package com.tencent.mobileqq.troop.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.viewmodel.PictureShowViewModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopAvatarWallPreviewActivity$8
  implements View.OnClickListener
{
  TroopAvatarWallPreviewActivity$8(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131446133)
    {
      if (i != 2131446135)
      {
        if (i == 2131446138) {
          TroopAvatarWallPreviewActivity.access$100(this.a).g();
        }
      }
      else {
        TroopAvatarWallPreviewActivity.access$100(this.a).f();
      }
    }
    else {
      TroopAvatarWallPreviewActivity.access$100(this.a).e();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.8
 * JD-Core Version:    0.7.0.1
 */