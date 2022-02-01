package com.tencent.mobileqq.troop.troopreddot.handler;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.config.TroopRedDotHandlerProcessorConfig;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.observer.TroopRedDotObserver;
import com.tencent.mobileqq.troop.troopreddot.api.ITroopRedDotHandler;
import com.tencent.mobileqq.troop.unreadmsg.TroopUnreadMsgInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x8ca.cmd0x8ca.ReqBody;
import tencent.im.oidb.cmd0x8ca.cmd0x8ca.RspBody;
import tencent.im.oidb.oidb_0x8c9.oidb_0x8c9.GroupAppUnreadInfo;
import tencent.im.oidb.oidb_0x8c9.oidb_0x8c9.ReqBody;
import tencent.im.oidb.oidb_0x8c9.oidb_0x8c9.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopRedDotHandler
  extends TroopBaseHandler
  implements ITroopRedDotHandler
{
  protected Set<String> a;
  
  public TroopRedDotHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(long paramLong, int paramInt)
  {
    TroopRedDotHandler.1 local1 = new TroopRedDotHandler.1(this, paramLong, paramInt);
    this.appRuntime.addDefaultObservers(local1);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearTroopAIORedDot, troopUin=");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("TroopRedDotHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new cmd0x8ca.ReqBody();
    ((cmd0x8ca.ReqBody)localObject).opt_uint32_sub_cmd.set(3L);
    try
    {
      ((cmd0x8ca.ReqBody)localObject).opt_uint64_from_uin.set(Long.parseLong(this.appRuntime.getCurrentAccountUin()));
      ((cmd0x8ca.ReqBody)localObject).opt_uint64_group_code.set(Long.parseLong(paramString));
      ((cmd0x8ca.ReqBody)localObject).opt_bytes_group_sig.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      ((cmd0x8ca.ReqBody)localObject).opt_uint64_appid.set(paramLong);
      paramArrayOfByte = new oidb_sso.OIDBSSOPkg();
      paramArrayOfByte.uint32_command.set(2250);
      paramArrayOfByte.uint32_result.set(0);
      paramArrayOfByte.uint32_service_type.set(2);
      paramArrayOfByte.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x8ca.ReqBody)localObject).toByteArray()));
      localObject = new ToServiceMsg("mobileqq.service", this.appRuntime.getCurrentAccountUin(), "OidbSvc.0x8ca_2");
      ((ToServiceMsg)localObject).extraData.putString("troopUin", paramString);
      ((ToServiceMsg)localObject).extraData.putString("type", String.valueOf(paramLong));
      ((ToServiceMsg)localObject).putWupBuffer(paramArrayOfByte.toByteArray());
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (NumberFormatException paramArrayOfByte)
    {
      label222:
      break label222;
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("clearTroopAIORedDot error, NumberFormatException, troopUin : ");
      paramArrayOfByte.append(paramString);
      QLog.d("TroopRedDotHandler", 2, paramArrayOfByte.toString());
    }
  }
  
  private boolean a(long paramLong, oidb_0x8c9.GroupAppUnreadInfo paramGroupAppUnreadInfo, List<TroopUnreadMsgInfo> paramList, StringBuilder paramStringBuilder)
  {
    long l = paramGroupAppUnreadInfo.opt_uint64_appid.get();
    TroopUnreadMsgInfo localTroopUnreadMsgInfo = new TroopUnreadMsgInfo();
    localTroopUnreadMsgInfo.jdField_a_of_type_Long = l;
    localTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString = String.valueOf(paramLong);
    localTroopUnreadMsgInfo.b = paramGroupAppUnreadInfo.opt_int32_group_unread_num.get();
    localTroopUnreadMsgInfo.jdField_a_of_type_Int = paramGroupAppUnreadInfo.opt_int32_group_album_passive_cnt.get();
    TroopRedDotHandlerProcessorConfig.a().a(this.appRuntime, paramLong, localTroopUnreadMsgInfo);
    if (QLog.isDevelopLevel())
    {
      paramStringBuilder.append("add photoinfo, groupCode = ");
      paramStringBuilder.append(paramLong);
      paramStringBuilder.append(", appid = ");
      paramStringBuilder.append(localTroopUnreadMsgInfo.jdField_a_of_type_Long);
      paramStringBuilder.append(", messageNum = ");
      paramStringBuilder.append(localTroopUnreadMsgInfo.jdField_a_of_type_Int);
      paramStringBuilder.append(", newPhotoes = ");
      paramStringBuilder.append(localTroopUnreadMsgInfo.b);
    }
    paramList.add(localTroopUnreadMsgInfo);
    return a(false, localTroopUnreadMsgInfo);
  }
  
  private boolean a(boolean paramBoolean, TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    long l = paramTroopUnreadMsgInfo.jdField_a_of_type_Long;
    boolean bool = true;
    if (l == 1102858908L)
    {
      if (paramTroopUnreadMsgInfo.b == -1) {
        return bool;
      }
      if (paramTroopUnreadMsgInfo.b > 0) {
        return true;
      }
      if (paramTroopUnreadMsgInfo.b == 0) {
        return true;
      }
    }
    bool = paramBoolean;
    return bool;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str;
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      str = paramToServiceMsg.extraData.getString("troopUin");
      paramToServiceMsg = paramToServiceMsg.extraData.getString("type");
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        notifyUI(TroopRedDotObserver.jdField_a_of_type_Int, false, new Object[] { str, paramToServiceMsg, Boolean.valueOf(true) });
        return;
      }
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.uint32_result.get() == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null)) {
        paramObject = new cmd0x8ca.RspBody();
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      long l;
      label254:
      break label312;
    }
    try
    {
      paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      l = paramObject.opt_uint64_group_code.get();
      TroopRedDotHandlerProcessorConfig.a().a(this.appRuntime, String.valueOf(l));
      notifyUI(TroopRedDotObserver.jdField_a_of_type_Int, true, new Object[] { str, paramToServiceMsg, Boolean.valueOf(true) });
      if (!QLog.isColorLevel()) {
        break label282;
      }
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleClearTroopAioRedDot, succ, troopUin=");
      paramFromServiceMsg.append(str);
      QLog.i("TroopRedDotHandler", 2, paramFromServiceMsg.toString());
      return;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      break label254;
    }
    notifyUI(TroopRedDotObserver.jdField_a_of_type_Int, false, new Object[] { str, paramToServiceMsg, Boolean.valueOf(true) });
    label282:
    return;
    notifyUI(TroopRedDotObserver.jdField_a_of_type_Int, false, new Object[] { str, paramToServiceMsg, Boolean.valueOf(true) });
    return;
    label312:
    notifyUI(TroopRedDotObserver.jdField_a_of_type_Int, false, new Object[] { str, paramToServiceMsg, Boolean.valueOf(true) });
  }
  
  protected String a()
  {
    return "TroopRedDotHandler";
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    super.notifyUI(paramInt, paramBoolean, paramObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getResultCode() == 1000) {}
    label407:
    label408:
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        int i = paramToServiceMsg.uint32_result.get();
        if (QLog.isDevelopLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handle_oidb_0x8c9_2|oidb_sso.OIDBSSOPkg.result = ");
          paramFromServiceMsg.append(i);
          QLog.i("Q.troopgetnews..troop.notification_center", 4, paramFromServiceMsg.toString());
        }
        if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
          try
          {
            paramFromServiceMsg = new oidb_0x8c9.RspBody();
            paramFromServiceMsg.mergeFrom(paramToServiceMsg);
            long l = paramFromServiceMsg.opt_uint64_group_code.get();
            paramToServiceMsg = null;
            if (paramFromServiceMsg.rpt_group_app_unread_info.has())
            {
              Object localObject = paramFromServiceMsg.rpt_group_app_unread_info.get();
              paramToServiceMsg = new ArrayList();
              paramObject = new StringBuilder();
              localObject = ((List)localObject).iterator();
              i = 0;
              if (((Iterator)localObject).hasNext())
              {
                if (!a(l, (oidb_0x8c9.GroupAppUnreadInfo)((Iterator)localObject).next(), paramToServiceMsg, paramObject)) {
                  continue;
                }
                i = 1;
                continue;
              }
              if (QLog.isDevelopLevel()) {
                QLog.i("Q.troopgetnews..troop.notification_center", 4, paramObject.toString());
              }
              if (i == 0) {
                break label408;
              }
              notifyUI(TroopRedDotObserver.f, true, new Object[] { String.valueOf(l), Boolean.valueOf(false), Boolean.valueOf(false) });
              break label408;
            }
            i = paramFromServiceMsg.opt_int32_show_red_point_mobile.get();
            notifyUI(TroopRedDotObserver.e, true, new Object[] { Boolean.valueOf(false), paramToServiceMsg, Integer.valueOf(i) });
            return;
          }
          catch (Exception paramToServiceMsg)
          {
            if (!QLog.isDevelopLevel()) {
              break label407;
            }
          }
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handle_oidb_0x8c9_2|exception = ");
          paramFromServiceMsg.append(paramToServiceMsg.toString());
          QLog.i("Q.troopgetnews..troop.notification_center", 4, paramFromServiceMsg.toString());
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isDevelopLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handle_oidb_0x8c9_2| oidb_sso parseFrom byte ");
          paramFromServiceMsg.append(paramToServiceMsg.toString());
          QLog.d("Q.troopgetnews..troop.notification_center", 4, paramFromServiceMsg.toString());
        }
      }
      return;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      long l = Long.parseLong(paramString);
      ITroopInfoHandler localITroopInfoHandler = (ITroopInfoHandler)this.appRuntime.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopInfoHandlerName());
      byte[] arrayOfByte = localITroopInfoHandler.a(l);
      if (arrayOfByte != null)
      {
        a(paramString, arrayOfByte, paramInt);
        return;
      }
      a(l, paramInt);
      localITroopInfoHandler.a(l, "SUBCMD_GET_TROOP_AUTH_FOR_REDPOINT");
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void a(String paramString, List<Long> paramList, boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("send_oidb_0x8c9_2, troopUin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", appIds : ");
      ((StringBuilder)localObject).append(paramList);
      QLog.i("Q.troopgetnews.", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.appRuntime.getCurrentAccountUin();
    long l2 = -1L;
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        l1 = Long.valueOf((String)localObject).longValue();
        if (paramString == null) {
          continue;
        }
        l2 = Long.valueOf(paramString).longValue();
      }
      catch (Exception paramList)
      {
        continue;
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("myUin error: myUin = ");
        paramList.append((String)localObject);
        paramList.append(", strTroopUin = ");
        paramList.append(paramString);
        QLog.d("Q.troopgetnews.", 2, paramList.toString());
      }
      return;
      paramString = new oidb_0x8c9.ReqBody();
      paramString.opt_uint64_from_uin.set(l1);
      paramString.opt_uint64_group_code.set(l2);
      paramString.rpt_uint64_appid.set(paramList);
      paramList = new oidb_sso.OIDBSSOPkg();
      paramList.uint32_command.set(2249);
      localObject = paramList.uint32_service_type;
      if (paramBoolean) {
        i = 4;
      }
      ((PBUInt32Field)localObject).set(i);
      paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramString.toByteArray()));
      paramString = createToServiceMsg("OidbSvc.0x8c9_2");
      paramString.putWupBuffer(paramList.toByteArray());
      sendPbReq(paramString);
      return;
      long l1 = -1L;
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.a == null)
    {
      this.a = new HashSet();
      this.a.add("OidbSvc.0x8c9_2");
      this.a.add("OidbSvc.0x8ca_2");
    }
    return this.a;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopRedDotObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRedDotHandler", 2, "onReceive,resp == null");
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
        QLog.d("TroopRedDotHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    if (!a().equals(paramToServiceMsg.extraData.getString("REQ_TAG")))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("REQ_TAG doesn't match. cmd:  ");
        paramToServiceMsg.append(str);
        QLog.d("TroopRedDotHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    if ("OidbSvc.0x8c9_2".equals(paramFromServiceMsg.getServiceCmd()))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x8ca_2".equals(paramFromServiceMsg.getServiceCmd())) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopreddot.handler.TroopRedDotHandler
 * JD-Core Version:    0.7.0.1
 */