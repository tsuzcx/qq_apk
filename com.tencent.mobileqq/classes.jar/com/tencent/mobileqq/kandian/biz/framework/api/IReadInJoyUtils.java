package com.tencent.mobileqq.kandian.biz.framework.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.fastweb.CallCommentJs;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import com.tencent.mobileqq.kandian.repo.follow.IFollowStatusObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/framework/api/IReadInJoyUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "asyncWriteDataToSP", "", "key", "", "obj", "", "accountRelated", "", "calcVisibleItemCount", "recentListHeight", "", "res", "Landroid/content/res/Resources;", "canJumpFeedsForHasKeyguard", "mr", "Lcom/tencent/mobileqq/data/MessageRecord;", "checkGotoProfileOrShowAcntNotCoherentDlg", "activity", "Landroid/app/Activity;", "app", "Lcom/tencent/common/app/AppInterface;", "profileParams", "createArticleInfoForBiu", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "jsonStr", "createStructingMsgBrief", "articleInfo", "getAccount", "getAppRuntime", "Lmqq/app/AppRuntime;", "getDetailNetworkInfo", "", "context", "Landroid/content/Context;", "getEncryptUin", "getIMEIForReport", "getIMSIForReport", "getKanDianMode", "getLongAccountUin", "", "getMergeKanDianPosInMsgTab", "getSpecAggregateAvatarForKanDian", "Landroid/graphics/drawable/Drawable;", "oriIcon", "getUnSecrecyInfo", "text", "getUserMode", "getVideoParamFromJson", "jsonString", "handConversationToHide", "handConversationToShow", "handNet2Wifi", "isAppOnForeground", "isDailySceneType", "isDeleteNewKandian", "isInKanDian", "isMainFrameInit", "isStructMsgJumpForUG", "msg", "isSupportNative", "url", "channelID", "isWeiShiAccount", "uin", "isWendaCardViewType", "jumpTo", "scheme", "jumpToUrl", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;", "needForceNotification", "needKanDianNotification", "needNotificationForeground", "obtainMergeKanDianFolderStatus", "queryFollowStatus", "observer", "Lcom/tencent/mobileqq/kandian/repo/follow/IFollowStatusObserver;", "reportForLockScreenEnter", "kanDianRedDotInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/KandianRedDotInfo;", "reportForLockScreenExposure", "messageFacade", "message", "intent", "Landroid/content/Intent;", "reportForReadInJoyTabExposure", "redTypeInfo", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo;", "reportKandianTabExposureFor81C3", "reportRealTimeKanDianAction", "action", "articleId", "strategyId", "algId", "pUin", "folderStatus", "reportWebRenderPluginEventCost", "success", "stepEvent", "isCanRender", "costFromClick", "setIsShowPopup", "isShowPopup", "setStatusBar", "Lcom/tencent/mobileqq/app/QBaseActivity;", "shouldGetIndividualTimePush", "showReadInJoyNativeCommentView", "json", "Lorg/json/JSONObject;", "callbackId", "callCommentJs", "Lcom/tencent/mobileqq/kandian/biz/fastweb/CallCommentJs;", "startWebFastActivity", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyUtils
  extends QRouteApi
{
  public abstract void asyncWriteDataToSP(@NotNull String paramString, @NotNull Object paramObject, boolean paramBoolean);
  
  public abstract void calcVisibleItemCount(float paramFloat, @NotNull Resources paramResources);
  
  public abstract boolean canJumpFeedsForHasKeyguard(@NotNull MessageRecord paramMessageRecord);
  
  public abstract void checkGotoProfileOrShowAcntNotCoherentDlg(@Nullable Activity paramActivity, @Nullable AppInterface paramAppInterface, @Nullable Object paramObject);
  
  @NotNull
  public abstract AbsBaseArticleInfo createArticleInfoForBiu(@NotNull String paramString);
  
  @Nullable
  public abstract String createStructingMsgBrief(@Nullable AppInterface paramAppInterface, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  @NotNull
  public abstract String getAccount();
  
  @NotNull
  public abstract AppRuntime getAppRuntime();
  
  public abstract int getDetailNetworkInfo(@NotNull Context paramContext);
  
  @Nullable
  public abstract String getEncryptUin();
  
  @NotNull
  public abstract String getIMEIForReport();
  
  @NotNull
  public abstract String getIMSIForReport();
  
  public abstract int getKanDianMode();
  
  public abstract long getLongAccountUin();
  
  public abstract int getMergeKanDianPosInMsgTab();
  
  @NotNull
  public abstract Drawable getSpecAggregateAvatarForKanDian(@NotNull Drawable paramDrawable);
  
  @NotNull
  public abstract String getUnSecrecyInfo(@NotNull String paramString);
  
  public abstract int getUserMode();
  
  @Nullable
  public abstract String getVideoParamFromJson(@Nullable String paramString, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract void handConversationToHide();
  
  public abstract void handConversationToShow();
  
  public abstract void handNet2Wifi();
  
  public abstract boolean isAppOnForeground(@Nullable Context paramContext);
  
  public abstract boolean isDailySceneType(@Nullable MessageRecord paramMessageRecord);
  
  public abstract boolean isDeleteNewKandian();
  
  public abstract boolean isInKanDian();
  
  public abstract boolean isMainFrameInit();
  
  public abstract boolean isStructMsgJumpForUG(@Nullable Object paramObject);
  
  public abstract boolean isSupportNative(@Nullable String paramString, long paramLong, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isWeiShiAccount(@NotNull String paramString);
  
  public abstract boolean isWendaCardViewType(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract int jumpTo(@NotNull Context paramContext, @NotNull String paramString);
  
  @Nullable
  public abstract Integer jumpToUrl(@Nullable Context paramContext, @Nullable String paramString);
  
  public abstract boolean needForceNotification(@NotNull MessageRecord paramMessageRecord);
  
  public abstract boolean needKanDianNotification(@NotNull MessageRecord paramMessageRecord);
  
  public abstract boolean needNotificationForeground();
  
  public abstract void obtainMergeKanDianFolderStatus();
  
  public abstract boolean queryFollowStatus(@Nullable String paramString, @Nullable IFollowStatusObserver paramIFollowStatusObserver);
  
  public abstract void reportForLockScreenEnter();
  
  public abstract void reportForLockScreenEnter(@NotNull KandianRedDotInfo paramKandianRedDotInfo);
  
  public abstract void reportForLockScreenExposure(@NotNull Object paramObject, @Nullable MessageRecord paramMessageRecord, @NotNull Intent paramIntent);
  
  public abstract void reportForReadInJoyTabExposure(@Nullable BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo);
  
  public abstract void reportKandianTabExposureFor81C3();
  
  public abstract void reportRealTimeKanDianAction(int paramInt1, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, int paramInt2);
  
  public abstract void reportWebRenderPluginEventCost(boolean paramBoolean, @NotNull String paramString, int paramInt, long paramLong);
  
  public abstract void setIsShowPopup(boolean paramBoolean);
  
  public abstract void setStatusBar(@NotNull QBaseActivity paramQBaseActivity);
  
  public abstract boolean shouldGetIndividualTimePush();
  
  public abstract void showReadInJoyNativeCommentView(@Nullable JSONObject paramJSONObject, @Nullable String paramString, @Nullable CallCommentJs paramCallCommentJs);
  
  public abstract void startWebFastActivity(@NotNull Activity paramActivity, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils
 * JD-Core Version:    0.7.0.1
 */