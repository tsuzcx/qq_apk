package com.tencent.mobileqq.colornote.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.widget.QFormSimpleItem;
import java.util.Iterator;
import java.util.List;

public class ColorNoteSettingBaseSection
  extends LinearLayout
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private BaseSectionAdapter jdField_a_of_type_ComTencentMobileqqColornoteSettingsBaseSectionAdapter;
  private QFormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem;
  
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
    inflate(getContext(), 2131558889, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem = ((QFormSimpleItem)findViewById(2131377121));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363444));
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsBaseSectionAdapter.a(getContext()).iterator();
    while (localIterator.hasNext())
    {
      HistoryFormItem localHistoryFormItem = (HistoryFormItem)localIterator.next();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localHistoryFormItem);
    }
  }
  
  public void setAdapter(BaseSectionAdapter paramBaseSectionAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsBaseSectionAdapter = paramBaseSectionAdapter;
    this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsBaseSectionAdapter.a(new ColorNoteSettingBaseSection.1(this));
  }
  
  public void setBgType(int paramInt)
  {
    QFormSimpleItem localQFormSimpleItem = this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem;
    if (localQFormSimpleItem != null) {
      localQFormSimpleItem.setBgType(paramInt);
    }
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setContentDescription(paramCharSequence);
  }
  
  public void setHeaderOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setOnClickListener(paramOnClickListener);
  }
  
  public void setHeaderTitle(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setLeftText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.ColorNoteSettingBaseSection
 * JD-Core Version:    0.7.0.1
 */