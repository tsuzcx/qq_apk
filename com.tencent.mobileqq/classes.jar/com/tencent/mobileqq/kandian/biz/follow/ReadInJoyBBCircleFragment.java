package com.tencent.mobileqq.kandian.biz.follow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListViewGroup;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyListViewGroup;
import com.tencent.mobileqq.kandian.biz.feeds.constants.IReadInJoyBBCircleFragmentConst;
import com.tencent.mobileqq.kandian.biz.feeds.controller.HeaderViewController;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyChannelViewController;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyDiandianHeaderController;
import com.tencent.mobileqq.kandian.biz.framework.RIJFrameworkHeaderManager;
import com.tencent.mobileqq.kandian.biz.reddot.KandianSubscribeReportUtils;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPagerController;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianSubscribeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianSubscribeManager.KandianSubscribeMessageObserver;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class ReadInJoyBBCircleFragment
  extends ReadInJoyBaseFragment
  implements IReadInJoyBBCircleFragmentConst, KandianSubscribeManager.KandianSubscribeMessageObserver
{
  protected ReadInJoyChannelViewController a = null;
  private Context b;
  private View c;
  private TimeSliceHelper d = new TimeSliceHelper();
  private boolean m = false;
  
  private void w()
  {
    Object localObject = v();
    if (localObject == null) {
      return;
    }
    localObject = ((Activity)localObject).getIntent();
    KandianRedDotInfo localKandianRedDotInfo = KandianSubscribeManager.c();
    if (localKandianRedDotInfo != null) {
      ((Intent)localObject).putExtra("kandian_feeds_red_pnt_info", localKandianRedDotInfo);
    }
  }
  
  private void x()
  {
    try
    {
      boolean bool = this.m;
      if (bool) {
        return;
      }
      if ((this.b != null) && (this.c != null))
      {
        Object localObject1 = (ViewGroup)this.c.findViewById(2131444326);
        this.a = ((ReadInJoyChannelViewController)ReadInJoyUtils.c.remove(Integer.valueOf(70)));
        if (this.a == null)
        {
          this.a = new ReadInJoyChannelViewController((Activity)this.b);
          this.a.a(70);
          this.a.b(0);
          this.a.a((ViewGroup)localObject1);
          this.a.b(true);
          this.a.cT_();
        }
        else
        {
          this.a.a((ViewGroup)localObject1);
          this.a.c();
          this.a.b();
        }
        this.a.a(this.j, this.k);
        localObject1 = this.a.q();
        if ((localObject1 != null) && ((localObject1 instanceof ReadInJoyBaseListViewGroup))) {
          ((ReadInJoyBaseListViewGroup)localObject1).g();
        }
        ReadinjoySPEventReport.a(0, KandianSubscribeReportUtils.d(), 0);
        this.m = true;
      }
      return;
    }
    finally {}
  }
  
  private void y()
  {
    ThreadManager.executeOnSubThread(new ReadInJoyBBCircleFragment.1(this));
  }
  
  public void a()
  {
    w();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.a;
    if (localReadInJoyChannelViewController != null)
    {
      localReadInJoyChannelViewController.a(true);
      return;
    }
    ReadInJoyChannelViewPagerController.d(d());
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (!this.m) {
      x();
    }
    paramActivity = this.a;
    if (paramActivity != null) {
      paramActivity.i();
    }
    QLog.d("ReadInJoyBBCircleFragment", 2, "[notifyShowSelf] show!");
    w();
    PublicAccountReportUtils.a(null, "", "0X80093F0", "0X80093F0", 0, 0, "", "", "", "", false);
    paramActivity = this.a;
    if ((paramActivity != null) && ((paramActivity.q() instanceof ReadInJoyListViewGroup)))
    {
      paramActivity = ((ReadInJoyListViewGroup)this.a.q()).getHeaderViewManager().b().iterator();
      while (paramActivity.hasNext())
      {
        paramBundle = (HeaderViewController)paramActivity.next();
        if ((paramBundle instanceof ReadInJoyDiandianHeaderController)) {
          paramBundle.e();
        }
      }
    }
  }
  
  public int d()
  {
    return 70;
  }
  
  public void k()
  {
    super.k();
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.a;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.h();
    }
  }
  
  public void l()
  {
    super.l();
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.a;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.a(true);
    }
  }
  
  public void n()
  {
    super.n();
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.a;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.cR_();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.a;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    View localView = this.a.q();
    if (((localView instanceof ReadInJoyListViewGroup)) && (((ReadInJoyListViewGroup)localView).r())) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = v();
    if ((this.b != null) && (Build.VERSION.SDK_INT >= 11)) {
      ((Activity)this.b).getWindow().setFlags(16777216, 16777216);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.c = paramLayoutInflater.inflate(2131626246, paramViewGroup, false);
    if ((getUserVisibleHint()) || (!ReadInJoyUtils.g())) {
      x();
    }
    VideoReport.setPageId(this.c, "14");
    VideoReport.setPageParams(this.c, new RIJDtParamBuilder().a(Integer.valueOf(70)).b());
    return this.c;
  }
  
  public void onDestroy()
  {
    y();
    super.onDestroy();
    ReadInJoyLogicEngine.a().u();
    Object localObject = this.a;
    if (localObject != null)
    {
      ((ReadInJoyChannelViewController)localObject).e();
      localObject = this.a.q();
      if ((localObject != null) && ((localObject instanceof ReadInJoyBaseListViewGroup))) {
        ((ReadInJoyBaseListViewGroup)localObject).h();
      }
    }
    this.a = null;
    localObject = (QQAppInterface)ReadInJoyUtils.b();
    if (localObject != null)
    {
      localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if ((localObject != null) && (((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine() != null))
      {
        localObject = ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().e();
        if (localObject != null) {
          ((ReadInJoyUserInfoModule)localObject).c();
        }
      }
    }
  }
  
  public void onDestroyView()
  {
    ((KandianSubscribeManager)ReadInJoyUtils.b().getManager(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER)).a(this);
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    super.onDetach();
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.a;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.a;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.h();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.a != null) && (this.g)) {
      this.a.i();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.a;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.f();
    }
    this.d.b();
  }
  
  public void onStop()
  {
    super.onStop();
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.a;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.g();
    }
    if (!BaseActivity.mAppForground) {
      this.d.c();
    }
    if (v().isFinishing())
    {
      ReadinjoySPEventReport.a(1, KandianSubscribeReportUtils.d(), 0);
      KandianSubscribeReportUtils.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.follow.ReadInJoyBBCircleFragment
 * JD-Core Version:    0.7.0.1
 */