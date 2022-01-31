package com.tencent.mobileqq.onlinestatus;

import aepi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class OnlineStatusPanel
  extends LinearLayout
{
  EmoticonPagerRadioGroup a;
  public OnlineStatusPagerAdapter a;
  public QQViewPager a;
  
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
  
  private int a(int paramInt)
  {
    return aepi.a(32.0F, getResources()) * paramInt + aepi.a(20.0F, getResources()) * (paramInt - 1) + aepi.a(16.0F, getResources());
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.getCount() > 1) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.getCount());
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
  
  public void a()
  {
    ThreadManager.getFileThreadHandler().post(new OnlineStatusPanel.1(this));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter = new OnlineStatusPagerAdapter(BaseApplicationImpl.getContext(), paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131371382));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)findViewById(2131367840));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getLayoutParams();
    localLayoutParams.height = a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setLayoutParams(localLayoutParams);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPanel
 * JD-Core Version:    0.7.0.1
 */