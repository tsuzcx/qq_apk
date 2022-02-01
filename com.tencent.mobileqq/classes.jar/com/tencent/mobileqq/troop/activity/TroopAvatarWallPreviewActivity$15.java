package com.tencent.mobileqq.troop.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopAvatarWallPreviewActivity$15
  implements View.OnClickListener
{
  TroopAvatarWallPreviewActivity$15(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131439675: 
      TroopAvatarWallPreviewActivity.access$1400(this.a);
      break;
    case 2131439643: 
      TroopAvatarWallPreviewActivity.access$1100(this.a);
      break;
    case 2131439641: 
      TroopAvatarWallPreviewActivity.access$1300(this.a);
      break;
    case 2131439640: 
      TroopAvatarWallPreviewActivity.access$1200(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.15
 * JD-Core Version:    0.7.0.1
 */