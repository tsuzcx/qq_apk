package dov.com.qq.im.capture.util;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.CaptureContext;
import java.io.File;
import org.json.JSONObject;

public class ConfigSimplifier
{
  public ConfigSimplifier.ZipConfig a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip TextUtils.isEmpty(config) return");
      }
      return null;
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramString);
        if (!((JSONObject)localObject).has("pendantMD5")) {
          break label142;
        }
        paramString = ((JSONObject)localObject).getString("pendantMD5");
        if (!((JSONObject)localObject).has("pendantUrl")) {
          break label136;
        }
        str = ((JSONObject)localObject).getString("pendantUrl");
        if (!((JSONObject)localObject).has("pendantName")) {
          break label130;
        }
        localObject = ((JSONObject)localObject).getString("pendantName");
        if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(str)))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.w("ConfigSimplifier_PTV", 2, "zipMd5 or zipUrl empty return!");
          return null;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      paramString = new ConfigSimplifier.ZipConfig((String)localObject, str, paramString);
      return paramString;
      label130:
      Object localObject = "";
      continue;
      label136:
      String str = "";
      continue;
      label142:
      paramString = "";
    }
  }
  
  public ConfigSimplifier.ZipConfig a(String paramString1, String paramString2, String paramString3, ConfigSimplifier.ConfigDownloadCallback paramConfigDownloadCallback)
  {
    ConfigSimplifier.ZipConfig localZipConfig = a(paramString1);
    if (localZipConfig == null) {
      paramString1 = null;
    }
    do
    {
      for (;;)
      {
        return paramString1;
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSimplifier_PTV", 2, "parseConfigZip md5=" + localZipConfig.c + " url=" + localZipConfig.b + " name=" + localZipConfig.a);
        }
        try
        {
          paramString1 = paramString2 + File.separator;
          String str = paramString2 + File.separator + localZipConfig.a;
          File localFile = new File(paramString2, paramString3);
          if (localFile.exists())
          {
            localFile.delete();
            if (QLog.isColorLevel()) {
              QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip file.delete()");
            }
          }
          localObject = new File(str);
          if (((File)localObject).exists())
          {
            ((File)localObject).delete();
            if (QLog.isColorLevel()) {
              QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip filejson.delete()");
            }
          }
          localObject = new HttpNetReq();
          ((HttpNetReq)localObject).mCallback = new ConfigSimplifier.1(this, paramString2, paramString3, localZipConfig, paramString1, str, paramConfigDownloadCallback);
          ((HttpNetReq)localObject).mReqUrl = localZipConfig.b;
          ((HttpNetReq)localObject).mHttpMethod = 0;
          ((HttpNetReq)localObject).mOutPath = localFile.getPath();
          ((HttpNetReq)localObject).mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
        }
        catch (Exception paramString2)
        {
          try
          {
            Object localObject;
            paramString1 = BaseApplicationImpl.getApplication().getRuntime();
            if (QQAppInterface.class.isInstance(paramString1))
            {
              ((IHttpEngineService)((QQAppInterface)paramString1).getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject);
              paramString1 = localZipConfig;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("ConfigSimplifier", 2, "startDownloadFilterConfigZip, url: " + localZipConfig.b);
              return localZipConfig;
            }
            paramString1 = localZipConfig;
            if (CaptureContext.a() == null) {
              continue;
            }
            ((IHttpEngineService)CaptureContext.a().getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject);
            return localZipConfig;
          }
          catch (Exception paramString1) {}
          paramString2 = paramString2;
          paramString1 = localZipConfig;
        }
      }
    } while (!QLog.isColorLevel());
    paramString2.printStackTrace();
    return localZipConfig;
    return localZipConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.util.ConfigSimplifier
 * JD-Core Version:    0.7.0.1
 */