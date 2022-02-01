package com.tencent.mobileqq.conditionsearch.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import aquf;
import aqug;
import aquh;
import aqui;
import aquj;
import aquk;
import aqul;
import blgg;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

public class IphonePickerView
  extends LinearLayout
{
  public static int a;
  private static int b = -12303292;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aquk jdField_a_of_type_Aquk;
  private aqul jdField_a_of_type_Aqul;
  private blgg jdField_a_of_type_Blgg = new aquh(this);
  private AdapterView.OnItemSelectedListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener = new aqug(this);
  private aquj[] jdField_a_of_type_ArrayOfAquj;
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
    aquj localaquj = new aquj(this, paramInt, 25);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt] = paramWheelView;
    this.jdField_a_of_type_ArrayOfAquj[paramInt] = localaquj;
    paramWheelView.setAdapter(localaquj);
    paramWheelView.setOnItemSelectedListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener);
    paramWheelView.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_Blgg);
    paramWheelView.setOnEndMovementListener(new aqui(this, paramInt));
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
    findViewById(2131379109).setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfAquj.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt);
    }
    this.jdField_a_of_type_ArrayOfAquj[paramInt].notifyDataSetChanged();
  }
  
  public void a(aqul paramaqul)
  {
    Object localObject1 = getContext().getResources();
    jdField_a_of_type_Int = ((Resources)localObject1).getColor(2131167116);
    b = ((Resources)localObject1).getColor(2131167072);
    setBackgroundColor(((Resources)localObject1).getColor(2131167077));
    Object localObject2 = findViewById(2131378935);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167129));
    }
    localObject2 = findViewById(2131378936);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167129));
    }
    localObject2 = findViewById(2131370140);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167128));
    }
    localObject2 = findViewById(2131370120);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167128));
    }
    this.jdField_a_of_type_Aqul = paramaqul;
    this.c = this.jdField_a_of_type_Aqul.a();
    if ((this.c <= 0) || (this.c > 3)) {
      throw new RuntimeException("Unsupportted column count " + this.c);
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView = new WheelView[this.c];
    this.jdField_a_of_type_ArrayOfAquj = new aquj[this.c];
    paramaqul = (WheelView)findViewById(2131365423);
    localObject1 = (WheelView)findViewById(2131368357);
    localObject2 = (WheelView)findViewById(2131371470);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131378933));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378961));
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new aquf(this));
    }
    a(paramaqul, 0);
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
  
  public void setPickListener(aquk paramaquk)
  {
    this.jdField_a_of_type_Aquk = paramaquk;
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