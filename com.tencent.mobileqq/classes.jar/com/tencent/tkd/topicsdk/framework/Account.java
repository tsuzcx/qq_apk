package com.tencent.tkd.topicsdk.framework;

import com.tencent.tkd.topicsdk.interfaces.IAccount;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/Account;", "", "()V", "isLogin", "", "()Z", "mAccountImpl", "Lcom/tencent/tkd/topicsdk/interfaces/IAccount;", "userId", "", "getUserId", "()Ljava/lang/String;", "init", "", "account", "login", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
public final class Account
{
  public static final Account a;
  private static IAccount a;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkFrameworkAccount = new Account();
  }
  
  @NotNull
  public final String a()
  {
    Object localObject = jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIAccount;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAccountImpl");
    }
    localObject = ((IAccount)localObject).a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mAccountImpl.userId");
    return localObject;
  }
  
  public final void a(@NotNull IAccount paramIAccount)
  {
    Intrinsics.checkParameterIsNotNull(paramIAccount, "account");
    jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIAccount = paramIAccount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.Account
 * JD-Core Version:    0.7.0.1
 */