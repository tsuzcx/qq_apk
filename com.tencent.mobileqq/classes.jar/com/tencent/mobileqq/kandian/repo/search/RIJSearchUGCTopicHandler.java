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
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xbde.oidb_cmd0xbde.ReqBody;
import tencent.im.oidb.cmd0xbde.oidb_cmd0xbde.ReqSearchTopicInfo;
import tencent.im.oidb.cmd0xbde.oidb_cmd0xbde.RspBody;
import tencent.im.oidb.cmd0xbde.oidb_cmd0xbde.RspRecentTopicResult;
import tencent.im.oidb.cmd0xbde.oidb_cmd0xbde.RspSearchTopicResult;
import tencent.im.oidb.cmd0xbde.oidb_cmd0xbde.SearchInfo;

public class RIJSearchUGCTopicHandler
  extends RIJBaseArticleInfoHandler
{
  public RIJSearchUGCTopicHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xbde.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    paramFromServiceMsg = new ArrayList();
    paramObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    if (i == 0)
    {
      QLog.d("RIJSearchUGCTopicHandler", 2, "handle0xbdeGetTopicList: result OK");
      Iterator localIterator = paramToServiceMsg.msg_rsp_search_tag_info.rpt_msg_search_info_list.get().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((oidb_cmd0xbde.SearchInfo)localIterator.next()).bytes_key.get().toStringUtf8());
      }
      paramFromServiceMsg.addAll(ReadInJoyMSFHandlerUtils.f(paramToServiceMsg.msg_rsp_search_tag_info.rpt_msg_tag_info_list.get()));
      paramObject.addAll(ReadInJoyMSFHandlerUtils.f(paramToServiceMsg.msg_rsp_recent_tag_info.rpt_msg_tag_info_list.get()));
    }
    else
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handle0xbdeGetTopicList: failed, result: ");
      paramToServiceMsg.append(i);
      QLog.d("RIJSearchUGCTopicHandler", 2, paramToServiceMsg.toString());
    }
    this.b.post(new RIJSearchUGCTopicHandler.1(this, localArrayList, paramFromServiceMsg, paramObject));
  }
  
  public void a(String paramString)
  {
    oidb_cmd0xbde.ReqBody localReqBody = new oidb_cmd0xbde.ReqBody();
    if (!TextUtils.isEmpty(paramString))
    {
      oidb_cmd0xbde.SearchInfo localSearchInfo = new oidb_cmd0xbde.SearchInfo();
      localSearchInfo.bytes_key.set(ByteStringMicro.copyFromUtf8(paramString));
      paramString = new oidb_cmd0xbde.ReqSearchTopicInfo();
      paramString.rpt_msg_search_info_list.add(localSearchInfo);
      localReqBody.uint32_query_mode.set(1);
      localReqBody.uint32_need_recent_topics.set(0);
      localReqBody.msg_req_search_tag_info.set(paramString);
    }
    else
    {
      localReqBody.uint32_need_recent_topics.set(1);
    }
    paramString = ReadInJoyOidbHelper.a("OidbSvc.0xbde", 3038, 0, localReqBody.toByteArray());
    this.a.sendPbReq(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.search.RIJSearchUGCTopicHandler
 * JD-Core Version:    0.7.0.1
 */