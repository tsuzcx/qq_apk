package com.tencent.mobileqq.kandian.repo.account.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.repo.account.IUserLevelCallBack;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.account.api.IRIJUserLevelModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/account/api/impl/RIJUserLevelModuleImpl;", "Lcom/tencent/mobileqq/kandian/repo/account/api/IRIJUserLevelModule;", "()V", "doActionsByUserLevel", "", "context", "Landroid/content/Context;", "operType", "", "userLevelCallBack", "Lcom/tencent/mobileqq/kandian/repo/account/IUserLevelCallBack;", "requestUserLevel", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJUserLevelModuleImpl
  implements IRIJUserLevelModule
{
  public RIJUserLevelModuleImpl()
  {
    RIJUserLevelModule localRIJUserLevelModule = RIJUserLevelModule.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localRIJUserLevelModule, "RIJUserLevelModule.getInstance()");
    this.$$delegate_0 = localRIJUserLevelModule;
  }
  
  public boolean doActionsByUserLevel(@Nullable Context paramContext, int paramInt, @Nullable IUserLevelCallBack paramIUserLevelCallBack)
  {
    return this.$$delegate_0.doActionsByUserLevel(paramContext, paramInt, paramIUserLevelCallBack);
  }
  
  public void requestUserLevel(int paramInt, @Nullable IUserLevelCallBack paramIUserLevelCallBack)
  {
    this.$$delegate_0.requestUserLevel(paramInt, paramIUserLevelCallBack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.account.api.impl.RIJUserLevelModuleImpl
 * JD-Core Version:    0.7.0.1
 */