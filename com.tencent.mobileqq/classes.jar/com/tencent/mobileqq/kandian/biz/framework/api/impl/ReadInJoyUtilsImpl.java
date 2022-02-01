package com.tencent.mobileqq.kandian.biz.framework.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.base.utils.RIJDeviceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJDisplayStyleManager;
import com.tencent.mobileqq.kandian.base.utils.RIJNetworkUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.view.api.impl.KanDianOptUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyLegacyUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.CallCommentJs;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.RIJCreateArticleInfoForBiu;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.push.RIJLockScreenPushReport;
import com.tencent.mobileqq.kandian.biz.push.RIJMergeKanDianMessage;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotification;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.RIJWeiShiLegacyUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJKanDianTabReport;
import com.tencent.mobileqq.kandian.glue.report.RIJStatisticCollectorReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.utils.RIJPreParseData;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJStudyModeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import com.tencent.mobileqq.kandian.repo.follow.FollowListInfoModule;
import com.tencent.mobileqq.kandian.repo.follow.IFollowStatusObserver;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/framework/api/impl/ReadInJoyUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/framework/api/IReadInJoyUtils;", "()V", "asyncWriteDataToSP", "", "key", "", "obj", "", "accountRelated", "", "calcVisibleItemCount", "recentListHeight", "", "res", "Landroid/content/res/Resources;", "canJumpFeedsForHasKeyguard", "mr", "Lcom/tencent/mobileqq/data/MessageRecord;", "checkGotoProfileOrShowAcntNotCoherentDlg", "activity", "Landroid/app/Activity;", "app", "Lcom/tencent/common/app/AppInterface;", "profileParams", "createArticleInfoForBiu", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "jsonStr", "createStructingMsgBrief", "articleInfo", "getAccount", "getAppRuntime", "Lmqq/app/AppRuntime;", "getDetailNetworkInfo", "", "context", "Landroid/content/Context;", "getEncryptUin", "getIMEIForReport", "getIMSIForReport", "getKanDianMode", "getLongAccountUin", "", "getMergeKanDianPosInMsgTab", "getSpecAggregateAvatarForKanDian", "Landroid/graphics/drawable/Drawable;", "oriIcon", "getUnSecrecyInfo", "text", "getUserMode", "getVideoParamFromJson", "jsonString", "handConversationToHide", "handConversationToShow", "handNet2Wifi", "isAppOnForeground", "isDailySceneType", "isDeleteNewKandian", "isInKanDian", "isMainFrameInit", "isStructMsgJumpForUG", "msg", "isSupportNative", "url", "channelID", "isWeiShiAccount", "uin", "isWendaCardViewType", "jumpTo", "scheme", "jumpToUrl", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;", "needForceNotification", "needKanDianNotification", "needNotificationForeground", "obtainMergeKanDianFolderStatus", "queryFollowStatus", "observer", "Lcom/tencent/mobileqq/kandian/repo/follow/IFollowStatusObserver;", "reportForLockScreenEnter", "kanDianRedDotInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/KandianRedDotInfo;", "reportForLockScreenExposure", "messageFacade", "message", "intent", "Landroid/content/Intent;", "reportForReadInJoyTabExposure", "redTypeInfo", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo;", "reportKandianTabExposureFor81C3", "reportRealTimeKanDianAction", "action", "articleId", "strategyId", "algId", "pUin", "folderStatus", "reportWebRenderPluginEventCost", "success", "stepEvent", "isCanRender", "costFromClick", "setIsShowPopup", "isShowPopup", "setStatusBar", "Lcom/tencent/mobileqq/app/QBaseActivity;", "shouldGetIndividualTimePush", "showReadInJoyNativeCommentView", "json", "Lorg/json/JSONObject;", "callbackId", "callCommentJs", "Lcom/tencent/mobileqq/kandian/biz/fastweb/CallCommentJs;", "startWebFastActivity", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyUtilsImpl
  implements IReadInJoyUtils
{
  public void asyncWriteDataToSP(@NotNull String paramString, @NotNull Object paramObject, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    Intrinsics.checkParameterIsNotNull(paramObject, "obj");
    RIJSPUtils.a(paramString, paramObject, paramBoolean);
  }
  
  public void calcVisibleItemCount(float paramFloat, @NotNull Resources paramResources)
  {
    Intrinsics.checkParameterIsNotNull(paramResources, "res");
    RIJDisplayStyleManager.INSTANCE.calcVisibleItemCount(paramFloat, paramResources);
  }
  
  public boolean canJumpFeedsForHasKeyguard(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "mr");
    return RIJMergeKanDianMessage.a(paramMessageRecord);
  }
  
  public void checkGotoProfileOrShowAcntNotCoherentDlg(@Nullable Activity paramActivity, @Nullable AppInterface paramAppInterface, @Nullable Object paramObject)
  {
    ReadInJoyLegacyUtils.a(paramActivity, paramAppInterface, (ProfileParams)paramObject);
  }
  
  @NotNull
  public AbsBaseArticleInfo createArticleInfoForBiu(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "jsonStr");
    paramString = RIJCreateArticleInfoForBiu.a(paramString);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "RIJCreateArticleInfoForB…rticleInfoForBiu(jsonStr)");
    return paramString;
  }
  
  @Nullable
  public String createStructingMsgBrief(@Nullable AppInterface paramAppInterface, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return RIJWeiShiLegacyUtils.a(paramAppInterface, paramAbsBaseArticleInfo);
  }
  
  @NotNull
  public String getAccount()
  {
    String str = RIJQQAppInterfaceUtil.d();
    Intrinsics.checkExpressionValueIsNotNull(str, "RIJQQAppInterfaceUtil.getAccount()");
    return str;
  }
  
  @NotNull
  public AppRuntime getAppRuntime()
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    Intrinsics.checkExpressionValueIsNotNull(localAppRuntime, "RIJQQAppInterfaceUtil.getAppRuntime()");
    return localAppRuntime;
  }
  
  public int getDetailNetworkInfo(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return RIJNetworkUtils.d(paramContext);
  }
  
  @Nullable
  public String getEncryptUin()
  {
    return ReadInJoyUtils.a();
  }
  
  @NotNull
  public String getIMEIForReport()
  {
    return RIJDeviceUtil.a();
  }
  
  @NotNull
  public String getIMSIForReport()
  {
    return RIJDeviceUtil.b();
  }
  
  public int getKanDianMode()
  {
    return RIJAppSetting.b();
  }
  
  public long getLongAccountUin()
  {
    return RIJQQAppInterfaceUtil.c();
  }
  
  public int getMergeKanDianPosInMsgTab()
  {
    return RIJMergeKanDianMessage.a();
  }
  
  @NotNull
  public Drawable getSpecAggregateAvatarForKanDian(@NotNull Drawable paramDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable, "oriIcon");
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      paramDrawable = RIJTransMergeKanDianReport.a((QQAppInterface)localAppRuntime, paramDrawable);
      Intrinsics.checkExpressionValueIsNotNull(paramDrawable, "RIJTransMergeKanDianRepo… QQAppInterface, oriIcon)");
      return paramDrawable;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  @NotNull
  public String getUnSecrecyInfo(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    paramString = RIJAppSetting.b(paramString);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "RIJAppSetting.getUnSecrecyInfo(text)");
    return paramString;
  }
  
  public int getUserMode()
  {
    return RIJStudyModeUtils.d();
  }
  
  @Nullable
  public String getVideoParamFromJson(@Nullable String paramString, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return RIJPreParseData.b(paramString, paramAbsBaseArticleInfo);
  }
  
  public void handConversationToHide()
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      RIJAppSetting.e((QQAppInterface)localAppRuntime);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void handConversationToShow()
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      RIJAppSetting.d((QQAppInterface)localAppRuntime);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void handNet2Wifi()
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      RIJAppSetting.a((QQAppInterface)localAppRuntime);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public boolean isAppOnForeground(@Nullable Context paramContext)
  {
    return ReadInJoyUtils.a(paramContext);
  }
  
  public boolean isDailySceneType(@Nullable MessageRecord paramMessageRecord)
  {
    return RIJLockScreenPushReport.a(paramMessageRecord);
  }
  
  public boolean isDeleteNewKandian()
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null) {
      return ReadInJoyUtils.a((AppInterface)localAppRuntime);
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public boolean isInKanDian()
  {
    return RIJAppSetting.g();
  }
  
  public boolean isMainFrameInit()
  {
    return KanDianOptUtils.INSTANCE.isMainFrameInInit();
  }
  
  public boolean isStructMsgJumpForUG(@Nullable Object paramObject)
  {
    if ((paramObject instanceof AbsStructMsg)) {
      return ReadInJoyUtils.a((AbsStructMsg)paramObject);
    }
    return false;
  }
  
  public boolean isSupportNative(@Nullable String paramString, long paramLong, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyUtils.a(paramString, paramLong, paramAbsBaseArticleInfo);
  }
  
  public boolean isWeiShiAccount(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    return TextUtils.equals((CharSequence)AppConstants.WEISHI_UIN, (CharSequence)paramString);
  }
  
  public boolean isWendaCardViewType(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    return RIJFeedsType.z(paramAbsBaseArticleInfo);
  }
  
  public int jumpTo(@NotNull Context paramContext, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "scheme");
    paramContext = RIJJumpUtils.a(paramContext, paramString, null);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "RIJJumpUtils.jumpTo(context, scheme, null)");
    return paramContext.intValue();
  }
  
  @Nullable
  public Integer jumpToUrl(@Nullable Context paramContext, @Nullable String paramString)
  {
    return ReadInJoyUtils.b(paramContext, paramString);
  }
  
  public boolean needForceNotification(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "mr");
    return RIJPushNotification.a(paramMessageRecord);
  }
  
  public boolean needKanDianNotification(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "mr");
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null) {
      return RIJPushNotification.a((QQAppInterface)localAppRuntime, paramMessageRecord);
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public boolean needNotificationForeground()
  {
    return RIJPushNotification.a();
  }
  
  public void obtainMergeKanDianFolderStatus() {}
  
  public boolean queryFollowStatus(@Nullable String paramString, @Nullable IFollowStatusObserver paramIFollowStatusObserver)
  {
    return FollowListInfoModule.a(paramString, paramIFollowStatusObserver);
  }
  
  public void reportForLockScreenEnter() {}
  
  public void reportForLockScreenEnter(@NotNull KandianRedDotInfo paramKandianRedDotInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramKandianRedDotInfo, "kanDianRedDotInfo");
    RIJLockScreenPushReport.a(paramKandianRedDotInfo);
  }
  
  public void reportForLockScreenExposure(@NotNull Object paramObject, @Nullable MessageRecord paramMessageRecord, @NotNull Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "messageFacade");
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    RIJLockScreenPushReport.a((QQMessageFacade)paramObject, paramMessageRecord, paramIntent);
  }
  
  public void reportForReadInJoyTabExposure(@Nullable BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      RIJKanDianTabReport.a((QQAppInterface)localAppRuntime, paramRedTypeInfo);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void reportKandianTabExposureFor81C3() {}
  
  public void reportRealTimeKanDianAction(int paramInt1, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "articleId");
    Intrinsics.checkParameterIsNotNull(paramString2, "strategyId");
    Intrinsics.checkParameterIsNotNull(paramString3, "algId");
    Intrinsics.checkParameterIsNotNull(paramString4, "pUin");
    RIJFrameworkReportManager.a(paramInt1, paramString1, paramString2, paramString3, paramString4, paramInt2);
  }
  
  public void reportWebRenderPluginEventCost(boolean paramBoolean, @NotNull String paramString, int paramInt, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "stepEvent");
    RIJStatisticCollectorReport.a(RIJQQAppInterfaceUtil.e(), paramBoolean, paramString, paramInt, paramLong);
  }
  
  public void setIsShowPopup(boolean paramBoolean)
  {
    ReadInJoyUtils.b = paramBoolean;
  }
  
  public void setStatusBar(@NotNull QBaseActivity paramQBaseActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "activity");
    RIJAppSetting.a(paramQBaseActivity);
  }
  
  public boolean shouldGetIndividualTimePush()
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null) {
      return RIJMergeKanDianMessage.d((QQAppInterface)localAppRuntime);
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void showReadInJoyNativeCommentView(@Nullable JSONObject paramJSONObject, @Nullable String paramString, @Nullable CallCommentJs paramCallCommentJs)
  {
    ReadInJoyLegacyUtils.a(paramJSONObject, paramString, paramCallCommentJs);
  }
  
  public void startWebFastActivity(@NotNull Activity paramActivity, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    RIJJumpUtils.a(paramActivity, paramAbsBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.api.impl.ReadInJoyUtilsImpl
 * JD-Core Version:    0.7.0.1
 */