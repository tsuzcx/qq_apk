package com.tencent.mobileqq.kandian.biz.share.api;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={""})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/share/api/IReadInjoyWebShareHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "showShareActionSheet", "", "activity", "Landroid/app/Activity;", "app", "Lcom/tencent/common/app/AppInterface;", "data", "Landroid/os/Bundle;", "callBack", "Lcom/tencent/mobileqq/kandian/biz/share/api/IReadInjoyWebShareHelper$CallBack;", "CallBack", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInjoyWebShareHelper
  extends QRouteApi
{
  public abstract void showShareActionSheet(@NotNull Activity paramActivity, @NotNull AppInterface paramAppInterface, @NotNull Bundle paramBundle, @NotNull IReadInjoyWebShareHelper.CallBack paramCallBack);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.api.IReadInjoyWebShareHelper
 * JD-Core Version:    0.7.0.1
 */