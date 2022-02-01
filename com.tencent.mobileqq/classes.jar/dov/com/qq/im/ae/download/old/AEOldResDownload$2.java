package dov.com.qq.im.ae.download.old;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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

final class AEOldResDownload$2
  implements INetEngineListener
{
  AEOldResDownload$2(AEOldShortVideoResManager.INet_ShortVideoResource paramINet_ShortVideoResource, AEOldResInfo paramAEOldResInfo) {}
  
  public void onResp(NetResp paramNetResp)
  {
    AEQLog.b("AEOldResDownload", "[onResp] start");
    NetReq localNetReq = paramNetResp.mReq;
    String str3 = (String)localNetReq.getUserData();
    AEQLog.b("AEOldResDownload", "[onResp] key:" + str3);
    if (str3 == null)
    {
      AEQLog.d("AEOldResDownload", "[onResp] key=null ");
      this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$INet_ShortVideoResource.a("", -1, "");
      return;
    }
    try
    {
      if (paramNetResp.mResult != 0) {
        break label774;
      }
      AEQLog.b("AEOldResDownload", "[onResp] NetResp.ResultOk");
      localObject2 = (AEOldShortVideoResManager.SVConfigItem)AEOldResDownload.a().get(str3);
      str4 = localNetReq.mOutPath;
      AEQLog.b("AEOldResDownload", "[onResp]filePath=" + str4 + ",resp.mResult=" + paramNetResp.mResult + ",mHttpCode=" + paramNetResp.mHttpCode + ",mErrCode=" + paramNetResp.mErrCode + ",mErrDesc=" + paramNetResp.mErrDesc);
      if ((!VideoEnvironment64BitUtils.checkIs64bit()) || (!((AEOldShortVideoResManager.SVConfigItem)localObject2).check64BitReady())) {
        break label497;
      }
      String str2 = ((AEOldShortVideoResManager.SVConfigItem)localObject2).arm64v8a_md5;
      i = AEOldResUtil.a(str3, str2, str4);
      if (i != 0) {
        break label733;
      }
      AEQLog.b("AEOldResDownload", "[onResp] verifyResource:success=");
      str1 = AEOldResUtil.a((String)localNetReq.getUserData());
      try
      {
        if (!FileUtils.c(str4, str1)) {
          break label704;
        }
        localObject2 = ((AEOldShortVideoResManager.SVConfigItem)localObject2).name.substring(this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldResInfo.jdField_b_of_type_JavaLangString.length());
        str2 = str2 + '_' + (String)localObject2;
        str4 = AEOldResUtil.a();
        str4 = str4 + str2 + File.separator;
        File localFile = new File(str4);
        bool = localFile.mkdirs();
        AEQLog.b("AEOldResDownload", "[onResp] unzipFile:[exists]mkOK=" + bool);
        if (localFile.exists()) {
          break label507;
        }
        AEQLog.d("AEOldResDownload", "[onResp] unzipFile.exists=false[error]");
        this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$INet_ShortVideoResource.a(str3, -118, str1);
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
    AEQLog.a("AEOldResDownload", "[SecurityException]", localSecurityException1);
    i = -1;
    for (;;)
    {
      label774:
      try
      {
        if (this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldResInfo.jdField_b_of_type_Boolean)
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
        AEQLog.a("AEOldResDownload", "[onResp] isPredownload callback ERROR", paramNetResp);
        label704:
        label733:
        continue;
      }
      this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$INet_ShortVideoResource.a(str3, i, str1);
      return;
      localObject1 = ((AEOldShortVideoResManager.SVConfigItem)localObject2).armv7a_md5;
      break;
      try
      {
        FileUtils.a(str1, str4, false);
        bool = AEOldResUtil.a((String)localObject2, str4);
        AEQLog.b("AEOldResDownload", "[onResp]  copyResFileToFinalDir copyOK=" + bool);
        if (!bool) {
          continue;
        }
        if (AEOldResUtil.a((String)localObject2)) {
          if (AEOldResUtil.a((String)localObject1, this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldResInfo))
          {
            AEQLog.d("AEOldResDownload", "[onResp] copyResFileToFinalDir.SUCCESS");
            i = 0;
          }
          else
          {
            AEQLog.d("AEOldResDownload", "[onResp] storeNewPendantUnzipPath.error");
            i = -118;
            FileUtils.e(localNetReq.mOutPath);
            FileUtils.e(str1);
          }
        }
      }
      catch (IOException localIOException)
      {
        AEQLog.a("AEOldResDownload", "[onResp] unzip.error:", localIOException);
        i = -118;
        FileUtils.e(localNetReq.mOutPath);
        FileUtils.e(str1);
      }
      AEQLog.d("AEOldResDownload", "[onResp] saveAEResUnzipFinalPath.error");
      i = -118;
      FileUtils.e(localNetReq.mOutPath);
      FileUtils.e(str1);
      break label866;
      AEQLog.d("AEOldResDownload", "[onResp] storeUnzipFinalPath.error");
      i = -118;
      FileUtils.e(localNetReq.mOutPath);
      FileUtils.e(str1);
      break label866;
      i = -3;
      AEQLog.d("AEOldResDownload", "[onResp] ShortVideoResourceStatus.RES_RENAME_VERIFY_ERROR");
      FileUtils.e(localNetReq.mOutPath);
      FileUtils.e(str1);
      break label866;
      AEQLog.d("AEOldResDownload", "[onResp] verifyResource.error:" + i);
      FileUtils.e(localNetReq.mOutPath);
      str1 = "";
      break label866;
      AEQLog.d("AEOldResDownload", "[onResp] download.error:" + paramNetResp.mResult);
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
      AEQLog.d("AEOldResDownload", "[onUpdateProgeress] key = null");
      return;
    }
    this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$INet_ShortVideoResource.a(paramNetReq, paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldResDownload.2
 * JD-Core Version:    0.7.0.1
 */