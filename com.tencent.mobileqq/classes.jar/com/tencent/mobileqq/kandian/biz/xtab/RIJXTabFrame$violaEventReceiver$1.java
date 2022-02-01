package com.tencent.mobileqq.kandian.biz.xtab;

import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.xtab.api.impl.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.glue.viola.event.ViolaEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/xtab/RIJXTabFrame$violaEventReceiver$1", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/kandian/glue/viola/event/ViolaEvent;", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "onReceiveEvent", "", "simpleBaseEvent", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabFrame$violaEventReceiver$1
  implements SimpleEventReceiver<ViolaEvent>
{
  @NotNull
  public ArrayList<Class<ViolaEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ViolaEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(@Nullable SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof ViolaEvent))
    {
      Object localObject = (ViolaEvent)paramSimpleBaseEvent;
      paramSimpleBaseEvent = ((ViolaEvent)localObject).eventName;
      localObject = ((ViolaEvent)localObject).data;
      if ((paramSimpleBaseEvent != null) && (localObject != null))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onReceiveEvent] violaEventReceiver, eventName = ");
        localStringBuilder.append(paramSimpleBaseEvent);
        localStringBuilder.append(", data = ");
        localStringBuilder.append(localObject);
        QLog.i("RIJXTabFrame", 1, localStringBuilder.toString());
        if (TextUtils.equals((CharSequence)paramSimpleBaseEvent, (CharSequence)"on_feeds_style_update"))
        {
          int i = ((JSONObject)localObject).optInt("type", -1);
          if (i == -1) {
            return;
          }
          RIJXTabFrameUtils.INSTANCE.updateFeedsStyleUserSetting(i);
          ThreadManager.getUIHandler().post((Runnable)new RIJXTabFrame.violaEventReceiver.1.onReceiveEvent.1(this));
          RIJXTabFrame.b(this.a, true);
        }
      }
      else
      {
        QLog.e("RIJXTabFrame", 1, "[onReceiveEvent] violaEventReceiver, eventName or data is null.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabFrame.violaEventReceiver.1
 * JD-Core Version:    0.7.0.1
 */