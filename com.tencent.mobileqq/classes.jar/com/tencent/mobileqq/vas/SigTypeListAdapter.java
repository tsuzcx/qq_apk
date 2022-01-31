package com.tencent.mobileqq.vas;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SigTypeListAdapter
  extends BaseAdapter
{
  public int a;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  SignatureTemplateConfig.SignatureTemplateType[] jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType;
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType == null) {
      return 0;
    }
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.length;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType == null) || (this.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.length <= paramInt)) {
      return null;
    }
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130971590, null);
      paramView = new SigTypeListAdapter.Holder(this);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131375162));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131375163);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType[paramInt].a);
      if (paramInt != this.jdField_a_of_type_Int) {
        break;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#1fbaf3"));
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return localView;
      paramViewGroup = (SigTypeListAdapter.Holder)paramView.getTag();
      localView = paramView;
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
    paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.vas.SigTypeListAdapter
 * JD-Core Version:    0.7.0.1
 */