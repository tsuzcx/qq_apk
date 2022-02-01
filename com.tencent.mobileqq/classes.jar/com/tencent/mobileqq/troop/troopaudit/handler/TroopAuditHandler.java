package com.tencent.mobileqq.troop.troopaudit.handler;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.observer.TroopAuditObserver;
import com.tencent.mobileqq.troop.troopaudit.api.ITroopAuditHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.TagRecord;
import tencent.im.oidb.cmd0x91a.cmd0x91a.ReqBody;
import tencent.im.oidb.cmd0x91a.cmd0x91a.RspBody;
import tencent.im.oidb.cmd0x91b.cmd0x91b.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopAuditHandler
  extends TroopBaseHandler
  implements ITroopAuditHandler
{
  public TroopAuditHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      if ((paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null)) {}
    }
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
      if (paramToServiceMsg.uint32_result.get() == 0)
      {
        notifyUI(TroopAuditObserver.b, true, null);
        return;
      }
      i = TroopAuditObserver.b;
      j = paramToServiceMsg.uint32_result.get();
      if (!paramToServiceMsg.str_error_msg.has()) {
        break label150;
      }
      paramToServiceMsg = paramToServiceMsg.str_error_msg.get();
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        int i;
        int j;
        continue;
        paramToServiceMsg = "";
      }
    }
    notifyUI(i, false, new Object[] { Integer.valueOf(j), paramToServiceMsg });
    return;
    notifyUI(TroopAuditObserver.b, false, null);
    return;
    notifyUI(TroopAuditObserver.b, false, null);
  }
  
  public void a(long paramLong1, String paramString1, long paramLong2, List<String> paramList, int paramInt, long paramLong3, long paramLong4, long paramLong5, String paramString2, String paramString3)
  {
    cmd0x91b.ReqBody localReqBody = new cmd0x91b.ReqBody();
    localReqBody.uint64_group_code.set(Long.valueOf(paramLong1).longValue());
    localReqBody.uint32_source.set(1);
    localReqBody.uint32_notify_aio_flag.set(1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setTroopInfoAndAuditTimesBy0x91a: cityId:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("|lat:");
      ((StringBuilder)localObject).append(paramLong3);
      ((StringBuilder)localObject).append("|lon:");
      ((StringBuilder)localObject).append(paramLong4);
      QLog.d("TroopAuditHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_0x88d.GroupInfo();
    if (!TextUtils.isEmpty(paramString1)) {
      ((oidb_0x88d.GroupInfo)localObject).string_group_name.set(ByteStringMicro.copyFromUtf8(paramString1));
    }
    ((oidb_0x88d.GroupInfo)localObject).uint32_group_class_ext.set((int)paramLong2);
    new ArrayList();
    paramString1 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      oidb_0x88d.TagRecord localTagRecord = new oidb_0x88d.TagRecord();
      localTagRecord.bytes_tag_value.set(ByteStringMicro.copyFromUtf8(str));
      paramString1.add(localTagRecord);
    }
    ((oidb_0x88d.GroupInfo)localObject).rpt_tag_record.set(paramString1);
    if ((paramLong3 != 0L) && (paramLong4 != 0L))
    {
      paramString1 = new oidb_0x88d.GroupGeoInfo();
      paramString1.uint32_cityid.set(paramInt);
      paramString1.int64_latitude.set(paramLong3);
      paramString1.int64_longitude.set(paramLong4);
      paramString1.bytes_geocontent.set(ByteStringMicro.copyFromUtf8(paramString2));
      paramString1.uint64_poi_id.set(paramLong5);
      ((oidb_0x88d.GroupInfo)localObject).group_geo_info.set(paramString1);
    }
    if (paramString3 != null)
    {
      ((oidb_0x88d.GroupInfo)localObject).string_group_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString3));
      ((oidb_0x88d.GroupInfo)localObject).string_group_rich_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString3));
    }
    localReqBody.info.set((MessageMicro)localObject);
    paramString1 = new oidb_sso.OIDBSSOPkg();
    paramString1.uint32_command.set(2331);
    paramString1.uint32_service_type.set(1);
    paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramList = createToServiceMsg("OidbSvc.0x91b_1");
    paramList.putWupBuffer(paramString1.toByteArray());
    paramList.setTimeout(30000L);
    sendPbReq(paramList);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        notifyUI(TroopAuditObserver.a, false, null);
        return;
      }
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0.0F) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
      {
        paramFromServiceMsg = new cmd0x91a.RspBody();
        try
        {
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          notifyUI(TroopAuditObserver.a, true, new Object[] { String.valueOf(paramFromServiceMsg.uint64_group_code.get()), Integer.valueOf(paramFromServiceMsg.uint32_result_status.get()), Integer.valueOf(paramFromServiceMsg.uint32_audit_times_max.get()), Integer.valueOf(paramFromServiceMsg.uint32_audit_times_remain.get()), paramFromServiceMsg.group_info.get() });
          QLog.isColorLevel();
          return;
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          notifyUI(TroopAuditObserver.a, false, null);
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("oidb_91a error : ");
            paramFromServiceMsg.append(paramToServiceMsg.toString());
            QLog.e("TroopAuditHandler", 2, paramFromServiceMsg.toString());
          }
          return;
        }
      }
      notifyUI(TroopAuditObserver.a, false, null);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      label266:
      break label266;
    }
    notifyUI(TroopAuditObserver.a, false, null);
  }
  
  public void a(String paramString)
  {
    Object localObject = new cmd0x91a.ReqBody();
    ((cmd0x91a.ReqBody)localObject).uint64_group_code.set(Long.valueOf(paramString).longValue());
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(2330);
    paramString.uint32_service_type.set(1);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x91a.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x91a_1");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  protected String dv_()
  {
    return "TroopAuditHandler";
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x91a_1");
      this.allowCmdSet.add("OidbSvc.0x91b_1");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopAuditObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAuditHandler", 2, "onReceive,resp == null");
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
        QLog.d("TroopAuditHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    if ("OidbSvc.0x91a_1".equals(paramFromServiceMsg.getServiceCmd()))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x91b_1".equals(paramFromServiceMsg.getServiceCmd())) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopaudit.handler.TroopAuditHandler
 * JD-Core Version:    0.7.0.1
 */