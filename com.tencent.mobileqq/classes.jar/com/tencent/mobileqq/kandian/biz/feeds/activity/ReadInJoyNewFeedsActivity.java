package com.tencent.mobileqq.kandian.biz.feeds.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.pubaccount.AccountDetail.view.ReadInJoyNewFeedsTopGestureLayout;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.monitor.FPSMonitor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.ad.api.IRIJADExposureService;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.base.view.widget.BaseTabbar.OnTabChangeListener;
import com.tencent.mobileqq.kandian.base.view.widget.BaseTabbar.TabHolder;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyScreenShotReporter;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyRecommendFeedsFragment;
import com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoySubChannelFragment;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.RIJUGCDianDian;
import com.tencent.mobileqq.kandian.biz.framework.RIJWebSearchUtils;
import com.tencent.mobileqq.kandian.biz.framework.UserActionCollector;
import com.tencent.mobileqq.kandian.biz.message.activity.ReadInJoyNewBaseActivity;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.push.OnTabRedNumsChangeListenner;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.push.RIJLockScreenPushReport;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotification;
import com.tencent.mobileqq.kandian.biz.skin.BaseSkinRes;
import com.tencent.mobileqq.kandian.biz.skin.CommonSkinRes;
import com.tencent.mobileqq.kandian.biz.skin.GuideData;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyBaseResManager;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinGuideView;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinManager;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinManager.OnSkinChangedListener;
import com.tencent.mobileqq.kandian.biz.skin.ReadInjoySkinAndRefreshFacade;
import com.tencent.mobileqq.kandian.biz.skin.entity.BaseResData;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyNaviController;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyNavigationGridview;
import com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabbar;
import com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabbar.Tab;
import com.tencent.mobileqq.kandian.biz.video.ReadInJoyVideoChannelFragment;
import com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager;
import com.tencent.mobileqq.kandian.biz.video.VideoUIManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyWebRenderEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.report.ReadInJoyGlobalReporter;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.router.ReadInJoyFragmentFactory;
import com.tencent.mobileqq.kandian.glue.router.msgbox.api.impl.RIJMsgBoxUtils;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager.Companion;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianLockScreenPushAladdinConfig;
import com.tencent.mobileqq.kandian.repo.common.FreeNetFlowInfoModule;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.db.struct.KandianOx210MsgInfo;
import com.tencent.mobileqq.kandian.repo.feeds.FeedsSPUtils;
import com.tencent.mobileqq.kandian.repo.feeds.IReadInJoyNewFeedsActivityConst;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.handler.RIJGetArticleListHandler;
import com.tencent.mobileqq.kandian.repo.push.api.MessageObserver;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyNewFeedsActivity
  extends ReadInJoyNewBaseActivity
  implements View.OnClickListener, TopGestureLayout.OnGestureListener, OnTabRedNumsChangeListenner, ReadInJoySkinManager.OnSkinChangedListener, IReadInJoyNewFeedsActivityConst, MessageObserver, Observer
{
  private static final int E = Color.parseColor("#dedfe0");
  public static List<String> a = new ArrayList(1);
  public static int g = 0;
  public static ConcurrentHashMap<Integer, ReadInJoyNewFeedsActivity.TabInfo> h = new ConcurrentHashMap();
  private FragmentManager F;
  private ReadinjoyTabbar G;
  private View H;
  private View I;
  private KandianMergeManager J = null;
  private int K = 0;
  private boolean L;
  private boolean M;
  private int N;
  private int O = 0;
  private long P = 0L;
  private long Q = 0L;
  private long R = 0L;
  private long S = 0L;
  private long T = 0L;
  private int U = 0;
  private MqqHandler V = new MqqHandler();
  private GuideData W;
  private boolean X = false;
  private boolean Y = false;
  private Runnable Z = new ReadInJoyNewFeedsActivity.1(this);
  private boolean aa = false;
  private ConcurrentHashMap<Integer, ReadInJoySubChannelFragment> ab = new ConcurrentHashMap();
  private ReadInJoyBaseFragment ac;
  private ChannelCoverInfo ad;
  public boolean b;
  int c;
  boolean d = true;
  public ReadInJoyNaviController e;
  protected String f = null;
  protected ReadInJoyNewFeedsTopGestureLayout i;
  protected FrameLayout j;
  protected ReadInJoySkinGuideView k;
  protected ReadInjoySkinAndRefreshFacade l;
  BaseTabbar.OnTabChangeListener m = new ReadInJoyNewFeedsActivity.9(this);
  protected ReadInJoyObserver n = new ReadInJoyNewFeedsActivity.17(this);
  
  static
  {
    h.put(Integer.valueOf(0), new ReadInJoyNewFeedsActivity.TabInfo(HardCodeUtil.a(2131891080), 1, 0, -1, -857808928));
    h.put(Integer.valueOf(1), new ReadInJoyNewFeedsActivity.TabInfo(HardCodeUtil.a(2131910404), 2, 0, -1, -857808928));
    h.put(Integer.valueOf(2), new ReadInJoyNewFeedsActivity.TabInfo(HardCodeUtil.a(2131910545), 2, 0, -1, -857808928));
    h.put(Integer.valueOf(3), new ReadInJoyNewFeedsActivity.TabInfo(HardCodeUtil.a(2131910313), 2, 0, -1, -857808928));
  }
  
  private int A()
  {
    if (this.J == null) {
      this.J = ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    }
    return this.J.G().get(3);
  }
  
  private void B()
  {
    int i1 = this.K;
    if (i1 == 3) {
      return;
    }
    boolean bool;
    if (i1 == 0) {
      bool = ReadInJoyUtils.b;
    } else if (i1 == 1) {
      bool = ReadInJoyUtils.b;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTabRedNumsChange on");
      localStringBuilder.append(this.K);
      localStringBuilder.append("and rednums is");
      localStringBuilder.append(A());
      QLog.d("ReadInJoyNewFeedsActivity", 2, localStringBuilder.toString());
    }
  }
  
  private void a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.G.setSelection(paramInt1, this.K, this.F, getIntent(), paramInt2, paramBundle);
    paramBundle = (ReadInJoySkinManager)this.app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    if (paramBundle.c() != 0)
    {
      paramBundle = paramBundle.a(paramInt1 + 4);
      if (paramBundle != null) {
        this.G.c(paramInt1).c.f.setImageDrawable(paramBundle.a());
      }
    }
    this.G.c(this.K).c.f.setSelected(false);
    this.G.c(paramInt1).c.f.setSelected(true);
    if (this.J.b(this.K, paramInt1)) {
      this.G.b(paramInt1);
    }
    paramInt1 = this.G.getShowingPopupTipsTapPosi();
    if (paramInt1 == 3) {
      this.G.d(paramInt1);
    }
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    localReportR5Builder.addStringNotThrow("has_redpoint", paramInt);
    PublicAccountReportUtils.a(null, "", "0X8007C40", "0X8007C40", 0, 0, "", "", "", VideoReporter.b(localReportR5Builder.getR5Object()), false);
    ReadInJoyScreenShotReporter.a(this).a(3, 56);
    if (paramBoolean) {
      PublicTracker.a(null, "video_tab_cost");
    }
  }
  
  private void a(Bundle paramBundle)
  {
    if (this.J == null) {
      this.J = ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    }
    if ((paramBundle != null) && (paramBundle.getInt("BID_TYPE", 0) == 2))
    {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "reportSubscribeTabRedInfo.");
      long l1 = this.J.x();
      if (l1 != 0L) {
        try
        {
          paramBundle = RIJTransMergeKanDianReport.d();
          paramBundle.put("kandian_mode", RIJAppSetting.b());
          paramBundle.put("tab_source", 3);
          PublicAccountReportUtils.a(null, "CliOper", "", String.valueOf(l1), "0X80081C6", "0X80081C6", 0, 1, null, null, String.valueOf(this.J.y()), paramBundle.toString(), false);
          return;
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    getWindow().getDecorView().post(new ReadInJoyNewFeedsActivity.11(this, paramString));
  }
  
  public static boolean a()
  {
    return a.size() > 0;
  }
  
  private void e(boolean paramBoolean)
  {
    g(0);
    z();
    ReadInJoyScreenShotReporter.a(this).a(0, 0);
    if (paramBoolean) {
      PublicTracker.a(null, "recommend_tab_cost");
    }
  }
  
  public static void f(int paramInt)
  {
    if (paramInt == 7)
    {
      RIJAppSetting.c(2);
      return;
    }
    if (paramInt == 5)
    {
      RIJAppSetting.c(1);
      return;
    }
    if (paramInt == 1)
    {
      RIJAppSetting.c(4);
      return;
    }
    if ((paramInt != 6) && (paramInt != 9))
    {
      RIJAppSetting.c(5);
      return;
    }
    RIJAppSetting.c(7);
  }
  
  private void f(boolean paramBoolean)
  {
    j(E);
    if (RIJUGCDianDian.a()) {
      b(2130843922);
    }
    ReadInJoyScreenShotReporter.a(this).a();
    if (paramBoolean) {
      PublicTracker.a(null, "subscribe_tab_cost");
    }
  }
  
  private void j(int paramInt)
  {
    View localView = this.I;
    if (localView != null) {
      localView.setBackgroundColor(paramInt);
    }
  }
  
  private void k(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 17: 
      ReadInJoyHelper.g(getAppRuntime(), ReadInJoyHelper.m(getAppRuntime()) ^ true);
      return;
    case 16: 
      ReadInJoyHelper.u(getAppRuntime(), ReadInJoyHelper.ab(getAppRuntime()) ^ true);
      return;
    case 15: 
      ReadInJoyHelper.f(getAppRuntime(), ReadInJoyHelper.l(getAppRuntime()) ^ true);
      return;
    case 14: 
      FPSMonitor.a().a(FPSMonitor.a().b() ^ true);
      if (FPSMonitor.a().b())
      {
        FPSMonitor.a().a(this);
        return;
      }
      FPSMonitor.a().a(this);
      return;
    case 13: 
      RIJShowKanDianTabSp.a(getAppRuntime(), "debug_kd_tab_type", "0");
      QQToast.makeText(getApplicationContext(), HardCodeUtil.a(2131910354), 0).show();
      return;
    case 12: 
      RIJShowKanDianTabSp.a(getAppRuntime(), "debug_kd_tab_type", "3");
      QQToast.makeText(getApplicationContext(), HardCodeUtil.a(2131910590), 0).show();
      return;
    case 11: 
      RIJShowKanDianTabSp.a(getAppRuntime(), "debug_kd_tab_type", "2");
      QQToast.makeText(getApplicationContext(), HardCodeUtil.a(2131910510), 0).show();
      return;
    case 10: 
      RIJShowKanDianTabSp.a(getAppRuntime(), "debug_kd_tab_type", "1");
      QQToast.makeText(getApplicationContext(), HardCodeUtil.a(2131910438), 0).show();
      return;
    case 9: 
      ReadInJoyHelper.i(getAppRuntime(), ReadInJoyHelper.o(getAppRuntime()) ^ true);
      QQToast.makeText(getApplicationContext(), HardCodeUtil.a(2131910619), 0).show();
      return;
    case 6: 
      ReadInJoyHelper.h(getAppRuntime(), ReadInJoyHelper.n(getAppRuntime()) ^ true);
      return;
    case 5: 
      ReadInJoyHelper.e(getAppRuntime(), ReadInJoyHelper.k(getAppRuntime()) ^ true);
      return;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 7: 
      l(paramInt);
      return;
    case 0: 
      ReadInJoyHelper.b(getAppRuntime(), ReadInJoyHelper.e(getAppRuntime()) ^ true);
      ReadInJoyLogicEngineEventDispatcher.a().c();
    }
  }
  
  private void l(int paramInt)
  {
    if (paramInt == 1)
    {
      RIJGetArticleListHandler.g = -2;
    }
    else if (paramInt == 2)
    {
      RIJGetArticleListHandler.g = -1;
    }
    else if (paramInt == 3)
    {
      RIJGetArticleListHandler.g = 1;
    }
    else if (paramInt == 4)
    {
      RIJGetArticleListHandler.g = 0;
    }
    else if (paramInt == 7)
    {
      boolean bool = FeedsSPUtils.a(getAppRuntime());
      FeedsSPUtils.a(getAppRuntime(), bool ^ true);
      QQToast.makeText(getApplicationContext(), HardCodeUtil.a(2131910246), 0).show();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("readinjoy setting feeds type:");
    localStringBuilder.append(RIJGetArticleListHandler.g);
    QLog.d("ReadInJoyNewFeedsActivity", 1, localStringBuilder.toString());
  }
  
  private void v()
  {
    Object localObject = this.app;
    if (localObject != null)
    {
      localObject = (ReadInJoySkinManager)((AppInterface)localObject).getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
      if (localObject != null) {
        ((ReadInJoySkinManager)localObject).a(this);
      }
    }
  }
  
  private void w()
  {
    Object localObject = this.app;
    if (localObject != null)
    {
      localObject = (ReadInJoySkinManager)((AppInterface)localObject).getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
      ((ReadInJoySkinManager)localObject).b(this);
      ((ReadInJoySkinManager)localObject).a();
    }
  }
  
  private void x()
  {
    QLog.d("ReadInJoyNewFeedsActivity", 2, "reportKandianTabRedInfo.");
    if (this.J == null) {
      this.J = ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    }
    SparseIntArray localSparseIntArray = this.J.G();
    if (localSparseIntArray.get(0) <= 0) {
      localSparseIntArray.put(0, this.J.R());
    }
    localSparseIntArray.put(3, 0);
    int i1 = 0;
    if (i1 < 4) {
      if (localSparseIntArray.get(i1) <= 0) {}
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = RIJTransMergeKanDianReport.d();
        localJSONObject.put("kandian_mode", RIJAppSetting.b());
        localJSONObject.put("tab_source", i1 + 1);
        if (i1 != 2) {
          break label209;
        }
        long l1 = this.J.x();
        if (l1 == 0L) {
          break label209;
        }
        int i2 = this.J.y();
        String str1 = String.valueOf(l1);
        str3 = String.valueOf(i2);
        PublicAccountReportUtils.a(null, "CliOper", "", str1, "0X80081C6", "0X80081C6", 0, 1, null, null, str3, localJSONObject.toString(), false);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      i1 += 1;
      break;
      return;
      label209:
      String str2 = "";
      String str3 = str2;
    }
  }
  
  private void y()
  {
    this.ad = new ChannelCoverInfo();
    ChannelCoverInfo localChannelCoverInfo = this.ad;
    localChannelCoverInfo.mChannelCoverId = 0;
    localChannelCoverInfo.mChannelCoverName = HardCodeUtil.a(2131910484);
    this.ad.mChannelType = 0;
  }
  
  private void z()
  {
    GuideData localGuideData = this.W;
    if (localGuideData != null)
    {
      this.W = null;
      ThreadManager.post(new ReadInJoyNewFeedsActivity.8(this, localGuideData), 8, null, true);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Bundle paramBundle, boolean paramBoolean)
  {
    int i1;
    if ((paramInt1 >= 0) && (paramInt1 < 4)) {
      i1 = paramInt1;
    } else {
      i1 = 0;
    }
    this.O = this.K;
    boolean bool2 = a(paramInt1);
    paramInt1 = this.J.e(i1);
    a(i1, paramInt2, paramBundle);
    setTitle(((ReadInJoyNewFeedsActivity.TabInfo)h.get(Integer.valueOf(i1))).a);
    g(8);
    c(i1);
    j(-1);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("setSelection from tab ");
      paramBundle.append(this.K);
      paramBundle.append(" to tab ");
      paramBundle.append(i1);
      paramBundle.append(", jumpType:");
      paramBundle.append(paramInt2);
      QLog.d("ReadInJoyNewFeedsActivity", 2, paramBundle.toString());
    }
    boolean bool1;
    if (this.K == i1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.K = i1;
    g = this.K;
    k();
    if (paramBoolean) {
      a(i1, paramInt1, bool1, bool2);
    }
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 == 3)
          {
            PublicTracker.a(null, "self_tab_cost");
            ReadInJoyScreenShotReporter.a(this).a();
          }
        }
        else {
          f(paramBoolean);
        }
      }
      else {
        a(paramInt1, paramBoolean);
      }
    }
    else {
      e(paramBoolean);
    }
    ReadInJoyGlobalReporter.c(j().d());
    this.d = false;
  }
  
  protected void a(int paramInt, String paramString, BaseResData paramBaseResData)
  {
    ReadInJoyBaseResManager localReadInJoyBaseResManager = (ReadInJoyBaseResManager)this.app.getManager(paramInt);
    if (localReadInJoyBaseResManager.b(paramString, paramBaseResData))
    {
      String str = localReadInJoyBaseResManager.a(paramString, paramBaseResData.id);
      if (localReadInJoyBaseResManager.c(paramString, paramBaseResData))
      {
        if ((QQManagerFactory.READ_INJOY_SKIN_MANAGER == paramInt) && (SharedPreUtils.bt(this, paramBaseResData.id) != paramBaseResData.seq))
        {
          FileUtils.deleteDirectory(str);
          localReadInJoyBaseResManager.e(paramString, paramBaseResData);
          return;
        }
        localReadInJoyBaseResManager.d(paramString, paramBaseResData);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("showSkinGuide：real: ");
          paramString.append(paramBaseResData.id);
          QLog.d("ReadInJoyNewFeedsActivity", 2, paramString.toString());
        }
        if ((paramBaseResData instanceof GuideData))
        {
          paramString = (GuideData)paramBaseResData;
          this.V.post(new ReadInJoyNewFeedsActivity.5(this, paramString, str, paramInt));
        }
      }
      else
      {
        localReadInJoyBaseResManager.e(paramString, paramBaseResData);
      }
    }
  }
  
  public void a(View paramView)
  {
    ReadInJoyNewFeedsTopGestureLayout localReadInJoyNewFeedsTopGestureLayout = this.i;
    if (localReadInJoyNewFeedsTopGestureLayout != null) {
      localReadInJoyNewFeedsTopGestureLayout.a(paramView);
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "onKandianMsgNotification.");
    }
    h();
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    if (paramInt == KandianOx210MsgInfo.y)
    {
      if (this.mIsResume) {
        B();
      } else {
        this.aa = true;
      }
      paramMessageRecord = this.J;
      if ((paramMessageRecord != null) && (paramMessageRecord.P())) {
        ReadInJoyWebDataManager.a().a(this.app.getCurrentAccountUin(), 1);
      }
    }
    else if (paramInt == KandianOx210MsgInfo.z)
    {
      a(paramBundle);
    }
  }
  
  public void a(ReadInJoyBaseFragment paramReadInJoyBaseFragment)
  {
    this.ac = paramReadInJoyBaseFragment;
  }
  
  @TargetApi(23)
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      return;
    }
    getWindow().getDecorView().setSystemUiVisibility(0);
  }
  
  public boolean a(int paramInt)
  {
    return this.G.c(paramInt).d;
  }
  
  public void b()
  {
    PublicTracker.a(null, "KANDIAN_NEW_FEEDS_INIT_UI");
    this.F = getSupportFragmentManager();
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.i = new ReadInJoyNewFeedsTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.i.a());
      this.i.a().setOnFlingGesture(this);
    }
    setContentView(2131626011);
    this.G = ((ReadinjoyTabbar)findViewById(2131446764));
    this.H = findViewById(2131446739);
    this.I = findViewById(2131447724);
    y();
    f();
    e();
    if (ThemeUtil.isInNightMode(this.app)) {
      u();
    }
    ReadInJoyFragmentFactory.a().a(this);
    if ((this.u != null) && (this.N != 5)) {
      this.u.setText(getString(2131887625));
    }
    QQMessageFacade localQQMessageFacade = this.app.getMessageFacade();
    if (localQQMessageFacade != null) {
      d(localQQMessageFacade.w());
    }
    this.j = ((FrameLayout)findViewById(2131433079));
    PublicTracker.a("KANDIAN_NEW_FEEDS_INIT_UI", null);
    this.A.setOnClickListener(this);
    try
    {
      this.e = new ReadInJoyNaviController(this.j, new ReadInJoyNavigationGridview(this, new ReadInJoyNewFeedsActivity.NaviMaskTouchListenerImpl(this)), this.A);
      this.e.a = getTitleBarHeight();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("ReadInJoyNewFeedsActivity", 1, "init ReadInJoyNavigationGridView Exception or Error.");
      localThrowable.printStackTrace();
    }
  }
  
  protected void b(int paramInt)
  {
    super.i(paramInt);
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "onSubscribeMsgNotification.");
    }
    h();
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.K == 0) {
      this.G.setTabState(0, paramBoolean);
    }
  }
  
  public void c()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (ThemeUtil.isInNightMode(this.app))
      {
        if ((!SystemUtil.d()) && (!SystemUtil.g()))
        {
          this.mSystemBarComp.setStatusBarColor(-7829368);
          this.C.setBackgroundColor(-7829368);
          return;
        }
        this.mSystemBarComp.setStatusBarColor(-7829368);
        this.C.setBackgroundColor(-7829368);
        this.mSystemBarComp.setStatusBarDarkMode(true);
        return;
      }
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.d()) && (!SystemUtil.g()))
      {
        a(true);
        this.mSystemBarComp.setStatusBarColor(-1);
        this.C.setBackgroundColor(-1);
        return;
      }
      if (!SystemUtil.g())
      {
        this.mSystemBarComp.setStatusBarColor(-2368549);
        this.C.setBackgroundColor(-2368549);
        return;
      }
      this.mSystemBarComp.setStatusBarColor(-1);
      this.C.setBackgroundColor(-1);
      this.mSystemBarComp.setStatusBarDarkMode(true);
    }
  }
  
  public void c(int paramInt)
  {
    if (SystemUtil.f())
    {
      h(((ReadInJoyNewFeedsActivity.TabInfo)h.get(Integer.valueOf(paramInt))).c);
      BaseSkinRes localBaseSkinRes = ((ReadInJoySkinManager)this.app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a(8);
      if (localBaseSkinRes != null) {
        this.G.setSelectColor(localBaseSkinRes.b());
      }
    }
    else
    {
      ThreadManager.post(new ReadInJoyNewFeedsActivity.13(this, paramInt), 5, null, false);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.J == null) {
      this.J = ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    }
    SparseIntArray localSparseIntArray = this.J.G();
    if (!paramBoolean)
    {
      if (localSparseIntArray.get(0) > 0) {
        localSparseIntArray.put(0, 10);
      }
    }
    else {
      localSparseIntArray.put(0, 0);
    }
    localSparseIntArray.put(0, this.J.R());
    localSparseIntArray.put(3, 0);
    int i1 = 0;
    while (i1 < 4)
    {
      ReadinjoyTabbar localReadinjoyTabbar = this.G;
      int i2 = ((ReadInJoyNewFeedsActivity.TabInfo)h.get(Integer.valueOf(i1))).b;
      paramBoolean = true;
      if (i2 != 1) {
        paramBoolean = false;
      }
      localReadinjoyTabbar.a(i1, paramBoolean, localSparseIntArray.get(i1));
      i1 += 1;
    }
  }
  
  protected void d()
  {
    c(this.K);
    ReadInJoySkinManager localReadInJoySkinManager = (ReadInJoySkinManager)this.app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    int i1 = 0;
    while (i1 < 4)
    {
      BaseSkinRes localBaseSkinRes = localReadInJoySkinManager.a(i1 + 4);
      if (localBaseSkinRes != null)
      {
        BaseTabbar.TabHolder localTabHolder = this.G.c(i1).c;
        localTabHolder.f.setImageDrawable(localBaseSkinRes.a());
        if (i1 == this.K)
        {
          localTabHolder.f.setSelected(true);
          this.G.a(i1, i1);
        }
      }
      if (localReadInJoySkinManager.c() == 1) {
        this.G.setTabState(i1, false);
      }
      i1 += 1;
    }
  }
  
  void d(int paramInt)
  {
    Boolean localBoolean = Boolean.valueOf(true);
    if ((this.N != 5) || (this.L)) {
      localBoolean = Boolean.valueOf(false);
    }
    if (localBoolean.booleanValue()) {
      runOnUiThread(new ReadInJoyNewFeedsActivity.16(this, paramInt));
    }
  }
  
  public void da_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "onTabRedNumsChange.");
    }
    g();
    h();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    int i2;
    int i1;
    if (paramInt1 == 9992)
    {
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("isNeedFinish", false))) {
        finish();
      }
    }
    else
    {
      boolean bool;
      if (paramInt1 == 103)
      {
        if (paramInt2 == -1)
        {
          bool = paramIntent.getBooleanExtra("bFailed", false);
          localObject = new QQToast(this);
          ((QQToast)localObject).setDuration(2000);
          if ((bool ^ true))
          {
            ((QQToast)localObject).setToastIcon(QQToast.getIconRes(2));
            ((QQToast)localObject).setToastMsg(2131889172);
            ((QQToast)localObject).show(getApplicationContext().getResources().getDimensionPixelSize(2131299920) - (int)DisplayUtils.a(getApplicationContext(), 5.0F));
          }
          else
          {
            ((QQToast)localObject).setToastIcon(QQToast.getIconRes(1));
            ((QQToast)localObject).setToastMsg(2131889173);
            ((QQToast)localObject).show(getApplicationContext().getResources().getDimensionPixelSize(2131299920) - (int)DisplayUtils.a(getApplicationContext(), 5.0F));
          }
        }
      }
      else if (paramInt1 == 9991)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyNewFeedsActivity", 2, "back from article detail");
        }
        if (RIJWebSearchUtils.a())
        {
          bool = TextUtils.isEmpty(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).readInJoyReleaseWebServiceConfig());
          i2 = 80;
          i1 = i2;
          if (bool) {}
        }
      }
    }
    try
    {
      i1 = new JSONObject(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).readInJoyReleaseWebServiceConfig()).optInt("releaseServiceMinMem", 80);
      long l1 = DeviceInfoUtil.r();
      if (l1 >>> 20 <= i1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyNewFeedsActivity", 2, "back from article detail, release web core service");
        }
        ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).stopWebCoreService();
      }
      try
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
        ((HashMap)localObject).put("param_totalMem", String.valueOf(DeviceInfoUtil.a()));
        ((HashMap)localObject).put("param_availableMem", String.valueOf(l1));
        ((HashMap)localObject).put("param_cpuNum", String.valueOf(DeviceInfoUtil.h()));
        ((HashMap)localObject).put("param_cpuFreq", String.valueOf(DeviceInfoUtil.k()));
        ((HashMap)localObject).put("param_releaseType", String.valueOf(0));
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("releaseWebCoreServiceReport:");
          localStringBuilder.append(((HashMap)localObject).toString());
          QLog.d("ReadInJoyNewFeedsActivity", 2, localStringBuilder.toString());
        }
        StatisticCollector.getInstance(this).collectPerformance(this.app.getCurrentAccountUin(), "actReadInJoyReleaseWebService", true, 0L, 0L, (HashMap)localObject, "");
      }
      catch (Exception localException2)
      {
        label485:
        break label485;
      }
      if (this.G.c(this.K).a() != null) {
        this.G.c(this.K).a().a(paramInt1, paramInt2, paramIntent);
      }
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        i1 = i2;
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    PublicTracker.a("KANDIAN_NEW_FEEDS_ACTIVITY_MANAGER", null);
    PublicTracker.a(null, "KANDIAN_NEW_FEEDS_CREATE");
    VideoVolumeControl.getInstance().inKandianModule(this);
    VideoReport.addToDetectionWhitelist(this);
    super.doOnCreate(paramBundle);
    a.add(String.valueOf(hashCode()));
    com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshManager.j = false;
    ReadinjoyReportUtils.a(this.app);
    ReadInJoyHelper.z(this.app);
    ReadInJoyHelper.D(this.app);
    ViolaSoLoaderManager.a.a().a();
    ReadInJoyWebRenderEngine.e();
    this.P = System.currentTimeMillis();
    paramBundle = getIntent();
    Bundle localBundle = paramBundle.getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("key_notification_click_action", false))) {
      ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).u();
    }
    this.J = ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    this.J.a(this);
    this.J.a(this);
    this.L = paramBundle.getBooleanExtra("from_search", false);
    this.M = paramBundle.getBooleanExtra("from_javascript", false);
    this.N = paramBundle.getIntExtra("launch_from", 5);
    f(this.N);
    int i1 = this.N;
    if (6 == i1)
    {
      RIJKanDianFolderStatus.updateMergeKandianFolderStatus(3);
      RIJLockScreenPushReport.a();
    }
    else if (9 == i1)
    {
      RIJKanDianFolderStatus.updateMergeKandianFolderStatus(3);
    }
    else if (1 == i1)
    {
      RIJKanDianFolderStatus.updateMergeKandianFolderStatus(8);
    }
    else if (2 == i1)
    {
      RIJKanDianFolderStatus.updateMergeKandianFolderStatus(8);
    }
    else if (11 == i1)
    {
      ReadInJoyLogicEngineEventDispatcher.a().c("onConversationJumpRestoreStack");
    }
    ReadInJoyLogicEngineEventDispatcher.a().b();
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    i1 = NetworkUtil.getSystemNetwork(getApplication());
    if ((i1 == 4) || (i1 == 1)) {
      ThreadManager.post(new ReadInJoyNewFeedsActivity.2(this), 5, null, true);
    }
    ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.MyRunnable(this, this));
    b();
    getWindow().setBackgroundDrawable(null);
    paramBundle = (ReadInJoyLogicManager)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    ReadInJoyLogicEngine.a().C();
    ReadInJoyLogicEngine.a().x();
    if (this.app.getMessageFacade() != null) {
      this.app.getMessageFacade().addObserver(this);
    }
    if (ReadInJoyHelper.a(this.app)) {
      TroopBarAssistantManager.a().d(this.app);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.n);
    ReadInJoyHelper.c(this.app);
    this.c = RIJKanDianFolderStatus.reportFolderStatus;
    ReadinjoyReportUtils.a(ReadinjoyReportUtils.a(), true, 0L, this.c, 0);
    RIJThreadHandler.a(RIJQQAppInterfaceUtil.c());
    B();
    if (this.J.P()) {
      ReadInJoyWebDataManager.a().a(this.app.getCurrentAccountUin(), 1);
    }
    PublicTracker.a("KANDIAN_NEW_FEEDS_CREATE", null);
    PublicTracker.a(null, "KANDIAN_NEW_FEEDS_CREATE_TO_RESUME");
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    i1 = RIJAppSetting.b();
    int i2 = RIJKanDianFolderStatus.reportFolderStatus;
    ReadInJoyGlobalReporter.e().a(this.app, l1, i1, i2);
    ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.3(this, l1, i1, i2));
    v();
    this.l = new ReadInjoySkinAndRefreshFacade(this.app, 0);
    this.l.a(new ReadInJoyNewFeedsActivity.4(this));
    this.l.a();
    c();
    ThreadManager.getFileThreadHandler().postDelayed(this.Z, 20000L);
    ReadInJoyGlobalReporter.c(0);
    RIJPushNotification.c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    long l1 = System.currentTimeMillis();
    try
    {
      int i1 = this.G.getSelectedTabIndex();
      ((ReadInJoyLogicManager)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().n(i1);
    }
    catch (Exception localException)
    {
      QLog.d("ReadInJoyNewFeedsActivity", 1, "saveLeaveKanDianTab throw Exception.");
      localException.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, new Object[] { "saveLeaveKanDianTab time cost: ", Long.valueOf(System.currentTimeMillis() - l1) });
    }
    ((IRIJADExposureService)RIJQQAppInterfaceUtil.a().getRuntimeService(IRIJADExposureService.class)).reportAllInvalidADExposure(getActivity());
    ReadInJoyScreenShotReporter.a(this).b();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.n);
    ReadInJoyFragmentFactory.a().b();
    ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
    w();
    Object localObject = this.k;
    if (localObject != null) {
      ((ReadInJoySkinGuideView)localObject).a();
    }
    a.remove(String.valueOf(hashCode()));
    super.doOnDestroy();
    this.Q = System.currentTimeMillis();
    l1 = this.Q - this.P;
    if (l1 > 0L) {
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066F7", "0X80066F7", 0, 0, Long.toString(l1 / 1000L), "", "", RIJTransMergeKanDianReport.c(), false);
    }
    if (this.app.getMessageFacade() != null) {
      this.app.getMessageFacade().deleteObserver(this);
    }
    localObject = (ReadInJoyLogicManager)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if ((localObject != null) && (((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine() != null))
    {
      localObject = ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().e();
      if (localObject != null) {
        ((ReadInJoyUserInfoModule)localObject).c();
      }
    }
    this.J.b(this);
    this.J.b(this);
    this.J.S();
    ReadInJoyLogicEngine.a().D();
    VideoVolumeControl.getInstance().outKandianModule(this);
    PreloadManager.a().c();
    PreloadManager.a().h();
    ReadinjoyReportUtils.a(ReadinjoyReportUtils.a(), false, this.P, this.c, this.U);
    PublicTracker.a();
    ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).stopWebCoreService();
    ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).releaseLightWebProcess();
    ReadInJoyWebDataManager.b();
    ReadInJoyWebDataManager.a().e();
    i();
    ((ReadInJoySkinManager)this.app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).b(this);
    this.l.b();
    localObject = this.f;
    if (localObject != null)
    {
      FileUtils.deleteDirectory(CommonSkinRes.a((String)localObject));
      this.f = null;
    }
    ReadInJoyGlobalReporter.e().a();
    ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.12(this));
    localObject = this.e;
    if (localObject != null) {
      ((ReadInJoyNaviController)localObject).b();
    }
    localObject = ReadInJoyLogicEngine.a().U();
    if (localObject != null) {
      ((FreeNetFlowInfoModule)localObject).a(false);
    }
    ThreadManager.getFileThreadHandler().removeCallbacks(this.Z);
    UserActionCollector.a().d();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.L = paramIntent.getBooleanExtra("from_search", false);
    this.M = paramIntent.getBooleanExtra("from_javascript", false);
    this.N = paramIntent.getIntExtra("launch_from", 5);
    f(this.N);
    if ((this.u != null) && (this.N != 5)) {
      this.u.setText(getString(2131887625));
    }
    a(paramIntent.getIntExtra("target_fragment", 0), 258, paramIntent.getExtras(), false);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    AbstractGifImage.pauseAll();
    this.G.d(3);
    ReadInJoyScreenShotReporter.a(this).a();
    ReadInJoyLogicEngine.L();
    ReadInJoySkinGuideView localReadInJoySkinGuideView = this.k;
    if (localReadInJoySkinGuideView != null) {
      localReadInJoySkinGuideView.b();
    }
  }
  
  protected void doOnResume()
  {
    PublicTracker.a("KANDIAN_NEW_FEEDS_CREATE_TO_RESUME", null);
    PublicTracker.a(null, "KANDIAN_NEW_FEEDS_RESUME");
    ReadInJoyFragmentFactory.a().a(this);
    super.doOnResume();
    if (this.X)
    {
      a(this.O, 257, null, false);
      this.X = false;
    }
    if (this.K == 0) {
      g(0);
    } else {
      g(8);
    }
    if ((getIntent() != null) && (getIntent().getExtras() != null) && (getIntent().hasExtra("notification_message_id")))
    {
      String str = getIntent().getExtras().getString("notification_message_id", "");
      if ((!str.isEmpty()) && (RIJMsgBoxUtils.b() == 2) && (RIJKanDianLockScreenPushAladdinConfig.b() == 2)) {
        ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(2, str);
      }
      getIntent().removeExtra("notification_message_id");
      if ((RIJKanDianLockScreenPushAladdinConfig.b() == 1) || (RIJMsgBoxUtils.b() != 2)) {
        a(str);
      }
    }
    d();
    c(this.b ^ true);
    h();
    x();
    if (!this.b)
    {
      this.b = true;
      PublicTracker.a("KANDIAN_FEEDS_STAGE_1_COST", null);
    }
    AbstractGifImage.resumeAll();
    if (this.aa) {
      this.V.postDelayed(new ReadInJoyNewFeedsActivity.10(this), 1000L);
    }
    int i1 = this.K;
    if (i1 != 0)
    {
      if (i1 != 1) {
        ReadInJoyScreenShotReporter.a(this).a();
      } else {
        ReadInJoyScreenShotReporter.a(this).a(3, 56);
      }
    }
    else {
      ReadInJoyScreenShotReporter.a(this).a(0, 0);
    }
    PublicTracker.a("KANDIAN_NEW_FEEDS_RESUME", null);
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    this.R = System.currentTimeMillis();
    ReadInJoyLogicEngine.a().E();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    VideoVolumeControl.getInstance().requestOrAbandonAudioFocus(false, "readinjoy tab doOnStop");
    this.S = System.currentTimeMillis();
    this.T += this.S - this.R;
    ReadInJoyLogicEngine.a().F();
  }
  
  public void e()
  {
    this.t.setContentDescription(HardCodeUtil.a(2131910509));
    this.t.setOnClickListener(this);
    this.y.setOnClickListener(this);
    findViewById(2131444899).setOnClickListener(this);
  }
  
  public void e(int paramInt)
  {
    this.U = (paramInt | this.U);
  }
  
  public void f()
  {
    this.G.setEnableRepeatedClick(true);
    this.G.setCurrentActivity(this);
    ReadInJoySkinManager localReadInJoySkinManager = (ReadInJoySkinManager)this.app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    int i1 = 0;
    while (i1 < 4)
    {
      this.G.a(i1, ((ReadInJoyNewFeedsActivity.TabInfo)h.get(Integer.valueOf(i1))).a);
      if (localReadInJoySkinManager.c() != 0)
      {
        BaseSkinRes localBaseSkinRes = localReadInJoySkinManager.a(i1 + 4);
        if (localBaseSkinRes != null) {
          this.G.c(i1).c.f.setImageDrawable(localBaseSkinRes.a());
        }
      }
      i1 += 1;
    }
    this.G.setOnTabChangeListener(this.m);
    i1 = getIntent().getIntExtra("tab_tab_index", 0);
    if (i1 > 0) {
      this.K = i1;
    } else {
      this.K = 0;
    }
    for (;;)
    {
      try
      {
        if ((this.J.d()) || (System.currentTimeMillis() - ReadInJoyHelper.c(this.app) > 600000L) || (this.N == 1)) {
          break label280;
        }
        if (this.N != 9) {
          break label275;
        }
      }
      catch (Exception localException)
      {
        QLog.d("ReadInJoyNewFeedsActivity", 1, "restoreHistoryKanDianTab throw Exception.");
        localException.printStackTrace();
      }
      if ((i1 == 0) && (RIJAppSetting.b(p()))) {
        this.K = ((ReadInJoyLogicManager)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().T();
      }
      i1 = this.K;
      g = i1;
      this.d = true;
      this.G.setSelectedTab(i1, false);
      return;
      label275:
      i1 = 0;
      continue;
      label280:
      i1 = 1;
    }
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void flingLToR()
  {
    ReadInJoyBaseFragment localReadInJoyBaseFragment = this.ac;
    if ((localReadInJoyBaseFragment == null) || (!localReadInJoyBaseFragment.o())) {
      onBackPressed();
    }
  }
  
  public void flingRToL() {}
  
  public void g()
  {
    c(false);
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "setRecommendRedDotInfo.");
    }
    ChannelCoverInfo localChannelCoverInfo = this.ad;
    if ((localChannelCoverInfo != null) && (localChannelCoverInfo.mChannelCoverId == 0)) {}
    for (;;)
    {
      try
      {
        if (this.J == null) {
          this.J = ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
        }
        if (this.J.P()) {
          return;
        }
        if (!this.J.d()) {
          break label104;
        }
        i1 = 1;
        RIJThreadHandler.b().post(new ReadInJoyNewFeedsActivity.7(this, i1));
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label104:
      int i1 = 0;
    }
  }
  
  public void i()
  {
    Iterator localIterator = this.ab.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      localObject = (ReadInJoySubChannelFragment)this.ab.get(localObject);
      if (localObject != null) {
        ((ReadInJoySubChannelFragment)localObject).onDestroy();
      }
    }
    this.ab.clear();
  }
  
  public ReadInJoyBaseFragment j()
  {
    return this.ac;
  }
  
  protected void k()
  {
    if (this.G.c(this.K).a() != null) {
      super.d(this.G.c(this.K).a().m());
    }
  }
  
  void l()
  {
    if (this.u != null) {
      ThreadManager.post(new ReadInJoyNewFeedsActivity.15(this), 5, null, true);
    }
  }
  
  public ReadinjoyTabbar n()
  {
    return this.G;
  }
  
  public long o()
  {
    return this.T;
  }
  
  protected boolean onBackEvent()
  {
    if (this.K == 0)
    {
      localObject = this.e;
      if ((localObject != null) && (((ReadInJoyNaviController)localObject).c()))
      {
        this.e.a(null);
        return true;
      }
    }
    Object localObject = this.G;
    if ((localObject != null) && (((ReadinjoyTabbar)localObject).c(this.K) != null))
    {
      localObject = this.G.c(this.K).a();
      if ((localObject instanceof ReadInJoyVideoChannelFragment))
      {
        localObject = ((ReadInJoyVideoChannelFragment)localObject).a();
        if ((localObject != null) && (((VideoPlayManager)localObject).k() != null) && (((VideoPlayManager)localObject).k().c()))
        {
          ((VideoPlayManager)localObject).k().p();
          return true;
        }
      }
      else if (((localObject instanceof ReadInJoyRecommendFeedsFragment)) && (((ReadInJoyRecommendFeedsFragment)localObject).w()))
      {
        return true;
      }
    }
    localObject = this.ac;
    if ((localObject != null) && (((ReadInJoyBaseFragment)localObject).onBackEvent())) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131436194)
    {
      if (i1 != 2131444899)
      {
        switch (i1)
        {
        default: 
          return;
        }
        if (this.K == 0)
        {
          paramView = this.e;
          if (paramView != null)
          {
            if (paramView.c())
            {
              this.e.a(null);
              return;
            }
            if ((j() instanceof ReadInJoySubChannelFragment))
            {
              this.e.a(j().d());
              return;
            }
            this.e.a(0);
            return;
          }
        }
        try
        {
          this.G.c(this.K).a().h();
          return;
        }
        catch (Throwable paramView)
        {
          paramView.printStackTrace();
          QLog.d("ReadInJoyNewFeedsActivity", 1, "notifyTitleClick failed.");
          return;
        }
      }
      j().l();
      ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.14(this));
      return;
    }
    if ((this.K == 2) && (RIJUGCDianDian.a()))
    {
      RIJUGCDianDian.a(this, this.r);
      PublicAccountReportUtils.a(null, "", "0X8008C5F", "0X8008C5F", 0, 0, "", "", "", RIJTransMergeKanDianReport.e(), false);
      return;
    }
    RIJWebSearchUtils.a(this);
    UniteSearchReportController.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), new ReportModelDC02528().opername("Kdian_inner_search").module("kd_web_search").action("clk_search"));
  }
  
  public long p()
  {
    return this.P;
  }
  
  public boolean q()
  {
    return this.U != 0;
  }
  
  public int r()
  {
    return this.K;
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((!this.L) && (!this.M) && ((paramObject instanceof MessageRecord)))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((KandianMergeManager.a(paramObservable, this.app) == -1) && (paramObservable.extInt != 5) && (!paramObservable.isSendFromLocal())) {
        l();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity
 * JD-Core Version:    0.7.0.1
 */