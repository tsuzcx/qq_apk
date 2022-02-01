package com.tencent.mobileqq.mini.util;

import android.text.TextUtils;
import org.json.JSONObject;

public final class ApiUtil
{
  private static final String TAG = "ApiUtil";
  
  public static JSONObject wrapCallbackCancel(String paramString, JSONObject paramJSONObject)
  {
    return wrapCallbackCancel(paramString, paramJSONObject, null);
  }
  
  public static JSONObject wrapCallbackCancel(String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = paramJSONObject;
      if (paramJSONObject == null) {
        paramString1 = new JSONObject();
      }
      return paramString1;
    }
    if (paramJSONObject == null) {}
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        paramJSONObject = (JSONObject)localObject;
      }
      catch (Exception paramString1)
      {
        Object localObject;
        continue;
      }
      try
      {
        localObject = new StringBuilder().append(paramString1).append(":cancel ");
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = "cancel";
        }
        paramJSONObject.put("errMsg", paramString1);
      }
      catch (Exception paramString1)
      {
        continue;
      }
      return paramJSONObject;
    }
  }
  
  public static JSONObject wrapCallbackFail(String paramString, JSONObject paramJSONObject)
  {
    return wrapCallbackFail(paramString, paramJSONObject, null);
  }
  
  /* Error */
  public static JSONObject wrapCallbackFail(String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 26	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +19 -> 23
    //   7: aload_1
    //   8: astore_0
    //   9: aload_1
    //   10: ifnonnull +11 -> 21
    //   13: new 28	org/json/JSONObject
    //   16: dup
    //   17: invokespecial 29	org/json/JSONObject:<init>	()V
    //   20: astore_0
    //   21: aload_0
    //   22: areturn
    //   23: aload_1
    //   24: ifnonnull +89 -> 113
    //   27: new 28	org/json/JSONObject
    //   30: dup
    //   31: invokespecial 29	org/json/JSONObject:<init>	()V
    //   34: astore_3
    //   35: aload_3
    //   36: astore_1
    //   37: new 31	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   44: aload_0
    //   45: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc 55
    //   50: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: astore_3
    //   54: aload_2
    //   55: invokestatic 26	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: ifeq +24 -> 82
    //   61: ldc 57
    //   63: astore_0
    //   64: aload_1
    //   65: ldc 42
    //   67: aload_3
    //   68: aload_0
    //   69: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokevirtual 50	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   78: pop
    //   79: goto +37 -> 116
    //   82: new 31	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   89: ldc 59
    //   91: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_2
    //   95: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: astore_0
    //   102: goto -38 -> 64
    //   105: astore_0
    //   106: goto +10 -> 116
    //   109: astore_0
    //   110: goto +6 -> 116
    //   113: goto -76 -> 37
    //   116: aload_1
    //   117: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramString1	String
    //   0	118	1	paramJSONObject	JSONObject
    //   0	118	2	paramString2	String
    //   34	34	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   27	35	105	java/lang/Exception
    //   37	61	109	java/lang/Exception
    //   64	79	109	java/lang/Exception
    //   82	102	109	java/lang/Exception
  }
  
  public static JSONObject wrapCallbackOk(String paramString, JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = paramJSONObject;
      if (paramJSONObject == null) {
        paramString = new JSONObject();
      }
      return paramString;
    }
    if (paramJSONObject == null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        paramJSONObject = localJSONObject;
        label63:
        for (;;) {}
      }
      catch (Exception paramString)
      {
        try
        {
          paramJSONObject.put("errMsg", paramString + ":ok");
          for (;;)
          {
            return paramJSONObject;
            paramString = paramString;
          }
        }
        catch (Exception paramString)
        {
          break label63;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.util.ApiUtil
 * JD-Core Version:    0.7.0.1
 */