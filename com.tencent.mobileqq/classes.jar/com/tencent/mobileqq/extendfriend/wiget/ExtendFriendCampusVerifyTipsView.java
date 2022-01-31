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
import aqbg;
import aqgz;
import aqib;
import awrl;
import com.tencent.mobileqq.app.QQAppInterface;
import mww;

public class ExtendFriendCampusVerifyTipsView
  extends FrameLayout
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aqib jdField_a_of_type_Aqib;
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
    inflate(paramContext, 2131560937, this);
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377915));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377921));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377920));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131377907));
    this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(mww.a);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377914));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(mww.a);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    awrl localawrl;
    if ((paramActivity != null) && (paramQQAppInterface != null))
    {
      paramQQAppInterface = (aqbg)paramQQAppInterface.getManager(264);
      localawrl = paramQQAppInterface.a();
      if ((localawrl == null) || (TextUtils.isEmpty(localawrl.b))) {
        aqgz.b(paramActivity, paramQQAppInterface.f());
      }
    }
    else
    {
      return;
    }
    aqgz.a(paramActivity, localawrl.jdField_a_of_type_Int, localawrl.b, localawrl.jdField_a_of_type_JavaLangString);
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699370);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131699369);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131699368);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130844785);
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
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844788);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699371);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$TipsType != ExtendFriendCampusVerifyTipsView.TipsType.VERIFY_FAIL);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844787);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699367);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131699366);
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130844786);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Aqib != null) {
      this.jdField_a_of_type_Aqib.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$TipsType);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Aqib != null) {
      this.jdField_a_of_type_Aqib.b(this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$TipsType);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131377907: 
      c();
      return;
    }
    d();
  }
  
  public void setOnClickListener(aqib paramaqib)
  {
    this.jdField_a_of_type_Aqib = paramaqib;
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