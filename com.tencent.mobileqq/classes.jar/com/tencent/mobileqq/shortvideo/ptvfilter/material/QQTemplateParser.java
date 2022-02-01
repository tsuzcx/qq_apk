package com.tencent.mobileqq.shortvideo.ptvfilter.material;

import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.ttpic.util.DecryptListener;

public class QQTemplateParser
{
  private static final DecryptListener decryptListener = new QQTemplateParser.1();
  
  /* Error */
  public static MovieMaterial parseMovieMaterial(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 23	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: new 25	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   16: aload_1
    //   17: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 32
    //   22: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: astore 4
    //   33: aload 4
    //   35: invokevirtual 43	java/io/File:exists	()Z
    //   38: ifeq +11 -> 49
    //   41: aload 4
    //   43: invokevirtual 46	java/io/File:isDirectory	()Z
    //   46: ifeq +5 -> 51
    //   49: aconst_null
    //   50: areturn
    //   51: aload_0
    //   52: aload_1
    //   53: iconst_1
    //   54: getstatic 15	com/tencent/mobileqq/shortvideo/ptvfilter/material/QQTemplateParser:decryptListener	Lcom/tencent/ttpic/util/DecryptListener;
    //   57: invokestatic 52	com/tencent/ttpic/openapi/util/VideoTemplateParser:parseVideoMaterialFileAsJSONObject	(Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/ttpic/util/DecryptListener;)Lcom/google/gson/JsonObject;
    //   60: astore_0
    //   61: aload_0
    //   62: ifnull -13 -> 49
    //   65: aload_3
    //   66: astore_1
    //   67: aload_0
    //   68: ldc 54
    //   70: invokestatic 60	com/tencent/ttpic/util/GsonUtils:optJsonArray	(Lcom/google/gson/JsonObject;Ljava/lang/String;)Lcom/google/gson/JsonArray;
    //   73: astore 4
    //   75: aload 4
    //   77: ifnull +143 -> 220
    //   80: aload_3
    //   81: astore_1
    //   82: aload 4
    //   84: invokevirtual 66	com/google/gson/JsonArray:size	()I
    //   87: ifle +133 -> 220
    //   90: aload_3
    //   91: astore_1
    //   92: new 68	com/tencent/mobileqq/shortvideo/ptvfilter/material/MovieMaterial
    //   95: dup
    //   96: invokespecial 69	com/tencent/mobileqq/shortvideo/ptvfilter/material/MovieMaterial:<init>	()V
    //   99: astore_0
    //   100: aload 4
    //   102: iconst_0
    //   103: invokestatic 73	com/tencent/ttpic/util/GsonUtils:optJsonObject	(Lcom/google/gson/JsonArray;I)Lcom/google/gson/JsonObject;
    //   106: astore_1
    //   107: aload_0
    //   108: aload_1
    //   109: ldc 75
    //   111: iconst_0
    //   112: invokestatic 79	com/tencent/ttpic/util/GsonUtils:optBoolean	(Lcom/google/gson/JsonObject;Ljava/lang/String;Z)Z
    //   115: putfield 82	com/tencent/mobileqq/shortvideo/ptvfilter/material/MovieMaterial:isTouchable	Z
    //   118: aload_0
    //   119: aload_1
    //   120: ldc 84
    //   122: iconst_0
    //   123: invokestatic 79	com/tencent/ttpic/util/GsonUtils:optBoolean	(Lcom/google/gson/JsonObject;Ljava/lang/String;Z)Z
    //   126: putfield 86	com/tencent/mobileqq/shortvideo/ptvfilter/material/MovieMaterial:hasAtmosphere	Z
    //   129: aload_0
    //   130: aload_1
    //   131: ldc 88
    //   133: iconst_0
    //   134: invokestatic 79	com/tencent/ttpic/util/GsonUtils:optBoolean	(Lcom/google/gson/JsonObject;Ljava/lang/String;Z)Z
    //   137: putfield 90	com/tencent/mobileqq/shortvideo/ptvfilter/material/MovieMaterial:loopAtmosphere	Z
    //   140: aload_0
    //   141: aload_1
    //   142: ldc 92
    //   144: iconst_0
    //   145: invokestatic 79	com/tencent/ttpic/util/GsonUtils:optBoolean	(Lcom/google/gson/JsonObject;Ljava/lang/String;Z)Z
    //   148: putfield 94	com/tencent/mobileqq/shortvideo/ptvfilter/material/MovieMaterial:loopDoodle	Z
    //   151: aload_0
    //   152: aload_1
    //   153: ldc 96
    //   155: aconst_null
    //   156: invokestatic 100	com/tencent/ttpic/util/GsonUtils:optString	(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   159: putfield 103	com/tencent/mobileqq/shortvideo/ptvfilter/material/MovieMaterial:doodleName	Ljava/lang/String;
    //   162: aload_0
    //   163: aload_1
    //   164: ldc 105
    //   166: aconst_null
    //   167: invokestatic 100	com/tencent/ttpic/util/GsonUtils:optString	(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   170: putfield 107	com/tencent/mobileqq/shortvideo/ptvfilter/material/MovieMaterial:atmosphereName	Ljava/lang/String;
    //   173: aload_0
    //   174: aload_1
    //   175: ldc 109
    //   177: aconst_null
    //   178: invokestatic 100	com/tencent/ttpic/util/GsonUtils:optString	(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   181: putfield 112	com/tencent/mobileqq/shortvideo/ptvfilter/material/MovieMaterial:hintsImageName	Ljava/lang/String;
    //   184: aload_0
    //   185: aload_1
    //   186: ldc 114
    //   188: aconst_null
    //   189: invokestatic 100	com/tencent/ttpic/util/GsonUtils:optString	(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   192: putfield 116	com/tencent/mobileqq/shortvideo/ptvfilter/material/MovieMaterial:hintsContent	Ljava/lang/String;
    //   195: aload_0
    //   196: areturn
    //   197: astore_1
    //   198: aload_2
    //   199: astore_0
    //   200: aload_1
    //   201: astore_2
    //   202: aload_0
    //   203: astore_1
    //   204: aload_2
    //   205: invokevirtual 119	java/lang/Exception:printStackTrace	()V
    //   208: aload_0
    //   209: areturn
    //   210: astore_0
    //   211: aload_1
    //   212: areturn
    //   213: astore_1
    //   214: aload_0
    //   215: areturn
    //   216: astore_2
    //   217: goto -15 -> 202
    //   220: aconst_null
    //   221: astore_0
    //   222: goto -27 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	paramString1	String
    //   0	225	1	paramString2	String
    //   3	202	2	str	String
    //   216	1	2	localException	java.lang.Exception
    //   1	90	3	localObject1	Object
    //   31	70	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   67	75	197	java/lang/Exception
    //   82	90	197	java/lang/Exception
    //   92	100	197	java/lang/Exception
    //   67	75	210	finally
    //   82	90	210	finally
    //   92	100	210	finally
    //   204	208	210	finally
    //   100	195	213	finally
    //   100	195	216	java/lang/Exception
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString1, String paramString2)
  {
    return VideoTemplateParser.parseVideoMaterial(paramString1, paramString2, true, decryptListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.material.QQTemplateParser
 * JD-Core Version:    0.7.0.1
 */