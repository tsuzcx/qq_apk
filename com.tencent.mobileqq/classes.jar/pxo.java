import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xe71.oidb_cmd0xe71.ReqBody;
import tencent.im.oidb.cmd0xe71.oidb_cmd0xe71.RspBody;

public class pxo
  extends pxz
{
  private pxp a;
  
  public pxo(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, qnd paramqnd, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramqnd, paramHandler);
  }
  
  private ToServiceMsg a(long paramLong)
  {
    oidb_cmd0xe71.ReqBody localReqBody = new oidb_cmd0xe71.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.uint32_client_type.set(1);
    return qnf.a("OidbSvc.0xe71", 3697, 1, localReqBody.toByteArray());
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xe71.RspBody();
    if ((qnf.a(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0) && (paramToServiceMsg.uint32_result.has()))
    {
      QLog.d("RIJUGCAccountCreateModule", 1, "handleUGCAccountCreateResponsePkg result = " + paramToServiceMsg.uint32_result.get());
      if (this.a != null) {
        this.a.a(paramToServiceMsg.uint32_result.get());
      }
    }
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(long paramLong, pxp parampxp)
  {
    QLog.d("RIJUGCAccountCreateModule", 1, "requestUserApproveInfo uin: " + paramLong);
    if (parampxp != null) {
      this.a = parampxp;
    }
    parampxp = a(paramLong);
    parampxp.addAttribute("KEY_UGC_USER_ACCOUNT_UIN", Long.valueOf(paramLong));
    a(parampxp);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xe71")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pxo
 * JD-Core Version:    0.7.0.1
 */