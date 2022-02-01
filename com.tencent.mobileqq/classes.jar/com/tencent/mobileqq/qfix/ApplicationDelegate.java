package com.tencent.mobileqq.qfix;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
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
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class ApplicationDelegate
  extends Application
{
  protected QFixApplication mApplicationReal;
  
  public boolean bindService(Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.bindService(paramIntent, paramServiceConnection, paramInt);
    }
    return localQFixApplication.bindService(paramIntent, paramServiceConnection, paramInt);
  }
  
  public int checkCallingOrSelfPermission(String paramString)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.checkCallingOrSelfPermission(paramString);
    }
    return localQFixApplication.checkCallingOrSelfPermission(paramString);
  }
  
  public int checkCallingOrSelfUriPermission(Uri paramUri, int paramInt)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.checkCallingOrSelfUriPermission(paramUri, paramInt);
    }
    return localQFixApplication.checkCallingOrSelfUriPermission(paramUri, paramInt);
  }
  
  public int checkCallingPermission(String paramString)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.checkCallingPermission(paramString);
    }
    return localQFixApplication.checkCallingPermission(paramString);
  }
  
  public int checkCallingUriPermission(Uri paramUri, int paramInt)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.checkCallingUriPermission(paramUri, paramInt);
    }
    return localQFixApplication.checkCallingUriPermission(paramUri, paramInt);
  }
  
  public int checkPermission(String paramString, int paramInt1, int paramInt2)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.checkPermission(paramString, paramInt1, paramInt2);
    }
    return localQFixApplication.checkPermission(paramString, paramInt1, paramInt2);
  }
  
  public int checkUriPermission(Uri paramUri, int paramInt1, int paramInt2, int paramInt3)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.checkUriPermission(paramUri, paramInt1, paramInt2, paramInt3);
    }
    return localQFixApplication.checkUriPermission(paramUri, paramInt1, paramInt2, paramInt3);
  }
  
  public int checkUriPermission(Uri paramUri, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.checkUriPermission(paramUri, paramString1, paramString2, paramInt1, paramInt2, paramInt3);
    }
    return localQFixApplication.checkUriPermission(paramUri, paramString1, paramString2, paramInt1, paramInt2, paramInt3);
  }
  
  public void clearWallpaper()
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.clearWallpaper();
      return;
    }
    localQFixApplication.clearWallpaper();
  }
  
  public Context createPackageContext(String paramString, int paramInt)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.createPackageContext(paramString, paramInt);
    }
    return localQFixApplication.createPackageContext(paramString, paramInt);
  }
  
  public String[] databaseList()
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.databaseList();
    }
    return localQFixApplication.databaseList();
  }
  
  public boolean deleteDatabase(String paramString)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.deleteDatabase(paramString);
    }
    return localQFixApplication.deleteDatabase(paramString);
  }
  
  public boolean deleteFile(String paramString)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.deleteFile(paramString);
    }
    return localQFixApplication.deleteFile(paramString);
  }
  
  public void enforceCallingOrSelfPermission(String paramString1, String paramString2)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.enforceCallingOrSelfPermission(paramString1, paramString2);
      return;
    }
    localQFixApplication.enforceCallingOrSelfPermission(paramString1, paramString2);
  }
  
  public void enforceCallingOrSelfUriPermission(Uri paramUri, int paramInt, String paramString)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.enforceCallingOrSelfUriPermission(paramUri, paramInt, paramString);
      return;
    }
    localQFixApplication.enforceCallingOrSelfUriPermission(paramUri, paramInt, paramString);
  }
  
  public void enforceCallingPermission(String paramString1, String paramString2)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.enforceCallingPermission(paramString1, paramString2);
      return;
    }
    localQFixApplication.enforceCallingPermission(paramString1, paramString2);
  }
  
  public void enforceCallingUriPermission(Uri paramUri, int paramInt, String paramString)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.enforceCallingUriPermission(paramUri, paramInt, paramString);
      return;
    }
    localQFixApplication.enforceCallingUriPermission(paramUri, paramInt, paramString);
  }
  
  public void enforcePermission(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.enforcePermission(paramString1, paramInt1, paramInt2, paramString2);
      return;
    }
    localQFixApplication.enforcePermission(paramString1, paramInt1, paramInt2, paramString2);
  }
  
  public void enforceUriPermission(Uri paramUri, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.enforceUriPermission(paramUri, paramInt1, paramInt2, paramInt3, paramString);
      return;
    }
    localQFixApplication.enforceUriPermission(paramUri, paramInt1, paramInt2, paramInt3, paramString);
  }
  
  public void enforceUriPermission(Uri paramUri, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.enforceUriPermission(paramUri, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3);
      return;
    }
    localQFixApplication.enforceUriPermission(paramUri, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3);
  }
  
  public String[] fileList()
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.fileList();
    }
    return localQFixApplication.fileList();
  }
  
  public Context getApplicationContext()
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getApplicationContext();
    }
    return localQFixApplication.getApplicationContext();
  }
  
  public ApplicationInfo getApplicationInfo()
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getApplicationInfo();
    }
    return localQFixApplication.getApplicationInfo();
  }
  
  public AssetManager getAssets()
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getAssets();
    }
    return localQFixApplication.getAssets();
  }
  
  public Context getBaseContext()
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getBaseContext();
    }
    return localQFixApplication.getBaseContext();
  }
  
  public File getCacheDir()
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getCacheDir();
    }
    return localQFixApplication.getCacheDir();
  }
  
  public ClassLoader getClassLoader()
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getClassLoader();
    }
    return localQFixApplication.getClassLoader();
  }
  
  public ContentResolver getContentResolver()
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getContentResolver();
    }
    return localQFixApplication.getContentResolver();
  }
  
  public File getDatabasePath(String paramString)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getDatabasePath(paramString);
    }
    return localQFixApplication.getDatabasePath(paramString);
  }
  
  public File getDir(String paramString, int paramInt)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getDir(paramString, paramInt);
    }
    return localQFixApplication.getDir(paramString, paramInt);
  }
  
  public File getExternalCacheDir()
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getExternalCacheDir();
    }
    return localQFixApplication.getExternalCacheDir();
  }
  
  public File getExternalFilesDir(String paramString)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getExternalFilesDir(paramString);
    }
    return localQFixApplication.getExternalFilesDir(paramString);
  }
  
  public File getFileStreamPath(String paramString)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getFileStreamPath(paramString);
    }
    return localQFixApplication.getFileStreamPath(paramString);
  }
  
  public File getFilesDir()
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getFilesDir();
    }
    return localQFixApplication.getFilesDir();
  }
  
  public Looper getMainLooper()
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getMainLooper();
    }
    return localQFixApplication.getMainLooper();
  }
  
  public File getObbDir()
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getObbDir();
    }
    return localQFixApplication.getObbDir();
  }
  
  public String getPackageCodePath()
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getPackageCodePath();
    }
    return localQFixApplication.getPackageCodePath();
  }
  
  public PackageManager getPackageManager()
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getPackageManager();
    }
    return localQFixApplication.getPackageManager();
  }
  
  public String getPackageName()
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getPackageName();
    }
    return localQFixApplication.getPackageName();
  }
  
  public String getPackageResourcePath()
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getPackageResourcePath();
    }
    return localQFixApplication.getPackageResourcePath();
  }
  
  public Resources getResources()
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getResources();
    }
    return localQFixApplication.getResources();
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getSharedPreferences(paramString, paramInt);
    }
    return localQFixApplication.getSharedPreferences(paramString, paramInt);
  }
  
  public Object getSystemService(String paramString)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getSystemService(paramString);
    }
    return localQFixApplication.getSystemService(paramString);
  }
  
  public Resources.Theme getTheme()
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getTheme();
    }
    return localQFixApplication.getTheme();
  }
  
  public Drawable getWallpaper()
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getWallpaper();
    }
    return localQFixApplication.getWallpaper();
  }
  
  public int getWallpaperDesiredMinimumHeight()
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getWallpaperDesiredMinimumHeight();
    }
    return localQFixApplication.getWallpaperDesiredMinimumHeight();
  }
  
  public int getWallpaperDesiredMinimumWidth()
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.getWallpaperDesiredMinimumWidth();
    }
    return localQFixApplication.getWallpaperDesiredMinimumWidth();
  }
  
  public void grantUriPermission(String paramString, Uri paramUri, int paramInt)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.grantUriPermission(paramString, paramUri, paramInt);
      return;
    }
    localQFixApplication.grantUriPermission(paramString, paramUri, paramInt);
  }
  
  public boolean isRestricted()
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.isRestricted();
    }
    return localQFixApplication.isRestricted();
  }
  
  public FileInputStream openFileInput(String paramString)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.openFileInput(paramString);
    }
    return localQFixApplication.openFileInput(paramString);
  }
  
  public FileOutputStream openFileOutput(String paramString, int paramInt)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.openFileOutput(paramString, paramInt);
    }
    return localQFixApplication.openFileOutput(paramString, paramInt);
  }
  
  public SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.openOrCreateDatabase(paramString, paramInt, paramCursorFactory);
    }
    return localQFixApplication.openOrCreateDatabase(paramString, paramInt, paramCursorFactory);
  }
  
  public SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.openOrCreateDatabase(paramString, paramInt, paramCursorFactory, paramDatabaseErrorHandler);
    }
    return localQFixApplication.openOrCreateDatabase(paramString, paramInt, paramCursorFactory, paramDatabaseErrorHandler);
  }
  
  public Drawable peekWallpaper()
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.peekWallpaper();
    }
    return localQFixApplication.peekWallpaper();
  }
  
  public void proxyAttachBaseContext(Context paramContext, QFixApplication paramQFixApplication)
  {
    this.mApplicationReal = paramQFixApplication;
    attachBaseContext(paramContext);
  }
  
  public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks paramActivityLifecycleCallbacks)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.registerActivityLifecycleCallbacks(paramActivityLifecycleCallbacks);
      return;
    }
    localQFixApplication.registerActivityLifecycleCallbacks(paramActivityLifecycleCallbacks);
  }
  
  public void registerComponentCallbacks(ComponentCallbacks paramComponentCallbacks)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.registerComponentCallbacks(paramComponentCallbacks);
      return;
    }
    localQFixApplication.registerComponentCallbacks(paramComponentCallbacks);
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
    }
    return localQFixApplication.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, String paramString, Handler paramHandler)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.registerReceiver(paramBroadcastReceiver, paramIntentFilter, paramString, paramHandler);
    }
    return localQFixApplication.registerReceiver(paramBroadcastReceiver, paramIntentFilter, paramString, paramHandler);
  }
  
  public void removeStickyBroadcast(Intent paramIntent)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.removeStickyBroadcast(paramIntent);
      return;
    }
    localQFixApplication.removeStickyBroadcast(paramIntent);
  }
  
  public void revokeUriPermission(Uri paramUri, int paramInt)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.revokeUriPermission(paramUri, paramInt);
      return;
    }
    localQFixApplication.revokeUriPermission(paramUri, paramInt);
  }
  
  public void sendBroadcast(Intent paramIntent)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.sendBroadcast(paramIntent);
      return;
    }
    localQFixApplication.sendBroadcast(paramIntent);
  }
  
  public void sendBroadcast(Intent paramIntent, String paramString)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.sendBroadcast(paramIntent, paramString);
      return;
    }
    localQFixApplication.sendBroadcast(paramIntent, paramString);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.sendBroadcast(paramIntent, paramString);
      return;
    }
    localQFixApplication.sendOrderedBroadcast(paramIntent, paramString);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString1, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString2, Bundle paramBundle)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.sendOrderedBroadcast(paramIntent, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
      return;
    }
    localQFixApplication.sendOrderedBroadcast(paramIntent, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
  }
  
  public void sendStickyBroadcast(Intent paramIntent)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.sendStickyBroadcast(paramIntent);
      return;
    }
    localQFixApplication.sendStickyBroadcast(paramIntent);
  }
  
  public void sendStickyOrderedBroadcast(Intent paramIntent, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString, Bundle paramBundle)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.sendStickyOrderedBroadcast(paramIntent, paramBroadcastReceiver, paramHandler, paramInt, paramString, paramBundle);
      return;
    }
    localQFixApplication.sendStickyOrderedBroadcast(paramIntent, paramBroadcastReceiver, paramHandler, paramInt, paramString, paramBundle);
  }
  
  public void setTheme(int paramInt)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.setTheme(paramInt);
      return;
    }
    localQFixApplication.setTheme(paramInt);
  }
  
  public void setWallpaper(Bitmap paramBitmap)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.setWallpaper(paramBitmap);
      return;
    }
    localQFixApplication.setWallpaper(paramBitmap);
  }
  
  public void setWallpaper(InputStream paramInputStream)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.setWallpaper(paramInputStream);
      return;
    }
    localQFixApplication.setWallpaper(paramInputStream);
  }
  
  public void startActivities(Intent[] paramArrayOfIntent)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.startActivities(paramArrayOfIntent);
      return;
    }
    localQFixApplication.startActivities(paramArrayOfIntent);
  }
  
  public void startActivity(Intent paramIntent)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.startActivity(paramIntent);
      return;
    }
    localQFixApplication.startActivity(paramIntent);
  }
  
  public boolean startInstrumentation(ComponentName paramComponentName, String paramString, Bundle paramBundle)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.startInstrumentation(paramComponentName, paramString, paramBundle);
    }
    return localQFixApplication.startInstrumentation(paramComponentName, paramString, paramBundle);
  }
  
  public void startIntentSender(IntentSender paramIntentSender, Intent paramIntent, int paramInt1, int paramInt2, int paramInt3)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.startIntentSender(paramIntentSender, paramIntent, paramInt1, paramInt2, paramInt3);
      return;
    }
    localQFixApplication.startIntentSender(paramIntentSender, paramIntent, paramInt1, paramInt2, paramInt3);
  }
  
  public ComponentName startService(Intent paramIntent)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.startService(paramIntent);
    }
    return localQFixApplication.startService(paramIntent);
  }
  
  public boolean stopService(Intent paramIntent)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null) {
      return super.stopService(paramIntent);
    }
    return localQFixApplication.stopService(paramIntent);
  }
  
  public void unbindService(ServiceConnection paramServiceConnection)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.unbindService(paramServiceConnection);
      return;
    }
    localQFixApplication.unbindService(paramServiceConnection);
  }
  
  public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks paramActivityLifecycleCallbacks)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.unregisterActivityLifecycleCallbacks(paramActivityLifecycleCallbacks);
      return;
    }
    localQFixApplication.unregisterActivityLifecycleCallbacks(paramActivityLifecycleCallbacks);
  }
  
  public void unregisterComponentCallbacks(ComponentCallbacks paramComponentCallbacks)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.unregisterComponentCallbacks(paramComponentCallbacks);
      return;
    }
    localQFixApplication.unregisterComponentCallbacks(paramComponentCallbacks);
  }
  
  public void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    QFixApplication localQFixApplication = this.mApplicationReal;
    if (localQFixApplication == null)
    {
      super.unregisterReceiver(paramBroadcastReceiver);
      return;
    }
    localQFixApplication.unregisterReceiver(paramBroadcastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qfix.ApplicationDelegate
 * JD-Core Version:    0.7.0.1
 */