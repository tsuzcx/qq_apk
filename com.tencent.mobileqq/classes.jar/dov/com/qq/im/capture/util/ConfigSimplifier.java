package dov.com.qq.im.capture.util;

import android.text.TextUtils;
import anxb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
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
  
  public void a(String paramString1, String paramString2, String paramString3, ConfigSimplifier.ConfigDownloadCallback paramConfigDownloadCallback)
  {
    paramString1 = a(paramString1);
    if (paramString1 == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSimplifier_PTV", 2, "parseConfigZip md5=" + paramString1.jdField_c_of_type_JavaLangString + " url=" + paramString1.b + " name=" + paramString1.jdField_a_of_type_JavaLangString);
      }
      try
      {
        String str1 = paramString2 + File.separator;
        String str2 = paramString2 + File.separator + paramString1.jdField_a_of_type_JavaLangString;
        File localFile = new File(paramString2, paramString3);
        if (localFile.exists())
        {
          localFile.delete();
          if (QLog.isColorLevel()) {
            QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip file.delete()");
          }
        }
        Object localObject = new File(str2);
        if (((File)localObject).exists())
        {
          ((File)localObject).delete();
          if (QLog.isColorLevel()) {
            QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip filejson.delete()");
          }
        }
        localObject = new HttpNetReq();
        ((HttpNetReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new anxb(this, paramString2, paramString3, paramString1, str1, str2, paramConfigDownloadCallback);
        ((HttpNetReq)localObject).jdField_a_of_type_JavaLangString = paramString1.b;
        ((HttpNetReq)localObject).jdField_a_of_type_Int = 0;
        ((HttpNetReq)localObject).jdField_c_of_type_JavaLangString = localFile.getPath();
        ((HttpNetReq)localObject).jdField_c_of_type_Int = NetworkUtil.a(NetworkCenter.a().a());
        try
        {
          paramString2 = BaseApplicationImpl.getApplication().getRuntime();
          if (!QQAppInterface.class.isInstance(paramString2)) {
            continue;
          }
          ((QQAppInterface)paramString2).getNetEngine(0).a((NetReq)localObject);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("ConfigSimplifier", 2, "startDownloadFilterConfigZip, url: " + paramString1.b);
          return;
        }
        catch (Exception paramString1)
        {
          return;
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception paramString1) {}
    }
    paramString1.printStackTrace();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.util.ConfigSimplifier
 * JD-Core Version:    0.7.0.1
 */