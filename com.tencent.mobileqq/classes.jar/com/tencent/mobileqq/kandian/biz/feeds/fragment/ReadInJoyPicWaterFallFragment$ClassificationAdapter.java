package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.report.DistinctEventReporter;
import java.util.ArrayList;

class ReadInJoyPicWaterFallFragment$ClassificationAdapter
  extends BaseAdapter
{
  private ReadInJoyPicWaterFallFragment$ClassificationAdapter(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public ReadInJoyPicWaterFallFragment.ClassData a(int paramInt)
  {
    return (ReadInJoyPicWaterFallFragment.ClassData)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.a.a()).inflate(2131562696, paramViewGroup, false);
      localView.setOnClickListener(new ReadInJoyPicWaterFallFragment.ClassificationAdapter.1(this));
    }
    paramView = (ReadInJoyPicWaterFallFragment.ClassData)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    localView.setTag(Integer.valueOf(paramInt));
    ((TextView)localView).setText(paramView.a());
    this.a.jdField_a_of_type_ComTencentMobileqqKandianBaseReportDistinctEventReporter.trigger("exp_subchannel", paramView);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.ClassificationAdapter
 * JD-Core Version:    0.7.0.1
 */