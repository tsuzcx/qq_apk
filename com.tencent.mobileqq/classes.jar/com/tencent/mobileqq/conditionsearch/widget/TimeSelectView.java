package com.tencent.mobileqq.conditionsearch.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqya;
import aqyb;
import aqyc;
import aqyd;
import aqye;
import aqyf;
import aqyg;
import aqyh;
import bljo;
import blqt;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;

public class TimeSelectView
  extends LinearLayout
{
  public static int a;
  private static int jdField_b_of_type_Int = -12303292;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aqyg jdField_a_of_type_Aqyg;
  private aqyh jdField_a_of_type_Aqyh;
  private bljo jdField_a_of_type_Bljo = new aqyc(this);
  private blqt jdField_a_of_type_Blqt = new aqyd(this);
  private aqyf[] jdField_a_of_type_ArrayOfAqyf;
  private WheelView[] jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int c;
  
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
    aqyf localaqyf = new aqyf(this, paramInt, 25);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt] = paramWheelView;
    this.jdField_a_of_type_ArrayOfAqyf[paramInt] = localaqyf;
    paramWheelView.setAdapter(localaqyf);
    paramWheelView.setOnItemSelectedListener(this.jdField_a_of_type_Bljo);
    paramWheelView.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_Blqt);
    paramWheelView.setOnEndMovementListener(new aqye(this, paramInt));
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfAqyf.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt);
    }
    this.jdField_a_of_type_ArrayOfAqyf[paramInt].notifyDataSetChanged();
  }
  
  public void a(aqyh paramaqyh)
  {
    Object localObject1 = getContext().getResources();
    jdField_a_of_type_Int = ((Resources)localObject1).getColor(2131167080);
    jdField_b_of_type_Int = ((Resources)localObject1).getColor(2131167036);
    setBackgroundColor(((Resources)localObject1).getColor(2131167041));
    Object localObject2 = findViewById(2131378870);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167093));
    }
    localObject2 = findViewById(2131378871);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167093));
    }
    localObject2 = findViewById(2131369976);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167092));
    }
    localObject2 = findViewById(2131369956);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167092));
    }
    this.jdField_a_of_type_Aqyh = paramaqyh;
    this.c = this.jdField_a_of_type_Aqyh.a();
    if ((this.c <= 0) || (this.c > 4)) {
      throw new RuntimeException("Unsupportted column count " + this.c);
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView = new WheelView[this.c];
    this.jdField_a_of_type_ArrayOfAqyf = new aqyf[this.c];
    paramaqyh = (WheelView)findViewById(2131366700);
    localObject1 = (WheelView)findViewById(2131377235);
    localObject2 = (WheelView)findViewById(2131378814);
    WheelView localWheelView = (WheelView)findViewById(2131367077);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131378869));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377272));
    this.jdField_b_of_type_AndroidWidgetTextView.setText("设置待办提醒时间");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378896));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131378868));
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new aqya(this));
    }
    if (this.jdField_b_of_type_AndroidWidgetButton != null) {
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new aqyb(this));
    }
    a(paramaqyh, 0);
    if (this.c < 2)
    {
      ((WheelView)localObject1).setVisibility(8);
      if (this.c >= 3) {
        break label415;
      }
      ((WheelView)localObject2).setVisibility(8);
    }
    for (;;)
    {
      if (this.c >= 4) {
        break label429;
      }
      localWheelView.setVisibility(8);
      return;
      ((WheelView)localObject1).setVisibility(0);
      a((WheelView)localObject1, 1);
      break;
      label415:
      ((WheelView)localObject2).setVisibility(0);
      a((WheelView)localObject2, 2);
    }
    label429:
    localWheelView.setVisibility(0);
    a(localWheelView, 3);
  }
  
  public void setPickListener(aqyg paramaqyg)
  {
    this.jdField_a_of_type_Aqyg = paramaqyg;
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt1);
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt1].setSelection(paramInt2, true);
  }
  
  public void setTips(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.widget.TimeSelectView
 * JD-Core Version:    0.7.0.1
 */