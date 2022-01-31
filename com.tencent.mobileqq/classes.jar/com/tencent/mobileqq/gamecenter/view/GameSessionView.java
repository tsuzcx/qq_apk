package com.tencent.mobileqq.gamecenter.view;

import aekt;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import asil;
import asin;
import asjc;
import asjh;
import asji;
import asjj;
import asjk;
import bkeu;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class GameSessionView
  extends LinearLayout
  implements Handler.Callback, View.OnClickListener
{
  public static final String a;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private asjj jdField_a_of_type_Asjj;
  private List<GameCenterSessionInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private View b;
  private View c;
  
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
      asin.a(((asil)this.jdField_a_of_type_MqqAppAppRuntime.getManager(358)).a(), paramContext, paramGameCenterSessionInfo);
      return;
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof ToolAppRuntime))
    {
      QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "getGameMsgUrl", null, new asji(this, paramContext, paramGameCenterSessionInfo));
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
      ThreadManager.getSubThreadHandler().post(new GameSessionView.1(this));
      return;
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof ToolAppRuntime))
    {
      QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "getGameMsg", null, new asjh(this));
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[initData] unknown interface:" + this.jdField_a_of_type_MqqAppAppRuntime.getClass().getSimpleName());
  }
  
  public void a(Context paramContext)
  {
    Object localObject = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)localObject).inflate(2131559132, null);
    this.jdField_a_of_type_AndroidViewView.setTag(new asjk(this.jdField_a_of_type_AndroidViewView));
    this.jdField_a_of_type_AndroidViewView.setId(2131367021);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(asjc.a(getContext()));
    this.b = ((LayoutInflater)localObject).inflate(2131559132, null);
    this.b.setTag(new asjk(this.b));
    this.b.setId(2131367022);
    this.b.setBackgroundDrawable(asjc.a(getContext()));
    this.c = ((LayoutInflater)localObject).inflate(2131559133, null);
    this.c.setBackgroundDrawable(asjc.a(getContext()));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.c.findViewById(2131368823));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.c.findViewById(2131378853));
    localObject = new LinearLayout.LayoutParams(0, aekt.a(74.0F, getResources()));
    ((LinearLayout.LayoutParams)localObject).leftMargin = aekt.a(4.0F, getResources());
    ((LinearLayout.LayoutParams)localObject).rightMargin = aekt.a(4.0F, getResources());
    ((LinearLayout.LayoutParams)localObject).weight = 43.0F;
    addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout.LayoutParams(0, aekt.a(74.0F, getResources()));
    ((LinearLayout.LayoutParams)localObject).rightMargin = aekt.a(4.0F, getResources());
    ((LinearLayout.LayoutParams)localObject).weight = 43.0F;
    addView(this.b, (ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout.LayoutParams(0, aekt.a(74.0F, getResources()));
    ((LinearLayout.LayoutParams)localObject).rightMargin = aekt.a(4.0F, getResources());
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    ((LinearLayout.LayoutParams)localObject).weight = 14.0F;
    this.c.setId(2131370706);
    addView(this.c, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_Asjj = new asjj(this, null);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("action_qgame_messgae_change");
    ((IntentFilter)localObject).addAction("action_qgame_unread_change");
    paramContext.registerReceiver(this.jdField_a_of_type_Asjj, (IntentFilter)localObject);
  }
  
  public void a(View paramView, GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    if ((paramView.getTag() instanceof asjk)) {
      ((asjk)paramView.getTag()).a(paramGameCenterSessionInfo);
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return;
    }
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    a();
  }
  
  public void b()
  {
    if (getContext() != null) {
      getContext().unregisterReceiver(this.jdField_a_of_type_Asjj);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
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
      return;
      this.jdField_a_of_type_Long = l;
      switch (paramView.getId())
      {
      default: 
        return;
      }
    } while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0));
    paramView = (GameCenterSessionInfo)this.jdField_a_of_type_JavaUtilList.get(0);
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (this.jdField_a_of_type_JavaUtilList.size() > 2) {
      i = 3;
    }
    for (;;)
    {
      a(getContext(), paramView);
      bkeu.a().a(paramView.d(), "1", "145", "920", "92001", "206342", "0", "0", "20", "" + i);
      return;
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() < 2)) {
        break;
      }
      paramView = (GameCenterSessionInfo)this.jdField_a_of_type_JavaUtilList.get(1);
      i = this.jdField_a_of_type_JavaUtilList.size();
      if (this.jdField_a_of_type_JavaUtilList.size() > 2) {
        i = 3;
      }
      for (;;)
      {
        a(getContext(), paramView);
        bkeu.a().a(paramView.d(), "1", "145", "920", "92001", "206342", "0", "0", "20", "" + i);
        return;
        a(getContext(), null);
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
          break;
        }
        i = this.jdField_a_of_type_JavaUtilList.size();
        if (this.jdField_a_of_type_JavaUtilList.size() > 2) {
          i = 3;
        }
        for (;;)
        {
          bkeu.a().a("", "1", "145", "920", "92001", "206342", "0", "1", "20", "" + i);
          return;
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      setMeasuredDimension(0, 0);
      return;
    }
    setMeasuredDimension(getMeasuredWidth(), aekt.a(74.0F, getResources()));
  }
  
  public void setData(List<GameCenterSessionInfo> paramList)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new GameSessionView.3(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameSessionView
 * JD-Core Version:    0.7.0.1
 */