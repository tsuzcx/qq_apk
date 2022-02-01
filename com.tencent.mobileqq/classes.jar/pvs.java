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

public class pvs
  extends pwd
{
  private pvt a;
  
  public pvs(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, qli paramqli, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramqli, paramHandler);
  }
  
  private ToServiceMsg a(long paramLong)
  {
    oidb_cmd0xe71.ReqBody localReqBody = new oidb_cmd0xe71.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.uint32_client_type.set(1);
    return qlk.a("OidbSvc.0xe71", 3697, 1, localReqBody.toByteArray());
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xe71.RspBody();
    if ((qlk.a(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0) && (paramToServiceMsg.uint32_result.has()))
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
  
  public void a(long paramLong, pvt parampvt)
  {
    QLog.d("RIJUGCAccountCreateModule", 1, "requestUserApproveInfo uin: " + paramLong);
    if (parampvt != null) {
      this.a = parampvt;
    }
    parampvt = a(paramLong);
    parampvt.addAttribute("KEY_UGC_USER_ACCOUNT_UIN", Long.valueOf(paramLong));
    a(parampvt);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xe71")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pvs
 * JD-Core Version:    0.7.0.1
 */