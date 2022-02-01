package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

final class VideoFeedsHelper$13
  extends ClickableSpan
{
  VideoFeedsHelper$13(TextView paramTextView) {}
  
  public void onClick(View paramView)
  {
    this.a.performClick();
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.parseColor("#FF00CAFC"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper.13
 * JD-Core Version:    0.7.0.1
 */