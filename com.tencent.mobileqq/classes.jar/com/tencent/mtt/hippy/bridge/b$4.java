package com.tencent.mtt.hippy.bridge;

import android.os.Handler;
import android.os.Message;
import com.tencent.mtt.hippy.common.Callback;

class b$4
  extends NativeCallback
{
  b$4(b paramb, Handler paramHandler, Callback paramCallback)
  {
    super(paramHandler);
  }
  
  public void Call(long paramLong, Message paramMessage, String paramString)
  {
    boolean bool;
    if (paramLong == 1L) {
      bool = true;
    } else {
      bool = false;
    }
    Boolean localBoolean = Boolean.valueOf(bool);
    this.b.c.onDestroy();
    if (this.a != null)
    {
      paramString = null;
      if (!localBoolean.booleanValue())
      {
        paramString = new StringBuilder();
        paramString.append("destroy core failed!!! msg.what=");
        paramString.append(paramMessage.what);
        paramString = new RuntimeException(paramString.toString());
      }
      this.a.callback(localBoolean, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.b.4
 * JD-Core Version:    0.7.0.1
 */