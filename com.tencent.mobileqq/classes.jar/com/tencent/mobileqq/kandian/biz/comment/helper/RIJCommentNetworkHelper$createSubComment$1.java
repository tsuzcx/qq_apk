package com.tencent.mobileqq.kandian.biz.comment.helper;

import com.tencent.mobileqq.kandian.biz.comment.entity.CreateCommentResult;
import com.tencent.mobileqq.kandian.biz.comment.entity.SimpleCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentNetworkHelper.RIJCreateCommentObserver;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.SubCommentCreateRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "response", "Ltencent/im/oidb/oidb_0xd1e/oidb_0xd1e$SubCommentCreateRsp;", "commentId", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJCommentNetworkHelper$createSubComment$1
  extends Lambda
  implements Function2<oidb_0xd1e.SubCommentCreateRsp, Integer, Unit>
{
  RIJCommentNetworkHelper$createSubComment$1(boolean paramBoolean1, IRIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, long paramLong1, String paramString, int paramInt, boolean paramBoolean2, SubCommentCreateData paramSubCommentCreateData, long paramLong2)
  {
    super(2);
  }
  
  public final void invoke(@NotNull oidb_0xd1e.SubCommentCreateRsp paramSubCommentCreateRsp, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramSubCommentCreateRsp, "response");
    boolean bool = this.$needBiuAfterComment;
    int i = 1;
    if (!bool)
    {
      IRIJCommentNetworkHelper.RIJCreateCommentObserver localRIJCreateCommentObserver = this.$callback;
      if (localRIJCreateCommentObserver != null)
      {
        CreateCommentResult localCreateCommentResult = new CreateCommentResult();
        localCreateCommentResult.a = this.$commentSeq;
        localCreateCommentResult.b = true;
        localCreateCommentResult.c = 0;
        localCreateCommentResult.d = 2;
        localCreateCommentResult.e = String.valueOf(paramInt);
        localCreateCommentResult.f = this.$commentJsonStr;
        localCreateCommentResult.g = paramSubCommentCreateRsp.actual_create_content.get();
        localCreateCommentResult.h = paramSubCommentCreateRsp.share_url.get();
        localCreateCommentResult.i = this.$feedsType;
        localCreateCommentResult.j = this.$isFeeds;
        localCreateCommentResult.a((Collection)paramSubCommentCreateRsp.rpt_data.get());
        paramSubCommentCreateRsp = new StringBuilder();
        paramSubCommentCreateRsp.append("createSubComment: result=");
        paramSubCommentCreateRsp.append(localCreateCommentResult.toString());
        QLog.d("RIJCommentNetworkHelper", 1, paramSubCommentCreateRsp.toString());
        localRIJCreateCommentObserver.a(localCreateCommentResult);
      }
    }
    else
    {
      RIJBiuNetworkHelper.a.a((SimpleCommentData)this.$requestData, (Function2)new RIJCommentNetworkHelper.createSubComment.1.2(this, paramInt, paramSubCommentCreateRsp));
    }
    RIJCommentNetworkHelper.a(RIJCommentNetworkHelper.a, 0, System.currentTimeMillis() - this.$requestTime);
    if (((CharSequence)this.$requestData.d()).length() <= 0) {
      i = 0;
    }
    if (i != 0) {
      paramSubCommentCreateRsp = this.$requestData.d();
    } else {
      paramSubCommentCreateRsp = this.$requestData.e();
    }
    RIJCommentNetworkHelper.a(RIJCommentNetworkHelper.a, this.$requestData.n(), paramSubCommentCreateRsp, this.$requestData.a(), this.$requestData.m(), String.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkHelper.createSubComment.1
 * JD-Core Version:    0.7.0.1
 */