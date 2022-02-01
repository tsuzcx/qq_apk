package com.tencent.mobileqq.qqgamepub.mvp.model.buisness;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.qqgamepub.api.IGamePubAccountMsgService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoReq;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.mvp.model.base.IModel;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.base.IPresenter;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.utils.QQGameTimingLogger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQGameHippyModel
  implements WadlProxyServiceCallBackInterface, IModel
{
  protected QQGameTimingLogger a;
  protected long b;
  public long c;
  public long d;
  public long e;
  public long f;
  public long g;
  public long h;
  public int i;
  public long j;
  public boolean k = false;
  private IGamePubAccountMsgService l;
  private int m = 0;
  private int n = 0;
  private QQGameHippyBasePresenter o;
  
  public QQGameHippyModel(IPresenter paramIPresenter)
  {
    a(paramIPresenter);
  }
  
  public IGamePubAccountMsgService a()
  {
    if (this.l == null) {
      try
      {
        if (this.l == null) {
          this.l = ((IGamePubAccountMsgService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGamePubAccountMsgService.class, ""));
        }
      }
      finally {}
    }
    return this.l;
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(int paramInt, QQGameMsgInfo paramQQGameMsgInfo, String paramString)
  {
    GamePubAccountHelper.a(paramQQGameMsgInfo, paramInt, paramString);
    ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).reportGamePubAccountMsgStatus(2, paramQQGameMsgInfo.paMsgid, "");
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void a(Activity paramActivity, Bundle paramBundle)
  {
    paramActivity = paramActivity.getIntent();
    if (paramActivity != null)
    {
      if (paramActivity.hasExtra("startTime"))
      {
        if (paramBundle == null) {
          this.c = paramActivity.getLongExtra("startTime", 0L);
        } else {
          this.c = SystemClock.elapsedRealtime();
        }
        if (this.c > 0L) {
          this.f = (SystemClock.elapsedRealtime() - this.c);
        }
      }
      if (paramActivity.hasExtra("clickTime")) {
        this.d = paramActivity.getLongExtra("clickTime", 0L);
      }
      if (paramActivity.hasExtra("unreadNum")) {
        this.i = paramActivity.getIntExtra("unreadNum", 0);
      }
      if (paramActivity.hasExtra("lastReadTime")) {
        this.j = paramActivity.getLongExtra("lastReadTime", 0L);
      }
    }
  }
  
  public void a(WadlResult paramWadlResult) {}
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, int paramInt, String paramString)
  {
    GamePubAccountHelper.a(paramQQGameMsgInfo, paramInt, paramString);
  }
  
  public void a(IPresenter paramIPresenter)
  {
    this.o = ((QQGameHippyBasePresenter)paramIPresenter);
  }
  
  public void a(String paramString)
  {
    QQGameTimingLogger localQQGameTimingLogger = this.a;
    if (localQQGameTimingLogger != null) {
      localQQGameTimingLogger.a(paramString);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a = new QQGameTimingLogger(paramString1, paramString2);
  }
  
  public void a(ArrayList<WadlResult> paramArrayList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("---->onQueryCallback isGetGameEnter=");
      localStringBuilder.append(this.k);
      QLog.d("QQGameHippyModel", 1, localStringBuilder.toString());
    }
    if (this.k) {
      return;
    }
    for (;;)
    {
      try
      {
        long l1 = GamePubAccountHelper.a(paramArrayList);
        if (QLog.isColorLevel())
        {
          paramArrayList = new StringBuilder();
          paramArrayList.append("---> get lastGameAppID=");
          paramArrayList.append(l1);
          QLog.d("QQGameHippyModel", 1, paramArrayList.toString());
        }
        this.k = true;
        if (this.o.t().equals("3"))
        {
          i1 = 1;
          paramArrayList = new GmpEnterInfoReq(l1, 1, i1);
          ((IQWalletApi)QRoute.api(IQWalletApi.class)).servletSendRequest(paramArrayList, this.o);
          return;
        }
      }
      catch (Throwable paramArrayList)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("---->onQueryCallback getLastGameAppID fail:");
        localStringBuilder.append(paramArrayList.getMessage());
        QLog.d("QQGameHippyModel", 1, localStringBuilder.toString());
        return;
      }
      int i1 = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = (SystemClock.elapsedRealtime() - this.c);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("click GamePubAccount to onLoad success:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(",cost:");
    localStringBuilder.append(this.e);
    QLog.d("QQGameHippyModel", 1, localStringBuilder.toString());
  }
  
  public int b()
  {
    return this.i;
  }
  
  public void b(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.h = paramLong;
  }
  
  public void b(String paramString)
  {
    if (this.b < 0L) {
      return;
    }
    long l1 = (SystemClock.elapsedRealtime() - this.b) / 1000L;
    if (l1 > 0L) {
      GamePubAccountHelper.c(paramString).c("206471").d("76916").a(17, String.valueOf(l1)).a();
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      ((QQGameTimingLogger)localObject1).b();
      long l1 = this.a.b("loadHippy");
      long l3 = this.a.b("onLoadHippyEnd") - l1;
      l1 = -1L;
      localObject1 = this.o.s();
      if (localObject1 != null)
      {
        localObject2 = ((HippyQQPreloadEngine)localObject1).getLoadStepsTime();
        if (localObject2 == null) {
          return;
        }
        if (((HashMap)localObject2).containsKey("loadLibStart")) {
          l1 = ((Long)((HashMap)localObject2).get("loadLibStart")).longValue();
        } else {
          l1 = 0L;
        }
        if (((HashMap)localObject2).containsKey("loadLibEnd")) {
          l2 = ((Long)((HashMap)localObject2).get("loadLibEnd")).longValue();
        } else {
          l2 = 0L;
        }
        if (l2 < l1) {
          l1 = 0L;
        } else {
          l1 = l2 - l1;
        }
      }
      int i1 = -1;
      if (localObject1 != null)
      {
        int i4 = ((HippyQQPreloadEngine)localObject1).isPredraw();
        if (((HippyQQPreloadEngine)localObject1).isPreloaded()) {
          i1 = 2;
        } else {
          i1 = 0;
        }
        i1 = i4 | i1;
      }
      long l2 = this.a.b("initViewEnd") - this.b;
      localObject1 = ((IQQGameHippyApi)QRoute.api(IQQGameHippyApi.class)).getGamePaHippyModuleName();
      int i3 = ((IHippySetting)QRoute.api(IHippySetting.class)).getModuleVersion((String)localObject1);
      localObject1 = GamePubAccountHelper.c(this.o.t());
      Object localObject2 = ((WadlReportBuilder)localObject1).d("76918").c("206612").a(25, String.valueOf(i1));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i3);
      localStringBuilder.append("");
      paramString1 = ((WadlReportBuilder)localObject2).a(26, localStringBuilder.toString()).a(27, paramString1).a(28, paramString2);
      paramString2 = new StringBuilder();
      paramString2.append(this.h);
      paramString2.append("");
      paramString1 = paramString1.a(29, paramString2.toString());
      paramString2 = new StringBuilder();
      paramString2.append(this.g);
      paramString2.append("");
      paramString1 = paramString1.a(30, paramString2.toString());
      paramString2 = new StringBuilder();
      paramString2.append(this.e);
      paramString2.append("");
      paramString1 = paramString1.a(31, paramString2.toString());
      paramString2 = new StringBuilder();
      paramString2.append(l2);
      paramString2.append("");
      paramString1 = paramString1.a(32, paramString2.toString());
      paramString2 = new StringBuilder();
      paramString2.append(l3);
      paramString2.append("");
      paramString1 = paramString1.a(33, paramString2.toString());
      paramString2 = new StringBuilder();
      paramString2.append(this.f);
      paramString2.append("");
      paramString1 = paramString1.a(34, paramString2.toString());
      paramString2 = new StringBuilder();
      paramString2.append(l1);
      paramString2.append("");
      paramString1.a(35, paramString2.toString());
      paramString2 = this.a.d();
      if ((paramString2 != null) && (paramString2.size() > 0))
      {
        paramString1 = this.a.c();
        ((WadlReportBuilder)localObject1).a(36, paramString1);
        int i2 = 0;
        while (i2 < paramString2.size())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramString2.get(i2));
          ((StringBuilder)localObject2).append("");
          ((WadlReportBuilder)localObject1).a(37 + i2, ((StringBuilder)localObject2).toString());
          i2 += 1;
        }
        paramString2 = new StringBuilder();
        paramString2.append("gamePubAccount prefData={");
        paramString2.append("isPreLoadHipyy=");
        paramString2.append(i1);
        paramString2.append("|");
        paramString2.append("version=");
        paramString2.append("8.8.17.5770");
        paramString2.append("|");
        paramString2.append("hippyVersion=");
        paramString2.append(i3);
        paramString2.append("|");
        paramString2.append("showHippyCostTime=");
        paramString2.append(this.h);
        paramString2.append("|");
        paramString2.append("showHippyFirstScreenTime=");
        paramString2.append(this.g);
        paramString2.append("|");
        paramString2.append("AppLoadHippyCostTime=");
        paramString2.append(this.e);
        paramString2.append("|");
        paramString2.append("initViewCostTime=");
        paramString2.append(l2);
        paramString2.append("|");
        paramString2.append("loadHippyCostTime=");
        paramString2.append(l3);
        paramString2.append("|");
        paramString2.append("mEnterQQGamePubCostTime=");
        paramString2.append(this.f);
        paramString2.append("|");
        paramString2.append("loadLibCostTime=");
        paramString2.append(l1);
        paramString2.append("|");
        paramString2.append("pointTime=(");
        paramString2.append(paramString1);
        paramString2.append(")");
        paramString2.append("}");
        QLog.d("QQGameHippyModel", 1, new Object[] { paramString2 });
      }
      ((WadlReportBuilder)localObject1).a();
    }
  }
  
  public void b(ArrayList<WadlResult> paramArrayList) {}
  
  public int c()
  {
    return this.m;
  }
  
  public void c(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void c(long paramLong)
  {
    if (paramLong > 0L)
    {
      long l1 = this.c;
      if (paramLong > l1) {
        this.g = (paramLong - l1);
      }
    }
  }
  
  public int d()
  {
    return this.n;
  }
  
  public void d(long paramLong)
  {
    this.h = (paramLong - this.c);
  }
  
  public long e()
  {
    return this.j;
  }
  
  public void f()
  {
    this.k = false;
    WadlProxyServiceUtil.a().a(this);
    WadlProxyServiceUtil.a().a();
  }
  
  public void g()
  {
    WadlProxyServiceUtil.a().b(this);
  }
  
  public int h()
  {
    IGameMsgManagerService localIGameMsgManagerService = (IGameMsgManagerService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGameMsgManagerService.class, "");
    int i1 = localIGameMsgManagerService.getUnreadCnt4MsgTab();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GameMsgUnreadCnt =");
      localStringBuilder.append(i1);
      QLog.d("QQGameHippyModel", 4, localStringBuilder.toString());
    }
    return localIGameMsgManagerService.getUnreadCnt4MsgTab();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.mvp.model.buisness.QQGameHippyModel
 * JD-Core Version:    0.7.0.1
 */