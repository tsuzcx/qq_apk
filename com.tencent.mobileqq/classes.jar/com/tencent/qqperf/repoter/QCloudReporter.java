package com.tencent.qqperf.repoter;

import android.os.Build;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.UUID;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class QCloudReporter
  implements IReporter
{
  private static final String jdField_a_of_type_JavaLangString;
  private static final String b;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://sngapm.qq.com/entrance/");
    localStringBuilder.append(MagnifierSDK.b());
    localStringBuilder.append("/uploadFile/");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://sngapm.qq.com/entrance/");
    localStringBuilder.append(MagnifierSDK.b());
    localStringBuilder.append("/uploadJson/");
    b = localStringBuilder.toString();
  }
  
  public QCloudReporter(HandlerThread paramHandlerThread)
  {
    if (paramHandlerThread != null) {
      this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(paramHandlerThread.getLooper());
    }
  }
  
  public boolean a(ResultObject paramResultObject, IReporter.ReportResultCallback paramReportResultCallback)
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler == null) {
      return false;
    }
    JSONObject localJSONObject = paramResultObject.params;
    Object localObject3 = localJSONObject.optJSONObject("fileObj");
    Object localObject1 = localJSONObject.optJSONObject("clientinfo");
    try
    {
      boolean bool = localJSONObject.has("newplugin");
      int i;
      if (bool) {
        i = localJSONObject.getInt("newplugin");
      } else {
        i = ((JSONObject)localObject1).getInt("plugin");
      }
      Object localObject2 = ((JSONObject)localObject1).keys();
      String str1;
      while (((Iterator)localObject2).hasNext())
      {
        str1 = (String)((Iterator)localObject2).next();
        localJSONObject.put(str1, ((JSONObject)localObject1).getString(str1));
      }
      localJSONObject.put("version", MagnifierSDK.jdField_a_of_type_JavaLangString);
      localJSONObject.put("manu", Build.BRAND);
      localJSONObject.put("device", Build.MODEL);
      localObject2 = ((JSONObject)localObject1).getString("rdmuuid");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "0";
      }
      localJSONObject.put("rdmuuid", localObject1);
      localJSONObject.put("api_ver", 1);
      localJSONObject.put("plugin_ver", 1);
      localJSONObject.put("client_identify", UUID.randomUUID());
      localJSONObject.put("platform", "android");
      localJSONObject.put("plugin", i);
      localJSONObject.remove("clientinfo");
      localObject1 = new StringBuffer(1024);
      if (localObject3 != null)
      {
        localObject2 = ((JSONObject)localObject3).getString("fileObj1");
        localJSONObject.put("fileObj", localObject2);
        localObject3 = localJSONObject.keys();
        str1 = (String)((Iterator)localObject3).next();
        String str2 = localJSONObject.getString(str1);
        ((StringBuffer)localObject1).append(str1);
        ((StringBuffer)localObject1).append("=");
        ((StringBuffer)localObject1).append(URLEncoder.encode(str2, "UTF-8"));
        while (((Iterator)localObject3).hasNext())
        {
          str1 = (String)((Iterator)localObject3).next();
          str2 = localJSONObject.getString(str1);
          ((StringBuffer)localObject1).append("&");
          ((StringBuffer)localObject1).append(str1);
          ((StringBuffer)localObject1).append("=");
          ((StringBuffer)localObject1).append(URLEncoder.encode(str2, "UTF-8"));
        }
        ((StringBuffer)localObject1).append("&a=1");
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject3).append("?");
        ((StringBuilder)localObject3).append(((StringBuffer)localObject1).toString());
        localObject1 = ((StringBuilder)localObject3).toString();
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[qcloud_report] file url: ");
          ((StringBuilder)localObject3).append((String)localObject1);
          QLog.i("Magnifier_QCloudReporter", 2, ((StringBuilder)localObject3).toString());
        }
        paramResultObject = new QCloudFileUploadRunnable(new URL((String)localObject1), (String)localObject2, localJSONObject, paramReportResultCallback, paramResultObject.dbId, this.jdField_a_of_type_MqqOsMqqHandler);
        this.jdField_a_of_type_MqqOsMqqHandler.post(paramResultObject);
        return true;
      }
      ((StringBuffer)localObject1).append("p_id=");
      ((StringBuffer)localObject1).append(localJSONObject.getString("p_id"));
      ((StringBuffer)localObject1).append("&plugin=");
      ((StringBuffer)localObject1).append(i);
      ((StringBuffer)localObject1).append("&version=");
      ((StringBuffer)localObject1).append(URLEncoder.encode(MagnifierSDK.jdField_a_of_type_JavaLangString, "UTF-8"));
      ((StringBuffer)localObject1).append("&a=1");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(b);
      ((StringBuilder)localObject2).append("?");
      ((StringBuilder)localObject2).append(((StringBuffer)localObject1).toString());
      localObject1 = ((StringBuilder)localObject2).toString();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[qcloud_report] json url: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" jsonObj: ");
        ((StringBuilder)localObject2).append(localJSONObject.toString());
        QLog.i("Magnifier_QCloudReporter", 2, ((StringBuilder)localObject2).toString());
      }
      paramResultObject = new JsonUploadRunnable(new URL((String)localObject1), localJSONObject, paramReportResultCallback, paramResultObject.dbId, this.jdField_a_of_type_MqqOsMqqHandler);
      this.jdField_a_of_type_MqqOsMqqHandler.post(paramResultObject);
      return true;
    }
    catch (Throwable paramResultObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Magnifier_QCloudReporter", 2, "[qcloud_report] exception: ", paramResultObject);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.repoter.QCloudReporter
 * JD-Core Version:    0.7.0.1
 */