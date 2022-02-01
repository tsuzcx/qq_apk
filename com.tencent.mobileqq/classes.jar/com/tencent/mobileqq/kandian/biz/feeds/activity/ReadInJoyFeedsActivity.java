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
import com.tencent.mobileqq.kandian.base.utils.api.IRIJRuntimeUtils;
import com.tencent.mobileqq.kandian.base.view.widget.LeftRedDotRadioButton;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoySettingActivity;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyBaseActivity;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.controller.KanDianViewController;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyBaseViewController;
import com.tencent.mobileqq.kandian.biz.feeds.controller.SubscriptionViewController;
import com.tencent.mobileqq.kandian.biz.framework.RIJWebSearchUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
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
  private long jdField_a_of_type_Long = 0L;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  protected IPublicAccountDetailTopGestureLayoutProxy a;
  private ReadInJoyFeedsActivity.OnDoubleClick jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyFeedsActivity$OnDoubleClick;
  protected ReadInJoyObserver a;
  protected Map<Integer, ReadInJoyBaseViewController> a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
  public boolean a;
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 0L;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = 0L;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 0;
  private long jdField_d_of_type_Long = 0L;
  private int jdField_e_of_type_Int = 0;
  private long jdField_e_of_type_Long = 0L;
  
  public ReadInJoyFeedsActivity()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoyFeedsActivity.7(this);
  }
  
  private void a(KandianMergeManager paramKandianMergeManager)
  {
    boolean bool = paramKandianMergeManager.d() ^ true;
    paramKandianMergeManager.b(bool);
    if (bool)
    {
      QQToast.a(this, getResources().getString(2131699877), 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299168));
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80067D6", "0X80067D6", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
      return;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800705C", "0X800705C", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
  }
  
  private void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    if (paramMenuItem.id == 3) {
      RIJGetArticleListHandler.a = -2;
    } else if (paramMenuItem.id == 4) {
      RIJGetArticleListHandler.a = -1;
    } else if (paramMenuItem.id == 5) {
      RIJGetArticleListHandler.a = 1;
    } else if (paramMenuItem.id == 6) {
      RIJGetArticleListHandler.a = 0;
    }
    paramMenuItem = new StringBuilder();
    paramMenuItem.append("readinjoy setting feeds type:");
    paramMenuItem.append(RIJGetArticleListHandler.a);
    QLog.d("ReadInJoyBaseActivity", 1, paramMenuItem.toString());
  }
  
  private void a(PopupMenuDialog.MenuItem paramMenuItem, KandianMergeManager paramKandianMergeManager)
  {
    int i;
    if (paramKandianMergeManager.d())
    {
      paramKandianMergeManager = getString(2131720045);
      i = 2130842577;
    }
    else
    {
      paramKandianMergeManager = getString(2131699878);
      i = 2130842578;
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
    Object localObject3 = getString(2131694817);
    Object localObject2 = new ArrayList();
    PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
    a(localMenuItem, (KandianMergeManager)localObject1);
    ((List)localObject2).add(localMenuItem);
    localMenuItem = new PopupMenuDialog.MenuItem();
    localMenuItem.id = 1;
    localMenuItem.title = ((String)localObject3);
    localMenuItem.contentDescription = localMenuItem.title;
    localMenuItem.iconId = 2130842575;
    ((List)localObject2).add(localMenuItem);
    if (paramBoolean)
    {
      localObject3 = new PopupMenuDialog.MenuItem();
      ((PopupMenuDialog.MenuItem)localObject3).id = 2;
      int i;
      if (ReadInJoyHelper.d(getAppRuntime())) {
        i = 2131712742;
      } else {
        i = 2131712948;
      }
      ((PopupMenuDialog.MenuItem)localObject3).title = HardCodeUtil.a(i);
      ((PopupMenuDialog.MenuItem)localObject3).iconId = 2130849605;
      ((PopupMenuDialog.MenuItem)localObject3).contentDescription = ((PopupMenuDialog.MenuItem)localObject3).title;
      ((List)localObject2).add(localObject3);
      a((List)localObject2);
    }
    localObject3 = new PopupMenuDialog.MenuItem();
    ((PopupMenuDialog.MenuItem)localObject3).id = 7;
    ((PopupMenuDialog.MenuItem)localObject3).title = HardCodeUtil.a(2131712938);
    ((PopupMenuDialog.MenuItem)localObject3).iconId = 2130842579;
    ((List)localObject2).add(localObject3);
    localObject3 = new PopupMenuDialog.MenuItem();
    ((PopupMenuDialog.MenuItem)localObject3).id = 8;
    ((PopupMenuDialog.MenuItem)localObject3).title = HardCodeUtil.a(2131712836);
    ((PopupMenuDialog.MenuItem)localObject3).iconId = 2130842576;
    ((List)localObject2).add(localObject3);
    localObject1 = PopupMenuDialog.build(this, (List)localObject2, new ReadInJoyFeedsActivity.5(this, (KandianMergeManager)localObject1));
    localObject2 = this.jdField_b_of_type_AndroidViewViewGroup;
    ((PopupMenuDialog)localObject1).showAsDropDown((View)localObject2, ((View)localObject2).getWidth() - getResources().getDimensionPixelSize(2131298902) - getResources().getDimensionPixelSize(2131298898), getResources().getDimensionPixelSize(2131298214));
  }
  
  private void b()
  {
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376638));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131376123));
    int i = getIntent().getIntExtra("readinjoy_show_tab", -1);
    int j = getIntent().getIntExtra("tab_tab_index", 0);
    if (i >= 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(0);
      this.jdField_e_of_type_Int = j;
      c(j);
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(8);
      f();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetLeftRedDotRadioButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840347);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131712983));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_Int != 5)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690706));
    }
  }
  
  private void b(PopupMenuDialog.MenuItem paramMenuItem, KandianMergeManager paramKandianMergeManager)
  {
    switch (paramMenuItem.id)
    {
    default: 
      return;
    case 10: 
      ReadInJoyHelper.h(getAppRuntime(), ReadInJoyHelper.i(getAppRuntime()) ^ true);
      return;
    case 9: 
      ReadInJoyHelper.e(getAppRuntime(), ReadInJoyHelper.f(getAppRuntime()) ^ true);
      return;
    case 8: 
      e();
      return;
    case 7: 
      d();
      return;
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      a(paramMenuItem);
      return;
    case 2: 
      ReadInJoyHelper.b(getAppRuntime(), ReadInJoyHelper.d(getAppRuntime()) ^ true);
      ReadInJoyLogicEngineEventDispatcher.a().c();
      return;
    case 1: 
      c();
      return;
    }
    a(paramKandianMergeManager);
  }
  
  private void c()
  {
    ThreadManager.postImmediately(new ReadInJoyFeedsActivity.6(this), null, true);
    startActivity(new Intent(this, ReadInJoySettingActivity.class));
    ReportController.b(null, "CliOper", "", "", "0X800705B", "0X800705B", 0, 0, "", "", "", RIJTransMergeKanDianReport.a());
  }
  
  private void c(int paramInt)
  {
    this.jdField_c_of_type_AndroidViewViewGroup.removeAllViews();
    Object localObject;
    ReadInJoyBaseViewController localReadInJoyBaseViewController;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetLeftRedDotRadioButton.setSelected(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setSelected(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setChecked(false);
      d(0);
      ReadInJoyLogicEngine.a().g();
      localObject = (ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localObject == null)
      {
        localObject = new KanDianViewController(this);
        ((ReadInJoyBaseViewController)localObject).a(this.jdField_c_of_type_AndroidViewViewGroup);
        ((ReadInJoyBaseViewController)localObject).aw_();
      }
      else
      {
        ((ReadInJoyBaseViewController)localObject).b();
      }
      localReadInJoyBaseViewController = (ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(1));
      if (localReadInJoyBaseViewController != null) {
        localReadInJoyBaseViewController.c();
      }
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject);
      return;
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetLeftRedDotRadioButton.setSelected(false);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetLeftRedDotRadioButton.setChecked(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setSelected(true);
      e(0);
      ReadInJoyLogicEngine.a().f();
      localObject = (ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localObject == null)
      {
        localObject = new SubscriptionViewController(this);
        ((ReadInJoyBaseViewController)localObject).a(this.jdField_c_of_type_AndroidViewViewGroup);
        ((ReadInJoyBaseViewController)localObject).aw_();
      }
      else
      {
        ((ReadInJoyBaseViewController)localObject).b();
      }
      localReadInJoyBaseViewController = (ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(0));
      if (localReadInJoyBaseViewController != null) {
        localReadInJoyBaseViewController.c();
      }
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject);
    }
  }
  
  private void d()
  {
    String str = RIJQQAppInterfaceUtil.a();
    if (TextUtils.isEmpty(str))
    {
      QLog.e("ReadInJoyBaseActivity", 2, "click personal page , but uin is empty !");
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ReadInJoyConstants.g);
      localStringBuilder.append(Base64Util.encodeToString(str.getBytes(), 2));
      ReadInJoyUtils.a(this, localStringBuilder.toString());
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8007384", "0X8007384", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
  }
  
  private void d(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetLeftRedDotRadioButton.a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetLeftRedDotRadioButton.a(false);
  }
  
  private void e()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8007383", "0X8007383", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
    if (Boolean.valueOf(ReadInJoyHelper.x(ReadInJoyUtils.a())).booleanValue())
    {
      String str = HardCodeUtil.a(2131712751);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ViolaAccessHelper.a(ReadInJoyUtils.a()));
      localStringBuilder.append("&adtag=1&privateLetters=");
      ViolaAccessHelper.a(this, str, localStringBuilder.toString(), null);
      return;
    }
    ReadInJoyUtils.a(this, ReadInJoyConstants.d);
  }
  
  private void e(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(false);
  }
  
  private void f()
  {
    KanDianViewController localKanDianViewController = new KanDianViewController(this);
    localKanDianViewController.a(this.jdField_c_of_type_AndroidViewViewGroup);
    localKanDianViewController.aw_();
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_e_of_type_Int), localKanDianViewController);
  }
  
  public int a()
  {
    return this.jdField_e_of_type_Int;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      ThreadManager.post(new ReadInJoyFeedsActivity.3(this), 5, null, true);
    }
  }
  
  void a(int paramInt)
  {
    Boolean localBoolean = Boolean.valueOf(true);
    int i = this.jdField_c_of_type_Int;
    if ((i != 5) || (6 == i) || (this.jdField_b_of_type_Boolean)) {
      localBoolean = Boolean.valueOf(false);
    }
    if (localBoolean.booleanValue()) {
      runOnUiThread(new ReadInJoyFeedsActivity.4(this, paramInt));
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_d_of_type_Int = (paramInt | this.jdField_d_of_type_Int);
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
      long l = DeviceInfoUtil.e();
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
        ((HashMap)localObject1).put("param_cpuNum", String.valueOf(DeviceInfoUtil.b()));
        ((HashMap)localObject1).put("param_cpuFreq", String.valueOf(DeviceInfoUtil.b()));
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
      localObject1 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Integer)((Iterator)localObject1).next();
        ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(localObject2)).a(paramInt1, paramInt2, paramIntent);
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
    ReadInJoyHelper.b(this.app);
    ReadInJoyHelper.c(this.app);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramBundle = getIntent();
    Bundle localBundle = paramBundle.getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("key_notification_click_action", false))) {
      ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).h();
    }
    this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("from_search", false);
    this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("from_javascript", false);
    this.jdField_c_of_type_Int = paramBundle.getIntExtra("launch_from", 5);
    ReadInJoyLogicEngineEventDispatcher.a().a();
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    int i = NetworkUtil.getSystemNetwork(getApplication());
    if ((i == 4) || (i == 1)) {
      ThreadManager.post(new ReadInJoyFeedsActivity.1(this), 5, null, true);
    }
    ThreadManager.executeOnSubThread(new ReadInJoyFeedsActivity.MyRunnable(this, this));
    setContentView(2131560199);
    getWindow().setBackgroundDrawable(null);
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountDetailTopGestureLayoutProxy = ((IPublicAccountDetailTopGestureLayoutProxy)QRoute.api(IPublicAccountDetailTopGestureLayoutProxy.class));
      this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountDetailTopGestureLayoutProxy.init(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountDetailTopGestureLayoutProxy.getTopGestureLayout());
    }
    paramBundle = (ReadInJoyLogicManager)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    ReadInJoyLogicEngine.a().h();
    ReadInJoyLogicEngine.a().d();
    setTitle(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getXinKandianName(this.app, this.app.getApp()));
    b();
    this.jdField_b_of_type_AndroidViewViewGroup.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyFeedsActivity$OnDoubleClick = new ReadInJoyFeedsActivity.OnDoubleClick((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.jdField_e_of_type_Int)));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this, this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyFeedsActivity$OnDoubleClick);
    if (this.app.getMessageFacade() != null) {
      this.app.getMessageFacade().addObserver(this);
    }
    if (ReadInJoyHelper.a(this.app)) {
      TroopBarAssistantManager.a().c(this.app);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    ReadInJoyHelper.a(this.app);
    this.jdField_b_of_type_Int = RIJKanDianFolderStatus.reportFolderStatus;
    ReadinjoyReportUtils.a(1, true, 0L, this.jdField_b_of_type_Int, 0);
    RIJThreadHandler.a(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
    return true;
  }
  
  protected void doOnDestroy()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    super.doOnDestroy();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    long l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
    if (l > 0L) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066F7", "0X80066F7", 0, 0, Long.toString(l / 1000L), "", "", RIJTransMergeKanDianReport.b(), false);
    }
    Object localObject = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).e();
    }
    if (this.app.getMessageFacade() != null) {
      this.app.getMessageFacade().deleteObserver(this);
    }
    localObject = (ReadInJoyLogicManager)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    ReadInJoyLogicEngine.a().i();
    VideoVolumeControl.getInstance().outKandianModule(this);
    PreloadManager.a().b();
    PreloadManager.a().e();
    ReadinjoyReportUtils.a(1, false, this.jdField_a_of_type_Long, this.jdField_b_of_type_Int, this.jdField_d_of_type_Int);
    ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).checkDelDir();
    ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).cancelNotDownloadTask();
    ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).stopWebCoreService();
    ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).releaseLightWebProcess();
    ReadInJoyWebDataManager.a();
    ReadInJoyWebDataManager.a().b();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("from_search", false);
    this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("from_javascript", false);
    this.jdField_c_of_type_Int = paramIntent.getIntExtra("launch_from", 5);
    int i = getIntent().getIntExtra("readinjoy_show_tab", -1);
    int j = getIntent().getIntExtra("tab_tab_index", 0);
    if (i >= 0)
    {
      this.jdField_e_of_type_Int = j;
      c(j);
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).h();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      PublicTracker.a("KANDIAN_FEEDS_STAGE_1_COST", null);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).i();
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    ReadInJoyLogicEngine.a().j();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).f();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    this.jdField_e_of_type_Long += this.jdField_d_of_type_Long - this.jdField_c_of_type_Long;
    ReadInJoyLogicEngine.a().k();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).g();
    }
  }
  
  public void finish()
  {
    super.finish();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).m();
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131369254: 
      PublicTracker.a(null, "KANDIAN_TO_SUBSCRIPT_COST");
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a()) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80067D2", "0X80067D2", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
      } else {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80067D1", "0X80067D1", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
      }
      i = this.jdField_e_of_type_Int;
      if (i == 1)
      {
        ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i))).a(true);
        return;
      }
      this.jdField_e_of_type_Int = 1;
      c(this.jdField_e_of_type_Int);
      ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b(1);
      return;
    case 2131369253: 
      if (!this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetLeftRedDotRadioButton.a()) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80067D0", "0X80067D0", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
      } else {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80067CF", "0X80067CF", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
      }
      i = this.jdField_e_of_type_Int;
      if (i == 0)
      {
        ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i))).a(true);
        return;
      }
      this.jdField_e_of_type_Int = 0;
      c(this.jdField_e_of_type_Int);
      ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b(0);
      return;
    }
    if (ReadInJoyHelper.a(this.app)) {
      a(false);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (QQAppInterface)((IRIJRuntimeUtils)QRoute.api(IRIJRuntimeUtils.class)).getAppRuntime();
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean) && ((paramObject instanceof MessageRecord)) && (paramObservable != null))
    {
      paramObservable = (IKanDianMergeManager)paramObservable.getRuntimeService(IKanDianMergeManager.class);
      paramObject = (MessageRecord)paramObject;
      if ((paramObservable.getMsgFromSource(paramObject) == -1) && (!paramObject.isSendFromLocal())) {
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyFeedsActivity
 * JD-Core Version:    0.7.0.1
 */