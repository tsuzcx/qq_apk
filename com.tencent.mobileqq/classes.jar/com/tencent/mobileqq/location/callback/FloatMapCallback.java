package com.tencent.mobileqq.location.callback;

import android.view.View;
import com.tencent.mobileqq.activity.aio.helper.LocationShareHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.LocationShareServiceHolder;
import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper.FloatingLocationWrapper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class FloatMapCallback
  implements IFloatMapCallback
{
  public static long a = 0L;
  
  public static void a(QBaseActivity paramQBaseActivity)
  {
    if (paramQBaseActivity == null) {
      return;
    }
    FloatingScreenReporter.b();
    paramQBaseActivity = DialogUtil.a(paramQBaseActivity, 230, null, "位置共享将收起为小窗进行展示，请开启QQ悬浮窗权限以正常使用功能。", paramQBaseActivity.getString(2131690800), paramQBaseActivity.getString(2131694615), new FloatMapCallback.2(paramQBaseActivity), null);
    paramQBaseActivity.setCancelable(false);
    try
    {
      paramQBaseActivity.show();
      return;
    }
    catch (Exception paramQBaseActivity)
    {
      paramQBaseActivity.printStackTrace();
    }
  }
  
  private boolean a(QBaseActivity paramQBaseActivity, LocationRoom.RoomKey paramRoomKey, View paramView)
  {
    c();
    QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    FloatingScreenParams localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setShapeType(3).setCanMove(true).setCanZoom(false).setFloatingCenter(300, -680).build();
    IQQFloatingWindow localIQQFloatingWindow = (IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class);
    int i = localIQQFloatingWindow.enterLocationFloatingScreen(BaseApplication.getContext(), paramView, localFloatingScreenParams, FloatingLocationWrapper.CLASS_NAME);
    if (QLog.isColorLevel()) {
      QLog.d("FloatMapCallback", 2, new Object[] { "createFloatWindow: invoked. ", " result: ", Integer.valueOf(i) });
    }
    if (i == 1)
    {
      a(paramQBaseActivity);
      return false;
    }
    localIQQFloatingWindow.setWindowClickListener(FloatingLocationWrapper.CLASS_NAME, new FloatMapCallback.1(this, localQQAppInterface, paramRoomKey));
    return true;
  }
  
  public static void c()
  {
    a = System.currentTimeMillis();
  }
  
  public static void d()
  {
    long l = (System.currentTimeMillis() - a) / 1000L;
    if (QLog.isColorLevel()) {
      QLog.d("FloatMapCallback", 2, new Object[] { "reportFloatWindowLastExposeDuration: invoked. ", " second: ", Long.valueOf(l) });
    }
    ReportController.b(null, "CliOper", "", "", "0X800A976", "0X800A976", 0, 0, String.valueOf(l), "0", "0", "");
  }
  
  public void a()
  {
    ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen(FloatingLocationWrapper.CLASS_NAME);
  }
  
  public boolean a(QBaseActivity paramQBaseActivity, LocationRoom.RoomKey paramRoomKey)
  {
    return a(paramQBaseActivity, paramRoomKey, LocationShareServiceHolder.a(MobileQQ.sMobileQQ.waitAppRuntime(null)).getFloatMapView());
  }
  
  public void b()
  {
    ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).setWindowClickListener(FloatingLocationWrapper.CLASS_NAME, null);
    LocationShareHelper.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.callback.FloatMapCallback
 * JD-Core Version:    0.7.0.1
 */