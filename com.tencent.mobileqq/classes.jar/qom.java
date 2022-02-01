import android.os.Bundle;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.push.RIJPushNotifyModule.Companion.instance.2;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/push/RIJPushNotifyModule;", "", "()V", "requestUpdatePushStatus", "", "isOpenPushNotify", "", "isDefaultOpen", "uin", "", "type", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "errorCode", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qom
{
  @NotNull
  private static final Lazy a;
  public static final qon a;
  
  static
  {
    jdField_a_of_type_Qon = new qon(null);
    jdField_a_of_type_KotlinLazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0)RIJPushNotifyModule.Companion.instance.2.INSTANCE);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, @NotNull String paramString, int paramInt, @NotNull Function1<? super Integer, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    QLog.i("RIJPushNotifyModule", 1, "requestUpdatePushStatus " + "isOpenPushNotify: " + paramBoolean1 + ", isDefaultOpen: " + paramBoolean2 + ", " + "uin: " + paramString + ", type: " + paramInt);
    oidb_0xe9d.ReqBody localReqBody = new oidb_0xe9d.ReqBody();
    localReqBody.bool_default_on.set(paramBoolean2);
    localReqBody.string_request_param.set("{\"type\":" + paramInt + ",\"unique_id\":[\"" + paramString + "\"]}");
    localReqBody.bool_special_follow.set(paramBoolean1);
    nmb.a(pay.a(), (nmf)new qoo(paramFunction1), localReqBody.toByteArray(), "OidbSvc.0xe9d", 3741, 1, new Bundle(), 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qom
 * JD-Core Version:    0.7.0.1
 */