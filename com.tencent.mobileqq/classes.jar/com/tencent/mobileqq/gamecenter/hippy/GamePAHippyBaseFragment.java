package com.tencent.mobileqq.gamecenter.hippy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.fragment.BaseHippyFragment;
import com.tencent.hippy.qq.update.UpdateSetting;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet;
import com.tencent.mobileqq.activity.qwallet.utils.ArkPubicEventWrap;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoManager;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.gamecenter.protocol.GmpEnterInfoReq;
import com.tencent.mobileqq.gamecenter.protocol.GmpEnterInfoRsp;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.wadl.ipc.WadlProxyServiceUtil;
import cooperation.wadl.ipc.WadlProxyServiceWrap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public abstract class GamePAHippyBaseFragment
  extends BaseHippyFragment
  implements WadlProxyServiceCallBackInterface, BusinessObserver
{
  public int a;
  public long a;
  public View a;
  public QQAppInterface a;
  public GamePubAccountMsgManager a;
  public GamePubAccountMsgObserver a;
  public QQGameTimingLogger a;
  public List<QQGameMsgInfo> a;
  public boolean a;
  public int b;
  public long b;
  public List<String> b;
  public long c;
  public long d;
  public long e;
  public long f;
  public long g;
  
  public GamePAHippyBaseFragment()
  {
    this.jdField_b_of_type_Int = 1;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
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
    localStringBuilder.append("action=").append(paramInt1).append("|");
    if (paramInt2 != -1) {
      localHippyMap.pushInt("index", paramInt2);
    }
    localStringBuilder.append("index=").append(paramInt2).append("|");
    if (paramInt3 != -1) {
      localHippyMap.pushInt("height", paramInt3);
    }
    localStringBuilder.append("height=").append(paramInt3).append("|");
    if (!TextUtils.isEmpty(paramString))
    {
      localHippyMap.pushString("gameData", paramString);
      localStringBuilder.append("gameData=").append(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GamePAHippyBaseFragment", 1, "notfiyHippyPageRefresh data:" + localStringBuilder.toString());
    }
    sendHippyNativeEvent("onGameFeedsEvent", localHippyMap);
  }
  
  public void a(long paramLong)
  {
    if (paramLong < 0L) {}
    do
    {
      return;
      paramLong = (SystemClock.elapsedRealtime() - paramLong) / 1000L;
    } while (paramLong <= 0L);
    QQGameHelper.a(a()).c("206471").d("76916").a(17, String.valueOf(paramLong)).a();
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
    if (localIntent != null) {
      if (localIntent.hasExtra("startTime")) {
        if (paramBundle != null) {
          break label98;
        }
      }
    }
    label98:
    for (this.jdField_b_of_type_Long = localIntent.getLongExtra("startTime", 0L);; this.jdField_b_of_type_Long = SystemClock.elapsedRealtime())
    {
      if (this.jdField_b_of_type_Long > 0L) {
        this.e = (SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long);
      }
      if (localIntent.hasExtra("clickTime")) {
        this.c = localIntent.getLongExtra("clickTime", 0L);
      }
      if (localIntent.hasExtra("unreadNum")) {
        this.jdField_a_of_type_Int = localIntent.getIntExtra("unreadNum", 0);
      }
      return;
    }
  }
  
  abstract void a(GmpEnterInfoRsp paramGmpEnterInfoRsp, boolean paramBoolean);
  
  public void a(String paramString1, String paramString2)
  {
    long l1;
    long l3;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.b();
      l1 = this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("loadHippy");
      l3 = this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("onLoadHippyEnd") - l1;
      l1 = -1L;
      if (this.mHippyQQEngine == null) {
        break label127;
      }
      localObject = this.mHippyQQEngine.getLoadStepsTime();
      if (localObject != null) {}
    }
    else
    {
      return;
    }
    long l2;
    label116:
    label127:
    int i;
    if (((HashMap)localObject).containsKey("loadLibStart"))
    {
      l1 = ((Long)((HashMap)localObject).get("loadLibStart")).longValue();
      if (!((HashMap)localObject).containsKey("loadLibEnd")) {
        break label560;
      }
      l2 = ((Long)((HashMap)localObject).get("loadLibEnd")).longValue();
      if (l2 >= l1) {
        break label566;
      }
      l1 = 0L;
      i = -1;
      if (this.mHippyQQEngine != null)
      {
        if (!this.mHippyQQEngine.isPredraw()) {
          break label576;
        }
        i = 1;
        label148:
        if (!this.mHippyQQEngine.isPreloaded()) {
          break label581;
        }
      }
    }
    int k;
    label560:
    label566:
    label576:
    label581:
    for (int j = 2;; j = 0)
    {
      i |= j;
      l2 = this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("initViewEnd") - this.jdField_a_of_type_Long;
      k = UpdateSetting.getInstance().getModuleVersion("SGameOfficial");
      localObject = QQGameHelper.a(a());
      ((WadlReportBuilder)localObject).d("76918").c("206612").a(25, String.valueOf(i)).a(26, k + "").a(27, paramString1).a(28, paramString2).a(29, this.g + "").a(30, this.f + "").a(31, this.d + "").a(32, l2 + "").a(33, l3 + "").a(34, this.e + "").a(35, l1 + "");
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a();
      if ((paramString2 == null) || (paramString2.size() <= 0)) {
        break label807;
      }
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a();
      ((WadlReportBuilder)localObject).a(36, paramString1);
      j = 0;
      while (j < paramString2.size())
      {
        ((WadlReportBuilder)localObject).a(37 + j, paramString2.get(j) + "");
        j += 1;
      }
      l1 = 0L;
      break;
      l2 = 0L;
      break label116;
      l1 = l2 - l1;
      break label127;
      i = 0;
      break label148;
    }
    paramString2 = new StringBuilder();
    paramString2.append("gamePubAccount prefData={").append("isPreLoadHipyy=").append(i).append("|").append("version=").append("8.5.5.5105").append("|").append("hippyVersion=").append(k).append("|").append("showHippyCostTime=").append(this.g).append("|").append("showHippyFirstScreenTime=").append(this.f).append("|").append("AppLoadHippyCostTime=").append(this.d).append("|").append("initViewCostTime=").append(l2).append("|").append("loadHippyCostTime=").append(l3).append("|").append("mEnterQQGamePubCostTime=").append(this.e).append("|").append("loadLibCostTime=").append(l1).append("|").append("pointTime=(").append(paramString1).append(")").append("}");
    QLog.d("GamePAHippyBaseFragment", 1, new Object[] { paramString2 });
    label807:
    ((WadlReportBuilder)localObject).a();
  }
  
  abstract void a(ArrayList<QQGameMsgInfo> paramArrayList);
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyGamePubAccountMsgManager = ((GamePubAccountMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_PUB_ACCOUNT_MSG_MANAGER));
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyGamePubAccountMsgManager.a("2747277822", 3);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyGamePubAccountMsgObserver = new GamePAHippyBaseFragment.1(this);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyGamePubAccountMsgManager.addObserver(this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyGamePubAccountMsgObserver);
    c();
  }
  
  public void b(long paramLong) {}
  
  protected void c() {}
  
  public void c(long paramLong) {}
  
  protected void d()
  {
    try
    {
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        if (getActivity().mSystemBarComp != null) {
          break label34;
        }
        getActivity().setImmersiveStatus(0);
      }
      for (;;)
      {
        LiuHaiUtils.enableNotch(getActivity());
        return;
        label34:
        getActivity().mSystemBarComp.setStatusBarDrawable(null);
        getActivity().mSystemBarComp.setStatusBarColor(0);
        getActivity().mSystemBarComp.setStatusColor(0);
        getActivity().mSystemBarComp.setgetStatusBarVisible(false, 0);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public JSONObject doBussinessInitData(JSONObject paramJSONObject)
  {
    return null;
  }
  
  public void e() {}
  
  public void f() {}
  
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
    if (SubscribeUtils.a()) {
      SubscribeUtils.a(getActivity());
    }
  }
  
  public boolean onBackEvent()
  {
    GameCenterVideoViewController localGameCenterVideoViewController = GameCenterVideoManager.a().a();
    if ((localGameCenterVideoViewController != null) && (localGameCenterVideoViewController.isFullScreenMode()))
    {
      GameCenterVideoManager.a().a().exitFullScreen();
      return true;
    }
    return this.mHippyQQEngine.doOnBackPressed(new GamePAHippyBaseFragment.2(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new HashMap();
    paramBundle.put(Integer.valueOf(24), a());
    paramBundle.put(Integer.valueOf(4), "8");
    GameCenterUtils.a(CmGameUtil.a(), "769", "205838", "", "76902", "1", "160", paramBundle);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    WadlProxyServiceUtil.a().b(this);
    if (this.jdField_b_of_type_JavaUtilList != null) {
      ArkPubicEventWrap.a().b(this.jdField_b_of_type_JavaUtilList);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyGamePubAccountMsgObserver != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyGamePubAccountMsgManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyGamePubAccountMsgManager.deleteObserver(this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyGamePubAccountMsgObserver);
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    a(this.jdField_a_of_type_Long);
  }
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GamePAHippyBaseFragment", 1, "---->onQueryCallback isGetGameEnter=" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    for (;;)
    {
      try
      {
        long l = QQGameHelper.a(paramArrayList);
        if (QLog.isColorLevel()) {
          QLog.d("GamePAHippyBaseFragment", 1, "---> get lastGameAppID=" + l);
        }
        this.jdField_a_of_type_Boolean = true;
        if (a() == "3")
        {
          i = 1;
          QWalletCommonServlet.a(new GmpEnterInfoReq(l, 1, i), this);
          return;
        }
      }
      catch (Throwable paramArrayList)
      {
        QLog.d("GamePAHippyBaseFragment", 1, "---->onQueryCallback getLastGameAppID fail:" + paramArrayList.getMessage());
        return;
      }
      int i = 0;
    }
  }
  
  public void onQueryCallbackVia(ArrayList<WadlResult> paramArrayList) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    GmpEnterInfoRsp localGmpEnterInfoRsp;
    StringBuilder localStringBuilder;
    if (paramInt == 31)
    {
      if (paramBundle == null) {
        break label219;
      }
      localGmpEnterInfoRsp = (GmpEnterInfoRsp)paramBundle.getSerializable("rsp");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("GmpEnterInfoRsp|");
        if (localGmpEnterInfoRsp == null) {
          break label167;
        }
        paramBundle = Integer.valueOf(localGmpEnterInfoRsp.ret_code);
        QLog.d("GamePAHippyBaseFragment", 2, paramBundle);
        localStringBuilder = new StringBuilder().append("GmpEnterInfoRsp|");
        if (localGmpEnterInfoRsp == null) {
          break label174;
        }
        paramBundle = localGmpEnterInfoRsp.url;
        label98:
        QLog.d("GamePAHippyBaseFragment", 2, paramBundle);
        localStringBuilder = new StringBuilder().append("GmpEnterInfoRsp|");
        if (localGmpEnterInfoRsp == null) {
          break label181;
        }
      }
    }
    label167:
    label174:
    label181:
    for (paramBundle = localGmpEnterInfoRsp.content;; paramBundle = "")
    {
      QLog.d("GamePAHippyBaseFragment", 2, paramBundle);
      if (localGmpEnterInfoRsp != null) {}
      try
      {
        a(localGmpEnterInfoRsp, true);
        return;
      }
      catch (Throwable paramBundle)
      {
        QLog.d("GamePAHippyBaseFragment", 1, "-->onReceive showGiftIcon fail:" + paramBundle.getMessage());
        return;
      }
      paramBundle = "";
      break;
      paramBundle = "";
      break label98;
    }
    label219:
    QLog.d("GamePAHippyBaseFragment", 2, "GmpEnterInfoRsp| is null");
    a(null, false);
  }
  
  public void onWadlTaskStatusChanged(WadlResult paramWadlResult) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.GamePAHippyBaseFragment
 * JD-Core Version:    0.7.0.1
 */