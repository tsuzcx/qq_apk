package okhttp3.internal.cache;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okhttp3.internal.io.FileSystem;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class DiskLruCache$Editor
{
  private boolean done;
  final DiskLruCache.Entry entry;
  final boolean[] written;
  
  DiskLruCache$Editor(DiskLruCache paramDiskLruCache, DiskLruCache.Entry paramEntry)
  {
    this.entry = paramEntry;
    if (paramEntry.readable) {}
    for (paramDiskLruCache = null;; paramDiskLruCache = new boolean[paramDiskLruCache.valueCount])
    {
      this.written = paramDiskLruCache;
      return;
    }
  }
  
  public void abort()
  {
    synchronized (this.this$0)
    {
      if (this.done) {
        throw new IllegalStateException();
      }
    }
    if (this.entry.currentEditor == this) {
      this.this$0.completeEdit(this, false);
    }
    this.done = true;
  }
  
  public void abortUnlessCommitted()
  {
    synchronized (this.this$0)
    {
      if (!this.done)
      {
        Editor localEditor = this.entry.currentEditor;
        if (localEditor != this) {}
      }
    }
    try
    {
      this.this$0.completeEdit(this, false);
      label36:
      return;
      localObject = finally;
      throw localObject;
    }
    catch (IOException localIOException)
    {
      break label36;
    }
  }
  
  public void commit()
  {
    synchronized (this.this$0)
    {
      if (this.done) {
        throw new IllegalStateException();
      }
    }
    if (this.entry.currentEditor == this) {
      this.this$0.completeEdit(this, true);
    }
    this.done = true;
  }
  
  void detach()
  {
    int i;
    if (this.entry.currentEditor == this) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.this$0.valueCount) {}
      try
      {
        this.this$0.fileSystem.delete(this.entry.dirtyFiles[i]);
        label45:
        i += 1;
        continue;
        this.entry.currentEditor = null;
        return;
      }
      catch (IOException localIOException)
      {
        break label45;
      }
    }
  }
  
  public Sink newSink(int paramInt)
  {
    synchronized (this.this$0)
    {
      if (this.done) {
        throw new IllegalStateException();
      }
    }
    if (this.entry.currentEditor != this)
    {
      localObject2 = Okio.blackhole();
      return localObject2;
    }
    if (!this.entry.readable) {
      this.written[paramInt] = true;
    }
    Object localObject2 = this.entry.dirtyFiles[paramInt];
    try
    {
      localObject2 = this.this$0.fileSystem.sink((File)localObject2);
      localObject2 = new DiskLruCache.Editor.1(this, (Sink)localObject2);
      return localObject2;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Sink localSink = Okio.blackhole();
      return localSink;
    }
  }
  
  public Source newSource(int paramInt)
  {
    synchronized (this.this$0)
    {
      if (this.done) {
        throw new IllegalStateException();
      }
    }
    if ((!this.entry.readable) || (this.entry.currentEditor != this)) {
      return null;
    }
    try
    {
      Source localSource = this.this$0.fileSystem.source(this.entry.cleanFiles[paramInt]);
      return localSource;
    }
    catch (FileNotFoundException localFileNotFoundException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.internal.cache.DiskLruCache.Editor
 * JD-Core Version:    0.7.0.1
 */