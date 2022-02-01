package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.bean.LocationInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.QQPermissionCallback;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/publisher/impls/UserActionHandlerImpl$checkAndAskLocationPermission$1", "Lmqq/app/QQPermissionCallback;", "deny", "", "requestCode", "", "permissions", "", "", "results", "", "(I[Ljava/lang/String;[I)V", "grant", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class UserActionHandlerImpl$checkAndAskLocationPermission$1
  implements QQPermissionCallback
{
  UserActionHandlerImpl$checkAndAskLocationPermission$1(Activity paramActivity, LocationInfo paramLocationInfo) {}
  
  public void deny(int paramInt, @NotNull String[] paramArrayOfString, @NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "permissions");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "results");
    QLog.i("UserActionHandlerImpl", 1, "request position permissions, deny");
    QQToast.a((Context)this.jdField_a_of_type_AndroidAppActivity, 2131718329, 0).a();
  }
  
  public void grant(int paramInt, @NotNull String[] paramArrayOfString, @NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "permissions");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "results");
    QLog.i("UserActionHandlerImpl", 1, "request position permissions, grant");
    UserActionHandlerImpl.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPublisherImplsUserActionHandlerImpl, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanLocationInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.UserActionHandlerImpl.checkAndAskLocationPermission.1
 * JD-Core Version:    0.7.0.1
 */