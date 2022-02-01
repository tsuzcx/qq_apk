package com.tencent.qcircle.shadow.core.runtime;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CancellationSignal;

public class ResolverHook
{
  public static int bulkInsert(ContentResolver paramContentResolver, Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    return paramContentResolver.bulkInsert(UriConverter.parse(paramUri.toString()), paramArrayOfContentValues);
  }
  
  public static Bundle call(ContentResolver paramContentResolver, Uri paramUri, String paramString1, String paramString2, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    return paramContentResolver.call(UriConverter.parseCall(paramUri.toString(), localBundle), paramString1, paramString2, localBundle);
  }
  
  public static int delete(ContentResolver paramContentResolver, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return paramContentResolver.delete(UriConverter.parse(paramUri.toString()), paramString, paramArrayOfString);
  }
  
  public static Uri insert(ContentResolver paramContentResolver, Uri paramUri, ContentValues paramContentValues)
  {
    return paramContentResolver.insert(UriConverter.parse(paramUri.toString()), paramContentValues);
  }
  
  @TargetApi(26)
  public static Cursor query(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString, Bundle paramBundle, CancellationSignal paramCancellationSignal)
  {
    return paramContentResolver.query(UriConverter.parse(paramUri.toString()), paramArrayOfString, paramBundle, paramCancellationSignal);
  }
  
  public static Cursor query(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return paramContentResolver.query(UriConverter.parse(paramUri.toString()), paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  public static Cursor query(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, CancellationSignal paramCancellationSignal)
  {
    paramUri = UriConverter.parse(paramUri.toString());
    if (Build.VERSION.SDK_INT >= 16) {
      return paramContentResolver.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramCancellationSignal);
    }
    return null;
  }
  
  public static int update(ContentResolver paramContentResolver, Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return paramContentResolver.update(UriConverter.parse(paramUri.toString()), paramContentValues, paramString, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.ResolverHook
 * JD-Core Version:    0.7.0.1
 */