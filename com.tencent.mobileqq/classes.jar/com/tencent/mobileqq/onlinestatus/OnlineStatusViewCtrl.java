package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQViewPager;
import java.util.ArrayList;
import mqq.app.AppRuntime.Status;

public class OnlineStatusViewCtrl
{
  EmoticonPagerRadioGroup a;
  private OnlineStatusPanel b;
  
  public OnlineStatusViewCtrl(@NonNull Context paramContext, @NonNull ViewGroup paramViewGroup, OnlineStatusPagerAdapter.OnStatusItemClickListener paramOnStatusItemClickListener, OnlineStatusPanelParams paramOnlineStatusPanelParams, OnlineStatusPanel.OnlineStatusPanelListener paramOnlineStatusPanelListener)
  {
    this.b = ((OnlineStatusPanel)View.inflate(paramContext, 2131624522, null));
    this.a = ((EmoticonPagerRadioGroup)this.b.findViewById(2131435243));
    e();
    this.b.setListener(paramOnlineStatusPanelListener);
    this.b.a(paramOnlineStatusPanelParams);
    this.b.b.a(paramOnStatusItemClickListener);
    paramViewGroup.addView(this.b);
  }
  
  public void a()
  {
    QQViewPager localQQViewPager = this.b.a;
    int i = this.b.b.getCount();
    boolean bool = true;
    if (i <= 1) {
      bool = false;
    }
    localQQViewPager.disableGesture(bool);
  }
  
  public void a(ArrayList<OnlineStatusItem> paramArrayList)
  {
    this.b.b.a.clear();
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      this.b.b.a.addAll(paramArrayList);
    }
    this.b.b.c();
  }
  
  public void a(AppRuntime.Status paramStatus, long paramLong)
  {
    a(paramStatus, paramLong, null);
  }
  
  public void a(AppRuntime.Status paramStatus, long paramLong, OnlineStatusViewCtrl.OnStatusItemCheckListener paramOnStatusItemCheckListener)
  {
    OnlineStatusItem localOnlineStatusItem = OnLineStatusHelper.a().a(paramStatus, paramLong);
    if ((!this.b.b.a.isEmpty()) && (OnlineStatusListLayout.a(localOnlineStatusItem, (OnlineStatusItem)this.b.b.a.get(0)))) {
      return;
    }
    if (localOnlineStatusItem != null)
    {
      this.b.b.a.clear();
      this.b.b.a.add(localOnlineStatusItem);
      this.b.b.c();
      if (paramOnStatusItemCheckListener != null)
      {
        paramStatus = new OnlineStatusItem(paramStatus);
        paramStatus.b = paramLong;
        paramOnStatusItemCheckListener.a(paramStatus, null);
      }
    }
  }
  
  public void a(boolean paramBoolean, AppRuntime.Status paramStatus, long paramLong)
  {
    paramStatus = OnLineStatusHelper.a().a(paramStatus, paramLong);
    if (paramStatus != null)
    {
      this.b.b.a.clear();
      this.b.b.a.add(paramStatus);
    }
    this.b.a(paramBoolean);
  }
  
  public void b()
  {
    this.b.getOnlineStatusItemAndAppear();
  }
  
  public OnlineStatusItem c()
  {
    if (this.b.b.a.size() <= 0) {
      return null;
    }
    return (OnlineStatusItem)this.b.b.a.get(0);
  }
  
  public ArrayList<OnlineStatusItem> d()
  {
    return this.b.b.a;
  }
  
  public void e()
  {
    if (QQTheme.isNowThemeIsNight())
    {
      this.a.setIndicatorDrawable(2130842375);
      return;
    }
    this.a.setIndicatorDrawable(2130842374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusViewCtrl
 * JD-Core Version:    0.7.0.1
 */