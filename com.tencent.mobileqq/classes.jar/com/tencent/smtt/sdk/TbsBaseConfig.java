package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class TbsBaseConfig
{
  public static final String TAG = "TbsBaseConfig";
  Map<String, String> a;
  private Context b;
  
  private static File a(Context paramContext, String paramString)
  {
    p.a();
    paramContext = p.t(paramContext);
    if (paramContext == null) {
      return null;
    }
    paramContext = new File(paramContext, paramString);
    if (paramContext.exists()) {
      return paramContext;
    }
    try
    {
      paramContext.createNewFile();
      return paramContext;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public void clear()
  {
    this.a.clear();
    commit();
  }
  
  public void commit()
  {
    try
    {
      writeTbsDownloadInfo();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public abstract String getConfigFileName();
  
  public void init(Context paramContext)
  {
    this.a = new HashMap();
    this.b = paramContext.getApplicationContext();
    if (this.b == null) {
      this.b = paramContext;
    }
    refreshSyncMap(paramContext);
  }
  
  /* Error */
  public void refreshSyncMap(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 73	com/tencent/smtt/sdk/TbsBaseConfig:b	Landroid/content/Context;
    //   6: aload_0
    //   7: invokevirtual 82	com/tencent/smtt/sdk/TbsBaseConfig:getConfigFileName	()Ljava/lang/String;
    //   10: invokestatic 84	com/tencent/smtt/sdk/TbsBaseConfig:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: getfield 48	com/tencent/smtt/sdk/TbsBaseConfig:a	Ljava/util/Map;
    //   25: invokeinterface 52 1 0
    //   30: new 86	java/io/BufferedInputStream
    //   33: dup
    //   34: new 88	java/io/FileInputStream
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 91	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   42: invokespecial 94	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: astore_2
    //   46: aload_2
    //   47: astore_1
    //   48: new 96	java/util/Properties
    //   51: dup
    //   52: invokespecial 97	java/util/Properties:<init>	()V
    //   55: astore_3
    //   56: aload_2
    //   57: astore_1
    //   58: aload_3
    //   59: aload_2
    //   60: invokevirtual 100	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   63: aload_2
    //   64: astore_1
    //   65: aload_3
    //   66: invokevirtual 104	java/util/Properties:stringPropertyNames	()Ljava/util/Set;
    //   69: invokeinterface 110 1 0
    //   74: astore 4
    //   76: aload_2
    //   77: astore_1
    //   78: aload 4
    //   80: invokeinterface 115 1 0
    //   85: ifeq +40 -> 125
    //   88: aload_2
    //   89: astore_1
    //   90: aload 4
    //   92: invokeinterface 119 1 0
    //   97: checkcast 121	java/lang/String
    //   100: astore 5
    //   102: aload_2
    //   103: astore_1
    //   104: aload_0
    //   105: getfield 48	com/tencent/smtt/sdk/TbsBaseConfig:a	Ljava/util/Map;
    //   108: aload 5
    //   110: aload_3
    //   111: aload 5
    //   113: invokevirtual 125	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   116: invokeinterface 129 3 0
    //   121: pop
    //   122: goto -46 -> 76
    //   125: aload_2
    //   126: invokevirtual 132	java/io/BufferedInputStream:close	()V
    //   129: goto +49 -> 178
    //   132: astore_1
    //   133: aload_1
    //   134: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   137: goto +41 -> 178
    //   140: astore_3
    //   141: goto +12 -> 153
    //   144: astore_2
    //   145: aconst_null
    //   146: astore_1
    //   147: goto +35 -> 182
    //   150: astore_3
    //   151: aconst_null
    //   152: astore_2
    //   153: aload_2
    //   154: astore_1
    //   155: aload_3
    //   156: invokevirtual 134	java/lang/Throwable:printStackTrace	()V
    //   159: aload_2
    //   160: ifnull +18 -> 178
    //   163: aload_2
    //   164: invokevirtual 132	java/io/BufferedInputStream:close	()V
    //   167: goto +11 -> 178
    //   170: astore_1
    //   171: goto +29 -> 200
    //   174: astore_1
    //   175: goto -42 -> 133
    //   178: aload_0
    //   179: monitorexit
    //   180: return
    //   181: astore_2
    //   182: aload_1
    //   183: ifnull +15 -> 198
    //   186: aload_1
    //   187: invokevirtual 132	java/io/BufferedInputStream:close	()V
    //   190: goto +8 -> 198
    //   193: astore_1
    //   194: aload_1
    //   195: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   198: aload_2
    //   199: athrow
    //   200: aload_0
    //   201: monitorexit
    //   202: goto +5 -> 207
    //   205: aload_1
    //   206: athrow
    //   207: goto -2 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	TbsBaseConfig
    //   0	210	1	paramContext	Context
    //   45	81	2	localBufferedInputStream	java.io.BufferedInputStream
    //   144	1	2	localObject1	Object
    //   152	12	2	localObject2	Object
    //   181	18	2	localObject3	Object
    //   55	56	3	localProperties	java.util.Properties
    //   140	1	3	localThrowable1	java.lang.Throwable
    //   150	6	3	localThrowable2	java.lang.Throwable
    //   74	17	4	localIterator	java.util.Iterator
    //   100	12	5	str	String
    // Exception table:
    //   from	to	target	type
    //   125	129	132	java/lang/Exception
    //   48	56	140	java/lang/Throwable
    //   58	63	140	java/lang/Throwable
    //   65	76	140	java/lang/Throwable
    //   78	88	140	java/lang/Throwable
    //   90	102	140	java/lang/Throwable
    //   104	122	140	java/lang/Throwable
    //   2	14	144	finally
    //   21	46	144	finally
    //   2	14	150	java/lang/Throwable
    //   21	46	150	java/lang/Throwable
    //   125	129	170	finally
    //   133	137	170	finally
    //   163	167	170	finally
    //   186	190	170	finally
    //   194	198	170	finally
    //   198	200	170	finally
    //   163	167	174	java/lang/Exception
    //   48	56	181	finally
    //   58	63	181	finally
    //   65	76	181	finally
    //   78	88	181	finally
    //   90	102	181	finally
    //   104	122	181	finally
    //   155	159	181	finally
    //   186	190	193	java/lang/Exception
  }
  
  /* Error */
  public void writeTbsDownloadInfo()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 8
    //   4: ldc 136
    //   6: invokestatic 142	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aconst_null
    //   10: astore_2
    //   11: aconst_null
    //   12: astore 4
    //   14: aload_0
    //   15: getfield 73	com/tencent/smtt/sdk/TbsBaseConfig:b	Landroid/content/Context;
    //   18: aload_0
    //   19: invokevirtual 82	com/tencent/smtt/sdk/TbsBaseConfig:getConfigFileName	()Ljava/lang/String;
    //   22: invokestatic 84	com/tencent/smtt/sdk/TbsBaseConfig:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   25: astore_1
    //   26: aload_1
    //   27: ifnonnull +6 -> 33
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: new 86	java/io/BufferedInputStream
    //   36: dup
    //   37: new 88	java/io/FileInputStream
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 91	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: invokespecial 94	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: astore_3
    //   49: new 96	java/util/Properties
    //   52: dup
    //   53: invokespecial 97	java/util/Properties:<init>	()V
    //   56: astore 4
    //   58: aload 4
    //   60: aload_3
    //   61: invokevirtual 100	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   64: aload 4
    //   66: invokevirtual 143	java/util/Properties:clear	()V
    //   69: aload_0
    //   70: getfield 48	com/tencent/smtt/sdk/TbsBaseConfig:a	Ljava/util/Map;
    //   73: invokeinterface 146 1 0
    //   78: invokeinterface 110 1 0
    //   83: astore 5
    //   85: aload 5
    //   87: invokeinterface 115 1 0
    //   92: ifeq +120 -> 212
    //   95: aload 5
    //   97: invokeinterface 119 1 0
    //   102: checkcast 121	java/lang/String
    //   105: astore 6
    //   107: aload_0
    //   108: getfield 48	com/tencent/smtt/sdk/TbsBaseConfig:a	Ljava/util/Map;
    //   111: aload 6
    //   113: invokeinterface 150 2 0
    //   118: astore 7
    //   120: new 152	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   127: astore 8
    //   129: aload 8
    //   131: ldc 155
    //   133: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 8
    //   139: aload 7
    //   141: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 4
    //   147: aload 6
    //   149: aload 8
    //   151: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokevirtual 169	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   157: pop
    //   158: new 152	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   165: astore 8
    //   167: aload 8
    //   169: ldc 171
    //   171: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 8
    //   177: aload 6
    //   179: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 8
    //   185: ldc 173
    //   187: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload 8
    //   193: aload 7
    //   195: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: ldc 8
    //   201: aload 8
    //   203: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 142	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   209: goto -124 -> 85
    //   212: aload_0
    //   213: getfield 48	com/tencent/smtt/sdk/TbsBaseConfig:a	Ljava/util/Map;
    //   216: invokeinterface 52 1 0
    //   221: new 175	java/io/BufferedOutputStream
    //   224: dup
    //   225: new 177	java/io/FileOutputStream
    //   228: dup
    //   229: aload_1
    //   230: invokespecial 178	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   233: invokespecial 181	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   236: astore_1
    //   237: aload 4
    //   239: aload_1
    //   240: aconst_null
    //   241: invokevirtual 185	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   244: aload_3
    //   245: invokevirtual 132	java/io/BufferedInputStream:close	()V
    //   248: goto +8 -> 256
    //   251: astore_2
    //   252: aload_2
    //   253: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   256: aload_1
    //   257: invokevirtual 186	java/io/BufferedOutputStream:close	()V
    //   260: goto +82 -> 342
    //   263: astore_1
    //   264: aload_1
    //   265: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   268: goto +74 -> 342
    //   271: astore 4
    //   273: aload_1
    //   274: astore_2
    //   275: aload 4
    //   277: astore_1
    //   278: goto +74 -> 352
    //   281: astore_2
    //   282: goto +10 -> 292
    //   285: astore_1
    //   286: goto +66 -> 352
    //   289: astore_2
    //   290: aconst_null
    //   291: astore_1
    //   292: goto +15 -> 307
    //   295: astore_1
    //   296: aconst_null
    //   297: astore_3
    //   298: goto +54 -> 352
    //   301: astore_2
    //   302: aconst_null
    //   303: astore_1
    //   304: aload 4
    //   306: astore_3
    //   307: aload_2
    //   308: invokevirtual 134	java/lang/Throwable:printStackTrace	()V
    //   311: aload_3
    //   312: ifnull +15 -> 327
    //   315: aload_3
    //   316: invokevirtual 132	java/io/BufferedInputStream:close	()V
    //   319: goto +8 -> 327
    //   322: astore_2
    //   323: aload_2
    //   324: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   327: aload_1
    //   328: ifnull +14 -> 342
    //   331: aload_1
    //   332: invokevirtual 186	java/io/BufferedOutputStream:close	()V
    //   335: goto +7 -> 342
    //   338: astore_1
    //   339: goto -75 -> 264
    //   342: aload_0
    //   343: monitorexit
    //   344: return
    //   345: astore 4
    //   347: aload_1
    //   348: astore_2
    //   349: aload 4
    //   351: astore_1
    //   352: aload_3
    //   353: ifnull +15 -> 368
    //   356: aload_3
    //   357: invokevirtual 132	java/io/BufferedInputStream:close	()V
    //   360: goto +8 -> 368
    //   363: astore_3
    //   364: aload_3
    //   365: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   368: aload_2
    //   369: ifnull +15 -> 384
    //   372: aload_2
    //   373: invokevirtual 186	java/io/BufferedOutputStream:close	()V
    //   376: goto +8 -> 384
    //   379: astore_2
    //   380: aload_2
    //   381: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   384: aload_1
    //   385: athrow
    //   386: astore_1
    //   387: aload_0
    //   388: monitorexit
    //   389: goto +5 -> 394
    //   392: aload_1
    //   393: athrow
    //   394: goto -2 -> 392
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	TbsBaseConfig
    //   25	232	1	localObject1	Object
    //   263	11	1	localException1	java.lang.Exception
    //   277	1	1	localObject2	Object
    //   285	1	1	localObject3	Object
    //   291	1	1	localObject4	Object
    //   295	1	1	localObject5	Object
    //   303	29	1	localObject6	Object
    //   338	10	1	localException2	java.lang.Exception
    //   351	34	1	localObject7	Object
    //   386	7	1	localObject8	Object
    //   10	1	2	localObject9	Object
    //   251	2	2	localException3	java.lang.Exception
    //   274	1	2	localObject10	Object
    //   281	1	2	localThrowable1	java.lang.Throwable
    //   289	1	2	localThrowable2	java.lang.Throwable
    //   301	7	2	localThrowable3	java.lang.Throwable
    //   322	2	2	localException4	java.lang.Exception
    //   348	25	2	localObject11	Object
    //   379	2	2	localException5	java.lang.Exception
    //   48	309	3	localObject12	Object
    //   363	2	3	localException6	java.lang.Exception
    //   12	226	4	localProperties	java.util.Properties
    //   271	34	4	localObject13	Object
    //   345	5	4	localObject14	Object
    //   83	13	5	localIterator	java.util.Iterator
    //   105	73	6	str	String
    //   118	76	7	localObject15	Object
    //   127	75	8	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   244	248	251	java/lang/Exception
    //   256	260	263	java/lang/Exception
    //   237	244	271	finally
    //   237	244	281	java/lang/Throwable
    //   49	85	285	finally
    //   85	209	285	finally
    //   212	237	285	finally
    //   49	85	289	java/lang/Throwable
    //   85	209	289	java/lang/Throwable
    //   212	237	289	java/lang/Throwable
    //   14	26	295	finally
    //   33	49	295	finally
    //   14	26	301	java/lang/Throwable
    //   33	49	301	java/lang/Throwable
    //   315	319	322	java/lang/Exception
    //   331	335	338	java/lang/Exception
    //   307	311	345	finally
    //   356	360	363	java/lang/Exception
    //   372	376	379	java/lang/Exception
    //   2	9	386	finally
    //   244	248	386	finally
    //   252	256	386	finally
    //   256	260	386	finally
    //   264	268	386	finally
    //   315	319	386	finally
    //   323	327	386	finally
    //   331	335	386	finally
    //   356	360	386	finally
    //   364	368	386	finally
    //   372	376	386	finally
    //   380	384	386	finally
    //   384	386	386	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsBaseConfig
 * JD-Core Version:    0.7.0.1
 */