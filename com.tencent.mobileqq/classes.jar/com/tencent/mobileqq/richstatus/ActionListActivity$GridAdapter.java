package com.tencent.mobileqq.richstatus;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class ActionListActivity$GridAdapter
  extends BaseAdapter
{
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  
  public ActionListActivity$GridAdapter(ArrayList<Integer> paramArrayList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilArrayList = localObject;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ActionListActivity.ActionViewHolder localActionViewHolder;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity.getLayoutInflater().inflate(2131563051, paramViewGroup, false);
      localActionViewHolder = new ActionListActivity.ActionViewHolder(null);
      localActionViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131378628));
      localActionViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378629));
      paramView.setTag(localActionViewHolder);
    }
    for (;;)
    {
      localActionViewHolder = (ActionListActivity.ActionViewHolder)paramView.getTag();
      ActionInfo localActionInfo = ActionListActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity).a(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).intValue());
      if ((localActionInfo != null) && (localActionViewHolder.jdField_a_of_type_Int != localActionInfo.jdField_a_of_type_Int))
      {
        localActionViewHolder.jdField_a_of_type_Int = localActionInfo.jdField_a_of_type_Int;
        localActionViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new StatableBitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity.getResources(), ActionListActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity).a(localActionInfo.jdField_a_of_type_Int, 201), false, false));
        localActionViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localActionInfo.c);
        if (localActionInfo.b != 1) {
          break label226;
        }
        localActionViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      }
      for (;;)
      {
        paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label226:
        localActionViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity.getResources().getDrawable(2130839414), null);
        localActionViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.ActionListActivity.GridAdapter
 * JD-Core Version:    0.7.0.1
 */