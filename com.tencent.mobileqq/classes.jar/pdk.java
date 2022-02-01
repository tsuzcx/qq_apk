import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SubCommentCreateData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
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
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.ReqBody;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.RspBody;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.SubCommentCreateReq;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.SubCommentCreateRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/CreateSubCommentHandler;", "", "data", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SubCommentCreateData;", "(Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SubCommentCreateData;)V", "getData", "()Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SubCommentCreateData;", "onFailedCallback", "Lkotlin/Function2;", "", "", "", "getOnFailedCallback", "()Lkotlin/jvm/functions/Function2;", "setOnFailedCallback", "(Lkotlin/jvm/functions/Function2;)V", "onSuccessCallback", "Lkotlin/Function1;", "getOnSuccessCallback", "()Lkotlin/jvm/functions/Function1;", "setOnSuccessCallback", "(Lkotlin/jvm/functions/Function1;)V", "generateRequestBody", "Ltencent/im/oidb/oidb_0xd1e/oidb_0xd1e$ReqBody;", "onCommentOperationFailed", "errorCode", "errorMsg", "onSubCommentCreateSuccess", "subCommentId", "parseSubCommentCreateData", "", "send0xd1eRequest", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class pdk
{
  @NotNull
  private final SubCommentCreateData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData;
  @Nullable
  private Function1<? super Integer, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  @Nullable
  private Function2<? super Integer, ? super String, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction2;
  
  public pdk(@NotNull SubCommentCreateData paramSubCommentCreateData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData = paramSubCommentCreateData;
  }
  
  private final oidb_0xd1e.ReqBody a()
  {
    oidb_0xd1e.ReqBody localReqBody = new oidb_0xd1e.ReqBody();
    oidb_0xd1e.SubCommentCreateReq localSubCommentCreateReq = new oidb_0xd1e.SubCommentCreateReq();
    SubCommentCreateData localSubCommentCreateData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData;
    localSubCommentCreateReq.rowkey.set(localSubCommentCreateData.b());
    localSubCommentCreateReq.article_id.set(localSubCommentCreateData.c());
    localSubCommentCreateReq.author_id.set(localSubCommentCreateData.a());
    localSubCommentCreateReq.business_info.set(localSubCommentCreateData.d());
    localSubCommentCreateReq.content_src.set(localSubCommentCreateData.d());
    localSubCommentCreateReq.src.set(localSubCommentCreateData.c());
    localSubCommentCreateReq.scene.set(localSubCommentCreateData.b());
    localSubCommentCreateReq.content.set(localSubCommentCreateData.e());
    localSubCommentCreateReq.first_comment_id.set(localSubCommentCreateData.a());
    localSubCommentCreateReq.replied_sub_author_id.set(localSubCommentCreateData.b());
    localSubCommentCreateReq.replied_sub_comment_id.set(localSubCommentCreateData.f());
    localReqBody.sub_comment_create_req.set((MessageMicro)localSubCommentCreateReq);
    return localReqBody;
  }
  
  private final void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
    if (localObject != null) {
      localObject = (Unit)((Function1)localObject).invoke(Integer.valueOf(paramInt));
    }
  }
  
  private final void a(byte[] paramArrayOfByte)
  {
    oidb_0xd1e.RspBody localRspBody = new oidb_0xd1e.RspBody();
    localRspBody.mergeFrom(paramArrayOfByte);
    a(localRspBody.sub_comment_create_rsp.sub_comment_id.get());
  }
  
  public final void a()
  {
    oidb_0xd1e.ReqBody localReqBody = a();
    nir.a(pha.a(), (niv)new pdl(this), localReqBody.toByteArray(), "OidbSvc.0xd1e", 3358, 1);
  }
  
  public final void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    Function2 localFunction2 = this.jdField_a_of_type_KotlinJvmFunctionsFunction2;
    if (localFunction2 != null) {
      paramString = (Unit)localFunction2.invoke(Integer.valueOf(paramInt), paramString);
    }
  }
  
  public final void a(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public final void a(@Nullable Function2<? super Integer, ? super String, Unit> paramFunction2)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction2 = paramFunction2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pdk
 * JD-Core Version:    0.7.0.1
 */