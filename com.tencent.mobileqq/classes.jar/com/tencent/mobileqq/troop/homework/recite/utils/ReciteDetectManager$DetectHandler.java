package com.tencent.mobileqq.troop.homework.recite.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class ReciteDetectManager$DetectHandler
  extends Handler
{
  public ReciteDetectManager$DetectHandler(ReciteDetectManager paramReciteDetectManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    for (;;)
    {
      try
      {
        switch (paramMessage.what)
        {
        case 2: 
          return;
        }
      }
      finally {}
      paramMessage = paramMessage.getData();
      ReciteDetectManager.a(this.a, paramMessage.getDouble("startTime"), paramMessage.getStringArray("pinyins"));
      ReciteDetectManager.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.utils.ReciteDetectManager.DetectHandler
 * JD-Core Version:    0.7.0.1
 */