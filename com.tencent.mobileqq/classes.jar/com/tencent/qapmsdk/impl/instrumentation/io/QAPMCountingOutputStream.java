package com.tencent.qapmsdk.impl.instrumentation.io;

import java.io.IOException;
import java.io.OutputStream;

public class QAPMCountingOutputStream
  extends OutputStream
  implements QAPMStreamCompleteListenerSource
{
  private long count = 0L;
  private final OutputStream impl;
  private final QAPMStreamCompleteListenerManager listenerManager = new QAPMStreamCompleteListenerManager();
  
  public QAPMCountingOutputStream(OutputStream paramOutputStream)
  {
    this.impl = paramOutputStream;
  }
  
  private void notifyStreamComplete()
  {
    if (!this.listenerManager.isComplete()) {
      this.listenerManager.notifyStreamComplete(new QAPMStreamCompleteEvent(this, this.count));
    }
  }
  
  private void notifyStreamError(Exception paramException)
  {
    if (!this.listenerManager.isComplete()) {
      this.listenerManager.notifyStreamError(new QAPMStreamCompleteEvent(this, this.count, paramException));
    }
  }
  
  public void addStreamCompleteListener(QAPMStreamCompleteListener paramQAPMStreamCompleteListener)
  {
    this.listenerManager.addStreamCompleteListener(paramQAPMStreamCompleteListener);
  }
  
  public void close()
  {
    try
    {
      this.impl.close();
      notifyStreamComplete();
      return;
    }
    catch (IOException localIOException)
    {
      notifyStreamError(localIOException);
      throw localIOException;
    }
  }
  
  public void flush()
  {
    try
    {
      this.impl.flush();
      return;
    }
    catch (IOException localIOException)
    {
      notifyStreamError(localIOException);
      throw localIOException;
    }
  }
  
  public long getCount()
  {
    return this.count;
  }
  
  public void removeStreamCompleteListener(QAPMStreamCompleteListener paramQAPMStreamCompleteListener)
  {
    this.listenerManager.removeStreamCompleteListener(paramQAPMStreamCompleteListener);
  }
  
  public void write(int paramInt)
  {
    try
    {
      this.impl.write(paramInt);
      this.count += 1L;
      return;
    }
    catch (IOException localIOException)
    {
      notifyStreamError(localIOException);
      throw localIOException;
    }
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    try
    {
      this.impl.write(paramArrayOfByte);
      this.count += paramArrayOfByte.length;
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      notifyStreamError(paramArrayOfByte);
      throw paramArrayOfByte;
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      this.impl.write(paramArrayOfByte, paramInt1, paramInt2);
      this.count += paramInt2;
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      notifyStreamError(paramArrayOfByte);
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.io.QAPMCountingOutputStream
 * JD-Core Version:    0.7.0.1
 */