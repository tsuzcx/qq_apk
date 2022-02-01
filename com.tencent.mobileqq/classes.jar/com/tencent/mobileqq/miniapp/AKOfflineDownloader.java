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
    if (TextUtils.isEmpty(paramString2)) {
      return OfflineEnvHelper.a(paramString1) + paramString1;
    }
    return OfflineEnvHelper.a(paramString1) + paramString1 + File.separator + paramString2;
  }
  
  private static void b(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    MiniAppEvent localMiniAppEvent = new MiniAppEvent();
    int i;
    if ("MiniAppLauncher".equals(paramString2))
    {
      i = 1;
      localMiniAppEvent.jdField_a_of_type_Int = i;
      localMiniAppEvent.jdField_a_of_type_Boolean = paramBoolean;
      localMiniAppEvent.jdField_a_of_type_JavaLangString = paramString2;
      if (!paramBoolean) {
        break label107;
      }
    }
    label107:
    for (localMiniAppEvent.jdField_a_of_type_ArrayOfJavaLangObject = new Object[] { paramString1, paramObject, Integer.valueOf(paramInt), a(paramString3, "") };; localMiniAppEvent.jdField_a_of_type_ArrayOfJavaLangObject = new Object[] { paramString1, paramObject, Integer.valueOf(paramInt) })
    {
      if (localMiniAppEvent.jdField_a_of_type_Int != 1) {
        break label135;
      }
      StoryDispatcher.a().dispatch("MiniAppManager", localMiniAppEvent);
      return;
      i = 5;
      break;
    }
    label135:
    StoryDispatcher.a().dispatch(localMiniAppEvent);
  }
  
  public void a(String paramString1, String paramString2, Object paramObject)
  {
    String str = paramString1.substring("ak:".length());
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
    if (paramBundle == null) {}
    String str;
    do
    {
      return false;
      str = paramBundle.getString("bid");
      paramBundle = paramBundle.getString("path");
    } while ((!HtmlOffline.c(str)) || (!OfflineSecurity.a(paramBundle, str)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.AKOfflineDownloader
 * JD-Core Version:    0.7.0.1
 */