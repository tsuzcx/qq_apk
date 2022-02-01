package com.tencent.viola.core;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.viola.ui.action.DOMAction;
import com.tencent.viola.ui.action.MethodAddElement;
import com.tencent.viola.ui.action.MethodCreateBody;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.vinstance.VInstanceManager;
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
  
  private boolean isNeedLayoutImmediately(ViolaDomTask paramViolaDomTask)
  {
    if ((paramViolaDomTask != null) && (paramViolaDomTask.args != null) && (paramViolaDomTask.args.size() > 0) && (paramViolaDomTask.args.get(0) != null))
    {
      paramViolaDomTask = paramViolaDomTask.args.get(0);
      if ((paramViolaDomTask instanceof MethodAddElement)) {
        return ((MethodAddElement)paramViolaDomTask).isAddVInstance();
      }
      if ((paramViolaDomTask instanceof MethodCreateBody)) {
        return ((MethodCreateBody)paramViolaDomTask).isCreateFromNativeVue();
      }
    }
    return false;
  }
  
  private void performExecuteAction(ViolaDomTask paramViolaDomTask)
  {
    this.mDomManager.executeAction(paramViolaDomTask.instanceId, (DOMAction)paramViolaDomTask.args.get(0), ((Boolean)paramViolaDomTask.args.get(1)).booleanValue());
    if (isNeedLayoutImmediately(paramViolaDomTask))
    {
      this.mDomManager.getDomContext(paramViolaDomTask.instanceId).markDirty();
      if ((!(paramViolaDomTask.args.get(0) instanceof MethodCreateBody)) || (!((MethodCreateBody)paramViolaDomTask.args.get(0)).isCreateFromNativeVue())) {
        break label149;
      }
      this.mDomManager.forceNvBatch();
    }
    for (;;)
    {
      if ((paramViolaDomTask.args.get(0) instanceof MethodAddElement)) {
        VInstanceManager.getInstance().addVInstance(((MethodAddElement)paramViolaDomTask.args.get(0)).getRef(), paramViolaDomTask.instanceId);
      }
      return;
      label149:
      this.mDomManager.batch();
    }
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
      if ((i != 2) && (!isNeedLayoutImmediately(paramMessage)))
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
        performExecuteAction(paramMessage);
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