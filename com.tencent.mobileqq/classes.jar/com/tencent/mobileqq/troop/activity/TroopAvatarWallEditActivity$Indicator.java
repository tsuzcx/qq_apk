package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.troop.utils.BizTroopUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

final class TroopAvatarWallEditActivity$Indicator
{
  LinearLayout.LayoutParams a;
  private Context b;
  private LinearLayout c;
  private Drawable d;
  private Drawable e;
  
  TroopAvatarWallEditActivity$Indicator(@NonNull LinearLayout paramLinearLayout)
  {
    this.b = paramLinearLayout.getContext();
    this.c = paramLinearLayout;
    this.d = BizTroopUtil.a(this.b.getResources(), Color.parseColor("#66ffffff"), this.b.getResources().getDrawable(2130844829));
    this.e = BizTroopUtil.a(this.b.getResources(), Color.parseColor("#ffffffff"), this.b.getResources().getDrawable(2130844829));
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
    {
      this.d.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
      this.e.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
    }
    int i = ScreenUtil.dip2px(7.5F);
    this.a = new LinearLayout.LayoutParams(i, i);
    this.a.leftMargin = ScreenUtil.dip2px(7.0F);
  }
  
  void a(int paramInt)
  {
    int j = this.c.getChildCount();
    if (paramInt >= 0)
    {
      if (paramInt >= j) {
        return;
      }
      int i = 0;
      while (i < j)
      {
        View localView = this.c.getChildAt(i);
        Drawable localDrawable;
        if (paramInt == i) {
          localDrawable = this.e;
        } else {
          localDrawable = this.d;
        }
        localView.setBackgroundDrawable(localDrawable);
        i += 1;
      }
    }
  }
  
  void b(int paramInt)
  {
    if (this.c.getChildCount() != paramInt)
    {
      this.c.removeAllViews();
      while (paramInt > 0)
      {
        View localView = new View(this.b);
        localView.setLayoutParams(this.a);
        this.c.addView(localView);
        paramInt -= 1;
      }
    }
    a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity.Indicator
 * JD-Core Version:    0.7.0.1
 */