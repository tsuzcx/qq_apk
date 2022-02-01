import android.content.Context;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspGetFollowTabData;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspTrace;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/model/ArticleInfoModuleUtils;", "", "()V", "getDeviceID", "", "getNetType", "", "getSubscriptionArticleIdStr", "", "articleIdList", "", "", "handleRealStyle", "", "serviceKey", "stylePbData", "Lcom/tencent/mobileqq/pb/PBBytesField;", "isChannelDataExcludeFollowChannel", "", "clientSwitch", "resp", "Ltencent/im/oidb/cmd0x68b/oidb_cmd0x68b$RspBody;", "isFollowChannelClientSwitch", "isVideoRealtimeReplaceReq", "report68BTrace", "rspTrace", "Ltencent/im/oidb/cmd0x68b/oidb_cmd0x68b$RspTrace;", "CommonChannelDataHandle", "FollowChannelDataHandler", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qer
{
  public static final qer a = new qer();
  
  @JvmStatic
  public static final int a()
  {
    switch (NetworkUtil.getSystemNetwork((Context)BaseApplication.getContext()))
    {
    default: 
      return 0;
    case 0: 
      return 0;
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 4: 
      return 3;
    }
    return 4;
  }
  
  @JvmStatic
  @NotNull
  public static final String a(@Nullable List<Long> paramList)
  {
    Object localObject = (Collection)paramList;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i != 0; i = 0) {
      return "";
    }
    localObject = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      long l = ((Number)paramList.next()).longValue();
      ((StringBuilder)localObject).append(l + ' ');
    }
    paramList = ((StringBuilder)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramList, "sb.toString()");
    return paramList;
  }
  
  @JvmStatic
  @Nullable
  public static final byte[] a()
  {
    String str = pkh.b();
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localObject = ((String)localObject).getBytes(Charsets.UTF_8);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.String).getBytes(charset)");
    return localObject;
  }
  
  public final void a(@Nullable Object paramObject, @NotNull PBBytesField paramPBBytesField)
  {
    Intrinsics.checkParameterIsNotNull(paramPBBytesField, "stylePbData");
    paramPBBytesField = qxl.a(paramPBBytesField);
    if ((paramPBBytesField != null) && ((paramObject instanceof String))) {
      tmt.a((String)paramObject, paramPBBytesField);
    }
  }
  
  public final void a(@NotNull oidb_cmd0x68b.RspTrace paramRspTrace)
  {
    Intrinsics.checkParameterIsNotNull(paramRspTrace, "rspTrace");
    if (paramRspTrace.has()) {
      pqe.a(pkh.a(), paramRspTrace.rpt_trace_record_list.get());
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
 * Qualified Name:     qer
 * JD-Core Version:    0.7.0.1
 */