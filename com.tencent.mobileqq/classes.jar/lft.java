import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;

public class lft
{
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private final ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private final Map<String, int[]> jdField_a_of_type_JavaUtilMap;
  
  public lft(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  }
  
  public AppInterface a()
  {
    return this.jdField_a_of_type_ComTencentCommonAppAppInterface;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, aqtc paramaqtc, Class<? extends MSFServlet> paramClass)
  {
    if (paramToServiceMsg.getWupBuffer() != null)
    {
      long l = paramToServiceMsg.getWupBuffer().length;
      byte[] arrayOfByte = new byte[(int)l + 4];
      PkgTools.DWord2Byte(arrayOfByte, 0, 4L + l);
      PkgTools.copyData(arrayOfByte, 4, paramToServiceMsg.getWupBuffer(), (int)l);
      paramToServiceMsg.putWupBuffer(arrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("MsfServletProxy", 2, "PB cmd: req cmd: " + paramToServiceMsg.getServiceCmd());
      }
      paramToServiceMsg.actionListener = paramaqtc;
      paramaqtc = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), paramClass);
      paramaqtc.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramaqtc);
      l = System.currentTimeMillis();
      paramToServiceMsg.extraData.putLong("sendtimekey", l);
    }
  }
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Exception paramException)
  {
    if ((paramToServiceMsg == null) || (paramToServiceMsg.extraData == null))
    {
      paramException = new StringBuilder().append("handleResponse error req:").append(paramToServiceMsg).append("|");
      if (paramFromServiceMsg == null)
      {
        paramToServiceMsg = "null";
        lbd.g("MsfServletProxy", paramToServiceMsg);
      }
    }
    AppInterface localAppInterface;
    float f;
    Object localObject1;
    label153:
    boolean bool;
    do
    {
      return;
      paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
      break;
      localAppInterface = a();
      f = (float)(System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey")) / 1000.0F;
      localObject1 = paramFromServiceMsg.getServiceCmd();
      if (!paramBoolean) {
        break label350;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsfServletProxy", 2, "[RES]cmd=" + (String)localObject1 + ", app seq:" + paramFromServiceMsg.getAppSeq() + ", sec.=" + f);
      }
      bool = paramToServiceMsg.extraData.getBoolean("req_pb_protocol_flag", false);
    } while (((!paramBoolean) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(localObject1))) || (!bool));
    if (QLog.isColorLevel()) {
      QLog.d("MsfServletProxy", 2, "PB cmd: recv cmd: " + (String)localObject1);
    }
    int i;
    if (paramFromServiceMsg.getWupBuffer() != null)
    {
      i = paramFromServiceMsg.getWupBuffer().length - 4;
      if (i > 0)
      {
        paramException = new byte[i];
        PkgTools.copyData(paramException, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
        paramFromServiceMsg.putWupBuffer(paramException);
      }
    }
    for (paramException = paramFromServiceMsg.getWupBuffer();; paramException = null)
    {
      for (;;)
      {
        Object localObject2 = (int[])this.jdField_a_of_type_JavaUtilMap.get(localObject1);
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          int j = localObject2.length;
          i = 0;
          label305:
          if (i >= j) {
            break;
          }
          localObject1 = (BusinessHandler)localAppInterface.getBusinessHandler(localObject2[i]);
          if (localObject1 != null) {}
          try
          {
            ((BusinessHandler)localObject1).onReceive(paramToServiceMsg, paramFromServiceMsg, paramException);
            i += 1;
            break label305;
            label350:
            if (paramException != null)
            {
              localObject2 = new ByteArrayOutputStream();
              paramException.printStackTrace(new PrintStream((OutputStream)localObject2));
              paramException = new String(((ByteArrayOutputStream)localObject2).toByteArray());
              if (!QLog.isColorLevel()) {
                break label153;
              }
              QLog.d("MsfServletProxy", 2, "[NOT SEND]cmd=" + (String)localObject1 + ", " + paramException);
              break label153;
            }
            if (!QLog.isColorLevel()) {
              break label153;
            }
            QLog.w("MsfServletProxy", 2, "[RES]cmd=" + (String)localObject1 + ", CODE=" + paramFromServiceMsg.getResultCode() + ", sec.=" + f);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
              if (QLog.isColorLevel()) {
                QLog.w("MsfServletProxy", 2, localObject1.getClass().getSimpleName() + " onReceive error,", localException);
              }
            }
          }
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("MsfServletProxy", 2, " handlerIds no map " + (String)localObject1);
      return;
    }
  }
  
  public boolean a(String paramString, int[] paramArrayOfInt)
  {
    return a(paramString, paramArrayOfInt, false);
  }
  
  public boolean a(String paramString, int[] paramArrayOfInt, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, paramArrayOfInt);
      if (paramBoolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lft
 * JD-Core Version:    0.7.0.1
 */