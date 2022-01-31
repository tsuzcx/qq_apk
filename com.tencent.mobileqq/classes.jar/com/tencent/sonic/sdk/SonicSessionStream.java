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
  private final WeakReference<Callback> callbackWeakReference;
  private BufferedInputStream memStream;
  private boolean memStreamReadComplete = true;
  private BufferedInputStream netStream;
  private boolean netStreamReadComplete = true;
  private ByteArrayOutputStream outputStream;
  
  public SonicSessionStream(Callback paramCallback, ByteArrayOutputStream paramByteArrayOutputStream, BufferedInputStream paramBufferedInputStream)
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
    throws IOException
  {
    if (SonicUtils.shouldLog(4)) {
      SonicUtils.log("SonicSdk_SonicSessionStream", 4, "close: memory stream and socket stream, netStreamReadComplete=" + this.netStreamReadComplete + ", memStreamReadComplete=" + this.memStreamReadComplete);
    }
    Object localObject1 = null;
    try
    {
      if (this.memStream != null) {
        this.memStream.close();
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        label87:
        Callback localCallback;
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
    localCallback = (Callback)this.callbackWeakReference.get();
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
    throws IOException
  {
    int j = -1;
    int i = j;
    try
    {
      if (this.memStream != null)
      {
        i = j;
        if (!this.memStreamReadComplete) {
          i = this.memStream.read();
        }
      }
      j = i;
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
              break label85;
            }
            this.outputStream.write(j);
          }
        }
      }
      for (;;)
      {
        return j;
        label85:
        this.netStreamReadComplete = true;
      }
      throw new IOException(localThrowable2);
    }
    catch (Throwable localThrowable1)
    {
      SonicUtils.log("SonicSdk_SonicSessionStream", 6, "read error:" + localThrowable1.getMessage());
      if ((localThrowable1 instanceof IOException)) {
        throw localThrowable1;
      }
    }
    finally {}
  }
  
  public int read(@NonNull byte[] paramArrayOfByte)
    throws IOException
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
    throws IOException
  {
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
      int j;
      try
      {
        j = read();
        if (j != -1) {
          break label85;
        }
        paramInt1 = i;
        if (i == 0) {
          paramInt1 = -1;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        paramInt1 = i;
        if (i != 0) {
          continue;
        }
        throw paramArrayOfByte;
      }
      return paramInt1;
      label85:
      paramArrayOfByte[(paramInt1 + i)] = ((byte)j);
      i += 1;
      break;
      paramInt1 = paramInt2;
    }
  }
  
  public static abstract interface Callback
  {
    public abstract void onClose(boolean paramBoolean, ByteArrayOutputStream paramByteArrayOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSessionStream
 * JD-Core Version:    0.7.0.1
 */