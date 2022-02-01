package com.tencent.mobileqq.troop.fans.handler;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.fans.api.ITroopFansHandler;
import com.tencent.mobileqq.troop.fans.api.ITroopFansService;
import com.tencent.mobileqq.troop.fans.api.TroopFansObserver;
import com.tencent.mobileqq.troop.fans.data.TroopFansInfo.IdolItem;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0xef6.oidb_0xef6.ReqBody;
import tencent.im.oidb.cmd0xef6.oidb_0xef6.RspBody;
import tencent.im.oidb.cmd0xef7.oidb_0xef7.IdolInfo;
import tencent.im.oidb.cmd0xef7.oidb_0xef7.ReqBody;
import tencent.im.oidb.cmd0xef7.oidb_0xef7.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopFansHandler
  extends TroopBaseHandler
  implements ITroopFansHandler
{
  protected Set<String> a;
  
  public TroopFansHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg == null)
    {
      notifyUI(TroopFansObserver.TYPE_GET_MEMBER_IDOLINFO, false, new Object[] { Integer.valueOf(0), null, Integer.valueOf(-1) });
      return;
    }
    long l = 0L;
    if (paramToServiceMsg.extraData != null) {
      l = paramToServiceMsg.extraData.getLong("memberUin");
    }
    paramToServiceMsg = new oidb_0xef6.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0)
    {
      notifyUI(TroopFansObserver.TYPE_GET_MEMBER_IDOLINFO, true, new Object[] { Long.valueOf(l), paramToServiceMsg, Integer.valueOf(i) });
      return;
    }
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("handleGetIdolInfoOfCard failed result:");
    paramFromServiceMsg.append(i);
    QLog.i("TroopFansHandler", 2, paramFromServiceMsg.toString());
    notifyUI(TroopFansObserver.TYPE_GET_MEMBER_IDOLINFO, false, new Object[] { Long.valueOf(l), paramToServiceMsg, Integer.valueOf(i) });
  }
  
  protected String a()
  {
    return "TroopFansHandler";
  }
  
  public void a(long paramLong)
  {
    Object localObject2 = new oidb_0xef6.ReqBody();
    ((oidb_0xef6.ReqBody)localObject2).uint64_uin.set(paramLong);
    Object localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(3830);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xef6.ReqBody)localObject2).toByteArray()));
    localObject2 = createToServiceMsg("OidbSvc.0xef6_1");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putLong("memberUin", paramLong);
    sendPbReq((ToServiceMsg)localObject2);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getIdolInfoOfCard memberUin :");
      ((StringBuilder)localObject1).append(paramLong);
      QLog.i("TroopFansHandler", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramToServiceMsg != null))
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getString("troopUinStr");
      oidb_0xef7.RspBody localRspBody = new oidb_0xef7.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      if (i != 0)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleGetFansTroopIdolInfoResp failed result: ");
          paramFromServiceMsg.append(i);
          QLog.i("TroopFansHandler", 2, paramFromServiceMsg.toString());
        }
        notifyUI(TroopFansObserver.TYPE_NOTIFY_GET_FANS_TROOP_IDOL_INFO, false, new Object[] { paramToServiceMsg, "", Integer.valueOf(0) });
        return;
      }
      paramFromServiceMsg = (oidb_0xef7.IdolInfo)localRspBody.idol_info.get();
      paramObject = new TroopFansInfo.IdolItem();
      if (paramFromServiceMsg.name.has()) {
        paramObject.jdField_a_of_type_JavaLangString = paramFromServiceMsg.name.get();
      }
      if (paramFromServiceMsg.alias.has()) {
        paramObject.b = paramFromServiceMsg.avatar.get();
      }
      if (localRspBody.rank.has()) {
        paramObject.jdField_a_of_type_Long = localRspBody.rank.get();
      }
      ((ITroopFansService)this.appRuntime.getRuntimeService(ITroopFansService.class, "")).setTroopIdolInfoDate(paramToServiceMsg, paramObject);
      notifyUI(TroopFansObserver.TYPE_NOTIFY_GET_FANS_TROOP_IDOL_INFO, true, new Object[] { paramToServiceMsg, paramObject.jdField_a_of_type_JavaLangString, Long.valueOf(paramObject.jdField_a_of_type_Long) });
      return;
    }
    notifyUI(TroopFansObserver.TYPE_NOTIFY_GET_FANS_TROOP_IDOL_INFO, false, null);
    if (QLog.isColorLevel()) {
      QLog.d("TroopFansHandler", 2, "handleGetFansTroopIdolInfoResp req == null || res == null");
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      if (l == 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopFansHandler.troop.troop_app", 2, new Object[] { "getFansTroopStarRank troopUinStr invalid. str=", paramString });
        }
        return;
      }
      Object localObject = new oidb_0xef7.ReqBody();
      ((oidb_0xef7.ReqBody)localObject).group_id.set(l);
      localObject = makeOIDBPkg("OidbSvc.0xef7_1", 3831, 1, ((oidb_0xef7.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("troopUinStr", paramString);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFansTroopIdolInfo_0xef7 troopUinStr: ");
        localStringBuilder.append(paramString);
        QLog.i("TroopFansHandler", 1, localStringBuilder.toString());
      }
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString)
    {
      label135:
      break label135;
    }
    QLog.e("TroopFansHandler", 1, "getFansTroopIdolInfo_0xef7 parseLong troopUinStr exception");
  }
  
  public Set<String> getCommandList()
  {
    if (this.a == null)
    {
      this.a = new HashSet();
      this.a.add("OidbSvc.0xef7_1");
      this.a.add("OidbSvc.0xef6_1");
    }
    return this.a;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopFansObserver.class;
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
          QLog.d("TroopFansHandler", 2, paramToServiceMsg.toString());
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
          QLog.d("TroopFansHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("OidbSvc.0xef7_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xef6_1".equals(paramFromServiceMsg.getServiceCmd())) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopFansHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.fans.handler.TroopFansHandler
 * JD-Core Version:    0.7.0.1
 */