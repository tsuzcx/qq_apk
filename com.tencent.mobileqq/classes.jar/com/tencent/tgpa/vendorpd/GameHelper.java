package com.tencent.tgpa.vendorpd;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import com.tencent.tgpa.vendorpd.a.a;
import com.tencent.tgpa.vendorpd.a.b;
import com.tencent.tgpa.vendorpd.a.c;
import com.tencent.tgpa.vendorpd.a.d;
import com.tencent.tgpa.vendorpd.a.f;
import com.tencent.tgpa.vendorpd.a.g;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public class GameHelper
{
  private static int a(HashMap<String, String> paramHashMap)
  {
    String str = Environment.getExternalStorageDirectory().getPath();
    str = str + File.separator + f.a;
    if (!b.b(str)) {
      g.c("SAVE_PD: TGPA dir don't exsit, and create failed. path: " + str);
    }
    if (b.e(str))
    {
      g.a("SAVE_PD: TGPA dir exsit, start to save download info to file.");
      if (c.a(paramHashMap)) {
        return 0;
      }
      return -2;
    }
    g.b("SAVE_PD: pdinfo file don't exsit, cann't create save dir, just report.");
    return -1;
  }
  
  public static void enableDebug(boolean paramBoolean)
  {
    g.a(paramBoolean);
  }
  
  public static void getGameVersionUpdateInfo(Context paramContext, String paramString, ArrayList<String> paramArrayList, GameCallback paramGameCallback)
  {
    d.a().a(paramString);
    getGameVersionUpdateInfo(paramContext, paramArrayList, paramGameCallback);
  }
  
  public static void getGameVersionUpdateInfo(Context paramContext, ArrayList<String> paramArrayList, GameCallback paramGameCallback)
  {
    g.a("Start to get game version info. ");
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
          localObject1 = d.a(str2, (File)localObject1);
          if (localObject1 != null)
          {
            localObject1 = a.b(Base64.decode((String)localObject1, 2));
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
          g.c("get game version update info exception. packagename: " + str2);
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
    d.a().a(paramGameCallback);
    d.a().a(paramArrayList, paramContext);
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
      paramHashMap.put("save_result", String.valueOf(a(paramHashMap)));
      d.a().a(paramHashMap);
      return;
    }
    catch (Exception paramHashMap)
    {
      paramHashMap.printStackTrace();
      g.c("GameHelper:reportPreDownladInfo: exception.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.GameHelper
 * JD-Core Version:    0.7.0.1
 */