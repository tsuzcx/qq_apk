package com.tencent.qapmsdk.qapmmanager;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.qapmsdk.base.config.WhiteUrl;
import com.tencent.qapmsdk.base.config.WhiteUrl.Companion;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.BaseInfo.Info;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AppInfo;
import com.tencent.qapmsdk.common.util.AppInfo.Companion;
import com.tencent.qapmsdk.common.util.AsyncSPEditor;
import com.tencent.qapmsdk.common.util.PhoneUtil;
import com.tencent.qapmsdk.common.util.PhoneUtil.Companion;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/qapmmanager/QAPMConfigureWizard$Companion;", "", "()V", "TAG", "", "setAPMHost", "", "host", "setAppId", "id", "", "setAppKey", "key", "setApplication", "app", "Landroid/app/Application;", "setAthenaHost", "setDeviceId", "deviceId", "setLogLevel", "level", "setUin", "", "uin", "setUuid", "uuid", "setVersion", "version", "qapmmanager_release"}, k=1, mv={1, 1, 15})
public final class QAPMConfigureWizard$Companion
{
  @JvmStatic
  public final void setAPMHost(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "host");
    BaseInfo.urlMeta.qapmDomain = paramString;
    BaseInfo.Info.initUrl();
    WhiteUrl.Companion.addWhiteHost(paramString);
  }
  
  @JvmStatic
  public final void setAppId(int paramInt)
  {
    BaseInfo.userMeta.appId = paramInt;
  }
  
  @JvmStatic
  public final void setAppKey(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    BaseInfo.userMeta.appKey = paramString;
  }
  
  @JvmStatic
  public final void setApplication(@NotNull Application paramApplication)
  {
    Intrinsics.checkParameterIsNotNull(paramApplication, "app");
    BaseInfo.app = paramApplication;
    if ((TextUtils.isEmpty((CharSequence)BaseInfo.userMeta.deviceId)) && (BaseInfo.app != null)) {
      ((Companion)this).setDeviceId(PhoneUtil.Companion.generateDeviceId(BaseInfo.app));
    }
    if ((Intrinsics.areEqual("android.app.Application", paramApplication.getClass().getName()) ^ true)) {
      Logger.INSTANCE.w(new String[] { "QAPM_manager_QAPMConfigureWizard", "AppInstance is not android.app.Application." });
    }
  }
  
  @JvmStatic
  public final void setAthenaHost(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "host");
    BaseInfo.urlMeta.athenaDomain = paramString;
    BaseInfo.Info.initUrl();
    WhiteUrl.Companion.addWhiteHost(paramString);
  }
  
  @JvmStatic
  public final void setDeviceId(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "deviceId");
    BaseInfo.userMeta.deviceId = paramString;
  }
  
  @JvmStatic
  public final void setLogLevel(int paramInt)
  {
    Logger.INSTANCE.resetLogLevel(paramInt);
  }
  
  @JvmStatic
  public final boolean setUin(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    if (BaseInfo.sharePreference != null)
    {
      Object localObject1 = BaseInfo.userMeta.uin;
      String str = "10000";
      if (Intrinsics.areEqual("10000", localObject1))
      {
        UserMeta localUserMeta = BaseInfo.userMeta;
        Object localObject2 = BaseInfo.sharePreference;
        localObject1 = str;
        if (localObject2 != null)
        {
          localObject2 = ((SharedPreferences)localObject2).getString("config_uin", "10000");
          localObject1 = str;
          if (localObject2 != null) {
            localObject1 = localObject2;
          }
        }
        localUserMeta.uin = ((String)localObject1);
      }
    }
    if ((Intrinsics.areEqual(paramString, BaseInfo.userMeta.uin) ^ true))
    {
      BaseInfo.userMeta.uin = paramString;
      BaseInfo.editor.putString("config_uin", paramString).apply();
      return true;
    }
    return false;
  }
  
  @JvmStatic
  public final void setUuid(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uuid");
    if (Pattern.compile("^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$").matcher((CharSequence)paramString).find()) {
      BaseInfo.userMeta.uuid = paramString;
    }
  }
  
  @JvmStatic
  public final void setVersion(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "version");
    int i;
    if (((CharSequence)paramString).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      BaseInfo.userMeta.version = AppInfo.Companion.getAppVersion((Context)BaseInfo.app);
      return;
    }
    BaseInfo.userMeta.version = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.qapmmanager.QAPMConfigureWizard.Companion
 * JD-Core Version:    0.7.0.1
 */