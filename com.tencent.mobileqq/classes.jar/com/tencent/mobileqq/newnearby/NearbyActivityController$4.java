package com.tencent.mobileqq.newnearby;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;

class NearbyActivityController$4
  implements View.OnClickListener
{
  NearbyActivityController$4(NearbyActivityController paramNearbyActivityController) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(NearbyActivityController.a(this.a), QQBrowserActivity.class);
    paramView.putExtra("url", "https://nearby.qq.com/nearby-index/mine.html?_bid=3027&_wv=16777218");
    NearbyActivityController.a(this.a).startActivity(paramView);
    NearbyActivityController.a(this.a).app.getNearbyProcManager().b(42);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.NearbyActivityController.4
 * JD-Core Version:    0.7.0.1
 */