package com.tencent.mobileqq.conditionsearch;

import SummaryCard.CondFitUser;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.InterestLabelTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class SearchResultActivity$DataAdapter
  extends BaseAdapter
{
  private SearchResultActivity$DataAdapter(SearchResultActivity paramSearchResultActivity) {}
  
  public int getCount()
  {
    int j = this.a.jdField_a_of_type_JavaUtilList.size();
    if (this.a.b != 0) {}
    for (int i = 1;; i = 0) {
      return i + j;
    }
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.a.jdField_a_of_type_JavaUtilList.size()) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (getItemViewType(paramInt) == 0)
    {
      localView = paramView;
      if (paramView == null)
      {
        localView = this.a.getLayoutInflater().inflate(2131561149, null);
        localView.setOnClickListener(this.a);
        paramView = new SearchResultActivity.ItemViewHolder();
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368314));
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131372287));
        paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378168));
        paramView.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView = ((InterestLabelTextView)localView.findViewById(2131367834));
        paramView.c = ((InterestLabelTextView)localView.findViewById(2131382094));
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView = ((InterestLabelTextView)localView.findViewById(2131364463));
        paramView.d = ((InterestLabelTextView)localView.findViewById(2131370780));
        localView.setTag(paramView);
      }
      paramView = (SearchResultActivity.ItemViewHolder)localView.getTag();
      CondFitUser localCondFitUser = (CondFitUser)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramView = this.a.a(paramView, localCondFitUser);
      if (SearchResultActivity.jdField_a_of_type_Boolean) {
        localView.setContentDescription(paramView);
      }
      paramView = localView;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localView = paramView;
      if (paramView == null)
      {
        localView = this.a.getLayoutInflater().inflate(2131559592, null);
        localView.setOnClickListener(this.a);
        paramView = new SearchResultActivity.MoreViewHolder();
        localView.setTag(paramView);
        paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131376854));
        localView.findViewById(2131370717).setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371896));
      }
      if (this.a.b == 1)
      {
        this.a.b = 2;
        SearchResultActivity.d(this.a);
      }
      paramView = (SearchResultActivity.MoreViewHolder)localView.getTag();
      if (this.a.b == 3)
      {
        paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713609));
        paramView = localView;
      }
      else if (this.a.b == 2)
      {
        paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713600));
        paramView = localView;
      }
      else
      {
        if (this.a.b == 4)
        {
          paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713599));
        }
        paramView = localView;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.SearchResultActivity.DataAdapter
 * JD-Core Version:    0.7.0.1
 */