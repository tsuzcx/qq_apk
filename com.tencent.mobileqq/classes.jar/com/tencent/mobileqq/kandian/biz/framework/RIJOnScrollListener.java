package com.tencent.mobileqq.kandian.biz.framework;

import android.app.Activity;
import android.os.Build.VERSION;
import android.util.Pair;
import android.view.View;
import com.tencent.biz.pubaccount.util.FeedExposureHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJADExposureService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.image.ImageManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.ThreadPriorityUtil;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.ad.entity.IExposureSupplementManager;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.VideoPlayControlUtils;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSLiteSwitchManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import mqq.os.MqqHandler;

public class RIJOnScrollListener
  implements AbsListView.OnScrollListener
{
  boolean a;
  boolean b = false;
  int c = -1;
  double d = 0.0D;
  RIJDataManager e;
  FeedExposureHelper f;
  MqqHandler g = new MqqHandler();
  ThreadPriorityUtil h = new ThreadPriorityUtil();
  private View i;
  private View j;
  private int k;
  private int l;
  private Runnable m = new RIJOnScrollListener.1(this);
  
  public RIJOnScrollListener(RIJDataManager paramRIJDataManager)
  {
    this.e = paramRIJDataManager;
    this.f = new RIJOnScrollListener.2(this, paramRIJDataManager);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd(this.e.a().B()))
    {
      Pair localPair = ReadInJoyLogicEngine.a().f(this.e.a().B(), paramInt1 + paramInt2 - 1);
      if (localPair != null)
      {
        ReadInJoyLogicEngine.a().a(this.e.a().B(), ((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
        ThreadManager.executeOnSubThread(new RIJOnScrollListener.3(this, localPair));
      }
    }
  }
  
  private void a(AbsListView paramAbsListView)
  {
    if ((this.c == 2) && (Build.VERSION.SDK_INT < 21))
    {
      if (b(paramAbsListView))
      {
        ImageManager.get().pauseDownload();
        return;
      }
      ImageManager.get().resume();
    }
  }
  
  private void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.k < paramInt1)
    {
      VideoPlayControlUtils.a(this.i);
      return;
    }
    if (paramInt1 + paramInt2 - 1 < this.l) {
      VideoPlayControlUtils.a(this.j);
    }
  }
  
  private void b()
  {
    if (RIJQQAppInterfaceUtil.g())
    {
      int n = this.e.a().B();
      if (n != 0)
      {
        if (n != 56)
        {
          if (n != 70)
          {
            if (DailyModeConfigHandler.c(this.e.a().B()))
            {
              DropFrameMonitor.b().a(d());
              return;
            }
            DropFrameMonitor localDropFrameMonitor = DropFrameMonitor.b();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("list_kandian_channel_");
            localStringBuilder.append(this.e.a().B());
            localDropFrameMonitor.a(localStringBuilder.toString());
            return;
          }
          DropFrameMonitor.b().a("list_subscript");
          return;
        }
        DropFrameMonitor.b().a("list_video_kandian");
        return;
      }
      DropFrameMonitor.b().a("list_new_kandian");
    }
  }
  
  private boolean b(AbsListView paramAbsListView)
  {
    float f1 = paramAbsListView.getFlingVelocity();
    float f2 = (float)DeviceInfoUtil.E();
    return (f1 > 0.0F) && (f1 > f2 * 1.0F);
  }
  
  private void c()
  {
    if (RIJQQAppInterfaceUtil.g())
    {
      int n = this.e.a().B();
      if (n != 0)
      {
        if (n != 56)
        {
          if (n != 70)
          {
            if (DailyModeConfigHandler.c(this.e.a().B()))
            {
              DropFrameMonitor.b().a(d(), false);
              return;
            }
            DropFrameMonitor localDropFrameMonitor = DropFrameMonitor.b();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("list_kandian_channel_");
            localStringBuilder.append(this.e.a().B());
            localDropFrameMonitor.a(localStringBuilder.toString(), false);
            return;
          }
          DropFrameMonitor.b().a("list_subscript", false);
          return;
        }
        DropFrameMonitor.b().a("list_video_kandian", false);
        return;
      }
      DropFrameMonitor.b().a("list_new_kandian", false);
    }
  }
  
  private String d()
  {
    if (PTSLiteSwitchManager.a().c()) {
      return "list_readinjoy_daily_lite";
    }
    return "list_readinjoy_daily";
  }
  
  public FeedExposureHelper a()
  {
    return this.f;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    IRIJADExposureService localIRIJADExposureService = (IRIJADExposureService)RIJQQAppInterfaceUtil.a().getRuntimeService(IRIJADExposureService.class);
    if ((localIRIJADExposureService.checkAndReportAdExposure(this.e.a().v(), (Activity)this.e.a().A(), true)) && (this.e.a().b() != null)) {
      this.e.a().b().a(this.e.a().v(), (Activity)this.e.a().A());
    }
    a(paramInt1, paramInt2);
    int n = this.k;
    if (paramInt1 > n) {
      this.a = true;
    } else if (paramInt1 < n) {
      this.a = false;
    }
    localIRIJADExposureService.checkADScrollAction(this.e.a().v(), (Activity)this.e.a().A(), this.a, this.d);
    a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    this.k = paramInt1;
    this.l = (paramInt1 + paramInt2 - 1);
    this.i = paramAbsListView.getChildAt(0);
    this.j = paramAbsListView.getChildAt(paramInt2 - 1);
    a(paramAbsListView);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.c = paramInt;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onScrollStateChanged ");
      localStringBuilder.append(paramInt);
      QLog.d("RIJOnScrollListener", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onScrollStateChanged ");
      localStringBuilder.append(paramInt);
      QLog.d("RIJOnScrollListener", 2, localStringBuilder.toString());
    }
    if (paramInt == 0)
    {
      c();
      this.h.b();
      this.e.a().h().a(this.a, paramAbsListView.getCount(), paramAbsListView.getLastVisiblePosition(), this.e.a().c(), this.e);
      this.g.postDelayed(this.m, 1000L);
    }
    else
    {
      b();
      this.h.a();
      this.g.removeCallbacks(this.m);
    }
    if ((paramInt == 2) && (this.e.a().a()))
    {
      this.b = true;
    }
    else if ((paramInt != 2) && (this.b))
    {
      this.b = false;
      this.e.a().g(false);
    }
    this.f.a(paramAbsListView, paramInt);
    if ((paramInt == 0) && ((paramAbsListView instanceof ReadInJoyXListView)) && (!((ReadInJoyXListView)paramAbsListView).c())) {
      VideoPlayControlUtils.a(paramAbsListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJOnScrollListener
 * JD-Core Version:    0.7.0.1
 */