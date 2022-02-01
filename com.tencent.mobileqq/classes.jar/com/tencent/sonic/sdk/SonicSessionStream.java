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
    for (;;)
    {
      this.callbackWeakReference = new WeakReference(paramCallback);
      return;
      this.outputStream = new ByteArrayOutputStream();
    }
  }
  
  public void close()
  {
    if (SonicUtils.shouldLog(4)) {
      SonicUtils.log("SonicSdk_SonicSessionStream", 4, "close: memory stream and socket stream, netStreamReadComplete=" + this.netStreamReadComplete + ", memStreamReadComplete=" + this.memStreamReadComplete);
    }
    try
    {
      if (this.memStream != null) {
        this.memStream.close();
      }
      this.memStream = null;
      localObject1 = null;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        Object localObject1;
        label87:
        SonicSessionStream.Callback localCallback;
        SonicUtils.log("SonicSdk_SonicSessionStream", 6, "close memStream error:" + localThrowable1.getMessage());
        this.memStream = null;
      }
    }
    finally
    {
      this.memStream = null;
    }
    try
    {
      if (this.netStream != null) {
        this.netStream.close();
      }
    }
    catch (Throwable localThrowable2)
    {
      SonicUtils.log("SonicSdk_SonicSessionStream", 6, "close netStream error:" + localThrowable2.getMessage());
      this.netStream = null;
      break label87;
    }
    finally
    {
      this.netStream = null;
    }
    localCallback = (SonicSessionStream.Callback)this.callbackWeakReference.get();
    if (localCallback != null) {
      if ((!this.netStreamReadComplete) || (!this.memStreamReadComplete)) {
        break label271;
      }
    }
    label271:
    for (boolean bool = true;; bool = false)
    {
      localCallback.onClose(bool, this.outputStream);
      this.outputStream = null;
      if (localObject1 == null) {
        return;
      }
      SonicUtils.log("SonicSdk_SonicSessionStream", 6, "throw error:" + localObject1.getMessage());
      if (!(localObject1 instanceof IOException)) {
        break;
      }
      throw ((IOException)localObject1);
    }
    throw new IOException(localThrowable3);
  }
  
  public int read()
  {
    Object localObject = null;
    label296:
    label305:
    label310:
    for (;;)
    {
      int i;
      try
      {
        SonicSessionStream.Callback localCallback = (SonicSessionStream.Callback)this.callbackWeakReference.get();
        if ((localCallback instanceof SonicServer))
        {
          localObject = (SonicServer)localCallback;
          if (((SonicServer)localObject).session != null)
          {
            localObject = ((SonicServer)localObject).session.statistics;
            break label310;
          }
        }
        else
        {
          if ((this.memStream == null) || (this.memStreamReadComplete)) {
            break label305;
          }
          i = this.memStream.read();
          int j = i;
          if (-1 == i)
          {
            this.memStreamReadComplete = true;
            j = i;
            if (this.netStream != null)
            {
              j = i;
              if (!this.netStreamReadComplete)
              {
                j = this.netStream.read();
                if (-1 == j) {
                  continue;
                }
                this.outputStream.write(j);
              }
            }
          }
          if (j != -1) {
            break label240;
          }
          if ((localObject != null) && (((SonicSessionStatistics)localObject).connectionRecDataEndTime <= 0L))
          {
            ((SonicSessionStatistics)localObject).connectionRecDataEndTime = System.currentTimeMillis();
            SonicUtils.log("SonicSdk_SonicSessionStream", 4, "SonicSessionStream_from_SonicStart_to_RecLastData, cost=" + (((SonicSessionStatistics)localObject).connectionRecDataEndTime - ((SonicSessionStatistics)localObject).connectionFlowStartTime));
          }
          return j;
        }
        localObject = null;
        break label310;
        this.netStreamReadComplete = true;
        continue;
        if (localThrowable2 == null) {
          continue;
        }
      }
      catch (Throwable localThrowable1)
      {
        SonicUtils.log("SonicSdk_SonicSessionStream", 6, "read error:" + localThrowable1.getMessage());
        if (!(localThrowable1 instanceof IOException)) {
          break label296;
        }
        throw localThrowable1;
      }
      finally {}
      label240:
      if (localThrowable2.connectionRecDataStartTime <= 0L)
      {
        localThrowable2.connectionRecDataStartTime = System.currentTimeMillis();
        SonicUtils.log("SonicSdk_SonicSessionStream", 4, "SonicSessionStream_from_SonicStart_to_RecFirstData, cost=" + (localThrowable2.connectionRecDataStartTime - localThrowable2.connectionFlowStartTime));
        continue;
        throw new IOException(localThrowable2);
        i = -1;
      }
    }
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
    int j = -1;
    try
    {
      i = paramArrayOfByte.length;
      if (((paramInt1 | paramInt2) < 0) || (paramInt1 > i) || (i - paramInt1 < paramInt2)) {
        throw new ArrayIndexOutOfBoundsException();
      }
    }
    finally {}
    int i = 0;
    if (i < paramInt2) {}
    for (;;)
    {
      int k;
      try
      {
        k = read();
        if (k != -1) {
          break label95;
        }
        if (i != 0) {
          continue;
        }
        paramInt1 = j;
      }
      catch (IOException paramArrayOfByte)
      {
        if (i == 0) {
          continue;
        }
        paramInt1 = i;
        continue;
        throw paramArrayOfByte;
      }
      return paramInt1;
      paramInt1 = i;
      continue;
      label95:
      paramArrayOfByte[(paramInt1 + i)] = ((byte)k);
      i += 1;
      break;
      paramInt1 = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSessionStream
 * JD-Core Version:    0.7.0.1
 */