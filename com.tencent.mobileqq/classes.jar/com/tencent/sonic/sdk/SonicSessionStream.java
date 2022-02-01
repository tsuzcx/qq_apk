package com.tencent.sonic.sdk;

import android.support.annotation.NonNull;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class SonicSessionStream
  extends InputStream
{
  private static final String TAG = "SonicSdk_SonicSessionStream";
  private final WeakReference<SonicSessionStream.Callback> callbackWeakReference;
  private BufferedInputStream memStream;
  private boolean memStreamReadComplete = true;
  private BufferedInputStream netStream;
  private boolean netStreamReadComplete = true;
  private ByteArrayOutputStream outputStream;
  
  public SonicSessionStream(SonicSessionStream.Callback paramCallback, ByteArrayOutputStream paramByteArrayOutputStream, BufferedInputStream paramBufferedInputStream)
  {
    if (paramBufferedInputStream != null)
    {
      this.netStream = paramBufferedInputStream;
      this.netStreamReadComplete = false;
    }
    if (paramByteArrayOutputStream != null)
    {
      this.outputStream = paramByteArrayOutputStream;
      this.memStream = new BufferedInputStream(new ByteArrayInputStream(paramByteArrayOutputStream.toByteArray()));
      this.memStreamReadComplete = false;
    }
    else
    {
      this.outputStream = new ByteArrayOutputStream();
    }
    this.callbackWeakReference = new WeakReference(paramCallback);
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: iconst_4
    //   1: invokestatic 68	com/tencent/sonic/sdk/SonicUtils:shouldLog	(I)Z
    //   4: ifeq +53 -> 57
    //   7: new 70	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   14: astore_2
    //   15: aload_2
    //   16: ldc 73
    //   18: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_2
    //   23: aload_0
    //   24: getfield 26	com/tencent/sonic/sdk/SonicSessionStream:netStreamReadComplete	Z
    //   27: invokevirtual 80	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_2
    //   32: ldc 82
    //   34: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_2
    //   39: aload_0
    //   40: getfield 28	com/tencent/sonic/sdk/SonicSessionStream:memStreamReadComplete	Z
    //   43: invokevirtual 80	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: ldc 8
    //   49: iconst_4
    //   50: aload_2
    //   51: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 90	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_0
    //   58: getfield 50	com/tencent/sonic/sdk/SonicSessionStream:memStream	Ljava/io/BufferedInputStream;
    //   61: ifnull +10 -> 71
    //   64: aload_0
    //   65: getfield 50	com/tencent/sonic/sdk/SonicSessionStream:memStream	Ljava/io/BufferedInputStream;
    //   68: invokevirtual 92	java/io/BufferedInputStream:close	()V
    //   71: aload_0
    //   72: aconst_null
    //   73: putfield 50	com/tencent/sonic/sdk/SonicSessionStream:memStream	Ljava/io/BufferedInputStream;
    //   76: aconst_null
    //   77: astore_2
    //   78: goto +48 -> 126
    //   81: astore_2
    //   82: goto +233 -> 315
    //   85: astore_2
    //   86: new 70	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   93: astore_3
    //   94: aload_3
    //   95: ldc 94
    //   97: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload_3
    //   102: aload_2
    //   103: invokevirtual 97	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   106: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: ldc 8
    //   112: bipush 6
    //   114: aload_3
    //   115: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 90	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload_0
    //   122: aconst_null
    //   123: putfield 50	com/tencent/sonic/sdk/SonicSessionStream:memStream	Ljava/io/BufferedInputStream;
    //   126: aload_2
    //   127: astore_3
    //   128: aload_0
    //   129: getfield 30	com/tencent/sonic/sdk/SonicSessionStream:netStream	Ljava/io/BufferedInputStream;
    //   132: ifnull +12 -> 144
    //   135: aload_0
    //   136: getfield 30	com/tencent/sonic/sdk/SonicSessionStream:netStream	Ljava/io/BufferedInputStream;
    //   139: invokevirtual 92	java/io/BufferedInputStream:close	()V
    //   142: aload_2
    //   143: astore_3
    //   144: aload_0
    //   145: aconst_null
    //   146: putfield 30	com/tencent/sonic/sdk/SonicSessionStream:netStream	Ljava/io/BufferedInputStream;
    //   149: goto +46 -> 195
    //   152: astore_2
    //   153: goto +155 -> 308
    //   156: astore_3
    //   157: new 70	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   164: astore_2
    //   165: aload_2
    //   166: ldc 99
    //   168: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload_2
    //   173: aload_3
    //   174: invokevirtual 97	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   177: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: ldc 8
    //   183: bipush 6
    //   185: aload_2
    //   186: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 90	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: goto -48 -> 144
    //   195: aload_0
    //   196: getfield 58	com/tencent/sonic/sdk/SonicSessionStream:callbackWeakReference	Ljava/lang/ref/WeakReference;
    //   199: invokevirtual 103	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   202: checkcast 105	com/tencent/sonic/sdk/SonicSessionStream$Callback
    //   205: astore_2
    //   206: aload_2
    //   207: ifnull +35 -> 242
    //   210: aload_0
    //   211: getfield 26	com/tencent/sonic/sdk/SonicSessionStream:netStreamReadComplete	Z
    //   214: ifeq +15 -> 229
    //   217: aload_0
    //   218: getfield 28	com/tencent/sonic/sdk/SonicSessionStream:memStreamReadComplete	Z
    //   221: ifeq +8 -> 229
    //   224: iconst_1
    //   225: istore_1
    //   226: goto +5 -> 231
    //   229: iconst_0
    //   230: istore_1
    //   231: aload_2
    //   232: iload_1
    //   233: aload_0
    //   234: getfield 32	com/tencent/sonic/sdk/SonicSessionStream:outputStream	Ljava/io/ByteArrayOutputStream;
    //   237: invokeinterface 109 3 0
    //   242: aload_0
    //   243: aconst_null
    //   244: putfield 32	com/tencent/sonic/sdk/SonicSessionStream:outputStream	Ljava/io/ByteArrayOutputStream;
    //   247: aload_3
    //   248: ifnull +59 -> 307
    //   251: new 70	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   258: astore_2
    //   259: aload_2
    //   260: ldc 111
    //   262: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload_2
    //   267: aload_3
    //   268: invokevirtual 97	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   271: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: ldc 8
    //   277: bipush 6
    //   279: aload_2
    //   280: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 90	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: aload_3
    //   287: instanceof 113
    //   290: ifeq +8 -> 298
    //   293: aload_3
    //   294: checkcast 113	java/io/IOException
    //   297: athrow
    //   298: new 113	java/io/IOException
    //   301: dup
    //   302: aload_3
    //   303: invokespecial 116	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   306: athrow
    //   307: return
    //   308: aload_0
    //   309: aconst_null
    //   310: putfield 30	com/tencent/sonic/sdk/SonicSessionStream:netStream	Ljava/io/BufferedInputStream;
    //   313: aload_2
    //   314: athrow
    //   315: aload_0
    //   316: aconst_null
    //   317: putfield 50	com/tencent/sonic/sdk/SonicSessionStream:memStream	Ljava/io/BufferedInputStream;
    //   320: goto +5 -> 325
    //   323: aload_2
    //   324: athrow
    //   325: goto -2 -> 323
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	this	SonicSessionStream
    //   225	8	1	bool	boolean
    //   14	64	2	localStringBuilder	java.lang.StringBuilder
    //   81	1	2	localObject1	java.lang.Object
    //   85	58	2	localThrowable1	java.lang.Throwable
    //   152	1	2	localObject2	java.lang.Object
    //   164	160	2	localObject3	java.lang.Object
    //   93	51	3	localObject4	java.lang.Object
    //   156	147	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   57	71	81	finally
    //   86	121	81	finally
    //   57	71	85	java/lang/Throwable
    //   128	142	152	finally
    //   157	192	152	finally
    //   128	142	156	java/lang/Throwable
  }
  
  /* Error */
  public int read()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 58	com/tencent/sonic/sdk/SonicSessionStream:callbackWeakReference	Ljava/lang/ref/WeakReference;
    //   6: invokevirtual 103	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   9: checkcast 105	com/tencent/sonic/sdk/SonicSessionStream$Callback
    //   12: astore 6
    //   14: aload 6
    //   16: instanceof 120
    //   19: istore_3
    //   20: aconst_null
    //   21: astore 5
    //   23: aload 5
    //   25: astore 4
    //   27: iload_3
    //   28: ifeq +32 -> 60
    //   31: aload 6
    //   33: checkcast 120	com/tencent/sonic/sdk/SonicServer
    //   36: astore 6
    //   38: aload 5
    //   40: astore 4
    //   42: aload 6
    //   44: getfield 124	com/tencent/sonic/sdk/SonicServer:session	Lcom/tencent/sonic/sdk/SonicSession;
    //   47: ifnull +13 -> 60
    //   50: aload 6
    //   52: getfield 124	com/tencent/sonic/sdk/SonicServer:session	Lcom/tencent/sonic/sdk/SonicSession;
    //   55: getfield 130	com/tencent/sonic/sdk/SonicSession:statistics	Lcom/tencent/sonic/sdk/SonicSessionStatistics;
    //   58: astore 4
    //   60: aload_0
    //   61: getfield 50	com/tencent/sonic/sdk/SonicSessionStream:memStream	Ljava/io/BufferedInputStream;
    //   64: ifnull +301 -> 365
    //   67: aload_0
    //   68: getfield 28	com/tencent/sonic/sdk/SonicSessionStream:memStreamReadComplete	Z
    //   71: ifne +294 -> 365
    //   74: aload_0
    //   75: getfield 50	com/tencent/sonic/sdk/SonicSessionStream:memStream	Ljava/io/BufferedInputStream;
    //   78: invokevirtual 132	java/io/BufferedInputStream:read	()I
    //   81: istore_1
    //   82: goto +3 -> 85
    //   85: iload_1
    //   86: istore_2
    //   87: iconst_m1
    //   88: iload_1
    //   89: if_icmpne +55 -> 144
    //   92: aload_0
    //   93: iconst_1
    //   94: putfield 28	com/tencent/sonic/sdk/SonicSessionStream:memStreamReadComplete	Z
    //   97: iload_1
    //   98: istore_2
    //   99: aload_0
    //   100: getfield 30	com/tencent/sonic/sdk/SonicSessionStream:netStream	Ljava/io/BufferedInputStream;
    //   103: ifnull +41 -> 144
    //   106: iload_1
    //   107: istore_2
    //   108: aload_0
    //   109: getfield 26	com/tencent/sonic/sdk/SonicSessionStream:netStreamReadComplete	Z
    //   112: ifne +32 -> 144
    //   115: aload_0
    //   116: getfield 30	com/tencent/sonic/sdk/SonicSessionStream:netStream	Ljava/io/BufferedInputStream;
    //   119: invokevirtual 132	java/io/BufferedInputStream:read	()I
    //   122: istore_2
    //   123: iconst_m1
    //   124: iload_2
    //   125: if_icmpeq +14 -> 139
    //   128: aload_0
    //   129: getfield 32	com/tencent/sonic/sdk/SonicSessionStream:outputStream	Ljava/io/ByteArrayOutputStream;
    //   132: iload_2
    //   133: invokevirtual 136	java/io/ByteArrayOutputStream:write	(I)V
    //   136: goto +8 -> 144
    //   139: aload_0
    //   140: iconst_1
    //   141: putfield 26	com/tencent/sonic/sdk/SonicSessionStream:netStreamReadComplete	Z
    //   144: iload_2
    //   145: iconst_m1
    //   146: if_icmpne +74 -> 220
    //   149: aload 4
    //   151: ifnull +137 -> 288
    //   154: aload 4
    //   156: getfield 142	com/tencent/sonic/sdk/SonicSessionStatistics:connectionRecDataEndTime	J
    //   159: lconst_0
    //   160: lcmp
    //   161: ifgt +127 -> 288
    //   164: aload 4
    //   166: invokestatic 148	java/lang/System:currentTimeMillis	()J
    //   169: putfield 142	com/tencent/sonic/sdk/SonicSessionStatistics:connectionRecDataEndTime	J
    //   172: new 70	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   179: astore 5
    //   181: aload 5
    //   183: ldc 150
    //   185: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 5
    //   191: aload 4
    //   193: getfield 142	com/tencent/sonic/sdk/SonicSessionStatistics:connectionRecDataEndTime	J
    //   196: aload 4
    //   198: getfield 153	com/tencent/sonic/sdk/SonicSessionStatistics:connectionFlowStartTime	J
    //   201: lsub
    //   202: invokevirtual 156	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: ldc 8
    //   208: iconst_4
    //   209: aload 5
    //   211: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 90	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: goto +71 -> 288
    //   220: aload 4
    //   222: ifnull +66 -> 288
    //   225: aload 4
    //   227: getfield 159	com/tencent/sonic/sdk/SonicSessionStatistics:connectionRecDataStartTime	J
    //   230: lconst_0
    //   231: lcmp
    //   232: ifgt +56 -> 288
    //   235: aload 4
    //   237: invokestatic 148	java/lang/System:currentTimeMillis	()J
    //   240: putfield 159	com/tencent/sonic/sdk/SonicSessionStatistics:connectionRecDataStartTime	J
    //   243: new 70	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   250: astore 5
    //   252: aload 5
    //   254: ldc 161
    //   256: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload 5
    //   262: aload 4
    //   264: getfield 159	com/tencent/sonic/sdk/SonicSessionStatistics:connectionRecDataStartTime	J
    //   267: aload 4
    //   269: getfield 153	com/tencent/sonic/sdk/SonicSessionStatistics:connectionFlowStartTime	J
    //   272: lsub
    //   273: invokevirtual 156	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: ldc 8
    //   279: iconst_4
    //   280: aload 5
    //   282: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 90	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: aload_0
    //   289: monitorexit
    //   290: iload_2
    //   291: ireturn
    //   292: astore 4
    //   294: goto +66 -> 360
    //   297: astore 4
    //   299: new 70	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   306: astore 5
    //   308: aload 5
    //   310: ldc 163
    //   312: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload 5
    //   318: aload 4
    //   320: invokevirtual 97	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   323: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: ldc 8
    //   329: bipush 6
    //   331: aload 5
    //   333: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 90	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   339: aload 4
    //   341: instanceof 113
    //   344: ifeq +6 -> 350
    //   347: aload 4
    //   349: athrow
    //   350: new 113	java/io/IOException
    //   353: dup
    //   354: aload 4
    //   356: invokespecial 116	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   359: athrow
    //   360: aload_0
    //   361: monitorexit
    //   362: aload 4
    //   364: athrow
    //   365: iconst_m1
    //   366: istore_1
    //   367: goto -282 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	this	SonicSessionStream
    //   81	286	1	i	int
    //   86	205	2	j	int
    //   19	9	3	bool	boolean
    //   25	243	4	localObject1	java.lang.Object
    //   292	1	4	localObject2	java.lang.Object
    //   297	66	4	localThrowable	java.lang.Throwable
    //   21	311	5	localStringBuilder	java.lang.StringBuilder
    //   12	39	6	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	20	292	finally
    //   31	38	292	finally
    //   42	60	292	finally
    //   60	82	292	finally
    //   92	97	292	finally
    //   99	106	292	finally
    //   108	123	292	finally
    //   128	136	292	finally
    //   139	144	292	finally
    //   154	217	292	finally
    //   225	288	292	finally
    //   299	350	292	finally
    //   350	360	292	finally
    //   2	20	297	java/lang/Throwable
    //   31	38	297	java/lang/Throwable
    //   42	60	297	java/lang/Throwable
    //   60	82	297	java/lang/Throwable
    //   92	97	297	java/lang/Throwable
    //   99	106	297	java/lang/Throwable
    //   108	123	297	java/lang/Throwable
    //   128	136	297	java/lang/Throwable
    //   139	144	297	java/lang/Throwable
    //   154	217	297	java/lang/Throwable
    //   225	288	297	java/lang/Throwable
  }
  
  public int read(@NonNull byte[] paramArrayOfByte)
  {
    try
    {
      int i = read(paramArrayOfByte, 0, paramArrayOfByte.length);
      return i;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public int read(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      int i = paramArrayOfByte.length;
      if (((paramInt1 | paramInt2) >= 0) && (paramInt1 <= i) && (i - paramInt1 >= paramInt2))
      {
        i = 0;
        while (i < paramInt2) {
          try
          {
            int j = read();
            if (j == -1)
            {
              paramInt1 = i;
              if (i == 0) {
                paramInt1 = -1;
              }
              return paramInt1;
            }
            paramArrayOfByte[(paramInt1 + i)] = ((byte)j);
            i += 1;
          }
          catch (IOException paramArrayOfByte)
          {
            if (i != 0) {
              return i;
            }
            throw paramArrayOfByte;
          }
        }
        return paramInt2;
      }
      throw new ArrayIndexOutOfBoundsException();
    }
    finally {}
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSessionStream
 * JD-Core Version:    0.7.0.1
 */