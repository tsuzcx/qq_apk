package com.tencent.mobileqq.businessCard.utilities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.businessCard.activity.BusinessCardListActivity;

class BusinessCardGroupLogic$BusinessCardGroupAdapter
  extends BaseAdapter
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  String[] jdField_a_of_type_ArrayOfJavaLangString = { "按时间排序", "按姓名排序" };
  
  public BusinessCardGroupLogic$BusinessCardGroupAdapter(BusinessCardGroupLogic paramBusinessCardGroupLogic, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString.length;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString[paramInt];
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
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970268, paramViewGroup, false);
      paramView = new BusinessCardGroupLogic.BusinessCardGroupAdapter.ViewHolder(this);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363866));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131368698);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardUtilitiesBusinessCardGroupLogic.a.a != paramInt) {
        break;
      }
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return localView;
      paramViewGroup = (BusinessCardGroupLogic.BusinessCardGroupAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
    }
    paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.utilities.BusinessCardGroupLogic.BusinessCardGroupAdapter
 * JD-Core Version:    0.7.0.1
 */