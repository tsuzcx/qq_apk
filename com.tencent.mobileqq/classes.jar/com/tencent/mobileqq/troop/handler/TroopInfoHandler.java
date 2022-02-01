package com.tencent.mobileqq.troop.handler;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
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
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.config.TroopInfoHandlerProcessorConfig;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
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
import tencent.im.oidb.cmd0x88d.oidb_0x88d.TagRecord;
import tencent.im.oidb.cmd0xef0.oidb_0xef0.GroupInfoExt;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopInfoHandler
  extends TroopBaseHandler
  implements ITroopInfoHandler
{
  private static HashMap<Long, byte[]> b = new HashMap();
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
    Object localObject = localITroopInfoService.findTroopInfo(paramString);
    paramToServiceMsg = (ToServiceMsg)localObject;
    if (localObject == null)
    {
      paramToServiceMsg = new TroopInfo();
      paramToServiceMsg.troopuin = paramString;
    }
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
    localObject = (oidb_0x88d.GroupGeoInfo)paramGroupInfo.group_geo_info.get();
    paramToServiceMsg.strLocation = ((oidb_0x88d.GroupGeoInfo)localObject).bytes_geocontent.get().toStringUtf8();
    paramToServiceMsg.troopLat = ((int)((oidb_0x88d.GroupGeoInfo)localObject).int64_latitude.get());
    paramToServiceMsg.troopLon = ((int)((oidb_0x88d.GroupGeoInfo)localObject).int64_longitude.get());
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleGetSimpleTroopInfo troopUin:");
      ((StringBuilder)localObject).append(paramToServiceMsg.troopuin);
      ((StringBuilder)localObject).append(" dwGroupFlagExt3:");
      ((StringBuilder)localObject).append(paramToServiceMsg.dwGroupFlagExt3);
      ((StringBuilder)localObject).append(" isListenTogetherOpen: ");
      ((StringBuilder)localObject).append(paramToServiceMsg.isListenTogetherOpen());
      ((StringBuilder)localObject).append(" isAVGameOpen: ");
      ((StringBuilder)localObject).append(paramToServiceMsg.isAVGameOpen());
      ((StringBuilder)localObject).append(" troopInfo.isSharingLocation: ");
      ((StringBuilder)localObject).append(paramToServiceMsg.isSharingLocation());
      QLog.i("TroopInfoHandler", 2, ((StringBuilder)localObject).toString());
    }
    paramToServiceMsg.troopAuthenticateInfo = paramGroupInfo.string_certification_text.get().toStringUtf8();
    boolean bool1;
    if ((paramToServiceMsg.dwGroupFlagExt & 0x80) == 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramToServiceMsg.mMemberInvitingFlag = bool1;
    paramToServiceMsg.dwGagTimeStamp = paramGroupInfo.uint32_shutup_timestamp.get();
    if (paramGroupInfo.uint32_is_conf_group.get() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramToServiceMsg.isNewTroop = bool1;
    if (paramGroupInfo.uint32_is_modify_conf_group_face.get() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramToServiceMsg.hasSetNewTroopHead = bool1;
    if (paramGroupInfo.uint32_is_modify_conf_group_name.get() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramToServiceMsg.hasSetNewTroopName = bool1;
    paramToServiceMsg.wMemberNum = paramGroupInfo.uint32_group_member_num.get();
    a(paramString, paramGroupInfo, paramToServiceMsg);
    a(paramGroupInfo, paramToServiceMsg);
    b(paramString, paramGroupInfo, paramToServiceMsg);
    b(paramGroupInfo, paramToServiceMsg);
    c(paramGroupInfo, paramToServiceMsg);
    d(paramGroupInfo, paramToServiceMsg);
    e(paramGroupInfo, paramToServiceMsg);
    if (paramGroupInfo.uint32_cmduin_flag_ex2.has())
    {
      bool1 = bool2;
      if (paramGroupInfo.uint32_cmduin_flag_ex2.get() != paramToServiceMsg.cmdUinFlagEx2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopInfoHandler", 2, new Object[] { "0x88d::switch, handleGetSimpleTroopInfo: invoked. ", " old: ", Long.valueOf(paramToServiceMsg.cmdUinFlagEx2), " new: ", Integer.valueOf(paramGroupInfo.uint32_cmduin_flag_ex2.get()), " troopuin: ", paramString });
        }
        paramToServiceMsg.cmdUinFlagEx2 = paramGroupInfo.uint32_cmduin_flag_ex2.get();
        bool1 = true;
      }
    }
    else
    {
      bool1 = bool2;
    }
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
            QLog.d("TroopInfoHandler", 2, new Object[] { "0x88d::ring id, handleGetSimpleTroopInfo: invoked. ", " old: ", Long.valueOf(paramToServiceMsg.udwCmdUinRingtoneID), " new: ", Integer.valueOf(paramGroupInfo.uint32_cmduin_ringtone_id.get()) });
          }
          paramToServiceMsg.udwCmdUinRingtoneID = paramGroupInfo.uint32_cmduin_ringtone_id.get();
          bool2 = true;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("[handleGetSimpleTroopInfo], appID:");
      paramString.append(paramToServiceMsg.hlGuildAppid);
      paramString.append(",subType:");
      paramString.append(paramToServiceMsg.hlGuildSubType);
      QLog.d(".troop.kingteam_troop", 2, paramString.toString());
      paramString = new StringBuilder();
      paramString.append("handleGetSimpleTroopInfo dwGagTimeStamp:");
      paramString.append(paramToServiceMsg.dwGagTimeStamp);
      paramString.append(",troopname:");
      paramString.append(paramToServiceMsg.troopname);
      paramString.append(",forceSave = ");
      paramString.append(bool2);
      QLog.d("TroopInfoHandler", 2, paramString.toString());
    }
    if (bool2)
    {
      localITroopInfoService.saveTroopInfo(paramToServiceMsg);
      return paramToServiceMsg;
    }
    if (paramToServiceMsg.isAdmin())
    {
      localITroopInfoService.saveTroopInfo(paramToServiceMsg);
      if (QLog.isDevelopLevel()) {
        QLog.i("TroopMngTest", 4, String.format("onGetSimpleTroopInfo [%s, %s, %s]", new Object[] { paramToServiceMsg.troopuin, Long.valueOf(paramToServiceMsg.dwGroupFlagExt3 & 0x100000), Integer.valueOf(paramToServiceMsg.nMsgLimitFreq) }));
      }
    }
    return paramToServiceMsg;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("troop_uin");
    String str = paramToServiceMsg.extraData.getString("subCmd", "");
    label367:
    boolean bool2;
    if ((paramFromServiceMsg.getResultCode() == 1000) && (paramObject != null))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramObject;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handle_0x88d|oidb_sso parseFrom byte ");
          localStringBuilder.append(paramObject.toString());
          QLog.d("TroopInfoHandler", 2, localStringBuilder.toString());
        }
        paramObject.printStackTrace();
      }
      int i = paramToServiceMsg.uint32_result.get();
      label414:
      boolean bool1;
      if (i == 0)
      {
        int j = i;
        if (paramToServiceMsg.bytes_bodybuffer.has())
        {
          j = i;
          if (paramToServiceMsg.bytes_bodybuffer.get() != null)
          {
            paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
            j = i;
            try
            {
              paramObject = new oidb_0x88d.RspBody();
              j = i;
              paramObject.mergeFrom(paramToServiceMsg);
              j = i;
              paramToServiceMsg = paramObject.stzrspgroupinfo.get();
              int k;
              if (paramToServiceMsg == null)
              {
                k = 0;
              }
              else
              {
                j = i;
                k = paramToServiceMsg.size();
              }
              int n = 0;
              for (;;)
              {
                if (n < k)
                {
                  j = i;
                  try
                  {
                    paramObject = (oidb_0x88d.RspGroupInfo)paramToServiceMsg.get(n);
                    int m = i;
                    if (paramObject != null)
                    {
                      j = i;
                      if (paramObject.uint64_group_code.get() != l)
                      {
                        m = i;
                      }
                      else
                      {
                        j = i;
                        i = paramObject.uint32_result.get();
                        m = i;
                        if (i == 0)
                        {
                          m = i;
                          j = i;
                          if (paramObject.stgroupinfo.has())
                          {
                            j = i;
                            paramToServiceMsg = (oidb_0x88d.GroupInfo)paramObject.stgroupinfo.get();
                            break label367;
                          }
                        }
                      }
                    }
                    n += 1;
                    i = m;
                  }
                  catch (Exception paramToServiceMsg)
                  {
                    i = j;
                    break label414;
                  }
                }
              }
              paramToServiceMsg = null;
              j = i;
              if (paramToServiceMsg != null)
              {
                j = i;
                notifyUI(TroopObserver.TYPE_0X88D_RESULT, true, new Object[] { String.valueOf(l), str, paramToServiceMsg });
                return;
              }
            }
            catch (Exception paramToServiceMsg)
            {
              i = j;
              j = i;
              if (QLog.isColorLevel())
              {
                QLog.i("TroopInfoHandler", 2, paramToServiceMsg.toString());
                j = i;
              }
            }
          }
        }
        bool1 = true;
        i = j;
      }
      else
      {
        bool1 = false;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handle_0x88d|isSuccess = ");
        paramToServiceMsg.append(bool1);
        paramToServiceMsg.append("|resultcode = ");
        paramToServiceMsg.append(paramFromServiceMsg.getResultCode());
        paramToServiceMsg.append("|troopuin = ");
        paramToServiceMsg.append(l);
        paramToServiceMsg.append("|result = ");
        paramToServiceMsg.append(i);
        paramToServiceMsg.append("|subCmd = ");
        paramToServiceMsg.append(str);
        QLog.i("TroopInfoHandler", 2, paramToServiceMsg.toString());
        bool2 = bool1;
      }
    }
    else
    {
      bool2 = false;
    }
    notifyUI(TroopObserver.TYPE_0X88D_RESULT, bool2, new Object[] { Long.valueOf(l), str, null });
  }
  
  private void a(String paramString, Object paramObject, TroopInfoHandlerConfig paramTroopInfoHandlerConfig)
  {
    if (a(paramString, paramTroopInfoHandlerConfig))
    {
      if ((paramObject instanceof PBUInt32Field))
      {
        ((PBUInt32Field)paramObject).set(0);
        return;
      }
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
      if ((paramObject instanceof oidb_0x88d.GroupCardPrefix))
      {
        paramString = new oidb_0x88d.GroupCardPrefix();
        paramString.bytes_introduction.set(ByteStringMicro.EMPTY);
        paramTroopInfoHandlerConfig = new ArrayList();
        paramTroopInfoHandlerConfig.add(ByteStringMicro.EMPTY);
        paramString.rpt_bytes_prefix.set(paramTroopInfoHandlerConfig);
        ((oidb_0x88d.GroupCardPrefix)paramObject).set(paramString);
      }
    }
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
  
  private boolean a(String paramString, TroopInfoHandlerConfig paramTroopInfoHandlerConfig)
  {
    if ((paramTroopInfoHandlerConfig != null) && (paramTroopInfoHandlerConfig.b(paramString)))
    {
      if (QLog.isColorLevel())
      {
        paramTroopInfoHandlerConfig = new StringBuilder();
        paramTroopInfoHandlerConfig.append("shouldRequest88dFieldInConfigForAio = false, name = ");
        paramTroopInfoHandlerConfig.append(paramString);
        QLog.d("TroopInfoHandler", 2, paramTroopInfoHandlerConfig.toString());
      }
      return false;
    }
    return true;
  }
  
  private Object[] a(long paramLong, ToServiceMsg paramToServiceMsg, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    int i;
    boolean bool;
    if ((paramOIDBSSOPkg != null) && (paramOIDBSSOPkg.bytes_bodybuffer.has()) && (paramOIDBSSOPkg.bytes_bodybuffer.get() != null))
    {
      paramOIDBSSOPkg = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
      try
      {
        Object localObject = new oidb_0x88d.RspBody();
        ((oidb_0x88d.RspBody)localObject).mergeFrom(paramOIDBSSOPkg);
        List localList = ((oidb_0x88d.RspBody)localObject).stzrspgroupinfo.get();
        int k;
        if (localList == null) {
          k = 0;
        } else {
          k = localList.size();
        }
        paramOIDBSSOPkg = null;
        int n = 0;
        i = 0;
        for (;;)
        {
          if ((paramOIDBSSOPkg == null) && (n < k))
          {
            int j = i;
            try
            {
              oidb_0x88d.RspGroupInfo localRspGroupInfo = (oidb_0x88d.RspGroupInfo)localList.get(n);
              localObject = paramOIDBSSOPkg;
              int m = i;
              if (localRspGroupInfo != null)
              {
                j = i;
                if (localRspGroupInfo.uint64_group_code.get() != paramLong)
                {
                  localObject = paramOIDBSSOPkg;
                  m = i;
                }
                else
                {
                  j = i;
                  i = localRspGroupInfo.uint32_result.get();
                  localObject = paramOIDBSSOPkg;
                  m = i;
                  if (i == 0)
                  {
                    localObject = paramOIDBSSOPkg;
                    m = i;
                    j = i;
                    if (localRspGroupInfo.stgroupinfo.has())
                    {
                      j = i;
                      localObject = (oidb_0x88d.GroupInfo)localRspGroupInfo.stgroupinfo.get();
                      m = i;
                    }
                  }
                }
              }
              n += 1;
              paramOIDBSSOPkg = (oidb_sso.OIDBSSOPkg)localObject;
              i = m;
            }
            catch (Exception paramToServiceMsg)
            {
              bool = false;
              i = j;
              break label311;
            }
          }
        }
        if (paramOIDBSSOPkg != null)
        {
          try
          {
            paramToServiceMsg = a(String.valueOf(paramLong), paramToServiceMsg, paramOIDBSSOPkg);
            bool = true;
          }
          catch (Exception paramToServiceMsg)
          {
            bool = true;
            break label311;
          }
        }
        else
        {
          paramToServiceMsg = null;
          bool = false;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        bool = false;
        i = 0;
        label311:
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopdisband.", 2, paramToServiceMsg.toString());
        }
        paramToServiceMsg = null;
      }
    }
    else
    {
      paramToServiceMsg = null;
      bool = false;
      i = 0;
    }
    return new Object[] { paramToServiceMsg, Boolean.valueOf(bool), null, Integer.valueOf(i) };
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("troop_uin");
    int k = paramToServiceMsg.extraData.getInt("nFlag");
    String str = paramToServiceMsg.extraData.getString("source");
    boolean bool4 = paramToServiceMsg.extraData.getBoolean("simpleNotify");
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("oldGroupReqNotify", false);
    boolean bool2;
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
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleGetSimpleTroopInfo|oidb_sso parseFrom byte ");
          ((StringBuilder)localObject).append(paramObject.toString());
          QLog.d("Q.troopdisband.", 2, ((StringBuilder)localObject).toString());
        }
        paramObject.printStackTrace();
      }
      int i;
      if (paramFromServiceMsg != null)
      {
        int j = paramFromServiceMsg.uint32_result.get();
        i = j;
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("handleGetSimpleTroopInfo|oidb_sso.OIDBSSOPkg.result ");
          paramObject.append(j);
          QLog.d("Q.troopdisband.", 2, paramObject.toString());
          i = j;
        }
      }
      else
      {
        i = -1;
      }
      Object localObject = null;
      paramObject = null;
      boolean bool1;
      if (i == 0)
      {
        localObject = a(l, paramToServiceMsg, paramFromServiceMsg);
        if (localObject[0] != null) {
          paramToServiceMsg = (TroopInfo)localObject[0];
        } else {
          paramToServiceMsg = null;
        }
        bool1 = ((Boolean)localObject[1]).booleanValue();
        paramFromServiceMsg = paramObject;
        if (localObject[2] != null) {
          paramFromServiceMsg = (String)localObject[2];
        }
        i = ((Integer)localObject[3]).intValue();
      }
      else
      {
        paramFromServiceMsg = null;
        bool1 = false;
        paramToServiceMsg = (ToServiceMsg)localObject;
      }
      bool2 = bool1;
      if (bool4)
      {
        notifyUI(TroopObserver.TYPE_GET_SIMPLE_TROOP_INFO, bool1, new Object[] { Long.valueOf(l), Integer.valueOf(k), paramToServiceMsg, Integer.valueOf(i), paramFromServiceMsg, str });
        bool2 = bool1;
      }
    }
    else
    {
      bool2 = false;
    }
    if (bool3) {
      notifyUI(TroopObserver.TYPE_GET_TROOP_INFO, bool2, String.valueOf(l));
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
    long l = paramToServiceMsg.extraData.getLong("troop_uin");
    int i1 = paramToServiceMsg.extraData.getInt("nFlag");
    int i = paramFromServiceMsg.getResultCode();
    int j = -1;
    if (i == 1000)
    {
      paramToServiceMsg = new TroopInfoHandler.HandleOidb0x88d10InitPkg(this, (byte[])paramObject, -1).c();
      i = paramToServiceMsg.a();
      paramToServiceMsg = paramToServiceMsg.b();
      j = i;
      if (paramToServiceMsg != null)
      {
        j = i;
        if (paramToServiceMsg.bytes_bodybuffer.has())
        {
          j = i;
          if (paramToServiceMsg.bytes_bodybuffer.get() != null) {
            paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
          }
        }
      }
    }
    for (;;)
    {
      Object localObject1;
      boolean bool1;
      try
      {
        paramFromServiceMsg = new oidb_0x88d.RspBody();
        paramFromServiceMsg.mergeFrom(paramToServiceMsg);
        if ((i != 0) && (paramFromServiceMsg.str_errorinfo.has())) {
          paramToServiceMsg = String.valueOf(paramFromServiceMsg.str_errorinfo.get().toByteArray());
        } else {
          paramToServiceMsg = null;
        }
        try
        {
          localObject1 = paramFromServiceMsg.stzrspgroupinfo.get();
          int k;
          if (localObject1 == null) {
            k = 0;
          } else {
            k = ((List)localObject1).size();
          }
          paramFromServiceMsg = null;
          int n = 0;
          if ((paramFromServiceMsg == null) && (n < k))
          {
            j = i;
            try
            {
              localObject2 = (oidb_0x88d.RspGroupInfo)((List)localObject1).get(n);
              paramObject = paramFromServiceMsg;
              int m = i;
              if (localObject2 != null)
              {
                j = i;
                if (((oidb_0x88d.RspGroupInfo)localObject2).uint64_group_code.get() != l)
                {
                  paramObject = paramFromServiceMsg;
                  m = i;
                }
                else
                {
                  j = i;
                  i = ((oidb_0x88d.RspGroupInfo)localObject2).uint32_result.get();
                  paramObject = paramFromServiceMsg;
                  m = i;
                  if (i == 0)
                  {
                    paramObject = paramFromServiceMsg;
                    m = i;
                    j = i;
                    if (((oidb_0x88d.RspGroupInfo)localObject2).stgroupinfo.has())
                    {
                      j = i;
                      paramObject = (oidb_0x88d.GroupInfo)((oidb_0x88d.RspGroupInfo)localObject2).stgroupinfo.get();
                      m = i;
                    }
                  }
                }
              }
              n += 1;
              paramFromServiceMsg = paramObject;
              i = m;
            }
            catch (Exception paramObject)
            {
              i = j;
              continue;
            }
          }
          if (paramFromServiceMsg != null)
          {
            try
            {
              localObject1 = ((ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(String.valueOf(l));
              paramObject = localObject1;
              if (localObject1 == null) {}
              try
              {
                paramObject = new TroopInfo();
                try
                {
                  paramObject.troopuin = String.valueOf(l);
                }
                catch (Exception paramFromServiceMsg)
                {
                  localObject1 = paramObject;
                  continue;
                }
                localObject2 = paramFromServiceMsg;
                localObject1 = paramObject;
                if (paramFromServiceMsg.uint32_group_class_ext.has())
                {
                  localObject1 = paramObject;
                  paramObject.dwGroupClassExt = paramFromServiceMsg.uint32_group_class_ext.get();
                  localObject1 = paramObject;
                  if (!QLog.isColorLevel()) {
                    break label800;
                  }
                  localObject1 = paramObject;
                  localObject2 = new StringBuilder();
                  localObject1 = paramObject;
                  ((StringBuilder)localObject2).append("handle_0x88d_10|troopCreateTime ");
                  localObject1 = paramObject;
                  ((StringBuilder)localObject2).append(paramObject.troopCreateTime);
                  localObject1 = paramObject;
                  QLog.d("TroopInfoHandler", 2, ((StringBuilder)localObject2).toString());
                  break label800;
                }
                localObject1 = paramObject;
                if (((oidb_0x88d.GroupInfo)localObject2).uint64_group_owner.has())
                {
                  localObject1 = paramObject;
                  paramFromServiceMsg = new StringBuilder();
                  localObject1 = paramObject;
                  paramFromServiceMsg.append("");
                  localObject1 = paramObject;
                  paramFromServiceMsg.append(((oidb_0x88d.GroupInfo)localObject2).uint64_group_owner.get());
                  localObject1 = paramObject;
                  paramObject.troopowneruin = paramFromServiceMsg.toString();
                  localObject1 = paramObject;
                  if (QLog.isColorLevel())
                  {
                    localObject1 = paramObject;
                    paramFromServiceMsg = new StringBuilder();
                    localObject1 = paramObject;
                    paramFromServiceMsg.append("handle_0x88d_10|troopowneruin ");
                    localObject1 = paramObject;
                    paramFromServiceMsg.append(paramObject.troopowneruin);
                    localObject1 = paramObject;
                    QLog.d("TroopInfoHandler", 2, paramFromServiceMsg.toString());
                  }
                }
                bool2 = true;
              }
              catch (Exception paramFromServiceMsg)
              {
                paramObject = paramFromServiceMsg;
                paramFromServiceMsg = (FromServiceMsg)localObject1;
              }
              bool1 = true;
            }
            catch (Exception paramObject)
            {
              paramFromServiceMsg = null;
            }
          }
          else
          {
            paramObject = null;
            bool2 = false;
            localObject1 = paramObject;
            j = i;
            localObject2 = paramToServiceMsg;
          }
        }
        catch (Exception paramObject)
        {
          paramFromServiceMsg = null;
          bool1 = false;
        }
        localObject1 = paramFromServiceMsg;
      }
      catch (Exception paramObject)
      {
        paramFromServiceMsg = null;
        bool1 = false;
        paramToServiceMsg = null;
      }
      boolean bool2 = bool1;
      j = i;
      Object localObject2 = paramToServiceMsg;
      if (QLog.isColorLevel())
      {
        QLog.i("TroopInfoHandler", 2, paramObject.toString());
        localObject1 = paramFromServiceMsg;
        bool2 = bool1;
        j = i;
        localObject2 = paramToServiceMsg;
        break label752;
        localObject1 = null;
        bool2 = false;
        localObject2 = null;
      }
      label752:
      notifyUI(TroopObserver.TYPE_OIDB_0X88D_10, bool2, new Object[] { Long.valueOf(l), Integer.valueOf(i1), localObject1, Integer.valueOf(j), localObject2 });
      return;
      label800:
      localObject2 = paramFromServiceMsg;
    }
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
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg.getResultCode() != 1000) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopInfoHandler", 2, "handGetTroopAuth");
      }
      long l = paramToServiceMsg.extraData.getLong("troopCode");
      String str = paramToServiceMsg.extraData.getString("subCmd", "");
      paramFromServiceMsg = (byte[])paramObject;
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
      }
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has())) {
        notifyUI(TroopObserver.TYPE_GET_TROOP_AUTH, false, new Object[] { Long.valueOf(l), str });
      }
      int i = paramToServiceMsg.uint32_result.get();
      if (i != 0)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("0x580 cResult=");
          paramFromServiceMsg.append(i);
          QLog.d("TroopInfoHandler", 2, paramFromServiceMsg.toString());
        }
        notifyUI(TroopObserver.TYPE_GET_TROOP_AUTH, false, new Object[] { Long.valueOf(l), str });
      }
      try
      {
        paramToServiceMsg = new ByteArrayInputStream(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramFromServiceMsg = new DataInputStream(paramToServiceMsg);
        paramFromServiceMsg.readInt();
        paramFromServiceMsg.readInt();
        paramFromServiceMsg.readInt();
        paramFromServiceMsg.readInt();
        paramFromServiceMsg.skip(16L);
        paramFromServiceMsg.readInt();
        paramFromServiceMsg.readInt();
        paramFromServiceMsg.skip(4L);
        paramObject = new byte[paramFromServiceMsg.readShort()];
        paramFromServiceMsg.read(paramObject);
        b.put(Long.valueOf(l), paramObject);
        paramFromServiceMsg.close();
        paramToServiceMsg.close();
        notifyUI(TroopObserver.TYPE_GET_TROOP_AUTH, true, new Object[] { Long.valueOf(l), str, paramObject });
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopInfoHandler", 2, paramToServiceMsg.getMessage());
        }
        notifyUI(TroopObserver.TYPE_GET_TROOP_AUTH, false, new Object[] { Long.valueOf(l), str });
      }
    }
  }
  
  private void d(oidb_0x88d.GroupInfo paramGroupInfo, TroopInfo paramTroopInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramGroupInfo.st_group_card_prefix.has())
    {
      paramGroupInfo = (oidb_0x88d.GroupCardPrefix)paramGroupInfo.st_group_card_prefix.get();
      if (paramGroupInfo.bytes_introduction.has()) {
        paramTroopInfo.groupCardPrefixIntro = paramGroupInfo.bytes_introduction.get().toStringUtf8();
      } else {
        paramTroopInfo.groupCardPrefixIntro = "";
      }
      if (paramGroupInfo.rpt_bytes_prefix.has())
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
      if (QLog.isColorLevel())
      {
        paramGroupInfo = new StringBuilder();
        paramGroupInfo.append("handleGetSimpleTroopInfo_rspBody_updateGroupInfoExt troopUin:");
        paramGroupInfo.append(paramTroopInfo.troopuin);
        paramGroupInfo.append(" uint32_group_info_ext_seq:");
        paramGroupInfo.append(paramTroopInfo.mTroopInfoExtObj.groupInfoExtSeq);
        QLog.i("TroopInfoHandler", 2, paramGroupInfo.toString());
      }
    }
  }
  
  private boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return (paramString.equals("TroopMemberApiService.create_troop")) || (paramString.equals("TroopCreateLogic.create_new_troop")) || (paramString.equals("SubType0x44.source_apply_for_join_troop")) || (paramString.equals("SystemMessageProcessor.AgreeGroupInvation")) || (paramString.equals("getGroupInfoFromChatSettingForTroop"));
  }
  
  private void f(String paramString)
  {
    paramString = new TroopInfoHandler.1(this, paramString);
    this.appRuntime.addDefaultObservers(paramString);
  }
  
  public void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoHandler", 2, "getTroopAuth0x580");
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.appRuntime.getCurrentAccountUin(), "OidbSvc.0x580_1");
    try
    {
      Object localObject = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeInt((int)paramLong);
      byte[] arrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
      localDataOutputStream.close();
      ((ByteArrayOutputStream)localObject).close();
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1408);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(1);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(arrayOfByte));
      localToServiceMsg.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopInfoHandler", 2, localException.getMessage());
      }
    }
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    localToServiceMsg.extraData.putLong("troopCode", paramLong);
    localToServiceMsg.extraData.putString("subCmd", paramString);
    localToServiceMsg.extraData.putString("REQ_TAG", dv_());
    this.appRuntime.sendToService(localToServiceMsg);
  }
  
  public void a(Long paramLong, oidb_0x88d.GroupInfo paramGroupInfo, String paramString)
  {
    a(paramLong, paramGroupInfo, paramString, this.appRuntime.getAppid(), 30000L, 0);
  }
  
  public void a(Long paramLong, oidb_0x88d.GroupInfo paramGroupInfo, String paramString, int paramInt1, long paramLong1, int paramInt2)
  {
    Object localObject = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject).uint64_group_code.set(paramLong.longValue());
    ((oidb_0x88d.ReqGroupInfo)localObject).stgroupinfo.set(paramGroupInfo);
    paramGroupInfo = new oidb_0x88d.ReqBody();
    paramGroupInfo.uint32_appid.set(paramInt1);
    paramGroupInfo.stzreqgroupinfo.add((MessageMicro)localObject);
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(paramInt2);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramGroupInfo.toByteArray()));
    if (paramInt2 == 1) {
      paramGroupInfo = createToServiceMsg("OidbSvc.0x88d_1");
    } else {
      paramGroupInfo = createToServiceMsg("OidbSvc.0x88d_0");
    }
    paramGroupInfo.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    paramGroupInfo.extraData.putLong("troop_uin", paramLong.longValue());
    paramGroupInfo.extraData.putString("subCmd", paramString);
    paramGroupInfo.setTimeout(paramLong1);
    sendPbReq(paramGroupInfo);
  }
  
  public void a(String paramString)
  {
    a(paramString, 10000L, "");
  }
  
  public void a(String paramString1, long paramLong, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getGroupInfoReq, troopuin = ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("TroopInfoHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Object localObject = Long.valueOf(SystemClock.uptimeMillis());
    Long localLong = (Long)this.a.get(paramString1);
    if ((localLong != null) && (Math.abs(((Long)localObject).longValue() - localLong.longValue()) < paramLong))
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("getGroupInfoReq return, troopuin = ");
        paramString2.append(paramString1);
        QLog.d("TroopInfoHandler", 2, paramString2.toString());
      }
      return;
    }
    this.a.put(paramString1, localObject);
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
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getSimpleTroopInfo groupCode:");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(",forceSave = ");
      ((StringBuilder)localObject1).append(paramBoolean2);
      ((StringBuilder)localObject1).append(",source = ");
      ((StringBuilder)localObject1).append(paramString2);
      QLog.d("Q.getTroopMemberLevelInfo", 2, ((StringBuilder)localObject1).toString());
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
    if (e(paramString2))
    {
      TroopInfoExtHandler.a((oidb_0x88d.GroupInfo)localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("fillGroupInfoExt0x88d groupUin:");
        ((StringBuilder)localObject2).append(paramString1);
        QLog.d("TroopInfoHandler", 2, ((StringBuilder)localObject2).toString());
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
      ((ToServiceMsg)localObject1).extraData.putString("source", paramString2);
      ((ToServiceMsg)localObject1).extraData.putBoolean("forceSave", paramBoolean2);
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      ((ToServiceMsg)localObject1).extraData.putBoolean("simpleNotify", paramBoolean3);
      ((ToServiceMsg)localObject1).extraData.putBoolean("oldGroupReqNotify", paramBoolean4);
      ((ToServiceMsg)localObject1).extraData.putString("subCmd", "SUBCMD_GET_TROOP_SIMPLE_INFO");
      sendPbReq((ToServiceMsg)localObject1);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      QLog.e("TroopInfoHandler", 1, paramString1, new Object[0]);
    }
  }
  
  public byte[] a(long paramLong)
  {
    HashMap localHashMap = b;
    if ((localHashMap != null) && (localHashMap.containsKey(Long.valueOf(paramLong)))) {
      return (byte[])b.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  public void b()
  {
    HashMap localHashMap = b;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getSimpleTroopInfoForAio groupCode:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("Q.getTroopMemberLevelInfo", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = null;
    try
    {
      localObject1 = (TroopInfoHandlerConfig)QConfigManager.b().b(712);
    }
    catch (Exception localException)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.e("TroopInfoHandler", 2, localException.getMessage());
        localObject1 = localObject2;
      }
    }
    localObject2 = new oidb_0x88d.GroupInfo();
    a("string_group_name", ((oidb_0x88d.GroupInfo)localObject2).string_group_name, (TroopInfoHandlerConfig)localObject1);
    a("string_long_group_name", ((oidb_0x88d.GroupInfo)localObject2).string_long_group_name, (TroopInfoHandlerConfig)localObject1);
    a("uint32_group_face", ((oidb_0x88d.GroupInfo)localObject2).uint32_group_face, (TroopInfoHandlerConfig)localObject1);
    a("uint32_group_flag_ext", ((oidb_0x88d.GroupInfo)localObject2).uint32_group_flag_ext, (TroopInfoHandlerConfig)localObject1);
    a("uint32_group_flagext3", ((oidb_0x88d.GroupInfo)localObject2).uint32_group_flagext3, (TroopInfoHandlerConfig)localObject1);
    a("uint32_group_flag", ((oidb_0x88d.GroupInfo)localObject2).uint32_group_flag, (TroopInfoHandlerConfig)localObject1);
    a("string_group_rich_finger_memo", ((oidb_0x88d.GroupInfo)localObject2).string_group_rich_finger_memo, (TroopInfoHandlerConfig)localObject1);
    a("uint64_group_owner", ((oidb_0x88d.GroupInfo)localObject2).uint64_group_owner, (TroopInfoHandlerConfig)localObject1);
    a("uint32_group_class_ext", ((oidb_0x88d.GroupInfo)localObject2).uint32_group_class_ext, (TroopInfoHandlerConfig)localObject1);
    a("uint32_cmduin_join_time", ((oidb_0x88d.GroupInfo)localObject2).uint32_cmduin_join_time, (TroopInfoHandlerConfig)localObject1);
    a("uint32_group_type_flag", ((oidb_0x88d.GroupInfo)localObject2).uint32_group_type_flag, (TroopInfoHandlerConfig)localObject1);
    a("uint32_cmduin_flag_ex2", ((oidb_0x88d.GroupInfo)localObject2).uint32_cmduin_flag_ex2, (TroopInfoHandlerConfig)localObject1);
    a("uint32_cmduin_ringtone_id", ((oidb_0x88d.GroupInfo)localObject2).uint32_cmduin_ringtone_id, (TroopInfoHandlerConfig)localObject1);
    a("uint32_shutup_timestamp", ((oidb_0x88d.GroupInfo)localObject2).uint32_shutup_timestamp, (TroopInfoHandlerConfig)localObject1);
    a("uint32_is_conf_group", ((oidb_0x88d.GroupInfo)localObject2).uint32_is_conf_group, (TroopInfoHandlerConfig)localObject1);
    a("uint32_is_modify_conf_group_face", ((oidb_0x88d.GroupInfo)localObject2).uint32_is_modify_conf_group_face, (TroopInfoHandlerConfig)localObject1);
    a("uint32_is_modify_conf_group_name", ((oidb_0x88d.GroupInfo)localObject2).uint32_is_modify_conf_group_name, (TroopInfoHandlerConfig)localObject1);
    a("uint32_group_member_num", ((oidb_0x88d.GroupInfo)localObject2).uint32_group_member_num, (TroopInfoHandlerConfig)localObject1);
    a("uint32_auto_agree_join_group_user_num_for_conf_group", ((oidb_0x88d.GroupInfo)localObject2).uint32_auto_agree_join_group_user_num_for_conf_group, (TroopInfoHandlerConfig)localObject1);
    a("uint32_auto_agree_join_group_user_num_for_normal_group", ((oidb_0x88d.GroupInfo)localObject2).uint32_auto_agree_join_group_user_num_for_normal_group, (TroopInfoHandlerConfig)localObject1);
    a("uint32_msg_limit_frequency", ((oidb_0x88d.GroupInfo)localObject2).uint32_msg_limit_frequency, (TroopInfoHandlerConfig)localObject1);
    a("uint32_is_allow_recall_msg", ((oidb_0x88d.GroupInfo)localObject2).uint32_is_allow_recall_msg, (TroopInfoHandlerConfig)localObject1);
    a("uint32_hl_guild_appid", ((oidb_0x88d.GroupInfo)localObject2).uint32_hl_guild_appid, (TroopInfoHandlerConfig)localObject1);
    a("uint32_hl_guild_sub_type", ((oidb_0x88d.GroupInfo)localObject2).uint32_hl_guild_sub_type, (TroopInfoHandlerConfig)localObject1);
    a("string_group_finger_memo", ((oidb_0x88d.GroupInfo)localObject2).string_group_finger_memo, (TroopInfoHandlerConfig)localObject1);
    a("string_group_memo", ((oidb_0x88d.GroupInfo)localObject2).string_group_memo, (TroopInfoHandlerConfig)localObject1);
    a("string_certification_text", ((oidb_0x88d.GroupInfo)localObject2).string_certification_text, (TroopInfoHandlerConfig)localObject1);
    a("group_geo_info", ((oidb_0x88d.GroupInfo)localObject2).group_geo_info, (TroopInfoHandlerConfig)localObject1);
    a("bytes_group_school_info", ((oidb_0x88d.GroupInfo)localObject2).bytes_group_school_info, (TroopInfoHandlerConfig)localObject1);
    a("st_group_card_prefix", ((oidb_0x88d.GroupInfo)localObject2).st_group_card_prefix, (TroopInfoHandlerConfig)localObject1);
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    try
    {
      ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(Long.parseLong(paramString));
      ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
      localObject2 = new oidb_0x88d.ReqBody();
      ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(200010022);
      ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
      localObject2 = createToServiceMsg("OidbSvc.0x88d_0");
      ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      ((ToServiceMsg)localObject2).extraData.putLong("troop_uin", Long.parseLong(paramString));
      ((ToServiceMsg)localObject2).extraData.putString("source", "AIO");
      ((ToServiceMsg)localObject2).extraData.putBoolean("forceSave", false);
      ((ToServiceMsg)localObject2).extraData.putBoolean("simpleNotify", true);
      ((ToServiceMsg)localObject2).extraData.putString("subCmd", "SUBCMD_GET_TROOP_SIMPLE_INFO_FOR_AIO");
      ((ToServiceMsg)localObject2).setTimeout(30000L);
      sendPbReq((ToServiceMsg)localObject2);
      return;
    }
    catch (NumberFormatException paramString)
    {
      QLog.e("TroopInfoHandler", 1, paramString, new Object[0]);
    }
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
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(AppSetting.d());
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
  
  public void d(String paramString)
  {
    f(paramString);
    oidb_0x88d.GroupInfo localGroupInfo = new oidb_0x88d.GroupInfo();
    oidb_0x88d.TagRecord localTagRecord = new oidb_0x88d.TagRecord();
    localTagRecord.uint32_bad_num.set(0);
    localGroupInfo.rpt_tag_record.add(localTagRecord);
    a(Long.valueOf(Long.parseLong(paramString)), localGroupInfo, "SUBCMD_GET_TROOP_TAG", this.appRuntime.getAppid(), 30000L, 1);
  }
  
  protected String dv_()
  {
    return "TroopInfoHandler";
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x88d_0");
      this.allowCmdSet.add("OidbSvc.0x88d_1");
      this.allowCmdSet.add("OidbSvc.0x88d_10");
      this.allowCmdSet.add("OidbSvc.0x580_1");
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
          QLog.d("TroopInfoHandler", 2, paramToServiceMsg.toString());
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
          QLog.d("TroopInfoHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ((!"OidbSvc.0x88d_0".equals(paramFromServiceMsg.getServiceCmd())) && (!"OidbSvc.0x88d_1".equals(paramFromServiceMsg.getServiceCmd())))
      {
        if ("OidbSvc.0x88d_10".equals(paramFromServiceMsg.getServiceCmd()))
        {
          c(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x580_1".equals(paramFromServiceMsg.getServiceCmd())) {
          d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
      }
      else
      {
        str = paramToServiceMsg.extraData.getString("subCmd", "");
        if ((!str.equals("SUBCMD_GET_TROOP_SIMPLE_INFO")) && (!str.equals("SUBCMD_GET_TROOP_SIMPLE_INFO_FOR_AIO")))
        {
          a(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopInfoHandler
 * JD-Core Version:    0.7.0.1
 */