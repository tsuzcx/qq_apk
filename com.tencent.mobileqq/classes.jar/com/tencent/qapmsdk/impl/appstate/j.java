package com.tencent.qapmsdk.impl.appstate;

import com.tencent.qapmsdk.impl.instrumentation.g;
import com.tencent.qapmsdk.impl.instrumentation.l.b;
import org.json.JSONObject;

public class j
{
  private g a;
  private long b = System.currentTimeMillis();
  private boolean c = false;
  private l.b d;
  private long e = 0L;
  private long f;
  
  j(g paramg, long paramLong, l.b paramb)
  {
    this.a = paramg;
    this.a.e = System.currentTimeMillis();
    this.a.c = 0;
    this.d = paramb;
    this.e = paramLong;
  }
  
  private JSONObject a(long paramLong, com.tencent.qapmsdk.impl.instrumentation.j paramj, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    long l;
    if (paramBoolean) {
      l = paramj.e;
    } else {
      l = paramj.f;
    }
    double d1 = l;
    Double.isNaN(d1);
    localJSONObject.put("event_time", d1 / 1000.0D);
    localJSONObject.put("tag_id", paramLong);
    if (paramBoolean) {
      paramLong = 0L;
    } else {
      paramLong = paramj.f - paramj.e;
    }
    localJSONObject.put("during_time", paramLong);
    localJSONObject.put("type", paramBoolean ^ true);
    localJSONObject.put("stage", paramj.g);
    localJSONObject.put("sub_stage", paramj.h);
    localJSONObject.put("extra_info", "");
    localJSONObject.put("process_name", "");
    localJSONObject.put("is_slow", 0);
    return localJSONObject;
  }
  
  j a()
  {
    if (this.c) {
      return null;
    }
    this.c = true;
    this.a.f = System.currentTimeMillis();
    this.f = this.a.f;
    return this;
  }
  
  void a(long paramLong)
  {
    this.a.e = paramLong;
    this.b = paramLong;
  }
  
