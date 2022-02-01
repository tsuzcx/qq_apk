package com.tencent.mobileqq.qqgamepub.view;

import android.content.res.Resources;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ViewSwitcher;
import android.widget.ViewSwitcher.ViewFactory;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.data.IDataVisitor;
import com.tencent.mobileqq.gamecenter.msgInfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msgInfo.GameCenterSessionInfo.SimpleMessage;
import com.tencent.mobileqq.gamecenter.msgInfo.GameDelSessionRecord;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
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
    this.jdField_a_of_type_JavaLangString = paramGameSessionView.getResources().getString(2131695214);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return;
      }
      this.jdField_a_of_type_Int += 1;
      int i = this.jdField_a_of_type_Int;
      int j = this.jdField_a_of_type_JavaUtilList.size();
      int k = 0;
      if (i >= j) {
        this.jdField_a_of_type_Int = 0;
      }
      a(this.jdField_a_of_type_AndroidWidgetViewSwitcher.getNextView(), (GameSessionView.WrappedMessage)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetViewSwitcher.showNext();
      if ("3".equals(GamePubAccountHelper.a()))
      {
        i = 0;
        for (;;)
        {
          j = k;
          if (i >= this.jdField_a_of_type_AndroidWidgetViewSwitcher.getChildCount()) {
            break;
          }
          if ((this.jdField_a_of_type_AndroidWidgetViewSwitcher.getChildAt(i) != null) && (this.jdField_a_of_type_AndroidWidgetViewSwitcher.getChildAt(i).getHeight() == 0) && (this.jdField_a_of_type_AndroidWidgetViewSwitcher.getChildAt(i).getWidth() == 0))
          {
            j = 1;
            break;
          }
          i += 1;
        }
        if (j != 0)
        {
          QLog.d(GameSessionView.jdField_a_of_type_JavaLangString, 1, "viewSwitcher need posDraw");
          localObject = this.jdField_a_of_type_AndroidWidgetViewSwitcher;
          ((ViewSwitcher)localObject).measure(View.MeasureSpec.makeMeasureSpec(((ViewSwitcher)localObject).getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_AndroidWidgetViewSwitcher.getHeight(), 1073741824));
          localObject = this.jdField_a_of_type_AndroidWidgetViewSwitcher;
          ((ViewSwitcher)localObject).layout(((ViewSwitcher)localObject).getLeft(), this.jdField_a_of_type_AndroidWidgetViewSwitcher.getTop(), this.jdField_a_of_type_AndroidWidgetViewSwitcher.getRight(), this.jdField_a_of_type_AndroidWidgetViewSwitcher.getBottom());
        }
      }
      if (paramBoolean) {
        this.this$0.postDelayed(this, 1500L);
      }
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
    this.jdField_a_of_type_JavaUtilList.clear();
    boolean bool = false;
    paramInt = 0;
    GameCenterSessionInfo localGameCenterSessionInfo;
    Object localObject;
    int i;
    while (paramInt < paramList.size())
    {
      localGameCenterSessionInfo = (GameCenterSessionInfo)paramList.get(paramInt);
      localObject = ((GameCenterSessionInfo)paramList.get(paramInt)).a();
      if (localObject != null)
      {
        i = 0;
        while (i < ((List)localObject).size())
        {
          this.jdField_a_of_type_JavaUtilList.add(new GameSessionView.WrappedMessage(localGameCenterSessionInfo, (GameCenterSessionInfo.SimpleMessage)((List)localObject).get(i)));
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
        localObject = ((IGameMsgManagerService)GameSessionView.a(this.this$0).getRuntimeService(IGameMsgManagerService.class, "")).getSessionDelDataHelper();
        GameDelSessionRecord localGameDelSessionRecord = new GameDelSessionRecord();
        localGameDelSessionRecord.mUin = localGameCenterSessionInfo.d();
        if ((localObject != null) && (((IDataVisitor)localObject).d(localGameDelSessionRecord))) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0) {
          this.jdField_a_of_type_JavaUtilList.add(new GameSessionView.WrappedMessage(localGameCenterSessionInfo, new GameCenterSessionInfo.SimpleMessage(localGameCenterSessionInfo.a(), localGameCenterSessionInfo.i())));
        }
        paramInt += 1;
      }
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilList, this);
    this.this$0.removeCallbacks(this);
    this.jdField_a_of_type_AndroidWidgetViewSwitcher.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetViewSwitcher.setFactory(this);
    this.jdField_a_of_type_Int = -1;
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
        bool = true;
      }
      a(bool);
    }
  }
  
  public void onClick(View paramView)
  {
    GameCenterSessionInfo localGameCenterSessionInfo = a();
    GameSessionView localGameSessionView = this.this$0;
    GameSessionView.a(localGameSessionView, localGameSessionView.getContext(), localGameCenterSessionInfo);
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).setLastGameSessionClicked(GameSessionView.a(this.this$0).getAccount(), System.currentTimeMillis());
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void run()
  {
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.GameSessionView.ViewSwitcherSession
 * JD-Core Version:    0.7.0.1
 */