package com.tencent.mobileqq.qqfloatingwindow.impl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import com.tencent.mobileqq.qqfloatingwindow.FloatingBaseProxyWrapper;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenReporter;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
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
    if (paramContext != null)
    {
      if (paramView == null) {
        return 2;
      }
      if (!FloatingScreenPermission.checkPermission(paramContext)) {
        return 1;
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
    return 2;
  }
  
  public int enterFloatingScreen(Context paramContext, View paramView, FloatingScreenParams paramFloatingScreenParams, int paramInt)
  {
    if ((paramContext != null) && (paramView != null)) {
      try
      {
        FloatingScreenReporter.c(paramInt);
        boolean bool = FloatingScreenPermission.checkPermission(paramContext);
        if (!bool) {
          return 1;
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
        int i = paramFloatingScreenParams.getInt("qqfs_floating_center_x", -2147483648);
        int j = paramFloatingScreenParams.getInt("qqfs_floating_center_y", -2147483648);
        if ((i != -2147483648) && (j != -2147483648))
        {
          localFloatingScreenParams.setFloatingCenterX(i);
          localFloatingScreenParams.setFloatingCenterY(j);
        }
        paramContext = this.mWrapperFactory.a(paramContext, FloatingVideoWrapper.CLASS_NAME);
        if (paramContext == null) {
          return 3;
        }
        i = paramContext.a(localFloatingScreenParams, paramView);
        if (i == 0) {
          FloatingScreenReporter.b(paramInt);
        }
        return i;
      }
      finally {}
    }
    return 2;
  }
  
  public int enterLocationFloatingScreen(Context paramContext, View paramView, FloatingScreenParams paramFloatingScreenParams, String paramString)
  {
    if ((paramContext != null) && (paramView != null)) {
      try
      {
        boolean bool = FloatingScreenPermission.checkPermission(paramContext);
        if (!bool) {
          return 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FloatingScreenManager", 2, new Object[] { "enterLocationFloatingScreen:", paramView.toString() });
        }
        FloatingScreenParams localFloatingScreenParams = paramFloatingScreenParams;
        if (paramFloatingScreenParams == null) {
          localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setShapeType(1).setCanZoom(false).build();
        }
        paramContext = this.mWrapperFactory.a(paramContext, paramString);
        if (paramContext == null) {
          return 3;
        }
        paramContext.a(localFloatingScreenParams);
        int i = paramContext.a(localFloatingScreenParams, paramView);
        return i;
      }
      finally {}
    }
    return 2;
  }
  
  public int enterWatchTogetherFloatingScreen(Context paramContext, View paramView, FloatingScreenParams paramFloatingScreenParams, String paramString)
  {
    if ((paramContext != null) && (paramView != null)) {
      try
      {
        boolean bool = FloatingScreenPermission.checkPermission(paramContext);
        if (!bool) {
          return 1;
        }
        if (!MobileQQ.sMobileQQ.getQQProcessName().endsWith(":tool"))
        {
          QQToast.makeText(paramContext, 2131897821, 0).show();
          return -1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FloatingScreenManager", 2, new Object[] { "enterLocationFloatingScreen:", paramView.toString() });
        }
        FloatingScreenParams localFloatingScreenParams = paramFloatingScreenParams;
        if (paramFloatingScreenParams == null) {
          localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setShapeType(1).setCanZoom(false).build();
        }
        paramContext = this.mWrapperFactory.a(paramContext, paramString);
        if (paramContext == null) {
          return 3;
        }
        paramContext.a(localFloatingScreenParams);
        int i = paramContext.a(localFloatingScreenParams, paramView);
        return i;
      }
      finally {}
    }
    return 2;
  }
  
  public FloatingBaseProxyWrapper getFloatingProxyWrapper(Context paramContext, String paramString)
  {
    return this.mWrapperFactory.a(paramContext, paramString);
  }
  
  public void quitFloatingScreen()
  {
    FloatingBaseProxyWrapper localFloatingBaseProxyWrapper = this.mWrapperFactory.a(null, FloatingVideoWrapper.CLASS_NAME);
    if (localFloatingBaseProxyWrapper != null)
    {
      localFloatingBaseProxyWrapper.a(4);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FloatingScreenManager", 2, "quitFloatingScreen Fail, wrapper is null");
    }
  }
  
  public void quitFloatingScreen(String paramString)
  {
    paramString = this.mWrapperFactory.a(null, paramString);
    if (paramString != null) {
      paramString.a(4);
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
    FloatingBaseProxyWrapper localFloatingBaseProxyWrapper = this.mWrapperFactory.a(null, FloatingVideoWrapper.CLASS_NAME);
    if (localFloatingBaseProxyWrapper != null) {
      return localFloatingBaseProxyWrapper.a(paramIVideoInnerStatusListener);
    }
    return null;
  }
  
  public IVideoOuterStatusListener setFloatingVideoListener(IVideoInnerStatusListener paramIVideoInnerStatusListener, String paramString)
  {
    paramString = this.mWrapperFactory.a(null, paramString);
    if (paramString != null) {
      return paramString.a(paramIVideoInnerStatusListener);
    }
    return null;
  }
  
  @Deprecated
  public void setFullScreenListener(IFullScreenEnterListener paramIFullScreenEnterListener)
  {
    FloatingBaseProxyWrapper localFloatingBaseProxyWrapper = this.mWrapperFactory.a(null, FloatingVideoWrapper.CLASS_NAME);
    if (localFloatingBaseProxyWrapper != null) {
      localFloatingBaseProxyWrapper.a(paramIFullScreenEnterListener);
    }
  }
  
  public void setFullScreenViewClickListener(IFullScreenViewClickListener paramIFullScreenViewClickListener)
  {
    FloatingBaseProxyWrapper localFloatingBaseProxyWrapper = this.mWrapperFactory.a(null, FloatingVideoWrapper.CLASS_NAME);
    if (localFloatingBaseProxyWrapper != null) {
      localFloatingBaseProxyWrapper.a(paramIFullScreenViewClickListener);
    }
  }
  
  public void setWindowClickListener(String paramString, IWindowClickListener paramIWindowClickListener)
  {
    paramString = this.mWrapperFactory.a(null, paramString);
    if (paramString != null) {
      paramString.a(paramIWindowClickListener);
    }
  }
  
  public void updateFloatingWindowLocation(int paramInt1, int paramInt2, String paramString)
  {
    paramString = this.mWrapperFactory.a(null, paramString);
    if (paramString != null) {
      paramString.b(paramInt1, paramInt2);
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
      paramString.b(paramInt);
    }
  }
  
  public void updateFloatingWindowSize(int paramInt1, int paramInt2, String paramString)
  {
    paramString = this.mWrapperFactory.a(null, paramString);
    if (paramString != null) {
      paramString.c(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.QQFloatingWindowImpl
 * JD-Core Version:    0.7.0.1
 */