package com.tencent.tkd.topicsdk.widget.videocapture;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.tkd.R.string;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/widget/videocapture/CaptureOperateTouchLayout$setup$1", "Lcom/tencent/tkd/topicsdk/widget/videocapture/CaptureOperateTouchLayout$IndicatorLongPressCallback;", "onLongPressJudgeCancel", "", "onLongPressStart", "onShortLongPressStart", "onTouchUp", "isFromLongPress", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CaptureOperateTouchLayout$setup$1
  implements CaptureOperateTouchLayout.IndicatorLongPressCallback
{
  CaptureOperateTouchLayout$setup$1(TextView paramTextView, VideoMeasureScaleView paramVideoMeasureScaleView, ImageView paramImageView) {}
  
  public void a()
  {
    this.b.setText(R.string.P);
    this.c.setVisibility(4);
    int i = this.a.getVideoSeekPosition();
    CaptureOperateTouchLayout.a(this.a, this.d.getX() / CaptureOperateTouchLayout.e(this.a));
    CaptureOperateTouchLayout.a(this.a, i);
    CaptureOperateTouchLayout.OnCaptureOperateCallback localOnCaptureOperateCallback = this.a.getOnCaptureOperateCallback();
    if (localOnCaptureOperateCallback != null)
    {
      CaptureOperateTouchLayout localCaptureOperateTouchLayout = this.a;
      localOnCaptureOperateCallback.a(i, CaptureOperateTouchLayout.b(localCaptureOperateTouchLayout, CaptureOperateTouchLayout.g(localCaptureOperateTouchLayout)));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    CaptureOperateTouchLayout.OnCaptureOperateCallback localOnCaptureOperateCallback = this.a.getOnCaptureOperateCallback();
    if (localOnCaptureOperateCallback != null) {
      localOnCaptureOperateCallback.a();
    }
    this.b.setText(R.string.o);
    this.c.setVisibility(4);
  }
  
  public void b()
  {
    this.b.setText(R.string.Q);
  }
  
  public void c()
  {
    this.c.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocapture.CaptureOperateTouchLayout.setup.1
 * JD-Core Version:    0.7.0.1
 */