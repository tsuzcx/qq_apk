package com.tencent.mobileqq.troop.handler;

import KQQ.GroupMngRes;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopManagerService;
import com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi;
import com.tencent.mobileqq.troop.api.config.TroopMngHandlerProcessorConfig;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.api.troopcreate.ITroopCreateGrayMsg;
import com.tencent.mobileqq.troop.data.InviteToGroupInfo;
import com.tencent.mobileqq.troop.data.InviteToGroupInfo.UinInfo;
import com.tencent.mobileqq.troop.data.JoinGroupInfo;
import com.tencent.mobileqq.troop.data.TroopCreateInfo.InviteMemberInfo;
import com.tencent.mobileqq.troop.data.TroopCreateInfo.TroopCreateResult;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x758.cmd0x758.InviteUinInfo;
import tencent.im.oidb.cmd0x758.cmd0x758.ReqBody;
import tencent.im.oidb.cmd0x758.cmd0x758.RspBody;
import tencent.im.oidb.cmd0x874.cmd0x874.ConvertToGroupReq;
import tencent.im.oidb.cmd0x874.cmd0x874.ConvertToGroupRsp;
import tencent.im.oidb.cmd0x874.cmd0x874.ReqBody;
import tencent.im.oidb.cmd0x874.cmd0x874.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupExInfoOnly;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x89e.oidb_0x89e.ReqBody;
import tencent.im.oidb.cmd0x89e.oidb_0x89e.RspBody;
import tencent.im.oidb.cmd0x8a1.cmd0x8a1.CreateGroupInfo;
import tencent.im.oidb.cmd0x8a1.cmd0x8a1.GroupGeoInfo;
import tencent.im.oidb.cmd0x8a1.cmd0x8a1.ReqBody;
import tencent.im.oidb.cmd0x8a1.cmd0x8a1.RspBody;
import tencent.im.oidb.cmd0x9fa.oidb_0x9fa.GetSimilarGroupWebInfo;
import tencent.im.oidb.cmd0x9fa.oidb_0x9fa.ReqBody;
import tencent.im.oidb.cmd0x9fa.oidb_0x9fa.RspBody;
import tencent.im.oidb.cmd0x9fa.oidb_0x9fa.SimilarGroupWebInfo;
import tencent.im.oidb.cmd0xcca.cmd0xcca.ReqBody;
import tencent.im.oidb.cmd0xcca.cmd0xcca.RspBody;
import tencent.im.oidb.cmd0xe72.oidb_0xe72.ReqBody;
import tencent.im.oidb.cmd0xe72.oidb_0xe72.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopMngHandler
  extends TroopBaseHandler
  implements ITroopMngHandler
{
  public TroopMngHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    TroopMngHandlerProcessorConfig.a();
  }
  
  private int a(int paramInt)
  {
    int[] arrayOfInt = new int[11];
    int[] tmp6_5 = arrayOfInt;
    tmp6_5[0] = 2131696140;
    int[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 2131696136;
    int[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 2131696132;
    int[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 2131696135;
    int[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 2131696139;
    int[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 2131696137;
    int[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 2131696142;
    int[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 2131696134;
    int[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 2131696141;
    int[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 2131696133;
    int[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 2131696138;
    tmp60_54;
    if ((paramInt >= 0) && (paramInt < arrayOfInt.length)) {
      return arrayOfInt[paramInt];
    }
    return 2131696133;
  }
  
  @NotNull
  private TroopInfo a(long paramLong, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    Object localObject2 = ((ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(String.valueOf(paramLong));
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new TroopInfo();
      ((TroopInfo)localObject1).troopuin = String.valueOf(paramLong);
    }
    if (paramGroupInfo.uint32_group_option.has()) {
      ((TroopInfo)localObject1).cGroupOption = ((short)paramGroupInfo.uint32_group_option.get());
    }
    if (paramGroupInfo.string_group_question.has())
    {
      ((TroopInfo)localObject1).joinTroopQuestion = paramGroupInfo.string_group_question.get().toStringUtf8();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handle_oidb_0x88d_1|joinTroopQuestion ");
        ((StringBuilder)localObject2).append(((TroopInfo)localObject1).joinTroopQuestion);
        QLog.d("Q.troopquestionverify.", 2, ((StringBuilder)localObject2).toString());
      }
    }
    if (paramGroupInfo.string_group_answer.has()) {
      ((TroopInfo)localObject1).joinTroopAnswer = paramGroupInfo.string_group_answer.get().toStringUtf8();
    }
    if (paramGroupInfo.uint32_app_privilege_flag.has())
    {
      int i = paramGroupInfo.uint32_app_privilege_flag.get();
      float f2 = 0.0F;
      float f1 = f2;
      if (paramGroupInfo.st_group_ex_info.has())
      {
        f1 = f2;
        if (paramGroupInfo.st_group_ex_info.uint32_money_for_add_group.has()) {
          f1 = paramGroupInfo.st_group_ex_info.uint32_money_for_add_group.get() * 0.01F;
        }
      }
      paramLong = i;
      ((TroopInfo)localObject1).troopPrivilegeFlag = paramLong;
      ((TroopInfo)localObject1).dwAppPrivilegeFlag = paramLong;
      ((TroopInfo)localObject1).mTroopNeedPayNumber = f1;
    }
    if (paramGroupInfo.uint32_group_flagext3.has())
    {
      ((TroopInfo)localObject1).dwGroupFlagExt3 = paramGroupInfo.uint32_group_flagext3.get();
      if (QLog.isColorLevel())
      {
        paramGroupInfo = new StringBuilder();
        paramGroupInfo.append("handle_oidb_0x88d_1 troopUin:");
        paramGroupInfo.append(((TroopInfo)localObject1).troopuin);
        paramGroupInfo.append(" dwGroupFlagExt3:");
        paramGroupInfo.append(((TroopInfo)localObject1).dwGroupFlagExt3);
        paramGroupInfo.append(" isListenTogetherOpen: ");
        paramGroupInfo.append(((TroopInfo)localObject1).isListenTogetherOpen());
        paramGroupInfo.append(" isAVGameOpen: ");
        paramGroupInfo.append(((TroopInfo)localObject1).isAVGameOpen());
        paramGroupInfo.append(" troopInfo.isSharingLocation: ");
        paramGroupInfo.append(((TroopInfo)localObject1).isSharingLocation());
        QLog.i("TroopMngHandler", 2, paramGroupInfo.toString());
      }
    }
    return localObject1;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_role");
    return localStringBuilder.toString();
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, int paramInt, String paramString, GroupMngRes paramGroupMngRes)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramGroupMngRes.result == 0))
    {
      ((ITroopManagerService)this.appRuntime.getRuntimeService(ITroopManagerService.class, "")).deleteTroop(paramString);
      TroopMngHandlerProcessorConfig.d(this.appRuntime, paramString);
      notifyUI(TroopMngObserver.c, true, new Object[] { Integer.valueOf(paramGroupMngRes.reqtype), Byte.valueOf(paramGroupMngRes.result), paramString });
      return;
    }
    int i = TroopMngObserver.c;
    byte b;
    if (paramFromServiceMsg.isSuccess()) {
      b = paramGroupMngRes.result;
    } else {
      b = -1;
    }
    notifyUI(i, false, new Object[] { Integer.valueOf(paramInt), Byte.valueOf(b) });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GroupMngRes paramGroupMngRes)
  {
    Object localObject1 = paramGroupMngRes.vecBody;
    paramToServiceMsg = new TroopInfo();
    try
    {
      localObject1 = ByteBuffer.wrap((byte[])localObject1);
      paramToServiceMsg.troopcode = String.valueOf(((ByteBuffer)localObject1).getInt() & 0xFFFFFFFF);
      paramToServiceMsg.troopuin = String.valueOf(((ByteBuffer)localObject1).getInt() & 0xFFFFFFFF);
      paramToServiceMsg.strLocation = paramGroupMngRes.sGroupLocation;
      paramToServiceMsg.troopAuthenticateInfo = paramGroupMngRes.sAuthGrpInfo;
      paramToServiceMsg.joinTroopQuestion = paramGroupMngRes.sJoinQuestion;
      paramToServiceMsg.joinTroopAnswer = paramGroupMngRes.sJoinAnswer;
      int i;
      if (((ByteBuffer)localObject1).remaining() > 0)
      {
        i = ((ByteBuffer)localObject1).get();
        ((ByteBuffer)localObject1).remaining();
        switch (i & 0xFF)
        {
        }
      }
      Object localObject3;
      label562:
      Object localObject2;
      boolean bool;
      for (;;)
      {
        i = ((ByteBuffer)localObject1).get();
        break label562;
        ((ByteBuffer)localObject1).get();
        paramToServiceMsg.wMemberNum = (((ByteBuffer)localObject1).getShort() & 0xFFFF);
        break;
        i = ((ByteBuffer)localObject1).get() & 0xFF;
        localObject3 = new byte[i];
        ((ByteBuffer)localObject1).get((byte[])localObject3, 0, i);
        paramToServiceMsg.fingertroopmemo = PkgTools.utf8Byte2String((byte[])localObject3, 0, i);
        break;
        ((ByteBuffer)localObject1).get();
        paramToServiceMsg.troopface = ((short)(((ByteBuffer)localObject1).getShort() & 0xFFFF));
        break;
        i = ((ByteBuffer)localObject1).get() & 0xFF;
        localObject3 = new byte[i];
        ((ByteBuffer)localObject1).get((byte[])localObject3, 0, i);
        paramToServiceMsg.troopname = PkgTools.utf8Byte2String((byte[])localObject3, 0, i);
        break;
        ((ByteBuffer)localObject1).get();
        paramToServiceMsg.dwGroupFlagExt = (((ByteBuffer)localObject1).getInt() & 0xFFFFFFFF);
        break;
        ((ByteBuffer)localObject1).get();
        paramToServiceMsg.cGroupLevel = ((short)(((ByteBuffer)localObject1).get() & 0xFF));
        break;
        ((ByteBuffer)localObject1).get();
        paramToServiceMsg.wSpecialClass = (((ByteBuffer)localObject1).getShort() & 0xFFFF);
        break;
        ((ByteBuffer)localObject1).get();
        paramToServiceMsg.wMemberMax = (((ByteBuffer)localObject1).getShort() & 0xFFFF);
        break;
        ((ByteBuffer)localObject1).get();
        paramToServiceMsg.dwGroupClassExt = (((ByteBuffer)localObject1).getInt() & 0xFFFFFFFF);
        break;
        ((ByteBuffer)localObject1).get();
        paramToServiceMsg.cGroupOption = ((short)(((ByteBuffer)localObject1).get() & 0xFF));
        break;
        ((ByteBuffer)localObject1).get();
        paramToServiceMsg.troopowneruin = String.valueOf(((ByteBuffer)localObject1).getInt() & 0xFFFFFFFF);
        break;
        ((ByteBuffer)localObject1).get();
        paramToServiceMsg.dwGroupFlag = (((ByteBuffer)localObject1).getInt() & 0xFFFFFFFF);
        break;
        ((ByteBuffer)localObject1).get();
        paramToServiceMsg.troopCreateTime = (((ByteBuffer)localObject1).getInt() & 0xFFFFFFFF);
        break;
        ((ByteBuffer)localObject1).get();
        paramToServiceMsg.trooptype = (((ByteBuffer)localObject1).get() & 0xFF);
        break;
        i &= 0xFF;
        ((ByteBuffer)localObject1).get(new byte[i], 0, i);
        break;
      }
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
      localBufferUnderflowException.printStackTrace();
      localObject2 = ((ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramToServiceMsg.troopuin);
      if (localObject2 != null)
      {
        ((TroopInfo)localObject2).trooptype = paramToServiceMsg.trooptype;
        ((TroopInfo)localObject2).troopCreateTime = paramToServiceMsg.troopCreateTime;
        ((TroopInfo)localObject2).dwGroupFlag = paramToServiceMsg.dwGroupFlag;
        ((TroopInfo)localObject2).troopowneruin = paramToServiceMsg.troopowneruin;
        ((TroopInfo)localObject2).cGroupOption = paramToServiceMsg.cGroupOption;
        ((TroopInfo)localObject2).dwGroupClassExt = paramToServiceMsg.dwGroupClassExt;
        ((TroopInfo)localObject2).wMemberMax = paramToServiceMsg.wMemberMax;
        ((TroopInfo)localObject2).wSpecialClass = paramToServiceMsg.wSpecialClass;
        ((TroopInfo)localObject2).cGroupLevel = paramToServiceMsg.cGroupLevel;
        if (TextUtils.isEmpty(((TroopInfo)localObject2).newTroopName))
        {
          ((TroopInfo)localObject2).troopname = paramToServiceMsg.troopname;
        }
        else if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("decodeSearchGroup:");
          ((StringBuilder)localObject3).append(((TroopInfo)localObject2).troopcode);
          ((StringBuilder)localObject3).append("already set long troop name do nothing");
          QLog.d("TroopMngHandler", 2, ((StringBuilder)localObject3).toString());
        }
        ((TroopInfo)localObject2).troopface = paramToServiceMsg.troopface;
        ((TroopInfo)localObject2).fingertroopmemo = paramToServiceMsg.fingertroopmemo;
        ((TroopInfo)localObject2).wMemberNum = paramToServiceMsg.wMemberNum;
        ((TroopInfo)localObject2).strLocation = paramToServiceMsg.strLocation;
        ((TroopInfo)localObject2).dwGroupFlagExt = paramToServiceMsg.dwGroupFlagExt;
        ((TroopInfo)localObject2).troopAuthenticateInfo = paramToServiceMsg.troopAuthenticateInfo;
        ((TroopInfo)localObject2).joinTroopQuestion = paramToServiceMsg.joinTroopQuestion;
        localObject3 = this.appRuntime.getEntityManagerFactory().createEntityManager();
        ((EntityManager)localObject3).persist((Entity)localObject2);
        ((EntityManager)localObject3).close();
        bool = true;
      }
      else
      {
        localObject2 = (ITroopSystemMsgUtilApi)QRoute.api(ITroopSystemMsgUtilApi.class);
        ((ITroopSystemMsgUtilApi)localObject2).saveTroopNameToSP(this.appRuntime.getApp(), paramToServiceMsg.troopuin, paramToServiceMsg.troopname);
        ((ITroopSystemMsgUtilApi)localObject2).saveTroopFlagExToSP(this.appRuntime.getApp(), paramToServiceMsg.troopuin, paramToServiceMsg.dwGroupFlagExt);
        ((ITroopSystemMsgUtilApi)localObject2).saveTroopQuestionToSP(this.appRuntime.getApp(), paramToServiceMsg.troopuin, paramToServiceMsg.joinTroopQuestion);
        bool = false;
      }
      notifyUI(TroopMngObserver.d, true, new Object[] { Byte.valueOf(paramGroupMngRes.result), paramToServiceMsg, Boolean.valueOf(bool) });
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("groupreqtype");
    String str = paramToServiceMsg.extraData.getString("troop_uin");
    boolean bool = paramFromServiceMsg.isSuccess();
    Byte localByte = Byte.valueOf((byte)-1);
    if (bool)
    {
      GroupMngRes localGroupMngRes = (GroupMngRes)decodePacket(paramFromServiceMsg.getWupBuffer(), "GroupMngRes", new GroupMngRes());
      if (localGroupMngRes == null)
      {
        notifyUI(TroopMngObserver.c, false, new Object[] { Integer.valueOf(i), localByte });
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleGroupManager: groupreqType = ");
        localStringBuilder.append(i);
        localStringBuilder.append(", troopCode = ");
        localStringBuilder.append(str);
        localStringBuilder.append(", res.isSucc=");
        localStringBuilder.append(paramFromServiceMsg.isSuccess());
        localStringBuilder.append(", resp.ret=");
        localStringBuilder.append(localGroupMngRes.result);
        QLog.d("TroopMngHandler", 2, localStringBuilder.toString());
      }
      switch (i)
      {
      default: 
        notifyUI(TroopMngObserver.c, false, new Object[] { Integer.valueOf(i), localByte });
        return;
      case 9: 
        b(paramFromServiceMsg, i, str, localGroupMngRes);
        return;
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
        a(paramToServiceMsg, paramFromServiceMsg, i, str, localGroupMngRes);
        return;
      case 3: 
        c(paramToServiceMsg, paramFromServiceMsg, i, str, localGroupMngRes);
        return;
      case 2: 
        a(paramFromServiceMsg, i, str, localGroupMngRes);
        return;
      case 1: 
        b(paramToServiceMsg, paramFromServiceMsg, i, str, localGroupMngRes);
        return;
      }
      a(paramToServiceMsg, paramFromServiceMsg, localGroupMngRes);
      return;
    }
    notifyUI(TroopMngObserver.c, false, new Object[] { Integer.valueOf(i), localByte });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt, String paramString, GroupMngRes paramGroupMngRes)
  {
    Object localObject1;
    Object localObject2;
    if ((paramInt != 4) && (paramInt != 5))
    {
      if (((paramInt == 6) || (paramInt == 7)) && (paramFromServiceMsg.isSuccess()) && (paramGroupMngRes.result == 0))
      {
        int j;
        if (paramInt == 6)
        {
          if (1 == paramGroupMngRes.cIsMemInvite) {
            i = 1;
          } else {
            i = 0;
          }
          j = i;
          if (i == 0)
          {
            localObject1 = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
            j = i;
            if (((ITroopInfoService)localObject1).findTroopInfo(paramToServiceMsg.extraData.getString("troop_uin")) == null)
            {
              localObject2 = new TroopInfo();
              ((TroopInfo)localObject2).troopuin = String.valueOf(paramToServiceMsg.extraData.getString("troop_uin"));
              ((ITroopInfoService)localObject1).addTroop((TroopInfo)localObject2);
              ((TroopInfoHandler)this.appRuntime.getBusinessHandler(TroopInfoHandler.class.getName())).a(((TroopInfo)localObject2).troopuin);
              j = i;
            }
          }
        }
        else
        {
          j = 0;
        }
        localObject1 = this.appRuntime.getApp().getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0).edit();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramToServiceMsg.extraData.getString("Request_uin"));
        ((StringBuilder)localObject2).append("_member_answer_joined_");
        ((StringBuilder)localObject2).append(paramToServiceMsg.extraData.getLong("infotime", 0L));
        ((StringBuilder)localObject2).append(paramToServiceMsg.extraData.getLong("dbid", 0L));
        paramToServiceMsg = ((StringBuilder)localObject2).toString();
        ((SharedPreferences.Editor)localObject1).putInt(paramToServiceMsg, paramInt);
        if (paramInt == 6) {
          ((SharedPreferences.Editor)localObject1).putInt(a(paramToServiceMsg), j);
        }
        ((SharedPreferences.Editor)localObject1).commit();
      }
    }
    else if (paramFromServiceMsg.isSuccess())
    {
      localObject1 = this.appRuntime.getApp().getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0).edit();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramToServiceMsg.extraData.getString("Request_uin"));
      ((StringBuilder)localObject2).append("_answer_joined_");
      ((StringBuilder)localObject2).append(paramToServiceMsg.extraData.getLong("infotime", 0L));
      ((StringBuilder)localObject2).append(paramToServiceMsg.extraData.getLong("dbid", 0L));
      ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject2).toString(), paramInt).commit();
    }
    if ((paramFromServiceMsg.isSuccess()) && (paramGroupMngRes.result == 0))
    {
      notifyUI(TroopMngObserver.c, true, new Object[] { Integer.valueOf(paramGroupMngRes.reqtype), Byte.valueOf(paramGroupMngRes.result), paramString });
      return;
    }
    int i = TroopMngObserver.c;
    byte b;
    if (paramFromServiceMsg.isSuccess()) {
      b = paramGroupMngRes.result;
    } else {
      b = -1;
    }
    notifyUI(i, false, new Object[] { Integer.valueOf(paramInt), Byte.valueOf(b) });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, GroupMngRes paramGroupMngRes)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramGroupMngRes.result == 0))
    {
      a(paramToServiceMsg, paramGroupMngRes);
      return;
    }
    notifyUI(TroopMngObserver.d, paramFromServiceMsg.isSuccess(), new Object[] { Byte.valueOf(paramGroupMngRes.result), null, Boolean.valueOf(false) });
  }
  
  private void a(cmd0x874.RspBody paramRspBody)
  {
    String str = String.valueOf(paramRspBody.msg_convert_group.uint64_conf_uin.get());
    paramRspBody = String.valueOf(paramRspBody.msg_convert_group.uint64_group_code.get());
    Object localObject1;
    if ((!TextUtils.isEmpty(paramRspBody)) && (!TextUtils.equals("0", paramRspBody)))
    {
      localObject1 = new TroopInfo();
      ((TroopInfo)localObject1).troopuin = paramRspBody;
      ((TroopInfo)localObject1).dwAdditionalFlag = 1L;
      TroopMngHandlerProcessorConfig.a(this.appRuntime, paramRspBody, str, (TroopInfo)localObject1);
      Object localObject2 = (ITroopInfoHandler)this.appRuntime.getBusinessHandler(TroopInfoHandler.class.getName());
      if (localObject2 != null) {
        ((ITroopInfoHandler)localObject2).a(((TroopInfo)localObject1).troopuin);
      }
      localObject2 = (ITroopCreateGrayMsg)this.appRuntime.getRuntimeService(ITroopCreateGrayMsg.class, "");
      if (localObject2 != null) {
        ((ITroopCreateGrayMsg)localObject2).addTroopCreatedGrayTipsMr(((TroopInfo)localObject1).troopuin);
      }
      notifyUI(TroopMngObserver.i, true, new Object[] { Integer.valueOf(2131696140), str, paramRspBody, Boolean.valueOf(true) });
      return;
    }
    TroopMngHandlerProcessorConfig.a(this.appRuntime, paramRspBody, str, null);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleTransferDiscussionToTroop, troopUin:");
      ((StringBuilder)localObject1).append(paramRspBody);
      ((StringBuilder)localObject1).append("  discussionUin:");
      ((StringBuilder)localObject1).append(str);
      QLog.d("TroopMngHandler", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  private void b(long paramLong, int paramInt)
  {
    TroopMngHandler.1 local1 = new TroopMngHandler.1(this, paramLong, paramInt);
    this.appRuntime.addDefaultObservers(local1);
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, int paramInt, String paramString, GroupMngRes paramGroupMngRes)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramGroupMngRes.result == 0))
    {
      ((ITroopManagerService)this.appRuntime.getRuntimeService(ITroopManagerService.class, "")).deleteTroop(paramString);
      TroopMngHandlerProcessorConfig.b(this.appRuntime, paramString);
      notifyUI(TroopMngObserver.c, true, new Object[] { Integer.valueOf(paramGroupMngRes.reqtype), Byte.valueOf(paramGroupMngRes.result), paramString });
      return;
    }
    int i = TroopMngObserver.c;
    byte b;
    if (paramFromServiceMsg.isSuccess()) {
      b = paramGroupMngRes.result;
    } else {
      b = -1;
    }
    notifyUI(i, false, new Object[] { Integer.valueOf(paramInt), Byte.valueOf(b) });
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt, String paramString, GroupMngRes paramGroupMngRes)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    paramFromServiceMsg = Integer.valueOf(-1);
    if (bool)
    {
      int i = paramGroupMngRes.result;
      int j = paramGroupMngRes.errorCode;
      if (QLog.isColorLevel()) {
        QLog.d("TroopMngHandler", 2, String.format("handleGroupManager._eJoinGroupReq, errorCode: %s, result: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }));
      }
      if (i == 0)
      {
        paramInt = i;
        if (j == 1) {
          paramInt = -2;
        }
        notifyUI(TroopMngObserver.c, true, new Object[] { Integer.valueOf(paramGroupMngRes.reqtype), Integer.valueOf(paramInt), paramString });
        return;
      }
      if (i == 13)
      {
        paramString = paramGroupMngRes.vecBody;
        if (paramString != null)
        {
          i = (int)PkgTools.getLongData(paramString, 8);
          j = (int)PkgTools.getLongData(paramString, 12);
          paramString = PkgTools.getUTFString(paramString, 16, j);
          paramToServiceMsg = (JoinGroupInfo)paramToServiceMsg.extraData.getParcelable("join_group_info");
          if (QLog.isColorLevel()) {
            QLog.d("TroopMngHandler", 2, String.format("handleGroupManager._eJoinGroupReq, verifyType: %s, verifyUrlLen: %s, verifyUrl: %s, joinGroupInfo: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramString, paramToServiceMsg }));
          }
          if ((!TextUtils.isEmpty(paramString)) && (paramToServiceMsg != null))
          {
            TroopMngHandlerProcessorConfig.a(paramString, i, paramToServiceMsg);
            return;
          }
          notifyUI(TroopMngObserver.c, false, new Object[] { Integer.valueOf(paramInt), paramFromServiceMsg });
          return;
        }
        notifyUI(TroopMngObserver.c, false, new Object[] { Integer.valueOf(paramInt), paramFromServiceMsg });
        return;
      }
      if (i == 14)
      {
        paramToServiceMsg = paramGroupMngRes.vecJoinPrompt;
        if (paramToServiceMsg != null) {
          try
          {
            paramToServiceMsg = new JSONObject(new String(paramToServiceMsg, "utf-8"));
            i = paramToServiceMsg.optInt("tid", 0);
            long l = paramToServiceMsg.optLong("time", 0L);
            notifyUI(TroopMngObserver.c, false, new Object[] { Integer.valueOf(paramInt), paramFromServiceMsg });
            if ((i == 0) || (l == 0L)) {
              return;
            }
            if (QLog.isColorLevel())
            {
              paramToServiceMsg = new StringBuilder();
              paramToServiceMsg.append("handleGroupManager._eJoinGroupReq, 0xe troopCode = ");
              paramToServiceMsg.append(paramString);
              paramToServiceMsg.append(",tId = ");
              paramToServiceMsg.append(i);
              paramToServiceMsg.append(",time =");
              paramToServiceMsg.append(l);
              QLog.d("TroopMngHandler", 2, paramToServiceMsg.toString());
            }
            notifyUI(TroopMngObserver.jdField_b_of_type_Int, false, new Object[] { paramString, Integer.valueOf(i), Long.valueOf(l) });
            return;
          }
          catch (Exception paramToServiceMsg)
          {
            notifyUI(TroopMngObserver.c, false, new Object[] { Integer.valueOf(paramInt), paramFromServiceMsg });
            paramToServiceMsg.printStackTrace();
            return;
          }
        } else {
          notifyUI(TroopMngObserver.c, false, new Object[] { Integer.valueOf(paramInt), paramFromServiceMsg });
        }
      }
      else
      {
        notifyUI(TroopMngObserver.c, false, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      }
    }
    else
    {
      notifyUI(TroopMngObserver.c, false, new Object[] { Integer.valueOf(paramInt), paramFromServiceMsg });
    }
  }
  
  private void b(cmd0x874.RspBody paramRspBody)
  {
    int i = a(paramRspBody.uint32_code.get());
    notifyUI(TroopMngObserver.i, false, new Object[] { Integer.valueOf(i) });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt, String paramString, GroupMngRes paramGroupMngRes)
  {
    Object localObject1 = paramToServiceMsg.extraData.getString("troop_uin");
    Object localObject2 = paramToServiceMsg.extraData.getStringArrayList("frie_uins");
    if ((paramFromServiceMsg.isSuccess()) && (paramGroupMngRes.result == 0) && (paramString != null) && (localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      paramToServiceMsg = this.appRuntime.getEntityManagerFactory().createEntityManager();
      paramFromServiceMsg = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
      localObject1 = paramFromServiceMsg.findTroopInfo((String)localObject1);
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramToServiceMsg.find(TroopMemberInfo.class, "troopuin=? and memberuin=?", new String[] { paramString, str });
        if (localTroopMemberInfo != null)
        {
          paramToServiceMsg.remove(localTroopMemberInfo);
          if (((TroopInfo)localObject1).wMemberNum > 0) {
            ((TroopInfo)localObject1).wMemberNum -= 1;
          }
          if ((((TroopInfo)localObject1).Administrator != null) && (((TroopInfo)localObject1).Administrator.contains(str))) {
            ((TroopInfo)localObject1).Administrator.replace(str, "");
          }
        }
      }
      paramFromServiceMsg.saveTroopInfo((TroopInfo)localObject1);
      paramToServiceMsg.close();
      notifyUI(TroopMngObserver.c, true, new Object[] { Integer.valueOf(paramGroupMngRes.reqtype), Byte.valueOf(paramGroupMngRes.result), paramString });
      return;
    }
    int i = TroopMngObserver.c;
    byte b;
    if (paramFromServiceMsg.isSuccess()) {
      b = paramGroupMngRes.result;
    } else {
      b = -1;
    }
    notifyUI(i, false, new Object[] { Integer.valueOf(paramInt), Byte.valueOf(b) });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.extraData.getInt("type", 0) != 2) {
      return;
    }
    paramToServiceMsg = new TroopCreateInfo.TroopCreateResult();
    if (paramFromServiceMsg == null)
    {
      notifyUI(TroopMngObserver.jdField_a_of_type_Int, false, paramToServiceMsg);
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      notifyUI(TroopMngObserver.jdField_a_of_type_Int, false, paramToServiceMsg);
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramObject = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if (paramObject == null)
      {
        notifyUI(TroopMngObserver.jdField_a_of_type_Int, false, paramToServiceMsg);
        return;
      }
      int i = paramObject.uint32_result.get();
      if (i != 0)
      {
        paramToServiceMsg.jdField_a_of_type_Int = i;
        notifyUI(TroopMngObserver.jdField_a_of_type_Int, false, paramToServiceMsg);
        return;
      }
      paramFromServiceMsg = new cmd0x8a1.RspBody();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      label204:
      label214:
      break label214;
    }
    try
    {
      paramFromServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
      if (paramFromServiceMsg.uint32_create_option.get() != 1)
      {
        notifyUI(TroopMngObserver.jdField_a_of_type_Int, false, paramToServiceMsg);
        return;
      }
      paramToServiceMsg = new TroopInfo();
      paramToServiceMsg.troopuin = String.valueOf(Utils.a(paramFromServiceMsg.uint32_group_code.get()));
      notifyUI(TroopMngObserver.jdField_a_of_type_Int, true, paramToServiceMsg);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      break label204;
    }
    notifyUI(TroopMngObserver.jdField_a_of_type_Int, false, paramToServiceMsg);
    return;
    notifyUI(TroopMngObserver.jdField_a_of_type_Int, false, paramToServiceMsg);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bool2 = false;
    if ((paramObject != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramFromServiceMsg = null;
    if (bool1) {}
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg.uint32_result.get() != 0) {
        break label193;
      }
      bool1 = true;
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        bool1 = bool2;
        paramToServiceMsg = paramFromServiceMsg;
        continue;
        bool1 = false;
      }
    }
    if (bool1)
    {
      paramObject = new oidb_0x9fa.RspBody();
      paramObject.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      bool1 = bool2;
      paramToServiceMsg = paramFromServiceMsg;
      if (paramObject.web_info.has())
      {
        bool1 = bool2;
        paramToServiceMsg = paramFromServiceMsg;
        if (((oidb_0x9fa.SimilarGroupWebInfo)paramObject.web_info.get()).bytes_url.has())
        {
          paramToServiceMsg = ((oidb_0x9fa.SimilarGroupWebInfo)paramObject.web_info.get()).bytes_url.get().toStringUtf8();
          bool1 = true;
        }
      }
    }
    else
    {
      paramToServiceMsg = paramFromServiceMsg;
      break label172;
      paramToServiceMsg = paramFromServiceMsg;
    }
    label172:
    notifyUI(TroopMngObserver.g, bool1, paramToServiceMsg);
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    cmd0x758.RspBody localRspBody = new cmd0x758.RspBody();
    int j = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = (InviteToGroupInfo)paramToServiceMsg.extraData.getParcelable(InviteToGroupInfo.class.getSimpleName());
    String str = paramFromServiceMsg.jdField_a_of_type_JavaLangString;
    paramToServiceMsg = "";
    paramObject = Integer.valueOf(8);
    if (j == 0)
    {
      if (localRspBody.uint64_current_max_msgseq.has())
      {
        long l = localRspBody.uint64_current_max_msgseq.get();
        ((ITroopCreateInfoService)this.appRuntime.getRuntimeService(ITroopCreateInfoService.class, "")).getTroopCreateInfo().maxSeq = l;
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("TroopCreatGrayTip handleInviteToGroup troopMaxMsgseq:");
          paramToServiceMsg.append(l);
          QLog.d("TroopMngHandler", 2, paramToServiceMsg.toString());
        }
      }
      notifyUI(TroopMngObserver.c, true, new Object[] { paramObject, Integer.valueOf(0), str });
      paramToServiceMsg = ((ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(str);
      if ((paramToServiceMsg != null) && (!paramToServiceMsg.hasSetTroopHead())) {
        ((TroopMemberListHandler)this.appRuntime.getBusinessHandler(TroopMemberListHandler.class.getName())).a(Long.parseLong(str));
      }
    }
    else if (j == 1537)
    {
      if (localRspBody.string_verify_url.has()) {
        paramToServiceMsg = localRspBody.string_verify_url.get();
      }
      int i;
      if (localRspBody.uint32_verify_type.has()) {
        i = localRspBody.uint32_verify_type.get();
      } else {
        i = 0;
      }
      if (!TextUtils.isEmpty(paramToServiceMsg)) {
        TroopMngHandlerProcessorConfig.a(paramToServiceMsg, i, paramFromServiceMsg);
      } else {
        notifyUI(TroopMngObserver.c, false, new Object[] { paramObject, Integer.valueOf(j) });
      }
      QLog.d("TroopMngHandler", 1, String.format("handleInviteToGroup, verifyType: %s, verifyUrl: %s, inviteToGroupInfo: %s", new Object[] { Integer.valueOf(i), paramToServiceMsg, paramFromServiceMsg }));
    }
    else
    {
      notifyUI(TroopMngObserver.c, false, new Object[] { paramObject, Integer.valueOf(j) });
      QLog.d("TroopMngHandler", 1, String.format("handleInviteToGroup, result: %s", new Object[] { Integer.valueOf(j) }));
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMngHandler", 2, String.format("handleInviteToGroup, result: %s, inviteToGroupInfo: %s", new Object[] { Integer.valueOf(j), paramFromServiceMsg }));
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Integer localInteger = Integer.valueOf(2131696133);
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        notifyUI(TroopMngObserver.i, false, new Object[] { localInteger });
        return;
      }
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
        paramFromServiceMsg = new cmd0x874.RspBody();
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      label151:
      break label187;
    }
    try
    {
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      if (paramFromServiceMsg.uint32_code.get() == 0)
      {
        a(paramFromServiceMsg);
        return;
      }
      b(paramFromServiceMsg);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      break label151;
    }
    notifyUI(TroopMngObserver.i, false, new Object[] { localInteger });
    return;
    notifyUI(TroopMngObserver.i, false, new Object[] { localInteger });
    return;
    label187:
    notifyUI(TroopMngObserver.i, false, new Object[] { localInteger });
    return;
    notifyUI(TroopMngObserver.i, false, new Object[] { localInteger });
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      paramToServiceMsg = new cmd0xcca.RspBody();
      int m = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleGetGroupInviteStatus result code is: ");
        paramFromServiceMsg.append(m);
        QLog.i("TroopMngHandler", 2, paramFromServiceMsg.toString());
      }
      if (m == 0)
      {
        paramFromServiceMsg = new ArrayList();
        int i;
        if (paramToServiceMsg.uint32_group_members_num.has()) {
          i = paramToServiceMsg.uint32_group_members_num.get();
        } else {
          i = 0;
        }
        int j;
        if (paramToServiceMsg.uint32_group_friends_num.has()) {
          j = paramToServiceMsg.uint32_group_friends_num.get();
        } else {
          j = 0;
        }
        int k;
        if (paramToServiceMsg.friends_uins.has())
        {
          k = 0;
          while (k < paramToServiceMsg.friends_uins.size())
          {
            paramFromServiceMsg.add(String.valueOf(paramToServiceMsg.friends_uins.get(k)));
            k += 1;
          }
        }
        if (paramToServiceMsg.uint32_status.has()) {
          k = paramToServiceMsg.uint32_status.get();
        } else {
          k = 0;
        }
        notifyUI(TroopMngObserver.k, true, new Object[] { Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), paramFromServiceMsg, Integer.valueOf(k) });
        return;
      }
      notifyUI(TroopMngObserver.k, false, new Object[] { Integer.valueOf(m), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopMngHandler", 2, "handleGetGroupInviteStatus req or resp is null.");
    }
  }
  
  protected String a()
  {
    return "TroopMngHandler";
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    notifyUI(paramInt, paramBoolean, paramObject);
  }
  
  public void a(long paramLong)
  {
    Object localObject1 = new cmd0x874.ReqBody();
    ((cmd0x874.ReqBody)localObject1).uint32_subcmd.set(1);
    Object localObject2 = new cmd0x874.ConvertToGroupReq();
    ((cmd0x874.ConvertToGroupReq)localObject2).uint64_conf_uin.set(paramLong);
    ((cmd0x874.ReqBody)localObject1).msg_convert_group.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2164);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x874.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0x874_1");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder(150);
      ((StringBuilder)localObject).append("send_oidb_0x88d_1");
      ((StringBuilder)localObject).append("|troopuin = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("|flag = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("Q.troopquestionverify.", 2, ((StringBuilder)localObject).toString());
    }
    b(paramLong, paramInt);
    Object localObject = new oidb_0x88d.GroupInfo();
    if ((paramInt & 0x80) == 128) {
      ((oidb_0x88d.GroupInfo)localObject).uint32_group_option.set(0);
    }
    if ((paramInt & 0x800000) == 8388608) {
      ((oidb_0x88d.GroupInfo)localObject).string_group_question.set(ByteStringMicro.EMPTY);
    }
    if ((paramInt & 0x800) == 2048) {
      ((oidb_0x88d.GroupInfo)localObject).string_group_answer.set(ByteStringMicro.EMPTY);
    }
    if ((paramInt & 0x1) == 1) {
      ((oidb_0x88d.GroupInfo)localObject).uint32_app_privilege_flag.set(0);
    }
    ((oidb_0x88d.GroupInfo)localObject).uint32_group_flagext3.set(0);
    ((ITroopInfoHandler)this.appRuntime.getBusinessHandler(TroopInfoHandler.class.getName())).a(Long.valueOf(paramLong), (oidb_0x88d.GroupInfo)localObject, "SUBCMD_GET_TROOP_TAG", this.appRuntime.getAppid(), 30000L, 1);
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, long paramLong3, long paramLong4, int paramInt5, String paramString3, byte[] paramArrayOfByte)
  {
    cmd0x8a1.ReqBody localReqBody = new cmd0x8a1.ReqBody();
    localReqBody.uint32_create_option.set(1);
    cmd0x8a1.CreateGroupInfo localCreateGroupInfo = new cmd0x8a1.CreateGroupInfo();
    localCreateGroupInfo.uint32_group_code.set(Utils.a(paramLong1));
    localCreateGroupInfo.uint32_group_size.set(paramInt1);
    localCreateGroupInfo.uint64_owner_uin.set(paramLong2);
    localCreateGroupInfo.uint32_group_option.set(paramInt2);
    localCreateGroupInfo.string_group_name.set(ByteStringMicro.copyFromUtf8(paramString1));
    localCreateGroupInfo.string_group_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString2));
    localCreateGroupInfo.string_group_rich_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString2));
    localCreateGroupInfo.uint32_group_class.set(0);
    localCreateGroupInfo.uint32_group_class_ext.set(paramInt3);
    localCreateGroupInfo.uint32_group_type_flag.set(paramInt4);
    paramString1 = new cmd0x8a1.GroupGeoInfo();
    paramString1.uint32_city_id.set(paramInt5);
    paramString1.uint64_latitude.set(paramLong3);
    paramString1.uint64_longtitude.set(paramLong4);
    paramString1.string_geo_content.set(ByteStringMicro.copyFromUtf8(paramString3));
    localCreateGroupInfo.msg_group_geo_info.set(paramString1);
    localCreateGroupInfo.string_sign.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localCreateGroupInfo.uint64_create_flag.set(16L);
    localCreateGroupInfo.uint32_group_face.set(0);
    localCreateGroupInfo.uint32_app_id.set(200000007);
    localReqBody.msg_create_group_info.set(localCreateGroupInfo);
    paramString1 = new oidb_sso.OIDBSSOPkg();
    paramString1.uint32_command.set(2209);
    paramString1.uint32_result.set(0);
    paramString1.uint32_service_type.set(7);
    paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramString2 = createToServiceMsg("OidbSvc.0x8a1_0");
    paramString2.putWupBuffer(paramString1.toByteArray());
    paramString2.extraData.putInt("type", 2);
    sendPbReq(paramString2);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    Object localObject1 = new oidb_0x9fa.ReqBody();
    ((oidb_0x9fa.ReqBody)localObject1).uint32_appid.set(1);
    ((oidb_0x9fa.ReqBody)localObject1).uint32_cmdid.set(6);
    ((oidb_0x9fa.ReqBody)localObject1).int32_channel.set(3);
    Object localObject2 = new oidb_0x9fa.GetSimilarGroupWebInfo();
    ((oidb_0x9fa.GetSimilarGroupWebInfo)localObject2).uint64_group_code.set(paramLong1);
    ((oidb_0x9fa.GetSimilarGroupWebInfo)localObject2).uint64_uin.set(paramLong2);
    ((oidb_0x9fa.ReqBody)localObject1).msg_get_web_info.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2554);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x9fa.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0x9fa");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).setTimeout(3000L);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(150);
      ((StringBuilder)localObject1).append("send_oidb_0x89e");
      ((StringBuilder)localObject1).append("|troopuin = ");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append("|oldOwner = ");
      ((StringBuilder)localObject1).append(paramLong2);
      ((StringBuilder)localObject1).append("|newOwner = ");
      ((StringBuilder)localObject1).append(paramLong3);
      QLog.i("Q.troopdisband.", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new oidb_0x89e.ReqBody();
    ((oidb_0x89e.ReqBody)localObject2).uint64_group_code.set(paramLong1);
    ((oidb_0x89e.ReqBody)localObject2).uint64_old_owner.set(paramLong2);
    ((oidb_0x89e.ReqBody)localObject2).uint64_new_owner.set(paramLong3);
    Object localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2206);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x89e.ReqBody)localObject2).toByteArray()));
    localObject2 = createToServiceMsg("OidbSvc.0x89e_0");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putLong("troop_uin", paramLong1);
    ((ToServiceMsg)localObject2).extraData.putLong("OldOwner", paramLong2);
    ((ToServiceMsg)localObject2).extraData.putLong("NewOwner", paramLong3);
    ((ToServiceMsg)localObject2).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    Object localObject = new oidb_0xe72.ReqBody();
    ((oidb_0xe72.ReqBody)localObject).uint64_grp_code.set(paramLong1);
    ((oidb_0xe72.ReqBody)localObject).uint64_uin.set(paramLong2);
    if (!TextUtils.isEmpty(paramString)) {
      ((oidb_0xe72.ReqBody)localObject).bytes_join_group_auth.set(ByteStringMicro.copyFromUtf8(paramString));
    }
    ((oidb_0xe72.ReqBody)localObject).uint32_edu_support_no_verify.set(1);
    localObject = makeOIDBPkg("oidbSvc.0xe72", 3698, 0, ((oidb_0xe72.ReqBody)localObject).toByteArray(), 30000L);
    ((ToServiceMsg)localObject).addAttribute("troopUin", String.valueOf(paramLong1));
    ((ToServiceMsg)localObject).addAttribute("userUin", String.valueOf(paramLong2));
    ((ToServiceMsg)localObject).addAttribute("authKey", paramString);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(InviteToGroupInfo paramInviteToGroupInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMngHandler", 2, String.format("inviteToGroupWithNonFriends: %s", new Object[] { paramInviteToGroupInfo }));
    }
    if ((paramInviteToGroupInfo != null) && (paramInviteToGroupInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramInviteToGroupInfo.jdField_a_of_type_JavaUtilArrayList.size() != 0)) {}
    for (;;)
    {
      int i;
      try
      {
        Object localObject2 = paramInviteToGroupInfo.jdField_a_of_type_JavaUtilArrayList;
        localObject1 = new ArrayList();
        i = 0;
        if (i < ((List)localObject2).size())
        {
          InviteToGroupInfo.UinInfo localUinInfo = (InviteToGroupInfo.UinInfo)((List)localObject2).get(i);
          if ((!TextUtils.isEmpty(localUinInfo.jdField_a_of_type_JavaLangString)) && (!localUinInfo.jdField_a_of_type_JavaLangString.equals(this.appRuntime.getCurrentAccountUin())))
          {
            cmd0x758.InviteUinInfo localInviteUinInfo = new cmd0x758.InviteUinInfo();
            localInviteUinInfo.uint64_uin.set(Long.valueOf(localUinInfo.jdField_a_of_type_JavaLangString).longValue());
            if (!TextUtils.isEmpty(localUinInfo.c)) {
              localInviteUinInfo.uint64_judge_conf_code.set(Long.parseLong(localUinInfo.c));
            } else if (!TextUtils.isEmpty(localUinInfo.jdField_b_of_type_JavaLangString)) {
              localInviteUinInfo.uint64_judge_group_code.set(Long.parseLong(localUinInfo.jdField_b_of_type_JavaLangString));
            }
            ((List)localObject1).add(localInviteUinInfo);
            break label449;
          }
          QLog.d("TroopMngHandler", 1, String.format("inviteToGroupWithNonFriends, filter uin: %s", new Object[] { localUinInfo.jdField_a_of_type_JavaLangString }));
          break label449;
        }
        if (((List)localObject1).size() == 0)
        {
          QLog.d("TroopMngHandler", 1, "inviteToGroupWithNonFriends, uinInfoList.size() == 0");
          return;
        }
        localObject2 = new cmd0x758.ReqBody();
        ((cmd0x758.ReqBody)localObject2).uint64_join_group_code.set(Long.valueOf(paramInviteToGroupInfo.jdField_a_of_type_JavaLangString).longValue());
        if (!TextUtils.isEmpty(paramInviteToGroupInfo.jdField_b_of_type_JavaLangString)) {
          ((cmd0x758.ReqBody)localObject2).string_msg.set(paramInviteToGroupInfo.jdField_b_of_type_JavaLangString);
        }
        ((cmd0x758.ReqBody)localObject2).be_invited_uin_info.set((List)localObject1);
        ((cmd0x758.ReqBody)localObject2).uint32_verify_type.set(paramInviteToGroupInfo.jdField_a_of_type_Int);
        if (!TextUtils.isEmpty(paramInviteToGroupInfo.c)) {
          ((cmd0x758.ReqBody)localObject2).string_verify_token.set(paramInviteToGroupInfo.c);
        }
        localObject1 = makeOIDBPkg("OidbSvc.oidb_0x758", 1880, 1, ((cmd0x758.ReqBody)localObject2).toByteArray());
        ((ToServiceMsg)localObject1).extraData.putParcelable(InviteToGroupInfo.class.getSimpleName(), paramInviteToGroupInfo);
        sendPbReq((ToServiceMsg)localObject1);
        return;
      }
      catch (NumberFormatException paramInviteToGroupInfo)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("inviteToGroupWithNonFriends: ");
        ((StringBuilder)localObject1).append(paramInviteToGroupInfo.getMessage());
        QLog.d("TroopMngHandler", 1, ((StringBuilder)localObject1).toString());
        return;
      }
      QLog.d("TroopMngHandler", 1, String.format("inviteToGroupWithNonFriends: %s", new Object[] { paramInviteToGroupInfo }));
      return;
      label449:
      i += 1;
    }
  }
  
  public void a(JoinGroupInfo paramJoinGroupInfo)
  {
    if (paramJoinGroupInfo == null) {
      return;
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 1);
    localToServiceMsg.extraData.putString("troop_uin", paramJoinGroupInfo.jdField_a_of_type_JavaLangString);
    localToServiceMsg.extraData.putString("uin", this.appRuntime.getCurrentAccountUin());
    localToServiceMsg.extraData.putString("back_msg", paramJoinGroupInfo.jdField_b_of_type_JavaLangString);
    localToServiceMsg.extraData.putInt("stat_option", paramJoinGroupInfo.jdField_a_of_type_Int);
    localToServiceMsg.extraData.putString("join_group_key", paramJoinGroupInfo.c);
    localToServiceMsg.extraData.putString("join_group_sig", paramJoinGroupInfo.d);
    if (paramJoinGroupInfo.jdField_a_of_type_ArrayOfByte != null) {
      localToServiceMsg.extraData.putByteArray("new_Member_Msg", paramJoinGroupInfo.jdField_a_of_type_ArrayOfByte);
    }
    if (!TextUtils.isEmpty(paramJoinGroupInfo.e)) {
      localToServiceMsg.extraData.putString("pic_url", paramJoinGroupInfo.e);
    }
    localToServiceMsg.extraData.putInt("join_group_verify_type", paramJoinGroupInfo.jdField_b_of_type_Int);
    localToServiceMsg.extraData.putString("join_group_verify_token", paramJoinGroupInfo.f);
    localToServiceMsg.extraData.putParcelable("join_group_info", paramJoinGroupInfo);
    send(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("TroopMngHandler", 2, String.format("joinGroup, %s", new Object[] { paramJoinGroupInfo }));
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1 = paramToServiceMsg.extraData.getLong("OldOwner");
    long l2 = paramToServiceMsg.extraData.getLong("NewOwner");
    long l3 = paramToServiceMsg.extraData.getLong("troop_uin");
    int i = paramFromServiceMsg.getResultCode();
    int j = -1;
    Object localObject1;
    label133:
    int k;
    if (i == 1000)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        try
        {
          paramObject = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
          paramToServiceMsg = paramObject;
        }
        catch (InvalidProtocolBufferMicroException paramObject) {}
        if (!QLog.isColorLevel()) {
          break label133;
        }
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        paramToServiceMsg = null;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handle_oidb_0x89e_0| oidb_sso parseFrom byte ");
      ((StringBuilder)localObject1).append(paramObject.toString());
      QLog.d("TroopMngHandler", 2, ((StringBuilder)localObject1).toString());
      paramObject.printStackTrace();
      if (paramToServiceMsg != null)
      {
        i = paramToServiceMsg.uint32_result.get();
        j = i;
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("handle_oidb_0x89e_0|oidb_sso.OIDBSSOPkg.result = ");
          paramObject.append(i);
          QLog.i("TroopMngHandler", 2, paramObject.toString());
          j = i;
        }
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
      {
        paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
        k = j;
      }
    }
    for (;;)
    {
      boolean bool2;
      ToServiceMsg localToServiceMsg;
      try
      {
        Object localObject2 = new oidb_0x89e.RspBody();
        k = j;
        ((oidb_0x89e.RspBody)localObject2).mergeFrom(paramToServiceMsg);
        i = j;
        k = j;
        if (((oidb_0x89e.RspBody)localObject2).uint32_result.has())
        {
          k = j;
          j = ((oidb_0x89e.RspBody)localObject2).uint32_result.get();
          i = j;
          k = j;
          if (QLog.isColorLevel())
          {
            k = j;
            paramToServiceMsg = new StringBuilder();
            k = j;
            paramToServiceMsg.append("handle_oidb_0x89e_0|oidb_0x89e.RspBody.result = ");
            k = j;
            paramToServiceMsg.append(j);
            k = j;
            QLog.i("TroopMngHandler", 2, paramToServiceMsg.toString());
            i = j;
          }
        }
        if (i <= 0) {
          break label879;
        }
        k = i;
        if (!((oidb_0x89e.RspBody)localObject2).str_errorinfo.has()) {
          break label879;
        }
        k = i;
        localObject1 = String.valueOf(((oidb_0x89e.RspBody)localObject2).str_errorinfo.get().toByteArray());
        paramToServiceMsg = (ToServiceMsg)localObject1;
        paramObject = localObject1;
        try
        {
          if (QLog.isColorLevel())
          {
            paramObject = localObject1;
            paramToServiceMsg = new StringBuilder();
            paramObject = localObject1;
            paramToServiceMsg.append("handle_oidb_0x89e_0|strErrorMsg = ");
            paramObject = localObject1;
            paramToServiceMsg.append((String)localObject1);
            paramObject = localObject1;
            QLog.i("TroopMngHandler", 2, paramToServiceMsg.toString());
            paramToServiceMsg = (ToServiceMsg)localObject1;
          }
          if (i == 0)
          {
            paramObject = paramToServiceMsg;
            long l4 = ((oidb_0x89e.RspBody)localObject2).uint64_group_code.get();
            if (l4 == l3) {
              try
              {
                localObject2 = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
                localObject1 = ((ITroopInfoService)localObject2).findTroopInfo(String.valueOf(l3));
                paramObject = localObject1;
                if (localObject1 == null)
                {
                  paramObject = new TroopInfo();
                  paramObject.troopuin = String.valueOf(l3);
                }
                paramObject.troopowneruin = String.valueOf(l2);
                ((ITroopInfoService)localObject2).saveTroopInfo(paramObject);
                bool1 = true;
              }
              catch (Exception localException)
              {
                bool2 = true;
                paramObject = paramToServiceMsg;
                j = i;
                continue;
              }
            }
          }
          bool1 = false;
        }
        catch (Exception paramToServiceMsg)
        {
          j = i;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        j = k;
        paramObject = null;
        bool2 = false;
        localToServiceMsg = paramToServiceMsg;
        paramToServiceMsg = paramObject;
        bool1 = bool2;
        i = j;
        if (!QLog.isColorLevel()) {
          break label688;
        }
      }
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handle_oidb_0x89e_0|exception = ");
      paramToServiceMsg.append(localToServiceMsg.toString());
      QLog.i("TroopMngHandler", 2, paramToServiceMsg.toString());
      paramToServiceMsg = paramObject;
      boolean bool1 = bool2;
      i = j;
      break label688;
      i = j;
      paramToServiceMsg = null;
      bool1 = false;
      break label688;
      paramToServiceMsg = null;
      bool1 = false;
      i = -1;
      label688:
      notifyUI(TroopMngObserver.e, bool1, new Object[] { Long.valueOf(l3), String.valueOf(l1), String.valueOf(l2), Integer.valueOf(i), paramToServiceMsg });
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder(150);
        paramObject.append("handle_oidb_0x89e_0");
        paramObject.append("|isSuccess = ");
        paramObject.append(bool1);
        paramObject.append("|resultcode = ");
        paramObject.append(paramFromServiceMsg.getResultCode());
        paramObject.append("|troopuin = ");
        paramObject.append(l3);
        paramObject.append("|oldOwner = ");
        paramObject.append(l1);
        paramObject.append("|newOwner = ");
        paramObject.append(l2);
        paramObject.append("|result = ");
        paramObject.append(i);
        paramObject.append("|strErrorMsg = ");
        paramObject.append(paramToServiceMsg);
        QLog.i("TroopMngHandler", 2, paramObject.toString());
      }
      return;
      label879:
      paramToServiceMsg = null;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resignGroup groupCode = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TroopMngHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = createToServiceMsg("ProfileService.GroupMngReq");
    ((ToServiceMsg)localObject).extraData.putInt("groupreqtype", 2);
    ((ToServiceMsg)localObject).extraData.putString("troop_uin", paramString);
    ((ToServiceMsg)localObject).extraData.putString("uin", this.appRuntime.getCurrentAccountUin());
    send((ToServiceMsg)localObject);
    TroopMngHandlerProcessorConfig.c(this.appRuntime, paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 0);
    localToServiceMsg.extraData.putString("troop_uin", paramString);
    localToServiceMsg.extraData.putString("uin", this.appRuntime.getCurrentAccountUin());
    localToServiceMsg.extraData.putInt("stat_option", paramInt);
    localToServiceMsg.extraData.putByte("cIfGetAuthInfo", (byte)1);
    send(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, byte[] paramArrayOfByte, String paramString5)
  {
    JoinGroupInfo localJoinGroupInfo = new JoinGroupInfo();
    localJoinGroupInfo.jdField_a_of_type_JavaLangString = paramString1;
    localJoinGroupInfo.jdField_b_of_type_JavaLangString = paramString2;
    localJoinGroupInfo.jdField_a_of_type_Int = paramInt;
    localJoinGroupInfo.c = paramString3;
    localJoinGroupInfo.d = paramString4;
    localJoinGroupInfo.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    localJoinGroupInfo.e = paramString5;
    a(localJoinGroupInfo);
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    cmd0xcca.ReqBody localReqBody = new cmd0xcca.ReqBody();
    for (;;)
    {
      try
      {
        localReqBody.uint64_uin.set(Long.valueOf(paramString2).longValue());
        localReqBody.uint64_grp_code.set(Long.valueOf(paramString1).longValue());
        localReqBody.uint64_msg_seq.set(paramLong);
        if ((this.appRuntime != null) && (!TextUtils.equals(this.appRuntime.getCurrentUin(), paramString2)))
        {
          i = 2;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("getGroupInviteStatus service_type:");
            localStringBuilder.append(i);
            localStringBuilder.append(" invitedUin:");
            localStringBuilder.append(paramString2);
            localStringBuilder.append(" troopCode:");
            localStringBuilder.append(paramString1);
            localStringBuilder.append("  msgSeq:");
            localStringBuilder.append(paramLong);
            QLog.i("TroopMngHandler", 2, localStringBuilder.toString());
          }
          sendPbReq(makeOIDBPkg("OidbSvc.cmd0xcca", 3274, i, localReqBody.toByteArray()));
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getGroupInviteStatus exception: ");
        localStringBuilder.append(localNumberFormatException.getMessage());
        localStringBuilder.append(" invitedUin : ");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(" troopCode: ");
        localStringBuilder.append(paramString1);
        QLog.i("troop_ext", 1, localStringBuilder.toString());
        return;
      }
      int i = 1;
    }
  }
  
  public void a(String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramArrayList != null) && (paramArrayList.size() != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMngHandler", 2, String.format("inviteToGroup, groupCode: %s, inviteUins: %s, strMsg: %s", new Object[] { paramString1, paramArrayList, paramString2 }));
      }
      InviteToGroupInfo localInviteToGroupInfo = new InviteToGroupInfo();
      localInviteToGroupInfo.jdField_a_of_type_JavaLangString = paramString1;
      paramString1 = new ArrayList();
      localInviteToGroupInfo.jdField_b_of_type_JavaLangString = paramString2;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramString2 = (String)paramArrayList.next();
        InviteToGroupInfo.UinInfo localUinInfo = new InviteToGroupInfo.UinInfo();
        localUinInfo.jdField_a_of_type_JavaLangString = paramString2;
        paramString1.add(localUinInfo);
      }
      localInviteToGroupInfo.jdField_a_of_type_JavaUtilArrayList = paramString1;
      a(localInviteToGroupInfo);
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("inviteToGroup params error groupCode: ");
    paramString2.append(paramString1);
    paramString2.append(", inviteUins: ");
    paramString2.append(paramArrayList);
    QLog.d("TroopMngHandler", 1, paramString2.toString());
  }
  
  public void a(String paramString1, List<TroopCreateInfo.InviteMemberInfo> paramList, String paramString2)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    int i = 0;
    if ((!bool) && (paramList != null))
    {
      ArrayList localArrayList = new ArrayList();
      while (i < paramList.size())
      {
        TroopCreateInfo.InviteMemberInfo localInviteMemberInfo = (TroopCreateInfo.InviteMemberInfo)paramList.get(i);
        if (!localInviteMemberInfo.jdField_a_of_type_JavaLangString.equals(this.appRuntime.getCurrentAccountUin()))
        {
          InviteToGroupInfo.UinInfo localUinInfo = new InviteToGroupInfo.UinInfo();
          localUinInfo.jdField_a_of_type_JavaLangString = localInviteMemberInfo.jdField_a_of_type_JavaLangString;
          if (localInviteMemberInfo.jdField_a_of_type_Int == 1) {
            localUinInfo.jdField_b_of_type_JavaLangString = localInviteMemberInfo.c;
          } else if (localInviteMemberInfo.jdField_a_of_type_Int == 2) {
            localUinInfo.c = localInviteMemberInfo.c;
          }
          localArrayList.add(localUinInfo);
        }
        i += 1;
      }
      paramList = new InviteToGroupInfo();
      paramList.jdField_a_of_type_JavaLangString = paramString1;
      paramList.jdField_b_of_type_JavaLangString = paramString2;
      paramList.jdField_a_of_type_JavaUtilArrayList = localArrayList;
      a(paramList);
      return;
    }
    QLog.d("TroopMngHandler", 1, String.format("inviteToGroupWithNonFriends, groupCode: %s or inviteList is empty", new Object[] { paramString1 }));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      String str1 = (String)paramToServiceMsg.getAttribute("troopUin", "");
      String str2 = (String)paramToServiceMsg.getAttribute("userUin", "");
      paramToServiceMsg = (String)paramToServiceMsg.getAttribute("authKey", "");
      oidb_0xe72.RspBody localRspBody = new oidb_0xe72.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      int j = localRspBody.uint32_no_verify.get();
      int k = localRspBody.uint32_high_risk_group.get();
      boolean bool;
      if (i == 0) {
        bool = true;
      } else {
        bool = false;
      }
      if (!TextUtils.isEmpty(paramToServiceMsg))
      {
        notifyUI(TroopMngObserver.j, bool, new Object[] { Integer.valueOf(j), str1, str2, paramToServiceMsg, Integer.valueOf(k) });
        return;
      }
      notifyUI(TroopMngObserver.j, bool, new Object[] { str1, Integer.valueOf(k) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMngHandler", 2, "handleQueryJoinTroopCanNoVierfy resp == null || res == null");
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("disbandGroup groupCode = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TroopMngHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = createToServiceMsg("ProfileService.GroupMngReq");
    ((ToServiceMsg)localObject).extraData.putInt("groupreqtype", 9);
    ((ToServiceMsg)localObject).extraData.putString("troop_uin", paramString);
    ((ToServiceMsg)localObject).extraData.putString("uin", this.appRuntime.getCurrentAccountUin());
    send((ToServiceMsg)localObject);
    TroopMngHandlerProcessorConfig.a(this.appRuntime, paramString);
  }
  
  public void c(String paramString)
  {
    a(paramString, 0);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("ProfileService.GroupMngReq");
      this.allowCmdSet.add("OidbSvc.oidb_0x758");
      this.allowCmdSet.add("OidbSvc.0x9fa");
      this.allowCmdSet.add("OidbSvc.0x89e_0");
      this.allowCmdSet.add("OidbSvc.0x8a1_0");
      this.allowCmdSet.add("OidbSvc.0x874_1");
      this.allowCmdSet.add("oidbSvc.0xe72");
      this.allowCmdSet.add("OidbSvc.cmd0xcca");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopMngObserver.class;
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
          QLog.d("TroopMngHandler", 2, paramToServiceMsg.toString());
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
          QLog.d("TroopMngHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("ProfileService.GroupMngReq".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.oidb_0x758".equals(paramFromServiceMsg.getServiceCmd()))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9fa".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x89e_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8a1_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x874_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("oidbSvc.0xe72".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.cmd0xcca".equals(paramFromServiceMsg.getServiceCmd())) {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMngHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopMngHandler
 * JD-Core Version:    0.7.0.1
 */