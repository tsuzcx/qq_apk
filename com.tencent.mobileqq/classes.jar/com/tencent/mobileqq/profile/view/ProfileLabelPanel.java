package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.profile.ProfileLabelTypeInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.CirclePageIndicator;
import java.util.List;

public class ProfileLabelPanel
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener
{
  protected View a;
  protected TextView a;
  protected ViewPager a;
  protected ProfileLabelPanel.LabelStatusManager a;
  protected ProfileLabelPanelAdapter a;
  protected CirclePageIndicator a;
  protected List<ProfileLabelTypeInfo> a;
  protected TextView b;
  
  public ProfileLabelPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public ProfileLabelPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProfileLabelPanel(Context paramContext, ProfileLabelPanel.LabelStatusManager paramLabelStatusManager, List<ProfileLabelTypeInfo> paramList, ProfileLabelCallBack paramProfileLabelCallBack)
  {
    this(paramContext);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131562022, this);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$LabelStatusManager = paramLabelStatusManager;
    a(paramContext, paramProfileLabelCallBack);
  }
  
  protected void a(Context paramContext, ProfileLabelCallBack paramProfileLabelCallBack)
  {
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378261));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378264));
    this.b.setText(((ProfileLabelTypeInfo)this.jdField_a_of_type_JavaUtilList.get(0)).typeInfo);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((ProfileLabelTypeInfo)this.jdField_a_of_type_JavaUtilList.get(0)).typeName);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator = ((CirclePageIndicator)this.jdField_a_of_type_AndroidViewView.findViewById(2131372275));
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager = ((ViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131380822));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter = new ProfileLabelPanelAdapter(paramContext, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter.a(paramProfileLabelCallBack);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$LabelStatusManager);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setCurrentItem(0);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setViewPager(this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setOnPageChangeListener(this);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    ReportController.b(null, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "3", "", "", "");
    ProfileLabelTypeInfo localProfileLabelTypeInfo = (ProfileLabelTypeInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    this.b.setText(localProfileLabelTypeInfo.typeInfo);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localProfileLabelTypeInfo.typeName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileLabelPanel
 * JD-Core Version:    0.7.0.1
 */