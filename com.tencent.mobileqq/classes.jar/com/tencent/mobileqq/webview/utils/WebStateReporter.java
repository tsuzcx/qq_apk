package com.tencent.mobileqq.webview.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebStateReporter
{
  public static HashMap<String, Integer> a;
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
  
  public WebStateReporter()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Current State = ");
      localStringBuilder.append(paramInt);
      QLog.d("WebStateReporter_report", 2, localStringBuilder.toString());
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  void a(Context paramContext)
  {
    Object localObject = ClubContentJsonTask.e.jdField_a_of_type_JavaLangString;
    paramContext = new File(paramContext.getFilesDir(), (String)localObject);
    if (!paramContext.exists()) {
      return;
    }
    paramContext = FileUtils.readFileContent(paramContext);
    if (TextUtils.isEmpty(paramContext)) {
      return;
    }
    try
    {
      paramContext = new JSONObject(paramContext);
      int i = paramContext.getInt("sample_rate");
      jdField_a_of_type_JavaUtilHashMap.put("sample_rate", Integer.valueOf(i));
      localObject = paramContext.getJSONArray("rules");
      int j = ((JSONArray)localObject).length();
      i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        jdField_a_of_type_JavaUtilHashMap.put(localJSONObject.getString("distUrl"), Integer.valueOf(localJSONObject.getInt("rate")));
        i += 1;
      }
      jdField_c_of_type_Int = paramContext.getInt("tail_number");
      return;
    }
    catch (JSONException paramContext)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramContext);
        QLog.d("WebStateReporter", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(Context paramContext, long paramLong, String paramString, boolean paramBoolean)
  {
    if ((paramContext != null) && (paramLong > 0L))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
        this.jdField_a_of_type_Boolean = false;
      }
    }
    try
    {
      i = NetworkUtil.getSystemNetwork(paramContext);
    }
    catch (Exception localException)
    {
      int i;
      label56:
      String str;
      break label56;
    }
    i = 0;
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4) {
            str = "Unknown";
          }
        }
      }
    }
    for (;;)
    {
      break;
      str = "4G";
      continue;
      str = "3G";
      continue;
      str = "2G";
      continue;
      str = "wifi";
    }
    ThreadManager.post(new WebStateReporter.1(this, paramBoolean, paramString, paramContext, paramLong, str), 5, null, false);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    long l;
    if (paramAppRuntime == null) {
      l = 0L;
    } else {
      l = paramAppRuntime.getLongAccountUin();
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.post(new WebStateReporter.2(this, paramString, l, paramInt), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.utils.WebStateReporter
 * JD-Core Version:    0.7.0.1
 */