package com.tencent.mobileqq.remind.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import axil;
import axim;
import axin;
import axio;
import axip;
import axiq;
import axir;
import bhpy;
import bhqr;
import bhxx;
import bhxz;
import com.tencent.qphone.base.util.QLog;

public class IosTimepicker
  extends LinearLayout
{
  private static String jdField_a_of_type_JavaLangString = "remind";
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private axiq jdField_a_of_type_Axiq;
  private axir jdField_a_of_type_Axir;
  private bhpy jdField_a_of_type_Bhpy;
  private bhqr jdField_a_of_type_Bhqr = new axin(this);
  private bhxx jdField_a_of_type_Bhxx = new axip(this);
  private bhxz jdField_a_of_type_Bhxz = new axio(this);
  private int[] jdField_a_of_type_ArrayOfInt;
  private BaseAdapter[] jdField_a_of_type_ArrayOfAndroidWidgetBaseAdapter;
  private WheelView[] jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String[] jdField_b_of_type_ArrayOfJavaLangString;
  
  public IosTimepicker(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public IosTimepicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  @TargetApi(11)
  public IosTimepicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Axiq != null)
    {
      int j = this.jdField_a_of_type_ArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        this.jdField_a_of_type_ArrayOfInt[i] = this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[i].getSelectedItemPosition();
        i += 1;
      }
      this.jdField_b_of_type_Long = this.jdField_a_of_type_Axiq.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView, this.jdField_a_of_type_ArrayOfInt);
    }
    if (this.jdField_a_of_type_Axir != null) {
      this.jdField_a_of_type_Axir.a(this.jdField_b_of_type_Long);
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    if ((paramView instanceof WheelTextView))
    {
      if (paramInt == 0)
      {
        ((WheelTextView)paramView).setTextSize(20.0F);
        ((WheelTextView)paramView).setTextColor(this.jdField_a_of_type_Int);
      }
    }
    else {
      return;
    }
    ((WheelTextView)paramView).setTextSize(20.0F);
    ((WheelTextView)paramView).setTextColor(this.jdField_b_of_type_Int);
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void a(Context paramContext, bhpy parambhpy, axir paramaxir, View.OnClickListener paramOnClickListener, BaseAdapter[] paramArrayOfBaseAdapter, int[] paramArrayOfInt, axiq paramaxiq)
  {
    if ((paramArrayOfBaseAdapter == null) || (paramArrayOfBaseAdapter.length == 0) || (paramArrayOfBaseAdapter.length > 3)) {
      throw new IllegalArgumentException("adapters is null or empty, or its length is larger than 3");
    }
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      throw new IllegalArgumentException("selectionPos is null or empty, or its length is larger than 3");
    }
    if (paramArrayOfInt.length != paramArrayOfBaseAdapter.length) {
      throw new IllegalArgumentException("selectionPos.length is not equal to adapters.length");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bhpy = parambhpy;
    this.jdField_a_of_type_Axir = paramaxir;
    this.jdField_a_of_type_ArrayOfAndroidWidgetBaseAdapter = paramArrayOfBaseAdapter;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    int k = paramArrayOfBaseAdapter.length;
    int j = paramArrayOfInt.length;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView = new WheelView[k];
    this.jdField_a_of_type_Axiq = paramaxiq;
    int i = 0;
    while (i < k)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[i] = new WheelView(this.jdField_a_of_type_AndroidContentContext);
      i += 1;
    }
    parambhpy = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_Int = parambhpy.getColor(2131166985);
    this.jdField_b_of_type_Int = parambhpy.getColor(2131166945);
    this.jdField_a_of_type_ArrayOfJavaLangString = axil.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_b_of_type_ArrayOfJavaLangString = axil.jdField_b_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131368425);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131368424));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376307));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131377815));
    i = parambhpy.getColor(2131166998);
    findViewById(2131368423).setBackgroundColor(i);
    findViewById(2131368422).setBackgroundColor(i);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(parambhpy.getColor(2131166950));
    i = parambhpy.getColor(2131166997);
    findViewById(2131369466).setBackgroundColor(i);
    findViewById(2131369444).setBackgroundColor(i);
    if (paramOnClickListener != null)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
      if (k != 1) {
        break label514;
      }
      paramContext = new LinearLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[0].setLayoutParams(paramContext);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[0].setAdapter(this.jdField_a_of_type_ArrayOfAndroidWidgetBaseAdapter[0]);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "createTimePicker Time :" + axil.a(this.jdField_a_of_type_Long));
      }
    }
    for (;;)
    {
      i = 0;
      while (i < j)
      {
        paramContext = this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[i];
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramContext);
        paramContext.setAdapter(this.jdField_a_of_type_ArrayOfAndroidWidgetBaseAdapter[i]);
        paramContext.setSelection(this.jdField_a_of_type_ArrayOfInt[i], true);
        paramContext.setOnItemSelectedListener(this.jdField_a_of_type_Bhqr);
        paramContext.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_Bhxz);
        paramContext.setOnEndFlingListener(this.jdField_a_of_type_Bhxx);
        i += 1;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new axim(this));
      break;
      label514:
      i = 0;
      if (i < k)
      {
        paramaxir = this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[i];
        if (i == 0) {}
        for (paramContext = new LinearLayout.LayoutParams(parambhpy.getDimensionPixelSize(2131298905), -1);; paramContext = new LinearLayout.LayoutParams(parambhpy.getDimensionPixelSize(2131298907), -1))
        {
          paramContext.setMargins(0, parambhpy.getDimensionPixelSize(2131298910), 0, parambhpy.getDimensionPixelSize(2131298908));
          paramaxir.setLayoutParams(paramContext);
          if (i != 0)
          {
            paramaxir.setScrollCycle(true);
            paramaxir.setmMaxRotationAngle(80);
            paramaxir.setmMaxSkew(0.1F);
            paramaxir.setNeedTranslate(true);
          }
          i += 1;
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "createTimePicker Time :" + axil.a(this.jdField_a_of_type_Long));
      }
    }
    a();
  }
  
  public void setFormatDataListener(axiq paramaxiq)
  {
    this.jdField_a_of_type_Axiq = paramaxiq;
  }
  
  public void setMaxDays(int paramInt)
  {
    axil.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setMaxDays days = " + axil.jdField_a_of_type_Int);
    }
  }
  
  public void setOnTimePickerSelectListener(axir paramaxir)
  {
    this.jdField_a_of_type_Axir = paramaxir;
  }
  
  public void setTips(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.remind.widget.IosTimepicker
 * JD-Core Version:    0.7.0.1
 */