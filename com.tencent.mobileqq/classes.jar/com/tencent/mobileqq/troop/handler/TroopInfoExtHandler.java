package com.tencent.mobileqq.troop.handler;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopInfoExt;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoExtHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0xef0.oidb_0xef0.GroupInfoExt;
import tencent.im.oidb.cmd0xef0.oidb_0xef0.ReqBody;
import tencent.im.oidb.cmd0xef0.oidb_0xef0.RspBody;
import tencent.im.oidb.cmd0xef0.oidb_0xef0.RspDetail;

public class TroopInfoExtHandler
  extends TroopBaseHandler
  implements ITroopInfoExtHandler
{
  public TroopInfoExtHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      Object localObject1 = new oidb_0xef0.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
      if (i != 0)
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleGetTroopInfoExtBy0xef0 result = ");
          paramToServiceMsg.append(i);
          QLog.d("TroopInfoExtHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      paramToServiceMsg = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
      paramFromServiceMsg = ((oidb_0xef0.RspBody)localObject1).rpt_msg_rsp_detail.get();
      if ((paramFromServiceMsg != null) && (!paramFromServiceMsg.isEmpty()))
      {
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        label123:
        boolean bool2;
        for (boolean bool1 = false; paramFromServiceMsg.hasNext(); bool1 = bool2)
        {
          Object localObject2 = (oidb_0xef0.RspDetail)paramFromServiceMsg.next();
          if ((localObject2 == null) || (((oidb_0xef0.RspDetail)localObject2).int32_result.get() != 0)) {
            break label123;
          }
          paramObject = String.valueOf(((oidb_0xef0.RspDetail)localObject2).uint64_group_code.get());
          localObject1 = paramToServiceMsg.findTroopInfo(paramObject);
          if ((localObject1 == null) || (!((oidb_0xef0.RspDetail)localObject2).msg_group_info_ext.has())) {
            break label123;
          }
          TroopInfoExt localTroopInfoExt = ((TroopInfo)localObject1).mTroopInfoExtObj;
          ((TroopInfo)localObject1).mTroopInfoExtObj = TroopInfoExt.parseFromGroupInfoExt((oidb_0xef0.GroupInfoExt)((oidb_0xef0.RspDetail)localObject2).msg_group_info_ext.get());
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handleGetTroopInfoExtBy0xef0 troopUin:");
            ((StringBuilder)localObject2).append(paramObject);
            ((StringBuilder)localObject2).append(" uint32_group_info_ext_seq:");
            ((StringBuilder)localObject2).append(((TroopInfo)localObject1).mTroopInfoExtObj.groupInfoExtSeq);
            QLog.i("TroopInfoExtHandler", 2, ((StringBuilder)localObject2).toString());
          }
          paramToServiceMsg.saveTroopInfo((TroopInfo)localObject1);
          bool2 = bool1;
          if (!bool1) {
            bool2 = a(localTroopInfoExt, ((TroopInfo)localObject1).mTroopInfoExtObj);
          }
          notifyUI(TroopObserver.TYPE_GET_TROOP_INFO_EXT_COMPLETE, true, new Object[] { paramObject, localTroopInfoExt });
        }
        if (bool1) {
          ((ITroopListHandler)this.appRuntime.getBusinessHandler(TroopListHandler.class.getName())).a(TroopObserver.TYPE_NOTIFY_UPDATE_RECENT_LIST, true, null);
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopInfoExtHandler", 2, "handleGetTroopInfoExtBy0xef0 rspDetails empty");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoExtHandler", 2, "handleGetTroopInfoExtBy0xef0 resp == null || res == null");
    }
  }
  
  public static void a(oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if (paramGroupInfo == null) {
      return;
    }
    oidb_0xef0.GroupInfoExt localGroupInfoExt = new oidb_0xef0.GroupInfoExt();
    a(localGroupInfoExt);
    paramGroupInfo.st_group_info_ext.set(localGroupInfoExt);
  }
  
  static void a(oidb_0xef0.GroupInfoExt paramGroupInfoExt)
  {
    if (paramGroupInfoExt != null)
    {
      paramGroupInfoExt.uint32_group_info_ext_seq.set(0);
      paramGroupInfoExt.uint64_lucky_word_id.set(0L);
      paramGroupInfoExt.uint32_light_char_num.set(0);
      paramGroupInfoExt.bytes_lucky_word.set(ByteStringMicro.EMPTY);
      paramGroupInfoExt.uint32_star_id.set(0);
      paramGroupInfoExt.uint32_essential_msg_switch.set(0);
    }
  }
  
  private boolean a(TroopInfoExt paramTroopInfoExt1, TroopInfoExt paramTroopInfoExt2)
  {
    if (paramTroopInfoExt1 != null)
    {
      if (paramTroopInfoExt2 == null) {
        return false;
      }
      return (paramTroopInfoExt1.luckyWordId != paramTroopInfoExt2.luckyWordId) || (paramTroopInfoExt1.lightCharNum != paramTroopInfoExt2.lightCharNum);
    }
    return false;
  }
  
  protected String a()
  {
    return "TroopInfoExtHandler";
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramString));
    a(localArrayList);
  }
  
  public void a(List<Long> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getTroopInfoExtBy0xef0 + troopUinList = ");
        ((StringBuilder)localObject).append(paramList.toString());
        QLog.d("TroopInfoExtHandler", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new oidb_0xef0.GroupInfoExt();
      a((oidb_0xef0.GroupInfoExt)localObject);
      oidb_0xef0.ReqBody localReqBody = new oidb_0xef0.ReqBody();
      localReqBody.msg_group_info_ext.set((MessageMicro)localObject);
      localReqBody.rpt_uint64_group_code.set(paramList);
      a(makeOIDBPkg("OidbSvc.0xef0_1", 3824, 1, localReqBody.toByteArray(), 30000L));
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0xef0_1");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopInfoExtHandler", 2, "onReceive,resp == null");
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
        QLog.d("TroopInfoExtHandler", 2, paramToServiceMsg.toString());
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
        QLog.d("TroopInfoExtHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    if ("OidbSvc.0xef0_1".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopInfoExtHandler
 * JD-Core Version:    0.7.0.1
 */