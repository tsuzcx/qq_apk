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
import android.widget.RelativeLayout;
import blqh;
import bmau;
import bmub;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import xsm;

public abstract class ProviderView
  extends FrameLayout
{
  public Context a;
  protected View a;
  protected ViewGroup a;
  protected RelativeLayout a;
  public bmau a;
  protected bmub a;
  protected AppInterface a;
  protected QIMSlidingTabView a;
  protected Handler b;
  protected View b;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private QIMSlidingTabView jdField_b_of_type_DovComQqImCaptureViewQIMSlidingTabView;
  private QIMSlidingTabView c;
  protected boolean c;
  public boolean d;
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
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, String paramString1, String paramString2) {}
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = blqh.a();
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      paramBundle = LayoutInflater.from(getContext()).inflate(2131560726, this, false);
      addView(paramBundle);
      this.jdField_b_of_type_DovComQqImCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)paramBundle.findViewById(2131372389));
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)LayoutInflater.from(getContext()).inflate(2131560727, this.jdField_a_of_type_AndroidWidgetRelativeLayout, false));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView);
        this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramBundle.findViewById(2131372386));
      }
    }
    else
    {
      paramBundle = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      paramBundle.height = xsm.a(getContext(), this.f);
      this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramBundle);
      if (this.e != 1) {
        break label221;
      }
      paramBundle = this.jdField_b_of_type_DovComQqImCaptureViewQIMSlidingTabView;
      label147:
      this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView = paramBundle;
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setVisibility(0);
        if (this.e != 1) {
          break label229;
        }
        findViewById(2131372390).setVisibility(0);
      }
    }
    for (;;)
    {
      this.d = true;
      if (QLog.isColorLevel()) {
        QLog.i("ProviderView", 2, "oncreate");
      }
      return;
      this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)paramBundle.findViewById(2131372384));
      break;
      label221:
      paramBundle = this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView;
      break label147;
      label229:
      if (this.e != 2) {}
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
    if (this.jdField_a_of_type_AndroidViewView == null) {
      try
      {
        paramBundle = LayoutInflater.from(getContext()).inflate(2131560726, this, false);
        addView(paramBundle);
        if (this.jdField_b_of_type_AndroidViewView == null)
        {
          this.jdField_b_of_type_AndroidViewView = paramBundle;
          this.jdField_b_of_type_DovComQqImCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)this.jdField_b_of_type_AndroidViewView.findViewById(2131372389));
          if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
            break label143;
          }
          this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)LayoutInflater.from(getContext()).inflate(2131560727, this.jdField_a_of_type_AndroidWidgetRelativeLayout, false));
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_b_of_type_AndroidViewView.findViewById(2131372386));
          paramBundle = LayoutInflater.from(getContext()).inflate(a(), this, false);
          if (this.jdField_a_of_type_AndroidViewView != null) {
            break;
          }
          this.jdField_a_of_type_AndroidViewView = paramBundle;
          return;
          label143:
          this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)this.jdField_b_of_type_AndroidViewView.findViewById(2131372384));
        }
        return;
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ProviderView", 2, "preInflate failed " + paramBundle.toString());
        }
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProviderView", 2, "[cc]onProviderShow " + getClass().getSimpleName());
    }
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView == this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView) && (this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.getVisibility() != 0)) {
      this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.setVisibility(0);
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
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView == this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView) && (this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.getVisibility() == 0)) {
      this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.setVisibility(8);
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
  
  protected void k()
  {
    if (this.jdField_a_of_type_Bmau != null) {
      this.jdField_a_of_type_Bmau.h();
    }
  }
  
  public void l()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView == this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView) && (this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.getVisibility() == 0)) {
      this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProviderView", 2, "[cc]dismissBottomTab " + getClass().getSimpleName());
    }
  }
  
  public void m()
  {
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView == this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView) && (this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.getVisibility() != 0)) {
      this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
    if (QLog.isColorLevel()) {
      QLog.d("ProviderView", 2, "[cc]showBottomTab " + getClass().getSimpleName());
    }
  }
  
  public void setCaptureScene(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setDoodleEventListener(bmub parambmub)
  {
    this.jdField_a_of_type_Bmub = parambmub;
  }
  
  public void setLiuHaiParentView(RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
  }
  
  public void setNeedTabBar(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setProviderViewListener(bmau parambmau)
  {
    this.jdField_a_of_type_Bmau = parambmau;
  }
  
  public void setTabBarPosition(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.view.ProviderView
 * JD-Core Version:    0.7.0.1
 */