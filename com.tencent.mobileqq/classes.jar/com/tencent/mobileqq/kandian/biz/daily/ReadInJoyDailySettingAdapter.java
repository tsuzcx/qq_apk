package com.tencent.mobileqq.kandian.biz.daily;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.daily.ReadInJoyDailySettingModel;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoyDailySettingAdapter
  extends RecyclerView.Adapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  ReadInJoyDailySettingPopupWindow jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailySettingPopupWindow;
  private List<ReadInJoyDailySettingModel> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<ReadInJoyDailySettingModel> b = new ArrayList();
  
  public ReadInJoyDailySettingAdapter(Context paramContext, List<ReadInJoyDailySettingModel> paramList1, List<ReadInJoyDailySettingModel> paramList2)
  {
    this.jdField_a_of_type_JavaUtilList = paramList1;
    this.b = paramList2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt, ReadInJoyDailySettingModel paramReadInJoyDailySettingModel)
  {
    if (paramInt == 0) {
      RIJSPUtils.a("readinjoy_show_recommend_reason_in_title_b", paramReadInJoyDailySettingModel.c);
    }
  }
  
  public int getItemCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    int j = 0;
    int i;
    if (localList != null) {
      i = localList.size();
    } else {
      i = 0;
    }
    localList = this.b;
    if (localList != null) {
      j = localList.size();
    }
    return i + 0 + j;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.b.size()) {
      return 0;
    }
    return 1;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ReadInJoyDailySettingAdapter.DailySettingViewHolder localDailySettingViewHolder = (ReadInJoyDailySettingAdapter.DailySettingViewHolder)paramViewHolder;
    if (paramInt >= this.b.size())
    {
      paramInt -= this.b.size();
      paramViewHolder = (ReadInJoyDailySettingModel)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localDailySettingViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    else
    {
      paramViewHolder = (ReadInJoyDailySettingModel)this.b.get(paramInt);
      localDailySettingViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    localDailySettingViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewHolder.b);
    localDailySettingViewHolder.b.setText(paramViewHolder.d);
    localDailySettingViewHolder.itemView.setOnClickListener(new ReadInJoyDailySettingAdapter.1(this, localDailySettingViewHolder, paramViewHolder, paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new ReadInJoyDailySettingAdapter.DailySettingViewHolder(this, View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131560219, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailySettingAdapter
 * JD-Core Version:    0.7.0.1
 */