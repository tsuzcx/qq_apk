package com.tencent.tbs.one.impl.base;

import android.support.annotation.NonNull;
import java.io.OutputStream;

public class MultiOutputStream
  extends OutputStream
{
  private OutputStream[] mOutputStreams;
  
  public MultiOutputStream(OutputStream[] paramArrayOfOutputStream)
  {
    this.mOutputStreams = paramArrayOfOutputStream;
  }
  
  public void close()
  {
    OutputStream[] arrayOfOutputStream = this.mOutputStreams;
    int j = arrayOfOutputStream.length;
    int i = 0;
    while (i < j)
    {
      arrayOfOutputStream[i].close();
      i += 1;
    }
  }
  
  public void flush()
  {
    OutputStream[] arrayOfOutputStream = this.mOutputStreams;
    int j = arrayOfOutputStream.length;
    int i = 0;
    while (i < j)
    {
      arrayOfOutputStream[i].flush();
      i += 1;
    }
  }
  
  public void write(int paramInt)
  {
    OutputStream[] arrayOfOutputStream = this.mOutputStreams;
    int j = arrayOfOutputStream.length;
    int i = 0;
    while (i < j)
    {
      arrayOfOutputStream[i].write(paramInt);
      i += 1;
    }
  }
  
  public void write(@NonNull byte[] paramArrayOfByte)
  {
    OutputStream[] arrayOfOutputStream = this.mOutputStreams;
    int j = arrayOfOutputStream.length;
    int i = 0;
    while (i < j)
    {
      arrayOfOutputStream[i].write(paramArrayOfByte);
      i += 1;
    }
  }
  
  public void write(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    OutputStream[] arrayOfOutputStream = this.mOutputStreams;
    int j = arrayOfOutputStream.length;
    int i = 0;
    while (i < j)
    {
      arrayOfOutputStream[i].write(paramArrayOfByte, paramInt1, paramInt2);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.base.MultiOutputStream
 * JD-Core Version:    0.7.0.1
 */