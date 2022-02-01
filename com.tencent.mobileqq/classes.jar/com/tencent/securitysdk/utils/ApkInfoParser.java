package com.tencent.securitysdk.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import java.lang.reflect.Method;

public class ApkInfoParser
{
  /* Error */
  public static int a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iconst_0
    //   3: invokevirtual 23	android/content/Context:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +15 -> 23
    //   11: iconst_0
    //   12: ireturn
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 26	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   18: aconst_null
    //   19: astore_1
    //   20: goto -13 -> 7
    //   23: aload_1
    //   24: invokevirtual 30	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   27: astore 5
    //   29: new 32	android/content/res/Resources
    //   32: dup
    //   33: aload 5
    //   35: aload_0
    //   36: invokevirtual 36	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   39: invokevirtual 40	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   42: aconst_null
    //   43: invokespecial 43	android/content/res/Resources:<init>	(Landroid/content/res/AssetManager;Landroid/util/DisplayMetrics;Landroid/content/res/Configuration;)V
    //   46: astore 4
    //   48: aload_1
    //   49: aload 5
    //   51: invokestatic 46	com/tencent/securitysdk/utils/ApkInfoParser:a	(Landroid/content/Context;Landroid/content/res/AssetManager;)Landroid/content/res/XmlResourceParser;
    //   54: astore_0
    //   55: aload_0
    //   56: ifnull -45 -> 11
    //   59: aload_0
    //   60: invokeinterface 52 1 0
    //   65: istore_2
    //   66: iload_2
    //   67: iconst_1
    //   68: if_icmpeq +116 -> 184
    //   71: iload_2
    //   72: tableswitch	default:+20 -> 92, 2:+52->124
    //   93: invokeinterface 55 1 0
    //   98: istore_3
    //   99: iload_3
    //   100: istore_2
    //   101: goto -35 -> 66
    //   104: astore_0
    //   105: aload_0
    //   106: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   109: aconst_null
    //   110: astore_0
    //   111: goto -56 -> 55
    //   114: astore_1
    //   115: aload_1
    //   116: invokevirtual 57	org/xmlpull/v1/XmlPullParserException:printStackTrace	()V
    //   119: iconst_0
    //   120: istore_2
    //   121: goto -55 -> 66
    //   124: aload_0
    //   125: invokeinterface 61 1 0
    //   130: astore_1
    //   131: aload_1
    //   132: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   135: ifne -43 -> 92
    //   138: aload_1
    //   139: ldc 69
    //   141: invokevirtual 75	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   144: ifeq -52 -> 92
    //   147: aload_0
    //   148: aload 4
    //   150: ldc 77
    //   152: invokestatic 80	com/tencent/securitysdk/utils/ApkInfoParser:a	(Landroid/content/res/XmlResourceParser;Landroid/content/res/Resources;Ljava/lang/String;)Ljava/lang/String;
    //   155: astore_0
    //   156: aload_0
    //   157: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   160: ifne -149 -> 11
    //   163: aload_0
    //   164: invokestatic 86	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   167: ireturn
    //   168: astore_1
    //   169: aload_1
    //   170: invokevirtual 57	org/xmlpull/v1/XmlPullParserException:printStackTrace	()V
    //   173: goto -107 -> 66
    //   176: astore_1
    //   177: aload_1
    //   178: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   181: goto -115 -> 66
    //   184: aload_0
    //   185: invokeinterface 89 1 0
    //   190: iconst_0
    //   191: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramContext	Context
    //   0	192	1	paramString	String
    //   65	56	2	i	int
    //   98	2	3	j	int
    //   46	103	4	localResources	Resources
    //   27	23	5	localAssetManager	AssetManager
    // Exception table:
    //   from	to	target	type
    //   0	7	13	android/content/pm/PackageManager$NameNotFoundException
    //   48	55	104	java/io/IOException
    //   59	66	114	org/xmlpull/v1/XmlPullParserException
    //   92	99	168	org/xmlpull/v1/XmlPullParserException
    //   92	99	176	java/io/IOException
  }
  
  protected static XmlResourceParser a(Context paramContext, AssetManager paramAssetManager)
  {
    int j = 1;
    try
    {
      String str2 = (String)Context.class.getMethod("getPackageResourcePath", new Class[0]).invoke(paramContext, new Object[0]);
      Method localMethod = AssetManager.class.getMethod("getCookieName", new Class[] { Integer.TYPE });
      String str1 = str2;
      int i = j;
      if (str2 == null)
      {
        str1 = str2;
        i = j;
        if (paramContext.getPackageName().equals("android"))
        {
          str1 = "/system/framework/framework-res.apk";
          i = j;
        }
      }
      while (i < 20)
      {
        if (str1 != null) {
          if (str1.equals(localMethod.invoke(paramAssetManager, new Object[] { Integer.valueOf(i) })))
          {
            paramContext = paramAssetManager.openXmlResourceParser(i, "AndroidManifest.xml");
            return paramContext;
          }
        }
        i += 1;
      }
      return paramAssetManager.openXmlResourceParser("AndroidManifest.xml");
    }
    catch (Exception paramContext) {}
  }
  
  protected static String a(XmlResourceParser paramXmlResourceParser, Resources paramResources, String paramString)
  {
    return a(paramXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", paramString), paramResources);
  }
  
  protected static String a(String paramString, Resources paramResources)
  {
    if ((paramString == null) || (!paramString.startsWith("@")) || (paramResources == null)) {
      return paramString;
    }
    try
    {
      paramResources = paramResources.getString(Integer.parseInt(paramString.substring(1)));
      return paramResources;
    }
    catch (Resources.NotFoundException paramResources)
    {
      return paramString;
    }
    catch (NumberFormatException paramResources) {}
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.securitysdk.utils.ApkInfoParser
 * JD-Core Version:    0.7.0.1
 */