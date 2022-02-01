package com.tencent.mobileqq.leba.core;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.business.LebaSettingChangeProxy;
import com.tencent.mobileqq.leba.observer.LebaSettingObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.ReportRspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class LebaSettingHandler
  extends BusinessHandler
{
  public AppInterface a;
  public LebaSettingChangeProxy b = new LebaSettingChangeProxy();
  
  public LebaSettingHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.a = paramAppInterface;
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
    label332:
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
            break label332;
          }
          paramToServiceMsg = (ILebaHelperService)this.a.getRuntimeService(ILebaHelperService.class, "");
          if (paramToServiceMsg != null) {
            paramToServiceMsg.updateAppSetting(this.a, i, bool, l1, l2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.LebaSettingHandler
 * JD-Core Version:    0.7.0.1
 */