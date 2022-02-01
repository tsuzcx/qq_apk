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
import bbeg;
import bbeh;
import bbei;
import bbej;
import bbek;
import bbel;
import bbem;
import bkzi;
import blge;
import blgg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

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
  private bbel jdField_a_of_type_Bbel;
  private bbem jdField_a_of_type_Bbem;
  private bkzi jdField_a_of_type_Bkzi;
  private blge jdField_a_of_type_Blge = new bbek(this);
  private blgg jdField_a_of_type_Blgg = new bbej(this);
  private AdapterView.OnItemSelectedListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener = new bbei(this);
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
    if (this.jdField_a_of_type_Bbel != null)
    {
      int j = this.jdField_a_of_type_ArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        this.jdField_a_of_type_ArrayOfInt[i] = this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[i].getSelectedItemPosition();
        i += 1;
      }
      this.jdField_b_of_type_Long = this.jdField_a_of_type_Bbel.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView, this.jdField_a_of_type_ArrayOfInt);
    }
    if (this.jdField_a_of_type_Bbem != null) {
      this.jdField_a_of_type_Bbem.a(this.jdField_b_of_type_Long);
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
  
  public void a(Context paramContext, bkzi parambkzi, bbem parambbem, View.OnClickListener paramOnClickListener, BaseAdapter[] paramArrayOfBaseAdapter, int[] paramArrayOfInt, bbel parambbel)
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
    this.jdField_a_of_type_Bkzi = parambkzi;
    this.jdField_a_of_type_Bbem = parambbem;
    this.jdField_a_of_type_ArrayOfAndroidWidgetBaseAdapter = paramArrayOfBaseAdapter;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    int k = paramArrayOfBaseAdapter.length;
    int j = paramArrayOfInt.length;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView = new WheelView[k];
    this.jdField_a_of_type_Bbel = parambbel;
    int i = 0;
    while (i < k)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[i] = new WheelView(this.jdField_a_of_type_AndroidContentContext);
      i += 1;
    }
    parambkzi = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_Int = parambkzi.getColor(2131167116);
    this.jdField_b_of_type_Int = parambkzi.getColor(2131167072);
    this.jdField_a_of_type_ArrayOfJavaLangString = bbeg.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_b_of_type_ArrayOfJavaLangString = bbeg.jdField_b_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131368994);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131368993));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377313));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131378933));
    i = parambkzi.getColor(2131167129);
    findViewById(2131368992).setBackgroundColor(i);
    findViewById(2131368991).setBackgroundColor(i);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(parambkzi.getColor(2131167077));
    i = parambkzi.getColor(2131167128);
    findViewById(2131370140).setBackgroundColor(i);
    findViewById(2131370120).setBackgroundColor(i);
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
        QLog.d(jdField_a_of_type_JavaLangString, 2, "createTimePicker Time :" + bbeg.a(this.jdField_a_of_type_Long));
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
        paramContext.setOnItemSelectedListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener);
        paramContext.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_Blgg);
        paramContext.setOnEndFlingListener(this.jdField_a_of_type_Blge);
        i += 1;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bbeh(this));
      break;
      label514:
      i = 0;
      if (i < k)
      {
        parambbem = this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[i];
        if (i == 0) {}
        for (paramContext = new LinearLayout.LayoutParams(parambkzi.getDimensionPixelSize(2131299071), -1);; paramContext = new LinearLayout.LayoutParams(parambkzi.getDimensionPixelSize(2131299073), -1))
        {
          paramContext.setMargins(0, parambkzi.getDimensionPixelSize(2131299076), 0, parambkzi.getDimensionPixelSize(2131299074));
          parambbem.setLayoutParams(paramContext);
          if (i != 0)
          {
            parambbem.setScrollCycle(true);
            parambbem.setmMaxRotationAngle(80);
            parambbem.setmMaxSkew(0.1F);
            parambbem.setNeedTranslate(true);
          }
          i += 1;
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "createTimePicker Time :" + bbeg.a(this.jdField_a_of_type_Long));
      }
    }
    a();
  }
  
  public void setFormatDataListener(bbel parambbel)
  {
    this.jdField_a_of_type_Bbel = parambbel;
  }
  
  public void setMaxDays(int paramInt)
  {
    bbeg.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setMaxDays days = " + bbeg.jdField_a_of_type_Int);
    }
  }
  
  public void setOnTimePickerSelectListener(bbem parambbem)
  {
    this.jdField_a_of_type_Bbem = parambbem;
  }
  
  public void setTips(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.remind.widget.IosTimepicker
 * JD-Core Version:    0.7.0.1
 */