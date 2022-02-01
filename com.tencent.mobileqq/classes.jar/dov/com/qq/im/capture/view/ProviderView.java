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
  public Context a;
  protected View a;
  protected ViewGroup a;
  protected AppInterface a;
  protected ProviderView.ProviderViewListener a;
  protected QIMSlidingTabView a;
  protected DoodleLayout.DoodleEventListener a;
  protected Handler b;
  protected View b;
  private QIMSlidingTabView b;
  private QIMSlidingTabView c;
  protected boolean c;
  public boolean d = false;
  protected int e;
  protected int f = 206;
  public int g = 0;
  public int h = 2;
  
  public ProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  protected abstract int a();
  
  public QIMSlidingTabView a()
  {
    return this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, String paramString1, String paramString2) {}
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = CaptureContext.a();
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      paramBundle = LayoutInflater.from(getContext()).inflate(2131560993, this, false);
      addView(paramBundle);
      this.jdField_b_of_type_DovComQqImCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)paramBundle.findViewById(2131373597));
      this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)paramBundle.findViewById(2131373592));
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramBundle.findViewById(2131373594));
    }
    paramBundle = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    paramBundle.height = UIUtils.a(getContext(), this.f);
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramBundle);
    if (this.e == 1) {}
    for (paramBundle = this.jdField_b_of_type_DovComQqImCaptureViewQIMSlidingTabView;; paramBundle = this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView = paramBundle;
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setVisibility(0);
        if (this.e == 1) {
          findViewById(2131373598).setVisibility(0);
        }
      }
      this.d = true;
      if (QLog.isColorLevel()) {
        QLog.i("ProviderView", 2, "onCreate");
      }
      return;
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
  
  public void b() {}
  
  public void b(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    try
    {
      paramBundle = LayoutInflater.from(getContext()).inflate(2131560993, this, false);
      addView(paramBundle);
      if (this.jdField_b_of_type_AndroidViewView == null)
      {
        this.jdField_b_of_type_AndroidViewView = paramBundle;
        this.jdField_b_of_type_DovComQqImCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)this.jdField_b_of_type_AndroidViewView.findViewById(2131373597));
        this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)this.jdField_b_of_type_AndroidViewView.findViewById(2131373592));
        this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_b_of_type_AndroidViewView.findViewById(2131373594));
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
    if (QLog.isColorLevel()) {
      QLog.d("ProviderView", 2, "[cc]onProviderShow " + getClass().getSimpleName());
    }
  }
  
  public int d()
  {
    return this.f;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProviderView", 2, "[cc]onProviderDismiss " + getClass().getSimpleName());
    }
  }
  
  public void d(int paramInt)
  {
    this.f = paramInt;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public void e() {}
  
  public boolean e()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void f() {}
  
  public void setCaptureScene(int paramInt)
  {
    this.g = paramInt;
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
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.ProviderView
 * JD-Core Version:    0.7.0.1
 */