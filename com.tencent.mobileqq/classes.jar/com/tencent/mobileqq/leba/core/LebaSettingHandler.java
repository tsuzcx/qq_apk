package com.tencent.mobileqq.leba.core;

import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.business.LebaSettingChangeProxy;
import com.tencent.mobileqq.leba.observer.LebaSettingObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.ReportReqBody;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.ReportRspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class LebaSettingHandler
  extends BusinessHandler
{
  public AppInterface a;
  public LebaSettingChangeProxy a;
  
  public LebaSettingHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaSettingChangeProxy = new LebaSettingChangeProxy();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public void a(String paramString, boolean paramBoolean, long paramLong)
  {
    QLog.i("LebaSettingHandler", 1, " netSetPluginState : path = " + paramString + ";status = " + paramBoolean + ";time = " + paramLong);
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
    localReportReqBody.clientver.set("8.5.5.5105");
    localReportReqBody.platid.set(109);
    localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
    Object localObject = (IRedTouchManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IRedTouchManager.class, "");
    localReportReqBody.appid.set(((IRedTouchManager)localObject).getAppIdByPath(paramString));
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("cmd", 4);
      ((JSONObject)localObject).put("setting", paramBoolean);
      ((JSONObject)localObject).put("modify_ts", paramLong);
      localReportReqBody.buffer.set(((JSONObject)localObject).toString());
      localObject = createToServiceMsg("RedTouchSvc.EntranceSetting");
      ((ToServiceMsg)localObject).extraData.putInt("RedTouchSubCmd", 1);
      ((ToServiceMsg)localObject).extraData.putInt("SettingAppid", localReportReqBody.appid.get());
      ((ToServiceMsg)localObject).extraData.putBoolean("SettingStatus", paramBoolean);
      ((ToServiceMsg)localObject).putWupBuffer(localReportReqBody.toByteArray());
      super.sendPbReq((ToServiceMsg)localObject);
      this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaSettingChangeProxy.a(paramString, paramBoolean, paramLong);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("LebaSettingHandler", 1, localJSONException, new Object[0]);
      }
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return LebaSettingObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((!paramFromServiceMsg.getServiceCmd().equals("RedTouchSvc.EntranceSetting")) || (!paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      return;
      paramToServiceMsg = new BusinessInfoCheckUpdate.ReportRspBody();
      try
      {
        paramFromServiceMsg = (BusinessInfoCheckUpdate.ReportRspBody)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
        if (paramToServiceMsg.code.get() == 0)
        {
          i = paramToServiceMsg.appid.get();
          paramToServiceMsg = paramToServiceMsg.buffer.get();
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        try
        {
          int i;
          paramToServiceMsg = new JSONObject(paramToServiceMsg);
          if (paramToServiceMsg.getInt("cmd") == 4)
          {
            boolean bool = paramToServiceMsg.getBoolean("setting");
            long l1 = paramToServiceMsg.getLong("modify_ts");
            long l2 = paramToServiceMsg.getLong("server_ts");
            if ((l1 != l2) && (l2 > 0L))
            {
              paramToServiceMsg = (ILebaHelperService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ILebaHelperService.class, "");
              if (paramToServiceMsg != null) {
                paramToServiceMsg.updateAppSetting(this.jdField_a_of_type_ComTencentCommonAppAppInterface, i, bool, l1, l2);
              }
            }
            else
            {
              QLog.i("LebaSettingHandler", 1, " onReceiver, [" + i + "," + bool + "," + l1 + "," + l2 + "]");
              notifyUI(2, true, Boolean.valueOf(bool));
              return;
            }
          }
        }
        catch (Exception paramToServiceMsg)
        {
          for (;;)
          {
            QLog.e("LebaSettingHandler", 1, paramToServiceMsg, new Object[0]);
            return;
            paramFromServiceMsg = paramFromServiceMsg;
            paramToServiceMsg.code.set(-1);
            paramToServiceMsg.errmsg.set("prb.mergeFrom exception");
            paramFromServiceMsg.printStackTrace();
            continue;
            QLog.d("LebaSettingHandler", 1, "onReceive lebaHelperService == null");
          }
        }
        catch (Throwable paramToServiceMsg)
        {
          QLog.e("LebaSettingHandler", 1, paramToServiceMsg, new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.LebaSettingHandler
 * JD-Core Version:    0.7.0.1
 */