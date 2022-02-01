package com.tencent.mobileqq.webview.webso;

import android.os.Handler;
import android.text.TextUtils;
import bisl;
import bitb;
import bmtl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.http.HttpBaseUtil;
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
  ArrayList<bisl> jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean = false;
  
  public HybridWebReporter$ReportRunnable(ArrayList<bisl> paramArrayList)
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
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray;
    Object localObject1;
    try
    {
      localJSONArray = new JSONArray();
      localObject2 = ((ArrayList)localObject2).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localJSONArray.put(((bisl)((Iterator)localObject2).next()).a());
          continue;
          if (localObject1 == null) {
            break;
          }
        }
      }
    }
    catch (Exception localException)
    {
      QLog.w("HybridWebReporter", 1, localException.toString());
      localObject1 = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = localObject1.toString();
      if (QLog.isColorLevel()) {
        QLog.i("HybridWebReporter", 2, "json : " + this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Boolean = true;
      return;
      localObject1.put("data", localJSONArray);
    }
  }
  
  public void run()
  {
    Object localObject = QzoneConfig.getInstance().getConfig("QzUrlCache", "QzhwStatCgiURL", "https://h5.qzone.qq.com/report/native");
    String str2 = (String)localObject + "?uin=" + bitb.a();
    a();
    if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("HybridWebReporter", 2, "start report thread.");
    }
    label79:
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_Int <= 1)) {
      if (this.jdField_a_of_type_Int > 1)
      {
        new Handler(ThreadManager.getSubThreadLooper()).postDelayed(this, 300000L);
        this.jdField_b_of_type_Int += 1;
        this.jdField_a_of_type_Int = 0;
        return;
      }
    }
    for (;;)
    {
      int i;
      try
      {
        for (;;)
        {
          localObject = bmtl.a(BaseApplication.getContext(), str2, new StringEntity(this.jdField_a_of_type_JavaLangString, "UTF-8"));
          if (((HttpResponse)localObject).getStatusLine().getStatusCode() != 200) {
            break label410;
          }
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_b_of_type_Boolean = true;
          QLog.d("HybridWebReporter", 4, "report success.");
          try
          {
            Header[] arrayOfHeader = ((HttpResponse)localObject).getHeaders("Content-Encoding");
            int k = arrayOfHeader.length;
            i = 0;
            int j = 0;
            if (i < k)
            {
              if (!arrayOfHeader[i].getValue().equals("gzip")) {
                break label460;
              }
              j = 1;
              break label460;
            }
            localObject = ((HttpResponse)localObject).getEntity();
            if (j == 0) {
              break label400;
            }
            localObject = HttpBaseUtil.a(new GZIPInputStream(((HttpEntity)localObject).getContent()));
            if (QLog.isColorLevel()) {
              QLog.d("HybridWebReporter", 2, "HybridWeb report response result = " + (String)localObject);
            }
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              break;
            }
            localObject = new JSONObject((String)localObject);
            if (!(((JSONObject)localObject).opt("urlPrefixConfig") instanceof JSONArray)) {
              break label79;
            }
            HybridWebReporter.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).toString();
            LocalMultiProcConfig.putString("urlPrefixConfig", HybridWebReporter.jdField_a_of_type_JavaLangString);
          }
          catch (Throwable localThrowable1)
          {
            QLog.w("HybridWebReporter", 1, "save url prefix report err.", localThrowable1);
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        this.jdField_a_of_type_Int += 1;
        QLog.w("HybridWebReporter", 1, "exception when report", localThrowable2);
      }
      break label79;
      label400:
      String str1 = EntityUtils.toString(localThrowable2);
      continue;
      label410:
      QLog.e("HybridWebReporter", 1, "HttpStatus error when report : " + str1.getStatusLine().getStatusCode());
      this.jdField_a_of_type_Int += 1;
      break label79;
      break;
      label460:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.HybridWebReporter.ReportRunnable
 * JD-Core Version:    0.7.0.1
 */