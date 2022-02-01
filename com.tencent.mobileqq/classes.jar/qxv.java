import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.CoinPresentReq;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.MetaData;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.ReqBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTaskRemoteRepo;", "", "()V", "reportTaskCompleted", "", "rowKey", "", "type", "", "reportTaskProgressCallback", "Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTaskRemoteRepo$IReportTaskProgressCallback;", "Companion", "IReportTaskProgressCallback", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qxv
{
  private static volatile qxv a;
  public static final qxw a;
  
  static
  {
    jdField_a_of_type_Qxw = new qxw(null);
  }
  
  @JvmStatic
  @NotNull
  public static final qxv b()
  {
    return jdField_a_of_type_Qxw.a();
  }
  
  public final void a(@NotNull String paramString, int paramInt, @Nullable qxx paramqxx)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    long l1 = pay.a();
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    paramString = pay.a();
    oidb_cmd0xed4.MetaData localMetaData = new oidb_cmd0xed4.MetaData();
    localMetaData.type.set(2);
    localMetaData.timestamp.set(l2);
    oidb_cmd0xed4.CoinPresentReq localCoinPresentReq = new oidb_cmd0xed4.CoinPresentReq();
    localCoinPresentReq.uin.set(l1);
    oidb_cmd0xed4.ReqBody localReqBody = new oidb_cmd0xed4.ReqBody();
    localReqBody.meta.set((MessageMicro)localMetaData);
    localReqBody.present_req.set((MessageMicro)localCoinPresentReq);
    QLog.i("RIJRewardTaskRemoteRepo", 1, "report task completed --> uin: " + l1 + ", timestamp: " + l2);
    nmb.a(paramString, (nmf)new qxy(paramqxx), localReqBody.toByteArray(), "OidbSvc.0xed4", 3796, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qxv
 * JD-Core Version:    0.7.0.1
 */