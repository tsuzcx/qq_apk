package com.tencent.mobileqq.kandian.biz.biu;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IRIJBiuAndCommentMixDataManager;
import com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IRIJBiuAndCommentMixDataManager.BiuAndCommentListener;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.repo.comment.entity.RIJBiuAndCommentRequestData;
import com.tencent.mobileqq.kandian.repo.comment.entity.RIJBiuAndCommentRespData;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.CardJumpInfo;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.KeyInfo;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.RspBody;

@Deprecated
public class RIJBiuAndCommentMixDataManager
  implements RIJBiuAndCommentMixPBModule.BiuAndCommentPBObserver, IRIJBiuAndCommentMixDataManager
{
  private RIJBiuAndCommentMixPBModule b;
  private IRIJBiuAndCommentMixDataManager.BiuAndCommentListener c;
  
  public RIJBiuAndCommentMixDataManager()
  {
    Object localObject = RIJQQAppInterfaceUtil.a();
    if (localObject != null)
    {
      localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if (localObject != null)
      {
        this.b = ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().m();
        localObject = this.b;
        if (localObject != null) {
          ((RIJBiuAndCommentMixPBModule)localObject).a(this);
        }
        QLog.d("RIJBiuAndCommentMixDataManager", 1, "RIJBiuAndCommentMixDataManager init");
      }
    }
  }
  
  private RIJBiuAndCommentRespData a(oidb_cmd0xe16.RspBody paramRspBody, int paramInt, ToServiceMsg paramToServiceMsg)
  {
    RIJBiuAndCommentRespData localRIJBiuAndCommentRespData = new RIJBiuAndCommentRespData();
    localRIJBiuAndCommentRespData.a(paramInt);
    if (paramRspBody.msg_key_info.has())
    {
      if (paramRspBody.msg_key_info.uint64_feeds_id.has()) {
        localRIJBiuAndCommentRespData.b(String.valueOf(paramRspBody.msg_key_info.uint64_feeds_id.get()));
      }
      if (paramRspBody.msg_key_info.uint32_feeds_type.has()) {
        localRIJBiuAndCommentRespData.b(paramRspBody.msg_key_info.uint32_feeds_type.get());
      }
      if ((paramRspBody.msg_key_info.str_sub_comment_id.has()) && (!TextUtils.isEmpty(paramRspBody.msg_key_info.str_sub_comment_id.get()))) {
        localRIJBiuAndCommentRespData.a(paramRspBody.msg_key_info.str_sub_comment_id.get());
      } else if ((paramRspBody.msg_key_info.str_comment_id.has()) && (!TextUtils.isEmpty(paramRspBody.msg_key_info.str_comment_id.get()))) {
        localRIJBiuAndCommentRespData.a(paramRspBody.msg_key_info.str_comment_id.get());
      }
    }
    if (paramRspBody.msg_card_jump_info.has())
    {
      if ((paramRspBody.msg_card_jump_info.bytes_card_jump_url.has()) && (!TextUtils.isEmpty(paramRspBody.msg_card_jump_info.bytes_card_jump_url.get().toStringUtf8()))) {
        localRIJBiuAndCommentRespData.h(paramRspBody.msg_card_jump_info.bytes_card_jump_url.get().toStringUtf8());
      }
      if ((paramRspBody.msg_card_jump_info.bytes_comment_btn_url.has()) && (!TextUtils.isEmpty(paramRspBody.msg_card_jump_info.bytes_comment_btn_url.get().toStringUtf8()))) {
        localRIJBiuAndCommentRespData.i(paramRspBody.msg_card_jump_info.bytes_comment_btn_url.get().toStringUtf8());
      }
      if (paramRspBody.msg_card_jump_info.uint32_available.has()) {
        localRIJBiuAndCommentRespData.e(paramRspBody.msg_card_jump_info.uint32_available.get());
      }
      if (paramRspBody.msg_card_jump_info.bytes_share_url.has()) {
        localRIJBiuAndCommentRespData.c(paramRspBody.msg_card_jump_info.bytes_share_url.get().toStringUtf8());
      }
    }
    if ((paramToServiceMsg != null) && (paramToServiceMsg.getAttributes() != null))
    {
      paramRspBody = (RIJBiuAndCommentRequestData)paramToServiceMsg.getAttributes().get("request_data_entry");
      if (paramRspBody != null)
      {
        localRIJBiuAndCommentRespData.d(paramRspBody.getContentString());
        localRIJBiuAndCommentRespData.d(paramRspBody.getListShowType());
        localRIJBiuAndCommentRespData.c(paramRspBody.getCommentType());
        localRIJBiuAndCommentRespData.e(paramRspBody.getReplyCommentId());
        localRIJBiuAndCommentRespData.f(paramRspBody.getReplyParentCommentId());
        localRIJBiuAndCommentRespData.g(paramRspBody.getReplyUin());
        localRIJBiuAndCommentRespData.a(paramRspBody.isIsSecondReply());
        localRIJBiuAndCommentRespData.f(paramRspBody.getContentSrc());
      }
      paramRspBody = paramToServiceMsg.getAttributes().get("article_attributes");
      if ((paramRspBody instanceof BaseArticleInfo)) {
        localRIJBiuAndCommentRespData.a((AbsBaseArticleInfo)paramRspBody);
      }
    }
    paramRspBody = new StringBuilder();
    paramRspBody.append("onBiuAndCommentMixSend RIJBiuAndCommentRespData info is");
    paramRspBody.append(localRIJBiuAndCommentRespData.toString());
    QLog.d("RIJBiuAndCommentMixDataManager", 1, paramRspBody.toString());
    return localRIJBiuAndCommentRespData;
  }
  
  private void a(RIJBiuAndCommentRespData paramRIJBiuAndCommentRespData)
  {
    if ((paramRIJBiuAndCommentRespData != null) && (paramRIJBiuAndCommentRespData.f() != null))
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = paramRIJBiuAndCommentRespData.f();
      try
      {
        paramRIJBiuAndCommentRespData = new JSONObject();
        paramRIJBiuAndCommentRespData.put("rowkey", localAbsBaseArticleInfo.innerUniqueID);
        paramRIJBiuAndCommentRespData.put("article_id", localAbsBaseArticleInfo.mArticleID);
        paramRIJBiuAndCommentRespData.put("content_type", 1);
        paramRIJBiuAndCommentRespData.put("time", System.currentTimeMillis() / 1000L);
        paramRIJBiuAndCommentRespData = paramRIJBiuAndCommentRespData.toString();
      }
      catch (JSONException paramRIJBiuAndCommentRespData)
      {
        QLog.d("RIJBiuAndCommentMixDataManager", 2, paramRIJBiuAndCommentRespData.getMessage());
        paramRIJBiuAndCommentRespData = "";
      }
      PublicAccountReportUtils.a(null, ReadInJoyCommentUtils.a(localAbsBaseArticleInfo), "0X800AC6A", "0X800AC6A", 0, 0, String.valueOf(localAbsBaseArticleInfo.mArticleID), "", localAbsBaseArticleInfo.innerUniqueID, paramRIJBiuAndCommentRespData, false);
      return;
    }
    QLog.d("RIJBiuAndCommentMixDataManager", 2, "reportMixCommentBiuResult | respData or mArticleInfo is null");
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean, String paramString3, String paramString4, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      QLog.d("RIJBiuAndCommentMixDataManager", 1, "createLocalComment article info is null");
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("comment", paramString1);
      localJSONObject.put("commentId", paramString3);
      localJSONObject.put("isSecondReply", paramBoolean);
      localJSONObject.put("replyUin", paramString4);
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    paramString1 = ReadInJoyCommentDataManager.a(paramAbsBaseArticleInfo);
    if (paramString1 != null) {
      paramString1.a(paramString1.a(paramInt1, localJSONObject.toString()), paramString2, paramInt2);
    }
  }
  
  public void a()
  {
    RIJBiuAndCommentMixPBModule localRIJBiuAndCommentMixPBModule = this.b;
    if (localRIJBiuAndCommentMixPBModule != null)
    {
      localRIJBiuAndCommentMixPBModule.unInitialize();
      this.b = null;
    }
    this.c = null;
    QLog.d("RIJBiuAndCommentMixDataManager", 1, "onDestroy clear info");
  }
  
  public void a(IRIJBiuAndCommentMixDataManager.BiuAndCommentListener paramBiuAndCommentListener)
  {
    this.c = paramBiuAndCommentListener;
    QLog.d("RIJBiuAndCommentMixDataManager", 1, "setBiuAndCommentListener");
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJBiuAndCommentRequestData paramRIJBiuAndCommentRequestData)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramRIJBiuAndCommentRequestData != null))
    {
      if (this.b != null)
      {
        QLog.d("RIJBiuAndCommentMixDataManager", 1, "requestCreateBiuAndCommentMixComment goTo pbRequest");
        this.b.a(paramAbsBaseArticleInfo, paramRIJBiuAndCommentRequestData);
      }
      return;
    }
    QLog.d("RIJBiuAndCommentMixDataManager", 1, "requestCreateBiuAndCommentMixComment someThing is null");
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xe16.RspBody localRspBody = new oidb_cmd0xe16.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    paramToServiceMsg = a(localRspBody, i, paramToServiceMsg);
    ThreadManager.getUIHandler().post(new RIJBiuAndCommentMixDataManager.1(this, paramToServiceMsg, i));
    if (i == 0) {
      a(paramToServiceMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.RIJBiuAndCommentMixDataManager
 * JD-Core Version:    0.7.0.1
 */