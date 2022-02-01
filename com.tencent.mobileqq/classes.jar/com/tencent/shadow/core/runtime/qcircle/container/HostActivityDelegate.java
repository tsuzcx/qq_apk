package com.tencent.shadow.core.runtime.qcircle.container;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager.LayoutParams;

public abstract interface HostActivityDelegate
{
  public abstract boolean dispatchKeyEvent(KeyEvent paramKeyEvent);
  
  public abstract void finish();
  
  public abstract ComponentName getCallingActivity();
  
  public abstract ClassLoader getClassLoader();
  
  public abstract LayoutInflater getLayoutInflater();
  
  public abstract Object getPluginActivity();
  
  public abstract Resources getResources();
  
  public abstract boolean isChangingConfigurations();
  
  public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onApplyThemeResource(Resources.Theme paramTheme, int paramInt, boolean paramBoolean);
  
  public abstract void onAttachFragment(Fragment paramFragment);
  
  public abstract void onAttachedToWindow();
  
  public abstract void onBackPressed();
  
  public abstract void onChildTitleChanged(Activity paramActivity, CharSequence paramCharSequence);
  
  public abstract void onConfigurationChanged(Configuration paramConfiguration);
  
  public abstract void onContentChanged();
  
  public abstract void onCreate(Bundle paramBundle);
  
  public abstract CharSequence onCreateDescription();
  
  public abstract Dialog onCreateDialog(int paramInt);
  
  public abstract boolean onCreatePanelMenu(int paramInt, Menu paramMenu);
  
  public abstract View onCreatePanelView(int paramInt);
  
  public abstract boolean onCreateThumbnail(Bitmap paramBitmap, Canvas paramCanvas);
  
  public abstract View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet);
  
  public abstract View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet);
  
  public abstract void onDestroy();
  
  public abstract void onDetachedFromWindow();
  
  public abstract void onLowMemory();
  
  public abstract void onMultiWindowModeChanged(boolean paramBoolean);
  
  public abstract void onMultiWindowModeChanged(boolean paramBoolean, Configuration paramConfiguration);
  
  public abstract void onNewIntent(Intent paramIntent);
  
  public abstract void onPanelClosed(int paramInt, Menu paramMenu);
  
  public abstract void onPause();
  
  public abstract void onPostCreate(Bundle paramBundle);
  
  public abstract void onPostResume();
  
  public abstract void onPrepareDialog(int paramInt, Dialog paramDialog);
  
  public abstract boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu);
  
  public abstract void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  
  public abstract void onRestart();
  
  public abstract void onRestoreInstanceState(Bundle paramBundle);
  
  public abstract void onResume();
  
  public abstract Object onRetainNonConfigurationInstance();
  
  public abstract void onSaveInstanceState(Bundle paramBundle);
  
  public abstract void onStart();
  
  public abstract void onStop();
  
  public abstract boolean onTrackballEvent(MotionEvent paramMotionEvent);
  
  public abstract void onUserInteraction();
  
  public abstract void onUserLeaveHint();
  
  public abstract void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams);
  
  public abstract void onWindowFocusChanged(boolean paramBoolean);
  
  public abstract void recreate();
  
  public abstract void setDelegator(HostActivityDelegator paramHostActivityDelegator);
  
  public abstract void startActivityFromChild(Activity paramActivity, Intent paramIntent, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.qcircle.container.HostActivityDelegate
 * JD-Core Version:    0.7.0.1
 */