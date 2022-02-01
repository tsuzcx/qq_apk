package com.tencent.mobileqq.gamecenter.view;

import android.content.res.Resources;
import android.view.View;
import android.widget.ViewSwitcher;
import android.widget.ViewSwitcher.ViewFactory;
import avdu;
import avff;
import avfg;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo.SimpleMessage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mqq.app.AppRuntime;

abstract class GameSessionView$ViewSwitcherSession<T extends View>
  implements ViewSwitcher.ViewFactory, avff, Runnable, Comparator<avfg>
{
  private int jdField_a_of_type_Int = -1;
  private final long jdField_a_of_type_Long = 1500L;
  private ViewSwitcher jdField_a_of_type_AndroidWidgetViewSwitcher;
  protected String a;
  private List<avfg> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  GameSessionView$ViewSwitcherSession(GameSessionView paramGameSessionView)
  {
    this.jdField_a_of_type_JavaLangString = paramGameSessionView.getResources().getString(2131694981);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size()) {
      this.jdField_a_of_type_Int = 0;
    }
    a(this.jdField_a_of_type_AndroidWidgetViewSwitcher.getNextView(), (avfg)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetViewSwitcher.showNext();
    if (paramBoolean) {
      this.this$0.postDelayed(this, 1500L);
    }
  }
  
  public int a(avfg paramavfg1, avfg paramavfg2)
  {
    if (paramavfg1.a.jdField_a_of_type_Long > paramavfg2.a.jdField_a_of_type_Long) {
      return -1;
    }
    if (paramavfg1.a.jdField_a_of_type_Long < paramavfg2.a.jdField_a_of_type_Long) {
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
  
  protected void a(T paramT, avfg paramavfg)
  {
    paramT.setTag(paramavfg.a());
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
    while (paramInt < paramList.size())
    {
      GameCenterSessionInfo localGameCenterSessionInfo = (GameCenterSessionInfo)paramList.get(paramInt);
      List localList = ((GameCenterSessionInfo)paramList.get(paramInt)).a();
      if (localList != null)
      {
        int i = 0;
        while (i < localList.size())
        {
          this.jdField_a_of_type_JavaUtilList.add(new avfg(localGameCenterSessionInfo, (GameCenterSessionInfo.SimpleMessage)localList.get(i)));
          i += 1;
        }
      }
      paramInt += 1;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      paramList = (GameCenterSessionInfo)paramList.get(0);
      this.jdField_a_of_type_JavaUtilList.add(new avfg(paramList, new GameCenterSessionInfo.SimpleMessage(paramList.a(), paramList.i())));
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
    avdu.b(GameSessionView.a(this.this$0).getAccount(), System.currentTimeMillis());
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void run()
  {
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameSessionView.ViewSwitcherSession
 * JD-Core Version:    0.7.0.1
 */