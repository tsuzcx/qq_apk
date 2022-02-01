package com.tencent.widget.immersive;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.view.Window;
import bkqv;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

public class SystemBarCompact
{
  public boolean isStatusBarVisible = true;
  public boolean mDrawStatus = true;
  public boolean mInited;
  private int mPendingStatusBarColor;
  public int mStatusBarColor = 0;
  public Drawable mStatusBarDarwable;
  private bkqv mTintManager;
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
      this.mTintManager = new bkqv(this.mWindow, this.mDrawStatus);
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
      this.mTintManager.a(this.mDrawStatus);
    }
    if (this.mStatusBarDarwable != null) {
      setStatusBarDrawable(this.mStatusBarDarwable);
    }
    for (;;)
    {
      this.isStatusBarVisible = true;
      this.mInited = true;
      return;
      setStatusBarColor(this.mPendingStatusBarColor);
    }
  }
  
  @TargetApi(19)
  public void setStatusBarColor(int paramInt)
  {
    this.mStatusBarColor = paramInt;
    if ((this.mTintManager != null) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      this.mTintManager.a(paramInt);
    }
  }
  
  @TargetApi(19)
  public void setStatusBarDarkMode(boolean paramBoolean)
  {
    if (ImmersiveUtils.a())
    {
      if (!ThemeUtil.isDefaultOrDIYTheme()) {
        paramBoolean = false;
      }
      ImmersiveUtils.a(this.mWindow, paramBoolean);
    }
  }
  
  public void setStatusBarDrawable(Drawable paramDrawable)
  {
    this.mStatusBarDarwable = paramDrawable;
    if ((this.mTintManager != null) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      this.mTintManager.a(paramDrawable);
    }
  }
  
  public void setStatusBarMask(ColorFilter paramColorFilter)
  {
    this.mTintManager.a(paramColorFilter);
  }
  
  public void setStatusBarVisible(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("status", 2, "setStatusBarVisible=" + paramInt1);
    }
    if (paramInt1 == 0) {}
    for (this.isStatusBarVisible = true;; this.isStatusBarVisible = false)
    {
      if (this.mTintManager != null) {
        this.mTintManager.a(paramInt1, paramInt2);
      }
      return;
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
    if (QLog.isColorLevel()) {
      QLog.i("status", 2, "setgetStatusBarVisible=" + paramBoolean);
    }
    this.isStatusBarVisible = paramBoolean;
    if (this.mTintManager != null) {
      this.mTintManager.a(paramBoolean, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.immersive.SystemBarCompact
 * JD-Core Version:    0.7.0.1
 */