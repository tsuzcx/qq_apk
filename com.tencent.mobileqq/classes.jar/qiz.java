import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJLimitFriendHandler.1;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xbd6.oidb_cmd0xbd6.RspBody;

public class qiz
  extends qii
{
  public qiz(qep paramqep, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, qxn paramqxn, ExecutorService paramExecutorService)
  {
    super(paramqep, paramHandler, paramAppInterface, paramEntityManager, paramqxn, paramExecutorService);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xbd6.RspBody localRspBody = new oidb_cmd0xbd6.RspBody();
    int i = qxp.a(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = paramFromServiceMsg.getServiceCmd();
    paramToServiceMsg = (String)paramToServiceMsg.getAttribute("rowKey");
    this.a.post(new RIJLimitFriendHandler.1(this, paramFromServiceMsg, i, localRspBody, paramToServiceMsg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qiz
 * JD-Core Version:    0.7.0.1
 */