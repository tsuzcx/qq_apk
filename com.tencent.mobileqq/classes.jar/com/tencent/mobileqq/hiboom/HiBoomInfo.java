package com.tencent.mobileqq.hiboom;

import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class HiBoomInfo
{
  public String a;
  public String b;
  public String c;
  public List<HiBoomInfo.HiBoomInfoStyle> d;
  
  /* Error */
  public static HiBoomInfo a(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 2	com/tencent/mobileqq/hiboom/HiBoomInfo
    //   6: dup
    //   7: invokespecial 20	com/tencent/mobileqq/hiboom/HiBoomInfo:<init>	()V
    //   10: astore_1
    //   11: new 22	org/json/JSONObject
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 25	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   19: astore_0
    //   20: aload_1
    //   21: aload_0
    //   22: ldc 27
    //   24: invokevirtual 31	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   27: putfield 33	com/tencent/mobileqq/hiboom/HiBoomInfo:a	Ljava/lang/String;
    //   30: aload_1
    //   31: aload_0
    //   32: ldc 35
    //   34: invokevirtual 31	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   37: putfield 37	com/tencent/mobileqq/hiboom/HiBoomInfo:b	Ljava/lang/String;
    //   40: aload_1
    //   41: aload_0
    //   42: ldc 39
    //   44: invokevirtual 31	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   47: putfield 41	com/tencent/mobileqq/hiboom/HiBoomInfo:c	Ljava/lang/String;
    //   50: aload_0
    //   51: ldc 43
    //   53: invokevirtual 47	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   56: astore_0
    //   57: aload_1
    //   58: new 49	java/util/LinkedList
    //   61: dup
    //   62: invokespecial 50	java/util/LinkedList:<init>	()V
    //   65: putfield 52	com/tencent/mobileqq/hiboom/HiBoomInfo:d	Ljava/util/List;
    //   68: aload_0
    //   69: ifnull +8 -> 77
    //   72: aload_1
    //   73: aload_0
    //   74: invokestatic 55	com/tencent/mobileqq/hiboom/HiBoomInfo:a	(Lcom/tencent/mobileqq/hiboom/HiBoomInfo;Lorg/json/JSONArray;)V
    //   77: ldc 2
    //   79: monitorexit
    //   80: aload_1
    //   81: areturn
    //   82: astore_0
    //   83: ldc 2
    //   85: monitorexit
    //   86: aload_0
    //   87: athrow
    //   88: ldc 2
    //   90: monitorexit
    //   91: aconst_null
    //   92: areturn
    //   93: astore_0
    //   94: goto -6 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	paramString	String
    //   10	71	1	localHiBoomInfo	HiBoomInfo
    // Exception table:
    //   from	to	target	type
    //   3	68	82	finally
    //   72	77	82	finally
    //   3	68	93	java/lang/Exception
    //   72	77	93	java/lang/Exception
  }
  
  private static void a(HiBoomInfo.HiBoomInfoStyle paramHiBoomInfoStyle, JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.getJSONObject(i);
        HiBoomInfo.HiBoomInfoStyleWord localHiBoomInfoStyleWord = new HiBoomInfo.HiBoomInfoStyleWord();
        localHiBoomInfoStyleWord.d = ((JSONObject)localObject).optString("word_background_color");
        localHiBoomInfoStyleWord.a = ((JSONObject)localObject).optInt("word_index");
        localHiBoomInfoStyleWord.h = ((JSONObject)localObject).optInt("word_rotation");
        localHiBoomInfoStyleWord.i = ((JSONObject)localObject).optString("word_stroke_color");
        localHiBoomInfoStyleWord.j = ((JSONObject)localObject).optInt("word_stroke_line_width");
        localHiBoomInfoStyleWord.b = ((JSONObject)localObject).optString("word_text");
        localHiBoomInfoStyleWord.c = ((JSONObject)localObject).optString("word_text_color");
        localHiBoomInfoStyleWord.g = new int[2];
        JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("word_position");
        if ((localJSONArray != null) && (localJSONArray.length() == 2))
        {
          localHiBoomInfoStyleWord.g[0] = localJSONArray.getInt(0);
          localHiBoomInfoStyleWord.g[1] = localJSONArray.getInt(1);
        }
        localHiBoomInfoStyleWord.e = new int[2];
        localJSONArray = ((JSONObject)localObject).optJSONArray("word_size");
        if ((localJSONArray != null) && (localJSONArray.length() == 2))
        {
          localHiBoomInfoStyleWord.e[0] = localJSONArray.getInt(0);
          localHiBoomInfoStyleWord.e[1] = localJSONArray.getInt(1);
        }
        localObject = ((JSONObject)localObject).optJSONArray("word_color_rect");
        if ((localObject != null) && (((JSONArray)localObject).length() == 4))
        {
          localHiBoomInfoStyleWord.f = new int[4];
          localHiBoomInfoStyleWord.f[0] = ((JSONArray)localObject).getInt(0);
          localHiBoomInfoStyleWord.f[1] = ((JSONArray)localObject).getInt(1);
          localHiBoomInfoStyleWord.f[2] = ((JSONArray)localObject).getInt(2);
          localHiBoomInfoStyleWord.f[3] = ((JSONArray)localObject).getInt(3);
        }
        paramHiBoomInfoStyle.h.add(localHiBoomInfoStyleWord);
        i += 1;
      }
    }
  }
  
  private static void a(HiBoomInfo paramHiBoomInfo, JSONArray paramJSONArray)
  {
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      HiBoomInfo.HiBoomInfoStyle localHiBoomInfoStyle = new HiBoomInfo.HiBoomInfoStyle();
      localHiBoomInfoStyle.f = localJSONObject.optInt("word_count");
      localHiBoomInfoStyle.c = localJSONObject.optString("style_background_color");
      localHiBoomInfoStyle.a = localJSONObject.optString("style_name");
      localHiBoomInfoStyle.b = localJSONObject.optString("style_pic");
      localHiBoomInfoStyle.d = localJSONObject.optString("style_text_color");
      JSONArray localJSONArray = localJSONObject.optJSONArray("style_size");
      localHiBoomInfoStyle.e = new int[2];
      if ((localJSONArray != null) && (localJSONArray.length() == 2))
      {
        localHiBoomInfoStyle.e[0] = localJSONArray.getInt(0);
        localHiBoomInfoStyle.e[1] = localJSONArray.getInt(1);
      }
      localHiBoomInfoStyle.g = new LinkedList();
      b(localHiBoomInfoStyle, localJSONObject.optJSONArray("word_images"));
      localHiBoomInfoStyle.h = new LinkedList();
      a(localHiBoomInfoStyle, localJSONObject.optJSONArray("words"));
      paramHiBoomInfo.d.add(localHiBoomInfoStyle);
      i += 1;
    }
  }
  
  private static void b(HiBoomInfo.HiBoomInfoStyle paramHiBoomInfoStyle, JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.getJSONObject(i);
        HiBoomInfo.HiBoomInfoStyleImage localHiBoomInfoStyleImage = new HiBoomInfo.HiBoomInfoStyleImage();
        localHiBoomInfoStyleImage.a = ((JSONObject)localObject).optString("image_name");
        localHiBoomInfoStyleImage.d = ((JSONObject)localObject).optInt("image_rotation");
        localHiBoomInfoStyleImage.c = new int[2];
        JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("image_position");
        if ((localJSONArray != null) && (localJSONArray.length() == 2))
        {
          localHiBoomInfoStyleImage.c[0] = localJSONArray.getInt(0);
          localHiBoomInfoStyleImage.c[1] = localJSONArray.getInt(1);
        }
        localHiBoomInfoStyleImage.b = new int[2];
        localObject = ((JSONObject)localObject).optJSONArray("image_size");
        if ((localObject != null) && (((JSONArray)localObject).length() == 2))
        {
          localHiBoomInfoStyleImage.b[0] = ((JSONArray)localObject).getInt(0);
          localHiBoomInfoStyleImage.b[1] = ((JSONArray)localObject).getInt(1);
        }
        paramHiBoomInfoStyle.g.add(localHiBoomInfoStyleImage);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomInfo
 * JD-Core Version:    0.7.0.1
 */