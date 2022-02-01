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
  private volatile int jdField_a_of_type_Int = 0;
  public long a;
  private List<SendMessageHandler.SendMessageRunnable> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private volatile int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = System.currentTimeMillis();
  
  public SendMessageHandler()
  {
    super(Looper.getMainLooper());
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void a(long paramLong, String paramString)
  {
    try
    {
      if ((this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size()) && (this.jdField_a_of_type_JavaUtilList.size() >= 1))
      {
        int i = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Int = (i + 1);
        SendMessageHandler.SendMessageRunnable localSendMessageRunnable = (SendMessageHandler.SendMessageRunnable)this.jdField_a_of_type_JavaUtilList.get(i);
        localSendMessageRunnable.jdField_b_of_type_Int = i;
        localSendMessageRunnable.g = System.currentTimeMillis();
        localSendMessageRunnable.jdField_c_of_type_Long = paramLong;
        localSendMessageRunnable.jdField_a_of_type_JavaLangString = paramString;
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
      long l = this.jdField_b_of_type_Long;
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
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = 0;
      return;
    }
    finally {}
  }
  
  public void a(SendMessageHandler.SendMessageRunnable paramSendMessageRunnable)
  {
    try
    {
      paramSendMessageRunnable.f = this.jdField_b_of_type_Long;
      this.jdField_a_of_type_JavaUtilList.add(paramSendMessageRunnable);
      return;
    }
    finally
    {
      paramSendMessageRunnable = finally;
      throw paramSendMessageRunnable;
    }
  }
  
  public boolean a()
  {
    int i = 0;
    try
    {
      while (i < this.jdField_b_of_type_Int)
      {
        boolean bool = ((SendMessageHandler.SendMessageRunnable)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_c_of_type_Boolean;
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
  
  public boolean a(int paramInt, long paramLong1, long paramLong2, String[] paramArrayOfString)
  {
    try
    {
      if (paramInt < this.jdField_a_of_type_Int)
      {
        SendMessageHandler.SendMessageRunnable localSendMessageRunnable = (SendMessageHandler.SendMessageRunnable)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        localSendMessageRunnable.h = System.currentTimeMillis();
        localSendMessageRunnable.d = paramLong1;
        localSendMessageRunnable.e = paramLong2;
        localSendMessageRunnable.jdField_c_of_type_Boolean = true;
        localSendMessageRunnable.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
        if (QLog.isColorLevel())
        {
          paramArrayOfString = new StringBuilder();
          paramArrayOfString.append("--->>>recordRetryResult msgSeq[");
          paramArrayOfString.append(this.jdField_a_of_type_Long);
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
      int i = this.jdField_b_of_type_Int;
      int j = this.jdField_a_of_type_JavaUtilList.size();
      if (i >= j) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("shedule retry, seq:");
        localStringBuilder.append(this.jdField_a_of_type_Long);
        localStringBuilder.append("delayTime:");
        localStringBuilder.append(paramLong1);
        localStringBuilder.append(",timeout:");
        localStringBuilder.append(paramLong2);
        localStringBuilder.append(" scheduleCount:");
        localStringBuilder.append(this.jdField_b_of_type_Int);
        localStringBuilder.append(" reason:");
        localStringBuilder.append(paramString);
        QLog.d("Q.msg.SendMessageHandler", 2, localStringBuilder.toString());
      }
      this.jdField_b_of_type_Int += 1;
      postDelayed(new SendMessageHandler.1(this, paramLong2, paramString), paramLong1);
      return true;
    }
    finally {}
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    try
    {
      int j = this.jdField_a_of_type_Int;
      if (j > 0)
      {
        int i = this.jdField_a_of_type_JavaUtilList.size();
        if (i >= j)
        {
          i = 0;
          while (i < j) {
            try
            {
              localStringBuilder.append(((SendMessageHandler.SendMessageRunnable)this.jdField_a_of_type_JavaUtilList.get(i)).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SendMessageHandler
 * JD-Core Version:    0.7.0.1
 */