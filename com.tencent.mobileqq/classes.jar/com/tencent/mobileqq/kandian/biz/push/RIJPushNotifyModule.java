package com.tencent.mobileqq.kandian.biz.push;

import android.os.Bundle;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.protofile.oidb_0xe9d.oidb_0xe9d.ReqBody;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/push/RIJPushNotifyModule;", "", "()V", "requestUpdatePushStatus", "", "isOpenPushNotify", "", "isDefaultOpen", "uin", "", "type", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "errorCode", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJPushNotifyModule
{
  public static final RIJPushNotifyModule.Companion a = new RIJPushNotifyModule.Companion(null);
  @NotNull
  private static final Lazy b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0)RIJPushNotifyModule.Companion.instance.2.INSTANCE);
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, @NotNull String paramString, int paramInt, @NotNull Function1<? super Integer, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestUpdatePushStatus ");
    ((StringBuilder)localObject).append("isOpenPushNotify: ");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(", isDefaultOpen: ");
    ((StringBuilder)localObject).append(paramBoolean2);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append("uin: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", type: ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("RIJPushNotifyModule", 1, ((StringBuilder)localObject).toString());
    localObject = new oidb_0xe9d.ReqBody();
    ((oidb_0xe9d.ReqBody)localObject).bool_default_on.set(paramBoolean2);
    PBStringField localPBStringField = ((oidb_0xe9d.ReqBody)localObject).string_request_param;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"type\":");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",\"unique_id\":[\"");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\"]}");
    localPBStringField.set(localStringBuilder.toString());
    ((oidb_0xe9d.ReqBody)localObject).bool_special_follow.set(paramBoolean1);
    ProtoUtils.a(ReadInJoyUtils.b(), (ProtoUtils.TroopProtocolObserver)new RIJPushNotifyModule.requestUpdatePushStatus.1(paramFunction1), ((oidb_0xe9d.ReqBody)localObject).toByteArray(), "OidbSvc.0xe9d", 3741, 1, new Bundle(), 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyModule
 * JD-Core Version:    0.7.0.1
 */