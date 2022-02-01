package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import com.tencent.tkd.topicsdk.framework.events.UserActionEvent;
import com.tencent.tkd.topicsdk.widget.videocapture.CaptureOperateTouchLayout.OnIndicatorPressCallback;
import com.tencent.tkd.topicsdk.widget.videocapture.CaptureOperateTouchLayout.OnIndicatorPressCallback.DefaultImpls;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView$initCaptureOperateView$2", "Lcom/tencent/tkd/topicsdk/widget/videocapture/CaptureOperateTouchLayout$OnIndicatorPressCallback;", "onTouchDown", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class VideoCaptureView$initCaptureOperateView$2
  implements CaptureOperateTouchLayout.OnIndicatorPressCallback
{
  public void a()
  {
    DispatchManager.a.a((IEvent)new UserActionEvent(null, ReportEventKey.EVENT_DRAG, ReportEventPage.PAGE_SELECT_VIDEO_COVER, ReportEventElement.WIDGET_SELECT_COVER_FRAME, null, null, null, 113, null));
  }
  
  public void b()
  {
    CaptureOperateTouchLayout.OnIndicatorPressCallback.DefaultImpls.a(this);
  }
  
  public void c()
  {
    CaptureOperateTouchLayout.OnIndicatorPressCallback.DefaultImpls.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.VideoCaptureView.initCaptureOperateView.2
 * JD-Core Version:    0.7.0.1
 */