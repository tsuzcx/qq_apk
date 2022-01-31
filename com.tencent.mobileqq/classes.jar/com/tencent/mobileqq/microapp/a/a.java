package com.tencent.mobileqq.microapp.a;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  implements Closeable
{
  static final Pattern a = Pattern.compile("[A-Za-z0-9_-]{1,120}");
  private static final OutputStream p = new c();
  final ThreadPoolExecutor b = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  private final File c;
  private final File d;
  private final File e;
  private final File f;
  private final int g;
  private long h;
  private final int i;
  private long j = 0L;
  private Writer k;
  private final LinkedHashMap l = new LinkedHashMap(0, 0.75F, true);
  private int m;
  private long n = 0L;
  private final Callable o = new b(this);
  
  private a(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    this.c = paramFile;
    this.g = paramInt1;
    this.d = new File(paramFile, "journal");
    this.e = new File(paramFile, "journal.tmp");
    this.f = new File(paramFile, "journal.bkp");
    this.i = paramInt2;
    this.h = paramLong;
  }
  
  private a.a a(String paramString, long paramLong)
  {
    for (;;)
    {
      a.a locala;
      try
      {
        l();
        e(paramString);
        a.b localb = (a.b)this.l.get(paramString);
        if (paramLong != -1L) {
          if (localb != null)
          {
            long l1 = a.b.e(localb);
            if (l1 == paramLong) {}
          }
          else
          {
            paramString = null;
            return paramString;
          }
        }
        if (localb == null)
        {
          localb = new a.b(this, paramString, null);
          this.l.put(paramString, localb);
          locala = new a.a(this, localb, null);
          a.b.a(localb, locala);
          this.k.write("DIRTY " + paramString + '\n');
          this.k.flush();
          paramString = locala;
          continue;
        }
        locala = a.b.a(localb);
      }
      finally {}
      if (locala != null) {
        paramString = null;
      }
    }
  }
  
  public static a a(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("valueCount <= 0");
    }
    Object localObject = new File(paramFile, "journal.bkp");
    File localFile;
    if (((File)localObject).exists())
    {
      localFile = new File(paramFile, "journal");
      if (!localFile.exists()) {
        break label113;
      }
      ((File)localObject).delete();
    }
    for (;;)
    {
      localObject = new a(paramFile, paramInt1, paramInt2, paramLong);
      if (!((a)localObject).d.exists()) {
        break label174;
      }
      try
      {
        ((a)localObject).h();
        ((a)localObject).i();
        return localObject;
      }
      catch (IOException localIOException)
      {
        label113:
        System.out.println("DiskLruCache " + paramFile + " is corrupt: " + localIOException.getMessage() + ", removing");
        ((a)localObject).f();
      }
      a((File)localObject, localFile, false);
    }
    label174:
    paramFile.mkdirs();
    paramFile = new a(paramFile, paramInt1, paramInt2, paramLong);
    paramFile.j();
    return paramFile;
  }
  
  private void a(a.a parama, boolean paramBoolean)
  {
    int i3 = 0;
    a.b localb;
    try
    {
      localb = a.a.a(parama);
      if (a.b.a(localb) != parama) {
        throw new IllegalStateException();
      }
    }
    finally {}
    int i2 = i3;
    if (paramBoolean)
    {
      i2 = i3;
      if (!a.b.d(localb))
      {
        int i1 = 0;
        for (;;)
        {
          i2 = i3;
          if (i1 >= this.i) {
            break;
          }
          if (a.a.b(parama)[i1] == 0)
          {
            parama.b();
            throw new IllegalStateException("Newly created entry didn't create value for index " + i1);
          }
          if (!localb.b(i1).exists())
          {
            parama.b();
            return;
          }
          i1 += 1;
        }
      }
    }
    for (;;)
    {
      long l1;
      if (i2 < this.i)
      {
        parama = localb.b(i2);
        if (paramBoolean)
        {
          if (parama.exists())
          {
            File localFile = localb.a(i2);
            parama.renameTo(localFile);
            l1 = a.b.b(localb)[i2];
            long l2 = localFile.length();
            a.b.b(localb)[i2] = l2;
            this.j = (this.j - l1 + l2);
          }
        }
        else {
          a(parama);
        }
      }
      else
      {
        this.m += 1;
        a.b.a(localb, null);
        if ((a.b.d(localb) | paramBoolean))
        {
          a.b.a(localb, true);
          this.k.write("CLEAN " + a.b.c(localb) + localb.a() + '\n');
          if (paramBoolean)
          {
            l1 = this.n;
            this.n = (1L + l1);
            a.b.a(localb, l1);
          }
        }
        for (;;)
        {
          this.k.flush();
          if ((this.j <= this.h) && (!k())) {
            break;
          }
          this.b.submit(this.o);
          break;
          this.l.remove(a.b.c(localb));
          this.k.write("REMOVE " + a.b.c(localb) + '\n');
        }
      }
      i2 += 1;
    }
  }
  
  private static void a(File paramFile)
  {
    if ((paramFile.exists()) && (!paramFile.delete())) {
      throw new IOException();
    }
  }
  
  private static void a(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramBoolean) {
      a(paramFile2);
    }
    if (!paramFile1.renameTo(paramFile2)) {
      throw new IOException();
    }
  }
  
  private static String b(InputStream paramInputStream)
  {
    return i.a(new InputStreamReader(paramInputStream, i.b));
  }
  
  private void d(String paramString)
  {
    int i1 = paramString.indexOf(' ');
    if (i1 == -1) {
      throw new IOException("unexpected journal line: " + paramString);
    }
    int i2 = i1 + 1;
    int i3 = paramString.indexOf(' ', i2);
    String str;
    if (i3 == -1)
    {
      str = paramString.substring(i2);
      if ((i1 == "REMOVE".length()) && (paramString.startsWith("REMOVE"))) {
        this.l.remove(str);
      }
    }
    else
    {
      str = paramString.substring(i2, i3);
    }
    for (;;)
    {
      a.b localb2 = (a.b)this.l.get(str);
      a.b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new a.b(this, str, null);
        this.l.put(str, localb1);
      }
      if ((i3 != -1) && (i1 == "CLEAN".length()) && (paramString.startsWith("CLEAN")))
      {
        paramString = paramString.substring(i3 + 1).split(" ");
        a.b.a(localb1, true);
        a.b.a(localb1, null);
        a.b.a(localb1, paramString);
        return;
      }
      if ((i3 == -1) && (i1 == "DIRTY".length()) && (paramString.startsWith("DIRTY")))
      {
        a.b.a(localb1, new a.a(this, localb1, null));
        return;
      }
      if ((i3 == -1) && (i1 == "READ".length()) && (paramString.startsWith("READ"))) {
        break;
      }
      throw new IOException("unexpected journal line: " + paramString);
    }
  }
  
  private void e(String paramString)
  {
    a.matcher(paramString).matches();
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: new 383	com/tencent/mobileqq/microapp/a/g
    //   3: dup
    //   4: new 385	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 103	com/tencent/mobileqq/microapp/a/a:d	Ljava/io/File;
    //   12: invokespecial 387	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: getstatic 389	com/tencent/mobileqq/microapp/a/i:a	Ljava/nio/charset/Charset;
    //   18: invokespecial 390	com/tencent/mobileqq/microapp/a/g:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   21: astore_2
    //   22: aload_2
    //   23: invokevirtual 391	com/tencent/mobileqq/microapp/a/g:a	()Ljava/lang/String;
    //   26: astore_3
    //   27: aload_2
    //   28: invokevirtual 391	com/tencent/mobileqq/microapp/a/g:a	()Ljava/lang/String;
    //   31: astore 4
    //   33: aload_2
    //   34: invokevirtual 391	com/tencent/mobileqq/microapp/a/g:a	()Ljava/lang/String;
    //   37: astore 5
    //   39: aload_2
    //   40: invokevirtual 391	com/tencent/mobileqq/microapp/a/g:a	()Ljava/lang/String;
    //   43: astore 6
    //   45: aload_2
    //   46: invokevirtual 391	com/tencent/mobileqq/microapp/a/g:a	()Ljava/lang/String;
    //   49: astore 7
    //   51: ldc_w 393
    //   54: aload_3
    //   55: invokevirtual 397	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifeq +55 -> 113
    //   61: ldc_w 399
    //   64: aload 4
    //   66: invokevirtual 397	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: ifeq +44 -> 113
    //   72: aload_0
    //   73: getfield 94	com/tencent/mobileqq/microapp/a/a:g	I
    //   76: invokestatic 403	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   79: aload 5
    //   81: invokevirtual 397	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq +29 -> 113
    //   87: aload_0
    //   88: getfield 113	com/tencent/mobileqq/microapp/a/a:i	I
    //   91: invokestatic 403	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   94: aload 6
    //   96: invokevirtual 397	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   99: ifeq +14 -> 113
    //   102: ldc_w 405
    //   105: aload 7
    //   107: invokevirtual 397	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   110: ifne +77 -> 187
    //   113: new 182	java/io/IOException
    //   116: dup
    //   117: new 154	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   124: ldc_w 407
    //   127: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_3
    //   131: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: ldc_w 409
    //   137: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload 4
    //   142: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc_w 409
    //   148: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload 6
    //   153: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc_w 409
    //   159: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload 7
    //   164: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: ldc_w 411
    //   170: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokespecial 333	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   179: athrow
    //   180: astore_3
    //   181: aload_2
    //   182: invokestatic 414	com/tencent/mobileqq/microapp/a/i:a	(Ljava/io/Closeable;)V
    //   185: aload_3
    //   186: athrow
    //   187: iconst_0
    //   188: istore_1
    //   189: aload_0
    //   190: aload_2
    //   191: invokevirtual 391	com/tencent/mobileqq/microapp/a/g:a	()Ljava/lang/String;
    //   194: invokespecial 416	com/tencent/mobileqq/microapp/a/a:d	(Ljava/lang/String;)V
    //   197: iload_1
    //   198: iconst_1
    //   199: iadd
    //   200: istore_1
    //   201: goto -12 -> 189
    //   204: astore_3
    //   205: aload_0
    //   206: iload_1
    //   207: aload_0
    //   208: getfield 63	com/tencent/mobileqq/microapp/a/a:l	Ljava/util/LinkedHashMap;
    //   211: invokevirtual 419	java/util/LinkedHashMap:size	()I
    //   214: isub
    //   215: putfield 118	com/tencent/mobileqq/microapp/a/a:m	I
    //   218: aload_2
    //   219: invokevirtual 421	com/tencent/mobileqq/microapp/a/g:b	()Z
    //   222: ifeq +12 -> 234
    //   225: aload_0
    //   226: invokespecial 236	com/tencent/mobileqq/microapp/a/a:j	()V
    //   229: aload_2
    //   230: invokestatic 414	com/tencent/mobileqq/microapp/a/i:a	(Ljava/io/Closeable;)V
    //   233: return
    //   234: aload_0
    //   235: new 423	java/io/BufferedWriter
    //   238: dup
    //   239: new 425	java/io/OutputStreamWriter
    //   242: dup
    //   243: new 427	java/io/FileOutputStream
    //   246: dup
    //   247: aload_0
    //   248: getfield 103	com/tencent/mobileqq/microapp/a/a:d	Ljava/io/File;
    //   251: iconst_1
    //   252: invokespecial 430	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   255: getstatic 389	com/tencent/mobileqq/microapp/a/i:a	Ljava/nio/charset/Charset;
    //   258: invokespecial 433	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   261: invokespecial 436	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   264: putfield 152	com/tencent/mobileqq/microapp/a/a:k	Ljava/io/Writer;
    //   267: goto -38 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	a
    //   188	27	1	i1	int
    //   21	209	2	localg	g
    //   26	105	3	str1	String
    //   180	6	3	localObject	Object
    //   204	1	3	localEOFException	java.io.EOFException
    //   31	110	4	str2	String
    //   37	43	5	str3	String
    //   43	109	6	str4	String
    //   49	114	7	str5	String
    // Exception table:
    //   from	to	target	type
    //   22	113	180	finally
    //   113	180	180	finally
    //   189	197	180	finally
    //   205	229	180	finally
    //   234	267	180	finally
    //   189	197	204	java/io/EOFException
  }
  
  private void i()
  {
    a(this.e);
    Iterator localIterator = this.l.values().iterator();
    while (localIterator.hasNext())
    {
      a.b localb = (a.b)localIterator.next();
      int i1;
      if (a.b.a(localb) == null)
      {
        i1 = 0;
        while (i1 < this.i)
        {
          this.j += a.b.b(localb)[i1];
          i1 += 1;
        }
      }
      else
      {
        a.b.a(localb, null);
        i1 = 0;
        while (i1 < this.i)
        {
          a(localb.a(i1));
          a(localb.b(i1));
          i1 += 1;
        }
        localIterator.remove();
      }
    }
  }
  
  private void j()
  {
    for (;;)
    {
      try
      {
        if (this.k != null) {
          this.k.close();
        }
        BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.e), i.a));
        a.b localb;
        try
        {
          localBufferedWriter.write("libcore.io.DiskLruCache");
          localBufferedWriter.write("\n");
          localBufferedWriter.write("1");
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.g));
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.i));
          localBufferedWriter.write("\n");
          localBufferedWriter.write("\n");
          Iterator localIterator = this.l.values().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localb = (a.b)localIterator.next();
          if (a.b.a(localb) != null)
          {
            localBufferedWriter.write("DIRTY " + a.b.c(localb) + '\n');
            continue;
            localObject1 = finally;
          }
        }
        finally
        {
          localBufferedWriter.close();
        }
        localObject1.write("CLEAN " + a.b.c(localb) + localb.a() + '\n');
      }
      finally {}
    }
    localObject1.close();
    if (this.d.exists()) {
      a(this.d, this.f, true);
    }
    a(this.e, this.d, false);
    this.f.delete();
    this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d, true), i.a));
  }
  
  private boolean k()
  {
    return (this.m >= 2000) && (this.m >= this.l.size());
  }
  
  private void l()
  {
    if (this.k == null) {
      throw new IllegalStateException("cache is closed");
    }
  }
  
  private void m()
  {
    if (this.j > this.h)
    {
      long l1 = this.h / 2L;
      while (this.j > l1) {
        c((String)((Map.Entry)this.l.entrySet().iterator().next()).getKey());
      }
    }
  }
  
  /* Error */
  public a.c a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: invokespecial 121	com/tencent/mobileqq/microapp/a/a:l	()V
    //   9: aload_0
    //   10: aload_1
    //   11: invokespecial 124	com/tencent/mobileqq/microapp/a/a:e	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 63	com/tencent/mobileqq/microapp/a/a:l	Ljava/util/LinkedHashMap;
    //   18: aload_1
    //   19: invokevirtual 128	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast 130	com/tencent/mobileqq/microapp/a/a$b
    //   25: astore 6
    //   27: aload 6
    //   29: ifnonnull +10 -> 39
    //   32: aload 4
    //   34: astore_3
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_3
    //   38: areturn
    //   39: aload 4
    //   41: astore_3
    //   42: aload 6
    //   44: invokestatic 250	com/tencent/mobileqq/microapp/a/a$b:d	(Lcom/tencent/mobileqq/microapp/a/a$b;)Z
    //   47: ifeq -12 -> 35
    //   50: aload_0
    //   51: getfield 113	com/tencent/mobileqq/microapp/a/a:i	I
    //   54: anewarray 486	java/io/InputStream
    //   57: astore 5
    //   59: iconst_0
    //   60: istore_2
    //   61: iload_2
    //   62: aload_0
    //   63: getfield 113	com/tencent/mobileqq/microapp/a/a:i	I
    //   66: if_icmpge +65 -> 131
    //   69: aload 5
    //   71: iload_2
    //   72: new 385	java/io/FileInputStream
    //   75: dup
    //   76: aload 6
    //   78: iload_2
    //   79: invokevirtual 266	com/tencent/mobileqq/microapp/a/a$b:a	(I)Ljava/io/File;
    //   82: invokespecial 387	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   85: aastore
    //   86: iload_2
    //   87: iconst_1
    //   88: iadd
    //   89: istore_2
    //   90: goto -29 -> 61
    //   93: astore_1
    //   94: iconst_0
    //   95: istore_2
    //   96: aload 4
    //   98: astore_3
    //   99: iload_2
    //   100: aload_0
    //   101: getfield 113	com/tencent/mobileqq/microapp/a/a:i	I
    //   104: if_icmpge -69 -> 35
    //   107: aload 4
    //   109: astore_3
    //   110: aload 5
    //   112: iload_2
    //   113: aaload
    //   114: ifnull -79 -> 35
    //   117: aload 5
    //   119: iload_2
    //   120: aaload
    //   121: invokestatic 414	com/tencent/mobileqq/microapp/a/i:a	(Ljava/io/Closeable;)V
    //   124: iload_2
    //   125: iconst_1
    //   126: iadd
    //   127: istore_2
    //   128: goto -32 -> 96
    //   131: aload_0
    //   132: aload_0
    //   133: getfield 118	com/tencent/mobileqq/microapp/a/a:m	I
    //   136: iconst_1
    //   137: iadd
    //   138: putfield 118	com/tencent/mobileqq/microapp/a/a:m	I
    //   141: aload_0
    //   142: getfield 152	com/tencent/mobileqq/microapp/a/a:k	Ljava/io/Writer;
    //   145: new 154	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   152: ldc_w 488
    //   155: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_1
    //   159: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: bipush 10
    //   164: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   167: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokevirtual 491	java/io/Writer:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   173: pop
    //   174: aload_0
    //   175: invokespecial 295	com/tencent/mobileqq/microapp/a/a:k	()Z
    //   178: ifeq +15 -> 193
    //   181: aload_0
    //   182: getfield 83	com/tencent/mobileqq/microapp/a/a:b	Ljava/util/concurrent/ThreadPoolExecutor;
    //   185: aload_0
    //   186: getfield 90	com/tencent/mobileqq/microapp/a/a:o	Ljava/util/concurrent/Callable;
    //   189: invokevirtual 299	java/util/concurrent/ThreadPoolExecutor:submit	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   192: pop
    //   193: new 493	com/tencent/mobileqq/microapp/a/a$c
    //   196: dup
    //   197: aload_0
    //   198: aload_1
    //   199: aload 6
    //   201: invokestatic 135	com/tencent/mobileqq/microapp/a/a$b:e	(Lcom/tencent/mobileqq/microapp/a/a$b;)J
    //   204: aload 5
    //   206: aload 6
    //   208: invokestatic 273	com/tencent/mobileqq/microapp/a/a$b:b	(Lcom/tencent/mobileqq/microapp/a/a$b;)[J
    //   211: aconst_null
    //   212: invokespecial 496	com/tencent/mobileqq/microapp/a/a$c:<init>	(Lcom/tencent/mobileqq/microapp/a/a;Ljava/lang/String;J[Ljava/io/InputStream;[JLcom/tencent/mobileqq/microapp/a/b;)V
    //   215: astore_3
    //   216: goto -181 -> 35
    //   219: astore_1
    //   220: aload_0
    //   221: monitorexit
    //   222: aload_1
    //   223: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	a
    //   0	224	1	paramString	String
    //   60	68	2	i1	int
    //   34	182	3	localObject1	Object
    //   1	107	4	localObject2	Object
    //   57	148	5	arrayOfInputStream	InputStream[]
    //   25	182	6	localb	a.b
    // Exception table:
    //   from	to	target	type
    //   61	86	93	java/io/FileNotFoundException
    //   5	27	219	finally
    //   42	59	219	finally
    //   61	86	219	finally
    //   99	107	219	finally
    //   117	124	219	finally
    //   131	193	219	finally
    //   193	216	219	finally
  }
  
  public Set a()
  {
    if (this.l == null) {
      return null;
    }
    return this.l.keySet();
  }
  
  public long b()
  {
    try
    {
      long l1 = this.h;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public a.a b(String paramString)
  {
    return a(paramString, -1L);
  }
  
  public long c()
  {
    try
    {
      long l1 = this.j;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean c(String paramString)
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        l();
        e(paramString);
        a.b localb = (a.b)this.l.get(paramString);
        Object localObject;
        if (localb != null)
        {
          localObject = a.b.a(localb);
          if (localObject == null) {}
        }
        else
        {
          bool = false;
          return bool;
          this.j -= a.b.b(localb)[i1];
          a.b.b(localb)[i1] = 0L;
          i1 += 1;
        }
        if (i1 < this.i)
        {
          localObject = localb.a(i1);
          if ((!((File)localObject).exists()) || (((File)localObject).delete())) {
            continue;
          }
          throw new IOException("failed to delete " + localObject);
        }
      }
      finally {}
      this.m += 1;
      this.k.append("REMOVE " + paramString + '\n');
      this.l.remove(paramString);
      if (k()) {
        this.b.submit(this.o);
      }
      boolean bool = true;
    }
  }
  
  public void close()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.k;
        if (localObject1 == null) {
          return;
        }
        localObject1 = new ArrayList(this.l.values()).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          a.b localb = (a.b)((Iterator)localObject1).next();
          if (a.b.a(localb) == null) {
            continue;
          }
          a.b.a(localb).b();
          continue;
        }
        m();
      }
      finally {}
      this.k.close();
      this.k = null;
    }
  }
  
  /* Error */
  public boolean d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 152	com/tencent/mobileqq/microapp/a/a:k	Ljava/io/Writer;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	a
    //   12	7	1	bool	boolean
    //   6	2	2	localWriter	Writer
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public void e()
  {
    try
    {
      l();
      m();
      this.k.flush();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void f()
  {
    close();
    i.a(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.a.a
 * JD-Core Version:    0.7.0.1
 */