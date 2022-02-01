package com.tencent.mobileqq.kandian.biz.share.api;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/share/api/IReadInJoyShareManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "KEY_SAHRE_DATA", "", "getKEY_SAHRE_DATA", "()Ljava/lang/String;", "addShareCallBack", "", "shareCallBack", "Lcom/tencent/mobileqq/kandian/biz/share/api/ShareCallBack;", "jumpToReadInJoyShare", "", "context", "Landroid/content/Context;", "params", "Landroid/os/Bundle;", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "requestCode", "", "removeShareCallBack", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyShareManager
  extends QRouteApi
{
  public abstract void addShareCallBack(@NotNull ShareCallBack paramShareCallBack);
  
  @NotNull
  public abstract String getKEY_SAHRE_DATA();
  
  public abstract boolean jumpToReadInJoyShare(@Nullable Context paramContext, @Nullable Bundle paramBundle, @Nullable DialogInterface.OnDismissListener paramOnDismissListener, int paramInt);
  
  public abstract void removeShareCallBack(@NotNull ShareCallBack paramShareCallBack);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.api.IReadInJoyShareManager
 * JD-Core Version:    0.7.0.1
 */