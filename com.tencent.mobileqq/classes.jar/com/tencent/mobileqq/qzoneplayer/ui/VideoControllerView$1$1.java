package com.tencent.mobileqq.qzoneplayer.ui;

import android.view.MenuItem;
import android.widget.PopupMenu.OnMenuItemClickListener;

class VideoControllerView$1$1
  implements PopupMenu.OnMenuItemClickListener
{
  VideoControllerView$1$1(VideoControllerView.1 param1) {}
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = paramMenuItem.getTitle();
    if (paramMenuItem.equals("0.25倍速")) {
      this.this$1.this$0.mPlayer.setRate(0.25F);
    }
    for (;;)
    {
      return false;
      if (paramMenuItem.equals("0.5倍速")) {
        this.this$1.this$0.mPlayer.setRate(0.5F);
      } else if (paramMenuItem.equals("正常")) {
        this.this$1.this$0.mPlayer.setRate(1.0F);
      } else if (paramMenuItem.equals("1.5倍速")) {
        this.this$1.this$0.mPlayer.setRate(1.5F);
      } else if (paramMenuItem.equals("2.0倍速")) {
        this.this$1.this$0.mPlayer.setRate(2.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.1.1
 * JD-Core Version:    0.7.0.1
 */