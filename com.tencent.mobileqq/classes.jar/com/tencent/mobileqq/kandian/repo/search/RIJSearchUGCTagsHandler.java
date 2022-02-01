package com.tencent.mobileqq.kandian.repo.search;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.glue.msf.ReadInJoyMSFHandlerUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.handler.RIJBaseArticleInfoHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.ReqBody;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.ReqRecommendTagInfo;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.ReqSearchTagInfo;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.RspBody;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.RspRecommendTagInfo;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.RspSearchTagInfo;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.SearchInfo;

public class RIJSearchUGCTagsHandler
  extends RIJBaseArticleInfoHandler
{
  public RIJSearchUGCTagsHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  public void a(long paramLong)
  {
    Object localObject = new oidb_cmd0xb83.ReqRecommendTagInfo();
    ((oidb_cmd0xb83.ReqRecommendTagInfo)localObject).uint64_topic_id.set(paramLong);
    oidb_cmd0xb83.ReqBody localReqBody = new oidb_cmd0xb83.ReqBody();
    localReqBody.msg_req_recommend_tag_info.set((MessageMicro)localObject);
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0xb83", 2947, 0, localReqBody.toByteArray());
    this.a.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xb83.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    paramFromServiceMsg = new ArrayList();
    if (i == 0)
    {
      QLog.d("RIJSearchUGCTagsHandler", 1, "handle0xb83GetKeywordList result OK");
      paramObject = ReadInJoyMSFHandlerUtils.e(paramToServiceMsg.msg_rsp_search_tag_info.rpt_msg_tag_info_list.get());
      paramToServiceMsg = ReadInJoyMSFHandlerUtils.e(paramToServiceMsg.msg_rsp_recommend_tag_info.rpt_msg_tag_info_list.get());
      paramFromServiceMsg.addAll(paramObject);
      paramFromServiceMsg.addAll(paramToServiceMsg);
    }
    else
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handle0xb83GetKeywordList: failed, result: ");
      paramToServiceMsg.append(i);
      QLog.d("RIJSearchUGCTagsHandler", 2, paramToServiceMsg.toString());
    }
    this.b.post(new RIJSearchUGCTagsHandler.1(this, paramFromServiceMsg));
  }
  
  public void a(String paramString)
  {
    oidb_cmd0xb83.ReqBody localReqBody = new oidb_cmd0xb83.ReqBody();
    if (!TextUtils.isEmpty(paramString))
    {
      oidb_cmd0xb83.SearchInfo localSearchInfo = new oidb_cmd0xb83.SearchInfo();
      localSearchInfo.bytes_key.set(ByteStringMicro.copyFromUtf8(paramString));
      paramString = new oidb_cmd0xb83.ReqSearchTagInfo();
      paramString.rpt_msg_search_info_list.add(localSearchInfo);
      localReqBody.msg_req_search_tag_info.set(paramString);
    }
    else
    {
      paramString = new oidb_cmd0xb83.ReqRecommendTagInfo();
      localReqBody.msg_req_recommend_tag_info.set(paramString);
    }
    paramString = ReadInJoyOidbHelper.a("OidbSvc.0xb83", 2947, 0, localReqBody.toByteArray());
    this.a.sendPbReq(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.search.RIJSearchUGCTagsHandler
 * JD-Core Version:    0.7.0.1
 */