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
import com.tencent.mobileqq.gamecenter.msgInfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msgInfo.GameDelSessionRecord;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qqgamepub.config.QQGameConfBean;
import com.tencent.mobileqq.qqgamepub.ipc.QQGameIpcHandle;
import com.tencent.mobileqq.qqgamepub.ipc.QQGameIpcHandle.QGameIpcCallBack;
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
  implements Handler.Callback, QQGameIpcHandle.QGameIpcCallBack, HippyViewBase
{
  public static final String a;
  private static boolean d = false;
  private int jdField_a_of_type_Int = 1;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private GameSessionView.GameMessageReceiver jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView$GameMessageReceiver;
  private GameSessionView.SessionStyle jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView$SessionStyle;
  private GameContentView.UiRefresh jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView$UiRefresh;
  private List<GameCenterSessionInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQGamePub_");
    localStringBuilder.append(GameSessionView.class.getSimpleName());
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
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
    String str = jdField_a_of_type_JavaLangString;
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
    AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    if (localAppRuntime == null) {
      return;
    }
    if ((localAppRuntime instanceof BaseQQAppInterface))
    {
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).openGameMsgSessionPage(paramContext, paramGameCenterSessionInfo, "92001");
      return;
    }
    if (((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).isToolAppRuntime(this.jdField_a_of_type_MqqAppAppRuntime))
    {
      QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "getGameMsgUrl", null, new GameSessionView.4(this, paramContext, paramGameCenterSessionInfo));
      return;
    }
    paramContext = jdField_a_of_type_JavaLangString;
    paramGameCenterSessionInfo = new StringBuilder();
    paramGameCenterSessionInfo.append("[initData] unknown interface:");
    paramGameCenterSessionInfo.append(this.jdField_a_of_type_MqqAppAppRuntime.getClass().getSimpleName());
    QLog.w(paramContext, 1, paramGameCenterSessionInfo.toString());
  }
  
  private void a(CornerImageView paramCornerImageView, String paramString)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getResources().getDrawable(2130840667);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = getResources().getDrawable(2130840667);
    try
    {
      paramCornerImageView.setImageDrawable(URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject));
      return;
    }
    catch (Exception paramCornerImageView)
    {
      paramString = jdField_a_of_type_JavaLangString;
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
      IDataVisitor localIDataVisitor = ((IGameMsgManagerService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IGameMsgManagerService.class, "")).getSessionDelDataHelper();
      if (localIDataVisitor == null) {
        return false;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GameCenterSessionInfo localGameCenterSessionInfo = (GameCenterSessionInfo)paramList.next();
        GameDelSessionRecord localGameDelSessionRecord = new GameDelSessionRecord();
        localGameDelSessionRecord.mUin = localGameCenterSessionInfo.d();
        if ((localGameCenterSessionInfo != null) && (!localIDataVisitor.d(localGameDelSessionRecord))) {
          return false;
        }
      }
    }
    return true;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime;
    if (localObject == null) {
      return;
    }
    if ((localObject instanceof BaseQQAppInterface))
    {
      ThreadManager.getSubThreadHandler().post(new GameSessionView.2(this));
      return;
    }
    if (((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).isToolAppRuntime(this.jdField_a_of_type_MqqAppAppRuntime))
    {
      QQGameIpcHandle.a().a("task_get_qgame_session_msg", true);
      QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "getGameMsg", null, new GameSessionView.3(this));
      return;
    }
    localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[initData] unknown interface:");
    localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getClass().getSimpleName());
    QLog.i((String)localObject, 1, localStringBuilder.toString());
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView$GameMessageReceiver = new GameSessionView.GameMessageReceiver(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_qgame_messgae_change");
    localIntentFilter.addAction("action_qgame_unread_change");
    paramContext.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView$GameMessageReceiver, localIntentFilter);
  }
  
  public void a(String paramString, EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      paramEIPCResult = paramEIPCResult.data;
      if (paramEIPCResult != null)
      {
        paramString = (List)paramEIPCResult.getSerializable("key_get_game_msg");
        if (!this.b)
        {
          if (!paramEIPCResult.getBoolean("key_get_game_gray_user", false))
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "[setData] gray is not open. return.");
            }
            return;
          }
          this.jdField_a_of_type_Boolean = paramEIPCResult.getBoolean("key_get_game_show_on_list", false);
          d = paramEIPCResult.getBoolean("key_get_game_show_req_msg_unread", false);
          this.b = true;
        }
        paramEIPCResult = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onCallback] list:");
        localStringBuilder.append(paramString.size());
        localStringBuilder.append(",type:");
        localStringBuilder.append(this.jdField_a_of_type_Int);
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
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView$UiRefresh = paramUiRefresh;
    this.b = false;
    QQGameIpcHandle.a().a("task_get_qgame_session_msg", this);
    paramAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    if (paramAppRuntime == null) {
      return;
    }
    if ((paramAppRuntime instanceof BaseQQAppInterface))
    {
      ThreadManager.getSubThreadHandler().post(new GameSessionView.1(this));
      return;
    }
    if (((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).isToolAppRuntime(this.jdField_a_of_type_MqqAppAppRuntime))
    {
      QQGameIpcHandle.a().a("task_get_qgame_session_msg", true);
      return;
    }
    paramAppRuntime = jdField_a_of_type_JavaLangString;
    paramUiRefresh = new StringBuilder();
    paramUiRefresh.append("[initData] unknown interface:");
    paramUiRefresh.append(this.jdField_a_of_type_MqqAppAppRuntime.getClass().getSimpleName());
    QLog.i(paramAppRuntime, 1, paramUiRefresh.toString());
  }
  
  public void b()
  {
    GameContentView.UiRefresh localUiRefresh = this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView$UiRefresh;
    if (localUiRefresh != null) {
      localUiRefresh.b();
    }
  }
  
  public void c()
  {
    if (getContext() != null) {
      getContext().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView$GameMessageReceiver);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    QQGameIpcHandle.a().a("task_get_qgame_session_msg");
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
    this.jdField_a_of_type_Boolean = false;
    setVisibility(8);
    requestLayout();
    paramMessage = this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView$UiRefresh;
    if (paramMessage != null) {
      paramMessage.b();
    }
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    int i = 0;
    if ((localObject1 != null) && (((List)localObject1).size() != 0) && ((this.jdField_a_of_type_Int != 2) || (this.jdField_a_of_type_Boolean)))
    {
      super.onMeasure(paramInt1, paramInt2);
      if (!this.c)
      {
        if (this.jdField_a_of_type_JavaUtilList.get(0) != null)
        {
          localObject2 = (GameCenterSessionInfo)this.jdField_a_of_type_JavaUtilList.get(0);
          localObject1 = ((GameCenterSessionInfo)localObject2).e();
          if (((GameCenterSessionInfo)localObject2).a() == 0)
          {
            if (d)
            {
              paramInt1 = 0;
              paramInt2 = i;
              break label139;
            }
          }
          else
          {
            paramInt1 = ((GameCenterSessionInfo)localObject2).c();
            if (paramInt1 > 0)
            {
              paramInt2 = i;
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
        ((StringBuilder)localObject4).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject4).append("");
        localObject4 = ((StringBuilder)localObject4).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("");
        ((IGameMsgHelperApi)localObject2).reportForGameMsg((String)localObject1, "1", "145", "920", "92001", "206341", (String)localObject3, "0", (String)localObject4, "8", "", "", localStringBuilder.toString());
        this.c = true;
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
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      setVisibility(8);
      paramList = this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView$UiRefresh;
      if (paramList != null) {
        paramList.b();
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[setData] dataList size:");
      localStringBuilder.append(paramList.size());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      paramList = this.jdField_a_of_type_JavaUtilList.iterator();
      int i = 0;
      for (;;)
      {
        j = i;
        if (!paramList.hasNext()) {
          break;
        }
        localObject = (GameCenterSessionInfo)paramList.next();
        if (((GameCenterSessionInfo)localObject).a() == 0)
        {
          j = i + 1;
          i = j;
          if (QLog.isColorLevel())
          {
            localObject = jdField_a_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[folder], cnt:");
            localStringBuilder.append(j);
            QLog.d((String)localObject, 2, localStringBuilder.toString());
            i = j;
          }
        }
        else
        {
          j = i + ((GameCenterSessionInfo)localObject).c();
          i = j;
          if (QLog.isColorLevel())
          {
            localObject = jdField_a_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[normal], cnt:");
            localStringBuilder.append(j);
            QLog.d((String)localObject, 2, localStringBuilder.toString());
            i = j;
          }
        }
      }
    }
    int j = 0;
    paramList = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView$SessionStyle;
    if (paramList != null)
    {
      paramList.a();
      removeAllViews();
    }
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView$SessionStyle = a(j);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView$SessionStyle.a(this);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView$SessionStyle.a(this.jdField_a_of_type_JavaUtilList, j);
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView$SessionStyle instanceof GameSessionView.SessionStyleB4Hippy;
    setVisibility(0);
    boolean bool2 = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getGameSessionShown(this.jdField_a_of_type_MqqAppAppRuntime.getAccount());
    if (j > 0)
    {
      paramList = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[setData] unread:");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(", gameSessionShown:");
      ((StringBuilder)localObject).append(bool2);
      QLog.i(paramList, 1, ((StringBuilder)localObject).toString());
      if (!bool2)
      {
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).setGameSessionShown(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), true);
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", "145", "920", "92001", "207622", "", "", "", "");
      }
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).setLastGameSessionClicked(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), System.currentTimeMillis());
    }
    else
    {
      long l1 = System.currentTimeMillis();
      long l2 = QQGameConfBean.a().g * 3600 * 1000;
      long l3 = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getLastGameSessionClicked(this.jdField_a_of_type_MqqAppAppRuntime.getAccount());
      if (l3 == 0L)
      {
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).setLastGameSessionClicked(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), l1);
        paramList = jdField_a_of_type_JavaLangString;
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
      paramList = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[setData] unread:");
      ((StringBuilder)localObject).append(j);
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
          paramList = this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView$UiRefresh;
          if (paramList != null) {
            paramList.a(1000L);
          }
          ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).setGameSessionShown(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), false);
          ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", "145", "920", "92001", "207621", "", "", "", "");
          QLog.i(jdField_a_of_type_JavaLangString, 1, "[setData] setGameSessionShown false");
        }
        else
        {
          setVisibility(8);
          paramList = this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView$UiRefresh;
          if (paramList != null) {
            paramList.a(1000L);
          }
        }
      }
      else {
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).setLastGameSessionClicked(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), l1);
      }
    }
    paramList = this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView$UiRefresh;
    if (paramList != null) {
      paramList.b();
    }
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.GameSessionView
 * JD-Core Version:    0.7.0.1
 */