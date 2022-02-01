package com.tencent.mobileqq.onlinestatus;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

class AutoReplyEditActivity$8
  implements Runnable
{
  AutoReplyEditActivity$8(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public void run()
  {
    AutoReplyEditActivity.c(this.this$0, true);
    ViewGroup.LayoutParams localLayoutParams = AutoReplyEditActivity.i(this.this$0).getLayoutParams();
    AutoReplyEditActivity.j(this.this$0).setImageResource(2130837628);
    AutoReplyEditActivity.j(this.this$0).setContentDescription(this.this$0.getQBaseActivity().getString(2131887158));
    AutoReplyEditActivity.j(this.this$0).setOnClickListener(new AutoReplyEditActivity.8.1(this));
    AutoReplyEditActivity.k(this.this$0).setVisibility(0);
    localLayoutParams.height = (ScreenUtil.SCREEN_HIGHT / 3 + ScreenUtil.dip2px(50.0F));
    AutoReplyEditActivity.i(this.this$0).setMinimumHeight(localLayoutParams.height);
    AutoReplyEditActivity.i(this.this$0).setLayoutParams(localLayoutParams);
    AutoReplyEditActivity.l(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity.8
 * JD-Core Version:    0.7.0.1
 */