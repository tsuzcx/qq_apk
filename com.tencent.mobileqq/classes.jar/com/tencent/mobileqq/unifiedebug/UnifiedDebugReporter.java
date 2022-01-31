package com.tencent.mobileqq.unifiedebug;

import ajyi;
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
    this.jdField_a_of_type_MqqObserverBusinessObserver = new ajyi(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public String a(int paramInt, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("status", paramInt);
      JSONObject localJSONObject1 = paramJSONObject;
      if (paramJSONObject == null) {
        localJSONObject1 = new JSONObject();
      }
      localJSONObject2.put("data", localJSONObject1);
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("UnifiedDebugReporter", 2, "reportStatus: exception=" + paramJSONObject.getMessage());
        }
      }
    }
    return localJSONObject2.toString();
  }
  
  public void a(long paramLong, int paramInt, JSONObject paramJSONObject)
  {
    RemoteDebugReportMsg.RemoteLogReq localRemoteLogReq = new RemoteDebugReportMsg.RemoteLogReq();
    localRemoteLogReq.str_seq.set(String.valueOf(paramLong));
    localRemoteLogReq.str_data.set(a(paramInt, paramJSONObject));
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), UnifiedDebugReportServlet.class);
    localNewIntent.putExtra("extra_cmd", "ClubDebugging.report");
    localNewIntent.putExtra("extra_data", localRemoteLogReq.toByteArray());
    localNewIntent.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("UnifiedDebugReporter", 2, "reportStatus: seq=" + paramLong + ", statusCode=" + paramInt + ", data=" + paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.UnifiedDebugReporter
 * JD-Core Version:    0.7.0.1
 */