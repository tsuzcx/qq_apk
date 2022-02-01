package com.tencent.securitysdk.utils;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

public class ApkInfoParser
{
  public static int a(Context paramContext, String paramString)
  {
    Object localObject = null;
    try
    {
      paramString = paramContext.createPackageContext(paramString, 0);
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
    if (paramString == null) {
      return 0;
    }
    AssetManager localAssetManager = paramString.getAssets();
    Resources localResources = new Resources(localAssetManager, paramContext.getResources().getDisplayMetrics(), null);
    try
    {
      paramContext = a(paramString, localAssetManager);
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
      paramContext = localObject;
    }
    if (paramContext == null) {
      return 0;
    }
    int i;
    try
    {
      i = paramContext.getEventType();
    }
    catch (XmlPullParserException paramString)
    {
      paramString.printStackTrace();
      i = 0;
    }
    while (i != 1)
    {
      if (i == 2)
      {
        paramString = paramContext.getName();
        if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("manifest")))
        {
          paramContext = a(paramContext, localResources, "versionCode");
          if (TextUtils.isEmpty(paramContext)) {
            return 0;
          }
          return Integer.parseInt(paramContext);
        }
      }
      try
      {
        int j = paramContext.nextToken();
        i = j;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
      catch (XmlPullParserException paramString)
      {
        paramString.printStackTrace();
      }
    }
    paramContext.close();
    return 0;
  }
  
  protected static XmlResourceParser a(Context paramContext, AssetManager paramAssetManager)
  {
    for (;;)
    {
      try
      {
        String str2 = (String)Context.class.getMethod("getPackageResourcePath", new Class[0]).invoke(paramContext, new Object[0]);
        localMethod = AssetManager.class.getMethod("getCookieName", new Class[] { Integer.TYPE });
        str1 = str2;
        if (str2 != null) {
          continue;
        }
        str1 = str2;
        if (!paramContext.getPackageName().equals("android")) {
          continue;
        }
        str1 = "/system/framework/framework-res.apk";
      }
      catch (Exception paramContext)
      {
        Method localMethod;
        String str1;
        continue;
        int i = 1;
        continue;
      }
      if (i >= 20) {
        continue;
      }
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
  
  protected static String a(XmlResourceParser paramXmlResourceParser, Resources paramResources, String paramString)
  {
    return a(paramXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", paramString), paramResources);
  }
  
  protected static String a(String paramString, Resources paramResources)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.startsWith("@")) {
        if (paramResources == null) {
          return paramString;
        }
      }
    }
    try
    {
      str = paramResources.getString(Integer.parseInt(paramString.substring(1)));
      return str;
    }
    catch (NumberFormatException|Resources.NotFoundException paramResources) {}
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.securitysdk.utils.ApkInfoParser
 * JD-Core Version:    0.7.0.1
 */