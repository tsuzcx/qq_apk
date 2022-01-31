import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService.1;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService.2;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class por
{
  private static por jdField_a_of_type_Por;
  private int jdField_a_of_type_Int;
  private DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("0.00");
  private ConcurrentHashMap<Integer, WeakReference<pbe>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static por a()
  {
    if (jdField_a_of_type_Por == null) {
      jdField_a_of_type_Por = new por();
    }
    return jdField_a_of_type_Por;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = (Integer)paramToServiceMsg.getAttributes().get("seq");
    if (localObject == null) {}
    do
    {
      do
      {
        return;
        localObject = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      } while (localObject == null);
      localObject = (pbe)((WeakReference)localObject).get();
    } while (localObject == null);
    ((pbe)localObject).a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg)
  {
    int i;
    int k;
    if (paramToServiceMsg.getAttribute(pbe.f) != null)
    {
      i = ((Integer)paramToServiceMsg.getAttribute(pbe.f)).intValue();
      if (i == 2)
      {
        k = 1;
        QLog.d("ReadInJoyMSFService", 1, new Object[] { "is68bRetryReq = ", Boolean.valueOf(k), ", retryTimes = ", Integer.valueOf(i) });
      }
    }
    for (;;)
    {
      int n = k;
      int j;
      if (paramToServiceMsg.getAttribute("retryIndex") != null)
      {
        j = ((Integer)paramToServiceMsg.getAttribute("retryIndex")).intValue();
        if (j <= 0) {
          break label162;
        }
      }
      label162:
      for (i = 1;; i = 0)
      {
        n = k | i;
        QLog.d("ReadInJoyMSFService", 1, new Object[] { "is68bRetryReq = ", Boolean.valueOf(n), ", fastResendRetryIndex = ", Integer.valueOf(j) });
        if (n != 0) {
          QLog.d("ReadInJoyMSFService", 1, " isRetryRequest | 68b Retry");
        }
        return n;
        m = 0;
        break;
      }
      int m = 0;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = new ReadInJoyMSFService.2(this, paramToServiceMsg);
    onh.a().post(paramToServiceMsg);
  }
  
  public final void a(ToServiceMsg paramToServiceMsg, pbe parampbe)
  {
    if ((paramToServiceMsg == null) || (parampbe == null)) {
      return;
    }
    paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    parampbe = new WeakReference(parampbe);
    onh.a().post(new ReadInJoyMSFService.1(this, paramToServiceMsg, parampbe));
    a(paramToServiceMsg);
  }
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Exception paramException)
  {
    Object localObject = null;
    if (paramToServiceMsg == null) {
      return;
    }
    float f = (float)(System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey")) / 1000.0F;
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyMSFService", 2, "[RES]cmd=" + paramFromServiceMsg.getServiceCmd() + " app seq:" + paramFromServiceMsg.getAppSeq() + " during " + this.jdField_a_of_type_JavaTextDecimalFormat.format(f) + "sec.");
      }
      boolean bool = paramToServiceMsg.extraData.getBoolean("req_pb_protocol_flag", false);
      if (QLog.isDevelopLevel()) {
        QLog.d("ReadInJoy", 4, "bPbResp:" + bool);
      }
      paramException = localObject;
      if (paramBoolean)
      {
        if (!bool) {
          break label477;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyMSFService", 2, "PB cmd: recv cmd: " + paramFromServiceMsg.getServiceCmd());
        }
        paramException = localObject;
        if (paramFromServiceMsg.getWupBuffer() != null)
        {
          int i = paramFromServiceMsg.getWupBuffer().length - 4;
          paramException = new byte[i];
          bbmx.a(paramException, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
          paramFromServiceMsg.putWupBuffer(paramException);
          paramException = paramFromServiceMsg.getWupBuffer();
        }
      }
    }
    for (;;)
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramException);
      return;
      if (paramFromServiceMsg.getResultCode() == 2008)
      {
        paramFromServiceMsg = BaseActivity.sTopActivity;
        paramToServiceMsg = paramFromServiceMsg;
        if (paramFromServiceMsg == null) {
          paramToServiceMsg = onh.a().getApplication();
        }
        paramFromServiceMsg = new Intent(paramToServiceMsg, NotificationActivity.class);
        paramFromServiceMsg.setFlags(872415232);
        paramFromServiceMsg.putExtra("type", 2);
        paramToServiceMsg.startActivity(paramFromServiceMsg);
        return;
      }
      if (paramException != null)
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        paramException.printStackTrace(new PrintStream(localByteArrayOutputStream));
        paramException = new String(localByteArrayOutputStream.toByteArray());
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadInJoyMSFService", 2, "[NOT SEND]cmd=" + paramFromServiceMsg.getServiceCmd() + ", " + paramException);
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("ReadInJoyMSFService", 2, "[RES]cmd=" + paramFromServiceMsg.getServiceCmd() + ",CODE=" + paramFromServiceMsg.getResultCode() + " during " + this.jdField_a_of_type_JavaTextDecimalFormat.format(f) + "sec.");
      break;
      label477:
      if (0 != 0) {}
      try
      {
        throw new NullPointerException();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        paramException = localObject;
      }
      paramException = localObject;
      if (QLog.isColorLevel())
      {
        QLog.d("ReadInJoyMSFService", 2, "bpc null");
        paramException = localObject;
        continue;
        if (QLog.isColorLevel())
        {
          QLog.d("ReadInJoyMSFService", 2, "", localException);
          paramException = localObject;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     por
 * JD-Core Version:    0.7.0.1
 */