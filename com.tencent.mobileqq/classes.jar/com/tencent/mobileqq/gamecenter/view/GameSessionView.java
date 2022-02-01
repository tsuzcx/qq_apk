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
import areo;
import avds;
import avdu;
import avez;
import avfa;
import avfb;
import avfc;
import avfd;
import avff;
import avgs;
import avgv;
import avgy;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class GameSessionView
  extends RelativeLayout
  implements Handler.Callback, avgv
{
  public static final String a;
  private static boolean d;
  private int jdField_a_of_type_Int = 1;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private avfc jdField_a_of_type_Avfc;
  private avff jdField_a_of_type_Avff;
  private avgy jdField_a_of_type_Avgy;
  private List<GameCenterSessionInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
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
  
  private avff a(int paramInt)
  {
    int i = areo.a().d;
    switch (i)
    {
    default: 
      return new avfd(this, null);
    }
    if (paramInt > 0)
    {
      if (i == 1) {
        return new GameSessionView.SessionStyleA(this, null);
      }
      return new GameSessionView.SessionStyleB(this, null);
    }
    return new avfb(this, null);
  }
  
  private void a(Context paramContext, GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      return;
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface))
    {
      avdu.a(((avds)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).b(), paramContext, paramGameCenterSessionInfo);
      return;
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof ToolAppRuntime))
    {
      QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "getGameMsgUrl", null, new avfa(this, paramContext, paramGameCenterSessionInfo));
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "[initData] unknown interface:" + this.jdField_a_of_type_MqqAppAppRuntime.getClass().getSimpleName());
  }
  
  private void a(CornerImageView paramCornerImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130840662);
    localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130840662);
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
      avgs.a().a("task_get_qgame_session_msg", true);
      QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "getGameMsg", null, new avez(this));
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[initData] unknown interface:" + this.jdField_a_of_type_MqqAppAppRuntime.getClass().getSimpleName());
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_Avfc = new avfc(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_qgame_messgae_change");
    localIntentFilter.addAction("action_qgame_unread_change");
    paramContext.registerReceiver(this.jdField_a_of_type_Avfc, localIntentFilter);
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
  
  public void a(AppRuntime paramAppRuntime)
  {
    a(paramAppRuntime, null);
  }
  
  public void a(AppRuntime paramAppRuntime, avgy paramavgy)
  {
    if (paramAppRuntime == null) {}
    do
    {
      return;
      this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
      this.jdField_a_of_type_Avgy = paramavgy;
      this.b = false;
      avgs.a().a("task_get_qgame_session_msg", this);
    } while (this.jdField_a_of_type_MqqAppAppRuntime == null);
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface))
    {
      ThreadManager.getSubThreadHandler().post(new GameSessionView.1(this));
      return;
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof ToolAppRuntime))
    {
      avgs.a().a("task_get_qgame_session_msg", true);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[initData] unknown interface:" + this.jdField_a_of_type_MqqAppAppRuntime.getClass().getSimpleName());
  }
  
  public void b()
  {
    if (getContext() != null) {
      getContext().unregisterReceiver(this.jdField_a_of_type_Avfc);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    avgs.a().a("task_get_qgame_session_msg");
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
    } while (this.jdField_a_of_type_Avgy == null);
    this.jdField_a_of_type_Avgy.b();
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
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
          break label230;
        }
        paramInt2 = 0;
        paramInt1 = 0;
      }
    }
    for (;;)
    {
      avdu.a(str, "1", "145", "920", "92001", "206341", paramInt1 + "", "0", this.jdField_a_of_type_Int + "", "8", "", "", paramInt2 + "");
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
        label230:
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
      if (this.jdField_a_of_type_Avgy != null) {
        this.jdField_a_of_type_Avgy.b();
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
      if (this.jdField_a_of_type_Avff != null)
      {
        this.jdField_a_of_type_Avff.a();
        removeAllViews();
      }
      this.jdField_a_of_type_Avff = a(j);
      this.jdField_a_of_type_Avff.a(this);
      this.jdField_a_of_type_Avff.a(this.jdField_a_of_type_JavaUtilList, j);
      setVisibility(0);
      boolean bool2 = avdu.a(this.jdField_a_of_type_MqqAppAppRuntime.getAccount());
      if (j > 0)
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[setData] unread:" + j + ", gameSessionShown:" + bool2);
        if (!bool2)
        {
          avdu.a(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), true);
          avdu.a("", "1", "145", "920", "92001", "207622", "", "", "", "");
        }
        avdu.b(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), System.currentTimeMillis());
      }
      while (this.jdField_a_of_type_Avgy != null)
      {
        this.jdField_a_of_type_Avgy.b();
        return;
        long l1 = System.currentTimeMillis();
        long l2 = areo.a().e * 3600 * 1000;
        long l3 = avdu.a(this.jdField_a_of_type_MqqAppAppRuntime.getAccount());
        if (l3 == 0L)
        {
          avdu.b(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), l1);
          QLog.i(jdField_a_of_type_JavaLangString, 1, "[setData] init LastGameSessionClicked:" + l1);
        }
        if ((l3 != 0L) && (l1 - l3 >= l2)) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          QLog.i(jdField_a_of_type_JavaLangString, 1, "[setData] unread:" + j + ", expired:" + bool1 + ", duration:" + l2 + ", lastGameSessionClicked:" + l3 + ", gameSessionShown:" + bool2);
          if (!bool1) {
            break label703;
          }
          if (!bool2) {
            break label694;
          }
          if (this.jdField_a_of_type_Avgy != null) {
            this.jdField_a_of_type_Avgy.a(1000L);
          }
          avdu.a(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), false);
          avdu.a("", "1", "145", "920", "92001", "207621", "", "", "", "");
          QLog.i(jdField_a_of_type_JavaLangString, 1, "[setData] setGameSessionShown false");
          break;
        }
        label694:
        setVisibility(8);
        continue;
        label703:
        avdu.b(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), l1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameSessionView
 * JD-Core Version:    0.7.0.1
 */