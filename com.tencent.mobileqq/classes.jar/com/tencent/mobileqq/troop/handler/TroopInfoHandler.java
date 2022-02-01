package com.tencent.mobileqq.troop.handler;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopInfoExt;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.config.TroopInfoHandlerProcessorConfig;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupCardPrefix;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo;
import tencent.im.oidb.cmd0xef0.oidb_0xef0.GroupInfoExt;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopInfoHandler
  extends BusinessHandler
{
  protected ConcurrentHashMap<String, Long> a = new ConcurrentHashMap();
  
  public TroopInfoHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    TroopInfoHandlerProcessorConfig.a();
  }
  
  private TroopInfo a(String paramString, ToServiceMsg paramToServiceMsg, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("forceSave");
    ITroopInfoService localITroopInfoService = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
    paramToServiceMsg = localITroopInfoService.findTroopInfo(paramString);
    if (paramToServiceMsg == null)
    {
      paramToServiceMsg = new TroopInfo();
      paramToServiceMsg.troopuin = paramString;
    }
    for (;;)
    {
      TroopInfoHandlerProcessorConfig.a(this.appRuntime, paramToServiceMsg, paramGroupInfo);
      paramToServiceMsg.troopowneruin = String.valueOf(paramGroupInfo.uint64_group_owner.get());
      if (TextUtils.isEmpty(paramToServiceMsg.troopcode)) {
        paramToServiceMsg.troopcode = paramString;
      }
      paramToServiceMsg.troopname = paramGroupInfo.string_group_name.get().toStringUtf8();
      paramToServiceMsg.troopface = ((short)paramGroupInfo.uint32_group_face.get());
      paramToServiceMsg.troopmemo = paramGroupInfo.string_group_memo.get().toStringUtf8();
      paramToServiceMsg.fingertroopmemo = paramGroupInfo.string_group_finger_memo.get().toStringUtf8();
      paramToServiceMsg.mRichFingerMemo = paramGroupInfo.string_group_rich_finger_memo.get().toStringUtf8();
      oidb_0x88d.GroupGeoInfo localGroupGeoInfo = (oidb_0x88d.GroupGeoInfo)paramGroupInfo.group_geo_info.get();
      paramToServiceMsg.strLocation = localGroupGeoInfo.bytes_geocontent.get().toStringUtf8();
      paramToServiceMsg.troopLat = ((int)localGroupGeoInfo.int64_latitude.get());
      paramToServiceMsg.troopLon = ((int)localGroupGeoInfo.int64_longitude.get());
      paramToServiceMsg.troopTypeExt = paramGroupInfo.uint32_group_type_flag.get();
      paramToServiceMsg.dwGroupClassExt = paramGroupInfo.uint32_group_class_ext.get();
      paramToServiceMsg.dwCmdUinJoinTime = paramGroupInfo.uint32_cmduin_join_time.get();
      paramToServiceMsg.dwGroupFlagExt = paramGroupInfo.uint32_group_flag_ext.get();
      paramToServiceMsg.dwGroupFlag = paramGroupInfo.uint32_group_flag.get();
      if (paramGroupInfo.uint32_group_flagext3.has()) {
        paramToServiceMsg.dwGroupFlagExt3 = paramGroupInfo.uint32_group_flagext3.get();
      }
      if (paramGroupInfo.uint32_group_flagext4.has()) {
        paramToServiceMsg.groupFlagExt4 = paramGroupInfo.uint32_group_flagext4.get();
      }
      if (paramGroupInfo.uint32_cmduin_flag_ex3_grocery.has()) {
        paramToServiceMsg.cmduinFlagEx3Grocery = paramGroupInfo.uint32_cmduin_flag_ex3_grocery.get();
      }
      if (paramGroupInfo.bytes_cmduin_group_remark_name.has()) {
        paramToServiceMsg.troopRemark = paramGroupInfo.bytes_cmduin_group_remark_name.get().toStringUtf8();
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopInfoExtHandler", 2, "handleGetSimpleTroopInfo troopUin:" + paramToServiceMsg.troopuin + " dwGroupFlagExt3:" + paramToServiceMsg.dwGroupFlagExt3 + " isListenTogetherOpen: " + paramToServiceMsg.isListenTogetherOpen() + " isAVGameOpen: " + paramToServiceMsg.isAVGameOpen() + " troopInfo.isSharingLocation: " + paramToServiceMsg.isSharingLocation());
      }
      paramToServiceMsg.troopAuthenticateInfo = paramGroupInfo.string_certification_text.get().toStringUtf8();
      if ((paramToServiceMsg.dwGroupFlagExt & 0x80) == 0L)
      {
        bool1 = true;
        paramToServiceMsg.mMemberInvitingFlag = bool1;
        paramToServiceMsg.dwGagTimeStamp = paramGroupInfo.uint32_shutup_timestamp.get();
        if (paramGroupInfo.uint32_is_conf_group.get() != 1) {
          break label961;
        }
        bool1 = true;
        label507:
        paramToServiceMsg.isNewTroop = bool1;
        if (paramGroupInfo.uint32_is_modify_conf_group_face.get() != 1) {
          break label967;
        }
        bool1 = true;
        label527:
        paramToServiceMsg.hasSetNewTroopHead = bool1;
        if (paramGroupInfo.uint32_is_modify_conf_group_name.get() != 1) {
          break label973;
        }
        bool1 = true;
        label547:
        paramToServiceMsg.hasSetNewTroopName = bool1;
        paramToServiceMsg.wMemberNum = paramGroupInfo.uint32_group_member_num.get();
        a(paramString, paramGroupInfo, paramToServiceMsg);
        a(paramGroupInfo, paramToServiceMsg);
        b(paramString, paramGroupInfo, paramToServiceMsg);
        b(paramGroupInfo, paramToServiceMsg);
        c(paramGroupInfo, paramToServiceMsg);
        d(paramGroupInfo, paramToServiceMsg);
        e(paramGroupInfo, paramToServiceMsg);
        if ((!paramGroupInfo.uint32_cmduin_flag_ex2.has()) || (paramGroupInfo.uint32_cmduin_flag_ex2.get() == paramToServiceMsg.cmdUinFlagEx2)) {
          break label1050;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopInfoExtHandler", 2, new Object[] { "0x88d::switch, handleGetSimpleTroopInfo: invoked. ", " old: ", Long.valueOf(paramToServiceMsg.cmdUinFlagEx2), " new: ", Integer.valueOf(paramGroupInfo.uint32_cmduin_flag_ex2.get()), " troopuin: ", paramString });
        }
        paramToServiceMsg.cmdUinFlagEx2 = paramGroupInfo.uint32_cmduin_flag_ex2.get();
      }
      label1050:
      for (boolean bool1 = true;; bool1 = bool2)
      {
        bool2 = bool1;
        if (paramGroupInfo.uint32_cmduin_ringtone_id.has())
        {
          bool2 = bool1;
          if (paramGroupInfo.uint32_cmduin_ringtone_id.get() != paramToServiceMsg.udwCmdUinRingtoneID)
          {
            bool2 = bool1;
            if (paramGroupInfo.uint32_cmduin_ringtone_id.get() != 0)
            {
              if (QLog.isColorLevel()) {
                QLog.d("TroopInfoExtHandler", 2, new Object[] { "0x88d::ring id, handleGetSimpleTroopInfo: invoked. ", " old: ", Long.valueOf(paramToServiceMsg.udwCmdUinRingtoneID), " new: ", Integer.valueOf(paramGroupInfo.uint32_cmduin_ringtone_id.get()) });
              }
              paramToServiceMsg.udwCmdUinRingtoneID = paramGroupInfo.uint32_cmduin_ringtone_id.get();
              bool2 = true;
            }
          }
        }
        if (QLog.isColorLevel())
        {
          QLog.d(".troop.kingteam_troop", 2, "[handleGetSimpleTroopInfo], appID:" + paramToServiceMsg.hlGuildAppid + ",subType:" + paramToServiceMsg.hlGuildSubType);
          QLog.d("TroopInfoExtHandler", 2, "handleGetSimpleTroopInfo dwGagTimeStamp:" + paramToServiceMsg.dwGagTimeStamp + ",troopname:" + paramToServiceMsg.troopname + ",forceSave = " + bool2);
        }
        if (bool2) {
          localITroopInfoService.saveTroopInfo(paramToServiceMsg);
        }
        label961:
        label967:
        label973:
        do
        {
          do
          {
            return paramToServiceMsg;
            bool1 = false;
            break;
            bool1 = false;
            break label507;
            bool1 = false;
            break label527;
            bool1 = false;
            break label547;
          } while (!paramToServiceMsg.isAdmin());
          localITroopInfoService.saveTroopInfo(paramToServiceMsg);
        } while (!QLog.isDevelopLevel());
        QLog.i("TroopMngTest", 4, String.format("onGetSimpleTroopInfo [%s, %s, %s]", new Object[] { paramToServiceMsg.troopuin, Long.valueOf(paramToServiceMsg.dwGroupFlagExt3 & 0x100000), Integer.valueOf(paramToServiceMsg.nMsgLimitFreq) }));
        return paramToServiceMsg;
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    switch (paramToServiceMsg.extraData.getInt("subCmd", -1))
    {
    default: 
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void a(String paramString, Object paramObject, TroopInfoHandlerConfig paramTroopInfoHandlerConfig)
  {
    if (a(paramString, paramTroopInfoHandlerConfig))
    {
      if (!(paramObject instanceof PBUInt32Field)) {
        break label25;
      }
      ((PBUInt32Field)paramObject).set(0);
    }
    label25:
    do
    {
      return;
      if ((paramObject instanceof PBUInt64Field))
      {
        ((PBUInt64Field)paramObject).set(0L);
        return;
      }
      if ((paramObject instanceof PBBytesField))
      {
        ((PBBytesField)paramObject).set(ByteStringMicro.EMPTY);
        return;
      }
      if ((paramObject instanceof oidb_0x88d.GroupGeoInfo))
      {
        paramString = new oidb_0x88d.GroupGeoInfo();
        paramString.bytes_geocontent.set(ByteStringMicro.EMPTY);
        paramString.int64_latitude.set(0L);
        paramString.int64_longitude.set(0L);
        ((oidb_0x88d.GroupGeoInfo)paramObject).set(paramString);
        return;
      }
    } while (!(paramObject instanceof oidb_0x88d.GroupCardPrefix));
    paramString = new oidb_0x88d.GroupCardPrefix();
    paramString.bytes_introduction.set(ByteStringMicro.EMPTY);
    paramTroopInfoHandlerConfig = new ArrayList();
    paramTroopInfoHandlerConfig.add(ByteStringMicro.EMPTY);
    paramString.rpt_bytes_prefix.set(paramTroopInfoHandlerConfig);
    ((oidb_0x88d.GroupCardPrefix)paramObject).set(paramString);
  }
  
  private void a(String paramString, oidb_0x88d.GroupInfo paramGroupInfo, TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo.isNewTroop())
    {
      paramTroopInfo.maxInviteMemNum = paramGroupInfo.uint32_auto_agree_join_group_user_num_for_conf_group.get();
      return;
    }
    paramTroopInfo.maxInviteMemNum = paramGroupInfo.uint32_auto_agree_join_group_user_num_for_normal_group.get();
  }
  
  private void a(oidb_0x88d.GroupInfo paramGroupInfo, TroopInfo paramTroopInfo)
  {
    if (paramGroupInfo.string_long_group_name.has())
    {
      paramGroupInfo = paramGroupInfo.string_long_group_name.get().toStringUtf8();
      if (((!TextUtils.isEmpty(paramGroupInfo)) && (!paramTroopInfo.isNewTroop())) || (paramTroopInfo.hasSetNewTroopName))
      {
        paramTroopInfo.troopname = paramGroupInfo;
        if (paramTroopInfo.newTroopName == null) {
          paramTroopInfo.newTroopName = paramTroopInfo.troopname;
        }
      }
    }
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.equals("TroopMemberApiService.create_troop")) && (!paramString.equals("TroopCreateLogic.create_new_troop")) && (!paramString.equals("SubType0x44.source_apply_for_join_troop")) && (!paramString.equals("SystemMessageProcessor.AgreeGroupInvation")) && (!paramString.equals("getGroupInfoFromChatSettingForTroop"))) {
      return false;
    }
    return true;
  }
  
  private boolean a(String paramString, TroopInfoHandlerConfig paramTroopInfoHandlerConfig)
  {
    if ((paramTroopInfoHandlerConfig != null) && (paramTroopInfoHandlerConfig.a(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopInfoExtHandler", 2, "shouldRequest88dFieldInConfigForAio = false, name = " + paramString);
      }
      return false;
    }
    return true;
  }
  
  private Object[] a(long paramLong, ToServiceMsg paramToServiceMsg, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    localObject2 = null;
    bool3 = false;
    bool2 = false;
    int m = 0;
    n = 0;
    k = 0;
    i = 0;
    j = m;
    bool1 = bool2;
    localObject1 = localObject2;
    if (paramOIDBSSOPkg != null)
    {
      j = m;
      bool1 = bool2;
      localObject1 = localObject2;
      if (paramOIDBSSOPkg.bytes_bodybuffer.has())
      {
        j = m;
        bool1 = bool2;
        localObject1 = localObject2;
        if (paramOIDBSSOPkg.bytes_bodybuffer.get() != null) {
          paramOIDBSSOPkg = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
        }
      }
    }
    try
    {
      localObject1 = new oidb_0x88d.RspBody();
      ((oidb_0x88d.RspBody)localObject1).mergeFrom(paramOIDBSSOPkg);
      paramOIDBSSOPkg = null;
      j = k;
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        try
        {
          label142:
          oidb_0x88d.RspGroupInfo localRspGroupInfo;
          label201:
          paramToServiceMsg = a(String.valueOf(paramLong), paramToServiceMsg, paramOIDBSSOPkg);
          localObject1 = paramToServiceMsg;
          j = i;
          return new Object[] { localObject1, Boolean.valueOf(bool1), null, Integer.valueOf(j) };
        }
        catch (Exception paramToServiceMsg)
        {
          bool2 = true;
          continue;
        }
        paramToServiceMsg = paramToServiceMsg;
        bool2 = bool3;
        i = n;
        j = i;
        bool1 = bool2;
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.troopdisband.", 2, paramToServiceMsg.toString());
          j = i;
          bool1 = bool2;
          localObject1 = localObject2;
        }
      }
    }
    try
    {
      localObject1 = ((oidb_0x88d.RspBody)localObject1).stzrspgroupinfo.get();
      if (localObject1 != null) {
        break label201;
      }
      m = 0;
    }
    catch (Exception paramToServiceMsg)
    {
      i = j;
      bool2 = bool3;
      break label345;
      bool1 = false;
      paramToServiceMsg = null;
      break label299;
      i = k;
      break label429;
      n = 0;
      break label142;
      n += 1;
      break label142;
    }
    if ((paramOIDBSSOPkg == null) && (n < m))
    {
      j = i;
      localRspGroupInfo = (oidb_0x88d.RspGroupInfo)((List)localObject1).get(n);
      k = i;
      if (localRspGroupInfo != null)
      {
        j = i;
        if (localRspGroupInfo.uint64_group_code.get() != paramLong)
        {
          break label429;
          j = k;
          m = ((List)localObject1).size();
          break label423;
        }
        j = i;
        i = localRspGroupInfo.uint32_result.get();
        k = i;
        if (i == 0)
        {
          j = i;
          k = i;
          if (localRspGroupInfo.stgroupinfo.has())
          {
            j = i;
            paramOIDBSSOPkg = (oidb_0x88d.GroupInfo)localRspGroupInfo.stgroupinfo.get();
            break label429;
          }
        }
      }
    }
    else if (paramOIDBSSOPkg != null)
    {
      bool1 = true;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    long l = paramToServiceMsg.extraData.getLong("troop_uin");
    int k = paramToServiceMsg.extraData.getInt("nFlag");
    String str = paramToServiceMsg.extraData.getString("source");
    boolean bool4 = paramToServiceMsg.extraData.getBoolean("simpleNotify");
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("oldGroupReqNotify", false);
    if ((paramFromServiceMsg.getResultCode() == 1000) && (paramObject != null))
    {
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = paramObject;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        for (;;)
        {
          int j;
          if (QLog.isColorLevel()) {
            QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_0|oidb_sso parseFrom byte " + paramObject.toString());
          }
          paramObject.printStackTrace();
          continue;
          boolean bool1 = false;
          paramFromServiceMsg = null;
          paramToServiceMsg = null;
          continue;
          int i = -1;
        }
      }
      if (paramFromServiceMsg != null)
      {
        j = paramFromServiceMsg.uint32_result.get();
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_0|oidb_sso.OIDBSSOPkg.result " + j);
          i = j;
        }
        if (i == 0)
        {
          paramObject = a(l, paramToServiceMsg, paramFromServiceMsg);
          paramToServiceMsg = localObject2;
          if (paramObject[0] != null) {
            paramToServiceMsg = (TroopInfo)paramObject[0];
          }
          bool1 = ((Boolean)paramObject[1]).booleanValue();
          paramFromServiceMsg = localObject1;
          if (paramObject[2] != null) {
            paramFromServiceMsg = (String)paramObject[2];
          }
          i = ((Integer)paramObject[3]).intValue();
          bool2 = bool1;
          if (bool4) {
            notifyUI(TroopNotificationConstants.I, bool1, new Object[] { Long.valueOf(l), Integer.valueOf(k), paramToServiceMsg, Integer.valueOf(i), paramFromServiceMsg, str });
          }
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = false)
    {
      if (bool3) {
        notifyUI(TroopNotificationConstants.i, bool2, String.valueOf(l));
      }
      return;
    }
  }
  
  private void b(String paramString, oidb_0x88d.GroupInfo paramGroupInfo, TroopInfo paramTroopInfo)
  {
    if (paramGroupInfo.uint32_cmduin_new_mobile_flag.has()) {
      paramTroopInfo.troopmask = paramGroupInfo.uint32_cmduin_new_mobile_flag.get();
    }
  }
  
  private void b(oidb_0x88d.GroupInfo paramGroupInfo, TroopInfo paramTroopInfo)
  {
    if (paramGroupInfo.uint32_hl_guild_appid.has()) {
      paramTroopInfo.hlGuildAppid = paramGroupInfo.uint32_hl_guild_appid.get();
    }
    if (paramGroupInfo.uint32_hl_guild_orgid.has()) {
      paramTroopInfo.hlGuildOrgid = paramGroupInfo.uint32_hl_guild_orgid.get();
    }
    if (paramGroupInfo.uint32_is_allow_hl_guild_binary.has()) {
      paramTroopInfo.hlGuildBinary = paramGroupInfo.uint32_is_allow_hl_guild_binary.get();
    }
    if (paramGroupInfo.uint32_hl_guild_sub_type.has()) {
      paramTroopInfo.hlGuildSubType = paramGroupInfo.uint32_hl_guild_sub_type.get();
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bool3 = false;
    bool1 = false;
    localObject5 = null;
    Object localObject6 = null;
    localObject3 = null;
    localObject4 = null;
    Object localObject7 = null;
    l = paramToServiceMsg.extraData.getLong("troop_uin");
    i1 = paramToServiceMsg.extraData.getInt("nFlag");
    j = -1;
    localObject2 = localObject6;
    localObject1 = localObject7;
    bool2 = bool1;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramToServiceMsg = new TroopInfoHandler.HandleOidb0x88d10InitPkg(this, (byte[])paramObject, -1).a();
      i = paramToServiceMsg.a();
      paramToServiceMsg = paramToServiceMsg.a();
      localObject2 = localObject6;
      j = i;
      localObject1 = localObject7;
      bool2 = bool1;
      if (paramToServiceMsg != null)
      {
        localObject2 = localObject6;
        j = i;
        localObject1 = localObject7;
        bool2 = bool1;
        if (paramToServiceMsg.bytes_bodybuffer.has())
        {
          localObject2 = localObject6;
          j = i;
          localObject1 = localObject7;
          bool2 = bool1;
          if (paramToServiceMsg.bytes_bodybuffer.get() != null) {
            paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
          }
        }
      }
    }
    try
    {
      paramObject = new oidb_0x88d.RspBody();
      paramObject.mergeFrom(paramToServiceMsg);
      if ((i == 0) || (!paramObject.str_errorinfo.has())) {
        break label781;
      }
      paramToServiceMsg = String.valueOf(paramObject.str_errorinfo.get().toByteArray());
    }
    catch (Exception paramFromServiceMsg)
    {
      for (;;)
      {
        int n;
        try
        {
          paramObject = paramObject.stzrspgroupinfo.get();
          int m;
          if (paramObject == null)
          {
            m = 0;
            break label786;
            if ((paramFromServiceMsg != null) || (n >= m)) {
              continue;
            }
            j = i;
            localObject1 = (oidb_0x88d.RspGroupInfo)paramObject.get(n);
            k = i;
            if (localObject1 == null) {
              continue;
            }
            j = i;
            if (((oidb_0x88d.RspGroupInfo)localObject1).uint64_group_code.get() != l) {
              break label792;
            }
          }
          else
          {
            j = i;
            m = paramObject.size();
            break label786;
          }
          j = i;
          i = ((oidb_0x88d.RspGroupInfo)localObject1).uint32_result.get();
          k = i;
          if (i != 0) {
            continue;
          }
          j = i;
          k = i;
          if (!((oidb_0x88d.RspGroupInfo)localObject1).stgroupinfo.has()) {
            continue;
          }
          j = i;
          paramFromServiceMsg = (oidb_0x88d.GroupInfo)((oidb_0x88d.RspGroupInfo)localObject1).stgroupinfo.get();
          break label792;
          if (paramFromServiceMsg == null) {
            continue;
          }
          bool2 = true;
          paramObject = localObject4;
        }
        catch (Exception paramFromServiceMsg)
        {
          int k;
          i = j;
          paramObject = localObject3;
          bool1 = bool3;
          continue;
          localObject1 = null;
          bool1 = false;
          continue;
          i = k;
        }
        try
        {
          localObject1 = ((ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(String.valueOf(l));
          if (localObject1 != null) {
            continue;
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          bool1 = true;
          continue;
          paramObject = localObject1;
          continue;
        }
        try
        {
          localObject2 = new TroopInfo();
          paramObject = localObject2;
          ((TroopInfo)localObject2).troopuin = String.valueOf(l);
          paramObject = localObject2;
        }
        catch (Exception paramFromServiceMsg)
        {
          paramObject = localObject1;
          bool1 = true;
          continue;
        }
        try
        {
          if (paramFromServiceMsg.uint32_group_class_ext.has())
          {
            paramObject.dwGroupClassExt = paramFromServiceMsg.uint32_group_class_ext.get();
            if (QLog.isColorLevel()) {
              QLog.d("TroopInfoExtHandler", 2, "handle_oidb_0x88d_10|troopCreateTime " + paramObject.troopCreateTime);
            }
          }
          localObject1 = paramObject;
          bool1 = bool2;
          if (paramFromServiceMsg.uint64_group_owner.has())
          {
            paramObject.troopowneruin = ("" + paramFromServiceMsg.uint64_group_owner.get());
            localObject1 = paramObject;
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("TroopInfoExtHandler", 2, "handle_oidb_0x88d_10|troopowneruin " + paramObject.troopowneruin);
              bool1 = bool2;
              localObject1 = paramObject;
            }
          }
          bool2 = bool1;
          j = i;
          localObject2 = paramToServiceMsg;
          notifyUI(TroopNotificationConstants.Z, bool2, new Object[] { Long.valueOf(l), Integer.valueOf(i1), localObject1, Integer.valueOf(j), localObject2 });
          return;
        }
        catch (Exception paramFromServiceMsg)
        {
          bool1 = true;
          continue;
        }
        paramFromServiceMsg = paramFromServiceMsg;
        bool1 = bool3;
        paramObject = localObject3;
        paramToServiceMsg = localObject5;
        localObject2 = paramToServiceMsg;
        j = i;
        localObject1 = paramObject;
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.i("TroopInfoExtHandler", 2, paramFromServiceMsg.toString());
          localObject2 = paramToServiceMsg;
          j = i;
          localObject1 = paramObject;
          bool2 = bool1;
          continue;
          paramToServiceMsg = null;
          continue;
          n = 0;
          continue;
          n += 1;
        }
      }
    }
    paramFromServiceMsg = null;
    j = i;
  }
  
  private void c(oidb_0x88d.GroupInfo paramGroupInfo, TroopInfo paramTroopInfo)
  {
    if (paramGroupInfo.uint32_msg_limit_frequency.has()) {
      paramTroopInfo.nMsgLimitFreq = paramGroupInfo.uint32_msg_limit_frequency.get();
    }
    if (paramGroupInfo.uint32_is_allow_recall_msg.has()) {
      paramTroopInfo.isAllowHistoryMsgFlag = paramGroupInfo.uint32_is_allow_recall_msg.get();
    }
  }
  
  private void d(oidb_0x88d.GroupInfo paramGroupInfo, TroopInfo paramTroopInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramGroupInfo.st_group_card_prefix.has())
    {
      paramGroupInfo = (oidb_0x88d.GroupCardPrefix)paramGroupInfo.st_group_card_prefix.get();
      if (paramGroupInfo.bytes_introduction.has()) {}
      for (paramTroopInfo.groupCardPrefixIntro = paramGroupInfo.bytes_introduction.get().toStringUtf8(); paramGroupInfo.rpt_bytes_prefix.has(); paramTroopInfo.groupCardPrefixIntro = "")
      {
        paramGroupInfo = paramGroupInfo.rpt_bytes_prefix.get().iterator();
        while (paramGroupInfo.hasNext()) {
          localArrayList.add(((ByteStringMicro)paramGroupInfo.next()).toStringUtf8());
        }
      }
      paramTroopInfo.setGroupCardPrefix(localArrayList);
      return;
    }
    paramTroopInfo.groupCardPrefixIntro = "";
    paramTroopInfo.setGroupCardPrefix(localArrayList);
  }
  
  private void e(oidb_0x88d.GroupInfo paramGroupInfo, TroopInfo paramTroopInfo)
  {
    if (paramGroupInfo.st_group_info_ext.has())
    {
      paramTroopInfo.mTroopInfoExtObj = TroopInfoExt.parseFromGroupInfoExt((oidb_0xef0.GroupInfoExt)paramGroupInfo.st_group_info_ext.get());
      if (QLog.isColorLevel()) {
        QLog.i("TroopInfoExtHandler", 2, "handleGetSimpleTroopInfo_rspBody_updateGroupInfoExt troopUin:" + paramTroopInfo.troopuin + " uint32_group_info_ext_seq:" + paramTroopInfo.mTroopInfoExtObj.groupInfoExtSeq);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.getTroopMemberLevelInfo", 2, "getSimpleTroopInfoForAio groupCode:" + paramString);
    }
    try
    {
      localObject1 = (TroopInfoHandlerConfig)QConfigManager.a().a(712);
      localObject3 = new oidb_0x88d.GroupInfo();
      a("string_group_name", ((oidb_0x88d.GroupInfo)localObject3).string_group_name, (TroopInfoHandlerConfig)localObject1);
      a("string_long_group_name", ((oidb_0x88d.GroupInfo)localObject3).string_long_group_name, (TroopInfoHandlerConfig)localObject1);
      a("uint32_group_face", ((oidb_0x88d.GroupInfo)localObject3).uint32_group_face, (TroopInfoHandlerConfig)localObject1);
      a("uint32_group_flag_ext", ((oidb_0x88d.GroupInfo)localObject3).uint32_group_flag_ext, (TroopInfoHandlerConfig)localObject1);
      a("uint32_group_flagext3", ((oidb_0x88d.GroupInfo)localObject3).uint32_group_flagext3, (TroopInfoHandlerConfig)localObject1);
      a("uint32_group_flag", ((oidb_0x88d.GroupInfo)localObject3).uint32_group_flag, (TroopInfoHandlerConfig)localObject1);
      a("string_group_rich_finger_memo", ((oidb_0x88d.GroupInfo)localObject3).string_group_rich_finger_memo, (TroopInfoHandlerConfig)localObject1);
      a("uint64_group_owner", ((oidb_0x88d.GroupInfo)localObject3).uint64_group_owner, (TroopInfoHandlerConfig)localObject1);
      a("uint32_group_class_ext", ((oidb_0x88d.GroupInfo)localObject3).uint32_group_class_ext, (TroopInfoHandlerConfig)localObject1);
      a("uint32_cmduin_join_time", ((oidb_0x88d.GroupInfo)localObject3).uint32_cmduin_join_time, (TroopInfoHandlerConfig)localObject1);
      a("uint32_group_type_flag", ((oidb_0x88d.GroupInfo)localObject3).uint32_group_type_flag, (TroopInfoHandlerConfig)localObject1);
      a("uint32_cmduin_flag_ex2", ((oidb_0x88d.GroupInfo)localObject3).uint32_cmduin_flag_ex2, (TroopInfoHandlerConfig)localObject1);
      a("uint32_cmduin_ringtone_id", ((oidb_0x88d.GroupInfo)localObject3).uint32_cmduin_ringtone_id, (TroopInfoHandlerConfig)localObject1);
      a("uint32_shutup_timestamp", ((oidb_0x88d.GroupInfo)localObject3).uint32_shutup_timestamp, (TroopInfoHandlerConfig)localObject1);
      a("uint32_is_conf_group", ((oidb_0x88d.GroupInfo)localObject3).uint32_is_conf_group, (TroopInfoHandlerConfig)localObject1);
      a("uint32_is_modify_conf_group_face", ((oidb_0x88d.GroupInfo)localObject3).uint32_is_modify_conf_group_face, (TroopInfoHandlerConfig)localObject1);
      a("uint32_is_modify_conf_group_name", ((oidb_0x88d.GroupInfo)localObject3).uint32_is_modify_conf_group_name, (TroopInfoHandlerConfig)localObject1);
      a("uint32_group_member_num", ((oidb_0x88d.GroupInfo)localObject3).uint32_group_member_num, (TroopInfoHandlerConfig)localObject1);
      a("uint32_auto_agree_join_group_user_num_for_conf_group", ((oidb_0x88d.GroupInfo)localObject3).uint32_auto_agree_join_group_user_num_for_conf_group, (TroopInfoHandlerConfig)localObject1);
      a("uint32_auto_agree_join_group_user_num_for_normal_group", ((oidb_0x88d.GroupInfo)localObject3).uint32_auto_agree_join_group_user_num_for_normal_group, (TroopInfoHandlerConfig)localObject1);
      a("uint32_msg_limit_frequency", ((oidb_0x88d.GroupInfo)localObject3).uint32_msg_limit_frequency, (TroopInfoHandlerConfig)localObject1);
      a("uint32_is_allow_recall_msg", ((oidb_0x88d.GroupInfo)localObject3).uint32_is_allow_recall_msg, (TroopInfoHandlerConfig)localObject1);
      a("uint32_hl_guild_appid", ((oidb_0x88d.GroupInfo)localObject3).uint32_hl_guild_appid, (TroopInfoHandlerConfig)localObject1);
      a("uint32_hl_guild_sub_type", ((oidb_0x88d.GroupInfo)localObject3).uint32_hl_guild_sub_type, (TroopInfoHandlerConfig)localObject1);
      a("string_group_finger_memo", ((oidb_0x88d.GroupInfo)localObject3).string_group_finger_memo, (TroopInfoHandlerConfig)localObject1);
      a("string_group_memo", ((oidb_0x88d.GroupInfo)localObject3).string_group_memo, (TroopInfoHandlerConfig)localObject1);
      a("string_certification_text", ((oidb_0x88d.GroupInfo)localObject3).string_certification_text, (TroopInfoHandlerConfig)localObject1);
      a("group_geo_info", ((oidb_0x88d.GroupInfo)localObject3).group_geo_info, (TroopInfoHandlerConfig)localObject1);
      a("bytes_group_school_info", ((oidb_0x88d.GroupInfo)localObject3).bytes_group_school_info, (TroopInfoHandlerConfig)localObject1);
      a("st_group_card_prefix", ((oidb_0x88d.GroupInfo)localObject3).st_group_card_prefix, (TroopInfoHandlerConfig)localObject1);
      localObject1 = new oidb_0x88d.ReqGroupInfo();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(Long.parseLong(paramString));
          ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject3);
          Object localObject3 = new oidb_0x88d.ReqBody();
          ((oidb_0x88d.ReqBody)localObject3).uint32_appid.set(200010022);
          ((oidb_0x88d.ReqBody)localObject3).stzreqgroupinfo.add((MessageMicro)localObject1);
          Object localObject1 = new oidb_sso.OIDBSSOPkg();
          ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
          ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
          ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject3).toByteArray()));
          localObject3 = createToServiceMsg("OidbSvc.0x88d_0");
          ((ToServiceMsg)localObject3).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
          ((ToServiceMsg)localObject3).extraData.putLong("troop_uin", Long.parseLong(paramString));
          ((ToServiceMsg)localObject3).extraData.putInt("subCmd", 4);
          ((ToServiceMsg)localObject3).extraData.putString("source", "AIO");
          ((ToServiceMsg)localObject3).extraData.putBoolean("forceSave", false);
          ((ToServiceMsg)localObject3).extraData.putBoolean("simpleNotify", true);
          ((ToServiceMsg)localObject3).setTimeout(30000L);
          sendPbReq((ToServiceMsg)localObject3);
          return;
        }
        catch (NumberFormatException paramString)
        {
          Object localObject2;
          QLog.e("TroopInfoExtHandler", 1, paramString, new Object[0]);
        }
        localException = localException;
        if (QLog.isColorLevel()) {
          QLog.e("TroopInfoExtHandler", 2, localException.getMessage());
        }
        localObject2 = null;
      }
    }
  }
  
  public void a(String paramString1, long paramLong, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoExtHandler", 2, "getGroupInfoReq, troopuin = " + paramString1);
    }
    if (TextUtils.isEmpty(paramString1)) {}
    Long localLong1;
    do
    {
      return;
      localLong1 = Long.valueOf(SystemClock.uptimeMillis());
      Long localLong2 = (Long)this.a.get(paramString1);
      if ((localLong2 == null) || (Math.abs(localLong1.longValue() - localLong2.longValue()) >= paramLong)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopInfoExtHandler", 2, "getGroupInfoReq return, troopuin = " + paramString1);
    return;
    this.a.put(paramString1, localLong1);
    a(paramString1, false, paramString2, true, false, true, false);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, 10000L, paramString2);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    a(paramString, paramBoolean, "", false, true, false, false);
  }
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.getTroopMemberLevelInfo", 2, "getSimpleTroopInfo groupCode:" + paramString1 + ",forceSave = " + paramBoolean2 + ",source = " + paramString2);
    }
    Object localObject1 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject1).string_group_finger_memo.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).bytes_group_school_info.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).string_group_memo.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).string_group_name.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_face.set(0);
    Object localObject2 = new oidb_0x88d.GroupGeoInfo();
    ((oidb_0x88d.GroupGeoInfo)localObject2).bytes_geocontent.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupGeoInfo)localObject2).int64_latitude.set(0L);
    ((oidb_0x88d.GroupGeoInfo)localObject2).int64_longitude.set(0L);
    ((oidb_0x88d.GroupInfo)localObject1).group_geo_info.set((MessageMicro)localObject2);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_flag_ext.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_flagext3.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_flag.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).string_certification_text.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).string_group_rich_finger_memo.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).uint64_group_owner.set(0L);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_class_ext.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_cmduin_join_time.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_type_flag.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_cmduin_flag_ex2.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_cmduin_ringtone_id.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_shutup_timestamp.set(1);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_is_conf_group.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_is_modify_conf_group_face.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_is_modify_conf_group_name.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).string_long_group_name.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_member_num.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_auto_agree_join_group_user_num_for_conf_group.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_auto_agree_join_group_user_num_for_normal_group.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_cmduin_flag_ex3_grocery.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_flagext4.set(0);
    localObject2 = new oidb_0x88d.GroupCardPrefix();
    ((oidb_0x88d.GroupCardPrefix)localObject2).bytes_introduction.set(ByteStringMicro.EMPTY);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupCardPrefix)localObject2).rpt_bytes_prefix.set(localArrayList);
    ((oidb_0x88d.GroupInfo)localObject1).st_group_card_prefix.set((MessageMicro)localObject2);
    if (a(paramString2))
    {
      TroopInfoExtHandler.a((oidb_0x88d.GroupInfo)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("TroopInfoExtHandler", 2, "fillGroupInfoExt0x88d groupUin:" + paramString1);
      }
    }
    ((oidb_0x88d.GroupInfo)localObject1).bytes_cmduin_group_remark_name.set(ByteStringMicro.EMPTY);
    if (paramBoolean5) {
      ((oidb_0x88d.GroupInfo)localObject1).uint32_cmduin_new_mobile_flag.set(0);
    }
    ((oidb_0x88d.GroupInfo)localObject1).uint32_msg_limit_frequency.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_hl_guild_appid.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_hl_guild_sub_type.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_is_allow_recall_msg.set(0);
    localObject2 = new oidb_0x88d.ReqGroupInfo();
    try
    {
      ((oidb_0x88d.ReqGroupInfo)localObject2).uint64_group_code.set(Long.parseLong(paramString1));
      ((oidb_0x88d.ReqGroupInfo)localObject2).stgroupinfo.set((MessageMicro)localObject1);
      localObject1 = new oidb_0x88d.ReqBody();
      ((oidb_0x88d.ReqBody)localObject1).uint32_appid.set(200010024);
      ((oidb_0x88d.ReqBody)localObject1).stzreqgroupinfo.add((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2189);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
      if (paramBoolean1) {
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(19);
      }
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject1).toByteArray()));
      localObject1 = createToServiceMsg("OidbSvc.0x88d_0");
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putLong("troop_uin", Long.parseLong(paramString1));
      ((ToServiceMsg)localObject1).extraData.putInt("subCmd", 4);
      ((ToServiceMsg)localObject1).extraData.putString("source", paramString2);
      ((ToServiceMsg)localObject1).extraData.putBoolean("forceSave", paramBoolean2);
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      ((ToServiceMsg)localObject1).extraData.putBoolean("simpleNotify", paramBoolean3);
      ((ToServiceMsg)localObject1).extraData.putBoolean("oldGroupReqNotify", paramBoolean4);
      sendPbReq((ToServiceMsg)localObject1);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      QLog.e("TroopInfoExtHandler", 1, paramString1, new Object[0]);
    }
  }
  
  public void b(String paramString)
  {
    a(paramString, 10000L, "");
  }
  
  public void c(String paramString)
  {
    Object localObject2 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject2).string_group_finger_memo.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject2).string_group_memo.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject2).string_group_name.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject2).uint32_group_face.set(0);
    ((oidb_0x88d.GroupInfo)localObject2).uint32_group_flag_ext.set(0);
    ((oidb_0x88d.GroupInfo)localObject2).uint32_group_type_flag.set(0);
    ((oidb_0x88d.GroupInfo)localObject2).string_certification_text.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject2).string_group_rich_finger_memo.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject2).uint64_group_owner.set(0L);
    ((oidb_0x88d.GroupInfo)localObject2).uint32_group_class_ext.set(0);
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(Long.parseLong(paramString));
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(AppSetting.a());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(10);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
    localObject2 = createToServiceMsg("OidbSvc.0x88d_10");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putLong("troop_uin", Long.parseLong(paramString));
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x88d_0");
      this.allowCmdSet.add("OidbSvc.0x88d_10");
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
      if ("OidbSvc.0x88d_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x88d_10".equals(paramFromServiceMsg.getServiceCmd()));
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopInfoHandler
 * JD-Core Version:    0.7.0.1
 */