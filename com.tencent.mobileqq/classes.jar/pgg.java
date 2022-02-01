import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentLinkData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SubCommentCreateData;
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
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_0xefd.oidb_0xefd.FirstCommentCreateRsp;
import tencent.im.oidb.oidb_0xefd.oidb_0xefd.LinkData;
import tencent.im.oidb.oidb_0xefd.oidb_0xefd.ReqBody;
import tencent.im.oidb.oidb_0xefd.oidb_0xefd.RspBody;
import tencent.im.oidb.oidb_0xefd.oidb_0xefd.RspResult;
import tencent.im.oidb.oidb_0xefd.oidb_0xefd.SubCommentCreateReq;
import tencent.im.oidb.oidb_0xefd.oidb_0xefd.SubCommentCreateRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/CreateSubCommentHandlerForHippy;", "", "createCommentData", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SubCommentCreateData;", "extraParam", "", "(Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SubCommentCreateData;Ljava/lang/String;)V", "onFailedCallback", "Lkotlin/Function2;", "", "", "getOnFailedCallback", "()Lkotlin/jvm/functions/Function2;", "setOnFailedCallback", "(Lkotlin/jvm/functions/Function2;)V", "onSuccessCallback", "getOnSuccessCallback", "setOnSuccessCallback", "generateRequestBody", "Ltencent/im/oidb/oidb_0xefd/oidb_0xefd$ReqBody;", "onCommentOperationFailed", "errorCode", "errorMsg", "onSubCommentCreateSuccess", "comment", "commentId", "parseSubCommentCreateData", "data", "", "send0xefdRequest", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class pgg
{
  private final SubCommentCreateData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData;
  private final String jdField_a_of_type_JavaLangString;
  @Nullable
  private Function2<? super String, ? super Integer, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction2;
  @Nullable
  private Function2<? super Integer, ? super String, Unit> b;
  
  public pgg(@NotNull SubCommentCreateData paramSubCommentCreateData, @NotNull String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData = paramSubCommentCreateData;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  @VisibleForTesting
  @NotNull
  public final oidb_0xefd.ReqBody a()
  {
    oidb_0xefd.SubCommentCreateReq localSubCommentCreateReq = new oidb_0xefd.SubCommentCreateReq();
    localSubCommentCreateReq.rowkey.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData.b());
    localSubCommentCreateReq.article_id.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData.c());
    localSubCommentCreateReq.author_id.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData.a());
    localSubCommentCreateReq.business_info.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData.d());
    localSubCommentCreateReq.content_src.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData.d());
    localSubCommentCreateReq.src.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData.c());
    localSubCommentCreateReq.scene.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData.b());
    localSubCommentCreateReq.content.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData.e());
    localSubCommentCreateReq.first_comment_id.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData.a());
    localSubCommentCreateReq.replied_sub_author_id.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData.b());
    localSubCommentCreateReq.replied_sub_comment_id.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData.f());
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData.a();
    if (localObject != null)
    {
      Iterator localIterator = ((Iterable)localObject).iterator();
      if (localIterator.hasNext())
      {
        BaseCommentData.CommentLinkData localCommentLinkData = (BaseCommentData.CommentLinkData)localIterator.next();
        oidb_0xefd.LinkData localLinkData = new oidb_0xefd.LinkData();
        localLinkData.type.set(localCommentLinkData.type);
        localLinkData.url.set(localCommentLinkData.linkUrl);
        PBStringField localPBStringField = localLinkData.icon;
        localObject = localCommentLinkData.iconUrl;
        if (localObject != null) {}
        for (;;)
        {
          localPBStringField.set((String)localObject);
          localLinkData.wording.set(localCommentLinkData.wording);
          localSubCommentCreateReq.link_data.add((MessageMicro)localLinkData);
          break;
          localObject = "";
        }
      }
    }
    localSubCommentCreateReq.extra_param.set(this.jdField_a_of_type_JavaLangString);
    localObject = new oidb_0xefd.ReqBody();
    ((oidb_0xefd.ReqBody)localObject).sub_comment_create_req.set((MessageMicro)localSubCommentCreateReq);
    return localObject;
  }
  
  public final void a()
  {
    oidb_0xefd.ReqBody localReqBody = a();
    ntb.a(pnn.a(), (ntf)new pgh(this), localReqBody.toByteArray(), "OidbSvc.0xefd", 3837, 1);
  }
  
  public final void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    Function2 localFunction2 = this.b;
    if (localFunction2 != null) {
      paramString = (Unit)localFunction2.invoke(Integer.valueOf(paramInt), paramString);
    }
  }
  
  @VisibleForTesting
  public final void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "comment");
    Function2 localFunction2 = this.jdField_a_of_type_KotlinJvmFunctionsFunction2;
    if (localFunction2 != null) {
      paramString = (Unit)localFunction2.invoke(paramString, Integer.valueOf(paramInt));
    }
  }
  
  public final void a(@Nullable Function2<? super String, ? super Integer, Unit> paramFunction2)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction2 = paramFunction2;
  }
  
  @VisibleForTesting
  public final void a(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "data");
    Object localObject = new oidb_0xefd.RspBody();
    ((oidb_0xefd.RspBody)localObject).mergeFrom(paramArrayOfByte);
    int i = ((oidb_0xefd.RspBody)localObject).retcode.get();
    paramArrayOfByte = (oidb_0xefd.RspResult)((oidb_0xefd.RspBody)localObject).result.get();
    if ((i == 0) && (paramArrayOfByte != null))
    {
      localObject = paramArrayOfByte.sub_comment_create_rsp.str_comment.get();
      int j = paramArrayOfByte.sub_comment_create_rsp.sub_comment_id.get();
      if (paramArrayOfByte.first_comment_create_rsp.link_comment_over_times.get() == 1) {}
      for (i = 1; i != 0; i = 0)
      {
        a(-4096, "");
        return;
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject, "comment");
      a((String)localObject, j);
      return;
    }
    a(i, "create sub comment failed");
  }
  
  public final void b(@Nullable Function2<? super Integer, ? super String, Unit> paramFunction2)
  {
    this.b = paramFunction2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgg
 * JD-Core Version:    0.7.0.1
 */