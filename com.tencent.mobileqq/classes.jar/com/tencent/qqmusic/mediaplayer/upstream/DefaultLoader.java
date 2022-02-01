package com.tencent.qqmusic.mediaplayer.upstream;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqmusic.mediaplayer.downstream.IDataSink;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public abstract class DefaultLoader
  extends Thread
  implements Loader
{
  private static final int MSG_LOAD_CANCELLED = 5;
  private static final int MSG_LOAD_COMPLETED = 3;
  private static final int MSG_LOAD_ERROR = 4;
  private static final int MSG_LOAD_PROGRESS = 2;
  private static final int MSG_LOAD_STARTED = 1;
  private static final int SIZE_UNSET = -1;
  private static final String TAG = "DefaultLoader";
  private final Chunk END_OF_QUEUE = new Chunk(0, 0L, 0L);
  @Nullable
  private IDataSink cacheSink;
  private volatile boolean cancelled = false;
  private final BlockingQueue<Chunk> chunks;
  private final Handler eventHandler;
  private volatile boolean isLoading = false;
  private volatile boolean shutdown;
  @Nullable
  private IDataSource upstream;
  private long upstreamSize = -1L;
  private final UriLoader uriLoader;
  
  protected DefaultLoader(@NonNull Looper paramLooper, @NonNull UriLoader paramUriLoader, @Nullable Loader.Listener paramListener)
  {
    this.uriLoader = paramUriLoader;
    this.eventHandler = new Handler(paramLooper, new DefaultLoader.1(this, paramListener));
    this.chunks = new LinkedBlockingQueue(1);
  }
  
  private boolean loadChunk(@NonNull Chunk paramChunk)
  {
    if ((this.upstream != null) && (this.cacheSink != null))
    {
      long l3 = paramChunk.start;
      long l4 = paramChunk.size;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[loadChunk] enter. startPosition: ");
      localStringBuilder.append(l3);
      localStringBuilder.append(", chunkSize: ");
      localStringBuilder.append(l4);
      Logger.d("DefaultLoader", localStringBuilder.toString());
      paramChunk = new byte[paramChunk.bufferSize];
      int k;
      if (l4 == -1L) {
        k = 1;
      } else {
        k = 0;
      }
      int m;
      if (k != 0) {
        m = paramChunk.length;
      } else {
        m = (int)Math.min(paramChunk.length, l4);
      }
      long l1 = 0L;
      int j = 0;
      for (;;)
      {
        long l5 = l3 + l1;
        try
        {
          int i = this.upstream.readAt(l5, paramChunk, 0, m);
          if (i == -1)
          {
            Logger.i("DefaultLoader", "[loadChunk] read EOF.");
          }
          else
          {
            if (i != 0) {
              break label182;
            }
            Logger.d("DefaultLoader", "[loadChunk] read none.");
          }
          label179:
          label182:
          if (i >= 0)
          {
            try
            {
              j = this.cacheSink.write(l5, paramChunk, 0, i);
              long l6 = j;
              long l2 = l1 + i;
              this.eventHandler.removeMessages(2);
              this.eventHandler.obtainMessage(2, (int)l3, (int)(l5 + l6 - 1L)).sendToTarget();
              if ((!this.cancelled) && (!this.shutdown)) {
                i = 0;
              } else {
                i = 1;
              }
              l1 = l2;
              j = i;
              if (i != 0) {
                break label179;
              }
              l1 = l2;
              j = i;
              if (k != 0) {
                continue;
              }
              l1 = l2;
              j = i;
              if (l2 < l4) {
                continue;
              }
              l1 = l2;
              j = i;
            }
            catch (IOException paramChunk)
            {
              throw new IOException(new SinkWriteException(paramChunk));
            }
            paramChunk = new StringBuilder();
            paramChunk.append("[loadChunk] exit. startPosition: ");
            paramChunk.append(l3);
            paramChunk.append(", loadedBytes: ");
            paramChunk.append(l1);
            paramChunk.append(", this.cancelled: ");
            paramChunk.append(this.cancelled);
            paramChunk.append(", shutdown: ");
            paramChunk.append(this.shutdown);
            Logger.d("DefaultLoader", paramChunk.toString());
            return j ^ 0x1;
          }
          else
          {
            paramChunk = new StringBuilder();
            paramChunk.append("read error: ");
            paramChunk.append(i);
            throw new IOException(new SourceReadException(paramChunk.toString(), ""));
          }
        }
        catch (IOException paramChunk)
        {
          throw new IOException(new SourceReadException(paramChunk, ""));
        }
      }
    }
    paramChunk = new IllegalStateException("loader must be prepared first!");
    for (;;)
    {
      throw paramChunk;
    }
  }
  
  public void cancelLoading()
  {
    Logger.i("DefaultLoader", "[cancelLoading] cancel");
    this.uriLoader.cancelLoading();
    this.cancelled = true;
  }
  
  protected abstract IDataSink createCacheSink(StreamingRequest paramStreamingRequest);
  
  protected abstract IDataSource createUpStream(StreamingRequest paramStreamingRequest);
  
  public long getUpstreamSize()
  {
    return this.upstreamSize;
  }
  
  public boolean isLoading()
  {
    if (this.uriLoader.isLoading()) {
      return true;
    }
    return this.isLoading;
  }
  
  public void prepare()
  {
    Object localObject = this.upstream;
    if (localObject != null) {
      ((IDataSource)localObject).close();
    }
    localObject = this.cacheSink;
    if (localObject != null) {
      ((IDataSink)localObject).close();
    }
  }
  
  public void run()
  {
    for (;;)
    {
      if (this.shutdown) {
        break label105;
      }
      try
      {
        Chunk localChunk = (Chunk)this.chunks.take();
        if (this.END_OF_QUEUE == localChunk)
        {
          Logger.i("DefaultLoader", "[run] end of queue!");
          return;
        }
        try
        {
          if (loadChunk(localChunk)) {
            this.eventHandler.obtainMessage(3).sendToTarget();
          } else {
            this.eventHandler.obtainMessage(5).sendToTarget();
          }
        }
        catch (IOException localIOException)
        {
          Logger.e("DefaultLoader", "[run] got error!", localIOException);
          this.eventHandler.obtainMessage(4, localIOException).sendToTarget();
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        label97:
        label105:
        break label97;
      }
    }
    Logger.w("DefaultLoader", "[run] interrupted when taking chunk");
  }
  
  public void shutdown()
  {
    this.shutdown = true;
    this.chunks.offer(this.END_OF_QUEUE);
    join();
    try
    {
      if (this.upstream == null) {
        break label50;
      }
      this.upstream.close();
    }
    catch (IOException localIOException1)
    {
      label42:
      label50:
      label67:
      label75:
      break label42;
    }
    Logger.w("DefaultLoader", "[shutdown] failed to close upstream");
    try
    {
      if (this.cacheSink == null) {
        break label75;
      }
      this.cacheSink.close();
      return;
    }
    catch (IOException localIOException2)
    {
      break label67;
    }
    Logger.w("DefaultLoader", "[shutdown] failed to close cacheSink");
  }
  
  public void startLoading(@NonNull Chunk paramChunk)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[startLoading] chunk: ");
    localStringBuilder.append(paramChunk);
    Logger.i("DefaultLoader", localStringBuilder.toString());
    this.chunks.clear();
    if (this.chunks.offer(paramChunk))
    {
      this.isLoading = true;
      Logger.i("DefaultLoader", "[handleMessage] loading = true");
      this.cancelled = false;
      if (getState() == Thread.State.NEW) {
        this.uriLoader.startLoading(0, TimeUnit.MILLISECONDS, new DefaultLoader.2(this));
      }
      return;
    }
    throw new IllegalStateException("exceeds maximum of queue!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.DefaultLoader
 * JD-Core Version:    0.7.0.1
 */