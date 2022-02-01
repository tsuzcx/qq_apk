package com.tencent.tmdownloader.internal.downloadservice;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
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
    //   11: ifnonnull +9 -> 20
    //   14: ldc 2
    //   16: monitorexit
    //   17: ldc 20
    //   19: areturn
    //   20: aload_0
    //   21: ldc 22
    //   23: invokevirtual 28	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
    //   26: ifeq +9 -> 35
    //   29: ldc 2
    //   31: monitorexit
    //   32: ldc 20
    //   34: areturn
    //   35: aload_0
    //   36: ldc 30
    //   38: invokevirtual 34	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   41: checkcast 36	android/net/ConnectivityManager
    //   44: invokevirtual 40	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   47: astore_0
    //   48: aload_0
    //   49: ifnonnull +9 -> 58
    //   52: ldc 2
    //   54: monitorexit
    //   55: ldc 20
    //   57: areturn
    //   58: aload_0
    //   59: invokevirtual 46	android/net/NetworkInfo:getType	()I
    //   62: iconst_1
    //   63: if_icmpne +9 -> 72
    //   66: ldc 2
    //   68: monitorexit
    //   69: ldc 48
    //   71: areturn
    //   72: aload_0
    //   73: invokevirtual 51	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   76: astore_0
    //   77: aload_0
    //   78: ifnonnull +9 -> 87
    //   81: ldc 2
    //   83: monitorexit
    //   84: ldc 20
    //   86: areturn
    //   87: aload_0
    //   88: invokevirtual 56	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   91: astore_0
    //   92: new 58	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   99: astore_1
    //   100: aload_1
    //   101: ldc 64
    //   103: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_1
    //   108: aload_0
    //   109: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: ldc 70
    //   115: aload_1
    //   116: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 78	com/tencent/tmassistantbase/util/ab:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: ldc 2
    //   124: monitorexit
    //   125: aload_0
    //   126: areturn
    //   127: astore_0
    //   128: ldc 70
    //   130: ldc 80
    //   132: aload_0
    //   133: invokestatic 84	com/tencent/tmassistantbase/util/ab:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   136: ldc 2
    //   138: monitorexit
    //   139: ldc 20
    //   141: areturn
    //   142: astore_0
    //   143: ldc 2
    //   145: monitorexit
    //   146: aload_0
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	117	0	localObject1	Object
    //   127	6	0	localException	Exception
    //   142	5	0	localObject2	Object
    //   99	17	1	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   20	29	127	java/lang/Exception
    //   3	10	142	finally
    //   20	29	142	finally
    //   35	48	142	finally
    //   58	66	142	finally
    //   72	77	142	finally
    //   87	122	142	finally
    //   128	136	142	finally
  }
  
  public static String a(String paramString)
  {
    Object localObject = paramString.replace("\r", "").replace("\n", "").trim();
    paramString = new String((String)localObject);
    try
    {
      localObject = Uri.parse((String)localObject);
      String str = ((Uri)localObject).getLastPathSegment();
      if ((str != null) && (str.length() > 0))
      {
        localObject = paramString.replace(str, URLEncoder.encode(((Uri)localObject).getLastPathSegment()).replace("+", "%20"));
        return localObject;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      ab.b("DownloadHelper", "exception: ", localException);
    }
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str2 = GlobalUtil.calcMD5AsString(paramString1);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = Integer.toString(Math.abs(paramString1.hashCode()));
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      if (paramString2.equals("application/vnd.android.package-archive"))
      {
        paramString1 = ".apk";
        break label80;
      }
      if (paramString2.equals("application/tm.android.apkdiff"))
      {
        paramString1 = ".diff";
        break label80;
      }
      if (paramString2.equals("resource/tm.android.unknown"))
      {
        paramString1 = ".other";
        break label80;
      }
    }
    paramString1 = "";
    label80:
    paramString2 = new StringBuilder();
    paramString2.append(str1);
    paramString2.append(paramString1);
    return paramString2.toString();
  }
  
  public static String b(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("genExistedAPKFileNameByUrl url = ");
    ((StringBuilder)localObject1).append(paramString);
    ab.c("DownloadHelper", ((StringBuilder)localObject1).toString());
    Object localObject2;
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
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((String)localObject1).replace(".apk", ""));
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(GlobalUtil.calcMD5AsString(paramString));
        ((StringBuilder)localObject2).append(".apk");
        paramString = ((StringBuilder)localObject2).toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("genExistedAPKFileNameByUrl url contains apk return fileName = ");
        ((StringBuilder)localObject1).append(paramString);
        ab.c("DownloadHelper", ((StringBuilder)localObject1).toString());
        return paramString;
      }
    }
    else
    {
      localObject2 = null;
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = a(paramString, "application/vnd.android.package-archive");
    }
    paramString = new StringBuilder();
    paramString.append("genExistedAPKFileNameByUrl fileName == null, return fileName = ");
    paramString.append((String)localObject1);
    ab.c("DownloadHelper", paramString.toString());
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
      if (localObject != null)
      {
        boolean bool = ((NetworkInfo)localObject).isAvailable();
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  public static boolean b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 212	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: aload_1
    //   8: invokestatic 196	com/tencent/tmdownloader/internal/downloadservice/b:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11: invokestatic 216	com/tencent/tmdownloader/internal/storage/d:a	(Ljava/lang/String;)Ljava/lang/String;
    //   14: invokespecial 217	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: invokevirtual 220	java/io/File:exists	()Z
    //   20: istore_3
    //   21: iload_3
    //   22: istore 4
    //   24: iload_3
    //   25: ifne +75 -> 100
    //   28: iload_3
    //   29: istore_2
    //   30: ldc 150
    //   32: aload_1
    //   33: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   36: ifne +17 -> 53
    //   39: iload_3
    //   40: istore_2
    //   41: iload_3
    //   42: istore 4
    //   44: aload_0
    //   45: ldc 156
    //   47: invokevirtual 172	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   50: ifeq +50 -> 100
    //   53: iload_3
    //   54: istore_2
    //   55: new 212	java/io/File
    //   58: dup
    //   59: aload_0
    //   60: invokestatic 222	com/tencent/tmdownloader/internal/downloadservice/b:b	(Ljava/lang/String;)Ljava/lang/String;
    //   63: invokestatic 216	com/tencent/tmdownloader/internal/storage/d:a	(Ljava/lang/String;)Ljava/lang/String;
    //   66: invokespecial 217	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: invokevirtual 220	java/io/File:exists	()Z
    //   72: istore 5
    //   74: iload_3
    //   75: istore 4
    //   77: iload 5
    //   79: ifeq +21 -> 100
    //   82: iconst_1
    //   83: ireturn
    //   84: astore_0
    //   85: goto +18 -> 103
    //   88: astore_0
    //   89: ldc 70
    //   91: ldc 224
    //   93: aload_0
    //   94: invokestatic 84	com/tencent/tmassistantbase/util/ab:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   97: iload_2
    //   98: istore 4
    //   100: iload 4
    //   102: ireturn
    //   103: aload_0
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramString1	String
    //   0	105	1	paramString2	String
    //   1	97	2	bool1	boolean
    //   20	55	3	bool2	boolean
    //   22	79	4	bool3	boolean
    //   72	6	5	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   2	21	84	finally
    //   30	39	84	finally
    //   44	53	84	finally
    //   55	74	84	finally
    //   89	97	84	finally
    //   2	21	88	java/lang/Exception
    //   30	39	88	java/lang/Exception
    //   44	53	88	java/lang/Exception
    //   55	74	88	java/lang/Exception
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
  
  /* Error */
  public static boolean f(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: new 212	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokestatic 216	com/tencent/tmdownloader/internal/storage/d:a	(Ljava/lang/String;)Ljava/lang/String;
    //   14: invokespecial 217	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: invokevirtual 220	java/io/File:exists	()Z
    //   20: istore_1
    //   21: iload_1
    //   22: ireturn
    //   23: astore_0
    //   24: goto +18 -> 42
    //   27: astore_0
    //   28: ldc 70
    //   30: ldc 80
    //   32: aload_0
    //   33: invokestatic 84	com/tencent/tmassistantbase/util/ab:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   36: aload_0
    //   37: invokevirtual 124	java/lang/Exception:printStackTrace	()V
    //   40: iconst_0
    //   41: ireturn
    //   42: aload_0
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	paramString	String
    //   20	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	21	23	finally
    //   28	40	23	finally
    //   6	21	27	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadservice.b
 * JD-Core Version:    0.7.0.1
 */