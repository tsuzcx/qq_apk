package com.tencent.mobileqq.conditionsearch.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqix;
import aqiy;
import aqiz;
import aqja;
import aqjb;
import aqjc;
import aqjd;
import aqje;
import bkil;
import bkpq;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;

public class TimeSelectView
  extends LinearLayout
{
  public static int a;
  private static int jdField_b_of_type_Int = -12303292;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aqjd jdField_a_of_type_Aqjd;
  private aqje jdField_a_of_type_Aqje;
  private bkil jdField_a_of_type_Bkil = new aqiz(this);
  private bkpq jdField_a_of_type_Bkpq = new aqja(this);
  private aqjc[] jdField_a_of_type_ArrayOfAqjc;
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
    aqjc localaqjc = new aqjc(this, paramInt, 25);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt] = paramWheelView;
    this.jdField_a_of_type_ArrayOfAqjc[paramInt] = localaqjc;
    paramWheelView.setAdapter(localaqjc);
    paramWheelView.setOnItemSelectedListener(this.jdField_a_of_type_Bkil);
    paramWheelView.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_Bkpq);
    paramWheelView.setOnEndMovementListener(new aqjb(this, paramInt));
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfAqjc.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt);
    }
    this.jdField_a_of_type_ArrayOfAqjc[paramInt].notifyDataSetChanged();
  }
  
  public void a(aqje paramaqje)
  {
    Object localObject1 = getContext().getResources();
    jdField_a_of_type_Int = ((Resources)localObject1).getColor(2131167070);
    jdField_b_of_type_Int = ((Resources)localObject1).getColor(2131167030);
    setBackgroundColor(((Resources)localObject1).getColor(2131167035));
    Object localObject2 = findViewById(2131378709);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167083));
    }
    localObject2 = findViewById(2131378710);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167083));
    }
    localObject2 = findViewById(2131369879);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167082));
    }
    localObject2 = findViewById(2131369858);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167082));
    }
    this.jdField_a_of_type_Aqje = paramaqje;
    this.c = this.jdField_a_of_type_Aqje.a();
    if ((this.c <= 0) || (this.c > 4)) {
      throw new RuntimeException("Unsupportted column count " + this.c);
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView = new WheelView[this.c];
    this.jdField_a_of_type_ArrayOfAqjc = new aqjc[this.c];
    paramaqje = (WheelView)findViewById(2131366650);
    localObject1 = (WheelView)findViewById(2131377096);
    localObject2 = (WheelView)findViewById(2131378655);
    WheelView localWheelView = (WheelView)findViewById(2131367026);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131378708));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377132));
    this.jdField_b_of_type_AndroidWidgetTextView.setText("设置待办提醒时间");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378735));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131378707));
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new aqix(this));
    }
    if (this.jdField_b_of_type_AndroidWidgetButton != null) {
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new aqiy(this));
    }
    a(paramaqje, 0);
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
  
  public void setPickListener(aqjd paramaqjd)
  {
    this.jdField_a_of_type_Aqjd = paramaqjd;
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