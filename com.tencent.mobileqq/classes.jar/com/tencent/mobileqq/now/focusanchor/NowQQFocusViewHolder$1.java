package com.tencent.mobileqq.now.focusanchor;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.now.NowQQLiveConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NowQQFocusViewHolder$1
  implements View.OnClickListener
{
  NowQQFocusViewHolder$1(NowQQFocusViewHolder paramNowQQFocusViewHolder) {}
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() < NowQQFocusViewHolder.a(this.a) + 1000L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      NowQQFocusViewHolder.a(this.a, System.currentTimeMillis());
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", NowQQLiveConstant.a());
      localIntent.putExtra("hide_more_button", true);
      localIntent.addFlags(536870912);
      paramView.getContext().startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.focusanchor.NowQQFocusViewHolder.1
 * JD-Core Version:    0.7.0.1
 */