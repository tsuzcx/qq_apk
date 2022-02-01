package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.SeekBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, k=3, mv={1, 1, 16})
final class VideoMaskController$onTouchListener$1
  implements View.OnTouchListener
{
  VideoMaskController$onTouchListener$1(VideoMaskController paramVideoMaskController) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramMotionEvent, "event");
    int i = (int)paramMotionEvent.getRawX() - VideoMaskController.i(this.a);
    int j = (int)paramMotionEvent.getRawY() - VideoMaskController.j(this.a);
    int k = paramMotionEvent.getAction() & 0xFF;
    if (k != 0)
    {
      if (k != 1) {
        if (k != 2)
        {
          if (k != 3) {
            return true;
          }
        }
        else
        {
          if (Math.abs(j) - Math.abs(i) * 2 > 0)
          {
            VideoMaskController.b(this.a).requestDisallowInterceptTouchEvent(false);
            return false;
          }
          paramView = this.a.b();
          if ((paramView == null) || (VideoMaskController.b(this.a).getWidth() == 0)) {
            break label287;
          }
          float f1 = (int)paramMotionEvent.getRawX() - VideoMaskController.i(this.a);
          float f3 = 100;
          float f2 = f1 * f3 / VideoMaskController.b(this.a).getWidth() + VideoMaskController.k(this.a);
          if (f2 < 0)
          {
            f1 = 0.0F;
          }
          else
          {
            f1 = f2;
            if (f2 >= f3) {
              f1 = 99.0F;
            }
          }
          paramView.setProgress((int)f1);
          if ((Math.abs(i) <= 6) || (this.a.e())) {
            break label287;
          }
          VideoMaskController.l(this.a).onStartTrackingTouch(this.a.b());
          return true;
        }
      }
      if (Math.abs(i) >= 6)
      {
        if (Math.abs(j) - Math.abs(i) > 0) {
          return false;
        }
        VideoMaskController.l(this.a).onStopTrackingTouch(this.a.b());
        label287:
        return true;
      }
      return false;
    }
    VideoMaskController.a(this.a, (int)paramMotionEvent.getRawX());
    VideoMaskController.b(this.a, (int)paramMotionEvent.getRawY());
    paramView = this.a;
    VideoMaskController.c(paramView, paramView.b().getProgress());
    VideoMaskController.b(this.a).requestDisallowInterceptTouchEvent(true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoMaskController.onTouchListener.1
 * JD-Core Version:    0.7.0.1
 */