package com.tencent.mobileqq.widget;

import amtj;
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
import bcef;
import bhfx;
import bhfy;
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
  private bhfy jdField_a_of_type_Bhfy;
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
    LayoutInflater.from(getContext()).inflate(2131559550, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372249));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372253));
    this.c = ((ImageView)findViewById(2131372251));
    this.d = ((ImageView)findViewById(2131372255));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(a(amtj.a(2131706998)));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(a(amtj.a(2131707002)));
    this.c.setContentDescription(a(amtj.a(2131707001)));
    this.d.setContentDescription(a(amtj.a(2131706999)));
    TextView localTextView = (TextView)findViewById(2131379750);
    findViewById(2131372250).setOnClickListener(this);
    findViewById(2131372254).setOnClickListener(this);
    findViewById(2131372252).setOnClickListener(this);
    findViewById(2131372256).setOnClickListener(this);
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
    return getContext().getString(2131690601, new Object[] { paramString });
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
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130845488);
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845513);
        this.c.setBackgroundResource(2130845494);
        this.d.setBackgroundResource(2130845526);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon enable STATE_WHITE");
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130845485);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845500);
      this.c.setBackgroundResource(2130845491);
      this.d.setBackgroundResource(2130845506);
      return;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon unable STATE_BLACK");
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130845486);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845501);
      this.c.setBackgroundResource(2130845492);
      this.d.setBackgroundResource(2130845503);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon unable STATE_BLACK");
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130845487);
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845502);
    this.c.setBackgroundResource(2130845493);
    this.d.setBackgroundResource(2130845507);
  }
  
  public void a(ParticipleView paramParticipleView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView = paramParticipleView;
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.setOnParticipleSelectChangeListener(new bhfx(this));
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
    if (this.jdField_a_of_type_Bhfy != null)
    {
      if (paramView.getId() != 2131379750) {
        break label66;
      }
      this.jdField_a_of_type_Bhfy.a();
      bcef.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35F", "0X800A35F", 0, 0, "", "", "", "");
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
          case 2131372251: 
          case 2131372253: 
          case 2131372255: 
          default: 
            break;
          case 2131372250: 
            this.jdField_a_of_type_Bhfy.a(str);
            bcef.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35A", "0X800A35A", 0, 0, "", "", "", "");
            break;
          case 2131372252: 
            this.jdField_a_of_type_Bhfy.c(str);
            bcef.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35B", "0X800A35B", 0, 0, "", "", "", "");
            break;
          case 2131372254: 
            this.jdField_a_of_type_Bhfy.b(str);
            bcef.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35C", "0X800A35C", 0, 0, "", "", "", "");
            break;
          case 2131372256: 
            this.jdField_a_of_type_Bhfy.d(str);
            bcef.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A35E", "0X800A35E", 0, 0, "", "", "", "");
            break;
          }
        } else {
          QQToast.a(BaseApplicationImpl.getContext(), -1, amtj.a(2131706997), 0).a();
        }
      }
      else
      {
        QQToast.a(getContext(), amtj.a(2131707000), 0).a();
      }
    }
  }
  
  public void setOnMenuClickListener(bhfy parambhfy)
  {
    this.jdField_a_of_type_Bhfy = parambhfy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ParticipleBottomMenuView
 * JD-Core Version:    0.7.0.1
 */