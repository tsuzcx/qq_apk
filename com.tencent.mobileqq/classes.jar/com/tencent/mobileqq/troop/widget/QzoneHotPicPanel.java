package com.tencent.mobileqq.troop.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpic.HotPicMainPanel;
import com.tencent.mobileqq.hotpic.HotPicPageView.OnHotPicItemClickListener;
import com.tencent.mobileqq.hotpic.HotPicPanelViewPagerAdapter;
import com.tencent.mobileqq.hotpic.HotPicTab;

public class QzoneHotPicPanel
  extends HotPicMainPanel
{
  protected HotPicPageView.OnHotPicItemClickListener a;
  
  public QzoneHotPicPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(14)
  public void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, HotPicPageView.OnHotPicItemClickListener paramOnHotPicItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$OnHotPicItemClickListener = paramOnHotPicItemClickListener;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a = 1008;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362727);
    this.c = findViewById(2131362992);
    this.b = LayoutInflater.from(paramBaseActivity).inflate(2130968640, null);
    this.b.setVisibility(8);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131362990));
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab = ((HotPicTab)findViewById(2131362991));
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.setOnItemClickListener(this);
  }
  
  public void c() {}
  
  public void d() {}
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$OnHotPicItemClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.QzoneHotPicPanel
 * JD-Core Version:    0.7.0.1
 */