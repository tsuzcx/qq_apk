package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.glue.msf.ReadInJoyMSFHandlerUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.DislikeResult;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeParam;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.DislikeParam;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.ReqBody;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.RspBody;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.UserDisLike;

public class RIJDislikeArticleHandler
  extends RIJBaseArticleInfoHandler
{
  public int g;
  public List<DislikeResult> h;
  
  public RIJDislikeArticleHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  private oidb_cmd0x46f.DislikeParam a(DislikeParam paramDislikeParam)
  {
    oidb_cmd0x46f.DislikeParam localDislikeParam = new oidb_cmd0x46f.DislikeParam();
    localDislikeParam.uint64_articleid.set(paramDislikeParam.a);
    localDislikeParam.uint32_reasonid.set(paramDislikeParam.b);
    localDislikeParam.uint64_feeds_id.set(paramDislikeParam.e);
    localDislikeParam.uint64_biu_uin.set(paramDislikeParam.f);
    localDislikeParam.uint64_topic_id.set(paramDislikeParam.h);
    if ((paramDislikeParam.g != null) && (paramDislikeParam.g.length() > 0)) {
      localDislikeParam.bytes_rowkey.set(ByteStringMicro.copyFromUtf8(paramDislikeParam.g));
    }
    Object localObject1;
    Object localObject2;
    if ((paramDislikeParam.c != null) && (paramDislikeParam.c.size() > 0))
    {
      localObject1 = paramDislikeParam.c.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        localDislikeParam.rpt_uint64_tagid.add(localObject2);
      }
    }
    if ((paramDislikeParam.d != null) && (paramDislikeParam.d.size() > 0))
    {
      paramDislikeParam = paramDislikeParam.d.iterator();
      while (paramDislikeParam.hasNext())
      {
        localObject1 = (DislikeInfo)paramDislikeParam.next();
        localObject2 = new oidb_cmd0x46f.UserDisLike();
        ((oidb_cmd0x46f.UserDisLike)localObject2).bytes_dislike_account_id.set(ByteStringMicro.copyFromUtf8(((DislikeInfo)localObject1).f));
        ((oidb_cmd0x46f.UserDisLike)localObject2).type.set(((DislikeInfo)localObject1).d);
        ((oidb_cmd0x46f.UserDisLike)localObject2).uint64_dislike_tagid.set(((DislikeInfo)localObject1).e);
        ((oidb_cmd0x46f.UserDisLike)localObject2).bytes_dislike_tag_name.set(ByteStringMicro.copyFromUtf8(((DislikeInfo)localObject1).c));
        localDislikeParam.rpt_user_dislike_list.add((MessageMicro)localObject2);
      }
    }
    return localDislikeParam;
  }
  
  private void a(int paramInt, List<DislikeResult> paramList)
  {
    this.b.post(new RIJDislikeArticleHandler.1(this, paramInt, paramList));
  }
  
  public void a(long paramLong, List<? extends DislikeParam> paramList)
  {
    oidb_cmd0x46f.ReqBody localReqBody = new oidb_cmd0x46f.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0x46f.DislikeParam localDislikeParam = a((DislikeParam)paramList.next());
      localReqBody.rpt_param_list.add(localDislikeParam);
    }
    paramList = ReadInJoyOidbHelper.a("OidbSvc.0x46f", 1135, 0, localReqBody.toByteArray());
    this.a.sendPbReq(paramList);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0x46f.RspBody localRspBody = new oidb_cmd0x46f.RspBody();
    int k = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    int j = 0;
    int i = 0;
    paramFromServiceMsg = null;
    paramToServiceMsg = paramFromServiceMsg;
    if (k == 0)
    {
      if (localRspBody.uint32_fail_count.has()) {
        i = localRspBody.uint32_fail_count.get();
      }
      paramToServiceMsg = paramFromServiceMsg;
      j = i;
      if (localRspBody.rpt_result_list.has())
      {
        paramToServiceMsg = ReadInJoyMSFHandlerUtils.c(localRspBody.rpt_result_list.get());
        j = i;
      }
    }
    a(j, paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJDislikeArticleHandler
 * JD-Core Version:    0.7.0.1
 */