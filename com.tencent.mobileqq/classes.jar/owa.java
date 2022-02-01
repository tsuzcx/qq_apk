import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentCreateData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.FirstCommentCreateReq;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.FirstCommentCreateRsp;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.ReqBody;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.RspBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/CreateFirstCommentHandler;", "", "data", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentCreateData;", "(Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentCreateData;)V", "getData", "()Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentCreateData;", "onFailedCallback", "Lkotlin/Function2;", "", "", "", "getOnFailedCallback", "()Lkotlin/jvm/functions/Function2;", "setOnFailedCallback", "(Lkotlin/jvm/functions/Function2;)V", "onSuccessCallback", "Lkotlin/Function1;", "getOnSuccessCallback", "()Lkotlin/jvm/functions/Function1;", "setOnSuccessCallback", "(Lkotlin/jvm/functions/Function1;)V", "generateRequestBody", "Ltencent/im/oidb/oidb_0xd1e/oidb_0xd1e$ReqBody;", "onCommentOperationFailed", "errorCode", "errorMsg", "onFirstCommentCreateSuccess", "commentId", "parseFirstCommentCreateData", "", "send0xd1eRequest", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class owa
{
  @NotNull
  private final FirstCommentCreateData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentCreateData;
  @Nullable
  private Function1<? super String, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  @Nullable
  private Function2<? super Integer, ? super String, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction2;
  
  public owa(@NotNull FirstCommentCreateData paramFirstCommentCreateData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentCreateData = paramFirstCommentCreateData;
  }
  
  private final oidb_0xd1e.ReqBody a()
  {
    oidb_0xd1e.ReqBody localReqBody = new oidb_0xd1e.ReqBody();
    oidb_0xd1e.FirstCommentCreateReq localFirstCommentCreateReq = new oidb_0xd1e.FirstCommentCreateReq();
    FirstCommentCreateData localFirstCommentCreateData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentCreateData;
    localFirstCommentCreateReq.rowkey.set(localFirstCommentCreateData.b());
    localFirstCommentCreateReq.article_id.set(localFirstCommentCreateData.c());
    localFirstCommentCreateReq.author_id.set(localFirstCommentCreateData.a());
    localFirstCommentCreateReq.business_info.set(localFirstCommentCreateData.d());
    localFirstCommentCreateReq.content_src.set(localFirstCommentCreateData.d());
    localFirstCommentCreateReq.src.set(localFirstCommentCreateData.c());
    localFirstCommentCreateReq.scene.set(localFirstCommentCreateData.b());
    localFirstCommentCreateReq.content.set(localFirstCommentCreateData.a());
    localReqBody.first_comment_create_req.set((MessageMicro)localFirstCommentCreateReq);
    return localReqBody;
  }
  
  private final void a(String paramString)
  {
    Function1 localFunction1 = this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
    if (localFunction1 != null) {
      paramString = (Unit)localFunction1.invoke(paramString);
    }
  }
  
  private final void a(byte[] paramArrayOfByte)
  {
    oidb_0xd1e.RspBody localRspBody = new oidb_0xd1e.RspBody();
    localRspBody.mergeFrom(paramArrayOfByte);
    paramArrayOfByte = localRspBody.first_comment_create_rsp.comment_id.get();
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "commentId");
    if (((CharSequence)paramArrayOfByte).length() > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      a(paramArrayOfByte);
      return;
    }
    a(-1, "CommentId is empty.");
  }
  
  public final void a()
  {
    oidb_0xd1e.ReqBody localReqBody = a();
    nkm.a(ozs.a(), (nkq)new owb(this), localReqBody.toByteArray(), "OidbSvc.0xd1e", 3358, 4);
  }
  
  public final void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    Function2 localFunction2 = this.jdField_a_of_type_KotlinJvmFunctionsFunction2;
    if (localFunction2 != null) {
      paramString = (Unit)localFunction2.invoke(Integer.valueOf(paramInt), paramString);
    }
  }
  
  public final void a(@Nullable Function1<? super String, Unit> paramFunction1)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public final void a(@Nullable Function2<? super Integer, ? super String, Unit> paramFunction2)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction2 = paramFunction2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     owa
 * JD-Core Version:    0.7.0.1
 */