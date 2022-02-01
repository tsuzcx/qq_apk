package com.tencent.mobileqq.gamecenter.web.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import avgy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.gamecenter.view.GameSessionView;

public class GameContentView
  extends LinearLayout
{
  private avgy jdField_a_of_type_Avgy;
  GameSessionView jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView;
  
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
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView = new GameSessionView(getContext());
    addView(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView.a(BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_Avgy);
  }
  
  public int a()
  {
    return getHeight();
  }
  
  public GameSessionView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Avgy = null;
  }
  
  public void b()
  {
    e();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView.b();
    }
  }
  
  public void setUiRefresh(avgy paramavgy)
  {
    this.jdField_a_of_type_Avgy = paramavgy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.view.GameContentView
 * JD-Core Version:    0.7.0.1
 */