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
      ByteData.access$600(this.this$0, paramMessage.obj);
      return;
    }
    ByteData.access$700(this.this$0, Long.valueOf((String)paramMessage.obj).longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.secprotocol.ByteData.QdataHandler
 * JD-Core Version:    0.7.0.1
 */