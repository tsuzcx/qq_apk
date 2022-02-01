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

public class pvg
  extends pwd
{
  private HashMap<Integer, pvm> a;
  
  public pvg(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, qli paramqli, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramqli, paramHandler);
    b();
  }
  
  private pvm a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      return (pvm)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  private void a(pvm parampvm)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (parampvm == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(parampvm.a()), parampvm);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    a(new pvi());
    a(new pvh());
    a(new pvj());
    a(new pvk());
    a(new pvl());
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xed4.RspBody localRspBody = new oidb_cmd0xed4.RspBody();
    int i = qlk.a(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = (Integer)paramToServiceMsg.getAttributes().get("RequestType");
    if ((i != 0) && (QLog.isColorLevel())) {
      QLog.e("RIJCoinInfoModule", 2, "handle0xed4CoinInfoResp error, result:" + i);
    }
    int j = localRspBody.retcode.get();
    paramObject = localRspBody.retmsg.get();
    if (QLog.isColorLevel()) {
      QLog.d("RIJCoinInfoModule", 2, new Object[] { "handle0xed4CoinInfoResp result = ", i + ", requestType=" + paramFromServiceMsg + ", retCode=" + j + ", retMsg=" + paramObject });
    }
    pvm localpvm = a(paramFromServiceMsg.intValue());
    if (localpvm == null)
    {
      QLog.e("RIJCoinInfoModule", 1, "dispatch0xed4Resp() cant find requestHandler, requestType=" + paramFromServiceMsg);
      return;
    }
    localpvm.a(paramToServiceMsg, localRspBody, i, j, paramObject);
  }
  
  public void a() {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xed4")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void a(qlr paramqlr)
  {
    if (paramqlr == null) {
      if (QLog.isColorLevel()) {
        QLog.e("RIJCoinInfoModule", 2, "request0xed4CoinInfo params == null");
      }
    }
    pvm localpvm;
    do
    {
      return;
      try
      {
        oidb_cmd0xed4.ReqBody localReqBody = new oidb_cmd0xed4.ReqBody();
        localpvm = a(paramqlr.jdField_a_of_type_Int);
        if (localpvm != null) {
          break;
        }
        QLog.e("RIJCoinInfoModule", 1, "request0xed4CoinInfo cant find requestHandler, requestType=" + paramqlr.jdField_a_of_type_Int);
        return;
      }
      catch (Throwable localThrowable) {}
    } while (!QLog.isColorLevel());
    QLog.e("RIJCoinInfoModule", 2, "request0xed4CoinInfo failed. type=" + paramqlr.jdField_a_of_type_Int + ", rowkey=" + paramqlr.jdField_a_of_type_JavaLangString, localThrowable);
    return;
    Object localObject2 = new oidb_cmd0xed4.MetaData();
    ((oidb_cmd0xed4.MetaData)localObject2).timestamp.set(NetConnInfoCenter.getServerTimeMillis() / 1000L);
    localThrowable.meta.set((MessageMicro)localObject2);
    localObject2 = new oidb_cmd0xed4.SecurityInfo();
    ((oidb_cmd0xed4.SecurityInfo)localObject2).nickname.set(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentNickname());
    if (!TextUtils.isEmpty(DeviceInfoUtil.getIMSI())) {
      ((oidb_cmd0xed4.SecurityInfo)localObject2).device_id.set(DeviceInfoUtil.getIMSI());
    }
    String str = pri.a(BaseApplicationImpl.getContext());
    if (!TextUtils.isEmpty(str)) {
      ((oidb_cmd0xed4.SecurityInfo)localObject2).ip.set(str);
    }
    str = DeviceInfoUtil.getIMEI();
    if (!TextUtils.isEmpty(str)) {
      ((oidb_cmd0xed4.SecurityInfo)localObject2).terminal_id.set(str);
    }
    ((oidb_cmd0xed4.SecurityInfo)localObject2).os_type.set(2);
    ((oidb_cmd0xed4.SecurityInfo)localObject2).app_version.set("8.4.8");
    localThrowable.security_info.set((MessageMicro)localObject2);
    localpvm.a(paramqlr, localThrowable);
    Object localObject1 = localThrowable.toByteArray();
    if (QLog.isColorLevel()) {
      QLog.d("RIJCoinInfoModule", 2, "request0xed4CoinInfo requestType:" + paramqlr.jdField_a_of_type_Int + ", toByteArray size=" + localObject1.length);
    }
    localObject1 = qlk.a("OidbSvc.0xed4", 3796, 1, (byte[])localObject1);
    ((ToServiceMsg)localObject1).getAttributes().put("RequestType", Integer.valueOf(paramqlr.jdField_a_of_type_Int));
    if (!TextUtils.isEmpty(paramqlr.jdField_a_of_type_JavaLangString)) {
      ((ToServiceMsg)localObject1).getAttributes().put("RequestRowkey", paramqlr.jdField_a_of_type_JavaLangString);
    }
    a((ToServiceMsg)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pvg
 * JD-Core Version:    0.7.0.1
 */