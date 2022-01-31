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
    if (this.mApplicationReal == null) {
      return super.bindService(paramIntent, paramServiceConnection, paramInt);
    }
    return this.mApplicationReal.bindService(paramIntent, paramServiceConnection, paramInt);
  }
  
  public int checkCallingOrSelfPermission(String paramString)
  {
    if (this.mApplicationReal == null) {
      return super.checkCallingOrSelfPermission(paramString);
    }
    return this.mApplicationReal.checkCallingOrSelfPermission(paramString);
  }
  
  public int checkCallingOrSelfUriPermission(Uri paramUri, int paramInt)
  {
    if (this.mApplicationReal == null) {
      return super.checkCallingOrSelfUriPermission(paramUri, paramInt);
    }
    return this.mApplicationReal.checkCallingOrSelfUriPermission(paramUri, paramInt);
  }
  
  public int checkCallingPermission(String paramString)
  {
    if (this.mApplicationReal == null) {
      return super.checkCallingPermission(paramString);
    }
    return this.mApplicationReal.checkCallingPermission(paramString);
  }
  
  public int checkCallingUriPermission(Uri paramUri, int paramInt)
  {
    if (this.mApplicationReal == null) {
      return super.checkCallingUriPermission(paramUri, paramInt);
    }
    return this.mApplicationReal.checkCallingUriPermission(paramUri, paramInt);
  }
  
  public int checkPermission(String paramString, int paramInt1, int paramInt2)
  {
    if (this.mApplicationReal == null) {
      return super.checkPermission(paramString, paramInt1, paramInt2);
    }
    return this.mApplicationReal.checkPermission(paramString, paramInt1, paramInt2);
  }
  
  public int checkUriPermission(Uri paramUri, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mApplicationReal == null) {
      return super.checkUriPermission(paramUri, paramInt1, paramInt2, paramInt3);
    }
    return this.mApplicationReal.checkUriPermission(paramUri, paramInt1, paramInt2, paramInt3);
  }
  
  public int checkUriPermission(Uri paramUri, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mApplicationReal == null) {
      return super.checkUriPermission(paramUri, paramString1, paramString2, paramInt1, paramInt2, paramInt3);
    }
    return this.mApplicationReal.checkUriPermission(paramUri, paramString1, paramString2, paramInt1, paramInt2, paramInt3);
  }
  
  public void clearWallpaper()
  {
    if (this.mApplicationReal == null)
    {
      super.clearWallpaper();
      return;
    }
    this.mApplicationReal.clearWallpaper();
  }
  
  public Context createPackageContext(String paramString, int paramInt)
  {
    if (this.mApplicationReal == null) {
      return super.createPackageContext(paramString, paramInt);
    }
    return this.mApplicationReal.createPackageContext(paramString, paramInt);
  }
  
  public String[] databaseList()
  {
    if (this.mApplicationReal == null) {
      return super.databaseList();
    }
    return this.mApplicationReal.databaseList();
  }
  
  public boolean deleteDatabase(String paramString)
  {
    if (this.mApplicationReal == null) {
      return super.deleteDatabase(paramString);
    }
    return this.mApplicationReal.deleteDatabase(paramString);
  }
  
  public boolean deleteFile(String paramString)
  {
    if (this.mApplicationReal == null) {
      return super.deleteFile(paramString);
    }
    return this.mApplicationReal.deleteFile(paramString);
  }
  
  public void enforceCallingOrSelfPermission(String paramString1, String paramString2)
  {
    if (this.mApplicationReal == null)
    {
      super.enforceCallingOrSelfPermission(paramString1, paramString2);
      return;
    }
    this.mApplicationReal.enforceCallingOrSelfPermission(paramString1, paramString2);
  }
  
  public void enforceCallingOrSelfUriPermission(Uri paramUri, int paramInt, String paramString)
  {
    if (this.mApplicationReal == null)
    {
      super.enforceCallingOrSelfUriPermission(paramUri, paramInt, paramString);
      return;
    }
    this.mApplicationReal.enforceCallingOrSelfUriPermission(paramUri, paramInt, paramString);
  }
  
  public void enforceCallingPermission(String paramString1, String paramString2)
  {
    if (this.mApplicationReal == null)
    {
      super.enforceCallingPermission(paramString1, paramString2);
      return;
    }
    this.mApplicationReal.enforceCallingPermission(paramString1, paramString2);
  }
  
  public void enforceCallingUriPermission(Uri paramUri, int paramInt, String paramString)
  {
    if (this.mApplicationReal == null)
    {
      super.enforceCallingUriPermission(paramUri, paramInt, paramString);
      return;
    }
    this.mApplicationReal.enforceCallingUriPermission(paramUri, paramInt, paramString);
  }
  
  public void enforcePermission(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (this.mApplicationReal == null)
    {
      super.enforcePermission(paramString1, paramInt1, paramInt2, paramString2);
      return;
    }
    this.mApplicationReal.enforcePermission(paramString1, paramInt1, paramInt2, paramString2);
  }
  
  public void enforceUriPermission(Uri paramUri, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (this.mApplicationReal == null)
    {
      super.enforceUriPermission(paramUri, paramInt1, paramInt2, paramInt3, paramString);
      return;
    }
    this.mApplicationReal.enforceUriPermission(paramUri, paramInt1, paramInt2, paramInt3, paramString);
  }
  
  public void enforceUriPermission(Uri paramUri, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    if (this.mApplicationReal == null)
    {
      super.enforceUriPermission(paramUri, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3);
      return;
    }
    this.mApplicationReal.enforceUriPermission(paramUri, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3);
  }
  
  public String[] fileList()
  {
    if (this.mApplicationReal == null) {
      return super.fileList();
    }
    return this.mApplicationReal.fileList();
  }
  
  public Context getApplicationContext()
  {
    if (this.mApplicationReal == null) {
      return super.getApplicationContext();
    }
    return this.mApplicationReal.getApplicationContext();
  }
  
  public ApplicationInfo getApplicationInfo()
  {
    if (this.mApplicationReal == null) {
      return super.getApplicationInfo();
    }
    return this.mApplicationReal.getApplicationInfo();
  }
  
  public AssetManager getAssets()
  {
    if (this.mApplicationReal == null) {
      return super.getAssets();
    }
    return this.mApplicationReal.getAssets();
  }
  
  public Context getBaseContext()
  {
    if (this.mApplicationReal == null) {
      return super.getBaseContext();
    }
    return this.mApplicationReal.getBaseContext();
  }
  
  public File getCacheDir()
  {
    if (this.mApplicationReal == null) {
      return super.getCacheDir();
    }
    return this.mApplicationReal.getCacheDir();
  }
  
  public ClassLoader getClassLoader()
  {
    if (this.mApplicationReal == null) {
      return super.getClassLoader();
    }
    return this.mApplicationReal.getClassLoader();
  }
  
  public ContentResolver getContentResolver()
  {
    if (this.mApplicationReal == null) {
      return super.getContentResolver();
    }
    return this.mApplicationReal.getContentResolver();
  }
  
  public File getDatabasePath(String paramString)
  {
    if (this.mApplicationReal == null) {
      return super.getDatabasePath(paramString);
    }
    return this.mApplicationReal.getDatabasePath(paramString);
  }
  
  public File getDir(String paramString, int paramInt)
  {
    if (this.mApplicationReal == null) {
      return super.getDir(paramString, paramInt);
    }
    return this.mApplicationReal.getDir(paramString, paramInt);
  }
  
  public File getExternalCacheDir()
  {
    if (this.mApplicationReal == null) {
      return super.getExternalCacheDir();
    }
    return this.mApplicationReal.getExternalCacheDir();
  }
  
  public File getExternalFilesDir(String paramString)
  {
    if (this.mApplicationReal == null) {
      return super.getExternalFilesDir(paramString);
    }
    return this.mApplicationReal.getExternalFilesDir(paramString);
  }
  
  public File getFileStreamPath(String paramString)
  {
    if (this.mApplicationReal == null) {
      return super.getFileStreamPath(paramString);
    }
    return this.mApplicationReal.getFileStreamPath(paramString);
  }
  
  public File getFilesDir()
  {
    if (this.mApplicationReal == null) {
      return super.getFilesDir();
    }
    return this.mApplicationReal.getFilesDir();
  }
  
  public Looper getMainLooper()
  {
    if (this.mApplicationReal == null) {
      return super.getMainLooper();
    }
    return this.mApplicationReal.getMainLooper();
  }
  
  public File getObbDir()
  {
    if (this.mApplicationReal == null) {
      return super.getObbDir();
    }
    return this.mApplicationReal.getObbDir();
  }
  
  public String getPackageCodePath()
  {
    if (this.mApplicationReal == null) {
      return super.getPackageCodePath();
    }
    return this.mApplicationReal.getPackageCodePath();
  }
  
  public PackageManager getPackageManager()
  {
    if (this.mApplicationReal == null) {
      return super.getPackageManager();
    }
    return this.mApplicationReal.getPackageManager();
  }
  
  public String getPackageName()
  {
    if (this.mApplicationReal == null) {
      return super.getPackageName();
    }
    return this.mApplicationReal.getPackageName();
  }
  
  public String getPackageResourcePath()
  {
    if (this.mApplicationReal == null) {
      return super.getPackageResourcePath();
    }
    return this.mApplicationReal.getPackageResourcePath();
  }
  
  public Resources getResources()
  {
    if (this.mApplicationReal == null) {
      return super.getResources();
    }
    return this.mApplicationReal.getResources();
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    if (this.mApplicationReal == null) {
      return super.getSharedPreferences(paramString, paramInt);
    }
    return this.mApplicationReal.getSharedPreferences(paramString, paramInt);
  }
  
  public Object getSystemService(String paramString)
  {
    if (this.mApplicationReal == null) {
      return super.getSystemService(paramString);
    }
    return this.mApplicationReal.getSystemService(paramString);
  }
  
  public Resources.Theme getTheme()
  {
    if (this.mApplicationReal == null) {
      return super.getTheme();
    }
    return this.mApplicationReal.getTheme();
  }
  
  public Drawable getWallpaper()
  {
    if (this.mApplicationReal == null) {
      return super.getWallpaper();
    }
    return this.mApplicationReal.getWallpaper();
  }
  
  public int getWallpaperDesiredMinimumHeight()
  {
    if (this.mApplicationReal == null) {
      return super.getWallpaperDesiredMinimumHeight();
    }
    return this.mApplicationReal.getWallpaperDesiredMinimumHeight();
  }
  
  public int getWallpaperDesiredMinimumWidth()
  {
    if (this.mApplicationReal == null) {
      return super.getWallpaperDesiredMinimumWidth();
    }
    return this.mApplicationReal.getWallpaperDesiredMinimumWidth();
  }
  
  public void grantUriPermission(String paramString, Uri paramUri, int paramInt)
  {
    if (this.mApplicationReal == null)
    {
      super.grantUriPermission(paramString, paramUri, paramInt);
      return;
    }
    this.mApplicationReal.grantUriPermission(paramString, paramUri, paramInt);
  }
  
  public boolean isRestricted()
  {
    if (this.mApplicationReal == null) {
      return super.isRestricted();
    }
    return this.mApplicationReal.isRestricted();
  }
  
  public FileInputStream openFileInput(String paramString)
  {
    if (this.mApplicationReal == null) {
      return super.openFileInput(paramString);
    }
    return this.mApplicationReal.openFileInput(paramString);
  }
  
  public FileOutputStream openFileOutput(String paramString, int paramInt)
  {
    if (this.mApplicationReal == null) {
      return super.openFileOutput(paramString, paramInt);
    }
    return this.mApplicationReal.openFileOutput(paramString, paramInt);
  }
  
  public SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    if (this.mApplicationReal == null) {
      return super.openOrCreateDatabase(paramString, paramInt, paramCursorFactory);
    }
    return this.mApplicationReal.openOrCreateDatabase(paramString, paramInt, paramCursorFactory);
  }
  
  public SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    if (this.mApplicationReal == null) {
      return super.openOrCreateDatabase(paramString, paramInt, paramCursorFactory, paramDatabaseErrorHandler);
    }
    return this.mApplicationReal.openOrCreateDatabase(paramString, paramInt, paramCursorFactory, paramDatabaseErrorHandler);
  }
  
  public Drawable peekWallpaper()
  {
    if (this.mApplicationReal == null) {
      return super.peekWallpaper();
    }
    return this.mApplicationReal.peekWallpaper();
  }
  
  public void proxyAttachBaseContext(Context paramContext, QFixApplication paramQFixApplication)
  {
    this.mApplicationReal = paramQFixApplication;
    attachBaseContext(paramContext);
  }
  
  public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks paramActivityLifecycleCallbacks)
  {
    if (this.mApplicationReal == null)
    {
      super.registerActivityLifecycleCallbacks(paramActivityLifecycleCallbacks);
      return;
    }
    this.mApplicationReal.registerActivityLifecycleCallbacks(paramActivityLifecycleCallbacks);
  }
  
  public void registerComponentCallbacks(ComponentCallbacks paramComponentCallbacks)
  {
    if (this.mApplicationReal == null)
    {
      super.registerComponentCallbacks(paramComponentCallbacks);
      return;
    }
    this.mApplicationReal.registerComponentCallbacks(paramComponentCallbacks);
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    if (this.mApplicationReal == null) {
      return super.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
    }
    return this.mApplicationReal.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, String paramString, Handler paramHandler)
  {
    if (this.mApplicationReal == null) {
      return super.registerReceiver(paramBroadcastReceiver, paramIntentFilter, paramString, paramHandler);
    }
    return this.mApplicationReal.registerReceiver(paramBroadcastReceiver, paramIntentFilter, paramString, paramHandler);
  }
  
  public void removeStickyBroadcast(Intent paramIntent)
  {
    if (this.mApplicationReal == null)
    {
      super.removeStickyBroadcast(paramIntent);
      return;
    }
    this.mApplicationReal.removeStickyBroadcast(paramIntent);
  }
  
  public void revokeUriPermission(Uri paramUri, int paramInt)
  {
    if (this.mApplicationReal == null)
    {
      super.revokeUriPermission(paramUri, paramInt);
      return;
    }
    this.mApplicationReal.revokeUriPermission(paramUri, paramInt);
  }
  
  public void sendBroadcast(Intent paramIntent)
  {
    if (this.mApplicationReal == null)
    {
      super.sendBroadcast(paramIntent);
      return;
    }
    this.mApplicationReal.sendBroadcast(paramIntent);
  }
  
  public void sendBroadcast(Intent paramIntent, String paramString)
  {
    if (this.mApplicationReal == null)
    {
      super.sendBroadcast(paramIntent, paramString);
      return;
    }
    this.mApplicationReal.sendBroadcast(paramIntent, paramString);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString)
  {
    if (this.mApplicationReal == null)
    {
      super.sendBroadcast(paramIntent, paramString);
      return;
    }
    this.mApplicationReal.sendOrderedBroadcast(paramIntent, paramString);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString1, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString2, Bundle paramBundle)
  {
    if (this.mApplicationReal == null)
    {
      super.sendOrderedBroadcast(paramIntent, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
      return;
    }
    this.mApplicationReal.sendOrderedBroadcast(paramIntent, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
  }
  
  public void sendStickyBroadcast(Intent paramIntent)
  {
    if (this.mApplicationReal == null)
    {
      super.sendStickyBroadcast(paramIntent);
      return;
    }
    this.mApplicationReal.sendStickyBroadcast(paramIntent);
  }
  
  public void sendStickyOrderedBroadcast(Intent paramIntent, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.mApplicationReal == null)
    {
      super.sendStickyOrderedBroadcast(paramIntent, paramBroadcastReceiver, paramHandler, paramInt, paramString, paramBundle);
      return;
    }
    this.mApplicationReal.sendStickyOrderedBroadcast(paramIntent, paramBroadcastReceiver, paramHandler, paramInt, paramString, paramBundle);
  }
  
  public void setTheme(int paramInt)
  {
    if (this.mApplicationReal == null)
    {
      super.setTheme(paramInt);
      return;
    }
    this.mApplicationReal.setTheme(paramInt);
  }
  
  public void setWallpaper(Bitmap paramBitmap)
  {
    if (this.mApplicationReal == null)
    {
      super.setWallpaper(paramBitmap);
      return;
    }
    this.mApplicationReal.setWallpaper(paramBitmap);
  }
  
  public void setWallpaper(InputStream paramInputStream)
  {
    if (this.mApplicationReal == null)
    {
      super.setWallpaper(paramInputStream);
      return;
    }
    this.mApplicationReal.setWallpaper(paramInputStream);
  }
  
  public void startActivities(Intent[] paramArrayOfIntent)
  {
    if (this.mApplicationReal == null)
    {
      super.startActivities(paramArrayOfIntent);
      return;
    }
    this.mApplicationReal.startActivities(paramArrayOfIntent);
  }
  
  public void startActivity(Intent paramIntent)
  {
    if (this.mApplicationReal == null)
    {
      super.startActivity(paramIntent);
      return;
    }
    this.mApplicationReal.startActivity(paramIntent);
  }
  
  public boolean startInstrumentation(ComponentName paramComponentName, String paramString, Bundle paramBundle)
  {
    if (this.mApplicationReal == null) {
      return super.startInstrumentation(paramComponentName, paramString, paramBundle);
    }
    return this.mApplicationReal.startInstrumentation(paramComponentName, paramString, paramBundle);
  }
  
  public void startIntentSender(IntentSender paramIntentSender, Intent paramIntent, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mApplicationReal == null)
    {
      super.startIntentSender(paramIntentSender, paramIntent, paramInt1, paramInt2, paramInt3);
      return;
    }
    this.mApplicationReal.startIntentSender(paramIntentSender, paramIntent, paramInt1, paramInt2, paramInt3);
  }
  
  public ComponentName startService(Intent paramIntent)
  {
    if (this.mApplicationReal == null) {
      return super.startService(paramIntent);
    }
    return this.mApplicationReal.startService(paramIntent);
  }
  
  public boolean stopService(Intent paramIntent)
  {
    if (this.mApplicationReal == null) {
      return super.stopService(paramIntent);
    }
    return this.mApplicationReal.stopService(paramIntent);
  }
  
  public void unbindService(ServiceConnection paramServiceConnection)
  {
    if (this.mApplicationReal == null)
    {
      super.unbindService(paramServiceConnection);
      return;
    }
    this.mApplicationReal.unbindService(paramServiceConnection);
  }
  
  public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks paramActivityLifecycleCallbacks)
  {
    if (this.mApplicationReal == null)
    {
      super.unregisterActivityLifecycleCallbacks(paramActivityLifecycleCallbacks);
      return;
    }
    this.mApplicationReal.unregisterActivityLifecycleCallbacks(paramActivityLifecycleCallbacks);
  }
  
  public void unregisterComponentCallbacks(ComponentCallbacks paramComponentCallbacks)
  {
    if (this.mApplicationReal == null)
    {
      super.unregisterComponentCallbacks(paramComponentCallbacks);
      return;
    }
    this.mApplicationReal.unregisterComponentCallbacks(paramComponentCallbacks);
  }
  
  public void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    if (this.mApplicationReal == null)
    {
      super.unregisterReceiver(paramBroadcastReceiver);
      return;
    }
    this.mApplicationReal.unregisterReceiver(paramBroadcastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qfix.ApplicationDelegate
 * JD-Core Version:    0.7.0.1
 */