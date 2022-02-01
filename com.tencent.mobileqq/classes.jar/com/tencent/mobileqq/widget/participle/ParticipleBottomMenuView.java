package com.tencent.mobileqq.widget.participle;

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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqui.R.styleable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ParticipleBottomMenuView
  extends LinearLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ParticipleBottomMenuView.OnMenuClickListener jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleBottomMenuView$OnMenuClickListener;
  private ParticipleView jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView;
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
    LayoutInflater.from(getContext()).inflate(2131559537, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372328));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372332));
    this.c = ((ImageView)findViewById(2131372330));
    this.d = ((ImageView)findViewById(2131372334));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(a(HardCodeUtil.a(2131707895)));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(a(HardCodeUtil.a(2131707899)));
    this.c.setContentDescription(a(HardCodeUtil.a(2131707898)));
    this.d.setContentDescription(a(HardCodeUtil.a(2131707896)));
    TextView localTextView = (TextView)findViewById(2131379802);
    findViewById(2131372329).setOnClickListener(this);
    findViewById(2131372333).setOnClickListener(this);
    findViewById(2131372331).setOnClickListener(this);
    findViewById(2131372335).setOnClickListener(this);
    localTextView.setOnClickListener(this);
    if ((paramAttributeSet != null) && (paramContext != null))
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.az);
      this.jdField_a_of_type_Int = paramContext.getInteger(R.styleable.as, 0);
      this.jdField_b_of_type_Int = paramContext.getInteger(R.styleable.ar, 200);
      paramContext.recycle();
    }
    int i = this.jdField_a_of_type_Int;
    paramAttributeSet = "#000000";
    if (i == 1) {
      paramContext = "#000000";
    } else {
      paramContext = "#e6ffffff";
    }
    setBackgroundColor(Color.parseColor(paramContext));
    paramContext = paramAttributeSet;
    if (this.jdField_a_of_type_Int == 1) {
      paramContext = "#ffffff";
    }
    localTextView.setTextColor(Color.parseColor(paramContext));
    a();
  }
  
  public String a(String paramString)
  {
    return getContext().getString(2131690708, new Object[] { paramString });
  }
  
  public void a()
  {
    ParticipleView localParticipleView = this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView;
    if ((localParticipleView != null) && (!TextUtils.isEmpty(localParticipleView.a())))
    {
      if (this.jdField_a_of_type_Int == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon enable STATE_BLACK");
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130845763);
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845788);
        this.c.setBackgroundResource(2130845769);
        this.d.setBackgroundResource(2130845801);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon enable STATE_WHITE");
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130845760);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845775);
      this.c.setBackgroundResource(2130845766);
      this.d.setBackgroundResource(2130845781);
      return;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon unable STATE_BLACK");
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130845761);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845776);
      this.c.setBackgroundResource(2130845767);
      this.d.setBackgroundResource(2130845778);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ParticipleBottomMenuView", 2, "updateMenuIcon unable STATE_BLACK");
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130845762);
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845777);
    this.c.setBackgroundResource(2130845768);
    this.d.setBackgroundResource(2130845782);
  }
  
  public void a(ParticipleView paramParticipleView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView = paramParticipleView;
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView.setOnParticipleSelectChangeListener(new ParticipleBottomMenuView.1(this));
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
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleBottomMenuView$OnMenuClickListener != null) {
      if (paramView.getId() == 2131379802)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleBottomMenuView$OnMenuClickListener.a();
        ReportController.b(null, "dc00898", "", "", "0X800A35F", "0X800A35F", 0, 0, "", "", "", "");
      }
      else
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView;
        if (localObject != null)
        {
          localObject = ((ParticipleView)localObject).a();
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            if (paramView.getId() == 2131372329)
            {
              this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleBottomMenuView$OnMenuClickListener.a((String)localObject);
              ReportController.b(null, "dc00898", "", "", "0X800A35A", "0X800A35A", 0, 0, "", "", "", "");
            }
            else if (paramView.getId() == 2131372331)
            {
              this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleBottomMenuView$OnMenuClickListener.c((String)localObject);
              ReportController.b(null, "dc00898", "", "", "0X800A35B", "0X800A35B", 0, 0, "", "", "", "");
            }
            else if (paramView.getId() == 2131372333)
            {
              this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleBottomMenuView$OnMenuClickListener.b((String)localObject);
              ReportController.b(null, "dc00898", "", "", "0X800A35C", "0X800A35C", 0, 0, "", "", "", "");
            }
            else if (paramView.getId() == 2131372335)
            {
              this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleBottomMenuView$OnMenuClickListener.d((String)localObject);
              ReportController.b(null, "dc00898", "", "", "0X800A35E", "0X800A35E", 0, 0, "", "", "", "");
            }
          }
          else {
            QQToast.a(BaseApplication.getContext(), -1, HardCodeUtil.a(2131707894), 0).a();
          }
        }
        else
        {
          QQToast.a(getContext(), HardCodeUtil.a(2131707897), 0).a();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setOnMenuClickListener(ParticipleBottomMenuView.OnMenuClickListener paramOnMenuClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleBottomMenuView$OnMenuClickListener = paramOnMenuClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.participle.ParticipleBottomMenuView
 * JD-Core Version:    0.7.0.1
 */