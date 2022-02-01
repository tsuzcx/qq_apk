package org.apache.commons.io.input;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.RandomAccessFile;
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
  
  private long readLines(RandomAccessFile paramRandomAccessFile)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(64);
    Object localObject = null;
    int i;
    int k;
    for (;;)
    {
      try
      {
        l1 = paramRandomAccessFile.getFilePointer();
        i = 0;
        l2 = l1;
        if (!getRun()) {
          continue;
        }
        int m = paramRandomAccessFile.read(this.inbuf);
        if (m == -1) {
          continue;
        }
        k = 0;
        if (k >= m) {
          continue;
        }
        n = this.inbuf[k];
        switch (n)
        {
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          long l1;
          long l2;
          int n;
          int j;
          throw localThrowable1;
        }
        finally
        {
          if ((localByteArrayOutputStream != null) && (localThrowable1 == null)) {
            continue;
          }
          try
          {
            localByteArrayOutputStream.close();
            throw paramRandomAccessFile;
          }
          catch (Throwable localThrowable2)
          {
            localThrowable1.addSuppressed(localThrowable2);
            continue;
          }
          localThrowable2.close();
        }
      }
      finally
      {
        continue;
        continue;
      }
      j = i;
      if (i != 0)
      {
        j = 0;
        this.listener.handle(new String(localByteArrayOutputStream.toByteArray(), this.cset));
        localByteArrayOutputStream.reset();
        l1 = k + l2 + 1L;
      }
      localByteArrayOutputStream.write(n);
      i = j;
      break label338;
      i = 0;
      this.listener.handle(new String(localByteArrayOutputStream.toByteArray(), this.cset));
      localByteArrayOutputStream.reset();
      l1 = k + l2 + 1L;
      break label338;
      if (i == 0) {
        break label347;
      }
      localByteArrayOutputStream.write(13);
      break label347;
      l2 = paramRandomAccessFile.getFilePointer();
      continue;
      paramRandomAccessFile.seek(l1);
      if ((this.listener instanceof TailerListenerAdapter)) {
        ((TailerListenerAdapter)this.listener).endOfFileReached();
      }
      if ((localByteArrayOutputStream == null) || (0 != 0)) {
        try
        {
          localByteArrayOutputStream.close();
          return l1;
        }
        catch (Throwable paramRandomAccessFile)
        {
          throw new NullPointerException();
        }
      }
      localByteArrayOutputStream.close();
      return l1;
    }
    for (;;)
    {
      label338:
      k += 1;
      break;
      label347:
      i = 1;
    }
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
    //   0: lconst_0
    //   1: lstore 7
    //   3: lconst_0
    //   4: lstore 5
    //   6: aconst_null
    //   7: astore 12
    //   9: aload 12
    //   11: astore 14
    //   13: aload 12
    //   15: astore 13
    //   17: aload 12
    //   19: astore 11
    //   21: aload_0
    //   22: invokevirtual 132	org/apache/commons/io/input/Tailer:getRun	()Z
    //   25: istore 9
    //   27: aload 12
    //   29: astore 10
    //   31: lload 7
    //   33: lstore_1
    //   34: lload 5
    //   36: lstore_3
    //   37: iload 9
    //   39: ifeq +268 -> 307
    //   42: aload 12
    //   44: astore 10
    //   46: lload 7
    //   48: lstore_1
    //   49: lload 5
    //   51: lstore_3
    //   52: aload 12
    //   54: ifnonnull +253 -> 307
    //   57: aload 12
    //   59: astore 14
    //   61: aload 12
    //   63: astore 13
    //   65: aload 12
    //   67: astore 11
    //   69: new 124	java/io/RandomAccessFile
    //   72: dup
    //   73: aload_0
    //   74: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   77: ldc 17
    //   79: invokespecial 188	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   82: astore 10
    //   84: aload 10
    //   86: astore 12
    //   88: aload 12
    //   90: ifnonnull +133 -> 223
    //   93: aload 12
    //   95: astore 14
    //   97: aload 12
    //   99: astore 13
    //   101: aload 12
    //   103: astore 11
    //   105: aload_0
    //   106: getfield 51	org/apache/commons/io/input/Tailer:delayMillis	J
    //   109: invokestatic 191	java/lang/Thread:sleep	(J)V
    //   112: goto -103 -> 9
    //   115: astore 12
    //   117: aload 14
    //   119: astore 10
    //   121: aload 10
    //   123: astore 11
    //   125: invokestatic 195	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   128: invokevirtual 198	java/lang/Thread:interrupt	()V
    //   131: aload 10
    //   133: astore 11
    //   135: aload_0
    //   136: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   139: aload 12
    //   141: invokeinterface 201 2 0
    //   146: aload 10
    //   148: ifnull +8 -> 156
    //   151: aload 10
    //   153: invokevirtual 202	java/io/RandomAccessFile:close	()V
    //   156: aload_0
    //   157: invokevirtual 205	org/apache/commons/io/input/Tailer:stop	()V
    //   160: return
    //   161: astore 10
    //   163: aload 12
    //   165: astore 14
    //   167: aload 12
    //   169: astore 13
    //   171: aload 12
    //   173: astore 11
    //   175: aload_0
    //   176: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   179: invokeinterface 208 1 0
    //   184: goto -96 -> 88
    //   187: astore 12
    //   189: aload 13
    //   191: astore 10
    //   193: aload 10
    //   195: astore 11
    //   197: aload_0
    //   198: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   201: aload 12
    //   203: invokeinterface 201 2 0
    //   208: aload 10
    //   210: ifnull +8 -> 218
    //   213: aload 10
    //   215: invokevirtual 202	java/io/RandomAccessFile:close	()V
    //   218: aload_0
    //   219: invokevirtual 205	org/apache/commons/io/input/Tailer:stop	()V
    //   222: return
    //   223: aload 12
    //   225: astore 14
    //   227: aload 12
    //   229: astore 13
    //   231: aload 12
    //   233: astore 11
    //   235: aload_0
    //   236: getfield 53	org/apache/commons/io/input/Tailer:end	Z
    //   239: ifeq +841 -> 1080
    //   242: aload 12
    //   244: astore 14
    //   246: aload 12
    //   248: astore 13
    //   250: aload 12
    //   252: astore 11
    //   254: aload_0
    //   255: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   258: invokevirtual 213	java/io/File:length	()J
    //   261: lstore_1
    //   262: aload 12
    //   264: astore 14
    //   266: aload 12
    //   268: astore 13
    //   270: aload 12
    //   272: astore 11
    //   274: aload_0
    //   275: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   278: invokevirtual 216	java/io/File:lastModified	()J
    //   281: lstore 5
    //   283: aload 12
    //   285: astore 14
    //   287: aload 12
    //   289: astore 13
    //   291: aload 12
    //   293: astore 11
    //   295: aload 12
    //   297: lload_1
    //   298: invokevirtual 159	java/io/RandomAccessFile:seek	(J)V
    //   301: lload_1
    //   302: lstore 7
    //   304: goto -295 -> 9
    //   307: aload 10
    //   309: astore 14
    //   311: aload 10
    //   313: astore 13
    //   315: aload 10
    //   317: astore 11
    //   319: aload_0
    //   320: invokevirtual 132	org/apache/commons/io/input/Tailer:getRun	()Z
    //   323: ifeq +578 -> 901
    //   326: aload 10
    //   328: astore 14
    //   330: aload 10
    //   332: astore 13
    //   334: aload 10
    //   336: astore 11
    //   338: aload_0
    //   339: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   342: lload_3
    //   343: invokestatic 222	org/apache/commons/io/FileUtils:isFileNewer	(Ljava/io/File;J)Z
    //   346: istore 9
    //   348: aload 10
    //   350: astore 14
    //   352: aload 10
    //   354: astore 13
    //   356: aload 10
    //   358: astore 11
    //   360: aload_0
    //   361: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   364: invokevirtual 213	java/io/File:length	()J
    //   367: lstore 5
    //   369: lload 5
    //   371: lload_1
    //   372: lcmp
    //   373: ifge +283 -> 656
    //   376: aload 10
    //   378: astore 14
    //   380: aload 10
    //   382: astore 13
    //   384: aload 10
    //   386: astore 11
    //   388: aload_0
    //   389: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   392: invokeinterface 225 1 0
    //   397: new 124	java/io/RandomAccessFile
    //   400: dup
    //   401: aload_0
    //   402: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   405: ldc 17
    //   407: invokespecial 188	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   410: astore 11
    //   412: aload_0
    //   413: aload 10
    //   415: invokespecial 227	org/apache/commons/io/input/Tailer:readLines	(Ljava/io/RandomAccessFile;)J
    //   418: pop2
    //   419: aload 10
    //   421: ifnull +12 -> 433
    //   424: iconst_0
    //   425: ifeq +161 -> 586
    //   428: aload 10
    //   430: invokevirtual 202	java/io/RandomAccessFile:close	()V
    //   433: lconst_0
    //   434: lstore_1
    //   435: aload 11
    //   437: astore 10
    //   439: goto -132 -> 307
    //   442: astore 12
    //   444: aload_0
    //   445: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   448: aload 12
    //   450: invokeinterface 201 2 0
    //   455: goto -36 -> 419
    //   458: astore 13
    //   460: aload 11
    //   462: astore 12
    //   464: aload 13
    //   466: astore 11
    //   468: aload 11
    //   470: athrow
    //   471: astore 14
    //   473: aload 11
    //   475: astore 13
    //   477: aload 12
    //   479: astore 11
    //   481: aload 14
    //   483: astore 12
    //   485: aload 10
    //   487: ifnull +25 -> 512
    //   490: aload 13
    //   492: ifnull +135 -> 627
    //   495: aload 11
    //   497: astore 15
    //   499: aload 11
    //   501: astore 16
    //   503: aload 11
    //   505: astore 14
    //   507: aload 10
    //   509: invokevirtual 202	java/io/RandomAccessFile:close	()V
    //   512: aload 11
    //   514: astore 15
    //   516: aload 11
    //   518: astore 16
    //   520: aload 11
    //   522: astore 14
    //   524: aload 12
    //   526: athrow
    //   527: astore 10
    //   529: aload 11
    //   531: astore 15
    //   533: aload 11
    //   535: astore 16
    //   537: aload 11
    //   539: astore 14
    //   541: aload_0
    //   542: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   545: invokeinterface 208 1 0
    //   550: aload 11
    //   552: astore 15
    //   554: aload 11
    //   556: astore 16
    //   558: aload 11
    //   560: astore 14
    //   562: aload_0
    //   563: getfield 51	org/apache/commons/io/input/Tailer:delayMillis	J
    //   566: invokestatic 191	java/lang/Thread:sleep	(J)V
    //   569: aload 11
    //   571: astore 10
    //   573: goto -266 -> 307
    //   576: astore 10
    //   578: new 169	java/lang/NullPointerException
    //   581: dup
    //   582: invokespecial 170	java/lang/NullPointerException:<init>	()V
    //   585: athrow
    //   586: aload 10
    //   588: invokevirtual 202	java/io/RandomAccessFile:close	()V
    //   591: goto -158 -> 433
    //   594: astore 12
    //   596: aload 11
    //   598: astore 10
    //   600: goto -479 -> 121
    //   603: astore 10
    //   605: aload 11
    //   607: astore 15
    //   609: aload 11
    //   611: astore 16
    //   613: aload 11
    //   615: astore 14
    //   617: aload 13
    //   619: aload 10
    //   621: invokevirtual 174	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   624: goto -112 -> 512
    //   627: aload 11
    //   629: astore 15
    //   631: aload 11
    //   633: astore 16
    //   635: aload 11
    //   637: astore 14
    //   639: aload 10
    //   641: invokevirtual 202	java/io/RandomAccessFile:close	()V
    //   644: goto -132 -> 512
    //   647: astore 12
    //   649: aload 15
    //   651: astore 10
    //   653: goto -460 -> 193
    //   656: lload 5
    //   658: lload_1
    //   659: lcmp
    //   660: ifle +176 -> 836
    //   663: aload 10
    //   665: astore 14
    //   667: aload 10
    //   669: astore 13
    //   671: aload 10
    //   673: astore 11
    //   675: aload_0
    //   676: aload 10
    //   678: invokespecial 227	org/apache/commons/io/input/Tailer:readLines	(Ljava/io/RandomAccessFile;)J
    //   681: lstore_1
    //   682: aload 10
    //   684: astore 14
    //   686: aload 10
    //   688: astore 13
    //   690: aload 10
    //   692: astore 11
    //   694: aload_0
    //   695: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   698: invokevirtual 216	java/io/File:lastModified	()J
    //   701: lstore_3
    //   702: aload 10
    //   704: astore 14
    //   706: aload 10
    //   708: astore 13
    //   710: aload 10
    //   712: astore 11
    //   714: aload_0
    //   715: getfield 65	org/apache/commons/io/input/Tailer:reOpen	Z
    //   718: ifeq +25 -> 743
    //   721: aload 10
    //   723: ifnull +20 -> 743
    //   726: aload 10
    //   728: astore 14
    //   730: aload 10
    //   732: astore 13
    //   734: aload 10
    //   736: astore 11
    //   738: aload 10
    //   740: invokevirtual 202	java/io/RandomAccessFile:close	()V
    //   743: aload 10
    //   745: astore 14
    //   747: aload 10
    //   749: astore 13
    //   751: aload 10
    //   753: astore 11
    //   755: aload_0
    //   756: getfield 51	org/apache/commons/io/input/Tailer:delayMillis	J
    //   759: invokestatic 191	java/lang/Thread:sleep	(J)V
    //   762: aload 10
    //   764: astore 14
    //   766: aload 10
    //   768: astore 13
    //   770: aload 10
    //   772: astore 11
    //   774: aload_0
    //   775: invokevirtual 132	org/apache/commons/io/input/Tailer:getRun	()Z
    //   778: ifeq +296 -> 1074
    //   781: aload 10
    //   783: astore 14
    //   785: aload 10
    //   787: astore 13
    //   789: aload 10
    //   791: astore 11
    //   793: aload_0
    //   794: getfield 65	org/apache/commons/io/input/Tailer:reOpen	Z
    //   797: ifeq +277 -> 1074
    //   800: aload 10
    //   802: astore 14
    //   804: aload 10
    //   806: astore 13
    //   808: aload 10
    //   810: astore 11
    //   812: new 124	java/io/RandomAccessFile
    //   815: dup
    //   816: aload_0
    //   817: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   820: ldc 17
    //   822: invokespecial 188	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   825: astore 10
    //   827: aload 10
    //   829: lload_1
    //   830: invokevirtual 159	java/io/RandomAccessFile:seek	(J)V
    //   833: goto -526 -> 307
    //   836: iload 9
    //   838: ifeq +239 -> 1077
    //   841: aload 10
    //   843: astore 14
    //   845: aload 10
    //   847: astore 13
    //   849: aload 10
    //   851: astore 11
    //   853: aload 10
    //   855: lconst_0
    //   856: invokevirtual 159	java/io/RandomAccessFile:seek	(J)V
    //   859: aload 10
    //   861: astore 14
    //   863: aload 10
    //   865: astore 13
    //   867: aload 10
    //   869: astore 11
    //   871: aload_0
    //   872: aload 10
    //   874: invokespecial 227	org/apache/commons/io/input/Tailer:readLines	(Ljava/io/RandomAccessFile;)J
    //   877: lstore_1
    //   878: aload 10
    //   880: astore 14
    //   882: aload 10
    //   884: astore 13
    //   886: aload 10
    //   888: astore 11
    //   890: aload_0
    //   891: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   894: invokevirtual 216	java/io/File:lastModified	()J
    //   897: lstore_3
    //   898: goto -196 -> 702
    //   901: aload 10
    //   903: ifnull +8 -> 911
    //   906: aload 10
    //   908: invokevirtual 202	java/io/RandomAccessFile:close	()V
    //   911: aload_0
    //   912: invokevirtual 205	org/apache/commons/io/input/Tailer:stop	()V
    //   915: return
    //   916: astore 10
    //   918: aload_0
    //   919: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   922: aload 10
    //   924: invokeinterface 201 2 0
    //   929: goto -18 -> 911
    //   932: astore 10
    //   934: aload_0
    //   935: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   938: aload 10
    //   940: invokeinterface 201 2 0
    //   945: goto -789 -> 156
    //   948: astore 10
    //   950: aload_0
    //   951: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   954: aload 10
    //   956: invokeinterface 201 2 0
    //   961: goto -743 -> 218
    //   964: astore 10
    //   966: aload 11
    //   968: ifnull +8 -> 976
    //   971: aload 11
    //   973: invokevirtual 202	java/io/RandomAccessFile:close	()V
    //   976: aload_0
    //   977: invokevirtual 205	org/apache/commons/io/input/Tailer:stop	()V
    //   980: aload 10
    //   982: athrow
    //   983: astore 11
    //   985: aload_0
    //   986: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   989: aload 11
    //   991: invokeinterface 201 2 0
    //   996: goto -20 -> 976
    //   999: astore 10
    //   1001: goto -35 -> 966
    //   1004: astore 10
    //   1006: aload 16
    //   1008: astore 11
    //   1010: goto -44 -> 966
    //   1013: astore 12
    //   1015: aload 10
    //   1017: astore 11
    //   1019: aload 12
    //   1021: astore 10
    //   1023: goto -57 -> 966
    //   1026: astore 12
    //   1028: aload 11
    //   1030: astore 10
    //   1032: goto -839 -> 193
    //   1035: astore 12
    //   1037: goto -844 -> 193
    //   1040: astore 12
    //   1042: goto -921 -> 121
    //   1045: astore 12
    //   1047: aconst_null
    //   1048: astore 13
    //   1050: aload 10
    //   1052: astore 11
    //   1054: goto -569 -> 485
    //   1057: astore 12
    //   1059: aconst_null
    //   1060: astore 13
    //   1062: goto -577 -> 485
    //   1065: astore 11
    //   1067: aload 10
    //   1069: astore 12
    //   1071: goto -603 -> 468
    //   1074: goto -241 -> 833
    //   1077: goto -375 -> 702
    //   1080: lconst_0
    //   1081: lstore_1
    //   1082: goto -820 -> 262
    //   1085: astore 10
    //   1087: lconst_0
    //   1088: lstore_1
    //   1089: goto -560 -> 529
    //   1092: astore 12
    //   1094: aload 14
    //   1096: astore 10
    //   1098: goto -977 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1101	0	this	Tailer
    //   33	1056	1	l1	long
    //   36	862	3	l2	long
    //   4	653	5	l3	long
    //   1	302	7	l4	long
    //   25	812	9	bool	boolean
    //   29	123	10	localObject1	Object
    //   161	1	10	localFileNotFoundException1	java.io.FileNotFoundException
    //   191	317	10	localObject2	Object
    //   527	1	10	localFileNotFoundException2	java.io.FileNotFoundException
    //   571	1	10	localObject3	Object
    //   576	11	10	localThrowable1	Throwable
    //   598	1	10	localObject4	Object
    //   603	37	10	localThrowable2	Throwable
    //   651	256	10	localObject5	Object
    //   916	7	10	localIOException1	java.io.IOException
    //   932	7	10	localIOException2	java.io.IOException
    //   948	7	10	localIOException3	java.io.IOException
    //   964	17	10	localObject6	Object
    //   999	1	10	localObject7	Object
    //   1004	12	10	localObject8	Object
    //   1021	47	10	localObject9	Object
    //   1085	1	10	localFileNotFoundException3	java.io.FileNotFoundException
    //   1096	1	10	localObject10	Object
    //   19	953	11	localObject11	Object
    //   983	7	11	localIOException4	java.io.IOException
    //   1008	45	11	localObject12	Object
    //   1065	1	11	localThrowable3	Throwable
    //   7	95	12	localObject13	Object
    //   115	57	12	localInterruptedException1	java.lang.InterruptedException
    //   187	109	12	localException1	java.lang.Exception
    //   442	7	12	localIOException5	java.io.IOException
    //   462	63	12	localObject14	Object
    //   594	1	12	localInterruptedException2	java.lang.InterruptedException
    //   647	1	12	localException2	java.lang.Exception
    //   1013	7	12	localObject15	Object
    //   1026	1	12	localException3	java.lang.Exception
    //   1035	1	12	localException4	java.lang.Exception
    //   1040	1	12	localInterruptedException3	java.lang.InterruptedException
    //   1045	1	12	localObject16	Object
    //   1057	1	12	localObject17	Object
    //   1069	1	12	localObject18	Object
    //   1092	1	12	localInterruptedException4	java.lang.InterruptedException
    //   15	368	13	localObject19	Object
    //   458	7	13	localThrowable4	Throwable
    //   475	586	13	localObject20	Object
    //   11	368	14	localObject21	Object
    //   471	11	14	localObject22	Object
    //   505	590	14	localObject23	Object
    //   497	153	15	localObject24	Object
    //   501	506	16	localObject25	Object
    // Exception table:
    //   from	to	target	type
    //   21	27	115	java/lang/InterruptedException
    //   69	84	115	java/lang/InterruptedException
    //   105	112	115	java/lang/InterruptedException
    //   175	184	115	java/lang/InterruptedException
    //   235	242	115	java/lang/InterruptedException
    //   254	262	115	java/lang/InterruptedException
    //   274	283	115	java/lang/InterruptedException
    //   295	301	115	java/lang/InterruptedException
    //   319	326	115	java/lang/InterruptedException
    //   338	348	115	java/lang/InterruptedException
    //   360	369	115	java/lang/InterruptedException
    //   388	397	115	java/lang/InterruptedException
    //   675	682	115	java/lang/InterruptedException
    //   694	702	115	java/lang/InterruptedException
    //   714	721	115	java/lang/InterruptedException
    //   738	743	115	java/lang/InterruptedException
    //   755	762	115	java/lang/InterruptedException
    //   774	781	115	java/lang/InterruptedException
    //   793	800	115	java/lang/InterruptedException
    //   812	827	115	java/lang/InterruptedException
    //   853	859	115	java/lang/InterruptedException
    //   871	878	115	java/lang/InterruptedException
    //   890	898	115	java/lang/InterruptedException
    //   69	84	161	java/io/FileNotFoundException
    //   21	27	187	java/lang/Exception
    //   69	84	187	java/lang/Exception
    //   105	112	187	java/lang/Exception
    //   175	184	187	java/lang/Exception
    //   235	242	187	java/lang/Exception
    //   254	262	187	java/lang/Exception
    //   274	283	187	java/lang/Exception
    //   295	301	187	java/lang/Exception
    //   319	326	187	java/lang/Exception
    //   338	348	187	java/lang/Exception
    //   360	369	187	java/lang/Exception
    //   388	397	187	java/lang/Exception
    //   675	682	187	java/lang/Exception
    //   694	702	187	java/lang/Exception
    //   714	721	187	java/lang/Exception
    //   738	743	187	java/lang/Exception
    //   755	762	187	java/lang/Exception
    //   774	781	187	java/lang/Exception
    //   793	800	187	java/lang/Exception
    //   812	827	187	java/lang/Exception
    //   853	859	187	java/lang/Exception
    //   871	878	187	java/lang/Exception
    //   890	898	187	java/lang/Exception
    //   412	419	442	java/io/IOException
    //   412	419	458	java/lang/Throwable
    //   444	455	458	java/lang/Throwable
    //   468	471	471	finally
    //   507	512	527	java/io/FileNotFoundException
    //   524	527	527	java/io/FileNotFoundException
    //   617	624	527	java/io/FileNotFoundException
    //   639	644	527	java/io/FileNotFoundException
    //   428	433	576	java/lang/Throwable
    //   428	433	594	java/lang/InterruptedException
    //   578	586	594	java/lang/InterruptedException
    //   586	591	594	java/lang/InterruptedException
    //   507	512	603	java/lang/Throwable
    //   507	512	647	java/lang/Exception
    //   524	527	647	java/lang/Exception
    //   541	550	647	java/lang/Exception
    //   562	569	647	java/lang/Exception
    //   617	624	647	java/lang/Exception
    //   639	644	647	java/lang/Exception
    //   906	911	916	java/io/IOException
    //   151	156	932	java/io/IOException
    //   213	218	948	java/io/IOException
    //   21	27	964	finally
    //   69	84	964	finally
    //   105	112	964	finally
    //   125	131	964	finally
    //   135	146	964	finally
    //   175	184	964	finally
    //   197	208	964	finally
    //   235	242	964	finally
    //   254	262	964	finally
    //   274	283	964	finally
    //   295	301	964	finally
    //   319	326	964	finally
    //   338	348	964	finally
    //   360	369	964	finally
    //   388	397	964	finally
    //   675	682	964	finally
    //   694	702	964	finally
    //   714	721	964	finally
    //   738	743	964	finally
    //   755	762	964	finally
    //   774	781	964	finally
    //   793	800	964	finally
    //   812	827	964	finally
    //   853	859	964	finally
    //   871	878	964	finally
    //   890	898	964	finally
    //   971	976	983	java/io/IOException
    //   428	433	999	finally
    //   578	586	999	finally
    //   586	591	999	finally
    //   507	512	1004	finally
    //   524	527	1004	finally
    //   541	550	1004	finally
    //   562	569	1004	finally
    //   617	624	1004	finally
    //   639	644	1004	finally
    //   827	833	1013	finally
    //   428	433	1026	java/lang/Exception
    //   578	586	1026	java/lang/Exception
    //   586	591	1026	java/lang/Exception
    //   827	833	1035	java/lang/Exception
    //   827	833	1040	java/lang/InterruptedException
    //   397	412	1045	finally
    //   412	419	1057	finally
    //   444	455	1057	finally
    //   397	412	1065	java/lang/Throwable
    //   428	433	1085	java/io/FileNotFoundException
    //   578	586	1085	java/io/FileNotFoundException
    //   586	591	1085	java/io/FileNotFoundException
    //   507	512	1092	java/lang/InterruptedException
    //   524	527	1092	java/lang/InterruptedException
    //   541	550	1092	java/lang/InterruptedException
    //   562	569	1092	java/lang/InterruptedException
    //   617	624	1092	java/lang/InterruptedException
    //   639	644	1092	java/lang/InterruptedException
  }
  
  public void stop()
  {
    this.run = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.apache.commons.io.input.Tailer
 * JD-Core Version:    0.7.0.1
 */