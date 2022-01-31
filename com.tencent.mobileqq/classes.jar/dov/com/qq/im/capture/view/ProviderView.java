package dov.com.qq.im.capture.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.CaptureContext;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.DoodleEventListener;

public abstract class ProviderView
  extends FrameLayout
{
  Context a;
  public View a;
  protected ViewGroup a;
  protected AppInterface a;
  public ProviderView.ProviderViewListener a;
  protected QIMSlidingTabView a;
  protected DoodleLayout.DoodleEventListener a;
  protected Handler b;
  protected View b;
  private QIMSlidingTabView b;
  private QIMSlidingTabView c;
  protected boolean c;
  protected int d;
  protected boolean d;
  protected int e = 206;
  public int f = 0;
  
  public ProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  public abstract int a();
  
  protected Bundle a()
  {
    return null;
  }
  
  public QIMSlidingTabView a()
  {
    return this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProviderView", 2, "onProviderShow " + getClass().getSimpleName());
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = CaptureContext.a();
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      paramBundle = LayoutInflater.from(getContext()).inflate(2130970088, this, false);
      addView(paramBundle);
      this.jdField_b_of_type_DovComQqImCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)paramBundle.findViewById(2131368946));
      this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)paramBundle.findViewById(2131368949));
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramBundle.findViewById(2131368948));
    }
    paramBundle = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    paramBundle.height = UIUtils.a(getContext(), this.e);
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramBundle);
    if (this.jdField_d_of_type_Int == 1)
    {
      paramBundle = this.jdField_b_of_type_DovComQqImCaptureViewQIMSlidingTabView;
      this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView = paramBundle;
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setVisibility(0);
        if (this.jdField_d_of_type_Int != 1) {
          break label170;
        }
        findViewById(2131368947).setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = true;
      return;
      paramBundle = this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView;
      break;
      label170:
      if (this.jdField_d_of_type_Int != 2) {}
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
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProviderView", 2, "onProviderDismiss " + getClass().getSimpleName());
    }
  }
  
  public void b(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    try
    {
      paramBundle = LayoutInflater.from(getContext()).inflate(2130970088, this, false);
      addView(paramBundle);
      if (this.jdField_b_of_type_AndroidViewView == null)
      {
        this.jdField_b_of_type_AndroidViewView = paramBundle;
        this.jdField_b_of_type_DovComQqImCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368946));
        this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368949));
        this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_b_of_type_AndroidViewView.findViewById(2131368948));
      }
      paramBundle = LayoutInflater.from(getContext()).inflate(a(), this, false);
      if (this.jdField_a_of_type_AndroidViewView == null) {
        this.jdField_a_of_type_AndroidViewView = paramBundle;
      }
      return;
    }
    catch (Exception paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ProviderView", 2, "preInflate failed " + paramBundle.toString());
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  public void d(int paramInt)
  {
    this.e = paramInt;
  }
  
  public boolean d()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void e() {}
  
  public boolean e()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void f() {}
  
  public void g() {}
  
  protected void k()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.f();
    }
  }
  
  public void setCaptureScene(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setDoodleEventListener(DoodleLayout.DoodleEventListener paramDoodleEventListener)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener = paramDoodleEventListener;
  }
  
  public void setNeedTabBar(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setProviderViewListener(ProviderView.ProviderViewListener paramProviderViewListener)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener = paramProviderViewListener;
  }
  
  public void setTabBarPosition(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.ProviderView
 * JD-Core Version:    0.7.0.1
 */