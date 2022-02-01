package com.tencent.mobileqq.kandian.biz.comment.handler;

import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentHelper;
import com.tencent.mobileqq.kandian.biz.comment.entity.AuthorCommentDeleteData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SimpleCommentData;
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
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.AuthorCommentDeleteReq;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.AuthorCommentDeleteRsp;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.ReqBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/handler/AuthorDeleteCommentHandler;", "", "authorDeleteCommentData", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/AuthorCommentDeleteData;", "(Lcom/tencent/mobileqq/kandian/biz/comment/entity/AuthorCommentDeleteData;)V", "getAuthorDeleteCommentData", "()Lcom/tencent/mobileqq/kandian/biz/comment/entity/AuthorCommentDeleteData;", "onFailedCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isOverTimes", "", "getOnFailedCallback", "()Lkotlin/jvm/functions/Function1;", "setOnFailedCallback", "(Lkotlin/jvm/functions/Function1;)V", "onSuccessCallback", "", "getOnSuccessCallback", "setOnSuccessCallback", "serviceType", "", "getServiceType", "()I", "generateRequestBody", "Ltencent/im/oidb/oidb_0xd1e/oidb_0xd1e$ReqBody;", "handleAuthorCommentDeleteResult", "data", "", "onCommentOperationFailed", "errorCode", "errorMsg", "onCommentOperationSuccess", "send0xd1eRequest", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class AuthorDeleteCommentHandler
{
  public static final AuthorDeleteCommentHandler.Companion a = new AuthorDeleteCommentHandler.Companion(null);
  @Nullable
  private Function1<? super String, Unit> b;
  @Nullable
  private Function1<? super Boolean, Unit> c;
  @NotNull
  private final AuthorCommentDeleteData d;
  
  public AuthorDeleteCommentHandler(@NotNull AuthorCommentDeleteData paramAuthorCommentDeleteData)
  {
    this.d = paramAuthorCommentDeleteData;
  }
  
  private final void b(byte[] paramArrayOfByte)
  {
    oidb_0xd1e.AuthorCommentDeleteRsp localAuthorCommentDeleteRsp = new oidb_0xd1e.AuthorCommentDeleteRsp();
    localAuthorCommentDeleteRsp.mergeFrom(paramArrayOfByte);
    int i = localAuthorCommentDeleteRsp.over_times.get();
    if (i > 0)
    {
      paramArrayOfByte = this.c;
      if (paramArrayOfByte != null) {
        paramArrayOfByte = (Unit)paramArrayOfByte.invoke(Boolean.valueOf(true));
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("handleAuthorCommentDeleteResult | delteTimes ");
      paramArrayOfByte.append(i);
      QLog.d("AuthorDeleteCommentHandler", 1, paramArrayOfByte.toString());
      return;
    }
    paramArrayOfByte = this.b;
    if (paramArrayOfByte != null) {
      paramArrayOfByte = (Unit)paramArrayOfByte.invoke("");
    }
  }
  
  public final void a()
  {
    oidb_0xd1e.ReqBody localReqBody = b();
    ProtoUtils.a((AppRuntime)RIJQQAppInterfaceUtil.a(), (ProtoUtils.TroopProtocolObserver)new AuthorDeleteCommentHandler.send0xd1eRequest.1(this), localReqBody.toByteArray(), "OidbSvc.0xd1e", 3358, 9);
  }
  
  public final void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCommentOperationFailed | errCode ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ; errMsg ");
    localStringBuilder.append(paramString);
    QLog.d("AuthorDeleteCommentHandler", 1, localStringBuilder.toString());
    paramString = this.c;
    if (paramString != null) {
      paramString = (Unit)paramString.invoke(Boolean.valueOf(false));
    }
  }
  
  public final void a(@Nullable Function1<? super String, Unit> paramFunction1)
  {
    this.b = paramFunction1;
  }
  
  public final void a(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "data");
    b(paramArrayOfByte);
  }
  
  @NotNull
  public final oidb_0xd1e.ReqBody b()
  {
    oidb_0xd1e.ReqBody localReqBody = new oidb_0xd1e.ReqBody();
    oidb_0xd1e.AuthorCommentDeleteReq localAuthorCommentDeleteReq = new oidb_0xd1e.AuthorCommentDeleteReq();
    AuthorCommentDeleteData localAuthorCommentDeleteData = this.d;
    localAuthorCommentDeleteReq.article_id.set(localAuthorCommentDeleteData.a().e());
    localAuthorCommentDeleteReq.comment_type.set(localAuthorCommentDeleteData.b());
    localAuthorCommentDeleteReq.content_src.set(ReadInJoyCommentHelper.a(localAuthorCommentDeleteData.a().j()));
    localAuthorCommentDeleteReq.first_comment_id.set(localAuthorCommentDeleteData.c());
    localAuthorCommentDeleteReq.sub_comment_id.set(localAuthorCommentDeleteData.d());
    localAuthorCommentDeleteReq.src.set(localAuthorCommentDeleteData.a().h());
    localAuthorCommentDeleteReq.business_info.set(localAuthorCommentDeleteData.a().k());
    localReqBody.author_comment_delete_req.set((MessageMicro)localAuthorCommentDeleteReq);
    return localReqBody;
  }
  
  public final void b(@Nullable Function1<? super Boolean, Unit> paramFunction1)
  {
    this.c = paramFunction1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.handler.AuthorDeleteCommentHandler
 * JD-Core Version:    0.7.0.1
 */