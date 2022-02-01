package com.tencent.mobileqq.qqgamepub.view;

import android.content.res.Resources;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ViewSwitcher;
import android.widget.ViewSwitcher.ViewFactory;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.data.IDataVisitor;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo.SimpleMessage;
import com.tencent.mobileqq.gamecenter.msginfo.GameDelSessionRecord;
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
  protected String a;
  private ViewSwitcher b;
  private int c = -1;
  private final long d = 1500L;
  private List<GameSessionView.WrappedMessage> e = new ArrayList();
  
  GameSessionView$ViewSwitcherSession(GameSessionView paramGameSessionView)
  {
    this.a = paramGameSessionView.getResources().getString(2131892948);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return;
      }
      this.c += 1;
      int i = this.c;
      int j = this.e.size();
      int k = 0;
      if (i >= j) {
        this.c = 0;
      }
      a(this.b.getNextView(), (GameSessionView.WrappedMessage)this.e.get(this.c));
      this.b.showNext();
      if ("3".equals(GamePubAccountHelper.a()))
      {
        i = 0;
        for (;;)
        {
          j = k;
          if (i >= this.b.getChildCount()) {
            break;
          }
          if ((this.b.getChildAt(i) != null) && (this.b.getChildAt(i).getHeight() == 0) && (this.b.getChildAt(i).getWidth() == 0))
          {
            j = 1;
            break;
          }
          i += 1;
        }
        if (j != 0)
        {
          QLog.d(GameSessionView.a, 1, "viewSwitcher need posDraw");
          localObject = this.b;
          ((ViewSwitcher)localObject).measure(View.MeasureSpec.makeMeasureSpec(((ViewSwitcher)localObject).getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.b.getHeight(), 1073741824));
          localObject = this.b;
          ((ViewSwitcher)localObject).layout(((ViewSwitcher)localObject).getLeft(), this.b.getTop(), this.b.getRight(), this.b.getBottom());
        }
      }
      if (paramBoolean) {
        this.this$0.postDelayed(this, 1500L);
      }
    }
  }
  
  public int a(GameSessionView.WrappedMessage paramWrappedMessage1, GameSessionView.WrappedMessage paramWrappedMessage2)
  {
    if (paramWrappedMessage1.b.a > paramWrappedMessage2.b.a) {
      return -1;
    }
    if (paramWrappedMessage1.b.a < paramWrappedMessage2.b.a) {
      return 1;
    }
    return 0;
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
    this.b = paramViewSwitcher;
    paramViewSwitcher.setAnimateFirstView(false);
  }
  
  public void a(List<GameCenterSessionInfo> paramList, int paramInt)
  {
    this.e.clear();
    boolean bool = false;
    paramInt = 0;
    GameCenterSessionInfo localGameCenterSessionInfo;
    Object localObject;
    int i;
    while (paramInt < paramList.size())
    {
      localGameCenterSessionInfo = (GameCenterSessionInfo)paramList.get(paramInt);
      localObject = ((GameCenterSessionInfo)paramList.get(paramInt)).d();
      if (localObject != null)
      {
        i = 0;
        while (i < ((List)localObject).size())
        {
          this.e.add(new GameSessionView.WrappedMessage(localGameCenterSessionInfo, (GameCenterSessionInfo.SimpleMessage)((List)localObject).get(i)));
          i += 1;
        }
      }
      paramInt += 1;
    }
    if (this.e.size() == 0)
    {
      paramInt = 0;
      while (paramInt < paramList.size())
      {
        localGameCenterSessionInfo = (GameCenterSessionInfo)paramList.get(paramInt);
        localObject = ((IGameMsgManagerService)GameSessionView.a(this.this$0).getRuntimeService(IGameMsgManagerService.class, "")).getSessionDelDataHelper();
        GameDelSessionRecord localGameDelSessionRecord = new GameDelSessionRecord();
        localGameDelSessionRecord.mUin = localGameCenterSessionInfo.g();
        if ((localObject != null) && (((IDataVisitor)localObject).d(localGameDelSessionRecord))) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0) {
          this.e.add(new GameSessionView.WrappedMessage(localGameCenterSessionInfo, new GameCenterSessionInfo.SimpleMessage(localGameCenterSessionInfo.n(), localGameCenterSessionInfo.m())));
        }
        paramInt += 1;
      }
    }
    Collections.sort(this.e, this);
    this.this$0.removeCallbacks(this);
    this.b.removeAllViews();
    this.b.setFactory(this);
    this.c = -1;
    if (this.e.size() > 0)
    {
      if (this.e.size() > 1) {
        bool = true;
      }
      a(bool);
    }
  }
  
  protected ViewSwitcher c()
  {
    return this.b;
  }
  
  protected GameCenterSessionInfo d()
  {
    return (GameCenterSessionInfo)this.b.getCurrentView().getTag();
  }
  
  public void onClick(View paramView)
  {
    GameCenterSessionInfo localGameCenterSessionInfo = d();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.GameSessionView.ViewSwitcherSession
 * JD-Core Version:    0.7.0.1
 */