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
    if (paramEntry.readable) {
      paramDiskLruCache = null;
    } else {
      paramDiskLruCache = new boolean[paramDiskLruCache.valueCount];
    }
    this.written = paramDiskLruCache;
  }
  
  public void abort()
  {
    synchronized (this.this$0)
    {
      if (!this.done)
      {
        if (this.entry.currentEditor == this) {
          this.this$0.completeEdit(this, false);
        }
        this.done = true;
        return;
      }
      throw new IllegalStateException();
    }
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
      if (!this.done)
      {
        if (this.entry.currentEditor == this) {
          this.this$0.completeEdit(this, true);
        }
        this.done = true;
        return;
      }
      throw new IllegalStateException();
    }
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
      if (!this.done)
      {
        if (this.entry.currentEditor != this)
        {
          localObject1 = Okio.blackhole();
          return localObject1;
        }
        if (!this.entry.readable) {
          this.written[paramInt] = true;
        }
        localObject1 = this.entry.dirtyFiles[paramInt];
      }
      try
      {
        localObject1 = this.this$0.fileSystem.sink((File)localObject1);
        localObject1 = new DiskLruCache.Editor.1(this, (Sink)localObject1);
        return localObject1;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        label88:
        break label88;
      }
      Object localObject1 = Okio.blackhole();
      return localObject1;
      throw new IllegalStateException();
    }
  }
  
  public Source newSource(int paramInt)
  {
    synchronized (this.this$0)
    {
      Object localObject1;
      if (!this.done) {
        if (this.entry.readable)
        {
          localObject1 = this.entry.currentEditor;
          if (localObject1 != this) {}
        }
      }
      try
      {
        localObject1 = this.this$0.fileSystem.source(this.entry.cleanFiles[paramInt]);
        return localObject1;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        label66:
        break label66;
      }
      return null;
      return null;
      throw new IllegalStateException();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.cache.DiskLruCache.Editor
 * JD-Core Version:    0.7.0.1
 */