package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class OnlineStatusPanel
  extends RelativeLayout
{
  EmoticonPagerRadioGroup jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup;
  private OnlineStatusItem jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem;
  OnlineStatusPagerAdapter jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter;
  private OnlineStatusPanel.OnlineStatusPanelListener jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$OnlineStatusPanelListener;
  private OnlineStatusPanelParams jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams;
  QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  
  public OnlineStatusPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public OnlineStatusPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public OnlineStatusPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a(OnlineStatusPanelParams paramOnlineStatusPanelParams)
  {
    return (paramOnlineStatusPanelParams.h - ViewUtils.a(paramOnlineStatusPanelParams.g) * 2 - ViewUtils.b(paramOnlineStatusPanelParams.f) * (paramOnlineStatusPanelParams.c - 1)) / paramOnlineStatusPanelParams.c;
  }
  
  private int a(OnlineStatusPanelParams paramOnlineStatusPanelParams, int paramInt)
  {
    int i = ViewUtils.b(paramOnlineStatusPanelParams.d);
    int j = ViewUtils.b(paramOnlineStatusPanelParams.e);
    return paramInt * paramOnlineStatusPanelParams.b + ViewUtils.b(paramOnlineStatusPanelParams.f) * (paramOnlineStatusPanelParams.b - 1) + i + j;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.getCount() > 1)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.synButton(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.getCount());
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("e=");
        localStringBuilder.append(localException);
        QLog.e("OnlineStatusPanel", 1, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(8);
  }
  
  void a()
  {
    ThreadManager.getFileThreadHandler().post(new OnlineStatusPanel.1(this));
  }
  
  public void a(OnlineStatusPanelParams paramOnlineStatusPanelParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131372111));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter = new OnlineStatusPagerAdapter(MobileQQ.getContext(), paramOnlineStatusPanelParams, this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.addOnPageChangeListener(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)findViewById(2131368364));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams = paramOnlineStatusPanelParams;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.getLayoutParams();
    localLayoutParams.bottomMargin = ViewUtils.b(paramOnlineStatusPanelParams.i);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getLayoutParams();
    int i = a(paramOnlineStatusPanelParams);
    localLayoutParams.height = a(paramOnlineStatusPanelParams, i);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a(i);
    a();
  }
  
  void a(boolean paramBoolean)
  {
    ThreadManager.getFileThreadHandler().post(new OnlineStatusPanel.2(this, paramBoolean));
  }
  
  public void setCurrentItem()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a();
    if (i == this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem()) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.onPageSelected(i);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(i, false);
  }
  
  public void setFriendItem(OnlineStatusItem paramOnlineStatusItem)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem = paramOnlineStatusItem;
  }
  
  public void setListener(OnlineStatusPanel.OnlineStatusPanelListener paramOnlineStatusPanelListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$OnlineStatusPanelListener = paramOnlineStatusPanelListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPanel
 * JD-Core Version:    0.7.0.1
 */