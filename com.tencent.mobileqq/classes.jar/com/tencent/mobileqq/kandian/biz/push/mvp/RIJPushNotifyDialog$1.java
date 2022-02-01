package com.tencent.mobileqq.kandian.biz.push.mvp;

import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyParam;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/push/mvp/RIJPushNotifyDialog$1", "Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;", "onChannelRefreshed", "", "success", "", "channelID", "", "articleSeqList", "", "", "noMoreData", "onPushNotifyDialogDismiss", "needAnimation", "uin", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJPushNotifyDialog$1
  extends ReadInJoyObserver
{
  public void a(boolean paramBoolean1, int paramInt, @Nullable List<Long> paramList, boolean paramBoolean2)
  {
    this.a.b(true);
    RIJPushNotifyDialog.b(this.a).g().invoke(Boolean.valueOf(false), Boolean.valueOf(RIJPushNotifyDialog.c(this.a)), Integer.valueOf(0));
  }
  
  public void a_(boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    if ((Intrinsics.areEqual(paramString, RIJPushNotifyDialog.b(this.a).d())) || (Intrinsics.areEqual(paramString, "MATCH_ALL_UIN")))
    {
      this.a.b(paramBoolean);
      RIJPushNotifyDialog.b(this.a).g().invoke(Boolean.valueOf(false), Boolean.valueOf(RIJPushNotifyDialog.c(this.a)), Integer.valueOf(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.mvp.RIJPushNotifyDialog.1
 * JD-Core Version:    0.7.0.1
 */