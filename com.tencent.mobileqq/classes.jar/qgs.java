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

public class qgs
  extends qhj
{
  private qgt jdField_a_of_type_Qgt;
  private qgu jdField_a_of_type_Qgu;
  
  public qgs(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, qxn paramqxn, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramqxn, paramHandler);
  }
  
  private ToServiceMsg a(long paramLong, int paramInt)
  {
    oidb_cmd0xe71.ReqBody localReqBody = new oidb_cmd0xe71.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.uint32_client_type.set(1);
    localReqBody.uint32_op_type.set(paramInt);
    return qxp.a("OidbSvc.0xe71", 3697, paramInt, localReqBody.toByteArray());
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Integer localInteger = (Integer)paramToServiceMsg.getAttribute("KEY_UGC_USER_ACCOUNT_OPT_TYPE");
    if (localInteger.intValue() == 1) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (localInteger.intValue() != 2) {
      return;
    }
    d(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xe71.RspBody();
    int i = qxp.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i != 0) {
      QLog.d("RIJUGCAccountCreateModule", 1, "handleUGCAccountCreate result = " + i);
    }
    do
    {
      return;
      i = qxl.a(paramToServiceMsg.uint32_result, -1);
      QLog.d("RIJUGCAccountCreateModule", 1, "handleUGCAccountCreate pbResult = " + i);
    } while ((i < 0) || (this.jdField_a_of_type_Qgt == null));
    this.jdField_a_of_type_Qgt.a(paramToServiceMsg.uint32_result.get());
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xe71.RspBody();
    int i = qxp.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i != 0) {
      QLog.d("RIJUGCAccountCreateModule", 1, "handleUGCAccountStatus result = " + i);
    }
    do
    {
      return;
      i = qxl.a(paramToServiceMsg.account_status);
      QLog.d("RIJUGCAccountCreateModule", 1, "handleUGCAccountStatus status = " + i);
    } while (this.jdField_a_of_type_Qgu == null);
    this.jdField_a_of_type_Qgu.a(i);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Qgt = null;
    this.jdField_a_of_type_Qgu = null;
  }
  
  public void a(long paramLong, qgt paramqgt)
  {
    QLog.d("RIJUGCAccountCreateModule", 1, "requestUgcAccountCreate uin: " + paramLong);
    if (paramqgt != null) {
      this.jdField_a_of_type_Qgt = paramqgt;
    }
    paramqgt = a(paramLong, 1);
    paramqgt.addAttribute("KEY_UGC_USER_ACCOUNT_UIN", Long.valueOf(paramLong));
    paramqgt.addAttribute("KEY_UGC_USER_ACCOUNT_OPT_TYPE", Integer.valueOf(1));
    a(paramqgt);
  }
  
  public void a(long paramLong, qgu paramqgu)
  {
    QLog.d("RIJUGCAccountCreateModule", 1, "requestUgcAccountStatus uin: " + paramLong);
    if (paramqgu != null) {
      this.jdField_a_of_type_Qgu = paramqgu;
    }
    paramqgu = a(paramLong, 2);
    paramqgu.addAttribute("KEY_UGC_USER_ACCOUNT_UIN", Long.valueOf(paramLong));
    paramqgu.addAttribute("KEY_UGC_USER_ACCOUNT_OPT_TYPE", Integer.valueOf(2));
    a(paramqgu);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xe71")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qgs
 * JD-Core Version:    0.7.0.1
 */