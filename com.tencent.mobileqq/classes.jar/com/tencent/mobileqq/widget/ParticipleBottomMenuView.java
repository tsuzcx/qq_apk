package com.tencent.mobileqq.widget;

import alpo;
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
import azmj;
import beni;
import benj;
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
  private benj jdField_a_of_type_Benj;
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
    LayoutInflater.from(getContext()).inflate(2131559414, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371577));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371581));
    this.c = ((ImageView)findViewById(2131371579));
    this.d = ((ImageView)findViewById(2131371583));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(a(alpo.a(2131708268)));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(a(alpo.a(2131708272)));
    this.c.setContentDescription(a(alpo.a(2131708271)));
    this.d.setContentDescription(a(alpo.a(2131708269)));
    TextView localTextView = (TextView)findViewById(2131378860);
    findViewById(2131371578).setOnClickListener(this);
    findViewById(2131371582).setOnClickListener(this);
    findViewById(2131371580).setOnClickListener(this);
    findViewById(2131371584).setOnClickListener(this);
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
    return getContext().getString(2131690625, new Object[] { paramString });
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
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130845126);
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845151);
        this.c.setBackgroundResource(2130845132);
        this.d.setBackgroundResource(2130845164);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon enable STATE_WHITE");
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130845123);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845138);
      this.c.setBackgroundResource(2130845129);
      this.d.setBackgroundResource(2130845144);
      return;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon unable STATE_BLACK");
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130845124);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845139);
      this.c.setBackgroundResource(2130845130);
      this.d.setBackgroundResource(2130845141);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon unable STATE_BLACK");
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130845125);
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845140);
    this.c.setBackgroundResource(2130845131);
    this.d.setBackgroundResource(2130845145);
  }
  
  public void a(ParticipleView paramParticipleView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView = paramParticipleView;
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.setOnParticipleSelectChangeListener(new beni(this));
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
    if (this.jdField_a_of_type_Benj != null)
    {
      if (paramView.getId() == 2131378860)
      {
        this.jdField_a_of_type_Benj.a();
        azmj.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35F", "0X800A35F", 0, 0, "", "", "", "");
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
        case 2131371579: 
        case 2131371581: 
        case 2131371583: 
        default: 
          return;
        case 2131371578: 
          this.jdField_a_of_type_Benj.a(str);
          azmj.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35A", "0X800A35A", 0, 0, "", "", "", "");
          return;
        case 2131371580: 
          this.jdField_a_of_type_Benj.c(str);
          azmj.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35B", "0X800A35B", 0, 0, "", "", "", "");
          return;
        case 2131371582: 
          this.jdField_a_of_type_Benj.b(str);
          azmj.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35C", "0X800A35C", 0, 0, "", "", "", "");
          return;
        }
        this.jdField_a_of_type_Benj.d(str);
        azmj.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35E", "0X800A35E", 0, 0, "", "", "", "");
        return;
      }
      QQToast.a(BaseApplicationImpl.getContext(), -1, alpo.a(2131708267), 0).a();
      return;
    }
    QQToast.a(getContext(), alpo.a(2131708270), 0).a();
  }
  
  public void setOnMenuClickListener(benj parambenj)
  {
    this.jdField_a_of_type_Benj = parambenj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ParticipleBottomMenuView
 * JD-Core Version:    0.7.0.1
 */