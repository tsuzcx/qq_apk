package com.tencent.secprotocol;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ByteData$QdataHandler
  extends Handler
{
  public ByteData$QdataHandler(ByteData paramByteData, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 161: 
      ByteData.access$200(this.this$0, paramMessage.obj);
      return;
    }
    ByteData.access$300(this.this$0, Long.valueOf((String)paramMessage.obj).longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.secprotocol.ByteData.QdataHandler
 * JD-Core Version:    0.7.0.1
 */