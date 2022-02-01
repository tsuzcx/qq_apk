package com.tencent.mobileqq.guild.mainframe.container.discover.subfragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.mainframe.container.discover.QQGuildDiscoverFragment;
import com.tencent.mobileqq.guild.mainframe.container.discover.handler.QQGuildDiscoverDataCenter;
import com.tencent.mobileqq.guild.mainframe.container.discover.handler.QQGuildDiscoverHandler;
import com.tencent.mobileqq.guild.mainframe.container.discover.handler.QQGuildDiscoverObserver;
import com.tencent.mobileqq.guild.mainframe.container.discover.subfragment.adapter.QQGuildDiscoverSubTabCommonRvAdapter;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.OverScrollRecyclerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QQGuildDiscoverSubTabCommonFragment
  extends QQGuildDiscoverBaseSubTabFragment
{
  protected RecyclerView k;
  protected QQGuildDiscoverSubTabCommonRvAdapter l;
  private boolean m = false;
  private QQGuildDiscoverObserver n = new QQGuildDiscoverSubTabCommonFragment.1(this);
  
  protected View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramLayoutInflater = new StringBuilder();
      paramLayoutInflater.append("getView，categoryId == ");
      paramLayoutInflater.append(f());
      QLog.d("GuildDiscover.QQGuildDiscoverSubTabCommonFragment", 2, paramLayoutInflater.toString());
    }
    paramLayoutInflater = this.k;
    if (paramLayoutInflater == null)
    {
      this.k = new OverScrollRecyclerView(this.h);
      this.k.setId(2131434600);
      this.k.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.k.setPadding(0, 0, 0, Utils.a(13.0F, getResources()));
      this.k.setClipToPadding(false);
      this.k.setClipChildren(false);
      this.k.setScrollBarStyle(33554432);
      QQGuildUtil.a(this.k, "em_sgrp_discover_classify", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
    }
    else
    {
      paramLayoutInflater = paramLayoutInflater.getParent();
      if ((paramLayoutInflater instanceof ViewGroup)) {
        ((ViewGroup)paramLayoutInflater).removeView(this.k);
      }
    }
    return this.k;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnDestroy，categoryId == ");
      localStringBuilder.append(f());
      QLog.d("GuildDiscover.QQGuildDiscoverSubTabCommonFragment", 2, localStringBuilder.toString());
    }
    d();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnResume:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", categoryId == ");
      ((StringBuilder)localObject).append(f());
      QLog.d("GuildDiscover.QQGuildDiscoverSubTabCommonFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (this.k == null) {
      return;
    }
    c();
    VideoReport.reportEvent("imp", this.k, null);
    if (this.l == null)
    {
      this.l = new QQGuildDiscoverSubTabCommonRvAdapter(this.h, this.d);
      this.l.a(this.j.c);
      localObject = new GridLayoutManager(this.h, 2);
      this.k.setLayoutManager((RecyclerView.LayoutManager)localObject);
      this.k.setAdapter(this.l);
      this.l.a();
      this.k.addOnScrollListener(new QQGuildDiscoverSubTabCommonFragment.2(this));
    }
    if (this.l != null)
    {
      localObject = QQGuildDiscoverDataCenter.a(f());
      if ((localObject != null) && (((ArrayList)localObject).size() != 0)) {
        this.l.a((List)localObject);
      } else {
        ((QQGuildDiscoverHandler)this.d.getBusinessHandler(QQGuildDiscoverHandler.class.getName())).a(f());
      }
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("sgrp_discover_classify_id", Integer.valueOf(f()));
    VideoReport.reportEvent("imp", this.k, (Map)localObject);
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refresh，categoryId == ");
      localStringBuilder.append(f());
      QLog.d("GuildDiscover.QQGuildDiscoverSubTabCommonFragment", 2, localStringBuilder.toString());
    }
    if ((this.k != null) && (this.l != null)) {
      ((QQGuildDiscoverHandler)this.d.getBusinessHandler(QQGuildDiscoverHandler.class.getName())).a(f());
    }
    this.m = true;
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnPause，categoryId == ");
      localStringBuilder.append(f());
      QLog.d("GuildDiscover.QQGuildDiscoverSubTabCommonFragment", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      d();
    }
  }
  
  protected void c()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addObservers，categoryId == ");
      localStringBuilder.append(f());
      QLog.d("GuildDiscover.QQGuildDiscoverSubTabCommonFragment", 2, localStringBuilder.toString());
    }
    if ((this.d != null) && (this.g)) {
      this.d.addObserver(this.n);
    }
  }
  
  protected void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeObservers，categoryId == ");
      localStringBuilder.append(f());
      QLog.d("GuildDiscover.QQGuildDiscoverSubTabCommonFragment", 2, localStringBuilder.toString());
    }
    if (this.d != null) {
      this.d.removeObserver(this.n);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume:, categoryId == ");
      localStringBuilder.append(f());
      QLog.d("GuildDiscover.QQGuildDiscoverSubTabCommonFragment", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.subfragment.QQGuildDiscoverSubTabCommonFragment
 * JD-Core Version:    0.7.0.1
 */