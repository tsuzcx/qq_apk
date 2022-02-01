package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public abstract class ProviderView
  extends FrameLayout
{
  Context a;
  protected Handler a;
  protected View a;
  protected AppInterface a;
  protected ProviderView.ProviderViewListener a;
  protected QQSlidingTabView a;
  protected int b;
  protected boolean b;
  protected int c;
  protected boolean c;
  
  public ProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 206;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  public void setAppInterface(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public void setNeedTabBar(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setProviderViewListener(ProviderView.ProviderViewListener paramProviderViewListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$ProviderViewListener = paramProviderViewListener;
  }
  
  public void setTabBarPosition(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.ProviderView
 * JD-Core Version:    0.7.0.1
 */