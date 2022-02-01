import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.ReqBody;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.RspBody;

public class qiq
  extends qil
{
  public qiq(qep paramqep, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, qxn paramqxn, ExecutorService paramExecutorService)
  {
    super(paramqep, paramHandler, paramAppInterface, paramEntityManager, paramqxn, paramExecutorService);
  }
  
  public void a(long paramLong, boolean paramBoolean, FastWebArticleInfo paramFastWebArticleInfo)
  {
    oidb_cmd0x83e.ReqBody localReqBody = new oidb_cmd0x83e.ReqBody();
    int i;
    int j;
    label40:
    PBBytesField localPBBytesField;
    if (paramBoolean)
    {
      i = 12;
      localReqBody.uint64_uin.set(paramLong);
      localObject = localReqBody.uint32_operation;
      if (!paramBoolean) {
        break label144;
      }
      j = 2;
      ((PBUInt32Field)localObject).set(j);
      localPBBytesField = localReqBody.bytes_inner_uniq_id;
      if (paramFastWebArticleInfo == null) {
        break label150;
      }
    }
    label144:
    label150:
    for (Object localObject = paramFastWebArticleInfo.j;; localObject = "")
    {
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localObject = qxp.a("OidbSvc.0x83e", 2110, 0, localReqBody.toByteArray());
      ((ToServiceMsg)localObject).addAttribute("0x83e_fast_web_article_info", paramFastWebArticleInfo);
      ((ToServiceMsg)localObject).addAttribute("0x83e_upvote_fast_web_article", Integer.valueOf(1));
      ((ToServiceMsg)localObject).addAttribute("0x83e_upvote_operation_type", Integer.valueOf(i));
      this.a.a((ToServiceMsg)localObject);
      return;
      i = 13;
      break;
      j = 3;
      break label40;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = true;
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    paramToServiceMsg = new oidb_cmd0x83e.RspBody();
    int i = qxp.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0)
    {
      QLog.d("RIJCommentInLikeFeedUpvoteArticleHandler", 1, "handle0x83eUpvoteFastWebArticleAction result OK");
      if (paramToServiceMsg.uint32_operation.has())
      {
        paramFromServiceMsg = new StringBuilder().append("handle0x83eUpvoteFastWebArticleAction | upvote status :");
        if (paramToServiceMsg.uint32_operation.get() != 2) {
          break label89;
        }
      }
      for (;;)
      {
        QLog.d("RIJCommentInLikeFeedUpvoteArticleHandler", 2, bool);
        return;
        label89:
        bool = false;
      }
    }
    QLog.d("RIJCommentInLikeFeedUpvoteArticleHandler", 1, "handle0x83eUpvoteFastWebArticleAction failed result " + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qiq
 * JD-Core Version:    0.7.0.1
 */