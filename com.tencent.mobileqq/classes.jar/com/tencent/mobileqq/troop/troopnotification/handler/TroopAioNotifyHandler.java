package com.tencent.mobileqq.troop.troopnotification.handler;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.data.TroopAIONotifyItem;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.observer.TroopAioNotifyObserver;
import com.tencent.mobileqq.troop.troopnotification.api.ITroopAioNotifyHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.oidb_0x928.oidb_0x928.NoticeInfo;
import tencent.im.oidb.oidb_0x928.oidb_0x928.ReqBody;
import tencent.im.oidb.oidb_0x928.oidb_0x928.RspBody;

public class TroopAioNotifyHandler
  extends TroopBaseHandler
  implements ITroopAioNotifyHandler
{
  public TroopAioNotifyHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    super.notifyUI(paramInt, paramBoolean, paramObject);
  }
  
  public void a(long paramLong)
  {
    try
    {
      String str = AppSetting.h();
      Object localObject = new oidb_0x928.ReqBody();
      ((oidb_0x928.ReqBody)localObject).group_id.set(paramLong);
      ((oidb_0x928.ReqBody)localObject).platform.set(2);
      ((oidb_0x928.ReqBody)localObject).version.set(str);
      localObject = makeOIDBPkg("OidbSvc.0x928", 2344, 0, ((oidb_0x928.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putLong("troopUin", paramLong);
      sendPbReq((ToServiceMsg)localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getTroopAioNotifyFeeds, troopUin=");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(", version=");
        ((StringBuilder)localObject).append(str);
        QLog.d(".troop.notify_feeds.data", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.notify_feeds.data", 2, "getTroopAioNotifyFeeds, exp:", localException);
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_0x928.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    long l = paramToServiceMsg.extraData.getLong("troopUin");
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("<---- handleGetTroopAioNotifyFeeds, troopUin=");
      paramToServiceMsg.append(l);
      paramToServiceMsg.append(", ret=");
      paramToServiceMsg.append(i);
      QLog.d(".troop.notify_feeds.data", 2, paramToServiceMsg.toString());
    }
    if (i == 0) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg = ((oidb_0x928.RspBody)localObject).notice_info_list.get();
        paramToServiceMsg = new ArrayList();
        int j = paramFromServiceMsg.size();
        i = 0;
        if (i < j)
        {
          paramObject = (oidb_0x928.NoticeInfo)paramFromServiceMsg.get(i);
          localObject = new TroopAIONotifyItem();
          ((TroopAIONotifyItem)localObject).id = paramObject.id.get();
          ((TroopAIONotifyItem)localObject).title = paramObject.title.get();
          ((TroopAIONotifyItem)localObject).summary = paramObject.summary.get();
          ((TroopAIONotifyItem)localObject).url = paramObject.url.get();
          ((TroopAIONotifyItem)localObject).icon = paramObject.icon.get();
          ((TroopAIONotifyItem)localObject).type = paramObject.type.get();
          ((TroopAIONotifyItem)localObject).expireTime = paramObject.show_expire.get();
          ((TroopAIONotifyItem)localObject).hideMode = paramObject.hide_mode.get();
          ((TroopAIONotifyItem)localObject).troopUin = String.valueOf(l);
          ((TroopAIONotifyItem)localObject).appId = paramObject.app_id.get();
          if (paramToServiceMsg.contains(localObject)) {
            break label468;
          }
          paramToServiceMsg.add(localObject);
          break label468;
        }
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleGetTroopAioNotifyFeeds, serverList=");
          paramFromServiceMsg.append(paramToServiceMsg.size());
          paramFromServiceMsg.append(" ---->");
          QLog.d(".troop.notify_feeds.data", 2, paramFromServiceMsg.toString());
        }
        notifyUI(TroopAioNotifyObserver.b, true, new Object[] { String.valueOf(l), paramToServiceMsg });
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        notifyUI(TroopAioNotifyObserver.b, false, new Object[] { String.valueOf(l), new ArrayList() });
        if (!QLog.isColorLevel()) {
          break label467;
        }
      }
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGetTroopAioNotifyFeeds exp:, ");
      paramFromServiceMsg.append(paramToServiceMsg.toString());
      paramFromServiceMsg.append(" ---->");
      QLog.e(".troop.notify_feeds.data", 2, paramFromServiceMsg.toString());
      return;
      notifyUI(TroopAioNotifyObserver.b, false, new Object[] { String.valueOf(l), new ArrayList() });
      label467:
      return;
      label468:
      i += 1;
    }
  }
  
  protected String dv_()
  {
    return "TroopNotificationHandler";
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x928");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopAioNotifyObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationHandler", 2, "onReceive,resp == null");
      }
      return;
    }
    String str = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter(str))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmdfilter error=");
        paramToServiceMsg.append(str);
        QLog.d("TroopNotificationHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    if ("OidbSvc.0x928".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.handler.TroopAioNotifyHandler
 * JD-Core Version:    0.7.0.1
 */