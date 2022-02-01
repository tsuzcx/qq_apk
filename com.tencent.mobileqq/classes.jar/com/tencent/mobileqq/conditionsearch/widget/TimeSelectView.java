package com.tencent.mobileqq.conditionsearch.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener;

public class TimeSelectView
  extends LinearLayout
{
  public static int a = -7829368;
  private static int jdField_b_of_type_Int = -12303292;
  Vibrator jdField_a_of_type_AndroidOsVibrator;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TimeSelectView.IphonePickListener jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView$IphonePickListener;
  private TimeSelectView.PickerViewAdapter jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView$PickerViewAdapter;
  private AdapterView.OnItemSelectedListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener = new TimeSelectView.5(this);
  private VerticalGallery.OnSelectViewDataUpdateListener jdField_a_of_type_ComTencentWidgetVerticalGallery$OnSelectViewDataUpdateListener = new TimeSelectView.6(this);
  private boolean jdField_a_of_type_Boolean;
  private TimeSelectView.InnerAdapter[] jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchWidgetTimeSelectView$InnerAdapter;
  private WheelView[] jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private int jdField_c_of_type_Int = 0;
  private Button jdField_c_of_type_AndroidWidgetButton;
  
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
        paramView = (WheelTextView)paramView;
        paramView.setTextSize(20.0F);
        paramView.setTextColor(jdField_a_of_type_Int);
        return;
      }
      paramView = (WheelTextView)paramView;
      paramView.setTextSize(20.0F);
      paramView.setTextColor(jdField_b_of_type_Int);
    }
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof WheelTextView))
    {
      paramView = (WheelTextView)paramView;
      paramView.setContentDescription(new StringBuilder(paramView.getText()));
    }
  }
  
  private void a(WheelView paramWheelView, int paramInt)
  {
    paramWheelView.setTag(Integer.valueOf(paramInt));
    TimeSelectView.InnerAdapter localInnerAdapter = new TimeSelectView.InnerAdapter(this, paramInt, 25);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt] = paramWheelView;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchWidgetTimeSelectView$InnerAdapter[paramInt] = localInnerAdapter;
    paramWheelView.setAdapter(localInnerAdapter);
    paramWheelView.setOnItemSelectedListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener);
    paramWheelView.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_ComTencentWidgetVerticalGallery$OnSelectViewDataUpdateListener);
    paramWheelView.setOnEndMovementListener(new TimeSelectView.EndMovementListener(this, paramInt));
  }
  
  public int a(int paramInt)
  {
    if (paramInt >= 0)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView;
      if (paramInt < localObject.length) {
        return localObject[paramInt].getSelectedItemPosition();
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Error column index ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchWidgetTimeSelectView$InnerAdapter;
      if (paramInt < localObject.length)
      {
        localObject[paramInt].notifyDataSetChanged();
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Error column index ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void a(TimeSelectView.PickerViewAdapter paramPickerViewAdapter)
  {
    Object localObject1 = getContext().getResources();
    jdField_a_of_type_Int = ((Resources)localObject1).getColor(2131167148);
    jdField_b_of_type_Int = ((Resources)localObject1).getColor(2131167102);
    Object localObject2 = findViewById(2131378717);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167165));
    }
    localObject2 = findViewById(2131370070);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167165));
    }
    localObject2 = findViewById(2131370053);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167165));
    }
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView$PickerViewAdapter = paramPickerViewAdapter;
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView$PickerViewAdapter.a();
    int i = this.jdField_c_of_type_Int;
    if ((i > 0) && (i <= 2))
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView = new WheelView[i];
      this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchWidgetTimeSelectView$InnerAdapter = new TimeSelectView.InnerAdapter[i];
      this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)getContext().getSystemService("vibrator"));
      paramPickerViewAdapter = (WheelView)findViewById(2131366886);
      localObject1 = (WheelView)findViewById(2131377115);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131378714));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131378713));
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131378715));
      localObject2 = this.jdField_a_of_type_AndroidWidgetButton;
      if (localObject2 != null)
      {
        ((Button)localObject2).setOnClickListener(new TimeSelectView.1(this));
        this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(new TimeSelectView.2(this));
      }
      localObject2 = this.jdField_b_of_type_AndroidWidgetButton;
      if (localObject2 != null) {
        ((Button)localObject2).setOnClickListener(new TimeSelectView.3(this));
      }
      localObject2 = this.jdField_c_of_type_AndroidWidgetButton;
      if (localObject2 != null) {
        ((Button)localObject2).setOnClickListener(new TimeSelectView.4(this));
      }
      a(paramPickerViewAdapter, 0);
      paramPickerViewAdapter.setNeedTranslateCenter(true);
      paramPickerViewAdapter.setNeedTranslateCenterToRight(true);
      if (this.jdField_c_of_type_Int < 2)
      {
        ((WheelView)localObject1).setVisibility(8);
        return;
      }
      ((WheelView)localObject1).setVisibility(0);
      a((WheelView)localObject1, 1);
      ((WheelView)localObject1).setNeedTranslateCenter(true);
      return;
    }
    paramPickerViewAdapter = new StringBuilder();
    paramPickerViewAdapter.append("Unsupportted column count ");
    paramPickerViewAdapter.append(this.jdField_c_of_type_Int);
    throw new RuntimeException(paramPickerViewAdapter.toString());
  }
  
  public void setPickListener(TimeSelectView.IphonePickListener paramIphonePickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView$IphonePickListener = paramIphonePickListener;
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView;
      if (paramInt1 < localObject.length)
      {
        this.jdField_a_of_type_Boolean = true;
        localObject[paramInt1].setSelection(paramInt2, true);
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Error column index ");
    ((StringBuilder)localObject).append(paramInt1);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.widget.TimeSelectView
 * JD-Core Version:    0.7.0.1
 */