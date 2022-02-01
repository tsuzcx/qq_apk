package com.tencent.mobileqq.vas.gldrawable;

import android.os.Handler.Callback;
import android.os.Message;

class GLDrawableProxy$3
  implements Handler.Callback
{
  GLDrawableProxy$3(GLDrawableProxy paramGLDrawableProxy) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.obj != null)) {
      GLDrawableProxy.a().a(paramMessage.obj.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.GLDrawableProxy.3
 * JD-Core Version:    0.7.0.1
 */