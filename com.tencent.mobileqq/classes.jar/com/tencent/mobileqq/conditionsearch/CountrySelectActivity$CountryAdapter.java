package com.tencent.mobileqq.conditionsearch;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.widget.PinnedDividerListView.DividerAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class CountrySelectActivity$CountryAdapter
  extends PinnedDividerListView.DividerAdapter
{
  private CountrySelectActivity$CountryAdapter(CountrySelectActivity paramCountrySelectActivity) {}
  
  public int a()
  {
    return 2131559545;
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = (TextView)paramView;
    Object localObject = getItem(paramInt);
    if ((localObject instanceof CountrySelectActivity.DividerItem))
    {
      paramView.setText(((CountrySelectActivity.DividerItem)localObject).jdField_a_of_type_JavaLangString);
      return;
    }
    if ((localObject instanceof BaseAddress)) {
      paramView.setText(((BaseAddress)localObject).pinyinFirst);
    }
  }
  
  public boolean a(int paramInt)
  {
    return getItemViewType(paramInt) == 0;
  }
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.a.jdField_a_of_type_JavaUtilList.get(paramInt) instanceof CountrySelectActivity.DividerItem)) {
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
      if (paramView == null) {
        localView = this.a.getLayoutInflater().inflate(a(), null);
      }
      ((TextView)localView).setText(((CountrySelectActivity.DividerItem)getItem(paramInt)).jdField_a_of_type_JavaLangString);
      paramView = localView;
    }
    else
    {
      localView = paramView;
      if (paramView == null)
      {
        localView = this.a.getLayoutInflater().inflate(2131559546, null);
        paramView = new CountrySelectActivity.ViewHolder(null);
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365275));
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131364607));
        localView.findViewById(2131365274).setVisibility(8);
        localView.setTag(paramView);
        localView.setOnClickListener(this.a);
      }
      CountrySelectActivity.ViewHolder localViewHolder = (CountrySelectActivity.ViewHolder)localView.getTag();
      BaseAddress localBaseAddress = (BaseAddress)getItem(paramInt);
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localBaseAddress.name);
      if ((!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_JavaLangString.equals(localBaseAddress.code))) {
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      localViewHolder.jdField_a_of_type_JavaLangString = localBaseAddress.code;
      paramView = localView;
      if (CountrySelectActivity.jdField_a_of_type_Boolean) {
        if (localViewHolder.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)
        {
          paramView = new StringBuilder();
          paramView.append(localBaseAddress.name);
          paramView.append(HardCodeUtil.a(2131702781));
          localView.setContentDescription(paramView.toString());
          paramView = localView;
        }
        else
        {
          localView.setContentDescription(localBaseAddress.name);
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
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.CountrySelectActivity.CountryAdapter
 * JD-Core Version:    0.7.0.1
 */