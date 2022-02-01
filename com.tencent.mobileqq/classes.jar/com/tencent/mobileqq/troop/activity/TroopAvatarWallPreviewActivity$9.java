package com.tencent.mobileqq.troop.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopAvatarWallPreviewActivity$9
  implements View.OnClickListener
{
  TroopAvatarWallPreviewActivity$9(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131372188: 
      TroopAvatarWallPreviewActivity.access$1200(this.a);
      break;
    case 2131372170: 
      TroopAvatarWallPreviewActivity.access$900(this.a);
      break;
    case 2131372168: 
      TroopAvatarWallPreviewActivity.access$1100(this.a);
      break;
    case 2131372167: 
      TroopAvatarWallPreviewActivity.access$1000(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.9
 * JD-Core Version:    0.7.0.1
 */