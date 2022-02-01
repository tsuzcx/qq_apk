package com.tencent.mobileqq.qzoneplayer.ui;

import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupMenu;
import com.tencent.oskplayer.util.PlayerUtils;

class VideoControllerView$1
  implements View.OnTouchListener
{
  int currentDownCount = 0;
  String mTitle = "播放速度调节";
  int maxDownCount = 5;
  long startTimestamp = 0L;
  long timeLimitMs = 5000L;
  
  VideoControllerView$1(VideoControllerView paramVideoControllerView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if (System.currentTimeMillis() - this.startTimestamp > this.timeLimitMs)
      {
        this.currentDownCount = 0;
        PlayerUtils.log(2, "hahax", "restart counter");
      }
      if (this.currentDownCount == 0) {
        this.startTimestamp = System.currentTimeMillis();
      }
      this.currentDownCount += 1;
      paramView = new StringBuilder();
      paramView.append("count");
      paramView.append(this.currentDownCount);
      PlayerUtils.log(2, "hahax", paramView.toString());
      if (this.currentDownCount >= this.maxDownCount)
      {
        paramView = new PopupMenu(this.this$0.getContext(), VideoControllerView.access$000(this.this$0));
        paramView.getMenu().add(this.mTitle);
        paramView.getMenu().add("0.25倍速");
        paramView.getMenu().add("0.5倍速");
        paramView.getMenu().add("正常");
        paramView.getMenu().add("1.5倍速");
        paramView.getMenu().add("2.0倍速");
        paramView.setOnMenuItemClickListener(new VideoControllerView.1.1(this));
        paramView.show();
        this.currentDownCount = 0;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.1
 * JD-Core Version:    0.7.0.1
 */