package com.tencent.mtt.hippy.uimanager;

import android.view.View;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;

public class HippyViewEvent
{
  private String mEventName;
  
  public HippyViewEvent(String paramString)
  {
    this.mEventName = paramString;
  }
  
  public void send(View paramView, Object paramObject)
  {
    Object localObject;
    if ((paramView != null) && ((paramView.getContext() instanceof HippyInstanceContext)))
    {
      localObject = ((HippyInstanceContext)paramView.getContext()).getEngineContext();
      if (localObject != null) {
        break label30;
      }
    }
    label30:
    do
    {
      return;
      localObject = ((HippyEngineContext)localObject).getModuleManager();
    } while (localObject == null);
    ((EventDispatcher)((HippyModuleManager)localObject).getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(paramView.getId(), this.mEventName, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.HippyViewEvent
 * JD-Core Version:    0.7.0.1
 */