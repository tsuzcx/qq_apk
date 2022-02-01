import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentStickyData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.FirstCommentAuthorTopSetReq;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.FirstCommentAuthorTopSetRsp;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.ReqBody;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.RspBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/FirstCommentStickyHandler;", "", "data", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentStickyData;", "(Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentStickyData;)V", "getData", "()Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentStickyData;", "onFailCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isOverTimes", "", "getOnFailCallback", "()Lkotlin/jvm/functions/Function1;", "setOnFailCallback", "(Lkotlin/jvm/functions/Function1;)V", "onSuccessCallback", "Lkotlin/Function0;", "getOnSuccessCallback", "()Lkotlin/jvm/functions/Function0;", "setOnSuccessCallback", "(Lkotlin/jvm/functions/Function0;)V", "generateRequestBody", "Ltencent/im/oidb/oidb_0xd1e/oidb_0xd1e$ReqBody;", "onCommentOperationFailed", "errorCode", "", "errorMsg", "", "onCommentOperationSuccess", "", "send0xd1eRequest", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class pgl
{
  @NotNull
  private static final String jdField_a_of_type_JavaLangString = "FirstCommentStickyHandler";
  public static final pgm a;
  @NotNull
  private final FirstCommentStickyData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentStickyData;
  @Nullable
  private Function0<Unit> jdField_a_of_type_KotlinJvmFunctionsFunction0;
  @Nullable
  private Function1<? super Boolean, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  
  static
  {
    jdField_a_of_type_Pgm = new pgm(null);
  }
  
  public pgl(@NotNull FirstCommentStickyData paramFirstCommentStickyData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentStickyData = paramFirstCommentStickyData;
  }
  
  private final oidb_0xd1e.ReqBody a()
  {
    oidb_0xd1e.ReqBody localReqBody = new oidb_0xd1e.ReqBody();
    oidb_0xd1e.FirstCommentAuthorTopSetReq localFirstCommentAuthorTopSetReq = new oidb_0xd1e.FirstCommentAuthorTopSetReq();
    localFirstCommentAuthorTopSetReq.article_id.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentStickyData.b());
    localFirstCommentAuthorTopSetReq.comment_id.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentStickyData.a());
    localFirstCommentAuthorTopSetReq.comment_type.set(1);
    localFirstCommentAuthorTopSetReq.op_type.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentStickyData.a());
    localFirstCommentAuthorTopSetReq.content_src.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentStickyData.d());
    localFirstCommentAuthorTopSetReq.src.set(0);
    localFirstCommentAuthorTopSetReq.business_info.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentStickyData.d());
    localReqBody.first_comment_author_top_set_req.set((MessageMicro)localFirstCommentAuthorTopSetReq);
    return localReqBody;
  }
  
  public final void a()
  {
    oidb_0xd1e.ReqBody localReqBody = a();
    ntb.a(pnn.a(), (ntf)new pgn(this), localReqBody.toByteArray(), "OidbSvc.0xd1e", 3358, 10);
  }
  
  public final void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    QLog.d(jdField_a_of_type_JavaLangString, 1, "errorCode : " + paramInt + "  msg: " + paramString);
    paramString = this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
    if (paramString != null) {
      paramString = (Unit)paramString.invoke(Boolean.valueOf(false));
    }
  }
  
  public final void a(@Nullable Function0<Unit> paramFunction0)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction0 = paramFunction0;
  }
  
  public final void a(@Nullable Function1<? super Boolean, Unit> paramFunction1)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public final void a(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "data");
    oidb_0xd1e.RspBody localRspBody = new oidb_0xd1e.RspBody();
    localRspBody.mergeFrom(paramArrayOfByte);
    if ((localRspBody.first_comment_author_top_set_rsp.over_times.has()) && (localRspBody.first_comment_author_top_set_rsp.over_times.get() > 0))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "req fail, overtimes");
      paramArrayOfByte = this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
      if (paramArrayOfByte != null) {
        paramArrayOfByte = (Unit)paramArrayOfByte.invoke(Boolean.valueOf(true));
      }
    }
    do
    {
      return;
      QLog.d(jdField_a_of_type_JavaLangString, 1, "req success");
      paramArrayOfByte = this.jdField_a_of_type_KotlinJvmFunctionsFunction0;
    } while (paramArrayOfByte == null);
    paramArrayOfByte = (Unit)paramArrayOfByte.invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgl
 * JD-Core Version:    0.7.0.1
 */