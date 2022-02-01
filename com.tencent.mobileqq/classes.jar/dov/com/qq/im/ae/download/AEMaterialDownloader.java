package dov.com.qq.im.ae.download;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import java.io.File;

public class AEMaterialDownloader
{
  private static final String a = AEMaterialDownloader.class.getSimpleName();
  
  public static void a(AppInterface paramAppInterface, AEMaterialMetaData paramAEMaterialMetaData, String paramString, AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener)
  {
    if (paramAEMaterialMetaData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "startDownloadMaterial is null");
      }
      return;
    }
    b(paramAppInterface, paramAEMaterialMetaData, paramString, paramMaterialDownloadListener);
  }
  
  private static void b(AppInterface paramAppInterface, AEMaterialMetaData paramAEMaterialMetaData, String paramString, AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener)
  {
    if ((paramAEMaterialMetaData == null) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      paramAEMaterialMetaData.a = System.currentTimeMillis();
      paramAEMaterialMetaData.jdField_f_of_type_Boolean = true;
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = new AEMaterialDownloader.DownloadListener(paramAEMaterialMetaData, paramString, paramMaterialDownloadListener);
      localHttpNetReq.mReqUrl = paramAEMaterialMetaData.d;
      localHttpNetReq.mHttpMethod = 0;
      if (paramAEMaterialMetaData.jdField_f_of_type_JavaLangString == null)
      {
        QLog.i(a, 1, "startDownloadMaterial fail, info.name is null, url:" + paramAEMaterialMetaData.d);
        return;
      }
      localHttpNetReq.mOutPath = new File(paramString, paramAEMaterialMetaData.jdField_f_of_type_JavaLangString).getPath();
      localHttpNetReq.mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
      localHttpNetReq.mExcuteTimeLimit = 60000L;
      try
      {
        ((IHttpEngineService)paramAppInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
        localHttpNetReq.mCallback.onUpdateProgeress(localHttpNetReq, 1L, 100L);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(a, 2, "startDownloadMaterial url: " + paramAEMaterialMetaData.d);
        return;
      }
      catch (Exception paramAppInterface)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            paramAppInterface.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.AEMaterialDownloader
 * JD-Core Version:    0.7.0.1
 */