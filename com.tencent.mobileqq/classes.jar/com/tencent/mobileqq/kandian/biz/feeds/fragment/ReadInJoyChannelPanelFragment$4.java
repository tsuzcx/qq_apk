package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyChannelPanelFragment$4
  implements View.OnClickListener
{
  ReadInJoyChannelPanelFragment$4(ReadInJoyChannelPanelFragment paramReadInJoyChannelPanelFragment, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.b.getBaseActivity(), QQBrowserActivity.class);
    paramView.putExtra("url", this.a);
    this.b.getBaseActivity().startActivity(paramView);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("info.mChannelJumpUrl:");
      paramView.append(this.a);
      QLog.d("ReadInJoyChannelPanelFragment", 2, paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyChannelPanelFragment.4
 * JD-Core Version:    0.7.0.1
 */