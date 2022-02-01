package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class NearbyProfileDisplayTribePanel$15
  implements View.OnClickListener
{
  NearbyProfileDisplayTribePanel$15(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.a, QQBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://buluo.qq.com/mobile/xxq_setting.html?_wv=1027&uin=");
    localStringBuilder.append(this.a.a.app.getCurrentUin());
    paramView.putExtra("url", localStringBuilder.toString());
    paramView.putExtra("reqType", 1);
    this.a.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.15
 * JD-Core Version:    0.7.0.1
 */