package com.tencent.mobileqq.richmedia.server;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;

public class PeakMsfServletProxy
{
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Map<String, String[]> jdField_a_of_type_JavaUtilMap;
  
  public PeakMsfServletProxy(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    a("TransInfoCreate.CreateSession", new String[] { PeakAppInterface.a });
    a("TransInfo.JoinSession", new String[] { PeakAppInterface.a });
    a("TransInfo.ExitSession", new String[] { PeakAppInterface.a });
    a("TransInfo.ChangeSession", new String[] { PeakAppInterface.a });
    a("TransInfo.RawData", new String[] { PeakAppInterface.a });
  }
  
  public AppInterface a()
  {
    return this.jdField_a_of_type_ComTencentCommonAppAppInterface;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, Class<? extends MSFServlet> paramClass)
  {
    if (paramToServiceMsg.getWupBuffer() != null)
    {
      long l = paramToServiceMsg.getWupBuffer().length;
      byte[] arrayOfByte = new byte[(int)l + 4];
      PkgTools.DWord2Byte(arrayOfByte, 0, 4L + l);
      PkgTools.copyData(arrayOfByte, 4, paramToServiceMsg.getWupBuffer(), (int)l);
      paramToServiceMsg.putWupBuffer(arrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("PeakMsfServletProxy", 2, "PB cmd: req cmd: " + paramToServiceMsg.getServiceCmd());
      }
      paramClass = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), paramClass);
      paramClass.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramClass);
      l = System.currentTimeMillis();
      paramToServiceMsg.extraData.putLong("sendtimekey", l);
    }
  }
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Exception paramException)
  {
    int i = 0;
    AppInterface localAppInterface = a();
    float f = (float)(System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey")) / 1000.0F;
    Object localObject;
    int j;
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PeakMsfServletProxy", 2, "[RES]cmd=" + paramFromServiceMsg.getServiceCmd() + " app seq:" + paramFromServiceMsg.getAppSeq() + "sec." + f);
      }
      boolean bool = paramToServiceMsg.extraData.getBoolean("req_pb_protocol_flag", false);
      if ((!paramBoolean) || (!bool)) {
        break label498;
      }
      localObject = paramFromServiceMsg.getServiceCmd();
      if (QLog.isColorLevel()) {
        QLog.d("PeakMsfServletProxy", 2, "PB cmd: recv cmd: " + (String)localObject);
      }
      if (paramFromServiceMsg.getWupBuffer() == null) {
        break label499;
      }
      j = paramFromServiceMsg.getWupBuffer().length - 4;
      paramException = new byte[j];
      PkgTools.copyData(paramException, 0, paramFromServiceMsg.getWupBuffer(), 4, j);
      paramFromServiceMsg.putWupBuffer(paramException);
    }
    label226:
    label498:
    label499:
    for (paramException = paramFromServiceMsg.getWupBuffer();; paramException = null)
    {
      for (;;)
      {
        String[] arrayOfString = (String[])this.jdField_a_of_type_JavaUtilMap.get(localObject);
        if ((arrayOfString != null) && (arrayOfString.length > 0))
        {
          j = arrayOfString.length;
          if (i >= j) {
            break label498;
          }
          localObject = localAppInterface.getBusinessHandler(arrayOfString[i]);
          if (localObject != null) {}
          try
          {
            ((BusinessHandler)localObject).onReceive(paramToServiceMsg, paramFromServiceMsg, paramException);
            i += 1;
            break label226;
            if (paramException != null)
            {
              localObject = new ByteArrayOutputStream();
              paramException.printStackTrace(new PrintStream((OutputStream)localObject));
              paramException = new String(((ByteArrayOutputStream)localObject).toByteArray());
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("PeakMsfServletProxy", 2, "[NOT SEND]cmd=" + paramFromServiceMsg.getServiceCmd() + ", " + paramException);
              break;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.w("PeakMsfServletProxy", 2, "[RES]cmd=" + paramFromServiceMsg.getServiceCmd() + ",CODE=" + paramFromServiceMsg.getResultCode() + "sec." + f);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
              if (QLog.isColorLevel()) {
                QLog.w("PeakMsfServletProxy", 2, localObject.getClass().getSimpleName() + " onReceive error,", localException);
              }
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.w("PeakMsfServletProxy", 2, " handlerIds no map " + (String)localObject);
      }
      return;
    }
  }
  
  protected boolean a(String paramString, String[] paramArrayOfString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, paramArrayOfString);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.server.PeakMsfServletProxy
 * JD-Core Version:    0.7.0.1
 */