package com.tencent.mobileqq.mini.appbrand.utils;

import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.util.VersionUtils;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;

public class JSUtil
{
  public static final String KEY_URL = "url";
  public static final String SP_KEY_WHITE_LIST_CONFIG = "whitelist_config_json";
  public static final String SP_NAME_WHITE_LIST = "sp_cgi_whitelist";
  
  /* Error */
  public static String assetFile2Str(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 31	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: aload_1
    //   5: invokevirtual 37	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: aload_1
    //   12: invokevirtual 43	java/io/InputStream:available	()I
    //   15: newarray byte
    //   17: astore_2
    //   18: aload_1
    //   19: astore_0
    //   20: aload_1
    //   21: aload_2
    //   22: invokevirtual 47	java/io/InputStream:read	([B)I
    //   25: pop
    //   26: aload_1
    //   27: astore_0
    //   28: new 49	java/lang/String
    //   31: dup
    //   32: aload_2
    //   33: ldc 51
    //   35: invokespecial 54	java/lang/String:<init>	([BLjava/lang/String;)V
    //   38: astore_2
    //   39: aload_1
    //   40: ifnull +7 -> 47
    //   43: aload_1
    //   44: invokevirtual 57	java/io/InputStream:close	()V
    //   47: aload_2
    //   48: areturn
    //   49: astore_2
    //   50: goto +12 -> 62
    //   53: astore_1
    //   54: aconst_null
    //   55: astore_0
    //   56: goto +23 -> 79
    //   59: astore_2
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_1
    //   63: astore_0
    //   64: aload_2
    //   65: invokevirtual 60	java/lang/Exception:printStackTrace	()V
    //   68: aload_1
    //   69: ifnull +7 -> 76
    //   72: aload_1
    //   73: invokevirtual 57	java/io/InputStream:close	()V
    //   76: aconst_null
    //   77: areturn
    //   78: astore_1
    //   79: aload_0
    //   80: ifnull +7 -> 87
    //   83: aload_0
    //   84: invokevirtual 57	java/io/InputStream:close	()V
    //   87: aload_1
    //   88: athrow
    //   89: astore_0
    //   90: aload_2
    //   91: areturn
    //   92: astore_0
    //   93: aconst_null
    //   94: areturn
    //   95: astore_0
    //   96: goto -9 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramContext	android.content.Context
    //   0	99	1	paramString	String
    //   17	31	2	localObject	Object
    //   49	1	2	localException1	Exception
    //   59	32	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   11	18	49	java/lang/Exception
    //   20	26	49	java/lang/Exception
    //   28	39	49	java/lang/Exception
    //   0	9	53	finally
    //   0	9	59	java/lang/Exception
    //   11	18	78	finally
    //   20	26	78	finally
    //   28	39	78	finally
    //   64	68	78	finally
    //   43	47	89	java/io/IOException
    //   72	76	92	java/io/IOException
    //   83	87	95	java/io/IOException
  }
  
  public static String filterKeyForLog(String paramString, String... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replaceAll("((?i)sid|uin|sec_sig|MOBINFO)=[^&#]+", "$1=****");
  }
  
