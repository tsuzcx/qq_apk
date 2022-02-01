package com.tencent.mobileqq.troop.handler;

import KQQ.BatchResponse;
import KQQ.RespBatchProcess;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.config.TroopBatchInfoHandlerProcessorConfig;
import com.tencent.mobileqq.troop.api.handler.ITroopBatchInfohandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopBatchInfoHandler
  extends TroopBaseHandler
  implements ITroopBatchInfohandler
{
  public TroopBatchInfoHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(long paramLong, RespBatchProcess paramRespBatchProcess, TroopInfo paramTroopInfo)
  {
    int j = paramRespBatchProcess.batch_response_list.size();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleGetTroopCreditInfo, batch_response_list.size:");
      ((StringBuilder)localObject).append(j);
      QLog.i("troop.credit.data", 2, ((StringBuilder)localObject).toString());
    }
    int i = 0;
    while (i < j)
    {
      localObject = (BatchResponse)paramRespBatchProcess.batch_response_list.get(i);
      if ((localObject != null) && (((BatchResponse)localObject).result == 0) && (((BatchResponse)localObject).type == 1)) {
        a((BatchResponse)localObject, paramTroopInfo);
      }
      i += 1;
    }
    paramRespBatchProcess = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
    if (QLog.isColorLevel()) {
      QLog.i("troop.credit.data", 2, "handleGetTroopCreditInfo, save");
    }
    paramRespBatchProcess.saveTroopInfo(paramTroopInfo);
    notifyUI(TroopObserver.TYPE_GET_TROOP_CREDIT_INFO, true, Long.valueOf(paramLong));
  }
  
  private void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, TroopInfo paramTroopInfo, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if (paramGroupInfo.uint32_group_class_ext.has()) {
      paramTroopInfo.dwGroupClassExt = paramGroupInfo.uint32_group_class_ext.get();
    }
    if (paramGroupInfo.string_group_class_text.has()) {
      paramTroopInfo.mGroupClassExtText = paramGroupInfo.string_group_class_text.get().toStringUtf8();
    }
    Object localObject;
    if (paramGroupInfo.string_group_name.has())
    {
      localObject = paramGroupInfo.string_group_name.get().toStringUtf8();
      if (TextUtils.isEmpty(paramTroopInfo.newTroopName))
      {
        paramTroopInfo.troopname = ((String)localObject);
      }
      else if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleGetTroopClassType:");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(paramBoolean1);
        ((StringBuilder)localObject).append("already set long troop name do nothing");
        QLog.d("TroopBatchInfoHandler", 2, ((StringBuilder)localObject).toString());
      }
    }
    if (paramGroupInfo.uint64_group_owner.has())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramGroupInfo.uint64_group_owner.get());
      paramTroopInfo.troopowneruin = ((StringBuilder)localObject).toString();
    }
    if (paramGroupInfo.uint32_group_face.has()) {
      paramTroopInfo.troopface = ((short)paramGroupInfo.uint32_group_face.get());
    }
    if (paramGroupInfo.uint32_group_member_num.has())
    {
      paramTroopInfo.wMemberNum = paramGroupInfo.uint32_group_member_num.get();
      paramTroopInfo.wMemberNumClient = paramTroopInfo.wMemberNum;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleGetTroopClassType wMemberNumClient:");
        ((StringBuilder)localObject).append(paramTroopInfo.wMemberNumClient);
        ((StringBuilder)localObject).append("  wMemberNum:");
        ((StringBuilder)localObject).append(paramTroopInfo.wMemberNum);
        ((StringBuilder)localObject).append(" troopUin:");
        ((StringBuilder)localObject).append(paramTroopInfo.troopuin);
        QLog.d("TroopBatchInfoHandler", 2, ((StringBuilder)localObject).toString());
      }
    }
    if (paramGroupInfo.uint32_is_conf_group.has())
    {
      int i = paramGroupInfo.uint32_is_conf_group.get();
      boolean bool = false;
      if (i == 1) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      }
      paramTroopInfo.isNewTroop = paramBoolean1;
      if (paramGroupInfo.uint32_is_modify_conf_group_face.get() == 1) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      }
      paramTroopInfo.hasSetNewTroopHead = paramBoolean1;
      paramBoolean1 = bool;
      if (paramGroupInfo.uint32_is_modify_conf_group_name.get() == 1) {
        paramBoolean1 = true;
      }
      paramTroopInfo.hasSetNewTroopName = paramBoolean1;
    }
    if (paramGroupInfo.uint64_subscription_uin.has()) {
      paramTroopInfo.associatePubAccount = paramGroupInfo.uint64_subscription_uin.get();
    }
    if (QLog.isColorLevel())
    {
      paramGroupInfo = new StringBuilder();
      paramGroupInfo.append("handleGetTroopClassType:");
      paramGroupInfo.append(paramLong);
      paramGroupInfo.append(",");
      paramGroupInfo.append(paramTroopInfo.associatePubAccount);
      QLog.d("TroopBatchInfoHandler", 2, paramGroupInfo.toString());
    }
    if (paramBoolean2)
    {
      paramGroupInfo = (IMessageFacade)this.appRuntime.getRuntimeService(IMessageFacade.class, "");
      if (paramGroupInfo != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append("");
        paramGroupInfo.pullRecentGroupMsg(((StringBuilder)localObject).toString());
      }
      if (paramTroopInfo != null) {
        TroopBatchInfoHandlerProcessorConfig.a().a(this.appRuntime, paramTroopInfo);
      }
    }
  }
  
  private void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, TroopInfo paramTroopInfo, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    if ((paramOIDBSSOPkg != null) && (paramOIDBSSOPkg.bytes_bodybuffer.has()))
    {
      Object localObject = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
      try
      {
        paramOIDBSSOPkg = new oidb_0x88d.RspBody();
        paramOIDBSSOPkg.mergeFrom((byte[])localObject);
        localObject = null;
        List localList = paramOIDBSSOPkg.stzrspgroupinfo.get();
        int j = 0;
        int i;
        if (localList == null) {
          i = 0;
        } else {
          i = localList.size();
        }
        while ((localObject == null) && (j < i))
        {
          oidb_0x88d.RspGroupInfo localRspGroupInfo = (oidb_0x88d.RspGroupInfo)localList.get(j);
          if (localRspGroupInfo == null)
          {
            paramOIDBSSOPkg = (oidb_sso.OIDBSSOPkg)localObject;
          }
          else
          {
            paramOIDBSSOPkg = (oidb_sso.OIDBSSOPkg)localObject;
            if (localRspGroupInfo.uint32_result.get() == 0)
            {
              paramOIDBSSOPkg = (oidb_sso.OIDBSSOPkg)localObject;
              if (localRspGroupInfo.stgroupinfo.has())
              {
                localObject = (oidb_0x88d.GroupInfo)localRspGroupInfo.stgroupinfo.get();
                paramOIDBSSOPkg = (oidb_sso.OIDBSSOPkg)localObject;
                if (localObject != null)
                {
                  a(paramLong, paramBoolean1, paramBoolean2, paramTroopInfo, (oidb_0x88d.GroupInfo)localObject);
                  paramOIDBSSOPkg = (oidb_sso.OIDBSSOPkg)localObject;
                }
              }
            }
          }
          j += 1;
          localObject = paramOIDBSSOPkg;
        }
        return;
      }
      catch (Exception paramTroopInfo)
      {
        if (QLog.isColorLevel())
        {
          paramOIDBSSOPkg = new StringBuilder();
          paramOIDBSSOPkg.append("handleGetTroopClassType:");
          paramOIDBSSOPkg.append(paramTroopInfo.toString());
          QLog.d("TroopBatchInfoHandler", 2, paramOIDBSSOPkg.toString());
        }
        paramTroopInfo.printStackTrace();
      }
    }
  }
  
  private void a(BatchResponse paramBatchResponse, TroopInfo paramTroopInfo)
  {
    Object localObject = new oidb_sso.OIDBSSOPkg();
    for (;;)
    {
      int j;
      try
      {
        ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramBatchResponse.buffer);
        int k;
        if (paramBatchResponse.seq == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("troop.credit.data", 2, "handleGetTroopCreditInfo, batchResp:0X88D");
          }
          if (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has())
          {
            paramBatchResponse = ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray();
            try
            {
              localObject = new oidb_0x88d.RspBody();
              ((oidb_0x88d.RspBody)localObject).mergeFrom(paramBatchResponse);
              paramBatchResponse = null;
              List localList = ((oidb_0x88d.RspBody)localObject).stzrspgroupinfo.get();
              j = 0;
              int i;
              if (localList == null) {
                i = 0;
              } else {
                i = localList.size();
              }
              if ((paramBatchResponse == null) && (j < i))
              {
                oidb_0x88d.RspGroupInfo localRspGroupInfo = (oidb_0x88d.RspGroupInfo)localList.get(j);
                if (localRspGroupInfo == null)
                {
                  localObject = paramBatchResponse;
                }
                else
                {
                  k = localRspGroupInfo.uint32_result.get();
                  if (!QLog.isColorLevel()) {
                    break label495;
                  }
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("handleGetTroopCreditInfo, 0X88D ret:");
                  ((StringBuilder)localObject).append(k);
                  QLog.i("troop.credit.data", 2, ((StringBuilder)localObject).toString());
                  break label495;
                  localObject = paramBatchResponse;
                  if (k == 0)
                  {
                    localObject = paramBatchResponse;
                    if (localRspGroupInfo.stgroupinfo.has())
                    {
                      paramBatchResponse = (oidb_0x88d.GroupInfo)localRspGroupInfo.stgroupinfo.get();
                      localObject = paramBatchResponse;
                      if (paramBatchResponse != null)
                      {
                        if (paramBatchResponse.uint32_group_sec_level.has()) {
                          paramTroopInfo.troopCreditLevel = paramBatchResponse.uint32_group_sec_level.get();
                        }
                        if (paramBatchResponse.uint32_group_sec_level_info.has()) {
                          paramTroopInfo.troopCreditLevelInfo = paramBatchResponse.uint32_group_sec_level_info.get();
                        }
                        localObject = paramBatchResponse;
                        if (QLog.isColorLevel())
                        {
                          localObject = new StringBuilder();
                          ((StringBuilder)localObject).append("handleGetTroopCreditInfo after 0x88d:");
                          ((StringBuilder)localObject).append(paramTroopInfo.troopname);
                          ((StringBuilder)localObject).append(",");
                          ((StringBuilder)localObject).append(paramTroopInfo.troopuin);
                          ((StringBuilder)localObject).append(",");
                          ((StringBuilder)localObject).append(paramTroopInfo.troopCreditLevel);
                          ((StringBuilder)localObject).append(",");
                          ((StringBuilder)localObject).append(paramTroopInfo.troopCreditLevelInfo);
                          QLog.i("troop.credit.data", 2, ((StringBuilder)localObject).toString());
                          localObject = paramBatchResponse;
                        }
                      }
                    }
                  }
                }
                j += 1;
                paramBatchResponse = (BatchResponse)localObject;
              }
              else
              {
                return;
              }
            }
            catch (Exception paramBatchResponse)
            {
              if (QLog.isColorLevel())
              {
                paramTroopInfo = new StringBuilder();
                paramTroopInfo.append("handleGetTroopCreditInfo, 0X88D:");
                paramTroopInfo.append(paramBatchResponse.toString());
                QLog.e("troop.credit.data", 2, paramTroopInfo.toString());
              }
            }
          }
        }
        if (k != 72) {
          continue;
        }
      }
      catch (Exception paramBatchResponse)
      {
        if (QLog.isColorLevel())
        {
          paramTroopInfo = new StringBuilder();
          paramTroopInfo.append("handleGetTroopCreditInfo:");
          paramTroopInfo.append(paramBatchResponse.toString());
          QLog.e("troop.credit.data", 2, paramTroopInfo.toString());
        }
        return;
      }
      label495:
      if (j == 0) {
        localObject = paramBatchResponse;
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("ProfileService.ReqBatchProcess");
    localToServiceMsg.extraData.putLong("troop_code", paramLong);
    localToServiceMsg.extraData.putBoolean("is_admin", paramBoolean);
    localToServiceMsg.extraData.putInt("from", paramInt);
    send(localToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("param_get_credit_info", false);
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("param_get_troop_class_type", false);
    long l = paramToServiceMsg.extraData.getLong("troop_code");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleBatchGetTroopInfo, isTroopCreditLevelReq:");
      localStringBuilder.append(bool1);
      localStringBuilder.append(",reqTroopCode = ");
      localStringBuilder.append(l);
      QLog.i("TroopBatchInfoHandler", 2, localStringBuilder.toString());
    }
    if (bool1)
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (bool2)
    {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    bool1 = paramFromServiceMsg.isSuccess();
    if (bool1)
    {
      paramFromServiceMsg = (RespBatchProcess)paramObject;
      if (paramFromServiceMsg.batch_response_list != null)
      {
        if (paramFromServiceMsg.batch_response_list.size() == 0) {
          return;
        }
        notifyUI(TroopObserver.TYPE_BATCH_GET_TROOP_INFO, bool1, new Object[] { Long.valueOf(l), paramFromServiceMsg, paramToServiceMsg.extraData });
        return;
      }
      return;
    }
    notifyUI(TroopObserver.TYPE_BATCH_GET_TROOP_INFO, bool1, null);
  }
  
  public void a(String paramString, Boolean paramBoolean)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTroopClassType, troopCode = ");
        localStringBuilder.append(paramString);
        QLog.d("TroopBatchInfoHandler", 2, localStringBuilder.toString());
      }
      long l = Long.parseLong(paramString);
      paramString = createToServiceMsg("ProfileService.ReqBatchProcess");
      paramString.extraData.putLong("troop_code", l);
      paramString.extraData.putBoolean("param_get_troop_class_type", true);
      paramString.extraData.putBoolean("is_admin", true);
      paramString.extraData.putBoolean("isFromMsg0x26", paramBoolean.booleanValue());
      send(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel())
      {
        paramBoolean = new StringBuilder();
        paramBoolean.append("getTroopClassType:");
        paramBoolean.append(paramString.toString());
        QLog.e("TroopBatchInfoHandler", 2, paramBoolean.toString());
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("th->getTroopCreditLevel:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("troop.credit.data", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      long l = Long.parseLong(paramString);
      localObject = createToServiceMsg("ProfileService.ReqBatchProcess");
      ((ToServiceMsg)localObject).extraData.putLong("troop_code", l);
      ((ToServiceMsg)localObject).extraData.putBoolean("param_get_credit_info", true);
      ((ToServiceMsg)localObject).extraData.putBoolean("is_admin", paramBoolean);
      send((ToServiceMsg)localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("th->getTroopCreditLevel->sendReq:");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("troop.credit.data", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("th->getTroopCreditLevel:");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.i("troop.credit.data", 2, ((StringBuilder)localObject).toString());
      }
      notifyUI(TroopObserver.TYPE_BATCH_GET_TROOP_INFO, false, null);
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("troop_code");
    boolean bool = paramFromServiceMsg.isSuccess();
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetTroopCreditInfo:");
      paramToServiceMsg.append(l);
      paramToServiceMsg.append(",");
      paramToServiceMsg.append(bool);
      QLog.i("troop.credit.data", 2, paramToServiceMsg.toString());
    }
    if (l == 0L)
    {
      notifyUI(TroopObserver.TYPE_GET_TROOP_CREDIT_INFO, false, Long.valueOf(l));
      return;
    }
    if (!bool)
    {
      notifyUI(TroopObserver.TYPE_GET_TROOP_CREDIT_INFO, false, Long.valueOf(l));
      return;
    }
    paramFromServiceMsg = (RespBatchProcess)paramObject;
    if ((paramFromServiceMsg.batch_response_list != null) && (paramFromServiceMsg.batch_response_list.size() != 0))
    {
      paramObject = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
      paramToServiceMsg = null;
      if (paramObject != null)
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append(l);
        paramToServiceMsg.append("");
        paramToServiceMsg = paramObject.findTroopInfo(paramToServiceMsg.toString());
      }
      if (paramToServiceMsg == null)
      {
        notifyUI(TroopObserver.TYPE_GET_TROOP_CREDIT_INFO, false, Long.valueOf(l));
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.data", 2, "handleGetTroopCreditInfo, troopInfo==null");
        }
        return;
      }
      a(l, paramFromServiceMsg, paramToServiceMsg);
      return;
    }
    notifyUI(TroopObserver.TYPE_GET_TROOP_CREDIT_INFO, false, Long.valueOf(l));
    if (QLog.isColorLevel()) {
      QLog.i("troop.credit.data", 2, "handleGetTroopCreditInfo, batch_response_list==null or 0");
    }
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("troop_code");
    boolean bool2 = paramFromServiceMsg.isSuccess();
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("isFromMsg0x26");
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetTroopClassType:");
      paramToServiceMsg.append(l);
      paramToServiceMsg.append(",");
      paramToServiceMsg.append(bool2);
      QLog.d("TroopBatchInfoHandler", 2, paramToServiceMsg.toString());
    }
    if ((l != 0L) && (bool2))
    {
      paramObject = (RespBatchProcess)paramObject;
      if ((paramObject.batch_response_list != null) && (paramObject.batch_response_list.size() != 0))
      {
        Object localObject = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
        paramFromServiceMsg = null;
        if (localObject != null)
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append(l);
          paramToServiceMsg.append("");
          paramFromServiceMsg = ((ITroopInfoService)localObject).findTroopInfo(paramToServiceMsg.toString());
        }
        paramToServiceMsg = paramFromServiceMsg;
        if (paramFromServiceMsg == null)
        {
          paramFromServiceMsg = new TroopInfo();
          paramFromServiceMsg.troopuin = String.valueOf(l);
          paramToServiceMsg = paramFromServiceMsg;
          if (localObject != null)
          {
            ((ITroopInfoService)localObject).addTroop(paramFromServiceMsg);
            paramToServiceMsg = paramFromServiceMsg;
          }
        }
        int i = paramObject.batch_response_list.size();
        int j = 0;
        paramFromServiceMsg = (FromServiceMsg)localObject;
        while (j < i)
        {
          localObject = (BatchResponse)paramObject.batch_response_list.get(j);
          if ((localObject != null) && (((BatchResponse)localObject).result == 0) && (((BatchResponse)localObject).type == 1))
          {
            oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
            try
            {
              localOIDBSSOPkg.mergeFrom((byte[])((BatchResponse)localObject).buffer);
              if (((BatchResponse)localObject).seq == 0) {
                a(l, bool2, bool1, paramToServiceMsg, localOIDBSSOPkg);
              }
            }
            catch (Exception paramToServiceMsg)
            {
              paramToServiceMsg.printStackTrace();
              return;
            }
          }
          j += 1;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleGetTroopClassType:");
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append(",");
          paramObject = paramToServiceMsg;
          ((StringBuilder)localObject).append(paramObject.dwGroupClassExt);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(paramObject.mGroupClassExtText);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(i);
          QLog.d("TroopBatchInfoHandler", 2, ((StringBuilder)localObject).toString());
        }
        if ((paramFromServiceMsg != null) && (paramToServiceMsg != null))
        {
          paramFromServiceMsg.saveTroopInfo(paramToServiceMsg);
          notifyUI(TroopObserver.TYPE_NOTIFY_UPDATE_TROOP_INFO, true, new Object[] { paramToServiceMsg.troopuin });
          return;
        }
        return;
      }
      return;
    }
  }
  
  protected String dv_()
  {
    return "TroopBatchInfoHandler";
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("ProfileService.ReqBatchProcess");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopObserver.class;
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
          QLog.d("TroopBatchInfoHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("ProfileService.ReqBatchProcess".equals(paramFromServiceMsg.getServiceCmd())) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopBatchInfoHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopBatchInfoHandler
 * JD-Core Version:    0.7.0.1
 */