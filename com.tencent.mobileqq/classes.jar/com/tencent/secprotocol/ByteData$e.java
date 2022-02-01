package com.tencent.secprotocol;

import a.a.a.b.d;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class ByteData$e
  extends Handler
{
  public ByteData$e(ByteData paramByteData, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    d locald = (d)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 162: 
      ByteData.access$700(this.a, Long.valueOf((String)locald.c).longValue());
      return;
    }
    ByteData.logCat("java_poxy", "cmd: " + locald.a + " reqType: " + locald.b);
    ByteData.access$400(this.a, paramMessage.what, locald.a, locald.b, locald.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.secprotocol.ByteData.e
 * JD-Core Version:    0.7.0.1
 */