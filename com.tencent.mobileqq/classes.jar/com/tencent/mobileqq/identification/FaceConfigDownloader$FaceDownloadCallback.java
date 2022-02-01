package com.tencent.mobileqq.identification;

import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.impl.HttpEngineServiceImpl;
import com.tencent.mobileqq.util.FaceSharedPreUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public final class FaceConfigDownloader$FaceDownloadCallback
  implements INetEngineListener
{
  private final ConfigItem jdField_a_of_type_ComTencentMobileqqIdentificationConfigItem;
  private final FaceConfigDownloader.IDownloadCallback jdField_a_of_type_ComTencentMobileqqIdentificationFaceConfigDownloader$IDownloadCallback;
  
  public FaceConfigDownloader$FaceDownloadCallback(ConfigItem paramConfigItem, FaceConfigDownloader.IDownloadCallback paramIDownloadCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConfigDownloader$IDownloadCallback = paramIDownloadCallback;
    this.jdField_a_of_type_ComTencentMobileqqIdentificationConfigItem = paramConfigItem;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 3)
    {
      QLog.d("FaceConfigDownloader", 2, "identification res download repeating ");
      return;
    }
    String str = FaceConfigManager.a(BaseApplication.getContext());
    Object localObject1;
    Object localObject2;
    if (paramNetResp.mResult == 0)
    {
      localObject1 = paramNetResp.mReq.mOutPath;
      localObject2 = FileUtils.calcMd5((String)localObject1);
      if ((localObject2 == null) || (!((String)localObject2).equalsIgnoreCase(FaceConfigManager.b(this.jdField_a_of_type_ComTencentMobileqqIdentificationConfigItem)))) {}
    }
    try
    {
      localObject2 = new File(str);
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      FileUtils.uncompressZip((String)localObject1, str, false);
    }
    catch (IOException localIOException1)
    {
      boolean bool;
      label113:
      label118:
      label120:
      StringBuilder localStringBuilder;
      break label118;
    }
    try
    {
      FaceConfigDownloader.a.destroy();
      FaceConfigDownloader.a = null;
      bool = true;
    }
    catch (IOException localIOException2)
    {
      break label113;
    }
    bool = true;
    break label120;
    bool = false;
    QLog.d("FaceConfigDownloader", 1, "downloadRes.onResp download succ but unzip is failed");
    break label223;
    QLog.d("FaceConfigDownloader", 1, "downloadRes.onResp download succ but md5 is mismatched ");
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadRes.onResp download succ but md5 is mismatched,fileSize = ");
      localStringBuilder.append(FileUtils.getFileSizes((String)localObject1));
      localStringBuilder.append(",md5 = ");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(",url = ");
      localStringBuilder.append(FaceConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqIdentificationConfigItem));
      QLog.d("FaceConfigDownloader", 2, localStringBuilder.toString());
    }
    bool = false;
    label223:
    FileUtils.deleteFile((String)localObject1);
    break label271;
    QLog.d("FaceConfigDownloader", 1, new Object[] { "downloadRes.onResp failed  isSuccess is false, code is : ", Integer.valueOf(paramNetResp.mErrCode), " msg : ", paramNetResp.mErrDesc });
    bool = false;
    label271:
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("downloadRes.onResp download path : ");
      ((StringBuilder)localObject1).append(str);
      QLog.d("FaceConfigDownloader", 2, ((StringBuilder)localObject1).toString());
    }
    QLog.d("FaceConfigDownloader", 1, new Object[] { "download face res success : ", Boolean.valueOf(bool) });
    if (bool)
    {
      FaceSharedPreUtils.a(str);
      FaceSharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqIdentificationConfigItem.a);
      FaceSharedPreUtils.b(FaceConfigManager.a());
    }
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConfigDownloader$IDownloadCallback.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConfigDownloader$IDownloadCallback.a(String.valueOf(paramNetResp.mErrCode));
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.identification.FaceConfigDownloader.FaceDownloadCallback
 * JD-Core Version:    0.7.0.1
 */