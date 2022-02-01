package com.tencent.mobileqq.kandian.biz.account.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.account.api.IRIJUserProtoUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.userproto.ReadInjoyUserProtocolWidget;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/account/api/impl/RIJUserProtoUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/account/api/IRIJUserProtoUtils;", "()V", "check", "", "context", "Landroid/content/Context;", "afterSuccess", "Ljava/lang/Runnable;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJUserProtoUtilsImpl
  implements IRIJUserProtoUtils
{
  public boolean check(@NotNull Context paramContext, @Nullable Runnable paramRunnable)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qq_readinjoy_user_protocol_agreed_");
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication().runtime");
    localStringBuilder.append(((AppRuntime)localObject).getAccount());
    boolean bool1 = localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("qq_readinjoy_user_protocol_92_switch_");
    localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication().runtime");
    localStringBuilder.append(((AppRuntime)localObject).getAccount());
    boolean bool2 = Intrinsics.areEqual(localSharedPreferences.getString(localStringBuilder.toString(), "0"), "1");
    if ((!bool1) && (bool2))
    {
      new ReadInjoyUserProtocolWidget(paramContext, paramRunnable).show();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800992C", "0X800992C", 0, 0, "", "", "", "");
      return false;
    }
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.api.impl.RIJUserProtoUtilsImpl
 * JD-Core Version:    0.7.0.1
 */