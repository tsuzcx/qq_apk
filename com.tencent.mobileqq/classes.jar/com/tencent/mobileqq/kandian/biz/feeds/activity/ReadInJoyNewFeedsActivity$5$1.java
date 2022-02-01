package com.tencent.mobileqq.kandian.biz.feeds.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinGuideView;
import com.tencent.mobileqq.utils.SharedPreUtils;

class ReadInJoyNewFeedsActivity$5$1
  implements View.OnClickListener
{
  ReadInJoyNewFeedsActivity$5$1(ReadInJoyNewFeedsActivity.5 param5, FrameLayout paramFrameLayout) {}
  
  public void onClick(View paramView)
  {
    this.b.this$0.k.a();
    this.a.removeView(this.b.this$0.k);
    if (QQManagerFactory.READ_INJOY_SKIN_MANAGER == this.b.c) {
      SharedPreUtils.u(this.b.this$0, this.b.this$0.app.getCurrentAccountUin(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity.5.1
 * JD-Core Version:    0.7.0.1
 */