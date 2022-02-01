package com.tencent.mobileqq.qqexpand.widget;

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
import com.tencent.mobileqq.profile.SchoolInfo;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;

public class ExtendFriendCampusVerifyTipsView
  extends FrameLayout
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ExtendFriendCampusVerifyTipsView.OnClickListener jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendCampusVerifyTipsView$OnClickListener;
  private ExtendFriendCampusVerifyTipsView.TipsType jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendCampusVerifyTipsView$TipsType = ExtendFriendCampusVerifyTipsView.TipsType.VERIFY_NONE;
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
    inflate(paramContext, 2131561070, this);
    a();
    b();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378760));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378767));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378765));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131378752));
    this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(UITools.a);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378758));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(UITools.a);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    if ((paramActivity != null) && (paramQQAppInterface != null))
    {
      paramQQAppInterface = (IExpandManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      Object localObject = paramQQAppInterface.a();
      if ((localObject instanceof SchoolInfo))
      {
        localObject = (SchoolInfo)localObject;
        if (TextUtils.isEmpty(((SchoolInfo)localObject).b))
        {
          CampusHelper.a(paramActivity, paramQQAppInterface.i());
          return;
        }
        CampusHelper.a(paramActivity, ((SchoolInfo)localObject).jdField_a_of_type_Int, ((SchoolInfo)localObject).b, ((SchoolInfo)localObject).jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendCampusVerifyTipsView$TipsType == ExtendFriendCampusVerifyTipsView.TipsType.VERIFY_NONE)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698912);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698911);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131698910);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130845194);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendCampusVerifyTipsView$TipsType == ExtendFriendCampusVerifyTipsView.TipsType.VERIFY_SUCCESS)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845197);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698913);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendCampusVerifyTipsView$TipsType == ExtendFriendCampusVerifyTipsView.TipsType.VERIFY_FAIL)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845196);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698909);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131698908);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130845195);
    }
  }
  
  private void c()
  {
    ExtendFriendCampusVerifyTipsView.OnClickListener localOnClickListener = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendCampusVerifyTipsView$OnClickListener;
    if (localOnClickListener != null) {
      localOnClickListener.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendCampusVerifyTipsView$TipsType);
    }
  }
  
  private void d()
  {
    ExtendFriendCampusVerifyTipsView.OnClickListener localOnClickListener = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendCampusVerifyTipsView$OnClickListener;
    if (localOnClickListener != null) {
      localOnClickListener.b(this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendCampusVerifyTipsView$TipsType);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131378752)
    {
      if (i != 2131378758) {
        return;
      }
      d();
      return;
    }
    c();
  }
  
  public void setOnClickListener(ExtendFriendCampusVerifyTipsView.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendCampusVerifyTipsView$OnClickListener = paramOnClickListener;
  }
  
  public void setTipsType(ExtendFriendCampusVerifyTipsView.TipsType paramTipsType)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendCampusVerifyTipsView$TipsType = paramTipsType;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.ExtendFriendCampusVerifyTipsView
 * JD-Core Version:    0.7.0.1
 */