package com.tencent.mobileqq.troop.troopgag.api.impl;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.config.TroopGagProcessorConfig;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopModifyHandler;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.troopgag.api.ITroopGagHandler;
import com.tencent.mobileqq.troop.troopgag.api.ITroopGagHandler.GagMemberParam;
import com.tencent.mobileqq.troop.troopgag.api.TroopGagObserver;
import com.tencent.mobileqq.troop.troopgag.data.GagStatus;
import com.tencent.mobileqq.troop.troopgag.data.GagTroopMemberResult;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.groupinfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopGagHandler
  extends TroopBaseHandler
  implements ITroopGagHandler
{
  HashMap<String, Long> a = new HashMap();
  
  public TroopGagHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    TroopGagHandler.2 local2 = new TroopGagHandler.2(this, paramLong1, paramLong2);
    this.appRuntime.addDefaultObservers(local2);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1 = paramToServiceMsg.extraData.getString("troopUin");
    String str2 = paramToServiceMsg.extraData.getString("memberUin");
    long l = paramToServiceMsg.extraData.getLong("timpStamp");
    boolean bool2 = false;
    boolean bool1 = false;
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess())) {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
      {
        if (paramToServiceMsg.uint32_result.get() != 0)
        {
          if (paramToServiceMsg.uint32_result.get() == 10) {
            bool1 = true;
          }
          a(str1, false, l);
          TroopGagProcessorConfig.a().a(this.appRuntime, l, false, bool1);
          return;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("TroopGagHandler", 4, String.format("onRspTroopMember:sUin=%s sMemberUin=%s, succeeded", new Object[] { str1, str2 }));
        }
        a(str1, true, l);
        TroopGagProcessorConfig.a().a(this.appRuntime, l, true, false);
        return;
      }
      a(str1, false, l);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      label228:
      break label228;
    }
    a(str1, false, l);
    TroopGagProcessorConfig.a().a(this.appRuntime, l, false, false);
    return;
    if (QLog.isDevelopLevel()) {
      QLog.e("TroopGagHandler", 4, String.format("onRspTroopMember:sUin %s sMemberUin=%s, failed", new Object[] { str1, str2 }));
    }
    bool1 = bool2;
    if (paramFromServiceMsg.getResultCode() == 10) {
      bool1 = true;
    }
    a(str1, false, l);
    TroopGagProcessorConfig.a().a(this.appRuntime, l, false, bool1);
  }
  
  private void a(String paramString, boolean paramBoolean, long paramLong)
  {
    paramString = new GagStatus(paramString, new GagTroopMemberResult(paramBoolean, paramLong));
    paramString.h = 3;
    a(paramString);
  }
  
  private void b(String paramString)
  {
    paramString = new TroopGagHandler.1(this, paramString);
    this.appRuntime.addDefaultObservers(paramString);
  }
  
  public void a(GagStatus paramGagStatus)
  {
    notifyUI(TroopGagObserver.b, true, paramGagStatus);
  }
  
  public void a(String paramString)
  {
    long l;
    if (this.a.get(paramString) == null) {
      l = 0L;
    } else {
      l = ((Long)this.a.get(paramString)).longValue();
    }
    if ((l != 0L) && (System.currentTimeMillis() - l < 1800000L)) {
      return;
    }
    this.a.put(paramString, Long.valueOf(System.currentTimeMillis()));
    b(paramString);
    oidb_0x88d.GroupInfo localGroupInfo = new oidb_0x88d.GroupInfo();
    localGroupInfo.uint32_shutup_timestamp.set(0);
    localGroupInfo.uint32_shutup_timestamp_me.set(0);
    ITroopInfoHandler localITroopInfoHandler = (ITroopInfoHandler)this.appRuntime.getBusinessHandler(TroopInfoHandler.class.getName());
    try
    {
      localITroopInfoHandler.a(Long.valueOf(Long.parseLong(paramString)), localGroupInfo, "SUBCMD_GET_TROOP_GAG");
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagHandler", 4, String.format("doGagTroop : sUin = %s", new Object[] { paramString }));
    }
    try
    {
      long l = Long.parseLong(paramString);
      a(l, paramLong);
      oidb_0x89a.groupinfo localgroupinfo = new oidb_0x89a.groupinfo();
      localgroupinfo.uint32_shutup_time.set((int)paramLong);
      Bundle localBundle = new Bundle();
      localBundle.putString("troopUin", paramString);
      localBundle.putLong("timpStamp", paramLong);
      ((ITroopModifyHandler)this.appRuntime.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopModifyHandlerName())).a(l, localgroupinfo, "SUBCMD_SET_GAG_TROOP");
      return;
    }
    catch (Exception paramString) {}
  }
  
  public final void a(String paramString, ArrayList<ITroopGagHandler.GagMemberParam> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagHandler", 4, String.format("gagTroopMember:sUin=%s ", new Object[] { paramString }));
      }
      String str = "";
      int i = 0;
      Object localObject2;
      while (i < paramArrayList.size())
      {
        localObject1 = (ITroopGagHandler.GagMemberParam)paramArrayList.get(i);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(((ITroopGagHandler.GagMemberParam)localObject1).a);
        ((StringBuilder)localObject2).append(((ITroopGagHandler.GagMemberParam)localObject1).b);
        ((StringBuilder)localObject2).append("|");
        str = ((StringBuilder)localObject2).toString();
        i += 1;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagHandler", 4, String.format("doGagTroopMember:sUin=%s sMemberUins=%s", new Object[] { paramString, str }));
      }
      Object localObject1 = ByteBuffer.allocate(paramArrayList.size() * 8 + 7);
      ((ByteBuffer)localObject1).putInt((int)Long.valueOf(paramString).longValue());
      ((ByteBuffer)localObject1).put((byte)32);
      ((ByteBuffer)localObject1).putShort((short)paramArrayList.size());
      long l = 0L;
      str = null;
      i = 0;
      while (i < paramArrayList.size())
      {
        localObject2 = (ITroopGagHandler.GagMemberParam)paramArrayList.get(i);
        ((ByteBuffer)localObject1).putInt((int)Long.valueOf(((ITroopGagHandler.GagMemberParam)localObject2).a).longValue());
        ((ByteBuffer)localObject1).putInt((int)((ITroopGagHandler.GagMemberParam)localObject2).b);
        str = ((ITroopGagHandler.GagMemberParam)localObject2).a;
        l = ((ITroopGagHandler.GagMemberParam)localObject2).b;
        i += 1;
      }
      localObject1 = ((ByteBuffer)localObject1).array();
      paramArrayList = new oidb_sso.OIDBSSOPkg();
      paramArrayList.uint32_command.set(1392);
      paramArrayList.uint32_result.set(0);
      paramArrayList.uint32_service_type.set(8);
      paramArrayList.bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject1));
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("troopUin", paramString);
      ((Bundle)localObject1).putString("memberUin", str);
      ((Bundle)localObject1).putLong("timpStamp", l);
      paramString = new ToServiceMsg("mobileqq.service", this.appRuntime.getCurrentAccountUin(), "OidbSvc.0x570_8");
      paramString.putWupBuffer(paramArrayList.toByteArray());
      paramString.extraData = ((Bundle)localObject1);
      sendPbReq(paramString);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.e("TroopGagHandler", 4, String.format("doGagTroopMember:sUin=%s, empty arList error", new Object[] { paramString }));
    }
  }
  
  protected String dv_()
  {
    return "TroopGagHandler";
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x570_8");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopGagObserver.class;
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
          QLog.d("TroopGagHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if (!dv_().equals(paramToServiceMsg.extraData.getString("REQ_TAG")))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("REQ_TAG doesn't match. cmd:  ");
          paramToServiceMsg.append(str);
          QLog.d("TroopGagHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("OidbSvc.0x570_8".equals(paramFromServiceMsg.getServiceCmd())) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGagHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgag.api.impl.TroopGagHandler
 * JD-Core Version:    0.7.0.1
 */