package com.tencent.mobileqq.kandian.biz.comment.helper;

import com.tencent.mobileqq.kandian.biz.comment.entity.CreateCommentResult;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentNetworkHelper.RIJCreateCommentObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.SubCommentCreateRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "response", "Ltencent/im/oidb/oidb_0xd1e/oidb_0xd1e$SubCommentCreateRsp;", "errorCode", "", "<anonymous parameter 2>", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJCommentNetworkHelper$createSubComment$2
  extends Lambda
  implements Function3<oidb_0xd1e.SubCommentCreateRsp, Integer, String, Unit>
{
  RIJCommentNetworkHelper$createSubComment$2(IRIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, long paramLong1, String paramString, int paramInt, boolean paramBoolean, long paramLong2)
  {
    super(3);
  }
  
  public final void invoke(@NotNull oidb_0xd1e.SubCommentCreateRsp paramSubCommentCreateRsp, int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramSubCommentCreateRsp, "response");
    Intrinsics.checkParameterIsNotNull(paramString, "<anonymous parameter 2>");
    paramString = this.$callback;
    if (paramString != null)
    {
      CreateCommentResult localCreateCommentResult = new CreateCommentResult();
      localCreateCommentResult.a = this.$commentSeq;
      localCreateCommentResult.b = false;
      localCreateCommentResult.c = paramInt;
      localCreateCommentResult.d = 1;
      localCreateCommentResult.e = "";
      localCreateCommentResult.f = this.$commentJsonStr;
      localCreateCommentResult.g = paramSubCommentCreateRsp.actual_create_content.get();
      localCreateCommentResult.h = paramSubCommentCreateRsp.share_url.get();
      localCreateCommentResult.i = this.$feedsType;
      localCreateCommentResult.j = this.$isFeeds;
      paramSubCommentCreateRsp = new StringBuilder();
      paramSubCommentCreateRsp.append("createSubComment: result=");
      paramSubCommentCreateRsp.append(localCreateCommentResult.toString());
      QLog.d("RIJCommentNetworkHelper", 1, paramSubCommentCreateRsp.toString());
      paramString.a(localCreateCommentResult);
    }
    RIJCommentNetworkHelper.a(RIJCommentNetworkHelper.a, -1, System.currentTimeMillis() - this.$requestTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkHelper.createSubComment.2
 * JD-Core Version:    0.7.0.1
 */