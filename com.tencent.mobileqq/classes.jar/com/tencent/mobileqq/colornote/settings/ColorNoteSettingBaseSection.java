package com.tencent.mobileqq.colornote.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import aqqb;
import aqqh;
import com.tencent.mobileqq.widget.FormSimpleItem;
import java.util.Iterator;
import java.util.List;

public class ColorNoteSettingBaseSection
  extends LinearLayout
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private aqqb jdField_a_of_type_Aqqb;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  
  public ColorNoteSettingBaseSection(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public ColorNoteSettingBaseSection(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public ColorNoteSettingBaseSection(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    inflate(getContext(), 2131558953, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131377264));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363432));
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    Iterator localIterator = this.jdField_a_of_type_Aqqb.a(getContext()).iterator();
    while (localIterator.hasNext())
    {
      HistoryFormItem localHistoryFormItem = (HistoryFormItem)localIterator.next();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localHistoryFormItem);
    }
  }
  
  public void setAdapter(aqqb paramaqqb)
  {
    this.jdField_a_of_type_Aqqb = paramaqqb;
    this.jdField_a_of_type_Aqqb.a(new aqqh(this));
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(paramCharSequence);
  }
  
  public void setHeaderOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(paramOnClickListener);
  }
  
  public void setHeaderTitle(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.ColorNoteSettingBaseSection
 * JD-Core Version:    0.7.0.1
 */