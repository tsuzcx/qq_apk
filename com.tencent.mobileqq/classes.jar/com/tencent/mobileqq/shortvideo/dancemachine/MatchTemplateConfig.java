package com.tencent.mobileqq.shortvideo.dancemachine;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MatchTemplateConfig
{
  public int checkMethod;
  public int datumIndex0;
  public int datumIndex1;
  public float degreeThreshold;
  public float distanceThreshold;
  public List<MatchTemplateConfig.KeyPoint> keyPoints;
  public List<MatchTemplateConfig.KeyVector> keyVectors;
  
  /* Error */
  public static MatchTemplateConfig parseConfig(java.lang.String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 2	com/tencent/mobileqq/shortvideo/dancemachine/MatchTemplateConfig
    //   6: dup
    //   7: invokespecial 26	com/tencent/mobileqq/shortvideo/dancemachine/MatchTemplateConfig:<init>	()V
    //   10: astore_2
    //   11: new 28	org/json/JSONObject
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 31	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   19: astore_0
    //   20: aload_2
    //   21: aload_0
    //   22: ldc 32
    //   24: ldc2_w 33
    //   27: invokevirtual 38	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   30: d2f
    //   31: putfield 40	com/tencent/mobileqq/shortvideo/dancemachine/MatchTemplateConfig:distanceThreshold	F
    //   34: aload_2
    //   35: aload_0
    //   36: ldc 41
    //   38: ldc2_w 33
    //   41: invokevirtual 38	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   44: d2f
    //   45: putfield 43	com/tencent/mobileqq/shortvideo/dancemachine/MatchTemplateConfig:degreeThreshold	F
    //   48: aload_2
    //   49: aload_0
    //   50: ldc 44
    //   52: iconst_m1
    //   53: invokevirtual 48	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   56: putfield 50	com/tencent/mobileqq/shortvideo/dancemachine/MatchTemplateConfig:checkMethod	I
    //   59: aload_0
    //   60: ldc 52
    //   62: invokevirtual 56	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   65: astore_3
    //   66: aload_2
    //   67: aload_3
    //   68: iconst_0
    //   69: invokevirtual 62	org/json/JSONArray:getInt	(I)I
    //   72: putfield 64	com/tencent/mobileqq/shortvideo/dancemachine/MatchTemplateConfig:datumIndex0	I
    //   75: aload_2
    //   76: aload_3
    //   77: iconst_1
    //   78: invokevirtual 62	org/json/JSONArray:getInt	(I)I
    //   81: putfield 66	com/tencent/mobileqq/shortvideo/dancemachine/MatchTemplateConfig:datumIndex1	I
    //   84: aload_0
    //   85: ldc 67
    //   87: invokevirtual 70	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   90: astore_3
    //   91: aload_3
    //   92: ifnull +137 -> 229
    //   95: aload_2
    //   96: new 72	java/util/ArrayList
    //   99: dup
    //   100: invokespecial 73	java/util/ArrayList:<init>	()V
    //   103: putfield 75	com/tencent/mobileqq/shortvideo/dancemachine/MatchTemplateConfig:keyPoints	Ljava/util/List;
    //   106: iconst_0
    //   107: istore_1
    //   108: iload_1
    //   109: aload_3
    //   110: invokevirtual 79	org/json/JSONArray:length	()I
    //   113: if_icmpge +116 -> 229
    //   116: aload_3
    //   117: iload_1
    //   118: invokevirtual 83	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   121: checkcast 28	org/json/JSONObject
    //   124: astore 5
    //   126: new 85	com/tencent/mobileqq/shortvideo/dancemachine/MatchTemplateConfig$KeyPoint
    //   129: dup
    //   130: invokespecial 86	com/tencent/mobileqq/shortvideo/dancemachine/MatchTemplateConfig$KeyPoint:<init>	()V
    //   133: astore 4
    //   135: aload 4
    //   137: aload 5
    //   139: ldc 88
    //   141: invokevirtual 91	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   144: putfield 93	com/tencent/mobileqq/shortvideo/dancemachine/MatchTemplateConfig$KeyPoint:index	I
    //   147: aload 4
    //   149: aload 5
    //   151: ldc 95
    //   153: invokevirtual 98	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   156: d2f
    //   157: putfield 100	com/tencent/mobileqq/shortvideo/dancemachine/MatchTemplateConfig$KeyPoint:weight	F
    //   160: aload 4
    //   162: aload 5
    //   164: ldc 102
    //   166: invokevirtual 98	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   169: d2f
    //   170: putfield 104	com/tencent/mobileqq/shortvideo/dancemachine/MatchTemplateConfig$KeyPoint:threshold	F
    //   173: aload 5
    //   175: ldc 106
    //   177: invokevirtual 70	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   180: astore 5
    //   182: aload 4
    //   184: iconst_2
    //   185: newarray float
    //   187: dup
    //   188: iconst_0
    //   189: aload 5
    //   191: iconst_0
    //   192: invokevirtual 110	org/json/JSONArray:getDouble	(I)D
    //   195: d2f
    //   196: fastore
    //   197: dup
    //   198: iconst_1
    //   199: aload 5
    //   201: iconst_1
    //   202: invokevirtual 110	org/json/JSONArray:getDouble	(I)D
    //   205: d2f
    //   206: fastore
    //   207: putfield 114	com/tencent/mobileqq/shortvideo/dancemachine/MatchTemplateConfig$KeyPoint:coords	[F
    //   210: aload_2
    //   211: getfield 75	com/tencent/mobileqq/shortvideo/dancemachine/MatchTemplateConfig:keyPoints	Ljava/util/List;
    //   214: aload 4
    //   216: invokeinterface 120 2 0
    //   221: pop
    //   222: iload_1
    //   223: iconst_1
    //   224: iadd
    //   225: istore_1
    //   226: goto -118 -> 108
    //   229: aload_0
    //   230: ldc 121
    //   232: invokevirtual 70	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   235: astore_0
    //   236: aload_0
    //   237: ifnull +117 -> 354
    //   240: aload_2
    //   241: new 72	java/util/ArrayList
    //   244: dup
    //   245: invokespecial 73	java/util/ArrayList:<init>	()V
    //   248: putfield 123	com/tencent/mobileqq/shortvideo/dancemachine/MatchTemplateConfig:keyVectors	Ljava/util/List;
    //   251: iconst_0
    //   252: istore_1
    //   253: iload_1
    //   254: aload_0
    //   255: invokevirtual 79	org/json/JSONArray:length	()I
    //   258: if_icmpge +96 -> 354
    //   261: aload_0
    //   262: iload_1
    //   263: invokevirtual 83	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   266: checkcast 28	org/json/JSONObject
    //   269: astore 4
    //   271: new 125	com/tencent/mobileqq/shortvideo/dancemachine/MatchTemplateConfig$KeyVector
    //   274: dup
    //   275: invokespecial 126	com/tencent/mobileqq/shortvideo/dancemachine/MatchTemplateConfig$KeyVector:<init>	()V
    //   278: astore_3
    //   279: aload_3
    //   280: aload 4
    //   282: ldc 95
    //   284: invokevirtual 98	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   287: d2f
    //   288: putfield 127	com/tencent/mobileqq/shortvideo/dancemachine/MatchTemplateConfig$KeyVector:weight	F
    //   291: aload_3
    //   292: aload 4
    //   294: ldc 102
    //   296: invokevirtual 91	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   299: putfield 129	com/tencent/mobileqq/shortvideo/dancemachine/MatchTemplateConfig$KeyVector:threshold	I
    //   302: aload 4
    //   304: ldc 131
    //   306: invokevirtual 70	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   309: astore 4
    //   311: aload_3
    //   312: iconst_2
    //   313: newarray int
    //   315: dup
    //   316: iconst_0
    //   317: aload 4
    //   319: iconst_0
    //   320: invokevirtual 62	org/json/JSONArray:getInt	(I)I
    //   323: iastore
    //   324: dup
    //   325: iconst_1
    //   326: aload 4
    //   328: iconst_1
    //   329: invokevirtual 62	org/json/JSONArray:getInt	(I)I
    //   332: iastore
    //   333: putfield 135	com/tencent/mobileqq/shortvideo/dancemachine/MatchTemplateConfig$KeyVector:vectors	[I
    //   336: aload_2
    //   337: getfield 123	com/tencent/mobileqq/shortvideo/dancemachine/MatchTemplateConfig:keyVectors	Ljava/util/List;
    //   340: aload_3
    //   341: invokeinterface 120 2 0
    //   346: pop
    //   347: iload_1
    //   348: iconst_1
    //   349: iadd
    //   350: istore_1
    //   351: goto -98 -> 253
    //   354: ldc 2
    //   356: monitorexit
    //   357: aload_2
    //   358: areturn
    //   359: astore_0
    //   360: goto +13 -> 373
    //   363: astore_0
    //   364: aload_0
    //   365: invokevirtual 138	java/lang/Exception:printStackTrace	()V
    //   368: ldc 2
    //   370: monitorexit
    //   371: aconst_null
    //   372: areturn
    //   373: ldc 2
    //   375: monitorexit
    //   376: goto +5 -> 381
    //   379: aload_0
    //   380: athrow
    //   381: goto -2 -> 379
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	paramString	java.lang.String
    //   107	244	1	i	int
    //   10	348	2	localMatchTemplateConfig	MatchTemplateConfig
    //   65	276	3	localObject1	Object
    //   133	194	4	localObject2	Object
    //   124	76	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   3	91	359	finally
    //   95	106	359	finally
    //   108	222	359	finally
    //   229	236	359	finally
    //   240	251	359	finally
    //   253	347	359	finally
    //   364	368	359	finally
    //   3	91	363	java/lang/Exception
    //   95	106	363	java/lang/Exception
    //   108	222	363	java/lang/Exception
    //   229	236	363	java/lang/Exception
    //   240	251	363	java/lang/Exception
    //   253	347	363	java/lang/Exception
  }
  
  public int[] getPointIndices()
  {
    Object localObject = this.keyPoints;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = new int[this.keyPoints.size()];
      int i = 0;
      while (i < this.keyPoints.size())
      {
        localObject[i] = ((MatchTemplateConfig.KeyPoint)this.keyPoints.get(i)).index;
        i += 1;
      }
      return localObject;
    }
    return null;
  }
  
  public JSONObject toJsonObject()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject = new JSONArray();
      ((JSONArray)localObject).put(this.datumIndex0);
      ((JSONArray)localObject).put(this.datumIndex1);
      localJSONObject.put("datumIndices", localObject);
      localJSONObject.put("distanceThreshold", this.distanceThreshold);
      localJSONObject.put("degreeThreshold", this.degreeThreshold);
      localJSONObject.put("checkMethod", this.checkMethod);
      localObject = this.keyPoints;
      int j = 0;
      int i;
      if (localObject != null)
      {
        localObject = new JSONArray();
        i = 0;
        while (i < this.keyPoints.size())
        {
          ((JSONArray)localObject).put(((MatchTemplateConfig.KeyPoint)this.keyPoints.get(i)).toJsonObject());
          i += 1;
        }
        localJSONObject.put("keyPoints", localObject);
      }
      if (this.keyVectors != null)
      {
        localObject = new JSONArray();
        i = j;
        while (i < this.keyVectors.size())
        {
          ((JSONArray)localObject).put(((MatchTemplateConfig.KeyVector)this.keyVectors.get(i)).toJsonObject());
          i += 1;
        }
        localJSONObject.put("keyVectors", this.keyPoints);
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.MatchTemplateConfig
 * JD-Core Version:    0.7.0.1
 */