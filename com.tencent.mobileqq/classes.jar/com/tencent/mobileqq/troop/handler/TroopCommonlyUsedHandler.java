package com.tencent.mobileqq.troop.handler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.api.handler.ITroopCommonlyUsedHandler;
import com.tencent.mobileqq.troop.api.observer.TroopCommonlyUsedObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.ReqBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.RspBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpateResult;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpdateItem;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopCommonlyUsedHandler
  extends TroopBaseHandler
  implements ITroopCommonlyUsedHandler
{
  protected TroopCommonlyUsedHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1;
    int i;
    boolean bool;
    String str2;
    Object localObject;
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      if (!"OidbSvc.0x5d6_1".equals(paramFromServiceMsg.getServiceCmd())) {
        return;
      }
      str1 = paramToServiceMsg.extraData.getString("troopUin");
      i = paramToServiceMsg.extraData.getInt("reqType");
      bool = paramToServiceMsg.extraData.getBoolean("isList");
      str2 = paramToServiceMsg.extraData.getString("troop_delete_top_from_conversation");
      localObject = paramToServiceMsg.extraData.getStringArrayList("key_commonly_used_troop_list");
      if (localObject != null) {
        a((List)localObject, i);
      }
      if (bool)
      {
        localObject = new Object[5];
        localObject[0] = Integer.valueOf(-1);
        localObject[1] = Integer.valueOf(i);
        localObject[2] = null;
        localObject[3] = null;
        localObject[4] = str2;
      }
      else
      {
        localObject = new Object[5];
        localObject[0] = str1;
        localObject[1] = Integer.valueOf(i);
        localObject[2] = Integer.valueOf(-1);
        localObject[3] = null;
        localObject[4] = str2;
      }
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleSetCommonlyUsedTroop ResultCode=");
          paramToServiceMsg.append(paramFromServiceMsg.getResultCode());
          QLog.d("TroopCommonHandler", 4, paramToServiceMsg.toString());
        }
        if (bool) {
          i = TroopCommonlyUsedObserver.c;
        } else {
          i = TroopCommonlyUsedObserver.b;
        }
        notifyUI(i, false, localObject);
        return;
      }
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
      {
        a(paramToServiceMsg, str1, i, bool, str2, localObject, paramFromServiceMsg);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopCommonHandler", 4, "handleSetCommonlyUsedTroop sso empty");
      }
      if (bool) {
        i = TroopCommonlyUsedObserver.c;
      } else {
        i = TroopCommonlyUsedObserver.b;
      }
      notifyUI(i, false, localObject);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      label374:
      break label374;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopCommonHandler", 4, "handleSetCommonlyUsedTroop decode package failed");
    }
    if (bool) {
      i = TroopCommonlyUsedObserver.c;
    } else {
      i = TroopCommonlyUsedObserver.b;
    }
    notifyUI(i, false, localObject);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, String paramString1, int paramInt, boolean paramBoolean, String paramString2, Object paramObject, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    Object localObject = new oidb_0x5d6.RspBody();
    try
    {
      ((oidb_0x5d6.RspBody)localObject).mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      str = ((oidb_0x5d6.RspBody)localObject).str_wording.get();
      int j = paramOIDBSSOPkg.uint32_result.get();
      paramOIDBSSOPkg = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
      localStringBuilder = new StringBuilder("start handleSetCommonlyUsedTroop retCode =");
      localStringBuilder.append(j);
      localStringBuilder.append(" reqType=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" isList=");
      localStringBuilder.append(paramBoolean);
      if (paramBoolean)
      {
        paramString1 = ((oidb_0x5d6.RspBody)localObject).rpt_msg_update_result.get();
        paramToServiceMsg = new HashMap();
        if (paramString1 != null)
        {
          paramString1 = paramString1.iterator();
          while (paramString1.hasNext())
          {
            localObject = (oidb_0x5d6.SnsUpateResult)paramString1.next();
            paramToServiceMsg.put(paramOIDBSSOPkg.getTroopUinByTroopCode(String.valueOf(((oidb_0x5d6.SnsUpateResult)localObject).uint64_uin.get())), Integer.valueOf(((oidb_0x5d6.SnsUpateResult)localObject).uint32_result.get()));
            localStringBuilder.append(" troopUin=");
            localStringBuilder.append(((oidb_0x5d6.SnsUpateResult)localObject).uint64_uin.get());
          }
        }
        notifyUI(TroopCommonlyUsedObserver.c, true, new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt), paramToServiceMsg, str, paramString2 });
        break label456;
      }
      if ((j == 0) && (paramString1 != null))
      {
        if (paramInt == 0)
        {
          paramOIDBSSOPkg.addCommonlyUsedTroop(paramString1, paramToServiceMsg.extraData.getLong("timestamp"));
          i = j;
        }
        else
        {
          i = j;
          if (paramInt == 1)
          {
            paramOIDBSSOPkg.removeCommonlyUsedTroop(paramString1);
            i = j;
          }
        }
      }
      else
      {
        i = j;
        if (j == 1224)
        {
          ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).addLocalSetTopDataIgnore(this.appRuntime, paramString1);
          long l = NetConnInfoCenter.getServerTime();
          if (paramInt == 0) {
            paramOIDBSSOPkg.addCommonlyUsedTroop(paramString1, l);
          } else {
            paramOIDBSSOPkg.removeCommonlyUsedTroop(paramString1);
          }
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        String str;
        StringBuilder localStringBuilder;
        continue;
        int i = 0;
      }
    }
    localStringBuilder.append(" troopUin=");
    localStringBuilder.append(paramString1);
    notifyUI(TroopCommonlyUsedObserver.b, true, new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(i), str, paramString2 });
    label456:
    if (QLog.isColorLevel())
    {
      QLog.d("TroopCommonHandler", 4, localStringBuilder.toString());
      return;
      if (paramBoolean) {
        paramInt = TroopCommonlyUsedObserver.c;
      } else {
        paramInt = TroopCommonlyUsedObserver.b;
      }
      notifyUI(paramInt, false, paramObject);
    }
  }
  
  public long a(String paramString)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      return l;
    }
    catch (Exception paramString)
    {
      label10:
      break label10;
    }
    return 0L;
  }
  
  public void a(String paramString1, int paramInt, @Nullable String paramString2)
  {
    if (!NetworkUtil.isNetworkAvailable(null)) {
      return;
    }
    Object localObject1 = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
    String str = ((ITroopInfoService)localObject1).getTroopUin(paramString1);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setCommonlyUsedTroop, troopCode = ");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(", troopUin = ");
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append(" from");
      ((StringBuilder)localObject2).append(paramString2);
      QLog.d("TroopCommonHandler", 2, ((StringBuilder)localObject2).toString());
    }
    if (((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).isLocalSetTopDataIgnoreContain(this.appRuntime, str))
    {
      l = NetConnInfoCenter.getServerTime();
      if (paramInt == 0) {
        ((ITroopInfoService)localObject1).addCommonlyUsedTroop(str, l);
      } else {
        ((ITroopInfoService)localObject1).removeCommonlyUsedTroop(str);
      }
      notifyUI(TroopCommonlyUsedObserver.b, true, new Object[] { str, Integer.valueOf(paramInt), Integer.valueOf(0), null });
      return;
    }
    Object localObject2 = new oidb_0x5d6.SnsUpdateItem();
    ((oidb_0x5d6.SnsUpdateItem)localObject2).uint32_update_sns_type.set(13569);
    long l = NetConnInfoCenter.getServerTime();
    if (paramInt == 0)
    {
      int i = (byte)(int)(l >> 24 & 0xFF);
      int j = (byte)(int)(l >> 16 & 0xFF);
      int k = (byte)(int)(l >> 8 & 0xFF);
      int m = (byte)(int)(l & 0xFF);
      ((oidb_0x5d6.SnsUpdateItem)localObject2).bytes_value.set(ByteStringMicro.copyFrom(new byte[] { i, j, k, m }));
    }
    localObject1 = new ArrayList();
    ((List)localObject1).add(localObject2);
    localObject2 = new oidb_0x5d6.SnsUpateBuffer();
    ((oidb_0x5d6.SnsUpateBuffer)localObject2).uint64_uin.set(a(paramString1));
    ((oidb_0x5d6.SnsUpateBuffer)localObject2).rpt_msg_sns_update_item.set((List)localObject1);
    paramString1 = new ArrayList();
    paramString1.add(localObject2);
    localObject1 = new oidb_0x5d6.ReqBody();
    ((oidb_0x5d6.ReqBody)localObject1).uint32_domain.set(11);
    ((oidb_0x5d6.ReqBody)localObject1).uint32_seq.set(0);
    ((oidb_0x5d6.ReqBody)localObject1).rpt_msg_update_buffer.set(paramString1);
    paramString1 = new oidb_sso.OIDBSSOPkg();
    paramString1.uint32_command.set(1494);
    paramString1.uint32_result.set(0);
    paramString1.uint32_service_type.set(11);
    paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0x5d6_1");
    ((ToServiceMsg)localObject1).extraData.putString("troopUin", str);
    ((ToServiceMsg)localObject1).extraData.putInt("reqType", paramInt);
    ((ToServiceMsg)localObject1).extraData.putLong("timestamp", l);
    ((ToServiceMsg)localObject1).extraData.putInt("update_sns_type", 13569);
    ((ToServiceMsg)localObject1).extraData.putString("source_from", paramString2);
    ((ToServiceMsg)localObject1).putWupBuffer(paramString1.toByteArray());
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(List<String> paramList, int paramInt)
  {
    Object localObject3 = paramList;
    if ((localObject3 != null) && (paramList.size() != 0))
    {
      ITroopInfoService localITroopInfoService = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
      long l = NetConnInfoCenter.getServerTime();
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = null;
      Object localObject2 = localObject3;
      if (paramList.size() > 20)
      {
        paramList = new ArrayList(((List)localObject3).subList(19, paramList.size()));
        localObject3 = ((List)localObject3).subList(0, 19);
        localObject2 = localObject3;
        localObject1 = paramList;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("troopUinList.size() > 20， troopUinListLeft size :");
          ((StringBuilder)localObject1).append(paramList.size());
          QLog.d("TroopCommonHandler", 2, ((StringBuilder)localObject1).toString());
          localObject1 = paramList;
          localObject2 = localObject3;
        }
      }
      paramList = ((List)localObject2).iterator();
      while (paramList.hasNext())
      {
        localObject2 = (String)paramList.next();
        Object localObject4 = new oidb_0x5d6.SnsUpdateItem();
        ((oidb_0x5d6.SnsUpdateItem)localObject4).uint32_update_sns_type.set(13569);
        if (paramInt == 0)
        {
          int i = (byte)(int)(l >> 24 & 0xFF);
          int j = (byte)(int)(l >> 16 & 0xFF);
          int k = (byte)(int)(l >> 8 & 0xFF);
          int m = (byte)(int)(l & 0xFF);
          ((oidb_0x5d6.SnsUpdateItem)localObject4).bytes_value.set(ByteStringMicro.copyFrom(new byte[] { i, j, k, m }));
        }
        localObject3 = new ArrayList();
        ((List)localObject3).add(localObject4);
        localObject4 = new oidb_0x5d6.SnsUpateBuffer();
        ((oidb_0x5d6.SnsUpateBuffer)localObject4).uint64_uin.set(a(localITroopInfoService.getTroopCodeByTroopUin((String)localObject2)));
        ((oidb_0x5d6.SnsUpateBuffer)localObject4).rpt_msg_sns_update_item.set((List)localObject3);
        localArrayList.add(localObject4);
      }
      paramList = new oidb_0x5d6.ReqBody();
      paramList.uint32_domain.set(11);
      paramList.uint32_seq.set(0);
      paramList.rpt_msg_update_buffer.set(localArrayList);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1494);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(11);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramList.toByteArray()));
      paramList = createToServiceMsg("OidbSvc.0x5d6_1");
      paramList.extraData.putBoolean("isList", true);
      paramList.extraData.putInt("reqType", paramInt);
      paramList.extraData.putLong("timestamp", l);
      paramList.extraData.putInt("update_sns_type", 13569);
      paramList.extraData.putStringArrayList("key_commonly_used_troop_list", (ArrayList)localObject1);
      paramList.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      sendPbReq(paramList);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopCommonHandler", 2, "setCommonlyUsedTroopList， troopUinList is null or empty ...");
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    int j = HttpUtil.getNetWorkType();
    int i = j;
    if (j == -1) {
      i = 2;
    }
    if (i == 0) {
      return false;
    }
    a(paramString, paramInt, null);
    return true;
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x5d6_1");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopCommonlyUsedObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopCommonlyUsedHandler
 * JD-Core Version:    0.7.0.1
 */