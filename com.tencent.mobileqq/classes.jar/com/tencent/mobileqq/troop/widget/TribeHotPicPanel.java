package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import aqyw;
import aqzc;
import aqzv;
import axqw;
import bbev;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpic.HotPicMainPanel;
import com.tencent.mobileqq.hotpic.HotPicPanelViewPagerAdapter;
import com.tencent.mobileqq.hotpic.HotPicTab;
import com.tencent.mobileqq.hotpic.HotPicTagInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TribeHotPicPanel
  extends HotPicMainPanel
{
  protected aqzv a;
  protected boolean b;
  
  public TribeHotPicPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, aqzv paramaqzv)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Aqzv = paramaqzv;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369487);
    this.c = findViewById(2131367643);
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramBaseActivity).inflate(2131558548, null);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131367649));
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab = ((HotPicTab)findViewById(2131367630));
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.setOnItemClickListener(this);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void f()
  {
    this.d = XPanelContainer.jdField_a_of_type_Int;
    if (jdField_a_of_type_Int > this.d) {}
    aqzc localaqzc;
    Object localObject1;
    Object localObject3;
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManager.Panel", 2, "onShow " + AppSetting.g() + " init panelH " + this.d + " needExtendPanel" + this.jdField_a_of_type_Boolean);
      }
      localaqzc = aqzc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localaqzc.a(this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setInterceptListener(this);
      }
      localaqzc.a();
      localaqzc.d();
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(localaqzc.a());
      if (!a()) {
        break label269;
      }
      localObject2 = new ArrayList();
      localObject3 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        HotPicTagInfo localHotPicTagInfo = (HotPicTagInfo)((Iterator)localObject3).next();
        if (localHotPicTagInfo.tagType == 2) {
          ((ArrayList)localObject2).add(localHotPicTagInfo);
        }
      }
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (HotPicTagInfo)((Iterator)localObject2).next();
        if (((ArrayList)localObject1).contains(localObject3)) {
          ((ArrayList)localObject1).remove(localObject3);
        }
      }
    }
    label269:
    Object localObject2 = ((ArrayList)localObject1).iterator();
    int i = 0;
    int j = -1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (HotPicTagInfo)((Iterator)localObject2).next();
      this.jdField_a_of_type_Aqyw.a((HotPicTagInfo)localObject3);
      if (((HotPicTagInfo)localObject3).tagId == localaqzc.jdField_a_of_type_Int) {
        j = i;
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter = new HotPicPanelViewPagerAdapter(this, this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter.a(this.jdField_a_of_type_Aqzv);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.a((List)localObject1, j);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.setOnItemClickListener(this);
    if (j != -1) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(j);
    }
    if (bbev.g(this.jdField_a_of_type_AndroidContentContext))
    {
      localObject1 = localaqzc.a().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (HotPicTagInfo)((Iterator)localObject1).next();
        i = ((HotPicTagInfo)localObject2).tagId;
        j = ((HotPicTagInfo)localObject2).tagType;
        if ((i != 2) && (j != 255) && (!localaqzc.b(i))) {
          localaqzc.a(i);
        }
      }
    }
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B11", "0X8007B11", 0, 0, "", "", "", "");
    a();
    h();
    setVisibility(0);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public boolean isShown()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TribeHotPicPanel
 * JD-Core Version:    0.7.0.1
 */