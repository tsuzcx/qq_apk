package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;

public class ApkFileParser
{
  public static Drawable getAPKIcon(Context paramContext, String paramString)
  {
    try
    {
      Object localObject = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 1);
      if (localObject != null)
      {
        if (((PackageInfo)localObject).applicationInfo == null) {
          return null;
        }
        localObject = ((PackageInfo)localObject).applicationInfo;
        Class localClass = Class.forName("android.content.res.AssetManager");
        AssetManager localAssetManager = (AssetManager)localClass.getConstructor((Class[])null).newInstance((Object[])null);
        localClass.getDeclaredMethod("addAssetPath", new Class[] { String.class }).invoke(localAssetManager, new Object[] { paramString });
        paramString = new DisplayMetrics();
        paramString.setToDefaults();
        paramContext = new Resources(localAssetManager, paramString, paramContext.getResources().getConfiguration());
        if (((ApplicationInfo)localObject).icon != 0)
        {
          paramContext = paramContext.getDrawable(((ApplicationInfo)localObject).icon);
          return paramContext;
        }
      }
      else
      {
        return null;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static PackageInfo getPackageInfo(Context paramContext, String paramString, int paramInt)
  {
    return paramContext.getPackageManager().getPackageArchiveInfo(paramString, paramInt);
  }
  
  /* Error */
  public static PackageInfo getPackageInfo(String paramString)
  {
    // Byte code:
    //   0: new 27	android/content/pm/PackageInfo
    //   3: dup
    //   4: invokespecial 107	android/content/pm/PackageInfo:<init>	()V
    //   7: astore 5
    //   9: new 90	android/content/pm/ApplicationInfo
    //   12: dup
    //   13: invokespecial 108	android/content/pm/ApplicationInfo:<init>	()V
    //   16: astore_3
    //   17: aload_3
    //   18: new 110	android/os/Bundle
    //   21: dup
    //   22: invokespecial 111	android/os/Bundle:<init>	()V
    //   25: putfield 115	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   28: aload 5
    //   30: aload_3
    //   31: putfield 31	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   34: ldc 55
    //   36: invokevirtual 118	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   39: checkcast 55	android/content/res/AssetManager
    //   42: astore_3
    //   43: ldc 55
    //   45: ldc 57
    //   47: iconst_1
    //   48: anewarray 35	java/lang/Class
    //   51: dup
    //   52: iconst_0
    //   53: ldc 59
    //   55: aastore
    //   56: invokevirtual 63	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   59: astore 4
    //   61: aload 4
    //   63: iconst_1
    //   64: invokevirtual 122	java/lang/reflect/Method:setAccessible	(Z)V
    //   67: aload 4
    //   69: aload_3
    //   70: iconst_1
    //   71: anewarray 4	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload_0
    //   77: aastore
    //   78: invokevirtual 69	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   81: pop
    //   82: aload_3
    //   83: ldc 124
    //   85: invokevirtual 128	android/content/res/AssetManager:openXmlResourceParser	(Ljava/lang/String;)Landroid/content/res/XmlResourceParser;
    //   88: astore 6
    //   90: aload 6
    //   92: ifnonnull +5 -> 97
    //   95: aconst_null
    //   96: areturn
    //   97: aload 6
    //   99: invokeinterface 134 1 0
    //   104: istore_1
    //   105: goto +421 -> 526
    //   108: aload 6
    //   110: invokeinterface 138 1 0
    //   115: astore_3
    //   116: aload_3
    //   117: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   120: ifne +355 -> 475
    //   123: aload_3
    //   124: ldc 146
    //   126: invokevirtual 150	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   129: ifeq +61 -> 190
    //   132: iconst_0
    //   133: istore_1
    //   134: iload_1
    //   135: aload 6
    //   137: invokeinterface 153 1 0
    //   142: if_icmpge +333 -> 475
    //   145: aload 6
    //   147: iload_1
    //   148: invokeinterface 157 2 0
    //   153: ldc 159
    //   155: invokevirtual 150	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   158: ifeq +381 -> 539
    //   161: aload 5
    //   163: aload 6
    //   165: iload_1
    //   166: invokeinterface 162 2 0
    //   171: putfield 166	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   174: aload 5
    //   176: getfield 31	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   179: aload 5
    //   181: getfield 166	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   184: putfield 167	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   187: goto +352 -> 539
    //   190: aload_3
    //   191: ldc 169
    //   193: invokevirtual 150	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   196: istore_2
    //   197: iload_2
    //   198: ifeq +51 -> 249
    //   201: iconst_0
    //   202: istore_1
    //   203: iload_1
    //   204: aload 6
    //   206: invokeinterface 153 1 0
    //   211: if_icmpge +264 -> 475
    //   214: aload 6
    //   216: iload_1
    //   217: invokeinterface 157 2 0
    //   222: ldc 171
    //   224: invokevirtual 150	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   227: ifeq +319 -> 546
    //   230: aload 5
    //   232: getfield 31	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   235: aload 6
    //   237: iload_1
    //   238: invokeinterface 162 2 0
    //   243: putfield 174	android/content/pm/ApplicationInfo:className	Ljava/lang/String;
    //   246: goto +300 -> 546
    //   249: aload_3
    //   250: ldc 176
    //   252: invokevirtual 150	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   255: istore_2
    //   256: ldc 178
    //   258: astore_0
    //   259: iload_2
    //   260: ifeq +94 -> 354
    //   263: ldc 178
    //   265: astore 4
    //   267: iconst_0
    //   268: istore_1
    //   269: aload_0
    //   270: astore_3
    //   271: aload 4
    //   273: astore_0
    //   274: iload_1
    //   275: aload 6
    //   277: invokeinterface 153 1 0
    //   282: if_icmpge +56 -> 338
    //   285: aload 6
    //   287: iload_1
    //   288: invokeinterface 157 2 0
    //   293: ldc 171
    //   295: invokevirtual 150	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   298: ifeq +12 -> 310
    //   301: aload 6
    //   303: iload_1
    //   304: invokeinterface 162 2 0
    //   309: astore_3
    //   310: aload 6
    //   312: iload_1
    //   313: invokeinterface 157 2 0
    //   318: ldc 180
    //   320: invokevirtual 150	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   323: ifeq +230 -> 553
    //   326: aload 6
    //   328: iload_1
    //   329: invokeinterface 162 2 0
    //   334: astore_0
    //   335: goto +218 -> 553
    //   338: aload 5
    //   340: getfield 31	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   343: getfield 115	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   346: aload_3
    //   347: aload_0
    //   348: invokevirtual 184	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: goto +124 -> 475
    //   354: aload_3
    //   355: ldc 186
    //   357: invokevirtual 150	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   360: ifeq +115 -> 475
    //   363: iconst_0
    //   364: istore_1
    //   365: iload_1
    //   366: aload 6
    //   368: invokeinterface 153 1 0
    //   373: if_icmpge +31 -> 404
    //   376: aload 6
    //   378: iload_1
    //   379: invokeinterface 157 2 0
    //   384: ldc 171
    //   386: invokevirtual 150	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   389: ifeq +171 -> 560
    //   392: aload 6
    //   394: iload_1
    //   395: invokeinterface 162 2 0
    //   400: astore_0
    //   401: goto +159 -> 560
    //   404: new 188	android/content/pm/ActivityInfo
    //   407: dup
    //   408: invokespecial 189	android/content/pm/ActivityInfo:<init>	()V
    //   411: astore_3
    //   412: aload_3
    //   413: aload_0
    //   414: putfield 191	android/content/pm/ActivityInfo:name	Ljava/lang/String;
    //   417: aload 5
    //   419: getfield 195	android/content/pm/PackageInfo:activities	[Landroid/content/pm/ActivityInfo;
    //   422: ifnonnull +19 -> 441
    //   425: aload 5
    //   427: iconst_1
    //   428: anewarray 188	android/content/pm/ActivityInfo
    //   431: dup
    //   432: iconst_0
    //   433: aload_3
    //   434: aastore
    //   435: putfield 195	android/content/pm/PackageInfo:activities	[Landroid/content/pm/ActivityInfo;
    //   438: goto +37 -> 475
    //   441: aload 5
    //   443: getfield 195	android/content/pm/PackageInfo:activities	[Landroid/content/pm/ActivityInfo;
    //   446: arraylength
    //   447: istore_1
    //   448: aload 5
    //   450: aload 5
    //   452: getfield 195	android/content/pm/PackageInfo:activities	[Landroid/content/pm/ActivityInfo;
    //   455: iload_1
    //   456: iconst_1
    //   457: iadd
    //   458: invokestatic 201	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   461: checkcast 202	[Landroid/content/pm/ActivityInfo;
    //   464: putfield 195	android/content/pm/PackageInfo:activities	[Landroid/content/pm/ActivityInfo;
    //   467: aload 5
    //   469: getfield 195	android/content/pm/PackageInfo:activities	[Landroid/content/pm/ActivityInfo;
    //   472: iload_1
    //   473: aload_3
    //   474: aastore
    //   475: aload 6
    //   477: invokeinterface 205 1 0
    //   482: istore_1
    //   483: goto +43 -> 526
    //   486: aload 6
    //   488: invokeinterface 208 1 0
    //   493: aload 5
    //   495: areturn
    //   496: astore_0
    //   497: goto +6 -> 503
    //   500: astore_0
    //   501: aload_0
    //   502: athrow
    //   503: aload 6
    //   505: invokeinterface 208 1 0
    //   510: goto +5 -> 515
    //   513: aload_0
    //   514: athrow
    //   515: goto -2 -> 513
    //   518: astore_0
    //   519: aload 5
    //   521: areturn
    //   522: astore_3
    //   523: goto -13 -> 510
    //   526: iload_1
    //   527: iconst_1
    //   528: if_icmpeq -42 -> 486
    //   531: iload_1
    //   532: iconst_2
    //   533: if_icmpeq -425 -> 108
    //   536: goto -61 -> 475
    //   539: iload_1
    //   540: iconst_1
    //   541: iadd
    //   542: istore_1
    //   543: goto -409 -> 134
    //   546: iload_1
    //   547: iconst_1
    //   548: iadd
    //   549: istore_1
    //   550: goto -347 -> 203
    //   553: iload_1
    //   554: iconst_1
    //   555: iadd
    //   556: istore_1
    //   557: goto -283 -> 274
    //   560: iload_1
    //   561: iconst_1
    //   562: iadd
    //   563: istore_1
    //   564: goto -199 -> 365
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	567	0	paramString	String
    //   104	460	1	i	int
    //   196	64	2	bool	boolean
    //   16	458	3	localObject1	Object
    //   522	1	3	localException	Exception
    //   59	213	4	localObject2	Object
    //   7	513	5	localPackageInfo	PackageInfo
    //   88	416	6	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   97	105	496	finally
    //   108	132	496	finally
    //   134	187	496	finally
    //   190	197	496	finally
    //   203	246	496	finally
    //   249	256	496	finally
    //   274	285	496	finally
    //   285	310	496	finally
    //   310	335	496	finally
    //   338	351	496	finally
    //   354	363	496	finally
    //   365	376	496	finally
    //   376	401	496	finally
    //   404	438	496	finally
    //   441	475	496	finally
    //   475	483	496	finally
    //   501	503	496	finally
    //   97	105	500	java/lang/Exception
    //   108	132	500	java/lang/Exception
    //   134	187	500	java/lang/Exception
    //   190	197	500	java/lang/Exception
    //   203	246	500	java/lang/Exception
    //   249	256	500	java/lang/Exception
    //   274	285	500	java/lang/Exception
    //   285	310	500	java/lang/Exception
    //   310	335	500	java/lang/Exception
    //   338	351	500	java/lang/Exception
    //   354	363	500	java/lang/Exception
    //   365	376	500	java/lang/Exception
    //   376	401	500	java/lang/Exception
    //   404	438	500	java/lang/Exception
    //   441	475	500	java/lang/Exception
    //   475	483	500	java/lang/Exception
    //   486	493	518	java/lang/Exception
    //   503	510	522	java/lang/Exception
  }
  
  public static PackageInfo getPackageInfoWithException(Context paramContext, String paramString, int paramInt)
  {
    PackageInfo localPackageInfo = getPackageInfo(paramString);
    paramString = localPackageInfo;
    if (localPackageInfo == null) {
      paramString = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 128);
    }
    return paramString;
  }
  
  public static Signature[] getSignaure(String paramString)
  {
    try
    {
      Object localObject1 = Class.forName("android.content.pm.PackageParser");
      Object localObject2 = Class.forName("android.content.pm.PackageParser$Package");
      Object localObject3 = ((Class)localObject1).getConstructor(new Class[] { String.class });
      Method localMethod = ((Class)localObject1).getMethod("parsePackage", new Class[] { File.class, String.class, DisplayMetrics.class, Integer.TYPE });
      localObject1 = ((Class)localObject1).getMethod("collectCertificates", new Class[] { localObject2, Integer.TYPE });
      localObject2 = ((Class)localObject2).getField("mSignatures");
      localObject3 = ((Constructor)localObject3).newInstance(new Object[] { paramString });
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      localDisplayMetrics.setToDefaults();
      paramString = localMethod.invoke(localObject3, new Object[] { new File(paramString), paramString, localDisplayMetrics, Integer.valueOf(0) });
      if (paramString == null) {
        return null;
      }
      ((Method)localObject1).invoke(localObject3, new Object[] { paramString, Integer.valueOf(64) });
      paramString = ((Field)localObject2).get(paramString);
      if ((paramString != null) && ((paramString instanceof Signature[])))
      {
        paramString = (Signature[])paramString;
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static boolean isApkFileBroken(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 64);
    return (paramContext == null) || (paramContext.applicationInfo == null);
  }
  
  public static boolean isSignaturesSame(Signature[] paramArrayOfSignature1, Signature[] paramArrayOfSignature2)
  {
    if (paramArrayOfSignature1 == null) {
      return true;
    }
    if (paramArrayOfSignature2 == null) {
      return true;
    }
    HashSet localHashSet = new HashSet();
    int k = paramArrayOfSignature1.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      localHashSet.add(paramArrayOfSignature1[i]);
      i += 1;
    }
    paramArrayOfSignature1 = new HashSet();
    k = paramArrayOfSignature2.length;
    i = j;
    while (i < k)
    {
      paramArrayOfSignature1.add(paramArrayOfSignature2[i]);
      i += 1;
    }
    return localHashSet.equals(paramArrayOfSignature1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ApkFileParser
 * JD-Core Version:    0.7.0.1
 */