package com.tencent.open.business.base;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import org.json.JSONObject;

public class OpenConfig
{
  protected static HashMap<String, OpenConfig> a;
  protected static String b;
  protected Context c = null;
  protected String d = null;
  protected JSONObject e = new JSONObject();
  protected long f = 0L;
  protected int g = 0;
  private boolean h;
  
  protected OpenConfig(Context paramContext, String paramString)
  {
    this.c = paramContext;
    this.d = paramString;
    a();
    b();
  }
  
  public static OpenConfig a(Context paramContext, String paramString)
  {
    if (a == null) {
      a = new HashMap();
    }
    if (paramString != null) {
      b = paramString;
    }
    String str = paramString;
    if (paramString == null)
    {
      str = b;
      if (str == null) {
        str = "0";
      }
    }
    OpenConfig localOpenConfig = (OpenConfig)a.get(str);
    paramString = localOpenConfig;
    if (localOpenConfig == null)
    {
      paramString = new OpenConfig(paramContext, str);
      a.put(str, paramString);
    }
    return paramString;
  }
  
  public static int b(String paramString)
  {
    PackageManager localPackageManager = CommonDataAdapter.a().b().getPackageManager();
    try
    {
      paramString = localPackageManager.getPackageInfo(paramString, 1);
      if (paramString != null)
      {
        int i = paramString.versionCode;
        return i;
      }
    }
    catch (Exception paramString)
    {
      LogUtility.b("OpenConfig", "getApkVersonCode>>>", paramString);
    }
    return 0;
  }
  
  /* Error */
  protected String a(String paramString)
  {
    // Byte code:
    //   0: ldc 111
    //   2: astore_3
    //   3: aload_0
    //   4: getfield 31	com/tencent/open/business/base/OpenConfig:d	Ljava/lang/String;
    //   7: ifnull +201 -> 208
    //   10: new 113	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   17: astore_2
    //   18: aload_2
    //   19: aload_1
    //   20: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_2
    //   25: ldc 120
    //   27: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_2
    //   32: aload_0
    //   33: getfield 31	com/tencent/open/business/base/OpenConfig:d	Ljava/lang/String;
    //   36: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_2
    //   41: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: astore_2
    //   45: goto +3 -> 48
    //   48: aload_0
    //   49: getfield 29	com/tencent/open/business/base/OpenConfig:c	Landroid/content/Context;
    //   52: aload_2
    //   53: invokevirtual 128	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   56: astore_2
    //   57: aload_2
    //   58: astore_1
    //   59: goto +15 -> 74
    //   62: aload_0
    //   63: getfield 29	com/tencent/open/business/base/OpenConfig:c	Landroid/content/Context;
    //   66: invokevirtual 132	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   69: aload_1
    //   70: invokevirtual 138	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   73: astore_1
    //   74: new 140	java/io/BufferedReader
    //   77: dup
    //   78: new 142	java/io/InputStreamReader
    //   81: dup
    //   82: aload_1
    //   83: invokespecial 145	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   86: invokespecial 148	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   89: astore 5
    //   91: new 150	java/lang/StringBuffer
    //   94: dup
    //   95: invokespecial 151	java/lang/StringBuffer:<init>	()V
    //   98: astore_2
    //   99: aload 5
    //   101: invokevirtual 154	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   104: astore 4
    //   106: aload 4
    //   108: ifnull +13 -> 121
    //   111: aload_2
    //   112: aload 4
    //   114: invokevirtual 157	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   117: pop
    //   118: goto -19 -> 99
    //   121: aload_2
    //   122: invokevirtual 158	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   125: astore 4
    //   127: aload 4
    //   129: astore_2
    //   130: aload_1
    //   131: invokevirtual 163	java/io/InputStream:close	()V
    //   134: aload 4
    //   136: astore_2
    //   137: aload 5
    //   139: invokevirtual 164	java/io/BufferedReader:close	()V
    //   142: aload 4
    //   144: areturn
    //   145: astore_1
    //   146: aload_1
    //   147: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   150: aload_2
    //   151: areturn
    //   152: astore_2
    //   153: goto +24 -> 177
    //   156: astore_2
    //   157: aload_2
    //   158: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   161: aload_3
    //   162: astore_2
    //   163: aload_1
    //   164: invokevirtual 163	java/io/InputStream:close	()V
    //   167: aload_3
    //   168: astore_2
    //   169: aload 5
    //   171: invokevirtual 164	java/io/BufferedReader:close	()V
    //   174: ldc 111
    //   176: areturn
    //   177: aload_1
    //   178: invokevirtual 163	java/io/InputStream:close	()V
    //   181: aload 5
    //   183: invokevirtual 164	java/io/BufferedReader:close	()V
    //   186: goto +8 -> 194
    //   189: astore_1
    //   190: aload_1
    //   191: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   194: aload_2
    //   195: athrow
    //   196: astore_1
    //   197: aload_1
    //   198: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   201: ldc 111
    //   203: areturn
    //   204: astore_2
    //   205: goto -143 -> 62
    //   208: aload_1
    //   209: astore_2
    //   210: goto -162 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	OpenConfig
    //   0	213	1	paramString	String
    //   17	134	2	localObject1	Object
    //   152	1	2	localObject2	Object
    //   156	2	2	localIOException	IOException
    //   162	33	2	str1	String
    //   204	1	2	localFileNotFoundException	java.io.FileNotFoundException
    //   209	1	2	str2	String
    //   2	166	3	str3	String
    //   104	39	4	str4	String
    //   89	93	5	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   130	134	145	java/io/IOException
    //   137	142	145	java/io/IOException
    //   163	167	145	java/io/IOException
    //   169	174	145	java/io/IOException
    //   99	106	152	finally
    //   111	118	152	finally
    //   121	127	152	finally
    //   157	161	152	finally
    //   99	106	156	java/io/IOException
    //   111	118	156	java/io/IOException
    //   121	127	156	java/io/IOException
    //   177	186	189	java/io/IOException
    //   62	74	196	java/io/IOException
    //   3	45	204	java/io/FileNotFoundException
    //   48	57	204	java/io/FileNotFoundException
  }
  
