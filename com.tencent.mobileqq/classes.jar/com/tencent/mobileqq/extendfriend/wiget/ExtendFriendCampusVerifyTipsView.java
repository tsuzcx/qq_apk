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
import aslo;
import assp;
import asud;
import azrs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mvk;

public class ExtendFriendCampusVerifyTipsView
  extends FrameLayout
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private asud jdField_a_of_type_Asud;
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
    inflate(paramContext, 2131561114, this);
    a();
    b();
  }
  
  public static ExtendFriendCampusVerifyTipsView.TipsType a(int paramInt)
  {
    ExtendFriendCampusVerifyTipsView.TipsType localTipsType = ExtendFriendCampusVerifyTipsView.TipsType.VERIFY_NONE;
    switch (paramInt)
    {
    case 1: 
    default: 
      return localTipsType;
    case 0: 
      return ExtendFriendCampusVerifyTipsView.TipsType.VERIFY_NONE;
    case 2: 
      return ExtendFriendCampusVerifyTipsView.TipsType.VERIFY_SUCCESS;
    }
    return ExtendFriendCampusVerifyTipsView.TipsType.VERIFY_FAIL;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378978));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378984));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378983));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131378970));
    this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(mvk.a);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378976));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(mvk.a);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    azrs localazrs;
    if ((paramActivity != null) && (paramQQAppInterface != null))
    {
      paramQQAppInterface = (aslo)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      localazrs = paramQQAppInterface.a();
      if ((localazrs == null) || (TextUtils.isEmpty(localazrs.b))) {
        assp.a(paramActivity, paramQQAppInterface.f());
      }
    }
    else
    {
      return;
    }
    assp.a(paramActivity, localazrs.jdField_a_of_type_Int, localazrs.b, localazrs.jdField_a_of_type_JavaLangString);
  }
  
  public static boolean a(boolean paramBoolean, int paramInt)
  {
    return (paramBoolean) && ((paramInt == 0) || (paramInt == 2) || (paramInt == 3));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$TipsType == ExtendFriendCampusVerifyTipsView.TipsType.VERIFY_NONE)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698544);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698543);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131698542);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130845159);
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
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845162);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698545);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$TipsType != ExtendFriendCampusVerifyTipsView.TipsType.VERIFY_FAIL);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845161);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698541);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131698540);
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130845160);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Asud != null) {
      this.jdField_a_of_type_Asud.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$TipsType);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Asud != null) {
      this.jdField_a_of_type_Asud.b(this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$TipsType);
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
  
  public void setOnClickListener(asud paramasud)
  {
    this.jdField_a_of_type_Asud = paramasud;
  }
  
  public void setTipsType(ExtendFriendCampusVerifyTipsView.TipsType paramTipsType)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$TipsType = paramTipsType;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView
 * JD-Core Version:    0.7.0.1
 */