package com.tencent.mobileqq.miniapp;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;
import mqq.app.AppRuntime;

public class AKOfflineDownloader
  extends IDownloader
{
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append(OfflineEnvHelper.b(paramString1));
      paramString2.append(paramString1);
      return paramString2.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(OfflineEnvHelper.b(paramString1));
    localStringBuilder.append(paramString1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  private static void b(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    MiniAppEvent localMiniAppEvent = new MiniAppEvent();
    int i;
    if ("MiniAppLauncher".equals(paramString2)) {
      i = 1;
    } else {
      i = 5;
    }
    localMiniAppEvent.c = i;
    localMiniAppEvent.b = paramBoolean;
    localMiniAppEvent.d = paramString2;
    if (paramBoolean) {
      localMiniAppEvent.e = new Object[] { paramString1, paramObject, Integer.valueOf(paramInt), a(paramString3, "") };
    } else {
      localMiniAppEvent.e = new Object[] { paramString1, paramObject, Integer.valueOf(paramInt) };
    }
    if (localMiniAppEvent.c == 1)
    {
      StoryDispatcher.a().dispatch("MiniAppManager", localMiniAppEvent);
      return;
    }
    StoryDispatcher.a().dispatch(localMiniAppEvent);
  }
  
  public void a(String paramString1, String paramString2, Object paramObject)
  {
    String str = paramString1.substring(3);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null)
    {
      b(false, paramString1, paramString2, -1, str, paramObject);
      return;
    }
    HtmlOffline.b(str, localAppRuntime, new AKOfflineDownloader.1(this, str, paramString1, paramString2, paramObject, System.currentTimeMillis()), true, 0, true);
  }
  
  protected boolean a(Bundle paramBundle)
  {
    boolean bool2 = false;
    if (paramBundle == null) {
      return false;
    }
    String str = paramBundle.getString("bid");
    paramBundle = paramBundle.getString("path");
    boolean bool1 = bool2;
    if (HtmlOffline.h(str))
    {
      bool1 = bool2;
      if (OfflineSecurity.a(paramBundle, str)) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.AKOfflineDownloader
 * JD-Core Version:    0.7.0.1
 */