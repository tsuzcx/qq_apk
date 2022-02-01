package com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.LocationShareServiceHolder;
import com.tencent.mobileqq.location.ThemeChangedListener;
import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenContainer;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenContainer.OnDragListener;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenStatusReceiver;
import com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingBaseWrapper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageWrapper;
import mqq.app.MobileQQ;

public class FloatingLocationWrapper
  extends FloatingBaseWrapper
  implements ThemeChangedListener, FloatingScreenContainer.OnDragListener
{
  public static final String CLASS_NAME = FloatingLocationWrapper.class.getName();
  public static final int WAIT_ACTIVITY_ANIM_END_MILLIS = 500;
  
  public FloatingLocationWrapper(Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  private void f()
  {
    this.mFloatingContainer.setOnDragListener(this);
    LocationShareServiceHolder.a(MobileQQ.sMobileQQ.waitAppRuntime(null)).setThemeChangedListener(this);
  }
  
  private void g()
  {
    View localView = this.mRootLayout.findViewById(2131374874);
    localView.setContentDescription("位置共享悬浮窗");
    if (ThemeImageWrapper.isNightMode())
    {
      localView.setBackgroundColor(Color.parseColor("#4D000000"));
      return;
    }
    localView.setBackgroundColor(Color.parseColor("#00000000"));
  }
  
  public int a(FloatingScreenParams paramFloatingScreenParams, View paramView)
  {
    FloatingScreenParams localFloatingScreenParams = paramFloatingScreenParams;
    if (paramFloatingScreenParams == null)
    {
      if (this.mContext != null) {
        localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setCanZoom(false).build();
      }
    }
    else
    {
      paramFloatingScreenParams = new FloatingLocationWrapper.2(this, paramView, localFloatingScreenParams);
      ThreadManager.getUIHandlerV2().postDelayed(paramFloatingScreenParams, 500L);
      return 0;
    }
    return 2;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatingLocationWrapper", 2, new Object[] { "onThemeChanged: invoked. ", " TAG: ", "FloatingLocationWrapper" });
    }
    g();
  }
  
  public void a(Context paramContext)
  {
    super.a(paramContext);
    this.mFloatingCloseBtn.setContentDescription("关闭位置共享悬浮窗");
    g();
  }
  
  public void a(FloatingScreenParams paramFloatingScreenParams)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("qqfs_floating_sp", 4);
    int i = localSharedPreferences.getInt("KEY_QQFS_LOCATION_SHARE_CENTER_X", -2147483648);
    int j = localSharedPreferences.getInt("KEY_QQFS_LOCATION_SHARE_CENTER_Y", -2147483648);
    if ((i != -2147483648) && (j != -2147483648))
    {
      paramFloatingScreenParams.setFloatingCenterX(i);
      paramFloatingScreenParams.setFloatingCenterY(j);
    }
    if (QLog.isColorLevel()) {
      QLog.d("FloatingLocationWrapper", 2, new Object[] { "restoreLastCenterPosition: invoked. ", " centerX: ", Integer.valueOf(i), " centerY: ", Integer.valueOf(j) });
    }
  }
  
  public void b()
  {
    ReportController.b(null, "CliOper", "", "", "0X800A977", "0X800A977", 0, 0, "", "0", "0", "");
  }
  
  public void b(int paramInt)
  {
    FloatingLocationWrapper.3 local3 = new FloatingLocationWrapper.3(this, paramInt);
    ThreadManager.getUIHandlerV2().post(local3);
  }
  
  public void d()
  {
    if (this.mStatusReceiver == null)
    {
      this.mStatusReceiver = new FloatingScreenStatusReceiver(this.mContext);
      this.mStatusReceiver.a(1, new FloatingLocationWrapper.1(this));
    }
  }
  
  public void e()
  {
    if (this.mFloatingContainer != null)
    {
      boolean bool = this.mFloatingContainer.b();
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("qqfs_floating_sp", 4).edit();
      int i = this.mFloatingContainer.a();
      int j = this.mFloatingContainer.b();
      localEditor.putInt("KEY_QQFS_LOCATION_SHARE_CENTER_X", i);
      localEditor.putInt("KEY_QQFS_LOCATION_SHARE_CENTER_Y", j);
      localEditor.apply();
      if (QLog.isColorLevel()) {
        QLog.d("FloatingLocationWrapper", 2, new Object[] { "saveFloatingCenter: invoked. ", " centerX: ", Integer.valueOf(i), " centerY: ", Integer.valueOf(j), " isSmallFloating: ", Boolean.valueOf(bool) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper.FloatingLocationWrapper
 * JD-Core Version:    0.7.0.1
 */