package com.tencent.mobileqq.guild.setting.msgnotify;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.data.QQGuildDTConstant;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelMsgNotifyTypeCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class QQGuildMsgNotifySettingFragment
  extends QQGuildTitleBarFragment
{
  private String o;
  private XListView p;
  private QQGuildMsgNotifySettingAdapter q;
  private ISetChannelMsgNotifyTypeCallback r = new QQGuildMsgNotifySettingFragment.1(this);
  
  private List<NotifySettingData> a(AppInterface paramAppInterface, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return localArrayList;
      }
      paramAppInterface = ((IGPSService)paramAppInterface.getRuntimeService(IGPSService.class, "")).getChannelList(paramString);
      if (paramAppInterface == null) {
        return localArrayList;
      }
      a(localArrayList, paramAppInterface);
      b(localArrayList, paramAppInterface);
    }
    return localArrayList;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("guild_id", paramString);
    localIntent.putExtras(localBundle);
    QPublicFragmentActivity.Launcher.a(paramContext, localIntent, QPublicFragmentActivity.class, QQGuildMsgNotifySettingFragment.class);
  }
  
  private void a(LayoutInflater paramLayoutInflater)
  {
    this.c.setText(getResources().getString(2131916353));
    this.p = ((XListView)this.l.findViewById(2131437317));
    paramLayoutInflater = paramLayoutInflater.inflate(2131625094, null);
    this.p.addHeaderView(paramLayoutInflater);
  }
  
  private void a(List<NotifySettingData> paramList, List<IGProChannelInfo> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      IGProChannelInfo localIGProChannelInfo = (IGProChannelInfo)paramList1.next();
      if ((localIGProChannelInfo != null) && (localIGProChannelInfo.getType() == 1)) {
        localArrayList.add(localIGProChannelInfo);
      }
    }
    if (!localArrayList.isEmpty()) {
      paramList.add(new NotifySettingData(getString(2131890520), localArrayList));
    }
  }
  
  private void b(List<NotifySettingData> paramList, List<IGProChannelInfo> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      IGProChannelInfo localIGProChannelInfo = (IGProChannelInfo)paramList1.next();
      if ((localIGProChannelInfo != null) && (localIGProChannelInfo.getType() == 5)) {
        localArrayList.add(localIGProChannelInfo);
      }
    }
    if (!localArrayList.isEmpty()) {
      paramList.add(new NotifySettingData(getString(2131890519), localArrayList));
    }
  }
  
  private void i()
  {
    List localList = a(l(), this.o);
    if (!localList.isEmpty())
    {
      this.q = new QQGuildMsgNotifySettingAdapter(getQBaseActivity(), this.o, this.r);
      this.q.a(localList);
      this.p.setAdapter(this.q);
    }
  }
  
  private void j()
  {
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(this.k, "pg_sgrp_msg_push_set");
    IGProGuildInfo localIGProGuildInfo = ((IGPSService)l().getRuntimeService(IGPSService.class, "")).getGuildInfo(this.o);
    HashMap localHashMap = new HashMap();
    localHashMap.put("sgrp_channel_id", this.o);
    int i;
    if (localIGProGuildInfo != null) {
      i = localIGProGuildInfo.getUserType();
    } else {
      i = 0;
    }
    localHashMap.put("sgrp_user_type", Integer.valueOf(QQGuildDTConstant.a(i)));
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.k, this.o, localHashMap);
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    if (TextUtils.isEmpty(this.o))
    {
      QLog.e("QQGuildMsgNotifySettingFragment", 1, "doOnCreateView mGuildId is null!");
      return;
    }
    a(paramLayoutInflater);
    i();
    j();
  }
  
  protected int b()
  {
    return 2131625093;
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null) {
      this.o = paramBundle.getString("guild_id");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.msgnotify.QQGuildMsgNotifySettingFragment
 * JD-Core Version:    0.7.0.1
 */