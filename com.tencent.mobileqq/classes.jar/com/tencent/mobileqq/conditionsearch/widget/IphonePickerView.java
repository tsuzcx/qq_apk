package com.tencent.mobileqq.conditionsearch.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqxt;
import aqxu;
import aqxv;
import aqxw;
import aqxx;
import aqxy;
import aqxz;
import bljo;
import blqt;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;

public class IphonePickerView
  extends LinearLayout
{
  public static int a;
  private static int b = -12303292;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aqxy jdField_a_of_type_Aqxy;
  private aqxz jdField_a_of_type_Aqxz;
  private bljo jdField_a_of_type_Bljo = new aqxu(this);
  private blqt jdField_a_of_type_Blqt = new aqxv(this);
  private aqxx[] jdField_a_of_type_ArrayOfAqxx;
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
    aqxx localaqxx = new aqxx(this, paramInt, 25);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt] = paramWheelView;
    this.jdField_a_of_type_ArrayOfAqxx[paramInt] = localaqxx;
    paramWheelView.setAdapter(localaqxx);
    paramWheelView.setOnItemSelectedListener(this.jdField_a_of_type_Bljo);
    paramWheelView.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_Blqt);
    paramWheelView.setOnEndMovementListener(new aqxw(this, paramInt));
  }
  
  public int a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt);
    }
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt].getSelectedItemPosition();
  }
  
  public void a()
  {
    findViewById(2131379047).setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfAqxx.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt);
    }
    this.jdField_a_of_type_ArrayOfAqxx[paramInt].notifyDataSetChanged();
  }
  
  public void a(aqxz paramaqxz)
  {
    Object localObject1 = getContext().getResources();
    jdField_a_of_type_Int = ((Resources)localObject1).getColor(2131167080);
    b = ((Resources)localObject1).getColor(2131167036);
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
    this.jdField_a_of_type_Aqxz = paramaqxz;
    this.c = this.jdField_a_of_type_Aqxz.a();
    if ((this.c <= 0) || (this.c > 3)) {
      throw new RuntimeException("Unsupportted column count " + this.c);
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView = new WheelView[this.c];
    this.jdField_a_of_type_ArrayOfAqxx = new aqxx[this.c];
    paramaqxz = (WheelView)findViewById(2131365298);
    localObject1 = (WheelView)findViewById(2131368188);
    localObject2 = (WheelView)findViewById(2131371315);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131378869));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378896));
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new aqxt(this));
    }
    a(paramaqxz, 0);
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
  
  public void setPickListener(aqxy paramaqxy)
  {
    this.jdField_a_of_type_Aqxy = paramaqxy;
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
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.widget.IphonePickerView
 * JD-Core Version:    0.7.0.1
 */