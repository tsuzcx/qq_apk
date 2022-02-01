package com.tencent.mobileqq.webview.webso;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

class HybridWebReporter$ReportRunnable
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  String jdField_a_of_type_JavaLangString;
  ArrayList<HybridWebReporter.HybridWebReportInfo> jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean = false;
  
  public HybridWebReporter$ReportRunnable(ArrayList<HybridWebReporter.HybridWebReportInfo> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      QLog.e("HybridWebReporter", 1, "listToSend is empty.");
      return;
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
    Object localObject1 = new JSONObject();
    try
    {
      JSONArray localJSONArray = new JSONArray();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        localJSONArray.put(((HybridWebReporter.HybridWebReportInfo)((Iterator)localObject2).next()).a());
      }
      ((JSONObject)localObject1).put("data", localJSONArray);
    }
    catch (Exception localException)
    {
      localObject1 = null;
      QLog.w("HybridWebReporter", 1, localException.toString());
    }
    if (localObject1 != null) {
      this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).toString();
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("json : ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      QLog.i("HybridWebReporter", 2, ((StringBuilder)localObject1).toString());
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        paramString = VasUtil.a().websoExecuteHttpPost(BaseApplication.getContext(), paramString, new StringEntity(this.jdField_a_of_type_JavaLangString, "UTF-8"));
        Object localObject;
        if (paramString.getStatusLine().getStatusCode() == 200)
        {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_b_of_type_Boolean = true;
          QLog.d("HybridWebReporter", 4, "report success.");
          try
          {
            localObject = paramString.getHeaders("Content-Encoding");
            int k = localObject.length;
            i = 0;
            int j = 0;
            if (i < k)
            {
              if (!localObject[i].getValue().equals("gzip")) {
                break label320;
              }
              j = 1;
              break label320;
            }
            paramString = paramString.getEntity();
            if (j != 0) {
              paramString = WebSoUtils.a(new GZIPInputStream(paramString.getContent()));
            } else {
              paramString = EntityUtils.toString(paramString);
            }
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("HybridWeb report response result = ");
              ((StringBuilder)localObject).append(paramString);
              QLog.d("HybridWebReporter", 2, ((StringBuilder)localObject).toString());
            }
            if (TextUtils.isEmpty(paramString)) {
              return;
            }
            paramString = new JSONObject(paramString);
            if (!(paramString.opt("urlPrefixConfig") instanceof JSONArray)) {
              break label319;
            }
            HybridWebReporter.jdField_a_of_type_JavaLangString = paramString.toString();
            LocalMultiProcConfig.putString("urlPrefixConfig", HybridWebReporter.jdField_a_of_type_JavaLangString);
            return;
          }
          catch (Throwable paramString)
          {
            QLog.w("HybridWebReporter", 1, "save url prefix report err.", paramString);
            return;
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("HttpStatus error when report : ");
          ((StringBuilder)localObject).append(paramString.getStatusLine().getStatusCode());
          QLog.e("HybridWebReporter", 1, ((StringBuilder)localObject).toString());
          this.jdField_a_of_type_Int += 1;
          return;
        }
      }
      catch (Throwable paramString)
      {
        this.jdField_a_of_type_Int += 1;
        QLog.w("HybridWebReporter", 1, "exception when report", paramString);
      }
      label319:
      return;
      label320:
      i += 1;
    }
  }
  
  public void run()
  {
    String str = QzoneConfig.getInstance().getConfig("QzUrlCache", "QzhwStatCgiURL", "https://h5.qzone.qq.com/report/native");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("?uin=");
    localStringBuilder.append(WebSoUtils.a());
    str = localStringBuilder.toString();
    a();
    if (!TextUtils.isEmpty(str))
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("HybridWebReporter", 2, "start report thread.");
      }
      while ((!this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_Int <= 1))
      {
        if (this.jdField_a_of_type_Int > 1)
        {
          new Handler(ThreadManager.getSubThreadLooper()).postDelayed(this, 300000L);
          this.jdField_b_of_type_Int += 1;
          this.jdField_a_of_type_Int = 0;
          return;
        }
        a(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.HybridWebReporter.ReportRunnable
 * JD-Core Version:    0.7.0.1
 */