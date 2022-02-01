package com.tencent.mobileqq.widget;

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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ParticipleBottomMenuView
  extends LinearLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ParticipleBottomMenuView.OnMenuClickListener jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView$OnMenuClickListener;
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
    LayoutInflater.from(getContext()).inflate(2131559659, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372751));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372755));
    this.c = ((ImageView)findViewById(2131372753));
    this.d = ((ImageView)findViewById(2131372757));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(a(HardCodeUtil.a(2131707872)));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(a(HardCodeUtil.a(2131707876)));
    this.c.setContentDescription(a(HardCodeUtil.a(2131707875)));
    this.d.setContentDescription(a(HardCodeUtil.a(2131707873)));
    TextView localTextView = (TextView)findViewById(2131380504);
    findViewById(2131372752).setOnClickListener(this);
    findViewById(2131372756).setOnClickListener(this);
    findViewById(2131372754).setOnClickListener(this);
    findViewById(2131372758).setOnClickListener(this);
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
    return getContext().getString(2131690780, new Object[] { paramString });
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
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130845890);
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845915);
        this.c.setBackgroundResource(2130845896);
        this.d.setBackgroundResource(2130845928);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon enable STATE_WHITE");
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130845887);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845902);
      this.c.setBackgroundResource(2130845893);
      this.d.setBackgroundResource(2130845908);
      return;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon unable STATE_BLACK");
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130845888);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845903);
      this.c.setBackgroundResource(2130845894);
      this.d.setBackgroundResource(2130845905);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon unable STATE_BLACK");
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130845889);
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845904);
    this.c.setBackgroundResource(2130845895);
    this.d.setBackgroundResource(2130845909);
  }
  
  public void a(ParticipleView paramParticipleView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView = paramParticipleView;
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.setOnParticipleSelectChangeListener(new ParticipleBottomMenuView.1(this));
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
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView$OnMenuClickListener != null)
    {
      if (paramView.getId() != 2131380504) {
        break label66;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView$OnMenuClickListener.a();
      ReportController.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35F", "0X800A35F", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label66:
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView != null)
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.a();
        if (!TextUtils.isEmpty(str)) {
          switch (paramView.getId())
          {
          case 2131372753: 
          case 2131372755: 
          case 2131372757: 
          default: 
            break;
          case 2131372752: 
            this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView$OnMenuClickListener.a(str);
            ReportController.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35A", "0X800A35A", 0, 0, "", "", "", "");
            break;
          case 2131372754: 
            this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView$OnMenuClickListener.c(str);
            ReportController.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35B", "0X800A35B", 0, 0, "", "", "", "");
            break;
          case 2131372756: 
            this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView$OnMenuClickListener.b(str);
            ReportController.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35C", "0X800A35C", 0, 0, "", "", "", "");
            break;
          case 2131372758: 
            this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView$OnMenuClickListener.d(str);
            ReportController.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35E", "0X800A35E", 0, 0, "", "", "", "");
            break;
          }
        } else {
          QQToast.a(BaseApplicationImpl.getContext(), -1, HardCodeUtil.a(2131707871), 0).a();
        }
      }
      else
      {
        QQToast.a(getContext(), HardCodeUtil.a(2131707874), 0).a();
      }
    }
  }
  
  public void setOnMenuClickListener(ParticipleBottomMenuView.OnMenuClickListener paramOnMenuClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView$OnMenuClickListener = paramOnMenuClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ParticipleBottomMenuView
 * JD-Core Version:    0.7.0.1
 */