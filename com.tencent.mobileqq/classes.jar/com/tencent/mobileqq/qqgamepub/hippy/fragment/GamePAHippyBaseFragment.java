package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.fragment.BaseHippyFragment;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qqgamepub.api.IGamePubAccountMsgService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoReq;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.hippy.GamePubAccountMsgObserver;
import com.tencent.mobileqq.qqgamepub.utils.GameCenterUtils;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.utils.GameVideoManager;
import com.tencent.mobileqq.qqgamepub.utils.QQGameTimingLogger;
import com.tencent.mobileqq.qqgamepub.utils.QQGameUIHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public abstract class GamePAHippyBaseFragment
  extends BaseHippyFragment
  implements WadlProxyServiceCallBackInterface, BusinessObserver
{
  public int a;
  protected long a;
  public View a;
  protected AppInterface a;
  public IGamePubAccountMsgService a;
  public GamePubAccountMsgObserver a;
  public GamePAHippyBaseFragment.AdHandleBroadCastReceiver a;
  private GamePAHippyBaseFragment.ArkEventObserver a;
  protected QQGameTimingLogger a;
  public List<QQGameMsgInfo> a;
  public boolean a;
  public int b;
  public long b;
  protected List<String> b;
  public long c;
  public long d;
  public long e;
  public long f;
  public long g;
  public long h;
  
  static {}
  
  public GamePAHippyBaseFragment()
  {
    this.jdField_b_of_type_Int = 1;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyFragmentGamePAHippyBaseFragment$AdHandleBroadCastReceiver = new GamePAHippyBaseFragment.AdHandleBroadCastReceiver(this, null);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyFragmentGamePAHippyBaseFragment$ArkEventObserver = new GamePAHippyBaseFragment.ArkEventObserver(this, null);
  }
  
  private void a(Intent paramIntent)
  {
    try
    {
      String str = paramIntent.getStringExtra("arkViewId");
      boolean bool = paramIntent.getBooleanExtra("isAioDeletMsg", false);
      Object localObject = null;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        paramIntent = localObject;
        if (!localIterator.hasNext()) {
          break;
        }
        paramIntent = (QQGameMsgInfo)localIterator.next();
      } while (!str.equals(String.valueOf(paramIntent.uniseq)));
      if (paramIntent != null)
      {
        if (!bool)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqQqgamepubApiIGamePubAccountMsgService == null) {
            this.jdField_a_of_type_ComTencentMobileqqQqgamepubApiIGamePubAccountMsgService = ((IGamePubAccountMsgService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IGamePubAccountMsgService.class, ""));
          }
          this.jdField_a_of_type_ComTencentMobileqqQqgamepubApiIGamePubAccountMsgService.deleteMsg(paramIntent.frienduin, paramIntent.istroop, paramIntent.uniseq);
          QQToast.a(getQBaseActivity(), 2131700862, 1).a();
        }
        a(str);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramIntent;
    }
  }
  
  private void b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(24), a());
    localHashMap.put(Integer.valueOf(4), "8");
    GameCenterUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "769", "205838", "", "76902", "1", "160", localHashMap);
  }
  
  private void b(String paramString)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("data", paramString);
    sendHippyNativeEvent("gc_hippy_rec_ark", localHippyMap);
  }
  
  private void i()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_qgame_delete_ad");
      MobileQQ.sMobileQQ.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyFragmentGamePAHippyBaseFragment$AdHandleBroadCastReceiver, localIntentFilter);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GamePAHippyBaseFragment register BroadCastReceiver error: ");
      localStringBuilder.append(localThrowable.getMessage());
      QLog.e("GamePAHippyBaseFragment", 1, localStringBuilder.toString());
    }
  }
  
  protected int a()
  {
    return 3;
  }
  
  abstract String a();
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    WadlProxyServiceUtil.a().a(this);
    WadlProxyServiceUtil.a().a();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushInt("action", paramInt1);
    localStringBuilder.append("action=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("|");
    if (paramInt2 != -1) {
      localHippyMap.pushInt("index", paramInt2);
    }
    localStringBuilder.append("index=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("|");
    if (paramInt3 != -1) {
      localHippyMap.pushInt("height", paramInt3);
    }
    localStringBuilder.append("height=");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("|");
    if (!TextUtils.isEmpty(paramString))
    {
      localHippyMap.pushString("gameData", paramString);
      localStringBuilder.append("gameData=");
      localStringBuilder.append(paramString);
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("notfiyHippyPageRefresh data:");
      paramString.append(localStringBuilder.toString());
      QLog.d("GamePAHippyBaseFragment", 1, paramString.toString());
    }
    sendHippyNativeEvent("onGameFeedsEvent", localHippyMap);
  }
  
  protected void a(Activity paramActivity)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null)) {
      paramActivity.getWindow().setFlags(16777216, 16777216);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    Intent localIntent = getActivity().getIntent();
    if (localIntent != null)
    {
      if (localIntent.hasExtra("startTime"))
      {
        if (paramBundle == null) {
          this.jdField_b_of_type_Long = localIntent.getLongExtra("startTime", 0L);
        } else {
          this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
        }
        if (this.jdField_b_of_type_Long > 0L) {
          this.e = (SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long);
        }
      }
      if (localIntent.hasExtra("clickTime")) {
        this.c = localIntent.getLongExtra("clickTime", 0L);
      }
      if (localIntent.hasExtra("unreadNum")) {
        this.jdField_a_of_type_Int = localIntent.getIntExtra("unreadNum", 0);
      }
      if (localIntent.hasExtra("lastReadTime")) {
        this.h = localIntent.getLongExtra("lastReadTime", 0L);
      }
    }
  }
  
  public void a(WadlResult paramWadlResult) {}
  
  abstract void a(GmpEnterInfoRsp paramGmpEnterInfoRsp, boolean paramBoolean);
  
  abstract void a(String paramString);
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger;
    if (localObject1 != null)
    {
      ((QQGameTimingLogger)localObject1).b();
      long l1 = this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("loadHippy");
      long l3 = this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("onLoadHippyEnd") - l1;
      l1 = -1L;
      if (this.mHippyQQEngine != null)
      {
        localObject1 = this.mHippyQQEngine.getLoadStepsTime();
        if (localObject1 == null) {
          return;
        }
        if (((HashMap)localObject1).containsKey("loadLibStart")) {
          l1 = ((Long)((HashMap)localObject1).get("loadLibStart")).longValue();
        } else {
          l1 = 0L;
        }
        if (((HashMap)localObject1).containsKey("loadLibEnd")) {
          l2 = ((Long)((HashMap)localObject1).get("loadLibEnd")).longValue();
        } else {
          l2 = 0L;
        }
        if (l2 < l1) {
          l1 = 0L;
        } else {
          l1 = l2 - l1;
        }
      }
      int i = -1;
      if (this.mHippyQQEngine != null)
      {
        int m = this.mHippyQQEngine.isPredraw();
        if (this.mHippyQQEngine.isPreloaded()) {
          i = 2;
        } else {
          i = 0;
        }
        i = m | i;
      }
      long l2 = this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("initViewEnd") - this.jdField_a_of_type_Long;
      localObject1 = ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).getGamePaHippyModuleName();
      int k = ((IHippySetting)QRoute.api(IHippySetting.class)).getModuleVersion((String)localObject1);
      localObject1 = GamePubAccountHelper.a(a());
      Object localObject2 = ((WadlReportBuilder)localObject1).d("76918").c("206612").a(25, String.valueOf(i));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(k);
      localStringBuilder.append("");
      paramString1 = ((WadlReportBuilder)localObject2).a(26, localStringBuilder.toString()).a(27, paramString1).a(28, paramString2);
      paramString2 = new StringBuilder();
      paramString2.append(this.g);
      paramString2.append("");
      paramString1 = paramString1.a(29, paramString2.toString());
      paramString2 = new StringBuilder();
      paramString2.append(this.f);
      paramString2.append("");
      paramString1 = paramString1.a(30, paramString2.toString());
      paramString2 = new StringBuilder();
      paramString2.append(this.d);
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
      paramString2.append(this.e);
      paramString2.append("");
      paramString1 = paramString1.a(34, paramString2.toString());
      paramString2 = new StringBuilder();
      paramString2.append(l1);
      paramString2.append("");
      paramString1.a(35, paramString2.toString());
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a();
      if ((paramString2 != null) && (paramString2.size() > 0))
      {
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a();
        ((WadlReportBuilder)localObject1).a(36, paramString1);
        int j = 0;
        while (j < paramString2.size())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramString2.get(j));
          ((StringBuilder)localObject2).append("");
          ((WadlReportBuilder)localObject1).a(37 + j, ((StringBuilder)localObject2).toString());
          j += 1;
        }
        paramString2 = new StringBuilder();
        paramString2.append("gamePubAccount prefData={");
        paramString2.append("isPreLoadHipyy=");
        paramString2.append(i);
        paramString2.append("|");
        paramString2.append("version=");
        paramString2.append("8.7.0.5295");
        paramString2.append("|");
        paramString2.append("hippyVersion=");
        paramString2.append(k);
        paramString2.append("|");
        paramString2.append("showHippyCostTime=");
        paramString2.append(this.g);
        paramString2.append("|");
        paramString2.append("showHippyFirstScreenTime=");
        paramString2.append(this.f);
        paramString2.append("|");
        paramString2.append("AppLoadHippyCostTime=");
        paramString2.append(this.d);
        paramString2.append("|");
        paramString2.append("initViewCostTime=");
        paramString2.append(l2);
        paramString2.append("|");
        paramString2.append("loadHippyCostTime=");
        paramString2.append(l3);
        paramString2.append("|");
        paramString2.append("mEnterQQGamePubCostTime=");
        paramString2.append(this.e);
        paramString2.append("|");
        paramString2.append("loadLibCostTime=");
        paramString2.append(l1);
        paramString2.append("|");
        paramString2.append("pointTime=(");
        paramString2.append(paramString1);
        paramString2.append(")");
        paramString2.append("}");
        QLog.d("GamePAHippyBaseFragment", 1, new Object[] { paramString2 });
      }
      ((WadlReportBuilder)localObject1).a();
    }
  }
  
  public void a(ArrayList<WadlResult> paramArrayList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("---->onQueryCallback isGetGameEnter=");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.d("GamePAHippyBaseFragment", 1, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    for (;;)
    {
      try
      {
        long l = GamePubAccountHelper.a(paramArrayList);
        if (QLog.isColorLevel())
        {
          paramArrayList = new StringBuilder();
          paramArrayList.append("---> get lastGameAppID=");
          paramArrayList.append(l);
          QLog.d("GamePAHippyBaseFragment", 1, paramArrayList.toString());
        }
        this.jdField_a_of_type_Boolean = true;
        if (a().equals("3"))
        {
          i = 1;
          paramArrayList = new GmpEnterInfoReq(l, 1, i);
          ((IQWalletApi)QRoute.api(IQWalletApi.class)).servletSendRequest(paramArrayList, this);
          return;
        }
      }
      catch (Throwable paramArrayList)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("---->onQueryCallback getLastGameAppID fail:");
        localStringBuilder.append(paramArrayList.getMessage());
        QLog.d("GamePAHippyBaseFragment", 1, localStringBuilder.toString());
        return;
      }
      int i = 0;
    }
  }
  
  protected int b()
  {
    return 5;
  }
  
  public void b(long paramLong)
  {
    if (paramLong < 0L) {
      return;
    }
    paramLong = (SystemClock.elapsedRealtime() - paramLong) / 1000L;
    if (paramLong > 0L) {
      GamePubAccountHelper.a(a()).c("206471").d("76916").a(17, String.valueOf(paramLong)).a();
    }
  }
  
  public void b(ArrayList<WadlResult> paramArrayList) {}
  
  protected void c()
  {
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localAppInterface != null)
    {
      ((IGameMsgManagerService)localAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).setUnshowedUnreadCnt(0);
      ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).setReaded("2747277822", 1008, true, true);
    }
  }
  
  public void c(long paramLong) {}
  
  abstract void c(ArrayList<QQGameMsgInfo> paramArrayList);
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubApiIGamePubAccountMsgService = ((IGamePubAccountMsgService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IGamePubAccountMsgService.class, ""));
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqQqgamepubApiIGamePubAccountMsgService.findMessage("2747277822", a());
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyGamePubAccountMsgObserver = new GamePAHippyBaseFragment.1(this);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubApiIGamePubAccountMsgService.addObserver(this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyGamePubAccountMsgObserver);
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)((Iterator)localObject).next();
        if (!TextUtils.isEmpty(localQQGameMsgInfo.arkAppName))
        {
          ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addNotify(localQQGameMsgInfo.arkAppName);
          this.jdField_b_of_type_JavaUtilList.add(localQQGameMsgInfo.arkAppName);
        }
      }
    }
    ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addObserver(this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyFragmentGamePAHippyBaseFragment$ArkEventObserver);
    e();
  }
  
  public void d(long paramLong)
  {
    ThreadManagerV2.executeOnSubThread(new GamePAHippyBaseFragment.3(this));
  }
  
  protected JSONObject doBussinessInitData(JSONObject paramJSONObject)
  {
    return null;
  }
  
  protected void e() {}
  
  protected void f()
  {
    try
    {
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        if (getQBaseActivity().mSystemBarComp == null)
        {
          getQBaseActivity().setImmersiveStatus(0);
        }
        else
        {
          getQBaseActivity().mSystemBarComp.setStatusBarDrawable(null);
          getQBaseActivity().mSystemBarComp.setStatusBarColor(0);
          getQBaseActivity().mSystemBarComp.setStatusColor(0);
          getQBaseActivity().mSystemBarComp.setgetStatusBarVisible(false, 0);
        }
      }
      LiuHaiUtils.enableNotch(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void g() {}
  
  public void h() {}
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    a(getActivity());
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).isInNightMode()) {
      ((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).addNightModeMask(paramActivity);
    }
  }
  
  public boolean onBackEvent()
  {
    if (((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).isVideoFullScreenMode())
    {
      ((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).exitVideoFullScreen();
      return true;
    }
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null)
    {
      QLog.e("GamePAHippyBaseFragment", 1, "GamePAHippyBaseFragment getActivity is null");
      return true;
    }
    if (this.mHippyQQEngine != null) {
      return this.mHippyQQEngine.doOnBackPressed(new GamePAHippyBaseFragment.2(this, localFragmentActivity));
    }
    localFragmentActivity.finish();
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b();
    i();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger = new QQGameTimingLogger("GamePAHippyBaseFragment", "onCreateView");
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface();
    a(getActivity());
    a(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("preGetIntentData");
    f();
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("setStatusBarImmersive");
    a();
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("initDownload");
    d();
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("initMessage");
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyFragmentGamePAHippyBaseFragment$AdHandleBroadCastReceiver != null) {
      MobileQQ.sMobileQQ.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyFragmentGamePAHippyBaseFragment$AdHandleBroadCastReceiver);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    WadlProxyServiceUtil.a().b(this);
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).unRegistVolumnReceiver(this.jdField_b_of_type_JavaUtilList);
      if (this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyFragmentGamePAHippyBaseFragment$ArkEventObserver != null) {
        ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).deleteObserver(this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyFragmentGamePAHippyBaseFragment$ArkEventObserver);
      }
    }
    GamePubAccountMsgObserver localGamePubAccountMsgObserver = this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyGamePubAccountMsgObserver;
    if (localGamePubAccountMsgObserver != null)
    {
      IGamePubAccountMsgService localIGamePubAccountMsgService = this.jdField_a_of_type_ComTencentMobileqqQqgamepubApiIGamePubAccountMsgService;
      if (localIGamePubAccountMsgService != null) {
        localIGamePubAccountMsgService.deleteObserver(localGamePubAccountMsgObserver);
      }
    }
    QQGameUIHelper.a();
    GameVideoManager.a().f();
  }
  
  public void onFinish()
  {
    super.onFinish();
    b(this.jdField_a_of_type_Long);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 31)
    {
      if (paramBundle != null)
      {
        GmpEnterInfoRsp localGmpEnterInfoRsp = (GmpEnterInfoRsp)paramBundle.getSerializable("rsp");
        Object localObject;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("GmpEnterInfoRsp|");
          localObject = "";
          if (localGmpEnterInfoRsp != null) {
            paramBundle = Integer.valueOf(localGmpEnterInfoRsp.ret_code);
          } else {
            paramBundle = "";
          }
          localStringBuilder.append(paramBundle);
          QLog.d("GamePAHippyBaseFragment", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("GmpEnterInfoRsp|");
          if (localGmpEnterInfoRsp != null) {
            paramBundle = localGmpEnterInfoRsp.url;
          } else {
            paramBundle = "";
          }
          localStringBuilder.append(paramBundle);
          QLog.d("GamePAHippyBaseFragment", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("GmpEnterInfoRsp|");
          paramBundle = (Bundle)localObject;
          if (localGmpEnterInfoRsp != null) {
            paramBundle = localGmpEnterInfoRsp.content;
          }
          localStringBuilder.append(paramBundle);
          QLog.d("GamePAHippyBaseFragment", 2, localStringBuilder.toString());
        }
        if (localGmpEnterInfoRsp == null) {
          return;
        }
        try
        {
          a(localGmpEnterInfoRsp, true);
          return;
        }
        catch (Throwable paramBundle)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("-->onReceive showGiftIcon fail:");
          ((StringBuilder)localObject).append(paramBundle.getMessage());
          QLog.d("GamePAHippyBaseFragment", 1, ((StringBuilder)localObject).toString());
          return;
        }
      }
      QLog.d("GamePAHippyBaseFragment", 2, "GmpEnterInfoRsp| is null");
      a(null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyBaseFragment
 * JD-Core Version:    0.7.0.1
 */