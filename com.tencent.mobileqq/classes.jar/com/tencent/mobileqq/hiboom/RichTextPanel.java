package com.tencent.mobileqq.hiboom;

import adxs;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;

public class RichTextPanel
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener, TabBarView.OnTabChangeListener
{
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "智能表情", "嗨爆字体" };
  private int jdField_a_of_type_Int;
  private PagerAdapter jdField_a_of_type_AndroidSupportV4ViewPagerAdapter = new adxs(this);
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  
  public RichTextPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public RichTextPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RichTextPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[2];
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = new ZhituPanelView(getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = new HiBoomPanelView(getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    setBackgroundResource(2131492969);
    a();
    Object localObject = new RelativeLayout(getContext());
    ((RelativeLayout)localObject).setId(2131362487);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, DisplayUtil.a(getContext(), 44.0F));
    localLayoutParams1.addRule(12, -1);
    ((RelativeLayout)localObject).setBackgroundResource(2131492969);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = new TabBarView(getContext());
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setId(2131362485);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, DisplayUtil.a(getContext(), 44.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setGravity(16);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setUnderLineMargin(ViewUtils.a(5.0F));
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(jdField_a_of_type_ArrayOfJavaLangString[i]);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setBackgroundResource(2130846128);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this);
    ((RelativeLayout)localObject).addView(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView, localLayoutParams2);
    addView((View)localObject, localLayoutParams1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = new QQViewPager(getContext());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setId(2131362486);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setBackgroundResource(2131492969);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setFocusable(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setFocusableInTouchMode(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.a(true);
    ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131362487);
    addView(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    i = paramBaseChatPie.a.getPreferences().getInt("rich_text_last_tab", 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(i, false);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(paramInt, false);
    }
  }
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt2;
    if (paramInt2 != this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt2, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getPreferences().edit().putInt("rich_text_last_tab", paramInt2).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.RichTextPanel
 * JD-Core Version:    0.7.0.1
 */