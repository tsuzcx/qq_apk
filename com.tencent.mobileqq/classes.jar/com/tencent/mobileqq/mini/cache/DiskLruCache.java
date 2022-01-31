package com.tencent.mobileqq.mini.cache;

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

public final class DiskLruCache
  implements Closeable
{
  static final long ANY_SEQUENCE_NUMBER = -1L;
  private static final String CLEAN = "CLEAN";
  private static final String DIRTY = "DIRTY";
  static final String JOURNAL_FILE = "journal";
  static final String JOURNAL_FILE_BACKUP = "journal.bkp";
  static final String JOURNAL_FILE_TEMP = "journal.tmp";
  static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[A-Za-z0-9_-]{1,120}");
  static final String MAGIC = "libcore.io.DiskLruCache";
  private static final OutputStream NULL_OUTPUT_STREAM = new DiskLruCache.2();
  private static final String READ = "READ";
  private static final String REMOVE = "REMOVE";
  static final String STRING_KEY_PATTERN = "[A-Za-z0-9_-]{1,120}";
  static final String VERSION_1 = "1";
  private final int appVersion;
  private final Callable<Void> cleanupCallable = new DiskLruCache.1(this);
  private final File directory;
  final ThreadPoolExecutor executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  private final File journalFile;
  private final File journalFileBackup;
  private final File journalFileTmp;
  private Writer journalWriter;
  private final LinkedHashMap<String, DiskLruCache.Entry> lruEntries = new LinkedHashMap(0, 0.75F, true);
  private long maxSize;
  private long nextSequenceNumber;
  private int redundantOpCount;
  private long size;
  private final int valueCount;
  
  private DiskLruCache(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    this.directory = paramFile;
    this.appVersion = paramInt1;
    this.journalFile = new File(paramFile, "journal");
    this.journalFileTmp = new File(paramFile, "journal.tmp");
    this.journalFileBackup = new File(paramFile, "journal.bkp");
    this.valueCount = paramInt2;
    this.maxSize = paramLong;
  }
  
  private void checkNotClosed()
  {
    if (this.journalWriter == null) {
      throw new IllegalStateException("cache is closed");
    }
  }
  
  private void completeEdit(DiskLruCache.Editor paramEditor, boolean paramBoolean)
  {
    int k = 0;
    DiskLruCache.Entry localEntry;
    try
    {
      localEntry = DiskLruCache.Editor.access$1400(paramEditor);
      if (DiskLruCache.Entry.access$700(localEntry) != paramEditor) {
        throw new IllegalStateException();
      }
    }
    finally {}
    int j = k;
    if (paramBoolean)
    {
      j = k;
      if (!DiskLruCache.Entry.access$600(localEntry))
      {
        int i = 0;
        for (;;)
        {
          j = k;
          if (i >= this.valueCount) {
            break;
          }
          if (DiskLruCache.Editor.access$1500(paramEditor)[i] == 0)
          {
            paramEditor.abort();
            throw new IllegalStateException("Newly created entry didn't create value for index " + i);
          }
          if (!localEntry.getDirtyFile(i).exists())
          {
            paramEditor.abort();
            return;
          }
          i += 1;
        }
      }
    }
    for (;;)
    {
      long l1;
      if (j < this.valueCount)
      {
        paramEditor = localEntry.getDirtyFile(j);
        if (paramBoolean)
        {
          if (paramEditor.exists())
          {
            File localFile = localEntry.getCleanFile(j);
            paramEditor.renameTo(localFile);
            l1 = DiskLruCache.Entry.access$1000(localEntry)[j];
            long l2 = localFile.length();
            DiskLruCache.Entry.access$1000(localEntry)[j] = l2;
            this.size = (this.size - l1 + l2);
          }
        }
        else {
          deleteIfExists(paramEditor);
        }
      }
      else
      {
        this.redundantOpCount += 1;
        DiskLruCache.Entry.access$702(localEntry, null);
        if ((DiskLruCache.Entry.access$600(localEntry) | paramBoolean))
        {
          DiskLruCache.Entry.access$602(localEntry, true);
          this.journalWriter.write("CLEAN " + DiskLruCache.Entry.access$1100(localEntry) + localEntry.getLengths() + '\n');
          if (paramBoolean)
          {
            l1 = this.nextSequenceNumber;
            this.nextSequenceNumber = (1L + l1);
            DiskLruCache.Entry.access$1202(localEntry, l1);
          }
        }
        for (;;)
        {
          this.journalWriter.flush();
          if ((this.size <= this.maxSize) && (!journalRebuildRequired())) {
            break;
          }
          this.executorService.submit(this.cleanupCallable);
          break;
          this.lruEntries.remove(DiskLruCache.Entry.access$1100(localEntry));
          this.journalWriter.write("REMOVE " + DiskLruCache.Entry.access$1100(localEntry) + '\n');
        }
      }
      j += 1;
    }
  }
  
  private static void deleteIfExists(File paramFile)
  {
    if ((paramFile.exists()) && (!paramFile.delete())) {
      throw new IOException();
    }
  }
  
  private DiskLruCache.Editor edit(String paramString, long paramLong)
  {
    for (;;)
    {
      DiskLruCache.Editor localEditor;
      try
      {
        checkNotClosed();
        validateKey(paramString);
        DiskLruCache.Entry localEntry = (DiskLruCache.Entry)this.lruEntries.get(paramString);
        if (paramLong != -1L) {
          if (localEntry != null)
          {
            long l = DiskLruCache.Entry.access$1200(localEntry);
            if (l == paramLong) {}
          }
          else
          {
            paramString = null;
            return paramString;
          }
        }
        if (localEntry == null)
        {
          localEntry = new DiskLruCache.Entry(this, paramString, null);
          this.lruEntries.put(paramString, localEntry);
          localEditor = new DiskLruCache.Editor(this, localEntry, null);
          DiskLruCache.Entry.access$702(localEntry, localEditor);
          this.journalWriter.write("DIRTY " + paramString + '\n');
          this.journalWriter.flush();
          paramString = localEditor;
          continue;
        }
        localEditor = DiskLruCache.Entry.access$700(localEntry);
      }
      finally {}
      if (localEditor != null) {
        paramString = null;
      }
    }
  }
  
  private static String inputStreamToString(InputStream paramInputStream)
  {
    return Util.readFully(new InputStreamReader(paramInputStream, Util.UTF_8));
  }
  
  private boolean journalRebuildRequired()
  {
    return (this.redundantOpCount >= 2000) && (this.redundantOpCount >= this.lruEntries.size());
  }
  
  public static DiskLruCache open(File paramFile, int paramInt1, int paramInt2, long paramLong)
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
        break label115;
      }
      ((File)localObject).delete();
    }
    for (;;)
    {
      localObject = new DiskLruCache(paramFile, paramInt1, paramInt2, paramLong);
      if (!((DiskLruCache)localObject).journalFile.exists()) {
        break label179;
      }
      try
      {
        ((DiskLruCache)localObject).readJournal();
        ((DiskLruCache)localObject).processJournal();
        return localObject;
      }
      catch (IOException localIOException)
      {
        label115:
        System.out.println("DiskLruCache " + paramFile + " is corrupt: " + localIOException.getMessage() + ", removing");
        ((DiskLruCache)localObject).delete();
      }
      renameTo((File)localObject, localFile, false);
    }
    label179:
    paramFile.mkdirs();
    paramFile = new DiskLruCache(paramFile, paramInt1, paramInt2, paramLong);
    paramFile.rebuildJournal();
    return paramFile;
  }
  
  private void processJournal()
  {
    deleteIfExists(this.journalFileTmp);
    Iterator localIterator = this.lruEntries.values().iterator();
    while (localIterator.hasNext())
    {
      DiskLruCache.Entry localEntry = (DiskLruCache.Entry)localIterator.next();
      int i;
      if (DiskLruCache.Entry.access$700(localEntry) == null)
      {
        i = 0;
        while (i < this.valueCount)
        {
          this.size += DiskLruCache.Entry.access$1000(localEntry)[i];
          i += 1;
        }
      }
      else
      {
        DiskLruCache.Entry.access$702(localEntry, null);
        i = 0;
        while (i < this.valueCount)
        {
          deleteIfExists(localEntry.getCleanFile(i));
          deleteIfExists(localEntry.getDirtyFile(i));
          i += 1;
        }
        localIterator.remove();
      }
    }
  }
  
  /* Error */
  private void readJournal()
  {
    // Byte code:
    //   0: new 421	com/tencent/mobileqq/mini/cache/StrictLineReader
    //   3: dup
    //   4: new 423	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 127	com/tencent/mobileqq/mini/cache/DiskLruCache:journalFile	Ljava/io/File;
    //   12: invokespecial 425	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: getstatic 428	com/tencent/mobileqq/mini/cache/Util:US_ASCII	Ljava/nio/charset/Charset;
    //   18: invokespecial 429	com/tencent/mobileqq/mini/cache/StrictLineReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   21: astore_2
    //   22: aload_2
    //   23: invokevirtual 432	com/tencent/mobileqq/mini/cache/StrictLineReader:readLine	()Ljava/lang/String;
    //   26: astore_3
    //   27: aload_2
    //   28: invokevirtual 432	com/tencent/mobileqq/mini/cache/StrictLineReader:readLine	()Ljava/lang/String;
    //   31: astore 4
    //   33: aload_2
    //   34: invokevirtual 432	com/tencent/mobileqq/mini/cache/StrictLineReader:readLine	()Ljava/lang/String;
    //   37: astore 5
    //   39: aload_2
    //   40: invokevirtual 432	com/tencent/mobileqq/mini/cache/StrictLineReader:readLine	()Ljava/lang/String;
    //   43: astore 6
    //   45: aload_2
    //   46: invokevirtual 432	com/tencent/mobileqq/mini/cache/StrictLineReader:readLine	()Ljava/lang/String;
    //   49: astore 7
    //   51: ldc 29
    //   53: aload_3
    //   54: invokevirtual 438	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifeq +54 -> 111
    //   60: ldc 41
    //   62: aload 4
    //   64: invokevirtual 438	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: ifeq +44 -> 111
    //   70: aload_0
    //   71: getfield 120	com/tencent/mobileqq/mini/cache/DiskLruCache:appVersion	I
    //   74: invokestatic 443	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   77: aload 5
    //   79: invokevirtual 438	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   82: ifeq +29 -> 111
    //   85: aload_0
    //   86: getfield 133	com/tencent/mobileqq/mini/cache/DiskLruCache:valueCount	I
    //   89: invokestatic 443	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   92: aload 6
    //   94: invokevirtual 438	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   97: ifeq +14 -> 111
    //   100: ldc_w 445
    //   103: aload 7
    //   105: invokevirtual 438	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   108: ifne +77 -> 185
    //   111: new 305	java/io/IOException
    //   114: dup
    //   115: new 214	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   122: ldc_w 447
    //   125: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_3
    //   129: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc_w 449
    //   135: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload 4
    //   140: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 449
    //   146: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload 6
    //   151: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc_w 449
    //   157: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 7
    //   162: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w 451
    //   168: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokespecial 452	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   177: athrow
    //   178: astore_3
    //   179: aload_2
    //   180: invokestatic 456	com/tencent/mobileqq/mini/cache/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   183: aload_3
    //   184: athrow
    //   185: iconst_0
    //   186: istore_1
    //   187: aload_0
    //   188: aload_2
    //   189: invokevirtual 432	com/tencent/mobileqq/mini/cache/StrictLineReader:readLine	()Ljava/lang/String;
    //   192: invokespecial 459	com/tencent/mobileqq/mini/cache/DiskLruCache:readJournalLine	(Ljava/lang/String;)V
    //   195: iload_1
    //   196: iconst_1
    //   197: iadd
    //   198: istore_1
    //   199: goto -12 -> 187
    //   202: astore_3
    //   203: aload_0
    //   204: iload_1
    //   205: aload_0
    //   206: getfield 91	com/tencent/mobileqq/mini/cache/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   209: invokevirtual 348	java/util/LinkedHashMap:size	()I
    //   212: isub
    //   213: putfield 180	com/tencent/mobileqq/mini/cache/DiskLruCache:redundantOpCount	I
    //   216: aload_2
    //   217: invokevirtual 462	com/tencent/mobileqq/mini/cache/StrictLineReader:hasUnterminatedLine	()Z
    //   220: ifeq +12 -> 232
    //   223: aload_0
    //   224: invokespecial 176	com/tencent/mobileqq/mini/cache/DiskLruCache:rebuildJournal	()V
    //   227: aload_2
    //   228: invokestatic 456	com/tencent/mobileqq/mini/cache/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   231: return
    //   232: aload_0
    //   233: new 464	java/io/BufferedWriter
    //   236: dup
    //   237: new 466	java/io/OutputStreamWriter
    //   240: dup
    //   241: new 468	java/io/FileOutputStream
    //   244: dup
    //   245: aload_0
    //   246: getfield 127	com/tencent/mobileqq/mini/cache/DiskLruCache:journalFile	Ljava/io/File;
    //   249: iconst_1
    //   250: invokespecial 471	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   253: getstatic 428	com/tencent/mobileqq/mini/cache/Util:US_ASCII	Ljava/nio/charset/Charset;
    //   256: invokespecial 474	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   259: invokespecial 477	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   262: putfield 139	com/tencent/mobileqq/mini/cache/DiskLruCache:journalWriter	Ljava/io/Writer;
    //   265: goto -38 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	DiskLruCache
    //   186	27	1	i	int
    //   21	207	2	localStrictLineReader	StrictLineReader
    //   26	103	3	str1	String
    //   178	6	3	localObject	Object
    //   202	1	3	localEOFException	java.io.EOFException
    //   31	108	4	str2	String
    //   37	41	5	str3	String
    //   43	107	6	str4	String
    //   49	112	7	str5	String
    // Exception table:
    //   from	to	target	type
    //   22	111	178	finally
    //   111	178	178	finally
    //   187	195	178	finally
    //   203	227	178	finally
    //   232	265	178	finally
    //   187	195	202	java/io/EOFException
  }
  
  private void readJournalLine(String paramString)
  {
    int i = paramString.indexOf(' ');
    if (i == -1) {
      throw new IOException("unexpected journal line: " + paramString);
    }
    int j = i + 1;
    int k = paramString.indexOf(' ', j);
    String str;
    if (k == -1)
    {
      str = paramString.substring(j);
      if ((i == "REMOVE".length()) && (paramString.startsWith("REMOVE"))) {
        this.lruEntries.remove(str);
      }
    }
    else
    {
      str = paramString.substring(j, k);
    }
    for (;;)
    {
      DiskLruCache.Entry localEntry2 = (DiskLruCache.Entry)this.lruEntries.get(str);
      DiskLruCache.Entry localEntry1 = localEntry2;
      if (localEntry2 == null)
      {
        localEntry1 = new DiskLruCache.Entry(this, str, null);
        this.lruEntries.put(str, localEntry1);
      }
      if ((k != -1) && (i == "CLEAN".length()) && (paramString.startsWith("CLEAN")))
      {
        paramString = paramString.substring(k + 1).split(" ");
        DiskLruCache.Entry.access$602(localEntry1, true);
        DiskLruCache.Entry.access$702(localEntry1, null);
        DiskLruCache.Entry.access$800(localEntry1, paramString);
        return;
      }
      if ((k == -1) && (i == "DIRTY".length()) && (paramString.startsWith("DIRTY")))
      {
        DiskLruCache.Entry.access$702(localEntry1, new DiskLruCache.Editor(this, localEntry1, null));
        return;
      }
      if ((k == -1) && (i == "READ".length()) && (paramString.startsWith("READ"))) {
        break;
      }
      throw new IOException("unexpected journal line: " + paramString);
    }
  }
  
  private void rebuildJournal()
  {
    for (;;)
    {
      try
      {
        if (this.journalWriter != null) {
          this.journalWriter.close();
        }
        BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), Util.US_ASCII));
        DiskLruCache.Entry localEntry;
        try
        {
          localBufferedWriter.write("libcore.io.DiskLruCache");
          localBufferedWriter.write("\n");
          localBufferedWriter.write("1");
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.appVersion));
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.valueCount));
          localBufferedWriter.write("\n");
          localBufferedWriter.write("\n");
          Iterator localIterator = this.lruEntries.values().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localEntry = (DiskLruCache.Entry)localIterator.next();
          if (DiskLruCache.Entry.access$700(localEntry) != null)
          {
            localBufferedWriter.write("DIRTY " + DiskLruCache.Entry.access$1100(localEntry) + '\n');
            continue;
            localObject1 = finally;
          }
        }
        finally
        {
          localBufferedWriter.close();
        }
        localObject1.write("CLEAN " + DiskLruCache.Entry.access$1100(localEntry) + localEntry.getLengths() + '\n');
      }
      finally {}
    }
    localObject1.close();
    if (this.journalFile.exists()) {
      renameTo(this.journalFile, this.journalFileBackup, true);
    }
    renameTo(this.journalFileTmp, this.journalFile, false);
    this.journalFileBackup.delete();
    this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
  }
  
  private static void renameTo(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramBoolean) {
      deleteIfExists(paramFile2);
    }
    if (!paramFile1.renameTo(paramFile2)) {
      throw new IOException();
    }
  }
  
  private void trimToSize()
  {
    if (this.size > this.maxSize)
    {
      long l = this.maxSize / 2L;
      while (this.size > l) {
        remove((String)((Map.Entry)this.lruEntries.entrySet().iterator().next()).getKey());
      }
    }
  }
  
  private void validateKey(String paramString)
  {
    if (!LEGAL_KEY_PATTERN.matcher(paramString).matches()) {}
  }
  
  public void close()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.journalWriter;
        if (localObject1 == null) {
          return;
        }
        localObject1 = new ArrayList(this.lruEntries.values()).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          DiskLruCache.Entry localEntry = (DiskLruCache.Entry)((Iterator)localObject1).next();
          if (DiskLruCache.Entry.access$700(localEntry) == null) {
            continue;
          }
          DiskLruCache.Entry.access$700(localEntry).abort();
          continue;
        }
        trimToSize();
      }
      finally {}
      this.journalWriter.close();
      this.journalWriter = null;
    }
  }
  
  public void delete()
  {
    close();
    Util.deleteContents(this.directory);
    this.size = 0L;
  }
  
  public DiskLruCache.Editor edit(String paramString)
  {
    return edit(paramString, -1L);
  }
  
  public void flush()
  {
    try
    {
      checkNotClosed();
      trimToSize();
      this.journalWriter.flush();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public DiskLruCache.Snapshot get(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: invokespecial 308	com/tencent/mobileqq/mini/cache/DiskLruCache:checkNotClosed	()V
    //   9: aload_0
    //   10: aload_1
    //   11: invokespecial 311	com/tencent/mobileqq/mini/cache/DiskLruCache:validateKey	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 91	com/tencent/mobileqq/mini/cache/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   18: aload_1
    //   19: invokevirtual 314	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast 196	com/tencent/mobileqq/mini/cache/DiskLruCache$Entry
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
    //   44: invokestatic 205	com/tencent/mobileqq/mini/cache/DiskLruCache$Entry:access$600	(Lcom/tencent/mobileqq/mini/cache/DiskLruCache$Entry;)Z
    //   47: ifeq -12 -> 35
    //   50: aload_0
    //   51: getfield 133	com/tencent/mobileqq/mini/cache/DiskLruCache:valueCount	I
    //   54: anewarray 555	java/io/InputStream
    //   57: astore 5
    //   59: iconst_0
    //   60: istore_2
    //   61: iload_2
    //   62: aload_0
    //   63: getfield 133	com/tencent/mobileqq/mini/cache/DiskLruCache:valueCount	I
    //   66: if_icmpge +65 -> 131
    //   69: aload 5
    //   71: iload_2
    //   72: new 423	java/io/FileInputStream
    //   75: dup
    //   76: aload 6
    //   78: iload_2
    //   79: invokevirtual 238	com/tencent/mobileqq/mini/cache/DiskLruCache$Entry:getCleanFile	(I)Ljava/io/File;
    //   82: invokespecial 425	java/io/FileInputStream:<init>	(Ljava/io/File;)V
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
    //   101: getfield 133	com/tencent/mobileqq/mini/cache/DiskLruCache:valueCount	I
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
    //   121: invokestatic 456	com/tencent/mobileqq/mini/cache/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   124: iload_2
    //   125: iconst_1
    //   126: iadd
    //   127: istore_2
    //   128: goto -32 -> 96
    //   131: aload_0
    //   132: aload_0
    //   133: getfield 180	com/tencent/mobileqq/mini/cache/DiskLruCache:redundantOpCount	I
    //   136: iconst_1
    //   137: iadd
    //   138: putfield 180	com/tencent/mobileqq/mini/cache/DiskLruCache:redundantOpCount	I
    //   141: aload_0
    //   142: getfield 139	com/tencent/mobileqq/mini/cache/DiskLruCache:journalWriter	Ljava/io/Writer;
    //   145: new 214	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   152: ldc_w 557
    //   155: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_1
    //   159: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: bipush 10
    //   164: invokevirtual 276	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   167: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokevirtual 560	java/io/Writer:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   173: pop
    //   174: aload_0
    //   175: invokespecial 164	com/tencent/mobileqq/mini/cache/DiskLruCache:journalRebuildRequired	()Z
    //   178: ifeq +15 -> 193
    //   181: aload_0
    //   182: getfield 109	com/tencent/mobileqq/mini/cache/DiskLruCache:executorService	Ljava/util/concurrent/ThreadPoolExecutor;
    //   185: aload_0
    //   186: getfield 116	com/tencent/mobileqq/mini/cache/DiskLruCache:cleanupCallable	Ljava/util/concurrent/Callable;
    //   189: invokevirtual 294	java/util/concurrent/ThreadPoolExecutor:submit	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   192: pop
    //   193: new 562	com/tencent/mobileqq/mini/cache/DiskLruCache$Snapshot
    //   196: dup
    //   197: aload_0
    //   198: aload_1
    //   199: aload 6
    //   201: invokestatic 318	com/tencent/mobileqq/mini/cache/DiskLruCache$Entry:access$1200	(Lcom/tencent/mobileqq/mini/cache/DiskLruCache$Entry;)J
    //   204: aload 5
    //   206: aload 6
    //   208: invokestatic 246	com/tencent/mobileqq/mini/cache/DiskLruCache$Entry:access$1000	(Lcom/tencent/mobileqq/mini/cache/DiskLruCache$Entry;)[J
    //   211: aconst_null
    //   212: invokespecial 565	com/tencent/mobileqq/mini/cache/DiskLruCache$Snapshot:<init>	(Lcom/tencent/mobileqq/mini/cache/DiskLruCache;Ljava/lang/String;J[Ljava/io/InputStream;[JLcom/tencent/mobileqq/mini/cache/DiskLruCache$1;)V
    //   215: astore_3
    //   216: goto -181 -> 35
    //   219: astore_1
    //   220: aload_0
    //   221: monitorexit
    //   222: aload_1
    //   223: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	DiskLruCache
    //   0	224	1	paramString	String
    //   60	68	2	i	int
    //   34	182	3	localObject1	Object
    //   1	107	4	localObject2	Object
    //   57	148	5	arrayOfInputStream	InputStream[]
    //   25	182	6	localEntry	DiskLruCache.Entry
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
  
  public File getDirectory()
  {
    return this.directory;
  }
  
  public Set<String> getKeys()
  {
    if (this.lruEntries == null) {
      return null;
    }
    return this.lruEntries.keySet();
  }
  
  public long getMaxSize()
  {
    try
    {
      long l = this.maxSize;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean isClosed()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 139	com/tencent/mobileqq/mini/cache/DiskLruCache:journalWriter	Ljava/io/Writer;
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
    //   0	27	0	this	DiskLruCache
    //   12	7	1	bool	boolean
    //   6	2	2	localWriter	Writer
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public boolean remove(String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        checkNotClosed();
        validateKey(paramString);
        DiskLruCache.Entry localEntry = (DiskLruCache.Entry)this.lruEntries.get(paramString);
        Object localObject;
        if (localEntry != null)
        {
          localObject = DiskLruCache.Entry.access$700(localEntry);
          if (localObject == null) {}
        }
        else
        {
          bool = false;
          return bool;
          this.size -= DiskLruCache.Entry.access$1000(localEntry)[i];
          DiskLruCache.Entry.access$1000(localEntry)[i] = 0L;
          i += 1;
        }
        if (i < this.valueCount)
        {
          localObject = localEntry.getCleanFile(i);
          if ((!((File)localObject).exists()) || (((File)localObject).delete())) {
            continue;
          }
          throw new IOException("failed to delete " + localObject);
        }
      }
      finally {}
      this.redundantOpCount += 1;
      this.journalWriter.append("REMOVE " + paramString + '\n');
      this.lruEntries.remove(paramString);
      if (journalRebuildRequired()) {
        this.executorService.submit(this.cleanupCallable);
      }
      boolean bool = true;
    }
  }
  
  public void setMaxSize(long paramLong)
  {
    try
    {
      this.maxSize = paramLong;
      this.executorService.submit(this.cleanupCallable);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long size()
  {
    try
    {
      long l = this.size;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.cache.DiskLruCache
 * JD-Core Version:    0.7.0.1
 */