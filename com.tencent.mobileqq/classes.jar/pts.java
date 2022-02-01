import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspGetFollowTabData;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspTrace;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/model/AritcleInfoModuleUtils;", "", "()V", "handleRealStyle", "", "serviceKey", "stylePbData", "Lcom/tencent/mobileqq/pb/PBBytesField;", "isChannelDataExcludeFollowChannel", "", "clientSwitch", "", "resp", "Ltencent/im/oidb/cmd0x68b/oidb_cmd0x68b$RspBody;", "isFollowChannelClientSwitch", "isVideoRealtimeReplaceReq", "report68BTrace", "rspTrace", "Ltencent/im/oidb/cmd0x68b/oidb_cmd0x68b$RspTrace;", "CommonChannelDataHandle", "FollowChannelDataHandler", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class pts
{
  public static final pts a = new pts();
  
  public final void a(@Nullable Object paramObject, @NotNull PBBytesField paramPBBytesField)
  {
    Intrinsics.checkParameterIsNotNull(paramPBBytesField, "stylePbData");
    paramPBBytesField = qlg.a(paramPBBytesField);
    if ((paramPBBytesField != null) && ((paramObject instanceof String))) {
      szl.a((String)paramObject, paramPBBytesField);
    }
  }
  
  public final void a(@NotNull oidb_cmd0x68b.RspTrace paramRspTrace)
  {
    Intrinsics.checkParameterIsNotNull(paramRspTrace, "rspTrace");
    if (paramRspTrace.has()) {
      pay.a(pay.a(), paramRspTrace.rpt_trace_record_list.get());
    }
  }
  
  public final boolean a(long paramLong)
  {
    return (paramLong >> 13 & 1L) == 1L;
  }
  
  public final boolean a(long paramLong, @NotNull oidb_cmd0x68b.RspBody paramRspBody)
  {
    Intrinsics.checkParameterIsNotNull(paramRspBody, "resp");
    return ((paramLong >> 9 & 1L) == 1L) && (paramRspBody.msg_rsp_get_follow_tab_data.has());
  }
  
  public final boolean b(long paramLong, @NotNull oidb_cmd0x68b.RspBody paramRspBody)
  {
    Intrinsics.checkParameterIsNotNull(paramRspBody, "resp");
    return (!a(paramLong, paramRspBody)) && (paramRspBody.rspChannelArticle.has()) && (paramRspBody.rspChannelArticle.get() != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pts
 * JD-Core Version:    0.7.0.1
 */