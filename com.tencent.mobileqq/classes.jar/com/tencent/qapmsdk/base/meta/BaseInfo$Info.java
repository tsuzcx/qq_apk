package com.tencent.qapmsdk.base.meta;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qapmsdk.base.dbpersist.DBHelper;
import com.tencent.qapmsdk.base.dbpersist.DBHelper.Companion;
import com.tencent.qapmsdk.base.reporter.uploaddata.verifier.QAPMNameVerifier;
import com.tencent.qapmsdk.common.ssl.NameVerifierFactory;
import com.tencent.qapmsdk.common.util.AsyncSPEditor;
import com.tencent.qapmsdk.common.util.FileUtil;
import com.tencent.qapmsdk.common.util.FileUtil.Companion;
import javax.net.ssl.HostnameVerifier;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/meta/BaseInfo$Info;", "", "()V", "app", "Landroid/app/Application;", "dbHelper", "Lcom/tencent/qapmsdk/base/dbpersist/DBHelper;", "editor", "Lcom/tencent/qapmsdk/common/util/AsyncSPEditor;", "pubJson", "Lorg/json/JSONObject;", "sharePreference", "Landroid/content/SharedPreferences;", "token", "", "urlMeta", "Lcom/tencent/qapmsdk/base/meta/UrlMeta;", "userMeta", "Lcom/tencent/qapmsdk/base/meta/UserMeta;", "initInfo", "", "initUrl", "reset", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class BaseInfo$Info
{
  @JvmStatic
  public final void initInfo()
  {
    Application localApplication = BaseInfo.app;
    if (localApplication != null)
    {
      FileUtil.Companion.setApp(localApplication);
      NameVerifierFactory.INSTANCE.setNameVerifier((HostnameVerifier)new QAPMNameVerifier());
      BaseInfo.sharePreference = localApplication.getSharedPreferences("QAPM_SP", 0);
      Object localObject1 = BaseInfo.sharePreference;
      if (localObject1 != null) {
        localObject1 = ((SharedPreferences)localObject1).edit();
      } else {
        localObject1 = null;
      }
      BaseInfo.editor = new AsyncSPEditor((SharedPreferences.Editor)localObject1);
      localObject1 = BaseInfo.userMeta.uin;
      Object localObject2 = "10000";
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
      localObject1 = DBHelper.Companion;
      localObject2 = localApplication.getApplicationContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "it.applicationContext");
      BaseInfo.dbHelper = ((DBHelper.Companion)localObject1).getInstance((Context)localObject2);
      BaseInfo.pubJson = new JSONObject(BaseInfo.userMeta.toJSON());
    }
  }
  
  @JvmStatic
  public final void initUrl()
  {
    UrlMeta localUrlMeta = BaseInfo.urlMeta;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseInfo.urlMeta.qapmDomain);
    localStringBuilder.append("/appconfig/v5/config/");
    localStringBuilder.append(BaseInfo.userMeta.appId);
    localStringBuilder.append('/');
    localUrlMeta.setConfigUrl(localStringBuilder.toString());
    localUrlMeta = BaseInfo.urlMeta;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseInfo.urlMeta.qapmDomain);
    localStringBuilder.append("/entrance/");
    localStringBuilder.append(BaseInfo.userMeta.appId);
    localStringBuilder.append("/authorize/");
    localUrlMeta.setAuthorizationUrl(localStringBuilder.toString());
    localUrlMeta = BaseInfo.urlMeta;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseInfo.urlMeta.qapmDomain);
    localStringBuilder.append("/entrance/");
    localStringBuilder.append(BaseInfo.userMeta.appId);
    localStringBuilder.append("/uploadJson/");
    localUrlMeta.setJsonUploadUrl(localStringBuilder.toString());
    localUrlMeta = BaseInfo.urlMeta;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseInfo.urlMeta.qapmDomain);
    localStringBuilder.append("/entrance/");
    localStringBuilder.append(BaseInfo.userMeta.appId);
    localStringBuilder.append("/uploadFile/");
    localUrlMeta.setFileUploadUrl(localStringBuilder.toString());
    localUrlMeta = BaseInfo.urlMeta;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseInfo.urlMeta.athenaDomain);
    localStringBuilder.append("entrance/uploadJson/");
    localStringBuilder.append(BaseInfo.userMeta.appId);
    localStringBuilder.append('/');
    localStringBuilder.append(BaseInfo.userMeta.version);
    localStringBuilder.append('/');
    localUrlMeta.setAthenaJsonUploadUrl(localStringBuilder.toString());
    localUrlMeta = BaseInfo.urlMeta;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseInfo.urlMeta.athenaDomain);
    localStringBuilder.append("entrance/uploadFile/");
    localStringBuilder.append(BaseInfo.userMeta.appId);
    localStringBuilder.append('/');
    localStringBuilder.append(BaseInfo.userMeta.version);
    localStringBuilder.append('/');
    localUrlMeta.setAthenaFileUploadUrl(localStringBuilder.toString());
  }
  
  @JvmStatic
  public final void reset()
  {
    ((Info)this).initUrl();
    BaseInfo.pubJson = new JSONObject(BaseInfo.userMeta.toJSON());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.meta.BaseInfo.Info
 * JD-Core Version:    0.7.0.1
 */