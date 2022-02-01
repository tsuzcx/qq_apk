package com.tencent.mobileqq.onlinestatus;

import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import axum;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class AutoReplyEditActivity$8
  implements Runnable
{
  AutoReplyEditActivity$8(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public void run()
  {
    AutoReplyEditActivity.a(this.this$0, true);
    ViewGroup.LayoutParams localLayoutParams = AutoReplyEditActivity.a(this.this$0).getLayoutParams();
    AutoReplyEditActivity.a(this.this$0).setImageResource(2130837535);
    AutoReplyEditActivity.a(this.this$0).setContentDescription(this.this$0.getActivity().getString(2131690223));
    AutoReplyEditActivity.a(this.this$0).setOnClickListener(new axum(this));
    AutoReplyEditActivity.a(this.this$0).setVisibility(0);
    localLayoutParams.height = (ScreenUtil.SCREEN_HIGHT / 3 + ScreenUtil.dip2px(50.0F));
    AutoReplyEditActivity.a(this.this$0).setMinimumHeight(localLayoutParams.height);
    AutoReplyEditActivity.a(this.this$0).setLayoutParams(localLayoutParams);
    AutoReplyEditActivity.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity.8
 * JD-Core Version:    0.7.0.1
 */