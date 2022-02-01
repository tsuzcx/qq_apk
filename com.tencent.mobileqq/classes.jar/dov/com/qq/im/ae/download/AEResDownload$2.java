package dov.com.qq.im.ae.download;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment64BitUtils;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import dov.com.qq.im.ae.util.AEQLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

final class AEResDownload$2
  implements INetEngineListener
{
  AEResDownload$2(ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource, AEResInfo paramAEResInfo) {}
  
  public void onResp(NetResp paramNetResp)
  {
    AEQLog.b("AEResDownload", "[onResp] start");
    NetReq localNetReq = paramNetResp.mReq;
    String str3 = (String)localNetReq.getUserData();
    AEQLog.b("AEResDownload", "[onResp] key:" + str3);
    if (str3 == null)
    {
      AEQLog.d("AEResDownload", "[onResp] key=null ");
      this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$INet_ShortVideoResource.onDownloadFinish("", -1, "");
      return;
    }
    try
    {
      if (paramNetResp.mResult != 0) {
        break label774;
      }
      AEQLog.b("AEResDownload", "[onResp] NetResp.ResultOk");
      localObject2 = (ShortVideoResourceManager.SVConfigItem)AEResDownload.a().get(str3);
      str4 = localNetReq.mOutPath;
      AEQLog.b("AEResDownload", "[onResp]filePath=" + str4 + ",resp.mResult=" + paramNetResp.mResult + ",mHttpCode=" + paramNetResp.mHttpCode + ",mErrCode=" + paramNetResp.mErrCode + ",mErrDesc=" + paramNetResp.mErrDesc);
      if ((!VideoEnvironment64BitUtils.checkIs64bit()) || (!((ShortVideoResourceManager.SVConfigItem)localObject2).check64BitReady())) {
        break label497;
      }
      String str2 = ((ShortVideoResourceManager.SVConfigItem)localObject2).arm64v8a_md5;
      i = AEResUtil.a(str3, str2, str4);
      if (i != 0) {
        break label733;
      }
      AEQLog.b("AEResDownload", "[onResp] verifyResource:success=");
      str1 = AEResUtil.a((String)localNetReq.getUserData());
      try
      {
        if (!FileUtils.c(str4, str1)) {
          break label704;
        }
        localObject2 = ((ShortVideoResourceManager.SVConfigItem)localObject2).name.substring(this.jdField_a_of_type_DovComQqImAeDownloadAEResInfo.jdField_b_of_type_JavaLangString.length());
        str2 = str2 + '_' + (String)localObject2;
        str4 = AEResUtil.a();
        str4 = str4 + str2 + File.separator;
        File localFile = new File(str4);
        bool = localFile.mkdirs();
        AEQLog.b("AEResDownload", "[onResp] unzipFile:[exists]mkOK=" + bool);
        if (localFile.exists()) {
          break label507;
        }
        AEQLog.d("AEResDownload", "[onResp] unzipFile.exists=false[error]");
        this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$INet_ShortVideoResource.onDownloadFinish(str3, -118, str1);
        return;
      }
      catch (SecurityException localSecurityException1) {}
    }
    catch (SecurityException localSecurityException2)
    {
      for (;;)
      {
        Object localObject2;
        String str4;
        int i;
        boolean bool;
        String str1 = "";
      }
    }
    AEQLog.a("AEResDownload", "[SecurityException]", localSecurityException1);
    i = -1;
    for (;;)
    {
      label774:
      try
      {
        if (this.jdField_a_of_type_DovComQqImAeDownloadAEResInfo.jdField_b_of_type_Boolean)
        {
          localObject1 = (PreDownloadController)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
          if ((localObject1 != null) && (((PreDownloadController)localObject1).isEnable()))
          {
            if (i != 0) {
              continue;
            }
            ((PreDownloadController)localObject1).preDownloadSuccess((String)paramNetResp.mRespProperties.get("param_url"), paramNetResp.mTotalFileLen);
          }
        }
      }
      catch (Throwable paramNetResp)
      {
        Object localObject1;
        label497:
        label507:
        AEQLog.a("AEResDownload", "[onResp] isPredownload callback ERROR", paramNetResp);
        label704:
        label733:
        continue;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$INet_ShortVideoResource.onDownloadFinish(str3, i, str1);
      return;
      localObject1 = ((ShortVideoResourceManager.SVConfigItem)localObject2).armv7a_md5;
      break;
      try
      {
        FileUtils.a(str1, str4, false);
        bool = AEResUtil.a((String)localObject2, str4);
        AEQLog.b("AEResDownload", "[onResp]  copyResFileToFinalDir copyOK=" + bool);
        if (!bool) {
          continue;
        }
        if (AEResUtil.a((String)localObject2)) {
          if (AEResUtil.a((String)localObject1, this.jdField_a_of_type_DovComQqImAeDownloadAEResInfo))
          {
            AEQLog.d("AEResDownload", "[onResp] copyResFileToFinalDir.SUCCESS");
            i = 0;
          }
          else
          {
            AEQLog.d("AEResDownload", "[onResp] storeNewPendantUnzipPath.error");
            i = -118;
            FileUtils.e(localNetReq.mOutPath);
            FileUtils.e(str1);
          }
        }
      }
      catch (IOException localIOException)
      {
        AEQLog.a("AEResDownload", "[onResp] unzip.error:", localIOException);
        i = -118;
        FileUtils.e(localNetReq.mOutPath);
        FileUtils.e(str1);
      }
      AEQLog.d("AEResDownload", "[onResp] saveAEResUnzipFinalPath.error");
      i = -118;
      FileUtils.e(localNetReq.mOutPath);
      FileUtils.e(str1);
      break label866;
      AEQLog.d("AEResDownload", "[onResp] storeUnzipFinalPath.error");
      i = -118;
      FileUtils.e(localNetReq.mOutPath);
      FileUtils.e(str1);
      break label866;
      i = -3;
      AEQLog.d("AEResDownload", "[onResp] ShortVideoResourceStatus.RES_RENAME_VERIFY_ERROR");
      FileUtils.e(localNetReq.mOutPath);
      FileUtils.e(str1);
      break label866;
      AEQLog.d("AEResDownload", "[onResp] verifyResource.error:" + i);
      FileUtils.e(localNetReq.mOutPath);
      str1 = "";
      break label866;
      AEQLog.d("AEResDownload", "[onResp] download.error:" + paramNetResp.mResult);
      FileUtils.e(localNetReq.mOutPath);
      i = -117;
      str1 = "";
      break label866;
      localIOException.preDownloadSuccess((String)paramNetResp.mRespProperties.get("param_url"), -1L);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = (String)paramNetReq.getUserData();
    if (paramNetReq == null)
    {
      AEQLog.d("AEResDownload", "[onUpdateProgeress] key = null");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$INet_ShortVideoResource.onUpdateProgress(paramNetReq, paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.AEResDownload.2
 * JD-Core Version:    0.7.0.1
 */