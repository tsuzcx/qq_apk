package com.tencent.viola.core;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.viola.ui.action.DOMAction;
import java.util.List;

public class ViolaDomHandler
  implements Handler.Callback
{
  public static final int DELAY_TIME = 16;
  public static final int TRANSITION_DELAY_TIME = 5;
  private ViolaDomManager mDomManager;
  
  public ViolaDomHandler(ViolaDomManager paramViolaDomManager)
  {
    this.mDomManager = paramViolaDomManager;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return false;
    }
    int i = paramMessage.what;
    paramMessage = paramMessage.obj;
    if ((paramMessage != null) && ((paramMessage instanceof ViolaDomTask))) {}
    for (paramMessage = (ViolaDomTask)paramMessage;; paramMessage = null)
    {
      long l;
      if (i != 2)
      {
        if (this.mDomManager.hasMessages(2)) {
          this.mDomManager.removeMessages(2);
        }
        ViolaDomManager localViolaDomManager = this.mDomManager;
        if (i == 4)
        {
          l = 5L;
          localViolaDomManager.sendEmptyMessageDelayed(2, l);
        }
      }
      else
      {
        switch (i)
        {
        }
      }
      for (;;)
      {
        return true;
        l = 16L;
        break;
        this.mDomManager.executeAction(paramMessage.instanceId, (DOMAction)paramMessage.args.get(0), ((Boolean)paramMessage.args.get(1)).booleanValue());
        continue;
        this.mDomManager.executeAction(paramMessage.instanceId, (DOMAction)paramMessage.args.get(0), ((Boolean)paramMessage.args.get(1)).booleanValue());
        continue;
        this.mDomManager.batch();
        continue;
        this.mDomManager.consumeRenderTask(paramMessage.instanceId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.core.ViolaDomHandler
 * JD-Core Version:    0.7.0.1
 */