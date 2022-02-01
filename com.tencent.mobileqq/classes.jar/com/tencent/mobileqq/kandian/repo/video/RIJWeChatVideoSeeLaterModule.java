package com.tencent.mobileqq.kandian.repo.video;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xf1f.oidb_cmd0xf1f.ArticleItem;
import tencent.im.oidb.cmd0xf1f.oidb_cmd0xf1f.ReqBody;
import tencent.im.oidb.cmd0xf1f.oidb_cmd0xf1f.RspBody;

public class RIJWeChatVideoSeeLaterModule
  extends ReadInJoyEngineModule
{
  private List<RIJWeChatVideoSeeLaterModule.WeChatVideoSeeLaterOptCallback> a;
  
  public RIJWeChatVideoSeeLaterModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private void a(int paramInt)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((RIJWeChatVideoSeeLaterModule.WeChatVideoSeeLaterOptCallback)((Iterator)localObject).next()).a(paramInt);
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xf1f.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i != 0)
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleWeChatVideoSeeLater result = ");
      paramToServiceMsg.append(i);
      QLog.d("RIJUGCAccountCreateModule", 1, paramToServiceMsg.toString());
      return;
    }
    i = RIJPBFieldUtils.a(paramToServiceMsg.uint32_result);
    a(i);
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handleWeChatVideoSeeLater uint32_result = ");
    paramToServiceMsg.append(i);
    QLog.d("RIJUGCAccountCreateModule", 1, paramToServiceMsg.toString());
  }
  
  public static oidb_cmd0xf1f.ReqBody b(List<RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      oidb_cmd0xf1f.ReqBody localReqBody = new oidb_cmd0xf1f.ReqBody();
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem localWeChatVideoArticleItem = (RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem)paramList.next();
        oidb_cmd0xf1f.ArticleItem localArticleItem = new oidb_cmd0xf1f.ArticleItem();
        localArticleItem.bytes_rowkey.set(ByteStringMicro.copyFromUtf8(localWeChatVideoArticleItem.a));
        localArticleItem.uint64_feeds_id.set(localWeChatVideoArticleItem.b);
        localArticleItem.uint32_play_time.set(localWeChatVideoArticleItem.c);
        localArticleItem.uint32_duration.set(localWeChatVideoArticleItem.d);
        localArrayList.add(localArticleItem);
      }
      localReqBody.rpt_article_item.set(localArrayList);
      localReqBody.opt_type.set(1);
      return localReqBody;
    }
    return null;
  }
  
  public void a(List<RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem> paramList)
  {
    paramList = b(paramList);
    if (paramList == null)
    {
      QLog.d("RIJUGCAccountCreateModule", 1, "requestUgcAccountCreate weChatVideoArticleItemList is empty!");
      return;
    }
    paramList = ReadInJoyOidbHelper.a("OidbSvc.0xf1f", 3871, 0, paramList.toByteArray());
    paramList.addAttribute("KEY_SEE_LATER_OPT_TYPE", Integer.valueOf(1));
    sendPbReq(paramList);
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (((Integer)paramToServiceMsg.getAttribute("KEY_SEE_LATER_OPT_TYPE")).intValue() == 1) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void unInitialize()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.video.RIJWeChatVideoSeeLaterModule
 * JD-Core Version:    0.7.0.1
 */