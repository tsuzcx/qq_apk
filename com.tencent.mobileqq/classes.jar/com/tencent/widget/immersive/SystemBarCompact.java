package com.tencent.widget.immersive;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.view.Window;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;

public class SystemBarCompact
{
  public boolean isStatusBarVisible = true;
  public boolean mDrawStatus = true;
  public boolean mInited;
  private int mPendingStatusBarColor;
  public int mStatusBarColor = 0;
  public Drawable mStatusBarDarwable;
  private SystemBarTintManager mTintManager;
  private Window mWindow;
  
  public SystemBarCompact(Activity paramActivity, boolean paramBoolean, int paramInt)
  {
    this.mWindow = paramActivity.getWindow();
    this.mDrawStatus = paramBoolean;
    this.mPendingStatusBarColor = paramInt;
  }
  
  public SystemBarCompact(Dialog paramDialog, boolean paramBoolean, int paramInt)
  {
    this.mWindow = paramDialog.getWindow();
    this.mDrawStatus = paramBoolean;
    this.mPendingStatusBarColor = paramInt;
  }
  
  private void ensureTintManager()
  {
    if (this.mTintManager == null) {
      this.mTintManager = new SystemBarTintManager(this.mWindow, this.mDrawStatus);
    }
  }
  
  @TargetApi(19)
  public void init()
  {
    if (this.mInited) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("systembar", 2, "mChatBarComp init()");
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      ensureTintManager();
      this.mTintManager.setStatusBarTintEnabled(this.mDrawStatus);
    }
    Drawable localDrawable = this.mStatusBarDarwable;
    if (localDrawable != null) {
      setStatusBarDrawable(localDrawable);
    } else {
      setStatusBarColor(this.mPendingStatusBarColor);
    }
    this.isStatusBarVisible = true;
    this.mInited = true;
  }
  
  @TargetApi(19)
  public void setStatusBarColor(int paramInt)
  {
    this.mStatusBarColor = paramInt;
    if ((this.mTintManager != null) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      this.mTintManager.setStatusBarTintColor(paramInt);
    }
  }
  
  @TargetApi(19)
  public void setStatusBarDarkMode(boolean paramBoolean)
  {
    if (ImmersiveUtils.supportStatusBarDarkMode())
    {
      if (!QQTheme.b()) {
        paramBoolean = false;
      }
      ImmersiveUtils.setStatusBarDarkMode(this.mWindow, paramBoolean);
    }
  }
  
  public void setStatusBarDrawable(Drawable paramDrawable)
  {
    this.mStatusBarDarwable = paramDrawable;
    if ((this.mTintManager != null) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      this.mTintManager.setStatusBarTintDrawable(paramDrawable);
    }
  }
  
  public void setStatusBarMask(ColorFilter paramColorFilter)
  {
    this.mTintManager.setColorFilter(paramColorFilter);
  }
  
  public void setStatusBarVisible(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setStatusBarVisible=");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("status", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 == 0) {
      this.isStatusBarVisible = true;
    } else {
      this.isStatusBarVisible = false;
    }
    Object localObject = this.mTintManager;
    if (localObject != null) {
      ((SystemBarTintManager)localObject).setStatusBarVisible(paramInt1, paramInt2);
    }
  }
  
  public void setStatusColor(int paramInt)
  {
    this.mPendingStatusBarColor = paramInt;
  }
  
  public void setStatusDrawable(Drawable paramDrawable)
  {
    this.mStatusBarDarwable = paramDrawable;
  }
  
  public void setgetStatusBarVisible(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setgetStatusBarVisible=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("status", 2, ((StringBuilder)localObject).toString());
    }
    this.isStatusBarVisible = paramBoolean;
    Object localObject = this.mTintManager;
    if (localObject != null) {
      ((SystemBarTintManager)localObject).setStatusBarVisible(paramBoolean, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.immersive.SystemBarCompact
 * JD-Core Version:    0.7.0.1
 */