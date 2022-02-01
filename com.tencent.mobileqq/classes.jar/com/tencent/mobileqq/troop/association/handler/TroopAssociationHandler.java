package com.tencent.mobileqq.troop.association.handler;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.IBizTroopInfoService;
import com.tencent.mobileqq.troop.association.api.ITroopAssociationHandler;
import com.tencent.mobileqq.troop.association.api.TroopAssociationObserver;
import com.tencent.mobileqq.troop.association.data.AllianceItem;
import com.tencent.mobileqq.troop.association.data.AssociatedTroopItem;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import tencent.im.oidb.cmd0xede.oidb_0xede.GroupInfo;
import tencent.im.oidb.cmd0xede.oidb_0xede.ReqBody;
import tencent.im.oidb.cmd0xede.oidb_0xede.RspBody;

public class TroopAssociationHandler
  extends TroopBaseHandler
  implements ITroopAssociationHandler
{
  protected Set<String> a;
  private AtomicLong b = new AtomicLong(0L);
  
  public TroopAssociationHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public long a(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getAssociatedTroopList troopUin =  ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" opType: ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" startTroopUin: ");
      ((StringBuilder)localObject1).append(paramString2);
      QLog.d("TroopAssociationHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = paramString2;
    long l2 = this.b.getAndIncrement();
    Object localObject2 = new oidb_0xede.ReqBody();
    try
    {
      ((oidb_0xede.ReqBody)localObject2).uint64_group_code.set(Long.valueOf(paramString1).longValue());
      ((oidb_0xede.ReqBody)localObject2).uint32_op_type.set(paramInt);
      long l1;
      if (TextUtils.isEmpty(paramString2)) {
        l1 = 0L;
      } else {
        l1 = Long.valueOf(paramString2).longValue();
      }
      ((oidb_0xede.ReqBody)localObject2).uint64_start_group_code.set(l1);
      localObject2 = makeOIDBPkg("OidbSvc.0xede_1", 3806, 1, ((oidb_0xede.ReqBody)localObject2).toByteArray(), 30000L);
      ((ToServiceMsg)localObject2).extraData.putString("troopUin", paramString1);
      ((ToServiceMsg)localObject2).extraData.putInt("opType", paramInt);
      Bundle localBundle = ((ToServiceMsg)localObject2).extraData;
      if (TextUtils.isEmpty(paramString2)) {
        localObject1 = "0";
      }
      localBundle.putString("startUin", (String)localObject1);
      ((ToServiceMsg)localObject2).extraData.putLong("getseq", l2);
      sendPbReq((ToServiceMsg)localObject2);
      return l2;
    }
    catch (Exception paramString2)
    {
      notifyUI(TroopAssociationObserver.b, false, new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(l2), null });
      paramString2.printStackTrace();
    }
    return l2;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str;
    int j;
    long l1;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      str = paramToServiceMsg.extraData.getString("troopUin");
      j = paramToServiceMsg.extraData.getInt("opType");
      l1 = paramToServiceMsg.extraData.getLong("getseq");
    }
    for (;;)
    {
      try
      {
        oidb_0xede.RspBody localRspBody = new oidb_0xede.RspBody();
        i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
        if (i != 0)
        {
          if (QLog.isColorLevel())
          {
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("handleGetRelatedTroopListResp failed, result: ");
            paramToServiceMsg.append(i);
            QLog.d("TroopAssociationHandler", 2, paramToServiceMsg.toString());
          }
          notifyUI(TroopAssociationObserver.b, false, new Object[] { str, Integer.valueOf(j), Long.valueOf(l1), null });
          return;
        }
        paramFromServiceMsg = new AllianceItem();
        if (!localRspBody.uint32_group_info_size.has()) {
          break label959;
        }
        i = localRspBody.uint32_group_info_size.get();
        paramFromServiceMsg.associatedTroopCount = i;
        if (j == 3)
        {
          ((IBizTroopInfoService)this.appRuntime.getRuntimeService(IBizTroopInfoService.class, "")).setAssociatedTroopCount(str, i);
          if (QLog.isColorLevel())
          {
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("handleGetRelatedTroopListResp succ, opType: ");
            paramToServiceMsg.append(j);
            paramToServiceMsg.append(" count: ");
            paramToServiceMsg.append(i);
            QLog.d("TroopAssociationHandler", 2, paramToServiceMsg.toString());
          }
          notifyUI(TroopAssociationObserver.b, true, new Object[] { str, Integer.valueOf(j), Long.valueOf(l1), paramFromServiceMsg });
          return;
        }
        long l2 = localRspBody.uint64_next_group_code.get();
        paramObject = new ArrayList();
        paramToServiceMsg = localRspBody.rpt_group_info.get().iterator();
        if (paramToServiceMsg.hasNext())
        {
          oidb_0xede.GroupInfo localGroupInfo = (oidb_0xede.GroupInfo)paramToServiceMsg.next();
          AssociatedTroopItem localAssociatedTroopItem = new AssociatedTroopItem();
          localAssociatedTroopItem.uin = String.valueOf(localGroupInfo.uint64_group_code.get());
          if (!localGroupInfo.string_group_name.has()) {
            break label965;
          }
          localAssociatedTroopItem.name = new String(localGroupInfo.string_group_name.get().toByteArray());
          localAssociatedTroopItem.maxMemberNum = localGroupInfo.uint32_group_member_max_num.get();
          localAssociatedTroopItem.memberNum = localGroupInfo.uint32_group_member_num.get();
          localAssociatedTroopItem.relateStatus = localGroupInfo.uint32_status.get();
          localAssociatedTroopItem.relateType = localGroupInfo.uint32_type.get();
          localAssociatedTroopItem.privilege = localGroupInfo.uint32_role.get();
          localAssociatedTroopItem.intro = new String(localGroupInfo.string_group_finger_memo.get().toByteArray());
          localAssociatedTroopItem.richIntro = new String(localGroupInfo.string_group_rich_finger_memo.get().toByteArray());
          localAssociatedTroopItem.groupFace = localGroupInfo.uint32_group_face.get();
          localAssociatedTroopItem.isConfGroup = localGroupInfo.uint32_is_conf_group.get();
          if (j == 2)
          {
            localAssociatedTroopItem.seq = localGroupInfo.uint32_seq.get();
            if (localGroupInfo.bytes_join_group_auth.has()) {
              localAssociatedTroopItem.joinAuth = new String(localGroupInfo.bytes_join_group_auth.get().toByteArray());
            }
          }
          localAssociatedTroopItem.labelList = AssociatedTroopItem.transLabel(localGroupInfo.rpt_group_label.get());
          paramObject.add(localAssociatedTroopItem);
          continue;
        }
        paramFromServiceMsg.uin = String.valueOf(localRspBody.uint64_alliance_id.get());
        paramFromServiceMsg.adminUin = String.valueOf(localRspBody.uint64_alliance_admin_uin.get());
        paramFromServiceMsg.adminName = new String(localRspBody.str_alliance_admin_name.get().toByteArray());
        paramFromServiceMsg.createTime = localRspBody.uint64_alliance_create_time.get();
        paramFromServiceMsg.associatedTroopList = paramObject;
        if (l2 <= 0L) {
          break label968;
        }
        paramToServiceMsg = String.valueOf(l2);
        paramFromServiceMsg.nextTroopUin = paramToServiceMsg;
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleGetRelatedTroopListResp succ, opType: ");
          paramToServiceMsg.append(j);
          paramToServiceMsg.append(" count: ");
          paramToServiceMsg.append(i);
          paramToServiceMsg.append(" allianceItem: ");
          paramToServiceMsg.append(paramFromServiceMsg.toString());
          QLog.d("TroopAssociationHandler", 2, paramToServiceMsg.toString());
        }
        notifyUI(TroopAssociationObserver.b, true, new Object[] { str, Integer.valueOf(j), Long.valueOf(l1), paramFromServiceMsg });
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        notifyUI(TroopAssociationObserver.b, false, new Object[] { str, Integer.valueOf(j), Long.valueOf(l1), null });
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleGetRelatedTroopListResp e: ");
          paramFromServiceMsg.append(paramToServiceMsg);
          QLog.d("TroopAssociationHandler", 2, paramFromServiceMsg.toString());
        }
        paramToServiceMsg.printStackTrace();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssociationHandler", 2, "handleGetRelatedTroopListResp resp == null || res == null");
      }
      notifyUI(TroopAssociationObserver.b, false, new Object[] { "", Integer.valueOf(-1), Integer.valueOf(-1), null });
      return;
      label959:
      int i = 0;
      continue;
      label965:
      continue;
      label968:
      paramToServiceMsg = null;
    }
  }
  
  protected String dv_()
  {
    return "TroopAssociationHandler";
  }
  
  public Set<String> getCommandList()
  {
    if (this.a == null)
    {
      this.a = new HashSet();
      this.a.add("OidbSvc.0xede_1");
    }
    return this.a;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopAssociationObserver.class;
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
          QLog.d("TroopAssociationHandler", 2, paramToServiceMsg.toString());
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
          QLog.d("TroopAssociationHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("OidbSvc.0xede_1".equals(paramFromServiceMsg.getServiceCmd())) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopAssociationHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.association.handler.TroopAssociationHandler
 * JD-Core Version:    0.7.0.1
 */