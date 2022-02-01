package com.tencent.mobileqq.kandian.biz.comment.handler;

import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.comment.entity.BlockUserCommentData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xf35.oidb_cmd0xf35.BlockUserReq;
import tencent.im.oidb.cmd0xf35.oidb_cmd0xf35.BlockUserRsp;
import tencent.im.oidb.cmd0xf35.oidb_cmd0xf35.ReqBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/handler/BlockUserCommentHandler;", "", "data", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/BlockUserCommentData;", "(Lcom/tencent/mobileqq/kandian/biz/comment/entity/BlockUserCommentData;)V", "getData", "()Lcom/tencent/mobileqq/kandian/biz/comment/entity/BlockUserCommentData;", "onFailedCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isOverTimes", "", "errorMsg", "", "getOnFailedCallback", "()Lkotlin/jvm/functions/Function2;", "setOnFailedCallback", "(Lkotlin/jvm/functions/Function2;)V", "onSuccessCallback", "Lkotlin/Function1;", "getOnSuccessCallback", "()Lkotlin/jvm/functions/Function1;", "setOnSuccessCallback", "(Lkotlin/jvm/functions/Function1;)V", "generateRequestBody", "Ltencent/im/oidb/cmd0xf35/oidb_cmd0xf35$ReqBody;", "handleBlockUserCommentResult", "", "onCommentOperationFailed", "errorCode", "", "onCommentOperationSuccess", "send0xf35Request", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BlockUserCommentHandler
{
  public static final BlockUserCommentHandler.Companion a = new BlockUserCommentHandler.Companion(null);
  @Nullable
  private Function1<? super String, Unit> b;
  @Nullable
  private Function2<? super Boolean, ? super String, Unit> c;
  @NotNull
  private final BlockUserCommentData d;
  
  public BlockUserCommentHandler(@NotNull BlockUserCommentData paramBlockUserCommentData)
  {
    this.d = paramBlockUserCommentData;
  }
  
  public final void a()
  {
    oidb_cmd0xf35.ReqBody localReqBody = b();
    ProtoUtils.a((AppRuntime)RIJQQAppInterfaceUtil.a(), (ProtoUtils.TroopProtocolObserver)new BlockUserCommentHandler.send0xf35Request.1(this), localReqBody.toByteArray(), "OidbSvc.0xf35", 3893, 1);
  }
  
  public final void a(int paramInt, @NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCommentOperationFailed | errCode ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" ; errMsg ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("BlockUserCommentHandler", 1, ((StringBuilder)localObject).toString());
    localObject = this.c;
    if (localObject != null) {
      paramString = (Unit)((Function2)localObject).invoke(Boolean.valueOf(paramBoolean), paramString);
    }
  }
  
  public final void a(@Nullable Function1<? super String, Unit> paramFunction1)
  {
    this.b = paramFunction1;
  }
  
  public final void a(@Nullable Function2<? super Boolean, ? super String, Unit> paramFunction2)
  {
    this.c = paramFunction2;
  }
  
  public final void a(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "data");
    Object localObject = new oidb_cmd0xf35.BlockUserRsp();
    ((oidb_cmd0xf35.BlockUserRsp)localObject).mergeFrom(paramArrayOfByte);
    int i = ((oidb_cmd0xf35.BlockUserRsp)localObject).over_times.get();
    int j = ((oidb_cmd0xf35.BlockUserRsp)localObject).ret.get();
    localObject = ((oidb_cmd0xf35.BlockUserRsp)localObject).err_message.get();
    if (i > 0)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject, "errorMsg");
      a(j, (String)localObject, true);
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("handleBlockUserCommentResult | errorMsg ");
      paramArrayOfByte.append((String)localObject);
      QLog.d("BlockUserCommentHandler", 1, paramArrayOfByte.toString());
      return;
    }
    b(paramArrayOfByte);
  }
  
  @NotNull
  public final oidb_cmd0xf35.ReqBody b()
  {
    oidb_cmd0xf35.ReqBody localReqBody = new oidb_cmd0xf35.ReqBody();
    oidb_cmd0xf35.BlockUserReq localBlockUserReq = new oidb_cmd0xf35.BlockUserReq();
    BlockUserCommentData localBlockUserCommentData = this.d;
    localBlockUserReq.first_comment_id.set(this.d.a());
    localBlockUserReq.sub_comment_id.set(this.d.b());
    localBlockUserReq.comment_type.set(this.d.c());
    localBlockUserReq.comment_source.set(0);
    localReqBody.block_user_req.set((MessageMicro)localBlockUserReq);
    return localReqBody;
  }
  
  public final void b(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "data");
    paramArrayOfByte = this.b;
    if (paramArrayOfByte != null) {
      paramArrayOfByte = (Unit)paramArrayOfByte.invoke("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.handler.BlockUserCommentHandler
 * JD-Core Version:    0.7.0.1
 */