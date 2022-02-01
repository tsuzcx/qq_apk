package com.tencent.mtt.hippy.uimanager;

import android.view.View;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;

public class HippyViewEvent
{
  private final String mEventName;
  
  public HippyViewEvent(String paramString)
  {
    this.mEventName = paramString;
  }
  
  public void send(int paramInt, HippyEngineContext paramHippyEngineContext, Object paramObject)
  {
    if (paramHippyEngineContext == null) {
      return;
    }
    paramHippyEngineContext = paramHippyEngineContext.getModuleManager();
    if (paramHippyEngineContext != null) {
      ((EventDispatcher)paramHippyEngineContext.getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(paramInt, this.mEventName, paramObject);
    }
  }
  
  public void send(View paramView, Object paramObject)
  {
    if ((paramView != null) && ((paramView.getContext() instanceof HippyInstanceContext)))
    {
      HippyEngineContext localHippyEngineContext = ((HippyInstanceContext)paramView.getContext()).getEngineContext();
      send(paramView.getId(), localHippyEngineContext, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.HippyViewEvent
 * JD-Core Version:    0.7.0.1
 */