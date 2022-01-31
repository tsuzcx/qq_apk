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
import avqn;
import avqo;
import avqp;
import avqq;
import avqr;
import avqs;
import avqt;
import bfpc;
import bfpv;
import bfxa;
import bfxc;
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
  private avqs jdField_a_of_type_Avqs;
  private avqt jdField_a_of_type_Avqt;
  private bfpc jdField_a_of_type_Bfpc;
  private bfpv jdField_a_of_type_Bfpv = new avqp(this);
  private bfxa jdField_a_of_type_Bfxa = new avqr(this);
  private bfxc jdField_a_of_type_Bfxc = new avqq(this);
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
    if (this.jdField_a_of_type_Avqs != null)
    {
      int j = this.jdField_a_of_type_ArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        this.jdField_a_of_type_ArrayOfInt[i] = this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[i].getSelectedItemPosition();
        i += 1;
      }
      this.jdField_b_of_type_Long = this.jdField_a_of_type_Avqs.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView, this.jdField_a_of_type_ArrayOfInt);
    }
    if (this.jdField_a_of_type_Avqt != null) {
      this.jdField_a_of_type_Avqt.a(this.jdField_b_of_type_Long);
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
  
  public void a(Context paramContext, bfpc parambfpc, avqt paramavqt, View.OnClickListener paramOnClickListener, BaseAdapter[] paramArrayOfBaseAdapter, int[] paramArrayOfInt, avqs paramavqs)
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
    this.jdField_a_of_type_Bfpc = parambfpc;
    this.jdField_a_of_type_Avqt = paramavqt;
    this.jdField_a_of_type_ArrayOfAndroidWidgetBaseAdapter = paramArrayOfBaseAdapter;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    int k = paramArrayOfBaseAdapter.length;
    int j = paramArrayOfInt.length;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView = new WheelView[k];
    this.jdField_a_of_type_Avqs = paramavqs;
    int i = 0;
    while (i < k)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[i] = new WheelView(this.jdField_a_of_type_AndroidContentContext);
      i += 1;
    }
    parambfpc = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_Int = parambfpc.getColor(2131166937);
    this.jdField_b_of_type_Int = parambfpc.getColor(2131166898);
    this.jdField_a_of_type_ArrayOfJavaLangString = avqn.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_b_of_type_ArrayOfJavaLangString = avqn.jdField_b_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131368279);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131368278));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375809));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131377286));
    i = parambfpc.getColor(2131166950);
    findViewById(2131368277).setBackgroundColor(i);
    findViewById(2131368276).setBackgroundColor(i);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(parambfpc.getColor(2131166903));
    i = parambfpc.getColor(2131166949);
    findViewById(2131369233).setBackgroundColor(i);
    findViewById(2131369211).setBackgroundColor(i);
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
        QLog.d(jdField_a_of_type_JavaLangString, 2, "createTimePicker Time :" + avqn.a(this.jdField_a_of_type_Long));
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
        paramContext.setOnItemSelectedListener(this.jdField_a_of_type_Bfpv);
        paramContext.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_Bfxc);
        paramContext.setOnEndFlingListener(this.jdField_a_of_type_Bfxa);
        i += 1;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new avqo(this));
      break;
      label514:
      i = 0;
      if (i < k)
      {
        paramavqt = this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[i];
        if (i == 0) {}
        for (paramContext = new LinearLayout.LayoutParams(parambfpc.getDimensionPixelSize(2131298856), -1);; paramContext = new LinearLayout.LayoutParams(parambfpc.getDimensionPixelSize(2131298858), -1))
        {
          paramContext.setMargins(0, parambfpc.getDimensionPixelSize(2131298861), 0, parambfpc.getDimensionPixelSize(2131298859));
          paramavqt.setLayoutParams(paramContext);
          if (i != 0)
          {
            paramavqt.setScrollCycle(true);
            paramavqt.setmMaxRotationAngle(80);
            paramavqt.setmMaxSkew(0.1F);
            paramavqt.setNeedTranslate(true);
          }
          i += 1;
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "createTimePicker Time :" + avqn.a(this.jdField_a_of_type_Long));
      }
    }
    a();
  }
  
  public void setFormatDataListener(avqs paramavqs)
  {
    this.jdField_a_of_type_Avqs = paramavqs;
  }
  
  public void setMaxDays(int paramInt)
  {
    avqn.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setMaxDays days = " + avqn.jdField_a_of_type_Int);
    }
  }
  
  public void setOnTimePickerSelectListener(avqt paramavqt)
  {
    this.jdField_a_of_type_Avqt = paramavqt;
  }
  
  public void setTips(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.remind.widget.IosTimepicker
 * JD-Core Version:    0.7.0.1
 */