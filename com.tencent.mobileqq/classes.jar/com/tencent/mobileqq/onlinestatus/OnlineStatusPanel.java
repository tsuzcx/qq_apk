package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import axvo;
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
  private axvo jdField_a_of_type_Axvo;
  EmoticonPagerRadioGroup jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup;
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
    int j = getResources().getDisplayMetrics().widthPixels;
    int i = j;
    if (paramInt == 3) {
      i = j - AIOUtils.dp2px(26.0F, getResources());
    }
    return (i - AIOUtils.dp2px(14.0F, getResources()) * 2 - a(paramInt, getResources()) * 3) / 4;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = AIOUtils.dp2px(9.0F, getResources());
    int j = AIOUtils.dp2px(39.0F, getResources());
    return i + (paramInt2 * paramInt1 + a(paramInt3, getResources()) * (paramInt1 - 1)) + j;
  }
  
  public static int a(int paramInt, Resources paramResources)
  {
    if (paramInt == 3) {}
    for (paramInt = 5;; paramInt = 9) {
      return AIOUtils.dp2px(paramInt, paramResources);
    }
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
  
  public void a()
  {
    ThreadManager.getFileThreadHandler().post(new OnlineStatusPanel.1(this));
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131372032));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter = new OnlineStatusPagerAdapter(BaseApplicationImpl.getContext(), paramInt1, paramInt2, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)findViewById(2131368259));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.getLayoutParams();
    if (paramInt2 == 1) {
      localLayoutParams.bottomMargin = 0;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getLayoutParams();
    int i = a(paramInt2);
    localLayoutParams.height = a(paramInt1, i, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a(i);
    a();
  }
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.getFileThreadHandler().post(new OnlineStatusPanel.2(this, paramBoolean));
  }
  
  public void setListener(axvo paramaxvo)
  {
    this.jdField_a_of_type_Axvo = paramaxvo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPanel
 * JD-Core Version:    0.7.0.1
 */