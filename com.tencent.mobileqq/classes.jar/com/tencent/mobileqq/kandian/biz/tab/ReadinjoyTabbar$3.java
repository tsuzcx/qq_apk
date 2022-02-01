package com.tencent.mobileqq.kandian.biz.tab;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.widget.BubblePopupWindow;

class ReadinjoyTabbar$3
  implements View.OnClickListener
{
  ReadinjoyTabbar$3(ReadinjoyTabbar paramReadinjoyTabbar) {}
  
  public void onClick(View paramView)
  {
    if ((ReadinjoyTabbar.a(this.a) != null) && (ReadinjoyTabbar.a(this.a).isShowing())) {}
    try
    {
      ReadinjoyTabbar.a(this.a).a(3, 257, null, true);
      ReadinjoyTabbar.a(this.a).dismiss();
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabbar.3
 * JD-Core Version:    0.7.0.1
 */