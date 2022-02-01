package com.tencent.mobileqq.kandian.biz.account.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/account/api/IRIJUserProtoUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "check", "", "context", "Landroid/content/Context;", "afterSuccess", "Ljava/lang/Runnable;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJUserProtoUtils
  extends QRouteApi
{
  public abstract boolean check(@NotNull Context paramContext, @Nullable Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.api.IRIJUserProtoUtils
 * JD-Core Version:    0.7.0.1
 */