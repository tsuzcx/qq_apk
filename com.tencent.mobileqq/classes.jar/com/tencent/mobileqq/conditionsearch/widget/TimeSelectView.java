package com.tencent.mobileqq.conditionsearch.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import aprj;
import aprk;
import aprl;
import aprm;
import aprn;
import apro;
import aprp;
import aprq;
import aprr;
import aprs;
import bjuu;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

public class TimeSelectView
  extends LinearLayout
{
  public static int a;
  private static int jdField_b_of_type_Int = -12303292;
  private static int jdField_c_of_type_Int = 35;
  public Vibrator a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private aprr jdField_a_of_type_Aprr;
  private aprs jdField_a_of_type_Aprs;
  private bjuu jdField_a_of_type_Bjuu = new apro(this);
  private AdapterView.OnItemSelectedListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener = new aprn(this);
  private boolean jdField_a_of_type_Boolean;
  private aprq[] jdField_a_of_type_ArrayOfAprq;
  private WheelView[] jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private int d;
  
  static
  {
    jdField_a_of_type_Int = -7829368;
  }
  
  public TimeSelectView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TimeSelectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(View paramView, int paramInt)
  {
    if ((paramView instanceof WheelTextView))
    {
      if (paramInt == 0)
      {
        ((WheelTextView)paramView).setTextSize(20.0F);
        ((WheelTextView)paramView).setTextColor(jdField_a_of_type_Int);
      }
    }
    else {
      return;
    }
    ((WheelTextView)paramView).setTextSize(20.0F);
    ((WheelTextView)paramView).setTextColor(jdField_b_of_type_Int);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof WheelTextView))
    {
      StringBuilder localStringBuilder = new StringBuilder(((WheelTextView)paramView).getText());
      ((WheelTextView)paramView).setContentDescription(localStringBuilder);
    }
  }
  
  private void a(WheelView paramWheelView, int paramInt)
  {
    paramWheelView.setTag(Integer.valueOf(paramInt));
    aprq localaprq = new aprq(this, paramInt, 25);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt] = paramWheelView;
    this.jdField_a_of_type_ArrayOfAprq[paramInt] = localaprq;
    paramWheelView.setAdapter(localaprq);
    paramWheelView.setOnItemSelectedListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener);
    paramWheelView.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_Bjuu);
    paramWheelView.setOnEndMovementListener(new aprp(this, paramInt));
  }
  
  public int a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt);
    }
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt].getSelectedItemPosition();
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfAprq.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt);
    }
    this.jdField_a_of_type_ArrayOfAprq[paramInt].notifyDataSetChanged();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void a(aprs paramaprs)
  {
    Object localObject = getContext().getResources();
    jdField_a_of_type_Int = ((Resources)localObject).getColor(2131167102);
    jdField_b_of_type_Int = ((Resources)localObject).getColor(2131167058);
    View localView = findViewById(2131378642);
    if (localView != null) {
      localView.setBackgroundColor(((Resources)localObject).getColor(2131167119));
    }
    localView = findViewById(2131369970);
    if (localView != null) {
      localView.setBackgroundColor(((Resources)localObject).getColor(2131167119));
    }
    localView = findViewById(2131369950);
    if (localView != null) {
      localView.setBackgroundColor(((Resources)localObject).getColor(2131167119));
    }
    this.jdField_a_of_type_Aprs = paramaprs;
    this.d = this.jdField_a_of_type_Aprs.a();
    if ((this.d <= 0) || (this.d > 2)) {
      throw new RuntimeException("Unsupportted column count " + this.d);
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView = new WheelView[this.d];
    this.jdField_a_of_type_ArrayOfAprq = new aprq[this.d];
    this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)getContext().getSystemService("vibrator"));
    paramaprs = (WheelView)findViewById(2131366730);
    localObject = (WheelView)findViewById(2131376985);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131378639));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131378638));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131378640));
    if (this.jdField_a_of_type_AndroidWidgetButton != null)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new aprj(this));
      this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(new aprk(this));
    }
    if (this.jdField_b_of_type_AndroidWidgetButton != null) {
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new aprl(this));
    }
    if (this.jdField_c_of_type_AndroidWidgetButton != null) {
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(new aprm(this));
    }
    a(paramaprs, 0);
    paramaprs.setNeedTranslateCenter(true);
    paramaprs.setNeedTranslateCenterToRight(true);
    if (this.d < 2)
    {
      ((WheelView)localObject).setVisibility(8);
      return;
    }
    ((WheelView)localObject).setVisibility(0);
    a((WheelView)localObject, 1);
    ((WheelView)localObject).setNeedTranslateCenter(true);
  }
  
  public void setPickListener(aprr paramaprr)
  {
    this.jdField_a_of_type_Aprr = paramaprr;
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt1);
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt1].setSelection(paramInt2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.widget.TimeSelectView
 * JD-Core Version:    0.7.0.1
 */