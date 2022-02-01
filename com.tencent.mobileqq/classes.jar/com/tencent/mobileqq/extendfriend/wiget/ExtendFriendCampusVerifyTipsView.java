package com.tencent.mobileqq.extendfriend.wiget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.utils.CampusHelper;
import com.tencent.mobileqq.profile.SchoolInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ExtendFriendCampusVerifyTipsView
  extends FrameLayout
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ExtendFriendCampusVerifyTipsView.OnClickListener jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$OnClickListener;
  private ExtendFriendCampusVerifyTipsView.TipsType jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$TipsType = ExtendFriendCampusVerifyTipsView.TipsType.VERIFY_NONE;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public ExtendFriendCampusVerifyTipsView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExtendFriendCampusVerifyTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExtendFriendCampusVerifyTipsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflate(paramContext, 2131561203, this);
    a();
    b();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379409));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379415));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379414));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131379401));
    this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(UITools.a);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379407));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(UITools.a);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    SchoolInfo localSchoolInfo;
    if ((paramActivity != null) && (paramQQAppInterface != null))
    {
      paramQQAppInterface = (ExtendFriendManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      localSchoolInfo = paramQQAppInterface.a();
      if ((localSchoolInfo == null) || (TextUtils.isEmpty(localSchoolInfo.b))) {
        CampusHelper.a(paramActivity, paramQQAppInterface.h());
      }
    }
    else
    {
      return;
    }
    CampusHelper.a(paramActivity, localSchoolInfo.jdField_a_of_type_Int, localSchoolInfo.b, localSchoolInfo.jdField_a_of_type_JavaLangString);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$TipsType == ExtendFriendCampusVerifyTipsView.TipsType.VERIFY_NONE)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698836);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698835);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131698834);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130845321);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$TipsType == ExtendFriendCampusVerifyTipsView.TipsType.VERIFY_SUCCESS)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845324);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698837);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$TipsType != ExtendFriendCampusVerifyTipsView.TipsType.VERIFY_FAIL);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845323);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698833);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131698832);
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130845322);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$OnClickListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$OnClickListener.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$TipsType);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$OnClickListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$OnClickListener.b(this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$TipsType);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      c();
      continue;
      d();
    }
  }
  
  public void setOnClickListener(ExtendFriendCampusVerifyTipsView.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$OnClickListener = paramOnClickListener;
  }
  
  public void setTipsType(ExtendFriendCampusVerifyTipsView.TipsType paramTipsType)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$TipsType = paramTipsType;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView
 * JD-Core Version:    0.7.0.1
 */