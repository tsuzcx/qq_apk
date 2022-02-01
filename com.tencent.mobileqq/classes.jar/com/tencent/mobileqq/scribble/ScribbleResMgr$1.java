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
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleMessage  status: ");
      ((StringBuilder)localObject1).append(paramMessage.what);
      ((StringBuilder)localObject1).append(" type: ");
      ((StringBuilder)localObject1).append(paramMessage.arg1);
      QLog.d("ScribbleResMgr", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramMessage.what == 1001)
    {
      ScribbleResMgr.a(this.a, paramMessage.arg1, paramMessage.arg2, true);
      return;
    }
    if (paramMessage.what == 1002)
    {
      ScribbleResMgr.a(this.a, paramMessage.arg1, paramMessage.arg2, false);
      return;
    }
    Object localObject1 = ScribbleResMgr.a(this.a).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ScribbleResMgr.CallbackPack)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        View localView = ((ScribbleResMgr.CallbackPack)localObject2).a();
        localObject2 = ((ScribbleResMgr.CallbackPack)localObject2).a();
        if ((localView != null) && (localObject2 != null)) {
          ((ResCallback)localObject2).a(localView, paramMessage.arg1, (ResInfo)paramMessage.obj, paramMessage.what);
        } else {
          ((Iterator)localObject1).remove();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr.1
 * JD-Core Version:    0.7.0.1
 */