  protected void a()
  {
    if (!this.h) {
      ThreadManager.executeOnSubThread(new OpenConfig.1(this));
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    Object localObject1 = paramString1;
    try
    {
      if (this.d != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(".");
        ((StringBuilder)localObject1).append(this.d);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject1 = this.c.openFileOutput((String)localObject1, 0);
      try
      {
        paramString1 = new OutputStreamWriter((OutputStream)localObject1);
        try
        {
          paramString1.write(paramString2);
          paramString1.flush();
        }
        catch (IOException paramString2) {}
        localObject2 = localObject1;
      }
      catch (IOException paramString2)
      {
        paramString1 = null;
      }
      localObject1 = paramString2;
      paramString2 = localObject2;
    }
    catch (IOException localIOException)
    {
      paramString1 = null;
      paramString2 = localObject2;
    }
    localIOException.printStackTrace();
    String str = paramString2;
    if (str != null) {
      try
      {
        str.close();
      }
      catch (IOException paramString2)
      {
        paramString2.printStackTrace();
      }
    }
    if (paramString1 != null) {
      try
      {
        paramString1.close();
        return;
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    this.e = paramJSONObject;
    a("com.tencent.open.config.json", paramJSONObject.toString());
    this.f = SystemClock.elapsedRealtime();
  }
  
  protected void b()
  {
    if (this.g != 0) {
      return;
    }
    this.g = 1;
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.d);
    localBundle.putString("appid_for_getting_config", this.d);
    localBundle.putString("status_os", Build.VERSION.RELEASE);
    localBundle.putString("status_machine", Build.MODEL);
    localBundle.putString("status_brand", Build.BRAND);
    localBundle.putString("status_version", Build.VERSION.SDK);
    localBundle.putString("sdkv", "1.5");
    localBundle.putString("sdkp", "a");
    localBundle.putString("blacklist_logic_version", String.valueOf(1));
    localBundle.putString("yyb_version", String.valueOf(b("com.tencent.android.qqdownloader")));
    localBundle.putString("qq_version", String.valueOf(GlobalUtil.getAppVersionCode(CommonDataAdapter.a().b())));
    ThreadManager.executeOnNetWorkThread(new OpenConfig.2(this, localBundle));
  }
  
  public String c(String paramString)
  {
    c();
    JSONObject localJSONObject = this.e;
    if (localJSONObject == null) {
      return "";
    }
    return localJSONObject.optString(paramString);
  }
  
  protected void c()
  {
    JSONObject localJSONObject = this.e;
    int i;
    if (localJSONObject != null) {
      i = localJSONObject.optInt("Common_frequency");
    } else {
      i = 0;
    }
    long l = Math.max(i, 1) * 3600 * 1000;
    if (SystemClock.elapsedRealtime() - this.f >= l) {
      b();
    }
  }
  
  public int d(String paramString)
  {
    c();
    JSONObject localJSONObject = this.e;
    if (localJSONObject == null) {
      return 0;
    }
    return localJSONObject.optInt(paramString);
  }
  
  public long e(String paramString)
  {
    c();
    JSONObject localJSONObject = this.e;
    if (localJSONObject == null) {
      return 0L;
    }
    return localJSONObject.optLong(paramString);
  }
  
  public boolean f(String paramString)
  {
    c();
    JSONObject localJSONObject = this.e;
    if (localJSONObject == null) {
      return false;
    }
    paramString = localJSONObject.opt(paramString);
    if (paramString == null) {
      return false;
    }
    if ((paramString instanceof Integer)) {
      return paramString.equals(Integer.valueOf(0)) ^ true;
    }
    if ((paramString instanceof Boolean)) {
      return ((Boolean)paramString).booleanValue();
    }
    return false;
  }
  
  public boolean g(String paramString)
  {
    c();
    JSONObject localJSONObject = this.e;
    if (localJSONObject == null) {
      return true;
    }
    paramString = localJSONObject.opt(paramString);
    if (paramString == null) {
      return true;
    }
    if ((paramString instanceof Integer)) {
      return paramString.equals(Integer.valueOf(0)) ^ true;
    }
    if ((paramString instanceof Boolean)) {
      return ((Boolean)paramString).booleanValue();
    }
    return false;
  }
  
  public boolean h(String paramString)
  {
    c();
    JSONObject localJSONObject = this.e;
    if (localJSONObject == null) {
      return false;
    }
    paramString = localJSONObject.opt(paramString);
    if (paramString == null) {
      return false;
    }
    if ((paramString instanceof Integer)) {
      return paramString.equals(Integer.valueOf(0)) ^ true;
    }
    if ((paramString instanceof Boolean)) {
      return ((Boolean)paramString).booleanValue();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.business.base.OpenConfig
 * JD-Core Version:    0.7.0.1
 */