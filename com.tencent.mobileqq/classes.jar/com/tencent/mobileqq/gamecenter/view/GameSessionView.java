package com.tencent.mobileqq.gamecenter.view;

import agej;
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
import avld;
import avlf;
import avmd;
import avmk;
import avml;
import avmm;
import avmn;
import avmo;
import avmp;
import avny;
import avob;
import avoe;
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
  implements Handler.Callback, View.OnClickListener, avob
{
  public static final String a;
  private static boolean e;
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private View jdField_a_of_type_AndroidViewView;
  private ScaleAnimation jdField_a_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.75F, 1, 0.0F);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private avmm jdField_a_of_type_Avmm;
  private avoe jdField_a_of_type_Avoe;
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
      avlf.a(((avld)this.jdField_a_of_type_MqqAppAppRuntime.getManager(358)).b(), paramContext, paramGameCenterSessionInfo);
      return;
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof ToolAppRuntime))
    {
      QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "getGameMsgUrl", null, new avml(this, paramContext, paramGameCenterSessionInfo));
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
      avny.a().a("task_get_qgame_session_msg", true);
      QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "getGameMsg", null, new avmk(this));
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
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130840177);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("查看全部游戏消息");
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(10.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#80333333"));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131371388);
    FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-1, agej.a(17.0F, getResources()));
    localLayoutParams1.rightMargin = agej.a(25.0F, getResources());
    localLayoutParams1.leftMargin = agej.a(25.0F, getResources());
    localLayoutParams1.topMargin = agej.a(60.0F, getResources());
    localFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams1);
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)localObject).inflate(2131559202, null);
    this.jdField_a_of_type_AndroidViewView.setTag(new avmo(this.jdField_a_of_type_AndroidViewView));
    this.jdField_a_of_type_AndroidViewView.setId(2131367355);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(avmd.a(getContext()));
    localLayoutParams1 = new FrameLayout.LayoutParams(-1, agej.a(64.0F, getResources()));
    localLayoutParams1.leftMargin = agej.a(15.0F, getResources());
    localLayoutParams1.rightMargin = agej.a(15.0F, getResources());
    localFrameLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams1);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    addView(localFrameLayout, localLayoutParams);
    this.jdField_b_of_type_AndroidViewView = ((LayoutInflater)localObject).inflate(2131559203, null);
    this.jdField_b_of_type_AndroidViewView.setId(2131367356);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setTag(new avmp(this.jdField_b_of_type_AndroidViewView));
    localObject = new RelativeLayout.LayoutParams(agej.a(172.0F, getResources()), agej.a(64.0F, getResources()));
    ((RelativeLayout.LayoutParams)localObject).rightMargin = agej.a(33.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = agej.a(4.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    addView(this.jdField_b_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_Avmm = new avmm(this, null);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("action_qgame_messgae_change");
    ((IntentFilter)localObject).addAction("action_qgame_unread_change");
    paramContext.registerReceiver(this.jdField_a_of_type_Avmm, (IntentFilter)localObject);
  }
  
  public void a(View paramView, GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    if ((paramView.getTag() instanceof avmn)) {
      ((avmn)paramView.getTag()).a(paramGameCenterSessionInfo);
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
  
  public void a(AppRuntime paramAppRuntime, avoe paramavoe)
  {
    if (paramAppRuntime == null) {}
    do
    {
      return;
      this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
      this.jdField_a_of_type_Avoe = paramavoe;
      this.jdField_b_of_type_Boolean = false;
      avny.a().a("task_get_qgame_session_msg", this);
    } while (this.jdField_a_of_type_MqqAppAppRuntime == null);
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface))
    {
      ThreadManager.getSubThreadHandler().post(new GameSessionView.1(this));
      return;
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof ToolAppRuntime))
    {
      avny.a().a("task_get_qgame_session_msg", true);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[initData] unknown interface:" + this.jdField_a_of_type_MqqAppAppRuntime.getClass().getSimpleName());
  }
  
  public void b()
  {
    if (getContext() != null) {
      getContext().unregisterReceiver(this.jdField_a_of_type_Avmm);
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
    } while (this.jdField_a_of_type_Avoe == null);
    this.jdField_a_of_type_Avoe.c();
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
    int k = this.jdField_a_of_type_JavaUtilList.size();
    if (this.jdField_a_of_type_JavaUtilList.size() > 2) {
      k = 3;
    }
    for (;;)
    {
      int j;
      int i;
      if (localGameCenterSessionInfo.a() == 0)
      {
        if (!e) {
          break label508;
        }
        j = 0;
        i = 0;
      }
      for (;;)
      {
        a(getContext(), localGameCenterSessionInfo);
        avlf.a(localGameCenterSessionInfo.e(), "1", "145", "920", "92001", "206342", i + "", localGameCenterSessionInfo.a() + "", this.jdField_a_of_type_Int + "", "20", "" + k, "", j + "");
        a(paramView, localGameCenterSessionInfo);
        break;
        j = localGameCenterSessionInfo.c();
        if (j > 0)
        {
          i = 0;
          continue;
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
            avlf.a("", "1", "145", "920", "92001", "206342", localGameCenterSessionInfo.a() + "", this.jdField_a_of_type_Int + "", "20", "" + i);
            break;
          }
        }
        i = 1;
        continue;
        label508:
        j = 0;
        i = 1;
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
    GameCenterSessionInfo localGameCenterSessionInfo;
    if (this.jdField_a_of_type_JavaUtilList.get(0) != null)
    {
      localGameCenterSessionInfo = (GameCenterSessionInfo)this.jdField_a_of_type_JavaUtilList.get(0);
      str = localGameCenterSessionInfo.e();
      if (localGameCenterSessionInfo.a() == 0)
      {
        if (!e) {
          break label230;
        }
        paramInt2 = 0;
        paramInt1 = 0;
      }
    }
    for (;;)
    {
      avlf.a(str, "1", "145", "920", "92001", "206341", paramInt1 + "", "0", this.jdField_a_of_type_Int + "", "8", "", "", paramInt2 + "");
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
      requestLayout();
      if (this.jdField_a_of_type_Avoe != null) {
        this.jdField_a_of_type_Avoe.c();
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
          if (this.jdField_a_of_type_Avoe == null) {
            break;
          }
          this.jdField_a_of_type_Avoe.c();
          return;
          this.jdField_a_of_type_AndroidWidgetTextView.setText("查看全部游戏消息");
        }
      }
      int j;
      if ((this.jdField_a_of_type_Avoe != null) && ((this.jdField_a_of_type_Avoe instanceof QQGameFeedWebFragment)))
      {
        if (this.jdField_a_of_type_JavaUtilList.get(0) == null) {
          break label576;
        }
        paramList = ((GameCenterSessionInfo)this.jdField_a_of_type_JavaUtilList.get(0)).e();
        j = ((GameCenterSessionInfo)this.jdField_a_of_type_JavaUtilList.get(0)).a();
      }
      for (;;)
      {
        ((QQGameFeedWebFragment)this.jdField_a_of_type_Avoe).a(i, j);
        if (!this.d)
        {
          localObject = j + "";
          String str = this.jdField_a_of_type_Int + "";
          StringBuilder localStringBuilder = new StringBuilder().append("");
          if (i > 0)
          {
            i = 1;
            label450:
            avlf.a(paramList, "1", "145", "920", "92001", "206829", (String)localObject, str, "8", i);
            this.d = true;
          }
        }
        else
        {
          if (!this.jdField_a_of_type_Boolean) {
            break label564;
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
          break label450;
          label564:
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        label576:
        j = -1;
        paramList = "";
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameSessionView
 * JD-Core Version:    0.7.0.1
 */