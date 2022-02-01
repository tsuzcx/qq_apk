package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModuleUtils;
import com.tencent.mobileqq.kandian.repo.handler.sp.RIJGetIndividualArticleSp;
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
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0x75e.oidb_cmd0x75e.ArticleInfo;
import tencent.im.oidb.cmd0x75e.oidb_cmd0x75e.ReqBody;
import tencent.im.oidb.cmd0x75e.oidb_cmd0x75e.ReqPara;
import tencent.im.oidb.cmd0x75e.oidb_cmd0x75e.RspArticle;
import tencent.im.oidb.cmd0x75e.oidb_cmd0x75e.RspBody;

public class RIJGetIndividualArticleHandler
  extends RIJBaseArticleInfoHandler
{
  public RIJGetIndividualArticleHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  public void a(long paramLong, int paramInt)
  {
    Object localObject = new oidb_cmd0x75e.ReqBody();
    ((oidb_cmd0x75e.ReqBody)localObject).uint64_uin.set(paramLong);
    ((oidb_cmd0x75e.ReqBody)localObject).uint32_network_type.set(ArticleInfoModuleUtils.a());
    oidb_cmd0x75e.ReqPara localReqPara = new oidb_cmd0x75e.ReqPara();
    localReqPara.enum_op_type.set(paramInt);
    ((oidb_cmd0x75e.ReqBody)localObject).msg_req_para.set(localReqPara);
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0x75e", 1886, 0, ((oidb_cmd0x75e.ReqBody)localObject).toByteArray());
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0x75e.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0)
    {
      if ((paramToServiceMsg.msg_rsp_article.has()) && (paramToServiceMsg.msg_rsp_article.get() != null))
      {
        paramToServiceMsg = (oidb_cmd0x75e.RspArticle)paramToServiceMsg.msg_rsp_article.get();
        if ((paramToServiceMsg.rpt_article_info.has()) && (paramToServiceMsg.rpt_article_info.get() != null))
        {
          paramToServiceMsg = paramToServiceMsg.rpt_article_info.get();
          if ((paramToServiceMsg.size() > 0) && (((oidb_cmd0x75e.ArticleInfo)paramToServiceMsg.get(0)).bytes_article_xml.has()) && (((oidb_cmd0x75e.ArticleInfo)paramToServiceMsg.get(0)).bytes_article_xml.get() != null))
          {
            paramToServiceMsg = ((oidb_cmd0x75e.ArticleInfo)paramToServiceMsg.get(0)).bytes_article_xml.get().toStringUtf8();
            ((KandianMergeManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(paramToServiceMsg);
          }
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handle0x75eIndividualArticleList error = ");
      paramToServiceMsg.append(i);
      QLog.w("RIJGetIndividualArticleHandler", 2, paramToServiceMsg.toString());
    }
    RIJGetIndividualArticleSp.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJGetIndividualArticleHandler
 * JD-Core Version:    0.7.0.1
 */