package com.tencent.viola.core;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.viola.ui.action.DOMAction;
import com.tencent.viola.ui.action.MethodAddElement;
import com.tencent.viola.ui.action.MethodCreateBody;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.utils.ViolaUtils;
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
      if (((paramViolaDomTask.args.get(0) instanceof MethodCreateBody)) && (((MethodCreateBody)paramViolaDomTask.args.get(0)).isCreateFromNativeVue()))
      {
        if (ViolaUtils.isLayoutOpmOpen())
        {
          this.mDomManager.forceNvBatch(paramViolaDomTask.instanceId);
          return;
        }
        this.mDomManager.forceNvBatch();
        return;
      }
      this.mDomManager.batch();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return false;
    }
    int i = paramMessage.what;
    Object localObject2 = paramMessage.obj;
    Message localMessage = null;
    Object localObject1 = localMessage;
    if (localObject2 != null)
    {
      localObject1 = localMessage;
      if ((localObject2 instanceof ViolaDomTask)) {
        localObject1 = (ViolaDomTask)localObject2;
      }
    }
    if ((i != 2) && (!isNeedLayoutImmediately((ViolaDomTask)localObject1)))
    {
      if (this.mDomManager.hasMessages(2)) {
        this.mDomManager.removeMessages(2);
      }
      localMessage = Message.obtain();
      localMessage.obj = ((ViolaDomTask)localObject1).instanceId;
      localMessage.what = 2;
      localObject2 = this.mDomManager;
      long l;
      if (i == 4) {
        l = 5L;
      } else {
        l = 16L;
      }
      ((ViolaDomManager)localObject2).sendMessageDelayed(localMessage, l);
    }
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return true;
          }
          this.mDomManager.executeAction(((ViolaDomTask)localObject1).instanceId, (DOMAction)((ViolaDomTask)localObject1).args.get(0), ((Boolean)((ViolaDomTask)localObject1).args.get(1)).booleanValue());
          return true;
        }
        this.mDomManager.consumeRenderTask(((ViolaDomTask)localObject1).instanceId);
        return true;
      }
      if (ViolaUtils.isLayoutOpmOpen())
      {
        this.mDomManager.batch((String)paramMessage.obj);
        return true;
      }
      this.mDomManager.batch();
      return true;
    }
    performExecuteAction((ViolaDomTask)localObject1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.ViolaDomHandler
 * JD-Core Version:    0.7.0.1
 */