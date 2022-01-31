package com.tencent.mobileqq.conditionsearch.widget;

import ammz;
import amna;
import amnb;
import amnc;
import amnd;
import amne;
import amnf;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import bfpv;
import bfxc;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;

public class IphonePickerView
  extends LinearLayout
{
  public static int a;
  private static int b = -12303292;
  private amne jdField_a_of_type_Amne;
  private amnf jdField_a_of_type_Amnf;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bfpv jdField_a_of_type_Bfpv = new amna(this);
  private bfxc jdField_a_of_type_Bfxc = new amnb(this);
  private amnd[] jdField_a_of_type_ArrayOfAmnd;
  private WheelView[] jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView;
  private int c;
  
  static
  {
    jdField_a_of_type_Int = -7829368;
  }
  
  public IphonePickerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public IphonePickerView(Context paramContext, AttributeSet paramAttributeSet)
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
    ((WheelTextView)paramView).setTextColor(b);
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
    amnd localamnd = new amnd(this, paramInt, 25);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt] = paramWheelView;
    this.jdField_a_of_type_ArrayOfAmnd[paramInt] = localamnd;
    paramWheelView.setAdapter(localamnd);
    paramWheelView.setOnItemSelectedListener(this.jdField_a_of_type_Bfpv);
    paramWheelView.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_Bfxc);
    paramWheelView.setOnEndMovementListener(new amnc(this, paramInt));
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
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfAmnd.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt);
    }
    this.jdField_a_of_type_ArrayOfAmnd[paramInt].notifyDataSetChanged();
  }
  
  public void a(amnf paramamnf)
  {
    Object localObject1 = getContext().getResources();
    jdField_a_of_type_Int = ((Resources)localObject1).getColor(2131166937);
    b = ((Resources)localObject1).getColor(2131166898);
    setBackgroundColor(((Resources)localObject1).getColor(2131166903));
    Object localObject2 = findViewById(2131377287);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131166950));
    }
    localObject2 = findViewById(2131377288);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131166950));
    }
    localObject2 = findViewById(2131369233);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131166949));
    }
    localObject2 = findViewById(2131369211);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131166949));
    }
    this.jdField_a_of_type_Amnf = paramamnf;
    this.c = this.jdField_a_of_type_Amnf.a();
    if ((this.c <= 0) || (this.c > 3)) {
      throw new RuntimeException("Unsupportted column count " + this.c);
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView = new WheelView[this.c];
    this.jdField_a_of_type_ArrayOfAmnd = new amnd[this.c];
    paramamnf = (WheelView)findViewById(2131364928);
    localObject1 = (WheelView)findViewById(2131367659);
    localObject2 = (WheelView)findViewById(2131370331);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131377286));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377313));
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ammz(this));
    }
    a(paramamnf, 0);
    if (this.c < 2) {
      ((WheelView)localObject1).setVisibility(8);
    }
    while (this.c < 3)
    {
      ((WheelView)localObject2).setVisibility(8);
      return;
      ((WheelView)localObject1).setVisibility(0);
      a((WheelView)localObject1, 1);
    }
    ((WheelView)localObject2).setVisibility(0);
    a((WheelView)localObject2, 2);
  }
  
  public void setPickListener(amne paramamne)
  {
    this.jdField_a_of_type_Amne = paramamne;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.widget.IphonePickerView
 * JD-Core Version:    0.7.0.1
 */