  /* Error */
  void a(QAPMMonitorThreadLocal paramQAPMMonitorThreadLocal)
  {
    // Byte code:
    //   0: invokestatic 111	com/tencent/qapmsdk/impl/e/a:a	()Lcom/tencent/qapmsdk/impl/e/a;
    //   3: astore 12
    //   5: aload_0
    //   6: getfield 33	com/tencent/qapmsdk/impl/appstate/j:a	Lcom/tencent/qapmsdk/impl/instrumentation/g;
    //   9: getfield 101	com/tencent/qapmsdk/impl/instrumentation/g:f	J
    //   12: aload_0
    //   13: getfield 33	com/tencent/qapmsdk/impl/appstate/j:a	Lcom/tencent/qapmsdk/impl/instrumentation/g;
    //   16: getfield 36	com/tencent/qapmsdk/impl/instrumentation/g:e	J
    //   19: lsub
    //   20: lstore_2
    //   21: lload_2
    //   22: ldc2_w 112
    //   25: lcmp
    //   26: ifle +8 -> 34
    //   29: aload_1
    //   30: invokevirtual 117	com/tencent/qapmsdk/impl/appstate/QAPMMonitorThreadLocal:d	()V
    //   33: return
    //   34: aload_0
    //   35: getfield 33	com/tencent/qapmsdk/impl/appstate/j:a	Lcom/tencent/qapmsdk/impl/instrumentation/g;
    //   38: getfield 36	com/tencent/qapmsdk/impl/instrumentation/g:e	J
    //   41: lstore 4
    //   43: aload_0
    //   44: getfield 33	com/tencent/qapmsdk/impl/appstate/j:a	Lcom/tencent/qapmsdk/impl/instrumentation/g;
    //   47: getfield 36	com/tencent/qapmsdk/impl/instrumentation/g:e	J
    //   50: lstore 6
    //   52: aload_0
    //   53: getfield 33	com/tencent/qapmsdk/impl/appstate/j:a	Lcom/tencent/qapmsdk/impl/instrumentation/g;
    //   56: getfield 101	com/tencent/qapmsdk/impl/instrumentation/g:f	J
    //   59: lstore 8
    //   61: aload_0
    //   62: getfield 33	com/tencent/qapmsdk/impl/appstate/j:a	Lcom/tencent/qapmsdk/impl/instrumentation/g;
    //   65: getfield 118	com/tencent/qapmsdk/impl/instrumentation/g:g	Ljava/lang/String;
    //   68: astore 11
    //   70: aload_0
    //   71: getfield 33	com/tencent/qapmsdk/impl/appstate/j:a	Lcom/tencent/qapmsdk/impl/instrumentation/g;
    //   74: getfield 119	com/tencent/qapmsdk/impl/instrumentation/g:h	Ljava/lang/String;
    //   77: astore 13
    //   79: lload_2
    //   80: aload_0
    //   81: getfield 31	com/tencent/qapmsdk/impl/appstate/j:e	J
    //   84: lcmp
    //   85: ifle +9 -> 94
    //   88: iconst_1
    //   89: istore 10
    //   91: goto +6 -> 97
    //   94: iconst_0
    //   95: istore 10
    //   97: aload 12
    //   99: lload 4
    //   101: lload 6
    //   103: lload 8
    //   105: aload 11
    //   107: aload 13
    //   109: iload 10
    //   111: invokevirtual 122	com/tencent/qapmsdk/impl/e/a:a	(JJJLjava/lang/String;Ljava/lang/String;Z)V
    //   114: aload_1
    //   115: invokevirtual 125	com/tencent/qapmsdk/impl/appstate/QAPMMonitorThreadLocal:f	()Ljava/lang/ThreadLocal;
    //   118: invokevirtual 131	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   121: checkcast 133	java/util/Vector
    //   124: astore 13
    //   126: aload 13
    //   128: ifnull +82 -> 210
    //   131: aload 13
    //   133: invokevirtual 137	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   136: astore 11
    //   138: aload 11
    //   140: invokeinterface 143 1 0
    //   145: ifeq +65 -> 210
    //   148: aload 11
    //   150: invokeinterface 146 1 0
    //   155: checkcast 48	com/tencent/qapmsdk/impl/instrumentation/j
    //   158: astore 14
    //   160: aload 14
    //   162: getfield 91	com/tencent/qapmsdk/impl/instrumentation/j:h	Ljava/lang/String;
    //   165: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   168: ifeq +6 -> 174
    //   171: goto -33 -> 138
    //   174: aload 12
    //   176: aload_0
    //   177: getfield 33	com/tencent/qapmsdk/impl/appstate/j:a	Lcom/tencent/qapmsdk/impl/instrumentation/g;
    //   180: getfield 36	com/tencent/qapmsdk/impl/instrumentation/g:e	J
    //   183: aload 14
    //   185: getfield 49	com/tencent/qapmsdk/impl/instrumentation/j:e	J
    //   188: aload 14
    //   190: getfield 51	com/tencent/qapmsdk/impl/instrumentation/j:f	J
    //   193: aload 14
    //   195: getfield 83	com/tencent/qapmsdk/impl/instrumentation/j:g	Ljava/lang/String;
    //   198: aload 14
    //   200: getfield 91	com/tencent/qapmsdk/impl/instrumentation/j:h	Ljava/lang/String;
    //   203: iconst_0
    //   204: invokevirtual 122	com/tencent/qapmsdk/impl/e/a:a	(JJJLjava/lang/String;Ljava/lang/String;Z)V
    //   207: goto -69 -> 138
    //   210: new 154	org/json/JSONArray
    //   213: dup
    //   214: invokespecial 155	org/json/JSONArray:<init>	()V
    //   217: astore 11
    //   219: aload 11
    //   221: aload_0
    //   222: aload_0
    //   223: getfield 33	com/tencent/qapmsdk/impl/appstate/j:a	Lcom/tencent/qapmsdk/impl/instrumentation/g;
    //   226: getfield 36	com/tencent/qapmsdk/impl/instrumentation/g:e	J
    //   229: aload_0
    //   230: getfield 33	com/tencent/qapmsdk/impl/appstate/j:a	Lcom/tencent/qapmsdk/impl/instrumentation/g;
    //   233: iconst_1
    //   234: invokespecial 157	com/tencent/qapmsdk/impl/appstate/j:a	(JLcom/tencent/qapmsdk/impl/instrumentation/j;Z)Lorg/json/JSONObject;
    //   237: invokevirtual 160	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   240: pop
    //   241: aload_0
    //   242: getfield 33	com/tencent/qapmsdk/impl/appstate/j:a	Lcom/tencent/qapmsdk/impl/instrumentation/g;
    //   245: getfield 36	com/tencent/qapmsdk/impl/instrumentation/g:e	J
    //   248: lstore 4
    //   250: aload_0
    //   251: getfield 33	com/tencent/qapmsdk/impl/appstate/j:a	Lcom/tencent/qapmsdk/impl/instrumentation/g;
    //   254: astore 14
    //   256: aload 11
    //   258: aload_0
    //   259: lload 4
    //   261: aload 14
    //   263: iconst_0
    //   264: invokespecial 157	com/tencent/qapmsdk/impl/appstate/j:a	(JLcom/tencent/qapmsdk/impl/instrumentation/j;Z)Lorg/json/JSONObject;
    //   267: invokevirtual 160	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   270: pop
    //   271: aload 13
    //   273: ifnull +89 -> 362
    //   276: aload 13
    //   278: invokevirtual 137	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   281: astore 13
    //   283: aload 13
    //   285: invokeinterface 143 1 0
    //   290: ifeq +72 -> 362
    //   293: aload 13
    //   295: invokeinterface 146 1 0
    //   300: checkcast 48	com/tencent/qapmsdk/impl/instrumentation/j
    //   303: astore 14
    //   305: aload 14
    //   307: getfield 91	com/tencent/qapmsdk/impl/instrumentation/j:h	Ljava/lang/String;
    //   310: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   313: ifeq +6 -> 319
    //   316: goto -33 -> 283
    //   319: aload 11
    //   321: aload_0
    //   322: aload_0
    //   323: getfield 33	com/tencent/qapmsdk/impl/appstate/j:a	Lcom/tencent/qapmsdk/impl/instrumentation/g;
    //   326: getfield 36	com/tencent/qapmsdk/impl/instrumentation/g:e	J
    //   329: aload 14
    //   331: iconst_1
    //   332: invokespecial 157	com/tencent/qapmsdk/impl/appstate/j:a	(JLcom/tencent/qapmsdk/impl/instrumentation/j;Z)Lorg/json/JSONObject;
    //   335: invokevirtual 160	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   338: pop
    //   339: aload 11
    //   341: aload_0
    //   342: aload_0
    //   343: getfield 33	com/tencent/qapmsdk/impl/appstate/j:a	Lcom/tencent/qapmsdk/impl/instrumentation/g;
    //   346: getfield 36	com/tencent/qapmsdk/impl/instrumentation/g:e	J
    //   349: aload 14
    //   351: iconst_0
    //   352: invokespecial 157	com/tencent/qapmsdk/impl/appstate/j:a	(JLcom/tencent/qapmsdk/impl/instrumentation/j;Z)Lorg/json/JSONObject;
    //   355: invokevirtual 160	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   358: pop
    //   359: goto -76 -> 283
    //   362: new 45	org/json/JSONObject
    //   365: dup
    //   366: invokespecial 46	org/json/JSONObject:<init>	()V
    //   369: astore 13
    //   371: aload 13
    //   373: ldc 162
    //   375: aload 11
    //   377: invokevirtual 86	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   380: pop
    //   381: getstatic 167	com/tencent/qapmsdk/impl/g/b:a	Ljava/util/List;
    //   384: aload_0
    //   385: getfield 33	com/tencent/qapmsdk/impl/appstate/j:a	Lcom/tencent/qapmsdk/impl/instrumentation/g;
    //   388: getfield 119	com/tencent/qapmsdk/impl/instrumentation/g:h	Ljava/lang/String;
    //   391: invokeinterface 173 2 0
    //   396: ifeq +31 -> 427
    //   399: aload 12
    //   401: lload_2
    //   402: aload_0
    //   403: getfield 33	com/tencent/qapmsdk/impl/appstate/j:a	Lcom/tencent/qapmsdk/impl/instrumentation/g;
    //   406: getfield 36	com/tencent/qapmsdk/impl/instrumentation/g:e	J
    //   409: aload_0
    //   410: getfield 33	com/tencent/qapmsdk/impl/appstate/j:a	Lcom/tencent/qapmsdk/impl/instrumentation/g;
    //   413: getfield 119	com/tencent/qapmsdk/impl/instrumentation/g:h	Ljava/lang/String;
    //   416: aload 13
    //   418: invokevirtual 177	org/json/JSONObject:toString	()Ljava/lang/String;
    //   421: invokevirtual 180	com/tencent/qapmsdk/impl/e/a:a	(JJLjava/lang/String;Ljava/lang/String;)V
    //   424: goto +66 -> 490
    //   427: aload 12
    //   429: lload_2
    //   430: aload_0
    //   431: getfield 33	com/tencent/qapmsdk/impl/appstate/j:a	Lcom/tencent/qapmsdk/impl/instrumentation/g;
    //   434: getfield 36	com/tencent/qapmsdk/impl/instrumentation/g:e	J
    //   437: aload_0
    //   438: getfield 33	com/tencent/qapmsdk/impl/appstate/j:a	Lcom/tencent/qapmsdk/impl/instrumentation/g;
    //   441: getfield 118	com/tencent/qapmsdk/impl/instrumentation/g:g	Ljava/lang/String;
    //   444: aload 13
    //   446: invokevirtual 177	org/json/JSONObject:toString	()Ljava/lang/String;
    //   449: invokevirtual 180	com/tencent/qapmsdk/impl/e/a:a	(JJLjava/lang/String;Ljava/lang/String;)V
    //   452: goto +38 -> 490
    //   455: astore 11
    //   457: goto +5 -> 462
    //   460: astore 11
    //   462: getstatic 186	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   465: iconst_3
    //   466: anewarray 188	java/lang/String
    //   469: dup
    //   470: iconst_0
    //   471: ldc 190
    //   473: aastore
    //   474: dup
    //   475: iconst_1
    //   476: ldc 192
    //   478: aastore
    //   479: dup
    //   480: iconst_2
    //   481: aload 11
    //   483: invokevirtual 195	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   486: aastore
    //   487: invokevirtual 199	com/tencent/qapmsdk/common/logger/Logger:w	([Ljava/lang/String;)V
    //   490: aload 12
    //   492: invokevirtual 200	com/tencent/qapmsdk/impl/e/a:d	()V
    //   495: aload_1
    //   496: invokevirtual 117	com/tencent/qapmsdk/impl/appstate/QAPMMonitorThreadLocal:d	()V
    //   499: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	500	0	this	j
    //   0	500	1	paramQAPMMonitorThreadLocal	QAPMMonitorThreadLocal
    //   20	410	2	l1	long
    //   41	219	4	l2	long
    //   50	52	6	l3	long
    //   59	45	8	l4	long
    //   89	21	10	bool	boolean
    //   68	308	11	localObject1	Object
    //   455	1	11	localJSONException1	org.json.JSONException
    //   460	22	11	localJSONException2	org.json.JSONException
    //   3	488	12	locala	com.tencent.qapmsdk.impl.e.a
    //   77	368	13	localObject2	Object
    //   158	192	14	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   256	271	455	org/json/JSONException
    //   276	283	455	org/json/JSONException
    //   283	316	455	org/json/JSONException
    //   319	359	455	org/json/JSONException
    //   362	424	455	org/json/JSONException
    //   427	452	455	org/json/JSONException
    //   210	256	460	org/json/JSONException
  }
  
  void b(long paramLong)
  {
    this.a.f = paramLong;
    this.f = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.j
 * JD-Core Version:    0.7.0.1
 */