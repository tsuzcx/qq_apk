package com.tencent.mobileqq.widget;

import ajjy;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import awqx;
import bbkt;
import bbku;
import bbmy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class ParticipleBottomMenuView
  extends LinearLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bbku jdField_a_of_type_Bbku;
  private ParticipleView jdField_a_of_type_ComTencentMobileqqWidgetParticipleView;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ImageView c;
  private ImageView d;
  
  public ParticipleBottomMenuView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public ParticipleBottomMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public ParticipleBottomMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(getContext()).inflate(2131493791, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131305569));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131305573));
    this.c = ((ImageView)findViewById(2131305571));
    this.d = ((ImageView)findViewById(2131305575));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(a(ajjy.a(2131642100)));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(a(ajjy.a(2131642104)));
    this.c.setContentDescription(a(ajjy.a(2131642103)));
    this.d.setContentDescription(a(ajjy.a(2131642101)));
    TextView localTextView = (TextView)findViewById(2131312451);
    findViewById(2131305570).setOnClickListener(this);
    findViewById(2131305574).setOnClickListener(this);
    findViewById(2131305572).setOnClickListener(this);
    findViewById(2131305576).setOnClickListener(this);
    localTextView.setOnClickListener(this);
    if ((paramAttributeSet != null) && (paramContext != null))
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ParticipleBottomMenuView);
      this.jdField_a_of_type_Int = paramContext.getInteger(1, 0);
      this.jdField_b_of_type_Int = paramContext.getInteger(0, 200);
      paramContext.recycle();
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      paramContext = "#000000";
      setBackgroundColor(Color.parseColor(paramContext));
      if (this.jdField_a_of_type_Int != 1) {
        break label278;
      }
    }
    label278:
    for (paramContext = "#ffffff";; paramContext = "#000000")
    {
      localTextView.setTextColor(Color.parseColor(paramContext));
      a();
      return;
      paramContext = "#e6ffffff";
      break;
    }
  }
  
  public String a(String paramString)
  {
    return getContext().getString(2131625013, new Object[] { paramString });
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.a())))
    {
      if (this.jdField_a_of_type_Int == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon enable STATE_BLACK");
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130844680);
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130844705);
        this.c.setBackgroundResource(2130844686);
        this.d.setBackgroundResource(2130844718);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon enable STATE_WHITE");
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130844677);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130844692);
      this.c.setBackgroundResource(2130844683);
      this.d.setBackgroundResource(2130844698);
      return;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon unable STATE_BLACK");
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130844678);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130844693);
      this.c.setBackgroundResource(2130844684);
      this.d.setBackgroundResource(2130844695);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon unable STATE_BLACK");
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130844679);
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130844694);
    this.c.setBackgroundResource(2130844685);
    this.d.setBackgroundResource(2130844699);
  }
  
  public void a(ParticipleView paramParticipleView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView = paramParticipleView;
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.setOnParticipleSelectChangeListener(new bbkt(this));
  }
  
  public void b()
  {
    a();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(this.jdField_b_of_type_Int);
    setAlpha(0.0F);
    setVisibility(0);
    localObjectAnimator.start();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bbku != null)
    {
      if (paramView.getId() == 2131312451)
      {
        this.jdField_a_of_type_Bbku.a();
        awqx.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35F", "0X800A35F", 0, 0, "", "", "", "");
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView != null)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.a();
      if (!TextUtils.isEmpty(str))
      {
        switch (paramView.getId())
        {
        case 2131305571: 
        case 2131305573: 
        case 2131305575: 
        default: 
          return;
        case 2131305570: 
          this.jdField_a_of_type_Bbku.a(str);
          awqx.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35A", "0X800A35A", 0, 0, "", "", "", "");
          return;
        case 2131305572: 
          this.jdField_a_of_type_Bbku.c(str);
          awqx.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35B", "0X800A35B", 0, 0, "", "", "", "");
          return;
        case 2131305574: 
          this.jdField_a_of_type_Bbku.b(str);
          awqx.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35C", "0X800A35C", 0, 0, "", "", "", "");
          return;
        }
        this.jdField_a_of_type_Bbku.d(str);
        awqx.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35E", "0X800A35E", 0, 0, "", "", "", "");
        return;
      }
      bbmy.a(BaseApplicationImpl.getContext(), -1, ajjy.a(2131642099), 0).a();
      return;
    }
    bbmy.a(getContext(), ajjy.a(2131642102), 0).a();
  }
  
  public void setOnMenuClickListener(bbku parambbku)
  {
    this.jdField_a_of_type_Bbku = parambbku;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ParticipleBottomMenuView
 * JD-Core Version:    0.7.0.1
 */