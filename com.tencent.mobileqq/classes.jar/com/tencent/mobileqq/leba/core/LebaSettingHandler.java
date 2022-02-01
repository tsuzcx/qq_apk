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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" netSetPluginState : path = ");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(";status = ");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append(";time = ");
    ((StringBuilder)localObject1).append(paramLong);
    QLog.i("LebaSettingHandler", 1, ((StringBuilder)localObject1).toString());
    localObject1 = new BusinessInfoCheckUpdate.ReportReqBody();
    ((BusinessInfoCheckUpdate.ReportReqBody)localObject1).uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
    ((BusinessInfoCheckUpdate.ReportReqBody)localObject1).clientver.set("8.7.0.5295");
    ((BusinessInfoCheckUpdate.ReportReqBody)localObject1).platid.set(109);
    Object localObject2 = ((BusinessInfoCheckUpdate.ReportReqBody)localObject1).platver;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.VERSION.SDK_INT);
    localStringBuilder.append("");
    ((PBStringField)localObject2).set(localStringBuilder.toString());
    localObject2 = (IRedTouchManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IRedTouchManager.class, "");
    ((BusinessInfoCheckUpdate.ReportReqBody)localObject1).appid.set(((IRedTouchManager)localObject2).getAppIdByPath(paramString));
    localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("cmd", 4);
      ((JSONObject)localObject2).put("setting", paramBoolean);
      ((JSONObject)localObject2).put("modify_ts", paramLong);
      ((BusinessInfoCheckUpdate.ReportReqBody)localObject1).buffer.set(((JSONObject)localObject2).toString());
    }
    catch (JSONException localJSONException)
    {
      QLog.e("LebaSettingHandler", 1, localJSONException, new Object[0]);
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("RedTouchSvc.EntranceSetting");
    localToServiceMsg.extraData.putInt("RedTouchSubCmd", 1);
    localToServiceMsg.extraData.putInt("SettingAppid", ((BusinessInfoCheckUpdate.ReportReqBody)localObject1).appid.get());
    localToServiceMsg.extraData.putBoolean("SettingStatus", paramBoolean);
    localToServiceMsg.putWupBuffer(((BusinessInfoCheckUpdate.ReportReqBody)localObject1).toByteArray());
    super.sendPbReq(localToServiceMsg);
    this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaSettingChangeProxy.a(paramString, paramBoolean, paramLong);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return LebaSettingObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if (paramFromServiceMsg.getServiceCmd().equals("RedTouchSvc.EntranceSetting"))
    {
      if (!paramFromServiceMsg.isSuccess()) {
        return;
      }
      paramToServiceMsg = new BusinessInfoCheckUpdate.ReportRspBody();
      try
      {
        paramFromServiceMsg = (BusinessInfoCheckUpdate.ReportRspBody)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (Exception paramFromServiceMsg)
      {
        paramToServiceMsg.code.set(-1);
        paramToServiceMsg.errmsg.set("prb.mergeFrom exception");
        paramFromServiceMsg.printStackTrace();
      }
      if (paramToServiceMsg.code.get() == 0)
      {
        i = paramToServiceMsg.appid.get();
        paramToServiceMsg = paramToServiceMsg.buffer.get();
      }
    }
    label340:
    for (;;)
    {
      try
      {
        paramToServiceMsg = new JSONObject(paramToServiceMsg);
        if (paramToServiceMsg.getInt("cmd") == 4)
        {
          boolean bool = paramToServiceMsg.getBoolean("setting");
          long l1 = paramToServiceMsg.getLong("modify_ts");
          long l2 = paramToServiceMsg.getLong("server_ts");
          if ((l1 == l2) || (l2 <= 0L)) {
            break label340;
          }
          paramToServiceMsg = (ILebaHelperService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ILebaHelperService.class, "");
          if (paramToServiceMsg != null) {
            paramToServiceMsg.updateAppSetting(this.jdField_a_of_type_ComTencentCommonAppAppInterface, i, bool, l1, l2);
          } else {
            QLog.d("LebaSettingHandler", 1, "onReceive lebaHelperService == null");
          }
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append(" onReceiver, [");
          paramToServiceMsg.append(i);
          paramToServiceMsg.append(",");
          paramToServiceMsg.append(bool);
          paramToServiceMsg.append(",");
          paramToServiceMsg.append(l1);
          paramToServiceMsg.append(",");
          paramToServiceMsg.append(l2);
          paramToServiceMsg.append("]");
          paramToServiceMsg = paramToServiceMsg.toString();
          try
          {
            QLog.i("LebaSettingHandler", 1, paramToServiceMsg);
            notifyUI(2, true, Boolean.valueOf(bool));
            return;
          }
          catch (Exception paramToServiceMsg) {}
          QLog.e("LebaSettingHandler", 1, paramToServiceMsg, new Object[0]);
        }
      }
      catch (Throwable paramToServiceMsg)
      {
        QLog.e("LebaSettingHandler", 1, paramToServiceMsg, new Object[0]);
        return;
      }
      catch (Exception paramToServiceMsg) {}
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.LebaSettingHandler
 * JD-Core Version:    0.7.0.1
 */