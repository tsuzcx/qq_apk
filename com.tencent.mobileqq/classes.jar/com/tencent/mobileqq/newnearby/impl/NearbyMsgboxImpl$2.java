package com.tencent.mobileqq.newnearby.impl;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.dating.MsgBoxListActivity;

class NearbyMsgboxImpl$2
  implements View.OnClickListener
{
  NearbyMsgboxImpl$2(NearbyMsgboxImpl paramNearbyMsgboxImpl, MsgBoxListActivity paramMsgBoxListActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, QQBrowserActivity.class);
    paramView.putExtra("url", "https://nearby.qq.com/nearby-index/mine.html?_bid=3027&_wv=16777218");
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.impl.NearbyMsgboxImpl.2
 * JD-Core Version:    0.7.0.1
 */