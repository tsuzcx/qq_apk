package com.tencent.mobileqq.troop.api.observer;

import KQQ.RespBatchProcess;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopInfoExt;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class TroopObserver
  implements com.tencent.mobileqq.app.BusinessObserver, mqq.observer.BusinessObserver
{
  public static final int TYPE_0X88D_RESULT;
  public static final int TYPE_BATCH_ADD_FRIEND_SECURITY_CHECK;
  public static final int TYPE_BATCH_GET_TROOPCARD_DEAFULTNICK;
  public static final int TYPE_BATCH_GET_TROOP_INFO;
  public static final int TYPE_DEL_TROOP_MEMBER;
  public static final int TYPE_GEN_NEW_TROOP_NAME;
  public static final int TYPE_GET_MULTI_TROOP_INFO;
  public static final int TYPE_GET_SIMPLE_TROOP_INFO;
  public static final int TYPE_GET_TROOPMEMEBER_CARD_LIST;
  public static final int TYPE_GET_TROOP_AUTH;
  public static final int TYPE_GET_TROOP_CREDIT_INFO;
  public static final int TYPE_GET_TROOP_INFO;
  public static final int TYPE_GET_TROOP_INFO_EXT_COMPLETE;
  public static final int TYPE_GET_TROOP_LIST;
  public static final int TYPE_GET_TROOP_MEMBER_AUTO_REMARK;
  public static final int TYPE_GET_TROOP_MEMBER_CARD;
  public static final int TYPE_GET_TROOP_MEMBER_LIST_BY_787;
  public static final int TYPE_GET_TROOP_TAG;
  public static final int TYPE_GET_UIN_BY_OPEN_ID;
  public static final int TYPE_MODIFY_TROOPMEMEBER_CARD;
  public static final int TYPE_MODIFY_TROOPMEMEBER_CARD_PUSH;
  public static final int TYPE_NOTIFY_BATCH_ADDFRDS_DATA_PREPARE_ERR;
  public static final int TYPE_NOTIFY_BATCH_GET_TROOP_PROFILE;
  public static final int TYPE_NOTIFY_BATCH_REQ_COMMFRDS;
  public static final int TYPE_NOTIFY_BATCH_REQ_REMARK;
  public static final int TYPE_NOTIFY_OIDB_0XD22_1;
  public static final int TYPE_NOTIFY_OIDB_0XD22_2;
  public static final int TYPE_NOTIFY_OIDB_0XD23_2;
  public static final int TYPE_NOTIFY_READY_FOR_TROOP_BATCHADD_TIP;
  public static final int TYPE_NOTIFY_TROOP_OPEN_API_TOKEN_VERIFY;
  public static final int TYPE_NOTIFY_TROOP_RANK_TITLE_UPDATE;
  public static final int TYPE_NOTIFY_UPDATE_RECENT_LIST;
  public static final int TYPE_NOTIFY_UPDATE_TROOP_INFO;
  public static final int TYPE_OIDB_0X88D_10;
  public static final int TYPE_OIDB_0X899_0;
  public static final int TYPE_OIDB_0X899_1;
  public static final int TYPE_OPERATE_SPECIAL_FOCUS;
  public static final int TYPR_GET_TROOP_GETMEMBERLIST;
  private static int sNotificationTypeStart;
  
  static
  {
    int i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_GET_TROOP_LIST = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_UPDATE_RECENT_LIST = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_GET_TROOP_INFO = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_GET_MULTI_TROOP_INFO = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_GET_SIMPLE_TROOP_INFO = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_0X88D_RESULT = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_OIDB_0X88D_10 = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_GET_TROOP_TAG = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_GEN_NEW_TROOP_NAME = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_GET_TROOP_AUTH = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_GET_TROOP_INFO_EXT_COMPLETE = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_DEL_TROOP_MEMBER = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_GET_TROOPMEMEBER_CARD_LIST = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_GET_TROOP_MEMBER_CARD = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_GET_TROOP_MEMBER_LIST_BY_787 = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_MODIFY_TROOPMEMEBER_CARD = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPR_GET_TROOP_GETMEMBERLIST = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_OIDB_0X899_0 = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_OIDB_0X899_1 = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_MODIFY_TROOPMEMEBER_CARD_PUSH = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_GET_TROOP_MEMBER_AUTO_REMARK = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_OIDB_0XD22_1 = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_OIDB_0XD22_2 = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_OIDB_0XD23_2 = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_TROOP_OPEN_API_TOKEN_VERIFY = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_BATCH_ADD_FRIEND_SECURITY_CHECK = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_BATCH_REQ_COMMFRDS = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_BATCH_REQ_REMARK = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_BATCH_GET_TROOP_INFO = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_GET_TROOP_CREDIT_INFO = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_UPDATE_TROOP_INFO = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_BATCH_GET_TROOPCARD_DEAFULTNICK = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_BATCH_GET_TROOP_PROFILE = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_GET_UIN_BY_OPEN_ID = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_READY_FOR_TROOP_BATCHADD_TIP = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_BATCH_ADDFRDS_DATA_PREPARE_ERR = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_TROOP_RANK_TITLE_UPDATE = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_OPERATE_SPECIAL_FOCUS = i;
  }
  
  private void onUpdate_batchAddFriendSecurityCheck(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_BATCH_ADD_FRIEND_SECURITY_CHECK) {
      return;
    }
    paramObject = (Object[])paramObject;
    onBAFSecurityCheckResult(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2], ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue());
  }
  
  private void onUpdate_batchGetTroopCardDeafultNick(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_BATCH_GET_TROOPCARD_DEAFULTNICK) {
      return;
    }
    onBatchTroopCardDefaultNick(paramBoolean, paramObject);
  }
  
  private void onUpdate_batchGetTroopInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_BATCH_GET_TROOP_INFO) {
      return;
    }
    if (paramBoolean)
    {
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        onBatchGetTroopInfoResp(paramBoolean, ((Long)paramObject[0]).longValue(), (RespBatchProcess)paramObject[1], (Bundle)paramObject[2]);
      }
    }
    else {
      onBatchGetTroopInfoResp(paramBoolean, -1L, null, null);
    }
  }
  
  private void onUpdate_delTroopMember(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_DEL_TROOP_MEMBER) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      paramInt = ((Integer)paramObject[0]).intValue();
      ArrayList localArrayList = (ArrayList)paramObject[1];
      onDeleteTroopMember(paramBoolean, paramInt, localArrayList);
      if (paramObject.length > 2)
      {
        onDeleteTroopMember(paramBoolean, paramInt, localArrayList, (String)paramObject[2]);
        return;
      }
      onDeleteTroopMember(paramBoolean, paramInt, localArrayList, null);
    }
  }
  
  private void onUpdate_genNewTroopName(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_GEN_NEW_TROOP_NAME) {
      return;
    }
    paramObject = (Object[])paramObject;
    onGenNewTroopName((String)paramObject[0], (String)paramObject[1]);
  }
  
  private void onUpdate_get0x88d(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_0X88D_RESULT) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length == 3) && ((paramObject[0] instanceof String)) && ((paramObject[1] instanceof String)) && ((paramObject[2] instanceof oidb_0x88d.GroupInfo)))
      {
        onGet0x88d_Result(paramBoolean, (String)paramObject[0], (String)paramObject[1], (oidb_0x88d.GroupInfo)paramObject[2]);
        return;
      }
      if ((paramObject.length == 2) && ((paramObject[0] instanceof String)) && ((paramObject[1] instanceof String)))
      {
        onGet0x88d_Result(paramBoolean, (String)paramObject[0], (String)paramObject[1], null);
        return;
      }
      if ((paramObject.length == 1) && ((paramObject[0] instanceof String))) {
        onGet0x88d_Result(paramBoolean, (String)paramObject[0], "", null);
      }
    }
  }
  
  private void onUpdate_getMultiTroopInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_GET_MULTI_TROOP_INFO) {
      return;
    }
    onUpdateTroopNickname(paramBoolean);
    if (paramObject != null) {
      onGetMutilTroopInfoResult(paramBoolean, (ArrayList)paramObject);
    }
  }
  
  private void onUpdate_getSimpleTroopInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_GET_SIMPLE_TROOP_INFO) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      Object localObject = (Object[])paramObject;
      paramInt = localObject.length;
      paramObject = null;
      if ((paramInt >= 3) && ((localObject[2] instanceof TroopInfo)))
      {
        paramObject = (TroopInfo)localObject[2];
        localObject = (String)localObject[5];
      }
      else
      {
        localObject = null;
      }
      onGetSimpleTroopInfoResult(paramBoolean, paramObject, (String)localObject);
    }
  }
  
  private void onUpdate_getTroopAuth(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_GET_TROOP_AUTH) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      Object localObject = (Object[])paramObject;
      long l;
      if (localObject.length >= 1) {
        l = ((Long)localObject[0]).longValue();
      } else {
        l = 0L;
      }
      if (localObject.length >= 2) {
        paramObject = (String)localObject[1];
      } else {
        paramObject = "";
      }
      if (localObject.length >= 3) {
        localObject = (byte[])localObject[2];
      } else {
        localObject = null;
      }
      onGetTroopAuth(paramBoolean, l, paramObject, (byte[])localObject);
    }
  }
  
  private void onUpdate_getTroopCreditInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_GET_TROOP_CREDIT_INFO) {
      return;
    }
    if ((paramObject instanceof Long))
    {
      onGetTroopCreditLevelInfo(paramBoolean, ((Long)paramObject).longValue());
      return;
    }
    onGetTroopCreditLevelInfo(paramBoolean, 0L);
  }
  
  private void onUpdate_getTroopGetMemberList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPR_GET_TROOP_GETMEMBERLIST) {
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject;
    if (arrayOfObject.length == 5)
    {
      String str = (String)arrayOfObject[0];
      if (arrayOfObject[1] == null) {
        paramObject = null;
      } else {
        paramObject = (List)arrayOfObject[1];
      }
      onUpdateTroopGetMemberList(str, paramBoolean, paramObject, ((Integer)arrayOfObject[2]).intValue(), ((Long)arrayOfObject[3]).longValue(), ((Integer)arrayOfObject[4]).intValue());
      return;
    }
    QLog.d("TroopBusinessObserver", 1, "onUpdate,TYPR_GET_TROOP_GETMEMBERLIST datas.length error");
  }
  
  private void onUpdate_getTroopInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_GET_TROOP_INFO) {
      return;
    }
    onGetTroopInfoResult(paramBoolean, (String)paramObject);
  }
  
  private void onUpdate_getTroopList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_GET_TROOP_LIST) {
      return;
    }
    onUpdateTroopList(paramBoolean);
    onUpdateRecentList();
  }
  
  private void onUpdate_getTroopMemberAutoRemark(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_GET_TROOP_MEMBER_AUTO_REMARK) {
      return;
    }
    paramObject = (Object[])paramObject;
    onGetTroopMemberAutoRemark(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
  }
  
  private void onUpdate_getTroopMemberCard(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_GET_TROOP_MEMBER_CARD) {
      return;
    }
    onGetTroopMemberCard(paramBoolean, paramObject);
  }
  
  private void onUpdate_getTroopMemberCardList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_GET_TROOPMEMEBER_CARD_LIST) {
      return;
    }
    if (paramObject != null)
    {
      Object localObject = (Object[])paramObject;
      paramObject = (ArrayList)localObject[0];
      localObject = (Boolean)localObject[1];
      if (QLog.isColorLevel()) {
        QLog.d("handlerGetTroopMemberCardInfoList", 2, "TYPE_GET_TROOPMEMEBER_CARD_LIST suc");
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("TYPE_GET_TROOPMEMEBER_CARD_LIST bSaved2DBSuccess = ");
        localStringBuilder.append(localObject);
        QLog.d("handlerGetTroopMemberCardInfoList", 2, localStringBuilder.toString());
      }
      onGetTroopMemberCardInfoResult(paramBoolean, paramObject);
      onGetTroopMemberCardInfoResult(paramBoolean, paramObject, ((Boolean)localObject).booleanValue());
      return;
    }
    onGetTroopMemberCardInfoResult(paramBoolean, null);
    onGetTroopMemberCardInfoResult(paramBoolean, null, false);
    if (QLog.isColorLevel()) {
      QLog.d("handlerGetTroopMemberCardInfoList", 2, "TYPE_GET_TROOPMEMEBER_CARD_LIST failed");
    }
  }
  
  private void onUpdate_getTroopMemberListBy787(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_GET_TROOP_MEMBER_LIST_BY_787) {
      return;
    }
    paramObject = (Object[])paramObject;
    onGetTroopMemberListBy0x787((String)paramObject[0], (List)paramObject[1]);
  }
  
  private void onUpdate_getTroopTag(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_GET_TROOP_TAG) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      Object[] arrayOfObject = (Object[])paramObject;
      Object localObject3 = null;
      paramObject = "";
      Object localObject1 = paramObject;
      Object localObject2 = localObject3;
      if (arrayOfObject.length >= 2)
      {
        if ((arrayOfObject[0] instanceof String)) {
          paramObject = (String)arrayOfObject[0];
        }
        localObject1 = paramObject;
        localObject2 = localObject3;
        if ((arrayOfObject[1] instanceof String))
        {
          localObject2 = (String)arrayOfObject[1];
          localObject1 = paramObject;
        }
      }
      onGetTroopTagResult(paramBoolean, localObject1, (String)localObject2);
    }
  }
  
  private void onUpdate_getUinByOpenId(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_GET_UIN_BY_OPEN_ID) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      onGetUinByOpenId(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2], (String)paramObject[3], ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), paramObject[6]);
    }
  }
  
  private void onUpdate_modifyTroopMemberCard(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_MODIFY_TROOPMEMEBER_CARD) {
      return;
    }
    paramObject = (Object[])paramObject;
    if ((paramObject != null) && (paramObject.length > 1))
    {
      onModifyTroopInfoResult(paramBoolean, (ArrayList)paramObject[0], (String)paramObject[1]);
      return;
    }
    onModifyTroopInfoResult(paramBoolean, null, "");
  }
  
  private void onUpdate_modifyTroopMemberCardPush(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_MODIFY_TROOPMEMEBER_CARD_PUSH) {
      return;
    }
    onModifyTroopInfoPushResult(paramBoolean, (ArrayList)paramObject);
  }
  
  private void onUpdate_notifyBatchAddfrdsDataPrepareErr(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_BATCH_ADDFRDS_DATA_PREPARE_ERR) {
      return;
    }
    paramObject = (Object[])paramObject;
    onTroopBatchAddFrdsDataPrepareErr(paramBoolean, (String)paramObject[0], ((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
  }
  
  private void onUpdate_notifyBatchGetTroopProfile(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_BATCH_GET_TROOP_PROFILE) {
      return;
    }
    boolean bool = true;
    if ((paramObject instanceof Object[])) {
      bool = ((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue();
    }
    onGetOnePageTroopInfo(paramBoolean, bool);
  }
  
  private void onUpdate_notifyBatchReqCommfrds(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_BATCH_REQ_COMMFRDS) {
      return;
    }
    paramObject = (Object[])paramObject;
    onTroopBatchReqMemberCmnFrds(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue(), ((Boolean)paramObject[4]).booleanValue(), ((Boolean)paramObject[5]).booleanValue(), (HashMap)paramObject[6], (List)paramObject[7]);
  }
  
  private void onUpdate_notifyBatchReqRemark(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_BATCH_REQ_REMARK) {
      return;
    }
    paramObject = (Object[])paramObject;
    onTroopBatchGetMemberRemark(paramBoolean, (String)paramObject[0], ((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), ((Boolean)paramObject[3]).booleanValue());
  }
  
  private void onUpdate_notifyGetTroopInfoExtComplete(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_GET_TROOP_INFO_EXT_COMPLETE) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length == 2) && ((paramObject[0] instanceof String)) && ((paramObject[1] instanceof TroopInfoExt))) {
        onGetTroopInfoExtComplete(paramBoolean, (String)paramObject[0], (TroopInfoExt)paramObject[1]);
      }
    }
  }
  
  private void onUpdate_notifyOidb_0xD22_1(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_OIDB_0XD22_1) {
      return;
    }
    if ((paramObject instanceof Object[])) {
      paramObject = (String)((Object[])(Object[])paramObject)[0];
    } else {
      paramObject = "";
    }
    onGetCreateTroopTokenForThirdApp(paramBoolean, paramObject);
  }
  
  private void onUpdate_notifyOidb_0xD22_2(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_OIDB_0XD22_2) {
      return;
    }
    boolean bool = paramObject instanceof Object[];
    String str = "";
    Object localObject;
    if (bool)
    {
      localObject = (Object[])paramObject;
      paramObject = (String)localObject[0];
      localObject = (String)localObject[1];
    }
    else
    {
      localObject = "";
      paramObject = str;
    }
    onGetJoinTroopTokenForThirdApp(paramBoolean, paramObject, (String)localObject);
  }
  
  private void onUpdate_notifyOidb_0xD23_2(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_OIDB_0XD23_2) {
      return;
    }
    paramInt = -1;
    long l = 0L;
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      paramInt = ((Integer)paramObject[0]).intValue();
      l = ((Long)paramObject[1]).longValue();
    }
    onBindTroopForThirdApp(paramBoolean, paramInt, l);
  }
  
  private void onUpdate_notifyReadyForTroopBatchAddTip(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_READY_FOR_TROOP_BATCHADD_TIP) {
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject;
    paramObject = null;
    if (arrayOfObject[2] != null) {
      paramObject = (List)arrayOfObject[2];
    }
    onTroopBatchAddFrdsReadyForTip(paramBoolean, (String)arrayOfObject[0], ((Integer)arrayOfObject[1]).intValue(), paramObject);
  }
  
  private void onUpdate_notifyTroopOpenApiTokenVerify(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_TROOP_OPEN_API_TOKEN_VERIFY) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      onTroopOpenApiVerifyed(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2], (String)paramObject[3], ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), (ArrayList)paramObject[6], ((Integer)paramObject[7]).intValue(), ((Integer)paramObject[8]).intValue());
    }
  }
  
  private void onUpdate_notifyTroopRankTitleUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_TROOP_RANK_TITLE_UPDATE) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 3) {
        onTroopRankTitleUpdate((String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue());
      }
    }
  }
  
  private void onUpdate_notifyUpdateRecentList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_UPDATE_RECENT_LIST) {
      return;
    }
    onUpdateRecentList();
  }
  
  private void onUpdate_notifyUpdateTroopInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_UPDATE_TROOP_INFO) {
      return;
    }
    onTroopInfoUpdate((String)((Object[])(Object[])paramObject)[0]);
  }
  
  private void onUpdate_oidb_0x88d_10(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_OIDB_0X88D_10) {
      return;
    }
    paramObject = (Object[])paramObject;
    onOIDB0X88D_10_Ret(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (TroopInfo)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
  }
  
  private void onUpdate_oidb_0x899_0(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_OIDB_0X899_0) {
      return;
    }
    paramObject = (Object[])paramObject;
    onOIDB0X899_0_Ret(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (List)paramObject[2], ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue(), (String)paramObject[5]);
  }
  
  private void onUpdate_oidb_0x899_1(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_OIDB_0X899_1) {
      return;
    }
    paramObject = (Object[])paramObject;
    onOIDB0X899_1_Ret(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (List)paramObject[2], ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue(), (String)paramObject[5]);
  }
  
  private void onUpdate_operateSpecialFocus(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_OPERATE_SPECIAL_FOCUS) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      onOperateSpecialFocus(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (long[])paramObject[2]);
    }
  }
  
  protected void onBAFSecurityCheckResult(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2) {}
  
  protected void onBatchGetTroopInfoResp(boolean paramBoolean, long paramLong, RespBatchProcess paramRespBatchProcess, Bundle paramBundle) {}
  
  protected void onBatchTroopCardDefaultNick(boolean paramBoolean, Object paramObject) {}
  
  protected void onBindTroopForThirdApp(boolean paramBoolean, int paramInt, long paramLong) {}
  
  protected void onDeleteTroopMember(boolean paramBoolean, int paramInt, ArrayList<String> paramArrayList) {}
  
  protected void onDeleteTroopMember(boolean paramBoolean, int paramInt, ArrayList<String> paramArrayList, String paramString) {}
  
  protected void onGenNewTroopName(String paramString1, String paramString2) {}
  
  protected void onGet0x88d_Result(boolean paramBoolean, String paramString1, String paramString2, oidb_0x88d.GroupInfo paramGroupInfo) {}
  
  protected void onGetCreateTroopTokenForThirdApp(boolean paramBoolean, String paramString) {}
  
  protected void onGetJoinTroopTokenForThirdApp(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void onGetMutilTroopInfoResult(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList) {}
  
  protected void onGetOnePageTroopInfo(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetSimpleTroopInfoResult(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString) {}
  
  protected void onGetTroopAuth(boolean paramBoolean, long paramLong, String paramString, byte[] paramArrayOfByte) {}
  
  protected void onGetTroopCreditLevelInfo(boolean paramBoolean, long paramLong) {}
  
  protected void onGetTroopInfoExtComplete(boolean paramBoolean, String paramString, TroopInfoExt paramTroopInfoExt) {}
  
  protected void onGetTroopInfoResult(boolean paramBoolean, String paramString) {}
  
  protected void onGetTroopMemberAutoRemark(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void onGetTroopMemberCard(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetTroopMemberCardInfoResult(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList) {}
  
  protected void onGetTroopMemberCardInfoResult(boolean paramBoolean1, ArrayList<TroopMemberCardInfo> paramArrayList, boolean paramBoolean2) {}
  
  protected void onGetTroopMemberListBy0x787(String paramString, List<Pair<String, String>> paramList) {}
  
  protected void onGetTroopTagResult(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void onGetUinByOpenId(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, Object paramObject) {}
  
  protected void onModifyTroopInfoPushResult(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList) {}
  
  protected void onModifyTroopInfoResult(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList, String paramString) {}
  
  protected void onOIDB0X88D_10_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString) {}
  
  protected void onOIDB0X899_0_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString) {}
  
  protected void onOIDB0X899_1_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString) {}
  
  protected void onOperateSpecialFocus(boolean paramBoolean, String paramString, int paramInt, long[] paramArrayOfLong) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt != 0) {
      return;
    }
    if (paramBoolean)
    {
      onSetTroopAdminSuccess(paramBundle.getString("troop_code"), paramBundle.getString("troop_member_uin"), paramBundle.getByte("operation"));
      return;
    }
    paramInt = 0;
    if (paramBundle != null) {
      paramInt = paramBundle.getInt("error_code");
    }
    onSetTroopAdminFail(paramInt);
  }
  
  protected void onSetTroopAdminFail(int paramInt) {}
  
  protected void onSetTroopAdminSuccess(String paramString1, String paramString2, byte paramByte) {}
  
  protected void onTroopBatchAddFrdsDataPrepareErr(boolean paramBoolean, String paramString, long paramLong, int paramInt) {}
  
  protected void onTroopBatchAddFrdsReadyForTip(boolean paramBoolean, String paramString, int paramInt, List<String> paramList) {}
  
  protected void onTroopBatchGetMemberRemark(boolean paramBoolean1, String paramString, long paramLong, int paramInt, boolean paramBoolean2) {}
  
  protected void onTroopBatchReqMemberCmnFrds(boolean paramBoolean1, String paramString1, String paramString2, long paramLong, int paramInt, boolean paramBoolean2, boolean paramBoolean3, HashMap<String, Integer> paramHashMap, List<String> paramList) {}
  
  protected void onTroopInfoUpdate(String paramString) {}
  
  public void onTroopOpenApiVerifyed(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, ArrayList<String> paramArrayList, int paramInt4, int paramInt5) {}
  
  protected void onTroopRankTitleUpdate(String paramString1, String paramString2, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    onUpdate_getTroopList(paramInt, paramBoolean, paramObject);
    onUpdate_notifyUpdateRecentList(paramInt, paramBoolean, paramObject);
    onUpdate_getMultiTroopInfo(paramInt, paramBoolean, paramObject);
    onUpdate_get0x88d(paramInt, paramBoolean, paramObject);
    onUpdate_getSimpleTroopInfo(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopInfo(paramInt, paramBoolean, paramObject);
    onUpdate_oidb_0x88d_10(paramInt, paramBoolean, paramObject);
    onUpdate_notifyGetTroopInfoExtComplete(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopTag(paramInt, paramBoolean, paramObject);
    onUpdate_genNewTroopName(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopAuth(paramInt, paramBoolean, paramObject);
    onUpdate_modifyTroopMemberCard(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopMemberCardList(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopMemberCard(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopMemberListBy787(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopGetMemberList(paramInt, paramBoolean, paramObject);
    onUpdate_modifyTroopMemberCardPush(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopMemberAutoRemark(paramInt, paramBoolean, paramObject);
    onUpdate_batchGetTroopCardDeafultNick(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopRankTitleUpdate(paramInt, paramBoolean, paramObject);
    onUpdate_oidb_0x899_0(paramInt, paramBoolean, paramObject);
    onUpdate_oidb_0x899_1(paramInt, paramBoolean, paramObject);
    onUpdate_delTroopMember(paramInt, paramBoolean, paramObject);
    onUpdate_notifyOidb_0xD22_1(paramInt, paramBoolean, paramObject);
    onUpdate_notifyOidb_0xD22_2(paramInt, paramBoolean, paramObject);
    onUpdate_notifyOidb_0xD23_2(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopOpenApiTokenVerify(paramInt, paramBoolean, paramObject);
    onUpdate_notifyBatchGetTroopProfile(paramInt, paramBoolean, paramObject);
    onUpdate_getUinByOpenId(paramInt, paramBoolean, paramObject);
    onUpdate_notifyBatchReqCommfrds(paramInt, paramBoolean, paramObject);
    onUpdate_notifyBatchReqRemark(paramInt, paramBoolean, paramObject);
    onUpdate_batchAddFriendSecurityCheck(paramInt, paramBoolean, paramObject);
    onUpdate_notifyReadyForTroopBatchAddTip(paramInt, paramBoolean, paramObject);
    onUpdate_notifyBatchAddfrdsDataPrepareErr(paramInt, paramBoolean, paramObject);
    onUpdate_operateSpecialFocus(paramInt, paramBoolean, paramObject);
    onUpdate_batchGetTroopInfo(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopCreditInfo(paramInt, paramBoolean, paramObject);
    onUpdate_notifyUpdateTroopInfo(paramInt, paramBoolean, paramObject);
  }
  
  protected void onUpdateRecentList() {}
  
  protected void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2) {}
  
  protected void onUpdateTroopList(boolean paramBoolean) {}
  
  protected void onUpdateTroopNickname(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.observer.TroopObserver
 * JD-Core Version:    0.7.0.1
 */