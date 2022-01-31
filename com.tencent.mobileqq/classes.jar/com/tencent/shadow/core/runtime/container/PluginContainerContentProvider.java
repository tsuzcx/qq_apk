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
    if (this.hostContentProviderDelegate == null) {
      throw new IllegalArgumentException("hostContentProviderDelegate is null ,请检查ContentProviderDelegateProviderHolder.setDelegateProviderHolderPrepareListener是否调用，或" + getClass().getSimpleName() + " 是否和插件在同一进程");
    }
  }
  
  public int bulkInsert(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    checkHostContentProviderDelegate();
    if (this.hostContentProviderDelegate != null) {
      return this.hostContentProviderDelegate.bulkInsert(paramUri, paramArrayOfContentValues);
    }
    return 0;
  }
  
  public Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    checkHostContentProviderDelegate();
    if (this.hostContentProviderDelegate != null) {
      return this.hostContentProviderDelegate.call(paramString1, paramString2, paramBundle);
    }
    return null;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    checkHostContentProviderDelegate();
    if (this.hostContentProviderDelegate != null) {
      return this.hostContentProviderDelegate.delete(paramUri, paramString, paramArrayOfString);
    }
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    checkHostContentProviderDelegate();
    if (this.hostContentProviderDelegate != null) {
      return this.hostContentProviderDelegate.getType(paramUri);
    }
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    checkHostContentProviderDelegate();
    if (this.hostContentProviderDelegate != null) {
      return this.hostContentProviderDelegate.insert(paramUri, paramContentValues);
    }
    return null;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.hostContentProviderDelegate != null) {
      this.hostContentProviderDelegate.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public boolean onCreate()
  {
    return false;
  }
  
  public void onLowMemory()
  {
    if (this.hostContentProviderDelegate != null) {
      this.hostContentProviderDelegate.onLowMemory();
    }
  }
  
  public void onTrimMemory(int paramInt)
  {
    if (this.hostContentProviderDelegate != null) {
      this.hostContentProviderDelegate.onTrimMemory(paramInt);
    }
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    checkHostContentProviderDelegate();
    if (this.hostContentProviderDelegate != null) {
      return this.hostContentProviderDelegate.openFile(paramUri, paramString);
    }
    return super.openFile(paramUri, paramString);
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString, CancellationSignal paramCancellationSignal)
  {
    checkHostContentProviderDelegate();
    if (this.hostContentProviderDelegate != null) {
      return this.hostContentProviderDelegate.openFile(paramUri, paramString, paramCancellationSignal);
    }
    return super.openFile(paramUri, paramString);
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    checkHostContentProviderDelegate();
    if (this.hostContentProviderDelegate != null) {
      return this.hostContentProviderDelegate.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    }
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    checkHostContentProviderDelegate();
    if (this.hostContentProviderDelegate != null) {
      return this.hostContentProviderDelegate.update(paramUri, paramContentValues, paramString, paramArrayOfString);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.container.PluginContainerContentProvider
 * JD-Core Version:    0.7.0.1
 */