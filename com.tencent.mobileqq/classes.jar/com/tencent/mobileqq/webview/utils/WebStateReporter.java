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
  public static HashMap<String, Integer> a = new HashMap();
  public static int i = 6;
  public int b = 0;
  public long c;
  public int d;
  public boolean e = false;
  public long f;
  public String g;
  public long h;
  
  private String b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return "Unknown";
          }
          return "4G";
        }
        return "3G";
      }
      return "2G";
    }
    return "wifi";
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
    this.h = System.currentTimeMillis();
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
    this.f = paramLong;
  }
  
  void a(Context paramContext)
  {
    Object localObject = ClubContentJsonTask.e.a;
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
      int j = paramContext.getInt("sample_rate");
      a.put("sample_rate", Integer.valueOf(j));
      localObject = paramContext.getJSONArray("rules");
      int k = ((JSONArray)localObject).length();
      j = 0;
      while (j < k)
      {
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
        a.put(localJSONObject.getString("distUrl"), Integer.valueOf(localJSONObject.getInt("rate")));
        j += 1;
      }
      i = paramContext.getInt("tail_number");
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
      if (this.e)
      {
        this.d = this.b;
        this.h = this.c;
        this.e = false;
      }
    }
    try
    {
      j = NetworkUtil.getSystemNetwork(paramContext);
    }
    catch (Exception localException)
    {
      int j;
      label56:
      break label56;
    }
    j = 0;
    ThreadManager.post(new WebStateReporter.1(this, paramBoolean, paramString, paramContext, paramLong, b(j)), 5, null, false);
  }
  
  public void a(String paramString)
  {
    this.g = paramString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.utils.WebStateReporter
 * JD-Core Version:    0.7.0.1
 */