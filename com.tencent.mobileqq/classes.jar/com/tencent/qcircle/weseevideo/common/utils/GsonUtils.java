package com.tencent.qcircle.weseevideo.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.tencent.qcircle.tavcut.util.Logger;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.List;

public class GsonUtils
{
  private static Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().serializeNulls().create();
  
  public static <T> T json2Obj(String paramString, Type paramType)
  {
    try
    {
      paramString = new GsonUtils.ProxyJsonReader(new StringReader(paramString));
      paramString.setLenient(false);
      paramString = gson.fromJson(paramString, paramType);
      return paramString;
    }
    catch (Exception paramString)
    {
      Logger.e(paramString);
    }
    return null;
  }
  
  /* Error */
  public static <T> List<T> json2ObjList(String paramString, Type paramType)
  {
    // Byte code:
    //   0: new 66	com/google/gson/JsonParser
    //   3: dup
    //   4: invokespecial 67	com/google/gson/JsonParser:<init>	()V
    //   7: aload_0
    //   8: invokevirtual 71	com/google/gson/JsonParser:parse	(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    //   11: invokevirtual 77	com/google/gson/JsonElement:getAsJsonArray	()Lcom/google/gson/JsonArray;
    //   14: astore 5
    //   16: new 79	java/util/ArrayList
    //   19: dup
    //   20: invokespecial 80	java/util/ArrayList:<init>	()V
    //   23: astore_0
    //   24: iconst_0
    //   25: istore_2
    //   26: aload 5
    //   28: invokevirtual 86	com/google/gson/JsonArray:size	()I
    //   31: istore_3
    //   32: aload_0
    //   33: astore 4
    //   35: iload_2
    //   36: iload_3
    //   37: if_icmpge +44 -> 81
    //   40: aload_0
    //   41: getstatic 26	com/tencent/qcircle/weseevideo/common/utils/GsonUtils:gson	Lcom/google/gson/Gson;
    //   44: aload 5
    //   46: iload_2
    //   47: invokevirtual 90	com/google/gson/JsonArray:get	(I)Lcom/google/gson/JsonElement;
    //   50: aload_1
    //   51: invokevirtual 93	com/google/gson/Gson:fromJson	(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   54: invokeinterface 99 2 0
    //   59: pop
    //   60: iload_2
    //   61: iconst_1
    //   62: iadd
    //   63: istore_2
    //   64: goto -32 -> 32
    //   67: astore_1
    //   68: goto +6 -> 74
    //   71: astore_1
    //   72: aconst_null
    //   73: astore_0
    //   74: aload_1
    //   75: invokestatic 60	com/tencent/qcircle/tavcut/util/Logger:e	(Ljava/lang/Throwable;)V
    //   78: aload_0
    //   79: astore 4
    //   81: aload 4
    //   83: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramString	String
    //   0	84	1	paramType	Type
    //   25	39	2	i	int
    //   31	7	3	j	int
    //   33	49	4	str	String
    //   14	31	5	localJsonArray	com.google.gson.JsonArray
    // Exception table:
    //   from	to	target	type
    //   26	32	67	java/lang/Exception
    //   40	60	67	java/lang/Exception
    //   0	24	71	java/lang/Exception
  }
  
  public static <T> String obj2Json(T paramT)
  {
    try
    {
      paramT = gson.toJson(paramT);
      return paramT;
    }
    catch (Exception paramT)
    {
      Logger.e(paramT);
    }
    return null;
  }
  
  public static <T> String objList2Json(List<T> paramList)
  {
    try
    {
      paramList = gson.toJson(paramList);
      return paramList;
    }
    catch (Exception paramList)
    {
      Logger.e(paramList);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.common.utils.GsonUtils
 * JD-Core Version:    0.7.0.1
 */