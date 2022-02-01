package com.tencent.shadow.core.runtime.qcircle.container;

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
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

public abstract interface HostActivityDelegator
{
  public abstract void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract void applyOverrideConfiguration(Configuration paramConfiguration);
  
  public abstract boolean bindService(Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt);
  
  public abstract int checkCallingOrSelfPermission(String paramString);
  
  public abstract int checkCallingOrSelfUriPermission(Uri paramUri, int paramInt);
  
  public abstract int checkCallingPermission(String paramString);
  
  public abstract int checkCallingUriPermission(Uri paramUri, int paramInt);
  
  public abstract int checkPermission(String paramString, int paramInt1, int paramInt2);
  
  public abstract int checkSelfPermission(String paramString);
  
  public abstract int checkUriPermission(Uri paramUri, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int checkUriPermission(Uri paramUri, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void clearWallpaper();
  
  public abstract void closeContextMenu();
  
  public abstract void closeOptionsMenu();
  
  public abstract Context createConfigurationContext(Configuration paramConfiguration);
  
  public abstract Context createContextForSplit(String paramString);
  
  public abstract Context createDeviceProtectedStorageContext();
  
  public abstract Context createDisplayContext(Display paramDisplay);
  
  public abstract Context createPackageContext(String paramString, int paramInt);
  
  public abstract PendingIntent createPendingResult(int paramInt1, Intent paramIntent, int paramInt2);
  
  public abstract String[] databaseList();
  
  public abstract boolean deleteDatabase(String paramString);
  
  public abstract boolean deleteFile(String paramString);
  
  public abstract boolean deleteSharedPreferences(String paramString);
  
  public abstract void dismissDialog(int paramInt);
  
  public abstract void dismissKeyboardShortcutsHelper();
  
  public abstract boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent);
  
  public abstract boolean dispatchKeyEvent(KeyEvent paramKeyEvent);
  
  public abstract boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent);
  
