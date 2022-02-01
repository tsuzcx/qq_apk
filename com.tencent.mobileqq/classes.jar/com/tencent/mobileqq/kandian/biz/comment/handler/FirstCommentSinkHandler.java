package com.tencent.mobileqq.kandian.biz.comment.handler;

import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentHelper;
import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentSinkData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.FirstCommentAuthorTopSetReq;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.FirstCommentAuthorTopSetRsp;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.ReqBody;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.RspBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/handler/FirstCommentSinkHandler;", "", "data", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/FirstCommentSinkData;", "(Lcom/tencent/mobileqq/kandian/biz/comment/entity/FirstCommentSinkData;)V", "getData", "()Lcom/tencent/mobileqq/kandian/biz/comment/entity/FirstCommentSinkData;", "onFailCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isOverTimes", "", "getOnFailCallback", "()Lkotlin/jvm/functions/Function1;", "setOnFailCallback", "(Lkotlin/jvm/functions/Function1;)V", "onSuccessCallback", "Lkotlin/Function0;", "getOnSuccessCallback", "()Lkotlin/jvm/functions/Function0;", "setOnSuccessCallback", "(Lkotlin/jvm/functions/Function0;)V", "generateRequestBody", "Ltencent/im/oidb/oidb_0xd1e/oidb_0xd1e$ReqBody;", "onCommentOperationFailed", "errorCode", "", "errorMsg", "", "onCommentOperationSuccess", "", "send0xd1eRequest", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class FirstCommentSinkHandler
{
  public static final FirstCommentSinkHandler.Companion a = new FirstCommentSinkHandler.Companion(null);
  @NotNull
  private static final String e = "FirstCommentSinkHandler";
  @Nullable
  private Function0<Unit> b;
  @Nullable
  private Function1<? super Boolean, Unit> c;
  @NotNull
  private final FirstCommentSinkData d;
  
  public FirstCommentSinkHandler(@NotNull FirstCommentSinkData paramFirstCommentSinkData)
  {
    this.d = paramFirstCommentSinkData;
  }
  
  private final oidb_0xd1e.ReqBody b()
  {
    oidb_0xd1e.ReqBody localReqBody = new oidb_0xd1e.ReqBody();
    oidb_0xd1e.FirstCommentAuthorTopSetReq localFirstCommentAuthorTopSetReq = new oidb_0xd1e.FirstCommentAuthorTopSetReq();
    localFirstCommentAuthorTopSetReq.article_id.set(this.d.d());
    localFirstCommentAuthorTopSetReq.comment_id.set(this.d.b());
    localFirstCommentAuthorTopSetReq.comment_type.set(1);
    localFirstCommentAuthorTopSetReq.op_type.set(this.d.a());
    localFirstCommentAuthorTopSetReq.content_src.set(ReadInJoyCommentHelper.a(this.d.j()));
    localFirstCommentAuthorTopSetReq.src.set(0);
    localFirstCommentAuthorTopSetReq.business_info.set(this.d.k());
    localReqBody.first_comment_author_top_set_req.set((MessageMicro)localFirstCommentAuthorTopSetReq);
    return localReqBody;
  }
  
  public final void a()
  {
    oidb_0xd1e.ReqBody localReqBody = b();
    ProtoUtils.a((AppRuntime)RIJQQAppInterfaceUtil.a(), (ProtoUtils.TroopProtocolObserver)new FirstCommentSinkHandler.send0xd1eRequest.1(this), localReqBody.toByteArray(), "OidbSvc.0xd1e", 3358, 10);
  }
  
  public final void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    String str = e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("errorCode : ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("  msg: ");
    localStringBuilder.append(paramString);
    QLog.d(str, 1, localStringBuilder.toString());
    paramString = this.c;
    if (paramString != null) {
      paramString = (Unit)paramString.invoke(Boolean.valueOf(false));
    }
  }
  
  public final void a(@Nullable Function0<Unit> paramFunction0)
  {
    this.b = paramFunction0;
  }
  
  public final void a(@Nullable Function1<? super Boolean, Unit> paramFunction1)
  {
    this.c = paramFunction1;
  }
  
  public final void a(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "data");
    oidb_0xd1e.RspBody localRspBody = new oidb_0xd1e.RspBody();
    localRspBody.mergeFrom(paramArrayOfByte);
    if ((localRspBody.first_comment_author_top_set_rsp.over_times.has()) && (localRspBody.first_comment_author_top_set_rsp.over_times.get() > 0))
    {
      QLog.d(e, 1, "req fail, overtimes");
      paramArrayOfByte = this.c;
      if (paramArrayOfByte != null) {
        paramArrayOfByte = (Unit)paramArrayOfByte.invoke(Boolean.valueOf(true));
      }
    }
    else
    {
      QLog.d(e, 1, "req success");
      paramArrayOfByte = this.b;
      if (paramArrayOfByte != null) {
        paramArrayOfByte = (Unit)paramArrayOfByte.invoke();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.handler.FirstCommentSinkHandler
 * JD-Core Version:    0.7.0.1
 */