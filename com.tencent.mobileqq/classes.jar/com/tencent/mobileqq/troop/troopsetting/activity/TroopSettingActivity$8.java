package com.tencent.mobileqq.troop.troopsetting.activity;

import android.content.res.Resources;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.data.TroopInfoData;

class TroopSettingActivity$8
  implements View.OnTouchListener
{
  TroopSettingActivity$8(TroopSettingActivity paramTroopSettingActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i;
    if ((TroopInfo.hasPayPrivilege(this.a.i.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.a.i.mTroopPrivilegeFlag, 512))) {
      i = 1;
    } else {
      i = 0;
    }
    if (!this.a.i.isMember)
    {
      if (i == 0) {
        return false;
      }
      if (paramMotionEvent.getAction() == 0) {
        paramView.getBackground().setColorFilter(new LightingColorFilter(0, -950263));
      }
      if ((paramMotionEvent.getX() >= this.a.getResources().getDisplayMetrics().widthPixels - 2) || (paramMotionEvent.getX() <= 0.0F) || (paramMotionEvent.getY() <= 0.0F) || (paramMotionEvent.getY() > this.a.getResources().getDimensionPixelSize(2131297461) - 2) || (paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
        paramView.getBackground().setColorFilter(new LightingColorFilter(0, -158425));
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.8
 * JD-Core Version:    0.7.0.1
 */