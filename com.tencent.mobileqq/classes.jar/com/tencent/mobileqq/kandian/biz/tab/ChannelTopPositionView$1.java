package com.tencent.mobileqq.kandian.biz.tab;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoySelectPositionFragment;
import com.tencent.qphone.base.util.QLog;

class ChannelTopPositionView$1
  implements View.OnClickListener
{
  ChannelTopPositionView$1(ChannelTopPositionView paramChannelTopPositionView) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChannelTopPositionView", 2, "onclick");
    }
    if (ChannelTopPositionView.a(this.a) != null) {
      QPublicFragmentActivity.start(ChannelTopPositionView.a(this.a), ReadInJoySelectPositionFragment.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ChannelTopPositionView.1
 * JD-Core Version:    0.7.0.1
 */