package com.tencent.mobileqq.guild.channel;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class QQGuildChannelListSettingFragment$QQGuildChannelListAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private List<GuildChannelInfoUIData> a = new ArrayList();
  private View.OnClickListener b;
  private boolean c;
  
  public int a(IGProChannelInfo paramIGProChannelInfo)
  {
    if (paramIGProChannelInfo == null) {
      return -1;
    }
    int i = 0;
    while (i < this.a.size())
    {
      GuildChannelInfoUIData localGuildChannelInfoUIData = (GuildChannelInfoUIData)this.a.get(i);
      if ((localGuildChannelInfoUIData.c != null) && (paramIGProChannelInfo.getChannelUin().equals(localGuildChannelInfoUIData.c.getChannelUin()))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.b = paramOnClickListener;
  }
  
  public void a(List<GuildChannelInfoUIData> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.c != paramBoolean)
    {
      this.c = paramBoolean;
      notifyDataSetChanged();
    }
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
    Object localObject = (QQGuildChannelListSettingFragment.ChannelInfoViewHolder)paramViewHolder;
    ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).itemView.setBackgroundColor(16777215);
    int j = localGuildChannelInfoUIData.a;
    int i = 0;
    if (j == 0)
    {
      ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).e.setText(localGuildChannelInfoUIData.c.getChannelName());
      ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).itemView.setBackgroundColor(-1);
      ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).d.setVisibility(8);
      ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).c.setVisibility(0);
      ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).a.setVisibility(8);
      ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).j.setVisibility(8);
      if (localGuildChannelInfoUIData.c.getType() == 2) {
        ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).b.setImageResource(2130841053);
      } else if (localGuildChannelInfoUIData.c.getType() == 5) {
        ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).b.setImageResource(2130840935);
      } else if (localGuildChannelInfoUIData.c.getType() == 6) {
        ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).b.setImageResource(2130840668);
      } else {
        ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).b.setImageResource(2130841035);
      }
      paramViewHolder.itemView.setOnClickListener(this.b);
      paramViewHolder.itemView.setTag(localGuildChannelInfoUIData);
      if (this.c)
      {
        ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).h.setVisibility(8);
        ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).i.setVisibility(0);
      }
      else
      {
        ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).h.setVisibility(0);
        ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).i.setVisibility(8);
      }
    }
    else if (localGuildChannelInfoUIData.a == 1)
    {
      ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).f.setText(localGuildChannelInfoUIData.b);
      ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).d.setVisibility(0);
      ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).c.setVisibility(8);
      ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).a.setVisibility(8);
      ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).j.setVisibility(8);
      paramViewHolder.itemView.setOnClickListener(null);
      ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).g.setTag(localGuildChannelInfoUIData);
      ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).g.setOnClickListener(this.b);
      localObject = ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).g;
      if (this.c) {
        i = 8;
      }
      ((ImageView)localObject).setVisibility(i);
    }
    else if (localGuildChannelInfoUIData.a == -1)
    {
      ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).c.setVisibility(8);
      ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).d.setVisibility(8);
      ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).a.setVisibility(8);
      ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).j.setVisibility(0);
    }
    else
    {
      ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).c.setVisibility(8);
      ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).d.setVisibility(8);
      ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).a.setVisibility(0);
      ((QQGuildChannelListSettingFragment.ChannelInfoViewHolder)localObject).j.setVisibility(8);
    }
    QQGuildChannelListSettingFragment.a(paramViewHolder.itemView, localGuildChannelInfoUIData.c);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(BaseApplication.getContext()).inflate(2131625008, paramViewGroup, false);
    QQGuildChannelListSettingFragment.ChannelInfoViewHolder localChannelInfoViewHolder = new QQGuildChannelListSettingFragment.ChannelInfoViewHolder(paramViewGroup);
    localChannelInfoViewHolder.e = ((TextView)paramViewGroup.findViewById(2131434568));
    localChannelInfoViewHolder.g = ((ImageView)paramViewGroup.findViewById(2131434563));
    localChannelInfoViewHolder.f = ((TextView)paramViewGroup.findViewById(2131434570));
    localChannelInfoViewHolder.h = ((ImageView)paramViewGroup.findViewById(2131434567));
    localChannelInfoViewHolder.i = ((ImageView)paramViewGroup.findViewById(2131434569));
    localChannelInfoViewHolder.d = ((RelativeLayout)paramViewGroup.findViewById(2131434562));
    localChannelInfoViewHolder.c = ((RelativeLayout)paramViewGroup.findViewById(2131434558));
    localChannelInfoViewHolder.b = ((ImageView)paramViewGroup.findViewById(2131434565));
    localChannelInfoViewHolder.a = ((RelativeLayout)paramViewGroup.findViewById(2131434561));
    localChannelInfoViewHolder.j = paramViewGroup.findViewById(2131434564);
    return localChannelInfoViewHolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelListSettingFragment.QQGuildChannelListAdapter
 * JD-Core Version:    0.7.0.1
 */