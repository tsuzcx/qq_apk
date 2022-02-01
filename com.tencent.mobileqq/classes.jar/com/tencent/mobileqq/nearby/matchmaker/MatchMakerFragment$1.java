package com.tencent.mobileqq.nearby.matchmaker;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class MatchMakerFragment$1
  implements View.OnClickListener
{
  MatchMakerFragment$1(MatchMakerFragment paramMatchMakerFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.getBaseActivity(), QQBrowserActivity.class);
    paramView.putExtra("url", "https://qvideo.qq.com/qq/hongniang/personal-center.html?_wv=16778245&from=mp");
    paramView.addFlags(536870912);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.matchmaker.MatchMakerFragment.1
 * JD-Core Version:    0.7.0.1
 */