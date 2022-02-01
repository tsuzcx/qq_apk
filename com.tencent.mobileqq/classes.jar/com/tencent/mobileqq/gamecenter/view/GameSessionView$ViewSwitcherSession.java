package com.tencent.mobileqq.gamecenter.view;

import android.content.res.Resources;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ViewSwitcher;
import android.widget.ViewSwitcher.ViewFactory;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo.SimpleMessage;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mqq.app.AppRuntime;

abstract class GameSessionView$ViewSwitcherSession<T extends View>
  implements ViewSwitcher.ViewFactory, GameSessionView.SessionStyle, Runnable, Comparator<GameSessionView.WrappedMessage>
{
  private int jdField_a_of_type_Int = -1;
  private final long jdField_a_of_type_Long = 1500L;
  private ViewSwitcher jdField_a_of_type_AndroidWidgetViewSwitcher;
  protected String a;
  private List<GameSessionView.WrappedMessage> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  GameSessionView$ViewSwitcherSession(GameSessionView paramGameSessionView)
  {
    this.jdField_a_of_type_JavaLangString = paramGameSessionView.getResources().getString(2131695220);
  }
  
  private void a(boolean paramBoolean)
  {
    int k = 0;
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size()) {
      this.jdField_a_of_type_Int = 0;
    }
    a(this.jdField_a_of_type_AndroidWidgetViewSwitcher.getNextView(), (GameSessionView.WrappedMessage)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetViewSwitcher.showNext();
    int i;
    if ("3".equals(QQGameHelper.b())) {
      i = 0;
    }
    for (;;)
    {
      int j = k;
      if (i < this.jdField_a_of_type_AndroidWidgetViewSwitcher.getChildCount())
      {
        if ((this.jdField_a_of_type_AndroidWidgetViewSwitcher.getChildAt(i) != null) && (this.jdField_a_of_type_AndroidWidgetViewSwitcher.getChildAt(i).getHeight() == 0) && (this.jdField_a_of_type_AndroidWidgetViewSwitcher.getChildAt(i).getWidth() == 0)) {
          j = 1;
        }
      }
      else
      {
        if (j != 0)
        {
          QLog.d(GameSessionView.jdField_a_of_type_JavaLangString, 1, "viewSwitcher need posDraw");
          this.jdField_a_of_type_AndroidWidgetViewSwitcher.measure(View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_AndroidWidgetViewSwitcher.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_AndroidWidgetViewSwitcher.getHeight(), 1073741824));
          this.jdField_a_of_type_AndroidWidgetViewSwitcher.layout(this.jdField_a_of_type_AndroidWidgetViewSwitcher.getLeft(), this.jdField_a_of_type_AndroidWidgetViewSwitcher.getTop(), this.jdField_a_of_type_AndroidWidgetViewSwitcher.getRight(), this.jdField_a_of_type_AndroidWidgetViewSwitcher.getBottom());
        }
        if (paramBoolean) {
          this.this$0.postDelayed(this, 1500L);
        }
        return;
      }
      i += 1;
    }
  }
  
  public int a(GameSessionView.WrappedMessage paramWrappedMessage1, GameSessionView.WrappedMessage paramWrappedMessage2)
  {
    if (paramWrappedMessage1.a.jdField_a_of_type_Long > paramWrappedMessage2.a.jdField_a_of_type_Long) {
      return -1;
    }
    if (paramWrappedMessage1.a.jdField_a_of_type_Long < paramWrappedMessage2.a.jdField_a_of_type_Long) {
      return 1;
    }
    return 0;
  }
  
  protected ViewSwitcher a()
  {
    return this.jdField_a_of_type_AndroidWidgetViewSwitcher;
  }
  
  protected GameCenterSessionInfo a()
  {
    return (GameCenterSessionInfo)this.jdField_a_of_type_AndroidWidgetViewSwitcher.getCurrentView().getTag();
  }
  
  public void a()
  {
    this.this$0.removeCallbacks(this);
  }
  
  protected void a(T paramT, GameSessionView.WrappedMessage paramWrappedMessage)
  {
    paramT.setTag(paramWrappedMessage.a());
  }
  
  protected void a(ViewSwitcher paramViewSwitcher)
  {
    this.jdField_a_of_type_AndroidWidgetViewSwitcher = paramViewSwitcher;
    paramViewSwitcher.setAnimateFirstView(false);
  }
  
  public void a(List<GameCenterSessionInfo> paramList, int paramInt)
  {
    boolean bool = false;
    this.jdField_a_of_type_JavaUtilList.clear();
    paramInt = 0;
    GameCenterSessionInfo localGameCenterSessionInfo;
    while (paramInt < paramList.size())
    {
      localGameCenterSessionInfo = (GameCenterSessionInfo)paramList.get(paramInt);
      List localList = ((GameCenterSessionInfo)paramList.get(paramInt)).a();
      if (localList != null)
      {
        int i = 0;
        while (i < localList.size())
        {
          this.jdField_a_of_type_JavaUtilList.add(new GameSessionView.WrappedMessage(localGameCenterSessionInfo, (GameCenterSessionInfo.SimpleMessage)localList.get(i)));
          i += 1;
        }
      }
      paramInt += 1;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      paramInt = 0;
      while (paramInt < paramList.size())
      {
        localGameCenterSessionInfo = (GameCenterSessionInfo)paramList.get(paramInt);
        this.jdField_a_of_type_JavaUtilList.add(new GameSessionView.WrappedMessage(localGameCenterSessionInfo, new GameCenterSessionInfo.SimpleMessage(localGameCenterSessionInfo.a(), localGameCenterSessionInfo.i())));
        paramInt += 1;
      }
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilList, this);
    this.this$0.removeCallbacks(this);
    this.jdField_a_of_type_AndroidWidgetViewSwitcher.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetViewSwitcher.setFactory(this);
    this.jdField_a_of_type_Int = -1;
    if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
      bool = true;
    }
    a(bool);
  }
  
  public void onClick(View paramView)
  {
    GameCenterSessionInfo localGameCenterSessionInfo = a();
    GameSessionView.a(this.this$0, this.this$0.getContext(), localGameCenterSessionInfo);
    GameMsgUtil.b(GameSessionView.a(this.this$0).getAccount(), System.currentTimeMillis());
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void run()
  {
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameSessionView.ViewSwitcherSession
 * JD-Core Version:    0.7.0.1
 */