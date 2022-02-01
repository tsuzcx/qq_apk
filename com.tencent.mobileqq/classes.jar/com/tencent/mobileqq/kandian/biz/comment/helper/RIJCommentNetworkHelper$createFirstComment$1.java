package com.tencent.mobileqq.kandian.biz.comment.helper;

import com.tencent.mobileqq.kandian.biz.comment.entity.CreateCommentResult;
import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SimpleCommentData;
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
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.FirstCommentCreateRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "response", "Ltencent/im/oidb/oidb_0xd1e/oidb_0xd1e$FirstCommentCreateRsp;", "commentId", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJCommentNetworkHelper$createFirstComment$1
  extends Lambda
  implements Function2<oidb_0xd1e.FirstCommentCreateRsp, String, Unit>
{
  RIJCommentNetworkHelper$createFirstComment$1(boolean paramBoolean1, IRIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, long paramLong1, String paramString, int paramInt, boolean paramBoolean2, FirstCommentCreateData paramFirstCommentCreateData, long paramLong2)
  {
    super(2);
  }
  
  public final void invoke(@NotNull oidb_0xd1e.FirstCommentCreateRsp paramFirstCommentCreateRsp, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentCreateRsp, "response");
    Intrinsics.checkParameterIsNotNull(paramString, "commentId");
    boolean bool = this.$needBiuAfterComment;
    int i = 0;
    if (!bool)
    {
      IRIJCommentNetworkHelper.RIJCreateCommentObserver localRIJCreateCommentObserver = this.$callback;
      if (localRIJCreateCommentObserver != null)
      {
        CreateCommentResult localCreateCommentResult = new CreateCommentResult();
        localCreateCommentResult.a = this.$commentSeq;
        localCreateCommentResult.b = true;
        localCreateCommentResult.c = 0;
        localCreateCommentResult.d = 1;
        localCreateCommentResult.e = paramString;
        localCreateCommentResult.f = this.$commentJsonStr;
        localCreateCommentResult.g = paramFirstCommentCreateRsp.actual_create_content.get();
        localCreateCommentResult.h = paramFirstCommentCreateRsp.share_url.get();
        localCreateCommentResult.i = this.$feedsType;
        localCreateCommentResult.j = this.$isFeeds;
        localCreateCommentResult.a((Collection)paramFirstCommentCreateRsp.rpt_data.get());
        paramFirstCommentCreateRsp = new StringBuilder();
        paramFirstCommentCreateRsp.append("createFirstComment: result=");
        paramFirstCommentCreateRsp.append(localCreateCommentResult.toString());
        QLog.d("RIJCommentNetworkHelper", 1, paramFirstCommentCreateRsp.toString());
        localRIJCreateCommentObserver.a(localCreateCommentResult);
      }
    }
    else
    {
      RIJBiuNetworkHelper.a.a((SimpleCommentData)this.$requestData, (Function2)new RIJCommentNetworkHelper.createFirstComment.1.2(this, paramString, paramFirstCommentCreateRsp));
    }
    RIJCommentNetworkHelper.a(RIJCommentNetworkHelper.a, 0, System.currentTimeMillis() - this.$requestTime);
    if (((CharSequence)this.$requestData.d()).length() > 0) {
      i = 1;
    }
    if (i != 0) {
      paramFirstCommentCreateRsp = this.$requestData.d();
    } else {
      paramFirstCommentCreateRsp = this.$requestData.e();
    }
    RIJCommentNetworkHelper.a(RIJCommentNetworkHelper.a, this.$requestData.c(), paramFirstCommentCreateRsp, "", "", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkHelper.createFirstComment.1
 * JD-Core Version:    0.7.0.1
 */