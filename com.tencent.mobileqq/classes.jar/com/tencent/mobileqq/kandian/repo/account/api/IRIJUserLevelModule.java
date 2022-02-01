package com.tencent.mobileqq.kandian.repo.account.api;

import android.content.Context;
import com.tencent.mobileqq.kandian.repo.account.IUserLevelCallBack;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/account/api/IRIJUserLevelModule;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "doActionsByUserLevel", "", "context", "Landroid/content/Context;", "operType", "", "userLevelCallBack", "Lcom/tencent/mobileqq/kandian/repo/account/IUserLevelCallBack;", "requestUserLevel", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJUserLevelModule
  extends QRouteApi
{
  public abstract boolean doActionsByUserLevel(@Nullable Context paramContext, int paramInt, @Nullable IUserLevelCallBack paramIUserLevelCallBack);
  
  public abstract void requestUserLevel(int paramInt, @Nullable IUserLevelCallBack paramIUserLevelCallBack);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.account.api.IRIJUserLevelModule
 * JD-Core Version:    0.7.0.1
 */