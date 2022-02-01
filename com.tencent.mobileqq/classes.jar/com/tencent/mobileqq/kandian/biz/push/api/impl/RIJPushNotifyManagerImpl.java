package com.tencent.mobileqq.kandian.biz.push.api.impl;

import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager;
import com.tencent.mobileqq.kandian.biz.push.api.IPushNotifyDialogCallback;
import com.tencent.mobileqq.kandian.biz.push.api.IRIJPushNotifyManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/push/api/impl/RIJPushNotifyManagerImpl;", "Lcom/tencent/mobileqq/kandian/biz/push/api/IRIJPushNotifyManager;", "()V", "dismiss", "", "needAnimation", "", "uin", "", "showPushNotifyDialog", "guideType", "", "avatarUrl", "uniqueId", "bizType", "showPushNotifyDialogForWeb", "isDarkMode", "hasNightMode", "callback", "Lcom/tencent/mobileqq/kandian/biz/push/api/IPushNotifyDialogCallback;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJPushNotifyManagerImpl
  implements IRIJPushNotifyManager
{
  public void dismiss(boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    this.$$delegate_0.dismiss(paramBoolean, paramString);
  }
  
  public void showPushNotifyDialog(int paramInt1, @NotNull String paramString1, @NotNull String paramString2, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "avatarUrl");
    Intrinsics.checkParameterIsNotNull(paramString2, "uniqueId");
    this.$$delegate_0.showPushNotifyDialog(paramInt1, paramString1, paramString2, paramInt2);
  }
  
  public void showPushNotifyDialogForWeb(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, @NotNull String paramString1, int paramInt2, @NotNull String paramString2, @NotNull IPushNotifyDialogCallback paramIPushNotifyDialogCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "avatarUrl");
    Intrinsics.checkParameterIsNotNull(paramString2, "uniqueId");
    Intrinsics.checkParameterIsNotNull(paramIPushNotifyDialogCallback, "callback");
    this.$$delegate_0.showPushNotifyDialogForWeb(paramInt1, paramBoolean1, paramBoolean2, paramString1, paramInt2, paramString2, paramIPushNotifyDialogCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.api.impl.RIJPushNotifyManagerImpl
 * JD-Core Version:    0.7.0.1
 */