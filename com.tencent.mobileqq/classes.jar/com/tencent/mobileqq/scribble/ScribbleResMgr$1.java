package com.tencent.mobileqq.scribble;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class ScribbleResMgr$1
  extends Handler
{
  ScribbleResMgr$1(ScribbleResMgr paramScribbleResMgr, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScribbleResMgr", 2, "handleMessage  status: " + paramMessage.what + " type: " + paramMessage.arg1);
    }
    if (paramMessage.what == 1001) {
      ScribbleResMgr.a(this.a, paramMessage.arg1, paramMessage.arg2, true);
    }
    for (;;)
    {
      return;
      if (paramMessage.what == 1002)
      {
        ScribbleResMgr.a(this.a, paramMessage.arg1, paramMessage.arg2, false);
        return;
      }
      Iterator localIterator = ScribbleResMgr.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (ScribbleResMgr.CallbackPack)localIterator.next();
        if (localObject != null)
        {
          View localView = ((ScribbleResMgr.CallbackPack)localObject).a();
          localObject = ((ScribbleResMgr.CallbackPack)localObject).a();
          if ((localView != null) && (localObject != null)) {
            ((ScribbleResMgr.ResCallback)localObject).a(localView, paramMessage.arg1, (ScribbleResMgr.ResInfo)paramMessage.obj, paramMessage.what);
          } else {
            localIterator.remove();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr.1
 * JD-Core Version:    0.7.0.1
 */