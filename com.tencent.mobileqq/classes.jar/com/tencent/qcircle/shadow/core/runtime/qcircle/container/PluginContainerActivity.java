package com.tencent.qcircle.shadow.core.runtime.qcircle.container;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.app.Application;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.SharedElementCallback;
import android.app.TaskStackBuilder;
import android.app.VoiceInteractor;
import android.app.assist.AssistContent;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Display;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toolbar;
import com.tencent.qcircle.shadow.core.runtime.qcircle.reflect.DtVideoReportReflect;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

public class PluginContainerActivity
  extends Activity
  implements HostActivity, HostActivityDelegator
{
  private static final String TAG = "PluginContainerActivity";
  HostActivityDelegate hostActivityDelegate;
  private boolean isBeforeOnCreate = true;
  private Resources.Theme mHostTheme;
  
  public PluginContainerActivity()
  {
    Object localObject = DelegateProviderHolder.getDelegateProvider();
    if (localObject != null)
    {
      localObject = ((DelegateProvider)localObject).getHostActivityDelegate(getClass());
      ((HostActivityDelegate)localObject).setDelegator(this);
    }
    else
    {
      Log.e("PluginContainerActivity", "PluginContainerActivity: DelegateProviderHolder没有初始化");
      localObject = null;
    }
    this.hostActivityDelegate = ((HostActivityDelegate)localObject);
  }
  
  private boolean isIllegalIntent(Bundle paramBundle)
  {
    Bundle localBundle2 = getIntent().getExtras();
    boolean bool = true;
    if ((localBundle2 == null) && (paramBundle == null)) {
      return true;
    }
    Bundle localBundle1 = paramBundle;
    if (paramBundle == null) {
      localBundle1 = localBundle2;
    }
    try
    {
      paramBundle = localBundle1.getString("LOADER_VERSION");
      long l1 = localBundle1.getLong("PROCESS_ID_KEY");
      if ("2.0.12".equals(paramBundle))
      {
        long l2 = DelegateProviderHolder.sCustomPid;
        if (l1 != l2) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    catch (Throwable paramBundle) {}
    return true;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null) {
      return localHostActivityDelegate.dispatchKeyEvent(paramKeyEvent);
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void finish()
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.finish();
      return;
    }
    super.finish();
  }
  
  public ComponentName getCallingActivity()
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null) {
      return localHostActivityDelegate.getCallingActivity();
    }
    return super.getCallingActivity();
  }
  
  public ClassLoader getClassLoader()
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null) {
      return localHostActivityDelegate.getClassLoader();
    }
    return super.getClassLoader();
  }
  
  public HostActivity getHostActivity()
  {
    return this;
  }
  
  public Activity getImplementActivity()
  {
    return this;
  }
  
  public Window getImplementWindow()
  {
    return getWindow();
  }
  
  public LayoutInflater getLayoutInflater()
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null) {
      return localHostActivityDelegate.getLayoutInflater();
    }
    return super.getLayoutInflater();
  }
  
  public final Object getPluginActivity()
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null) {
      return localHostActivityDelegate.getPluginActivity();
    }
    return new PluginContainerActivity.1(this);
  }
  
  public Resources getResources()
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null) {
      return localHostActivityDelegate.getResources();
    }
    return super.getResources();
  }
  
  public Resources.Theme getTheme()
  {
    if (this.isBeforeOnCreate)
    {
      if (this.mHostTheme == null) {
        this.mHostTheme = super.getResources().newTheme();
      }
      return this.mHostTheme;
    }
    return super.getTheme();
  }
  
  public boolean isChangingConfigurations()
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null) {
      return localHostActivityDelegate.isChangingConfigurations();
    }
    return super.isChangingConfigurations();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onApplyThemeResource(Resources.Theme paramTheme, int paramInt, boolean paramBoolean)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.onApplyThemeResource(paramTheme, paramInt, paramBoolean);
      return;
    }
    super.onApplyThemeResource(paramTheme, paramInt, paramBoolean);
  }
  
  public void onAttachFragment(Fragment paramFragment)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null) {
      localHostActivityDelegate.onAttachFragment(paramFragment);
    }
  }
  
  public void onAttachedToWindow()
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null) {
      localHostActivityDelegate.onAttachedToWindow();
    }
  }
  
  public void onBackPressed()
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.onBackPressed();
      return;
    }
    super.onBackPressed();
  }
  
  protected void onChildTitleChanged(Activity paramActivity, CharSequence paramCharSequence)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.onChildTitleChanged(paramActivity, paramCharSequence);
      return;
    }
    super.onChildTitleChanged(paramActivity, paramCharSequence);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null) {
      localHostActivityDelegate.onConfigurationChanged(paramConfiguration);
    } else {
      super.onConfigurationChanged(paramConfiguration);
    }
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onContentChanged()
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.onContentChanged();
      return;
    }
    super.onContentChanged();
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    this.isBeforeOnCreate = false;
    this.mHostTheme = null;
    if (isIllegalIntent(paramBundle))
    {
      this.hostActivityDelegate = null;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("illegalIntent savedInstanceState==");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append(" getIntent().getExtras()==");
      ((StringBuilder)localObject).append(getIntent().getExtras());
      Log.e("PluginContainerActivity", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.hostActivityDelegate;
    if (localObject != null)
    {
      ((HostActivityDelegate)localObject).onCreate(paramBundle);
      DtVideoReportReflect.g().invokeAddToDetectionWhitelist(this);
      return;
    }
    super.onCreate(null);
    Log.e("PluginContainerActivity", "onCreate: hostActivityDelegate==null finish activity");
    finish();
    System.exit(0);
  }
  
  public CharSequence onCreateDescription()
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null) {
      return localHostActivityDelegate.onCreateDescription();
    }
    return super.onCreateDescription();
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null) {
      return localHostActivityDelegate.onCreateDialog(paramInt);
    }
    return super.onCreateDialog(paramInt);
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null) {
      return localHostActivityDelegate.onCreatePanelMenu(paramInt, paramMenu);
    }
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View onCreatePanelView(int paramInt)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null) {
      return localHostActivityDelegate.onCreatePanelView(paramInt);
    }
    return super.onCreatePanelView(paramInt);
  }
  
  public boolean onCreateThumbnail(Bitmap paramBitmap, Canvas paramCanvas)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null) {
      return localHostActivityDelegate.onCreateThumbnail(paramBitmap, paramCanvas);
    }
    return super.onCreateThumbnail(paramBitmap, paramCanvas);
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null) {
      return localHostActivityDelegate.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
    }
    return super.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null) {
      return localHostActivityDelegate.onCreateView(paramString, paramContext, paramAttributeSet);
    }
    return super.onCreateView(paramString, paramContext, paramAttributeSet);
  }
  
  protected void onDestroy()
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.onDestroy();
      return;
    }
    super.onDestroy();
  }
  
  public void onDetachedFromWindow()
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null) {
      localHostActivityDelegate.onDetachedFromWindow();
    }
  }
  
  public void onLowMemory()
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.onLowMemory();
      return;
    }
    super.onLowMemory();
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.onMultiWindowModeChanged(paramBoolean);
      return;
    }
    super.onMultiWindowModeChanged(paramBoolean);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean, Configuration paramConfiguration)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.onMultiWindowModeChanged(paramBoolean, paramConfiguration);
      return;
    }
    super.onMultiWindowModeChanged(paramBoolean, paramConfiguration);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.onNewIntent(paramIntent);
      return;
    }
    super.onNewIntent(paramIntent);
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.onPanelClosed(paramInt, paramMenu);
      return;
    }
    super.onPanelClosed(paramInt, paramMenu);
  }
  
  protected void onPause()
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.onPause();
      return;
    }
    super.onPause();
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.onPostCreate(paramBundle);
      return;
    }
    super.onPostCreate(paramBundle);
  }
  
  protected void onPostResume()
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.onPostResume();
      return;
    }
    super.onPostResume();
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.onPrepareDialog(paramInt, paramDialog);
      return;
    }
    super.onPrepareDialog(paramInt, paramDialog);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null) {
      return localHostActivityDelegate.onPreparePanel(paramInt, paramView, paramMenu);
    }
    return super.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      return;
    }
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  protected void onRestart()
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.onRestart();
      return;
    }
    super.onRestart();
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.onRestoreInstanceState(paramBundle);
      return;
    }
    super.onRestoreInstanceState(paramBundle);
  }
  
  protected void onResume()
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.onResume();
      return;
    }
    super.onResume();
  }
  
  public Object onRetainNonConfigurationInstance()
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null) {
      return localHostActivityDelegate.onRetainNonConfigurationInstance();
    }
    return super.onRetainNonConfigurationInstance();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null) {
      localHostActivityDelegate.onSaveInstanceState(paramBundle);
    } else {
      super.onSaveInstanceState(paramBundle);
    }
    paramBundle.putString("LOADER_VERSION", "2.0.12");
    paramBundle.putLong("PROCESS_ID_KEY", DelegateProviderHolder.sCustomPid);
  }
  
  protected void onStart()
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.onStart();
      return;
    }
    super.onStart();
  }
  
  protected void onStop()
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.onStop();
      return;
    }
    super.onStop();
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null) {
      return localHostActivityDelegate.onTrackballEvent(paramMotionEvent);
    }
    return super.onTrackballEvent(paramMotionEvent);
  }
  
  public void onUserInteraction()
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.onUserInteraction();
      return;
    }
    super.onUserInteraction();
  }
  
  protected void onUserLeaveHint()
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.onUserLeaveHint();
      return;
    }
    super.onUserLeaveHint();
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.onWindowAttributesChanged(paramLayoutParams);
      return;
    }
    super.onWindowAttributesChanged(paramLayoutParams);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.onWindowFocusChanged(paramBoolean);
      return;
    }
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public void recreate()
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.recreate();
      return;
    }
    super.recreate();
  }
  
  public void setTheme(int paramInt)
  {
    if (!this.isBeforeOnCreate) {
      super.setTheme(paramInt);
    }
  }
  
  public void startActivityFromChild(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    HostActivityDelegate localHostActivityDelegate = this.hostActivityDelegate;
    if (localHostActivityDelegate != null)
    {
      localHostActivityDelegate.startActivityFromChild(paramActivity, paramIntent, paramInt);
      return;
    }
    super.startActivityFromChild(paramActivity, paramIntent, paramInt);
  }
  
  public void superAddContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addContentView(paramView, paramLayoutParams);
  }
  
  @TargetApi(17)
  public void superApplyOverrideConfiguration(Configuration paramConfiguration)
  {
    super.applyOverrideConfiguration(paramConfiguration);
  }
  
  public void superAttachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
  }
  
  public boolean superBindService(Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    return super.bindService(paramIntent, paramServiceConnection, paramInt);
  }
  
  public int superCheckCallingOrSelfPermission(String paramString)
  {
    return super.checkCallingOrSelfPermission(paramString);
  }
  
  public int superCheckCallingOrSelfUriPermission(Uri paramUri, int paramInt)
  {
    return super.checkCallingOrSelfUriPermission(paramUri, paramInt);
  }
  
  public int superCheckCallingPermission(String paramString)
  {
    return super.checkCallingPermission(paramString);
  }
  
  public int superCheckCallingUriPermission(Uri paramUri, int paramInt)
  {
    return super.checkCallingUriPermission(paramUri, paramInt);
  }
  
  public int superCheckPermission(String paramString, int paramInt1, int paramInt2)
  {
    return super.checkPermission(paramString, paramInt1, paramInt2);
  }
  
  @TargetApi(23)
  public int superCheckSelfPermission(String paramString)
  {
    return super.checkSelfPermission(paramString);
  }
  
  public int superCheckUriPermission(Uri paramUri, int paramInt1, int paramInt2, int paramInt3)
  {
    return super.checkUriPermission(paramUri, paramInt1, paramInt2, paramInt3);
  }
  
  public int superCheckUriPermission(Uri paramUri, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    return super.checkUriPermission(paramUri, paramString1, paramString2, paramInt1, paramInt2, paramInt3);
  }
  
  public void superClearWallpaper() {}
  
  public void superCloseContextMenu()
  {
    super.closeContextMenu();
  }
  
  public void superCloseOptionsMenu()
  {
    super.closeOptionsMenu();
  }
  
  @TargetApi(17)
  public Context superCreateConfigurationContext(Configuration paramConfiguration)
  {
    return super.createConfigurationContext(paramConfiguration);
  }
  
  @TargetApi(26)
  public Context superCreateContextForSplit(String paramString)
  {
    return super.createContextForSplit(paramString);
  }
  
  @TargetApi(24)
  public Context superCreateDeviceProtectedStorageContext()
  {
    return super.createDeviceProtectedStorageContext();
  }
  
  @TargetApi(17)
  public Context superCreateDisplayContext(Display paramDisplay)
  {
    return super.createDisplayContext(paramDisplay);
  }
  
  public Context superCreatePackageContext(String paramString, int paramInt)
  {
    return super.createPackageContext(paramString, paramInt);
  }
  
  public PendingIntent superCreatePendingResult(int paramInt1, Intent paramIntent, int paramInt2)
  {
    return super.createPendingResult(paramInt1, paramIntent, paramInt2);
  }
  
  public String[] superDatabaseList()
  {
    return super.databaseList();
  }
  
  public boolean superDeleteDatabase(String paramString)
  {
    return super.deleteDatabase(paramString);
  }
  
  public boolean superDeleteFile(String paramString)
  {
    return super.deleteFile(paramString);
  }
  
  @TargetApi(24)
  public boolean superDeleteSharedPreferences(String paramString)
  {
    return super.deleteSharedPreferences(paramString);
  }
  
  public void superDismissDialog(int paramInt)
  {
    super.dismissDialog(paramInt);
  }
  
  @TargetApi(24)
  public void superDismissKeyboardShortcutsHelper()
  {
    super.dismissKeyboardShortcutsHelper();
  }
  
  public boolean superDispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchGenericMotionEvent(paramMotionEvent);
  }
  
  public boolean superDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean superDispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    return super.dispatchKeyShortcutEvent(paramKeyEvent);
  }
  
  public boolean superDispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
  }
  
  public boolean superDispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean superDispatchTrackballEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTrackballEvent(paramMotionEvent);
  }
  
  public void superDump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public void superEnforceCallingOrSelfPermission(String paramString1, String paramString2)
  {
    super.enforceCallingOrSelfPermission(paramString1, paramString2);
  }
  
  public void superEnforceCallingOrSelfUriPermission(Uri paramUri, int paramInt, String paramString)
  {
    super.enforceCallingOrSelfUriPermission(paramUri, paramInt, paramString);
  }
  
  public void superEnforceCallingPermission(String paramString1, String paramString2)
  {
    super.enforceCallingPermission(paramString1, paramString2);
  }
  
  public void superEnforceCallingUriPermission(Uri paramUri, int paramInt, String paramString)
  {
    super.enforceCallingUriPermission(paramUri, paramInt, paramString);
  }
  
  public void superEnforcePermission(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    super.enforcePermission(paramString1, paramInt1, paramInt2, paramString2);
  }
  
  public void superEnforceUriPermission(Uri paramUri, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    super.enforceUriPermission(paramUri, paramInt1, paramInt2, paramInt3, paramString);
  }
  
  public void superEnforceUriPermission(Uri paramUri, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    super.enforceUriPermission(paramUri, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3);
  }
  
  @TargetApi(24)
  public void superEnterPictureInPictureMode()
  {
    super.enterPictureInPictureMode();
  }
  
  @TargetApi(26)
  public boolean superEnterPictureInPictureMode(PictureInPictureParams paramPictureInPictureParams)
  {
    return super.enterPictureInPictureMode(paramPictureInPictureParams);
  }
  
  public String[] superFileList()
  {
    return super.fileList();
  }
  
  public <T extends View> T superFindViewById(int paramInt)
  {
    return super.findViewById(paramInt);
  }
  
  public void superFinish()
  {
    super.finish();
  }
  
  public void superFinishActivity(int paramInt)
  {
    super.finishActivity(paramInt);
  }
  
  public void superFinishActivityFromChild(Activity paramActivity, int paramInt)
  {
    super.finishActivityFromChild(paramActivity, paramInt);
  }
  
  @TargetApi(16)
  public void superFinishAffinity()
  {
    super.finishAffinity();
  }
  
  @TargetApi(21)
  public void superFinishAfterTransition()
  {
    super.finishAfterTransition();
  }
  
  @TargetApi(21)
  public void superFinishAndRemoveTask()
  {
    super.finishAndRemoveTask();
  }
  
  public void superFinishFromChild(Activity paramActivity)
  {
    super.finishFromChild(paramActivity);
  }
  
  public ActionBar superGetActionBar()
  {
    return super.getActionBar();
  }
  
  public Application superGetApplication()
  {
    return super.getApplication();
  }
  
  public Context superGetApplicationContext()
  {
    return super.getApplicationContext();
  }
  
  public ApplicationInfo superGetApplicationInfo()
  {
    return super.getApplicationInfo();
  }
  
  public AssetManager superGetAssets()
  {
    return super.getAssets();
  }
  
  public Context superGetBaseContext()
  {
    return super.getBaseContext();
  }
  
  public File superGetCacheDir()
  {
    return super.getCacheDir();
  }
  
  public ComponentName superGetCallingActivity()
  {
    return super.getCallingActivity();
  }
  
  public String superGetCallingPackage()
  {
    return super.getCallingPackage();
  }
  
  public int superGetChangingConfigurations()
  {
    return super.getChangingConfigurations();
  }
  
  public ClassLoader superGetClassLoader()
  {
    return super.getClassLoader();
  }
  
  @TargetApi(21)
  public File superGetCodeCacheDir()
  {
    return super.getCodeCacheDir();
  }
  
  public ComponentName superGetComponentName()
  {
    return super.getComponentName();
  }
  
  public ContentResolver superGetContentResolver()
  {
    return super.getContentResolver();
  }
  
  @TargetApi(21)
  public Scene superGetContentScene()
  {
    return super.getContentScene();
  }
  
  @TargetApi(21)
  public TransitionManager superGetContentTransitionManager()
  {
    return super.getContentTransitionManager();
  }
  
  public View superGetCurrentFocus()
  {
    return super.getCurrentFocus();
  }
  
  @TargetApi(24)
  public File superGetDataDir()
  {
    return super.getDataDir();
  }
  
  public File superGetDatabasePath(String paramString)
  {
    return super.getDatabasePath(paramString);
  }
  
  public File superGetDir(String paramString, int paramInt)
  {
    return super.getDir(paramString, paramInt);
  }
  
  public File superGetExternalCacheDir()
  {
    return super.getExternalCacheDir();
  }
  
  @TargetApi(19)
  public File[] superGetExternalCacheDirs()
  {
    return super.getExternalCacheDirs();
  }
  
  public File superGetExternalFilesDir(String paramString)
  {
    return super.getExternalFilesDir(paramString);
  }
  
  @TargetApi(19)
  public File[] superGetExternalFilesDirs(String paramString)
  {
    return super.getExternalFilesDirs(paramString);
  }
  
  @TargetApi(21)
  public File[] superGetExternalMediaDirs()
  {
    return super.getExternalMediaDirs();
  }
  
  public File superGetFileStreamPath(String paramString)
  {
    return super.getFileStreamPath(paramString);
  }
  
  public File superGetFilesDir()
  {
    return super.getFilesDir();
  }
  
  public FragmentManager superGetFragmentManager()
  {
    return super.getFragmentManager();
  }
  
  public Intent superGetIntent()
  {
    return super.getIntent();
  }
  
  public Object superGetLastNonConfigurationInstance()
  {
    return super.getLastNonConfigurationInstance();
  }
  
  public LayoutInflater superGetLayoutInflater()
  {
    return super.getLayoutInflater();
  }
  
  public LoaderManager superGetLoaderManager()
  {
    return super.getLoaderManager();
  }
  
  public String superGetLocalClassName()
  {
    return super.getLocalClassName();
  }
  
  public Looper superGetMainLooper()
  {
    return super.getMainLooper();
  }
  
  @TargetApi(26)
  public int superGetMaxNumPictureInPictureActions()
  {
    return super.getMaxNumPictureInPictureActions();
  }
  
  @TargetApi(21)
  public MediaController superGetMediaController()
  {
    return super.getMediaController();
  }
  
  public MenuInflater superGetMenuInflater()
  {
    return super.getMenuInflater();
  }
  
  @TargetApi(21)
  public File superGetNoBackupFilesDir()
  {
    return super.getNoBackupFilesDir();
  }
  
  public File superGetObbDir()
  {
    return super.getObbDir();
  }
  
  @TargetApi(19)
  public File[] superGetObbDirs()
  {
    return super.getObbDirs();
  }
  
  public String superGetPackageCodePath()
  {
    return super.getPackageCodePath();
  }
  
  public PackageManager superGetPackageManager()
  {
    return super.getPackageManager();
  }
  
  public String superGetPackageName()
  {
    return super.getPackageName();
  }
  
  public String superGetPackageResourcePath()
  {
    return super.getPackageResourcePath();
  }
  
  public Activity superGetParent()
  {
    return super.getParent();
  }
  
  @TargetApi(16)
  public Intent superGetParentActivityIntent()
  {
    return super.getParentActivityIntent();
  }
  
  public SharedPreferences superGetPreferences(int paramInt)
  {
    return super.getPreferences(paramInt);
  }
  
  @TargetApi(22)
  public Uri superGetReferrer()
  {
    return super.getReferrer();
  }
  
  public int superGetRequestedOrientation()
  {
    return super.getRequestedOrientation();
  }
  
  public Resources superGetResources()
  {
    return super.getResources();
  }
  
  @TargetApi(23)
  public SearchEvent superGetSearchEvent()
  {
    return super.getSearchEvent();
  }
  
  public SharedPreferences superGetSharedPreferences(String paramString, int paramInt)
  {
    return super.getSharedPreferences(paramString, paramInt);
  }
  
  public Object superGetSystemService(String paramString)
  {
    return super.getSystemService(paramString);
  }
  
  @TargetApi(23)
  public String superGetSystemServiceName(Class<?> paramClass)
  {
    return super.getSystemServiceName(paramClass);
  }
  
  public int superGetTaskId()
  {
    return super.getTaskId();
  }
  
  public Resources.Theme superGetTheme()
  {
    return super.getTheme();
  }
  
  public CharSequence superGetTitle()
  {
    return super.getTitle();
  }
  
  public int superGetTitleColor()
  {
    return super.getTitleColor();
  }
  
  @TargetApi(23)
  public VoiceInteractor superGetVoiceInteractor()
  {
    return super.getVoiceInteractor();
  }
  
  public int superGetVolumeControlStream()
  {
    return super.getVolumeControlStream();
  }
  
  public Drawable superGetWallpaper()
  {
    return super.getWallpaper();
  }
  
  public int superGetWallpaperDesiredMinimumHeight()
  {
    return super.getWallpaperDesiredMinimumHeight();
  }
  
  public int superGetWallpaperDesiredMinimumWidth()
  {
    return super.getWallpaperDesiredMinimumWidth();
  }
  
  public Window superGetWindow()
  {
    return super.getWindow();
  }
  
  public WindowManager superGetWindowManager()
  {
    return super.getWindowManager();
  }
  
  public void superGrantUriPermission(String paramString, Uri paramUri, int paramInt)
  {
    super.grantUriPermission(paramString, paramUri, paramInt);
  }
  
  public boolean superHasWindowFocus()
  {
    return super.hasWindowFocus();
  }
  
  public void superInvalidateOptionsMenu()
  {
    super.invalidateOptionsMenu();
  }
  
  @TargetApi(26)
  public boolean superIsActivityTransitionRunning()
  {
    return super.isActivityTransitionRunning();
  }
  
  public boolean superIsChangingConfigurations()
  {
    return super.isChangingConfigurations();
  }
  
  public boolean superIsChild()
  {
    return super.isChild();
  }
  
  @TargetApi(17)
  public boolean superIsDestroyed()
  {
    return super.isDestroyed();
  }
  
  @TargetApi(24)
  public boolean superIsDeviceProtectedStorage()
  {
    return super.isDeviceProtectedStorage();
  }
  
  public boolean superIsFinishing()
  {
    return super.isFinishing();
  }
  
  @TargetApi(18)
  public boolean superIsImmersive()
  {
    return super.isImmersive();
  }
  
  @TargetApi(24)
  public boolean superIsInMultiWindowMode()
  {
    return super.isInMultiWindowMode();
  }
  
  @TargetApi(24)
  public boolean superIsInPictureInPictureMode()
  {
    return super.isInPictureInPictureMode();
  }
  
  @TargetApi(24)
  public boolean superIsLocalVoiceInteractionSupported()
  {
    return super.isLocalVoiceInteractionSupported();
  }
  
  public boolean superIsRestricted()
  {
    return super.isRestricted();
  }
  
  public boolean superIsTaskRoot()
  {
    return super.isTaskRoot();
  }
  
  @TargetApi(23)
  public boolean superIsVoiceInteraction()
  {
    return super.isVoiceInteraction();
  }
  
  @TargetApi(23)
  public boolean superIsVoiceInteractionRoot()
  {
    return super.isVoiceInteractionRoot();
  }
  
  @TargetApi(24)
  public boolean superMoveDatabaseFrom(Context paramContext, String paramString)
  {
    return super.moveDatabaseFrom(paramContext, paramString);
  }
  
  @TargetApi(24)
  public boolean superMoveSharedPreferencesFrom(Context paramContext, String paramString)
  {
    return super.moveSharedPreferencesFrom(paramContext, paramString);
  }
  
  public boolean superMoveTaskToBack(boolean paramBoolean)
  {
    return super.moveTaskToBack(paramBoolean);
  }
  
  @TargetApi(16)
  public boolean superNavigateUpTo(Intent paramIntent)
  {
    return super.navigateUpTo(paramIntent);
  }
  
  @TargetApi(16)
  public boolean superNavigateUpToFromChild(Activity paramActivity, Intent paramIntent)
  {
    return super.navigateUpToFromChild(paramActivity, paramIntent);
  }
  
  public void superOnActionModeFinished(ActionMode paramActionMode)
  {
    super.onActionModeFinished(paramActionMode);
  }
  
  public void superOnActionModeStarted(ActionMode paramActionMode)
  {
    super.onActionModeStarted(paramActionMode);
  }
  
  @TargetApi(21)
  public void superOnActivityReenter(int paramInt, Intent paramIntent)
  {
    super.onActivityReenter(paramInt, paramIntent);
  }
  
  public void superOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void superOnApplyThemeResource(Resources.Theme paramTheme, int paramInt, boolean paramBoolean)
  {
    super.onApplyThemeResource(paramTheme, paramInt, paramBoolean);
  }
  
  public void superOnAttachFragment(Fragment paramFragment)
  {
    super.onAttachFragment(paramFragment);
  }
  
  public void superOnAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  public void superOnBackPressed()
  {
    super.onBackPressed();
  }
  
  public void superOnChildTitleChanged(Activity paramActivity, CharSequence paramCharSequence)
  {
    super.onChildTitleChanged(paramActivity, paramCharSequence);
  }
  
  public void superOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void superOnContentChanged()
  {
    super.onContentChanged();
  }
  
  public boolean superOnContextItemSelected(MenuItem paramMenuItem)
  {
    return super.onContextItemSelected(paramMenuItem);
  }
  
  public void superOnContextMenuClosed(Menu paramMenu)
  {
    super.onContextMenuClosed(paramMenu);
  }
  
  public void superOnCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  @TargetApi(21)
  public void superOnCreate(Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    super.onCreate(paramBundle, paramPersistableBundle);
  }
  
  public void superOnCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public CharSequence superOnCreateDescription()
  {
    return super.onCreateDescription();
  }
  
  public Dialog superOnCreateDialog(int paramInt)
  {
    return super.onCreateDialog(paramInt);
  }
  
  public Dialog superOnCreateDialog(int paramInt, Bundle paramBundle)
  {
    return super.onCreateDialog(paramInt, paramBundle);
  }
  
  @TargetApi(16)
  public void superOnCreateNavigateUpTaskStack(TaskStackBuilder paramTaskStackBuilder)
  {
    super.onCreateNavigateUpTaskStack(paramTaskStackBuilder);
  }
  
  public boolean superOnCreateOptionsMenu(Menu paramMenu)
  {
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean superOnCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View superOnCreatePanelView(int paramInt)
  {
    return super.onCreatePanelView(paramInt);
  }
  
  public boolean superOnCreateThumbnail(Bitmap paramBitmap, Canvas paramCanvas)
  {
    return super.onCreateThumbnail(paramBitmap, paramCanvas);
  }
  
  public View superOnCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return super.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public View superOnCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return super.onCreateView(paramString, paramContext, paramAttributeSet);
  }
  
  public void superOnDestroy()
  {
    super.onDestroy();
  }
  
  public void superOnDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  @TargetApi(21)
  public void superOnEnterAnimationComplete()
  {
    super.onEnterAnimationComplete();
  }
  
  public boolean superOnGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    return super.onGenericMotionEvent(paramMotionEvent);
  }
  
  public boolean superOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean superOnKeyLongPress(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyLongPress(paramInt, paramKeyEvent);
  }
  
  public boolean superOnKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    return super.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
  }
  
  public boolean superOnKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyShortcut(paramInt, paramKeyEvent);
  }
  
  public boolean superOnKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  @TargetApi(24)
  public void superOnLocalVoiceInteractionStarted()
  {
    super.onLocalVoiceInteractionStarted();
  }
  
  @TargetApi(24)
  public void superOnLocalVoiceInteractionStopped()
  {
    super.onLocalVoiceInteractionStopped();
  }
  
  public void superOnLowMemory()
  {
    super.onLowMemory();
  }
  
  public boolean superOnMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    return super.onMenuItemSelected(paramInt, paramMenuItem);
  }
  
  public boolean superOnMenuOpened(int paramInt, Menu paramMenu)
  {
    return super.onMenuOpened(paramInt, paramMenu);
  }
  
  @TargetApi(24)
  public void superOnMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
  }
  
  @TargetApi(26)
  public void superOnMultiWindowModeChanged(boolean paramBoolean, Configuration paramConfiguration)
  {
    super.onMultiWindowModeChanged(paramBoolean, paramConfiguration);
  }
  
  @TargetApi(16)
  public boolean superOnNavigateUp()
  {
    return super.onNavigateUp();
  }
  
  @TargetApi(16)
  public boolean superOnNavigateUpFromChild(Activity paramActivity)
  {
    return super.onNavigateUpFromChild(paramActivity);
  }
  
  public void superOnNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
  }
  
  public boolean superOnOptionsItemSelected(MenuItem paramMenuItem)
  {
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void superOnOptionsMenuClosed(Menu paramMenu)
  {
    super.onOptionsMenuClosed(paramMenu);
  }
  
  public void superOnPanelClosed(int paramInt, Menu paramMenu)
  {
    super.onPanelClosed(paramInt, paramMenu);
  }
  
  public void superOnPause()
  {
    super.onPause();
  }
  
  @TargetApi(24)
  public void superOnPictureInPictureModeChanged(boolean paramBoolean)
  {
    super.onPictureInPictureModeChanged(paramBoolean);
  }
  
  @TargetApi(26)
  public void superOnPictureInPictureModeChanged(boolean paramBoolean, Configuration paramConfiguration)
  {
    super.onPictureInPictureModeChanged(paramBoolean, paramConfiguration);
  }
  
  @TargetApi(26)
  public void superOnPointerCaptureChanged(boolean paramBoolean)
  {
    super.onPointerCaptureChanged(paramBoolean);
  }
  
  public void superOnPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
  }
  
  @TargetApi(21)
  public void superOnPostCreate(Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    super.onPostCreate(paramBundle, paramPersistableBundle);
  }
  
  public void superOnPostResume()
  {
    super.onPostResume();
  }
  
  public void superOnPrepareDialog(int paramInt, Dialog paramDialog)
  {
    super.onPrepareDialog(paramInt, paramDialog);
  }
  
  public void superOnPrepareDialog(int paramInt, Dialog paramDialog, Bundle paramBundle)
  {
    super.onPrepareDialog(paramInt, paramDialog, paramBundle);
  }
  
  @TargetApi(16)
  public void superOnPrepareNavigateUpTaskStack(TaskStackBuilder paramTaskStackBuilder)
  {
    super.onPrepareNavigateUpTaskStack(paramTaskStackBuilder);
  }
  
  public boolean superOnPrepareOptionsMenu(Menu paramMenu)
  {
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  public boolean superOnPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    return super.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  @TargetApi(23)
  public void superOnProvideAssistContent(AssistContent paramAssistContent)
  {
    super.onProvideAssistContent(paramAssistContent);
  }
  
  @TargetApi(18)
  public void superOnProvideAssistData(Bundle paramBundle)
  {
    super.onProvideAssistData(paramBundle);
  }
  
  @TargetApi(24)
  public void superOnProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt)
  {
    super.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
  }
  
  @TargetApi(23)
  public Uri superOnProvideReferrer()
  {
    return super.onProvideReferrer();
  }
  
  @TargetApi(23)
  public void superOnRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void superOnRestart()
  {
    super.onRestart();
  }
  
  public void superOnRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
  }
  
  @TargetApi(21)
  public void superOnRestoreInstanceState(Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    super.onRestoreInstanceState(paramBundle, paramPersistableBundle);
  }
  
  public void superOnResume()
  {
    super.onResume();
  }
  
  public Object superOnRetainNonConfigurationInstance()
  {
    return super.onRetainNonConfigurationInstance();
  }
  
  public void superOnSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
  }
  
  @TargetApi(21)
  public void superOnSaveInstanceState(Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    super.onSaveInstanceState(paramBundle, paramPersistableBundle);
  }
  
  public boolean superOnSearchRequested()
  {
    return super.onSearchRequested();
  }
  
  @TargetApi(23)
  public boolean superOnSearchRequested(SearchEvent paramSearchEvent)
  {
    return super.onSearchRequested(paramSearchEvent);
  }
  
  public void superOnStart()
  {
    super.onStart();
  }
  
  @TargetApi(23)
  public void superOnStateNotSaved()
  {
    super.onStateNotSaved();
  }
  
  public void superOnStop()
  {
    super.onStop();
  }
  
  public void superOnTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    super.onTitleChanged(paramCharSequence, paramInt);
  }
  
  public boolean superOnTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean superOnTrackballEvent(MotionEvent paramMotionEvent)
  {
    return super.onTrackballEvent(paramMotionEvent);
  }
  
  public void superOnTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
  }
  
  public void superOnUserInteraction()
  {
    super.onUserInteraction();
  }
  
  public void superOnUserLeaveHint()
  {
    super.onUserLeaveHint();
  }
  
  @TargetApi(21)
  public void superOnVisibleBehindCanceled()
  {
    super.onVisibleBehindCanceled();
  }
  
  public void superOnWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    super.onWindowAttributesChanged(paramLayoutParams);
  }
  
  public void superOnWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public ActionMode superOnWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    return super.onWindowStartingActionMode(paramCallback);
  }
  
  @TargetApi(23)
  public ActionMode superOnWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
  {
    return super.onWindowStartingActionMode(paramCallback, paramInt);
  }
  
  public void superOpenContextMenu(View paramView)
  {
    super.openContextMenu(paramView);
  }
  
  public FileInputStream superOpenFileInput(String paramString)
  {
    return super.openFileInput(paramString);
  }
  
  public FileOutputStream superOpenFileOutput(String paramString, int paramInt)
  {
    return super.openFileOutput(paramString, paramInt);
  }
  
  public void superOpenOptionsMenu()
  {
    super.openOptionsMenu();
  }
  
  public SQLiteDatabase superOpenOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    return super.openOrCreateDatabase(paramString, paramInt, paramCursorFactory);
  }
  
  public SQLiteDatabase superOpenOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return super.openOrCreateDatabase(paramString, paramInt, paramCursorFactory, paramDatabaseErrorHandler);
  }
  
  public void superOverridePendingTransition(int paramInt1, int paramInt2)
  {
    super.overridePendingTransition(paramInt1, paramInt2);
  }
  
  public Drawable superPeekWallpaper()
  {
    return super.peekWallpaper();
  }
  
  @TargetApi(21)
  public void superPostponeEnterTransition()
  {
    super.postponeEnterTransition();
  }
  
  public void superRecreate()
  {
    super.recreate();
  }
  
  public void superRegisterComponentCallbacks(ComponentCallbacks paramComponentCallbacks)
  {
    super.registerComponentCallbacks(paramComponentCallbacks);
  }
  
  public void superRegisterForContextMenu(View paramView)
  {
    super.registerForContextMenu(paramView);
  }
  
  public Intent superRegisterReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    return super.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
  }
  
  @TargetApi(26)
  public Intent superRegisterReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, int paramInt)
  {
    return super.registerReceiver(paramBroadcastReceiver, paramIntentFilter, paramInt);
  }
  
  public Intent superRegisterReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, String paramString, Handler paramHandler)
  {
    return super.registerReceiver(paramBroadcastReceiver, paramIntentFilter, paramString, paramHandler);
  }
  
  @TargetApi(26)
  public Intent superRegisterReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, String paramString, Handler paramHandler, int paramInt)
  {
    return super.registerReceiver(paramBroadcastReceiver, paramIntentFilter, paramString, paramHandler, paramInt);
  }
  
  @TargetApi(21)
  public boolean superReleaseInstance()
  {
    return super.releaseInstance();
  }
  
  public void superRemoveDialog(int paramInt)
  {
    super.removeDialog(paramInt);
  }
  
  @SuppressLint({"MissingPermission"})
  public void superRemoveStickyBroadcast(Intent paramIntent)
  {
    super.removeStickyBroadcast(paramIntent);
  }
  
  @SuppressLint({"MissingPermission"})
  @TargetApi(17)
  public void superRemoveStickyBroadcastAsUser(Intent paramIntent, UserHandle paramUserHandle)
  {
    super.removeStickyBroadcastAsUser(paramIntent, paramUserHandle);
  }
  
  @TargetApi(19)
  public void superReportFullyDrawn()
  {
    super.reportFullyDrawn();
  }
  
  @TargetApi(24)
  public DragAndDropPermissions superRequestDragAndDropPermissions(DragEvent paramDragEvent)
  {
    return super.requestDragAndDropPermissions(paramDragEvent);
  }
  
  public void superRequestPermissions(String[] paramArrayOfString, int paramInt) {}
  
  @TargetApi(24)
  public void superRequestShowKeyboardShortcuts()
  {
    super.requestShowKeyboardShortcuts();
  }
  
  @TargetApi(21)
  public boolean superRequestVisibleBehind(boolean paramBoolean)
  {
    return super.requestVisibleBehind(paramBoolean);
  }
  
  public boolean superRequestWindowFeature(int paramInt)
  {
    return super.requestWindowFeature(paramInt);
  }
  
  public void superRevokeUriPermission(Uri paramUri, int paramInt)
  {
    super.revokeUriPermission(paramUri, paramInt);
  }
  
  @TargetApi(26)
  public void superRevokeUriPermission(String paramString, Uri paramUri, int paramInt)
  {
    super.revokeUriPermission(paramString, paramUri, paramInt);
  }
  
  public void superRunOnUiThread(Runnable paramRunnable)
  {
    super.runOnUiThread(paramRunnable);
  }
  
  public void superSendBroadcast(Intent paramIntent)
  {
    super.sendBroadcast(paramIntent);
  }
  
  public void superSendBroadcast(Intent paramIntent, String paramString)
  {
    super.sendBroadcast(paramIntent, paramString);
  }
  
  @SuppressLint({"MissingPermission"})
  @TargetApi(17)
  public void superSendBroadcastAsUser(Intent paramIntent, UserHandle paramUserHandle)
  {
    super.sendBroadcastAsUser(paramIntent, paramUserHandle);
  }
  
  @SuppressLint({"MissingPermission"})
  @TargetApi(17)
  public void superSendBroadcastAsUser(Intent paramIntent, UserHandle paramUserHandle, String paramString)
  {
    super.sendBroadcastAsUser(paramIntent, paramUserHandle, paramString);
  }
  
  public void superSendOrderedBroadcast(Intent paramIntent, String paramString)
  {
    super.sendOrderedBroadcast(paramIntent, paramString);
  }
  
  public void superSendOrderedBroadcast(Intent paramIntent, String paramString1, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString2, Bundle paramBundle)
  {
    super.sendOrderedBroadcast(paramIntent, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
  }
  
  public void superSendOrderedBroadcastAsUser(Intent paramIntent, UserHandle paramUserHandle, String paramString1, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString2, Bundle paramBundle) {}
  
  @SuppressLint({"MissingPermission"})
  public void superSendStickyBroadcast(Intent paramIntent)
  {
    super.sendStickyBroadcast(paramIntent);
  }
  
  @SuppressLint({"MissingPermission"})
  @TargetApi(17)
  public void superSendStickyBroadcastAsUser(Intent paramIntent, UserHandle paramUserHandle)
  {
    super.sendStickyBroadcastAsUser(paramIntent, paramUserHandle);
  }
  
  @SuppressLint({"MissingPermission"})
  public void superSendStickyOrderedBroadcast(Intent paramIntent, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString, Bundle paramBundle)
  {
    super.sendStickyOrderedBroadcast(paramIntent, paramBroadcastReceiver, paramHandler, paramInt, paramString, paramBundle);
  }
  
  @SuppressLint({"MissingPermission"})
  @TargetApi(17)
  public void superSendStickyOrderedBroadcastAsUser(Intent paramIntent, UserHandle paramUserHandle, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString, Bundle paramBundle)
  {
    super.sendStickyOrderedBroadcastAsUser(paramIntent, paramUserHandle, paramBroadcastReceiver, paramHandler, paramInt, paramString, paramBundle);
  }
  
  @TargetApi(21)
  public void superSetActionBar(Toolbar paramToolbar)
  {
    super.setActionBar(paramToolbar);
  }
  
  @TargetApi(21)
  public void superSetContentTransitionManager(TransitionManager paramTransitionManager)
  {
    super.setContentTransitionManager(paramTransitionManager);
  }
  
  public void superSetContentView(int paramInt)
  {
    super.setContentView(paramInt);
  }
  
  public void superSetContentView(View paramView)
  {
    super.setContentView(paramView);
  }
  
  public void superSetContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(paramView, paramLayoutParams);
  }
  
  public void superSetDefaultKeyMode(int paramInt)
  {
    super.setDefaultKeyMode(paramInt);
  }
  
  @TargetApi(21)
  public void superSetEnterSharedElementCallback(SharedElementCallback paramSharedElementCallback)
  {
    super.setEnterSharedElementCallback(paramSharedElementCallback);
  }
  
  @TargetApi(21)
  public void superSetExitSharedElementCallback(SharedElementCallback paramSharedElementCallback)
  {
    super.setExitSharedElementCallback(paramSharedElementCallback);
  }
  
  public void superSetFeatureDrawable(int paramInt, Drawable paramDrawable)
  {
    super.setFeatureDrawable(paramInt, paramDrawable);
  }
  
  public void superSetFeatureDrawableAlpha(int paramInt1, int paramInt2)
  {
    super.setFeatureDrawableAlpha(paramInt1, paramInt2);
  }
  
  public void superSetFeatureDrawableResource(int paramInt1, int paramInt2)
  {
    super.setFeatureDrawableResource(paramInt1, paramInt2);
  }
  
  public void superSetFeatureDrawableUri(int paramInt, Uri paramUri)
  {
    super.setFeatureDrawableUri(paramInt, paramUri);
  }
  
  public void superSetFinishOnTouchOutside(boolean paramBoolean)
  {
    super.setFinishOnTouchOutside(paramBoolean);
  }
  
  @TargetApi(18)
  public void superSetImmersive(boolean paramBoolean)
  {
    super.setImmersive(paramBoolean);
  }
  
  public void superSetIntent(Intent paramIntent)
  {
    super.setIntent(paramIntent);
  }
  
  @TargetApi(21)
  public void superSetMediaController(MediaController paramMediaController)
  {
    super.setMediaController(paramMediaController);
  }
  
  @TargetApi(26)
  public void superSetPictureInPictureParams(PictureInPictureParams paramPictureInPictureParams)
  {
    super.setPictureInPictureParams(paramPictureInPictureParams);
  }
  
  public void superSetProgress(int paramInt)
  {
    super.setProgress(paramInt);
  }
  
  public void superSetProgressBarIndeterminate(boolean paramBoolean)
  {
    super.setProgressBarIndeterminate(paramBoolean);
  }
  
  public void superSetProgressBarIndeterminateVisibility(boolean paramBoolean)
  {
    super.setProgressBarIndeterminateVisibility(paramBoolean);
  }
  
  public void superSetProgressBarVisibility(boolean paramBoolean)
  {
    super.setProgressBarVisibility(paramBoolean);
  }
  
  public void superSetRequestedOrientation(int paramInt)
  {
    super.setRequestedOrientation(paramInt);
  }
  
  public void superSetResult(int paramInt)
  {
    super.setResult(paramInt);
  }
  
  public void superSetResult(int paramInt, Intent paramIntent)
  {
    super.setResult(paramInt, paramIntent);
  }
  
  public void superSetSecondaryProgress(int paramInt)
  {
    super.setSecondaryProgress(paramInt);
  }
  
  @TargetApi(27)
  public void superSetShowWhenLocked(boolean paramBoolean)
  {
    super.setShowWhenLocked(paramBoolean);
  }
  
  @TargetApi(21)
  public void superSetTaskDescription(ActivityManager.TaskDescription paramTaskDescription)
  {
    super.setTaskDescription(paramTaskDescription);
  }
  
  public void superSetTheme(int paramInt)
  {
    super.setTheme(paramInt);
  }
  
  public void superSetTitle(int paramInt)
  {
    super.setTitle(paramInt);
  }
  
  public void superSetTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
  }
  
  public void superSetTitleColor(int paramInt)
  {
    super.setTitleColor(paramInt);
  }
  
  @TargetApi(27)
  public void superSetTurnScreenOn(boolean paramBoolean)
  {
    super.setTurnScreenOn(paramBoolean);
  }
  
  public void superSetVisible(boolean paramBoolean)
  {
    super.setVisible(paramBoolean);
  }
  
  public void superSetVolumeControlStream(int paramInt)
  {
    super.setVolumeControlStream(paramInt);
  }
  
  @TargetApi(24)
  public void superSetVrModeEnabled(boolean paramBoolean, ComponentName paramComponentName)
  {
    super.setVrModeEnabled(paramBoolean, paramComponentName);
  }
  
  public void superSetWallpaper(Bitmap paramBitmap) {}
  
  public void superSetWallpaper(InputStream paramInputStream) {}
  
  @TargetApi(23)
  public boolean superShouldShowRequestPermissionRationale(String paramString)
  {
    return super.shouldShowRequestPermissionRationale(paramString);
  }
  
  @TargetApi(16)
  public boolean superShouldUpRecreateTask(Intent paramIntent)
  {
    return super.shouldUpRecreateTask(paramIntent);
  }
  
  @TargetApi(23)
  public boolean superShowAssist(Bundle paramBundle)
  {
    return super.showAssist(paramBundle);
  }
  
  public void superShowDialog(int paramInt)
  {
    super.showDialog(paramInt);
  }
  
  public boolean superShowDialog(int paramInt, Bundle paramBundle)
  {
    return super.showDialog(paramInt, paramBundle);
  }
  
  @TargetApi(23)
  public void superShowLockTaskEscapeMessage()
  {
    super.showLockTaskEscapeMessage();
  }
  
  public ActionMode superStartActionMode(ActionMode.Callback paramCallback)
  {
    return super.startActionMode(paramCallback);
  }
  
  @TargetApi(23)
  public ActionMode superStartActionMode(ActionMode.Callback paramCallback, int paramInt)
  {
    return super.startActionMode(paramCallback, paramInt);
  }
  
  public void superStartActivities(Intent[] paramArrayOfIntent)
  {
    super.startActivities(paramArrayOfIntent);
  }
  
  @TargetApi(16)
  public void superStartActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    super.startActivities(paramArrayOfIntent, paramBundle);
  }
  
  public void superStartActivity(Intent paramIntent)
  {
    super.startActivity(paramIntent);
  }
  
  @TargetApi(16)
  public void superStartActivity(Intent paramIntent, Bundle paramBundle)
  {
    super.startActivity(paramIntent, paramBundle);
  }
  
  public void superStartActivityForResult(Intent paramIntent, int paramInt)
  {
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  @TargetApi(16)
  public void superStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public void superStartActivityFromChild(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    super.startActivityFromChild(paramActivity, paramIntent, paramInt);
  }
  
  @TargetApi(16)
  public void superStartActivityFromChild(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    super.startActivityFromChild(paramActivity, paramIntent, paramInt, paramBundle);
  }
  
  public void superStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    super.startActivityFromFragment(paramFragment, paramIntent, paramInt);
  }
  
  @TargetApi(16)
  public void superStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    super.startActivityFromFragment(paramFragment, paramIntent, paramInt, paramBundle);
  }
  
  public boolean superStartActivityIfNeeded(Intent paramIntent, int paramInt)
  {
    return super.startActivityIfNeeded(paramIntent, paramInt);
  }
  
  @TargetApi(16)
  public boolean superStartActivityIfNeeded(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    return super.startActivityIfNeeded(paramIntent, paramInt, paramBundle);
  }
  
  @TargetApi(26)
  public ComponentName superStartForegroundService(Intent paramIntent)
  {
    return super.startForegroundService(paramIntent);
  }
  
  public boolean superStartInstrumentation(ComponentName paramComponentName, String paramString, Bundle paramBundle)
  {
    return super.startInstrumentation(paramComponentName, paramString, paramBundle);
  }
  
  public void superStartIntentSender(IntentSender paramIntentSender, Intent paramIntent, int paramInt1, int paramInt2, int paramInt3)
  {
    super.startIntentSender(paramIntentSender, paramIntent, paramInt1, paramInt2, paramInt3);
  }
  
  @TargetApi(16)
  public void superStartIntentSender(IntentSender paramIntentSender, Intent paramIntent, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    super.startIntentSender(paramIntentSender, paramIntent, paramInt1, paramInt2, paramInt3, paramBundle);
  }
  
  public void superStartIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4)
  {
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
  }
  
  @TargetApi(16)
  public void superStartIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  public void superStartIntentSenderFromChild(Activity paramActivity, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4)
  {
    super.startIntentSenderFromChild(paramActivity, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
  }
  
  @TargetApi(16)
  public void superStartIntentSenderFromChild(Activity paramActivity, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    super.startIntentSenderFromChild(paramActivity, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  @TargetApi(24)
  public void superStartLocalVoiceInteraction(Bundle paramBundle)
  {
    super.startLocalVoiceInteraction(paramBundle);
  }
  
  @TargetApi(21)
  public void superStartLockTask()
  {
    super.startLockTask();
  }
  
  public void superStartManagingCursor(Cursor paramCursor)
  {
    super.startManagingCursor(paramCursor);
  }
  
  public boolean superStartNextMatchingActivity(Intent paramIntent)
  {
    return super.startNextMatchingActivity(paramIntent);
  }
  
  @TargetApi(16)
  public boolean superStartNextMatchingActivity(Intent paramIntent, Bundle paramBundle)
  {
    return super.startNextMatchingActivity(paramIntent, paramBundle);
  }
  
  @TargetApi(21)
  public void superStartPostponedEnterTransition()
  {
    super.startPostponedEnterTransition();
  }
  
  public void superStartSearch(String paramString, boolean paramBoolean1, Bundle paramBundle, boolean paramBoolean2)
  {
    super.startSearch(paramString, paramBoolean1, paramBundle, paramBoolean2);
  }
  
  public ComponentName superStartService(Intent paramIntent)
  {
    return super.startService(paramIntent);
  }
  
  @TargetApi(24)
  public void superStopLocalVoiceInteraction()
  {
    super.stopLocalVoiceInteraction();
  }
  
  @TargetApi(21)
  public void superStopLockTask()
  {
    super.stopLockTask();
  }
  
  public void superStopManagingCursor(Cursor paramCursor)
  {
    super.stopManagingCursor(paramCursor);
  }
  
  public boolean superStopService(Intent paramIntent)
  {
    return super.stopService(paramIntent);
  }
  
  public void superTakeKeyEvents(boolean paramBoolean)
  {
    super.takeKeyEvents(paramBoolean);
  }
  
  public void superTriggerSearch(String paramString, Bundle paramBundle)
  {
    super.triggerSearch(paramString, paramBundle);
  }
  
  public void superUnbindService(ServiceConnection paramServiceConnection)
  {
    super.unbindService(paramServiceConnection);
  }
  
  public void superUnregisterComponentCallbacks(ComponentCallbacks paramComponentCallbacks)
  {
    super.unregisterComponentCallbacks(paramComponentCallbacks);
  }
  
  public void superUnregisterForContextMenu(View paramView)
  {
    super.unregisterForContextMenu(paramView);
  }
  
  public void superUnregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    super.unregisterReceiver(paramBroadcastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.qcircle.container.PluginContainerActivity
 * JD-Core Version:    0.7.0.1
 */