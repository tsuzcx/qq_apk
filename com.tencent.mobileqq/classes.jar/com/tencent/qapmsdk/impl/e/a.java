package com.tencent.qapmsdk.impl.e;

import android.os.Handler;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.impl.instrumentation.j;
import com.tencent.qapmsdk.resource.meta.SingleItem;
import com.tencent.qapmsdk.resource.meta.TagItem;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class a
{
  static volatile boolean a = false;
  private static volatile a b;
  private final Vector<TagItem> c = new Vector();
  private final Vector<SingleItem> d = new Vector();
  
  public static a a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new a();
        }
      }
      finally {}
    }
    return b;
  }
  
  private JSONObject a(long paramLong, double paramDouble1, double paramDouble2, int paramInt, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("event_time", paramDouble1 / 1000.0D);
    localJSONObject.put("tag_id", paramLong);
    localJSONObject.put("during_time", paramDouble2);
    localJSONObject.put("type", paramInt);
    localJSONObject.put("stage", paramString1);
    localJSONObject.put("sub_stage", paramString2);
    localJSONObject.put("extra_info", "");
    localJSONObject.put("process_name", "");
    localJSONObject.put("is_slow", 0);
    return localJSONObject;
  }
  
  /* Error */
  public void a(double paramDouble1, double paramDouble2, double paramDouble3, long paramLong1, long paramLong2, j paramj)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore 21
    //   3: getstatic 79	com/tencent/qapmsdk/impl/g/b:e	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 85	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: ifeq +4 -> 13
    //   12: return
    //   13: aload 21
    //   15: getfield 27	com/tencent/qapmsdk/impl/e/a:d	Ljava/util/Vector;
    //   18: astore 20
    //   20: aload 20
    //   22: monitorenter
    //   23: iconst_m1
    //   24: istore 14
    //   26: aload 11
    //   28: ifnull +9 -> 37
    //   31: iconst_1
    //   32: istore 15
    //   34: goto +6 -> 40
    //   37: iconst_0
    //   38: istore 15
    //   40: aload 21
    //   42: getfield 27	com/tencent/qapmsdk/impl/e/a:d	Ljava/util/Vector;
    //   45: invokevirtual 89	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   48: astore 21
    //   50: aload 21
    //   52: invokeinterface 94 1 0
    //   57: ifeq +513 -> 570
    //   60: aload 21
    //   62: invokeinterface 98 1 0
    //   67: checkcast 100	com/tencent/qapmsdk/resource/meta/SingleItem
    //   70: astore 22
    //   72: iload 14
    //   74: iconst_1
    //   75: iadd
    //   76: istore 14
    //   78: getstatic 103	com/tencent/qapmsdk/impl/g/b:a	Ljava/util/List;
    //   81: aload 22
    //   83: getfield 106	com/tencent/qapmsdk/resource/meta/SingleItem:stage	Ljava/lang/String;
    //   86: invokeinterface 112 2 0
    //   91: ifne +6 -> 97
    //   94: goto -44 -> 50
    //   97: new 34	org/json/JSONObject
    //   100: dup
    //   101: aload 22
    //   103: getfield 115	com/tencent/qapmsdk/resource/meta/SingleItem:extraData	Ljava/lang/String;
    //   106: invokespecial 118	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   109: astore 23
    //   111: aload 23
    //   113: ldc 120
    //   115: invokevirtual 124	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   118: astore 24
    //   120: iconst_0
    //   121: istore 16
    //   123: aload 24
    //   125: invokevirtual 130	org/json/JSONArray:length	()I
    //   128: istore 17
    //   130: iload 16
    //   132: iload 17
    //   134: if_icmpge +428 -> 562
    //   137: aload 24
    //   139: iload 16
    //   141: invokevirtual 134	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   144: astore 21
    //   146: aload 21
    //   148: ldc 52
    //   150: invokevirtual 138	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   153: istore 17
    //   155: iload 17
    //   157: iconst_1
    //   158: if_icmpne +387 -> 545
    //   161: dload_1
    //   162: dconst_0
    //   163: dcmpl
    //   164: ifeq +398 -> 562
    //   167: iload 15
    //   169: ifne +359 -> 528
    //   172: lload 9
    //   174: l2d
    //   175: dstore 12
    //   177: dload 12
    //   179: invokestatic 144	java/lang/Double:isNaN	(D)Z
    //   182: pop
    //   183: aload 21
    //   185: ldc 50
    //   187: dload 12
    //   189: dload_1
    //   190: dsub
    //   191: dconst_1
    //   192: dmul
    //   193: invokevirtual 43	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   196: pop
    //   197: dload 12
    //   199: invokestatic 144	java/lang/Double:isNaN	(D)Z
    //   202: pop
    //   203: dload 12
    //   205: ldc2_w 38
    //   208: ddiv
    //   209: dstore_1
    //   210: aload 21
    //   212: ldc 37
    //   214: dload_1
    //   215: invokevirtual 43	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   218: pop
    //   219: aload 24
    //   221: iload 16
    //   223: aload 21
    //   225: invokevirtual 147	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   228: pop
    //   229: goto +3 -> 232
    //   232: iload 15
    //   234: ifeq +17 -> 251
    //   237: aload 11
    //   239: getfield 152	com/tencent/qapmsdk/impl/instrumentation/j:e	J
    //   242: lstore 18
    //   244: lload 18
    //   246: l2d
    //   247: dstore_1
    //   248: goto +6 -> 254
    //   251: dload 5
    //   253: dstore_1
    //   254: iload 15
    //   256: ifeq +13 -> 269
    //   259: aload 11
    //   261: getfield 155	com/tencent/qapmsdk/impl/instrumentation/j:h	Ljava/lang/String;
    //   264: astore 21
    //   266: goto +7 -> 273
    //   269: ldc 157
    //   271: astore 21
    //   273: aload 24
    //   275: aload_0
    //   276: lload 7
    //   278: dload_1
    //   279: dconst_0
    //   280: iconst_0
    //   281: ldc 159
    //   283: aload 21
    //   285: invokespecial 161	com/tencent/qapmsdk/impl/e/a:a	(JDDILjava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;
    //   288: invokevirtual 164	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   291: pop
    //   292: iload 15
    //   294: ifeq +237 -> 531
    //   297: aload 11
    //   299: getfield 167	com/tencent/qapmsdk/impl/instrumentation/j:f	J
    //   302: l2d
    //   303: dstore_1
    //   304: goto +3 -> 307
    //   307: iload 15
    //   309: ifeq +28 -> 337
    //   312: aload 11
    //   314: getfield 167	com/tencent/qapmsdk/impl/instrumentation/j:f	J
    //   317: lstore 9
    //   319: aload 11
    //   321: getfield 152	com/tencent/qapmsdk/impl/instrumentation/j:e	J
    //   324: lstore 18
    //   326: lload 9
    //   328: lload 18
    //   330: lsub
    //   331: l2d
    //   332: dstore 5
    //   334: goto +21 -> 355
    //   337: lload 9
    //   339: l2d
    //   340: dstore 12
    //   342: dload 12
    //   344: invokestatic 144	java/lang/Double:isNaN	(D)Z
    //   347: pop
    //   348: dload 12
    //   350: dload 5
    //   352: dsub
    //   353: dstore 5
    //   355: iload 15
    //   357: ifeq +181 -> 538
    //   360: aload 11
    //   362: getfield 155	com/tencent/qapmsdk/impl/instrumentation/j:h	Ljava/lang/String;
    //   365: astore 11
    //   367: goto +3 -> 370
    //   370: aload 24
    //   372: aload_0
    //   373: lload 7
    //   375: dload_1
    //   376: dload 5
    //   378: iconst_1
    //   379: ldc 159
    //   381: aload 11
    //   383: invokespecial 161	com/tencent/qapmsdk/impl/e/a:a	(JDDILjava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;
    //   386: invokevirtual 164	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   389: pop
    //   390: goto +3 -> 393
    //   393: aload 20
    //   395: astore 21
    //   397: iconst_1
    //   398: istore 15
    //   400: dload_3
    //   401: dconst_0
    //   402: dcmpl
    //   403: ifeq +9 -> 412
    //   406: aload 22
    //   408: dload_3
    //   409: putfield 171	com/tencent/qapmsdk/resource/meta/SingleItem:costTime	D
    //   412: aload 22
    //   414: aload 23
    //   416: invokevirtual 175	org/json/JSONObject:toString	()Ljava/lang/String;
    //   419: putfield 115	com/tencent/qapmsdk/resource/meta/SingleItem:extraData	Ljava/lang/String;
    //   422: aload_0
    //   423: getfield 27	com/tencent/qapmsdk/impl/e/a:d	Ljava/util/Vector;
    //   426: iload 14
    //   428: aload 22
    //   430: invokevirtual 179	java/util/Vector:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   433: pop
    //   434: goto +3 -> 437
    //   437: iconst_1
    //   438: istore 15
    //   440: aload 20
    //   442: astore 21
    //   444: aload 20
    //   446: monitorexit
    //   447: return
    //   448: iload 14
    //   450: istore 15
    //   452: aload 20
    //   454: astore 21
    //   456: aload 20
    //   458: monitorexit
    //   459: aload 11
    //   461: athrow
    //   462: astore 11
    //   464: iload 15
    //   466: istore 14
    //   468: aload 21
    //   470: astore 20
    //   472: goto -24 -> 448
    //   475: iconst_1
    //   476: istore 14
    //   478: getstatic 185	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   481: astore 11
    //   483: iconst_2
    //   484: anewarray 187	java/lang/String
    //   487: astore 20
    //   489: aload 20
    //   491: iconst_0
    //   492: ldc 189
    //   494: aastore
    //   495: aload 20
    //   497: iload 14
    //   499: ldc 191
    //   501: aastore
    //   502: aload 11
    //   504: aload 20
    //   506: invokevirtual 194	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   509: return
    //   510: astore 11
    //   512: goto -37 -> 475
    //   515: astore 11
    //   517: goto -39 -> 478
    //   520: astore 11
    //   522: iconst_1
    //   523: istore 14
    //   525: goto -77 -> 448
    //   528: goto -296 -> 232
    //   531: lload 9
    //   533: l2d
    //   534: dstore_1
    //   535: goto -228 -> 307
    //   538: ldc 157
    //   540: astore 11
    //   542: goto -172 -> 370
    //   545: iload 16
    //   547: iconst_1
    //   548: iadd
    //   549: istore 16
    //   551: goto -428 -> 123
    //   554: astore 11
    //   556: iconst_1
    //   557: istore 14
    //   559: goto -111 -> 448
    //   562: goto -169 -> 393
    //   565: astore 11
    //   567: goto -11 -> 556
    //   570: goto -133 -> 437
    //   573: astore 11
    //   575: iconst_1
    //   576: istore 14
    //   578: goto -130 -> 448
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	581	0	this	a
    //   0	581	1	paramDouble1	double
    //   0	581	3	paramDouble2	double
    //   0	581	5	paramDouble3	double
    //   0	581	7	paramLong1	long
    //   0	581	9	paramLong2	long
    //   0	581	11	paramj	j
    //   175	174	12	d1	double
    //   24	553	14	i	int
    //   32	433	15	j	int
    //   121	429	16	k	int
    //   128	31	17	m	int
    //   242	87	18	l	long
    //   18	487	20	localObject1	Object
    //   1	468	21	localObject2	Object
    //   70	359	22	localSingleItem	SingleItem
    //   109	306	23	localJSONObject	JSONObject
    //   118	253	24	localJSONArray	org.json.JSONArray
    // Exception table:
    //   from	to	target	type
    //   422	434	462	finally
    //   444	447	462	finally
    //   456	459	462	finally
    //   3	12	510	java/lang/Exception
    //   13	23	510	java/lang/Exception
    //   459	462	515	java/lang/Exception
    //   183	197	520	finally
    //   210	229	520	finally
    //   237	244	520	finally
    //   259	266	520	finally
    //   137	155	554	finally
    //   273	292	565	finally
    //   297	304	565	finally
    //   312	326	565	finally
    //   360	367	565	finally
    //   370	390	565	finally
    //   406	412	565	finally
    //   412	422	565	finally
    //   40	50	573	finally
    //   50	72	573	finally
    //   78	94	573	finally
    //   97	120	573	finally
    //   123	130	573	finally
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, boolean paramBoolean)
  {
    long l = paramLong3 - paramLong2;
    if (l < 0L) {
      return;
    }
    synchronized (this.c)
    {
      TagItem localTagItem = new TagItem();
      localTagItem.duringTime = 0.0D;
      localTagItem.stage = paramString1;
      localTagItem.subStage = paramString2;
      localTagItem.extraInfo = "";
      double d1 = paramLong2;
      Double.isNaN(d1);
      d1 /= 1000.0D;
      localTagItem.eventTime = d1;
      localTagItem.tagId = paramLong1;
      localTagItem.type = 0;
      localTagItem.isSlow = paramBoolean;
      this.c.add(localTagItem);
      localTagItem = new TagItem();
      localTagItem.duringTime = l;
      localTagItem.stage = paramString1;
      localTagItem.subStage = paramString2;
      localTagItem.extraInfo = "";
      d1 = paramLong3;
      Double.isNaN(d1);
      d1 /= 1000.0D;
      localTagItem.eventTime = d1;
      localTagItem.tagId = paramLong1;
      localTagItem.isSlow = paramBoolean;
      localTagItem.type = 1;
      this.c.add(localTagItem);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    synchronized (this.d)
    {
      SingleItem localSingleItem = new SingleItem();
      localSingleItem.costTime = paramLong1;
      localSingleItem.stage = paramString1;
      localSingleItem.extraData = paramString2;
      localSingleItem.eventTime = paramLong2;
      this.d.add(localSingleItem);
      return;
    }
  }
  
  public void a(long paramLong, j paramj)
  {
    if (com.tencent.qapmsdk.impl.g.b.e.get()) {
      return;
    }
    localVector = this.c;
    int j = -1;
    int i;
    if (paramj != null) {
      i = 1;
    } else {
      i = 0;
    }
    do
    {
      try
      {
        localObject = this.c.iterator();
        d2 = 0.0D;
        l1 = 0L;
        d1 = 0.0D;
      }
      finally
      {
        for (;;)
        {
          long l1;
          double d1;
          TagItem localTagItem;
          int k;
          double d4;
          for (;;)
          {
            throw paramj;
          }
          double d3 = 0.0D;
          continue;
          long l2 = d2;
          continue;
          long l3 = paramLong;
          continue;
          Object localObject = "LAUNCH_END_BY_USER";
          continue;
          boolean bool = false;
          continue;
          double d2 = 0.0D;
          d3 = d2;
          continue;
          continue;
          d2 = 0.0D;
          d3 = d2;
        }
      }
      if (!((Iterator)localObject).hasNext()) {
        break label396;
      }
      localTagItem = (TagItem)((Iterator)localObject).next();
      j += 1;
    } while (!com.tencent.qapmsdk.impl.g.b.a.contains(localTagItem.subStage));
    if (localTagItem.type == 0)
    {
      d1 = localTagItem.eventTime * 1000.0D;
      l1 = localTagItem.tagId;
    }
    k = localTagItem.type;
    if (k == 1) {
      if (d1 != 0.0D) {
        if (i == 0)
        {
          d4 = paramLong;
          Double.isNaN(d4);
          d3 = (d4 - d1) * 1.0D;
          d2 = localTagItem.eventTime;
          localTagItem.duringTime = d3;
          Double.isNaN(d4);
          d4 /= 1000.0D;
          localTagItem.eventTime = d4;
          this.c.set(j, localTagItem);
          d2 *= 1000.0D;
          if (i == 0) {
            break label356;
          }
          l2 = paramj.e;
          if (i == 0) {
            break label364;
          }
          l3 = paramj.f;
          if (i == 0) {
            break label370;
          }
          localObject = paramj.h;
          if (d3 <= PluginCombination.startUpPlugin.threshold) {
            break label377;
          }
          bool = true;
          a(l1, l2, l3, "QAPM_APPLAUNCH", (String)localObject, bool);
          d4 = d2;
          d2 = d3;
          d3 = d4;
          a(d1, d2, d3, l1, paramLong, paramj);
        }
      }
    }
  }
  
  Vector<TagItem> b()
  {
    return this.c;
  }
  
  Vector<SingleItem> c()
  {
    return this.d;
  }
  
  public void d()
  {
    if (!a)
    {
      new Handler(ThreadManager.getMonitorThreadLooper()).postDelayed(b.a(), 20000L);
      a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.e.a
 * JD-Core Version:    0.7.0.1
 */