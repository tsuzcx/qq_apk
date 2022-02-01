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
import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentAegisHelper;
import com.tencent.mobileqq.kandian.biz.comment.helper.RIJPerformanceReporter;
import com.tencent.mobileqq.pb.MessageMicro;
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
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.FirstCommentCreateReq;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.FirstCommentCreateRsp;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.ReqBody;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.RspBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/handler/CreateFirstCommentHandler;", "", "data", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/FirstCommentCreateData;", "(Lcom/tencent/mobileqq/kandian/biz/comment/entity/FirstCommentCreateData;)V", "getData", "()Lcom/tencent/mobileqq/kandian/biz/comment/entity/FirstCommentCreateData;", "onFailedCallback", "Lkotlin/Function3;", "Ltencent/im/oidb/oidb_0xd1e/oidb_0xd1e$FirstCommentCreateRsp;", "", "", "", "getOnFailedCallback", "()Lkotlin/jvm/functions/Function3;", "setOnFailedCallback", "(Lkotlin/jvm/functions/Function3;)V", "onSuccessCallback", "Lkotlin/Function2;", "getOnSuccessCallback", "()Lkotlin/jvm/functions/Function2;", "setOnSuccessCallback", "(Lkotlin/jvm/functions/Function2;)V", "generateRequestBody", "Ltencent/im/oidb/oidb_0xd1e/oidb_0xd1e$ReqBody;", "getResponse", "", "onCommentOperationFailed", "response", "errorCode", "errorMsg", "onFirstCommentCreateSuccess", "commentId", "parseFirstCommentCreateData", "rateReport", "bundle", "Landroid/os/Bundle;", "reportAegisWhenFail", "send0xd1eRequest", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class CreateFirstCommentHandler
{
  public static final CreateFirstCommentHandler.Companion a = new CreateFirstCommentHandler.Companion(null);
  @Nullable
  private Function2<? super oidb_0xd1e.FirstCommentCreateRsp, ? super String, Unit> b;
  @Nullable
  private Function3<? super oidb_0xd1e.FirstCommentCreateRsp, ? super Integer, ? super String, Unit> c;
  @NotNull
  private final FirstCommentCreateData d;
  
  public CreateFirstCommentHandler(@NotNull FirstCommentCreateData paramFirstCommentCreateData)
  {
    this.d = paramFirstCommentCreateData;
  }
  
  private final oidb_0xd1e.FirstCommentCreateRsp a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return new oidb_0xd1e.FirstCommentCreateRsp();
    }
    oidb_0xd1e.RspBody localRspBody = new oidb_0xd1e.RspBody();
    localRspBody.mergeFrom(paramArrayOfByte);
    paramArrayOfByte = localRspBody.first_comment_create_rsp;
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "commentRsp.first_comment_create_rsp");
    return paramArrayOfByte;
  }
  
  private final void a(int paramInt, String paramString)
  {
    if (paramInt != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("errorCode:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" errorMsg:");
      if (paramString == null) {
        paramString = "Empty error message.";
      }
      localStringBuilder.append(paramString);
      RIJCommentAegisHelper.a(localStringBuilder.toString(), "CreateFirstCommentHandler");
    }
  }
  
  private final void a(oidb_0xd1e.FirstCommentCreateRsp paramFirstCommentCreateRsp, String paramString)
  {
    Function2 localFunction2 = this.b;
    if (localFunction2 != null) {
      paramFirstCommentCreateRsp = (Unit)localFunction2.invoke(paramFirstCommentCreateRsp, paramString);
    }
  }
  
  private final oidb_0xd1e.ReqBody b()
  {
    oidb_0xd1e.ReqBody localReqBody = new oidb_0xd1e.ReqBody();
    oidb_0xd1e.FirstCommentCreateReq localFirstCommentCreateReq = new oidb_0xd1e.FirstCommentCreateReq();
    Object localObject1 = this.d;
    localFirstCommentCreateReq.rowkey.set(((FirstCommentCreateData)localObject1).d());
    localFirstCommentCreateReq.article_id.set(((FirstCommentCreateData)localObject1).e());
    localFirstCommentCreateReq.author_id.set(((FirstCommentCreateData)localObject1).g());
    localFirstCommentCreateReq.business_info.set(((FirstCommentCreateData)localObject1).k());
    localFirstCommentCreateReq.content_src.set(ReadInJoyCommentHelper.a(((FirstCommentCreateData)localObject1).j()));
    localFirstCommentCreateReq.src.set(((FirstCommentCreateData)localObject1).h());
    localFirstCommentCreateReq.scene.set(((FirstCommentCreateData)localObject1).f());
    localFirstCommentCreateReq.content.set(((FirstCommentCreateData)localObject1).a());
    Object localObject2 = ((FirstCommentCreateData)localObject1).b();
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        BaseCommentData.CommentRptData localCommentRptData = (BaseCommentData.CommentRptData)((Iterator)localObject2).next();
        localFirstCommentCreateReq.rpt_data.add((MessageMicro)Base0xd1eHandler.a.a(localCommentRptData));
      }
    }
    localFirstCommentCreateReq.detect_dirty_word.set(1);
    localObject1 = ((FirstCommentCreateData)localObject1).i();
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (BaseCommentData.CommentLinkData)((Iterator)localObject1).next();
        localFirstCommentCreateReq.link_data.add((MessageMicro)Base0xd1eHandler.a.a((BaseCommentData.CommentLinkData)localObject2));
      }
    }
    localReqBody.first_comment_create_req.set((MessageMicro)localFirstCommentCreateReq);
    return localReqBody;
  }
  
  private final void b(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = a(paramArrayOfByte);
    int j = paramArrayOfByte.link_comment_over_times.get();
    int i = 0;
    if (j == 1) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if (paramArrayOfByte.dirty_word_show_toast.get() == 1) {
      k = 1;
    } else {
      k = 0;
    }
    String str = paramArrayOfByte.comment_id.get();
    Intrinsics.checkExpressionValueIsNotNull(str, "commentId");
    if (((CharSequence)str).length() > 0) {
      i = 1;
    }
    if ((i != 0) && (j == 0) && (k == 0))
    {
      a(paramArrayOfByte, str);
      return;
    }
    i = -1;
    if (j != 0) {
      i = -4096;
    }
    if (k != 0) {
      i = -4097;
    }
    a(paramArrayOfByte, i, "CommentId is empty.");
  }
  
  public final void a()
  {
    oidb_0xd1e.ReqBody localReqBody = b();
    QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
    Bundle localBundle = new Bundle();
    localBundle.putLong("send_time", SystemClock.elapsedRealtime());
    ProtoUtils.a((AppRuntime)localQQAppInterface, (ProtoUtils.TroopProtocolObserver)new CreateFirstCommentHandler.send0xd1eRequest.1(this), localReqBody.toByteArray(), "OidbSvc.0xd1e", 3358, 4, localBundle);
  }
  
  public final void a(int paramInt, @Nullable Bundle paramBundle)
  {
    RIJPerformanceReporter.a().a(0, 0, paramInt, paramBundle);
  }
  
  public final void a(@Nullable Function2<? super oidb_0xd1e.FirstCommentCreateRsp, ? super String, Unit> paramFunction2)
  {
    this.b = paramFunction2;
  }
  
  public final void a(@Nullable Function3<? super oidb_0xd1e.FirstCommentCreateRsp, ? super Integer, ? super String, Unit> paramFunction3)
  {
    this.c = paramFunction3;
  }
  
  public final void a(@NotNull oidb_0xd1e.FirstCommentCreateRsp paramFirstCommentCreateRsp, int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentCreateRsp, "response");
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    Function3 localFunction3 = this.c;
    if (localFunction3 != null) {
      paramFirstCommentCreateRsp = (Unit)localFunction3.invoke(paramFirstCommentCreateRsp, Integer.valueOf(paramInt), paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.handler.CreateFirstCommentHandler
 * JD-Core Version:    0.7.0.1
 */