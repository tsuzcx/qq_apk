package com.tencent.mobileqq.guild.client;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qqguildsdk.data.IClientInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuildClientTitleDisplaySettingListAdapter
  extends BaseAdapter
  implements CompoundButton.OnCheckedChangeListener
{
  private final List<IClientInfo> a = new ArrayList();
  private int b = 0;
  private final GuildClientTitleDisplaySettingFragment c;
  
  public GuildClientTitleDisplaySettingListAdapter(GuildClientTitleDisplaySettingFragment paramGuildClientTitleDisplaySettingFragment)
  {
    this.c = paramGuildClientTitleDisplaySettingFragment;
    this.c.o.c().observe(this.c.getViewLifecycleOwner(), new GuildClientTitleDisplaySettingListAdapter.1(this));
  }
  
  private int b(IClientInfo paramIClientInfo)
  {
    int i = 1;
    while (i < this.a.size())
    {
      if (((IClientInfo)this.a.get(i)).a().equals(paramIClientInfo.a())) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  public IClientInfo a(int paramInt)
  {
    if (this.a.size() > paramInt) {
      return (IClientInfo)this.a.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    this.b = 0;
    notifyDataSetChanged();
  }
  
  public void a(IClientInfo paramIClientInfo)
  {
    this.b = b(paramIClientInfo);
    notifyDataSetChanged();
  }
  
  public void a(List<IClientInfo> paramList)
  {
    this.a.clear();
    this.a.add(0, paramList.get(0));
    this.a.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new GuildClientTitleDisplaySettingListAdapter.ViewHolder(null);
      localView = paramView.a(paramViewGroup);
    }
    else
    {
      localObject = (GuildClientTitleDisplaySettingListAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    Object localObject = a(paramInt);
    if ((localObject != null) && (!TextUtils.isEmpty(((IClientInfo)localObject).a())))
    {
      if (paramInt == getCount() - 1) {
        localView.setBackgroundResource(2130840774);
      }
      paramView.a(this.c.getContext(), paramInt, (IClientInfo)localObject, this.b);
      GuildClientTitleDisplaySettingListAdapter.ViewHolder.a(paramView).setOnCheckedChangeListener(this);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((paramBoolean) && (((Integer)paramCompoundButton.getTag()).intValue() != this.b))
    {
      this.b = ((Integer)paramCompoundButton.getTag()).intValue();
      String str = a(this.b).a();
      if (this.b == 0) {
        str = "0";
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("sgrp_otherapp_id", str);
      VideoReport.reportEvent("clck", paramCompoundButton.getParent(), localHashMap);
      this.c.o.a(str);
      notifyDataSetChanged();
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientTitleDisplaySettingListAdapter
 * JD-Core Version:    0.7.0.1
 */