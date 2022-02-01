package com.tencent.mobileqq.kandian.biz.comment.helper;

import com.tencent.mobileqq.kandian.biz.comment.entity.CreateCommentResult;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentNetworkHelper.RIJCreateCommentObserver;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.FirstCommentCreateRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuccess", "", "errorCode", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJCommentNetworkHelper$createFirstComment$1$2
  extends Lambda
  implements Function2<Boolean, Integer, Unit>
{
  RIJCommentNetworkHelper$createFirstComment$1$2(RIJCommentNetworkHelper.createFirstComment.1 param1, String paramString, oidb_0xd1e.FirstCommentCreateRsp paramFirstCommentCreateRsp)
  {
    super(2);
  }
  
  public final void invoke(boolean paramBoolean, int paramInt)
  {
    IRIJCommentNetworkHelper.RIJCreateCommentObserver localRIJCreateCommentObserver = this.this$0.$callback;
    if (localRIJCreateCommentObserver != null)
    {
      CreateCommentResult localCreateCommentResult = new CreateCommentResult();
      localCreateCommentResult.a = this.this$0.$commentSeq;
      localCreateCommentResult.b = paramBoolean;
      localCreateCommentResult.c = paramInt;
      localCreateCommentResult.d = 1;
      localCreateCommentResult.e = this.$commentId;
      localCreateCommentResult.f = this.this$0.$commentJsonStr;
      localCreateCommentResult.g = this.$response.actual_create_content.get();
      localCreateCommentResult.h = this.$response.share_url.get();
      localCreateCommentResult.i = this.this$0.$feedsType;
      localCreateCommentResult.j = this.this$0.$isFeeds;
      localCreateCommentResult.a((Collection)this.$response.rpt_data.get());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createFirstComment: result=");
      localStringBuilder.append(localCreateCommentResult.toString());
      QLog.d("RIJCommentNetworkHelper", 1, localStringBuilder.toString());
      localRIJCreateCommentObserver.a(localCreateCommentResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkHelper.createFirstComment.1.2
 * JD-Core Version:    0.7.0.1
 */