package com.tencent.mobileqq.webview.utils;

import akrb;
import akrc;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebStateReporter
{
  public static HashMap a;
  public static int c;
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public long c;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_c_of_type_Int = 6;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("WebStateReporter_report", 2, "Current State = " + paramInt);
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void a(Context paramContext)
  {
    paramContext = new File(paramContext.getFilesDir(), ClubContentJsonTask.e.jdField_a_of_type_JavaLangString);
    if (!paramContext.exists()) {}
    do
    {
      do
      {
        return;
        paramContext = FileUtils.a(paramContext);
      } while (TextUtils.isEmpty(paramContext));
      try
      {
        paramContext = new JSONObject(paramContext);
        int i = paramContext.getInt("sample_rate");
        jdField_a_of_type_JavaUtilHashMap.put("sample_rate", Integer.valueOf(i));
        JSONArray localJSONArray = paramContext.getJSONArray("rules");
        int j = localJSONArray.length();
        i = 0;
        while (i < j)
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          jdField_a_of_type_JavaUtilHashMap.put(localJSONObject.getString("distUrl"), Integer.valueOf(localJSONObject.getInt("rate")));
          i += 1;
        }
        jdField_c_of_type_Int = paramContext.getInt("tail_number");
        return;
      }
      catch (JSONException paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.d("WebStateReporter", 2, "" + paramContext);
  }
  
  public void a(Context paramContext, long paramLong, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
    b(paramContext, paramLong, paramString, paramBoolean);
  }
  
  public void a(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    if (paramInt == 0) {}
    for (;;)
    {
      return;
      if (paramAppInterface == null) {}
      for (long l = 0L; !TextUtils.isEmpty(paramString); l = paramAppInterface.getLongAccountUin())
      {
        ThreadManager.post(new akrc(this, paramString, l, paramInt), 5, null, false);
        return;
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("WebStateReporter_report", 2, "Current Reader State = " + paramInt);
    }
  }
  
  public void b(Context paramContext, long paramLong, String paramString, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramLong <= 0L) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      this.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Boolean = false;
    }
    try
    {
      i = NetworkUtil.a(paramContext);
      switch (i)
      {
      default: 
        String str1 = "Unknown";
        ThreadManager.post(new akrb(this, paramBoolean, paramString, paramContext, paramLong, str1), 5, null, false);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 0;
        continue;
        String str2 = "2G";
        continue;
        str2 = "3G";
        continue;
        str2 = "4G";
        continue;
        str2 = "wifi";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.webview.utils.WebStateReporter
 * JD-Core Version:    0.7.0.1
 */