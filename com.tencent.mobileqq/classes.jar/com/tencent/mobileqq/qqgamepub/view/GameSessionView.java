package com.tencent.mobileqq.qqgamepub.view;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.data.IDataVisitor;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameDelSessionRecord;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qqgamepub.config.QQGameConfBean;
import com.tencent.mobileqq.qqgamepub.ipc.QQGameIPCHandler;
import com.tencent.mobileqq.qqgamepub.ipc.QQGameIPCHandler.QGameIpcCallBack;
import com.tencent.mobileqq.qqgamepub.web.view.GameContentView.UiRefresh;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class GameSessionView
  extends RelativeLayout
  implements Handler.Callback, QQGameIPCHandler.QGameIpcCallBack, HippyViewBase
{
  public static final String a;
  private static boolean l = false;
  private List<GameCenterSessionInfo> b = new ArrayList();
  private Handler c = new Handler(Looper.getMainLooper(), this);
  private AppRuntime d;
  private GameContentView.UiRefresh e;
  private GameSessionView.GameMessageReceiver f;
  private int g = 1;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private GameSessionView.SessionStyle k;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQGamePub_");
    localStringBuilder.append(GameSessionView.class.getSimpleName());
    a = localStringBuilder.toString();
  }
  
  public GameSessionView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public GameSessionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public GameSessionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private GameSessionView.SessionStyle a(int paramInt)
  {
    boolean bool = ((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getNewPAHippyV2Switch();
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[createSessionStyle], hippySwitch:");
    localStringBuilder.append(bool);
    QLog.i(str, 1, localStringBuilder.toString());
    if (bool) {
      return new GameSessionView.SessionStyleB4Hippy(this, null);
    }
    return new GameSessionView.SessionStyleB(this, null);
  }
  
  private void a(Context paramContext, GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    AppRuntime localAppRuntime = this.d;
    if (localAppRuntime == null) {
      return;
    }
    if ((localAppRuntime instanceof BaseQQAppInterface))
    {
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).openGameMsgSessionPage(paramContext, paramGameCenterSessionInfo, "92001");
      return;
    }
    if (((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).isToolAppRuntime(this.d))
    {
      QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "getGameMsgUrl", null, new GameSessionView.4(this, paramContext, paramGameCenterSessionInfo));
      return;
    }
    paramContext = a;
    paramGameCenterSessionInfo = new StringBuilder();
    paramGameCenterSessionInfo.append("[initData] unknown interface:");
    paramGameCenterSessionInfo.append(this.d.getClass().getSimpleName());
    QLog.w(paramContext, 1, paramGameCenterSessionInfo.toString());
  }
  
  private void a(CornerImageView paramCornerImageView, String paramString)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getResources().getDrawable(2130841444);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = getResources().getDrawable(2130841444);
    try
    {
      paramCornerImageView.setImageDrawable(URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject));
      return;
    }
    catch (Exception paramCornerImageView)
    {
      paramString = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[setAvatar] ");
      ((StringBuilder)localObject).append(paramCornerImageView);
      QLog.e(paramString, 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private boolean a(List<GameCenterSessionInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return true;
      }
      new ArrayList();
      IDataVisitor localIDataVisitor = ((IGameMsgManagerService)this.d.getRuntimeService(IGameMsgManagerService.class, "")).getSessionDelDataHelper();
      if (localIDataVisitor == null) {
        return false;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GameCenterSessionInfo localGameCenterSessionInfo = (GameCenterSessionInfo)paramList.next();
        GameDelSessionRecord localGameDelSessionRecord = new GameDelSessionRecord();
        localGameDelSessionRecord.mUin = localGameCenterSessionInfo.g();
        if ((localGameCenterSessionInfo != null) && (!localIDataVisitor.d(localGameDelSessionRecord))) {
          return false;
        }
      }
    }
    return true;
  }
  
  public void a()
  {
    GameContentView.UiRefresh localUiRefresh = this.e;
    if (localUiRefresh != null) {
      localUiRefresh.h();
    }
  }
  
  public void a(Context paramContext)
  {
    this.f = new GameSessionView.GameMessageReceiver(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_qgame_messgae_change");
    localIntentFilter.addAction("action_qgame_unread_change");
    paramContext.registerReceiver(this.f, localIntentFilter);
  }
  
  public void a(String paramString, EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      paramEIPCResult = paramEIPCResult.data;
      if (paramEIPCResult != null)
      {
        paramString = (List)paramEIPCResult.getSerializable("key_get_game_msg");
        if (!this.i)
        {
          if (!paramEIPCResult.getBoolean("key_get_game_gray_user", false))
          {
            if (QLog.isColorLevel()) {
              QLog.d(a, 2, "[setData] gray is not open. return.");
            }
            return;
          }
          this.h = paramEIPCResult.getBoolean("key_get_game_show_on_list", false);
          l = paramEIPCResult.getBoolean("key_get_game_show_req_msg_unread", false);
          this.i = true;
        }
        paramEIPCResult = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onCallback] list:");
        localStringBuilder.append(paramString.size());
        localStringBuilder.append(",type:");
        localStringBuilder.append(this.g);
        QLog.e(paramEIPCResult, 1, localStringBuilder.toString());
        setData(paramString);
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime, GameContentView.UiRefresh paramUiRefresh)
  {
    if (paramAppRuntime == null) {
      return;
    }
    this.d = paramAppRuntime;
    this.e = paramUiRefresh;
    this.i = false;
    QQGameIPCHandler.a().a("task_get_qgame_session_msg", this);
    paramAppRuntime = this.d;
    if (paramAppRuntime == null) {
      return;
    }
    if ((paramAppRuntime instanceof BaseQQAppInterface))
    {
      ThreadManager.getSubThreadHandler().post(new GameSessionView.1(this));
      return;
    }
    if (((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).isToolAppRuntime(this.d))
    {
      QQGameIPCHandler.a().a("task_get_qgame_session_msg", true);
      return;
    }
    paramAppRuntime = a;
    paramUiRefresh = new StringBuilder();
    paramUiRefresh.append("[initData] unknown interface:");
    paramUiRefresh.append(this.d.getClass().getSimpleName());
    QLog.i(paramAppRuntime, 1, paramUiRefresh.toString());
  }
  
  public void b()
  {
    if (getContext() != null) {
      getContext().unregisterReceiver(this.f);
    }
    this.c.removeCallbacksAndMessages(null);
    QQGameIPCHandler.a().a("task_get_qgame_session_msg");
  }
  
  public void getData()
  {
    Object localObject = this.d;
    if (localObject == null) {
      return;
    }
    if ((localObject instanceof BaseQQAppInterface))
    {
      ThreadManager.getSubThreadHandler().post(new GameSessionView.2(this));
      return;
    }
    if (((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).isToolAppRuntime(this.d))
    {
      QQGameIPCHandler.a().a("task_get_qgame_session_msg", true);
      QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "getGameMsg", null, new GameSessionView.3(this));
      return;
    }
    localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[initData] unknown interface:");
    localStringBuilder.append(this.d.getClass().getSimpleName());
    QLog.i((String)localObject, 1, localStringBuilder.toString());
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    this.h = false;
    setVisibility(8);
    requestLayout();
    paramMessage = this.e;
    if (paramMessage != null) {
      paramMessage.h();
    }
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.b;
    int m = 0;
    if ((localObject1 != null) && (((List)localObject1).size() != 0) && ((this.g != 2) || (this.h)))
    {
      super.onMeasure(paramInt1, paramInt2);
      if (!this.j)
      {
        if (this.b.get(0) != null)
        {
          localObject2 = (GameCenterSessionInfo)this.b.get(0);
          localObject1 = ((GameCenterSessionInfo)localObject2).h();
          if (((GameCenterSessionInfo)localObject2).f() == 0)
          {
            if (l)
            {
              paramInt1 = 0;
              paramInt2 = m;
              break label139;
            }
          }
          else
          {
            paramInt1 = ((GameCenterSessionInfo)localObject2).o();
            if (paramInt1 > 0)
            {
              paramInt2 = m;
              break label139;
            }
            break label137;
          }
        }
        else
        {
          localObject1 = "";
        }
        paramInt1 = 0;
        label137:
        paramInt2 = 1;
        label139:
        Object localObject2 = (IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class);
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramInt2);
        ((StringBuilder)localObject3).append("");
        localObject3 = ((StringBuilder)localObject3).toString();
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(this.g);
        ((StringBuilder)localObject4).append("");
        localObject4 = ((StringBuilder)localObject4).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("");
        ((IGameMsgHelperApi)localObject2).reportForGameMsg((String)localObject1, "1", "145", "920", "92001", "206341", (String)localObject3, "0", (String)localObject4, "8", "", "", localStringBuilder.toString());
        this.j = true;
      }
    }
    else
    {
      setMeasuredDimension(0, 0);
    }
  }
  
  public void setData(List<GameCenterSessionInfo> paramList)
  {
    if (a(paramList))
    {
      this.b = new ArrayList();
      setVisibility(8);
      paramList = this.e;
      if (paramList != null) {
        paramList.h();
      }
      return;
    }
    this.b = paramList;
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[setData] dataList size:");
      localStringBuilder.append(paramList.size());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.b.size() > 0)
    {
      paramList = this.b.iterator();
      int m = 0;
      for (;;)
      {
        n = m;
        if (!paramList.hasNext()) {
          break;
        }
        localObject = (GameCenterSessionInfo)paramList.next();
        if (((GameCenterSessionInfo)localObject).f() == 0)
        {
          n = m + 1;
          m = n;
          if (QLog.isColorLevel())
          {
            localObject = a;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[folder], cnt:");
            localStringBuilder.append(n);
            QLog.d((String)localObject, 2, localStringBuilder.toString());
            m = n;
          }
        }
        else
        {
          n = m + ((GameCenterSessionInfo)localObject).o();
          m = n;
          if (QLog.isColorLevel())
          {
            localObject = a;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[normal], cnt:");
            localStringBuilder.append(n);
            QLog.d((String)localObject, 2, localStringBuilder.toString());
            m = n;
          }
        }
      }
    }
    int n = 0;
    paramList = this.k;
    if (paramList != null)
    {
      paramList.a();
      removeAllViews();
    }
    this.k = a(n);
    this.k.a(this);
    this.k.a(this.b, n);
    boolean bool1 = this.k instanceof GameSessionView.SessionStyleB4Hippy;
    setVisibility(0);
    boolean bool2 = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getGameSessionShown(this.d.getAccount());
    if (n > 0)
    {
      paramList = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[setData] unread:");
      ((StringBuilder)localObject).append(n);
      ((StringBuilder)localObject).append(", gameSessionShown:");
      ((StringBuilder)localObject).append(bool2);
      QLog.i(paramList, 1, ((StringBuilder)localObject).toString());
      if (!bool2)
      {
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).setGameSessionShown(this.d.getAccount(), true);
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", "145", "920", "92001", "207622", "", "", "", "");
      }
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).setLastGameSessionClicked(this.d.getAccount(), System.currentTimeMillis());
    }
    else
    {
      long l1 = System.currentTimeMillis();
      long l2 = QQGameConfBean.a().k * 3600 * 1000;
      long l3 = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getLastGameSessionClicked(this.d.getAccount());
      if (l3 == 0L)
      {
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).setLastGameSessionClicked(this.d.getAccount(), l1);
        paramList = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[setData] init LastGameSessionClicked:");
        ((StringBuilder)localObject).append(l1);
        QLog.i(paramList, 1, ((StringBuilder)localObject).toString());
      }
      if ((l3 != 0L) && (l1 - l3 >= l2)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramList = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[setData] unread:");
      ((StringBuilder)localObject).append(n);
      ((StringBuilder)localObject).append(", expired:");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(", duration:");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(", lastGameSessionClicked:");
      ((StringBuilder)localObject).append(l3);
      ((StringBuilder)localObject).append(", gameSessionShown:");
      ((StringBuilder)localObject).append(bool2);
      QLog.i(paramList, 1, ((StringBuilder)localObject).toString());
      if (bool1)
      {
        if (bool2)
        {
          paramList = this.e;
          if (paramList != null) {
            paramList.c(1000L);
          }
          ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).setGameSessionShown(this.d.getAccount(), false);
          ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", "145", "920", "92001", "207621", "", "", "", "");
          QLog.i(a, 1, "[setData] setGameSessionShown false");
        }
        else
        {
          setVisibility(8);
          paramList = this.e;
          if (paramList != null) {
            paramList.c(1000L);
          }
        }
      }
      else {
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).setLastGameSessionClicked(this.d.getAccount(), l1);
      }
    }
    paramList = this.e;
    if (paramList != null) {
      paramList.h();
    }
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.GameSessionView
 * JD-Core Version:    0.7.0.1
 */