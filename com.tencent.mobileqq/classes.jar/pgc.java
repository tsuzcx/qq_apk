import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentLinkData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentCreateData;
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
import tencent.im.oidb.oidb_0xefd.oidb_0xefd.FirstCommentCreateReq;
import tencent.im.oidb.oidb_0xefd.oidb_0xefd.FirstCommentCreateRsp;
import tencent.im.oidb.oidb_0xefd.oidb_0xefd.LinkData;
import tencent.im.oidb.oidb_0xefd.oidb_0xefd.ReqBody;
import tencent.im.oidb.oidb_0xefd.oidb_0xefd.RspBody;
import tencent.im.oidb.oidb_0xefd.oidb_0xefd.RspResult;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/CreateFirstCommentHandlerForHippy;", "", "commentCreateData", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentCreateData;", "extraParam", "", "(Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentCreateData;Ljava/lang/String;)V", "onFailedCallback", "Lkotlin/Function2;", "", "", "getOnFailedCallback", "()Lkotlin/jvm/functions/Function2;", "setOnFailedCallback", "(Lkotlin/jvm/functions/Function2;)V", "onSuccessCallback", "getOnSuccessCallback", "setOnSuccessCallback", "generateRequestBody", "Ltencent/im/oidb/oidb_0xefd/oidb_0xefd$ReqBody;", "onCommentOperationFailed", "errorCode", "errorMsg", "onFirstCommentCreateSuccess", "comment", "commentId", "parseFirstCommentCreateData", "data", "", "send0xefdRequest", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class pgc
{
  private final FirstCommentCreateData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentCreateData;
  private final String jdField_a_of_type_JavaLangString;
  @Nullable
  private Function2<? super String, ? super String, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction2;
  @Nullable
  private Function2<? super Integer, ? super String, Unit> b;
  
  public pgc(@NotNull FirstCommentCreateData paramFirstCommentCreateData, @NotNull String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentCreateData = paramFirstCommentCreateData;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  @VisibleForTesting
  @NotNull
  public final oidb_0xefd.ReqBody a()
  {
    oidb_0xefd.FirstCommentCreateReq localFirstCommentCreateReq = new oidb_0xefd.FirstCommentCreateReq();
    localFirstCommentCreateReq.rowkey.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentCreateData.b());
    localFirstCommentCreateReq.article_id.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentCreateData.c());
    localFirstCommentCreateReq.author_id.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentCreateData.a());
    localFirstCommentCreateReq.business_info.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentCreateData.d());
    localFirstCommentCreateReq.content_src.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentCreateData.d());
    localFirstCommentCreateReq.src.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentCreateData.c());
    localFirstCommentCreateReq.scene.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentCreateData.b());
    localFirstCommentCreateReq.content.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentCreateData.a());
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentCreateData.a();
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
          localFirstCommentCreateReq.link_data.add((MessageMicro)localLinkData);
          break;
          localObject = "";
        }
      }
    }
    localFirstCommentCreateReq.extra_param.set(this.jdField_a_of_type_JavaLangString);
    localObject = new oidb_0xefd.ReqBody();
    ((oidb_0xefd.ReqBody)localObject).first_comment_create_req.set((MessageMicro)localFirstCommentCreateReq);
    return localObject;
  }
  
  public final void a()
  {
    oidb_0xefd.ReqBody localReqBody = a();
    ntb.a(pnn.a(), (ntf)new pgd(this), localReqBody.toByteArray(), "OidbSvc.0xefd", 3837, 4);
  }
  
  @VisibleForTesting
  public final void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    Function2 localFunction2 = this.b;
    if (localFunction2 != null) {
      paramString = (Unit)localFunction2.invoke(Integer.valueOf(paramInt), paramString);
    }
  }
  
  @VisibleForTesting
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "comment");
    Intrinsics.checkParameterIsNotNull(paramString2, "commentId");
    Function2 localFunction2 = this.jdField_a_of_type_KotlinJvmFunctionsFunction2;
    if (localFunction2 != null) {
      paramString1 = (Unit)localFunction2.invoke(paramString1, paramString2);
    }
  }
  
  public final void a(@Nullable Function2<? super String, ? super String, Unit> paramFunction2)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction2 = paramFunction2;
  }
  
  @VisibleForTesting
  public final void a(@NotNull byte[] paramArrayOfByte)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "data");
    Object localObject = new oidb_0xefd.RspBody();
    ((oidb_0xefd.RspBody)localObject).mergeFrom(paramArrayOfByte);
    int i = ((oidb_0xefd.RspBody)localObject).retcode.get();
    localObject = (oidb_0xefd.RspResult)((oidb_0xefd.RspBody)localObject).result.get();
    if ((i == 0) && (localObject != null))
    {
      if (((oidb_0xefd.RspResult)localObject).first_comment_create_rsp.link_comment_over_times.get() == 1)
      {
        i = 1;
        paramArrayOfByte = ((oidb_0xefd.RspResult)localObject).first_comment_create_rsp.str_comment.get();
        localObject = ((oidb_0xefd.RspResult)localObject).first_comment_create_rsp.comment_id.get();
        Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "comment");
        if (((CharSequence)paramArrayOfByte).length() <= 0) {
          break label146;
        }
      }
      for (;;)
      {
        if ((j == 0) || (i != 0)) {
          break label151;
        }
        Intrinsics.checkExpressionValueIsNotNull(localObject, "commentId");
        a(paramArrayOfByte, (String)localObject);
        return;
        i = 0;
        break;
        label146:
        j = 0;
      }
      label151:
      if (i != 0) {}
      for (i = -4096;; i = -1)
      {
        a(i, "Comment is empty.");
        return;
      }
    }
    a(i, "create first comment failed");
  }
  
  public final void b(@Nullable Function2<? super Integer, ? super String, Unit> paramFunction2)
  {
    this.b = paramFunction2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgc
 * JD-Core Version:    0.7.0.1
 */