package com.tencent.mobileqq.qqgamepub.web.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qqgamepub.view.GameSessionView;
import mqq.app.MobileQQ;

public class GameContentView
  extends LinearLayout
{
  GameSessionView a;
  private GameContentView.UiRefresh b;
  
  public GameContentView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public GameContentView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GameContentView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void c()
  {
    this.a = new GameSessionView(getContext());
    addView(this.a);
  }
  
  private void d()
  {
    this.a.setVisibility(8);
    this.a.a(MobileQQ.sMobileQQ.waitAppRuntime(null), this.b);
  }
  
  public void a()
  {
    d();
  }
  
  public void b()
  {
    GameSessionView localGameSessionView = this.a;
    if (localGameSessionView != null) {
      localGameSessionView.b();
    }
    this.b = null;
  }
  
  public int getContentViewHeight()
  {
    return getHeight();
  }
  
  public GameSessionView getGameSessionView()
  {
    return this.a;
  }
  
  public void setUiRefresh(GameContentView.UiRefresh paramUiRefresh)
  {
    this.b = paramUiRefresh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.web.view.GameContentView
 * JD-Core Version:    0.7.0.1
 */