package com.tencent.mobileqq.kandian.biz.biu;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.comment.entity.RIJBiuAndCommentRequestData;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.CommentInfo;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.ContentInfo;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.ParamInfo;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.ReqBody;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.RspBody;

public class RIJBiuAndCommentMixPBModule
  extends ReadInJoyEngineModule
{
  private RIJBiuAndCommentMixPBModule.BiuAndCommentPBObserver a;
  
  public RIJBiuAndCommentMixPBModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private oidb_cmd0xe16.ReqBody a(RIJBiuAndCommentRequestData paramRIJBiuAndCommentRequestData, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    oidb_cmd0xe16.ContentInfo localContentInfo = new oidb_cmd0xe16.ContentInfo();
    localContentInfo.str_rowkey.set(paramRIJBiuAndCommentRequestData.getRowKey());
    localContentInfo.uint32_src.set(paramRIJBiuAndCommentRequestData.getContentSrc());
    oidb_cmd0xe16.CommentInfo localCommentInfo = new oidb_cmd0xe16.CommentInfo();
    if (!TextUtils.isEmpty(paramRIJBiuAndCommentRequestData.getContentString()))
    {
      localCommentInfo.str_comment.set(new String(Base64Util.decode(paramRIJBiuAndCommentRequestData.getContentString().getBytes(), 0)));
      if (paramRIJBiuAndCommentRequestData.getCommentType() == 2)
      {
        if (!TextUtils.isEmpty(paramRIJBiuAndCommentRequestData.getReplyUin())) {
          localCommentInfo.uint64_sub_author.set(Long.parseLong(paramRIJBiuAndCommentRequestData.getReplyUin()));
        }
        localCommentInfo.str_sub_comment_id.set(paramRIJBiuAndCommentRequestData.getReplyCommentId());
        if (!TextUtils.isEmpty(paramRIJBiuAndCommentRequestData.getReplyParentCommentId()))
        {
          localCommentInfo.str_comment_id.set(paramRIJBiuAndCommentRequestData.getReplyParentCommentId());
        }
        else
        {
          paramAbsBaseArticleInfo = ReadInJoyCommentDataManager.a(paramAbsBaseArticleInfo);
          if (paramAbsBaseArticleInfo != null)
          {
            paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.a(paramRIJBiuAndCommentRequestData.getReplyCommentId());
            paramRIJBiuAndCommentRequestData.setReplyParentCommentId(paramAbsBaseArticleInfo);
            localCommentInfo.str_comment_id.set(paramAbsBaseArticleInfo);
          }
        }
      }
    }
    paramAbsBaseArticleInfo = new oidb_cmd0xe16.ParamInfo();
    paramAbsBaseArticleInfo.bool_diffuse_to_friends.set(paramRIJBiuAndCommentRequestData.isDiffuseToFriends());
    paramAbsBaseArticleInfo.bool_with_biu.set(paramRIJBiuAndCommentRequestData.isBiu());
    paramRIJBiuAndCommentRequestData = new oidb_cmd0xe16.ReqBody();
    paramRIJBiuAndCommentRequestData.msg_comment_info.set(localCommentInfo);
    paramRIJBiuAndCommentRequestData.msg_content_info.set(localContentInfo);
    paramRIJBiuAndCommentRequestData.msg_param_info.set(paramAbsBaseArticleInfo);
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append("get0xe16ReqBody :");
    paramAbsBaseArticleInfo.append(paramRIJBiuAndCommentRequestData.toString());
    QLog.d("RIJBiuAndCommentMixPBModule", 1, paramAbsBaseArticleInfo.toString());
    return paramRIJBiuAndCommentRequestData;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    RIJBiuAndCommentMixPBModule.BiuAndCommentPBObserver localBiuAndCommentPBObserver = this.a;
    if (localBiuAndCommentPBObserver != null) {
      localBiuAndCommentPBObserver.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    ReadinjoyReportUtils.a(ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0xe16.RspBody()), paramToServiceMsg, 2, null);
  }
  
  public void a(RIJBiuAndCommentMixPBModule.BiuAndCommentPBObserver paramBiuAndCommentPBObserver)
  {
    this.a = paramBiuAndCommentPBObserver;
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJBiuAndCommentRequestData paramRIJBiuAndCommentRequestData)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramRIJBiuAndCommentRequestData != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start request 0xe16 ");
      ((StringBuilder)localObject).append(paramRIJBiuAndCommentRequestData.toString());
      QLog.d("RIJBiuAndCommentMixPBModule", 1, ((StringBuilder)localObject).toString());
      localObject = ReadInJoyOidbHelper.a("OidbSvc.0xe16", 3606, 1, a(paramRIJBiuAndCommentRequestData, paramAbsBaseArticleInfo).toByteArray());
      if ((localObject != null) && (((ToServiceMsg)localObject).getAttributes() != null))
      {
        ((ToServiceMsg)localObject).getAttributes().put("request_data_entry", paramRIJBiuAndCommentRequestData);
        ((ToServiceMsg)localObject).getAttributes().put("article_attributes", paramAbsBaseArticleInfo);
        ((ToServiceMsg)localObject).getAttributes().put("service_type", Integer.valueOf(1));
      }
      if (localObject != null)
      {
        sendPbReq((ToServiceMsg)localObject);
        paramAbsBaseArticleInfo = new StringBuilder();
        paramAbsBaseArticleInfo.append("0xe16 request :");
        paramAbsBaseArticleInfo.append(((ToServiceMsg)localObject).toString());
        QLog.d("RIJBiuAndCommentMixPBModule", 1, paramAbsBaseArticleInfo.toString());
      }
      return;
    }
    QLog.d("RIJBiuAndCommentMixPBModule", 1, "requestCreateBiuAndCommentMixComment someThing is NULL");
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xe16"))
    {
      Object localObject = paramToServiceMsg.getAttributes().get("service_type");
      if (((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 1))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
  
  public void unInitialize()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.RIJBiuAndCommentMixPBModule
 * JD-Core Version:    0.7.0.1
 */