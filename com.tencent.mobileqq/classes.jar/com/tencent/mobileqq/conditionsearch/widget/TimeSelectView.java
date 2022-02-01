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
  public static int a;
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
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt);
    }
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt].getSelectedItemPosition();
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchWidgetTimeSelectView$InnerAdapter.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt);
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchWidgetTimeSelectView$InnerAdapter[paramInt].notifyDataSetChanged();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void a(TimeSelectView.PickerViewAdapter paramPickerViewAdapter)
  {
    Object localObject = getContext().getResources();
    jdField_a_of_type_Int = ((Resources)localObject).getColor(2131167123);
    jdField_b_of_type_Int = ((Resources)localObject).getColor(2131167079);
    View localView = findViewById(2131379367);
    if (localView != null) {
      localView.setBackgroundColor(((Resources)localObject).getColor(2131167140));
    }
    localView = findViewById(2131370411);
    if (localView != null) {
      localView.setBackgroundColor(((Resources)localObject).getColor(2131167140));
    }
    localView = findViewById(2131370391);
    if (localView != null) {
      localView.setBackgroundColor(((Resources)localObject).getColor(2131167140));
    }
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView$PickerViewAdapter = paramPickerViewAdapter;
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView$PickerViewAdapter.a();
    if ((this.jdField_c_of_type_Int <= 0) || (this.jdField_c_of_type_Int > 2)) {
      throw new RuntimeException("Unsupportted column count " + this.jdField_c_of_type_Int);
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView = new WheelView[this.jdField_c_of_type_Int];
    this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchWidgetTimeSelectView$InnerAdapter = new TimeSelectView.InnerAdapter[this.jdField_c_of_type_Int];
    this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)getContext().getSystemService("vibrator"));
    paramPickerViewAdapter = (WheelView)findViewById(2131367036);
    localObject = (WheelView)findViewById(2131377679);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131379364));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131379363));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131379365));
    if (this.jdField_a_of_type_AndroidWidgetButton != null)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new TimeSelectView.1(this));
      this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(new TimeSelectView.2(this));
    }
    if (this.jdField_b_of_type_AndroidWidgetButton != null) {
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new TimeSelectView.3(this));
    }
    if (this.jdField_c_of_type_AndroidWidgetButton != null) {
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(new TimeSelectView.4(this));
    }
    a(paramPickerViewAdapter, 0);
    paramPickerViewAdapter.setNeedTranslateCenter(true);
    paramPickerViewAdapter.setNeedTranslateCenterToRight(true);
    if (this.jdField_c_of_type_Int < 2)
    {
      ((WheelView)localObject).setVisibility(8);
      return;
    }
    ((WheelView)localObject).setVisibility(0);
    a((WheelView)localObject, 1);
    ((WheelView)localObject).setNeedTranslateCenter(true);
  }
  
  public void setPickListener(TimeSelectView.IphonePickListener paramIphonePickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView$IphonePickListener = paramIphonePickListener;
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