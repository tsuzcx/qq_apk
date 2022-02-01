package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.EOFException;
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
import okio.BufferedSource;
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
  static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
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
      boolean bool = isClosed();
      if (!bool) {
        return;
      }
      throw new IllegalStateException("cache is closed");
    }
    finally {}
  }
  
  public static DiskLruCache create(FileSystem paramFileSystem, File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramLong > 0L)
    {
      if (paramInt2 > 0) {
        return new DiskLruCache(paramFileSystem, paramFile, paramInt1, paramInt2, paramLong, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
      }
      throw new IllegalArgumentException("valueCount <= 0");
    }
    throw new IllegalArgumentException("maxSize <= 0");
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
      DiskLruCache.Editor localEditor = localEntry.currentEditor;
      int j = 0;
      int i = 0;
      if (localEditor == null)
      {
        while (i < this.valueCount)
        {
          this.size += localEntry.lengths[i];
          i += 1;
        }
      }
      else
      {
        localEntry.currentEditor = null;
        i = j;
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
  
  private void readJournal()
  {
    localBufferedSource = Okio.buffer(this.fileSystem.source(this.journalFile));
    for (;;)
    {
      try
      {
        str1 = localBufferedSource.readUtf8LineStrict();
        str2 = localBufferedSource.readUtf8LineStrict();
        localObject2 = localBufferedSource.readUtf8LineStrict();
        str3 = localBufferedSource.readUtf8LineStrict();
        str4 = localBufferedSource.readUtf8LineStrict();
        if (("libcore.io.DiskLruCache".equals(str1)) && ("1".equals(str2)) && (Integer.toString(this.appVersion).equals(localObject2)) && (Integer.toString(this.valueCount).equals(str3)))
        {
          boolean bool = "".equals(str4);
          if (bool) {
            i = 0;
          }
        }
      }
      finally
      {
        String str1;
        String str2;
        Object localObject2;
        String str3;
        String str4;
        int i;
        Util.closeQuietly(localBufferedSource);
        continue;
        throw localObject1;
        continue;
      }
      try
      {
        readJournalLine(localBufferedSource.readUtf8LineStrict());
        i += 1;
      }
      catch (EOFException localEOFException) {}
    }
    this.redundantOpCount = (i - this.lruEntries.size());
    if (!localBufferedSource.exhausted()) {
      rebuildJournal();
    } else {
      this.journalWriter = newJournalWriter();
    }
    Util.closeQuietly(localBufferedSource);
    return;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("unexpected journal header: [");
    ((StringBuilder)localObject2).append(str1);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(str2);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(str3);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(str4);
    ((StringBuilder)localObject2).append("]");
    throw new IOException(((StringBuilder)localObject2).toString());
  }
  
  private void readJournalLine(String paramString)
  {
    int i = paramString.indexOf(' ');
    if (i != -1)
    {
      int j = i + 1;
      int k = paramString.indexOf(' ', j);
      if (k == -1)
      {
        localObject2 = paramString.substring(j);
        localObject1 = localObject2;
        if (i == 6)
        {
          localObject1 = localObject2;
          if (paramString.startsWith("REMOVE")) {
            this.lruEntries.remove(localObject2);
          }
        }
      }
      else
      {
        localObject1 = paramString.substring(j, k);
      }
      DiskLruCache.Entry localEntry = (DiskLruCache.Entry)this.lruEntries.get(localObject1);
      Object localObject2 = localEntry;
      if (localEntry == null)
      {
        localObject2 = new DiskLruCache.Entry(this, (String)localObject1);
        this.lruEntries.put(localObject1, localObject2);
      }
      if ((k != -1) && (i == 5) && (paramString.startsWith("CLEAN")))
      {
        paramString = paramString.substring(k + 1).split(" ");
        ((DiskLruCache.Entry)localObject2).readable = true;
        ((DiskLruCache.Entry)localObject2).currentEditor = null;
        ((DiskLruCache.Entry)localObject2).setLengths(paramString);
        return;
      }
      if ((k == -1) && (i == 5) && (paramString.startsWith("DIRTY")))
      {
        ((DiskLruCache.Entry)localObject2).currentEditor = new DiskLruCache.Editor(this, (DiskLruCache.Entry)localObject2);
        return;
      }
      if ((k == -1) && (i == 4) && (paramString.startsWith("READ"))) {
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("unexpected journal line: ");
      ((StringBuilder)localObject1).append(paramString);
      throw new IOException(((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("unexpected journal line: ");
    ((StringBuilder)localObject1).append(paramString);
    throw new IOException(((StringBuilder)localObject1).toString());
  }
  
  private void validateKey(String paramString)
  {
    if (LEGAL_KEY_PATTERN.matcher(paramString).matches()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("keys must match regex [a-z0-9_-]{1,120}: \"");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\"");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void close()
  {
    try
    {
      if ((!this.initialized) || (this.closed)) {
        break label105;
      }
      arrayOfEntry = (DiskLruCache.Entry[])this.lruEntries.values().toArray(new DiskLruCache.Entry[this.lruEntries.size()]);
      j = arrayOfEntry.length;
      i = 0;
    }
    finally
    {
      for (;;)
      {
        DiskLruCache.Entry[] arrayOfEntry;
        int j;
        int i;
        DiskLruCache.Entry localEntry;
        for (;;)
        {
          label105:
          throw localObject;
        }
        i += 1;
      }
    }
    if (i < j)
    {
      localEntry = arrayOfEntry[i];
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
      return;
      this.closed = true;
      return;
    }
  }
  
  void completeEdit(DiskLruCache.Editor paramEditor, boolean paramBoolean)
  {
    try
    {
      localEntry = paramEditor.entry;
      if (localEntry.currentEditor != paramEditor) {
        break label472;
      }
      int k = 0;
      j = k;
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
              break label134;
            }
            if (paramEditor.written[i] == 0) {
              break;
            }
            if (!this.fileSystem.exists(localEntry.dirtyFiles[i]))
            {
              paramEditor.abort();
              return;
            }
            i += 1;
          }
          paramEditor.abort();
          paramEditor = new StringBuilder();
          paramEditor.append("Newly created entry didn't create value for index ");
          paramEditor.append(i);
          throw new IllegalStateException(paramEditor.toString());
        }
      }
    }
    finally
    {
      for (;;)
      {
        DiskLruCache.Entry localEntry;
        int j;
        label134:
        File localFile;
        long l1;
        long l2;
        for (;;)
        {
          label472:
          throw paramEditor;
        }
        j += 1;
      }
    }
    if (j < this.valueCount)
    {
      paramEditor = localEntry.dirtyFiles[j];
      if (paramBoolean)
      {
        if (this.fileSystem.exists(paramEditor))
        {
          localFile = localEntry.cleanFiles[j];
          this.fileSystem.rename(paramEditor, localFile);
          l1 = localEntry.lengths[j];
          l2 = this.fileSystem.size(localFile);
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
      else
      {
        this.lruEntries.remove(localEntry.key);
        this.journalWriter.writeUtf8("REMOVE").writeByte(32);
        this.journalWriter.writeUtf8(localEntry.key);
        this.journalWriter.writeByte(10);
      }
      this.journalWriter.flush();
      if ((this.size > this.maxSize) || (journalRebuildRequired())) {
        this.executor.execute(this.cleanupRunnable);
      }
      return;
      throw new IllegalStateException();
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
    try
    {
      initialize();
      checkNotClosed();
      validateKey(paramString);
      DiskLruCache.Entry localEntry = (DiskLruCache.Entry)this.lruEntries.get(paramString);
      if (paramLong != -1L) {
        if (localEntry != null)
        {
          long l = localEntry.sequenceNumber;
          if (l == paramLong) {}
        }
        else
        {
          return null;
        }
      }
      Object localObject;
      if (localEntry != null)
      {
        localObject = localEntry.currentEditor;
        if (localObject != null) {
          return null;
        }
      }
      if ((!this.mostRecentTrimFailed) && (!this.mostRecentRebuildFailed))
      {
        this.journalWriter.writeUtf8("DIRTY").writeByte(32).writeUtf8(paramString).writeByte(10);
        this.journalWriter.flush();
        boolean bool = this.hasJournalErrors;
        if (bool) {
          return null;
        }
        localObject = localEntry;
        if (localEntry == null)
        {
          localObject = new DiskLruCache.Entry(this, paramString);
          this.lruEntries.put(paramString, localObject);
        }
        paramString = new DiskLruCache.Editor(this, (DiskLruCache.Entry)localObject);
        ((DiskLruCache.Entry)localObject).currentEditor = paramString;
        return paramString;
      }
      this.executor.execute(this.cleanupRunnable);
      return null;
    }
    finally {}
  }
  
  public void evictAll()
  {
    try
    {
      initialize();
      DiskLruCache.Entry[] arrayOfEntry = (DiskLruCache.Entry[])this.lruEntries.values().toArray(new DiskLruCache.Entry[this.lruEntries.size()]);
      int j = arrayOfEntry.length;
      int i = 0;
      while (i < j)
      {
        removeEntry(arrayOfEntry[i]);
        i += 1;
      }
      this.mostRecentTrimFailed = false;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void flush()
  {
    try
    {
      boolean bool = this.initialized;
      if (!bool) {
        return;
      }
      checkNotClosed();
      trimToSize();
      this.journalWriter.flush();
      return;
    }
    finally {}
  }
  
  public DiskLruCache.Snapshot get(String paramString)
  {
    try
    {
      initialize();
      checkNotClosed();
      validateKey(paramString);
      Object localObject = (DiskLruCache.Entry)this.lruEntries.get(paramString);
      if ((localObject != null) && (((DiskLruCache.Entry)localObject).readable))
      {
        localObject = ((DiskLruCache.Entry)localObject).snapshot();
        if (localObject == null) {
          return null;
        }
        this.redundantOpCount += 1;
        this.journalWriter.writeUtf8("READ").writeByte(32).writeUtf8(paramString).writeByte(10);
        if (journalRebuildRequired()) {
          this.executor.execute(this.cleanupRunnable);
        }
        return localObject;
      }
      return null;
    }
    finally {}
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
      boolean bool = this.initialized;
      if (bool) {
        return;
      }
      if (this.fileSystem.exists(this.journalFileBackup)) {
        if (this.fileSystem.exists(this.journalFile)) {
          this.fileSystem.delete(this.journalFileBackup);
        } else {
          this.fileSystem.rename(this.journalFileBackup, this.journalFile);
        }
      }
      bool = this.fileSystem.exists(this.journalFile);
      if (bool) {
        try
        {
          readJournal();
          processJournal();
          this.initialized = true;
          return;
        }
        catch (IOException localIOException)
        {
          Platform localPlatform = Platform.get();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("DiskLruCache ");
          localStringBuilder.append(this.directory);
          localStringBuilder.append(" is corrupt: ");
          localStringBuilder.append(localIOException.getMessage());
          localStringBuilder.append(", removing");
          localPlatform.log(5, localStringBuilder.toString(), localIOException);
        }
      }
      try
      {
        delete();
        this.closed = false;
      }
      finally
      {
        this.closed = false;
      }
      this.initialized = true;
      return;
    }
    finally {}
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
    int i = this.redundantOpCount;
    return (i >= 2000) && (i >= this.lruEntries.size());
  }
  
  void rebuildJournal()
  {
    try
    {
      if (this.journalWriter != null) {
        this.journalWriter.close();
      }
      BufferedSink localBufferedSink = Okio.buffer(this.fileSystem.sink(this.journalFileTmp));
      try
      {
        localBufferedSink.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
        localBufferedSink.writeUtf8("1").writeByte(10);
        localBufferedSink.writeDecimalLong(this.appVersion).writeByte(10);
        localBufferedSink.writeDecimalLong(this.valueCount).writeByte(10);
        localBufferedSink.writeByte(10);
        Iterator localIterator = this.lruEntries.values().iterator();
        while (localIterator.hasNext())
        {
          DiskLruCache.Entry localEntry = (DiskLruCache.Entry)localIterator.next();
          if (localEntry.currentEditor != null)
          {
            localBufferedSink.writeUtf8("DIRTY").writeByte(32);
            localBufferedSink.writeUtf8(localEntry.key);
            localBufferedSink.writeByte(10);
          }
          else
          {
            localBufferedSink.writeUtf8("CLEAN").writeByte(32);
            localBufferedSink.writeUtf8(localEntry.key);
            localEntry.writeLengths(localBufferedSink);
            localBufferedSink.writeByte(10);
          }
        }
        localBufferedSink.close();
        if (this.fileSystem.exists(this.journalFile)) {
          this.fileSystem.rename(this.journalFile, this.journalFileBackup);
        }
        this.fileSystem.rename(this.journalFileTmp, this.journalFile);
        this.fileSystem.delete(this.journalFileBackup);
        this.journalWriter = newJournalWriter();
        this.hasJournalErrors = false;
        this.mostRecentRebuildFailed = false;
        return;
      }
      finally
      {
        localBufferedSink.close();
      }
      throw localObject1;
    }
    finally {}
    for (;;) {}
  }
  
  public boolean remove(String paramString)
  {
    try
    {
      initialize();
      checkNotClosed();
      validateKey(paramString);
      paramString = (DiskLruCache.Entry)this.lruEntries.get(paramString);
      if (paramString == null) {
        return false;
      }
      boolean bool = removeEntry(paramString);
      if ((bool) && (this.size <= this.maxSize)) {
        this.mostRecentTrimFailed = false;
      }
      return bool;
    }
    finally {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.cache.DiskLruCache
 * JD-Core Version:    0.7.0.1
 */