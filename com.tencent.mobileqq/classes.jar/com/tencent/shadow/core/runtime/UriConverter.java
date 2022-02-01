package com.tencent.shadow.core.runtime;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import com.tencent.shadow.core.runtime.qcircle.container.DelegateProvider;
import com.tencent.shadow.core.runtime.qcircle.container.DelegateProviderHolder;

public class UriConverter
{
  public static Uri build(Uri.Builder paramBuilder)
  {
    return parse(paramBuilder.build().toString());
  }
  
  public static Bundle call(ContentResolver paramContentResolver, Uri paramUri, String paramString1, String paramString2, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    return paramContentResolver.call(parseCall(paramUri.toString(), localBundle), paramString1, paramString2, localBundle);
  }
  
  public static void notifyChange(ContentResolver paramContentResolver, Uri paramUri, ContentObserver paramContentObserver)
  {
    paramContentResolver.notifyChange(parse(paramUri.toString()), paramContentObserver);
  }
  
  @TargetApi(26)
  public static void notifyChange(ContentResolver paramContentResolver, Uri paramUri, ContentObserver paramContentObserver, int paramInt)
  {
    paramContentResolver.notifyChange(parse(paramUri.toString()), paramContentObserver, paramInt);
  }
  
  public static void notifyChange(ContentResolver paramContentResolver, Uri paramUri, ContentObserver paramContentObserver, boolean paramBoolean)
  {
    paramContentResolver.notifyChange(parse(paramUri.toString()), paramContentObserver, paramBoolean);
  }
  
  public static Uri parse(String paramString)
  {
    DelegateProvider localDelegateProvider = DelegateProviderHolder.getDelegateProvider();
    if ((localDelegateProvider != null) && (localDelegateProvider.getUriParseDelegate() != null)) {
      return localDelegateProvider.getUriParseDelegate().parse(paramString);
    }
    return Uri.parse(paramString);
  }
  
  public static Uri parseCall(String paramString, Bundle paramBundle)
  {
    DelegateProvider localDelegateProvider = DelegateProviderHolder.getDelegateProvider();
    if ((localDelegateProvider != null) && (localDelegateProvider.getUriParseDelegate() != null)) {
      return localDelegateProvider.getUriParseDelegate().parseCall(paramString, paramBundle);
    }
    return Uri.parse(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.UriConverter
 * JD-Core Version:    0.7.0.1
 */