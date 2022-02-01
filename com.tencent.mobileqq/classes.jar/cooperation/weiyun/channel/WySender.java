package cooperation.weiyun.channel;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.utils.Singleton;
import cooperation.weiyun.channel.pb.WeiyunPB.MsgHead;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public final class WySender
{
  private static Singleton<WySender, Void> jdField_a_of_type_ComTencentWeiyunUtilsSingleton = new WySender.1();
  private long jdField_a_of_type_Long = 1L;
  private ConcurrentHashMap<Integer, WySender.ICallback> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  public static WySender a()
  {
    return (WySender)jdField_a_of_type_ComTencentWeiyunUtilsSingleton.get(null);
  }
  
  private void a(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      QLog.e("WySender", 1, "sendRequestInner : seq[" + paramInt + "], cmd is empty");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WySender", 1, "sendRequestInner : seq[" + paramInt + "], cmd[" + paramString + "]");
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String[] arrayOfString;
    if (paramString.contains(".")) {
      arrayOfString = paramString.split("\\.");
    }
    for (int i = Integer.parseInt(arrayOfString[(arrayOfString.length - 1)]);; i = Integer.parseInt(paramString))
    {
      paramArrayOfByte = new PBPackage(i, paramArrayOfByte);
      paramString = new ToServiceMsg("mobileqq.service", localAppRuntime.getAccount(), paramString);
      paramString.setTimeout(Math.min(60000L, (30000.0D * Math.pow(this.jdField_a_of_type_Long, 0.15D))));
      paramString.setEnableFastResend(true);
      paramString.putWupBuffer(PBSerialization.a(paramArrayOfByte));
      paramString.extraData.putInt("sequence", paramInt);
      paramString.extraData.putLong("sendtimekey", System.currentTimeMillis());
      paramArrayOfByte = new NewIntent(localAppRuntime.getApplication(), WyServlet.class);
      paramArrayOfByte.putExtra(ToServiceMsg.class.getSimpleName(), paramString);
      localAppRuntime.startServlet(paramArrayOfByte);
      return;
    }
  }
  
  void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = null;
    int k = paramToServiceMsg.extraData.getInt("sequence");
    int i;
    label40:
    PBPackage localPBPackage;
    if (paramFromServiceMsg.isSuccess())
    {
      i = 0;
      if (i != 1002) {
        break label148;
      }
      this.jdField_a_of_type_Long += 1L;
      if (i != 0) {
        break label156;
      }
      localPBPackage = PBSerialization.a(paramFromServiceMsg.getWupBuffer());
      label53:
      paramFromServiceMsg = paramFromServiceMsg.getBusinessFailMsg();
      paramToServiceMsg = paramFromServiceMsg;
      if (i == 1002) {
        paramToServiceMsg = "(1002)" + paramFromServiceMsg;
      }
      if (i != 0) {
        break label205;
      }
      if (localPBPackage != null) {
        break label162;
      }
      i = 1810023;
    }
    label148:
    label156:
    label162:
    label196:
    label205:
    for (;;)
    {
      label99:
      WySender.ICallback localICallback = (WySender.ICallback)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(k));
      if (localICallback != null) {
        if (localPBPackage != null) {
          break label196;
        }
      }
      for (paramFromServiceMsg = localObject;; paramFromServiceMsg = localPBPackage.a())
      {
        localICallback.a(i, paramToServiceMsg, paramFromServiceMsg);
        return;
        i = paramFromServiceMsg.getResultCode();
        break;
        this.jdField_a_of_type_Long = 1L;
        break label40;
        localPBPackage = null;
        break label53;
        paramFromServiceMsg = localPBPackage.a();
        int j = paramFromServiceMsg.retcode.get();
        if (j == 0) {
          break label205;
        }
        paramToServiceMsg = paramFromServiceMsg.retmsg.get();
        i = j;
        break label99;
      }
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, WySender.ICallback paramICallback)
  {
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    if (paramICallback != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(i), paramICallback);
    }
    a(i, paramString, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.channel.WySender
 * JD-Core Version:    0.7.0.1
 */