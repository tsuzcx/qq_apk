package com.tencent.qcircle.shadow.core.runtime;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.KeyEvent.Callback;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.qcircle.shadow.core.runtime.qcircle.container.HostActivityDelegator;
import com.tencent.qcircle.shadow.core.runtime.skin.entity.SkinItem;
import com.tencent.qcircle.shadow.core.runtime.skin.listener.ISkinUpdate;
import com.tencent.qcircle.shadow.core.runtime.skin.loader.SkinManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class PluginActivity
  extends ShadowContext
  implements KeyEvent.Callback, Window.Callback, ISkinUpdate
{
  private static final String TAG = "PluginActivity";
  HostActivityDelegator mHostActivityDelegator;
  ShadowApplication mPluginApplication;
  
  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    return this.mHostActivityDelegator.superDispatchGenericMotionEvent(paramMotionEvent);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4))
    {
      HostActivityDelegator localHostActivityDelegator = this.mHostActivityDelegator;
      if ((localHostActivityDelegator instanceof Activity))
      {
        ((Activity)localHostActivityDelegator).onBackPressed();
        return true;
      }
    }
    return this.mHostActivityDelegator.superDispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    return this.mHostActivityDelegator.superDispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return this.mHostActivityDelegator.superDispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.mHostActivityDelegator.superDispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent)
  {
    return this.mHostActivityDelegator.superDispatchTrackballEvent(paramMotionEvent);
  }
  
  public void finish()
  {
    this.mHostActivityDelegator.superFinish();
  }
  
  public HostActivityDelegator getHostActivityDelegator()
  {
    return this.mHostActivityDelegator;
  }
  
  public LayoutInflater getLayoutInflater()
  {
    return ShadowLayoutInflater.build(this.mHostActivityDelegator.getWindow().getLayoutInflater(), this, this.mPartKey, this.mSkinMap);
  }
  
  public boolean isChangingConfigurations()
  {
    return this.mHostActivityDelegator.superIsChangingConfigurations();
  }
  
  public boolean moveTaskToBack(boolean paramBoolean)
  {
    return this.mHostActivityDelegator.superMoveTaskToBack(paramBoolean);
  }
  
  public void onActionModeFinished(ActionMode paramActionMode)
  {
    this.mHostActivityDelegator.superOnActionModeFinished(paramActionMode);
  }
  
  public void onActionModeStarted(ActionMode paramActionMode)
  {
    this.mHostActivityDelegator.superOnActionModeStarted(paramActionMode);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mHostActivityDelegator.superOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onApplyThemeResource(Resources.Theme paramTheme, int paramInt, boolean paramBoolean) {}
  
  public void onAttachFragment(Fragment paramFragment)
  {
    this.mHostActivityDelegator.superOnAttachFragment(paramFragment);
  }
  
  public void onAttachedToWindow()
  {
    this.mHostActivityDelegator.superOnAttachedToWindow();
  }
  
  public void onBackPressed()
  {
    this.mHostActivityDelegator.superOnBackPressed();
  }
  
  public void onChildTitleChanged(Activity paramActivity, CharSequence paramCharSequence)
  {
    this.mHostActivityDelegator.superOnChildTitleChanged(paramActivity, paramCharSequence);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.mHostActivityDelegator.superOnConfigurationChanged(paramConfiguration);
  }
  
  public void onContentChanged()
  {
    this.mHostActivityDelegator.superOnContentChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mHostActivityDelegator.superOnCreate(paramBundle);
    SkinManager.getsInstance().attach(this);
  }
  
  public CharSequence onCreateDescription()
  {
    return this.mHostActivityDelegator.superOnCreateDescription();
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    return this.mHostActivityDelegator.superOnCreateDialog(paramInt);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return this.mHostActivityDelegator.superOnCreateOptionsMenu(paramMenu);
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if (paramInt == 0) {
      return onCreateOptionsMenu(paramMenu);
    }
    return this.mHostActivityDelegator.superOnCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View onCreatePanelView(int paramInt)
  {
    return this.mHostActivityDelegator.superOnCreatePanelView(paramInt);
  }
  
  public boolean onCreateThumbnail(Bitmap paramBitmap, Canvas paramCanvas)
  {
    return this.mHostActivityDelegator.superOnCreateThumbnail(paramBitmap, paramCanvas);
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.mHostActivityDelegator.superOnCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.mHostActivityDelegator.superOnCreateView(paramString, paramContext, paramAttributeSet);
  }
  
  public void onDestroy()
  {
    this.mHostActivityDelegator.superOnDestroy();
    SkinManager.getsInstance().detach(this);
    this.mSkinMap.clear();
  }
  
  public void onDetachedFromWindow()
  {
    this.mHostActivityDelegator.superOnDetachedFromWindow();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.mHostActivityDelegator.superOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyLongPress(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.mHostActivityDelegator.superOnKeyLongPress(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    return this.mHostActivityDelegator.superOnKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.mHostActivityDelegator.superOnKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onLowMemory()
  {
    this.mHostActivityDelegator.superOnLowMemory();
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    return this.mHostActivityDelegator.superOnMenuItemSelected(paramInt, paramMenuItem);
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return this.mHostActivityDelegator.superOnMenuOpened(paramInt, paramMenu);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    this.mHostActivityDelegator.superOnMultiWindowModeChanged(paramBoolean);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean, Configuration paramConfiguration)
  {
    this.mHostActivityDelegator.superOnMultiWindowModeChanged(paramBoolean, paramConfiguration);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    this.mHostActivityDelegator.superOnNewIntent(paramIntent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return this.mHostActivityDelegator.superOnOptionsItemSelected(paramMenuItem);
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    this.mHostActivityDelegator.superOnPanelClosed(paramInt, paramMenu);
  }
  
  public void onPause()
  {
    this.mHostActivityDelegator.superOnPause();
  }
  
  public void onPointerCaptureChanged(boolean paramBoolean)
  {
    this.mHostActivityDelegator.superOnPointerCaptureChanged(paramBoolean);
  }
  
  public void onPostCreate(Bundle paramBundle)
  {
    this.mHostActivityDelegator.superOnPostCreate(paramBundle);
  }
  
  public void onPostResume()
  {
    this.mHostActivityDelegator.superOnPostResume();
  }
  
  public void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    this.mHostActivityDelegator.superOnPrepareDialog(paramInt, paramDialog);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    return this.mHostActivityDelegator.superOnPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt)
  {
    this.mHostActivityDelegator.superOnProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.mHostActivityDelegator.superOnRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onRestart()
  {
    this.mHostActivityDelegator.superOnRestart();
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    this.mHostActivityDelegator.superOnRestoreInstanceState(paramBundle);
  }
  
  public void onResume()
  {
    this.mHostActivityDelegator.superOnResume();
  }
  
  public Object onRetainNonConfigurationInstance()
  {
    return this.mHostActivityDelegator.superOnRetainNonConfigurationInstance();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    this.mHostActivityDelegator.superOnSaveInstanceState(paramBundle);
  }
  
  public boolean onSearchRequested()
  {
    return this.mHostActivityDelegator.superOnSearchRequested();
  }
  
  public boolean onSearchRequested(SearchEvent paramSearchEvent)
  {
    return this.mHostActivityDelegator.superOnSearchRequested(paramSearchEvent);
  }
  
  public void onStart()
  {
    this.mHostActivityDelegator.superOnStart();
  }
  
  public void onStop()
  {
    this.mHostActivityDelegator.superOnStop();
  }
  
  public void onThemeUpdate()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onThemeUpdate: ");
    ((StringBuilder)localObject).append(this.mSkinMap.size());
    Log.d("PluginActivity", ((StringBuilder)localObject).toString());
    if (this.mSkinMap.isEmpty()) {
      return;
    }
    localObject = this.mSkinMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((SkinItem)((Iterator)localObject).next()).apply();
    }
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    return this.mHostActivityDelegator.superOnTrackballEvent(paramMotionEvent);
  }
  
  public void onUserInteraction()
  {
    this.mHostActivityDelegator.superOnUserInteraction();
  }
  
  public void onUserLeaveHint()
  {
    this.mHostActivityDelegator.superOnUserLeaveHint();
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    this.mHostActivityDelegator.superOnWindowAttributesChanged(paramLayoutParams);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    this.mHostActivityDelegator.superOnWindowFocusChanged(paramBoolean);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    return this.mHostActivityDelegator.superOnWindowStartingActionMode(paramCallback);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
  {
    return this.mHostActivityDelegator.superOnWindowStartingActionMode(paramCallback, paramInt);
  }
  
  public void recreate()
  {
    this.mHostActivityDelegator.recreate();
  }
  
  public void setHostActivityDelegator(HostActivityDelegator paramHostActivityDelegator)
  {
    this.mHostActivityDelegator = paramHostActivityDelegator;
  }
  
  public final void setHostContextAsBase(Context paramContext)
  {
    attachBaseContext(paramContext);
  }
  
  public void setPluginApplication(ShadowApplication paramShadowApplication)
  {
    this.mPluginApplication = paramShadowApplication;
  }
  
  public void startActivityFromChild(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    this.mHostActivityDelegator.superStartActivityFromChild(paramActivity, paramIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.PluginActivity
 * JD-Core Version:    0.7.0.1
 */