package com.tencent.mobileqq.troop.handler;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
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
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
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
  extends BusinessHandler
{
  public TroopInfoExtHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopInfoExtHandler", 2, "sendPbRequest. request is null.");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoExtHandler", 2, "sendPbRequest. cmd=" + paramToServiceMsg.getServiceCmd());
    }
    super.sendPbReq(paramToServiceMsg);
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
    if ((paramTroopInfoExt1 == null) || (paramTroopInfoExt2 == null)) {}
    while ((paramTroopInfoExt1.luckyWordId == paramTroopInfoExt2.luckyWordId) && (paramTroopInfoExt1.lightCharNum == paramTroopInfoExt2.lightCharNum)) {
      return false;
    }
    return true;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopInfoExtHandler", 2, "handleGetTroopInfoExtBy0xef0 resp == null || res == null");
      }
    }
    boolean bool1;
    label141:
    do
    {
      Object localObject;
      do
      {
        int i;
        do
        {
          return;
          localObject = new oidb_0xef0.RspBody();
          i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
          if (i == 0) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("TroopInfoExtHandler", 2, "handleGetTroopInfoExtBy0xef0 result = " + i);
        return;
        paramToServiceMsg = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
        paramFromServiceMsg = ((oidb_0xef0.RspBody)localObject).rpt_msg_rsp_detail.get();
        if ((paramFromServiceMsg != null) && (!paramFromServiceMsg.isEmpty())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopInfoExtHandler", 2, "handleGetTroopInfoExtBy0xef0 rspDetails empty");
      return;
      paramFromServiceMsg = paramFromServiceMsg.iterator();
      boolean bool2;
      for (bool1 = false; paramFromServiceMsg.hasNext(); bool1 = bool2)
      {
        paramObject = (oidb_0xef0.RspDetail)paramFromServiceMsg.next();
        if ((paramObject == null) || (paramObject.int32_result.get() != 0)) {
          break label141;
        }
        localObject = String.valueOf(paramObject.uint64_group_code.get());
        TroopInfo localTroopInfo = paramToServiceMsg.findTroopInfo((String)localObject);
        bool2 = bool1;
        if (localTroopInfo != null)
        {
          bool2 = bool1;
          if (paramObject.msg_group_info_ext.has())
          {
            TroopInfoExt localTroopInfoExt = localTroopInfo.mTroopInfoExtObj;
            localTroopInfo.mTroopInfoExtObj = TroopInfoExt.parseFromGroupInfoExt((oidb_0xef0.GroupInfoExt)paramObject.msg_group_info_ext.get());
            if (QLog.isColorLevel()) {
              QLog.i("TroopInfoExtHandler", 2, "handleGetTroopInfoExtBy0xef0 troopUin:" + (String)localObject + " uint32_group_info_ext_seq:" + localTroopInfo.mTroopInfoExtObj.groupInfoExtSeq);
            }
            paramToServiceMsg.saveTroopInfo(localTroopInfo);
            bool2 = bool1;
            if (!bool1) {
              bool2 = a(localTroopInfoExt, localTroopInfo.mTroopInfoExtObj);
            }
            notifyUI(TroopNotificationConstants.cj, true, new Object[] { localObject, localTroopInfoExt });
          }
        }
      }
    } while (!bool1);
    notifyUI(TroopNotificationConstants.aC, true, null);
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
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoExtHandler", 2, "getTroopInfoExtBy0xef0 + troopUinList = " + paramList.toString());
    }
    oidb_0xef0.GroupInfoExt localGroupInfoExt = new oidb_0xef0.GroupInfoExt();
    a(localGroupInfoExt);
    oidb_0xef0.ReqBody localReqBody = new oidb_0xef0.ReqBody();
    localReqBody.msg_group_info_ext.set(localGroupInfoExt);
    localReqBody.rpt_uint64_group_code.set(paramList);
    a(makeOIDBPkg("OidbSvc.0xef0_1", 3824, 1, localReqBody.toByteArray(), 30000L));
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
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return TroopObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopInfoExtHandler", 2, "onReceive,resp == null");
      }
    }
    do
    {
      String str;
      do
      {
        return;
        str = paramFromServiceMsg.getServiceCmd();
        if (!msgCmdFilter(str)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopInfoExtHandler", 2, "cmdfilter error=" + str);
      return;
    } while (!"OidbSvc.0xef0_1".equals(paramFromServiceMsg.getServiceCmd()));
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopInfoExtHandler
 * JD-Core Version:    0.7.0.1
 */