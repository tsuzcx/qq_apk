package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xc6d.oidb_cmd0xc6d.ReqBody;
import tencent.im.oidb.cmd0xc6d.oidb_cmd0xc6d.RspBody;

public class RIJInteractiveCardsHandler
  extends RIJBaseArticleInfoHandler
{
  public RIJInteractiveCardsHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xc6d.RspBody();
    int j = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    int i;
    if (j == 0)
    {
      paramFromServiceMsg = paramToServiceMsg.rpt_card_json.get();
      paramToServiceMsg = new ArrayList();
      paramFromServiceMsg = paramFromServiceMsg.iterator();
      while (paramFromServiceMsg.hasNext()) {
        paramToServiceMsg.add(((ByteStringMicro)paramFromServiceMsg.next()).toStringUtf8());
      }
      i = paramToServiceMsg.size();
      this.jdField_a_of_type_AndroidOsHandler.post(new RIJInteractiveCardsHandler.1(this, paramToServiceMsg));
    }
    else
    {
      i = 0;
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handle0xc6dInteractiveCards,result=");
    paramToServiceMsg.append(j);
    paramToServiceMsg.append(" size=");
    paramToServiceMsg.append(i);
    QLog.d("RIJInteractiveCardsHandler", 1, paramToServiceMsg.toString());
  }
  
  public void a(String paramString)
  {
    Object localObject = new oidb_cmd0xc6d.ReqBody();
    if (!TextUtils.isEmpty(paramString)) {
      ((oidb_cmd0xc6d.ReqBody)localObject).bytes_row_key.set(ByteStringMicro.copyFromUtf8(paramString));
    } else {
      ((oidb_cmd0xc6d.ReqBody)localObject).bytes_row_key.set(ByteStringMicro.copyFromUtf8(""));
    }
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0xc6d", 3181, 1, ((oidb_cmd0xc6d.ReqBody)localObject).toByteArray());
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.sendPbReqWithAutoRetry((ToServiceMsg)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("request0xc6dInteractiveAreaCards,rowKey=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("RIJInteractiveCardsHandler", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJInteractiveCardsHandler
 * JD-Core Version:    0.7.0.1
 */