package com.tencent.tmdownloader.internal.downloadservice;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmdownloader.internal.storage.d;
import java.io.File;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class b
{
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 14	com/tencent/tmassistantbase/util/GlobalUtil:getInstance	()Lcom/tencent/tmassistantbase/util/GlobalUtil;
    //   6: invokevirtual 18	com/tencent/tmassistantbase/util/GlobalUtil:getContext	()Landroid/content/Context;
    //   9: astore_0
    //   10: aload_0
    //   11: ifnonnull +11 -> 22
    //   14: ldc 20
    //   16: astore_0
    //   17: ldc 2
    //   19: monitorexit
    //   20: aload_0
    //   21: areturn
    //   22: aload_0
    //   23: ldc 22
    //   25: invokevirtual 28	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
    //   28: ifeq +24 -> 52
    //   31: ldc 20
    //   33: astore_0
    //   34: goto -17 -> 17
    //   37: astore_0
    //   38: ldc 30
    //   40: ldc 32
    //   42: aload_0
    //   43: invokestatic 38	com/tencent/tmassistantbase/util/ab:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   46: ldc 20
    //   48: astore_0
    //   49: goto -32 -> 17
    //   52: aload_0
    //   53: ldc 40
    //   55: invokevirtual 44	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   58: checkcast 46	android/net/ConnectivityManager
    //   61: invokevirtual 50	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   64: astore_0
    //   65: aload_0
    //   66: ifnonnull +9 -> 75
    //   69: ldc 20
    //   71: astore_0
    //   72: goto -55 -> 17
    //   75: aload_0
    //   76: invokevirtual 56	android/net/NetworkInfo:getType	()I
    //   79: iconst_1
    //   80: if_icmpne +9 -> 89
    //   83: ldc 58
    //   85: astore_0
    //   86: goto -69 -> 17
    //   89: aload_0
    //   90: invokevirtual 61	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   93: astore_0
    //   94: aload_0
    //   95: ifnonnull +9 -> 104
    //   98: ldc 20
    //   100: astore_0
    //   101: goto -84 -> 17
    //   104: aload_0
    //   105: invokevirtual 66	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   108: astore_0
    //   109: ldc 30
    //   111: new 68	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   118: ldc 74
    //   120: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_0
    //   124: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 84	com/tencent/tmassistantbase/util/ab:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: goto -116 -> 17
    //   136: astore_0
    //   137: ldc 2
    //   139: monitorexit
    //   140: aload_0
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	25	0	localObject1	Object
    //   37	6	0	localException	Exception
    //   48	76	0	localObject2	Object
    //   136	5	0	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   22	31	37	java/lang/Exception
    //   3	10	136	finally
    //   22	31	136	finally
    //   38	46	136	finally
    //   52	65	136	finally
    //   75	83	136	finally
    //   89	94	136	finally
    //   104	133	136	finally
  }
  
  public static String a(String paramString)
  {
    paramString = paramString.replace("\r", "").replace("\n", "").trim();
    String str1 = new String(paramString);
    try
    {
      Uri localUri = Uri.parse(paramString);
      String str2 = localUri.getLastPathSegment();
      paramString = str1;
      if (str2 != null)
      {
        paramString = str1;
        if (str2.length() > 0) {
          paramString = str1.replace(str2, URLEncoder.encode(localUri.getLastPathSegment()).replace("+", "%20"));
        }
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      ab.b("DownloadHelper", "exception: ", paramString);
    }
    return str1;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str2 = GlobalUtil.calcMD5AsString(paramString1);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = Integer.toString(Math.abs(paramString1.hashCode()));
    }
    str2 = "";
    paramString1 = str2;
    if (!TextUtils.isEmpty(paramString2))
    {
      if (!paramString2.equals("application/vnd.android.package-archive")) {
        break label68;
      }
      paramString1 = ".apk";
    }
    for (;;)
    {
      return str1 + paramString1;
      label68:
      if (paramString2.equals("application/tm.android.apkdiff"))
      {
        paramString1 = ".diff";
      }
      else
      {
        paramString1 = str2;
        if (paramString2.equals("resource/tm.android.unknown")) {
          paramString1 = ".other";
        }
      }
    }
  }
  
  public static String b(String paramString)
  {
    ab.c("DownloadHelper", "genExistedAPKFileNameByUrl url = " + paramString);
    Object localObject2 = null;
    if (paramString.contains(".apk"))
    {
      localObject2 = paramString.trim().substring(paramString.lastIndexOf("/") + 1).trim();
      localObject1 = localObject2;
      if (((String)localObject2).contains("?")) {
        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf("?"));
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = d(c((String)localObject1));
        paramString = ((String)localObject1).replace(".apk", "") + "_" + GlobalUtil.calcMD5AsString(paramString) + ".apk";
        ab.c("DownloadHelper", "genExistedAPKFileNameByUrl url contains apk return fileName = " + paramString);
        return paramString;
      }
    }
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = a(paramString, "application/vnd.android.package-archive");
    }
    ab.c("DownloadHelper", "genExistedAPKFileNameByUrl fileName == null, return fileName = " + (String)localObject1);
    return localObject1;
  }
  
  public static boolean b()
  {
    Object localObject = GlobalUtil.getInstance().getContext();
    if (localObject == null)
    {
      ab.d("DownloadHelper", "GlobalUtil.getInstance().getContext() == null.");
      return false;
    }
    localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
    try
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject == null) {
        break label51;
      }
      bool = ((NetworkInfo)localObject).isAvailable();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        boolean bool = false;
      }
    }
    return bool;
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        boolean bool1 = new File(d.a(a(paramString1, paramString2))).exists();
        boolean bool2;
        if (bool1)
        {
          bool1 = true;
          bool2 = bool1;
          if (bool1) {}
        }
        boolean bool3;
        bool1 = false;
      }
      catch (Exception paramString1)
      {
        try
        {
          if (!"application/vnd.android.package-archive".equals(paramString2))
          {
            bool2 = bool1;
            if (!paramString1.contains(".apk")) {}
          }
          else
          {
            bool3 = new File(d.a(b(paramString1))).exists();
            bool2 = bool1;
            if (bool3) {
              bool2 = true;
            }
          }
          return bool2;
        }
        catch (Exception paramString1)
        {
          continue;
        }
        paramString1 = paramString1;
        bool1 = false;
        ab.b("DownloadHelper", "halleytest exception: ", paramString1);
        return bool1;
      }
      finally {}
    }
  }
  
  public static String c(String paramString)
  {
    if (paramString != null) {
      return URLDecoder.decode(paramString);
    }
    return null;
  }
  
  public static String d(String paramString)
  {
    return paramString.replace("?", "_").replace("*", "_").replace(" ", "_").replace("$", "_").replace("&", "_").replace("@", "_").replace("#", "_").replace("<", "_").replace(">", "_").replace("|", "_").replace(":", "_").replace("/", "_").replace("\\", "_").replace("\"", "_");
  }
  
  public static boolean e(String paramString)
  {
    try
    {
      new URI(a(paramString));
      return true;
    }
    catch (Throwable paramString)
    {
      ab.b("DownloadHelper", "exception: ", paramString);
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static boolean f(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      try
      {
        boolean bool = new File(d.a(paramString)).exists();
        if (!bool) {
          continue;
        }
        return true;
      }
      catch (Exception paramString)
      {
        paramString = paramString;
        ab.b("DownloadHelper", "exception: ", paramString);
        paramString.printStackTrace();
        return false;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadservice.b
 * JD-Core Version:    0.7.0.1
 */