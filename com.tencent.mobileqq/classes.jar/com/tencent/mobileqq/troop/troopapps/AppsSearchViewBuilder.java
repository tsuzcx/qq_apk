package com.tencent.mobileqq.troop.troopapps;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class AppsSearchViewBuilder
  extends AppsBaseBuilder
  implements View.OnClickListener, View.OnTouchListener
{
  AppsSearchViewBuilder(Context paramContext, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super(paramContext, paramQQAppInterface, paramBaseActivity, null, paramBundle);
  }
  
  private void a(View paramView)
  {
    ReportController.b(null, "dc00898", "", String.valueOf(this.b), "0X800AFBF", "0X800AFBF", 0, 0, String.valueOf(this.c), "", "", "");
    if (!TroopAppShortcutUtils.a(this.g, this.b)) {
      return;
    }
    TroopAppShortcutUtils.a(this.b, this.g, this.f, this.h);
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new AppsSearchViewBuilder.ItemViewHolder();
      View localView = LayoutInflater.from(this.f).inflate(2131625901, paramViewGroup, false);
      paramView.a = ((TextView)localView.findViewById(2131437131));
      paramView.b = ((ImageView)localView.findViewById(2131445409));
      localView.setTag(paramView);
      paramViewGroup = paramView;
      paramView = localView;
    }
    else
    {
      paramViewGroup = (AppsSearchViewBuilder.ItemViewHolder)paramView.getTag();
    }
    if (this.j)
    {
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.b.setClickable(true);
      paramViewGroup.b.setOnClickListener(this);
    }
    else
    {
      paramViewGroup.b.setVisibility(8);
    }
    if (AppSetting.e) {
      paramViewGroup.b.setContentDescription(this.f.getString(2131917378));
    }
    if (this.i)
    {
      paramViewGroup.a.setTextColor(Color.parseColor("#ffffff"));
      paramView.setBackgroundColor(-16777216);
      paramViewGroup.b.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
    }
    else
    {
      paramViewGroup.b.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    }
    paramViewGroup.b.setOnTouchListener(this);
    return paramView;
  }
  
  public void a_(Object paramObject) {}
  
  public Object b()
  {
    return null;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131445409) {
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (((i == 1) || (i == 3)) && (Build.VERSION.SDK_INT >= 11)) {
        paramView.setAlpha(1.0F);
      }
    }
    else if (Build.VERSION.SDK_INT >= 11) {
      paramView.setAlpha(0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.AppsSearchViewBuilder
 * JD-Core Version:    0.7.0.1
 */