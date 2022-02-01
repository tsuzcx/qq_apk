package com.tencent.mobileqq.qqfloatingwindow.impl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingBaseWrapper;
import com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper;
import com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingWrapperFactory;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenViewClickListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IWindowClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class QQFloatingWindowImpl
  implements IQQFloatingWindow
{
  private static final String QQFS_LOCATION_CENTER_X = "qqfs_floating_center_x";
  private static final String QQFS_LOCATION_CENTER_Y = "qqfs_floating_center_y";
  public static final String TAG = "FloatingScreenManager";
  private FloatingWrapperFactory mWrapperFactory = new FloatingWrapperFactory();
  
  private static void sendWindowClosedBroadcastWithId(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("param_concern_floating_type", 0);
    localIntent.putExtra("param_curr_window_status", 104);
    localIntent.putExtra("param_busitype", paramInt);
    localIntent.putExtra("param_ignored_processid", MobileQQ.sProcessId);
    paramContext.sendBroadcast(localIntent);
  }
  
  public int enterCustomFloatingScreen(Context paramContext, View paramView, FloatingScreenParams paramFloatingScreenParams, String paramString, int paramInt)
  {
    int i = 1;
    if ((paramContext == null) || (paramView == null)) {
      i = 2;
    }
    while (!FloatingScreenPermission.checkPermission(paramContext)) {
      return i;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FloatingScreenManager", 2, new Object[] { "enterCustomFloatingScreen:", Integer.valueOf(paramInt), ", view:", paramView.toString() });
    }
    FloatingScreenParams localFloatingScreenParams = paramFloatingScreenParams;
    if (paramFloatingScreenParams == null) {
      localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setShapeType(1).setCanZoom(false).build();
    }
    paramContext = this.mWrapperFactory.a(paramContext, paramString);
    if (paramContext == null) {
      return 3;
    }
    return paramContext.a(localFloatingScreenParams, paramView);
  }
  
  public int enterFloatingScreen(Context paramContext, View paramView, FloatingScreenParams paramFloatingScreenParams, int paramInt)
  {
    int i = 1;
    if ((paramContext == null) || (paramView == null)) {
      i = 2;
    }
    for (;;)
    {
      return i;
      try
      {
        FloatingScreenReporter.b(paramInt);
        if (!FloatingScreenPermission.checkPermission(paramContext)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FloatingScreenManager", 2, new Object[] { "enterFloatingScree:", paramView.toString() });
        }
        sendWindowClosedBroadcastWithId(paramContext, paramInt);
        ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(MobileQQ.getContext(), 50, 2);
        FloatingScreenParams localFloatingScreenParams = paramFloatingScreenParams;
        if (paramFloatingScreenParams == null) {
          localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setShapeType(2).setCanZoom(true).build();
        }
        paramFloatingScreenParams = MobileQQ.getContext().getSharedPreferences("qqfs_floating_sp", 4);
        i = paramFloatingScreenParams.getInt("qqfs_floating_center_x", -2147483648);
        int j = paramFloatingScreenParams.getInt("qqfs_floating_center_y", -2147483648);
        if ((i != -2147483648) && (j != -2147483648))
        {
          localFloatingScreenParams.setFloatingCenterX(i);
          localFloatingScreenParams.setFloatingCenterY(j);
        }
        paramContext = this.mWrapperFactory.a(paramContext, FloatingVideoWrapper.CLASS_NAME);
        if (paramContext == null)
        {
          i = 3;
          continue;
        }
        j = paramContext.a(localFloatingScreenParams, paramView);
        i = j;
        if (j != 0) {
          continue;
        }
        FloatingScreenReporter.a(paramInt);
        i = j;
      }
      finally {}
    }
  }
  
  public int enterLocationFloatingScreen(Context paramContext, View paramView, FloatingScreenParams paramFloatingScreenParams, String paramString)
  {
    int i = 1;
    if ((paramContext == null) || (paramView == null)) {
      i = 2;
    }
    for (;;)
    {
      return i;
      try
      {
        if (!FloatingScreenPermission.checkPermission(paramContext)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FloatingScreenManager", 2, new Object[] { "enterLocationFloatingScreen:", paramView.toString() });
        }
        FloatingScreenParams localFloatingScreenParams = paramFloatingScreenParams;
        if (paramFloatingScreenParams == null) {
          localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setShapeType(1).setCanZoom(false).build();
        }
        paramContext = this.mWrapperFactory.a(paramContext, paramString);
        if (paramContext == null)
        {
          i = 3;
          continue;
        }
        paramContext.a(localFloatingScreenParams);
        i = paramContext.a(localFloatingScreenParams, paramView);
      }
      finally {}
    }
  }
  
  public int enterWatchTogetherFloatingScreen(Context paramContext, View paramView, FloatingScreenParams paramFloatingScreenParams, String paramString)
  {
    int i = 1;
    if ((paramContext == null) || (paramView == null)) {
      i = 2;
    }
    for (;;)
    {
      return i;
      try
      {
        if (!FloatingScreenPermission.checkPermission(paramContext)) {
          continue;
        }
        if (!MobileQQ.sMobileQQ.getQQProcessName().endsWith(":tool"))
        {
          QQToast.a(paramContext, 2131699658, 0).a();
          i = -1;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FloatingScreenManager", 2, new Object[] { "enterLocationFloatingScreen:", paramView.toString() });
        }
        FloatingScreenParams localFloatingScreenParams = paramFloatingScreenParams;
        if (paramFloatingScreenParams == null) {
          localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setShapeType(1).setCanZoom(false).build();
        }
        paramContext = this.mWrapperFactory.a(paramContext, paramString);
        if (paramContext == null)
        {
          i = 3;
          continue;
        }
        paramContext.a(localFloatingScreenParams);
        i = paramContext.a(localFloatingScreenParams, paramView);
      }
      finally {}
    }
  }
  
  public void quitFloatingScreen()
  {
    FloatingBaseWrapper localFloatingBaseWrapper = this.mWrapperFactory.a(null, FloatingVideoWrapper.CLASS_NAME);
    if (localFloatingBaseWrapper != null) {
      localFloatingBaseWrapper.b(4);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("FloatingScreenManager", 2, "quitFloatingScreen Fail, wrapper is null");
  }
  
  public void quitFloatingScreen(String paramString)
  {
    paramString = this.mWrapperFactory.a(null, paramString);
    if (paramString != null) {
      paramString.b(4);
    }
  }
  
  public void saveFloatingCenter(int paramInt1, int paramInt2)
  {
    SharedPreferences.Editor localEditor = MobileQQ.getContext().getSharedPreferences("qqfs_floating_sp", 4).edit();
    localEditor.putInt("qqfs_floating_center_x", paramInt1);
    localEditor.putInt("qqfs_floating_center_y", paramInt2);
    localEditor.commit();
  }
  
  public IVideoOuterStatusListener setFloatingVideoListener(IVideoInnerStatusListener paramIVideoInnerStatusListener)
  {
    IVideoOuterStatusListener localIVideoOuterStatusListener = null;
    FloatingBaseWrapper localFloatingBaseWrapper = this.mWrapperFactory.a(null, FloatingVideoWrapper.CLASS_NAME);
    if (localFloatingBaseWrapper != null) {
      localIVideoOuterStatusListener = localFloatingBaseWrapper.a(paramIVideoInnerStatusListener);
    }
    return localIVideoOuterStatusListener;
  }
  
  public IVideoOuterStatusListener setFloatingVideoListener(IVideoInnerStatusListener paramIVideoInnerStatusListener, String paramString)
  {
    Object localObject = null;
    FloatingBaseWrapper localFloatingBaseWrapper = this.mWrapperFactory.a(null, paramString);
    paramString = localObject;
    if (localFloatingBaseWrapper != null) {
      paramString = localFloatingBaseWrapper.a(paramIVideoInnerStatusListener);
    }
    return paramString;
  }
  
  @Deprecated
  public void setFullScreenListener(IFullScreenEnterListener paramIFullScreenEnterListener)
  {
    FloatingBaseWrapper localFloatingBaseWrapper = this.mWrapperFactory.a(null, FloatingVideoWrapper.CLASS_NAME);
    if (localFloatingBaseWrapper != null) {
      localFloatingBaseWrapper.a(paramIFullScreenEnterListener);
    }
  }
  
  public void setFullScreenViewClickListener(IFullScreenViewClickListener paramIFullScreenViewClickListener)
  {
    FloatingBaseWrapper localFloatingBaseWrapper = this.mWrapperFactory.a(null, FloatingVideoWrapper.CLASS_NAME);
    if (localFloatingBaseWrapper != null) {
      localFloatingBaseWrapper.a(paramIFullScreenViewClickListener);
    }
  }
  
  public void setWindowClickListener(String paramString, IWindowClickListener paramIWindowClickListener)
  {
    paramString = this.mWrapperFactory.a(null, paramString);
    if (paramString != null) {
      paramString.a(paramIWindowClickListener);
    }
  }
  
  public void updateFloatingWindowRatio(float paramFloat, String paramString)
  {
    paramString = this.mWrapperFactory.a(null, paramString);
    if (paramString != null) {
      paramString.a(paramFloat);
    }
  }
  
  public void updateFloatingWindowShape(int paramInt, String paramString)
  {
    paramString = this.mWrapperFactory.a(null, paramString);
    if (paramString != null) {
      paramString.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.QQFloatingWindowImpl
 * JD-Core Version:    0.7.0.1
 */