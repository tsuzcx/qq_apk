package com.tencent.mobileqq.qqgamepub.web.delegate;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameWebPresenter;
import com.tencent.mobileqq.qqgamepub.view.GameSessionView;
import com.tencent.mobileqq.qqgamepub.web.view.GameContentView;
import com.tencent.mobileqq.qqgamepub.web.view.GameContentView.UiRefresh;
import com.tencent.qphone.base.util.QLog;

public class GameContentViewDelegate
  extends BaseViewDelegate<QQGameWebPresenter>
  implements GameContentView.UiRefresh
{
  private GameContentView c;
  private GameSessionView d;
  private View e;
  
  public GameContentViewDelegate(QQGameWebPresenter paramQQGameWebPresenter, View paramView)
  {
    super(paramQQGameWebPresenter, paramView);
    this.c = ((GameContentView)paramView.findViewById(2131436926));
    this.d = this.c.getGameSessionView();
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    for (paramView = paramView.getParent(); (paramView instanceof ViewGroup); paramView = paramView.getParent()) {
      ((ViewGroup)paramView).setClipChildren(paramBoolean);
    }
  }
  
  public void a()
  {
    QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "doOnDestory", null, null);
    GameContentView localGameContentView = this.c;
    if (localGameContentView != null) {
      localGameContentView.b();
    }
  }
  
  public void a(View paramView)
  {
    this.e = paramView;
  }
  
  public void b()
  {
    GameContentView localGameContentView = this.c;
    if (localGameContentView != null)
    {
      localGameContentView.a();
      this.c.setUiRefresh(this);
    }
  }
  
  public int c()
  {
    Object localObject = this.c;
    int i;
    if ((localObject != null) && (((GameContentView)localObject).getVisibility() == 0)) {
      i = this.c.getContentViewHeight();
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("gameContentHeight=");
      ((StringBuilder)localObject).append(i);
      QLog.d("GameContentViewDelegate", 1, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  public void c(long paramLong)
  {
    GameSessionView localGameSessionView = this.d;
    if (localGameSessionView != null) {
      localGameSessionView.postDelayed(new GameContentViewDelegate.2(this), paramLong);
    }
  }
  
  public void d()
  {
    QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "doOnResume", null, null);
  }
  
  public void h()
  {
    GameContentView localGameContentView = this.c;
    if (localGameContentView != null) {
      localGameContentView.post(new GameContentViewDelegate.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.web.delegate.GameContentViewDelegate
 * JD-Core Version:    0.7.0.1
 */