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
  ReadInJoyDailySettingPopupWindow a;
  private List<ReadInJoyDailySettingModel> b = new ArrayList();
  private List<ReadInJoyDailySettingModel> c = new ArrayList();
  private Context d;
  
  public ReadInJoyDailySettingAdapter(Context paramContext, List<ReadInJoyDailySettingModel> paramList1, List<ReadInJoyDailySettingModel> paramList2)
  {
    this.b = paramList1;
    this.c = paramList2;
    this.d = paramContext;
  }
  
  private void a(int paramInt, ReadInJoyDailySettingModel paramReadInJoyDailySettingModel)
  {
    if (paramInt == 0) {
      RIJSPUtils.a("readinjoy_show_recommend_reason_in_title_b", paramReadInJoyDailySettingModel.c);
    }
  }
  
  public int getItemCount()
  {
    List localList = this.b;
    int j = 0;
    int i;
    if (localList != null) {
      i = localList.size();
    } else {
      i = 0;
    }
    localList = this.c;
    if (localList != null) {
      j = localList.size();
    }
    return i + 0 + j;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.c.size()) {
      return 0;
    }
    return 1;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ReadInJoyDailySettingAdapter.DailySettingViewHolder localDailySettingViewHolder = (ReadInJoyDailySettingAdapter.DailySettingViewHolder)paramViewHolder;
    if (paramInt >= this.c.size())
    {
      paramInt -= this.c.size();
      paramViewHolder = (ReadInJoyDailySettingModel)this.b.get(paramInt);
      localDailySettingViewHolder.c.setVisibility(8);
    }
    else
    {
      paramViewHolder = (ReadInJoyDailySettingModel)this.c.get(paramInt);
      localDailySettingViewHolder.c.setVisibility(0);
    }
    localDailySettingViewHolder.a.setText(paramViewHolder.b);
    localDailySettingViewHolder.b.setText(paramViewHolder.d);
    localDailySettingViewHolder.itemView.setOnClickListener(new ReadInJoyDailySettingAdapter.1(this, localDailySettingViewHolder, paramViewHolder, paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new ReadInJoyDailySettingAdapter.DailySettingViewHolder(this, View.inflate(this.d, 2131626266, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailySettingAdapter
 * JD-Core Version:    0.7.0.1
 */