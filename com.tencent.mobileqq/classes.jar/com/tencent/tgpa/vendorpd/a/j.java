package com.tencent.tgpa.vendorpd.a;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.tencent.tgpa.vendorpd.GameCallback;
import com.tencent.tgpa.vendorpd.gradish.GradishWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import okhttp3.Call;
import okhttp3.FormBody.Builder;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;

public class j
{
  private static volatile j a;
  private String b = "default";
  private GameCallback c;
  
  public static j a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new j();
      }
      return a;
    }
    finally {}
  }
  
  /* Error */
  public static String a(String paramString, java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload 5
    //   8: astore_3
    //   9: aload_1
    //   10: invokevirtual 35	java/io/File:exists	()Z
    //   13: ifeq +107 -> 120
    //   16: aload 5
    //   18: astore_3
    //   19: aload_1
    //   20: invokevirtual 38	java/io/File:canRead	()Z
    //   23: ifeq +97 -> 120
    //   26: new 40	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   33: astore 5
    //   35: new 43	java/io/FileInputStream
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 46	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   43: astore_3
    //   44: sipush 1024
    //   47: newarray byte
    //   49: astore_1
    //   50: aload_3
    //   51: aload_1
    //   52: invokevirtual 50	java/io/FileInputStream:read	([B)I
    //   55: istore_2
    //   56: iload_2
    //   57: ifle +65 -> 122
    //   60: aload 5
    //   62: new 52	java/lang/String
    //   65: dup
    //   66: aload_1
    //   67: iconst_0
    //   68: iload_2
    //   69: ldc 54
    //   71: invokespecial 57	java/lang/String:<init>	([BIILjava/lang/String;)V
    //   74: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: goto -28 -> 50
    //   81: astore_1
    //   82: aload_3
    //   83: astore_1
    //   84: new 40	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   91: ldc 63
    //   93: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_0
    //   97: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 72	com/tencent/tgpa/vendorpd/a/m:b	(Ljava/lang/String;)V
    //   106: aload_1
    //   107: ifnull +7 -> 114
    //   110: aload_1
    //   111: invokevirtual 75	java/io/FileInputStream:close	()V
    //   114: aload 5
    //   116: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: astore_3
    //   120: aload_3
    //   121: areturn
    //   122: aload_3
    //   123: ifnull -9 -> 114
    //   126: aload_3
    //   127: invokevirtual 75	java/io/FileInputStream:close	()V
    //   130: goto -16 -> 114
    //   133: astore_1
    //   134: new 40	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   141: ldc 77
    //   143: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_0
    //   147: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 72	com/tencent/tgpa/vendorpd/a/m:b	(Ljava/lang/String;)V
    //   156: goto -42 -> 114
    //   159: astore_1
    //   160: new 40	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   167: ldc 77
    //   169: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_0
    //   173: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 72	com/tencent/tgpa/vendorpd/a/m:b	(Ljava/lang/String;)V
    //   182: goto -68 -> 114
    //   185: astore_1
    //   186: aconst_null
    //   187: astore_3
    //   188: aload_3
    //   189: ifnull +7 -> 196
    //   192: aload_3
    //   193: invokevirtual 75	java/io/FileInputStream:close	()V
    //   196: aload_1
    //   197: athrow
    //   198: astore_3
    //   199: new 40	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   206: ldc 77
    //   208: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_0
    //   212: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 72	com/tencent/tgpa/vendorpd/a/m:b	(Ljava/lang/String;)V
    //   221: goto -25 -> 196
    //   224: astore_1
    //   225: goto -37 -> 188
    //   228: astore 4
    //   230: aload_1
    //   231: astore_3
    //   232: aload 4
    //   234: astore_1
    //   235: goto -47 -> 188
    //   238: astore_1
    //   239: aload 4
    //   241: astore_1
    //   242: goto -158 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	paramString	String
    //   0	245	1	paramFile	java.io.File
    //   55	14	2	i	int
    //   8	185	3	localObject1	Object
    //   198	1	3	localException	Exception
    //   231	1	3	localFile	java.io.File
    //   4	1	4	localObject2	Object
    //   228	12	4	localObject3	Object
    //   1	114	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   44	50	81	java/lang/Exception
    //   50	56	81	java/lang/Exception
    //   60	78	81	java/lang/Exception
    //   126	130	133	java/lang/Exception
    //   110	114	159	java/lang/Exception
    //   35	44	185	finally
    //   192	196	198	java/lang/Exception
    //   44	50	224	finally
    //   50	56	224	finally
    //   60	78	224	finally
    //   84	106	228	finally
    //   35	44	238	java/lang/Exception
  }
  
  public int a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    paramContext = i.a(paramContext.getPackageName(), paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
    c.b = System.currentTimeMillis() - c.a;
    try
    {
      m.b("combine package response: " + String.valueOf(paramContext));
      if (paramContext == null)
      {
        m.b("combine package request failed, please check. ");
        return e.h.a();
      }
      paramContext = new JSONObject(paramContext);
      if (paramContext.has("ret"))
      {
        i = paramContext.getInt("ret");
        if (i == 0)
        {
          if (paramContext.has("data"))
          {
            paramContext = paramContext.getJSONObject("data");
            try
            {
              i = i.a(paramString3, paramString4, paramContext);
              return i;
            }
            catch (JSONException paramContext)
            {
              paramContext.printStackTrace();
              return e.i.a();
            }
            catch (Exception paramContext)
            {
              paramContext.printStackTrace();
              Log.e("TGPA", "combine apk failed because of unkown exception. ple call ericqtzhang.");
              return e.j.a();
            }
          }
          return e.i.a();
        }
        m.b("combine package request error, please check response code: " + i);
        return e.r.a();
      }
      m.b("combine package response parse exception, please check response.");
      int i = e.i.a();
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      m.c("combine package response parse to json exception.");
    }
    return e.i.a();
  }
  
  public void a(GameCallback paramGameCallback)
  {
    this.c = paramGameCallback;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(String paramString, Context paramContext)
  {
    paramContext = "https://version.tgpa.qq.com/pd_pkg_ver";
    if (m.a) {
      paramContext = "https://testversion.tgpa.qq.com/pd_pkg_ver";
    }
    Log.d("TGPA", "PreDownManager:getVersionInfoFromServer: url: " + String.valueOf(paramContext));
    Object localObject = String.valueOf(System.currentTimeMillis());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("app_data=").append(paramString).append("&");
    localStringBuilder.append("time_stamp=").append((String)localObject).append("&");
    localStringBuilder.append("api_key=").append("6d3cb8b9139aa731b912961282ff3b78").append("&");
    localStringBuilder.append("api_secret=").append("996f0a74d71f5803a269a64cf3a565c9");
    FormBody.Builder localBuilder = new FormBody.Builder();
    localBuilder.add("time_stamp", (String)localObject).add("api_key", "6d3cb8b9139aa731b912961282ff3b78").add("api_sign", String.valueOf(d.a(localStringBuilder.toString()))).add("model", Build.MODEL).add("manufacturer", Build.MANUFACTURER).add("channel", this.b).add("sdk_code", String.valueOf(115)).add("sdk_version", String.valueOf("1.1.5")).add("app_data", paramString).add("xid", GradishWrapper.getCommonUniqueID2WithoutFlag()).build();
    paramString = localBuilder.build();
    localObject = new Headers.Builder().add("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").add("X-Requested-With", "XMLHttpRequest").add("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.116").build();
    paramString = new Request.Builder().headers((Headers)localObject).url(paramContext).post(paramString).build();
    try
    {
      new OkHttpClient().newCall(paramString).enqueue(new j.1(this));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      m.b("report predownload data exception. ");
    }
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    if (m.a) {}
    for (String str = "https://testversion.tgpa.qq.com/pd_data_report";; str = "https://version.tgpa.qq.com/pd_data_report")
    {
      paramHashMap.put("xid", GradishWrapper.getCommonUniqueID2WithoutFlag());
      Object localObject = new FormBody.Builder();
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        ((FormBody.Builder)localObject).add((String)localEntry.getKey(), String.valueOf(localEntry.getValue()));
        m.b("report data: " + (String)localEntry.getKey() + "=" + (String)localEntry.getValue());
      }
      paramHashMap = new Headers.Builder().add("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").add("X-Requested-With", "XMLHttpRequest").add("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.116").build();
      localObject = ((FormBody.Builder)localObject).build();
      paramHashMap = new Request.Builder().headers(paramHashMap).url(str).post((RequestBody)localObject).build();
      try
      {
        new OkHttpClient().newCall(paramHashMap).enqueue(new j.2(this));
        return;
      }
      catch (Exception paramHashMap)
      {
        paramHashMap.printStackTrace();
        m.b("report predownload data exception. ");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.a.j
 * JD-Core Version:    0.7.0.1
 */