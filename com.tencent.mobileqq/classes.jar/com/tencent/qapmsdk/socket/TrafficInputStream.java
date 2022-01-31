package com.tencent.qapmsdk.socket;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import com.tencent.qapmsdk.socket.handler.TrafficInputStreamHandlerDispatcher;
import com.tencent.qapmsdk.socket.model.SocketInfo;
import java.io.InputStream;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class TrafficInputStream
  extends InputStream
{
  private byte[] byteTemp = new byte[1];
  private SocketInfo socketInfo;
  private InputStream trafficInputStream;
  private TrafficInputStreamHandlerDispatcher trafficInputStreamHandlerDispatcher;
  
  public TrafficInputStream(InputStream paramInputStream, SocketInfo paramSocketInfo)
  {
    this.trafficInputStream = paramInputStream;
    this.trafficInputStreamHandlerDispatcher = new TrafficInputStreamHandlerDispatcher();
    if (paramSocketInfo != null) {
      this.socketInfo = paramSocketInfo;
    }
  }
  
  public int available()
  {
    return this.trafficInputStream.available();
  }
  
  public void close()
  {
    this.trafficInputStreamHandlerDispatcher.dispatchClose();
    this.trafficInputStream.close();
  }
  
  public void mark(int paramInt)
  {
    try
    {
      this.trafficInputStream.mark(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean markSupported()
  {
    return this.trafficInputStream.markSupported();
  }
  
  public int read()
  {
    if (read(this.byteTemp, 0, 1) <= 0) {
      return -1;
    }
    return this.byteTemp[0] & 0xFF;
  }
  
  public int read(@NonNull byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = this.trafficInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
    this.trafficInputStreamHandlerDispatcher.dispatchRead(paramArrayOfByte, paramInt1, paramInt2, i, this.socketInfo);
    return i;
  }
  
  public void reset()
  {
    try
    {
      this.trafficInputStream.reset();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setSocketInfo(SocketInfo paramSocketInfo)
  {
    this.socketInfo = paramSocketInfo;
  }
  
  public long skip(long paramLong)
  {
    return this.trafficInputStream.skip(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.TrafficInputStream
 * JD-Core Version:    0.7.0.1
 */