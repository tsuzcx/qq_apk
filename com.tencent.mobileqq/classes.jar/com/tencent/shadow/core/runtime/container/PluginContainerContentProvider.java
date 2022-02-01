package com.tencent.shadow.core.runtime.container;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;

public class PluginContainerContentProvider
  extends ContentProvider
{
  private static final String TAG = "ContentProvider_";
  private HostContentProviderDelegate hostContentProviderDelegate;
  
  public PluginContainerContentProvider()
  {
    ContentProviderDelegateProviderHolder.setDelegateProviderHolderPrepareListener(new PluginContainerContentProvider.1(this));
  }
  
  private void checkHostContentProviderDelegate()
  {
    if (this.hostContentProviderDelegate != null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hostContentProviderDelegate is null ,请检查ContentProviderDelegateProviderHolder.setDelegateProviderHolderPrepareListener是否调用，或");
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append(" 是否和插件在同一进程");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int bulkInsert(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    checkHostContentProviderDelegate();
    HostContentProviderDelegate localHostContentProviderDelegate = this.hostContentProviderDelegate;
    if (localHostContentProviderDelegate != null) {
      return localHostContentProviderDelegate.bulkInsert(paramUri, paramArrayOfContentValues);
    }
    return 0;
  }
  
  public Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    checkHostContentProviderDelegate();
    HostContentProviderDelegate localHostContentProviderDelegate = this.hostContentProviderDelegate;
    if (localHostContentProviderDelegate != null) {
      return localHostContentProviderDelegate.call(paramString1, paramString2, paramBundle);
    }
    return null;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    checkHostContentProviderDelegate();
    HostContentProviderDelegate localHostContentProviderDelegate = this.hostContentProviderDelegate;
    if (localHostContentProviderDelegate != null) {
      return localHostContentProviderDelegate.delete(paramUri, paramString, paramArrayOfString);
    }
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    checkHostContentProviderDelegate();
    HostContentProviderDelegate localHostContentProviderDelegate = this.hostContentProviderDelegate;
    if (localHostContentProviderDelegate != null) {
      return localHostContentProviderDelegate.getType(paramUri);
    }
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    checkHostContentProviderDelegate();
    HostContentProviderDelegate localHostContentProviderDelegate = this.hostContentProviderDelegate;
    if (localHostContentProviderDelegate != null) {
      return localHostContentProviderDelegate.insert(paramUri, paramContentValues);
    }
    return null;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    HostContentProviderDelegate localHostContentProviderDelegate = this.hostContentProviderDelegate;
    if (localHostContentProviderDelegate != null) {
      localHostContentProviderDelegate.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public boolean onCreate()
  {
    return false;
  }
  
  public void onLowMemory()
  {
    HostContentProviderDelegate localHostContentProviderDelegate = this.hostContentProviderDelegate;
    if (localHostContentProviderDelegate != null) {
      localHostContentProviderDelegate.onLowMemory();
    }
  }
  
  public void onTrimMemory(int paramInt)
  {
    HostContentProviderDelegate localHostContentProviderDelegate = this.hostContentProviderDelegate;
    if (localHostContentProviderDelegate != null) {
      localHostContentProviderDelegate.onTrimMemory(paramInt);
    }
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    checkHostContentProviderDelegate();
    HostContentProviderDelegate localHostContentProviderDelegate = this.hostContentProviderDelegate;
    if (localHostContentProviderDelegate != null) {
      return localHostContentProviderDelegate.openFile(paramUri, paramString);
    }
    return super.openFile(paramUri, paramString);
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString, CancellationSignal paramCancellationSignal)
  {
    checkHostContentProviderDelegate();
    HostContentProviderDelegate localHostContentProviderDelegate = this.hostContentProviderDelegate;
    if (localHostContentProviderDelegate != null) {
      return localHostContentProviderDelegate.openFile(paramUri, paramString, paramCancellationSignal);
    }
    return super.openFile(paramUri, paramString);
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    checkHostContentProviderDelegate();
    HostContentProviderDelegate localHostContentProviderDelegate = this.hostContentProviderDelegate;
    if (localHostContentProviderDelegate != null) {
      return localHostContentProviderDelegate.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    }
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    checkHostContentProviderDelegate();
    HostContentProviderDelegate localHostContentProviderDelegate = this.hostContentProviderDelegate;
    if (localHostContentProviderDelegate != null) {
      return localHostContentProviderDelegate.update(paramUri, paramContentValues, paramString, paramArrayOfString);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.container.PluginContainerContentProvider
 * JD-Core Version:    0.7.0.1
 */