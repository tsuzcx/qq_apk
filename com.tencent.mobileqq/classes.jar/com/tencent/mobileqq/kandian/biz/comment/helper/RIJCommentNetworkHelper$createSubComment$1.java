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
        localCreateCommentResult.jdField_a_of_type_Long = this.$commentSeq;
        localCreateCommentResult.jdField_a_of_type_Boolean = true;
        localCreateCommentResult.jdField_a_of_type_Int = 0;
        localCreateCommentResult.jdField_b_of_type_Int = 2;
        localCreateCommentResult.jdField_a_of_type_JavaLangString = String.valueOf(paramInt);
        localCreateCommentResult.jdField_b_of_type_JavaLangString = this.$commentJsonStr;
        localCreateCommentResult.jdField_c_of_type_JavaLangString = paramSubCommentCreateRsp.actual_create_content.get();
        localCreateCommentResult.d = paramSubCommentCreateRsp.share_url.get();
        localCreateCommentResult.jdField_c_of_type_Int = this.$feedsType;
        localCreateCommentResult.jdField_b_of_type_Boolean = this.$isFeeds;
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
    if (((CharSequence)this.$requestData.c()).length() <= 0) {
      i = 0;
    }
    if (i != 0) {
      paramSubCommentCreateRsp = this.$requestData.c();
    } else {
      paramSubCommentCreateRsp = this.$requestData.d();
    }
    RIJCommentNetworkHelper.a(RIJCommentNetworkHelper.a, this.$requestData.g(), paramSubCommentCreateRsp, this.$requestData.a(), this.$requestData.f(), String.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkHelper.createSubComment.1
 * JD-Core Version:    0.7.0.1
 */