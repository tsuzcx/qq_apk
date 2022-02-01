package com.tencent.mobileqq.troop.troopsurvey.handler;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.config.TroopSurveyHandlerProcessorConfig;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.observer.TroopSurveyObserver;
import com.tencent.mobileqq.troop.troopsurvey.api.ITroopSurveyHandler;
import com.tencent.mobileqq.troop.unreadmsg.TroopUnreadMsgInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppTipNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum;

public class TroopSurveyHandler
  extends TroopBaseHandler
  implements ITroopSurveyHandler
{
  public static String a = "OidbSvc.0xb36_1";
  protected Set<String> b;
  
  public TroopSurveyHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("troopUin");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handle_oidb_0xb36_1, troopUin = ");
      localStringBuilder.append(str);
      QLog.d(".troop.survey", 2, localStringBuilder.toString());
    }
    if (!paramFromServiceMsg.isSuccess())
    {
      QLog.e(".troop.survey", 1, new Object[] { "handle_oidb_0xb36_1, resp not success: ", paramFromServiceMsg.getBusinessFailMsg(), paramFromServiceMsg.toString() });
      notifyUI(TroopSurveyObserver.b, false, new Object[] { str });
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      TroopSurveyHandlerProcessorConfig.a().a(this.appRuntime, paramToServiceMsg, str, paramFromServiceMsg);
      notifyUI(TroopSurveyObserver.b, true, new Object[] { str });
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.e(".troop.survey", 1, "handle_oidb_0xb36_1, pkg.mergeFrom error! ", paramToServiceMsg);
      notifyUI(TroopSurveyObserver.b, false, new Object[] { str });
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("send_oidb_0xb36, troopUin = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d(".troop.survey", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new oidb_cmd0xb36.ReqBody();
    try
    {
      long l = Long.parseLong(paramString);
      ((oidb_cmd0xb36.ReqBody)localObject2).group_id.set(l);
      ((oidb_cmd0xb36.ReqBody)localObject2).red_point_num.set(paramInt);
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2870);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(1);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0xb36.ReqBody)localObject2).toByteArray()));
      localObject2 = createToServiceMsg(a);
      ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      ((ToServiceMsg)localObject2).extraData.putString("troopUin", paramString);
      sendPbReq((ToServiceMsg)localObject2);
      return;
    }
    catch (NumberFormatException paramString)
    {
      QLog.e(".troop.survey", 1, "send_oidb_0xb36 error! ", paramString);
    }
  }
  
  public boolean a(TroopUnreadMsgInfo paramTroopUnreadMsgInfo, submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum paramSubCmd0x1UpdateAppUnreadNum, int paramInt)
  {
    if (paramTroopUnreadMsgInfo.a != 1106717414L) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(".troop.survey", 2, new Object[] { "handle_push_msginfo receive TROOP_SURVEY_REDPOINT troopuin: ", paramTroopUnreadMsgInfo.b, " newNum: ", Integer.valueOf(paramTroopUnreadMsgInfo.d), " unreadNumber: ", Integer.valueOf(paramTroopUnreadMsgInfo.c), " from: ", Integer.valueOf(paramInt) });
    }
    if ((paramSubCmd0x1UpdateAppUnreadNum != null) && (paramSubCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.has()))
    {
      paramSubCmd0x1UpdateAppUnreadNum = paramSubCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.bytes_text.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramSubCmd0x1UpdateAppUnreadNum))
      {
        if (QLog.isColorLevel()) {
          QLog.d(".troop.survey", 2, new Object[] { "handle_push_msginfo receive TROOP_SURVEY_REDPOINT troopuin: ", paramTroopUnreadMsgInfo.b, " will notify ark com.tencent.groupDragon, data: ", paramSubCmd0x1UpdateAppUnreadNum });
        }
        TroopSurveyHandlerProcessorConfig.a().a(paramSubCmd0x1UpdateAppUnreadNum);
      }
    }
    if ((paramInt != 2) && (paramTroopUnreadMsgInfo.d == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.survey", 2, new Object[] { "handle_push_msginfo receive TROOP_SURVEY_REDPOINT troopuin: ", paramTroopUnreadMsgInfo.b, " newNum: ", Integer.valueOf(paramTroopUnreadMsgInfo.d), " unreadNumber: ", Integer.valueOf(paramTroopUnreadMsgInfo.c), " no need to send_oidb_0xb36 , from is: ", Integer.valueOf(paramInt) });
      }
      return true;
    }
    a(paramTroopUnreadMsgInfo.b, paramTroopUnreadMsgInfo.d);
    return true;
  }
  
  protected String dv_()
  {
    return "TroopSurveyHandler";
  }
  
  public Set<String> getCommandList()
  {
    if (this.b == null)
    {
      this.b = new HashSet();
      this.b.add(a);
    }
    return this.b;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopSurveyObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramToServiceMsg != null))
    {
      String str = paramFromServiceMsg.getServiceCmd();
      if (msgCmdFilter(str))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("cmdfilter error=");
          paramToServiceMsg.append(str);
          QLog.d("TroopSurveyHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if (a.equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopSurveyHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsurvey.handler.TroopSurveyHandler
 * JD-Core Version:    0.7.0.1
 */