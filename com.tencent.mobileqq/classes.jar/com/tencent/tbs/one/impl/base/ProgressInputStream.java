package com.tencent.tbs.one.impl.base;

import android.support.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

public class ProgressInputStream
  extends InputStream
{
  private static final int PUBLISH_PROGRESS_INTERVAL = 2;
  private ProgressInputStream.Client mClient;
  private long mContentLength;
  private InputStream mInputStream;
  private int mLastProgress = 0;
  private long mTotalBytesRead = 0L;
  
  public ProgressInputStream(InputStream paramInputStream, long paramLong)
  {
    this.mInputStream = paramInputStream;
    this.mContentLength = paramLong;
  }
  
  private void assertCanContinue()
  {
    if ((this.mClient != null) && (!this.mClient.canContinue())) {
      throw new IOException("Aborted");
    }
  }
  
  private void publishProgress()
  {
    if ((this.mContentLength > 0L) && (this.mClient != null))
    {
      int i = (int)(this.mTotalBytesRead / this.mContentLength * 100.0D);
      if (i - this.mLastProgress >= 2)
      {
        this.mLastProgress = i;
        this.mClient.onProgressChanged(i);
      }
    }
  }
  
  public int available()
  {
    return this.mInputStream.available();
  }
  
  public void close()
  {
    this.mInputStream.close();
  }
  
  public long getTotalBytesRead()
  {
    return this.mTotalBytesRead;
  }
  
  public void mark(int paramInt)
  {
    try
    {
      this.mInputStream.mark(paramInt);
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
    return this.mInputStream.markSupported();
  }
  
  public int read()
  {
    assertCanContinue();
    int i = this.mInputStream.read();
    if (i != -1)
    {
      this.mTotalBytesRead += 1L;
      publishProgress();
    }
    return i;
  }
  
  public int read(@NonNull byte[] paramArrayOfByte)
  {
    assertCanContinue();
    int i = this.mInputStream.read(paramArrayOfByte);
    if (i != -1)
    {
      this.mTotalBytesRead += i;
      publishProgress();
    }
    return i;
  }
  
  public int read(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    assertCanContinue();
    paramInt1 = this.mInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != -1)
    {
      this.mTotalBytesRead += paramInt1;
      publishProgress();
    }
    return paramInt1;
  }
  
  public void reset()
  {
    try
    {
      this.mInputStream.reset();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setClient(ProgressInputStream.Client paramClient)
  {
    this.mClient = paramClient;
  }
  
  public long skip(long paramLong)
  {
    return this.mInputStream.skip(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.base.ProgressInputStream
 * JD-Core Version:    0.7.0.1
 */