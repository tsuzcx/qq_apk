import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJRefreshTopicInfoHandler.1;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJRefreshTopicInfoHandler.2;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xa6e.oidb_cmd0xa6e.RspBody;

public class qjb
  extends qii
{
  public qjb(qep paramqep, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, qxn paramqxn, ExecutorService paramExecutorService)
  {
    super(paramqep, paramHandler, paramAppInterface, paramEntityManager, paramqxn, paramExecutorService);
  }
  
  public void a(int paramInt)
  {
    ConcurrentMap localConcurrentMap1 = this.jdField_a_of_type_Qep.a().c(paramInt);
    ConcurrentMap localConcurrentMap2 = this.jdField_a_of_type_Qep.a().a(paramInt);
    if ((localConcurrentMap1 == null) || (localConcurrentMap2 == null) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isTerminated()) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJRefreshTopicInfoHandler.1(this, localConcurrentMap2, localConcurrentMap1, paramInt));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xa6e.RspBody localRspBody = new oidb_cmd0xa6e.RspBody();
    if (qxp.a(paramFromServiceMsg, paramObject, localRspBody) == 0)
    {
      paramFromServiceMsg = localRspBody.rpt_topicinfo.get();
      int i = ((Integer)paramToServiceMsg.getAttribute("channelId")).intValue();
      paramToServiceMsg = (Set)paramToServiceMsg.getAttribute("0xa6e_articleSeqSet");
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJRefreshTopicInfoHandler.2(this, i, paramToServiceMsg, paramFromServiceMsg));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qjb
 * JD-Core Version:    0.7.0.1
 */