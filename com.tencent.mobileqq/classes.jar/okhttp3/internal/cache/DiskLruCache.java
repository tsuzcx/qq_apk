package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.Okio;

public final class DiskLruCache
  implements Closeable, Flushable
{
  static final long ANY_SEQUENCE_NUMBER = -1L;
  private static final String CLEAN = "CLEAN";
  private static final String DIRTY = "DIRTY";
  static final String JOURNAL_FILE = "journal";
  static final String JOURNAL_FILE_BACKUP = "journal.bkp";
  static final String JOURNAL_FILE_TEMP = "journal.tmp";
  static final Pattern LEGAL_KEY_PATTERN;
  static final String MAGIC = "libcore.io.DiskLruCache";
  private static final String READ = "READ";
  private static final String REMOVE = "REMOVE";
  static final String VERSION_1 = "1";
  private final int appVersion;
  private final Runnable cleanupRunnable = new DiskLruCache.1(this);
  boolean closed;
  final File directory;
  private final Executor executor;
  final FileSystem fileSystem;
  boolean hasJournalErrors;
  boolean initialized;
  private final File journalFile;
  private final File journalFileBackup;
  private final File journalFileTmp;
  BufferedSink journalWriter;
  final LinkedHashMap<String, DiskLruCache.Entry> lruEntries = new LinkedHashMap(0, 0.75F, true);
  private long maxSize;
  boolean mostRecentRebuildFailed;
  boolean mostRecentTrimFailed;
  private long nextSequenceNumber = 0L;
  int redundantOpCount;
  private long size = 0L;
  final int valueCount;
  
  static
  {
    if (!DiskLruCache.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
      return;
    }
  }
  
  DiskLruCache(FileSystem paramFileSystem, File paramFile, int paramInt1, int paramInt2, long paramLong, Executor paramExecutor)
  {
    this.fileSystem = paramFileSystem;
    this.directory = paramFile;
    this.appVersion = paramInt1;
    this.journalFile = new File(paramFile, "journal");
    this.journalFileTmp = new File(paramFile, "journal.tmp");
    this.journalFileBackup = new File(paramFile, "journal.bkp");
    this.valueCount = paramInt2;
    this.maxSize = paramLong;
    this.executor = paramExecutor;
  }
  
  private void checkNotClosed()
  {
    try
    {
      if (isClosed()) {
        throw new IllegalStateException("cache is closed");
      }
    }
    finally {}
  }
  
  public static DiskLruCache create(FileSystem paramFileSystem, File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("valueCount <= 0");
    }
    return new DiskLruCache(paramFileSystem, paramFile, paramInt1, paramInt2, paramLong, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
  }
  
  private BufferedSink newJournalWriter()
  {
    return Okio.buffer(new DiskLruCache.2(this, this.fileSystem.appendingSink(this.journalFile)));
  }
  
  private void processJournal()
  {
    this.fileSystem.delete(this.journalFileTmp);
    Iterator localIterator = this.lruEntries.values().iterator();
    while (localIterator.hasNext())
    {
      DiskLruCache.Entry localEntry = (DiskLruCache.Entry)localIterator.next();
      int i;
      if (localEntry.currentEditor == null)
      {
        i = 0;
        while (i < this.valueCount)
        {
          this.size += localEntry.lengths[i];
          i += 1;
        }
      }
      else
      {
        localEntry.currentEditor = null;
        i = 0;
        while (i < this.valueCount)
        {
          this.fileSystem.delete(localEntry.cleanFiles[i]);
          this.fileSystem.delete(localEntry.dirtyFiles[i]);
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
    //   0: aload_0
    //   1: getfield 114	okhttp3/internal/cache/DiskLruCache:fileSystem	Lokhttp3/internal/io/FileSystem;
    //   4: aload_0
    //   5: getfield 125	okhttp3/internal/cache/DiskLruCache:journalFile	Ljava/io/File;
    //   8: invokeinterface 251 2 0
    //   13: invokestatic 254	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
    //   16: astore_2
    //   17: aload_2
    //   18: invokeinterface 260 1 0
    //   23: astore_3
    //   24: aload_2
    //   25: invokeinterface 260 1 0
    //   30: astore 4
    //   32: aload_2
    //   33: invokeinterface 260 1 0
    //   38: astore 5
    //   40: aload_2
    //   41: invokeinterface 260 1 0
    //   46: astore 6
    //   48: aload_2
    //   49: invokeinterface 260 1 0
    //   54: astore 7
    //   56: ldc 33
    //   58: aload_3
    //   59: invokevirtual 266	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   62: ifeq +54 -> 116
    //   65: ldc 40
    //   67: aload 4
    //   69: invokevirtual 266	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   72: ifeq +44 -> 116
    //   75: aload_0
    //   76: getfield 118	okhttp3/internal/cache/DiskLruCache:appVersion	I
    //   79: invokestatic 272	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   82: aload 5
    //   84: invokevirtual 266	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   87: ifeq +29 -> 116
    //   90: aload_0
    //   91: getfield 131	okhttp3/internal/cache/DiskLruCache:valueCount	I
    //   94: invokestatic 272	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   97: aload 6
    //   99: invokevirtual 266	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: ifeq +14 -> 116
    //   105: ldc_w 274
    //   108: aload 7
    //   110: invokevirtual 266	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   113: ifne +77 -> 190
    //   116: new 276	java/io/IOException
    //   119: dup
    //   120: new 278	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 279	java/lang/StringBuilder:<init>	()V
    //   127: ldc_w 281
    //   130: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_3
    //   134: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc_w 287
    //   140: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload 4
    //   145: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc_w 287
    //   151: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload 6
    //   156: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc_w 287
    //   162: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 7
    //   167: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc_w 289
    //   173: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokespecial 292	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   182: athrow
    //   183: astore_3
    //   184: aload_2
    //   185: invokestatic 296	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   188: aload_3
    //   189: athrow
    //   190: iconst_0
    //   191: istore_1
    //   192: aload_0
    //   193: aload_2
    //   194: invokeinterface 260 1 0
    //   199: invokespecial 299	okhttp3/internal/cache/DiskLruCache:readJournalLine	(Ljava/lang/String;)V
    //   202: iload_1
    //   203: iconst_1
    //   204: iadd
    //   205: istore_1
    //   206: goto -14 -> 192
    //   209: astore_3
    //   210: aload_0
    //   211: iload_1
    //   212: aload_0
    //   213: getfield 103	okhttp3/internal/cache/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   216: invokevirtual 302	java/util/LinkedHashMap:size	()I
    //   219: isub
    //   220: putfield 304	okhttp3/internal/cache/DiskLruCache:redundantOpCount	I
    //   223: aload_2
    //   224: invokeinterface 307 1 0
    //   229: ifne +12 -> 241
    //   232: aload_0
    //   233: invokevirtual 310	okhttp3/internal/cache/DiskLruCache:rebuildJournal	()V
    //   236: aload_2
    //   237: invokestatic 296	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   240: return
    //   241: aload_0
    //   242: aload_0
    //   243: invokespecial 312	okhttp3/internal/cache/DiskLruCache:newJournalWriter	()Lokio/BufferedSink;
    //   246: putfield 314	okhttp3/internal/cache/DiskLruCache:journalWriter	Lokio/BufferedSink;
    //   249: goto -13 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	DiskLruCache
    //   191	29	1	i	int
    //   16	221	2	localBufferedSource	okio.BufferedSource
    //   23	111	3	str1	String
    //   183	6	3	localObject	Object
    //   209	1	3	localEOFException	java.io.EOFException
    //   30	114	4	str2	String
    //   38	45	5	str3	String
    //   46	109	6	str4	String
    //   54	112	7	str5	String
    // Exception table:
    //   from	to	target	type
    //   17	116	183	finally
    //   116	183	183	finally
    //   192	202	183	finally
    //   210	236	183	finally
    //   241	249	183	finally
    //   192	202	209	java/io/EOFException
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
        localEntry1 = new DiskLruCache.Entry(this, str);
        this.lruEntries.put(str, localEntry1);
      }
      if ((k != -1) && (i == "CLEAN".length()) && (paramString.startsWith("CLEAN")))
      {
        paramString = paramString.substring(k + 1).split(" ");
        localEntry1.readable = true;
        localEntry1.currentEditor = null;
        localEntry1.setLengths(paramString);
        return;
      }
      if ((k == -1) && (i == "DIRTY".length()) && (paramString.startsWith("DIRTY")))
      {
        localEntry1.currentEditor = new DiskLruCache.Editor(this, localEntry1);
        return;
      }
      if ((k == -1) && (i == "READ".length()) && (paramString.startsWith("READ"))) {
        break;
      }
      throw new IOException("unexpected journal line: " + paramString);
    }
  }
  
  private void validateKey(String paramString)
  {
    if (!LEGAL_KEY_PATTERN.matcher(paramString).matches()) {
      throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + paramString + "\"");
    }
  }
  
  public void close()
  {
    for (;;)
    {
      try
      {
        if ((!this.initialized) || (this.closed))
        {
          this.closed = true;
          return;
        }
        DiskLruCache.Entry[] arrayOfEntry = (DiskLruCache.Entry[])this.lruEntries.values().toArray(new DiskLruCache.Entry[this.lruEntries.size()]);
        int j = arrayOfEntry.length;
        int i = 0;
        if (i < j)
        {
          DiskLruCache.Entry localEntry = arrayOfEntry[i];
          if (localEntry.currentEditor != null) {
            localEntry.currentEditor.abort();
          }
        }
        else
        {
          trimToSize();
          this.journalWriter.close();
          this.journalWriter = null;
          this.closed = true;
          continue;
        }
        i += 1;
      }
      finally {}
    }
  }
  
  void completeEdit(DiskLruCache.Editor paramEditor, boolean paramBoolean)
  {
    int k = 0;
    DiskLruCache.Entry localEntry;
    try
    {
      localEntry = paramEditor.entry;
      if (localEntry.currentEditor != paramEditor) {
        throw new IllegalStateException();
      }
    }
    finally {}
    int j = k;
    if (paramBoolean)
    {
      j = k;
      if (!localEntry.readable)
      {
        int i = 0;
        for (;;)
        {
          j = k;
          if (i >= this.valueCount) {
            break;
          }
          if (paramEditor.written[i] == 0)
          {
            paramEditor.abort();
            throw new IllegalStateException("Newly created entry didn't create value for index " + i);
          }
          if (!this.fileSystem.exists(localEntry.dirtyFiles[i]))
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
        paramEditor = localEntry.dirtyFiles[j];
        if (paramBoolean)
        {
          if (this.fileSystem.exists(paramEditor))
          {
            File localFile = localEntry.cleanFiles[j];
            this.fileSystem.rename(paramEditor, localFile);
            l1 = localEntry.lengths[j];
            long l2 = this.fileSystem.size(localFile);
            localEntry.lengths[j] = l2;
            this.size = (this.size - l1 + l2);
          }
        }
        else {
          this.fileSystem.delete(paramEditor);
        }
      }
      else
      {
        this.redundantOpCount += 1;
        localEntry.currentEditor = null;
        if ((localEntry.readable | paramBoolean))
        {
          localEntry.readable = true;
          this.journalWriter.writeUtf8("CLEAN").writeByte(32);
          this.journalWriter.writeUtf8(localEntry.key);
          localEntry.writeLengths(this.journalWriter);
          this.journalWriter.writeByte(10);
          if (paramBoolean)
          {
            l1 = this.nextSequenceNumber;
            this.nextSequenceNumber = (1L + l1);
            localEntry.sequenceNumber = l1;
          }
        }
        for (;;)
        {
          this.journalWriter.flush();
          if ((this.size <= this.maxSize) && (!journalRebuildRequired())) {
            break;
          }
          this.executor.execute(this.cleanupRunnable);
          break;
          this.lruEntries.remove(localEntry.key);
          this.journalWriter.writeUtf8("REMOVE").writeByte(32);
          this.journalWriter.writeUtf8(localEntry.key);
          this.journalWriter.writeByte(10);
        }
      }
      j += 1;
    }
  }
  
  public void delete()
  {
    close();
    this.fileSystem.deleteContents(this.directory);
  }
  
  @Nullable
  public DiskLruCache.Editor edit(String paramString)
  {
    return edit(paramString, -1L);
  }
  
  DiskLruCache.Editor edit(String paramString, long paramLong)
  {
    for (;;)
    {
      try
      {
        initialize();
        checkNotClosed();
        validateKey(paramString);
        Object localObject = (DiskLruCache.Entry)this.lruEntries.get(paramString);
        if (paramLong != -1L) {
          if (localObject != null)
          {
            long l = ((DiskLruCache.Entry)localObject).sequenceNumber;
            if (l == paramLong) {}
          }
          else
          {
            paramString = null;
            return paramString;
          }
        }
        if ((localObject != null) && (((DiskLruCache.Entry)localObject).currentEditor != null))
        {
          paramString = null;
        }
        else if ((this.mostRecentTrimFailed) || (this.mostRecentRebuildFailed))
        {
          this.executor.execute(this.cleanupRunnable);
          paramString = null;
        }
        else
        {
          this.journalWriter.writeUtf8("DIRTY").writeByte(32).writeUtf8(paramString).writeByte(10);
          this.journalWriter.flush();
          if (this.hasJournalErrors)
          {
            paramString = null;
          }
          else if (localObject == null)
          {
            localObject = new DiskLruCache.Entry(this, paramString);
            this.lruEntries.put(paramString, localObject);
            paramString = (String)localObject;
            localObject = new DiskLruCache.Editor(this, paramString);
            paramString.currentEditor = ((DiskLruCache.Editor)localObject);
            paramString = (String)localObject;
          }
          else
          {
            paramString = (String)localObject;
          }
        }
      }
      finally {}
    }
  }
  
  public void evictAll()
  {
    int i = 0;
    try
    {
      initialize();
      DiskLruCache.Entry[] arrayOfEntry = (DiskLruCache.Entry[])this.lruEntries.values().toArray(new DiskLruCache.Entry[this.lruEntries.size()]);
      int j = arrayOfEntry.length;
      while (i < j)
      {
        removeEntry(arrayOfEntry[i]);
        i += 1;
      }
      this.mostRecentTrimFailed = false;
      return;
    }
    finally {}
  }
  
  /* Error */
  public void flush()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 384	okhttp3/internal/cache/DiskLruCache:initialized	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokespecial 475	okhttp3/internal/cache/DiskLruCache:checkNotClosed	()V
    //   18: aload_0
    //   19: invokevirtual 398	okhttp3/internal/cache/DiskLruCache:trimToSize	()V
    //   22: aload_0
    //   23: getfield 314	okhttp3/internal/cache/DiskLruCache:journalWriter	Lokio/BufferedSink;
    //   26: invokeinterface 450 1 0
    //   31: goto -20 -> 11
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	DiskLruCache
    //   6	2	1	bool	boolean
    //   34	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	34	finally
    //   14	31	34	finally
  }
  
  /* Error */
  public DiskLruCache.Snapshot get(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 473	okhttp3/internal/cache/DiskLruCache:initialize	()V
    //   6: aload_0
    //   7: invokespecial 475	okhttp3/internal/cache/DiskLruCache:checkNotClosed	()V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 477	okhttp3/internal/cache/DiskLruCache:validateKey	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield 103	okhttp3/internal/cache/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   19: aload_1
    //   20: invokevirtual 342	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 226	okhttp3/internal/cache/DiskLruCache$Entry
    //   26: astore_3
    //   27: aload_3
    //   28: ifnull +12 -> 40
    //   31: aload_3
    //   32: getfield 358	okhttp3/internal/cache/DiskLruCache$Entry:readable	Z
    //   35: istore_2
    //   36: iload_2
    //   37: ifne +9 -> 46
    //   40: aconst_null
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: aload_3
    //   47: invokevirtual 493	okhttp3/internal/cache/DiskLruCache$Entry:snapshot	()Lokhttp3/internal/cache/DiskLruCache$Snapshot;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnonnull +8 -> 60
    //   55: aconst_null
    //   56: astore_1
    //   57: goto -15 -> 42
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 304	okhttp3/internal/cache/DiskLruCache:redundantOpCount	I
    //   65: iconst_1
    //   66: iadd
    //   67: putfield 304	okhttp3/internal/cache/DiskLruCache:redundantOpCount	I
    //   70: aload_0
    //   71: getfield 314	okhttp3/internal/cache/DiskLruCache:journalWriter	Lokio/BufferedSink;
    //   74: ldc 35
    //   76: invokeinterface 433 2 0
    //   81: bipush 32
    //   83: invokeinterface 437 2 0
    //   88: aload_1
    //   89: invokeinterface 433 2 0
    //   94: bipush 10
    //   96: invokeinterface 437 2 0
    //   101: pop
    //   102: aload_3
    //   103: astore_1
    //   104: aload_0
    //   105: invokevirtual 453	okhttp3/internal/cache/DiskLruCache:journalRebuildRequired	()Z
    //   108: ifeq -66 -> 42
    //   111: aload_0
    //   112: getfield 135	okhttp3/internal/cache/DiskLruCache:executor	Ljava/util/concurrent/Executor;
    //   115: aload_0
    //   116: getfield 112	okhttp3/internal/cache/DiskLruCache:cleanupRunnable	Ljava/lang/Runnable;
    //   119: invokeinterface 459 2 0
    //   124: aload_3
    //   125: astore_1
    //   126: goto -84 -> 42
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	DiskLruCache
    //   0	134	1	paramString	String
    //   35	2	2	bool	boolean
    //   26	99	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	27	129	finally
    //   31	36	129	finally
    //   46	51	129	finally
    //   60	102	129	finally
    //   104	124	129	finally
  }
  
  public File getDirectory()
  {
    return this.directory;
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
  
  public void initialize()
  {
    try
    {
      if ((!$assertionsDisabled) && (!Thread.holdsLock(this))) {
        throw new AssertionError();
      }
    }
    finally {}
    boolean bool = this.initialized;
    if (bool) {
      return;
    }
    if (this.fileSystem.exists(this.journalFileBackup))
    {
      if (!this.fileSystem.exists(this.journalFile)) {
        break label191;
      }
      this.fileSystem.delete(this.journalFileBackup);
    }
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          bool = this.fileSystem.exists(this.journalFile);
          if (bool) {
            try
            {
              readJournal();
              processJournal();
              this.initialized = true;
            }
            catch (IOException localIOException)
            {
              Platform.get().log(5, "DiskLruCache " + this.directory + " is corrupt: " + localIOException.getMessage() + ", removing", localIOException);
            }
          }
        }
        try
        {
          delete();
          this.closed = false;
          rebuildJournal();
          this.initialized = true;
        }
        finally
        {
          label191:
          this.closed = false;
        }
      }
      this.fileSystem.rename(this.journalFileBackup, this.journalFile);
    }
  }
  
  public boolean isClosed()
  {
    try
    {
      boolean bool = this.closed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  boolean journalRebuildRequired()
  {
    return (this.redundantOpCount >= 2000) && (this.redundantOpCount >= this.lruEntries.size());
  }
  
  void rebuildJournal()
  {
    for (;;)
    {
      DiskLruCache.Entry localEntry;
      try
      {
        if (this.journalWriter != null) {
          this.journalWriter.close();
        }
        BufferedSink localBufferedSink1 = Okio.buffer(this.fileSystem.sink(this.journalFileTmp));
        try
        {
          localBufferedSink1.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
          localBufferedSink1.writeUtf8("1").writeByte(10);
          localBufferedSink1.writeDecimalLong(this.appVersion).writeByte(10);
          localBufferedSink1.writeDecimalLong(this.valueCount).writeByte(10);
          localBufferedSink1.writeByte(10);
          Iterator localIterator = this.lruEntries.values().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localEntry = (DiskLruCache.Entry)localIterator.next();
          if (localEntry.currentEditor != null)
          {
            localBufferedSink1.writeUtf8("DIRTY").writeByte(32);
            localBufferedSink1.writeUtf8(localEntry.key);
            localBufferedSink1.writeByte(10);
            continue;
            localBufferedSink2 = finally;
          }
        }
        finally
        {
          localBufferedSink1.close();
        }
        localBufferedSink2.writeUtf8("CLEAN").writeByte(32);
      }
      finally {}
      localBufferedSink2.writeUtf8(localEntry.key);
      localEntry.writeLengths(localBufferedSink2);
      localBufferedSink2.writeByte(10);
    }
    localBufferedSink2.close();
    if (this.fileSystem.exists(this.journalFile)) {
      this.fileSystem.rename(this.journalFile, this.journalFileBackup);
    }
    this.fileSystem.rename(this.journalFileTmp, this.journalFile);
    this.fileSystem.delete(this.journalFileBackup);
    this.journalWriter = newJournalWriter();
    this.hasJournalErrors = false;
    this.mostRecentRebuildFailed = false;
  }
  
  /* Error */
  public boolean remove(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 473	okhttp3/internal/cache/DiskLruCache:initialize	()V
    //   6: aload_0
    //   7: invokespecial 475	okhttp3/internal/cache/DiskLruCache:checkNotClosed	()V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 477	okhttp3/internal/cache/DiskLruCache:validateKey	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield 103	okhttp3/internal/cache/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   19: aload_1
    //   20: invokevirtual 342	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 226	okhttp3/internal/cache/DiskLruCache$Entry
    //   26: astore_1
    //   27: aload_1
    //   28: ifnonnull +9 -> 37
    //   31: iconst_0
    //   32: istore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: iload_2
    //   36: ireturn
    //   37: aload_0
    //   38: aload_1
    //   39: invokevirtual 488	okhttp3/internal/cache/DiskLruCache:removeEntry	(Lokhttp3/internal/cache/DiskLruCache$Entry;)Z
    //   42: istore_3
    //   43: iload_3
    //   44: istore_2
    //   45: iload_3
    //   46: ifeq -13 -> 33
    //   49: iload_3
    //   50: istore_2
    //   51: aload_0
    //   52: getfield 95	okhttp3/internal/cache/DiskLruCache:size	J
    //   55: aload_0
    //   56: getfield 133	okhttp3/internal/cache/DiskLruCache:maxSize	J
    //   59: lcmp
    //   60: ifgt -27 -> 33
    //   63: aload_0
    //   64: iconst_0
    //   65: putfield 479	okhttp3/internal/cache/DiskLruCache:mostRecentTrimFailed	Z
    //   68: iload_3
    //   69: istore_2
    //   70: goto -37 -> 33
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	DiskLruCache
    //   0	78	1	paramString	String
    //   32	38	2	bool1	boolean
    //   42	27	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   2	27	73	finally
    //   37	43	73	finally
    //   51	68	73	finally
  }
  
  boolean removeEntry(DiskLruCache.Entry paramEntry)
  {
    if (paramEntry.currentEditor != null) {
      paramEntry.currentEditor.detach();
    }
    int i = 0;
    while (i < this.valueCount)
    {
      this.fileSystem.delete(paramEntry.cleanFiles[i]);
      this.size -= paramEntry.lengths[i];
      paramEntry.lengths[i] = 0L;
      i += 1;
    }
    this.redundantOpCount += 1;
    this.journalWriter.writeUtf8("REMOVE").writeByte(32).writeUtf8(paramEntry.key).writeByte(10);
    this.lruEntries.remove(paramEntry.key);
    if (journalRebuildRequired()) {
      this.executor.execute(this.cleanupRunnable);
    }
    return true;
  }
  
  public void setMaxSize(long paramLong)
  {
    try
    {
      this.maxSize = paramLong;
      if (this.initialized) {
        this.executor.execute(this.cleanupRunnable);
      }
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
      initialize();
      long l = this.size;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Iterator<DiskLruCache.Snapshot> snapshots()
  {
    try
    {
      initialize();
      DiskLruCache.3 local3 = new DiskLruCache.3(this);
      return local3;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void trimToSize()
  {
    while (this.size > this.maxSize) {
      removeEntry((DiskLruCache.Entry)this.lruEntries.values().iterator().next());
    }
    this.mostRecentTrimFailed = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.internal.cache.DiskLruCache
 * JD-Core Version:    0.7.0.1
 */