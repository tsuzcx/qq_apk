package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import bbix;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import zps;

public abstract class ProviderView
  extends FrameLayout
{
  Context a;
  protected Handler a;
  protected View a;
  protected ViewGroup a;
  protected bbix a;
  protected AppInterface a;
  protected QQSlidingTabView a;
  protected View b;
  private QQSlidingTabView b;
  protected boolean b;
  protected int c;
  private QQSlidingTabView c;
  protected boolean c;
  protected int d = 206;
  
  public ProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      paramBundle = LayoutInflater.from(getContext()).inflate(2131561099, this, false);
      addView(paramBundle);
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView = ((QQSlidingTabView)paramBundle.findViewById(2131373095));
      this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView = ((QQSlidingTabView)paramBundle.findViewById(2131373090));
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramBundle.findViewById(2131373092));
    }
    paramBundle = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    paramBundle.height = zps.a(getContext(), this.d);
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramBundle);
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_c_of_type_Int != 1) {
        break label155;
      }
      paramBundle = this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView = paramBundle;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.setVisibility(0);
      if (this.jdField_c_of_type_Int != 1) {
        break label163;
      }
      findViewById(2131373096).setVisibility(0);
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = true;
      return;
      label155:
      paramBundle = this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView;
      break;
      label163:
      if (this.jdField_c_of_type_Int != 2) {}
    }
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      throw new IllegalStateException("no content layout");
    }
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void aI_() {}
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void c() {}
  
  public void setAppInterface(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public void setNeedTabBar(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setProviderViewListener(bbix parambbix)
  {
    this.jdField_a_of_type_Bbix = parambbix;
  }
  
  public void setTabBarPosition(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.ProviderView
 * JD-Core Version:    0.7.0.1
 */