  public static Constructor<?> getDeclaredConstructor(Class<?> paramClass, Class... paramVarArgs)
  {
    if (VersionUtils.isHoneycomb()) {
      return paramClass.getConstructor(paramVarArgs);
    }
    paramClass = paramClass.getDeclaredConstructors();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Constructor<?> localConstructor = paramClass[i];
      if (isParameterTypesMatch(paramVarArgs, localConstructor.getParameterTypes())) {
        return localConstructor;
      }
      i += 1;
    }
    paramClass = new NoSuchMethodException();
    for (;;)
    {
      throw paramClass;
    }
  }
  
  public static int[] getDecoderVersion()
  {
    int i = Build.VERSION.SDK_INT;
    if ((i >= 14) && (i <= 15)) {
      return new int[] { 0, 1, 2, 0 };
    }
    if (16 == i) {
      return new int[] { 0, 1, 2, 0 };
    }
    if (17 == i) {
      return new int[] { 0, 2, 0, 0 };
    }
    if (18 == i) {
      return new int[] { 0, 2, 1, 0 };
    }
    if (19 == i) {
      return new int[] { 0, 3, 2, 0 };
    }
    if (i > 19) {
      return new int[] { 0, 4, 1, 0 };
    }
    return null;
  }
  
  public static String getSpecifiedLevelDomain(String paramString, int paramInt)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject3 = "";
    Object localObject1 = localObject3;
    if (!bool)
    {
      localObject1 = localObject3;
      if (paramInt <= 0) {}
    }
    for (;;)
    {
      int i;
      try
      {
        localObject4 = Uri.parse(paramString);
        localObject1 = localObject3;
        if (!((Uri)localObject4).isHierarchical()) {
          break label164;
        }
        localObject4 = ((Uri)localObject4).getHost();
        localObject1 = localObject3;
        if (localObject4 == null) {
          break label164;
        }
        localObject4 = ((String)localObject4).split("\\.");
        localObject1 = localObject3;
        if (localObject4.length <= 0) {
          break label164;
        }
        i = Math.max(0, localObject4.length - (paramInt + 1));
        localObject1 = new StringBuilder(256);
        ((StringBuilder)localObject1).append(localObject4[i]);
      }
      catch (Exception localException)
      {
        Object localObject4;
        localException.printStackTrace();
        localObject2 = localObject3;
      }
      if (i < localObject4.length)
      {
        ((StringBuilder)localObject1).append('.');
        ((StringBuilder)localObject1).append(localObject4[i]);
      }
      else
      {
        localObject1 = ((StringBuilder)localObject1).toString();
        Object localObject2;
        label164:
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("Get ");
          ((StringBuilder)localObject3).append(paramInt);
          ((StringBuilder)localObject3).append(" level domain= ");
          ((StringBuilder)localObject3).append(localObject2);
          ((StringBuilder)localObject3).append(" from ");
          ((StringBuilder)localObject3).append(paramString);
          QLog.d("QLog", 2, ((StringBuilder)localObject3).toString());
        }
        return localObject2;
      }
      i += 1;
    }
  }
  
  private static boolean isParameterTypesMatch(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2)
  {
    if (paramArrayOfClass1.length != paramArrayOfClass2.length) {
      return false;
    }
    int j = paramArrayOfClass1.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfClass1[i] != paramArrayOfClass2[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static int[] jsStringToJavaIntArray(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int i = 0;
    if (bool) {
      return new int[0];
    }
    paramString = paramString.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
    int[] arrayOfInt = new int[paramString.length];
    for (;;)
    {
      if (i < paramString.length) {}
      try
      {
        arrayOfInt[i] = Integer.parseInt(paramString[i]);
        label63:
        i += 1;
        continue;
        return arrayOfInt;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label63;
      }
    }
  }
  
  public static String toJsString(String paramString)
  {
    if (paramString == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("\"");
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      char c = paramString.charAt(i);
      if (c != '\f')
      {
        if (c != '\r')
        {
          if ((c != '"') && (c != '/') && (c != '\\')) {}
          switch (c)
          {
          default: 
            if (c <= '\037') {
              localStringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
            } else {
              localStringBuilder.append(c);
            }
            break;
          case '\n': 
            localStringBuilder.append("\\n");
            break;
          case '\t': 
            localStringBuilder.append("\\t");
            break;
          case '\b': 
            localStringBuilder.append("\\b");
            break;
            localStringBuilder.append('\\');
            localStringBuilder.append(c);
            break;
          }
        }
        else
        {
          localStringBuilder.append("\\r");
        }
      }
      else {
        localStringBuilder.append("\\f");
      }
      i += 1;
    }
    localStringBuilder.append("\"");
    return localStringBuilder.toString();
  }
  
  public static void webViewLoadLocalJsInner(WebView paramWebView, String paramString, ValueCallback paramValueCallback)
  {
    try
    {
      paramString = FileUtils.readFileToString(new File(paramString));
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
    paramWebView.evaluateJavascript(paramString, paramValueCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.JSUtil
 * JD-Core Version:    0.7.0.1
 */