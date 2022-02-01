package com.tencent.mobileqq.guild.setting.msgnotify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton.OnCheckedChangeListener;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelMsgNotifyTypeCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQGuildMsgNotifySettingAdapter
  extends BaseAdapter
  implements GuildSwitchButton.OnCheckedChangeListener
{
  private String a;
  private Context b;
  private List<NotifySettingData> c = new ArrayList();
  private ISetChannelMsgNotifyTypeCallback d;
  
  public QQGuildMsgNotifySettingAdapter(Context paramContext, String paramString, ISetChannelMsgNotifyTypeCallback paramISetChannelMsgNotifyTypeCallback)
  {
    this.b = paramContext;
    this.a = paramString;
    this.d = paramISetChannelMsgNotifyTypeCallback;
  }
  
  private AppInterface a()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime instanceof AppInterface)) {
      return (AppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void a(IGProChannelInfo paramIGProChannelInfo, int paramInt)
  {
    if (a() == null)
    {
      QLog.e("QQGuildMsgNotifySettingAdapter", 1, "updateNotifyLevel appInterface null");
      return;
    }
    ((QQGuildHandler)a().getBusinessHandler(QQGuildHandler.class.getName())).a(paramIGProChannelInfo, paramInt, this.d);
  }
  
  private void a(IGProChannelInfo paramIGProChannelInfo, View paramView, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sgrp_sub_channel_id", paramIGProChannelInfo.getChannelUin());
    localHashMap.put("sgrp_sub_channel_type", Integer.valueOf(paramIGProChannelInfo.getType()));
    localHashMap.put("sgrp_sub_channel_switch", Integer.valueOf(paramInt));
    VideoReport.reportEvent("clck", paramView, localHashMap);
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (!(getItem(paramInt) instanceof String)) {
      return paramView;
    }
    String str = (String)getItem(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.b).inflate(2131625095, paramViewGroup, false);
    }
    ((TextView)localView.findViewById(2131430500)).setText(str);
    return localView;
  }
  
  public void a(List<NotifySettingData> paramList)
  {
    this.c = paramList;
  }
  
  public boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (!(getItem(paramInt) instanceof IGProChannelInfo)) {
      return paramView;
    }
    IGProChannelInfo localIGProChannelInfo = (IGProChannelInfo)getItem(paramInt);
    QQGuildMsgNotifySettingAdapter.ViewHolder localViewHolder = new QQGuildMsgNotifySettingAdapter.ViewHolder(this, null);
    boolean bool = false;
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(this.b).inflate(2131625092, paramViewGroup, false);
      localViewHolder.a = ((TextView)paramViewGroup.findViewById(2131430505));
      localViewHolder.b = ((ImageView)paramViewGroup.findViewById(2131435219));
      localViewHolder.c = ((GuildSwitchButton)paramViewGroup.findViewById(2131439103));
      localViewHolder.c.setOnCheckedChangeListener(null);
      localViewHolder.d = paramViewGroup.findViewById(2131446253);
      paramViewGroup.setTag(localViewHolder);
      paramView = localViewHolder;
    }
    else
    {
      localViewHolder = (QQGuildMsgNotifySettingAdapter.ViewHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = localViewHolder;
    }
    int i = paramInt + 1;
    if ((getItem(i) != null) && (!(getItem(i) instanceof String))) {
      paramView.d.setVisibility(0);
    } else {
      paramView.d.setVisibility(8);
    }
    if (localIGProChannelInfo.getFinalMsgNotify() == 1) {
      bool = true;
    }
    paramView.c.setTag(Integer.valueOf(paramInt));
    paramView.a.setText(localIGProChannelInfo.getChannelName());
    paramView.c.setContentDescription(localIGProChannelInfo.getChannelName());
    paramView.c.setOnCheckedChangeListener(null);
    paramView.c.setChecked(bool);
    paramView.c.setOnCheckedChangeListener(this);
    QQGuildUtil.a(paramView.c, "em_sgrp_channel_msg_push_switch", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
    return paramViewGroup;
  }
  
  public int getCount()
  {
    Object localObject = this.c;
    int j = 0;
    int i = 0;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        i += ((NotifySettingData)((Iterator)localObject).next()).a();
      }
    }
    return j;
  }
  
  public Object getItem(int paramInt)
  {
    Iterator localIterator = this.c.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      NotifySettingData localNotifySettingData = (NotifySettingData)localIterator.next();
      int j = localNotifySettingData.a();
      int k = paramInt - i;
      if (k < j) {
        return localNotifySettingData.a(k);
      }
      i += j;
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    Iterator localIterator = this.c.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      int j = ((NotifySettingData)localIterator.next()).a();
      if (paramInt - i == 0) {
        return 0;
      }
      i += j;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    View localView;
    if (i != 0)
    {
      if (i != 1) {
        localView = paramView;
      } else {
        localView = b(paramInt, paramView, paramViewGroup);
      }
    }
    else {
      localView = a(paramInt, paramView, paramViewGroup);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return getItemViewType(paramInt) != 0;
  }
  
  public void onCheckedChanged(GuildSwitchButton paramGuildSwitchButton, boolean paramBoolean)
  {
    IGProChannelInfo localIGProChannelInfo = (IGProChannelInfo)getItem(((Integer)paramGuildSwitchButton.getTag()).intValue());
    if (localIGProChannelInfo == null) {
      return;
    }
    int j = 1;
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    a(localIGProChannelInfo, paramGuildSwitchButton, i);
    if (paramBoolean) {
      i = j;
    } else {
      i = 2;
    }
    a(localIGProChannelInfo, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.msgnotify.QQGuildMsgNotifySettingAdapter
 * JD-Core Version:    0.7.0.1
 */