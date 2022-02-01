package com.tencent.shadow.core.runtime.container;

import android.content.ContentValues;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;

public abstract interface HostContentProviderDelegate
{
  public abstract int bulkInsert(Uri paramUri, ContentValues[] paramArrayOfContentValues);
  
  public abstract Bundle call(String paramString1, String paramString2, Bundle paramBundle);
  
  public abstract int delete(Uri paramUri, String paramString, String[] paramArrayOfString);
  
  public abstract String getType(Uri paramUri);
  
  public abstract Uri insert(Uri paramUri, ContentValues paramContentValues);
  
  public abstract void onConfigurationChanged(Configuration paramConfiguration);
  
  public abstract boolean onCreate();
  
  public abstract void onLowMemory();
  
  public abstract void onTrimMemory(int paramInt);
  
  public abstract ParcelFileDescriptor openFile(Uri paramUri, String paramString);
  
  public abstract ParcelFileDescriptor openFile(Uri paramUri, String paramString, CancellationSignal paramCancellationSignal);
  
  public abstract Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2);
  
  public abstract int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.container.HostContentProviderDelegate
 * JD-Core Version:    0.7.0.1
 */