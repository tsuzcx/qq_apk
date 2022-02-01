package com.tencent.mobileqq.kandian.biz.feeds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.repo.feeds.CityData;
import java.util.ArrayList;
import java.util.List;

public class SelectCityAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList<CityData> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public SelectCityAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt, SelectCityAdapter.ViewHolder paramViewHolder)
  {
    String str;
    if (((CityData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 2) {
      str = ((CityData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b;
    } else if (((CityData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 1) {
      str = ((CityData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString;
    } else {
      str = "";
    }
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(str);
  }
  
  public void a(List<CityData> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
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
    if ((paramView != null) && (((SelectCityAdapter.ViewHolder)paramView.getTag()).jdField_a_of_type_Int == ((CityData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int))
    {
      paramViewGroup = (SelectCityAdapter.ViewHolder)paramView.getTag();
    }
    else
    {
      SelectCityAdapter.ViewHolder localViewHolder = new SelectCityAdapter.ViewHolder(this, null);
      localViewHolder.jdField_a_of_type_Int = ((CityData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
      if (((CityData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 2)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560275, paramViewGroup, false);
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364647));
      }
      else
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560278, paramViewGroup, false);
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368755));
      }
      paramView.setTag(localViewHolder);
      paramViewGroup = localViewHolder;
    }
    a(paramInt, paramViewGroup);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.SelectCityAdapter
 * JD-Core Version:    0.7.0.1
 */