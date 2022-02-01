package com.tencent.mobileqq.kandian.biz.comment.handler;

import androidx.annotation.VisibleForTesting;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.comment.entity.PatrolArbitrationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xf8a.oidb_cmd0xf8a.CommentInfo;
import tencent.im.oidb.cmd0xf8a.oidb_cmd0xf8a.PatrolInfo;
import tencent.im.oidb.cmd0xf8a.oidb_cmd0xf8a.ReqBody;
import tencent.im.oidb.cmd0xf8a.oidb_cmd0xf8a.RspBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/handler/PatrolArbitrationHandler;", "", "data", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/PatrolArbitrationData;", "(Lcom/tencent/mobileqq/kandian/biz/comment/entity/PatrolArbitrationData;)V", "getData", "()Lcom/tencent/mobileqq/kandian/biz/comment/entity/PatrolArbitrationData;", "onFailedCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "errorMsg", "", "getOnFailedCallback", "()Lkotlin/jvm/functions/Function1;", "setOnFailedCallback", "(Lkotlin/jvm/functions/Function1;)V", "onSuccessCallback", "getOnSuccessCallback", "setOnSuccessCallback", "generateRequestBody", "Ltencent/im/oidb/cmd0xf8a/oidb_cmd0xf8a$ReqBody;", "handlePatrolArbitrationResult", "", "onCommentOperationFailed", "errorCode", "", "onCommentOperationSuccess", "send0xf8aRequest", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PatrolArbitrationHandler
{
  public static final PatrolArbitrationHandler.Companion a;
  @NotNull
  private final PatrolArbitrationData jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityPatrolArbitrationData;
  @Nullable
  private Function1<? super String, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  @Nullable
  private Function1<? super String, Unit> b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizCommentHandlerPatrolArbitrationHandler$Companion = new PatrolArbitrationHandler.Companion(null);
  }
  
  public PatrolArbitrationHandler(@NotNull PatrolArbitrationData paramPatrolArbitrationData)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityPatrolArbitrationData = paramPatrolArbitrationData;
  }
  
  @NotNull
  public final oidb_cmd0xf8a.ReqBody a()
  {
    oidb_cmd0xf8a.ReqBody localReqBody = new oidb_cmd0xf8a.ReqBody();
    oidb_cmd0xf8a.PatrolInfo localPatrolInfo = new oidb_cmd0xf8a.PatrolInfo();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityPatrolArbitrationData;
    localPatrolInfo.patrol_uin.set(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityPatrolArbitrationData.a());
    localPatrolInfo.patrol_source.set(1);
    localObject = new oidb_cmd0xf8a.CommentInfo();
    PatrolArbitrationData localPatrolArbitrationData = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityPatrolArbitrationData;
    ((oidb_cmd0xf8a.CommentInfo)localObject).first_comment_id.set(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityPatrolArbitrationData.b());
    ((oidb_cmd0xf8a.CommentInfo)localObject).sub_comment_id.set(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityPatrolArbitrationData.c());
    ((oidb_cmd0xf8a.CommentInfo)localObject).rowkey.set(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityPatrolArbitrationData.d());
    localReqBody.patrol_info.set((MessageMicro)localPatrolInfo);
    localReqBody.comment_info.set((MessageMicro)localObject);
    return localReqBody;
  }
  
  public final void a()
  {
    oidb_cmd0xf8a.ReqBody localReqBody = a();
    ProtoUtils.a((AppRuntime)RIJQQAppInterfaceUtil.a(), (ProtoUtils.TroopProtocolObserver)new PatrolArbitrationHandler.send0xf8aRequest.1(this), localReqBody.toByteArray(), "OidbSvc.0xf8a", 3978, 0);
  }
  
  public final void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCommentOperationFailed | errCode ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" ; errMsg ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("PatrolArbitrationHandler", 1, ((StringBuilder)localObject).toString());
    localObject = this.b;
    if (localObject != null) {
      paramString = (Unit)((Function1)localObject).invoke(paramString);
    }
  }
  
  public final void a(@Nullable Function1<? super String, Unit> paramFunction1)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public final void a(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "data");
    Object localObject = new oidb_cmd0xf8a.RspBody();
    ((oidb_cmd0xf8a.RspBody)localObject).mergeFrom(paramArrayOfByte);
    int i = ((oidb_cmd0xf8a.RspBody)localObject).ret.get();
    paramArrayOfByte = ((oidb_cmd0xf8a.RspBody)localObject).err_message.get();
    if (i != 0)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "errorMsg");
      a(i, paramArrayOfByte);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlePatrolArbitrationResult | errorMsg ");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      QLog.d("PatrolArbitrationHandler", 1, ((StringBuilder)localObject).toString());
      return;
    }
    b();
  }
  
  @VisibleForTesting
  public final void b()
  {
    Object localObject = this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
    if (localObject != null) {
      localObject = (Unit)((Function1)localObject).invoke("");
    }
  }
  
  public final void b(@Nullable Function1<? super String, Unit> paramFunction1)
  {
    this.b = paramFunction1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.handler.PatrolArbitrationHandler
 * JD-Core Version:    0.7.0.1
 */