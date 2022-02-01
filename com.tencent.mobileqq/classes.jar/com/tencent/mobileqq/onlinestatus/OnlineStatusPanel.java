package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class OnlineStatusPanel
  extends RelativeLayout
{
  EmoticonPagerRadioGroup jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup;
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
    return (paramOnlineStatusPanelParams.h - AIOUtils.a(paramOnlineStatusPanelParams.g, getResources()) * 2 - AIOUtils.a(paramOnlineStatusPanelParams.f, getResources()) * (paramOnlineStatusPanelParams.c - 1)) / paramOnlineStatusPanelParams.c;
  }
  
  private int a(OnlineStatusPanelParams paramOnlineStatusPanelParams, int paramInt)
  {
    int i = AIOUtils.a(paramOnlineStatusPanelParams.d, getResources());
    int j = AIOUtils.a(paramOnlineStatusPanelParams.e, getResources());
    return i + (paramOnlineStatusPanelParams.b * paramInt + AIOUtils.a(paramOnlineStatusPanelParams.f, getResources()) * (paramOnlineStatusPanelParams.b - 1)) + j;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.getCount() > 1) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.synButton(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.getCount());
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(0);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("OnlineStatusPanel", 1, "e=" + localException);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(8);
  }
  
  void a()
  {
    ThreadManager.getFileThreadHandler().post(new OnlineStatusPanel.1(this));
  }
  
  public void a(OnlineStatusPanelParams paramOnlineStatusPanelParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131372526));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter = new OnlineStatusPagerAdapter(BaseApplicationImpl.getContext(), paramOnlineStatusPanelParams, this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)findViewById(2131368627));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams = paramOnlineStatusPanelParams;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.getLayoutParams();
    localLayoutParams.bottomMargin = AIOUtils.a(paramOnlineStatusPanelParams.i, getResources());
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
  
  public void setListener(OnlineStatusPanel.OnlineStatusPanelListener paramOnlineStatusPanelListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$OnlineStatusPanelListener = paramOnlineStatusPanelListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPanel
 * JD-Core Version:    0.7.0.1
 */