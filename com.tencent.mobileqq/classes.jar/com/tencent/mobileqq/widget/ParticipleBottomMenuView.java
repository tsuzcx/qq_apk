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
import anvx;
import bdla;
import biqp;
import biqq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ParticipleBottomMenuView
  extends LinearLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private biqq jdField_a_of_type_Biqq;
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
    LayoutInflater.from(getContext()).inflate(2131559583, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372441));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372445));
    this.c = ((ImageView)findViewById(2131372443));
    this.d = ((ImageView)findViewById(2131372447));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(a(anvx.a(2131707345)));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(a(anvx.a(2131707349)));
    this.c.setContentDescription(a(anvx.a(2131707348)));
    this.d.setContentDescription(a(anvx.a(2131707346)));
    TextView localTextView = (TextView)findViewById(2131380067);
    findViewById(2131372442).setOnClickListener(this);
    findViewById(2131372446).setOnClickListener(this);
    findViewById(2131372444).setOnClickListener(this);
    findViewById(2131372448).setOnClickListener(this);
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
    return getContext().getString(2131690678, new Object[] { paramString });
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
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130845573);
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845598);
        this.c.setBackgroundResource(2130845579);
        this.d.setBackgroundResource(2130845611);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon enable STATE_WHITE");
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130845570);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845585);
      this.c.setBackgroundResource(2130845576);
      this.d.setBackgroundResource(2130845591);
      return;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon unable STATE_BLACK");
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130845571);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845586);
      this.c.setBackgroundResource(2130845577);
      this.d.setBackgroundResource(2130845588);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon unable STATE_BLACK");
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130845572);
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845587);
    this.c.setBackgroundResource(2130845578);
    this.d.setBackgroundResource(2130845592);
  }
  
  public void a(ParticipleView paramParticipleView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView = paramParticipleView;
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.setOnParticipleSelectChangeListener(new biqp(this));
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
    if (this.jdField_a_of_type_Biqq != null)
    {
      if (paramView.getId() != 2131380067) {
        break label66;
      }
      this.jdField_a_of_type_Biqq.a();
      bdla.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35F", "0X800A35F", 0, 0, "", "", "", "");
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
          case 2131372443: 
          case 2131372445: 
          case 2131372447: 
          default: 
            break;
          case 2131372442: 
            this.jdField_a_of_type_Biqq.a(str);
            bdla.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35A", "0X800A35A", 0, 0, "", "", "", "");
            break;
          case 2131372444: 
            this.jdField_a_of_type_Biqq.c(str);
            bdla.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35B", "0X800A35B", 0, 0, "", "", "", "");
            break;
          case 2131372446: 
            this.jdField_a_of_type_Biqq.b(str);
            bdla.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35C", "0X800A35C", 0, 0, "", "", "", "");
            break;
          case 2131372448: 
            this.jdField_a_of_type_Biqq.d(str);
            bdla.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35E", "0X800A35E", 0, 0, "", "", "", "");
            break;
          }
        } else {
          QQToast.a(BaseApplicationImpl.getContext(), -1, anvx.a(2131707344), 0).a();
        }
      }
      else
      {
        QQToast.a(getContext(), anvx.a(2131707347), 0).a();
      }
    }
  }
  
  public void setOnMenuClickListener(biqq parambiqq)
  {
    this.jdField_a_of_type_Biqq = parambiqq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ParticipleBottomMenuView
 * JD-Core Version:    0.7.0.1
 */