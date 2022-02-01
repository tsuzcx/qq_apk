package com.tencent.mobileqq.profilecard.bussiness.anonymous.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.tencent.mobileqq.forward.api.IForwardApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneShareApi;
import com.tencent.util.QQCustomArkDialogUtil;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/bussiness/anonymous/utils/AskAnonymouslyUtil$Companion;", "", "()V", "ARK_APP_COMPACT", "", "ARK_APP_NAME", "ARK_APP_PROMPT", "ARK_APP_VER", "ARK_APP_VIEW", "JUMP_URL", "META_BUTTON_KEY", "META_JUMP_URL_KEY", "META_META_DATA_TYPE", "META_SUMMARY_KEY", "META_TITLE_KEY", "SHARE_INVITE_TO_QZONE_BG_URL", "SHARE_TO_QZONE_ACTION_TYPE", "", "SHARE_TO_QZONE_RECOM_BOTTOM_ID", "SHARE_TO_QZONE_SUMMARY", "SHARE_TO_QZONE_TITLE", "SHARE_TYPE_DETAIL", "TAG", "constructShareData", "Lcooperation/qzone/QZoneShareData;", "imageUrl", "jumpUrl", "getAskAnonymouslyArkMeta", "getInviteAskAnonymouslyIntent", "Landroid/content/Intent;", "activity", "Landroid/app/Activity;", "showQzone", "", "getMetaString", "inviteAskAnonymously", "", "shareDetailToQZone", "shareInviteToQZone", "syncDetailToQZone", "profilecard-impl_release"}, k=1, mv={1, 1, 16})
public final class AskAnonymouslyUtil$Companion
{
  private final QZoneShareData constructShareData(String paramString1, String paramString2)
  {
    QZoneShareData localQZoneShareData = new QZoneShareData();
    localQZoneShareData.mSummary = "匿名提问，有问必答";
    localQZoneShareData.mTitle = "匿问我答";
    localQZoneShareData.mImageUrls = new ArrayList();
    localQZoneShareData.mImageUrls.add(paramString1);
    localQZoneShareData.targetUrl = paramString2;
    localQZoneShareData.from = 0;
    localQZoneShareData.qzoneShareInfo = ((Map)new HashMap());
    paramString1 = localQZoneShareData.qzoneShareInfo;
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "shareData.qzoneShareInfo");
    paramString1.put("change_big_pic", "1");
    paramString1 = localQZoneShareData.qzoneShareInfo;
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "shareData.qzoneShareInfo");
    paramString1.put("need_circular_bead", "1");
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("icon_url", "https://downv6.qq.com/qq_relation/ask_anonymously/ask_anonymously_invite_icon_to_qzone_v2.png");
      paramString1.put("title", "匿问我答");
      paramString1.put("summary", "匿名提问，有问必答");
      paramString1.put("jump_url", paramString2);
      paramString2 = MobileQQ.sMobileQQ;
      Intrinsics.checkExpressionValueIsNotNull(paramString2, "MobileQQ.sMobileQQ");
      paramString2 = paramString2.getApplicationContext();
      Intrinsics.checkExpressionValueIsNotNull(paramString2, "MobileQQ.sMobileQQ.applicationContext");
      paramString1.put("button_txt", paramString2.getResources().getString(2131699158));
      paramString1.put("recom_bottom_id", 5);
      paramString2 = paramString1.toString();
      Intrinsics.checkExpressionValueIsNotNull(paramString2, "json.toString()");
      paramString1.put("action_type", 2);
      paramString1 = localQZoneShareData.qzoneShareInfo;
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "shareData.qzoneShareInfo");
      paramString1.put("comm_recom_bottom", paramString2);
      paramString1 = new StringBuilder();
      paramString1.append("shareInviteToQZone， comm_recom_bottom： ");
      paramString1.append(paramString2);
      QLog.d("AskAnonymouslyUtil", 1, paramString1.toString());
      return localQZoneShareData;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("shareInviteToQZone exception: ");
      paramString2.append(Log.getStackTraceString((Throwable)paramString1));
      QLog.e("AskAnonymouslyUtil", 1, paramString2.toString());
    }
    return localQZoneShareData;
  }
  
  private final Intent getInviteAskAnonymouslyIntent(Activity paramActivity, boolean paramBoolean)
  {
    paramActivity = (Context)paramActivity;
    Object localObject1 = QRoute.api(IForwardApi.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "QRoute.api(IForwardApi::class.java)");
    paramActivity = new Intent(paramActivity, ((IForwardApi)localObject1).getForwardRecentActivityClass());
    try
    {
      paramActivity.putExtra("forward_type", ((IForwardApi)QRoute.api(IForwardApi.class)).SEND_ASK_ANONYMOUSLY_ARK_MSG());
      paramActivity.putExtra("is_ark_display_share", true);
      paramActivity.putExtra("forward_ark_app_name", "com.tencent.askanonymously");
      paramActivity.putExtra("forward_ark_app_view", "invite");
      paramActivity.putExtra("forward_ark_app_ver", "1.0.0.1");
      paramActivity.putExtra("forward_ark_app_prompt", "[匿问我答] 绝对坦白，等你来提问～");
      paramActivity.putExtra("forward_ark_app_compat", "[匿问我答，等你来提问～] 请使用最新版手机QQ查看");
      paramActivity.putExtra("k_qzone", paramBoolean);
      paramActivity.putExtra(((IForwardApi)QRoute.api(IForwardApi.class)).SELECTION_MODE(), ((IForwardApi)QRoute.api(IForwardApi.class)).SELECTION_MODE_MULTI());
      localObject1 = ((Companion)this).getMetaString();
      paramActivity.putExtra("forward_ark_app_meta", (String)localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getInviteAskAnonymouslyIntent metaDataString: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("AskAnonymouslyUtil", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = MobileQQ.sMobileQQ;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "MobileQQ.sMobileQQ");
      localObject2 = ((MobileQQ)localObject2).getApplicationContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "MobileQQ.sMobileQQ.applicationContext");
      localObject2 = ((Context)localObject2).getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "MobileQQ.sMobileQQ.applicationContext.resources");
      paramActivity.putExtras(QQCustomArkDialogUtil.a("com.tencent.askanonymously", "invite", "1.0.0.1", (String)localObject1, ((Resources)localObject2).getDisplayMetrics().density, null, null));
      return paramActivity;
    }
    catch (JSONException localJSONException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getInviteAskAnonymouslyIntent exception message: ");
      ((StringBuilder)localObject2).append(localJSONException.getMessage());
      QLog.e("AskAnonymouslyUtil", 1, ((StringBuilder)localObject2).toString());
    }
    return paramActivity;
  }
  
  @Nullable
  public final String getAskAnonymouslyArkMeta()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    Object localObject = StringCompanionObject.INSTANCE;
    localObject = new Object[2];
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    Intrinsics.checkExpressionValueIsNotNull(localAppRuntime, "MobileQQ.sMobileQQ.peekAppRuntime()");
    localObject[0] = localAppRuntime.getAccount();
    localObject[1] = Integer.valueOf(4);
    localObject = String.format("https://ti.qq.com/v2/anonymous/question?_wv=16777218&_wwv=129&uin=%s&from=%d", Arrays.copyOf((Object[])localObject, localObject.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
    localJSONObject2.put("jump_url", localObject);
    localJSONObject1.put("invite", localJSONObject2);
    return localJSONObject1.toString();
  }
  
  @Nullable
  public final String getMetaString()
  {
    return ((Companion)this).getAskAnonymouslyArkMeta();
  }
  
  public final void inviteAskAnonymously(@Nullable Activity paramActivity, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AskAnonymouslyUtil", 2, "inviteAskAnonymously");
    }
    if (paramActivity == null)
    {
      QLog.e("AskAnonymouslyUtil", 2, "inviteAskAnonymously error: activity is null");
      return;
    }
    Intent localIntent = ((Companion)this).getInviteAskAnonymouslyIntent(paramActivity, paramBoolean);
    if (localIntent == null)
    {
      QLog.e("AskAnonymouslyUtil", 1, "inviteAskAnonymously error: params wrong");
      return;
    }
    paramActivity.startActivity(localIntent);
  }
  
  public final void shareDetailToQZone(@Nullable Activity paramActivity, @Nullable String paramString1, @Nullable String paramString2)
  {
    if ((paramActivity != null) && (!TextUtils.isEmpty((CharSequence)paramString1)) && (!TextUtils.isEmpty((CharSequence)paramString2)))
    {
      Companion localCompanion = (Companion)this;
      if (paramString1 == null) {
        Intrinsics.throwNpe();
      }
      if (paramString2 == null) {
        Intrinsics.throwNpe();
      }
      paramString1 = localCompanion.constructShareData(paramString1, paramString2);
      paramActivity = (Context)paramActivity;
      paramString2 = MobileQQ.sMobileQQ.peekAppRuntime();
      Intrinsics.checkExpressionValueIsNotNull(paramString2, "MobileQQ.sMobileQQ.peekAppRuntime()");
      QZoneShareManager.shareToQzoneFromAskAnonymously(paramActivity, paramString2.getAccount(), paramString1, 2);
      return;
    }
    QLog.e("AskAnonymouslyUtil", 2, "shareDetailToQZone error: param is invalid");
  }
  
  public final void shareInviteToQZone(@Nullable Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AskAnonymouslyUtil", 2, "shareInviteToQZone");
    }
    if (paramActivity == null)
    {
      QLog.e("AskAnonymouslyUtil", 2, "shareInviteToQZone error: activity is null");
      return;
    }
    Object localObject1 = StringCompanionObject.INSTANCE;
    localObject1 = new Object[2];
    Object localObject2 = MobileQQ.sMobileQQ.peekAppRuntime();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "MobileQQ.sMobileQQ.peekAppRuntime()");
    localObject1[0] = ((AppRuntime)localObject2).getAccount();
    localObject1[1] = Integer.valueOf(5);
    localObject1 = String.format("https://ti.qq.com/v2/anonymous/question?_wv=16777218&_wwv=129&uin=%s&from=%d", Arrays.copyOf((Object[])localObject1, localObject1.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
    localObject2 = (Companion)this;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    localObject1 = ((Companion)localObject2).constructShareData("https://downv6.qq.com/qq_relation/ask_anonymously/ask_anonymously_invite_bg_to_qzone_v2.png", (String)localObject1);
    paramActivity = (Context)paramActivity;
    localObject2 = MobileQQ.sMobileQQ.peekAppRuntime();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "MobileQQ.sMobileQQ.peekAppRuntime()");
    QZoneShareManager.shareToQzoneFromAskAnonymously(paramActivity, ((AppRuntime)localObject2).getAccount(), (QZoneShareData)localObject1, 1);
  }
  
  public final void syncDetailToQZone(@Nullable Activity paramActivity, @Nullable String paramString1, @Nullable String paramString2)
  {
    if ((paramActivity != null) && (!TextUtils.isEmpty((CharSequence)paramString1)) && (!TextUtils.isEmpty((CharSequence)paramString2)))
    {
      Object localObject = (Companion)this;
      if (paramString1 == null) {
        Intrinsics.throwNpe();
      }
      if (paramString2 == null) {
        Intrinsics.throwNpe();
      }
      paramString1 = ((Companion)localObject).constructShareData(paramString1, paramString2);
      paramString2 = (IQzoneShareApi)QRoute.api(IQzoneShareApi.class);
      paramActivity = (Context)paramActivity;
      localObject = MobileQQ.sMobileQQ.peekAppRuntime();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "MobileQQ.sMobileQQ.peekAppRuntime()");
      paramString2.startShareServlet(paramActivity, "", ((AppRuntime)localObject).getLongAccountUin(), paramString1);
      return;
    }
    QLog.e("AskAnonymouslyUtil", 2, "syncDetailToQZone error: param is invalid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AskAnonymouslyUtil.Companion
 * JD-Core Version:    0.7.0.1
 */