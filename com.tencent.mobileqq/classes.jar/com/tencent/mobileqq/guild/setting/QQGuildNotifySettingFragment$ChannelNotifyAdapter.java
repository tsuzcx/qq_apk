package com.tencent.mobileqq.guild.setting;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class QQGuildNotifySettingFragment$ChannelNotifyAdapter
  extends BaseAdapter
{
  private List<IGProChannelInfo> a = new ArrayList();
  
  public IGProChannelInfo a(int paramInt)
  {
    List localList = this.a;
    if ((localList != null) && (paramInt < localList.size())) {
      return (IGProChannelInfo)this.a.get(paramInt);
    }
    return null;
  }
  
  public void a(List<IGProChannelInfo> paramList)
  {
    this.a = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.a;
    if (localList != null) {
      return localList.size();
    }
    return 0;
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
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131625102, null);
      paramView = new QQGuildNotifySettingFragment.ChannelNotifyAdapter.ViewHolder(null);
      paramView.b = ((TextView)localView.findViewById(2131430508));
      paramView.a = ((TextView)localView.findViewById(2131430509));
      localView.setTag(paramView);
    }
    else
    {
      localObject = (QQGuildNotifySettingFragment.ChannelNotifyAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    Object localObject = a(paramInt);
    if (localObject != null)
    {
      paramView.a.setText(((IGProChannelInfo)localObject).getChannelName());
      if (((IGProChannelInfo)localObject).getFinalMsgNotify() == 3) {
        paramView.b.setText(localView.getResources().getString(2131890330));
      } else if (((IGProChannelInfo)localObject).getFinalMsgNotify() == 2) {
        paramView.b.setText(localView.getResources().getString(2131890331));
      } else {
        paramView.b.setText(localView.getResources().getString(2131890328));
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildNotifySettingFragment.ChannelNotifyAdapter
 * JD-Core Version:    0.7.0.1
 */