package com.tencent.mobileqq.troop.showexternal.api.impl;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.IBizTroopInfoService;
import com.tencent.mobileqq.troop.data.ShowExternalTroop;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.showexternal.api.ITroopShowExternalHandler;
import com.tencent.mobileqq.troop.showexternal.api.TroopShowExternalObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.ReqBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.RspBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpdateItem;
import tencent.im.oidb.cmd0x8b4.GroupInfo;
import tencent.im.oidb.cmd0x8b4.ReqBody;
import tencent.im.oidb.cmd0x8b4.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopShowExternalHandler
  extends TroopBaseHandler
  implements ITroopShowExternalHandler
{
  public TroopShowExternalHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopShowExternalHandler", 2, "handle0x8b4Rsp");
    }
    Object localObject;
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      if (paramFromServiceMsg.getResultCode() != 1000) {
        bool = false;
      } else {
        bool = true;
      }
      localObject = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
      localObject = localOIDBSSOPkg;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      label75:
      int i;
      break label75;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopShowExternalHandler", 2, "handle0x8b4Rsp InvalidProtocolBufferMicroException");
    }
    boolean bool = false;
    if (localObject == null) {
      return;
    }
    if ((((oidb_sso.OIDBSSOPkg)localObject).uint32_result.has()) && (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) && (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() != null)) {
      break label140;
    }
    bool = false;
    label140:
    i = ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.get();
    if (i != 0)
    {
      if (i != 2)
      {
        if (i != 4) {
          return;
        }
        c(bool, paramToServiceMsg, paramFromServiceMsg, (oidb_sso.OIDBSSOPkg)localObject, paramObject);
        return;
      }
      b(bool, paramToServiceMsg, paramFromServiceMsg, (oidb_sso.OIDBSSOPkg)localObject, paramObject);
      return;
    }
    a(bool, paramToServiceMsg, paramFromServiceMsg, (oidb_sso.OIDBSSOPkg)localObject, paramObject);
  }
  
  private void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopShowExternalHandler", 2, "handleSwitchTroopShowExStatusRsp");
    }
    String str = paramToServiceMsg.extraData.getString("troop_uin");
    paramObject = new Object[3];
    paramObject[0] = str;
    paramObject[1] = Integer.valueOf(paramFromServiceMsg.getResultCode());
    paramObject[2] = Integer.valueOf(-1);
    if ((!paramBoolean) || (paramOIDBSSOPkg == null)) {
      notifyUI(TroopShowExternalObserver.c, false, paramObject);
    }
    if (!"getShowEternalStatus".equals(paramToServiceMsg.extraData.getString("0x8d4_cmd_key"))) {
      return;
    }
    paramToServiceMsg = new cmd0x8b4.RspBody();
    try
    {
      paramToServiceMsg.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      if ((!paramFromServiceMsg.isSuccess()) || (paramToServiceMsg.uint32_result.get() != 0)) {
        break label203;
      }
      notifyUI(TroopShowExternalObserver.c, true, new Object[] { str, Integer.valueOf(paramToServiceMsg.uint32_result.get()), Integer.valueOf(paramToServiceMsg.uint32_flag.get()) });
      if (paramToServiceMsg.uint32_flag.get() != 1) {
        break label229;
      }
      paramBoolean = true;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        continue;
        paramBoolean = false;
      }
    }
    a(null, str, paramBoolean, true);
    return;
    label203:
    notifyUI(TroopShowExternalObserver.c, false, paramObject);
    return;
    notifyUI(TroopShowExternalObserver.c, false, paramObject);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str;
    int j;
    long l;
    Object localObject;
    int i;
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg;
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      str = paramToServiceMsg.extraData.getString("troop_uin");
      j = paramToServiceMsg.extraData.getInt("reqType");
      l = paramToServiceMsg.extraData.getLong("timestamp");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder("handleSwitchTroopShowExStatusAfterJoinedTroopRsp, handle response begin==>");
        ((StringBuilder)localObject).append("isSuccess:");
        ((StringBuilder)localObject).append(paramFromServiceMsg.isSuccess());
        ((StringBuilder)localObject).append("|ssoSeq:");
        ((StringBuilder)localObject).append(paramFromServiceMsg.getRequestSsoSeq());
        ((StringBuilder)localObject).append("|ServiceCmd:");
        ((StringBuilder)localObject).append(paramToServiceMsg.getServiceCmd());
        ((StringBuilder)localObject).append("|troopUin:");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("|reqType:");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append("|timestamp:");
        ((StringBuilder)localObject).append(l);
        QLog.d("TroopShowExternalHandler.troop.set_show_external_status", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new Object[4];
      localObject[0] = str;
      localObject[1] = Integer.valueOf(j);
      localObject[2] = Integer.valueOf(paramFromServiceMsg.getResultCode());
      if (j == 1) {
        i = 0;
      } else {
        i = 1;
      }
      localObject[3] = Integer.valueOf(i);
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        notifyUI(TroopShowExternalObserver.b, false, localObject);
        return;
      }
      localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramObject = (oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.mergeFrom((byte[])paramObject);
      if ((paramObject != null) && (paramObject.uint32_result.has()) && (paramObject.bytes_bodybuffer.has()) && (paramObject.bytes_bodybuffer.get() != null))
      {
        if (!"setShowExternalStatus0x5d6".equals(paramToServiceMsg.extraData.getString("0x5d6_cmd_key"))) {
          return;
        }
        paramToServiceMsg = new oidb_0x5d6.RspBody();
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      label449:
      label471:
      break label471;
    }
    try
    {
      paramToServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
      paramToServiceMsg = (IBizTroopInfoService)this.appRuntime.getRuntimeService(IBizTroopInfoService.class, "");
      if (j == 1) {
        paramToServiceMsg.addShowExternalTroop(str, l);
      } else if (j == 0) {
        paramToServiceMsg.removeShowExternalTroop(str);
      }
      i = paramFromServiceMsg.getResultCode();
      notifyUI(TroopShowExternalObserver.b, true, new Object[] { str, Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(j) });
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      break label449;
    }
    notifyUI(TroopShowExternalObserver.b, false, localObject);
    return;
    notifyUI(TroopShowExternalObserver.b, false, localObject);
    return;
    notifyUI(TroopShowExternalObserver.b, false, localObject);
  }
  
  private void b(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, Object paramObject)
  {
    paramObject = paramToServiceMsg.extraData.getString("troop_uin");
    int j = paramToServiceMsg.extraData.getInt("reqType");
    long l = paramToServiceMsg.extraData.getLong("timestamp");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("handleSwitchTroopShowExStatusBeforeJoinedTroopRsp, handle response begin==>");
      ((StringBuilder)localObject).append("isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("|ssoSeq:");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getRequestSsoSeq());
      ((StringBuilder)localObject).append("|ServiceCmd:");
      ((StringBuilder)localObject).append(paramToServiceMsg.getServiceCmd());
      ((StringBuilder)localObject).append("|troopUin:");
      ((StringBuilder)localObject).append(paramObject);
      ((StringBuilder)localObject).append("|reqType:");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append("|timestamp:");
      ((StringBuilder)localObject).append(l);
      QLog.d("TroopShowExternalHandler.troop.set_show_external_status", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Object[4];
    localObject[0] = paramObject;
    localObject[1] = Integer.valueOf(j);
    localObject[2] = Integer.valueOf(paramFromServiceMsg.getResultCode());
    int i;
    if (j == 1) {
      i = 0;
    } else {
      i = 1;
    }
    localObject[3] = Integer.valueOf(i);
    if ((!paramBoolean) || (paramOIDBSSOPkg == null)) {
      notifyUI(TroopShowExternalObserver.b, false, localObject);
    }
    if (!"setShowExternalStatus0x8d4".equals(paramToServiceMsg.extraData.getString("0x8d4_cmd_key"))) {
      return;
    }
    paramToServiceMsg = new cmd0x8b4.RspBody();
    try
    {
      paramToServiceMsg.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      if ((paramFromServiceMsg.isSuccess()) && (paramToServiceMsg.uint32_result.get() == 0))
      {
        notifyUI(TroopShowExternalObserver.b, true, new Object[] { paramObject, Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(paramToServiceMsg.uint32_flag.get()) });
        return;
      }
      notifyUI(TroopShowExternalObserver.b, false, localObject);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      label351:
      break label351;
    }
    notifyUI(TroopShowExternalObserver.b, false, localObject);
  }
  
  private void c(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopShowExternalHandler", 2, "handleGetShowExtTroopListRsp");
    }
    StringBuilder localStringBuilder;
    Object localObject1;
    if ((paramBoolean) && (paramOIDBSSOPkg != null))
    {
      paramObject = paramToServiceMsg.extraData.getString("target_uin");
      localStringBuilder = new StringBuilder();
      localObject1 = new cmd0x8b4.RspBody();
    }
    try
    {
      ((cmd0x8b4.RspBody)localObject1).mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      paramOIDBSSOPkg = new Object[2];
      paramOIDBSSOPkg[0] = Integer.valueOf(((cmd0x8b4.RspBody)localObject1).uint32_result.get());
      paramOIDBSSOPkg[1] = null;
      if ((paramFromServiceMsg.isSuccess()) && (((cmd0x8b4.RspBody)localObject1).uint32_result.get() == 0))
      {
        if (!((cmd0x8b4.RspBody)localObject1).rpt_group_info.has())
        {
          notifyUI(TroopShowExternalObserver.a, paramBoolean, paramOIDBSSOPkg);
          return;
        }
        paramOIDBSSOPkg = new ArrayList();
        Object localObject2 = ((cmd0x8b4.RspBody)localObject1).rpt_group_info.get();
        localStringBuilder.append("groupInfoList size:");
        localStringBuilder.append(((List)localObject2).size());
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          cmd0x8b4.GroupInfo localGroupInfo = (cmd0x8b4.GroupInfo)((Iterator)localObject2).next();
          paramOIDBSSOPkg.add(new ShowExternalTroop(localGroupInfo));
          localStringBuilder.append("[uint64_gc:");
          localStringBuilder.append(localGroupInfo.uint64_gc.get());
          localStringBuilder.append(",addedTimestamp:");
          localStringBuilder.append(localGroupInfo.uint32_set_display_time.get());
          localStringBuilder.append("], ");
        }
        localObject1 = ((cmd0x8b4.RspBody)localObject1).bytes_text_label.get();
        localObject2 = new ArrayList();
        int i = 0;
        while (i < ((List)localObject1).size())
        {
          ((List)localObject2).add(((ByteStringMicro)((List)localObject1).get(i)).toStringUtf8());
          i += 1;
        }
        notifyUI(TroopShowExternalObserver.a, paramBoolean, new Object[] { Integer.valueOf(0), paramOIDBSSOPkg, localObject2 });
      }
      else
      {
        notifyUI(TroopShowExternalObserver.a, paramBoolean, paramOIDBSSOPkg);
      }
    }
    catch (InvalidProtocolBufferMicroException paramOIDBSSOPkg)
    {
      break label408;
    }
    catch (NullPointerException paramOIDBSSOPkg)
    {
      label396:
      break label396;
    }
    notifyUI(TroopShowExternalObserver.a, paramBoolean, null);
    break label417;
    label408:
    notifyUI(TroopShowExternalObserver.a, paramBoolean, null);
    label417:
    if (QLog.isColorLevel())
    {
      paramOIDBSSOPkg = new StringBuilder("handleGetShowExtTroopListRsp, handle rsp begin==>");
      paramOIDBSSOPkg.append("|ssoSeq:");
      paramOIDBSSOPkg.append(paramFromServiceMsg.getRequestSsoSeq());
      paramOIDBSSOPkg.append("|ServiceCmd:");
      paramOIDBSSOPkg.append(paramToServiceMsg.getServiceCmd());
      paramOIDBSSOPkg.append("|destUin:");
      paramOIDBSSOPkg.append(paramObject);
      paramOIDBSSOPkg.append("|seTroopArray:");
      paramOIDBSSOPkg.append(localStringBuilder.toString());
      QLog.d("TroopShowExternalHandler.troop.get_show_external_troop_list", 2, paramOIDBSSOPkg.toString());
    }
    return;
    notifyUI(TroopShowExternalObserver.a, paramBoolean, null);
  }
  
  protected String a()
  {
    return "TroopShowExternalHandler";
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopShowExternalHandler", 2, "getShowExternalTroopList destUin is null");
      }
      return;
    }
    label268:
    try
    {
      paramString = paramString.trim();
      long l = Long.parseLong(paramString);
      if (l == 0L) {
        return;
      }
      Object localObject2 = new cmd0x8b4.ReqBody();
      ((cmd0x8b4.ReqBody)localObject2).uint64_dst_uin.set(l);
      ((cmd0x8b4.ReqBody)localObject2).uint32_start.set(paramInt1);
      ((cmd0x8b4.ReqBody)localObject2).uint32_cnt.set(paramInt2);
      Object localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2228);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x8b4.ReqBody)localObject2).toByteArray()));
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(4);
      localObject2 = createToServiceMsg("OidbSvc.0x8b4");
      ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      ((ToServiceMsg)localObject2).extraData.putString("0x8d4_cmd_key", "setShowExternalStatus0x8d4");
      ((ToServiceMsg)localObject2).extraData.putString("target_uin", paramString);
      sendPbReq((ToServiceMsg)localObject2);
      if (!QLog.isColorLevel()) {
        break label268;
      }
      localObject1 = new StringBuilder("getShowExternalTroopList, request begin==>");
      ((StringBuilder)localObject1).append("|ssoSeq:");
      ((StringBuilder)localObject1).append(((ToServiceMsg)localObject2).getRequestSsoSeq());
      ((StringBuilder)localObject1).append("|ServiceCmd:");
      ((StringBuilder)localObject1).append(((ToServiceMsg)localObject2).getServiceCmd());
      ((StringBuilder)localObject1).append("|destUin:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("TroopShowExternalHandler", 2, ((StringBuilder)localObject1).toString());
      return;
    }
    catch (NumberFormatException paramString)
    {
      label253:
      break label253;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopShowExternalHandler", 2, "NumberFormatException");
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString2 == null) {
      return;
    }
    try
    {
      String str = paramString2.trim();
      long l1 = Long.parseLong(str);
      int j = 1;
      int i;
      Object localObject;
      if (paramBoolean2)
      {
        paramString1 = new cmd0x8b4.ReqBody();
        paramString1.uint64_gc.set(l1);
        paramString2 = paramString1.uint32_flag;
        if (paramBoolean1 == true) {
          i = 1;
        } else {
          i = 0;
        }
        paramString2.set(i);
        paramString2 = new oidb_sso.OIDBSSOPkg();
        paramString2.uint32_command.set(2228);
        paramString2.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
        paramString2.uint32_service_type.set(2);
        paramString1 = createToServiceMsg("OidbSvc.0x8b4");
        paramString1.putWupBuffer(paramString2.toByteArray());
        paramString1.extraData.putString("0x8d4_cmd_key", "setShowExternalStatus0x8d4");
        paramString2 = paramString1.extraData;
        if (paramBoolean1 == true) {
          i = j;
        } else {
          i = 0;
        }
        paramString2.putInt("reqType", i);
        paramString1.extraData.putString("troop_uin", str);
        sendPbReq(paramString1);
      }
      else
      {
        if (paramString1 == null) {
          return;
        }
        paramString1 = new oidb_0x5d6.SnsUpdateItem();
        paramString1.uint32_update_sns_type.set(13571);
        long l2 = NetConnInfoCenter.getServerTime();
        paramString2 = new byte[5];
        if (paramBoolean1) {
          paramString2[0] = 1;
        } else {
          paramString2[0] = 0;
        }
        paramString2[1] = ((byte)(int)(l2 >> 24 & 0xFF));
        paramString2[2] = ((byte)(int)(l2 >> 16 & 0xFF));
        paramString2[3] = ((byte)(int)(l2 >> 8 & 0xFF));
        paramString2[4] = ((byte)(int)(l2 & 0xFF));
        paramString1.uint32_value_offset.set(1);
        paramString1.bytes_value.set(ByteStringMicro.copyFrom(paramString2));
        paramString2 = new ArrayList();
        paramString2.add(paramString1);
        paramString1 = new oidb_0x5d6.SnsUpateBuffer();
        paramString1.uint64_uin.set(l1);
        paramString1.rpt_msg_sns_update_item.set(paramString2);
        paramString2 = new ArrayList();
        paramString2.add(paramString1);
        paramString1 = new oidb_0x5d6.ReqBody();
        paramString1.uint32_domain.set(11);
        paramString1.uint32_seq.set(0);
        paramString1.rpt_msg_update_buffer.set(paramString2);
        paramString2 = new oidb_sso.OIDBSSOPkg();
        paramString2.uint32_command.set(1494);
        paramString2.uint32_result.set(0);
        paramString2.uint32_service_type.set(3);
        paramString2.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
        paramString1 = createToServiceMsg("OidbSvc.0x5d6_3");
        paramString1.extraData.putString("0x5d6_cmd_key", "setShowExternalStatus0x5d6");
        paramString1.extraData.putString("troop_uin", str);
        localObject = paramString1.extraData;
        i = 1;
        if (paramBoolean1 != true) {
          i = 0;
        }
        ((Bundle)localObject).putInt("reqType", i);
        paramString1.extraData.putLong("timestamp", l2);
        paramString1.putWupBuffer(paramString2.toByteArray());
        sendPbReq(paramString1);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder("switchTroopShowExternalStatus, requset begin==>");
        localStringBuilder.append("ssoSeq:");
        localObject = "null";
        if (paramString1 == null) {
          paramString2 = "null";
        } else {
          paramString2 = Integer.valueOf(paramString1.getRequestSsoSeq());
        }
        localStringBuilder.append(paramString2);
        localStringBuilder.append("|ServiceCmd:");
        if (paramString1 == null) {
          paramString1 = (String)localObject;
        } else {
          paramString1 = paramString1.getServiceCmd();
        }
        localStringBuilder.append(paramString1);
        localStringBuilder.append("|beforeJoinedTroop:");
        localStringBuilder.append(paramBoolean2);
        localStringBuilder.append("|troopUin:");
        localStringBuilder.append(str);
        localStringBuilder.append("|reqType:");
        localStringBuilder.append(paramBoolean1);
        localStringBuilder.append("|timestamp:");
        localStringBuilder.append(NetConnInfoCenter.getServerTime());
        QLog.d("TroopShowExternalHandler", 2, localStringBuilder.toString());
      }
      return;
    }
    catch (NumberFormatException paramString1)
    {
      label687:
      break label687;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopShowExternalHandler", 2, "NumberFormatException");
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x8b4");
      this.allowCmdSet.add("OidbSvc.0x5d6_3");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopShowExternalObserver.class;
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
          QLog.d("TroopShowExternalHandler", 2, paramToServiceMsg.toString());
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
          QLog.d("TroopShowExternalHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("OidbSvc.0x8b4".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5d6_3".equals(paramFromServiceMsg.getServiceCmd())) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopShowExternalHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.showexternal.api.impl.TroopShowExternalHandler
 * JD-Core Version:    0.7.0.1
 */