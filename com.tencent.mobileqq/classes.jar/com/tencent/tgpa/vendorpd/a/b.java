package com.tencent.tgpa.vendorpd.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.tencent.tgpa.vendorpd.CombinationInfo;
import com.tencent.tgpa.vendorpd.GameCallback;
import com.tencent.tgpa.vendorpd.GamePredownloader.RetMsg;
import com.tencent.tgpa.vendorpd.b.c;
import com.tencent.tgpa.vendorpd.b.d;
import com.tencent.tgpa.vendorpd.b.e;
import com.tencent.tgpa.vendorpd.b.f;
import com.tencent.tgpa.vendorpd.gradish.GradishWrapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private GameCallback g;
  
  public b(b.b paramb)
  {
    this.a = b.b.a(paramb);
    this.b = b.b.b(paramb);
    this.c = b.b.c(paramb);
    this.d = b.b.d(paramb);
    this.e = b.b.e(paramb);
    this.f = b.b.f(paramb);
    this.g = b.b.g(paramb);
  }
  
  private String a(String paramString)
  {
    if (paramString == null)
    {
      f.b("onResponse: request predownload info failed!");
      paramString = GamePredownloader.RetMsg.NetworkException;
    }
    for (;;)
    {
      return paramString.getJsonData();
      try
      {
        f.a("onResponse: request version response data: %s", new Object[] { paramString });
        JSONObject localJSONObject1 = new JSONObject(paramString);
        if ((localJSONObject1.has("ret")) && (localJSONObject1.has("data")))
        {
          if (localJSONObject1.getInt("ret") == 0)
          {
            paramString = localJSONObject1.getJSONObject("data");
            Iterator localIterator = paramString.keys();
            while (localIterator.hasNext())
            {
              String str1 = (String)localIterator.next();
              try
              {
                JSONObject localJSONObject2 = paramString.getJSONObject(str1);
                String str2 = localJSONObject2.getString("path");
                StringBuilder localStringBuilder2 = new StringBuilder();
                localStringBuilder2.append(Environment.getExternalStorageDirectory());
                localStringBuilder2.append(File.separator);
                localStringBuilder2.append(str2);
                localStringBuilder2.append(File.separator);
                localJSONObject2.put("path", localStringBuilder2.toString());
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
                StringBuilder localStringBuilder1 = new StringBuilder();
                localStringBuilder1.append("onResponse: check game predownload info exception. game: ");
                localStringBuilder1.append(str1);
                f.d(localStringBuilder1.toString());
              }
            }
            return localJSONObject1.toString();
          }
          f.b("OnResponse: request failed, ret is not 0! please check response: %s", new Object[] { paramString });
          return localJSONObject1.toString();
        }
        f.b("OnResponse: request failed, json format is not correct! please check the data: %s", new Object[] { paramString });
        paramString = GamePredownloader.RetMsg.ResponseDataJsonFormatException.getJsonData();
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        f.d("OnResponse: network response content parse to json exception.");
        paramString = GamePredownloader.RetMsg.ResponseDataIsNotJson;
      }
    }
  }
  
  private HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
    localHashMap.put("X-Requested-With", "XMLHttpRequest");
    localHashMap.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.116");
    return localHashMap;
  }
  
  private String b(Context paramContext, ArrayList<String> paramArrayList)
  {
    JSONObject localJSONObject1 = new JSONObject();
    int i = 0;
    while (i < paramArrayList.size())
    {
      String str = (String)paramArrayList.get(i);
      try
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("vc", String.valueOf(com.tencent.tgpa.vendorpd.b.b.b(paramContext, str))).put("vn", com.tencent.tgpa.vendorpd.b.b.a(paramContext, str));
        localJSONObject1.put(str, localJSONObject2);
      }
      catch (JSONException localJSONException)
      {
        label79:
        break label79;
      }
      f.a("get game local version info exception! pkg: %s", new Object[] { str });
      i += 1;
    }
    return localJSONObject1.toString();
  }
  
  public b a(GameCallback paramGameCallback)
  {
    this.g = paramGameCallback;
    return this;
  }
  
  public String a(String paramString, CombinationInfo paramCombinationInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(b.d.c.a());
    String str1 = ((StringBuilder)localObject).toString();
    HashMap localHashMap1 = a();
    localHashMap1.put("app_name", paramString);
    String str3 = String.valueOf(System.currentTimeMillis());
    String str2 = d.c(paramCombinationInfo.predownFilePath);
    if (paramCombinationInfo.cdnMD5 == null) {
      localObject = "";
    } else {
      localObject = paramCombinationInfo.cdnMD5;
    }
    localObject = String.format("time_stamp=%s&api_key=%s&api_secret=%s&cdn_url=%s&cdn_md5=%s&game_package=%s&predownload_file=%s", new Object[] { str3, this.d, this.e, paramCombinationInfo.cdnUrl, localObject, paramCombinationInfo.gamePackageName, str2 });
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("time_stamp", str3);
    localHashMap2.put("api_key", this.d);
    localHashMap2.put("api_sign", String.valueOf(c.a((String)localObject)));
    localHashMap2.put("model", Build.MODEL);
    localHashMap2.put("manufacturer", Build.MANUFACTURER);
    localHashMap2.put("channel", this.b);
    localHashMap2.put("sdk_code", String.valueOf(17));
    localHashMap2.put("sdk_version", "1.1.7");
    localHashMap2.put("cdn_url", paramCombinationInfo.cdnUrl);
    if (paramCombinationInfo.cdnMD5 == null) {
      localObject = "";
    } else {
      localObject = paramCombinationInfo.cdnMD5;
    }
    localHashMap2.put("cdn_md5", localObject);
    localHashMap2.put("game_package", paramCombinationInfo.gamePackageName);
    localHashMap2.put("predownload_file", str2);
    localHashMap2.put("predownfile_md5", paramCombinationInfo.predownFileMD5);
    localHashMap2.put("app_name", paramString);
    localHashMap2.put("xid", GradishWrapper.getXID());
    paramCombinationInfo = this.f;
    paramString = paramCombinationInfo;
    if (paramCombinationInfo == null) {
      paramString = "";
    }
    localHashMap2.put("oaid", paramString);
    try
    {
      f.a("request combine config, data: %s , header: %s", new Object[] { localHashMap2.toString(), localHashMap1.toString() });
      paramString = e.a(str1, localHashMap2, localHashMap1);
      return paramString;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      f.d("request predownload combine config exception.");
    }
    return null;
  }
  
  public void a(Context paramContext, ArrayList<String> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("/");
    localStringBuilder.append(b.d.a.a());
    new b.a(localStringBuilder.toString(), new b.1(this, paramContext, paramArrayList)).execute(new String[0]);
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("/");
    localStringBuilder.append(b.d.b.a());
    new b.a(localStringBuilder.toString(), paramHashMap, new b.2(this)).execute(new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.a.b
 * JD-Core Version:    0.7.0.1
 */