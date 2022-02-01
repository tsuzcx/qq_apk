package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoMaskController$expandTouchArea$1$1"}, k=3, mv={1, 1, 16})
final class VideoMaskController$expandTouchArea$$inlined$let$lambda$1
  implements Runnable
{
  VideoMaskController$expandTouchArea$$inlined$let$lambda$1(ViewParent paramViewParent, VideoMaskController paramVideoMaskController, View paramView, float paramFloat1, float paramFloat2) {}
  
  public final void run()
  {
    try
    {
      Rect localRect = new Rect();
      this.b.setEnabled(true);
      this.b.getHitRect(localRect);
      localRect.top -= AIOUtils.b(this.c, this.b.getResources());
      localRect.bottom += AIOUtils.b(this.d, this.b.getResources());
      ((View)this.a).setTouchDelegate(new TouchDelegate(localRect, this.b));
      str = this.this$0.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[expandTouchArea] after, top = ");
      localStringBuilder.append(localRect.top);
      localStringBuilder.append(", bottom = ");
      localStringBuilder.append(localRect.bottom);
      QLog.i(str, 1, localStringBuilder.toString());
      return;
    }
    catch (Exception localException)
    {
      String str = this.this$0.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[expandTouchArea] e = ");
      localStringBuilder.append(localException);
      QLog.e(str, 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoMaskController.expandTouchArea..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */