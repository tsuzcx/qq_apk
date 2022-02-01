package com.tencent.mobileqq.gamecenter.web.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import auwe;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.gamecenter.view.GameSessionView;

public class GameContentView
  extends LinearLayout
{
  private auwe jdField_a_of_type_Auwe;
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
    LayoutInflater.from(getContext()).inflate(2131559191, this);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView = ((GameSessionView)findViewById(2131370079));
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView.a(BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_Auwe);
    }
  }
  
  public int a()
  {
    return getHeight();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Auwe = null;
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
  
  public void setUiRefresh(auwe paramauwe)
  {
    this.jdField_a_of_type_Auwe = paramauwe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.view.GameContentView
 * JD-Core Version:    0.7.0.1
 */