package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.widget.QQToast;

class VideoFeedsDebugDialog$6
  implements View.OnLongClickListener
{
  public boolean onLongClick(View paramView)
  {
    VideoFeedsDebugDialog.a(this.b, String.valueOf(((TextView)paramView).getText()));
    QQToast.makeText(this.a, "已复制信息", 0).show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsDebugDialog.6
 * JD-Core Version:    0.7.0.1
 */