package com.tencent.mobileqq.kandian.biz.daily;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoyDailyConfigAdapter
  extends RecyclerView.Adapter
{
  private List<String> a = new ArrayList();
  private List<String> b = new ArrayList();
  private Context c;
  private ReadInJoyDailySettingPopupWindow.Callback d;
  
  public ReadInJoyDailyConfigAdapter(Context paramContext, List<String> paramList1, List<String> paramList2, ReadInJoyDailySettingPopupWindow.Callback paramCallback)
  {
    this.b = paramList1;
    this.a = paramList2;
    this.c = paramContext;
    this.d = paramCallback;
  }
  
  public int getItemCount()
  {
    List localList = this.b;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof ReadInJoyDailyConfigAdapter.DailyConfigViewHolder))
    {
      paramViewHolder = (ReadInJoyDailyConfigAdapter.DailyConfigViewHolder)paramViewHolder;
      if ((paramInt >= 0) && (paramInt < this.b.size()))
      {
        String str1 = (String)this.b.get(paramInt);
        String str2 = (String)this.a.get(paramInt);
        paramViewHolder.a.setText(str1);
        paramViewHolder.a.setOnClickListener(new ReadInJoyDailyConfigAdapter.1(this, str2, str1));
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new ReadInJoyDailyConfigAdapter.DailyConfigViewHolder(this, View.inflate(this.c, 2131626208, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyConfigAdapter
 * JD-Core Version:    0.7.0.1
 */