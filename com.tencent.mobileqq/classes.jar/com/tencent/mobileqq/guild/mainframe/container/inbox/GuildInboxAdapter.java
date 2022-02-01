package com.tencent.mobileqq.guild.mainframe.container.inbox;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService;
import com.tencent.mobileqq.guild.mainframe.helper.GuildInboxSelectHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.data.GuildNoticeRedPoint;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class GuildInboxAdapter
  extends BaseAdapter
  implements View.OnClickListener, DragFrameLayout.OnDragModeChangedListener
{
  private List<GuildNoticeRedPoint> a = new ArrayList();
  private GuildMainViewContext b;
  private DragFrameLayout c;
  
  public GuildInboxAdapter(GuildMainViewContext paramGuildMainViewContext)
  {
    this.b = paramGuildMainViewContext;
  }
  
  private void a(View paramView)
  {
    new HashMap().put("sgrp_notificationbox_type", String.valueOf(1));
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(paramView, "em_sgrp_notificationbox_click", null);
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.c = paramDragFrameLayout;
    this.c.a(this, true);
  }
  
  public void a(@NonNull List<GuildNoticeRedPoint> paramList)
  {
    this.a = paramList;
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.a;
    if ((localList != null) && (paramInt < localList.size())) {
      return this.a.get(paramInt);
    }
    throw new IndexOutOfBoundsException("GuildNoticeAdapter is IndexOutOfBoundsException");
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
      localView = LayoutInflater.from(this.b.b()).inflate(2131625099, null);
      paramView = new GuildInboxAdapter.Holder(null);
      GuildInboxAdapter.Holder.a(paramView, (ImageView)localView.findViewById(2131434613));
      GuildInboxAdapter.Holder.a(paramView, (TextView)localView.findViewById(2131434739));
      GuildInboxAdapter.Holder.a(paramView, (DragTextView)localView.findViewById(2131434741));
      localView.setTag(paramView);
    }
    else
    {
      localObject = (GuildInboxAdapter.Holder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    Object localObject = (GuildNoticeRedPoint)this.a.get(paramInt);
    GuildInboxAdapter.Holder.a(paramView).setText(GuildInboxRedUtils.a(((GuildNoticeRedPoint)localObject).a, GuildInboxAdapter.Holder.a(paramView).getResources()));
    if ((((GuildNoticeRedPoint)localObject).b > 0) && (NetConnInfoCenter.getServerTime() <= ((GuildNoticeRedPoint)localObject).c)) {
      GuildInboxAdapter.Holder.b(paramView).setVisibility(0);
    } else {
      GuildInboxAdapter.Holder.b(paramView).setVisibility(8);
    }
    GuildInboxAdapter.Holder.b(paramView).setOnModeChangeListener(this.c);
    GuildInboxAdapter.Holder.b(paramView).setDragViewType(0, localView);
    int i;
    if (((GuildInboxSelectHelper)this.b.a(GuildMainFrameConstants.h)).i() == GuildInboxSelectHelper.c) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localView.setBackgroundResource(2130840760);
      GuildInboxAdapter.Holder.a(paramView).setTextColor(Color.rgb(0, 0, 0));
    }
    else
    {
      localView.setBackgroundResource(2130840758);
      GuildInboxAdapter.Holder.a(paramView).setTextColor(Color.rgb(116, 127, 141));
    }
    a(localView);
    localView.setTag(paramView);
    localView.setOnClickListener(new GuildInboxAdapter.1(this, (GuildNoticeRedPoint)localObject));
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    DragFrameLayout localDragFrameLayout = this.c;
    if ((localDragFrameLayout != null) && (localDragFrameLayout.getMode() == -1) && (paramDragFrameLayout.getDragView() != null) && (paramDragFrameLayout.getDragView().getId() == 2131434741))
    {
      ((IGuildInboxRedService)this.b.a().getRuntimeService(IGuildInboxRedService.class, "")).clearNoticeRedPoint(1);
      if (QLog.isColorLevel()) {
        QLog.d("GuildInboxAdapter", 1, "GuildInboxAdapter onChange clearNoticeRedPoint");
      }
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.inbox.GuildInboxAdapter
 * JD-Core Version:    0.7.0.1
 */