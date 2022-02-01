package com.tencent.mobileqq.kandian.biz.publisher.impls;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.tkd.topicsdk.interfaces.IAccount;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/AccountImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/IAccount;", "()V", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "getApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "getUserId", "", "isLogin", "", "login", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class AccountImpl
  implements IAccount
{
  private final QQAppInterface b()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    if (localObject != null) {
      return (QQAppInterface)localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  @NotNull
  public String a()
  {
    String str = b().getAccount();
    Intrinsics.checkExpressionValueIsNotNull(str, "app.account");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.AccountImpl
 * JD-Core Version:    0.7.0.1
 */