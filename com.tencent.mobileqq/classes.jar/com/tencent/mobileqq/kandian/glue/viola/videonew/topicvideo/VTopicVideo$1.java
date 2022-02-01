package com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo;

import com.tencent.mobileqq.kandian.glue.viola.videonew.VVideoView.OnVideoViewLifeCycleChangeListener;
import com.tencent.viola.core.dispatch.ComponentAppearEvent;
import com.tencent.viola.core.dispatch.IEvent;
import com.tencent.viola.core.dispatch.IObserver;

class VTopicVideo$1
  implements IObserver
{
  VTopicVideo$1(VTopicVideo paramVTopicVideo) {}
  
  public String getRef()
  {
    return this.a.getRef();
  }
  
  public void onReceive(IEvent paramIEvent)
  {
    if ((paramIEvent.getRef().equals(this.a.getRef())) && (this.a.getVideoLifeCycleChangeListener() != null))
    {
      paramIEvent = (ComponentAppearEvent)paramIEvent;
      if (paramIEvent.event.equals("didDisappear"))
      {
        this.a.getVideoLifeCycleChangeListener().dd_();
        return;
      }
      if (paramIEvent.event.equals("willAppear"))
      {
        this.a.getVideoLifeCycleChangeListener().db_();
        return;
      }
      if (paramIEvent.event.equals("didAppear")) {
        this.a.getVideoLifeCycleChangeListener().dc_();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo.VTopicVideo.1
 * JD-Core Version:    0.7.0.1
 */