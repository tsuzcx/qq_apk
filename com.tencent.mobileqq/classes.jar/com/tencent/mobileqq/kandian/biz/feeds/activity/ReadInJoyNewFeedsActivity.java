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
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyDialogUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyRecommendFeedsFragment;
import com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoySubChannelFragment;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.RIJUGCDianDian;
import com.tencent.mobileqq.kandian.biz.framework.RIJWebSearchUtils;
import com.tencent.mobileqq.kandian.biz.framework.UserActionCollector;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
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
  public static List<String> a;
  public static ConcurrentHashMap<Integer, ReadInJoyNewFeedsActivity.TabInfo> a;
  public static int b;
  private static final int jdField_d_of_type_Int = Color.parseColor("#dedfe0");
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  protected FrameLayout a;
  private FragmentManager jdField_a_of_type_AndroidxFragmentAppFragmentManager;
  protected ReadInJoyNewFeedsTopGestureLayout a;
  BaseTabbar.OnTabChangeListener jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBaseTabbar$OnTabChangeListener = new ReadInJoyNewFeedsActivity.9(this);
  private ReadInJoyBaseFragment jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment;
  private GuideData jdField_a_of_type_ComTencentMobileqqKandianBizSkinGuideData;
  protected ReadInJoySkinGuideView a;
  protected ReadInjoySkinAndRefreshFacade a;
  public ReadInJoyNaviController a;
  private ReadinjoyTabbar jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar;
  private KandianMergeManager jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager = null;
  protected ReadInJoyObserver a;
  private ChannelCoverInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyNewFeedsActivity.1(this);
  protected String a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
  public boolean a;
  private long jdField_b_of_type_Long = 0L;
  private ConcurrentHashMap<Integer, ReadInJoySubChannelFragment> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  boolean jdField_b_of_type_Boolean = true;
  private long jdField_c_of_type_Long = 0L;
  private View jdField_c_of_type_AndroidViewView;
  private long jdField_d_of_type_Long = 0L;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 0;
  private long jdField_e_of_type_Long = 0L;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int = 0;
  private boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int = 0;
  private boolean jdField_h_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaUtilList = new ArrayList(1);
    jdField_b_of_type_Int = 0;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(0), new ReadInJoyNewFeedsActivity.TabInfo(HardCodeUtil.a(2131693524), 1, 0, -1, -857808928));
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(1), new ReadInJoyNewFeedsActivity.TabInfo(HardCodeUtil.a(2131712832), 2, 0, -1, -857808928));
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(2), new ReadInJoyNewFeedsActivity.TabInfo(HardCodeUtil.a(2131712981), 2, 0, -1, -857808928));
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(3), new ReadInJoyNewFeedsActivity.TabInfo(HardCodeUtil.a(2131712738), 2, 0, -1, -857808928));
  }
  
  public ReadInJoyNewFeedsActivity()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoyNewFeedsActivity.17(this);
  }
  
  private void a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.setSelection(paramInt1, this.jdField_e_of_type_Int, this.jdField_a_of_type_AndroidxFragmentAppFragmentManager, getIntent(), paramInt2, paramBundle);
    paramBundle = (ReadInJoySkinManager)this.app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    if (paramBundle.a() != 0)
    {
      paramBundle = paramBundle.a(paramInt1 + 4);
      if (paramBundle != null) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.a(paramInt1).a.c.setImageDrawable(paramBundle.a());
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.a(this.jdField_e_of_type_Int).a.c.setSelected(false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.a(paramInt1).a.c.setSelected(true);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.a(this.jdField_e_of_type_Int, paramInt1)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.a(paramInt1);
    }
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.b();
    if (paramInt1 == 3) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.b(paramInt1);
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
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007C40", "0X8007C40", 0, 0, "", "", "", VideoReporter.a(localReportR5Builder.getR5Object()), false);
    ReadInJoyScreenShotReporter.a(this).a(3, 56);
    if (paramBoolean) {
      PublicTracker.a(null, "video_tab_cost");
    }
  }
  
  private void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    }
    if ((paramBundle != null) && (paramBundle.getInt("BID_TYPE", 0) == 2))
    {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "reportSubscribeTabRedInfo.");
      long l = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.a();
      if (l != 0L) {
        try
        {
          paramBundle = RIJTransMergeKanDianReport.a();
          paramBundle.put("kandian_mode", RIJAppSetting.a());
          paramBundle.put("tab_source", 3);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", String.valueOf(l), "0X80081C6", "0X80081C6", 0, 1, null, null, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.b()), paramBundle.toString(), false);
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
    return jdField_a_of_type_JavaUtilList.size() > 0;
  }
  
  private int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    }
    return this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.a().get(3);
  }
  
  public static void e(int paramInt)
  {
    if (paramInt == 7)
    {
      RIJAppSetting.a(2);
      return;
    }
    if (paramInt == 5)
    {
      RIJAppSetting.a(1);
      return;
    }
    if (paramInt == 1)
    {
      RIJAppSetting.a(4);
      return;
    }
    if ((paramInt != 6) && (paramInt != 9))
    {
      RIJAppSetting.a(5);
      return;
    }
    RIJAppSetting.a(7);
  }
  
  private void e(boolean paramBoolean)
  {
    f(0);
    q();
    ReadInJoyScreenShotReporter.a(this).a(0, 0);
    if (paramBoolean) {
      PublicTracker.a(null, "recommend_tab_cost");
    }
  }
  
  private void f(boolean paramBoolean)
  {
    i(jdField_d_of_type_Int);
    if (RIJUGCDianDian.a()) {
      a(2130842966);
    }
    ReadInJoyScreenShotReporter.a(this).a();
    if (paramBoolean) {
      PublicTracker.a(null, "subscribe_tab_cost");
    }
  }
  
  private void i(int paramInt)
  {
    View localView = this.jdField_d_of_type_AndroidViewView;
    if (localView != null) {
      localView.setBackgroundColor(paramInt);
    }
  }
  
  private void j(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 17: 
      ReadInJoyHelper.g(getAppRuntime(), ReadInJoyHelper.h(getAppRuntime()) ^ true);
      return;
    case 16: 
      ReadInJoyHelper.t(getAppRuntime(), ReadInJoyHelper.y(getAppRuntime()) ^ true);
      return;
    case 15: 
      ReadInJoyHelper.f(getAppRuntime(), ReadInJoyHelper.g(getAppRuntime()) ^ true);
      return;
    case 14: 
      FPSMonitor.a().a(FPSMonitor.a().a() ^ true);
      if (FPSMonitor.a().a())
      {
        FPSMonitor.a().a(this);
        return;
      }
      FPSMonitor.a().a(this);
      return;
    case 13: 
      RIJShowKanDianTabSp.a(getAppRuntime(), "debug_kd_tab_type", "0");
      QQToast.a(getApplicationContext(), HardCodeUtil.a(2131712781), 0).a();
      return;
    case 12: 
      RIJShowKanDianTabSp.a(getAppRuntime(), "debug_kd_tab_type", "3");
      QQToast.a(getApplicationContext(), HardCodeUtil.a(2131713028), 0).a();
      return;
    case 11: 
      RIJShowKanDianTabSp.a(getAppRuntime(), "debug_kd_tab_type", "2");
      QQToast.a(getApplicationContext(), HardCodeUtil.a(2131712944), 0).a();
      return;
    case 10: 
      RIJShowKanDianTabSp.a(getAppRuntime(), "debug_kd_tab_type", "1");
      QQToast.a(getApplicationContext(), HardCodeUtil.a(2131712867), 0).a();
      return;
    case 9: 
      ReadInJoyHelper.i(getAppRuntime(), ReadInJoyHelper.j(getAppRuntime()) ^ true);
      QQToast.a(getApplicationContext(), HardCodeUtil.a(2131713058), 0).a();
      return;
    case 6: 
      ReadInJoyHelper.h(getAppRuntime(), ReadInJoyHelper.i(getAppRuntime()) ^ true);
      return;
    case 5: 
      ReadInJoyHelper.e(getAppRuntime(), ReadInJoyHelper.f(getAppRuntime()) ^ true);
      return;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 7: 
      k(paramInt);
      return;
    case 0: 
      ReadInJoyHelper.b(getAppRuntime(), ReadInJoyHelper.d(getAppRuntime()) ^ true);
      ReadInJoyLogicEngineEventDispatcher.a().c();
    }
  }
  
  private void k(int paramInt)
  {
    if (paramInt == 1)
    {
      RIJGetArticleListHandler.jdField_a_of_type_Int = -2;
    }
    else if (paramInt == 2)
    {
      RIJGetArticleListHandler.jdField_a_of_type_Int = -1;
    }
    else if (paramInt == 3)
    {
      RIJGetArticleListHandler.jdField_a_of_type_Int = 1;
    }
    else if (paramInt == 4)
    {
      RIJGetArticleListHandler.jdField_a_of_type_Int = 0;
    }
    else if (paramInt == 7)
    {
      boolean bool = FeedsSPUtils.a(getAppRuntime());
      FeedsSPUtils.a(getAppRuntime(), bool ^ true);
      QQToast.a(getApplicationContext(), HardCodeUtil.a(2131712668), 0).a();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("readinjoy setting feeds type:");
    localStringBuilder.append(RIJGetArticleListHandler.jdField_a_of_type_Int);
    QLog.d("ReadInJoyNewFeedsActivity", 1, localStringBuilder.toString());
  }
  
  private void m()
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
  
  private void n()
  {
    Object localObject = this.app;
    if (localObject != null)
    {
      localObject = (ReadInJoySkinManager)((AppInterface)localObject).getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
      ((ReadInJoySkinManager)localObject).b(this);
      ((ReadInJoySkinManager)localObject).a();
    }
  }
  
  private void o()
  {
    QLog.d("ReadInJoyNewFeedsActivity", 2, "reportKandianTabRedInfo.");
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    }
    SparseIntArray localSparseIntArray = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.a();
    if (localSparseIntArray.get(0) <= 0) {
      localSparseIntArray.put(0, this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.e());
    }
    localSparseIntArray.put(3, 0);
    int i = 0;
    if (i < 4) {
      if (localSparseIntArray.get(i) <= 0) {}
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = RIJTransMergeKanDianReport.a();
        localJSONObject.put("kandian_mode", RIJAppSetting.a());
        localJSONObject.put("tab_source", i + 1);
        if (i != 2) {
          break label221;
        }
        long l = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.a();
        if (l == 0L) {
          break label221;
        }
        int j = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.b();
        String str1 = String.valueOf(l);
        str3 = String.valueOf(j);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", str1, "0X80081C6", "0X80081C6", 0, 1, null, null, str3, localJSONObject.toString(), false);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      i += 1;
      break;
      return;
      label221:
      String str2 = "";
      String str3 = str2;
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo = new ChannelCoverInfo();
    ChannelCoverInfo localChannelCoverInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo;
    localChannelCoverInfo.mChannelCoverId = 0;
    localChannelCoverInfo.mChannelCoverName = HardCodeUtil.a(2131712914);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo.mChannelType = 0;
  }
  
  private void q()
  {
    GuideData localGuideData = this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinGuideData;
    if (localGuideData != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinGuideData = null;
      ThreadManager.post(new ReadInJoyNewFeedsActivity.8(this, localGuideData), 8, null, true);
    }
  }
  
  private void r()
  {
    int i = this.jdField_e_of_type_Int;
    if (i == 3) {
      return;
    }
    boolean bool;
    if (i == 0) {
      bool = ReadInJoyUtils.jdField_a_of_type_Boolean;
    } else if (i == 1) {
      bool = ReadInJoyUtils.jdField_a_of_type_Boolean;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTabRedNumsChange on");
      localStringBuilder.append(this.jdField_e_of_type_Int);
      localStringBuilder.append("and rednums is");
      localStringBuilder.append(b());
      QLog.d("ReadInJoyNewFeedsActivity", 2, localStringBuilder.toString());
    }
  }
  
  public int a()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_e_of_type_Long;
  }
  
  public ReadInJoyBaseFragment a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment;
  }
  
  public ReadinjoyTabbar a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar;
  }
  
  public void a()
  {
    PublicTracker.a(null, "KANDIAN_NEW_FEEDS_INIT_UI");
    this.jdField_a_of_type_AndroidxFragmentAppFragmentManager = getSupportFragmentManager();
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewReadInJoyNewFeedsTopGestureLayout = new ReadInJoyNewFeedsTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewReadInJoyNewFeedsTopGestureLayout.a());
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewReadInJoyNewFeedsTopGestureLayout.a().setOnFlingGesture(this);
    }
    setContentView(2131559968);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar = ((ReadinjoyTabbar)findViewById(2131378245));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131378221);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131379004);
    p();
    e();
    d();
    if (ThemeUtil.isInNightMode(this.app)) {
      l();
    }
    ReadInJoyFragmentFactory.a().a(this);
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_f_of_type_Int != 5)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690706));
    }
    QQMessageFacade localQQMessageFacade = this.app.getMessageFacade();
    if (localQQMessageFacade != null) {
      c(localQQMessageFacade.b());
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131366757));
    PublicTracker.a("KANDIAN_NEW_FEEDS_INIT_UI", null);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNaviController = new ReadInJoyNaviController(this.jdField_a_of_type_AndroidWidgetFrameLayout, new ReadInJoyNavigationGridview(this, new ReadInJoyNewFeedsActivity.NaviMaskTouchListenerImpl(this)), this.jdField_b_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNaviController.jdField_a_of_type_Int = getTitleBarHeight();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("ReadInJoyNewFeedsActivity", 1, "init ReadInJoyNavigationGridView Exception or Error.");
      localThrowable.printStackTrace();
    }
  }
  
  protected void a(int paramInt)
  {
    super.h(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, Bundle paramBundle, boolean paramBoolean)
  {
    int i;
    if ((paramInt1 >= 0) && (paramInt1 < 4)) {
      i = paramInt1;
    } else {
      i = 0;
    }
    this.jdField_g_of_type_Int = this.jdField_e_of_type_Int;
    boolean bool2 = a(paramInt1);
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.b(i);
    a(i, paramInt2, paramBundle);
    setTitle(((ReadInJoyNewFeedsActivity.TabInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i))).jdField_a_of_type_JavaLangString);
    f(8);
    b(i);
    i(-1);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("setSelection from tab ");
      paramBundle.append(this.jdField_e_of_type_Int);
      paramBundle.append(" to tab ");
      paramBundle.append(i);
      paramBundle.append(", jumpType:");
      paramBundle.append(paramInt2);
      QLog.d("ReadInJoyNewFeedsActivity", 2, paramBundle.toString());
    }
    boolean bool1;
    if (this.jdField_e_of_type_Int == i) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_e_of_type_Int = i;
    jdField_b_of_type_Int = this.jdField_e_of_type_Int;
    i();
    if (paramBoolean) {
      a(i, paramInt1, bool1, bool2);
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
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
    ReadInJoyGlobalReporter.c(a().b());
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected void a(int paramInt, String paramString, BaseResData paramBaseResData)
  {
    ReadInJoyBaseResManager localReadInJoyBaseResManager = (ReadInJoyBaseResManager)this.app.getManager(paramInt);
    if (localReadInJoyBaseResManager.a(paramString, paramBaseResData))
    {
      String str = localReadInJoyBaseResManager.a(paramString, paramBaseResData.id);
      if (localReadInJoyBaseResManager.b(paramString, paramBaseResData))
      {
        if ((QQManagerFactory.READ_INJOY_SKIN_MANAGER == paramInt) && (SharedPreUtils.d(this, paramBaseResData.id) != paramBaseResData.seq))
        {
          FileUtils.deleteDirectory(str);
          localReadInJoyBaseResManager.c(paramString, paramBaseResData);
          return;
        }
        localReadInJoyBaseResManager.b(paramString, paramBaseResData);
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
          this.jdField_a_of_type_MqqOsMqqHandler.post(new ReadInJoyNewFeedsActivity.5(this, paramString, str, paramInt));
        }
      }
      else
      {
        localReadInJoyBaseResManager.c(paramString, paramBaseResData);
      }
    }
  }
  
  public void a(View paramView)
  {
    ReadInJoyNewFeedsTopGestureLayout localReadInJoyNewFeedsTopGestureLayout = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewReadInJoyNewFeedsTopGestureLayout;
    if (localReadInJoyNewFeedsTopGestureLayout != null) {
      localReadInJoyNewFeedsTopGestureLayout.a(paramView);
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "onKandianMsgNotification.");
    }
    g();
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    if (paramInt == KandianOx210MsgInfo.k)
    {
      if (this.mIsResume) {
        r();
      } else {
        this.jdField_h_of_type_Boolean = true;
      }
      paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager;
      if ((paramMessageRecord != null) && (paramMessageRecord.i())) {
        ReadInJoyWebDataManager.a().a(this.app.getCurrentAccountUin(), 1);
      }
    }
    else if (paramInt == KandianOx210MsgInfo.l)
    {
      a(paramBundle);
    }
  }
  
  public void a(ReadInJoyBaseFragment paramReadInJoyBaseFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment = paramReadInJoyBaseFragment;
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
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.a(paramInt).jdField_b_of_type_Boolean;
  }
  
  public void aD_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "onTabRedNumsChange.");
    }
    f();
    g();
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void b()
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
        if ((!SystemUtil.b()) && (!SystemUtil.d()))
        {
          this.mSystemBarComp.setStatusBarColor(-7829368);
          this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-7829368);
          return;
        }
        this.mSystemBarComp.setStatusBarColor(-7829368);
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-7829368);
        this.mSystemBarComp.setStatusBarDarkMode(true);
        return;
      }
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
      {
        a(true);
        this.mSystemBarComp.setStatusBarColor(-1);
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
        return;
      }
      if (!SystemUtil.d())
      {
        this.mSystemBarComp.setStatusBarColor(-2368549);
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-2368549);
        return;
      }
      this.mSystemBarComp.setStatusBarColor(-1);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
      this.mSystemBarComp.setStatusBarDarkMode(true);
    }
  }
  
  public void b(int paramInt)
  {
    if (SystemUtil.c())
    {
      g(((ReadInJoyNewFeedsActivity.TabInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt))).jdField_b_of_type_Int);
      BaseSkinRes localBaseSkinRes = ((ReadInJoySkinManager)this.app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a(8);
      if (localBaseSkinRes != null) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.setSelectColor(localBaseSkinRes.a());
      }
    }
    else
    {
      ThreadManager.post(new ReadInJoyNewFeedsActivity.13(this, paramInt), 5, null, false);
    }
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "onSubscribeMsgNotification.");
    }
    g();
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_e_of_type_Int == 0) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.setTabState(0, paramBoolean);
    }
  }
  
  public boolean b()
  {
    return this.jdField_h_of_type_Int != 0;
  }
  
  protected void c()
  {
    b(this.jdField_e_of_type_Int);
    ReadInJoySkinManager localReadInJoySkinManager = (ReadInJoySkinManager)this.app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    int i = 0;
    while (i < 4)
    {
      BaseSkinRes localBaseSkinRes = localReadInJoySkinManager.a(i + 4);
      if (localBaseSkinRes != null)
      {
        BaseTabbar.TabHolder localTabHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.a(i).a;
        localTabHolder.c.setImageDrawable(localBaseSkinRes.a());
        if (i == this.jdField_e_of_type_Int)
        {
          localTabHolder.c.setSelected(true);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.a(i, i);
        }
      }
      if (localReadInJoySkinManager.a() == 1) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.setTabState(i, false);
      }
      i += 1;
    }
  }
  
  void c(int paramInt)
  {
    Boolean localBoolean = Boolean.valueOf(true);
    if ((this.jdField_f_of_type_Int != 5) || (this.jdField_d_of_type_Boolean)) {
      localBoolean = Boolean.valueOf(false);
    }
    if (localBoolean.booleanValue()) {
      runOnUiThread(new ReadInJoyNewFeedsActivity.16(this, paramInt));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    }
    SparseIntArray localSparseIntArray = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.a();
    if (!paramBoolean)
    {
      if (localSparseIntArray.get(0) > 0) {
        localSparseIntArray.put(0, 10);
      }
    }
    else {
      localSparseIntArray.put(0, 0);
    }
    localSparseIntArray.put(0, this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.e());
    localSparseIntArray.put(3, 0);
    int i = 0;
    while (i < 4)
    {
      ReadinjoyTabbar localReadinjoyTabbar = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar;
      int j = ((ReadInJoyNewFeedsActivity.TabInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i))).jdField_a_of_type_Int;
      paramBoolean = true;
      if (j != 1) {
        paramBoolean = false;
      }
      localReadinjoyTabbar.a(i, paramBoolean, localSparseIntArray.get(i));
      i += 1;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131712943));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    findViewById(2131376638).setOnClickListener(this);
  }
  
  public void d(int paramInt)
  {
    this.jdField_h_of_type_Int = (paramInt | this.jdField_h_of_type_Int);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    int j;
    int i;
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
          ((QQToast)localObject).d(2000);
          if ((bool ^ true))
          {
            ((QQToast)localObject).a(QQToast.a(2));
            ((QQToast)localObject).c(2131692185);
            ((QQToast)localObject).b(getApplicationContext().getResources().getDimensionPixelSize(2131299168) - (int)DisplayUtils.a(getApplicationContext(), 5.0F));
          }
          else
          {
            ((QQToast)localObject).a(QQToast.a(1));
            ((QQToast)localObject).c(2131692186);
            ((QQToast)localObject).b(getApplicationContext().getResources().getDimensionPixelSize(2131299168) - (int)DisplayUtils.a(getApplicationContext(), 5.0F));
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
          j = 80;
          i = j;
          if (bool) {}
        }
      }
    }
    try
    {
      i = new JSONObject(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).readInJoyReleaseWebServiceConfig()).optInt("releaseServiceMinMem", 80);
      long l = DeviceInfoUtil.e();
      if (l >>> 20 <= i)
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
        ((HashMap)localObject).put("param_availableMem", String.valueOf(l));
        ((HashMap)localObject).put("param_cpuNum", String.valueOf(DeviceInfoUtil.b()));
        ((HashMap)localObject).put("param_cpuFreq", String.valueOf(DeviceInfoUtil.b()));
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
        label488:
        break label488;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.a(this.jdField_e_of_type_Int).a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.a(this.jdField_e_of_type_Int).a().a(paramInt1, paramInt2, paramIntent);
      }
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        i = j;
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
    jdField_a_of_type_JavaUtilList.add(String.valueOf(hashCode()));
    com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshManager.jdField_b_of_type_Boolean = false;
    ReadinjoyReportUtils.a(this.app);
    ReadInJoyHelper.b(this.app);
    ReadInJoyHelper.c(this.app);
    ViolaSoLoaderManager.a.a().a();
    ReadInJoyWebRenderEngine.c();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramBundle = getIntent();
    Bundle localBundle = paramBundle.getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("key_notification_click_action", false))) {
      ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).h();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.a(this);
    this.jdField_d_of_type_Boolean = paramBundle.getBooleanExtra("from_search", false);
    this.jdField_e_of_type_Boolean = paramBundle.getBooleanExtra("from_javascript", false);
    this.jdField_f_of_type_Int = paramBundle.getIntExtra("launch_from", 5);
    e(this.jdField_f_of_type_Int);
    int i = this.jdField_f_of_type_Int;
    if (6 == i)
    {
      RIJKanDianFolderStatus.updateMergeKandianFolderStatus(3);
      RIJLockScreenPushReport.a();
    }
    else if (9 == i)
    {
      RIJKanDianFolderStatus.updateMergeKandianFolderStatus(3);
    }
    else if (1 == i)
    {
      RIJKanDianFolderStatus.updateMergeKandianFolderStatus(8);
    }
    else if (2 == i)
    {
      RIJKanDianFolderStatus.updateMergeKandianFolderStatus(8);
    }
    else if (11 == i)
    {
      ReadInJoyLogicEngineEventDispatcher.a().c("onConversationJumpRestoreStack");
    }
    ReadInJoyLogicEngineEventDispatcher.a().a();
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    i = NetworkUtil.getSystemNetwork(getApplication());
    if ((i == 4) || (i == 1)) {
      ThreadManager.post(new ReadInJoyNewFeedsActivity.2(this), 5, null, true);
    }
    ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.MyRunnable(this, this));
    a();
    getWindow().setBackgroundDrawable(null);
    paramBundle = (ReadInJoyLogicManager)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    ReadInJoyLogicEngine.a().h();
    ReadInJoyLogicEngine.a().d();
    if (this.app.getMessageFacade() != null) {
      this.app.getMessageFacade().addObserver(this);
    }
    if (ReadInJoyHelper.a(this.app)) {
      TroopBarAssistantManager.a().c(this.app);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    ReadInJoyHelper.a(this.app);
    this.jdField_a_of_type_Int = RIJKanDianFolderStatus.reportFolderStatus;
    ReadinjoyReportUtils.a(ReadinjoyReportUtils.a(), true, 0L, this.jdField_a_of_type_Int, 0);
    RIJThreadHandler.a(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
    r();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.i()) {
      ReadInJoyWebDataManager.a().a(this.app.getCurrentAccountUin(), 1);
    }
    PublicTracker.a("KANDIAN_NEW_FEEDS_CREATE", null);
    PublicTracker.a(null, "KANDIAN_NEW_FEEDS_CREATE_TO_RESUME");
    long l = NetConnInfoCenter.getServerTimeMillis();
    i = RIJAppSetting.a();
    int j = RIJKanDianFolderStatus.reportFolderStatus;
    ReadInJoyGlobalReporter.a().a(this.app, l, i, j);
    ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.3(this, l, i, j));
    m();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInjoySkinAndRefreshFacade = new ReadInjoySkinAndRefreshFacade(this.app, 0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInjoySkinAndRefreshFacade.a(new ReadInJoyNewFeedsActivity.4(this));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInjoySkinAndRefreshFacade.a();
    b();
    ThreadManager.getFileThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 20000L);
    ReadInJoyGlobalReporter.c(0);
    RIJPushNotification.a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    long l = System.currentTimeMillis();
    try
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.a();
      ((ReadInJoyLogicManager)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().h(i);
    }
    catch (Exception localException)
    {
      QLog.d("ReadInJoyNewFeedsActivity", 1, "saveLeaveKanDianTab throw Exception.");
      localException.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, new Object[] { "saveLeaveKanDianTab time cost: ", Long.valueOf(System.currentTimeMillis() - l) });
    }
    ((IRIJADExposureService)RIJQQAppInterfaceUtil.a().getRuntimeService(IRIJADExposureService.class)).reportAllInvalidADExposure(getActivity());
    ReadInJoyScreenShotReporter.a(this).b();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    ReadInJoyFragmentFactory.a().a();
    ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
    n();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinGuideView;
    if (localObject != null) {
      ((ReadInJoySkinGuideView)localObject).a();
    }
    jdField_a_of_type_JavaUtilList.remove(String.valueOf(hashCode()));
    super.doOnDestroy();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
    if (l > 0L) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066F7", "0X80066F7", 0, 0, Long.toString(l / 1000L), "", "", RIJTransMergeKanDianReport.b(), false);
    }
    if (this.app.getMessageFacade() != null) {
      this.app.getMessageFacade().deleteObserver(this);
    }
    localObject = (ReadInJoyLogicManager)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if ((localObject != null) && (((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine() != null))
    {
      localObject = ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().a();
      if (localObject != null) {
        ((ReadInJoyUserInfoModule)localObject).a();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.b(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.b(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.p();
    ReadInJoyLogicEngine.a().i();
    VideoVolumeControl.getInstance().outKandianModule(this);
    PreloadManager.a().b();
    PreloadManager.a().e();
    ReadinjoyReportUtils.a(ReadinjoyReportUtils.a(), false, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_h_of_type_Int);
    PublicTracker.a();
    ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).stopWebCoreService();
    ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).releaseLightWebProcess();
    ReadInJoyWebDataManager.a();
    ReadInJoyWebDataManager.a().b();
    h();
    ((ReadInJoySkinManager)this.app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).b(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInjoySkinAndRefreshFacade.b();
    localObject = this.jdField_a_of_type_JavaLangString;
    if (localObject != null)
    {
      FileUtils.deleteDirectory(CommonSkinRes.a((String)localObject));
      this.jdField_a_of_type_JavaLangString = null;
    }
    ReadInJoyGlobalReporter.a().a();
    ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.12(this));
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNaviController;
    if (localObject != null) {
      ((ReadInJoyNaviController)localObject).b();
    }
    localObject = ReadInJoyLogicEngine.a().a();
    if (localObject != null) {
      ((FreeNetFlowInfoModule)localObject).a(false);
    }
    ThreadManager.getFileThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    UserActionCollector.a().c();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("from_search", false);
    this.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("from_javascript", false);
    this.jdField_f_of_type_Int = paramIntent.getIntExtra("launch_from", 5);
    e(this.jdField_f_of_type_Int);
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_f_of_type_Int != 5)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690706));
    }
    a(paramIntent.getIntExtra("target_fragment", 0), 258, paramIntent.getExtras(), false);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    AbstractGifImage.pauseAll();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.b(3);
    ReadInJoyScreenShotReporter.a(this).a();
    ReadInJoyLogicEngine.n();
    ReadInJoySkinGuideView localReadInJoySkinGuideView = this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinGuideView;
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
    if (this.jdField_f_of_type_Boolean)
    {
      a(this.jdField_g_of_type_Int, 257, null, false);
      this.jdField_f_of_type_Boolean = false;
    }
    if (this.jdField_e_of_type_Int == 0) {
      f(0);
    } else {
      f(8);
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
    c();
    c(this.jdField_a_of_type_Boolean ^ true);
    g();
    o();
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      PublicTracker.a("KANDIAN_FEEDS_STAGE_1_COST", null);
    }
    AbstractGifImage.resumeAll();
    if (this.jdField_h_of_type_Boolean) {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new ReadInJoyNewFeedsActivity.10(this), 1000L);
    }
    int i = this.jdField_e_of_type_Int;
    if (i != 0)
    {
      if (i != 1) {
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
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    ReadInJoyLogicEngine.a().j();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    VideoVolumeControl.getInstance().requestOrAbandonAudioFocus(false, "readinjoy tab doOnStop");
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    this.jdField_e_of_type_Long += this.jdField_d_of_type_Long - this.jdField_c_of_type_Long;
    ReadInJoyLogicEngine.a().k();
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.setEnableRepeatedClick(true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.setCurrentActivity(this);
    ReadInJoySkinManager localReadInJoySkinManager = (ReadInJoySkinManager)this.app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    int i = 0;
    while (i < 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.a(i, ((ReadInJoyNewFeedsActivity.TabInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i))).jdField_a_of_type_JavaLangString);
      if (localReadInJoySkinManager.a() != 0)
      {
        BaseSkinRes localBaseSkinRes = localReadInJoySkinManager.a(i + 4);
        if (localBaseSkinRes != null) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.a(i).a.c.setImageDrawable(localBaseSkinRes.a());
        }
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBaseTabbar$OnTabChangeListener);
    i = getIntent().getIntExtra("tab_tab_index", 0);
    if (i > 0) {
      this.jdField_e_of_type_Int = i;
    } else {
      this.jdField_e_of_type_Int = 0;
    }
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.b()) || (System.currentTimeMillis() - ReadInJoyHelper.a(this.app) > 600000L) || (this.jdField_f_of_type_Int == 1)) {
          break label281;
        }
        if (this.jdField_f_of_type_Int != 9) {
          break label276;
        }
      }
      catch (Exception localException)
      {
        QLog.d("ReadInJoyNewFeedsActivity", 1, "restoreHistoryKanDianTab throw Exception.");
        localException.printStackTrace();
      }
      if ((i == 0) && (RIJAppSetting.a(b()))) {
        this.jdField_e_of_type_Int = ((ReadInJoyLogicManager)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().d();
      }
      i = this.jdField_e_of_type_Int;
      jdField_b_of_type_Int = i;
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.setSelectedTab(i, false);
      return;
      label276:
      i = 0;
      continue;
      label281:
      i = 1;
    }
  }
  
  public void f()
  {
    c(false);
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void flingLToR()
  {
    ReadInJoyBaseFragment localReadInJoyBaseFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment;
    if ((localReadInJoyBaseFragment == null) || (!localReadInJoyBaseFragment.d())) {
      onBackPressed();
    }
  }
  
  public void flingRToL() {}
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "setRecommendRedDotInfo.");
    }
    ChannelCoverInfo localChannelCoverInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo;
    if ((localChannelCoverInfo != null) && (localChannelCoverInfo.mChannelCoverId == 0)) {}
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager == null) {
          this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.i()) {
          return;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.b()) {
          break label105;
        }
        i = 1;
        RIJThreadHandler.b().post(new ReadInJoyNewFeedsActivity.7(this, i));
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label105:
      int i = 0;
    }
  }
  
  public void h()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      localObject = (ReadInJoySubChannelFragment)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if (localObject != null) {
        ((ReadInJoySubChannelFragment)localObject).onDestroy();
      }
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.a(this.jdField_e_of_type_Int).a() != null) {
      super.d(this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.a(this.jdField_e_of_type_Int).a().c());
    }
  }
  
  void j()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      ThreadManager.post(new ReadInJoyNewFeedsActivity.15(this), 5, null, true);
    }
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_e_of_type_Int == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNaviController;
      if ((localObject != null) && (((ReadInJoyNaviController)localObject).a()))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNaviController.a(null);
        return true;
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar;
    if ((localObject != null) && (((ReadinjoyTabbar)localObject).a(this.jdField_e_of_type_Int) != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.a(this.jdField_e_of_type_Int).a();
      if ((localObject instanceof ReadInJoyVideoChannelFragment))
      {
        localObject = ((ReadInJoyVideoChannelFragment)localObject).a();
        if ((localObject != null) && (((VideoPlayManager)localObject).a() != null) && (((VideoPlayManager)localObject).a().a()))
        {
          ((VideoPlayManager)localObject).a().j();
          return true;
        }
      }
      else if (((localObject instanceof ReadInJoyRecommendFeedsFragment)) && (((ReadInJoyRecommendFeedsFragment)localObject).f()))
      {
        return true;
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment;
    if ((localObject != null) && (((ReadInJoyBaseFragment)localObject).onBackEvent())) {
      return true;
    }
    if ((!RIJShowKanDianTabSp.c()) && (getIntent() != null) && (getIntent().getBooleanExtra("from_lock_screen", false)))
    {
      ReadInJoyDialogUtil.a(this);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131369216)
    {
      if (i != 2131376638)
      {
        switch (i)
        {
        default: 
          return;
        }
        if (this.jdField_e_of_type_Int == 0)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNaviController;
          if (paramView != null)
          {
            if (paramView.a())
            {
              this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNaviController.a(null);
              return;
            }
            if ((a() instanceof ReadInJoySubChannelFragment))
            {
              this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNaviController.a(a().b());
              return;
            }
            this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNaviController.a(0);
            return;
          }
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabbar.a(this.jdField_e_of_type_Int).a().d();
          return;
        }
        catch (Throwable paramView)
        {
          paramView.printStackTrace();
          QLog.d("ReadInJoyNewFeedsActivity", 1, "notifyTitleClick failed.");
          return;
        }
      }
      a().f();
      ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.14(this));
      return;
    }
    if ((this.jdField_e_of_type_Int == 2) && (RIJUGCDianDian.a()))
    {
      RIJUGCDianDian.a(this, this.jdField_a_of_type_AndroidViewViewGroup);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008C5F", "0X8008C5F", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(), false);
      return;
    }
    RIJWebSearchUtils.a(this);
    UniteSearchReportController.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), new ReportModelDC02528().opername("Kdian_inner_search").module("kd_web_search").action("clk_search"));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_e_of_type_Boolean) && ((paramObject instanceof MessageRecord)))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((KandianMergeManager.a(paramObservable, this.app) == -1) && (paramObservable.extInt != 5) && (!paramObservable.isSendFromLocal())) {
        j();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity
 * JD-Core Version:    0.7.0.1
 */