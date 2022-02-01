package com.tencent.mobileqq.utils;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SendMessageHandler
  extends Handler
{
  public long a = 0L;
  private long b = System.currentTimeMillis();
  private List<SendMessageHandler.SendMessageRunnable> c = Collections.synchronizedList(new ArrayList());
  private volatile int d = 0;
  private volatile int e = 0;
  
  public SendMessageHandler()
  {
    super(Looper.getMainLooper());
  }
  
  private void a(long paramLong, String paramString)
  {
    try
    {
      if ((this.d < this.c.size()) && (this.c.size() >= 1))
      {
        int i = this.d;
        this.d = (i + 1);
        SendMessageHandler.SendMessageRunnable localSendMessageRunnable = (SendMessageHandler.SendMessageRunnable)this.c.get(i);
        localSendMessageRunnable.m = i;
        localSendMessageRunnable.k = System.currentTimeMillis();
        localSendMessageRunnable.g = paramLong;
        localSendMessageRunnable.n = paramString;
        localSendMessageRunnable.run();
        return;
      }
      return;
    }
    finally {}
  }
  
  public long a(long paramLong)
  {
    try
    {
      long l = this.b;
      return paramLong - l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.SendMessageHandler", 2, "stopAndRemoveRunnalbes");
      }
      removeCallbacksAndMessages(null);
      this.c.clear();
      this.d = 0;
      this.e = 0;
      return;
    }
    finally {}
  }
  
  public void a(SendMessageHandler.SendMessageRunnable paramSendMessageRunnable)
  {
    try
    {
      paramSendMessageRunnable.j = this.b;
      this.c.add(paramSendMessageRunnable);
      return;
    }
    finally
    {
      paramSendMessageRunnable = finally;
      throw paramSendMessageRunnable;
    }
  }
  
  public boolean a(int paramInt, long paramLong1, long paramLong2, String[] paramArrayOfString)
  {
    try
    {
      if (paramInt < this.d)
      {
        SendMessageHandler.SendMessageRunnable localSendMessageRunnable = (SendMessageHandler.SendMessageRunnable)this.c.get(paramInt);
        localSendMessageRunnable.l = System.currentTimeMillis();
        localSendMessageRunnable.h = paramLong1;
        localSendMessageRunnable.i = paramLong2;
        localSendMessageRunnable.f = true;
        localSendMessageRunnable.o = paramArrayOfString;
        if (QLog.isColorLevel())
        {
          paramArrayOfString = new StringBuilder();
          paramArrayOfString.append("--->>>recordRetryResult msgSeq[");
          paramArrayOfString.append(this.a);
          paramArrayOfString.append("] retryIndex[");
          paramArrayOfString.append(paramInt);
          paramArrayOfString.append("] errorCode[");
          paramArrayOfString.append(paramLong1);
          paramArrayOfString.append("] serverReplyCode[");
          paramArrayOfString.append(paramLong2);
          paramArrayOfString.append("] retryInfo:");
          paramArrayOfString.append(toString());
          QLog.d("WMJ", 2, paramArrayOfString.toString());
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.e("WMJ", 2, "retry runnalbe not found!");
      }
      return false;
    }
    finally {}
  }
  
  public boolean a(long paramLong1, long paramLong2, String paramString)
  {
    try
    {
      int i = this.e;
      int j = this.c.size();
      if (i >= j) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("shedule retry, seq:");
        localStringBuilder.append(this.a);
        localStringBuilder.append("delayTime:");
        localStringBuilder.append(paramLong1);
        localStringBuilder.append(",timeout:");
        localStringBuilder.append(paramLong2);
        localStringBuilder.append(" scheduleCount:");
        localStringBuilder.append(this.e);
        localStringBuilder.append(" reason:");
        localStringBuilder.append(paramString);
        QLog.d("Q.msg.SendMessageHandler", 2, localStringBuilder.toString());
      }
      this.e += 1;
      postDelayed(new SendMessageHandler.1(this, paramLong2, paramString), paramLong1);
      return true;
    }
    finally {}
  }
  
  public boolean b()
  {
    int i = 0;
    try
    {
      while (i < this.e)
      {
        boolean bool = ((SendMessageHandler.SendMessageRunnable)this.c.get(i)).f;
        if (!bool) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    finally
    {
      localObject = finally;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    try
    {
      int j = this.d;
      if (j > 0)
      {
        int i = this.c.size();
        if (i >= j)
        {
          i = 0;
          while (i < j) {
            try
            {
              localStringBuilder.append(((SendMessageHandler.SendMessageRunnable)this.c.get(i)).toString());
              if (i != j - 1) {
                localStringBuilder.append(",");
              }
              i += 1;
            }
            catch (Exception localException)
            {
              localStringBuilder.append(localException.getMessage());
            }
          }
        }
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SendMessageHandler
 * JD-Core Version:    0.7.0.1
 */