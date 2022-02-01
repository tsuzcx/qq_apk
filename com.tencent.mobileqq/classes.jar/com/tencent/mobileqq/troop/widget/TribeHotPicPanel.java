package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.viewpager.widget.ViewPager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.hotpic.HotPicIndexAndIDMap;
import com.tencent.mobileqq.hotpic.HotPicMainPanel;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.hotpic.HotPicPageView.OnHotPicItemClickListener;
import com.tencent.mobileqq.hotpic.HotPicPanelViewPagerAdapter;
import com.tencent.mobileqq.hotpic.HotPicTab;
import com.tencent.mobileqq.hotpic.HotPicTagInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TribeHotPicPanel
  extends HotPicMainPanel
{
  protected HotPicPageView.OnHotPicItemClickListener a;
  protected boolean b;
  
  public TribeHotPicPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.b = false;
  }
  
  public void f()
  {
    this.d = XPanelContainer.jdField_a_of_type_Int;
    boolean bool;
    if (jdField_a_of_type_Int > this.d) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onShow ");
      ((StringBuilder)localObject1).append(AppSetting.g());
      ((StringBuilder)localObject1).append(" init panelH ");
      ((StringBuilder)localObject1).append(this.d);
      ((StringBuilder)localObject1).append(" needExtendPanel");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
      QLog.d("HotPicManager.Panel", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ((HotPicManager)localObject1).a(this);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setInterceptListener(this);
    }
    ((HotPicManager)localObject1).a();
    ((HotPicManager)localObject1).d();
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).addAll(((HotPicManager)localObject1).a());
    Object localObject4;
    if (a())
    {
      localObject3 = new ArrayList();
      localObject4 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        HotPicTagInfo localHotPicTagInfo = (HotPicTagInfo)((Iterator)localObject4).next();
        if (localHotPicTagInfo.tagType == 2) {
          ((ArrayList)localObject3).add(localHotPicTagInfo);
        }
      }
      if (((ArrayList)localObject3).size() > 0)
      {
        localObject3 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (HotPicTagInfo)((Iterator)localObject3).next();
          if (((ArrayList)localObject2).contains(localObject4)) {
            ((ArrayList)localObject2).remove(localObject4);
          }
        }
      }
    }
    Object localObject3 = ((ArrayList)localObject2).iterator();
    int j = -1;
    int i = 0;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (HotPicTagInfo)((Iterator)localObject3).next();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap.a((HotPicTagInfo)localObject4);
      if (((HotPicTagInfo)localObject4).tagId == ((HotPicManager)localObject1).jdField_a_of_type_Int) {
        j = i;
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter = new HotPicPanelViewPagerAdapter(this, this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$OnHotPicItemClickListener);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setOnPageChangeListener(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.a((List)localObject2, j);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.setOnItemClickListener(this);
    if (j != -1) {
      this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setCurrentItem(j);
    }
    if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      localObject2 = ((HotPicManager)localObject1).a().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (HotPicTagInfo)((Iterator)localObject2).next();
        i = ((HotPicTagInfo)localObject3).tagId;
        j = ((HotPicTagInfo)localObject3).tagType;
        if ((i != 2) && (j != 255) && (!((HotPicManager)localObject1).b(i))) {
          ((HotPicManager)localObject1).a(i);
        }
      }
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B11", "0X8007B11", 0, 0, "", "", "", "");
    a();
    h();
    setVisibility(0);
    this.b = true;
  }
  
  public boolean isShown()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TribeHotPicPanel
 * JD-Core Version:    0.7.0.1
 */