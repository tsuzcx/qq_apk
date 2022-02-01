package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.kandian.biz.xtab.api.impl.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.glue.viola.event.ViolaEvent;
import java.util.ArrayList;
import org.json.JSONObject;

class KandianMergeManager$2
  implements SimpleEventReceiver<ViolaEvent>
{
  KandianMergeManager$2(KandianMergeManager paramKandianMergeManager) {}
  
  public ArrayList<Class<ViolaEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ViolaEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof ViolaEvent))
    {
      Object localObject = (ViolaEvent)paramSimpleBaseEvent;
      paramSimpleBaseEvent = ((ViolaEvent)localObject).eventName;
      localObject = ((ViolaEvent)localObject).data;
      if (paramSimpleBaseEvent != null)
      {
        if (localObject == null) {
          return;
        }
        if (TextUtils.equals(paramSimpleBaseEvent, "on_feeds_style_update"))
        {
          int i = ((JSONObject)localObject).optInt("type", -1);
          if (i == -1) {
            return;
          }
          RIJXTabFrameUtils.INSTANCE.updateFeedsStyleUserSetting(i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.2
 * JD-Core Version:    0.7.0.1
 */