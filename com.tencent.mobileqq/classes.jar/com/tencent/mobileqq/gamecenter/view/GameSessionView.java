package com.tencent.mobileqq.gamecenter.view;

import afur;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import autd;
import autf;
import auud;
import auuk;
import auul;
import auum;
import auun;
import auuo;
import auup;
import auvy;
import auwb;
import auwe;
import bmxq;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class GameSessionView
  extends RelativeLayout
  implements Handler.Callback, View.OnClickListener, auwb
{
  public static final String a;
  private static boolean e;
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private View jdField_a_of_type_AndroidViewView;
  private ScaleAnimation jdField_a_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.75F, 1, 0.0F);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private auum jdField_a_of_type_Auum;
  private auwe jdField_a_of_type_Auwe;
  private List<GameCenterSessionInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
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
  
  private void a(Context paramContext, GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      return;
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface))
    {
      autf.a(((autd)this.jdField_a_of_type_MqqAppAppRuntime.getManager(358)).b(), paramContext, paramGameCenterSessionInfo);
      return;
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof ToolAppRuntime))
    {
      QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "getGameMsgUrl", null, new auul(this, paramContext, paramGameCenterSessionInfo));
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "[initData] unknown interface:" + this.jdField_a_of_type_MqqAppAppRuntime.getClass().getSimpleName());
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
      auvy.a().a("task_get_qgame_session_msg", true);
      QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "getGameMsg", null, new auuk(this));
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[initData] unknown interface:" + this.jdField_a_of_type_MqqAppAppRuntime.getClass().getSimpleName());
  }
  
  public void a(Context paramContext)
  {
    Object localObject = LayoutInflater.from(paramContext);
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130840168);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("查看全部游戏消息");
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(10.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#80333333"));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131371281);
    FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-1, afur.a(17.0F, getResources()));
    localLayoutParams1.rightMargin = afur.a(25.0F, getResources());
    localLayoutParams1.leftMargin = afur.a(25.0F, getResources());
    localLayoutParams1.topMargin = afur.a(60.0F, getResources());
    localFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams1);
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)localObject).inflate(2131559203, null);
    this.jdField_a_of_type_AndroidViewView.setTag(new auuo(this.jdField_a_of_type_AndroidViewView));
    this.jdField_a_of_type_AndroidViewView.setId(2131367299);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(auud.a(getContext()));
    localLayoutParams1 = new FrameLayout.LayoutParams(-1, afur.a(64.0F, getResources()));
    localLayoutParams1.leftMargin = afur.a(15.0F, getResources());
    localLayoutParams1.rightMargin = afur.a(15.0F, getResources());
    localFrameLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams1);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    addView(localFrameLayout, localLayoutParams);
    this.jdField_b_of_type_AndroidViewView = ((LayoutInflater)localObject).inflate(2131559204, null);
    this.jdField_b_of_type_AndroidViewView.setId(2131367300);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setTag(new auup(this.jdField_b_of_type_AndroidViewView));
    localObject = new RelativeLayout.LayoutParams(afur.a(172.0F, getResources()), afur.a(64.0F, getResources()));
    ((RelativeLayout.LayoutParams)localObject).rightMargin = afur.a(33.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = afur.a(4.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    addView(this.jdField_b_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_Auum = new auum(this, null);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("action_qgame_messgae_change");
    ((IntentFilter)localObject).addAction("action_qgame_unread_change");
    paramContext.registerReceiver(this.jdField_a_of_type_Auum, (IntentFilter)localObject);
  }
  
  public void a(View paramView, GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    if ((paramView.getTag() instanceof auun)) {
      ((auun)paramView.getTag()).a(paramGameCenterSessionInfo);
    }
  }
  
  public void a(String paramString, EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      paramString = paramEIPCResult.data;
      if (paramString != null)
      {
        paramEIPCResult = (List)paramString.getSerializable("key_get_game_msg");
        if (this.jdField_b_of_type_Boolean) {
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
    e = paramString.getBoolean("key_get_game_show_req_msg_unread", false);
    this.jdField_b_of_type_Boolean = true;
    label90:
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[onCallback] list:" + paramEIPCResult.size() + ",type:" + this.jdField_a_of_type_Int);
    setData(paramEIPCResult);
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    a(paramAppRuntime, null);
  }
  
  public void a(AppRuntime paramAppRuntime, auwe paramauwe)
  {
    if (paramAppRuntime == null) {}
    do
    {
      return;
      this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
      this.jdField_a_of_type_Auwe = paramauwe;
      this.jdField_b_of_type_Boolean = false;
      auvy.a().a("task_get_qgame_session_msg", this);
    } while (this.jdField_a_of_type_MqqAppAppRuntime == null);
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface))
    {
      ThreadManager.getSubThreadHandler().post(new GameSessionView.1(this));
      return;
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof ToolAppRuntime))
    {
      auvy.a().a("task_get_qgame_session_msg", true);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[initData] unknown interface:" + this.jdField_a_of_type_MqqAppAppRuntime.getClass().getSimpleName());
  }
  
  public void b()
  {
    if (getContext() != null) {
      getContext().unregisterReceiver(this.jdField_a_of_type_Auum);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
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
    } while (this.jdField_a_of_type_Auwe == null);
    this.jdField_a_of_type_Auwe.c();
    return false;
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 2000L) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[onClick] click too frequently.");
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        this.jdField_a_of_type_Long = l;
        e = false;
        switch (paramView.getId())
        {
        }
      }
    } while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0));
    GameCenterSessionInfo localGameCenterSessionInfo = (GameCenterSessionInfo)this.jdField_a_of_type_JavaUtilList.get(0);
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (this.jdField_a_of_type_JavaUtilList.size() > 2) {
      i = 3;
    }
    for (;;)
    {
      a(getContext(), localGameCenterSessionInfo);
      bmxq.a().a(localGameCenterSessionInfo.e(), "1", "145", "920", "92001", "206342", localGameCenterSessionInfo.a() + "", this.jdField_a_of_type_Int + "", "20", "" + i);
      a(paramView, localGameCenterSessionInfo);
      break;
      a(getContext(), null);
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break;
      }
      localGameCenterSessionInfo = (GameCenterSessionInfo)this.jdField_a_of_type_JavaUtilList.get(0);
      i = this.jdField_a_of_type_JavaUtilList.size();
      if (this.jdField_a_of_type_JavaUtilList.size() > 2) {
        i = 3;
      }
      for (;;)
      {
        bmxq.a().a("", "1", "145", "920", "92001", "206342", localGameCenterSessionInfo.a() + "", this.jdField_a_of_type_Int + "", "20", "" + i);
        break;
      }
    }
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
    if (this.jdField_a_of_type_JavaUtilList.get(0) != null) {
      str = ((GameCenterSessionInfo)this.jdField_a_of_type_JavaUtilList.get(0)).e();
    }
    bmxq.a().a(str, "1", "145", "920", "92001", "206341", "0", this.jdField_a_of_type_Int + "", "8", "");
    this.c = true;
  }
  
  public void setData(List<GameCenterSessionInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      setVisibility(8);
      requestLayout();
      if (this.jdField_a_of_type_Auwe != null) {
        this.jdField_a_of_type_Auwe.c();
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 0, "[setData] dataList size:" + paramList.size());
    }
    int i;
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      paramList = this.jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
      if (paramList.hasNext())
      {
        localObject = (GameCenterSessionInfo)paramList.next();
        if (((GameCenterSessionInfo)localObject).a() == 0) {}
        for (i = ((GameCenterSessionInfo)localObject).b() + i;; i = ((GameCenterSessionInfo)localObject).c() + i) {
          break;
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        a(this.jdField_a_of_type_AndroidViewView, (GameCenterSessionInfo)this.jdField_a_of_type_JavaUtilList.get(0));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        if (i > 0)
        {
          paramList = "共" + i + "条好友消息";
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramList);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          setVisibility(0);
          requestLayout();
          if (this.jdField_a_of_type_Auwe == null) {
            break;
          }
          this.jdField_a_of_type_Auwe.c();
          return;
          this.jdField_a_of_type_AndroidWidgetTextView.setText("查看全部游戏消息");
        }
      }
      if ((this.jdField_a_of_type_Auwe != null) && ((this.jdField_a_of_type_Auwe instanceof QQGameFeedWebFragment)))
      {
        paramList = "";
        if (this.jdField_a_of_type_JavaUtilList.get(0) == null) {
          break label587;
        }
        paramList = ((GameCenterSessionInfo)this.jdField_a_of_type_JavaUtilList.get(0)).e();
      }
      label575:
      label587:
      for (int j = ((GameCenterSessionInfo)this.jdField_a_of_type_JavaUtilList.get(0)).a();; j = -1)
      {
        ((QQGameFeedWebFragment)this.jdField_a_of_type_Auwe).a(i, j);
        if (!this.d)
        {
          localObject = bmxq.a();
          String str1 = j + "";
          String str2 = this.jdField_a_of_type_Int + "";
          StringBuilder localStringBuilder = new StringBuilder().append("");
          if (i > 0)
          {
            i = 1;
            label459:
            ((bmxq)localObject).a(paramList, "1", "145", "920", "92001", "206829", str1, str2, "8", i);
            this.d = true;
          }
        }
        else
        {
          if (!this.jdField_a_of_type_Boolean) {
            break label575;
          }
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          a(this.jdField_b_of_type_AndroidViewView, (GameCenterSessionInfo)this.jdField_a_of_type_JavaUtilList.get(0));
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 5000L);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break;
          i = 0;
          break label459;
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameSessionView
 * JD-Core Version:    0.7.0.1
 */