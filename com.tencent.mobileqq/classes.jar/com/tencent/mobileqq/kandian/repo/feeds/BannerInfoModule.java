package com.tencent.mobileqq.kandian.repo.feeds;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.repo.common.IFindRemovedEntity;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo.DynamicItem;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo.ImgItem;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo.MoreChannelItem;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo.VideoItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerRoundReqBody;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerRoundRspBody;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.ContentBannerItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.DynamicBannerItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.MoreChannelItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.ReqBody;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.RspBody;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.VideoBannerItem;

public class BannerInfoModule
  extends ReadInJoyEngineModule
{
  private IFindRemovedEntity<TopBannerInfo> jdField_a_of_type_ComTencentMobileqqKandianRepoCommonIFindRemovedEntity = new BannerInfoModule.1(this);
  private final ConcurrentHashMap<Integer, TopBannerInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public BannerInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler, ArticleInfoModule paramArticleInfoModule)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    if (paramArticleInfoModule != null) {
      paramArticleInfoModule.a().a(new BannerInfoModule.2(this));
    }
    registerEntityFinder(TopBannerInfo.class, this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonIFindRemovedEntity);
  }
  
  private void a(TopBannerInfo paramTopBannerInfo)
  {
    b(paramTopBannerInfo);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramTopBannerInfo.mChannelId), paramTopBannerInfo);
    this.mMainThreadHandler.post(new BannerInfoModule.3(this, paramTopBannerInfo));
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xbc9.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    int j = 0;
    QLog.d("ReadInJoyEngineModule", 2, new Object[] { "handle0xbc9BannerInfo result = ", Integer.valueOf(i) });
    if ((i == 0) && (paramToServiceMsg.msg_banner_round_rsp_body.has()))
    {
      paramObject = (oidb_cmd0xbc9.BannerRoundRspBody)paramToServiceMsg.msg_banner_round_rsp_body.get();
      if ((paramObject.uint32_need_update.has()) && (paramObject.uint32_need_update.get() == 1))
      {
        paramFromServiceMsg = new TopBannerInfo();
        if ((paramObject.rpt_msg_banner_list.has()) && (paramObject.rpt_msg_banner_list.size() > 0))
        {
          i = 0;
          while (i < paramObject.rpt_msg_banner_list.size())
          {
            paramToServiceMsg = null;
            oidb_cmd0xbc9.BannerItem localBannerItem = (oidb_cmd0xbc9.BannerItem)paramObject.rpt_msg_banner_list.get(i);
            if (localBannerItem.uint32_banner_type.has())
            {
              if (localBannerItem.uint32_banner_type.get() == 2)
              {
                if (localBannerItem.msg_video_banner_item.has()) {
                  paramToServiceMsg = TopBannerInfo.VideoItem.b(localBannerItem);
                }
              }
              else if (localBannerItem.msg_article_content_item.has()) {
                paramToServiceMsg = TopBannerInfo.ImgItem.b(localBannerItem);
              }
              if (paramToServiceMsg != null) {
                paramFromServiceMsg.addItem(paramToServiceMsg);
              }
            }
            i += 1;
          }
        }
        if (paramObject.bytes_cookie.has()) {
          paramFromServiceMsg.mCookie = paramObject.bytes_cookie.get().toStringUtf8();
        }
        if (paramObject.uint32_channel_id.has()) {
          paramFromServiceMsg.mChannelId = paramObject.uint32_channel_id.get();
        }
        if ((paramObject.rpt_msg_dynamic_banner_list.has()) && (paramObject.rpt_msg_dynamic_banner_list.size() > 0))
        {
          i = j;
          while (i < paramObject.rpt_msg_dynamic_banner_list.size())
          {
            if ((((oidb_cmd0xbc9.DynamicBannerItem)paramObject.rpt_msg_dynamic_banner_list.get(i)).has()) && (paramObject.rpt_msg_dynamic_banner_list.get(i) != null))
            {
              paramToServiceMsg = TopBannerInfo.DynamicItem.a((oidb_cmd0xbc9.DynamicBannerItem)paramObject.rpt_msg_dynamic_banner_list.get(i));
              if (paramToServiceMsg != null)
              {
                paramToServiceMsg = paramToServiceMsg.iterator();
                while (paramToServiceMsg.hasNext()) {
                  paramFromServiceMsg.addDynamicItem((TopBannerInfo.DynamicItem)paramToServiceMsg.next());
                }
              }
            }
            i += 1;
          }
        }
        if (paramObject.msg_more_channel_item.has())
        {
          paramToServiceMsg = TopBannerInfo.MoreChannelItem.a((oidb_cmd0xbc9.MoreChannelItem)paramObject.msg_more_channel_item.get());
          if (paramToServiceMsg != null) {
            paramFromServiceMsg.setMoreChannelItem(paramToServiceMsg);
          }
        }
        a(paramFromServiceMsg);
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handle0xbc9BannerInfo bannerInfo = ");
        paramToServiceMsg.append(paramFromServiceMsg);
        QLog.d("ReadInJoyEngineModule", 2, paramToServiceMsg.toString());
        return;
      }
      QLog.d("ReadInJoyEngineModule", 2, "handle0xbc9BannerInfo uint32_need_update = 0");
    }
  }
  
  private void b(TopBannerInfo paramTopBannerInfo)
  {
    updateEntity(paramTopBannerInfo);
  }
  
  public TopBannerInfo a(int paramInt)
  {
    return (TopBannerInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt)
  {
    a(paramInt, 1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = a(paramInt1);
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = ((TopBannerInfo)localObject1).mCookie;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    localObject1 = new oidb_cmd0xbc9.ReqBody();
    oidb_cmd0xbc9.BannerRoundReqBody localBannerRoundReqBody = new oidb_cmd0xbc9.BannerRoundReqBody();
    localBannerRoundReqBody.bytes_cookie.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    localBannerRoundReqBody.uint32_channel_id.set(paramInt1);
    ((oidb_cmd0xbc9.ReqBody)localObject1).msg_banner_round_req_body.set(localBannerRoundReqBody);
    sendPbReq(ReadInJoyOidbHelper.a("OidbSvc.0xbc9", 3017, paramInt2, ((oidb_cmd0xbc9.ReqBody)localObject1).toByteArray()));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("req banner info cookies: ");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("  channelId: ");
    ((StringBuilder)localObject1).append(paramInt1);
    QLog.d("ReadInJoyEngineModule", 2, ((StringBuilder)localObject1).toString());
  }
  
  public void b(int paramInt)
  {
    Object localObject = this.mEntityManager;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    localObject = ((EntityManager)localObject).query(TopBannerInfo.class, true, "mChannelId IS NOT NULL AND mChannelId == ?", new String[] { localStringBuilder.toString() }, null, null, null, "1");
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(paramInt), ((List)localObject).get(0));
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(paramInt), new TopBannerInfo());
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbc9")) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void unInitialize() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.BannerInfoModule
 * JD-Core Version:    0.7.0.1
 */