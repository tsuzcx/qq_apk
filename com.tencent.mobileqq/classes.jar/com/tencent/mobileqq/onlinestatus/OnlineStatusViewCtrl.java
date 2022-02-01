package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.widget.ThemeImageWrapper;
import java.util.ArrayList;
import mqq.app.AppRuntime.Status;

public class OnlineStatusViewCtrl
{
  EmoticonPagerRadioGroup jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup;
  private OnlineStatusPanel jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel;
  
  public OnlineStatusViewCtrl(@NonNull Context paramContext, @NonNull ViewGroup paramViewGroup, OnlineStatusPagerAdapter.OnStatusItemClickListener paramOnStatusItemClickListener, OnlineStatusPanelParams paramOnlineStatusPanelParams, OnlineStatusPanel.OnlineStatusPanelListener paramOnlineStatusPanelListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel = ((OnlineStatusPanel)View.inflate(paramContext, 2131559006, null));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.findViewById(2131368627));
    c();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.setListener(paramOnlineStatusPanelListener);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.a(paramOnlineStatusPanelParams);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a(paramOnStatusItemClickListener);
    paramViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel);
  }
  
  public OnlineStatusItem a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.size() <= 0) {
      return null;
    }
    return (OnlineStatusItem)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.get(0);
  }
  
  public ArrayList<OnlineStatusItem> a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a;
  }
  
  public void a()
  {
    boolean bool = true;
    QQViewPager localQQViewPager = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.getCount() > 1) {}
    for (;;)
    {
      localQQViewPager.disableGesture(bool);
      return;
      bool = false;
    }
  }
  
  public void a(ArrayList<OnlineStatusItem> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.clear();
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.addAll(paramArrayList);
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a();
  }
  
  public void a(AppRuntime.Status paramStatus, long paramLong)
  {
    a(paramStatus, paramLong, null);
  }
  
  public void a(AppRuntime.Status paramStatus, long paramLong, OnlineStatusViewCtrl.OnStatusItemCheckListener paramOnStatusItemCheckListener)
  {
    OnlineStatusItem localOnlineStatusItem = OnLineStatusHelper.a().a(paramStatus, paramLong);
    if ((!this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.isEmpty()) && (OnlineStatusListLayout.a(localOnlineStatusItem, (OnlineStatusItem)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.get(0)))) {}
    do
    {
      do
      {
        return;
      } while (localOnlineStatusItem == null);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.clear();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.add(localOnlineStatusItem);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a();
    } while (paramOnStatusItemCheckListener == null);
    paramStatus = new OnlineStatusItem(paramStatus);
    paramStatus.a = paramLong;
    paramOnStatusItemCheckListener.a(paramStatus, null);
  }
  
  public void a(boolean paramBoolean, AppRuntime.Status paramStatus, long paramLong)
  {
    paramStatus = OnLineStatusHelper.a().a(paramStatus, paramLong);
    if (paramStatus != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.clear();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.add(paramStatus);
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.a(paramBoolean);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.a();
  }
  
  public void c()
  {
    if (ThemeImageWrapper.isNightMode())
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setIndicatorDrawable(2130841647);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setIndicatorDrawable(2130841646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusViewCtrl
 * JD-Core Version:    0.7.0.1
 */