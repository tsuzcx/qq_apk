package com.tencent.mobileqq.kandian.biz.push;

import com.tencent.mobileqq.kandian.biz.push.api.IPushNotifyDialogCallback;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errorCode", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJPushNotifyManager$showPushNotifyDialogForWeb$param$1$1
  extends Lambda
  implements Function1<Integer, Unit>
{
  RIJPushNotifyManager$showPushNotifyDialogForWeb$param$1$1(RIJPushNotifyManager.showPushNotifyDialogForWeb.param.1 param1, int paramInt)
  {
    super(1);
  }
  
  public final void invoke(int paramInt)
  {
    this.this$0.$callback.a(this.$buttonId, paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" resultCallback buttonId: ");
    localStringBuilder.append(this.$buttonId);
    localStringBuilder.append(" errorCode: ");
    localStringBuilder.append(paramInt);
    QLog.i("RIJPushNotifyManager", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager.showPushNotifyDialogForWeb.param.1.1
 * JD-Core Version:    0.7.0.1
 */