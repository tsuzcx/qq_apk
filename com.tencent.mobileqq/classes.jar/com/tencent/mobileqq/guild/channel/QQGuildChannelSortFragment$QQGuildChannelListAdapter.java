package com.tencent.mobileqq.guild.channel;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class QQGuildChannelSortFragment$QQGuildChannelListAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private List<GuildChannelInfoUIData> a = new ArrayList();
  
  public void a(List<GuildChannelInfoUIData> paramList)
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
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    GuildChannelInfoUIData localGuildChannelInfoUIData = (GuildChannelInfoUIData)this.a.get(paramInt);
    QQGuildChannelSortFragment.ChannelInfoViewHolder localChannelInfoViewHolder = (QQGuildChannelSortFragment.ChannelInfoViewHolder)paramViewHolder;
    if (localGuildChannelInfoUIData.c != null)
    {
      localChannelInfoViewHolder.b.setText(localGuildChannelInfoUIData.c.getChannelName());
      localChannelInfoViewHolder.a.setVisibility(8);
      localChannelInfoViewHolder.f.setVisibility(0);
      if (localGuildChannelInfoUIData.c.getType() == 2) {
        localChannelInfoViewHolder.g.setImageResource(2130840881);
      } else {
        localChannelInfoViewHolder.g.setImageResource(2130840874);
      }
    }
    else
    {
      localChannelInfoViewHolder.c.setText(localGuildChannelInfoUIData.b);
      localChannelInfoViewHolder.a.setVisibility(0);
      localChannelInfoViewHolder.f.setVisibility(8);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(BaseApplication.getContext()).inflate(2131625009, paramViewGroup, false);
    QQGuildChannelSortFragment.ChannelInfoViewHolder localChannelInfoViewHolder = new QQGuildChannelSortFragment.ChannelInfoViewHolder(paramViewGroup);
    localChannelInfoViewHolder.b = ((TextView)paramViewGroup.findViewById(2131434568));
    localChannelInfoViewHolder.d = ((ImageView)paramViewGroup.findViewById(2131434563));
    localChannelInfoViewHolder.c = ((TextView)paramViewGroup.findViewById(2131434570));
    localChannelInfoViewHolder.e = ((ImageView)paramViewGroup.findViewById(2131434567));
    localChannelInfoViewHolder.a = ((RelativeLayout)paramViewGroup.findViewById(2131434562));
    localChannelInfoViewHolder.f = ((RelativeLayout)paramViewGroup.findViewById(2131434558));
    localChannelInfoViewHolder.g = ((ImageView)paramViewGroup.findViewById(2131434565));
    return localChannelInfoViewHolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelSortFragment.QQGuildChannelListAdapter
 * JD-Core Version:    0.7.0.1
 */