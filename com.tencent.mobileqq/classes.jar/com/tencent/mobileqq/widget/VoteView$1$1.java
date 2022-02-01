package com.tencent.mobileqq.widget;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VoteView$1$1
  implements View.OnClickListener
{
  VoteView$1$1(VoteView.1 param1) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a.this$0.getContext(), QQBrowserActivity.class);
    String str = IndividuationUrlHelper.a(this.a.this$0.getContext(), "praise", "");
    VasWebviewUtil.b(this.a.this$0.getContext(), str, 536870912L, localIntent, false, -1);
    VasWebviewUtil.a(null, "thumbup", "others_click", null, 1, 0, 0, null, "1", null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VoteView.1.1
 * JD-Core Version:    0.7.0.1
 */