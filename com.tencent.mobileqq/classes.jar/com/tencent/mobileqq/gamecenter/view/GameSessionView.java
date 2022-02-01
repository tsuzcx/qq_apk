package com.tencent.mobileqq.gamecenter.view;

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
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.QQGameConfBean;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.gamecenter.util.QQGameConfigUtil;
import com.tencent.mobileqq.gamecenter.web.QQGameIpcHandle;
import com.tencent.mobileqq.gamecenter.web.QQGameIpcHandle.QGameIpcCallBack;
import com.tencent.mobileqq.gamecenter.web.view.GameContentView.UiRefresh;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
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
  private GameSessionView.GameMessageReceiver jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView$GameMessageReceiver;
  private GameSessionView.SessionStyle jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView$SessionStyle;
  private GameContentView.UiRefresh jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$UiRefresh;
  private List<GameCenterSessionInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = GameSessionView.class.getSimpleName();
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
    paramInt = QQGameConfigUtil.c();
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[createSessionStyle], hippySwitch:" + paramInt);
    if (1 == paramInt) {
      return new GameSessionView.SessionStyleB4Hippy(this, null);
    }
    return new GameSessionView.SessionStyleB(this, null);
  }
  
  private void a(Context paramContext, GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      return;
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface))
    {
      GameMsgUtil.a(paramContext, paramGameCenterSessionInfo, "92001");
      return;
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof ToolAppRuntime))
    {
      QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "getGameMsgUrl", null, new GameSessionView.4(this, paramContext, paramGameCenterSessionInfo));
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "[initData] unknown interface:" + this.jdField_a_of_type_MqqAppAppRuntime.getClass().getSimpleName());
  }
  
  private void a(CornerImageView paramCornerImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130840792);
    localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130840792);
    try
    {
      paramCornerImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
      return;
    }
    catch (Exception paramCornerImageView)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[setAvatar] " + paramCornerImageView);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      return;
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface))
    {
      ThreadManager.getSubThreadHandler().post(new GameSessionView.2(this));
      return;
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof ToolAppRuntime))
    {
      QQGameIpcHandle.a().a("task_get_qgame_session_msg", true);
      QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "getGameMsg", null, new GameSessionView.3(this));
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[initData] unknown interface:" + this.jdField_a_of_type_MqqAppAppRuntime.getClass().getSimpleName());
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView$GameMessageReceiver = new GameSessionView.GameMessageReceiver(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_qgame_messgae_change");
    localIntentFilter.addAction("action_qgame_unread_change");
    paramContext.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView$GameMessageReceiver, localIntentFilter);
  }
  
  public void a(String paramString, EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      paramString = paramEIPCResult.data;
      if (paramString != null)
      {
        paramEIPCResult = (List)paramString.getSerializable("key_get_game_msg");
        if (this.b) {
          break label90;
        }
        if (paramString.getBoolean("key_get_game_gray_user", false)) {
          break label62;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 0, "[setData] gray is not open. return.");
        }
      }
    }
    return;
    label62:
    this.jdField_a_of_type_Boolean = paramString.getBoolean("key_get_game_show_on_list", false);
    d = paramString.getBoolean("key_get_game_show_req_msg_unread", false);
    this.b = true;
    label90:
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[onCallback] list:" + paramEIPCResult.size() + ",type:" + this.jdField_a_of_type_Int);
    setData(paramEIPCResult);
  }
  
  public void a(AppRuntime paramAppRuntime, GameContentView.UiRefresh paramUiRefresh)
  {
    if (paramAppRuntime == null) {}
    do
    {
      return;
      this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$UiRefresh = paramUiRefresh;
      this.b = false;
      QQGameIpcHandle.a().a("task_get_qgame_session_msg", this);
    } while (this.jdField_a_of_type_MqqAppAppRuntime == null);
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface))
    {
      ThreadManager.getSubThreadHandler().post(new GameSessionView.1(this));
      return;
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof ToolAppRuntime))
    {
      QQGameIpcHandle.a().a("task_get_qgame_session_msg", true);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[initData] unknown interface:" + this.jdField_a_of_type_MqqAppAppRuntime.getClass().getSimpleName());
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$UiRefresh != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$UiRefresh.refreshGameContentView();
    }
  }
  
  public void c()
  {
    if (getContext() != null) {
      getContext().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView$GameMessageReceiver);
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
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      this.jdField_a_of_type_Boolean = false;
      setVisibility(8);
      requestLayout();
    } while (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$UiRefresh == null);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$UiRefresh.refreshGameContentView();
    return false;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0) || ((this.jdField_a_of_type_Int == 2) && (!this.jdField_a_of_type_Boolean))) {
      setMeasuredDimension(0, 0);
    }
    do
    {
      return;
      super.onMeasure(paramInt1, paramInt2);
    } while (this.c);
    String str = "";
    GameCenterSessionInfo localGameCenterSessionInfo;
    if (this.jdField_a_of_type_JavaUtilList.get(0) != null)
    {
      localGameCenterSessionInfo = (GameCenterSessionInfo)this.jdField_a_of_type_JavaUtilList.get(0);
      str = localGameCenterSessionInfo.e();
      if (localGameCenterSessionInfo.a() == 0)
      {
        if (!d) {
          break label229;
        }
        paramInt2 = 0;
        paramInt1 = 0;
      }
    }
    for (;;)
    {
      GameMsgUtil.a(str, "1", "145", "920", "92001", "206341", paramInt1 + "", "0", this.jdField_a_of_type_Int + "", "8", "", "", paramInt2 + "");
      this.c = true;
      return;
      paramInt2 = localGameCenterSessionInfo.c();
      if (paramInt2 > 0)
      {
        paramInt1 = 0;
      }
      else
      {
        paramInt1 = 1;
        continue;
        label229:
        paramInt2 = 0;
        paramInt1 = 1;
        continue;
        paramInt2 = 0;
        paramInt1 = 1;
      }
    }
  }
  
  public void setData(List<GameCenterSessionInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$UiRefresh != null) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$UiRefresh.refreshGameContentView();
      }
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilList = paramList;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 0, "[setData] dataList size:" + paramList.size());
      }
      int j;
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        paramList = this.jdField_a_of_type_JavaUtilList.iterator();
        int i = 0;
        j = i;
        if (paramList.hasNext())
        {
          GameCenterSessionInfo localGameCenterSessionInfo = (GameCenterSessionInfo)paramList.next();
          if (localGameCenterSessionInfo.a() == 0)
          {
            j = i + 1;
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d(jdField_a_of_type_JavaLangString, 0, "[folder], cnt:" + j);
              i = j;
            }
          }
          for (;;)
          {
            break;
            j = localGameCenterSessionInfo.c() + i;
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d(jdField_a_of_type_JavaLangString, 0, "[normal], cnt:" + j);
              i = j;
            }
          }
        }
      }
      else
      {
        j = 0;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView$SessionStyle != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView$SessionStyle.a();
        removeAllViews();
      }
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView$SessionStyle = a(j);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView$SessionStyle.a(this);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView$SessionStyle.a(this.jdField_a_of_type_JavaUtilList, j);
      paramList = "";
      if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView$SessionStyle instanceof GameSessionView.SessionStyleB4Hippy)) {
        paramList = "3";
      }
      setVisibility(0);
      boolean bool2 = GameMsgUtil.a(this.jdField_a_of_type_MqqAppAppRuntime.getAccount());
      if (j > 0)
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[setData] unread:" + j + ", gameSessionShown:" + bool2);
        if (!bool2)
        {
          GameMsgUtil.a(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), true);
          GameMsgUtil.a("", "1", "145", "920", "92001", "207622", "", "", "", "", "", "", "", paramList);
        }
        GameMsgUtil.b(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), System.currentTimeMillis());
      }
      while (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$UiRefresh != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$UiRefresh.refreshGameContentView();
        return;
        long l1 = System.currentTimeMillis();
        long l2 = QQGameConfBean.a().f * 3600 * 1000;
        long l3 = GameMsgUtil.a(this.jdField_a_of_type_MqqAppAppRuntime.getAccount());
        if (l3 == 0L)
        {
          GameMsgUtil.b(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), l1);
          QLog.i(jdField_a_of_type_JavaLangString, 1, "[setData] init LastGameSessionClicked:" + l1);
        }
        if ((l3 != 0L) && (l1 - l3 >= l2)) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          QLog.i(jdField_a_of_type_JavaLangString, 1, "[setData] unread:" + j + ", expired:" + bool1 + ", duration:" + l2 + ", lastGameSessionClicked:" + l3 + ", gameSessionShown:" + bool2);
          if (!bool1) {
            break label739;
          }
          if (!bool2) {
            break label730;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$UiRefresh != null) {
            this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$UiRefresh.shrinkGameContentView(1000L);
          }
          GameMsgUtil.a(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), false);
          GameMsgUtil.a("", "1", "145", "920", "92001", "207621", "", "", "", "", "", "", "", paramList);
          QLog.i(jdField_a_of_type_JavaLangString, 1, "[setData] setGameSessionShown false");
          break;
        }
        label730:
        setVisibility(8);
        continue;
        label739:
        GameMsgUtil.b(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), l1);
      }
    }
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameSessionView
 * JD-Core Version:    0.7.0.1
 */