import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.MetaData;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.ReqBody;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.RspBody;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.SecurityInfo;

public class qge
  extends qhj
{
  private HashMap<Integer, qgk> a;
  
  public qge(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, qxn paramqxn, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramqxn, paramHandler);
    b();
  }
  
  private qgk a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      return (qgk)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  private void a(qgk paramqgk)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (paramqgk == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramqgk.a()), paramqgk);
  }
  
  private void a(oidb_cmd0xed4.ReqBody paramReqBody)
  {
    Object localObject = new oidb_cmd0xed4.MetaData();
    ((oidb_cmd0xed4.MetaData)localObject).timestamp.set(NetConnInfoCenter.getServerTimeMillis() / 1000L);
    paramReqBody.meta.set((MessageMicro)localObject);
    localObject = new oidb_cmd0xed4.SecurityInfo();
    ((oidb_cmd0xed4.SecurityInfo)localObject).nickname.set(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentNickname());
    if (!TextUtils.isEmpty(DeviceInfoUtil.getIMSI())) {
      ((oidb_cmd0xed4.SecurityInfo)localObject).device_id.set(DeviceInfoUtil.getIMSI());
    }
    String str = qcg.a(BaseApplicationImpl.getContext());
    if (!TextUtils.isEmpty(str)) {
      ((oidb_cmd0xed4.SecurityInfo)localObject).ip.set(str);
    }
    str = DeviceInfoUtil.getIMEI();
    if (!TextUtils.isEmpty(str)) {
      ((oidb_cmd0xed4.SecurityInfo)localObject).terminal_id.set(str);
    }
    ((oidb_cmd0xed4.SecurityInfo)localObject).os_type.set(2);
    ((oidb_cmd0xed4.SecurityInfo)localObject).app_version.set("8.4.10");
    paramReqBody.security_info.set((MessageMicro)localObject);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    a(new qgg());
    a(new qgf());
    a(new qgh());
    a(new qgi());
    a(new qgj());
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xed4.RspBody localRspBody = new oidb_cmd0xed4.RspBody();
    int i = qxp.a(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = (Integer)paramToServiceMsg.getAttributes().get("RequestType");
    if ((i != 0) && (QLog.isColorLevel())) {
      QLog.e("RIJCoinInfoModule", 2, "handle0xed4CoinInfoResp error, result:" + i);
    }
    int j = localRspBody.retcode.get();
    paramObject = localRspBody.retmsg.get();
    if (QLog.isColorLevel()) {
      QLog.d("RIJCoinInfoModule", 2, new Object[] { "handle0xed4CoinInfoResp result = ", i + ", requestType=" + paramFromServiceMsg + ", retCode=" + j + ", retMsg=" + paramObject });
    }
    qgk localqgk = a(paramFromServiceMsg.intValue());
    if (localqgk == null)
    {
      QLog.e("RIJCoinInfoModule", 1, "dispatch0xed4Resp() cant find requestHandler, requestType=" + paramFromServiceMsg);
      return;
    }
    localqgk.a(paramToServiceMsg, localRspBody, i, j, paramObject);
  }
  
  public void a() {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xed4")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void a(qxw paramqxw)
  {
    if (paramqxw == null) {
      if (QLog.isColorLevel()) {
        QLog.e("RIJCoinInfoModule", 2, "request0xed4CoinInfo params == null");
      }
    }
    qgk localqgk;
    do
    {
      return;
      try
      {
        oidb_cmd0xed4.ReqBody localReqBody = new oidb_cmd0xed4.ReqBody();
        localqgk = a(paramqxw.jdField_a_of_type_Int);
        if (localqgk != null) {
          break;
        }
        QLog.e("RIJCoinInfoModule", 1, "request0xed4CoinInfo cant find requestHandler, requestType=" + paramqxw.jdField_a_of_type_Int);
        return;
      }
      catch (Throwable localThrowable) {}
    } while (!QLog.isColorLevel());
    QLog.e("RIJCoinInfoModule", 2, "request0xed4CoinInfo failed. type=" + paramqxw.jdField_a_of_type_Int + ", rowkey=" + paramqxw.jdField_a_of_type_JavaLangString, localThrowable);
    return;
    a(localThrowable);
    localqgk.a(paramqxw, localThrowable);
    Object localObject = localThrowable.toByteArray();
    if (QLog.isColorLevel()) {
      QLog.d("RIJCoinInfoModule", 2, "request0xed4CoinInfo requestType:" + paramqxw.jdField_a_of_type_Int + ", toByteArray size=" + localObject.length);
    }
    localObject = qxp.a("OidbSvc.0xed4", 3796, 1, (byte[])localObject);
    ((ToServiceMsg)localObject).getAttributes().put("RequestType", Integer.valueOf(paramqxw.jdField_a_of_type_Int));
    if (!TextUtils.isEmpty(paramqxw.jdField_a_of_type_JavaLangString)) {
      ((ToServiceMsg)localObject).getAttributes().put("RequestRowkey", paramqxw.jdField_a_of_type_JavaLangString);
    }
    a((ToServiceMsg)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qge
 * JD-Core Version:    0.7.0.1
 */