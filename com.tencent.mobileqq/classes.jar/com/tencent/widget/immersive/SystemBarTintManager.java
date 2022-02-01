package com.tencent.widget.immersive;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Method;

public class SystemBarTintManager
  implements Handler.Callback
{
  public static final int DEFAULT_TINT_COLOR = 255;
  public static final int MSG_GONE = 2;
  public static final int MSG_INVISIBLE = 1;
  public static final int MSG_VISIBLE = 0;
  private static final String NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME = "navigation_bar_height_landscape";
  private static final String NAV_BAR_HEIGHT_RES_NAME = "navigation_bar_height";
  private static final String NAV_BAR_WIDTH_RES_NAME = "navigation_bar_width";
  private static final String SHOW_NAV_BAR_RES_NAME = "config_showNavigationBar";
  public static boolean mInPortrait;
  private static int mhasNavBar = -1;
  private static String sNavBarOverride;
  private ColorFilter filter;
  private final SystemBarTintManager.SystemBarConfig mConfig;
  public Handler mHandler;
  private boolean mStatusBarAvailable;
  public boolean mStatusBarTintEnabled;
  public View mStatusBarTintView;
  
  static
  {
    if (VersionUtils.i()) {}
    try
    {
      Method localMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class });
      localMethod.setAccessible(true);
      sNavBarOverride = (String)localMethod.invoke(null, new Object[] { "qemu.hw.mainkeys" });
    }
    catch (Throwable localThrowable)
    {
      label54:
      break label54;
    }
    sNavBarOverride = null;
  }
  
  @TargetApi(19)
  public SystemBarTintManager(Window paramWindow, boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)paramWindow.getDecorView();
    int i = ImmersiveUtils.isSupporImmersive();
    boolean bool = true;
    if (i == 1) {
      this.mStatusBarAvailable = paramBoolean;
    }
    this.mConfig = new SystemBarTintManager.SystemBarConfig(paramWindow, this.mStatusBarAvailable, null);
    if (this.mStatusBarAvailable) {
      setupStatusBarView(paramWindow, localViewGroup);
    }
    this.mHandler = new Handler(Looper.getMainLooper(), this);
    if (paramWindow.getContext().getResources().getConfiguration().orientation == 1) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    mInPortrait = paramBoolean;
  }
  
  private static int getInternalDimensionSize(Resources paramResources, String paramString)
  {
    int i = paramResources.getIdentifier(paramString, "dimen", "android");
    if (i > 0) {
      return paramResources.getDimensionPixelSize(i);
    }
    return 0;
  }
  
  @TargetApi(14)
  public static int getNavigationBarHeight(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    if (Build.VERSION.SDK_INT >= 14)
    {
      if (mInPortrait) {
        paramContext = "navigation_bar_height";
      } else {
        paramContext = "navigation_bar_height_landscape";
      }
      return getInternalDimensionSize(localResources, paramContext);
    }
    return 0;
  }
  
  @TargetApi(14)
  public static boolean hasNavBar(Context paramContext)
  {
    int i = mhasNavBar;
    if (i != -1) {
      return i == 1;
    }
    Resources localResources = paramContext.getResources();
    i = localResources.getIdentifier("config_showNavigationBar", "bool", "android");
    if (i != 0)
    {
      bool = localResources.getBoolean(i);
      if (!"1".equals(sNavBarOverride))
      {
        if (!"0".equals(sNavBarOverride)) {
          break label97;
        }
        bool = true;
        break label97;
      }
    }
    else if (Build.VERSION.SDK_INT >= 14)
    {
      bool = ViewConfiguration.get(paramContext).hasPermanentMenuKey() ^ true;
      break label97;
    }
    boolean bool = false;
    label97:
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("hasNavbar=");
      paramContext.append(bool);
      QLog.d("XPanelContainer", 2, paramContext.toString());
    }
    if (bool)
    {
      mhasNavBar = 1;
      return bool;
    }
    mhasNavBar = 0;
    return bool;
  }
  
  public static void setLayerType(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT > 10) {
      paramView.setLayerType(0, null);
    }
  }
  
  private void setupStatusBarView(Window paramWindow, ViewGroup paramViewGroup)
  {
    this.mStatusBarTintView = new View(paramWindow.getContext());
    paramWindow = new FrameLayout.LayoutParams(-1, this.mConfig.getStatusBarHeight());
    paramWindow.gravity = 48;
    this.mStatusBarTintView.setLayoutParams(paramWindow);
    try
    {
      setLayerType(this.mStatusBarTintView);
    }
    catch (Exception paramWindow)
    {
      if (QLog.isColorLevel()) {
        QLog.d("setupStatusBarView", 2, paramWindow.toString());
      }
    }
    this.mStatusBarTintView.setVisibility(8);
    paramViewGroup.addView(this.mStatusBarTintView);
  }
  
  public SystemBarTintManager.SystemBarConfig getConfig()
  {
    return this.mConfig;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SystemBarTintManager=");
      localStringBuilder.append(paramMessage.what);
      QLog.d("status", 2, localStringBuilder.toString());
    }
    if (this.mStatusBarTintView == null) {
      return false;
    }
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return false;
        }
        this.mStatusBarTintView.setVisibility(8);
        return false;
      }
      this.mStatusBarTintView.setVisibility(4);
      return false;
    }
    this.mStatusBarTintView.setVisibility(0);
    return false;
  }
  
  public boolean isStatusBarTintEnabled()
  {
    return this.mStatusBarTintEnabled;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.filter = paramColorFilter;
    Drawable localDrawable = this.mStatusBarTintView.getBackground();
    if (localDrawable != null)
    {
      localDrawable.setColorFilter(paramColorFilter);
      localDrawable.invalidateSelf();
    }
  }
  
  @TargetApi(11)
  public void setStatusBarAlpha(float paramFloat)
  {
    if ((this.mStatusBarAvailable) && (Build.VERSION.SDK_INT >= 11))
    {
      this.mStatusBarTintView.setAlpha(paramFloat);
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillAfter(true);
    this.mStatusBarTintView.startAnimation(localAlphaAnimation);
  }
  
  public void setStatusBarTintColor(int paramInt)
  {
    if (this.mStatusBarAvailable)
    {
      this.mStatusBarTintView.setBackgroundColor(paramInt);
      if (this.mStatusBarTintView.getBackground() != null) {
        this.mStatusBarTintView.getBackground().setColorFilter(this.filter);
      }
    }
  }
  
  public void setStatusBarTintDrawable(Drawable paramDrawable)
  {
    if (this.mStatusBarAvailable)
    {
      if (paramDrawable != null) {
        paramDrawable.setColorFilter(this.filter);
      }
      this.mStatusBarTintView.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setStatusBarTintEnabled(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setStatusBarTintEnabled enabled = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("SystemBarTintManager", 2, ((StringBuilder)localObject).toString());
    }
    this.mStatusBarTintEnabled = paramBoolean;
    if (this.mStatusBarAvailable)
    {
      localObject = this.mStatusBarTintView;
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 4;
      }
      ((View)localObject).setVisibility(i);
    }
  }
  
  public void setStatusBarTintResource(int paramInt)
  {
    if (this.mStatusBarAvailable)
    {
      this.mStatusBarTintView.setBackgroundResource(paramInt);
      if (this.mStatusBarTintView.getBackground() != null) {
        this.mStatusBarTintView.getBackground().setColorFilter(this.filter);
      }
    }
  }
  
  public void setStatusBarVisible(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setStatusBarVisible=");
      localStringBuilder.append(paramInt1);
      QLog.d("status", 2, localStringBuilder.toString());
    }
    if (paramInt1 == 0) {
      this.mStatusBarTintEnabled = true;
    } else {
      this.mStatusBarTintEnabled = false;
    }
    this.mHandler.sendEmptyMessageDelayed(paramInt1, paramInt2);
  }
  
  public void setStatusBarVisible(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setStatusBarVisible=");
      localStringBuilder.append(paramBoolean);
      QLog.d("status", 2, localStringBuilder.toString());
    }
    this.mStatusBarTintEnabled = paramBoolean;
    if (paramBoolean)
    {
      this.mHandler.sendEmptyMessageDelayed(0, paramInt);
      return;
    }
    this.mHandler.sendEmptyMessageDelayed(1, paramInt);
  }
  
  public void setTintAlpha(float paramFloat)
  {
    setStatusBarAlpha(paramFloat);
  }
  
  public void setTintColor(int paramInt)
  {
    setStatusBarTintColor(paramInt);
  }
  
  public void setTintDrawable(Drawable paramDrawable)
  {
    setStatusBarTintDrawable(paramDrawable);
  }
  
  public void setTintResource(int paramInt)
  {
    setStatusBarTintResource(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.immersive.SystemBarTintManager
 * JD-Core Version:    0.7.0.1
 */