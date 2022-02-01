package dov.com.qq.im.ptv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import avli;
import blvp;
import boqv;
import boqy;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;

public class AIOLongCaptureCtrl
  implements View.OnTouchListener
{
  private static boolean jdField_a_of_type_Boolean;
  private static boolean jdField_b_of_type_Boolean;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private boqv jdField_a_of_type_Boqv;
  private RichmediaService jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService;
  private AIOLongCaptureCtrl.RunnableLW jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl$RunnableLW = new AIOLongCaptureCtrl.RunnableLW(this, null);
  private LWMotionEvent jdField_a_of_type_DovComQqImPtvLWMotionEvent = new LWMotionEvent();
  private Runnable jdField_a_of_type_JavaLangRunnable = new AIOLongCaptureCtrl.1(this);
  private long jdField_b_of_type_Long = 400L;
  private LWMotionEvent jdField_b_of_type_DovComQqImPtvLWMotionEvent = new LWMotionEvent();
  private boolean c;
  private boolean d;
  private boolean e;
  
  public AIOLongCaptureCtrl(boqv paramboqv)
  {
    this.jdField_a_of_type_Boqv = paramboqv;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private static LWMotionEvent a(Bundle paramBundle)
  {
    LWMotionEvent localLWMotionEvent = new LWMotionEvent();
    localLWMotionEvent.jdField_a_of_type_Int = paramBundle.getInt("LWAction");
    localLWMotionEvent.jdField_a_of_type_Float = paramBundle.getFloat("LWX");
    localLWMotionEvent.jdField_b_of_type_Float = paramBundle.getFloat("LWY");
    localLWMotionEvent.jdField_b_of_type_Int = paramBundle.getInt("LWEventSource", 0);
    return localLWMotionEvent;
  }
  
  public static void a(Bundle paramBundle)
  {
    paramBundle = a(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("PTV", 2, " cocohe PTV_LONG_POINT x=" + paramBundle.a() + " y:" + paramBundle.b());
    }
  }
  
  public static void b()
  {
    if (jdField_b_of_type_Boolean) {
      jdField_a_of_type_Boolean = true;
    }
    boolean bool;
    do
    {
      RichmediaService localRichmediaService;
      do
      {
        return;
        jdField_a_of_type_Boolean = false;
        localRichmediaService = RichmediaService.a();
      } while (localRichmediaService == null);
      bool = localRichmediaService.a(252, -1, new Bundle());
    } while (!QLog.isColorLevel());
    QLog.i("AIOLongCaptureCtrl", 2, "RichMediaServiceCall  success: " + bool);
  }
  
  public static void b(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV", 2, "peakExitEvent");
    }
  }
  
  private static void b(Bundle paramBundle, LWMotionEvent paramLWMotionEvent, int paramInt)
  {
    paramBundle.putInt("LWAction", paramLWMotionEvent.a());
    paramBundle.putFloat("LWX", paramLWMotionEvent.a());
    paramBundle.putFloat("LWY", paramLWMotionEvent.b());
    paramBundle.putInt("LWEventSource", paramInt);
  }
  
  private boolean b()
  {
    boolean bool = LightVideoConfigMgr.a().c();
    if (QLog.isColorLevel()) {
      QLog.i("AIOLongCaptureCtrl", 2, "isLongClickSupport: longSupport=" + bool);
    }
    if (!bool) {}
    int i;
    do
    {
      return false;
      if (!this.jdField_a_of_type_Boqv.a()) {
        return true;
      }
      int[] arrayOfInt = LiuHaiUtils.a(this.jdField_a_of_type_Boqv.a());
      i = (int)(arrayOfInt[1] * 0.45F);
      if (QLog.isColorLevel()) {
        QLog.i("AIOLongCaptureCtrl", 2, "isLongClickSupport: h_40Height=" + i + " mExternalPanelheight=" + XPanelContainer.jdField_a_of_type_Int + " dataInfo[1]=" + arrayOfInt[1]);
      }
    } while (XPanelContainer.jdField_a_of_type_Int > i);
    return true;
  }
  
  private void c()
  {
    this.jdField_a_of_type_Int = 3;
    if (!this.e)
    {
      e();
      this.e = true;
      d();
    }
  }
  
  private void c(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService = RichmediaService.a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService != null) && (!this.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService.a(251, -1, paramBundle)))
    {
      Intent localIntent = new Intent("tencent.qq.ipc.event");
      localIntent.putExtras(paramBundle);
      this.jdField_a_of_type_Boqv.a().sendBroadcast(localIntent);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
  }
  
  private void e()
  {
    Bundle localBundle = new Bundle();
    if (this.jdField_a_of_type_Boqv.a())
    {
      localBundle.putInt("flow_camera_show_mode_style", 1);
      localBundle.putBoolean("flow_camera_show_panel", true);
    }
    for (;;)
    {
      localBundle.putParcelable("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_Boqv.a());
      localBundle.putInt("flow_camera_height", XPanelContainer.jdField_a_of_type_Int);
      localBundle.putBoolean("flow_camera_peak_live", this.d);
      localBundle.putInt("light_video_entry_type", this.jdField_a_of_type_Int);
      boqy.a(this.jdField_a_of_type_Boqv.a(), this.jdField_a_of_type_Boqv.a(), localBundle, 20101);
      if (QLog.isColorLevel()) {
        QLog.i("AIOLongCaptureCtrl", 2, "handleTouch longStartActivity peakLive: " + this.d);
      }
      if (blvp.a != null) {
        blvp.a.b();
      }
      return;
      localBundle.putInt("flow_camera_show_mode_style", 1);
      localBundle.putBoolean("flow_camera_show_panel", false);
    }
  }
  
  private void f()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("flow_camera_show_mode_style", 0);
    localBundle.putBoolean("flow_camera_show_panel", false);
    localBundle.putInt("flow_camera_height", XPanelContainer.jdField_a_of_type_Int);
    localBundle.putParcelable("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_Boqv.a());
    localBundle.putInt("light_video_entry_type", this.jdField_a_of_type_Int);
    boqy.a(this.jdField_a_of_type_Boqv.a(), this.jdField_a_of_type_Boqv.a(), localBundle, 20101);
    if (QLog.isColorLevel()) {
      QLog.i("AIOLongCaptureCtrl", 2, "handleTouch clickStartActivity");
    }
    if (blvp.a != null) {
      blvp.a.b();
    }
  }
  
  public void a()
  {
    a(2);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (!this.e)
    {
      f();
      this.e = true;
      d();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 20101)
    {
      this.e = false;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (QLog.isColorLevel()) {
      QLog.i("AIOLongCaptureCtrl", 2, "handleTouch cocohe[AIO] entryX=" + paramMotionEvent.getRawX() + " entryY=" + paramMotionEvent.getRawY() + " actionEvent:" + i);
    }
    if (this.jdField_a_of_type_Boqv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOLongCaptureCtrl", 2, "handleTouch cocohe[AIO] context=null actionEvent:" + i);
      }
      return true;
    }
    switch (i)
    {
    }
    for (;;)
    {
      return false;
      jdField_a_of_type_Boolean = false;
      jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.c = true;
      if (QLog.isColorLevel()) {
        QLog.i("AIOLongCaptureCtrl", 2, "handleTouch[ACTION_DOWN] hasLongEventDown" + this.c);
      }
      this.jdField_a_of_type_DovComQqImPtvLWMotionEvent.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_DovComQqImPtvLWMotionEvent.jdField_a_of_type_Float = paramMotionEvent.getRawX();
      this.jdField_a_of_type_DovComQqImPtvLWMotionEvent.jdField_b_of_type_Float = paramMotionEvent.getRawY();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl$RunnableLW, 100L);
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("AIOLongCaptureCtrl", 2, "handleTouch[ACTION_UP]  hasLongEventDown:" + this.c);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl$RunnableLW);
      if (this.c)
      {
        this.c = false;
        a();
      }
      for (;;)
      {
        jdField_a_of_type_Boolean = false;
        jdField_b_of_type_Boolean = false;
        break;
        if (QLog.isColorLevel()) {
          QLog.i("AIOLongCaptureCtrl", 2, "handleTouch[ACTION_UP] havePtvUIStarted:" + jdField_a_of_type_Boolean);
        }
        if (jdField_a_of_type_Boolean)
        {
          paramView = new Bundle();
          this.jdField_b_of_type_DovComQqImPtvLWMotionEvent.a(paramMotionEvent);
          b(paramView, this.jdField_b_of_type_DovComQqImPtvLWMotionEvent, 0);
          c(paramView);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("AIOLongCaptureCtrl", 2, "handleTouch[ACTION_MOVE] hasLongEventDown:" + this.c + " havePtvUIStarted:" + jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_DovComQqImPtvLWMotionEvent.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_DovComQqImPtvLWMotionEvent.jdField_a_of_type_Float = paramMotionEvent.getRawX();
      this.jdField_a_of_type_DovComQqImPtvLWMotionEvent.jdField_b_of_type_Float = paramMotionEvent.getRawY();
      if (this.c)
      {
        long l1 = SystemClock.uptimeMillis();
        long l2 = this.jdField_a_of_type_Long;
        if ((b()) && (l1 - l2 >= this.jdField_b_of_type_Long))
        {
          c();
          this.c = false;
        }
      }
      else if (jdField_a_of_type_Boolean)
      {
        paramView = new Bundle();
        this.jdField_b_of_type_DovComQqImPtvLWMotionEvent.a(paramMotionEvent);
        b(paramView, this.jdField_b_of_type_DovComQqImPtvLWMotionEvent, 0);
        c(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ptv.AIOLongCaptureCtrl
 * JD-Core Version:    0.7.0.1
 */