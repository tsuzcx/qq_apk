package com.tencent.mobileqq.guild.channel;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class QQGuildChannelCategorySortFragment$QQGuildChannelCategoryAdapter
  extends RecyclerView.Adapter<QQGuildChannelCategorySortFragment.ChannelCategoryViewHolder>
{
  private List<ICategoryInfo> a = new ArrayList();
  
  @NonNull
  public QQGuildChannelCategorySortFragment.ChannelCategoryViewHolder a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(BaseApplication.getContext()).inflate(2131625001, paramViewGroup, false);
    QQGuildChannelCategorySortFragment.ChannelCategoryViewHolder localChannelCategoryViewHolder = new QQGuildChannelCategorySortFragment.ChannelCategoryViewHolder(paramViewGroup);
    localChannelCategoryViewHolder.a = ((TextView)paramViewGroup.findViewById(2131434547));
    localChannelCategoryViewHolder.b = ((ImageView)paramViewGroup.findViewById(2131434550));
    return localChannelCategoryViewHolder;
  }
  
  public void a(@NonNull QQGuildChannelCategorySortFragment.ChannelCategoryViewHolder paramChannelCategoryViewHolder, int paramInt)
  {
    String str = ((ICategoryInfo)this.a.get(paramInt)).a();
    if (!TextUtils.isEmpty(str)) {
      paramChannelCategoryViewHolder.a.setText(str);
    } else {
      paramChannelCategoryViewHolder.a.setText("未分组");
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramChannelCategoryViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(List<ICategoryInfo> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
    notifyDataSetChanged();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelCategorySortFragment.QQGuildChannelCategoryAdapter
 * JD-Core Version:    0.7.0.1
 */