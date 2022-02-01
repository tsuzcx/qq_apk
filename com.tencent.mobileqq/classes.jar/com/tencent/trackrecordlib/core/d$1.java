package com.tencent.trackrecordlib.core;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

class d$1
  extends Handler
{
  d$1(d paramd) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      Log.e("RecordThread", "can't accept msg.what: " + paramMessage.what);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trackrecordlib.core.d.1
 * JD-Core Version:    0.7.0.1
 */