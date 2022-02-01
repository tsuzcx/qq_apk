package com.tencent.mobileqq.kandian.biz.comment.helper;

import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentHelper;
import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SimpleCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentCreateData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.CommentInfo;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.ContentInfo;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.ParamInfo;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.ReqBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/helper/RIJBiuNetworkHelper;", "", "()V", "TAG", "", "getOnlyBiuReqBody", "Ltencent/im/oidb/cmd0xe16/oidb_cmd0xe16$ReqBody;", "commentData", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/SimpleCommentData;", "requestBiuAfterComment", "", "onlyBiuCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", "errorCode", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJBiuNetworkHelper
{
  public static final RIJBiuNetworkHelper a = new RIJBiuNetworkHelper();
  
  private final oidb_cmd0xe16.ReqBody a(SimpleCommentData paramSimpleCommentData)
  {
    oidb_cmd0xe16.ContentInfo localContentInfo = new oidb_cmd0xe16.ContentInfo();
    localContentInfo.uint32_src.set(ReadInJoyCommentHelper.a(paramSimpleCommentData.d()));
    if ((paramSimpleCommentData instanceof FirstCommentCreateData))
    {
      localContentInfo.str_rowkey.set(paramSimpleCommentData.c());
      localContentInfo.str_article_id.set(paramSimpleCommentData.d());
      localObject = ((FirstCommentCreateData)paramSimpleCommentData).b();
    }
    else if ((paramSimpleCommentData instanceof SubCommentCreateData))
    {
      localContentInfo.str_rowkey.set(paramSimpleCommentData.c());
      localContentInfo.str_article_id.set(paramSimpleCommentData.d());
      localObject = ((SubCommentCreateData)paramSimpleCommentData).g();
    }
    else
    {
      localObject = "";
    }
    oidb_cmd0xe16.CommentInfo localCommentInfo = new oidb_cmd0xe16.CommentInfo();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localCommentInfo.str_comment.set((String)localObject);
      if ((paramSimpleCommentData instanceof SubCommentCreateData))
      {
        paramSimpleCommentData = (SubCommentCreateData)paramSimpleCommentData;
        if (paramSimpleCommentData.b() != 0L) {
          localCommentInfo.uint64_sub_author.set(paramSimpleCommentData.b());
        }
        localCommentInfo.str_sub_comment_id.set(paramSimpleCommentData.f());
        int i;
        if (((CharSequence)paramSimpleCommentData.a()).length() > 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          localCommentInfo.str_comment_id.set(paramSimpleCommentData.a());
        }
      }
    }
    Object localObject = new oidb_cmd0xe16.ParamInfo();
    ((oidb_cmd0xe16.ParamInfo)localObject).bool_only_biu.set(true);
    paramSimpleCommentData = new oidb_cmd0xe16.ReqBody();
    paramSimpleCommentData.msg_comment_info.set((MessageMicro)localCommentInfo);
    paramSimpleCommentData.msg_content_info.set((MessageMicro)localContentInfo);
    paramSimpleCommentData.msg_param_info.set((MessageMicro)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestBiuAfterComment :");
      ((StringBuilder)localObject).append(paramSimpleCommentData);
      QLog.d("RIJBiuNetworkHelper", 2, ((StringBuilder)localObject).toString());
    }
    return paramSimpleCommentData;
  }
  
  public final void a(@NotNull SimpleCommentData paramSimpleCommentData, @NotNull Function2<? super Boolean, ? super Integer, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleCommentData, "commentData");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "onlyBiuCallback");
    paramSimpleCommentData = a(paramSimpleCommentData);
    ProtoUtils.a((AppRuntime)RIJQQAppInterfaceUtil.a(), (ProtoUtils.TroopProtocolObserver)new RIJBiuNetworkHelper.requestBiuAfterComment.1(paramFunction2), paramSimpleCommentData.toByteArray(), "OidbSvc.0xe16", 3606, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJBiuNetworkHelper
 * JD-Core Version:    0.7.0.1
 */