package com.tencent.mobileqq.troop.handler;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.handler.ITroopModifyHandler;
import com.tencent.mobileqq.troop.api.observer.TroopModifyObserver;
import com.tencent.mobileqq.troop.util.api.ITroopStringUtilsApi;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.ModifyGroupInfoResp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.GroupGeoInfo;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.GroupSchoolInfo;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.ReqBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.RspBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.groupinfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopModifyHandler
  extends TroopBaseHandler
  implements ITroopModifyHandler
{
  public TroopModifyHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(long paramLong)
  {
    TroopModifyHandler.1 local1 = new TroopModifyHandler.1(this, paramLong);
    this.appRuntime.addDefaultObservers(local1);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, ModifyGroupInfoResp paramModifyGroupInfoResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopModifyHandler", 2, "handleModifyTroopInfo");
    }
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      long l = paramToServiceMsg.extraData.getLong("dwGroupCode");
      int i = paramToServiceMsg.extraData.getInt("modify_troopinfo_flag");
      ITroopInfoService localITroopInfoService = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
      TroopInfo localTroopInfo = localITroopInfoService.findTroopInfo(Long.toString(l));
      if ((paramModifyGroupInfoResp != null) && (l == paramModifyGroupInfoResp.dwGroupCode) && (paramModifyGroupInfoResp.result == 0))
      {
        paramFromServiceMsg = localTroopInfo;
        if (localTroopInfo == null)
        {
          paramFromServiceMsg = new TroopInfo();
          paramFromServiceMsg.troopuin = Long.toString(l);
        }
        paramFromServiceMsg.troopname = paramToServiceMsg.extraData.getString("strGroupName");
        paramFromServiceMsg.dwGroupClassExt = paramToServiceMsg.extraData.getLong("dwGroupClass");
        paramFromServiceMsg.cGroupOption = ((short)(int)paramToServiceMsg.extraData.getLong("cGroupOption"));
        paramFromServiceMsg.troopmemo = paramToServiceMsg.extraData.getString("strGroupMemo");
        paramToServiceMsg = paramToServiceMsg.extraData.getString("strFingerMemo");
        try
        {
          paramModifyGroupInfoResp = paramToServiceMsg.getBytes("utf-8");
          if (paramModifyGroupInfoResp.length > 120) {
            paramFromServiceMsg.fingertroopmemo = ((ITroopStringUtilsApi)QRoute.api(ITroopStringUtilsApi.class)).cutByteByUtf8(paramModifyGroupInfoResp, 120);
          } else {
            paramFromServiceMsg.fingertroopmemo = paramToServiceMsg;
          }
        }
        catch (IOException paramModifyGroupInfoResp)
        {
          paramModifyGroupInfoResp.printStackTrace();
          paramFromServiceMsg.fingertroopmemo = "";
        }
        paramFromServiceMsg.mRichFingerMemo = paramToServiceMsg;
        paramFromServiceMsg.setOnlyTroopMemberInviteOption(false);
        localITroopInfoService.saveTroopInfo(paramFromServiceMsg);
        notifyUI(TroopModifyObserver.b, true, new Object[] { Long.valueOf(l), Integer.valueOf(i), paramFromServiceMsg });
        return;
      }
      notifyUI(TroopModifyObserver.b, false, new Object[] { Long.valueOf(l), Integer.valueOf(i), localTroopInfo });
      return;
    }
    notifyUI(TroopModifyObserver.b, false, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null });
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject instanceof ModifyGroupInfoResp)) {
      paramObject = (ModifyGroupInfoResp)paramObject;
    } else {
      paramObject = null;
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      if (paramToServiceMsg.extraData.getInt("key_subcmd", -1) != 4) {
        return;
      }
      str1 = paramToServiceMsg.extraData.getString("name");
      String str2 = paramToServiceMsg.extraData.getString("troopUin");
      paramToServiceMsg = new Object[4];
      paramToServiceMsg[0] = str2;
      paramToServiceMsg[1] = str1;
      paramToServiceMsg[2] = null;
      paramToServiceMsg[3] = Integer.valueOf(0);
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        notifyUI(TroopModifyObserver.e, false, paramToServiceMsg);
        return;
      }
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if (paramFromServiceMsg == null)
      {
        notifyUI(TroopModifyObserver.e, false, paramToServiceMsg);
        return;
      }
      paramObject = new oidb_0x89a.RspBody();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      int i;
      long l;
      label290:
      break label300;
    }
    try
    {
      paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      i = paramFromServiceMsg.uint32_result.get();
      if (i != 0)
      {
        if (paramObject.str_errorinfo.has()) {
          paramToServiceMsg[2] = paramObject.str_errorinfo.get().toStringUtf8();
        }
        if (i == 1328) {
          paramToServiceMsg[2] = HardCodeUtil.a(2131890814);
        }
        paramToServiceMsg[3] = Integer.valueOf(i);
        notifyUI(TroopModifyObserver.e, false, paramToServiceMsg);
        return;
      }
      l = paramObject.uint64_group_code.get();
      i = TroopModifyObserver.e;
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("");
      paramToServiceMsg.append(l);
      notifyUI(i, true, new Object[] { paramToServiceMsg.toString(), str1, null });
      return;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      break label290;
    }
    notifyUI(TroopModifyObserver.e, false, paramToServiceMsg);
    return;
    label300:
    notifyUI(TroopModifyObserver.e, false, paramToServiceMsg);
    return;
    notifyUI(TroopModifyObserver.e, false, null);
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    notifyUI(paramInt, paramBoolean, paramObject);
  }
  
  public void a(long paramLong1, int paramInt1, String paramString1, long paramLong2, List<String> paramList, int paramInt2, long paramLong3, long paramLong4, long paramLong5, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, String paramString6)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("modifyTroopInfoBy0x89a==>cityId:");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("|lat:");
      ((StringBuilder)localObject).append(paramLong3);
      ((StringBuilder)localObject).append("|lon:");
      ((StringBuilder)localObject).append(paramLong4);
      QLog.d("TroopModifyHandler", 2, ((StringBuilder)localObject).toString());
    }
    a(paramLong1);
    Object localObject = new oidb_0x89a.groupinfo();
    ((oidb_0x89a.groupinfo)localObject).uint32_group_type_flag.set(paramInt1);
    if (!TextUtils.isEmpty(paramString1)) {
      ((oidb_0x89a.groupinfo)localObject).string_group_name.set(ByteStringMicro.copyFromUtf8(paramString1));
    }
    ((oidb_0x89a.groupinfo)localObject).uint32_group_class_ext.set((int)paramLong2);
    if (!TextUtils.isEmpty(paramString6)) {
      ((oidb_0x89a.groupinfo)localObject).string_group_class_text.set(ByteStringMicro.copyFromUtf8(paramString6));
    }
    paramString1 = new ArrayList();
    if (paramList != null)
    {
      paramInt1 = 0;
      while (paramInt1 < paramList.size())
      {
        if (!TextUtils.isEmpty((CharSequence)paramList.get(paramInt1))) {
          paramString1.add(ByteStringMicro.copyFromUtf8((String)paramList.get(paramInt1)));
        }
        paramInt1 += 1;
      }
    }
    if (paramString1.size() == 0) {
      paramString1.add(ByteStringMicro.copyFrom("".getBytes()));
    }
    ((oidb_0x89a.groupinfo)localObject).rpt_string_group_tag.set(paramString1);
    paramString1 = new oidb_0x89a.GroupGeoInfo();
    paramString1.uint32_city_id.set(paramInt2);
    paramString1.uint64_latitude.set(paramLong3);
    paramString1.uint64_longtitude.set(paramLong4);
    if (paramString2 != null) {
      paramString1.string_geo_content.set(ByteStringMicro.copyFromUtf8(paramString2));
    }
    paramString1.uint64_poi_id.set(paramLong5);
    ((oidb_0x89a.groupinfo)localObject).msg_group_geo_info.set(paramString1);
    if (paramString3 != null)
    {
      ((oidb_0x89a.groupinfo)localObject).string_group_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString3));
      ((oidb_0x89a.groupinfo)localObject).string_group_rich_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString3));
    }
    if ((!TextUtils.isEmpty(paramString4)) && (paramInt3 != 0))
    {
      paramString1 = new oidb_0x89a.GroupSchoolInfo();
      paramString1.bytes_location.set(ByteStringMicro.copyFromUtf8(paramString4));
      paramString1.uint32_grade.set(paramInt3);
      if (!TextUtils.isEmpty(paramString5)) {
        paramString1.bytes_school.set(ByteStringMicro.copyFromUtf8(paramString5));
      }
      ((oidb_0x89a.groupinfo)localObject).bytes_group_school_info.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
    }
    a(paramLong1, (oidb_0x89a.groupinfo)localObject, "SUBCMD_EDIT_TROOP_INFO");
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.ModifyGroupInfoReq");
    localToServiceMsg.extraData.putLong("dwGroupCode", paramLong1);
    localToServiceMsg.extraData.putLong("cGroupOption", paramLong2);
    localToServiceMsg.extraData.putLong("dwGroupClass", paramLong3);
    Bundle localBundle = localToServiceMsg.extraData;
    String str = "";
    Object localObject = paramString1;
    if (paramString1 == null) {
      localObject = "";
    }
    localBundle.putString("strGroupName", (String)localObject);
    localToServiceMsg.extraData.putInt("wGroupFace", paramInt1);
    localObject = localToServiceMsg.extraData;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    ((Bundle)localObject).putString("strGroupMemo", paramString1);
    paramString1 = localToServiceMsg.extraData;
    if (paramString3 == null) {
      paramString3 = str;
    }
    paramString1.putString("strFingerMemo", paramString3);
    localToServiceMsg.extraData.putInt("modify_troopinfo_flag", paramInt2);
    if ((paramInt2 & 0x2) == 2) {
      localToServiceMsg.extraData.putLong("dwValidMask", 2L);
    }
    send(localToServiceMsg);
  }
  
  public void a(long paramLong, oidb_0x89a.groupinfo paramgroupinfo, String paramString)
  {
    a(paramLong, paramgroupinfo, paramString, 0);
  }
  
  public void a(long paramLong, oidb_0x89a.groupinfo paramgroupinfo, String paramString, int paramInt)
  {
    Object localObject = new oidb_0x89a.ReqBody();
    ((oidb_0x89a.ReqBody)localObject).uint64_group_code.set(paramLong);
    ((oidb_0x89a.ReqBody)localObject).st_group_info.set(paramgroupinfo);
    paramgroupinfo = new oidb_sso.OIDBSSOPkg();
    paramgroupinfo.uint32_command.set(2202);
    paramgroupinfo.uint32_result.set(0);
    paramgroupinfo.uint32_service_type.set(paramInt);
    paramgroupinfo.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x89a.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x89a_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramgroupinfo.toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("subCmd", paramString);
    ((ToServiceMsg)localObject).extraData.putLong("uin", paramLong);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg == null)
    {
      QLog.e("TroopModifyHandler", 2, "handle0x89a failed. req is NULL!");
      return;
    }
    String str = paramToServiceMsg.extraData.getString("subCmd");
    long l = paramToServiceMsg.extraData.getLong("uin");
    paramToServiceMsg = "";
    if (paramFromServiceMsg == null)
    {
      QLog.e("TroopModifyHandler", 2, "handle0x89a failed. resp is NULL!");
      notifyUI(TroopModifyObserver.c, false, new Object[] { Long.valueOf(l), str, Integer.valueOf(0), "" });
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramObject = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      paramFromServiceMsg = new oidb_0x89a.RspBody();
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      int i;
      label275:
      label322:
      break label322;
    }
    try
    {
      paramFromServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
      if (paramFromServiceMsg.uint64_group_code.has()) {
        l = paramFromServiceMsg.uint64_group_code.get();
      }
      i = paramObject.uint32_result.get();
      if (i != 0)
      {
        if (paramFromServiceMsg.str_errorinfo.has()) {
          paramToServiceMsg = new String(paramFromServiceMsg.str_errorinfo.get().toByteArray());
        }
        notifyUI(TroopModifyObserver.c, false, new Object[] { Long.valueOf(l), str, Integer.valueOf(i), paramToServiceMsg });
        return;
      }
      notifyUI(TroopModifyObserver.c, true, new Object[] { Long.valueOf(l), str, Integer.valueOf(0), "" });
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      break label275;
    }
    QLog.e("TroopModifyHandler", 2, "handle0x89a failed. InvalidProtocolBufferMicroException!");
    notifyUI(TroopModifyObserver.c, false, new Object[] { Long.valueOf(l), str, Integer.valueOf(0), "" });
    return;
    QLog.e("TroopModifyHandler", 2, "handle0x89a failed. InvalidProtocolBufferMicroException!");
    notifyUI(TroopModifyObserver.c, false, new Object[] { Long.valueOf(l), str, Integer.valueOf(0), "" });
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("modifyTroopName==>name:");
      ((StringBuilder)localObject1).append(paramString2);
      QLog.d("TroopModifyHandler.troop.location_info", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new oidb_0x89a.ReqBody();
    try
    {
      long l = Long.parseLong(paramString1);
      ((oidb_0x89a.ReqBody)localObject1).uint64_group_code.set(l);
      Object localObject2 = new oidb_0x89a.groupinfo();
      if (!TextUtils.isEmpty(paramString2)) {
        ((oidb_0x89a.groupinfo)localObject2).string_group_name.set(ByteStringMicro.copyFromUtf8(paramString2));
      }
      ((oidb_0x89a.ReqBody)localObject1).st_group_info.set((MessageMicro)localObject2);
      int i;
      if (paramBoolean) {
        i = 15;
      } else {
        i = 0;
      }
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2202);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(i);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x89a.ReqBody)localObject1).toByteArray()));
      localObject1 = createToServiceMsg("OidbSvc.0x89a_0");
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putInt("key_subcmd", 4);
      ((ToServiceMsg)localObject1).extraData.putString("troopUin", paramString1);
      ((ToServiceMsg)localObject1).extraData.putString("name", paramString2);
      sendPbReq((ToServiceMsg)localObject1);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  protected String dv_()
  {
    return "TroopModifyHandler";
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x89a_0");
      this.allowCmdSet.add("friendlist.ModifyGroupInfoReq");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopModifyObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopModifyHandler", 2, "onReceive,resp == null");
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
        QLog.d("TroopModifyHandler", 2, paramToServiceMsg.toString());
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
        QLog.d("TroopModifyHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    if ("OidbSvc.0x89a_0".equals(paramFromServiceMsg.getServiceCmd()))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("friendlist.ModifyGroupInfoReq".equals(paramFromServiceMsg.getServiceCmd())) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopModifyHandler
 * JD-Core Version:    0.7.0.1
 */