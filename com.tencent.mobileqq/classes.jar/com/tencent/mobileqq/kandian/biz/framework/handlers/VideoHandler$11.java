package com.tencent.mobileqq.kandian.biz.framework.handlers;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.glue.viola.event.ViolaEvent;
import java.util.ArrayList;

class VideoHandler$11
  implements SimpleEventReceiver<ViolaEvent>
{
  VideoHandler$11(VideoHandler paramVideoHandler) {}
  
  public ArrayList<Class<ViolaEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ViolaEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof ViolaEvent)) {
      ReadInJoyHelper.a(this.a.c, (ViolaEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler.11
 * JD-Core Version:    0.7.0.1
 */