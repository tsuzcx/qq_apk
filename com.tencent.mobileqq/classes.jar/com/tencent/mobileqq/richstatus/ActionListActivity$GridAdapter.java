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
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
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
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity.getLayoutInflater().inflate(2131562875, paramViewGroup, false);
      paramView = new ActionListActivity.ActionViewHolder(null);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131378021));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378022));
      localView.setTag(paramView);
    }
    paramView = (ActionListActivity.ActionViewHolder)localView.getTag();
    ActionInfo localActionInfo = ActionListActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity).a(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).intValue());
    if ((localActionInfo != null) && (paramView.jdField_a_of_type_Int != localActionInfo.jdField_a_of_type_Int))
    {
      paramView.jdField_a_of_type_Int = localActionInfo.jdField_a_of_type_Int;
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new StatableBitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity.getResources(), ActionListActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity).a(localActionInfo.jdField_a_of_type_Int, 201), false, false));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localActionInfo.c);
      if (localActionInfo.b == 1)
      {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      }
      else
      {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity.getResources().getDrawable(2130839270), null);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      }
    }
    localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.ActionListActivity.GridAdapter
 * JD-Core Version:    0.7.0.1
 */