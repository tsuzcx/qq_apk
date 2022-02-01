package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.troop.viewmodel.PictureShowActionEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class BridgeModule$10
  implements SimpleEventReceiver<PictureShowActionEvent>
{
  BridgeModule$10(BridgeModule paramBridgeModule) {}
  
  public ArrayList<Class<PictureShowActionEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(PictureShowActionEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof PictureShowActionEvent))
    {
      paramSimpleBaseEvent = (PictureShowActionEvent)paramSimpleBaseEvent;
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("retCode", 0);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("clickType", paramSimpleBaseEvent.getType());
        localJSONObject.put("liked", paramSimpleBaseEvent.isLiked());
        ((JSONObject)localObject).put("data", localJSONObject);
        this.a.invokeCallJS(paramSimpleBaseEvent.getCallbackId(), localObject);
        return;
      }
      catch (JSONException paramSimpleBaseEvent)
      {
        QLog.e("BridgeModule", 1, paramSimpleBaseEvent, new Object[] { "showPictureActionReceiver onReceiveEvent" });
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showPictureActionReceiver, errorEvent, eventClass=");
    ((StringBuilder)localObject).append(paramSimpleBaseEvent.getClass().getName());
    QLog.e("BridgeModule", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule.10
 * JD-Core Version:    0.7.0.1
 */