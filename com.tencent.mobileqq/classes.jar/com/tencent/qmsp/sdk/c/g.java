package com.tencent.qmsp.sdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.util.Pair;
import com.tencent.qmsp.sdk.a.d;
import com.tencent.qmsp.sdk.a.e;
import com.tencent.qmsp.sdk.app.QmspSDK;
import com.tencent.qmsp.sdk.f.k;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class g
{
  private static final byte[] f = { 51, 117, -95 };
  private static final byte[] g = { 38, 114, -96 };
  private static final byte[] h = { 20, 125, -96, 80, 13, 57, 57, -7, 36, 100 };
  private static final byte[] i = { 20, 125, -96, 80, 13, 57, 91, -20, 49 };
  private static final byte[] j = { 52, 100 };
  private static final byte[] k = { 20, 125, -96, 80, 96, 24, 117 };
  private static final byte[][] l;
  private static g m;
  private ConcurrentHashMap<Integer, Integer> a = new ConcurrentHashMap();
  private CopyOnWriteArrayList<g.c> b = new CopyOnWriteArrayList();
  private SharedPreferences c = null;
  private long d = QmspSDK.getAtomCbTimeout().get();
  private int e = 0;
  
  static
  {
    byte[] arrayOfByte = { 49, 99, -70 };
    l = new byte[][] { { 54, 100 }, arrayOfByte, { 54, 115 } };
  }
  
  private g()
  {
    Context localContext = QmspSDK.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b.a);
    localStringBuilder.append(a(i));
    this.c = localContext.getSharedPreferences(localStringBuilder.toString(), 0);
    b();
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    return a(new Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)));
  }
  
  private int a(Pair<Integer, Integer> paramPair)
  {
    if (paramPair == null) {
      return -1;
    }
    StringBuilder localStringBuilder;
    switch (((Integer)paramPair.first).intValue())
    {
    default: 
      return -1;
    case 10003: 
      if ((QmspSDK.getAtomUpdateInterval().get() != ((Integer)paramPair.second).intValue()) && (((Integer)paramPair.second).intValue() > 3600000))
      {
        QmspSDK.getAtomUpdateInterval().set(((Integer)paramPair.second).intValue());
        paramPair = a(k);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[CB-CYC] Plugin Ruery TimeOut : ");
        localStringBuilder.append(QmspSDK.getAtomUpdateInterval().get());
        com.tencent.qmsp.sdk.f.g.a(paramPair, 1, localStringBuilder.toString());
      }
      return 0;
    case 10002: 
      if ((QmspSDK.getAtomCbTimeout().get() != ((Integer)paramPair.second).intValue()) && (((Integer)paramPair.second).intValue() > 3600000))
      {
        QmspSDK.getAtomCbTimeout().set(((Integer)paramPair.second).intValue());
        paramPair = a(k);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[CB-CYC] CB Ruery TimeOut : ");
        localStringBuilder.append(QmspSDK.getAtomCbTimeout().get());
        com.tencent.qmsp.sdk.f.g.a(paramPair, 1, localStringBuilder.toString());
      }
      return 0;
    case 10001: 
      if ((QmspSDK.getAtomReadTimeOut().get() != ((Integer)paramPair.second).intValue()) && (((Integer)paramPair.second).intValue() > 5000))
      {
        QmspSDK.getAtomReadTimeOut().set(((Integer)paramPair.second).intValue());
        paramPair = a(k);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[CB-CYC] Socket Read TimeOut: ");
        localStringBuilder.append(QmspSDK.getAtomReadTimeOut().get());
        com.tencent.qmsp.sdk.f.g.a(paramPair, 1, localStringBuilder.toString());
      }
      return 0;
    }
    if ((QmspSDK.getAtomConnTimeOut().get() != ((Integer)paramPair.second).intValue()) && (((Integer)paramPair.second).intValue() > 5000))
    {
      QmspSDK.getAtomConnTimeOut().set(((Integer)paramPair.second).intValue());
      paramPair = a(k);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[CB-CYC] Socket Conn TimeOut: ");
      localStringBuilder.append(QmspSDK.getAtomConnTimeOut().get());
      com.tencent.qmsp.sdk.f.g.a(paramPair, 1, localStringBuilder.toString());
    }
    return 0;
  }
  
  private Pair<Integer, Integer> a(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      paramString = new Pair(Integer.valueOf(Integer.parseInt(paramString)), Integer.valueOf(paramJSONObject.getInt(paramString)));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private String a(byte[] paramArrayOfByte)
  {
    return k.a(paramArrayOfByte);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    com.tencent.qmsp.sdk.f.g.a(a(k), 1, String.format("[CB] report: funType=%d, result=%d,  NowTaskID=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    com.tencent.qmsp.sdk.a.g localg = new com.tencent.qmsp.sdk.a.g();
    try
    {
      localg.a(paramInt1).a(paramInt2).a(paramInt3);
      com.tencent.qmsp.sdk.a.f.a(localg.toString(), 1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      com.tencent.qmsp.sdk.f.g.b(com.tencent.qmsp.sdk.f.g.a, 0, "onReport error!");
    }
  }
  
  private void a(long paramLong)
  {
    g.a locala = new g.a(this);
    f.i().c().postDelayed(locala, paramLong);
  }
  
  private void a(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.getInt(a(f)) != 1) {
        return;
      }
      paramString = paramString.getJSONObject(a(g));
      if (paramString != null)
      {
        Iterator localIterator = paramString.keys();
        if (localIterator != null) {
          while (localIterator.hasNext())
          {
            Pair localPair = a((String)localIterator.next(), paramString);
            if (localPair != null)
            {
              a(localPair);
              Integer localInteger = (Integer)this.a.get(localPair.first);
              if ((localInteger == null) || (localInteger.byteValue() != ((Integer)localPair.second).intValue())) {
                localLinkedList.add(localPair);
              }
              this.a.put(localPair.first, localPair.second);
            }
          }
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      a(1002, -1, this.e);
      paramString.printStackTrace();
      g();
      if (!localLinkedList.isEmpty())
      {
        paramString = this.b.iterator();
        while (paramString.hasNext()) {
          ((g.c)paramString.next()).a(localLinkedList);
        }
      }
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cb-->Result: ");
      localStringBuilder.append(paramJSONObject);
      com.tencent.qmsp.sdk.f.g.a("Task: ", 0, localStringBuilder.toString());
      int i1 = -1;
      int n = i1;
      if (!paramJSONObject.isNull(a(l[0])))
      {
        n = i1;
        if (!paramJSONObject.isNull(a(l[1])))
        {
          n = i1;
          if (!paramJSONObject.isNull(a(l[2])))
          {
            i1 = paramJSONObject.optInt(a(l[0]));
            this.e = Integer.valueOf(paramJSONObject.optString(a(l[1]))).intValue();
            paramJSONObject = paramJSONObject.optString(a(l[2]));
            n = i1;
            if (i1 == 0)
            {
              n = i1;
              if (paramJSONObject != null)
              {
                n = i1;
                if (!paramJSONObject.equals(""))
                {
                  a(paramJSONObject);
                  n = i1;
                }
              }
            }
          }
        }
      }
      a(1001, n, this.e);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  /* Error */
  private void b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 348	java/io/DataInputStream
    //   6: dup
    //   7: new 350	java/io/ByteArrayInputStream
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 352	java/io/ByteArrayInputStream:<init>	([B)V
    //   15: invokespecial 355	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_1
    //   19: aload_1
    //   20: astore 5
    //   22: aload_1
    //   23: astore 4
    //   25: aload_1
    //   26: invokevirtual 358	java/io/DataInputStream:available	()I
    //   29: ifeq +79 -> 108
    //   32: aload_1
    //   33: astore 4
    //   35: aload_1
    //   36: invokevirtual 361	java/io/DataInputStream:readInt	()I
    //   39: istore_2
    //   40: aload_1
    //   41: astore 4
    //   43: aload_1
    //   44: invokevirtual 361	java/io/DataInputStream:readInt	()I
    //   47: istore_3
    //   48: aload_1
    //   49: astore 4
    //   51: aload_0
    //   52: iload_2
    //   53: iload_3
    //   54: invokespecial 363	com/tencent/qmsp/sdk/c/g:a	(II)I
    //   57: pop
    //   58: aload_1
    //   59: astore 4
    //   61: aload_0
    //   62: getfield 77	com/tencent/qmsp/sdk/c/g:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   65: iload_2
    //   66: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   69: iload_3
    //   70: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   73: invokevirtual 300	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   76: pop
    //   77: goto -58 -> 19
    //   80: astore 5
    //   82: goto +11 -> 93
    //   85: astore_1
    //   86: goto +35 -> 121
    //   89: astore 5
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: astore 4
    //   96: aload 5
    //   98: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   101: aload_1
    //   102: ifnull +17 -> 119
    //   105: aload_1
    //   106: astore 5
    //   108: aload 5
    //   110: invokevirtual 367	java/io/DataInputStream:close	()V
    //   113: return
    //   114: astore_1
    //   115: aload_1
    //   116: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   119: return
    //   120: astore_1
    //   121: aload 4
    //   123: ifnull +18 -> 141
    //   126: aload 4
    //   128: invokevirtual 367	java/io/DataInputStream:close	()V
    //   131: goto +10 -> 141
    //   134: astore 4
    //   136: aload 4
    //   138: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   141: goto +5 -> 146
    //   144: aload_1
    //   145: athrow
    //   146: goto -2 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	g
    //   0	149	1	paramArrayOfByte	byte[]
    //   39	27	2	n	int
    //   47	23	3	i1	int
    //   1	126	4	arrayOfByte1	byte[]
    //   134	3	4	localIOException1	java.io.IOException
    //   20	1	5	arrayOfByte2	byte[]
    //   80	1	5	localIOException2	java.io.IOException
    //   89	8	5	localIOException3	java.io.IOException
    //   106	3	5	arrayOfByte3	byte[]
    // Exception table:
    //   from	to	target	type
    //   25	32	80	java/io/IOException
    //   35	40	80	java/io/IOException
    //   43	48	80	java/io/IOException
    //   51	58	80	java/io/IOException
    //   61	77	80	java/io/IOException
    //   3	19	85	finally
    //   3	19	89	java/io/IOException
    //   108	113	114	java/io/IOException
    //   25	32	120	finally
    //   35	40	120	finally
    //   43	48	120	finally
    //   51	58	120	finally
    //   61	77	120	finally
    //   96	101	120	finally
    //   126	131	134	java/io/IOException
  }
  
  private JSONObject c()
  {
    try
    {
      Object localObject1 = this.c.edit();
      ((SharedPreferences.Editor)localObject1).putLong(a(j), System.currentTimeMillis());
      ((SharedPreferences.Editor)localObject1).commit();
      localObject1 = new JSONObject();
      JSONObject localJSONObject = d.a(1);
      if (localJSONObject == null)
      {
        localObject2 = a(k);
        com.tencent.qmsp.sdk.f.g.d((String)localObject2, 0, "make query head Fail!");
      }
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put(e.a(20), 1);
      ((JSONObject)localObject2).put(e.a(21), 512);
      ((JSONObject)localObject1).put(e.a(15), localJSONObject);
      ((JSONObject)localObject1).put(e.a(16), localObject2);
      return localObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static g d()
  {
    if (m == null) {
      try
      {
        if (m == null) {
          m = new g();
        }
      }
      finally {}
    }
    return m;
  }
  
  private String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.qmsp.sdk.a.b.a());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(a(h));
    return localStringBuilder.toString();
  }
  
  private boolean f()
  {
    try
    {
      this.d = QmspSDK.getAtomCbTimeout().get();
      long l1 = this.c.getLong(a(j), 0L);
      long l2 = System.currentTimeMillis() - l1;
      l1 = l2;
      if (l2 < 0L) {
        l1 = 0L;
      }
      if (l1 < QmspSDK.getAtomCbTimeout().get())
      {
        this.d -= l1;
        return false;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  private void g()
  {
    byte[] arrayOfByte = h();
    if (arrayOfByte != null) {
      new m().a(e(), arrayOfByte, null, 1);
    }
  }
  
  /* Error */
  private byte[] h()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 440	java/io/ByteArrayOutputStream
    //   5: dup
    //   6: invokespecial 441	java/io/ByteArrayOutputStream:<init>	()V
    //   9: astore_1
    //   10: new 443	java/io/DataOutputStream
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 446	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore 5
    //   20: aload_1
    //   21: astore_2
    //   22: aload 5
    //   24: astore_3
    //   25: aload_0
    //   26: getfield 77	com/tencent/qmsp/sdk/c/g:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   29: invokevirtual 450	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   32: invokeinterface 453 1 0
    //   37: astore 4
    //   39: aload_1
    //   40: astore_2
    //   41: aload 5
    //   43: astore_3
    //   44: aload 4
    //   46: invokeinterface 277 1 0
    //   51: ifeq +69 -> 120
    //   54: aload_1
    //   55: astore_2
    //   56: aload 5
    //   58: astore_3
    //   59: aload 4
    //   61: invokeinterface 281 1 0
    //   66: checkcast 455	java/util/Map$Entry
    //   69: astore 6
    //   71: aload_1
    //   72: astore_2
    //   73: aload 5
    //   75: astore_3
    //   76: aload 5
    //   78: aload 6
    //   80: invokeinterface 458 1 0
    //   85: checkcast 136	java/lang/Integer
    //   88: invokevirtual 153	java/lang/Integer:intValue	()I
    //   91: invokevirtual 461	java/io/DataOutputStream:writeInt	(I)V
    //   94: aload_1
    //   95: astore_2
    //   96: aload 5
    //   98: astore_3
    //   99: aload 5
    //   101: aload 6
    //   103: invokeinterface 464 1 0
    //   108: checkcast 136	java/lang/Integer
    //   111: invokevirtual 153	java/lang/Integer:intValue	()I
    //   114: invokevirtual 461	java/io/DataOutputStream:writeInt	(I)V
    //   117: goto -78 -> 39
    //   120: aload_1
    //   121: astore_2
    //   122: aload 5
    //   124: astore_3
    //   125: aload_1
    //   126: invokevirtual 467	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   129: astore 4
    //   131: aload_1
    //   132: invokevirtual 468	java/io/ByteArrayOutputStream:close	()V
    //   135: goto +8 -> 143
    //   138: astore_1
    //   139: aload_1
    //   140: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   143: aload 5
    //   145: invokevirtual 469	java/io/DataOutputStream:close	()V
    //   148: aload 4
    //   150: areturn
    //   151: astore_1
    //   152: aload_1
    //   153: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   156: aload 4
    //   158: areturn
    //   159: astore_2
    //   160: aload_1
    //   161: astore 4
    //   163: aload 5
    //   165: astore_1
    //   166: aload_2
    //   167: astore 5
    //   169: goto +39 -> 208
    //   172: astore 4
    //   174: aload_1
    //   175: astore_2
    //   176: aload 4
    //   178: astore_1
    //   179: goto +75 -> 254
    //   182: astore 5
    //   184: aconst_null
    //   185: astore_2
    //   186: aload_1
    //   187: astore 4
    //   189: aload_2
    //   190: astore_1
    //   191: goto +17 -> 208
    //   194: astore_1
    //   195: aconst_null
    //   196: astore_2
    //   197: goto +57 -> 254
    //   200: astore 5
    //   202: aconst_null
    //   203: astore 4
    //   205: aload 4
    //   207: astore_1
    //   208: aload 4
    //   210: astore_2
    //   211: aload_1
    //   212: astore_3
    //   213: aload 5
    //   215: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   218: aload 4
    //   220: ifnull +16 -> 236
    //   223: aload 4
    //   225: invokevirtual 468	java/io/ByteArrayOutputStream:close	()V
    //   228: goto +8 -> 236
    //   231: astore_2
    //   232: aload_2
    //   233: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   236: aload_1
    //   237: ifnull +14 -> 251
    //   240: aload_1
    //   241: invokevirtual 469	java/io/DataOutputStream:close	()V
    //   244: aconst_null
    //   245: areturn
    //   246: astore_1
    //   247: aload_1
    //   248: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   251: aconst_null
    //   252: areturn
    //   253: astore_1
    //   254: aload_2
    //   255: ifnull +15 -> 270
    //   258: aload_2
    //   259: invokevirtual 468	java/io/ByteArrayOutputStream:close	()V
    //   262: goto +8 -> 270
    //   265: astore_2
    //   266: aload_2
    //   267: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   270: aload_3
    //   271: ifnull +15 -> 286
    //   274: aload_3
    //   275: invokevirtual 469	java/io/DataOutputStream:close	()V
    //   278: goto +8 -> 286
    //   281: astore_2
    //   282: aload_2
    //   283: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   286: goto +5 -> 291
    //   289: aload_1
    //   290: athrow
    //   291: goto -2 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	g
    //   9	123	1	localByteArrayOutputStream1	java.io.ByteArrayOutputStream
    //   138	2	1	localIOException1	java.io.IOException
    //   151	10	1	localIOException2	java.io.IOException
    //   165	26	1	localObject1	Object
    //   194	1	1	localObject2	Object
    //   207	34	1	localObject3	Object
    //   246	2	1	localIOException3	java.io.IOException
    //   253	37	1	localObject4	Object
    //   21	101	2	localByteArrayOutputStream2	java.io.ByteArrayOutputStream
    //   159	8	2	localIOException4	java.io.IOException
    //   175	36	2	localObject5	Object
    //   231	28	2	localIOException5	java.io.IOException
    //   265	2	2	localIOException6	java.io.IOException
    //   281	2	2	localIOException7	java.io.IOException
    //   1	274	3	localObject6	Object
    //   37	125	4	localObject7	Object
    //   172	5	4	localObject8	Object
    //   187	37	4	localObject9	Object
    //   18	150	5	localObject10	Object
    //   182	1	5	localIOException8	java.io.IOException
    //   200	14	5	localIOException9	java.io.IOException
    //   69	33	6	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   131	135	138	java/io/IOException
    //   143	148	151	java/io/IOException
    //   25	39	159	java/io/IOException
    //   44	54	159	java/io/IOException
    //   59	71	159	java/io/IOException
    //   76	94	159	java/io/IOException
    //   99	117	159	java/io/IOException
    //   125	131	159	java/io/IOException
    //   10	20	172	finally
    //   10	20	182	java/io/IOException
    //   2	10	194	finally
    //   2	10	200	java/io/IOException
    //   223	228	231	java/io/IOException
    //   240	244	246	java/io/IOException
    //   25	39	253	finally
    //   44	54	253	finally
    //   59	71	253	finally
    //   76	94	253	finally
    //   99	117	253	finally
    //   125	131	253	finally
    //   213	218	253	finally
    //   258	262	265	java/io/IOException
    //   274	278	281	java/io/IOException
  }
  
  private void i()
  {
    try
    {
      a(1003, 0, this.e);
      JSONObject localJSONObject = c();
      String str = a(k);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CB: ");
      localStringBuilder.append(localJSONObject.toString());
      com.tencent.qmsp.sdk.f.g.d(str, 0, localStringBuilder.toString());
      com.tencent.qmsp.sdk.b.g.b().a(1, QmspSDK.getAppID(), 1, localJSONObject, new g.b(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int a(int paramInt)
  {
    Integer localInteger = (Integer)this.a.get(Integer.valueOf(paramInt));
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return -1;
  }
  
  public void a()
  {
    if (m != null) {
      m = null;
    }
  }
  
  public void a(g.c paramc)
  {
    this.b.add(paramc);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!QmspSDK.getTaskStatus())
    {
      com.tencent.qmsp.sdk.f.g.a(a(k), 1, "cb Task Finish！");
      return;
    }
    String str;
    try
    {
      Object localObject1 = a(k);
      com.tencent.qmsp.sdk.f.g.a((String)localObject1, 1, "Start to query cb!");
      if (!paramBoolean) {
        if (!f())
        {
          localObject1 = a(k);
          com.tencent.qmsp.sdk.f.g.a((String)localObject1, 1, "time has not arrived!");
        }
        else
        {
          i();
        }
      }
      str = a(k);
      localObject1 = new StringBuilder();
    }
    finally {}
    try
    {
      localObject2.printStackTrace();
      StringBuilder localStringBuilder1;
      return;
    }
    finally
    {
      str = a(k);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("next time: ");
      localStringBuilder2.append(this.d);
      com.tencent.qmsp.sdk.f.g.a(str, 0, localStringBuilder2.toString());
      a(this.d);
    }
  }
  
  public void b()
  {
    byte[] arrayOfByte = new m().a(e(), null, 1);
    if (arrayOfByte != null) {
      b(arrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.g
 * JD-Core Version:    0.7.0.1
 */