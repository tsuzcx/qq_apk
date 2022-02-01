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
import anzj;
import bdll;
import bizw;
import bizx;
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
  private bizx jdField_a_of_type_Bizx;
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
    LayoutInflater.from(getContext()).inflate(2131559548, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372283));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372287));
    this.c = ((ImageView)findViewById(2131372285));
    this.d = ((ImageView)findViewById(2131372289));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(a(anzj.a(2131706766)));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(a(anzj.a(2131706770)));
    this.c.setContentDescription(a(anzj.a(2131706769)));
    this.d.setContentDescription(a(anzj.a(2131706767)));
    TextView localTextView = (TextView)findViewById(2131379987);
    findViewById(2131372284).setOnClickListener(this);
    findViewById(2131372288).setOnClickListener(this);
    findViewById(2131372286).setOnClickListener(this);
    findViewById(2131372290).setOnClickListener(this);
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
    return getContext().getString(2131690561, new Object[] { paramString });
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
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130845609);
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845634);
        this.c.setBackgroundResource(2130845615);
        this.d.setBackgroundResource(2130845647);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon enable STATE_WHITE");
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130845606);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845621);
      this.c.setBackgroundResource(2130845612);
      this.d.setBackgroundResource(2130845627);
      return;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon unable STATE_BLACK");
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130845607);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845622);
      this.c.setBackgroundResource(2130845613);
      this.d.setBackgroundResource(2130845624);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon unable STATE_BLACK");
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130845608);
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845623);
    this.c.setBackgroundResource(2130845614);
    this.d.setBackgroundResource(2130845628);
  }
  
  public void a(ParticipleView paramParticipleView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView = paramParticipleView;
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.setOnParticipleSelectChangeListener(new bizw(this));
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
    if (this.jdField_a_of_type_Bizx != null)
    {
      if (paramView.getId() != 2131379987) {
        break label66;
      }
      this.jdField_a_of_type_Bizx.a();
      bdll.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35F", "0X800A35F", 0, 0, "", "", "", "");
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
          case 2131372285: 
          case 2131372287: 
          case 2131372289: 
          default: 
            break;
          case 2131372284: 
            this.jdField_a_of_type_Bizx.a(str);
            bdll.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35A", "0X800A35A", 0, 0, "", "", "", "");
            break;
          case 2131372286: 
            this.jdField_a_of_type_Bizx.c(str);
            bdll.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35B", "0X800A35B", 0, 0, "", "", "", "");
            break;
          case 2131372288: 
            this.jdField_a_of_type_Bizx.b(str);
            bdll.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35C", "0X800A35C", 0, 0, "", "", "", "");
            break;
          case 2131372290: 
            this.jdField_a_of_type_Bizx.d(str);
            bdll.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35E", "0X800A35E", 0, 0, "", "", "", "");
            break;
          }
        } else {
          QQToast.a(BaseApplicationImpl.getContext(), -1, anzj.a(2131706765), 0).a();
        }
      }
      else
      {
        QQToast.a(getContext(), anzj.a(2131706768), 0).a();
      }
    }
  }
  
  public void setOnMenuClickListener(bizx parambizx)
  {
    this.jdField_a_of_type_Bizx = parambizx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ParticipleBottomMenuView
 * JD-Core Version:    0.7.0.1
 */