package com.tencent.mobileqq.kandian.biz.common.widget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJSuperMaskService;
import com.tencent.mobileqq.kandian.base.view.widget.KandianProgressView;
import com.tencent.mobileqq.kandian.base.view.widget.KandianProgressView.ClickCallBack;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyPageItemCache;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyBaseViewController;
import com.tencent.mobileqq.kandian.biz.ugc.KanDianVideoUploadUtils;
import com.tencent.mobileqq.kandian.biz.ugc.KandianVideoUploadService;
import com.tencent.mobileqq.kandian.biz.ugc.KandianVideoUploadService.ICallBack;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class ReadInJoyBaseListViewGroup
  extends FrameLayout
{
  protected int a;
  protected ReadInJoyPageItemCache b;
  protected ReadInJoyBaseViewController c;
  protected ReadInJoyXListView d;
  protected boolean e = false;
  Map<String, KandianProgressView> f = new HashMap();
  List<KandianProgressView> g = new ArrayList();
  KandianVideoUploadService.ICallBack h = new ReadInJoyBaseListViewGroup.1(this);
  KandianProgressView.ClickCallBack i = new ReadInJoyBaseListViewGroup.2(this);
  
  public ReadInJoyBaseListViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt, ReadInJoyPageItemCache paramReadInJoyPageItemCache)
  {
    super(paramReadInJoyBaseViewController.cQ_());
    this.a = paramInt;
    this.c = paramReadInJoyBaseViewController;
    if (paramReadInJoyPageItemCache == null)
    {
      this.b = new ReadInJoyPageItemCache();
      this.b.b = ReadInJoyHelper.a(paramInt, (QQAppInterface)ReadInJoyUtils.b());
      return;
    }
    this.b = paramReadInJoyPageItemCache;
    this.b.h = 1;
  }
  
  private void a()
  {
    Iterator localIterator = KanDianVideoUploadUtils.a().iterator();
    while (localIterator.hasNext())
    {
      Intent localIntent = (Intent)localIterator.next();
      String str = localIntent.getStringExtra("mTaskID");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("is loading fail view:");
      localStringBuilder.append(str);
      localStringBuilder.append("map size");
      localStringBuilder.append(this.f.size());
      QLog.d("KandianVideoUpload", 1, localStringBuilder.toString());
      if (this.f.get(str) == null) {
        KandianVideoUploadService.a(localIntent.getExtras(), this.h);
      }
    }
  }
  
  private void a(Bundle paramBundle, String paramString)
  {
    String str1 = paramBundle.getString("mTaskID");
    String str2 = paramBundle.getString("arg_video_cover");
    Object localObject = (View)this.f.get(str1);
    if (localObject == null)
    {
      if (this.f.size() < 2)
      {
        if (!this.g.isEmpty())
        {
          localObject = (KandianProgressView)this.g.get(0);
          this.g.remove(localObject);
        }
        else
        {
          localObject = new KandianProgressView(getCurrentActivity(), paramBundle, str1, str2, this.i);
        }
        ((KandianProgressView)localObject).setTag(paramString);
        ((KandianProgressView)localObject).setViewInformation(paramBundle, str1, str2);
        a((View)localObject);
        this.f.put(str1, localObject);
      }
    }
    else {
      ((View)localObject).setTag(paramString);
    }
  }
  
  private void a(View paramView)
  {
    ReadInJoyXListView localReadInJoyXListView = this.d;
    if (localReadInJoyXListView != null) {
      localReadInJoyXListView.addHeaderView(paramView);
    }
  }
  
  private void a(String paramString)
  {
    KandianProgressView localKandianProgressView = (KandianProgressView)this.f.get(paramString);
    if (localKandianProgressView != null)
    {
      this.d.removeHeaderView(localKandianProgressView);
      this.g.add(localKandianProgressView);
      this.f.remove(paramString);
    }
  }
  
  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(Map<Integer, Boolean> paramMap);
  
  public abstract void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean);
  
  public abstract void a(Set<Long> paramSet, Map<Long, BaseReportData> paramMap);
  
  public abstract void a(boolean paramBoolean);
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void b() {}
  
  public abstract void b(Map<Integer, Boolean> paramMap);
  
  public void c() {}
  
  public void c(Map<Integer, BaseReportData> paramMap) {}
  
  public void d() {}
  
  public void e() {}
  
  public abstract void f();
  
  public void g()
  {
    a();
    KandianVideoUploadService.a(this.h);
  }
  
  public int getChannelID()
  {
    return this.a;
  }
  
  public Activity getCurrentActivity()
  {
    return this.c.cQ_();
  }
  
  public RIJDataFetchManager getDataFetchManager()
  {
    return null;
  }
  
  public abstract String getLastActionBrief();
  
  public abstract long getLastActionTime();
  
  public ReadInJoyXListView getReadInJoyXListView()
  {
    return this.d;
  }
  
  public ReadInJoyBaseViewController getViewController()
  {
    return this.c;
  }
  
  public void h()
  {
    KandianVideoUploadService.a(null);
  }
  
  public void i()
  {
    if (!this.e)
    {
      this.e = true;
      ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).isChannelRefreshing(this.a, true);
      PublicTracker.a(null, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE");
      ReadInJoyLogicEngine.a().a(this.a, 20, 9223372036854775807L, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListViewGroup
 * JD-Core Version:    0.7.0.1
 */