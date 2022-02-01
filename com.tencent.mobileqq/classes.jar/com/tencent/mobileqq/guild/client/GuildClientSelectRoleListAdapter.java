package com.tencent.mobileqq.guild.client;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class GuildClientSelectRoleListAdapter
  extends RecyclerView.Adapter<GuildClientSelectRoleListAdapter.RoleItemViewHolder>
  implements CompoundButton.OnCheckedChangeListener
{
  private final Context a;
  private final List<GuildClientRoleInfo.RoleInfo> b = new ArrayList();
  private int c = 0;
  
  public GuildClientSelectRoleListAdapter(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public GuildClientRoleInfo.RoleInfo a()
  {
    return (GuildClientRoleInfo.RoleInfo)this.b.get(this.c);
  }
  
  public GuildClientSelectRoleListAdapter.RoleItemViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new GuildClientSelectRoleListAdapter.RoleItemViewHolder(LayoutInflater.from(this.a).inflate(2131625124, paramViewGroup, false));
  }
  
  public void a(GuildClientSelectRoleListAdapter.RoleItemViewHolder paramRoleItemViewHolder, int paramInt)
  {
    paramRoleItemViewHolder.a((GuildClientRoleInfo.RoleInfo)this.b.get(paramInt), paramInt, this.c);
    GuildClientSelectRoleListAdapter.RoleItemViewHolder.a(paramRoleItemViewHolder).setOnCheckedChangeListener(this);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramRoleItemViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(List<GuildClientRoleInfo.RoleInfo> paramList)
  {
    this.b.clear();
    this.b.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i = ((Integer)paramCompoundButton.getTag()).intValue();
      if (this.c != i)
      {
        this.c = ((Integer)paramCompoundButton.getTag()).intValue();
        notifyDataSetChanged();
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientSelectRoleListAdapter
 * JD-Core Version:    0.7.0.1
 */