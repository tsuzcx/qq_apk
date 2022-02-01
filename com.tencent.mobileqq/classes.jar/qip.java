import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJCommentInLikeFeedUpvoteActionHandler.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.FeedsInfo;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.ReqBody;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.RspBody;

public class qip
  extends qil
{
  public qip(qep paramqep, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, qxn paramqxn, ExecutorService paramExecutorService)
  {
    super(paramqep, paramHandler, paramAppInterface, paramEntityManager, paramqxn, paramExecutorService);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, ArticleInfo paramArticleInfo)
  {
    Object localObject1 = new oidb_cmd0x83e.ReqBody();
    if (paramBoolean) {}
    for (int i = 2;; i = 3)
    {
      if (paramLong1 != -1L) {
        ((oidb_cmd0x83e.ReqBody)localObject1).uint64_uin.set(paramLong1);
      }
      if (paramLong2 != -1L) {
        ((oidb_cmd0x83e.ReqBody)localObject1).uint64_feeds_id.set(paramLong2);
      }
      ((oidb_cmd0x83e.ReqBody)localObject1).uint32_operation.set(i);
      Object localObject2 = new oidb_cmd0x83e.FeedsInfo();
      ((oidb_cmd0x83e.FeedsInfo)localObject2).feeds_type.set(paramArticleInfo.busiType);
      ((oidb_cmd0x83e.FeedsInfo)localObject2).uint32_business_id.set((int)paramArticleInfo.businessId);
      ((oidb_cmd0x83e.ReqBody)localObject1).msg_feeds_info.set((MessageMicro)localObject2);
      localObject2 = String.valueOf(pkh.a()) + System.currentTimeMillis();
      ((oidb_cmd0x83e.ReqBody)localObject1).bytes_req_seq.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localObject1 = qxp.a("OidbSvc.0x83e", 2110, 0, ((oidb_cmd0x83e.ReqBody)localObject1).toByteArray());
      ((ToServiceMsg)localObject1).addAttribute("0x83e_article", paramArticleInfo);
      ((ToServiceMsg)localObject1).addAttribute("0x83e_upvote_operation_type", Integer.valueOf(i));
      this.jdField_a_of_type_Qep.b((ToServiceMsg)localObject1);
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    oidb_cmd0x83e.RspBody localRspBody = new oidb_cmd0x83e.RspBody();
    if (a(paramFromServiceMsg, paramObject, localRspBody) == 0)
    {
      QLog.d("RIJCommentInLikeFeedUpvoteActionHandler", 1, "handle0x83eUpvoteAction result OK");
      if (QLog.isColorLevel())
      {
        if (localRspBody.uint64_feeds_id.has()) {
          QLog.d("RIJCommentInLikeFeedUpvoteActionHandler", 2, "upvote feeds id:" + localRspBody.uint64_feeds_id.get());
        }
        if (localRspBody.uint32_operation.has())
        {
          paramFromServiceMsg = new StringBuilder().append("upvote status:");
          if (localRspBody.uint32_operation.get() != 2) {
            break label167;
          }
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      QLog.d("RIJCommentInLikeFeedUpvoteActionHandler", 2, bool);
      try
      {
        paramToServiceMsg = (ArticleInfo)paramToServiceMsg.getAttribute("0x83e_article");
        this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJCommentInLikeFeedUpvoteActionHandler.1(this, paramToServiceMsg));
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        label167:
        QLog.d("RIJCommentInLikeFeedUpvoteActionHandler", 1, "failed to update article ", paramToServiceMsg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qip
 * JD-Core Version:    0.7.0.1
 */