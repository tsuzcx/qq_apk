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
    int i;
    if (this.a.b != 0) {
      i = 1;
    } else {
      i = 0;
    }
    return j + i;
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
    Object localObject;
    if (getItemViewType(paramInt) == 0)
    {
      localView = paramView;
      if (paramView == null)
      {
        localView = this.a.getLayoutInflater().inflate(2131561012, null);
        localView.setOnClickListener(this.a);
        paramView = new SearchResultActivity.ItemViewHolder();
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368066));
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371876));
        paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377592));
        paramView.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView = ((InterestLabelTextView)localView.findViewById(2131367601));
        paramView.c = ((InterestLabelTextView)localView.findViewById(2131381296));
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView = ((InterestLabelTextView)localView.findViewById(2131364353));
        paramView.d = ((InterestLabelTextView)localView.findViewById(2131370414));
        localView.setTag(paramView);
      }
      paramView = (SearchResultActivity.ItemViewHolder)localView.getTag();
      localObject = (CondFitUser)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
      localObject = this.a.a(paramView, (CondFitUser)localObject);
      paramView = localView;
      if (SearchResultActivity.jdField_a_of_type_Boolean)
      {
        localView.setContentDescription((CharSequence)localObject);
        paramView = localView;
      }
    }
    else
    {
      localView = paramView;
      if (paramView == null)
      {
        localView = this.a.getLayoutInflater().inflate(2131559469, null);
        localView.setOnClickListener(this.a);
        paramView = new SearchResultActivity.MoreViewHolder();
        localView.setTag(paramView);
        paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131376345));
        localView.findViewById(2131370354).setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371517));
      }
      if (this.a.b == 1)
      {
        paramView = this.a;
        paramView.b = 2;
        SearchResultActivity.d(paramView);
      }
      localObject = (SearchResultActivity.MoreViewHolder)localView.getTag();
      if (this.a.b == 3)
      {
        ((SearchResultActivity.MoreViewHolder)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        ((SearchResultActivity.MoreViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713576));
        paramView = localView;
      }
      else if (this.a.b == 2)
      {
        ((SearchResultActivity.MoreViewHolder)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        ((SearchResultActivity.MoreViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713567));
        paramView = localView;
      }
      else
      {
        paramView = localView;
        if (this.a.b == 4)
        {
          ((SearchResultActivity.MoreViewHolder)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          ((SearchResultActivity.MoreViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713566));
          paramView = localView;
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.SearchResultActivity.DataAdapter
 * JD-Core Version:    0.7.0.1
 */