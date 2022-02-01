import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentLinkData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentCreateData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.FirstCommentCreateReq;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.FirstCommentCreateRsp;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.LinkData;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.ReqBody;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.RspBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/CreateFirstCommentHandler;", "", "data", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentCreateData;", "(Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentCreateData;)V", "getData", "()Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentCreateData;", "onFailedCallback", "Lkotlin/Function2;", "", "", "", "getOnFailedCallback", "()Lkotlin/jvm/functions/Function2;", "setOnFailedCallback", "(Lkotlin/jvm/functions/Function2;)V", "onSuccessCallback", "Lkotlin/Function1;", "getOnSuccessCallback", "()Lkotlin/jvm/functions/Function1;", "setOnSuccessCallback", "(Lkotlin/jvm/functions/Function1;)V", "generateRequestBody", "Ltencent/im/oidb/oidb_0xd1e/oidb_0xd1e$ReqBody;", "onCommentOperationFailed", "errorCode", "errorMsg", "onFirstCommentCreateSuccess", "commentId", "parseFirstCommentCreateData", "", "send0xd1eRequest", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class oxa
{
  @NotNull
  private final FirstCommentCreateData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentCreateData;
  @Nullable
  private Function1<? super String, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  @Nullable
  private Function2<? super Integer, ? super String, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction2;
  
  public oxa(@NotNull FirstCommentCreateData paramFirstCommentCreateData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentCreateData = paramFirstCommentCreateData;
  }
  
  private final oidb_0xd1e.ReqBody a()
  {
    oidb_0xd1e.ReqBody localReqBody = new oidb_0xd1e.ReqBody();
    oidb_0xd1e.FirstCommentCreateReq localFirstCommentCreateReq = new oidb_0xd1e.FirstCommentCreateReq();
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentCreateData;
    localFirstCommentCreateReq.rowkey.set(((FirstCommentCreateData)localObject).b());
    localFirstCommentCreateReq.article_id.set(((FirstCommentCreateData)localObject).c());
    localFirstCommentCreateReq.author_id.set(((FirstCommentCreateData)localObject).a());
    localFirstCommentCreateReq.business_info.set(((FirstCommentCreateData)localObject).d());
    localFirstCommentCreateReq.content_src.set(((FirstCommentCreateData)localObject).d());
    localFirstCommentCreateReq.src.set(((FirstCommentCreateData)localObject).c());
    localFirstCommentCreateReq.scene.set(((FirstCommentCreateData)localObject).b());
    localFirstCommentCreateReq.content.set(((FirstCommentCreateData)localObject).a());
    localObject = ((FirstCommentCreateData)localObject).a();
    if (localObject != null)
    {
      Iterator localIterator = ((Iterable)localObject).iterator();
      if (localIterator.hasNext())
      {
        BaseCommentData.CommentLinkData localCommentLinkData = (BaseCommentData.CommentLinkData)localIterator.next();
        oidb_0xd1e.LinkData localLinkData = new oidb_0xd1e.LinkData();
        localLinkData.type.set(localCommentLinkData.type);
        localLinkData.url.set(localCommentLinkData.linkUrl);
        PBStringField localPBStringField = localLinkData.icon;
        localObject = localCommentLinkData.iconUrl;
        if (localObject != null) {}
        for (;;)
        {
          localPBStringField.set((String)localObject);
          localLinkData.wording.set(localCommentLinkData.wording);
          localFirstCommentCreateReq.link_data.add((MessageMicro)localLinkData);
          break;
          localObject = "";
        }
      }
    }
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
    int j = 1;
    oidb_0xd1e.RspBody localRspBody = new oidb_0xd1e.RspBody();
    localRspBody.mergeFrom(paramArrayOfByte);
    int i;
    if (localRspBody.first_comment_create_rsp.link_comment_over_times.get() == 1)
    {
      i = 1;
      paramArrayOfByte = localRspBody.first_comment_create_rsp.comment_id.get();
      Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "commentId");
      if (((CharSequence)paramArrayOfByte).length() <= 0) {
        break label84;
      }
    }
    for (;;)
    {
      if ((j == 0) || (i != 0)) {
        break label89;
      }
      a(paramArrayOfByte);
      return;
      i = 0;
      break;
      label84:
      j = 0;
    }
    label89:
    j = -1;
    if (i != 0) {
      j = -4096;
    }
    a(j, "CommentId is empty.");
  }
  
  public final void a()
  {
    oidb_0xd1e.ReqBody localReqBody = a();
    nmb.a(pay.a(), (nmf)new oxb(this), localReqBody.toByteArray(), "OidbSvc.0xd1e", 3358, 4);
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
 * Qualified Name:     oxa
 * JD-Core Version:    0.7.0.1
 */