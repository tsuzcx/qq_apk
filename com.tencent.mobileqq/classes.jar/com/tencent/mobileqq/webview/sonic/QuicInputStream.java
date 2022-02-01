package com.tencent.mobileqq.webview.sonic;

import androidx.annotation.NonNull;
import com.tencent.sonic.sdk.SonicUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingQueue;

public class QuicInputStream
  extends InputStream
{
  private static String TAG = "SonicSdk_QuicInputStream";
  private int account = 0;
  private LinkedBlockingQueue<Integer> blockingQueue;
  private volatile boolean isFinish = false;
  
  public QuicInputStream(LinkedBlockingQueue<Integer> paramLinkedBlockingQueue)
  {
    this.blockingQueue = paramLinkedBlockingQueue;
  }
  
  public int read()
  {
    if (!this.isFinish) {}
    for (;;)
    {
      try
      {
        int i = ((Integer)this.blockingQueue.take()).intValue();
        String str;
        StringBuilder localStringBuilder;
        int j;
        i = -1;
      }
      catch (InterruptedException localInterruptedException1)
      {
        try
        {
          this.account += 1;
          if (i == -1)
          {
            this.isFinish = true;
            str = TAG;
            localStringBuilder = new StringBuilder().append("QuicInputStream already finish. length=");
            j = this.account;
            this.account = (j + 1);
            SonicUtils.log(str, 4, j);
          }
          return i;
        }
        catch (InterruptedException localInterruptedException2)
        {
          continue;
        }
        localInterruptedException1 = localInterruptedException1;
        i = -1;
        localInterruptedException1.printStackTrace();
      }
      catch (Throwable localThrowable)
      {
        SonicUtils.log(TAG, 6, "read error:" + localThrowable.getMessage());
        throw new IOException(localThrowable);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.sonic.QuicInputStream
 * JD-Core Version:    0.7.0.1
 */