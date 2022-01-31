package com.tencent.mobileqq.widget;

import ajya;
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
import axqy;
import bcog;
import bcoh;
import bcql;
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
  private bcoh jdField_a_of_type_Bcoh;
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
    LayoutInflater.from(getContext()).inflate(2131559362, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371265));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371269));
    this.c = ((ImageView)findViewById(2131371267));
    this.d = ((ImageView)findViewById(2131371271));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(a(ajya.a(2131707896)));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(a(ajya.a(2131707900)));
    this.c.setContentDescription(a(ajya.a(2131707899)));
    this.d.setContentDescription(a(ajya.a(2131707897)));
    TextView localTextView = (TextView)findViewById(2131378281);
    findViewById(2131371266).setOnClickListener(this);
    findViewById(2131371270).setOnClickListener(this);
    findViewById(2131371268).setOnClickListener(this);
    findViewById(2131371272).setOnClickListener(this);
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
    return getContext().getString(2131690574, new Object[] { paramString });
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
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130844762);
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130844787);
        this.c.setBackgroundResource(2130844768);
        this.d.setBackgroundResource(2130844800);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon enable STATE_WHITE");
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130844759);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130844774);
      this.c.setBackgroundResource(2130844765);
      this.d.setBackgroundResource(2130844780);
      return;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon unable STATE_BLACK");
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130844760);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130844775);
      this.c.setBackgroundResource(2130844766);
      this.d.setBackgroundResource(2130844777);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon unable STATE_BLACK");
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130844761);
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130844776);
    this.c.setBackgroundResource(2130844767);
    this.d.setBackgroundResource(2130844781);
  }
  
  public void a(ParticipleView paramParticipleView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView = paramParticipleView;
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.setOnParticipleSelectChangeListener(new bcog(this));
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
    if (this.jdField_a_of_type_Bcoh != null)
    {
      if (paramView.getId() == 2131378281)
      {
        this.jdField_a_of_type_Bcoh.a();
        axqy.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35F", "0X800A35F", 0, 0, "", "", "", "");
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
        case 2131371267: 
        case 2131371269: 
        case 2131371271: 
        default: 
          return;
        case 2131371266: 
          this.jdField_a_of_type_Bcoh.a(str);
          axqy.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35A", "0X800A35A", 0, 0, "", "", "", "");
          return;
        case 2131371268: 
          this.jdField_a_of_type_Bcoh.c(str);
          axqy.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35B", "0X800A35B", 0, 0, "", "", "", "");
          return;
        case 2131371270: 
          this.jdField_a_of_type_Bcoh.b(str);
          axqy.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35C", "0X800A35C", 0, 0, "", "", "", "");
          return;
        }
        this.jdField_a_of_type_Bcoh.d(str);
        axqy.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35E", "0X800A35E", 0, 0, "", "", "", "");
        return;
      }
      bcql.a(BaseApplicationImpl.getContext(), -1, ajya.a(2131707895), 0).a();
      return;
    }
    bcql.a(getContext(), ajya.a(2131707898), 0).a();
  }
  
  public void setOnMenuClickListener(bcoh parambcoh)
  {
    this.jdField_a_of_type_Bcoh = parambcoh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ParticipleBottomMenuView
 * JD-Core Version:    0.7.0.1
 */