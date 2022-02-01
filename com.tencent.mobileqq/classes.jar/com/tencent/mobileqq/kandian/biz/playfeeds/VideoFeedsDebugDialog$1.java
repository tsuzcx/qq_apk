package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class VideoFeedsDebugDialog$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (VideoFeedsDebugDialog.a(this.a).getVisibility() == 0)
    {
      VideoFeedsDebugDialog.a(this.a);
      return;
    }
    VideoFeedsDebugDialog.a(this.a);
    VideoFeedsDebugDialog.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsDebugDialog.1
 * JD-Core Version:    0.7.0.1
 */