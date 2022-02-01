package com.tencent.mobileqq.conditionsearch.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener;

public class IphonePickerView
  extends LinearLayout
{
  public static int a = -7829368;
  private static int b = -12303292;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IphonePickerView.IphonePickListener jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener;
  private IphonePickerView.PickerViewAdapter jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter;
  private AdapterView.OnItemSelectedListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener = new IphonePickerView.2(this);
  private VerticalGallery.OnSelectViewDataUpdateListener jdField_a_of_type_ComTencentWidgetVerticalGallery$OnSelectViewDataUpdateListener = new IphonePickerView.3(this);
  private IphonePickerView.InnerAdapter[] jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchWidgetIphonePickerView$InnerAdapter;
  private WheelView[] jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView;
  private int c = 0;
  
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
        paramView = (WheelTextView)paramView;
        paramView.setTextSize(20.0F);
        paramView.setTextColor(jdField_a_of_type_Int);
        return;
      }
      paramView = (WheelTextView)paramView;
      paramView.setTextSize(20.0F);
      paramView.setTextColor(b);
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
    IphonePickerView.InnerAdapter localInnerAdapter = new IphonePickerView.InnerAdapter(this, paramInt, 25);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt] = paramWheelView;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchWidgetIphonePickerView$InnerAdapter[paramInt] = localInnerAdapter;
    paramWheelView.setAdapter(localInnerAdapter);
    paramWheelView.setOnItemSelectedListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener);
    paramWheelView.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_ComTencentWidgetVerticalGallery$OnSelectViewDataUpdateListener);
    paramWheelView.setOnEndMovementListener(new IphonePickerView.EndMovementListener(this, paramInt));
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
  
  public void a()
  {
    findViewById(2131378890).setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchWidgetIphonePickerView$InnerAdapter;
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
  
  public void a(IphonePickerView.PickerViewAdapter paramPickerViewAdapter)
  {
    Object localObject1 = getContext().getResources();
    jdField_a_of_type_Int = ((Resources)localObject1).getColor(2131167148);
    b = ((Resources)localObject1).getColor(2131167102);
    setBackgroundColor(((Resources)localObject1).getColor(2131167107));
    Object localObject2 = findViewById(2131378716);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167161));
    }
    localObject2 = findViewById(2131378717);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167161));
    }
    localObject2 = findViewById(2131370070);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167160));
    }
    localObject2 = findViewById(2131370053);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167160));
    }
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = paramPickerViewAdapter;
    this.c = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter.getColumnCount();
    int i = this.c;
    if ((i > 0) && (i <= 3))
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView = new WheelView[i];
      this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchWidgetIphonePickerView$InnerAdapter = new IphonePickerView.InnerAdapter[i];
      paramPickerViewAdapter = (WheelView)findViewById(2131365431);
      localObject1 = (WheelView)findViewById(2131368318);
      localObject2 = (WheelView)findViewById(2131371408);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131378714));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378743));
      Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
      if (localButton != null) {
        localButton.setOnClickListener(new IphonePickerView.1(this));
      }
      a(paramPickerViewAdapter, 0);
      if (this.c < 2)
      {
        ((WheelView)localObject1).setVisibility(8);
      }
      else
      {
        ((WheelView)localObject1).setVisibility(0);
        a((WheelView)localObject1, 1);
      }
      if (this.c < 3)
      {
        ((WheelView)localObject2).setVisibility(8);
        return;
      }
      ((WheelView)localObject2).setVisibility(0);
      a((WheelView)localObject2, 2);
      return;
    }
    paramPickerViewAdapter = new StringBuilder();
    paramPickerViewAdapter.append("Unsupportted column count ");
    paramPickerViewAdapter.append(this.c);
    throw new RuntimeException(paramPickerViewAdapter.toString());
  }
  
  public void setPickListener(IphonePickerView.IphonePickListener paramIphonePickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener = paramIphonePickListener;
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView;
      if (paramInt1 < localObject.length)
      {
        localObject[paramInt1].setSelection(paramInt2, true);
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Error column index ");
    ((StringBuilder)localObject).append(paramInt1);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void setTips(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.widget.IphonePickerView
 * JD-Core Version:    0.7.0.1
 */