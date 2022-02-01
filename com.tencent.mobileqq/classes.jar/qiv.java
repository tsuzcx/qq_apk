import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;
import tencent.im.oidb.cmd0xbbd.oidb_cmd0xbbd.ReqBody;
import tencent.im.oidb.cmd0xbbd.oidb_cmd0xbbd.ReqFeedsInfo;
import tencent.im.oidb.cmd0xbbd.oidb_cmd0xbbd.ReqPara;
import tencent.im.oidb.cmd0xbbd.oidb_cmd0xbbd.RspBody;
import tencent.im.oidb.cmd0xbbd.oidb_cmd0xbbd.RspFeedsData;
import tencent.im.oidb.cmd0xbbd.oidb_cmd0xbbd.RspFeedsInfo;

public class qiv
  extends qii
{
  public qiv(qep paramqep, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, qxn paramqxn, ExecutorService paramExecutorService)
  {
    super(paramqep, paramHandler, paramAppInterface, paramEntityManager, paramqxn, paramExecutorService);
  }
  
  private void a(ArrayList<ArticleInfo> paramArrayList, rpb paramrpb)
  {
    paramrpb = paramrpb.a;
    paramArrayList = paramArrayList.iterator();
    for (;;)
    {
      if (!paramArrayList.hasNext()) {
        return;
      }
      ArticleInfo localArticleInfo = (ArticleInfo)paramArrayList.next();
      Iterator localIterator = paramrpb.iterator();
      if (localIterator.hasNext())
      {
        rpc localrpc = (rpc)localIterator.next();
        if (localArticleInfo.mFeedId != localrpc.jdField_a_of_type_Long) {
          break;
        }
        localArticleInfo.mRecommendSeq = localrpc.c;
        localArticleInfo.mFeedType = localrpc.jdField_a_of_type_Int;
        localArticleInfo.mAlgorithmID = localrpc.jdField_b_of_type_Long;
        localArticleInfo.mStrategyId = localrpc.jdField_b_of_type_Int;
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = new oidb_cmd0xbbd.RspBody();
    int i = qxp.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    if (i == 0)
    {
      if (((oidb_cmd0xbbd.RspBody)localObject1).msg_rsp_feeds_data.rpt_feeds_info_list.has())
      {
        paramObject = ((oidb_cmd0xbbd.RspBody)localObject1).msg_rsp_feeds_data.rpt_feeds_info_list.get();
        paramFromServiceMsg = new ArrayList();
        paramObject = paramObject.iterator();
        while (paramObject.hasNext())
        {
          localObject1 = (oidb_cmd0xbbd.RspFeedsInfo)paramObject.next();
          if ((((oidb_cmd0xbbd.RspFeedsInfo)localObject1).msg_article_summary.has()) && (((oidb_cmd0xbbd.RspFeedsInfo)localObject1).uint32_feeds_type.has()))
          {
            localObject2 = qxm.a((articlesummary.ArticleSummary)((oidb_cmd0xbbd.RspFeedsInfo)localObject1).msg_article_summary.get(), 70, 0, null);
            if ((localObject2 != null) && (((ArticleInfo)localObject2).mArticleID != -1L))
            {
              ((ArticleInfo)localObject2).mFeedType = ((oidb_cmd0xbbd.RspFeedsInfo)localObject1).uint32_feeds_type.get();
              paramFromServiceMsg.add(localObject2);
            }
          }
        }
        paramObject = (ArticleInfo)paramToServiceMsg.getAttribute("ArticleInfo");
        a(paramFromServiceMsg, paramObject.mExtraBiuBriefInfo);
        localObject1 = (Integer)paramToServiceMsg.getAttribute("channelID");
        Object localObject2 = (Long)paramToServiceMsg.getAttribute(qhj.d);
        paramObject.isExtraBiuExpanded = true;
        this.a.a().a((Integer)localObject1, paramObject, true);
        this.a.a(true, ((Integer)localObject1).intValue(), false, paramFromServiceMsg, ((Long)localObject2).longValue(), -1L, null, null, paramToServiceMsg);
      }
      return;
    }
    QLog.e("RIJGetMoreBiuHandler", 1, "handle0xbbdGetMoreBiuList result ==" + i);
  }
  
  public void a(rpb paramrpb, ArticleInfo paramArticleInfo)
  {
    Object localObject = new oidb_cmd0xbbd.ReqBody();
    long l = Long.valueOf(pkh.a()).longValue();
    ((oidb_cmd0xbbd.ReqBody)localObject).uint64_uin.set(l);
    ((oidb_cmd0xbbd.ReqBody)localObject).uint32_network_type.set(qer.a());
    oidb_cmd0xbbd.ReqPara localReqPara = new oidb_cmd0xbbd.ReqPara();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramrpb.a.iterator();
    while (localIterator.hasNext())
    {
      rpc localrpc = (rpc)localIterator.next();
      oidb_cmd0xbbd.ReqFeedsInfo localReqFeedsInfo = new oidb_cmd0xbbd.ReqFeedsInfo();
      localReqFeedsInfo.uint64_feeds_id.set(localrpc.jdField_a_of_type_Long);
      localReqFeedsInfo.uint32_feeds_type.set(localrpc.jdField_a_of_type_Int);
      localArrayList.add(localReqFeedsInfo);
    }
    localReqPara.rpt_req_feeds_info.set(localArrayList);
    ((oidb_cmd0xbbd.ReqBody)localObject).msg_req_para.set(localReqPara);
    localObject = qxp.a("OidbSvc.0xbbd", 3005, 0, ((oidb_cmd0xbbd.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).getAttributes().put(qhj.c, Integer.valueOf(15));
    ((ToServiceMsg)localObject).getAttributes().put("channelID", Integer.valueOf(70));
    ((ToServiceMsg)localObject).getAttributes().put(qhj.d, Long.valueOf(((rpc)paramrpb.a.get(0)).c));
    ((ToServiceMsg)localObject).getAttributes().put(qhj.e, Integer.valueOf(-1));
    ((ToServiceMsg)localObject).getAttributes().put("ArticleInfo", paramArticleInfo);
    this.a.a((ToServiceMsg)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qiv
 * JD-Core Version:    0.7.0.1
 */