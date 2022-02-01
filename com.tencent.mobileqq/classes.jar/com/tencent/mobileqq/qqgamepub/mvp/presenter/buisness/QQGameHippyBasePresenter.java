package com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qqgamepub.api.IGamePubAccountMsgService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.hippy.GamePubAccountMsgObserver;
import com.tencent.mobileqq.qqgamepub.mvp.model.buisness.QQGameHippyModel;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.base.BaseUIPresenter;
import com.tencent.mobileqq.qqgamepub.mvp.view.buisness.IQQGameHippyBaseView;
import com.tencent.mobileqq.qqgamepub.utils.GameVideoManager;
import com.tencent.mobileqq.qqgamepub.utils.QQGameUIHelper;
import com.tencent.mobileqq.qqgamepub.web.QQGameReportLogic;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public abstract class QQGameHippyBasePresenter<V extends IQQGameHippyBaseView, M extends QQGameHippyModel>
  extends BaseUIPresenter<V, M>
  implements BusinessObserver
{
  protected AppInterface c;
  public int d = 1;
  public List<QQGameMsgInfo> e;
  protected List<String> f = new ArrayList();
  public GamePubAccountMsgObserver g;
  public final QQGameHippyBasePresenter<V, M>.AdHandleBroadCastReceiver h = new QQGameHippyBasePresenter.AdHandleBroadCastReceiver(this, null);
  private QQGameReportLogic i;
  private final QQGameHippyBasePresenter<V, M>.ArkEventObserver j = new QQGameHippyBasePresenter.ArkEventObserver(this, null);
  
  static {}
  
  private void a(Intent paramIntent)
  {
    try
    {
      String str = paramIntent.getStringExtra("arkViewId");
      boolean bool = paramIntent.getBooleanExtra("isAioDeletMsg", false);
      Object localObject = null;
      Iterator localIterator = this.e.iterator();
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
          ((QQGameHippyModel)this.b).a().deleteMsg(paramIntent.frienduin, paramIntent.istroop, paramIntent.uniseq);
          QQToast.makeText(r(), 2131898886, 1).show();
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
  
  private void b(String paramString)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("data", paramString);
    a("gc_hippy_rec_ark", localHippyMap);
  }
  
  private void x()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_qgame_delete_ad");
      MobileQQ.sMobileQQ.registerReceiver(this.h, localIntentFilter);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GamePAHippyBaseFragment register BroadCastReceiver error: ");
      localStringBuilder.append(localThrowable.getMessage());
      QLog.e("QQGamePub_QQGameHippyBasePresenter", 1, localStringBuilder.toString());
    }
  }
  
  private void y()
  {
    ((QQGameHippyModel)this.b).a().deleteObserver(this.g);
  }
  
  private void z()
  {
    ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).unRegistVolumnReceiver(this.f);
    ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).deleteObserver(this.j);
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    ((QQGameHippyModel)this.b).a("QQGamePub_QQGameHippyBasePresenter", "onCreateView");
    ((QQGameHippyModel)this.b).a(SystemClock.elapsedRealtime());
    this.c = ((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface();
    c(r());
    ((QQGameHippyModel)this.b).a(r(), paramBundle);
    ((QQGameHippyModel)this.b).a("preGetIntentData");
    o();
    ((QQGameHippyModel)this.b).a("setStatusBarImmersive");
    ((QQGameHippyModel)this.b).f();
    ((QQGameHippyModel)this.b).a("initDownload");
    m();
    ((QQGameHippyModel)this.b).a("initMessage");
    x();
    w().a(((QQGameHippyModel)this.b).b());
    return null;
  }
  
  public JSONObject a(JSONObject paramJSONObject)
  {
    return null;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateHippyState：");
      localStringBuilder.append(paramInt);
      QLog.i("QQGamePub_QQGameHippyBasePresenter", 2, localStringBuilder.toString());
    }
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
      QLog.d("QQGamePub_QQGameHippyBasePresenter", 1, paramString.toString());
    }
    a("onGameFeedsEvent", localHippyMap);
  }
  
  public void a(Activity paramActivity)
  {
    b(paramActivity);
  }
  
  public void a(GmpEnterInfoRsp paramGmpEnterInfoRsp, boolean paramBoolean) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, HippyMap paramHippyMap)
  {
    try
    {
      HippyQQPreloadEngine localHippyQQPreloadEngine = s();
      if ((localHippyQQPreloadEngine != null) && (paramHippyMap != null) && (!TextUtils.isEmpty(paramString)))
      {
        ((EventDispatcher)localHippyQQPreloadEngine.getHippyEngine().getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(paramString, paramHippyMap);
        return;
      }
    }
    catch (Throwable paramString)
    {
      paramHippyMap = new StringBuilder();
      paramHippyMap.append("sendHippyNativeEvent fail:");
      paramHippyMap.append(paramString.getMessage());
      QLog.d("QQGamePub_QQGameHippyBasePresenter", 1, paramHippyMap.toString());
    }
  }
  
  public void a(ArrayList<QQGameMsgInfo> paramArrayList) {}
  
  public void b(Activity paramActivity)
  {
    if (((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).isInNightMode()) {
      ((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).addNightModeMask(paramActivity);
    }
  }
  
  public void c(Activity paramActivity)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null)) {
      paramActivity.getWindow().setFlags(16777216, 16777216);
    }
  }
  
  public void e()
  {
    l();
  }
  
  public void f()
  {
    AppInterface localAppInterface = this.c;
    if (localAppInterface != null) {
      ((IGameMsgManagerService)localAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).setUnshowedUnreadCnt(0);
    }
  }
  
  public void g()
  {
    ((QQGameHippyModel)this.b).g();
    z();
    y();
    QQGameUIHelper.a();
    GameVideoManager.a().g();
  }
  
  public void h()
  {
    ((QQGameHippyModel)this.b).b(t());
  }
  
  public void i()
  {
    k();
  }
  
  public boolean j()
  {
    if (((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).isVideoFullScreenMode())
    {
      ((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).exitVideoFullScreen();
      return true;
    }
    QBaseActivity localQBaseActivity = r();
    if (localQBaseActivity == null)
    {
      QLog.e("QQGamePub_QQGameHippyBasePresenter", 1, "GamePAHippyBaseFragment getActivity is null");
      return true;
    }
    HippyQQPreloadEngine localHippyQQPreloadEngine = s();
    if (localHippyQQPreloadEngine != null) {
      return localHippyQQPreloadEngine.doOnBackPressed(new QQGameHippyBasePresenter.1(this, localQBaseActivity));
    }
    localQBaseActivity.finish();
    return true;
  }
  
  public void k()
  {
    MobileQQ.sMobileQQ.unregisterReceiver(this.h);
  }
  
  public void l()
  {
    AppInterface localAppInterface = this.c;
    if (localAppInterface != null)
    {
      ((IGameMsgManagerService)localAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).setUnshowedUnreadCnt(0);
      ((IMessageFacade)this.c.getRuntimeService(IMessageFacade.class, "")).setReaded("2747277822", 1008, true, true);
    }
  }
  
  protected void m()
  {
    this.e = ((QQGameHippyModel)this.b).a().findMessage("2747277822", p());
    this.g = new QQGameHippyBasePresenter.2(this);
    ((QQGameHippyModel)this.b).a().addObserver(this.g);
    Object localObject = this.e;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)((Iterator)localObject).next();
        if (!TextUtils.isEmpty(localQQGameMsgInfo.arkAppName))
        {
          ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addNotify(localQQGameMsgInfo.arkAppName);
          this.f.add(localQQGameMsgInfo.arkAppName);
        }
      }
    }
    ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addObserver(this.j);
    n();
  }
  
  protected void n() {}
  
  protected void o()
  {
    try
    {
      QBaseActivity localQBaseActivity = r();
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (localQBaseActivity != null)) {
        if (localQBaseActivity.mSystemBarComp == null)
        {
          localQBaseActivity.setImmersiveStatus(0);
        }
        else
        {
          localQBaseActivity.mSystemBarComp.setStatusBarDrawable(null);
          localQBaseActivity.mSystemBarComp.setStatusBarColor(0);
          localQBaseActivity.mSystemBarComp.setStatusColor(0);
          localQBaseActivity.mSystemBarComp.setgetStatusBarVisible(false, 0);
        }
      }
      LiuHaiUtils.enableNotch(localQBaseActivity);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
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
            paramBundle = Integer.valueOf(localGmpEnterInfoRsp.retCode);
          } else {
            paramBundle = "";
          }
          localStringBuilder.append(paramBundle);
          QLog.d("QQGamePub_QQGameHippyBasePresenter", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("GmpEnterInfoRsp|");
          if (localGmpEnterInfoRsp != null) {
            paramBundle = localGmpEnterInfoRsp.url;
          } else {
            paramBundle = "";
          }
          localStringBuilder.append(paramBundle);
          QLog.d("QQGamePub_QQGameHippyBasePresenter", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("GmpEnterInfoRsp|");
          paramBundle = (Bundle)localObject;
          if (localGmpEnterInfoRsp != null) {
            paramBundle = localGmpEnterInfoRsp.content;
          }
          localStringBuilder.append(paramBundle);
          QLog.d("QQGamePub_QQGameHippyBasePresenter", 2, localStringBuilder.toString());
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
          QLog.d("QQGamePub_QQGameHippyBasePresenter", 1, ((StringBuilder)localObject).toString());
          return;
        }
      }
      QLog.d("QQGamePub_QQGameHippyBasePresenter", 2, "GmpEnterInfoRsp| is null");
      a(null, false);
    }
  }
  
  protected int p()
  {
    return 3;
  }
  
  protected int q()
  {
    return 5;
  }
  
  protected QBaseActivity r()
  {
    if (!c())
    {
      QLog.i("QQGamePub_QQGameHippyBasePresenter", 1, "[getActivity] view is detach");
      return null;
    }
    return (QBaseActivity)((IQQGameHippyBaseView)this.a.get()).d();
  }
  
  public HippyQQPreloadEngine s()
  {
    if (!c())
    {
      QLog.i("QQGamePub_QQGameHippyBasePresenter", 1, "[getHippyQQEngine] view is detach");
      return null;
    }
    return ((IQQGameHippyBaseView)this.a.get()).c();
  }
  
  public String t()
  {
    return "";
  }
  
  public void u()
  {
    Object localObject = r();
    if (localObject != null)
    {
      localObject = new ActivityURIRequest((Context)localObject, "/pubaccount/detail");
      ((ActivityURIRequest)localObject).extra().putString("uin", "2747277822");
      ((ActivityURIRequest)localObject).extra().putBoolean("fromQGamePub", true);
      QRoute.startUri((URIRequest)localObject, null);
    }
  }
  
  public void v()
  {
    QBaseActivity localQBaseActivity = r();
    if (localQBaseActivity != null) {
      localQBaseActivity.finish();
    }
  }
  
  public QQGameReportLogic w()
  {
    if (this.i == null) {
      this.i = new QQGameReportLogic();
    }
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter
 * JD-Core Version:    0.7.0.1
 */