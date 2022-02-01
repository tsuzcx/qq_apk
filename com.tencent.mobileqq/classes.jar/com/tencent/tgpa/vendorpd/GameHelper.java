package com.tencent.tgpa.vendorpd;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import com.tencent.tgpa.vendorpd.a.a;
import com.tencent.tgpa.vendorpd.a.c;
import com.tencent.tgpa.vendorpd.a.d;
import com.tencent.tgpa.vendorpd.a.e;
import com.tencent.tgpa.vendorpd.a.f;
import com.tencent.tgpa.vendorpd.a.g;
import com.tencent.tgpa.vendorpd.a.j;
import com.tencent.tgpa.vendorpd.a.l;
import com.tencent.tgpa.vendorpd.a.m;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public class GameHelper
{
  private static int a(HashMap<String, String> paramHashMap)
  {
    String str = Environment.getExternalStorageDirectory().getPath();
    str = str + File.separator + l.a;
    if (!f.b(str)) {
      m.c("SAVE_PD: TGPA dir don't exsit, and create failed. path: " + str);
    }
    if (f.e(str))
    {
      m.a("SAVE_PD: TGPA dir exsit, start to save download info to file.");
      if (g.a(paramHashMap)) {
        return 0;
      }
      return -2;
    }
    m.b("SAVE_PD: pdinfo file don't exsit, cann't create save dir, just report.");
    return -1;
  }
  
  public static int combinePackage(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    a.a(paramContext);
    c.a = System.currentTimeMillis();
    int i;
    label32:
    long l1;
    long l2;
    HashMap localHashMap;
    if (paramContext == null)
    {
      i = e.b.a();
      if (i != 0) {
        break label425;
      }
      m.b("combine apk success.");
      l1 = System.currentTimeMillis();
      l2 = c.a;
      localHashMap = new HashMap();
      localHashMap.put("event_name", "CombineApk");
      localHashMap.put("game_name", String.valueOf(paramString6));
      localHashMap.put("mobile", Build.MODEL);
      localHashMap.put("manufacturer", Build.MANUFACTURER);
      localHashMap.put("channel", String.valueOf(paramString1));
      if (i != 0) {
        break label451;
      }
    }
    label425:
    label451:
    for (paramContext = "0";; paramContext = "1")
    {
      for (;;)
      {
        localHashMap.put("status", paramContext);
        localHashMap.put("begin_time", String.valueOf(c.a));
        localHashMap.put("end_time", String.valueOf(l1));
        localHashMap.put("run_time", String.valueOf(l1 - l2));
        localHashMap.put("md5_time", String.valueOf(c.c));
        localHashMap.put("request_time", String.valueOf(c.b));
        localHashMap.put("load_time", String.valueOf(c.a));
        localHashMap.put("report_time", String.valueOf(System.currentTimeMillis() / 1000L));
        localHashMap.put("predown_file", String.valueOf(paramString4));
        localHashMap.put("file_name", String.valueOf(paramString2));
        localHashMap.put("file_md5", String.valueOf(paramString3));
        localHashMap.put("predownfile_md5", paramString5);
        localHashMap.put("error_code", String.valueOf(i));
        j.a().a(localHashMap);
        return i;
        if (paramString1 == null)
        {
          i = e.c.a();
          break;
        }
        if (paramString2 == null)
        {
          i = e.d.a();
          break;
        }
        if (paramString6 == null)
        {
          i = e.e.a();
          break;
        }
        if (paramString4 == null)
        {
          i = e.f.a();
          break;
        }
        if (!f.d(paramString4))
        {
          i = e.g.a();
          break;
        }
        try
        {
          i = j.a().a(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          Log.e("TGPA", "combine package exception.");
          i = e.j.a();
        }
      }
      break;
      m.b("combine apk failed. error code: " + i);
      break label32;
    }
  }
  
  public static void enableDebug(boolean paramBoolean)
  {
    m.a(paramBoolean);
  }
  
  public static void getGameVersionUpdateInfo(Context paramContext, String paramString, ArrayList<String> paramArrayList, GameCallback paramGameCallback)
  {
    j.a().a(paramString);
    getGameVersionUpdateInfo(paramContext, paramArrayList, paramGameCallback);
  }
  
  public static void getGameVersionUpdateInfo(Context paramContext, ArrayList<String> paramArrayList, GameCallback paramGameCallback)
  {
    m.a("Start to get game version info. ");
    a.a(paramContext);
    String str1 = Environment.getExternalStorageDirectory().getPath();
    StringBuilder localStringBuilder = new StringBuilder("{");
    int i = 0;
    if (i < paramArrayList.size())
    {
      String str2 = (String)paramArrayList.get(i);
      Object localObject1 = new File(str1 + File.separator + "Android/data/" + str2 + File.separator + "files" + File.separator + ".vmppd");
      if (((File)localObject1).exists()) {}
      for (;;)
      {
        try
        {
          localObject1 = j.a(str2, (File)localObject1);
          if (localObject1 != null)
          {
            localObject1 = d.c(Base64.decode((String)localObject1, 2));
            if (localObject1 != null)
            {
              Object localObject2 = new JSONObject(new String((byte[])localObject1, 0, localObject1.length, "utf-8"));
              if (str2.equals(((JSONObject)localObject2).getString("pn")))
              {
                localObject1 = ((JSONObject)localObject2).getString("mv");
                localObject2 = ((JSONObject)localObject2).getString("sv");
                if ((localObject1 != null) && (localObject2 != null))
                {
                  localStringBuilder.append("\"").append(str2).append("\":{");
                  localStringBuilder.append("\"mv\":\"").append((String)localObject1).append("\",");
                  localStringBuilder.append("\"sv\":\"").append((String)localObject2).append("\"},");
                }
              }
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          m.c("get game version update info exception. packagename: " + str2);
          continue;
        }
        i += 1;
        break;
        localStringBuilder.append("\"").append(str2).append("\":{");
        localStringBuilder.append("\"mv\":\"").append(0).append("\",");
        localStringBuilder.append("\"sv\":\"").append(0).append("\"},");
      }
    }
    str1 = localStringBuilder.toString();
    paramArrayList = str1;
    if (str1.charAt(str1.length() - 1) == ',') {
      paramArrayList = str1.substring(0, str1.length() - 1);
    }
    paramArrayList = paramArrayList + "}";
    j.a().a(paramGameCallback);
    j.a().a(paramArrayList, paramContext);
  }
  
  public static void reportPreDownladInfo(HashMap<String, String> paramHashMap)
  {
    try
    {
      paramHashMap.put("load_time", String.valueOf(System.currentTimeMillis() / 1000L));
      if (!paramHashMap.containsKey("mobile")) {
        paramHashMap.put("mobile", Build.MODEL);
      }
      if (!paramHashMap.containsKey("manufacturer")) {
        paramHashMap.put("manufacturer", Build.MANUFACTURER);
      }
      int i = a(paramHashMap);
      paramHashMap.put("event_name", "PreDownloadFile");
      paramHashMap.put("save_result", String.valueOf(i));
      j.a().a(paramHashMap);
      return;
    }
    catch (Exception paramHashMap)
    {
      paramHashMap.printStackTrace();
      m.c("GameHelper:reportPreDownladInfo: exception.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.GameHelper
 * JD-Core Version:    0.7.0.1
 */