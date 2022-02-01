package com.tencent.mobileqq.troop.onlinepush.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.troop.api.ITroopNameHelperService;
import com.tencent.mobileqq.troop.api.config.TroopOnlinePushHandlerProcessorConfig;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectConfig;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectData;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.handler.TroopMemberListHandler;
import com.tencent.mobileqq.troop.observer.TroopRedDotObserver;
import com.tencent.mobileqq.troop.onlinepush.api.ITroopOnlinePushHandler;
import com.tencent.mobileqq.troop.onlinepush.api.TroopOnlinePushObserver;
import com.tencent.mobileqq.troop.troopreddot.api.ITroopRedDotHandler;
import com.tencent.mobileqq.troop.troopreddot.handler.TroopRedDotHandler;
import com.tencent.mobileqq.troop.unreadmsg.TroopUnreadMsgInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppID;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x4UpdateApp;

public class TroopOnlinePushHandler
  extends TroopBaseHandler
  implements ITroopOnlinePushHandler
{
  HashMap<String, Long> a = new HashMap(50);
  
  public TroopOnlinePushHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    ((ITroopRedDotHandler)this.appRuntime.getBusinessHandler(TroopRedDotHandler.class.getName())).a(paramInt, paramBoolean, paramObject);
  }
  
  private void a(TroopEnterEffectData paramTroopEnterEffectData)
  {
    ITroopEnterEffectService localITroopEnterEffectService = (ITroopEnterEffectService)this.appRuntime.getRuntimeService(ITroopEnterEffectService.class, "all");
    if (localITroopEnterEffectService.getTroopEnterEffectConfig().a)
    {
      localITroopEnterEffectService.addTroopEnterEffectData(paramTroopEnterEffectData);
      TroopOnlinePushHandlerProcessorConfig.a().a(this.appRuntime, paramTroopEnterEffectData);
      notifyUI(TroopOnlinePushObserver.TYPE_NOTIFY_TROOP_ENTER_EFFECT_PUSH, true, paramTroopEnterEffectData);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect", 2, "handleTroopEnterEffectPush function not enable");
    }
  }
  
  private void a(submsgtype0x26.MsgBody.SubCmd0x4UpdateApp paramSubCmd0x4UpdateApp)
  {
    long l = paramSubCmd0x4UpdateApp.msg_app_id.uint64_app_id.get();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramSubCmd0x4UpdateApp.uint64_group_code.get());
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    if (l == 1105933138L)
    {
      TroopOnlinePushHandlerProcessorConfig.a().a(this.appRuntime, (String)localObject);
      return;
    }
    if ((paramSubCmd0x4UpdateApp.sint32_unread_num.get() == 0) && (l == 1102858908L))
    {
      if (QLog.isColorLevel())
      {
        paramSubCmd0x4UpdateApp = new StringBuilder();
        paramSubCmd0x4UpdateApp.append("handleTroopNewsOnlinePush, deleteFeedInfo, troopUin=");
        paramSubCmd0x4UpdateApp.append((String)localObject);
        QLog.i("TroopOnlinePushHandler", 2, paramSubCmd0x4UpdateApp.toString());
      }
      a(TroopRedDotObserver.f, true, new Object[] { localObject, Boolean.valueOf(true), Boolean.valueOf(true) });
    }
  }
  
  protected String a()
  {
    return "TroopOnlinePushHandler";
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, false);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleMemberAdd addMemberUin:");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append("  nick:");
      ((StringBuilder)localObject1).append(paramString3);
      ((StringBuilder)localObject1).append(" currentUin:");
      ((StringBuilder)localObject1).append(this.appRuntime.getCurrentAccountUin());
      QLog.d("TroopOnlinePushHandler", 2, ((StringBuilder)localObject1).toString());
    }
    long l = System.currentTimeMillis();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("add_");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(paramString2);
    localObject1 = ((StringBuilder)localObject1).toString();
    if ((this.a.containsKey(localObject1)) && (l - ((Long)this.a.get(localObject1)).longValue() < 2000L)) {
      return;
    }
    if (TextUtils.equals(this.appRuntime.getCurrentAccountUin(), paramString2)) {
      return;
    }
    this.a.put(localObject1, Long.valueOf(l));
    Object localObject2 = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
    localObject1 = ((ITroopInfoService)localObject2).getTroopInfo(paramString1);
    if (localObject1 != null)
    {
      if (!((ITroopCreateInfoService)this.appRuntime.getRuntimeService(ITroopCreateInfoService.class, "")).isInInviteList(paramString1, paramString2))
      {
        ((TroopInfo)localObject1).wMemberNumClient += 1;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleMemberAdd wMemberNumClient:");
          localStringBuilder.append(((TroopInfo)localObject1).wMemberNumClient);
          localStringBuilder.append("  wMemberNum:");
          localStringBuilder.append(((TroopInfo)localObject1).wMemberNum);
          localStringBuilder.append(" troopUin:");
          localStringBuilder.append(((TroopInfo)localObject1).troopuin);
          QLog.d("TroopOnlinePushHandler", 2, localStringBuilder.toString());
        }
      }
      ((ITroopInfoService)localObject2).saveTroopInfo((TroopInfo)localObject1);
    }
    if ((localObject1 != null) && (!((TroopInfo)localObject1).hasSetTroopHead()))
    {
      localObject2 = ((ITroopInfoService)localObject2).getTroopMemberForTroopHead(paramString1);
      if ((((ArrayList)localObject2).size() == 0) || ((((ArrayList)localObject2).size() < 4) && (((TroopInfo)localObject1).wMemberNum > 4))) {
        ((ITroopMemberListHandler)this.appRuntime.getBusinessHandler(TroopMemberListHandler.class.getName())).a(Long.parseLong(paramString1));
      }
      if (localObject2 != null) {
        TroopOnlinePushHandlerProcessorConfig.a().a(this.appRuntime, paramString1, paramString2, (TroopInfo)localObject1, (ArrayList)localObject2);
      }
      ((ITroopMemberInfoService)this.appRuntime.getRuntimeService(ITroopMemberInfoService.class, "")).saveTroopMemberEx(String.valueOf(paramString1), paramString2, null, -100, paramString3, null, -100, -100, -100, -100L, (byte)-100, -100L, -100.0D);
    }
    notifyUI(TroopOnlinePushObserver.TYPE_NOTIFY_TROOP_MEMBER_CHANGED, true, null);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleMemberExit, troopUin=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",memberUin=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" isFromOfflinePush=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.e("TroopOnlinePushHandler", 2, ((StringBuilder)localObject).toString());
    }
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("del_");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    if ((this.a.containsKey(localObject)) && (l - ((Long)this.a.get(localObject)).longValue() < 2000L)) {
      return;
    }
    this.a.put(localObject, Long.valueOf(l));
    localObject = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
    TroopInfo localTroopInfo = ((ITroopInfoService)localObject).getTroopInfo(paramString1);
    TroopOnlinePushHandlerProcessorConfig.a().a(this.appRuntime, paramString1, paramString2, localTroopInfo);
    if (localTroopInfo != null)
    {
      if (!paramBoolean)
      {
        localTroopInfo.wMemberNumClient -= 1;
        ((ITroopCreateInfoService)this.appRuntime.getRuntimeService(ITroopCreateInfoService.class, "")).deleteInInviteList(paramString1, paramString2);
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("handleMemberExit wMemberNumClient:");
          paramString2.append(localTroopInfo.wMemberNumClient);
          paramString2.append("  wMemberNum:");
          paramString2.append(localTroopInfo.wMemberNum);
          paramString2.append(" troopUin:");
          paramString2.append(localTroopInfo.troopuin);
          QLog.d("TroopOnlinePushHandler", 2, paramString2.toString());
        }
      }
      ((ITroopInfoService)localObject).saveTroopInfo(localTroopInfo);
    }
    ((ITroopNameHelperService)this.appRuntime.getRuntimeService(ITroopNameHelperService.class, "")).updateTroopName(paramString1);
    notifyUI(TroopOnlinePushObserver.TYPE_NOTIFY_TROOP_MEMBER_CHANGED, true, null);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Object localObject = new submsgtype0x26.MsgBody();
    try
    {
      ((submsgtype0x26.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      if (QLog.isDevelopLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("handleTroopNewsOnlinePush, cmd[");
        paramArrayOfByte.append(((submsgtype0x26.MsgBody)localObject).uint32_sub_cmd.get());
        paramArrayOfByte.append("]");
        QLog.w("TroopOnlinePushHandler", 1, paramArrayOfByte.toString());
      }
      if (((submsgtype0x26.MsgBody)localObject).uint32_sub_cmd.get() == 4)
      {
        if ((!((submsgtype0x26.MsgBody)localObject).msg_subcmd_0x4_push_body.has()) && (QLog.isColorLevel())) {
          QLog.e("TroopOnlinePushHandler", 2, "handleMsgType0x210SubMsgType0x26 : msg has not 0x3_push_body");
        }
        paramArrayOfByte = (submsgtype0x26.MsgBody.SubCmd0x4UpdateApp)((submsgtype0x26.MsgBody)localObject).msg_subcmd_0x4_push_body.get();
        if ((paramArrayOfByte.msg_app_id.has()) && (paramArrayOfByte.msg_app_id.uint64_app_id.has()) && (paramArrayOfByte.uint64_group_code.has()) && (paramArrayOfByte.sint32_unread_num.has())) {
          a(paramArrayOfByte);
        }
      }
      if ((((submsgtype0x26.MsgBody)localObject).uint32_sub_cmd.has()) && (((submsgtype0x26.MsgBody)localObject).uint32_sub_cmd.get() == 1))
      {
        try
        {
          if (!((submsgtype0x26.MsgBody)localObject).rpt_msg_subcmd_0x1_push_body.has())
          {
            if (!QLog.isDevelopLevel()) {
              break label590;
            }
            QLog.i("TroopOnlinePushHandler", 4, "rpt_msg_subcmd_0x1_push_body.has() = false");
            return;
          }
          paramArrayOfByte = ((submsgtype0x26.MsgBody)localObject).rpt_msg_subcmd_0x1_push_body.get();
          if (paramArrayOfByte == null)
          {
            if (!QLog.isDevelopLevel()) {
              return;
            }
            QLog.e("TroopOnlinePushHandler", 4, "rpt_msg_subcmd_0x1_push_body is null");
            return;
          }
          localObject = new ArrayList();
          StringBuilder localStringBuilder = new StringBuilder();
          Iterator localIterator = paramArrayOfByte.iterator();
          paramArrayOfByte = null;
          boolean bool = false;
          int i = 0;
          while (localIterator.hasNext())
          {
            TroopOnlinePushHandler.HandleTroopNewsOnlinePushDecode0x1UpdateAppUnreadNum localHandleTroopNewsOnlinePushDecode0x1UpdateAppUnreadNum = new TroopOnlinePushHandler.HandleTroopNewsOnlinePushDecode0x1UpdateAppUnreadNum(this, bool, (List)localObject, paramArrayOfByte, i, localStringBuilder, (submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localIterator.next()).a();
            if (!localHandleTroopNewsOnlinePushDecode0x1UpdateAppUnreadNum.a())
            {
              bool = localHandleTroopNewsOnlinePushDecode0x1UpdateAppUnreadNum.b();
              paramArrayOfByte = localHandleTroopNewsOnlinePushDecode0x1UpdateAppUnreadNum.a();
              i = localHandleTroopNewsOnlinePushDecode0x1UpdateAppUnreadNum.a();
            }
          }
          if (QLog.isDevelopLevel()) {
            QLog.i("TroopOnlinePushHandler", 4, localStringBuilder.toString());
          }
          if (i != 0) {
            a(TroopRedDotObserver.e, true, new Object[] { Boolean.valueOf(true), localObject, Integer.valueOf(-1) });
          } else {
            a(TroopRedDotObserver.e, true, new Object[] { Boolean.valueOf(true), localObject, Integer.valueOf(0) });
          }
          if (bool)
          {
            a(TroopRedDotObserver.f, true, new Object[] { paramArrayOfByte.a, Boolean.valueOf(false), Boolean.valueOf(true) });
            return;
          }
        }
        catch (Exception paramArrayOfByte)
        {
          if (QLog.isDevelopLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("handleTroopNewsOnlinePush|exception = ");
            ((StringBuilder)localObject).append(paramArrayOfByte.toString());
            QLog.i("TroopOnlinePushHandler", 4, ((StringBuilder)localObject).toString());
          }
        }
        return;
      }
      if (QLog.isDevelopLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("handleTroopNewsOnlinePush : msgBody is null or NotSupportSubCMd :");
        paramArrayOfByte.append(((submsgtype0x26.MsgBody)localObject).uint32_sub_cmd.get());
        QLog.e("TroopOnlinePushHandler", 4, paramArrayOfByte.toString());
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      label570:
      break label570;
    }
    if (QLog.isDevelopLevel()) {
      QLog.e("TroopOnlinePushHandler", 4, "handleTroopNewsOnlinePush : fail to parse submsgtype0x26.");
    }
    return;
    label590:
    return;
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      if ("0".equals(paramString2)) {
        return;
      }
      String str = this.appRuntime.getCurrentAccountUin();
      long l = NetConnInfoCenter.getServerTime();
      MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
      UniteGrayTipParam localUniteGrayTipParam = new UniteGrayTipParam(paramString1, paramString1, "", 1, 2024, 131073, l);
      localMessageForUniteGrayTip.frienduin = paramString1;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131715499));
      localStringBuilder.append(paramString3);
      localStringBuilder.append("\"");
      paramString3 = localStringBuilder.toString();
      if (str.equals(paramString2))
      {
        paramString1 = new StringBuilder();
        paramString1.append(HardCodeUtil.a(2131715500));
        paramString1.append(paramString3);
        paramString1 = paramString1.toString();
      }
      else
      {
        str = ((ITroopMemberNameService)this.appRuntime.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberName(paramString1, paramString2);
        paramString1 = new StringBuilder();
        paramString1.append(str);
        paramString1.append(paramString3);
        paramString1 = paramString1.toString();
        paramString3 = new Bundle();
        paramString3.putInt("key_action", 5);
        paramString3.putString("troop_mem_uin", paramString2);
        paramString3.putBoolean("need_update_nick", false);
        localUniteGrayTipParam.a(0, str.length(), paramString3);
      }
      localUniteGrayTipParam.c = paramString1;
      localMessageForUniteGrayTip.initGrayTipMsg(this.appRuntime, localUniteGrayTipParam);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("handleModifyTroopNamePushWithHighLight insert troopName");
        paramString2.append(paramString1);
        QLog.d("TroopOnlinePushHandler", 2, paramString2.toString());
      }
      ((IMessageFacade)this.appRuntime.getRuntimeService(IMessageFacade.class, "")).addMessage(localMessageForUniteGrayTip, this.appRuntime.getCurrentAccountUin());
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopOnlinePushObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.onlinepush.api.impl.TroopOnlinePushHandler
 * JD-Core Version:    0.7.0.1
 */