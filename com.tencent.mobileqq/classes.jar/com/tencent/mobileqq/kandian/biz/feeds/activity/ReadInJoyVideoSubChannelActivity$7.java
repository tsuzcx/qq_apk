package com.tencent.mobileqq.kandian.biz.feeds.activity;

import android.view.View;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ReadInJoyVideoSubChannelActivity$7
  implements ActionSheet.OnButtonClickListener
{
  ReadInJoyVideoSubChannelActivity$7(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity, ChannelInfo paramChannelInfo) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      ReadInJoyVideoSubChannelActivity.a(this.b, this.a, false);
      ReadInJoyVideoSubChannelActivity.d(this.b).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyVideoSubChannelActivity.7
 * JD-Core Version:    0.7.0.1
 */