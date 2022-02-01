package com.tencent.mobileqq.kandian.biz.comment.handler;

import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentHelper;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentLinkData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentRptData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.helper.RIJPerformanceReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.ReqBody;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.RspBody;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.SubCommentCreateReq;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.SubCommentCreateRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/handler/CreateSubCommentHandler;", "", "data", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/SubCommentCreateData;", "(Lcom/tencent/mobileqq/kandian/biz/comment/entity/SubCommentCreateData;)V", "getData", "()Lcom/tencent/mobileqq/kandian/biz/comment/entity/SubCommentCreateData;", "onFailedCallback", "Lkotlin/Function3;", "Ltencent/im/oidb/oidb_0xd1e/oidb_0xd1e$SubCommentCreateRsp;", "", "", "", "getOnFailedCallback", "()Lkotlin/jvm/functions/Function3;", "setOnFailedCallback", "(Lkotlin/jvm/functions/Function3;)V", "onSuccessCallback", "Lkotlin/Function2;", "getOnSuccessCallback", "()Lkotlin/jvm/functions/Function2;", "setOnSuccessCallback", "(Lkotlin/jvm/functions/Function2;)V", "generateRequestBody", "Ltencent/im/oidb/oidb_0xd1e/oidb_0xd1e$ReqBody;", "getResponse", "", "onCommentOperationFailed", "response", "errorCode", "errorMsg", "onSubCommentCreateSuccess", "subCommentId", "parseSubCommentCreateData", "rateReport", "bundle", "Landroid/os/Bundle;", "send0xd1eRequest", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class CreateSubCommentHandler
{
  @NotNull
  private final SubCommentCreateData jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySubCommentCreateData;
  @Nullable
  private Function2<? super oidb_0xd1e.SubCommentCreateRsp, ? super Integer, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction2;
  @Nullable
  private Function3<? super oidb_0xd1e.SubCommentCreateRsp, ? super Integer, ? super String, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction3;
  
  public CreateSubCommentHandler(@NotNull SubCommentCreateData paramSubCommentCreateData)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySubCommentCreateData = paramSubCommentCreateData;
  }
  
  private final oidb_0xd1e.ReqBody a()
  {
    oidb_0xd1e.ReqBody localReqBody = new oidb_0xd1e.ReqBody();
    oidb_0xd1e.SubCommentCreateReq localSubCommentCreateReq = new oidb_0xd1e.SubCommentCreateReq();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySubCommentCreateData;
    localSubCommentCreateReq.rowkey.set(((SubCommentCreateData)localObject1).c());
    localSubCommentCreateReq.article_id.set(((SubCommentCreateData)localObject1).d());
    localSubCommentCreateReq.author_id.set(((SubCommentCreateData)localObject1).a());
    localSubCommentCreateReq.business_info.set(((SubCommentCreateData)localObject1).e());
    localSubCommentCreateReq.content_src.set(ReadInJoyCommentHelper.a(((SubCommentCreateData)localObject1).d()));
    localSubCommentCreateReq.src.set(((SubCommentCreateData)localObject1).c());
    localSubCommentCreateReq.scene.set(((SubCommentCreateData)localObject1).b());
    localSubCommentCreateReq.content.set(((SubCommentCreateData)localObject1).b());
    localSubCommentCreateReq.first_comment_id.set(((SubCommentCreateData)localObject1).a());
    localSubCommentCreateReq.replied_sub_author_id.set(((SubCommentCreateData)localObject1).b());
    localSubCommentCreateReq.replied_sub_comment_id.set(((SubCommentCreateData)localObject1).f());
    localSubCommentCreateReq.detect_dirty_word.set(1);
    Object localObject2 = ((SubCommentCreateData)localObject1).a();
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        BaseCommentData.CommentRptData localCommentRptData = (BaseCommentData.CommentRptData)((Iterator)localObject2).next();
        localSubCommentCreateReq.rpt_data.add((MessageMicro)Base0xd1eHandler.a.a(localCommentRptData));
      }
    }
    localObject1 = ((SubCommentCreateData)localObject1).b();
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (BaseCommentData.CommentLinkData)((Iterator)localObject1).next();
        localSubCommentCreateReq.link_data.add((MessageMicro)Base0xd1eHandler.a.a((BaseCommentData.CommentLinkData)localObject2));
      }
    }
    localReqBody.sub_comment_create_req.set((MessageMicro)localSubCommentCreateReq);
    return localReqBody;
  }
  
  private final oidb_0xd1e.SubCommentCreateRsp a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return new oidb_0xd1e.SubCommentCreateRsp();
    }
    oidb_0xd1e.RspBody localRspBody = new oidb_0xd1e.RspBody();
    localRspBody.mergeFrom(paramArrayOfByte);
    paramArrayOfByte = localRspBody.sub_comment_create_rsp;
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "commentRsp.sub_comment_create_rsp");
    return paramArrayOfByte;
  }
  
  private final void a(oidb_0xd1e.SubCommentCreateRsp paramSubCommentCreateRsp, int paramInt)
  {
    Function2 localFunction2 = this.jdField_a_of_type_KotlinJvmFunctionsFunction2;
    if (localFunction2 != null) {
      paramSubCommentCreateRsp = (Unit)localFunction2.invoke(paramSubCommentCreateRsp, Integer.valueOf(paramInt));
    }
  }
  
  private final void a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = a(paramArrayOfByte);
    int i = paramArrayOfByte.sub_comment_id.get();
    int j = paramArrayOfByte.link_comment_over_times.get();
    int k = 0;
    if (j == 1) {
      j = 1;
    } else {
      j = 0;
    }
    if (paramArrayOfByte.dirty_word_show_toast.get() == 1) {
      k = 1;
    }
    if ((j == 0) && (k == 0))
    {
      a(paramArrayOfByte, i);
      return;
    }
    i = -1;
    if (j != 0) {
      i = -4096;
    }
    if (k != 0) {
      i = -4097;
    }
    a(paramArrayOfByte, i, "");
  }
  
  public final void a()
  {
    oidb_0xd1e.ReqBody localReqBody = a();
    QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
    Bundle localBundle = new Bundle();
    localBundle.putLong("send_time", SystemClock.elapsedRealtime());
    ProtoUtils.a((AppRuntime)localQQAppInterface, (ProtoUtils.TroopProtocolObserver)new CreateSubCommentHandler.send0xd1eRequest.1(this), localReqBody.toByteArray(), "OidbSvc.0xd1e", 3358, 1, localBundle);
  }
  
  public final void a(int paramInt, @Nullable Bundle paramBundle)
  {
    RIJPerformanceReporter.a().a(1, 0, paramInt, paramBundle);
  }
  
  public final void a(@Nullable Function2<? super oidb_0xd1e.SubCommentCreateRsp, ? super Integer, Unit> paramFunction2)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction2 = paramFunction2;
  }
  
  public final void a(@Nullable Function3<? super oidb_0xd1e.SubCommentCreateRsp, ? super Integer, ? super String, Unit> paramFunction3)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction3 = paramFunction3;
  }
  
  public final void a(@NotNull oidb_0xd1e.SubCommentCreateRsp paramSubCommentCreateRsp, int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramSubCommentCreateRsp, "response");
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    Function3 localFunction3 = this.jdField_a_of_type_KotlinJvmFunctionsFunction3;
    if (localFunction3 != null) {
      paramSubCommentCreateRsp = (Unit)localFunction3.invoke(paramSubCommentCreateRsp, Integer.valueOf(paramInt), paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.handler.CreateSubCommentHandler
 * JD-Core Version:    0.7.0.1
 */