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
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.FirstCommentCreateRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "response", "Ltencent/im/oidb/oidb_0xd1e/oidb_0xd1e$FirstCommentCreateRsp;", "errorCode", "", "<anonymous parameter 2>", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJCommentNetworkHelper$createFirstComment$2
  extends Lambda
  implements Function3<oidb_0xd1e.FirstCommentCreateRsp, Integer, String, Unit>
{
  RIJCommentNetworkHelper$createFirstComment$2(IRIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, long paramLong1, String paramString, int paramInt, boolean paramBoolean, long paramLong2)
  {
    super(3);
  }
  
  public final void invoke(@NotNull oidb_0xd1e.FirstCommentCreateRsp paramFirstCommentCreateRsp, int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentCreateRsp, "response");
    Intrinsics.checkParameterIsNotNull(paramString, "<anonymous parameter 2>");
    paramString = this.$callback;
    if (paramString != null)
    {
      CreateCommentResult localCreateCommentResult = new CreateCommentResult();
      localCreateCommentResult.jdField_a_of_type_Long = this.$commentSeq;
      localCreateCommentResult.jdField_a_of_type_Boolean = false;
      localCreateCommentResult.jdField_a_of_type_Int = paramInt;
      localCreateCommentResult.jdField_b_of_type_Int = 1;
      localCreateCommentResult.jdField_a_of_type_JavaLangString = "";
      localCreateCommentResult.jdField_b_of_type_JavaLangString = this.$commentJsonStr;
      localCreateCommentResult.jdField_c_of_type_JavaLangString = paramFirstCommentCreateRsp.actual_create_content.get();
      localCreateCommentResult.d = paramFirstCommentCreateRsp.share_url.get();
      localCreateCommentResult.jdField_c_of_type_Int = this.$feedsType;
      localCreateCommentResult.jdField_b_of_type_Boolean = this.$isFeeds;
      paramFirstCommentCreateRsp = new StringBuilder();
      paramFirstCommentCreateRsp.append("createFirstComment: result=");
      paramFirstCommentCreateRsp.append(localCreateCommentResult.toString());
      QLog.d("RIJCommentNetworkHelper", 1, paramFirstCommentCreateRsp.toString());
      paramString.a(localCreateCommentResult);
    }
    RIJCommentNetworkHelper.a(RIJCommentNetworkHelper.a, -1, System.currentTimeMillis() - this.$requestTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkHelper.createFirstComment.2
 * JD-Core Version:    0.7.0.1
 */