package com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp;

import android.text.TextUtils;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AskAnonymouslyUtil;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AskAnonymouslyUtil.Companion;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/bussiness/anonymous/jsp/AskAnonymouslyApiPlugin;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "()V", "handleJsRequest", "", "listener", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "url", "", "pkgName", "method", "args", "", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class AskAnonymouslyApiPlugin
  extends WebViewPlugin
{
  public static final int CALL_SHARE_ACTIVITY = 0;
  public static final AskAnonymouslyApiPlugin.Companion Companion = new AskAnonymouslyApiPlugin.Companion(null);
  public static final int DO_NOT_CALL_SHARE_ACTIVITY = 1;
  public static final int INVITE_FOR_FRIEND_AND_GROUP = 0;
  public static final int INVITE_FOR_QZONE = 1;
  @NotNull
  public static final String KEY_IMAGE_URL = "image_url";
  @NotNull
  public static final String KEY_INVITE_TYPE = "invite_type";
  @NotNull
  public static final String KEY_JUMP_URL = "jump_url";
  @NotNull
  public static final String KEY_SHARE_TYPE = "share_type";
  @NotNull
  public static final String METHOD_INVITE = "invite";
  @NotNull
  public static final String METHOD_SHARE_DETAIL_TO_QZONE = "shareDetailToQZone";
  @NotNull
  public static final String NAME_SPACE = "askanonymously";
  @NotNull
  public static final String TAG = "AskAnonymouslyApiPlugin";
  
  public AskAnonymouslyApiPlugin()
  {
    this.mPluginNameSpace = "askanonymously";
  }
  
  public boolean handleJsRequest(@Nullable JsBridgeListener paramJsBridgeListener, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @NotNull String... paramVarArgs)
  {
    Object localObject3 = null;
    paramJsBridgeListener = null;
    Object localObject1 = null;
    Object localObject2 = null;
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    if (TextUtils.isEmpty((CharSequence)paramString1))
    {
      QLog.e("AskAnonymouslyApiPlugin", 1, "Call askanonymously jsapi error, url is empty");
      return false;
    }
    int i;
    if (StringsKt.equals(paramString2, "askanonymously", true))
    {
      if (StringsKt.equals("invite", paramString3, true))
      {
        if (QLog.isColorLevel()) {
          QLog.i("AskAnonymouslyApiPlugin", 2, "Call method invite");
        }
        try
        {
          i = new JSONObject(paramVarArgs[0]).optInt("invite_type", 0);
          if (i == 0)
          {
            paramString1 = AskAnonymouslyUtil.Companion;
            paramString2 = this.mRuntime;
            paramJsBridgeListener = localObject2;
            if (paramString2 != null) {
              paramJsBridgeListener = paramString2.a();
            }
            paramString1.inviteAskAnonymously(paramJsBridgeListener, false);
          }
          else if (i == 1)
          {
            paramString1 = AskAnonymouslyUtil.Companion;
            paramString2 = this.mRuntime;
            paramJsBridgeListener = localObject3;
            if (paramString2 != null) {
              paramJsBridgeListener = paramString2.a();
            }
            paramString1.shareInviteToQZone(paramJsBridgeListener);
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          QLog.e("AskAnonymouslyApiPlugin", 2, paramJsBridgeListener.getMessage(), (Throwable)paramJsBridgeListener);
        }
        QLog.e("AskAnonymouslyApiPlugin", 2, "invite inviteType invalid: " + i);
      }
      else
      {
        if (StringsKt.equals("shareDetailToQZone", paramString3, true)) {
          if (QLog.isColorLevel()) {
            QLog.i("AskAnonymouslyApiPlugin", 2, "Call method invite");
          }
        }
        for (;;)
        {
          try
          {
            paramString3 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString3.optString("jump_url");
            paramString2 = paramString3.optString("image_url");
            i = paramString3.optInt("share_type", 0);
            if (i != 0) {
              continue;
            }
            paramString3 = AskAnonymouslyUtil.Companion;
            paramVarArgs = this.mRuntime;
            if (paramVarArgs != null) {
              paramJsBridgeListener = paramVarArgs.a();
            }
            paramString3.shareDetailToQZone(paramJsBridgeListener, paramString2, paramString1);
          }
          catch (JSONException paramJsBridgeListener)
          {
            QLog.e("AskAnonymouslyApiPlugin", 2, paramJsBridgeListener.getMessage(), (Throwable)paramJsBridgeListener);
            continue;
            QLog.e("AskAnonymouslyApiPlugin", 2, "shareDetailToQZone shareType invalid: " + i);
            continue;
          }
          QLog.e("AskAnonymouslyApiPlugin", 1, "Call askanonymously jsapi error, method not match");
          return false;
          if (i != 1) {
            continue;
          }
          paramString3 = AskAnonymouslyUtil.Companion;
          paramVarArgs = this.mRuntime;
          paramJsBridgeListener = localObject1;
          if (paramVarArgs != null) {
            paramJsBridgeListener = paramVarArgs.a();
          }
          paramString3.syncDetailToQZone(paramJsBridgeListener, paramString2, paramString1);
        }
      }
    }
    else
    {
      QLog.e("AskAnonymouslyApiPlugin", 1, "Call askanonymously jsapi error, package not match");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin
 * JD-Core Version:    0.7.0.1
 */