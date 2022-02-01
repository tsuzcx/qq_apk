package com.tencent.mobileqq.guild.channel;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class QQGuildChannelChooseCategoryFragment$QQGuildChannelListAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private List<String> a = new ArrayList();
  private View.OnClickListener b;
  private String c;
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.b = paramOnClickListener;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
    super.notifyDataSetChanged();
  }
  
  public void a(List<String> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
    super.notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = (QQGuildChannelChooseCategoryFragment.ChannelInfoViewHolder)paramViewHolder;
    String str = (String)this.a.get(paramInt);
    if (TextUtils.isEmpty(str)) {
      ((QQGuildChannelChooseCategoryFragment.ChannelInfoViewHolder)localObject).a.setText(BaseApplication.getContext().getString(2131890325));
    } else {
      ((QQGuildChannelChooseCategoryFragment.ChannelInfoViewHolder)localObject).a.setText(str);
    }
    TextView localTextView = ((QQGuildChannelChooseCategoryFragment.ChannelInfoViewHolder)localObject).a;
    int i = 0;
    localTextView.setVisibility(0);
    paramViewHolder.itemView.setOnClickListener(this.b);
    paramViewHolder.itemView.setTag(Integer.valueOf(paramInt));
    localObject = ((QQGuildChannelChooseCategoryFragment.ChannelInfoViewHolder)localObject).b;
    if (!str.equals(this.c)) {
      i = 8;
    }
    ((ImageView)localObject).setVisibility(i);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(paramViewHolder.itemView, "em_sgrp_channel_mange_type_change", null);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(BaseApplication.getContext()).inflate(2131625002, paramViewGroup, false);
    QQGuildChannelChooseCategoryFragment.ChannelInfoViewHolder localChannelInfoViewHolder = new QQGuildChannelChooseCategoryFragment.ChannelInfoViewHolder(paramViewGroup);
    localChannelInfoViewHolder.a = ((TextView)paramViewGroup.findViewById(2131434560));
    localChannelInfoViewHolder.b = ((ImageView)paramViewGroup.findViewById(2131434559));
    return localChannelInfoViewHolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelChooseCategoryFragment.QQGuildChannelListAdapter
 * JD-Core Version:    0.7.0.1
 */