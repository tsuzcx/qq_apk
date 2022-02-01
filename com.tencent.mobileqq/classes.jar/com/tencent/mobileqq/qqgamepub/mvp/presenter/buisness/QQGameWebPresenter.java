package com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.viewpager.widget.ViewPager;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoReq;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.ipc.QQGameIPCHandler;
import com.tencent.mobileqq.qqgamepub.ipc.QQGameIPCHandler.QGameIpcCallBack;
import com.tencent.mobileqq.qqgamepub.model.GameMsgData;
import com.tencent.mobileqq.qqgamepub.mvp.model.bean.QQGameWebFeedModel;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.base.BaseUIPresenter;
import com.tencent.mobileqq.qqgamepub.mvp.view.buisness.IQQGameWebFeedView;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.utils.GameVideoManager;
import com.tencent.mobileqq.qqgamepub.view.GameArkView;
import com.tencent.mobileqq.qqgamepub.view.IHeaderView;
import com.tencent.mobileqq.qqgamepub.web.GameWebCostLogic;
import com.tencent.mobileqq.qqgamepub.web.QQGameReportLogic;
import com.tencent.mobileqq.qqgamepub.web.UnReadMsgLogic;
import com.tencent.mobileqq.qqgamepub.web.WebHeadPageAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;

public class QQGameWebPresenter
  extends BaseUIPresenter<IQQGameWebFeedView, QQGameWebFeedModel>
  implements WadlProxyServiceCallBackInterface, QQGameIPCHandler.QGameIpcCallBack, BusinessObserver
{
  private boolean c = false;
  private String d;
  private QQGameWebPresenter.MessageQGameReceiver e;
  private List<String> f = new ArrayList();
  private WebHeadPageAdapter g;
  private GameWebCostLogic h;
  private UnReadMsgLogic i;
  private QQGameReportLogic j;
  @SuppressLint({"HandlerLeak"})
  private Handler k = new QQGameWebPresenter.1(this);
  
  private void K()
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGameWebPresenter.5(this), 500L);
  }
  
  private void a(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    if (paramIntent == null) {
      return;
    }
    paramIntent = (ArrayList)paramIntent.getSerializable("key_get_msg");
    if ((paramIntent != null) && (paramIntent.size() > 0)) {
      ThreadManagerV2.getUIHandlerV2().post(new QQGameWebPresenter.4(this, paramIntent));
    }
  }
  
  private Map<String, Object> b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", Integer.valueOf(paramInt1));
    if (paramInt1 == 4)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        localHashMap.put("perfData", paramString);
        return localHashMap;
      }
    }
    else
    {
      if (paramInt2 != -1) {
        localHashMap.put("index", Integer.valueOf(paramInt2));
      }
      if (paramInt3 != -1) {
        localHashMap.put("height", Integer.valueOf(paramInt3));
      }
      if (!TextUtils.isEmpty(paramString)) {
        localHashMap.put("gameData", paramString);
      }
    }
    return localHashMap;
  }
  
  private void b(Activity paramActivity)
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGameWebPresenter.3(this, paramActivity), 400L);
  }
  
  private void b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("arkViewId");
    boolean bool = paramIntent.getBooleanExtra("isAioDeletMsg", false);
    if (!TextUtils.isEmpty(str)) {
      a(str, bool);
    }
  }
  
  public GameMsgData A()
  {
    return ((QQGameWebFeedModel)b()).g();
  }
  
  public void B()
  {
    this.e = new QQGameWebPresenter.MessageQGameReceiver(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_qgame_tool_messgae");
    localIntentFilter.addAction("action_qgame_jaspi_webloaded");
    localIntentFilter.addAction("action_qgame_h5_video_pause");
    localIntentFilter.addAction("action_qgame_h5_video_play");
    localIntentFilter.addAction("action_qgame_delete_ad");
    MobileQQ.sMobileQQ.registerReceiver(this.e, localIntentFilter);
  }
  
  public void C()
  {
    if (this.e != null) {
      MobileQQ.sMobileQQ.unregisterReceiver(this.e);
    }
  }
  
  public void D()
  {
    a(4, -1, -1, p().l(), 2000L);
  }
  
  public void E()
  {
    if (((QQGameWebFeedModel)b()).i() > 0)
    {
      ((QQGameWebFeedModel)b()).a(0);
      UnReadMsgLogic localUnReadMsgLogic = q();
      if (localUnReadMsgLogic.d() > 0)
      {
        localUnReadMsgLogic.a();
        return;
      }
      ((QQGameWebFeedModel)b()).a(((QQGameWebFeedModel)b()).d());
    }
  }
  
  public void F()
  {
    int m = ((QQGameWebFeedModel)b()).f();
    IHeaderView localIHeaderView = ((QQGameWebFeedModel)b()).c(m);
    if (localIHeaderView != null)
    {
      ((QQGameWebFeedModel)b()).a(localIHeaderView);
      if ((localIHeaderView instanceof GameArkView)) {
        ((GameArkView)localIHeaderView).f();
      }
    }
  }
  
  public void G()
  {
    ((QQGameWebFeedModel)b()).g().f();
  }
  
  public QQGameMsgInfo H()
  {
    if (c())
    {
      int m = y().k();
      return ((QQGameWebFeedModel)b()).b(m);
    }
    return null;
  }
  
  public void I()
  {
    if (!c()) {
      return;
    }
    a(3, -1, y().g(), "");
    if ((k() != null) && (((QQGameWebFeedModel)b()).b())) {
      a(1, y().k(), -1, "");
    }
    if (((QQGameWebFeedModel)b()).i() > 3) {
      a(2, -1, -1, ((QQGameWebFeedModel)b()).e());
    }
  }
  
  public QBaseActivity J()
  {
    if (!c())
    {
      QLog.i("QQGamePub_GamePAWebPresenter", 1, "[getActivity] view is detach");
      return null;
    }
    return ((IQQGameWebFeedView)this.a.get()).l();
  }
  
  public void a(int paramInt)
  {
    n().removeMessages(102);
    a(102, paramInt, -1, "", 200L);
    if (c()) {
      y().b(paramInt);
    }
    QQGameMsgInfo localQQGameMsgInfo = ((QQGameWebFeedModel)b()).b(paramInt);
    AppInterface localAppInterface = ((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface();
    if (localAppInterface != null) {
      ((QQGameWebFeedModel)b()).a(localAppInterface, localQQGameMsgInfo.paMsgid);
    }
    c(paramInt);
    n().removeMessages(1);
    a(1, paramInt, -1, "");
    ((QQGameWebFeedModel)b()).a();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    localMessage.obj = paramObject;
    n().sendMessage(localMessage);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    localMessage.obj = paramObject;
    n().sendMessageDelayed(localMessage, paramLong);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (c())
    {
      paramString = b(paramInt1, paramInt2, paramInt3, paramString);
      y().a(paramString);
    }
  }
  
  public void a(int paramInt, Activity paramActivity)
  {
    if (((QQGameWebFeedModel)b()).d(paramInt))
    {
      a(paramInt);
      return;
    }
    if (((QQGameWebFeedModel)b()).e(paramInt)) {
      b(paramActivity);
    }
  }
  
  public void a(ViewPager paramViewPager, Context paramContext)
  {
    this.g = new WebHeadPageAdapter(this, paramContext, paramViewPager);
  }
  
  public void a(WadlResult paramWadlResult) {}
  
  public void a(QBaseActivity paramQBaseActivity)
  {
    paramQBaseActivity = paramQBaseActivity.getIntent();
    boolean bool = false;
    long l3 = 0L;
    long l2;
    long l1;
    long l4;
    if (paramQBaseActivity != null)
    {
      if (paramQBaseActivity.hasExtra("startTime"))
      {
        l2 = paramQBaseActivity.getLongExtra("startTime", 0L);
        if (l2 > 0L) {
          l1 = SystemClock.elapsedRealtime() - l2;
        } else {
          l1 = 0L;
        }
      }
      else
      {
        l2 = 0L;
        l1 = l2;
      }
      if (paramQBaseActivity.hasExtra("clickTime")) {
        l3 = paramQBaseActivity.getLongExtra("clickTime", 0L);
      }
      if (paramQBaseActivity.hasExtra("unreadNum")) {
        this.i = new UnReadMsgLogic(paramQBaseActivity.getIntExtra("unreadNum", 0));
      }
      if (paramQBaseActivity.hasExtra("isColdBoot")) {
        bool = paramQBaseActivity.getBooleanExtra("isColdBoot", false);
      }
      if (paramQBaseActivity.hasExtra("arkResPath")) {
        this.d = paramQBaseActivity.getStringExtra("arkResPath");
      }
      l4 = l1;
    }
    else
    {
      l2 = 0L;
      l1 = l2;
      l4 = l1;
      bool = false;
      l3 = l1;
    }
    p().a(l2, l3, bool, l4);
  }
  
  public void a(String paramString)
  {
    ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addNotify(paramString);
    this.f.add(paramString);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("frienduin", paramString);
    localBundle.putInt("istroop", paramInt);
    localBundle.putLong("uniseq", paramLong);
    QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "deleteMessage", localBundle);
  }
  
  public void a(String paramString, EIPCResult paramEIPCResult)
  {
    if (!c()) {
      return;
    }
    try
    {
      if ("task_get_qgame_msg".equals(paramString))
      {
        y().a(paramEIPCResult);
        return;
      }
      if ("task_qgame_task_all_complete".equals(paramString))
      {
        y().f();
        return;
      }
    }
    catch (Throwable paramString)
    {
      paramEIPCResult = new StringBuilder();
      paramEIPCResult.append("handleIpcResult fail:");
      paramEIPCResult.append(paramString.getMessage());
      QLog.d("QQGamePub_GamePAWebPresenter", 1, paramEIPCResult.toString());
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("deleteMsg arkViewId:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("QQGamePub_GamePAWebPresenter", 1, ((StringBuilder)localObject1).toString());
      Object localObject2 = null;
      Iterator localIterator = A().d().iterator();
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (QQGameMsgInfo)localIterator.next();
      } while (!paramString.equals(String.valueOf(((QQGameMsgInfo)localObject1).uniseq)));
      if (localObject1 != null)
      {
        if (!paramBoolean)
        {
          a(((QQGameMsgInfo)localObject1).frienduin, ((QQGameMsgInfo)localObject1).istroop, ((QQGameMsgInfo)localObject1).uniseq);
          QQToast.makeText(MobileQQ.getContext(), 2131898886, 1).show();
        }
        b(paramString);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a(ArrayList<WadlResult> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("---->onQueryCallback isGetGameEnter=");
      localStringBuilder.append(this.c);
      QLog.d("QQGamePub_GamePAWebPresenter", 1, localStringBuilder.toString());
    }
    if (this.c) {
      return;
    }
    long l = GamePubAccountHelper.a(paramArrayList);
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("---> get lastGameAppID=");
      paramArrayList.append(l);
      QLog.d("QQGamePub_GamePAWebPresenter", 1, paramArrayList.toString());
    }
    this.c = true;
    paramArrayList = new GmpEnterInfoReq(l, 1, 0);
    ((IQWalletApi)QRoute.api(IQWalletApi.class)).servletSendRequest(paramArrayList, this);
  }
  
  public void b(int paramInt)
  {
    int m = 0;
    while (m < ((QQGameWebFeedModel)b()).j())
    {
      Object localObject1;
      if (m == paramInt)
      {
        Object localObject2 = ((QQGameWebFeedModel)b()).c(paramInt);
        ((QQGameWebFeedModel)b()).a((IHeaderView)localObject2);
        if ((localObject2 instanceof GameArkView))
        {
          localObject1 = GameVideoManager.a();
          localObject2 = (GameArkView)localObject2;
          ((GameVideoManager)localObject1).a((GameArkView)localObject2);
          ((GameArkView)localObject2).f();
        }
        else
        {
          GameVideoManager.a().a(null);
        }
      }
      else
      {
        localObject1 = ((QQGameWebFeedModel)b()).c(m);
        if (localObject1 != null) {
          ((IHeaderView)localObject1).b();
        }
      }
      m += 1;
    }
    ((QQGameWebFeedModel)b()).h().a();
  }
  
  public void b(QBaseActivity paramQBaseActivity)
  {
    if (!SimpleUIUtil.e())
    {
      paramQBaseActivity.setSystemBarComp(null);
      paramQBaseActivity.setImmersiveStatus(0);
    }
  }
  
  public void b(String paramString)
  {
    if (!c()) {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QQGamePub_GamePAWebPresenter", 1, "handleAdReverseFeedBack, arkViewId is null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("h5,call handleAdReverseFeedBack arkViewId:");
    localStringBuilder.append(paramString);
    QLog.d("QQGamePub_GamePAWebPresenter", 1, localStringBuilder.toString());
    y().a(false, 0);
    int i1 = ((QQGameWebFeedModel)b()).a(paramString);
    if (i1 < 0) {
      return;
    }
    if (i1 < ((QQGameWebFeedModel)b()).j())
    {
      paramString = (IHeaderView)A().e().get(i1);
      int n = y().k();
      int m = n;
      if (n == A().b() - 1) {
        m = n - 1;
      }
      if (m != -1)
      {
        A().e().remove(paramString);
        A().d().remove(i1);
        y().c(m);
        a(2, m, -1, GamePubAccountHelper.a(A().d()).toString());
        a(1, m, -1, "");
      }
    }
  }
  
  public void b(ArrayList<WadlResult> paramArrayList) {}
  
  public void c(int paramInt)
  {
    QQGameMsgInfo localQQGameMsgInfo = ((QQGameWebFeedModel)b()).b(paramInt);
    if (localQQGameMsgInfo != null)
    {
      if (paramInt == 0) {
        ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).reportGamePubAccountMsgStatus(2, localQQGameMsgInfo.paMsgid, "");
      }
      GamePubAccountHelper.a(localQQGameMsgInfo, 0, GamePubAccountHelper.a());
    }
  }
  
  public void c(ArrayList<QQGameMsgInfo> paramArrayList)
  {
    if (!c()) {
      return;
    }
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int m;
      if (l() == 1) {
        m = 1;
      } else {
        m = 0;
      }
      q().a(paramArrayList.size());
      q().b(paramArrayList.size());
      int n = 0;
      while (n < paramArrayList.size())
      {
        A().d().add(0, paramArrayList.get(n));
        IHeaderView localIHeaderView = ((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).createHeader((QQGameMsgInfo)paramArrayList.get(n), J());
        A().a(0, localIHeaderView);
        if (!TextUtils.isEmpty(((QQGameMsgInfo)paramArrayList.get(n)).arkAppName)) {
          a(((QQGameMsgInfo)paramArrayList.get(n)).arkAppName);
        }
        if (n == paramArrayList.size() - 1)
        {
          if (m == 0) {
            n().sendEmptyMessageDelayed(100, 3000L);
          }
          y().a(((QQGameMsgInfo)paramArrayList.get(n)).paMsgid);
        }
        int i1 = y().k();
        if (m == 0) {
          i1 += 1;
        }
        y().c(-1);
        y().d(i1);
        r().a(((QQGameMsgInfo)paramArrayList.get(n)).gameAppId, ((QQGameMsgInfo)paramArrayList.get(n)).paMsgid);
        n += 1;
      }
    }
  }
  
  public WebHeadPageAdapter k()
  {
    return this.g;
  }
  
  public int l()
  {
    WebHeadPageAdapter localWebHeadPageAdapter = this.g;
    if (localWebHeadPageAdapter != null) {
      return localWebHeadPageAdapter.getCount();
    }
    return -1;
  }
  
  public void m()
  {
    if (this.f != null) {
      ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).unRegistVolumnReceiver(this.f);
    }
  }
  
  public Handler n()
  {
    return this.k;
  }
  
  protected QQGameWebFeedModel o()
  {
    return new QQGameWebFeedModel(this);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 31)
    {
      GmpEnterInfoRsp localGmpEnterInfoRsp = null;
      Object localObject = localGmpEnterInfoRsp;
      if (paramBoolean)
      {
        localObject = localGmpEnterInfoRsp;
        if (paramBundle != null)
        {
          localGmpEnterInfoRsp = (GmpEnterInfoRsp)paramBundle.getSerializable("rsp");
          localObject = localGmpEnterInfoRsp;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("GmpEnterInfoRsp|");
            if (localGmpEnterInfoRsp != null) {
              paramBundle = Integer.valueOf(localGmpEnterInfoRsp.retCode);
            } else {
              paramBundle = "";
            }
            ((StringBuilder)localObject).append(paramBundle);
            QLog.d("QQGamePub_GamePAWebPresenter", 2, ((StringBuilder)localObject).toString());
            localObject = localGmpEnterInfoRsp;
          }
        }
      }
      ThreadManagerV2.getUIHandlerV2().post(new QQGameWebPresenter.2(this, (GmpEnterInfoRsp)localObject));
    }
  }
  
  public GameWebCostLogic p()
  {
    if (this.h == null) {
      this.h = new GameWebCostLogic();
    }
    return this.h;
  }
  
  public UnReadMsgLogic q()
  {
    if (this.i == null) {
      this.i = new UnReadMsgLogic(0);
    }
    return this.i;
  }
  
  public QQGameReportLogic r()
  {
    if (this.j == null) {
      this.j = new QQGameReportLogic();
    }
    return this.j;
  }
  
  public void s()
  {
    GameVideoManager.a().a(2);
  }
  
  public void t()
  {
    this.c = false;
    WadlProxyServiceUtil.a().a(this);
  }
  
  public void u()
  {
    QQGameIPCHandler.a().b();
    QQGameIPCHandler.a().a("task_qgame_task_all_complete", this);
    QQGameIPCHandler.a().a("task_get_qgame_msg", this);
    QQGameIPCHandler.a().a("task_get_qgame_msg", true);
  }
  
  public void v()
  {
    Handler localHandler = this.k;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    m();
    G();
    QQGameIPCHandler.a().c();
    GameVideoManager.a().g();
    WadlProxyServiceUtil.a().b(this);
  }
  
  public void w()
  {
    if (c())
    {
      y().a();
      WadlProxyServiceUtil.a().a();
    }
  }
  
  public String x()
  {
    return this.d;
  }
  
  public IQQGameWebFeedView y()
  {
    return (IQQGameWebFeedView)this.a.get();
  }
  
  public void z()
  {
    if (c()) {
      a(3, -1, y().g(), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameWebPresenter
 * JD-Core Version:    0.7.0.1
 */