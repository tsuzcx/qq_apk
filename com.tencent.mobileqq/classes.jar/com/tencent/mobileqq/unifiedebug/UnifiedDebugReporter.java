package com.tencent.mobileqq.unifiedebug;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.unifiedebug.RemoteDebugReportMsg.RemoteLogReq;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

public class UnifiedDebugReporter
{
  public QQAppInterface a;
  public BusinessObserver a;
  
  public UnifiedDebugReporter(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_MqqObserverBusinessObserver = new UnifiedDebugReporter.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public String a(int paramInt, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("status", paramInt);
      localObject = paramJSONObject;
      if (paramJSONObject == null) {
        localObject = new JSONObject();
      }
      localJSONObject.put("data", localObject);
    }
    catch (JSONException paramJSONObject)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportStatus: exception=");
        ((StringBuilder)localObject).append(paramJSONObject.getMessage());
        QLog.e("UnifiedDebugReporter", 2, ((StringBuilder)localObject).toString());
      }
    }
    return localJSONObject.toString();
  }
  
  public void a(long paramLong, int paramInt, JSONObject paramJSONObject)
  {
    Object localObject = new RemoteDebugReportMsg.RemoteLogReq();
    ((RemoteDebugReportMsg.RemoteLogReq)localObject).str_seq.set(String.valueOf(paramLong));
    ((RemoteDebugReportMsg.RemoteLogReq)localObject).str_data.set(a(paramInt, paramJSONObject));
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), UnifiedDebugReportServlet.class);
    localNewIntent.putExtra("extra_cmd", "ClubDebugging.report");
    localNewIntent.putExtra("extra_data", ((RemoteDebugReportMsg.RemoteLogReq)localObject).toByteArray());
    localNewIntent.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportStatus: seq=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", statusCode=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", data=");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.d("UnifiedDebugReporter", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.UnifiedDebugReporter
 * JD-Core Version:    0.7.0.1
 */