package com.tencent.qphone.base.util.log.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.ac;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  public static String a = "LogEvent";
  public static final int b = 10;
  public static final int c = 11;
  public static final int d = 20;
  public static final int e = 30;
  public static final int f = 40;
  public static final int g = 41;
  public static final int h = 50;
  public static String i = "SetLogLevel";
  public static String j = "UploadLogFile";
  public static String k = "UploadLogFiled_Debug";
  private static String l = "/14.18.180.90:60000";
  
  public static String a(int paramInt)
  {
    if (paramInt != 10)
    {
      if (paramInt != 11)
      {
        if (paramInt != 20)
        {
          if (paramInt != 30)
          {
            if (paramInt != 40)
            {
              if (paramInt != 41) {
                return "";
              }
              return "日志文件过大";
            }
            return "日志上传完成";
          }
          return "日志压缩完成";
        }
        return "日志Check完成";
      }
      return "重复请求";
    }
    return "客户端收到Push请求";
  }
  
  public static void a(String paramString)
  {
    Object localObject1 = BaseApplication.getContext().getSharedPreferences(paramString, 0);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
    localObject1 = ((SharedPreferences)localObject1).getAll().entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
      Object localObject2 = (String)localEntry.getValue();
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        if (System.currentTimeMillis() - ((JSONObject)localObject2).getLong("time") > 3600000L)
        {
          a(paramString, (JSONObject)localObject2);
          localEditor.remove((String)localEntry.getKey());
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e(a, 1, "", localJSONException);
      }
    }
    localEditor.commit();
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, b.a parama)
  {
    parama.a = paramInt;
    b.a(parama);
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(paramString1, 0);
    Object localObject = localSharedPreferences.getString(paramString2, null);
    int m = paramInt;
    if (localObject == null)
    {
      QLog.d(a, 1, new Object[] { "changeEventStat find eventStr null, stat: ", Integer.valueOf(paramInt), ", reportId: ", paramString2 });
      if ((paramInt != 40) && (paramInt != 41)) {
        return;
      }
      m = 50;
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      ((JSONObject)localObject).put("stat", m);
      if ((m == 40) || (m == 41)) {
        ((JSONObject)localObject).put("fileSize", parama.d);
      }
      if (parama.f)
      {
        ((JSONObject)localObject).put("endNet", NetConnInfoCenter.getSystemNetState());
        a(paramString1, (JSONObject)localObject);
        localSharedPreferences.edit().remove(paramString2).commit();
      }
      else
      {
        localSharedPreferences.edit().putString(paramString2, ((JSONObject)localObject).toString()).commit();
      }
      paramString1 = a;
      parama = new StringBuilder();
      parama.append("changeEventStat ");
      parama.append(m);
      parama.append(" ");
      parama.append(paramString2);
      QLog.d(paramString1, 1, parama.toString());
      return;
    }
    catch (JSONException paramString1)
    {
      QLog.e(a, 1, "", paramString1);
    }
  }
  
  public static void a(String paramString1, String paramString2, b.a parama)
  {
    parama.a = 10;
    b.a(parama);
    a(paramString1);
    paramString1 = BaseApplication.getContext().getSharedPreferences(paramString1, 0);
    try
    {
      parama = new JSONObject();
      parama.put("time", System.currentTimeMillis());
      parama.put("stat", 10);
      parama.put("uin", MsfService.getCore().getAccountCenter().i());
      parama.put("startNet", NetConnInfoCenter.getSystemNetState());
      String str = MsfService.core.sender.b.m().toString();
      parama.put("isSSOConfIP", l.equals(str));
      paramString1.edit().putString(paramString2, parama.toString()).commit();
      paramString1 = a;
      parama = new StringBuilder();
      parama.append("new LogEvent ");
      parama.append(paramString2);
      QLog.d(paramString1, 1, parama.toString());
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(a, 1, "", paramString1);
    }
  }
  
  public static void a(String paramString, JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        if (!paramJSONObject.has("stat")) {
          break label318;
        }
        m = paramJSONObject.getInt("stat");
        Object localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportLogEvent, ");
        localStringBuilder.append(m);
        QLog.d((String)localObject, 1, localStringBuilder.toString());
        localObject = new HashMap();
        if (paramString.equals(j))
        {
          ((HashMap)localObject).put("pmStat", String.valueOf(m));
          if (paramJSONObject.has("uin")) {
            ((HashMap)localObject).put("pmUin", String.valueOf(paramJSONObject.getString("uin")));
          }
          if (paramJSONObject.has("time")) {
            ((HashMap)localObject).put("pmTime", String.valueOf(paramJSONObject.getLong("time")));
          }
          if (paramJSONObject.has("startNet")) {
            ((HashMap)localObject).put("pmStartNet", String.valueOf(paramJSONObject.getInt("startNet")));
          }
          if (paramJSONObject.has("endNet")) {
            ((HashMap)localObject).put("pmEndNet", String.valueOf(paramJSONObject.getInt("endNet")));
          }
          if (paramJSONObject.has("fileSize")) {
            ((HashMap)localObject).put("pmFileSize", String.valueOf(paramJSONObject.getLong("fileSize")));
          }
          if (paramJSONObject.has("isSSOConfIP")) {
            ((HashMap)localObject).put("pmSSOConfIP", String.valueOf(paramJSONObject.getBoolean("isSSOConfIP")));
          }
        }
        if (MsfService.getCore().getStatReporter() != null)
        {
          MsfService.getCore().getStatReporter().a(paramString, true, 0L, 0L, (Map)localObject, false, false);
          if ((QLog.isDebugVersion()) && (j.equals(paramString)))
          {
            MsfService.getCore().getStatReporter().a(k, true, 0L, 0L, (Map)localObject, false, false);
            return;
          }
        }
      }
      catch (JSONException paramString)
      {
        QLog.e(a, 1, "", paramString);
      }
      return;
      label318:
      int m = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.a.a
 * JD-Core Version:    0.7.0.1
 */