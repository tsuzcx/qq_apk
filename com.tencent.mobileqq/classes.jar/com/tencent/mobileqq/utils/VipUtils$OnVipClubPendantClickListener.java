package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class VipUtils$OnVipClubPendantClickListener
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag(2131380933);
    if (((localObject instanceof Integer)) && ((paramView.getContext() instanceof Activity))) {
      VipUtils.a(paramView.getContext(), ((Integer)localObject).intValue());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.OnVipClubPendantClickListener
 * JD-Core Version:    0.7.0.1
 */