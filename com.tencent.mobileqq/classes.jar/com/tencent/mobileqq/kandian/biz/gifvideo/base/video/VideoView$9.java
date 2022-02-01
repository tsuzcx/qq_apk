package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.kandian.glue.viola.event.ViolaEvent;
import java.util.ArrayList;

class VideoView$9
  implements SimpleEventReceiver<ViolaEvent>
{
  VideoView$9(VideoView paramVideoView) {}
  
  public ArrayList<Class<ViolaEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ViolaEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof ViolaEvent)) {
      VideoView.access$1400(this.a, (ViolaEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoView.9
 * JD-Core Version:    0.7.0.1
 */