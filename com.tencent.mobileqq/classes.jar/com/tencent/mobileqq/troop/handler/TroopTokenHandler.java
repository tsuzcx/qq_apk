package com.tencent.mobileqq.troop.handler;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.config.TroopTokenHandlerProcessorConfig;
import com.tencent.mobileqq.troop.api.handler.ITroopTokenHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.stTroopMemberInfo;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo;
import tencent.im.oidb.cmd0xd22.Oidb_0xd22.AppInfo;
import tencent.im.oidb.cmd0xd22.Oidb_0xd22.ReqBody;
import tencent.im.oidb.cmd0xd22.Oidb_0xd22.RspBody;
import tencent.im.oidb.cmd0xd23.Oidb_0xd23.AppInfo;
import tencent.im.oidb.cmd0xd23.Oidb_0xd23.GroupInfo;
import tencent.im.oidb.cmd0xd23.Oidb_0xd23.ReqBody;
import tencent.im.oidb.cmd0xd23.Oidb_0xd23.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.opengroup.jstoken.ReqBody;
import tencent.im.opengroup.jstoken.RspBody;

public class TroopTokenHandler
  extends TroopBaseHandler
  implements ITroopTokenHandler
{
  protected Set<String> a;
  private HashMap<String, Long> b = new HashMap();
  private HashMap<String, ArrayList<stTroopMemberInfo>> c = null;
  
  public TroopTokenHandler(AppInterface paramAppInterface)
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
      paramToServiceMsg = new Oidb_0xd22.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (i == 0)
      {
        paramToServiceMsg = paramToServiceMsg.create_group_url.get().toStringUtf8();
        notifyUI(TroopObserver.TYPE_NOTIFY_OIDB_0XD22_1, true, new Object[] { paramToServiceMsg });
      }
      else
      {
        notifyUI(TroopObserver.TYPE_NOTIFY_OIDB_0XD22_1, false, null);
      }
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetCreateTroopTokenForThirdApp result: ");
      paramToServiceMsg.append(i);
      QLog.i("TroopAbility.Handler", 1, paramToServiceMsg.toString());
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      paramToServiceMsg = new Oidb_0xd22.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (i == 0)
      {
        paramFromServiceMsg = paramToServiceMsg.join_group_token.get().toStringUtf8();
        long l = paramToServiceMsg.group_code.get();
        notifyUI(TroopObserver.TYPE_NOTIFY_OIDB_0XD22_2, true, new Object[] { paramFromServiceMsg, String.valueOf(l) });
      }
      else
      {
        notifyUI(TroopObserver.TYPE_NOTIFY_OIDB_0XD22_2, false, null);
      }
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetJoinTroopTokenForThirdApp result: ");
      paramToServiceMsg.append(i);
      QLog.i("TroopAbility.Handler", 1, paramToServiceMsg.toString());
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      paramToServiceMsg = new Oidb_0xd23.RspBody();
      int j = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (j == 0)
      {
        int i;
        if (paramToServiceMsg.bind_flag.has()) {
          i = paramToServiceMsg.bind_flag.get();
        } else {
          i = -1;
        }
        long l;
        if (paramToServiceMsg.group_code.has()) {
          l = paramToServiceMsg.group_code.get();
        } else {
          l = -1L;
        }
        notifyUI(TroopObserver.TYPE_NOTIFY_OIDB_0XD23_2, true, new Object[] { Integer.valueOf(i), Long.valueOf(l) });
      }
      else
      {
        notifyUI(TroopObserver.TYPE_NOTIFY_OIDB_0XD23_2, false, null);
      }
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleBindTroopForThirdApp result: ");
      paramToServiceMsg.append(j);
      QLog.i("TroopAbility.TroopHandler", 1, paramToServiceMsg.toString());
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopTokenHandler", 2, "handleTroopOpenApiVerifyRsp");
    }
    int i;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      i = paramToServiceMsg.extraData.getInt("appid");
      String str1 = paramToServiceMsg.extraData.getString("openGroupId");
      String str2 = paramToServiceMsg.extraData.getString("token");
      String str3 = paramToServiceMsg.extraData.getString("url");
      j = paramToServiceMsg.extraData.getInt("seq");
      int k = paramFromServiceMsg.getResultCode();
      if (k == 1000)
      {
        paramFromServiceMsg = new jstoken.RspBody();
        try
        {
          paramFromServiceMsg.mergeFrom((byte[])paramObject);
          if (paramFromServiceMsg.uint32_result.get() != 0)
          {
            notifyUI(TroopObserver.TYPE_NOTIFY_TROOP_OPEN_API_TOKEN_VERIFY, false, new Object[] { Integer.valueOf(0), null, null, null, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(paramToServiceMsg.extraData.getInt("seq")), Integer.valueOf(paramFromServiceMsg.uint32_result.get()) });
            if (!QLog.isColorLevel()) {
              return;
            }
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("handleTroopOpenApiVerifyRsp: rspBody.uint32_result.get():");
            paramToServiceMsg.append(paramFromServiceMsg.uint32_result.get());
            QLog.d("TroopTokenHandler", 2, paramToServiceMsg.toString());
            return;
          }
          k = paramFromServiceMsg.uint32_frequency.get();
          paramToServiceMsg = paramFromServiceMsg.bytes_err_info.get().toStringUtf8();
          int m = paramFromServiceMsg.uint32_token_time_out.get();
          Object localObject = paramFromServiceMsg.rpt_bytes_apilist.get();
          paramObject = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            paramObject.add(((ByteStringMicro)((Iterator)localObject).next()).toStringUtf8());
          }
          notifyUI(TroopObserver.TYPE_NOTIFY_TROOP_OPEN_API_TOKEN_VERIFY, true, new Object[] { Integer.valueOf(i), str1, str2, str3, Integer.valueOf(k), Integer.valueOf(m), paramObject, Integer.valueOf(j), Integer.valueOf(paramFromServiceMsg.uint32_result.get()) });
          paramObject = new StringBuilder();
          paramObject.append("uint32_frequency:");
          paramObject.append(k);
          paramObject.append("|erroInfo:");
          paramObject.append(paramToServiceMsg);
          paramObject.append("|rpt_bytes_apilist:");
          paramObject.append(paramFromServiceMsg.rpt_bytes_apilist.get().toString());
          paramObject.append("|uint32_result:");
          paramObject.append(paramFromServiceMsg.uint32_result);
          QLog.d("TroopTokenHandler", 2, paramObject.toString());
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          notifyUI(TroopObserver.TYPE_NOTIFY_TROOP_OPEN_API_TOKEN_VERIFY, false, null);
          if (!QLog.isColorLevel()) {
            break label662;
          }
        }
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleTroopOpenApiVerifyRsp, onReceive");
        paramFromServiceMsg.append(paramToServiceMsg.toString());
        QLog.e("TroopTokenHandler.troop.openapi", 2, paramFromServiceMsg.toString());
      }
      else
      {
        notifyUI(TroopObserver.TYPE_NOTIFY_TROOP_OPEN_API_TOKEN_VERIFY, false, new Object[] { Integer.valueOf(0), null, null, null, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(j), Integer.valueOf(-1001) });
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleTroopOpenApiVerifyRsp: resp.getResultCode():");
          paramToServiceMsg.append(k);
          QLog.d("TroopTokenHandler", 2, paramToServiceMsg.toString());
        }
      }
      label662:
      return;
    }
    int j = TroopObserver.TYPE_NOTIFY_TROOP_OPEN_API_TOKEN_VERIFY;
    if (paramToServiceMsg == null) {
      i = -1;
    } else {
      i = paramToServiceMsg.extraData.getInt("seq");
    }
    notifyUI(j, false, new Object[] { Integer.valueOf(0), null, null, null, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(i), Integer.valueOf(-1001) });
    if (QLog.isColorLevel()) {
      QLog.d("TroopTokenHandler", 2, "handleTroopOpenApiVerifyRsp: req == null || resp == null");
    }
    return;
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      boolean bool2 = paramToServiceMsg.extraData.getBoolean("lastPage");
      paramToServiceMsg = new oidb_0x88d.RspBody();
      int j = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if ((j == 0) && (paramToServiceMsg.stzrspgroupinfo.has()))
      {
        paramObject = paramToServiceMsg.stzrspgroupinfo.get();
        int k = paramObject.size();
        int i = 0;
        boolean bool1;
        while (i < k)
        {
          paramToServiceMsg = (oidb_0x88d.RspGroupInfo)paramObject.get(i);
          long l = paramToServiceMsg.uint64_group_code.get();
          if (paramToServiceMsg.stgroupinfo.has())
          {
            oidb_0x88d.GroupInfo localGroupInfo = (oidb_0x88d.GroupInfo)paramToServiceMsg.stgroupinfo.get();
            ITroopInfoService localITroopInfoService = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
            paramFromServiceMsg = localITroopInfoService.findTroopInfo(String.valueOf(l));
            paramToServiceMsg = paramFromServiceMsg;
            if (paramFromServiceMsg == null)
            {
              paramToServiceMsg = new TroopInfo();
              paramToServiceMsg.troopuin = String.valueOf(l);
            }
            if (localGroupInfo.uint32_is_conf_group.has())
            {
              if (localGroupInfo.uint32_is_conf_group.get() == 1) {
                bool1 = true;
              } else {
                bool1 = false;
              }
              paramToServiceMsg.isNewTroop = bool1;
            }
            if (localGroupInfo.uint32_hl_guild_appid.has()) {
              paramToServiceMsg.hlGuildAppid = localGroupInfo.uint32_hl_guild_appid.get();
            }
            if (localGroupInfo.uint32_hl_guild_sub_type.has()) {
              paramToServiceMsg.hlGuildSubType = localGroupInfo.uint32_hl_guild_sub_type.get();
            }
            if (localGroupInfo.uint32_hl_guild_orgid.has()) {
              paramToServiceMsg.hlGuildOrgid = localGroupInfo.uint32_hl_guild_orgid.get();
            }
            if (localGroupInfo.uint32_is_allow_hl_guild_binary.has()) {
              paramToServiceMsg.hlGuildBinary = localGroupInfo.uint32_is_allow_hl_guild_binary.get();
            }
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("troop uin: ");
            paramFromServiceMsg.append(paramToServiceMsg.troopuin);
            paramFromServiceMsg.append(" isNewTroop:");
            paramFromServiceMsg.append(paramToServiceMsg.isNewTroop);
            paramFromServiceMsg.append(" hlGuideBinary: ");
            paramFromServiceMsg.append(paramToServiceMsg.hlGuildBinary);
            paramFromServiceMsg.append(" hlGuildAppid: ");
            paramFromServiceMsg.append(paramToServiceMsg.hlGuildAppid);
            paramFromServiceMsg.append(" hlGuildSubType: ");
            paramFromServiceMsg.append(paramToServiceMsg.hlGuildSubType);
            paramFromServiceMsg.append(" hlGuildOrgid: ");
            paramFromServiceMsg.append(paramToServiceMsg.hlGuildOrgid);
            QLog.i("TroopAbility.TroopHandler", 1, paramFromServiceMsg.toString());
            localITroopInfoService.saveTroopInfo(paramToServiceMsg);
          }
          i += 1;
        }
        i = TroopObserver.TYPE_NOTIFY_BATCH_GET_TROOP_PROFILE;
        if (j == 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        notifyUI(i, bool1, new Object[] { Boolean.valueOf(bool2) });
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getCreateTroopTokenForThirdApp appId: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" orgId: ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.i("TroopAbility.TroopHandler", 1, ((StringBuilder)localObject).toString());
    localObject = new Oidb_0xd22.ReqBody();
    Oidb_0xd22.AppInfo localAppInfo = new Oidb_0xd22.AppInfo();
    localAppInfo.appid.set(paramInt1);
    localAppInfo.organization_id.set(paramInt2);
    ((Oidb_0xd22.ReqBody)localObject).app_info.set(localAppInfo);
    sendPbReq(makeOIDBPkg("OidbSvc.0xd22_1", 3362, 1, ((Oidb_0xd22.ReqBody)localObject).toByteArray()));
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bindTroopForThirdApp appid: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" orgid: ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" troopUin: ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" appName: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("TroopAbility.TroopHandler", 1, ((StringBuilder)localObject).toString());
    localObject = new Oidb_0xd23.ReqBody();
    Oidb_0xd23.AppInfo localAppInfo = new Oidb_0xd23.AppInfo();
    localAppInfo.appid.set(paramInt1);
    localAppInfo.organization_id.set(paramInt2);
    Oidb_0xd23.GroupInfo localGroupInfo = new Oidb_0xd23.GroupInfo();
    localGroupInfo.group_code.set(paramLong);
    localGroupInfo.group_name.set(paramString);
    localAppInfo.group_info.set(localGroupInfo);
    ((Oidb_0xd23.ReqBody)localObject).app_info.set(localAppInfo);
    a(makeOIDBPkg("OidbSvc.0xd23_2", 3363, 2, ((Oidb_0xd23.ReqBody)localObject).toByteArray()));
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if ((paramInt1 != 0) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(1809);
      localOIDBSSOPkg.uint32_service_type.set(127);
      Object localObject = ByteBuffer.allocate(paramString1.getBytes().length + 6);
      ((ByteBuffer)localObject).putInt(paramInt1);
      ((ByteBuffer)localObject).putShort((short)paramString1.getBytes().length);
      ((ByteBuffer)localObject).put(paramString1.getBytes());
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      localObject = createToServiceMsg("OidbSvc.0x711_127");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).extraData.putString("openId", paramString1);
      ((ToServiceMsg)localObject).extraData.putString("token", paramString2);
      ((ToServiceMsg)localObject).extraData.putInt("appid", paramInt1);
      ((ToServiceMsg)localObject).extraData.putInt("seq", paramInt2);
      sendPbReq((ToServiceMsg)localObject);
    }
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    jstoken.ReqBody localReqBody = new jstoken.ReqBody();
    localReqBody.uint32_appid.set(paramInt1);
    if (!TextUtils.isEmpty(paramString1)) {
      localReqBody.bytes_group_openid.set(ByteStringMicro.copyFromUtf8(paramString1));
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localReqBody.bytes_jstoken.set(ByteStringMicro.copyFromUtf8(paramString2));
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localReqBody.bytes_url.set(ByteStringMicro.copyFromUtf8(paramString3));
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("GroupOpen.CheckJsApiToken");
    localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
    localToServiceMsg.extraData.putInt("appid", paramInt1);
    localToServiceMsg.extraData.putString("url", paramString3);
    localToServiceMsg.extraData.putString("openGroupId", paramString1);
    localToServiceMsg.extraData.putString("token", paramString2);
    localToServiceMsg.extraData.putInt("seq", paramInt2);
    sendPbReq(localToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopTokenHandler.troopTAG_GET_UIN_BY_OPEN_ID", 2, "handleOidb0x711_21Rsp:");
    }
    int i = paramToServiceMsg.extraData.getInt("appid");
    String str1 = paramToServiceMsg.extraData.getString("openId");
    String str2 = paramToServiceMsg.extraData.getString("token");
    int j = paramToServiceMsg.extraData.getInt("seq");
    if (!paramFromServiceMsg.isSuccess())
    {
      notifyUI(TroopObserver.TYPE_GET_UIN_BY_OPEN_ID, false, new Object[] { Integer.valueOf(i), str1, str2, "", Integer.valueOf(j), Integer.valueOf(paramFromServiceMsg.getResultCode()), null });
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      int k = paramToServiceMsg.uint32_result.get();
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("handleOidb0x711_21Rsp, resultCode:");
        paramObject.append(k);
        QLog.d("TroopTokenHandler.troopTAG_GET_UIN_BY_OPEN_ID", 2, paramObject.toString());
      }
      paramObject = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      if (k == 0)
      {
        paramToServiceMsg = new byte[4];
        System.arraycopy(paramObject, 0, paramToServiceMsg, 0, 4);
        paramObject = new StringBuilder();
        paramObject.append(ByteBuffer.wrap(paramToServiceMsg).getInt());
        paramObject.append("");
        paramToServiceMsg = paramObject.toString();
        paramObject = new Object();
        TroopTokenHandlerProcessorConfig.a().a(this.appRuntime, paramToServiceMsg, paramObject);
        notifyUI(TroopObserver.TYPE_GET_UIN_BY_OPEN_ID, true, new Object[] { Integer.valueOf(i), str1, str2, paramToServiceMsg, Integer.valueOf(j), Integer.valueOf(paramFromServiceMsg.getResultCode()), paramObject });
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("handleOidb0x711_21Rsp, uin:");
          paramObject.append(paramToServiceMsg);
          QLog.d("TroopTokenHandler.troopTAG_GET_UIN_BY_OPEN_ID", 2, paramObject.toString());
          return;
        }
      }
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("pkg.mergeFrom:");
        paramObject.append(paramToServiceMsg.toString());
        QLog.e(".troopTAG_GET_UIN_BY_OPEN_ID", 2, paramObject.toString());
      }
      notifyUI(TroopObserver.TYPE_GET_UIN_BY_OPEN_ID, false, new Object[] { Integer.valueOf(i), str1, str2, "", Integer.valueOf(j), Integer.valueOf(paramFromServiceMsg.getResultCode()), null });
    }
  }
  
  public void a(List<TroopInfo> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      oidb_0x88d.ReqBody localReqBody = new oidb_0x88d.ReqBody();
      localReqBody.uint32_appid.set(200000020);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TroopInfo localTroopInfo = (TroopInfo)paramList.next();
        oidb_0x88d.GroupInfo localGroupInfo = new oidb_0x88d.GroupInfo();
        localGroupInfo.uint32_is_conf_group.set(0);
        localGroupInfo.uint32_hl_guild_appid.set(0);
        localGroupInfo.uint32_hl_guild_sub_type.set(0);
        localGroupInfo.uint32_hl_guild_orgid.set(0);
        localGroupInfo.uint32_is_allow_hl_guild_binary.set(0);
        oidb_0x88d.ReqGroupInfo localReqGroupInfo = new oidb_0x88d.ReqGroupInfo();
        try
        {
          localReqGroupInfo.uint64_group_code.set(Long.parseLong(localTroopInfo.troopuin));
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.e("TroopTokenHandler", 1, localNumberFormatException, new Object[0]);
        }
        localReqGroupInfo.stgroupinfo.set(localGroupInfo);
        localReqBody.stzreqgroupinfo.add(localReqGroupInfo);
      }
      paramList = makeOIDBPkg("OidbSvc.0x88d_75", 2189, 75, localReqBody.toByteArray());
      paramList.extraData.putInt("subCmd", 12);
      paramList.extraData.putBoolean("lastPage", paramBoolean);
      a(paramList);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getJoinTroopTokenForThirdApp appId: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" organizationId: ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.i("TroopAbility.Handler", 1, ((StringBuilder)localObject).toString());
    localObject = new Oidb_0xd22.ReqBody();
    Oidb_0xd22.AppInfo localAppInfo = new Oidb_0xd22.AppInfo();
    localAppInfo.appid.set(paramInt1);
    localAppInfo.organization_id.set(paramInt2);
    ((Oidb_0xd22.ReqBody)localObject).app_info.set(localAppInfo);
    sendPbReq(makeOIDBPkg("OidbSvc.0xd22_2", 3362, 2, ((Oidb_0xd22.ReqBody)localObject).toByteArray()));
  }
  
  protected String dv_()
  {
    return "TroopTokenHandler";
  }
  
  public Set<String> getCommandList()
  {
    if (this.a == null)
    {
      this.a = new HashSet();
      this.a.add("OidbSvc.0xd22_1");
      this.a.add("OidbSvc.0xd22_2");
      this.a.add("OidbSvc.0xd23_2");
      this.a.add("GroupOpen.CheckJsApiToken");
      this.a.add("OidbSvc.0x88d_75");
      this.a.add("OidbSvc.0x711_127");
    }
    return this.a;
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
          QLog.d("TroopTokenHandler", 2, paramToServiceMsg.toString());
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
          QLog.d("TroopTokenHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("OidbSvc.0xd22_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xd22_2".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xd23_2".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("GroupOpen.CheckJsApiToken".equals(paramFromServiceMsg.getServiceCmd()))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x88d_75".equals(paramFromServiceMsg.getServiceCmd()))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x711_127".equals(paramFromServiceMsg.getServiceCmd())) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTokenHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopTokenHandler
 * JD-Core Version:    0.7.0.1
 */