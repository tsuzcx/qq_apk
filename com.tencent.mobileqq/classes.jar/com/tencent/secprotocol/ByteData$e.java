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
      ByteData.access$900(this.a, Long.valueOf((String)locald.c).longValue());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cmd: ");
    localStringBuilder.append(locald.a);
    localStringBuilder.append(" reqType: ");
    localStringBuilder.append(locald.b);
    ByteData.logCat("java_poxy", localStringBuilder.toString());
    ByteData.access$500(this.a, paramMessage.what, locald.a, locald.b, locald.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.secprotocol.ByteData.e
 * JD-Core Version:    0.7.0.1
 */