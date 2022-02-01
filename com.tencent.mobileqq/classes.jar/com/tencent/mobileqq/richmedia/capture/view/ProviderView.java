package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import bacv;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public abstract class ProviderView
  extends FrameLayout
{
  Context a;
  protected Handler a;
  protected View a;
  protected bacv a;
  protected AppInterface a;
  protected QQSlidingTabView a;
  protected int b;
  protected boolean b;
  protected int c = 206;
  protected boolean c;
  
  public ProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = true;
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
  
  public void setProviderViewListener(bacv parambacv)
  {
    this.jdField_a_of_type_Bacv = parambacv;
  }
  
  public void setTabBarPosition(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.ProviderView
 * JD-Core Version:    0.7.0.1
 */