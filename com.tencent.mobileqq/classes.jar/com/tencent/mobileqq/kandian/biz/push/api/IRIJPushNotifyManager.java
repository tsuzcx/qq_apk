package com.tencent.mobileqq.kandian.biz.push.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/push/api/IRIJPushNotifyManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "dismiss", "", "needAnimation", "", "uin", "", "showPushNotifyDialog", "guideType", "", "avatarUrl", "uniqueId", "bizType", "showPushNotifyDialogForWeb", "isDarkMode", "hasNightMode", "callback", "Lcom/tencent/mobileqq/kandian/biz/push/api/IPushNotifyDialogCallback;", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJPushNotifyManager
  extends QRouteApi
{
  public static final IRIJPushNotifyManager.Companion Companion = IRIJPushNotifyManager.Companion.a;
  @NotNull
  public static final String MATCH_ALL_UIN = "MATCH_ALL_UIN";
  
  public abstract void dismiss(boolean paramBoolean, @NotNull String paramString);
  
  public abstract void showPushNotifyDialog(int paramInt1, @NotNull String paramString1, @NotNull String paramString2, int paramInt2);
  
  public abstract void showPushNotifyDialogForWeb(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, @NotNull String paramString1, int paramInt2, @NotNull String paramString2, @NotNull IPushNotifyDialogCallback paramIPushNotifyDialogCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.api.IRIJPushNotifyManager
 * JD-Core Version:    0.7.0.1
 */