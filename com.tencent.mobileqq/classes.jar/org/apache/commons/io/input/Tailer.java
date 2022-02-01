package org.apache.commons.io.input;

import java.io.File;
import java.nio.charset.Charset;

public class Tailer
  implements Runnable
{
  private static final int DEFAULT_BUFSIZE = 4096;
  private static final Charset DEFAULT_CHARSET = ;
  private static final int DEFAULT_DELAY_MILLIS = 1000;
  private static final String RAF_MODE = "r";
  private final Charset cset;
  private final long delayMillis;
  private final boolean end;
  private final File file;
  private final byte[] inbuf;
  private final TailerListener listener;
  private final boolean reOpen;
  private volatile boolean run = true;
  
  public Tailer(File paramFile, Charset paramCharset, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.file = paramFile;
    this.delayMillis = paramLong;
    this.end = paramBoolean1;
    this.inbuf = new byte[paramInt];
    this.listener = paramTailerListener;
    paramTailerListener.init(this);
    this.reOpen = paramBoolean2;
    this.cset = paramCharset;
  }
  
  public Tailer(File paramFile, TailerListener paramTailerListener)
  {
    this(paramFile, paramTailerListener, 1000L);
  }
  
  public Tailer(File paramFile, TailerListener paramTailerListener, long paramLong)
  {
    this(paramFile, paramTailerListener, paramLong, false);
  }
  
  public Tailer(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean)
  {
    this(paramFile, paramTailerListener, paramLong, paramBoolean, 4096);
  }
  
  public Tailer(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean, int paramInt)
  {
    this(paramFile, paramTailerListener, paramLong, paramBoolean, false, paramInt);
  }
  
  public Tailer(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramFile, paramTailerListener, paramLong, paramBoolean1, paramBoolean2, 4096);
  }
  
  public Tailer(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this(paramFile, DEFAULT_CHARSET, paramTailerListener, paramLong, paramBoolean1, paramBoolean2, paramInt);
  }
  
  public static Tailer create(File paramFile, Charset paramCharset, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    paramFile = new Tailer(paramFile, paramCharset, paramTailerListener, paramLong, paramBoolean1, paramBoolean2, paramInt);
    paramCharset = new Thread(paramFile);
    paramCharset.setDaemon(true);
    paramCharset.start();
    return paramFile;
  }
  
  public static Tailer create(File paramFile, TailerListener paramTailerListener)
  {
    return create(paramFile, paramTailerListener, 1000L, false);
  }
  
  public static Tailer create(File paramFile, TailerListener paramTailerListener, long paramLong)
  {
    return create(paramFile, paramTailerListener, paramLong, false);
  }
  
  public static Tailer create(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean)
  {
    return create(paramFile, paramTailerListener, paramLong, paramBoolean, 4096);
  }
  
  public static Tailer create(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean, int paramInt)
  {
    return create(paramFile, paramTailerListener, paramLong, paramBoolean, false, paramInt);
  }
  
  public static Tailer create(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    return create(paramFile, paramTailerListener, paramLong, paramBoolean1, paramBoolean2, 4096);
  }
  
  public static Tailer create(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    return create(paramFile, DEFAULT_CHARSET, paramTailerListener, paramLong, paramBoolean1, paramBoolean2, paramInt);
  }
  
  /* Error */
  private long readLines(java.io.RandomAccessFile paramRandomAccessFile)
  {
    // Byte code:
    //   0: new 119	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: bipush 64
    //   6: invokespecial 122	java/io/ByteArrayOutputStream:<init>	(I)V
    //   9: astore 13
    //   11: aconst_null
    //   12: astore 12
    //   14: aload 12
    //   16: astore 11
    //   18: aload_1
    //   19: invokevirtual 128	java/io/RandomAccessFile:getFilePointer	()J
    //   22: lstore 7
    //   24: lload 7
    //   26: lstore 9
    //   28: iconst_0
    //   29: istore_2
    //   30: aload 12
    //   32: astore 11
    //   34: aload_0
    //   35: invokevirtual 132	org/apache/commons/io/input/Tailer:getRun	()Z
    //   38: ifeq +216 -> 254
    //   41: aload 12
    //   43: astore 11
    //   45: aload_1
    //   46: aload_0
    //   47: getfield 55	org/apache/commons/io/input/Tailer:inbuf	[B
    //   50: invokevirtual 136	java/io/RandomAccessFile:read	([B)I
    //   53: istore 5
    //   55: iload 5
    //   57: iconst_m1
    //   58: if_icmpeq +196 -> 254
    //   61: iconst_0
    //   62: istore 4
    //   64: iload 4
    //   66: iload 5
    //   68: if_icmpge +173 -> 241
    //   71: aload 12
    //   73: astore 11
    //   75: aload_0
    //   76: getfield 55	org/apache/commons/io/input/Tailer:inbuf	[B
    //   79: iload 4
    //   81: baload
    //   82: istore 6
    //   84: iload 6
    //   86: bipush 10
    //   88: if_icmpeq +100 -> 188
    //   91: iload 6
    //   93: bipush 13
    //   95: if_icmpeq +75 -> 170
    //   98: iload_2
    //   99: istore_3
    //   100: iload_2
    //   101: ifeq +53 -> 154
    //   104: aload 12
    //   106: astore 11
    //   108: aload_0
    //   109: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   112: new 138	java/lang/String
    //   115: dup
    //   116: aload 13
    //   118: invokevirtual 142	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   121: aload_0
    //   122: getfield 67	org/apache/commons/io/input/Tailer:cset	Ljava/nio/charset/Charset;
    //   125: invokespecial 145	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   128: invokeinterface 149 2 0
    //   133: aload 12
    //   135: astore 11
    //   137: aload 13
    //   139: invokevirtual 152	java/io/ByteArrayOutputStream:reset	()V
    //   142: iload 4
    //   144: i2l
    //   145: lload 9
    //   147: ladd
    //   148: lconst_1
    //   149: ladd
    //   150: lstore 7
    //   152: iconst_0
    //   153: istore_3
    //   154: aload 12
    //   156: astore 11
    //   158: aload 13
    //   160: iload 6
    //   162: invokevirtual 155	java/io/ByteArrayOutputStream:write	(I)V
    //   165: iload_3
    //   166: istore_2
    //   167: goto +176 -> 343
    //   170: iload_2
    //   171: ifeq +170 -> 341
    //   174: aload 12
    //   176: astore 11
    //   178: aload 13
    //   180: bipush 13
    //   182: invokevirtual 155	java/io/ByteArrayOutputStream:write	(I)V
    //   185: goto +156 -> 341
    //   188: aload 12
    //   190: astore 11
    //   192: aload_0
    //   193: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   196: new 138	java/lang/String
    //   199: dup
    //   200: aload 13
    //   202: invokevirtual 142	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   205: aload_0
    //   206: getfield 67	org/apache/commons/io/input/Tailer:cset	Ljava/nio/charset/Charset;
    //   209: invokespecial 145	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   212: invokeinterface 149 2 0
    //   217: aload 12
    //   219: astore 11
    //   221: aload 13
    //   223: invokevirtual 152	java/io/ByteArrayOutputStream:reset	()V
    //   226: iload 4
    //   228: i2l
    //   229: lload 9
    //   231: ladd
    //   232: lconst_1
    //   233: ladd
    //   234: lstore 7
    //   236: iconst_0
    //   237: istore_2
    //   238: goto +105 -> 343
    //   241: aload 12
    //   243: astore 11
    //   245: aload_1
    //   246: invokevirtual 128	java/io/RandomAccessFile:getFilePointer	()J
    //   249: lstore 9
    //   251: goto -221 -> 30
    //   254: aload 12
    //   256: astore 11
    //   258: aload_1
    //   259: lload 7
    //   261: invokevirtual 159	java/io/RandomAccessFile:seek	(J)V
    //   264: aload 12
    //   266: astore 11
    //   268: aload_0
    //   269: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   272: instanceof 161
    //   275: ifeq +17 -> 292
    //   278: aload 12
    //   280: astore 11
    //   282: aload_0
    //   283: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   286: checkcast 161	org/apache/commons/io/input/TailerListenerAdapter
    //   289: invokevirtual 164	org/apache/commons/io/input/TailerListenerAdapter:endOfFileReached	()V
    //   292: aload 13
    //   294: invokevirtual 167	java/io/ByteArrayOutputStream:close	()V
    //   297: lload 7
    //   299: lreturn
    //   300: astore_1
    //   301: goto +9 -> 310
    //   304: astore_1
    //   305: aload_1
    //   306: astore 11
    //   308: aload_1
    //   309: athrow
    //   310: aload 11
    //   312: ifnull +11 -> 323
    //   315: aload 13
    //   317: invokevirtual 167	java/io/ByteArrayOutputStream:close	()V
    //   320: goto +8 -> 328
    //   323: aload 13
    //   325: invokevirtual 167	java/io/ByteArrayOutputStream:close	()V
    //   328: goto +5 -> 333
    //   331: aload_1
    //   332: athrow
    //   333: goto -2 -> 331
    //   336: astore 11
    //   338: goto -10 -> 328
    //   341: iconst_1
    //   342: istore_2
    //   343: iload 4
    //   345: iconst_1
    //   346: iadd
    //   347: istore 4
    //   349: goto -285 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	this	Tailer
    //   0	352	1	paramRandomAccessFile	java.io.RandomAccessFile
    //   29	314	2	i	int
    //   99	67	3	j	int
    //   62	286	4	k	int
    //   53	16	5	m	int
    //   82	79	6	n	int
    //   22	276	7	l1	long
    //   26	224	9	l2	long
    //   16	295	11	localObject1	Object
    //   336	1	11	localThrowable	java.lang.Throwable
    //   12	267	12	localObject2	Object
    //   9	315	13	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   18	24	300	finally
    //   34	41	300	finally
    //   45	55	300	finally
    //   75	84	300	finally
    //   108	133	300	finally
    //   137	142	300	finally
    //   158	165	300	finally
    //   178	185	300	finally
    //   192	217	300	finally
    //   221	226	300	finally
    //   245	251	300	finally
    //   258	264	300	finally
    //   268	278	300	finally
    //   282	292	300	finally
    //   308	310	300	finally
    //   18	24	304	java/lang/Throwable
    //   34	41	304	java/lang/Throwable
    //   45	55	304	java/lang/Throwable
    //   75	84	304	java/lang/Throwable
    //   108	133	304	java/lang/Throwable
    //   137	142	304	java/lang/Throwable
    //   158	165	304	java/lang/Throwable
    //   178	185	304	java/lang/Throwable
    //   192	217	304	java/lang/Throwable
    //   221	226	304	java/lang/Throwable
    //   245	251	304	java/lang/Throwable
    //   258	264	304	java/lang/Throwable
    //   268	278	304	java/lang/Throwable
    //   282	292	304	java/lang/Throwable
    //   315	320	336	java/lang/Throwable
  }
  
  public long getDelay()
  {
    return this.delayMillis;
  }
  
  public File getFile()
  {
    return this.file;
  }
  
  protected boolean getRun()
  {
    return this.run;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: lconst_0
    //   4: lstore_3
    //   5: lload_3
    //   6: lstore 5
    //   8: aload 12
    //   10: astore 11
    //   12: aload 12
    //   14: astore 13
    //   16: aload 12
    //   18: astore 14
    //   20: aload_0
    //   21: invokevirtual 132	org/apache/commons/io/input/Tailer:getRun	()Z
    //   24: istore 9
    //   26: aload 12
    //   28: astore 10
    //   30: lload_3
    //   31: lstore 7
    //   33: lload 5
    //   35: lstore_1
    //   36: iload 9
    //   38: ifeq +185 -> 223
    //   41: aload 12
    //   43: astore 10
    //   45: lload_3
    //   46: lstore 7
    //   48: lload 5
    //   50: lstore_1
    //   51: aload 12
    //   53: ifnonnull +170 -> 223
    //   56: aload 12
    //   58: astore 11
    //   60: aload 12
    //   62: astore 13
    //   64: aload 12
    //   66: astore 14
    //   68: new 124	java/io/RandomAccessFile
    //   71: dup
    //   72: aload_0
    //   73: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   76: ldc 17
    //   78: invokespecial 181	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   81: astore 10
    //   83: aload 10
    //   85: astore 12
    //   87: goto +24 -> 111
    //   90: aload 12
    //   92: astore 11
    //   94: aload 12
    //   96: astore 13
    //   98: aload 12
    //   100: astore 14
    //   102: aload_0
    //   103: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   106: invokeinterface 184 1 0
    //   111: aload 12
    //   113: ifnonnull +25 -> 138
    //   116: aload 12
    //   118: astore 11
    //   120: aload 12
    //   122: astore 13
    //   124: aload 12
    //   126: astore 14
    //   128: aload_0
    //   129: getfield 51	org/apache/commons/io/input/Tailer:delayMillis	J
    //   132: invokestatic 187	java/lang/Thread:sleep	(J)V
    //   135: goto -127 -> 8
    //   138: aload 12
    //   140: astore 11
    //   142: aload 12
    //   144: astore 13
    //   146: aload 12
    //   148: astore 14
    //   150: aload_0
    //   151: getfield 53	org/apache/commons/io/input/Tailer:end	Z
    //   154: ifeq +851 -> 1005
    //   157: aload 12
    //   159: astore 11
    //   161: aload 12
    //   163: astore 13
    //   165: aload 12
    //   167: astore 14
    //   169: aload_0
    //   170: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   173: invokevirtual 192	java/io/File:length	()J
    //   176: lstore 5
    //   178: goto +3 -> 181
    //   181: aload 12
    //   183: astore 11
    //   185: aload 12
    //   187: astore 13
    //   189: aload 12
    //   191: astore 14
    //   193: aload_0
    //   194: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   197: invokevirtual 195	java/io/File:lastModified	()J
    //   200: lstore_3
    //   201: aload 12
    //   203: astore 11
    //   205: aload 12
    //   207: astore 13
    //   209: aload 12
    //   211: astore 14
    //   213: aload 12
    //   215: lload 5
    //   217: invokevirtual 159	java/io/RandomAccessFile:seek	(J)V
    //   220: goto -212 -> 8
    //   223: aload 10
    //   225: astore 11
    //   227: aload 10
    //   229: astore 13
    //   231: aload 10
    //   233: astore 14
    //   235: aload_0
    //   236: invokevirtual 132	org/apache/commons/io/input/Tailer:getRun	()Z
    //   239: ifeq +591 -> 830
    //   242: aload 10
    //   244: astore 11
    //   246: aload 10
    //   248: astore 13
    //   250: aload 10
    //   252: astore 14
    //   254: aload_0
    //   255: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   258: lload 7
    //   260: invokestatic 201	org/apache/commons/io/FileUtils:isFileNewer	(Ljava/io/File;J)Z
    //   263: istore 9
    //   265: aload 10
    //   267: astore 11
    //   269: aload 10
    //   271: astore 13
    //   273: aload 10
    //   275: astore 14
    //   277: aload_0
    //   278: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   281: invokevirtual 192	java/io/File:length	()J
    //   284: lstore_3
    //   285: lload_3
    //   286: lload_1
    //   287: lcmp
    //   288: ifge +264 -> 552
    //   291: aload 10
    //   293: astore 11
    //   295: aload 10
    //   297: astore 13
    //   299: aload 10
    //   301: astore 14
    //   303: aload_0
    //   304: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   307: invokeinterface 204 1 0
    //   312: new 124	java/io/RandomAccessFile
    //   315: dup
    //   316: aload_0
    //   317: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   320: ldc 17
    //   322: invokespecial 181	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   325: astore 11
    //   327: aload_0
    //   328: aload 10
    //   330: invokespecial 206	org/apache/commons/io/input/Tailer:readLines	(Ljava/io/RandomAccessFile;)J
    //   333: pop2
    //   334: goto +29 -> 363
    //   337: astore 13
    //   339: aconst_null
    //   340: astore 12
    //   342: goto +114 -> 456
    //   345: astore 12
    //   347: goto +104 -> 451
    //   350: astore 12
    //   352: aload_0
    //   353: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   356: aload 12
    //   358: invokeinterface 209 2 0
    //   363: aload 10
    //   365: ifnull +51 -> 416
    //   368: aload 11
    //   370: astore 12
    //   372: aload 11
    //   374: astore 13
    //   376: aload 11
    //   378: astore 14
    //   380: aload 10
    //   382: invokevirtual 210	java/io/RandomAccessFile:close	()V
    //   385: goto +31 -> 416
    //   388: astore 10
    //   390: aload 12
    //   392: astore 11
    //   394: goto +552 -> 946
    //   397: astore 10
    //   399: goto +456 -> 855
    //   402: astore 10
    //   404: goto +499 -> 903
    //   407: lconst_0
    //   408: lstore_1
    //   409: aload 11
    //   411: astore 10
    //   413: goto +96 -> 509
    //   416: lconst_0
    //   417: lstore_1
    //   418: aload 11
    //   420: astore 10
    //   422: lload 7
    //   424: lstore 5
    //   426: lload 5
    //   428: lstore 7
    //   430: goto -207 -> 223
    //   433: astore 13
    //   435: aconst_null
    //   436: astore 12
    //   438: aload 10
    //   440: astore 11
    //   442: goto +14 -> 456
    //   445: astore 12
    //   447: aload 10
    //   449: astore 11
    //   451: aload 12
    //   453: athrow
    //   454: astore 13
    //   456: aload 10
    //   458: ifnull +21 -> 479
    //   461: aload 12
    //   463: ifnull +11 -> 474
    //   466: aload 10
    //   468: invokevirtual 210	java/io/RandomAccessFile:close	()V
    //   471: goto +8 -> 479
    //   474: aload 10
    //   476: invokevirtual 210	java/io/RandomAccessFile:close	()V
    //   479: aload 13
    //   481: athrow
    //   482: astore 10
    //   484: goto +462 -> 946
    //   487: astore 10
    //   489: aload 11
    //   491: astore 13
    //   493: goto +362 -> 855
    //   496: astore 10
    //   498: aload 11
    //   500: astore 14
    //   502: goto +401 -> 903
    //   505: aload 11
    //   507: astore 10
    //   509: aload 10
    //   511: astore 11
    //   513: aload 10
    //   515: astore 13
    //   517: aload 10
    //   519: astore 14
    //   521: aload_0
    //   522: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   525: invokeinterface 184 1 0
    //   530: aload 10
    //   532: astore 11
    //   534: aload 10
    //   536: astore 13
    //   538: aload 10
    //   540: astore 14
    //   542: aload_0
    //   543: getfield 51	org/apache/commons/io/input/Tailer:delayMillis	J
    //   546: invokestatic 187	java/lang/Thread:sleep	(J)V
    //   549: goto -326 -> 223
    //   552: lload_3
    //   553: lload_1
    //   554: lcmp
    //   555: ifle +46 -> 601
    //   558: aload 10
    //   560: astore 11
    //   562: aload 10
    //   564: astore 13
    //   566: aload 10
    //   568: astore 14
    //   570: aload_0
    //   571: aload 10
    //   573: invokespecial 206	org/apache/commons/io/input/Tailer:readLines	(Ljava/io/RandomAccessFile;)J
    //   576: lstore_3
    //   577: aload 10
    //   579: astore 11
    //   581: aload 10
    //   583: astore 13
    //   585: aload 10
    //   587: astore 14
    //   589: aload_0
    //   590: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   593: invokevirtual 195	java/io/File:lastModified	()J
    //   596: lstore 5
    //   598: goto +72 -> 670
    //   601: lload 7
    //   603: lstore 5
    //   605: lload_1
    //   606: lstore_3
    //   607: iload 9
    //   609: ifeq +61 -> 670
    //   612: aload 10
    //   614: astore 11
    //   616: aload 10
    //   618: astore 13
    //   620: aload 10
    //   622: astore 14
    //   624: aload 10
    //   626: lconst_0
    //   627: invokevirtual 159	java/io/RandomAccessFile:seek	(J)V
    //   630: aload 10
    //   632: astore 11
    //   634: aload 10
    //   636: astore 13
    //   638: aload 10
    //   640: astore 14
    //   642: aload_0
    //   643: aload 10
    //   645: invokespecial 206	org/apache/commons/io/input/Tailer:readLines	(Ljava/io/RandomAccessFile;)J
    //   648: lstore_3
    //   649: aload 10
    //   651: astore 11
    //   653: aload 10
    //   655: astore 13
    //   657: aload 10
    //   659: astore 14
    //   661: aload_0
    //   662: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   665: invokevirtual 195	java/io/File:lastModified	()J
    //   668: lstore 5
    //   670: aload 10
    //   672: astore 11
    //   674: aload 10
    //   676: astore 13
    //   678: aload 10
    //   680: astore 14
    //   682: aload_0
    //   683: getfield 65	org/apache/commons/io/input/Tailer:reOpen	Z
    //   686: ifeq +25 -> 711
    //   689: aload 10
    //   691: ifnull +20 -> 711
    //   694: aload 10
    //   696: astore 11
    //   698: aload 10
    //   700: astore 13
    //   702: aload 10
    //   704: astore 14
    //   706: aload 10
    //   708: invokevirtual 210	java/io/RandomAccessFile:close	()V
    //   711: aload 10
    //   713: astore 11
    //   715: aload 10
    //   717: astore 13
    //   719: aload 10
    //   721: astore 14
    //   723: aload_0
    //   724: getfield 51	org/apache/commons/io/input/Tailer:delayMillis	J
    //   727: invokestatic 187	java/lang/Thread:sleep	(J)V
    //   730: lload 5
    //   732: lstore 7
    //   734: lload_3
    //   735: lstore_1
    //   736: aload 10
    //   738: astore 11
    //   740: aload 10
    //   742: astore 13
    //   744: aload 10
    //   746: astore 14
    //   748: aload_0
    //   749: invokevirtual 132	org/apache/commons/io/input/Tailer:getRun	()Z
    //   752: ifeq -529 -> 223
    //   755: lload 5
    //   757: lstore 7
    //   759: lload_3
    //   760: lstore_1
    //   761: aload 10
    //   763: astore 11
    //   765: aload 10
    //   767: astore 13
    //   769: aload 10
    //   771: astore 14
    //   773: aload_0
    //   774: getfield 65	org/apache/commons/io/input/Tailer:reOpen	Z
    //   777: ifeq -554 -> 223
    //   780: aload 10
    //   782: astore 11
    //   784: aload 10
    //   786: astore 13
    //   788: aload 10
    //   790: astore 14
    //   792: new 124	java/io/RandomAccessFile
    //   795: dup
    //   796: aload_0
    //   797: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   800: ldc 17
    //   802: invokespecial 181	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   805: astore 10
    //   807: aload 10
    //   809: astore 12
    //   811: aload 10
    //   813: astore 13
    //   815: aload 10
    //   817: astore 14
    //   819: aload 10
    //   821: lload_3
    //   822: invokevirtual 159	java/io/RandomAccessFile:seek	(J)V
    //   825: lload_3
    //   826: lstore_1
    //   827: goto -401 -> 426
    //   830: aload 10
    //   832: ifnull +64 -> 896
    //   835: aload 10
    //   837: invokevirtual 210	java/io/RandomAccessFile:close	()V
    //   840: goto +56 -> 896
    //   843: astore 10
    //   845: goto +40 -> 885
    //   848: astore 10
    //   850: goto +96 -> 946
    //   853: astore 10
    //   855: aload 13
    //   857: astore 11
    //   859: aload_0
    //   860: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   863: aload 10
    //   865: invokeinterface 209 2 0
    //   870: aload 13
    //   872: ifnull +24 -> 896
    //   875: aload 13
    //   877: invokevirtual 210	java/io/RandomAccessFile:close	()V
    //   880: goto +16 -> 896
    //   883: astore 10
    //   885: aload_0
    //   886: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   889: aload 10
    //   891: invokeinterface 209 2 0
    //   896: aload_0
    //   897: invokevirtual 213	org/apache/commons/io/input/Tailer:stop	()V
    //   900: return
    //   901: astore 10
    //   903: aload 14
    //   905: astore 11
    //   907: invokestatic 217	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   910: invokevirtual 220	java/lang/Thread:interrupt	()V
    //   913: aload 14
    //   915: astore 11
    //   917: aload_0
    //   918: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   921: aload 10
    //   923: invokeinterface 209 2 0
    //   928: aload 14
    //   930: ifnull -34 -> 896
    //   933: aload 14
    //   935: invokevirtual 210	java/io/RandomAccessFile:close	()V
    //   938: goto -42 -> 896
    //   941: astore 10
    //   943: goto -58 -> 885
    //   946: aload 11
    //   948: ifnull +24 -> 972
    //   951: aload 11
    //   953: invokevirtual 210	java/io/RandomAccessFile:close	()V
    //   956: goto +16 -> 972
    //   959: astore 11
    //   961: aload_0
    //   962: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   965: aload 11
    //   967: invokeinterface 209 2 0
    //   972: aload_0
    //   973: invokevirtual 213	org/apache/commons/io/input/Tailer:stop	()V
    //   976: goto +6 -> 982
    //   979: aload 10
    //   981: athrow
    //   982: goto -3 -> 979
    //   985: astore 10
    //   987: goto -897 -> 90
    //   990: astore 10
    //   992: goto -585 -> 407
    //   995: astore 10
    //   997: goto -518 -> 479
    //   1000: astore 10
    //   1002: goto -497 -> 505
    //   1005: lconst_0
    //   1006: lstore 5
    //   1008: goto -827 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1011	0	this	Tailer
    //   35	792	1	l1	long
    //   4	822	3	l2	long
    //   6	1001	5	l3	long
    //   31	727	7	l4	long
    //   24	584	9	bool	boolean
    //   28	353	10	localObject1	Object
    //   388	1	10	localObject2	Object
    //   397	1	10	localException1	java.lang.Exception
    //   402	1	10	localInterruptedException1	java.lang.InterruptedException
    //   411	64	10	localObject3	Object
    //   482	1	10	localObject4	Object
    //   487	1	10	localException2	java.lang.Exception
    //   496	1	10	localInterruptedException2	java.lang.InterruptedException
    //   507	329	10	localObject5	Object
    //   843	1	10	localIOException1	java.io.IOException
    //   848	1	10	localObject6	Object
    //   853	11	10	localException3	java.lang.Exception
    //   883	7	10	localIOException2	java.io.IOException
    //   901	21	10	localInterruptedException3	java.lang.InterruptedException
    //   941	39	10	localIOException3	java.io.IOException
    //   985	1	10	localFileNotFoundException1	java.io.FileNotFoundException
    //   990	1	10	localFileNotFoundException2	java.io.FileNotFoundException
    //   995	1	10	localThrowable1	java.lang.Throwable
    //   1000	1	10	localFileNotFoundException3	java.io.FileNotFoundException
    //   10	942	11	localObject7	Object
    //   959	7	11	localIOException4	java.io.IOException
    //   1	340	12	localObject8	Object
    //   345	1	12	localThrowable2	java.lang.Throwable
    //   350	7	12	localIOException5	java.io.IOException
    //   370	67	12	localObject9	Object
    //   445	17	12	localThrowable3	java.lang.Throwable
    //   809	1	12	localObject10	Object
    //   14	284	13	localObject11	Object
    //   337	1	13	localObject12	Object
    //   374	1	13	localObject13	Object
    //   433	1	13	localObject14	Object
    //   454	26	13	localObject15	Object
    //   491	385	13	localObject16	Object
    //   18	916	14	localObject17	Object
    // Exception table:
    //   from	to	target	type
    //   327	334	337	finally
    //   352	363	337	finally
    //   327	334	345	java/lang/Throwable
    //   352	363	345	java/lang/Throwable
    //   327	334	350	java/io/IOException
    //   380	385	388	finally
    //   819	825	388	finally
    //   380	385	397	java/lang/Exception
    //   819	825	397	java/lang/Exception
    //   380	385	402	java/lang/InterruptedException
    //   819	825	402	java/lang/InterruptedException
    //   312	327	433	finally
    //   312	327	445	java/lang/Throwable
    //   451	454	454	finally
    //   466	471	482	finally
    //   474	479	482	finally
    //   479	482	482	finally
    //   466	471	487	java/lang/Exception
    //   474	479	487	java/lang/Exception
    //   479	482	487	java/lang/Exception
    //   466	471	496	java/lang/InterruptedException
    //   474	479	496	java/lang/InterruptedException
    //   479	482	496	java/lang/InterruptedException
    //   835	840	843	java/io/IOException
    //   20	26	848	finally
    //   68	83	848	finally
    //   102	111	848	finally
    //   128	135	848	finally
    //   150	157	848	finally
    //   169	178	848	finally
    //   193	201	848	finally
    //   213	220	848	finally
    //   235	242	848	finally
    //   254	265	848	finally
    //   277	285	848	finally
    //   303	312	848	finally
    //   521	530	848	finally
    //   542	549	848	finally
    //   570	577	848	finally
    //   589	598	848	finally
    //   624	630	848	finally
    //   642	649	848	finally
    //   661	670	848	finally
    //   682	689	848	finally
    //   706	711	848	finally
    //   723	730	848	finally
    //   748	755	848	finally
    //   773	780	848	finally
    //   792	807	848	finally
    //   859	870	848	finally
    //   907	913	848	finally
    //   917	928	848	finally
    //   20	26	853	java/lang/Exception
    //   68	83	853	java/lang/Exception
    //   102	111	853	java/lang/Exception
    //   128	135	853	java/lang/Exception
    //   150	157	853	java/lang/Exception
    //   169	178	853	java/lang/Exception
    //   193	201	853	java/lang/Exception
    //   213	220	853	java/lang/Exception
    //   235	242	853	java/lang/Exception
    //   254	265	853	java/lang/Exception
    //   277	285	853	java/lang/Exception
    //   303	312	853	java/lang/Exception
    //   521	530	853	java/lang/Exception
    //   542	549	853	java/lang/Exception
    //   570	577	853	java/lang/Exception
    //   589	598	853	java/lang/Exception
    //   624	630	853	java/lang/Exception
    //   642	649	853	java/lang/Exception
    //   661	670	853	java/lang/Exception
    //   682	689	853	java/lang/Exception
    //   706	711	853	java/lang/Exception
    //   723	730	853	java/lang/Exception
    //   748	755	853	java/lang/Exception
    //   773	780	853	java/lang/Exception
    //   792	807	853	java/lang/Exception
    //   875	880	883	java/io/IOException
    //   20	26	901	java/lang/InterruptedException
    //   68	83	901	java/lang/InterruptedException
    //   102	111	901	java/lang/InterruptedException
    //   128	135	901	java/lang/InterruptedException
    //   150	157	901	java/lang/InterruptedException
    //   169	178	901	java/lang/InterruptedException
    //   193	201	901	java/lang/InterruptedException
    //   213	220	901	java/lang/InterruptedException
    //   235	242	901	java/lang/InterruptedException
    //   254	265	901	java/lang/InterruptedException
    //   277	285	901	java/lang/InterruptedException
    //   303	312	901	java/lang/InterruptedException
    //   521	530	901	java/lang/InterruptedException
    //   542	549	901	java/lang/InterruptedException
    //   570	577	901	java/lang/InterruptedException
    //   589	598	901	java/lang/InterruptedException
    //   624	630	901	java/lang/InterruptedException
    //   642	649	901	java/lang/InterruptedException
    //   661	670	901	java/lang/InterruptedException
    //   682	689	901	java/lang/InterruptedException
    //   706	711	901	java/lang/InterruptedException
    //   723	730	901	java/lang/InterruptedException
    //   748	755	901	java/lang/InterruptedException
    //   773	780	901	java/lang/InterruptedException
    //   792	807	901	java/lang/InterruptedException
    //   933	938	941	java/io/IOException
    //   951	956	959	java/io/IOException
    //   68	83	985	java/io/FileNotFoundException
    //   380	385	990	java/io/FileNotFoundException
    //   466	471	995	java/lang/Throwable
    //   466	471	1000	java/io/FileNotFoundException
    //   474	479	1000	java/io/FileNotFoundException
    //   479	482	1000	java/io/FileNotFoundException
  }
  
  public void stop()
  {
    this.run = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.input.Tailer
 * JD-Core Version:    0.7.0.1
 */