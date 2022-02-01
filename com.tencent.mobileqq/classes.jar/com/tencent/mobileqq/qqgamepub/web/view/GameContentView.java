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
  GameSessionView jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView;
  private GameContentView.UiRefresh jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView$UiRefresh;
  
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
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView = new GameSessionView(getContext());
    addView(this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView.a(MobileQQ.sMobileQQ.waitAppRuntime(null), this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView$UiRefresh);
  }
  
  public int a()
  {
    return getHeight();
  }
  
  public GameSessionView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView$UiRefresh = null;
  }
  
  public void b()
  {
    e();
  }
  
  public void c()
  {
    GameSessionView localGameSessionView = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView;
    if (localGameSessionView != null) {
      localGameSessionView.c();
    }
  }
  
  public void setUiRefresh(GameContentView.UiRefresh paramUiRefresh)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView$UiRefresh = paramUiRefresh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.web.view.GameContentView
 * JD-Core Version:    0.7.0.1
 */