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
import bbdc;
import bbdd;
import bbde;
import bbdf;
import bbdg;
import bbdh;
import bbdi;
import blir;
import bljo;
import blqr;
import blqt;
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
  private bbdh jdField_a_of_type_Bbdh;
  private bbdi jdField_a_of_type_Bbdi;
  private blir jdField_a_of_type_Blir;
  private bljo jdField_a_of_type_Bljo = new bbde(this);
  private blqr jdField_a_of_type_Blqr = new bbdg(this);
  private blqt jdField_a_of_type_Blqt = new bbdf(this);
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
    if (this.jdField_a_of_type_Bbdh != null)
    {
      int j = this.jdField_a_of_type_ArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        this.jdField_a_of_type_ArrayOfInt[i] = this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[i].getSelectedItemPosition();
        i += 1;
      }
      this.jdField_b_of_type_Long = this.jdField_a_of_type_Bbdh.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView, this.jdField_a_of_type_ArrayOfInt);
    }
    if (this.jdField_a_of_type_Bbdi != null) {
      this.jdField_a_of_type_Bbdi.a(this.jdField_b_of_type_Long);
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
  
  public void a(Context paramContext, blir paramblir, bbdi parambbdi, View.OnClickListener paramOnClickListener, BaseAdapter[] paramArrayOfBaseAdapter, int[] paramArrayOfInt, bbdh parambbdh)
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
    this.jdField_a_of_type_Blir = paramblir;
    this.jdField_a_of_type_Bbdi = parambbdi;
    this.jdField_a_of_type_ArrayOfAndroidWidgetBaseAdapter = paramArrayOfBaseAdapter;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    int k = paramArrayOfBaseAdapter.length;
    int j = paramArrayOfInt.length;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView = new WheelView[k];
    this.jdField_a_of_type_Bbdh = parambbdh;
    int i = 0;
    while (i < k)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[i] = new WheelView(this.jdField_a_of_type_AndroidContentContext);
      i += 1;
    }
    paramblir = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_Int = paramblir.getColor(2131167080);
    this.jdField_b_of_type_Int = paramblir.getColor(2131167036);
    this.jdField_a_of_type_ArrayOfJavaLangString = bbdc.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_b_of_type_ArrayOfJavaLangString = bbdc.jdField_b_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131368811);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131368810));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377290));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131378869));
    i = paramblir.getColor(2131167093);
    findViewById(2131368809).setBackgroundColor(i);
    findViewById(2131368808).setBackgroundColor(i);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(paramblir.getColor(2131167041));
    i = paramblir.getColor(2131167092);
    findViewById(2131369976).setBackgroundColor(i);
    findViewById(2131369956).setBackgroundColor(i);
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
        QLog.d(jdField_a_of_type_JavaLangString, 2, "createTimePicker Time :" + bbdc.a(this.jdField_a_of_type_Long));
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
        paramContext.setOnItemSelectedListener(this.jdField_a_of_type_Bljo);
        paramContext.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_Blqt);
        paramContext.setOnEndFlingListener(this.jdField_a_of_type_Blqr);
        i += 1;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bbdd(this));
      break;
      label514:
      i = 0;
      if (i < k)
      {
        parambbdi = this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[i];
        if (i == 0) {}
        for (paramContext = new LinearLayout.LayoutParams(paramblir.getDimensionPixelSize(2131299002), -1);; paramContext = new LinearLayout.LayoutParams(paramblir.getDimensionPixelSize(2131299004), -1))
        {
          paramContext.setMargins(0, paramblir.getDimensionPixelSize(2131299007), 0, paramblir.getDimensionPixelSize(2131299005));
          parambbdi.setLayoutParams(paramContext);
          if (i != 0)
          {
            parambbdi.setScrollCycle(true);
            parambbdi.setmMaxRotationAngle(80);
            parambbdi.setmMaxSkew(0.1F);
            parambbdi.setNeedTranslate(true);
          }
          i += 1;
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "createTimePicker Time :" + bbdc.a(this.jdField_a_of_type_Long));
      }
    }
    a();
  }
  
  public void setFormatDataListener(bbdh parambbdh)
  {
    this.jdField_a_of_type_Bbdh = parambbdh;
  }
  
  public void setMaxDays(int paramInt)
  {
    bbdc.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setMaxDays days = " + bbdc.jdField_a_of_type_Int);
    }
  }
  
  public void setOnTimePickerSelectListener(bbdi parambbdi)
  {
    this.jdField_a_of_type_Bbdi = parambbdi;
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