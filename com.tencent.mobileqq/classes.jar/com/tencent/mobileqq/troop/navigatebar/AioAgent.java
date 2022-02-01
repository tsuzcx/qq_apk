package com.tencent.mobileqq.troop.navigatebar;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.doutu.api.IDoutuService;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import java.util.Observable;
import java.util.Observer;

public abstract class AioAgent
  extends Observable
{
  public static int A = 1;
  public static int B = 2;
  public static int C = 3;
  public QQAppInterface D;
  public Context E;
  public BaseSessionInfo F;
  public RelativeLayout G;
  protected View H;
  public ChatAdapter1 I;
  public ChatXListView J;
  public Observer K;
  public ScrollerRunnable L;
  public boolean M = false;
  
  protected abstract void a();
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, Observer paramObserver, BaseSessionInfo paramBaseSessionInfo, RelativeLayout paramRelativeLayout, ChatAdapter1 paramChatAdapter1, ChatXListView paramChatXListView, ScrollerRunnable paramScrollerRunnable)
  {
    this.D = paramQQAppInterface;
    this.E = paramContext;
    this.F = paramBaseSessionInfo;
    this.G = paramRelativeLayout;
    paramContext = this.G;
    if (paramContext != null) {
      this.H = paramContext.findViewById(2131442214);
    }
    this.I = paramChatAdapter1;
    this.J = paramChatXListView;
    this.K = paramObserver;
    this.L = paramScrollerRunnable;
    deleteObservers();
    addObserver(paramObserver);
    paramQQAppInterface = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    if ((paramBaseSessionInfo.a != 1) && (paramBaseSessionInfo.a != 3000))
    {
      this.M = false;
      return;
    }
    if (!this.M)
    {
      this.M = true;
      a();
    }
  }
  
  protected abstract void b();
  
  public View f()
  {
    return null;
  }
  
  public void v()
  {
    if (this.M) {
      b();
    }
    this.M = false;
    deleteObservers();
  }
  
  public void w()
  {
    IDoutuService localIDoutuService = (IDoutuService)this.D.getRuntimeService(IDoutuService.class, "");
    if (localIDoutuService != null) {
      localIDoutuService.clearComboViews();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.AioAgent
 * JD-Core Version:    0.7.0.1
 */