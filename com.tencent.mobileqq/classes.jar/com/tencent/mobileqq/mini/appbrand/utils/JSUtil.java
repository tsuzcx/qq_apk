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
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_1
    //   53: astore_0
    //   54: aload_2
    //   55: invokevirtual 60	java/lang/Exception:printStackTrace	()V
    //   58: aload_1
    //   59: ifnull +7 -> 66
    //   62: aload_1
    //   63: invokevirtual 57	java/io/InputStream:close	()V
    //   66: aconst_null
    //   67: areturn
    //   68: astore_1
    //   69: aconst_null
    //   70: astore_0
    //   71: aload_0
    //   72: ifnull +7 -> 79
    //   75: aload_0
    //   76: invokevirtual 57	java/io/InputStream:close	()V
    //   79: aload_1
    //   80: athrow
    //   81: astore_0
    //   82: aload_2
    //   83: areturn
    //   84: astore_0
    //   85: goto -19 -> 66
    //   88: astore_0
    //   89: goto -10 -> 79
    //   92: astore_1
    //   93: goto -22 -> 71
    //   96: astore_2
    //   97: goto -45 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramContext	android.content.Context
    //   0	100	1	paramString	String
    //   17	31	2	localObject	Object
    //   49	34	2	localException1	Exception
    //   96	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	9	49	java/lang/Exception
    //   0	9	68	finally
    //   43	47	81	java/io/IOException
    //   62	66	84	java/io/IOException
    //   75	79	88	java/io/IOException
    //   11	18	92	finally
    //   20	26	92	finally
    //   28	39	92	finally
    //   54	58	92	finally
    //   11	18	96	java/lang/Exception
    //   20	26	96	java/lang/Exception
    //   28	39	96	java/lang/Exception
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
    if (VersionUtils.isHoneycomb())
    {
      paramClass = paramClass.getConstructor(paramVarArgs);
      return paramClass;
    }
    Constructor[] arrayOfConstructor = paramClass.getDeclaredConstructors();
    int j = arrayOfConstructor.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label59;
      }
      Constructor localConstructor = arrayOfConstructor[i];
      paramClass = localConstructor;
      if (isParameterTypesMatch(paramVarArgs, localConstructor.getParameterTypes())) {
        break;
      }
      i += 1;
    }
    label59:
    throw new NoSuchMethodException();
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
    str2 = "";
    Object localObject1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = str2;
      if (paramInt <= 0) {}
    }
    try
    {
      Object localObject2 = Uri.parse(paramString);
      localObject1 = str2;
      if (((Uri)localObject2).isHierarchical())
      {
        localObject2 = ((Uri)localObject2).getHost();
        localObject1 = str2;
        if (localObject2 != null)
        {
          localObject2 = ((String)localObject2).split("\\.");
          localObject1 = str2;
          if (localObject2.length > 0)
          {
            int i = Math.max(0, localObject2.length - (paramInt + 1));
            localObject1 = new StringBuilder(256);
            ((StringBuilder)localObject1).append(localObject2[i]);
            i += 1;
            while (i < localObject2.length)
            {
              ((StringBuilder)localObject1).append('.').append(localObject2[i]);
              i += 1;
            }
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        String str1 = str2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QLog", 2, "Get " + paramInt + " level domain= " + (String)localObject1 + " from " + paramString);
    }
    return localObject1;
  }
  
  private static boolean isParameterTypesMatch(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2)
  {
    if (paramArrayOfClass1.length != paramArrayOfClass2.length) {
      return false;
    }
    int j = paramArrayOfClass1.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label35;
      }
      if (paramArrayOfClass1[i] != paramArrayOfClass2[i]) {
        break;
      }
      i += 1;
    }
    label35:
    return true;
  }
  
  public static int[] jsStringToJavaIntArray(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {
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
        label61:
        i += 1;
        continue;
        return arrayOfInt;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label61;
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
    if (i < j)
    {
      char c = paramString.charAt(i);
      switch (c)
      {
      default: 
        if (c <= '\037') {
          localStringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append('\\').append(c);
        continue;
        localStringBuilder.append("\\t");
        continue;
        localStringBuilder.append("\\b");
        continue;
        localStringBuilder.append("\\n");
        continue;
        localStringBuilder.append("\\r");
        continue;
        localStringBuilder.append("\\f");
        continue;
        localStringBuilder.append(c);
      }
    }
    localStringBuilder.append("\"");
    return localStringBuilder.toString();
  }
  
  public static void webViewLoadLocalJsInner(WebView paramWebView, String paramString, ValueCallback paramValueCallback)
  {
    Object localObject = null;
    try
    {
      paramString = FileUtils.readFileToString(new File(paramString));
      paramWebView.evaluateJavascript(paramString, paramValueCallback);
      return;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.JSUtil
 * JD-Core Version:    0.7.0.1
 */