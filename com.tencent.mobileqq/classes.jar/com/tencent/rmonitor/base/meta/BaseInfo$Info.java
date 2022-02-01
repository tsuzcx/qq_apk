package com.tencent.rmonitor.base.meta;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.rmonitor.base.config.ConfigCenter;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.db.DBHelper;
import com.tencent.rmonitor.base.db.DBHelper.Companion;
import com.tencent.rmonitor.common.network.ssl.NameVerifierFactory;
import com.tencent.rmonitor.common.network.ssl.RMonitorNameVerifier;
import com.tencent.rmonitor.common.util.AppVersionHelper;
import com.tencent.rmonitor.common.util.AsyncSPEditor;
import com.tencent.rmonitor.common.util.DeviceUtil;
import com.tencent.rmonitor.common.util.FileUtil;
import com.tencent.rmonitor.common.util.FileUtil.Companion;
import com.tencent.rmonitor.common.util.StringUtil;
import java.util.UUID;
import javax.net.ssl.HostnameVerifier;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/meta/BaseInfo$Info;", "", "()V", "DEFAULT_USER_ID", "", "app", "Landroid/app/Application;", "dbHelper", "Lcom/tencent/rmonitor/base/db/DBHelper;", "editor", "Lcom/tencent/rmonitor/common/util/AsyncSPEditor;", "pubJson", "Lorg/json/JSONObject;", "sharePreference", "Landroid/content/SharedPreferences;", "token", "urlMeta", "Lcom/tencent/rmonitor/base/meta/UrlMeta;", "userMeta", "Lcom/tencent/rmonitor/base/meta/UserMeta;", "checkDeviceId", "", "application", "initInfo", "initUrl", "reset", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class BaseInfo$Info
{
  @JvmStatic
  public final void checkDeviceId(@NotNull Application paramApplication)
  {
    Intrinsics.checkParameterIsNotNull(paramApplication, "application");
    if (TextUtils.isEmpty((CharSequence)BaseInfo.userMeta.deviceId))
    {
      UserMeta localUserMeta = BaseInfo.userMeta;
      Object localObject = BaseInfo.sharePreference;
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).getString("config_device_id", "");
        if (localObject != null) {}
      }
      else
      {
        localObject = "";
      }
      localUserMeta.deviceId = ((String)localObject);
      if (TextUtils.isEmpty((CharSequence)BaseInfo.userMeta.deviceId))
      {
        if (ConfigProxy.INSTANCE.getConfig().b("CAN_COLLECT_SENSITIVE_INFO")) {
          BaseInfo.userMeta.deviceId = DeviceUtil.a(paramApplication);
        } else {
          BaseInfo.userMeta.deviceId = StringUtil.b(UUID.randomUUID().toString());
        }
        BaseInfo.editor.a("config_device_id", BaseInfo.userMeta.deviceId).b();
      }
    }
  }
  
  @JvmStatic
  public final void initInfo()
  {
    Application localApplication = BaseInfo.app;
    if (localApplication != null)
    {
      int i;
      if (((CharSequence)BaseInfo.userMeta.version).length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        BaseInfo.userMeta.version = AppVersionHelper.a.a(localApplication.getApplicationContext());
      }
      BaseInfo.userMeta.uuid = BaseInfo.userMeta.version;
      FileUtil.a.a(localApplication);
      NameVerifierFactory.b.a((HostnameVerifier)new RMonitorNameVerifier());
      BaseInfo.sharePreference = localApplication.getSharedPreferences("RMonitor_SP", 0);
      Object localObject1 = BaseInfo.sharePreference;
      if (localObject1 != null) {
        localObject1 = ((SharedPreferences)localObject1).edit();
      } else {
        localObject1 = null;
      }
      BaseInfo.editor = new AsyncSPEditor((SharedPreferences.Editor)localObject1);
      localObject1 = DBHelper.a;
      Object localObject2 = localApplication.getApplicationContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "it.applicationContext");
      BaseInfo.dbHelper = ((DBHelper.Companion)localObject1).a((Context)localObject2);
      localObject1 = BaseInfo.userMeta.uin;
      localObject2 = "10000";
      if (Intrinsics.areEqual(localObject1, "10000"))
      {
        UserMeta localUserMeta = BaseInfo.userMeta;
        Object localObject3 = BaseInfo.sharePreference;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((SharedPreferences)localObject3).getString("config_uin", "10000");
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = localObject3;
          }
        }
        localUserMeta.uin = ((String)localObject1);
      }
      BaseInfo.Info.checkDeviceId(localApplication);
      BaseInfo.pubJson = new JSONObject(BaseInfo.userMeta.toJSON());
    }
  }
  
  @JvmStatic
  public final void initUrl()
  {
    UrlMeta localUrlMeta = BaseInfo.urlMeta;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseInfo.urlMeta.rmonitorDomain);
    localStringBuilder.append("/appconfig/v5/config/");
    localStringBuilder.append(BaseInfo.userMeta.appId);
    localStringBuilder.append('/');
    localUrlMeta.setConfigUrl(localStringBuilder.toString());
    localUrlMeta = BaseInfo.urlMeta;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseInfo.urlMeta.rmonitorDomain);
    localStringBuilder.append("/entrance/");
    localStringBuilder.append(BaseInfo.userMeta.appId);
    localStringBuilder.append("/authorize/");
    localUrlMeta.setAuthorizationUrl(localStringBuilder.toString());
    localUrlMeta = BaseInfo.urlMeta;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseInfo.urlMeta.rmonitorDomain);
    localStringBuilder.append("/entrance/");
    localStringBuilder.append(BaseInfo.userMeta.appId);
    localStringBuilder.append("/uploadJson/");
    localUrlMeta.setJsonUploadUrl(localStringBuilder.toString());
    localUrlMeta = BaseInfo.urlMeta;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseInfo.urlMeta.rmonitorDomain);
    localStringBuilder.append("/entrance/");
    localStringBuilder.append(BaseInfo.userMeta.appId);
    localStringBuilder.append("/uploadFile/");
    localUrlMeta.setFileUploadUrl(localStringBuilder.toString());
  }
  
  @JvmStatic
  public final void reset()
  {
    ((Info)this).initUrl();
    BaseInfo.pubJson = new JSONObject(BaseInfo.userMeta.toJSON());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.meta.BaseInfo.Info
 * JD-Core Version:    0.7.0.1
 */