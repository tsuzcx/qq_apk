package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class QBApkProcesser$1
  extends Handler
{
  QBApkProcesser$1(QBApkProcesser paramQBApkProcesser, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    for (;;)
    {
      try
      {
        int i = paramMessage.what;
        switch (i)
        {
        }
      }
      catch (Exception localException)
      {
        Object[] arrayOfObject1;
        localException.printStackTrace();
        continue;
        Object[] arrayOfObject2 = (Object[])paramMessage.obj;
        QBApkProcesser.access$000(this.this$0, (Context)arrayOfObject2[0]);
        continue;
        arrayOfObject2 = (Object[])paramMessage.obj;
        QBApkProcesser.access$100(this.this$0, (Context)arrayOfObject2[0], (String)arrayOfObject2[1]);
        continue;
      }
      super.handleMessage(paramMessage);
      return;
      arrayOfObject1 = (Object[])paramMessage.obj;
      QBApkProcesser.openUrlByQBInThread((Context)arrayOfObject1[0], (String)arrayOfObject1[1]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.utils.QBApkProcesser.1
 * JD-Core Version:    0.7.0.1
 */