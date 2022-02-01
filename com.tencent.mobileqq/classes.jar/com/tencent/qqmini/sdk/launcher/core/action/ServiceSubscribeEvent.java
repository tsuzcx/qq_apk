package com.tencent.qqmini.sdk.launcher.core.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class ServiceSubscribeEvent
  implements Action<String>
{
  private String event;
  private String jsonParams;
  private int sourceId;
  private IJsService target;
  
  public static ServiceSubscribeEvent obtain(String paramString1, String paramString2, int paramInt)
  {
    ServiceSubscribeEvent localServiceSubscribeEvent = new ServiceSubscribeEvent();
    localServiceSubscribeEvent.event = paramString1;
    localServiceSubscribeEvent.jsonParams = paramString2;
    localServiceSubscribeEvent.sourceId = paramInt;
    return localServiceSubscribeEvent;
  }
  
  public static ServiceSubscribeEvent obtain(String paramString1, String paramString2, int paramInt, IJsService paramIJsService)
  {
    ServiceSubscribeEvent localServiceSubscribeEvent = new ServiceSubscribeEvent();
    localServiceSubscribeEvent.event = paramString1;
    localServiceSubscribeEvent.jsonParams = paramString2;
    localServiceSubscribeEvent.sourceId = paramInt;
    localServiceSubscribeEvent.target = paramIJsService;
    return localServiceSubscribeEvent;
  }
  
  public String perform(BaseRuntime paramBaseRuntime)
  {
    QMLog.d("Action", "SubscribeEvent " + "eventName = " + this.event + "sourceWebViewId = " + this.sourceId);
    if (this.target != null) {}
    for (paramBaseRuntime = this.target;; paramBaseRuntime = paramBaseRuntime.getJsService())
    {
      if (paramBaseRuntime != null) {
        paramBaseRuntime.evaluateSubscribeJS(this.event, this.jsonParams, this.sourceId);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent
 * JD-Core Version:    0.7.0.1
 */