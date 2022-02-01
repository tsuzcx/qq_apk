package com.tencent.open.appstore.cookie;

import android.text.TextUtils;
import com.tencent.open.base.LogUtility;

public class CookieUtils
{
  /* Error */
  public static void a(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: istore_1
    //   8: iload_1
    //   9: ifeq +7 -> 16
    //   12: ldc 2
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: invokestatic 23	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   20: astore_0
    //   21: aload_0
    //   22: ifnull -10 -> 12
    //   25: aload_0
    //   26: invokevirtual 27	android/net/Uri:getHost	()Ljava/lang/String;
    //   29: ifnull -17 -> 12
    //   32: aload_0
    //   33: invokevirtual 27	android/net/Uri:getHost	()Ljava/lang/String;
    //   36: invokevirtual 32	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   39: invokestatic 35	com/tencent/open/appstore/cookie/CookieUtils:a	(Ljava/lang/String;)Z
    //   42: ifeq -30 -> 12
    //   45: new 37	com/tencent/open/appstore/cookie/CookieSyncManagerImpl
    //   48: dup
    //   49: invokestatic 42	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   52: invokevirtual 45	com/tencent/open/adapter/CommonDataAdapter:a	()Landroid/content/Context;
    //   55: invokespecial 48	com/tencent/open/appstore/cookie/CookieSyncManagerImpl:<init>	(Landroid/content/Context;)V
    //   58: astore_0
    //   59: new 50	com/tencent/open/appstore/cookie/CookieManagerImpl
    //   62: dup
    //   63: invokespecial 51	com/tencent/open/appstore/cookie/CookieManagerImpl:<init>	()V
    //   66: astore 4
    //   68: aload 4
    //   70: iconst_1
    //   71: invokevirtual 54	com/tencent/open/appstore/cookie/CookieManagerImpl:a	(Z)V
    //   74: invokestatic 42	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   77: invokevirtual 57	com/tencent/open/adapter/CommonDataAdapter:a	()J
    //   80: lstore_2
    //   81: invokestatic 62	com/tencent/open/business/base/MobileInfoUtil:c	()Ljava/lang/String;
    //   84: astore 5
    //   86: invokestatic 42	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   89: invokevirtual 64	com/tencent/open/adapter/CommonDataAdapter:a	()Ljava/lang/String;
    //   92: astore 6
    //   94: aload 4
    //   96: ldc 66
    //   98: new 68	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   105: ldc 71
    //   107: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: lload_2
    //   111: invokevirtual 78	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   114: ldc 80
    //   116: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc 82
    //   121: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc 84
    //   126: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokevirtual 90	com/tencent/open/appstore/cookie/CookieManagerImpl:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload 4
    //   137: ldc 66
    //   139: new 68	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   146: ldc 92
    //   148: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload 6
    //   153: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc 80
    //   158: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc 82
    //   163: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc 84
    //   168: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokevirtual 90	com/tencent/open/appstore/cookie/CookieManagerImpl:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: aload 4
    //   179: ldc 66
    //   181: new 68	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   188: ldc 94
    //   190: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload 5
    //   195: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc 80
    //   200: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: ldc 82
    //   205: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: ldc 84
    //   210: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokevirtual 90	com/tencent/open/appstore/cookie/CookieManagerImpl:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload_0
    //   220: invokevirtual 96	com/tencent/open/appstore/cookie/CookieSyncManagerImpl:a	()V
    //   223: goto -211 -> 12
    //   226: astore_0
    //   227: ldc 2
    //   229: monitorexit
    //   230: aload_0
    //   231: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	paramString	String
    //   7	2	1	bool	boolean
    //   80	31	2	l	long
    //   66	112	4	localCookieManagerImpl	CookieManagerImpl
    //   84	110	5	str1	String
    //   92	60	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   3	8	226	finally
    //   16	21	226	finally
    //   25	223	226	finally
  }
  
  public static boolean a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.endsWith(".qq.com")) || (paramString.endsWith(".myapp.com")) || (paramString.endsWith(".3gqq.com")) || (paramString.endsWith(".qzone.com"))))
    {
      LogUtility.c("CookieUtils", "host:" + paramString + " isAuthedDomain:true");
      return true;
    }
    LogUtility.c("CookieUtils", "host:" + paramString + " isAuthedDomain:false");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appstore.cookie.CookieUtils
 * JD-Core Version:    0.7.0.1
 */