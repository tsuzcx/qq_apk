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
import com.tencent.mobileqq.remind.TimeHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.VerticalGallery.OnEndFlingListener;
import com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener;

public class IosTimepicker
  extends LinearLayout
{
  private static String jdField_a_of_type_JavaLangString = "remind";
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView = null;
  private Button jdField_a_of_type_AndroidWidgetButton = null;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private IosTimepicker.FormatDataListener jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$FormatDataListener;
  private IosTimepicker.OnTimePickerSelectListener jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$OnTimePickerSelectListener;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private AdapterView.OnItemSelectedListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener = new IosTimepicker.2(this);
  private VerticalGallery.OnEndFlingListener jdField_a_of_type_ComTencentWidgetVerticalGallery$OnEndFlingListener = new IosTimepicker.4(this);
  private VerticalGallery.OnSelectViewDataUpdateListener jdField_a_of_type_ComTencentWidgetVerticalGallery$OnSelectViewDataUpdateListener = new IosTimepicker.3(this);
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
    if (this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$FormatDataListener != null)
    {
      int j = this.jdField_a_of_type_ArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        this.jdField_a_of_type_ArrayOfInt[i] = this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[i].getSelectedItemPosition();
        i += 1;
      }
      this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$FormatDataListener.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView, this.jdField_a_of_type_ArrayOfInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$OnTimePickerSelectListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$OnTimePickerSelectListener.a(this.jdField_b_of_type_Long);
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
  
  public void a(Context paramContext, ActionSheet paramActionSheet, IosTimepicker.OnTimePickerSelectListener paramOnTimePickerSelectListener, View.OnClickListener paramOnClickListener, BaseAdapter[] paramArrayOfBaseAdapter, int[] paramArrayOfInt, IosTimepicker.FormatDataListener paramFormatDataListener)
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
    this.jdField_a_of_type_ComTencentWidgetActionSheet = paramActionSheet;
    this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$OnTimePickerSelectListener = paramOnTimePickerSelectListener;
    this.jdField_a_of_type_ArrayOfAndroidWidgetBaseAdapter = paramArrayOfBaseAdapter;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    int k = paramArrayOfBaseAdapter.length;
    int j = paramArrayOfInt.length;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView = new WheelView[k];
    this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$FormatDataListener = paramFormatDataListener;
    int i = 0;
    while (i < k)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[i] = new WheelView(this.jdField_a_of_type_AndroidContentContext);
      i += 1;
    }
    paramActionSheet = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_Int = paramActionSheet.getColor(2131167123);
    this.jdField_b_of_type_Int = paramActionSheet.getColor(2131167079);
    this.jdField_a_of_type_ArrayOfJavaLangString = TimeHelper.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_b_of_type_ArrayOfJavaLangString = TimeHelper.jdField_b_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369226);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369225));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377734));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131379364));
    i = paramActionSheet.getColor(2131167136);
    findViewById(2131369224).setBackgroundColor(i);
    findViewById(2131369223).setBackgroundColor(i);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(paramActionSheet.getColor(2131167084));
    i = paramActionSheet.getColor(2131167135);
    findViewById(2131370411).setBackgroundColor(i);
    findViewById(2131370391).setBackgroundColor(i);
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
        QLog.d(jdField_a_of_type_JavaLangString, 2, "createTimePicker Time :" + TimeHelper.a(this.jdField_a_of_type_Long));
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
        paramContext.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_ComTencentWidgetVerticalGallery$OnSelectViewDataUpdateListener);
        paramContext.setOnEndFlingListener(this.jdField_a_of_type_ComTencentWidgetVerticalGallery$OnEndFlingListener);
        i += 1;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new IosTimepicker.1(this));
      break;
      label514:
      i = 0;
      if (i < k)
      {
        paramOnTimePickerSelectListener = this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[i];
        if (i == 0) {}
        for (paramContext = new LinearLayout.LayoutParams(paramActionSheet.getDimensionPixelSize(2131299157), -1);; paramContext = new LinearLayout.LayoutParams(paramActionSheet.getDimensionPixelSize(2131299159), -1))
        {
          paramContext.setMargins(0, paramActionSheet.getDimensionPixelSize(2131299162), 0, paramActionSheet.getDimensionPixelSize(2131299160));
          paramOnTimePickerSelectListener.setLayoutParams(paramContext);
          if (i != 0)
          {
            paramOnTimePickerSelectListener.setScrollCycle(true);
            paramOnTimePickerSelectListener.setmMaxRotationAngle(80);
            paramOnTimePickerSelectListener.setmMaxSkew(0.1F);
            paramOnTimePickerSelectListener.setNeedTranslate(true);
          }
          i += 1;
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "createTimePicker Time :" + TimeHelper.a(this.jdField_a_of_type_Long));
      }
    }
    a();
  }
  
  public void setFormatDataListener(IosTimepicker.FormatDataListener paramFormatDataListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$FormatDataListener = paramFormatDataListener;
  }
  
  public void setMaxDays(int paramInt)
  {
    TimeHelper.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setMaxDays days = " + TimeHelper.jdField_a_of_type_Int);
    }
  }
  
  public void setOnTimePickerSelectListener(IosTimepicker.OnTimePickerSelectListener paramOnTimePickerSelectListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$OnTimePickerSelectListener = paramOnTimePickerSelectListener;
  }
  
  public void setTips(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.remind.widget.IosTimepicker
 * JD-Core Version:    0.7.0.1
 */