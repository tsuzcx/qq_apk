package com.vivo.push.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.vivo.push.cache.d;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public final class s
{
  private static Boolean a;
  private static String b;
  
  public static com.vivo.push.model.b a(Context paramContext)
  {
    Context localContext = ContextDelegate.getContext(paramContext).getApplicationContext();
    paramContext = d(localContext);
    if (paramContext != null)
    {
      o.d("PushPackageUtils", "get system push info :".concat(String.valueOf(paramContext)));
      return paramContext;
    }
    List localList = e(localContext);
    Object localObject2 = f(localContext, localContext.getPackageName());
    Object localObject1;
    if (localList.size() <= 0)
    {
      localObject1 = paramContext;
      if (localObject2 != null)
      {
        localObject1 = paramContext;
        if (((com.vivo.push.model.b)localObject2).d()) {
          localObject1 = localObject2;
        }
      }
      o.a("PushPackageUtils", "findAllPushPackages error: find no package!");
    }
    else
    {
      paramContext = y.b(localContext);
      Object localObject3 = null;
      paramContext = paramContext.a("com.vivo.push.cur_pkg", null);
      if ((!TextUtils.isEmpty(paramContext)) && (a(localContext, paramContext, "com.vivo.pushservice.action.METHOD")))
      {
        paramContext = f(localContext, paramContext);
        if ((paramContext != null) && (paramContext.d())) {}
      }
      else
      {
        paramContext = null;
      }
      if ((localObject2 != null) && (((com.vivo.push.model.b)localObject2).d())) {
        localObject1 = localObject2;
      } else {
        localObject1 = null;
      }
      if (paramContext != null) {
        localObject2 = paramContext;
      } else {
        localObject2 = null;
      }
      paramContext = (Context)localObject2;
      if (localObject1 != null)
      {
        if (localObject2 != null) {
          if (((com.vivo.push.model.b)localObject1).c())
          {
            paramContext = (Context)localObject2;
            if (!((com.vivo.push.model.b)localObject2).c()) {
              break label263;
            }
            paramContext = (Context)localObject2;
            if (((com.vivo.push.model.b)localObject1).b() <= ((com.vivo.push.model.b)localObject2).b()) {
              break label263;
            }
          }
          else if (!((com.vivo.push.model.b)localObject2).c())
          {
            paramContext = (Context)localObject2;
            if (((com.vivo.push.model.b)localObject1).b() <= ((com.vivo.push.model.b)localObject2).b()) {
              break label263;
            }
          }
        }
        paramContext = (Context)localObject1;
      }
      label263:
      HashMap localHashMap = new HashMap();
      if (paramContext != null)
      {
        localObject1 = paramContext;
        localObject2 = localObject3;
        if (paramContext.c())
        {
          localObject1 = null;
          localObject2 = paramContext;
        }
      }
      else
      {
        localObject1 = null;
        localObject2 = localObject3;
      }
      int j = localList.size();
      int i = 0;
      for (paramContext = (Context)localObject2; i < j; paramContext = (Context)localObject3)
      {
        String str = (String)localList.get(i);
        localObject2 = localObject1;
        localObject3 = paramContext;
        if (!TextUtils.isEmpty(str))
        {
          com.vivo.push.model.b localb = f(localContext, str);
          localObject2 = localObject1;
          localObject3 = paramContext;
          if (localb != null)
          {
            localHashMap.put(str, localb);
            localObject2 = localObject1;
            localObject3 = paramContext;
            if (localb.d()) {
              if (localb.c())
              {
                if (paramContext != null)
                {
                  localObject2 = localObject1;
                  localObject3 = paramContext;
                  if (localb.b() <= paramContext.b()) {}
                }
                else
                {
                  localObject3 = localb;
                  localObject2 = localObject1;
                }
              }
              else if (localObject1 != null)
              {
                localObject2 = localObject1;
                localObject3 = paramContext;
                if (localb.b() <= ((com.vivo.push.model.b)localObject1).b()) {}
              }
              else
              {
                localObject2 = localb;
                localObject3 = paramContext;
              }
            }
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
      if (localObject1 == null)
      {
        o.d("PushPackageUtils", "findSuitablePushPackage, all push app in balck list.");
        localObject1 = paramContext;
      }
    }
    if (localObject1 != null)
    {
      if (((com.vivo.push.model.b)localObject1).c())
      {
        paramContext = new StringBuilder("查找最优包为:");
        paramContext.append(((com.vivo.push.model.b)localObject1).a());
        paramContext.append("(");
        paramContext.append(((com.vivo.push.model.b)localObject1).b());
        paramContext.append(", Black)");
        o.a(localContext, paramContext.toString());
        paramContext = new StringBuilder("finSuitablePushPackage");
        paramContext.append(((com.vivo.push.model.b)localObject1).a());
        paramContext.append("(");
        paramContext.append(((com.vivo.push.model.b)localObject1).b());
        paramContext.append(", Black)");
        o.d("PushPackageUtils", paramContext.toString());
        return localObject1;
      }
      paramContext = new StringBuilder("查找最优包为:");
      paramContext.append(((com.vivo.push.model.b)localObject1).a());
      paramContext.append("(");
      paramContext.append(((com.vivo.push.model.b)localObject1).b());
      paramContext.append(")");
      o.a(localContext, paramContext.toString());
      paramContext = new StringBuilder("finSuitablePushPackage");
      paramContext.append(((com.vivo.push.model.b)localObject1).a());
      paramContext.append("(");
      paramContext.append(((com.vivo.push.model.b)localObject1).b());
      paramContext.append(")");
      o.d("PushPackageUtils", paramContext.toString());
      return localObject1;
    }
    o.b(localContext, "查找最优包为空!");
    o.d("PushPackageUtils", "finSuitablePushPackage is null");
    return localObject1;
  }
  
  private static boolean a(Context paramContext, long paramLong)
  {
    paramContext = com.vivo.push.cache.b.a().a(paramContext);
    if (paramContext != null) {
      return paramContext.isInBlackList(paramLong);
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramContext == null) {
        return false;
      }
      Object localObject = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
      ((Intent)localObject).setPackage(paramString);
      paramContext = paramContext.getPackageManager();
      localObject = paramContext.queryIntentServices((Intent)localObject, 576);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        int j = ((List)localObject).size();
        int i = 0;
        boolean bool2;
        for (boolean bool1 = false; i < j; bool1 = bool2)
        {
          ResolveInfo localResolveInfo = (ResolveInfo)((List)localObject).get(i);
          bool2 = bool1;
          if (localResolveInfo != null)
          {
            bool2 = bool1;
            if (localResolveInfo.serviceInfo != null)
            {
              String str = localResolveInfo.serviceInfo.name;
              boolean bool3 = localResolveInfo.serviceInfo.exported;
              bool2 = bool1;
              if ("com.vivo.push.sdk.service.PushService".equals(str))
              {
                bool2 = bool1;
                if (bool3)
                {
                  bool3 = localResolveInfo.serviceInfo.enabled;
                  int k = paramContext.getComponentEnabledSetting(new ComponentName(paramString, "com.vivo.push.sdk.service.PushService"));
                  bool2 = true;
                  bool1 = bool2;
                  if (k != 1) {
                    if ((k == 0) && (bool3)) {
                      bool1 = bool2;
                    } else {
                      bool1 = false;
                    }
                  }
                  bool2 = bool1;
                }
              }
            }
          }
          i += 1;
        }
        return bool1;
      }
      o.a("PushPackageUtils", "isEnablePush error: can not find push service.");
    }
    return false;
  }
  
  private static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    paramString2 = new Intent(paramString2);
    paramString2.setPackage(paramString1);
    try
    {
      paramContext = paramContext.getPackageManager().queryBroadcastReceivers(paramString2, 576);
    }
    catch (Exception paramContext)
    {
      label30:
      break label30;
    }
    paramContext = null;
    return (paramContext != null) && (paramContext.size() > 0);
  }
  
  public static int b(Context paramContext, String paramString)
  {
    int i;
    if (a(paramContext, paramString, "com.vivo.pushservice.action.RECEIVE")) {
      i = 0;
    } else {
      i = -1;
    }
    if (a(paramContext, paramString, "com.vivo.pushclient.action.RECEIVE")) {
      i = 1;
    }
    return i;
  }
  
  /* Error */
  public static String b(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 234	com/vivo/push/util/s:b	Ljava/lang/String;
    //   3: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +7 -> 13
    //   9: getstatic 234	com/vivo/push/util/s:b	Ljava/lang/String;
    //   12: areturn
    //   13: aconst_null
    //   14: astore 5
    //   16: aconst_null
    //   17: astore_3
    //   18: aload_0
    //   19: invokevirtual 238	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   22: getstatic 243	com/vivo/push/p:a	Landroid/net/Uri;
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: invokevirtual 249	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore 4
    //   34: aload 4
    //   36: ifnonnull +44 -> 80
    //   39: ldc 29
    //   41: ldc 251
    //   43: invokestatic 73	com/vivo/push/util/o:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   46: pop
    //   47: aload 4
    //   49: ifnull +23 -> 72
    //   52: aload 4
    //   54: invokeinterface 256 1 0
    //   59: aconst_null
    //   60: areturn
    //   61: astore_0
    //   62: ldc 29
    //   64: ldc_w 257
    //   67: aload_0
    //   68: invokestatic 260	com/vivo/push/util/o:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   71: pop
    //   72: aconst_null
    //   73: areturn
    //   74: astore_3
    //   75: aconst_null
    //   76: astore_0
    //   77: goto +232 -> 309
    //   80: aconst_null
    //   81: astore_3
    //   82: iconst_0
    //   83: istore_1
    //   84: aload_3
    //   85: astore_0
    //   86: aload 4
    //   88: invokeinterface 263 1 0
    //   93: ifeq +106 -> 199
    //   96: ldc_w 265
    //   99: aload 4
    //   101: aload 4
    //   103: ldc_w 266
    //   106: invokeinterface 270 2 0
    //   111: invokeinterface 274 2 0
    //   116: invokevirtual 207	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   119: istore_2
    //   120: iload_2
    //   121: ifeq +24 -> 145
    //   124: aload 4
    //   126: aload 4
    //   128: ldc_w 276
    //   131: invokeinterface 270 2 0
    //   136: invokeinterface 274 2 0
    //   141: astore_3
    //   142: goto -58 -> 84
    //   145: aload_0
    //   146: astore_3
    //   147: ldc_w 278
    //   150: aload 4
    //   152: aload 4
    //   154: ldc_w 266
    //   157: invokeinterface 270 2 0
    //   162: invokeinterface 274 2 0
    //   167: invokevirtual 207	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   170: ifeq -86 -> 84
    //   173: aload 4
    //   175: aload 4
    //   177: ldc_w 276
    //   180: invokeinterface 270 2 0
    //   185: invokeinterface 274 2 0
    //   190: invokestatic 284	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   193: istore_1
    //   194: aload_0
    //   195: astore_3
    //   196: goto -112 -> 84
    //   199: aload_0
    //   200: putstatic 234	com/vivo/push/util/s:b	Ljava/lang/String;
    //   203: aload_0
    //   204: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   207: istore_2
    //   208: iload_2
    //   209: ifeq +30 -> 239
    //   212: aload 4
    //   214: ifnull +23 -> 237
    //   217: aload 4
    //   219: invokeinterface 256 1 0
    //   224: aconst_null
    //   225: areturn
    //   226: astore_0
    //   227: ldc 29
    //   229: ldc_w 257
    //   232: aload_0
    //   233: invokestatic 260	com/vivo/push/util/o:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   236: pop
    //   237: aconst_null
    //   238: areturn
    //   239: iload_1
    //   240: ifne +30 -> 270
    //   243: aload 4
    //   245: ifnull +23 -> 268
    //   248: aload 4
    //   250: invokeinterface 256 1 0
    //   255: aconst_null
    //   256: areturn
    //   257: astore_0
    //   258: ldc 29
    //   260: ldc_w 257
    //   263: aload_0
    //   264: invokestatic 260	com/vivo/push/util/o:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   267: pop
    //   268: aconst_null
    //   269: areturn
    //   270: aload_0
    //   271: astore_3
    //   272: aload 4
    //   274: ifnull +87 -> 361
    //   277: aload_0
    //   278: astore_3
    //   279: aload 4
    //   281: invokeinterface 256 1 0
    //   286: aload_0
    //   287: areturn
    //   288: astore_0
    //   289: ldc 29
    //   291: ldc_w 257
    //   294: aload_0
    //   295: invokestatic 260	com/vivo/push/util/o:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   298: pop
    //   299: aload_3
    //   300: areturn
    //   301: astore_0
    //   302: aload 4
    //   304: astore_3
    //   305: goto +58 -> 363
    //   308: astore_3
    //   309: aload_3
    //   310: astore 5
    //   312: goto +17 -> 329
    //   315: astore_0
    //   316: goto +47 -> 363
    //   319: astore_3
    //   320: aconst_null
    //   321: astore_0
    //   322: aload 5
    //   324: astore 4
    //   326: aload_3
    //   327: astore 5
    //   329: aload 4
    //   331: astore_3
    //   332: ldc 29
    //   334: ldc_w 286
    //   337: aload 5
    //   339: invokestatic 260	com/vivo/push/util/o:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   342: pop
    //   343: aload_0
    //   344: astore_3
    //   345: aload 4
    //   347: ifnull +14 -> 361
    //   350: aload_0
    //   351: astore_3
    //   352: aload 4
    //   354: invokeinterface 256 1 0
    //   359: aload_0
    //   360: astore_3
    //   361: aload_3
    //   362: areturn
    //   363: aload_3
    //   364: ifnull +23 -> 387
    //   367: aload_3
    //   368: invokeinterface 256 1 0
    //   373: goto +14 -> 387
    //   376: astore_3
    //   377: ldc 29
    //   379: ldc_w 257
    //   382: aload_3
    //   383: invokestatic 260	com/vivo/push/util/o:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   386: pop
    //   387: goto +5 -> 392
    //   390: aload_0
    //   391: athrow
    //   392: goto -2 -> 390
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	paramContext	Context
    //   83	157	1	bool1	boolean
    //   119	90	2	bool2	boolean
    //   17	1	3	localObject1	Object
    //   74	1	3	localException1	Exception
    //   81	224	3	localObject2	Object
    //   308	2	3	localException2	Exception
    //   319	8	3	localException3	Exception
    //   331	37	3	localObject3	Object
    //   376	7	3	localException4	Exception
    //   32	321	4	localObject4	Object
    //   14	324	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   52	59	61	java/lang/Exception
    //   39	47	74	java/lang/Exception
    //   217	224	226	java/lang/Exception
    //   248	255	257	java/lang/Exception
    //   279	286	288	java/lang/Exception
    //   352	359	288	java/lang/Exception
    //   39	47	301	finally
    //   86	120	301	finally
    //   124	142	301	finally
    //   147	194	301	finally
    //   199	208	301	finally
    //   86	120	308	java/lang/Exception
    //   124	142	308	java/lang/Exception
    //   147	194	308	java/lang/Exception
    //   199	208	308	java/lang/Exception
    //   18	34	315	finally
    //   332	343	315	finally
    //   18	34	319	java/lang/Exception
    //   367	373	376	java/lang/Exception
  }
  
  public static boolean c(Context paramContext)
  {
    Object localObject1 = a;
    if (localObject1 != null) {
      return ((Boolean)localObject1).booleanValue();
    }
    Object localObject2 = null;
    localObject1 = localObject2;
    if (paramContext != null) {
      if (TextUtils.isEmpty("com.vivo.push.sdk.service.SystemPushConfig"))
      {
        localObject1 = localObject2;
      }
      else
      {
        ProviderInfo localProviderInfo = paramContext.getPackageManager().resolveContentProvider("com.vivo.push.sdk.service.SystemPushConfig", 128);
        localObject1 = localObject2;
        if (localProviderInfo != null) {
          localObject1 = localProviderInfo.packageName;
        }
      }
    }
    paramContext = Boolean.valueOf("BCC35D4D3606F154F0402AB7634E8490C0B244C2675C3C6238986987024F0C02".equals(g(paramContext, (String)localObject1)));
    a = paramContext;
    return paramContext.booleanValue();
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "com.vivo.pushclient.action.RECEIVE");
  }
  
  private static com.vivo.push.model.b d(Context paramContext)
  {
    String str = b(paramContext);
    boolean bool = TextUtils.isEmpty(str);
    ApplicationInfo localApplicationInfo = null;
    if (bool) {
      return null;
    }
    com.vivo.push.model.b localb = new com.vivo.push.model.b(str);
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(str, 128);
      if (localPackageInfo != null)
      {
        localb.a(localPackageInfo.versionCode);
        localb.a(localPackageInfo.versionName);
        localApplicationInfo = localPackageInfo.applicationInfo;
      }
      if (localApplicationInfo != null) {
        localb.a(z.a(paramContext, str));
      }
      localb.a(a(paramContext, localb.b()));
      localb.b(a(paramContext, str));
      return localb;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      o.d("PushPackageUtils", "PackageManager NameNotFoundException is null");
    }
    return null;
  }
  
  public static boolean d(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "com.vivo.pushservice.action.RECEIVE");
  }
  
  private static List<String> e(Context paramContext)
  {
    g.a("findAllCoreClientPush");
    ArrayList localArrayList = new ArrayList();
    Object localObject = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
    try
    {
      paramContext = paramContext.getPackageManager().queryIntentServices((Intent)localObject, 576);
    }
    catch (Exception paramContext)
    {
      label41:
      int j;
      int i;
      break label41;
    }
    paramContext = null;
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      j = paramContext.size();
      i = 0;
      while (i < j)
      {
        localObject = (ResolveInfo)paramContext.get(i);
        if (localObject != null)
        {
          localObject = ((ResolveInfo)localObject).serviceInfo.packageName;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localArrayList.add(localObject);
          }
        }
        i += 1;
      }
    }
    if (localArrayList.size() <= 0) {
      o.d("PushPackageUtils", "get all push packages is null");
    }
    return localArrayList;
  }
  
  public static boolean e(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "com.vivo.pushservice.action.METHOD");
  }
  
  private static com.vivo.push.model.b f(Context paramContext, String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    ApplicationInfo localApplicationInfo = null;
    if (!bool)
    {
      int i;
      if ((!a(paramContext, paramString, "com.vivo.pushservice.action.METHOD")) && (!a(paramContext, paramString, "com.vivo.pushservice.action.RECEIVE"))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0) {
        return null;
      }
      com.vivo.push.model.b localb = new com.vivo.push.model.b(paramString);
      try
      {
        PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramString, 128);
        if (localPackageInfo != null)
        {
          localb.a(localPackageInfo.versionCode);
          localb.a(localPackageInfo.versionName);
          localApplicationInfo = localPackageInfo.applicationInfo;
        }
        if (localApplicationInfo != null) {
          localb.a(z.a(paramContext, paramString));
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        o.a("PushPackageUtils", "getPushPackageInfo exception: ", localNameNotFoundException);
      }
      localb.b(a(paramContext, paramString));
      localb.a(a(paramContext, localb.b()));
      return localb;
    }
    return null;
  }
  
  private static String g(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramContext == null) {
        return null;
      }
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64).signatures;
        int i = 0;
        paramContext = paramContext[0].toByteArray();
        paramContext = MessageDigest.getInstance("SHA256").digest(paramContext);
        paramString = new StringBuffer();
        while (i < paramContext.length)
        {
          String str = Integer.toHexString(paramContext[i] & 0xFF).toUpperCase(Locale.US);
          if (str.length() == 1) {
            paramString.append("0");
          }
          paramString.append(str);
          i += 1;
        }
        paramContext = paramString.toString();
        return paramContext;
      }
      catch (Exception paramContext)
      {
        o.a("PushPackageUtils", paramContext);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.s
 * JD-Core Version:    0.7.0.1
 */