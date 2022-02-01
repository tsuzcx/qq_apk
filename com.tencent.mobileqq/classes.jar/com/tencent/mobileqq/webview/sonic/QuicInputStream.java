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
    int i;
    Object localObject;
    if (!this.isFinish) {
      try
      {
        i = ((Integer)this.blockingQueue.take()).intValue();
        try
        {
          this.account += 1;
        }
        catch (InterruptedException localInterruptedException1) {}
        StringBuilder localStringBuilder;
        localInterruptedException2.printStackTrace();
      }
      catch (Throwable localThrowable)
      {
        localObject = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("read error:");
        localStringBuilder.append(localThrowable.getMessage());
        SonicUtils.log((String)localObject, 6, localStringBuilder.toString());
        throw new IOException(localThrowable);
      }
      catch (InterruptedException localInterruptedException2)
      {
        i = -1;
      }
    } else {
      i = -1;
    }
    if (i == -1)
    {
      this.isFinish = true;
      String str = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QuicInputStream already finish. length=");
      int j = this.account;
      this.account = (j + 1);
      ((StringBuilder)localObject).append(j);
      SonicUtils.log(str, 4, ((StringBuilder)localObject).toString());
    }
    return i;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.sonic.QuicInputStream
 * JD-Core Version:    0.7.0.1
 */