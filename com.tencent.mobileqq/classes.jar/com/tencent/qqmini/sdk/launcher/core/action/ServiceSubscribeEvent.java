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
    Object localObject = new StringBuilder("SubscribeEvent ");
    ((StringBuilder)localObject).append("eventName = ");
    ((StringBuilder)localObject).append(this.event);
    ((StringBuilder)localObject).append("sourceWebViewId = ");
    ((StringBuilder)localObject).append(this.sourceId);
    QMLog.d("Action", ((StringBuilder)localObject).toString());
    localObject = this.target;
    if (localObject != null) {
      paramBaseRuntime = (BaseRuntime)localObject;
    } else {
      paramBaseRuntime = paramBaseRuntime.getJsService();
    }
    if (paramBaseRuntime != null) {
      paramBaseRuntime.evaluateSubscribeJS(this.event, this.jsonParams, this.sourceId);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent
 * JD-Core Version:    0.7.0.1
 */