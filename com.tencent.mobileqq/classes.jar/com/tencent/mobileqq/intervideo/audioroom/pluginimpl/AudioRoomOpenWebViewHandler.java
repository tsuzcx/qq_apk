package com.tencent.mobileqq.intervideo.audioroom.pluginimpl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/intervideo/audioroom/pluginimpl/AudioRoomOpenWebViewHandler;", "", "()V", "openWebView", "", "bundle", "Landroid/os/Bundle;", "setCookieIfNeed", "url", "", "startBrowserActivity", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class AudioRoomOpenWebViewHandler
{
  public static final AudioRoomOpenWebViewHandler INSTANCE = new AudioRoomOpenWebViewHandler();
  
  private final void a(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = new Intent(((BaseApplicationImpl)localObject).getBaseContext(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramString);
    ((Intent)localObject).addFlags(268435456);
    paramString = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "BaseApplicationImpl.getApplication()");
    paramString.getBaseContext().startActivity((Intent)localObject);
  }
  
  private final void a(String paramString, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("cookie");
    if (paramBundle != null)
    {
      Object localObject = (CharSequence)paramBundle;
      int i;
      if (((CharSequence)localObject).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 1)
      {
        paramBundle = BaseApplicationImpl.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(paramBundle, "BaseApplicationImpl.getApplication()");
        CookieSyncManager.createInstance(paramBundle.getBaseContext());
        paramBundle = Uri.parse(paramString);
        Intrinsics.checkExpressionValueIsNotNull(paramBundle, "Uri.parse(url)");
        paramBundle = paramBundle.getHost();
        if (paramBundle != null) {
          paramString = paramBundle;
        }
        paramBundle = ((Iterable)StringsKt.split$default((CharSequence)localObject, new String[] { ";" }, false, 0, 6, null)).iterator();
        while (paramBundle.hasNext())
        {
          localObject = (String)paramBundle.next();
          CookieManager.getInstance().setCookie(paramString, (String)localObject);
        }
        CookieSyncManager.getInstance().sync();
      }
    }
  }
  
  @JvmStatic
  public static final void openWebView(@NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "bundle");
    String str = paramBundle.getString("url");
    if (str != null)
    {
      int i;
      if (((CharSequence)str).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 1)
      {
        INSTANCE.a(str, paramBundle);
        INSTANCE.a(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.pluginimpl.AudioRoomOpenWebViewHandler
 * JD-Core Version:    0.7.0.1
 */