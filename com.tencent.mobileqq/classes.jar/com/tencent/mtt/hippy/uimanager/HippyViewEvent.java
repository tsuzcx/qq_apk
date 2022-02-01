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
    if ((paramView != null) && ((paramView.getContext() instanceof HippyInstanceContext)))
    {
      Object localObject = ((HippyInstanceContext)paramView.getContext()).getEngineContext();
      if (localObject == null) {
        return;
      }
      localObject = ((HippyEngineContext)localObject).getModuleManager();
      if (localObject != null) {
        ((EventDispatcher)((HippyModuleManager)localObject).getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(paramView.getId(), this.mEventName, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.HippyViewEvent
 * JD-Core Version:    0.7.0.1
 */