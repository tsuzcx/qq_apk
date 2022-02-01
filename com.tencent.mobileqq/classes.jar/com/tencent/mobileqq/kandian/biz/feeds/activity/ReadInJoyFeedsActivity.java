package com.tencent.mobileqq.kandian.biz.feeds.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailTopGestureLayoutProxy;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.base.view.widget.LeftRedDotRadioButton;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoySettingActivity;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyBaseActivity;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.controller.KanDianViewController;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyBaseViewController;
import com.tencent.mobileqq.kandian.biz.feeds.controller.SubscriptionViewController;
import com.tencent.mobileqq.kandian.biz.framework.RIJWebSearchUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.IReadInJoyNewFeedsActivityConst;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.handler.RIJGetArticleListHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ReadInJoyFeedsActivity
  extends ReadInJoyBaseActivity
  implements View.OnClickListener, View.OnTouchListener, IReadInJoyNewFeedsActivityConst, Observer
{
  private boolean A;
  private int B;
  private long C = 0L;
  private long D = 0L;
  private long E = 0L;
  private long F = 0L;
  private long G = 0L;
  private int H = 0;
  private int I = 0;
  protected Map<Integer, ReadInJoyBaseViewController> p = new HashMap();
  public boolean q;
  int r;
  protected IPublicAccountDetailTopGestureLayoutProxy s;
  protected ReadInJoyObserver t = new ReadInJoyFeedsActivity.7(this);
  private ViewGroup u;
  private ViewGroup v;
  private ReadInJoyFeedsActivity.OnDoubleClick w;
  private GestureDetector x;
  private MqqHandler y = new MqqHandler();
  private boolean z;
  
  private void a(KandianMergeManager paramKandianMergeManager)
  {
    boolean bool = paramKandianMergeManager.k() ^ true;
    paramKandianMergeManager.b(bool);
    if (bool)
    {
      QQToast.makeText(this, getResources().getString(2131897930), 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299920));
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80067D6", "0X80067D6", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
      return;
    }
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800705C", "0X800705C", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
  }
  
  private void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    if (paramMenuItem.id == 3) {
      RIJGetArticleListHandler.g = -2;
    } else if (paramMenuItem.id == 4) {
      RIJGetArticleListHandler.g = -1;
    } else if (paramMenuItem.id == 5) {
      RIJGetArticleListHandler.g = 1;
    } else if (paramMenuItem.id == 6) {
      RIJGetArticleListHandler.g = 0;
    }
    paramMenuItem = new StringBuilder();
    paramMenuItem.append("readinjoy setting feeds type:");
    paramMenuItem.append(RIJGetArticleListHandler.g);
    QLog.d("ReadInJoyBaseActivity", 1, paramMenuItem.toString());
  }
  
  private void a(PopupMenuDialog.MenuItem paramMenuItem, KandianMergeManager paramKandianMergeManager)
  {
    int i;
    if (paramKandianMergeManager.k())
    {
      paramKandianMergeManager = getString(2131917666);
      i = 2130843530;
    }
    else
    {
      paramKandianMergeManager = getString(2131897931);
      i = 2130843531;
    }
    paramMenuItem.id = 0;
    paramMenuItem.title = paramKandianMergeManager;
    paramMenuItem.contentDescription = paramMenuItem.title;
    paramMenuItem.iconId = i;
  }
  
  private void a(List<PopupMenuDialog.MenuItem> paramList) {}
  
  private void a(boolean paramBoolean)
  {
    Object localObject1 = (KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    Object localObject3 = getString(2131892520);
    Object localObject2 = new ArrayList();
    PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
    a(localMenuItem, (KandianMergeManager)localObject1);
    ((List)localObject2).add(localMenuItem);
    localMenuItem = new PopupMenuDialog.MenuItem();
    localMenuItem.id = 1;
    localMenuItem.title = ((String)localObject3);
    localMenuItem.contentDescription = localMenuItem.title;
    localMenuItem.iconId = 2130843528;
    ((List)localObject2).add(localMenuItem);
    if (paramBoolean)
    {
      localObject3 = new PopupMenuDialog.MenuItem();
      ((PopupMenuDialog.MenuItem)localObject3).id = 2;
      int i;
      if (ReadInJoyHelper.e(getAppRuntime())) {
        i = 2131910317;
      } else {
        i = 2131910514;
      }
      ((PopupMenuDialog.MenuItem)localObject3).title = HardCodeUtil.a(i);
      ((PopupMenuDialog.MenuItem)localObject3).iconId = 2130851310;
      ((PopupMenuDialog.MenuItem)localObject3).contentDescription = ((PopupMenuDialog.MenuItem)localObject3).title;
      ((List)localObject2).add(localObject3);
      a((List)localObject2);
    }
    localObject3 = new PopupMenuDialog.MenuItem();
    ((PopupMenuDialog.MenuItem)localObject3).id = 7;
    ((PopupMenuDialog.MenuItem)localObject3).title = HardCodeUtil.a(2131910504);
    ((PopupMenuDialog.MenuItem)localObject3).iconId = 2130843532;
    ((List)localObject2).add(localObject3);
    localObject3 = new PopupMenuDialog.MenuItem();
    ((PopupMenuDialog.MenuItem)localObject3).id = 8;
    ((PopupMenuDialog.MenuItem)localObject3).title = HardCodeUtil.a(2131910408);
    ((PopupMenuDialog.MenuItem)localObject3).iconId = 2130843529;
    ((List)localObject2).add(localObject3);
    localObject1 = PopupMenuDialog.build(this, (List)localObject2, new ReadInJoyFeedsActivity.5(this, (KandianMergeManager)localObject1));
    localObject2 = this.u;
    ((PopupMenuDialog)localObject1).showAsDropDown((View)localObject2, ((View)localObject2).getWidth() - getResources().getDimensionPixelSize(2131299624) - getResources().getDimensionPixelSize(2131299620), getResources().getDimensionPixelSize(2131298913));
  }
  
  private void b(PopupMenuDialog.MenuItem paramMenuItem, KandianMergeManager paramKandianMergeManager)
  {
    switch (paramMenuItem.id)
    {
    default: 
      return;
    case 10: 
      ReadInJoyHelper.h(getAppRuntime(), ReadInJoyHelper.n(getAppRuntime()) ^ true);
      return;
    case 9: 
      ReadInJoyHelper.e(getAppRuntime(), ReadInJoyHelper.k(getAppRuntime()) ^ true);
      return;
    case 8: 
      i();
      return;
    case 7: 
      h();
      return;
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      a(paramMenuItem);
      return;
    case 2: 
      ReadInJoyHelper.b(getAppRuntime(), ReadInJoyHelper.e(getAppRuntime()) ^ true);
      ReadInJoyLogicEngineEventDispatcher.a().c();
      return;
    case 1: 
      g();
      return;
    }
    a(paramKandianMergeManager);
  }
  
  private void c(int paramInt)
  {
    this.v.removeAllViews();
    Object localObject;
    ReadInJoyBaseViewController localReadInJoyBaseViewController;
    if (paramInt == 0)
    {
      this.g.setSelected(true);
      this.h.setSelected(false);
      this.h.setChecked(false);
      d(0);
      ReadInJoyLogicEngine.a().A();
      localObject = (ReadInJoyBaseViewController)this.p.get(Integer.valueOf(paramInt));
      if (localObject == null)
      {
        localObject = new KanDianViewController(this);
        ((ReadInJoyBaseViewController)localObject).a(this.v);
        ((ReadInJoyBaseViewController)localObject).cT_();
      }
      else
      {
        ((ReadInJoyBaseViewController)localObject).b();
      }
      localReadInJoyBaseViewController = (ReadInJoyBaseViewController)this.p.get(Integer.valueOf(1));
      if (localReadInJoyBaseViewController != null) {
        localReadInJoyBaseViewController.c();
      }
      this.p.put(Integer.valueOf(paramInt), localObject);
      return;
    }
    if (paramInt == 1)
    {
      this.g.setSelected(false);
      this.g.setChecked(false);
      this.h.setSelected(true);
      e(0);
      ReadInJoyLogicEngine.a().z();
      localObject = (ReadInJoyBaseViewController)this.p.get(Integer.valueOf(paramInt));
      if (localObject == null)
      {
        localObject = new SubscriptionViewController(this);
        ((ReadInJoyBaseViewController)localObject).a(this.v);
        ((ReadInJoyBaseViewController)localObject).cT_();
      }
      else
      {
        ((ReadInJoyBaseViewController)localObject).b();
      }
      localReadInJoyBaseViewController = (ReadInJoyBaseViewController)this.p.get(Integer.valueOf(0));
      if (localReadInJoyBaseViewController != null) {
        localReadInJoyBaseViewController.c();
      }
      this.p.put(Integer.valueOf(paramInt), localObject);
    }
  }
  
  private void d(int paramInt)
  {
    if (paramInt > 0)
    {
      this.g.a(false);
      return;
    }
    this.g.a(false);
  }
  
  private void e(int paramInt)
  {
    if (paramInt > 0)
    {
      this.h.a(true);
      return;
    }
    this.h.a(false);
  }
  
  private void f()
  {
    this.u = ((ViewGroup)this.i.findViewById(2131444899));
    this.v = ((ViewGroup)findViewById(2131444326));
    int i = getIntent().getIntExtra("readinjoy_show_tab", -1);
    int j = getIntent().getIntExtra("tab_tab_index", 0);
    if (i >= 0)
    {
      this.m.setVisibility(8);
      this.c.setVisibility(0);
      this.I = j;
      c(j);
    }
    else
    {
      this.m.setVisibility(0);
      this.c.setVisibility(8);
      j();
    }
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.j.setImageResource(2130841087);
    this.j.setContentDescription(HardCodeUtil.a(2131910547));
    this.j.setOnClickListener(this);
    if ((this.k != null) && (this.B != 5)) {
      this.k.setText(getString(2131887625));
    }
  }
  
  private void g()
  {
    ThreadManager.postImmediately(new ReadInJoyFeedsActivity.6(this), null, true);
    startActivity(new Intent(this, ReadInJoySettingActivity.class));
    ReportController.b(null, "CliOper", "", "", "0X800705B", "0X800705B", 0, 0, "", "", "", RIJTransMergeKanDianReport.a());
  }
  
  private void h()
  {
    String str = RIJQQAppInterfaceUtil.d();
    if (TextUtils.isEmpty(str))
    {
      QLog.e("ReadInJoyBaseActivity", 2, "click personal page , but uin is empty !");
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ReadInJoyConstants.h);
      localStringBuilder.append(Base64Util.encodeToString(str.getBytes(), 2));
      ReadInJoyUtils.a(this, localStringBuilder.toString());
    }
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8007384", "0X8007384", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
  }
  
  private void i()
  {
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8007383", "0X8007383", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
    if (Boolean.valueOf(ReadInJoyHelper.Z(ReadInJoyUtils.b())).booleanValue())
    {
      String str = HardCodeUtil.a(2131910325);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ViolaAccessHelper.a(ReadInJoyUtils.b()));
      localStringBuilder.append("&adtag=1&privateLetters=");
      ViolaAccessHelper.a(this, str, localStringBuilder.toString(), null);
      return;
    }
    ReadInJoyUtils.a(this, ReadInJoyConstants.e);
  }
  
  private void j()
  {
    KanDianViewController localKanDianViewController = new KanDianViewController(this);
    localKanDianViewController.a(this.v);
    localKanDianViewController.cT_();
    this.p.put(Integer.valueOf(this.I), localKanDianViewController);
  }
  
  void a(int paramInt)
  {
    Boolean localBoolean = Boolean.valueOf(true);
    int i = this.B;
    if ((i != 5) || (6 == i) || (this.z)) {
      localBoolean = Boolean.valueOf(false);
    }
    if (localBoolean.booleanValue()) {
      runOnUiThread(new ReadInJoyFeedsActivity.4(this, paramInt));
    }
  }
  
  public void b(int paramInt)
  {
    this.H = (paramInt | this.H);
  }
  
  void d()
  {
    if (this.k != null) {
      ThreadManager.post(new ReadInJoyFeedsActivity.3(this), 5, null, true);
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int j;
    int i;
    if (paramInt1 == 9992)
    {
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("isNeedFinish", false))) {
        finish();
      }
    }
    else if (paramInt1 == 9991)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseActivity", 2, "back from article detail");
      }
      if (RIJWebSearchUtils.a())
      {
        boolean bool = TextUtils.isEmpty(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).readInJoyReleaseWebServiceConfig());
        j = 80;
        i = j;
        if (bool) {}
      }
    }
    try
    {
      i = new JSONObject(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).readInJoyReleaseWebServiceConfig()).optInt("releaseServiceMinMem", 80);
      long l = DeviceInfoUtil.r();
      if (l >>> 20 <= i)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseActivity", 2, "back from article detail, release web core service");
        }
        ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).stopWebCoreService();
      }
      try
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
        ((HashMap)localObject1).put("param_totalMem", String.valueOf(DeviceInfoUtil.a()));
        ((HashMap)localObject1).put("param_availableMem", String.valueOf(l));
        ((HashMap)localObject1).put("param_cpuNum", String.valueOf(DeviceInfoUtil.h()));
        ((HashMap)localObject1).put("param_cpuFreq", String.valueOf(DeviceInfoUtil.k()));
        ((HashMap)localObject1).put("param_releaseType", String.valueOf(0));
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("releaseWebCoreServiceReport:");
          ((StringBuilder)localObject2).append(((HashMap)localObject1).toString());
          QLog.d("ReadInJoyBaseActivity", 2, ((StringBuilder)localObject2).toString());
        }
        StatisticCollector.getInstance(this).collectPerformance(this.app.getCurrentAccountUin(), "actReadInJoyReleaseWebService", true, 0L, 0L, (HashMap)localObject1, "");
      }
      catch (Exception localException2)
      {
        Object localObject1;
        Object localObject2;
        label330:
        break label330;
      }
      localObject1 = this.p.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Integer)((Iterator)localObject1).next();
        ((ReadInJoyBaseViewController)this.p.get(localObject2)).a(paramInt1, paramInt2, paramIntent);
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    VideoVolumeControl.getInstance().inKandianModule(this);
    super.doOnCreate(paramBundle);
    ReadInJoyHelper.z(this.app);
    ReadInJoyHelper.D(this.app);
    this.C = System.currentTimeMillis();
    paramBundle = getIntent();
    Bundle localBundle = paramBundle.getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("key_notification_click_action", false))) {
      ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).u();
    }
    this.z = paramBundle.getBooleanExtra("from_search", false);
    this.A = paramBundle.getBooleanExtra("from_javascript", false);
    this.B = paramBundle.getIntExtra("launch_from", 5);
    ReadInJoyLogicEngineEventDispatcher.a().b();
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    int i = NetworkUtil.getSystemNetwork(getApplication());
    if ((i == 4) || (i == 1)) {
      ThreadManager.post(new ReadInJoyFeedsActivity.1(this), 5, null, true);
    }
    ThreadManager.executeOnSubThread(new ReadInJoyFeedsActivity.MyRunnable(this, this));
    setContentView(2131626246);
    getWindow().setBackgroundDrawable(null);
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.s = ((IPublicAccountDetailTopGestureLayoutProxy)QRoute.api(IPublicAccountDetailTopGestureLayoutProxy.class));
      this.s.init(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.s.getTopGestureLayout());
    }
    paramBundle = (ReadInJoyLogicManager)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    ReadInJoyLogicEngine.a().C();
    ReadInJoyLogicEngine.a().x();
    setTitle(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getXinKandianName(this.app, this.app.getApp()));
    f();
    this.u.setOnTouchListener(this);
    this.w = new ReadInJoyFeedsActivity.OnDoubleClick((ReadInJoyBaseViewController)this.p.get(Integer.valueOf(this.I)));
    this.x = new GestureDetector(this, this.w);
    if (this.app.getMessageFacade() != null) {
      this.app.getMessageFacade().addObserver(this);
    }
    if (ReadInJoyHelper.a(this.app)) {
      TroopBarAssistantManager.a().d(this.app);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.t);
    ReadInJoyHelper.c(this.app);
    this.r = RIJKanDianFolderStatus.reportFolderStatus;
    ReadinjoyReportUtils.a(1, true, 0L, this.r, 0);
    RIJThreadHandler.a(RIJQQAppInterfaceUtil.c());
    return true;
  }
  
  protected void doOnDestroy()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.t);
    super.doOnDestroy();
    this.D = System.currentTimeMillis();
    long l = this.D - this.C;
    if (l > 0L) {
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066F7", "0X80066F7", 0, 0, Long.toString(l / 1000L), "", "", RIJTransMergeKanDianReport.c(), false);
    }
    Object localObject = this.p.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      ((ReadInJoyBaseViewController)this.p.get(localInteger)).e();
    }
    if (this.app.getMessageFacade() != null) {
      this.app.getMessageFacade().deleteObserver(this);
    }
    localObject = (ReadInJoyLogicManager)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    ReadInJoyLogicEngine.a().D();
    VideoVolumeControl.getInstance().outKandianModule(this);
    PreloadManager.a().c();
    PreloadManager.a().h();
    ReadinjoyReportUtils.a(1, false, this.C, this.r, this.H);
    ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).checkDelDir();
    ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).cancelNotDownloadTask();
    ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).stopWebCoreService();
    ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).releaseLightWebProcess();
    ReadInJoyWebDataManager.b();
    ReadInJoyWebDataManager.a().e();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.z = paramIntent.getBooleanExtra("from_search", false);
    this.A = paramIntent.getBooleanExtra("from_javascript", false);
    this.B = paramIntent.getIntExtra("launch_from", 5);
    int i = getIntent().getIntExtra("readinjoy_show_tab", -1);
    int j = getIntent().getIntExtra("tab_tab_index", 0);
    if (i >= 0)
    {
      this.I = j;
      c(j);
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    Iterator localIterator = this.p.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ReadInJoyBaseViewController)this.p.get(localInteger)).h();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (!this.q)
    {
      this.q = true;
      PublicTracker.a("KANDIAN_FEEDS_STAGE_1_COST", null);
    }
    Iterator localIterator = this.p.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ReadInJoyBaseViewController)this.p.get(localInteger)).i();
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    this.E = System.currentTimeMillis();
    ReadInJoyLogicEngine.a().E();
    Iterator localIterator = this.p.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ReadInJoyBaseViewController)this.p.get(localInteger)).f();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.F = System.currentTimeMillis();
    this.G += this.F - this.E;
    ReadInJoyLogicEngine.a().F();
    Iterator localIterator = this.p.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ReadInJoyBaseViewController)this.p.get(localInteger)).g();
    }
  }
  
  public int e()
  {
    return this.I;
  }
  
  public void finish()
  {
    super.finish();
    Iterator localIterator = this.p.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ReadInJoyBaseViewController)this.p.get(localInteger)).t();
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131436232: 
      PublicTracker.a(null, "KANDIAN_TO_SUBSCRIPT_COST");
      if (!this.h.a()) {
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80067D2", "0X80067D2", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
      } else {
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80067D1", "0X80067D1", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
      }
      i = this.I;
      if (i == 1)
      {
        ((ReadInJoyBaseViewController)this.p.get(Integer.valueOf(i))).a(true);
        return;
      }
      this.I = 1;
      c(this.I);
      ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).c(1);
      return;
    case 2131436231: 
      if (!this.g.a()) {
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80067D0", "0X80067D0", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
      } else {
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80067CF", "0X80067CF", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
      }
      i = this.I;
      if (i == 0)
      {
        ((ReadInJoyBaseViewController)this.p.get(Integer.valueOf(i))).a(true);
        return;
      }
      this.I = 0;
      c(this.I);
      ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).c(0);
      return;
    }
    if (ReadInJoyHelper.a(this.app)) {
      a(false);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return this.x.onTouchEvent(paramMotionEvent);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (QQAppInterface)RIJQQAppInterfaceUtil.e();
    if ((!this.z) && (!this.A) && ((paramObject instanceof MessageRecord)) && (paramObservable != null))
    {
      paramObservable = (IKanDianMergeManager)paramObservable.getRuntimeService(IKanDianMergeManager.class);
      paramObject = (MessageRecord)paramObject;
      if ((paramObservable.getMsgFromSource(paramObject) == -1) && (!paramObject.isSendFromLocal())) {
        d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyFeedsActivity
 * JD-Core Version:    0.7.0.1
 */