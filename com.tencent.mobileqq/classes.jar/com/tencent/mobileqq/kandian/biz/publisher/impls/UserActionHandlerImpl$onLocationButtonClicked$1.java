package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.bean.LocationInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "hasPermission", "", "invoke"}, k=3, mv={1, 1, 16})
final class UserActionHandlerImpl$onLocationButtonClicked$1
  extends Lambda
  implements Function1<Boolean, Unit>
{
  UserActionHandlerImpl$onLocationButtonClicked$1(UserActionHandlerImpl paramUserActionHandlerImpl, Activity paramActivity, LocationInfo paramLocationInfo)
  {
    super(1);
  }
  
  public final void invoke(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      UserActionHandlerImpl.a(this.this$0, this.$activity, this.$originLocationInfo);
      QLog.i("UserActionHandlerImpl", 1, "request position permissions, grant");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.UserActionHandlerImpl.onLocationButtonClicked.1
 * JD-Core Version:    0.7.0.1
 */