  public abstract boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent);
  
  public abstract boolean dispatchTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract boolean dispatchTrackballEvent(MotionEvent paramMotionEvent);
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract void enforceCallingOrSelfPermission(String paramString1, String paramString2);
  
  public abstract void enforceCallingOrSelfUriPermission(Uri paramUri, int paramInt, String paramString);
  
  public abstract void enforceCallingPermission(String paramString1, String paramString2);
  
  public abstract void enforceCallingUriPermission(Uri paramUri, int paramInt, String paramString);
  
  public abstract void enforcePermission(String paramString1, int paramInt1, int paramInt2, String paramString2);
  
  public abstract void enforceUriPermission(Uri paramUri, int paramInt1, int paramInt2, int paramInt3, String paramString);
  
  public abstract void enforceUriPermission(Uri paramUri, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3);
  
  public abstract void enterPictureInPictureMode();
  
  public abstract boolean enterPictureInPictureMode(PictureInPictureParams paramPictureInPictureParams);
  
  public abstract String[] fileList();
  
  public abstract <T extends View> T findViewById(int paramInt);
  
  public abstract void finish();
  
  public abstract void finishActivity(int paramInt);
  
  public abstract void finishActivityFromChild(Activity paramActivity, int paramInt);
  
  public abstract void finishAffinity();
  
  public abstract void finishAfterTransition();
  
  public abstract void finishAndRemoveTask();
  
  public abstract void finishFromChild(Activity paramActivity);
  
  public abstract ActionBar getActionBar();
  
  public abstract Application getApplication();
  
  public abstract Context getApplicationContext();
  
  public abstract ApplicationInfo getApplicationInfo();
  
  public abstract AssetManager getAssets();
  
  public abstract Context getBaseContext();
  
  public abstract File getCacheDir();
  
  public abstract ComponentName getCallingActivity();
  
  public abstract String getCallingPackage();
  
  public abstract int getChangingConfigurations();
  
  public abstract ClassLoader getClassLoader();
  
  public abstract File getCodeCacheDir();
  
  public abstract ComponentName getComponentName();
  
  public abstract ContentResolver getContentResolver();
  
  public abstract Scene getContentScene();
  
  public abstract TransitionManager getContentTransitionManager();
  
  public abstract View getCurrentFocus();
  
  public abstract File getDataDir();
  
  public abstract File getDatabasePath(String paramString);
  
  public abstract File getDir(String paramString, int paramInt);
  
  public abstract File getExternalCacheDir();
  
  public abstract File[] getExternalCacheDirs();
  
  public abstract File getExternalFilesDir(String paramString);
  
  public abstract File[] getExternalFilesDirs(String paramString);
  
  public abstract File[] getExternalMediaDirs();
  
  public abstract File getFileStreamPath(String paramString);
  
  public abstract File getFilesDir();
  
  public abstract FragmentManager getFragmentManager();
  
  public abstract HostActivity getHostActivity();
  
  public abstract Intent getIntent();
  
  public abstract Object getLastNonConfigurationInstance();
  
  public abstract LayoutInflater getLayoutInflater();
  
  public abstract LoaderManager getLoaderManager();
  
  public abstract String getLocalClassName();
  
  public abstract Looper getMainLooper();
  
  public abstract int getMaxNumPictureInPictureActions();
  
  public abstract MediaController getMediaController();
  
  public abstract MenuInflater getMenuInflater();
  
  public abstract File getNoBackupFilesDir();
  
  public abstract File getObbDir();
  
  public abstract File[] getObbDirs();
  
  public abstract String getPackageCodePath();
  
  public abstract PackageManager getPackageManager();
  
  public abstract String getPackageName();
  
  public abstract String getPackageResourcePath();
  
  public abstract Activity getParent();
  
  public abstract Intent getParentActivityIntent();
  
  public abstract SharedPreferences getPreferences(int paramInt);
  
  public abstract Uri getReferrer();
  
  public abstract int getRequestedOrientation();
  
  public abstract Resources getResources();
  
  public abstract SearchEvent getSearchEvent();
  
  public abstract SharedPreferences getSharedPreferences(String paramString, int paramInt);
  
  public abstract Object getSystemService(String paramString);
  
  public abstract String getSystemServiceName(Class<?> paramClass);
  
  public abstract int getTaskId();
  
  public abstract Resources.Theme getTheme();
  
  public abstract CharSequence getTitle();
  
  public abstract int getTitleColor();
  
  public abstract VoiceInteractor getVoiceInteractor();
  
  public abstract int getVolumeControlStream();
  
  public abstract Drawable getWallpaper();
  
  public abstract int getWallpaperDesiredMinimumHeight();
  
  public abstract int getWallpaperDesiredMinimumWidth();
  
  public abstract Window getWindow();
  
  public abstract WindowManager getWindowManager();
  
  public abstract void grantUriPermission(String paramString, Uri paramUri, int paramInt);
  
  public abstract boolean hasWindowFocus();
  
  public abstract void invalidateOptionsMenu();
  
  public abstract boolean isActivityTransitionRunning();
  
  public abstract boolean isChangingConfigurations();
  
  public abstract boolean isChild();
  
  public abstract boolean isDestroyed();
  
  public abstract boolean isDeviceProtectedStorage();
  
  public abstract boolean isFinishing();
  
  public abstract boolean isImmersive();
  
  public abstract boolean isInMultiWindowMode();
  
  public abstract boolean isInPictureInPictureMode();
  
  public abstract boolean isLocalVoiceInteractionSupported();
  
  public abstract boolean isRestricted();
  
  public abstract boolean isTaskRoot();
  
  public abstract boolean isVoiceInteraction();
  
  public abstract boolean isVoiceInteractionRoot();
  
  public abstract Cursor managedQuery(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2);
  
  public abstract boolean moveDatabaseFrom(Context paramContext, String paramString);
  
  public abstract boolean moveSharedPreferencesFrom(Context paramContext, String paramString);
  
  public abstract boolean moveTaskToBack(boolean paramBoolean);
  
  public abstract boolean navigateUpTo(Intent paramIntent);
  
  public abstract boolean navigateUpToFromChild(Activity paramActivity, Intent paramIntent);
  
  public abstract void openContextMenu(View paramView);
  
  public abstract FileInputStream openFileInput(String paramString);
  
  public abstract FileOutputStream openFileOutput(String paramString, int paramInt);
  
  public abstract void openOptionsMenu();
  
  public abstract SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory);
  
  public abstract SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler);
  
  public abstract void overridePendingTransition(int paramInt1, int paramInt2);
  
  public abstract Drawable peekWallpaper();
  
  public abstract void postponeEnterTransition();
  
  public abstract void recreate();
  
  public abstract void registerComponentCallbacks(ComponentCallbacks paramComponentCallbacks);
  
  public abstract void registerForContextMenu(View paramView);
  
  public abstract Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter);
  
  public abstract Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, int paramInt);
  
  public abstract Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, String paramString, Handler paramHandler);
  
  public abstract Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, String paramString, Handler paramHandler, int paramInt);
  
  public abstract boolean releaseInstance();
  
  public abstract void removeDialog(int paramInt);
  
  public abstract void removeStickyBroadcast(Intent paramIntent);
  
  public abstract void removeStickyBroadcastAsUser(Intent paramIntent, UserHandle paramUserHandle);
  
  public abstract void reportFullyDrawn();
  
  public abstract DragAndDropPermissions requestDragAndDropPermissions(DragEvent paramDragEvent);
  
  public abstract void requestPermissions(String[] paramArrayOfString, int paramInt);
  
  public abstract void requestShowKeyboardShortcuts();
  
  public abstract boolean requestVisibleBehind(boolean paramBoolean);
  
  public abstract boolean requestWindowFeature(int paramInt);
  
  public abstract void revokeUriPermission(Uri paramUri, int paramInt);
  
  public abstract void revokeUriPermission(String paramString, Uri paramUri, int paramInt);
  
  public abstract void runOnUiThread(Runnable paramRunnable);
  
  public abstract void sendBroadcast(Intent paramIntent);
  
  public abstract void sendBroadcast(Intent paramIntent, String paramString);
  
  public abstract void sendBroadcastAsUser(Intent paramIntent, UserHandle paramUserHandle);
  
  public abstract void sendBroadcastAsUser(Intent paramIntent, UserHandle paramUserHandle, String paramString);
  
  public abstract void sendOrderedBroadcast(Intent paramIntent, String paramString);
  
  public abstract void sendOrderedBroadcast(Intent paramIntent, String paramString1, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString2, Bundle paramBundle);
  
  public abstract void sendOrderedBroadcastAsUser(Intent paramIntent, UserHandle paramUserHandle, String paramString1, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString2, Bundle paramBundle);
  
  public abstract void sendStickyBroadcast(Intent paramIntent);
  
  public abstract void sendStickyBroadcastAsUser(Intent paramIntent, UserHandle paramUserHandle);
  
  public abstract void sendStickyOrderedBroadcast(Intent paramIntent, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString, Bundle paramBundle);
  
  public abstract void sendStickyOrderedBroadcastAsUser(Intent paramIntent, UserHandle paramUserHandle, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString, Bundle paramBundle);
  
  public abstract void setActionBar(Toolbar paramToolbar);
  
  public abstract void setContentTransitionManager(TransitionManager paramTransitionManager);
  
  public abstract void setContentView(int paramInt);
  
  public abstract void setContentView(View paramView);
  
  public abstract void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract void setDefaultKeyMode(int paramInt);
  
  public abstract void setEnterSharedElementCallback(SharedElementCallback paramSharedElementCallback);
  
  public abstract void setExitSharedElementCallback(SharedElementCallback paramSharedElementCallback);
  
  public abstract void setFeatureDrawable(int paramInt, Drawable paramDrawable);
  
  public abstract void setFeatureDrawableAlpha(int paramInt1, int paramInt2);
  
  public abstract void setFeatureDrawableResource(int paramInt1, int paramInt2);
  
  public abstract void setFeatureDrawableUri(int paramInt, Uri paramUri);
  
  public abstract void setFinishOnTouchOutside(boolean paramBoolean);
  
  public abstract void setImmersive(boolean paramBoolean);
  
  public abstract void setIntent(Intent paramIntent);
  
  public abstract void setMediaController(MediaController paramMediaController);
  
  public abstract void setPictureInPictureParams(PictureInPictureParams paramPictureInPictureParams);
  
  public abstract void setProgress(int paramInt);
  
  public abstract void setProgressBarIndeterminate(boolean paramBoolean);
  
  public abstract void setProgressBarIndeterminateVisibility(boolean paramBoolean);
  
  public abstract void setProgressBarVisibility(boolean paramBoolean);
  
  public abstract void setRequestedOrientation(int paramInt);
  
  public abstract void setResult(int paramInt);
  
  public abstract void setResult(int paramInt, Intent paramIntent);
  
  public abstract void setSecondaryProgress(int paramInt);
  
  public abstract void setShowWhenLocked(boolean paramBoolean);
  
  public abstract void setTaskDescription(ActivityManager.TaskDescription paramTaskDescription);
  
  public abstract void setTheme(int paramInt);
  
  public abstract void setTitle(int paramInt);
  
  public abstract void setTitle(CharSequence paramCharSequence);
  
  public abstract void setTitleColor(int paramInt);
  
  public abstract void setTurnScreenOn(boolean paramBoolean);
  
  public abstract void setVisible(boolean paramBoolean);
  
  public abstract void setVolumeControlStream(int paramInt);
  
  public abstract void setVrModeEnabled(boolean paramBoolean, ComponentName paramComponentName);
  
  public abstract void setWallpaper(Bitmap paramBitmap);
  
  public abstract void setWallpaper(InputStream paramInputStream);
  
  public abstract boolean shouldShowRequestPermissionRationale(String paramString);
  
  public abstract boolean shouldUpRecreateTask(Intent paramIntent);
  
  public abstract boolean showAssist(Bundle paramBundle);
  
  public abstract void showDialog(int paramInt);
  
  public abstract boolean showDialog(int paramInt, Bundle paramBundle);
  
  public abstract void showLockTaskEscapeMessage();
  
  public abstract ActionMode startActionMode(ActionMode.Callback paramCallback);
  
  public abstract ActionMode startActionMode(ActionMode.Callback paramCallback, int paramInt);
  
  public abstract void startActivities(Intent[] paramArrayOfIntent);
  
  public abstract void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle);
  
  public abstract void startActivity(Intent paramIntent);
  
  public abstract void startActivity(Intent paramIntent, Bundle paramBundle);
  
  public abstract void startActivityForResult(Intent paramIntent, int paramInt);
  
  public abstract void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle);
  
  public abstract void startActivityFromChild(Activity paramActivity, Intent paramIntent, int paramInt);
  
  public abstract void startActivityFromChild(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle);
  
  public abstract void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt);
  
  public abstract void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle);
  
  public abstract boolean startActivityIfNeeded(Intent paramIntent, int paramInt);
  
  public abstract boolean startActivityIfNeeded(Intent paramIntent, int paramInt, Bundle paramBundle);
  
  public abstract ComponentName startForegroundService(Intent paramIntent);
  
  public abstract boolean startInstrumentation(ComponentName paramComponentName, String paramString, Bundle paramBundle);
  
  public abstract void startIntentSender(IntentSender paramIntentSender, Intent paramIntent, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void startIntentSender(IntentSender paramIntentSender, Intent paramIntent, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle);
  
  public abstract void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle);
  
  public abstract void startIntentSenderFromChild(Activity paramActivity, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void startIntentSenderFromChild(Activity paramActivity, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle);
  
  public abstract void startLocalVoiceInteraction(Bundle paramBundle);
  
  public abstract void startLockTask();
  
  public abstract void startManagingCursor(Cursor paramCursor);
  
  public abstract boolean startNextMatchingActivity(Intent paramIntent);
  
  public abstract boolean startNextMatchingActivity(Intent paramIntent, Bundle paramBundle);
  
  public abstract void startPostponedEnterTransition();
  
  public abstract void startSearch(String paramString, boolean paramBoolean1, Bundle paramBundle, boolean paramBoolean2);
  
  public abstract ComponentName startService(Intent paramIntent);
  
  public abstract void stopLocalVoiceInteraction();
  
  public abstract void stopLockTask();
  
  public abstract void stopManagingCursor(Cursor paramCursor);
  
  public abstract boolean stopService(Intent paramIntent);
  
  public abstract void superAddContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract void superApplyOverrideConfiguration(Configuration paramConfiguration);
  
  public abstract void superAttachBaseContext(Context paramContext);
  
  public abstract boolean superBindService(Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt);
  
  public abstract int superCheckCallingOrSelfPermission(String paramString);
  
  public abstract int superCheckCallingOrSelfUriPermission(Uri paramUri, int paramInt);
  
  public abstract int superCheckCallingPermission(String paramString);
  
  public abstract int superCheckCallingUriPermission(Uri paramUri, int paramInt);
  
  public abstract int superCheckPermission(String paramString, int paramInt1, int paramInt2);
  
  public abstract int superCheckSelfPermission(String paramString);
  
  public abstract int superCheckUriPermission(Uri paramUri, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int superCheckUriPermission(Uri paramUri, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void superClearWallpaper();
  
  public abstract void superCloseContextMenu();
  
  public abstract void superCloseOptionsMenu();
  
  public abstract Context superCreateConfigurationContext(Configuration paramConfiguration);
  
  public abstract Context superCreateContextForSplit(String paramString);
  
  public abstract Context superCreateDeviceProtectedStorageContext();
  
  public abstract Context superCreateDisplayContext(Display paramDisplay);
  
  public abstract Context superCreatePackageContext(String paramString, int paramInt);
  
  public abstract PendingIntent superCreatePendingResult(int paramInt1, Intent paramIntent, int paramInt2);
  
  public abstract String[] superDatabaseList();
  
  public abstract boolean superDeleteDatabase(String paramString);
  
  public abstract boolean superDeleteFile(String paramString);
  
  public abstract boolean superDeleteSharedPreferences(String paramString);
  
  public abstract void superDismissDialog(int paramInt);
  
  public abstract void superDismissKeyboardShortcutsHelper();
  
  public abstract boolean superDispatchGenericMotionEvent(MotionEvent paramMotionEvent);
  
  public abstract boolean superDispatchKeyEvent(KeyEvent paramKeyEvent);
  
  public abstract boolean superDispatchKeyShortcutEvent(KeyEvent paramKeyEvent);
  
  public abstract boolean superDispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent);
  
  public abstract boolean superDispatchTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract boolean superDispatchTrackballEvent(MotionEvent paramMotionEvent);
  
  public abstract void superDump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract void superEnforceCallingOrSelfPermission(String paramString1, String paramString2);
  
  public abstract void superEnforceCallingOrSelfUriPermission(Uri paramUri, int paramInt, String paramString);
  
  public abstract void superEnforceCallingPermission(String paramString1, String paramString2);
  
  public abstract void superEnforceCallingUriPermission(Uri paramUri, int paramInt, String paramString);
  
  public abstract void superEnforcePermission(String paramString1, int paramInt1, int paramInt2, String paramString2);
  
  public abstract void superEnforceUriPermission(Uri paramUri, int paramInt1, int paramInt2, int paramInt3, String paramString);
  
  public abstract void superEnforceUriPermission(Uri paramUri, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3);
  
  public abstract void superEnterPictureInPictureMode();
  
  public abstract boolean superEnterPictureInPictureMode(PictureInPictureParams paramPictureInPictureParams);
  
  public abstract String[] superFileList();
  
  public abstract <T extends View> T superFindViewById(int paramInt);
  
  public abstract void superFinish();
  
  public abstract void superFinishActivity(int paramInt);
  
  public abstract void superFinishActivityFromChild(Activity paramActivity, int paramInt);
  
  public abstract void superFinishAffinity();
  
  public abstract void superFinishAfterTransition();
  
  public abstract void superFinishAndRemoveTask();
  
  public abstract void superFinishFromChild(Activity paramActivity);
  
  public abstract ActionBar superGetActionBar();
  
  public abstract Application superGetApplication();
  
  public abstract Context superGetApplicationContext();
  
  public abstract ApplicationInfo superGetApplicationInfo();
  
  public abstract AssetManager superGetAssets();
  
  public abstract Context superGetBaseContext();
  
  public abstract File superGetCacheDir();
  
  public abstract ComponentName superGetCallingActivity();
  
  public abstract String superGetCallingPackage();
  
  public abstract int superGetChangingConfigurations();
  
  public abstract ClassLoader superGetClassLoader();
  
  public abstract File superGetCodeCacheDir();
  
  public abstract ComponentName superGetComponentName();
  
  public abstract ContentResolver superGetContentResolver();
  
  public abstract Scene superGetContentScene();
  
  public abstract TransitionManager superGetContentTransitionManager();
  
  public abstract View superGetCurrentFocus();
  
  public abstract File superGetDataDir();
  
  public abstract File superGetDatabasePath(String paramString);
  
  public abstract File superGetDir(String paramString, int paramInt);
  
  public abstract File superGetExternalCacheDir();
  
  public abstract File[] superGetExternalCacheDirs();
  
  public abstract File superGetExternalFilesDir(String paramString);
  
  public abstract File[] superGetExternalFilesDirs(String paramString);
  
  public abstract File[] superGetExternalMediaDirs();
  
  public abstract File superGetFileStreamPath(String paramString);
  
  public abstract File superGetFilesDir();
  
  public abstract FragmentManager superGetFragmentManager();
  
  public abstract Intent superGetIntent();
  
  public abstract Object superGetLastNonConfigurationInstance();
  
  public abstract LayoutInflater superGetLayoutInflater();
  
  public abstract LoaderManager superGetLoaderManager();
  
  public abstract String superGetLocalClassName();
  
  public abstract Looper superGetMainLooper();
  
  public abstract int superGetMaxNumPictureInPictureActions();
  
  public abstract MediaController superGetMediaController();
  
  public abstract MenuInflater superGetMenuInflater();
  
  public abstract File superGetNoBackupFilesDir();
  
  public abstract File superGetObbDir();
  
  public abstract File[] superGetObbDirs();
  
  public abstract String superGetPackageCodePath();
  
  public abstract PackageManager superGetPackageManager();
  
  public abstract String superGetPackageName();
  
  public abstract String superGetPackageResourcePath();
  
  public abstract Activity superGetParent();
  
  public abstract Intent superGetParentActivityIntent();
  
  public abstract SharedPreferences superGetPreferences(int paramInt);
  
  public abstract Uri superGetReferrer();
  
  public abstract int superGetRequestedOrientation();
  
  public abstract Resources superGetResources();
  
  public abstract SearchEvent superGetSearchEvent();
  
  public abstract SharedPreferences superGetSharedPreferences(String paramString, int paramInt);
  
  public abstract Object superGetSystemService(String paramString);
  
  public abstract String superGetSystemServiceName(Class<?> paramClass);
  
  public abstract int superGetTaskId();
  
  public abstract Resources.Theme superGetTheme();
  
  public abstract CharSequence superGetTitle();
  
  public abstract int superGetTitleColor();
  
  public abstract VoiceInteractor superGetVoiceInteractor();
  
  public abstract int superGetVolumeControlStream();
  
  public abstract Drawable superGetWallpaper();
  
  public abstract int superGetWallpaperDesiredMinimumHeight();
  
  public abstract int superGetWallpaperDesiredMinimumWidth();
  
  public abstract Window superGetWindow();
  
  public abstract WindowManager superGetWindowManager();
  
  public abstract void superGrantUriPermission(String paramString, Uri paramUri, int paramInt);
  
  public abstract boolean superHasWindowFocus();
  
  public abstract void superInvalidateOptionsMenu();
  
  public abstract boolean superIsActivityTransitionRunning();
  
  public abstract boolean superIsChangingConfigurations();
  
  public abstract boolean superIsChild();
  
  public abstract boolean superIsDestroyed();
  
  public abstract boolean superIsDeviceProtectedStorage();
  
  public abstract boolean superIsFinishing();
  
  public abstract boolean superIsImmersive();
  
  public abstract boolean superIsInMultiWindowMode();
  
  public abstract boolean superIsInPictureInPictureMode();
  
  public abstract boolean superIsLocalVoiceInteractionSupported();
  
  public abstract boolean superIsRestricted();
  
  public abstract boolean superIsTaskRoot();
  
  public abstract boolean superIsVoiceInteraction();
  
  public abstract boolean superIsVoiceInteractionRoot();
  
  public abstract boolean superMoveDatabaseFrom(Context paramContext, String paramString);
  
  public abstract boolean superMoveSharedPreferencesFrom(Context paramContext, String paramString);
  
  public abstract boolean superMoveTaskToBack(boolean paramBoolean);
  
  public abstract boolean superNavigateUpTo(Intent paramIntent);
  
  public abstract boolean superNavigateUpToFromChild(Activity paramActivity, Intent paramIntent);
  
  public abstract void superOnActionModeFinished(ActionMode paramActionMode);
  
  public abstract void superOnActionModeStarted(ActionMode paramActionMode);
  
  public abstract void superOnActivityReenter(int paramInt, Intent paramIntent);
  
  public abstract void superOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void superOnApplyThemeResource(Resources.Theme paramTheme, int paramInt, boolean paramBoolean);
  
  public abstract void superOnAttachFragment(Fragment paramFragment);
  
  public abstract void superOnAttachedToWindow();
  
  public abstract void superOnBackPressed();
  
  public abstract void superOnChildTitleChanged(Activity paramActivity, CharSequence paramCharSequence);
  
  public abstract void superOnConfigurationChanged(Configuration paramConfiguration);
  
  public abstract void superOnContentChanged();
  
  public abstract boolean superOnContextItemSelected(MenuItem paramMenuItem);
  
  public abstract void superOnContextMenuClosed(Menu paramMenu);
  
  public abstract void superOnCreate(Bundle paramBundle);
  
  public abstract void superOnCreate(Bundle paramBundle, PersistableBundle paramPersistableBundle);
  
  public abstract void superOnCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo);
  
  public abstract CharSequence superOnCreateDescription();
  
  public abstract Dialog superOnCreateDialog(int paramInt);
  
  public abstract Dialog superOnCreateDialog(int paramInt, Bundle paramBundle);
  
  public abstract void superOnCreateNavigateUpTaskStack(TaskStackBuilder paramTaskStackBuilder);
  
  public abstract boolean superOnCreateOptionsMenu(Menu paramMenu);
  
  public abstract boolean superOnCreatePanelMenu(int paramInt, Menu paramMenu);
  
  public abstract View superOnCreatePanelView(int paramInt);
  
  public abstract boolean superOnCreateThumbnail(Bitmap paramBitmap, Canvas paramCanvas);
  
  public abstract View superOnCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet);
  
  public abstract View superOnCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet);
  
  public abstract void superOnDestroy();
  
  public abstract void superOnDetachedFromWindow();
  
  public abstract void superOnEnterAnimationComplete();
  
  public abstract boolean superOnGenericMotionEvent(MotionEvent paramMotionEvent);
  
  public abstract boolean superOnKeyDown(int paramInt, KeyEvent paramKeyEvent);
  
  public abstract boolean superOnKeyLongPress(int paramInt, KeyEvent paramKeyEvent);
  
  public abstract boolean superOnKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent);
  
  public abstract boolean superOnKeyShortcut(int paramInt, KeyEvent paramKeyEvent);
  
  public abstract boolean superOnKeyUp(int paramInt, KeyEvent paramKeyEvent);
  
  public abstract void superOnLocalVoiceInteractionStarted();
  
  public abstract void superOnLocalVoiceInteractionStopped();
  
  public abstract void superOnLowMemory();
  
  public abstract boolean superOnMenuItemSelected(int paramInt, MenuItem paramMenuItem);
  
  public abstract boolean superOnMenuOpened(int paramInt, Menu paramMenu);
  
  public abstract void superOnMultiWindowModeChanged(boolean paramBoolean);
  
  public abstract void superOnMultiWindowModeChanged(boolean paramBoolean, Configuration paramConfiguration);
  
  public abstract boolean superOnNavigateUp();
  
  public abstract boolean superOnNavigateUpFromChild(Activity paramActivity);
  
  public abstract void superOnNewIntent(Intent paramIntent);
  
  public abstract boolean superOnOptionsItemSelected(MenuItem paramMenuItem);
  
  public abstract void superOnOptionsMenuClosed(Menu paramMenu);
  
  public abstract void superOnPanelClosed(int paramInt, Menu paramMenu);
  
  public abstract void superOnPause();
  
  public abstract void superOnPictureInPictureModeChanged(boolean paramBoolean);
  
  public abstract void superOnPictureInPictureModeChanged(boolean paramBoolean, Configuration paramConfiguration);
  
  public abstract void superOnPointerCaptureChanged(boolean paramBoolean);
  
  public abstract void superOnPostCreate(Bundle paramBundle);
  
  public abstract void superOnPostCreate(Bundle paramBundle, PersistableBundle paramPersistableBundle);
  
  public abstract void superOnPostResume();
  
  public abstract void superOnPrepareDialog(int paramInt, Dialog paramDialog);
  
  public abstract void superOnPrepareDialog(int paramInt, Dialog paramDialog, Bundle paramBundle);
  
  public abstract void superOnPrepareNavigateUpTaskStack(TaskStackBuilder paramTaskStackBuilder);
  
  public abstract boolean superOnPrepareOptionsMenu(Menu paramMenu);
  
  public abstract boolean superOnPreparePanel(int paramInt, View paramView, Menu paramMenu);
  
  public abstract void superOnProvideAssistContent(AssistContent paramAssistContent);
  
  public abstract void superOnProvideAssistData(Bundle paramBundle);
  
  public abstract void superOnProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt);
  
  public abstract Uri superOnProvideReferrer();
  
  public abstract void superOnRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  
  public abstract void superOnRestart();
  
  public abstract void superOnRestoreInstanceState(Bundle paramBundle);
  
  public abstract void superOnRestoreInstanceState(Bundle paramBundle, PersistableBundle paramPersistableBundle);
  
  public abstract void superOnResume();
  
  public abstract Object superOnRetainNonConfigurationInstance();
  
  public abstract void superOnSaveInstanceState(Bundle paramBundle);
  
  public abstract void superOnSaveInstanceState(Bundle paramBundle, PersistableBundle paramPersistableBundle);
  
  public abstract boolean superOnSearchRequested();
  
  public abstract boolean superOnSearchRequested(SearchEvent paramSearchEvent);
  
  public abstract void superOnStart();
  
  public abstract void superOnStateNotSaved();
  
  public abstract void superOnStop();
  
  public abstract void superOnTitleChanged(CharSequence paramCharSequence, int paramInt);
  
  public abstract boolean superOnTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract boolean superOnTrackballEvent(MotionEvent paramMotionEvent);
  
  public abstract void superOnTrimMemory(int paramInt);
  
  public abstract void superOnUserInteraction();
  
  public abstract void superOnUserLeaveHint();
  
  public abstract void superOnVisibleBehindCanceled();
  
  public abstract void superOnWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams);
  
  public abstract void superOnWindowFocusChanged(boolean paramBoolean);
  
  public abstract ActionMode superOnWindowStartingActionMode(ActionMode.Callback paramCallback);
  
  public abstract ActionMode superOnWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt);
  
  public abstract void superOpenContextMenu(View paramView);
  
  public abstract FileInputStream superOpenFileInput(String paramString);
  
  public abstract FileOutputStream superOpenFileOutput(String paramString, int paramInt);
  
  public abstract void superOpenOptionsMenu();
  
  public abstract SQLiteDatabase superOpenOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory);
  
  public abstract SQLiteDatabase superOpenOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler);
  
  public abstract void superOverridePendingTransition(int paramInt1, int paramInt2);
  
  public abstract Drawable superPeekWallpaper();
  
  public abstract void superPostponeEnterTransition();
  
  public abstract void superRecreate();
  
  public abstract void superRegisterComponentCallbacks(ComponentCallbacks paramComponentCallbacks);
  
  public abstract void superRegisterForContextMenu(View paramView);
  
  public abstract Intent superRegisterReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter);
  
  public abstract Intent superRegisterReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, int paramInt);
  
  public abstract Intent superRegisterReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, String paramString, Handler paramHandler);
  
  public abstract Intent superRegisterReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, String paramString, Handler paramHandler, int paramInt);
  
  public abstract boolean superReleaseInstance();
  
  public abstract void superRemoveDialog(int paramInt);
  
  public abstract void superRemoveStickyBroadcast(Intent paramIntent);
  
  public abstract void superRemoveStickyBroadcastAsUser(Intent paramIntent, UserHandle paramUserHandle);
  
  public abstract void superReportFullyDrawn();
  
  public abstract DragAndDropPermissions superRequestDragAndDropPermissions(DragEvent paramDragEvent);
  
  public abstract void superRequestPermissions(String[] paramArrayOfString, int paramInt);
  
  public abstract void superRequestShowKeyboardShortcuts();
  
  public abstract boolean superRequestVisibleBehind(boolean paramBoolean);
  
  public abstract boolean superRequestWindowFeature(int paramInt);
  
  public abstract void superRevokeUriPermission(Uri paramUri, int paramInt);
  
  public abstract void superRevokeUriPermission(String paramString, Uri paramUri, int paramInt);
  
  public abstract void superRunOnUiThread(Runnable paramRunnable);
  
  public abstract void superSendBroadcast(Intent paramIntent);
  
  public abstract void superSendBroadcast(Intent paramIntent, String paramString);
  
  public abstract void superSendBroadcastAsUser(Intent paramIntent, UserHandle paramUserHandle);
  
  public abstract void superSendBroadcastAsUser(Intent paramIntent, UserHandle paramUserHandle, String paramString);
  
  public abstract void superSendOrderedBroadcast(Intent paramIntent, String paramString);
  
  public abstract void superSendOrderedBroadcast(Intent paramIntent, String paramString1, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString2, Bundle paramBundle);
  
  public abstract void superSendOrderedBroadcastAsUser(Intent paramIntent, UserHandle paramUserHandle, String paramString1, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString2, Bundle paramBundle);
  
  public abstract void superSendStickyBroadcast(Intent paramIntent);
  
  public abstract void superSendStickyBroadcastAsUser(Intent paramIntent, UserHandle paramUserHandle);
  
  public abstract void superSendStickyOrderedBroadcast(Intent paramIntent, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString, Bundle paramBundle);
  
  public abstract void superSendStickyOrderedBroadcastAsUser(Intent paramIntent, UserHandle paramUserHandle, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString, Bundle paramBundle);
  
  public abstract void superSetActionBar(Toolbar paramToolbar);
  
  public abstract void superSetContentTransitionManager(TransitionManager paramTransitionManager);
  
  public abstract void superSetContentView(int paramInt);
  
  public abstract void superSetContentView(View paramView);
  
  public abstract void superSetContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract void superSetDefaultKeyMode(int paramInt);
  
  public abstract void superSetEnterSharedElementCallback(SharedElementCallback paramSharedElementCallback);
  
  public abstract void superSetExitSharedElementCallback(SharedElementCallback paramSharedElementCallback);
  
  public abstract void superSetFeatureDrawable(int paramInt, Drawable paramDrawable);
  
  public abstract void superSetFeatureDrawableAlpha(int paramInt1, int paramInt2);
  
  public abstract void superSetFeatureDrawableResource(int paramInt1, int paramInt2);
  
  public abstract void superSetFeatureDrawableUri(int paramInt, Uri paramUri);
  
  public abstract void superSetFinishOnTouchOutside(boolean paramBoolean);
  
  public abstract void superSetImmersive(boolean paramBoolean);
  
  public abstract void superSetIntent(Intent paramIntent);
  
  public abstract void superSetMediaController(MediaController paramMediaController);
  
  public abstract void superSetPictureInPictureParams(PictureInPictureParams paramPictureInPictureParams);
  
  public abstract void superSetProgress(int paramInt);
  
  public abstract void superSetProgressBarIndeterminate(boolean paramBoolean);
  
  public abstract void superSetProgressBarIndeterminateVisibility(boolean paramBoolean);
  
  public abstract void superSetProgressBarVisibility(boolean paramBoolean);
  
  public abstract void superSetRequestedOrientation(int paramInt);
  
  public abstract void superSetResult(int paramInt);
  
  public abstract void superSetResult(int paramInt, Intent paramIntent);
  
  public abstract void superSetSecondaryProgress(int paramInt);
  
  public abstract void superSetShowWhenLocked(boolean paramBoolean);
  
  public abstract void superSetTaskDescription(ActivityManager.TaskDescription paramTaskDescription);
  
  public abstract void superSetTheme(int paramInt);
  
  public abstract void superSetTitle(int paramInt);
  
  public abstract void superSetTitle(CharSequence paramCharSequence);
  
  public abstract void superSetTitleColor(int paramInt);
  
  public abstract void superSetTurnScreenOn(boolean paramBoolean);
  
  public abstract void superSetVisible(boolean paramBoolean);
  
  public abstract void superSetVolumeControlStream(int paramInt);
  
  public abstract void superSetVrModeEnabled(boolean paramBoolean, ComponentName paramComponentName);
  
  public abstract void superSetWallpaper(Bitmap paramBitmap);
  
  public abstract void superSetWallpaper(InputStream paramInputStream);
  
  public abstract boolean superShouldShowRequestPermissionRationale(String paramString);
  
  public abstract boolean superShouldUpRecreateTask(Intent paramIntent);
  
  public abstract boolean superShowAssist(Bundle paramBundle);
  
  public abstract void superShowDialog(int paramInt);
  
  public abstract boolean superShowDialog(int paramInt, Bundle paramBundle);
  
  public abstract void superShowLockTaskEscapeMessage();
  
  public abstract ActionMode superStartActionMode(ActionMode.Callback paramCallback);
  
  public abstract ActionMode superStartActionMode(ActionMode.Callback paramCallback, int paramInt);
  
  public abstract void superStartActivities(Intent[] paramArrayOfIntent);
  
  public abstract void superStartActivities(Intent[] paramArrayOfIntent, Bundle paramBundle);
  
  public abstract void superStartActivity(Intent paramIntent);
  
  public abstract void superStartActivity(Intent paramIntent, Bundle paramBundle);
  
  public abstract void superStartActivityForResult(Intent paramIntent, int paramInt);
  
  public abstract void superStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle);
  
  public abstract void superStartActivityFromChild(Activity paramActivity, Intent paramIntent, int paramInt);
  
  public abstract void superStartActivityFromChild(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle);
  
  public abstract void superStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt);
  
  public abstract void superStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle);
  
  public abstract boolean superStartActivityIfNeeded(Intent paramIntent, int paramInt);
  
  public abstract boolean superStartActivityIfNeeded(Intent paramIntent, int paramInt, Bundle paramBundle);
  
  public abstract ComponentName superStartForegroundService(Intent paramIntent);
  
  public abstract boolean superStartInstrumentation(ComponentName paramComponentName, String paramString, Bundle paramBundle);
  
  public abstract void superStartIntentSender(IntentSender paramIntentSender, Intent paramIntent, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void superStartIntentSender(IntentSender paramIntentSender, Intent paramIntent, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle);
  
  public abstract void superStartIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void superStartIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle);
  
  public abstract void superStartIntentSenderFromChild(Activity paramActivity, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void superStartIntentSenderFromChild(Activity paramActivity, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle);
  
  public abstract void superStartLocalVoiceInteraction(Bundle paramBundle);
  
  public abstract void superStartLockTask();
  
  public abstract void superStartManagingCursor(Cursor paramCursor);
  
  public abstract boolean superStartNextMatchingActivity(Intent paramIntent);
  
  public abstract boolean superStartNextMatchingActivity(Intent paramIntent, Bundle paramBundle);
  
  public abstract void superStartPostponedEnterTransition();
  
  public abstract void superStartSearch(String paramString, boolean paramBoolean1, Bundle paramBundle, boolean paramBoolean2);
  
  public abstract ComponentName superStartService(Intent paramIntent);
  
  public abstract void superStopLocalVoiceInteraction();
  
  public abstract void superStopLockTask();
  
  public abstract void superStopManagingCursor(Cursor paramCursor);
  
  public abstract boolean superStopService(Intent paramIntent);
  
  public abstract void superTakeKeyEvents(boolean paramBoolean);
  
  public abstract void superTriggerSearch(String paramString, Bundle paramBundle);
  
  public abstract void superUnbindService(ServiceConnection paramServiceConnection);
  
  public abstract void superUnregisterComponentCallbacks(ComponentCallbacks paramComponentCallbacks);
  
  public abstract void superUnregisterForContextMenu(View paramView);
  
  public abstract void superUnregisterReceiver(BroadcastReceiver paramBroadcastReceiver);
  
  public abstract void takeKeyEvents(boolean paramBoolean);
  
  public abstract void triggerSearch(String paramString, Bundle paramBundle);
  
  public abstract void unbindService(ServiceConnection paramServiceConnection);
  
  public abstract void unregisterComponentCallbacks(ComponentCallbacks paramComponentCallbacks);
  
  public abstract void unregisterForContextMenu(View paramView);
  
  public abstract void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.qcircle.container.HostActivityDelegator
 * JD-Core Version:    0.7.0.1
 */