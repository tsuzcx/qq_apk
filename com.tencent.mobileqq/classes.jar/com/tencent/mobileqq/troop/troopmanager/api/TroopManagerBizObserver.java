package com.tencent.mobileqq.troop.troopmanager.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.troopshare.TroopShareResp;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TroopManagerBizObserver
  implements BusinessObserver
{
  public static final int OBSERVER_TYPE_TROOP_LINK;
  public static final int TYPE_ANONYMOUS_CHAT_SET_RESULT;
  public static final int TYPE_CONFESS_TALK_SWITCH;
  public static final int TYPE_EDIT_TROOP_LOCATION;
  public static final int TYPE_GET_GLOBAL_TROOP_LEVEL;
  public static final int TYPE_GET_INVITE_NO_AUTH_LIMIT_NUM;
  public static final int TYPE_GET_MAX_TROOP_ADMIN_NUM;
  public static final int TYPE_GET_PAY_TO_JOIN_TROOP_STATUS;
  public static final int TYPE_GET_TROOP_INFO_FOR_SET_JOIN_TYPE;
  public static final int TYPE_GET_TROOP_MEMBER_MAX_NUM;
  public static final int TYPE_NOTIFY_ACTIVE_EXT_TROOP_SUCCESS;
  public static final int TYPE_NOTIFY_MODIFY_TROOP_NICK_RULE;
  public static final int TYPE_NOTIFY_TROOP_UPGRADE_SUCCESS;
  public static final int TYPE_OIDB_0X903_2;
  public static final int TYPE_TROOP_GET_MODIFY_EXAMINE;
  public static final int TYPE_WRITE_TOGETHER_SWITCH;
  private static int sNotificationTypeStart;
  
  static
  {
    int i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_EDIT_TROOP_LOCATION = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_GET_TROOP_INFO_FOR_SET_JOIN_TYPE = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_MODIFY_TROOP_NICK_RULE = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_GET_MAX_TROOP_ADMIN_NUM = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_GET_PAY_TO_JOIN_TROOP_STATUS = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_GET_TROOP_MEMBER_MAX_NUM = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_CONFESS_TALK_SWITCH = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_WRITE_TOGETHER_SWITCH = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_ANONYMOUS_CHAT_SET_RESULT = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_TROOP_GET_MODIFY_EXAMINE = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_ACTIVE_EXT_TROOP_SUCCESS = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_GET_INVITE_NO_AUTH_LIMIT_NUM = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_OIDB_0X903_2 = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    OBSERVER_TYPE_TROOP_LINK = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_GET_GLOBAL_TROOP_LEVEL = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_TROOP_UPGRADE_SUCCESS = i;
  }
  
  private void onUpdate_confessTalkSwitchChange(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_CONFESS_TALK_SWITCH) {
      return;
    }
    onConfessTalkSwitchChange(paramBoolean, paramObject);
  }
  
  private void onUpdate_editTroopLocation(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_EDIT_TROOP_LOCATION) {
      return;
    }
    paramObject = (TroopManagerBizObserver.EditTroopLocationRet)paramObject;
    onEditTroopLocationRet(paramObject.c, paramObject.a, paramObject.d, paramObject.b, paramObject.e, paramObject.f);
  }
  
  private void onUpdate_getGlobalTroopLevel(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_GET_GLOBAL_TROOP_LEVEL) {
      return;
    }
    paramObject = (Object[])paramObject;
    onGetGolbalTroopLevel(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue());
  }
  
  private void onUpdate_getInviteNoAuthLimitNum(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_GET_INVITE_NO_AUTH_LIMIT_NUM) {
      return;
    }
    paramObject = (Object[])paramObject;
    onGetInviteNoAuthLimitNum(paramBoolean, ((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue());
  }
  
  private void onUpdate_getMaxTroopAdminNum(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_GET_MAX_TROOP_ADMIN_NUM) {
      return;
    }
    if (paramBoolean)
    {
      paramObject = (Object[])paramObject;
      onGetMaxTroopAdminNum(true, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
      return;
    }
    onGetMaxTroopAdminNum(false, "", -1);
  }
  
  private void onUpdate_getPayToJoinTroopStatus(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_GET_PAY_TO_JOIN_TROOP_STATUS) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      onGetPayToJoinTroopStatus(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), ((Boolean)paramObject[2]).booleanValue(), ((Boolean)paramObject[3]).booleanValue(), (String)paramObject[4]);
    }
  }
  
  private void onUpdate_getTroopInfoForSetJoinType(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_GET_TROOP_INFO_FOR_SET_JOIN_TYPE) {
      return;
    }
    paramObject = (Object[])paramObject;
    Object[] arrayOfObject = new Object[2];
    if (paramObject.length == 5)
    {
      arrayOfObject[0] = paramObject[3];
      arrayOfObject[1] = paramObject[4];
    }
    onGetTroopInfoForSetJoinTypeRet(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (TroopInfo)paramObject[2], arrayOfObject);
  }
  
  private void onUpdate_getTroopMemberMaxNum(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_GET_TROOP_MEMBER_MAX_NUM) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      String str = (String)paramObject[0];
      ((Integer)paramObject[1]).intValue();
      paramInt = -1;
      if (paramBoolean) {
        paramInt = ((Integer)paramObject[2]).intValue();
      }
      onGetTroopMemberMaxNum(paramBoolean, str, paramInt);
    }
  }
  
  private void onUpdate_notifyActiveExtTroopSuccess(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_ACTIVE_EXT_TROOP_SUCCESS) {
      return;
    }
    if ((paramObject instanceof Object[])) {
      onActiveExtTroop(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
    }
  }
  
  private void onUpdate_notifyModifyTroopNickRule(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_MODIFY_TROOP_NICK_RULE) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 3)
      {
        boolean bool = paramObject[0] instanceof Long;
        long l2 = 0L;
        long l1;
        if (bool) {
          l1 = ((Long)paramObject[0]).longValue();
        } else {
          l1 = 0L;
        }
        if ((paramObject[1] instanceof Integer)) {
          l2 = ((Integer)paramObject[1]).intValue();
        }
        if ((paramObject[2] instanceof String)) {
          paramObject = (String)paramObject[2];
        } else {
          paramObject = "";
        }
        onModifyTroopNickRule(paramBoolean, l1, l2, paramObject);
        return;
      }
      onModifyTroopNickRule(false, 0L, 0L, "");
      return;
    }
    onModifyTroopNickRule(false, 0L, 0L, "");
  }
  
  private void onUpdate_notifyTroopUpgradeSuccess(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_TROOP_UPGRADE_SUCCESS) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      onNotifyTroopUpgradeSuccess((String)paramObject[0], ((Integer)paramObject[1]).intValue());
    }
  }
  
  private void onUpdate_oidb_0x903_2(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_OIDB_0X903_2) {
      return;
    }
    try
    {
      paramObject = (Object[])paramObject;
      onGetInvitedUinList(paramBoolean, (Long)paramObject[0], (List)paramObject[1]);
      return;
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("onGetInvitedUinList", 2, paramObject.toString());
      }
    }
  }
  
  private void onUpdate_setAnonymousChatResult(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_ANONYMOUS_CHAT_SET_RESULT) {
      return;
    }
    onSetAnonymousChatResult(paramBoolean, ((Boolean)paramObject).booleanValue());
  }
  
  private void onUpdate_troopInfoModifyExamine(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_TROOP_GET_MODIFY_EXAMINE) {
      return;
    }
    if ((paramBoolean) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      onTroopInfoModifyExamine(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), (String)paramObject[3]);
      return;
    }
    onTroopInfoModifyExamine(-1L, -1L, -1L, "");
  }
  
  private void onUpdate_troopLink(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != OBSERVER_TYPE_TROOP_LINK) {
      return;
    }
    onTroopShareLink(paramBoolean, (TroopShareResp)paramObject);
  }
  
  private void onUpdate_writeTogetherSwitchChange(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_WRITE_TOGETHER_SWITCH) {
      return;
    }
    onWriteTogetherSwitchChange(paramBoolean, paramObject);
  }
  
  protected void onActiveExtTroop(boolean paramBoolean, String paramString) {}
  
  protected void onConfessTalkSwitchChange(boolean paramBoolean, Object paramObject) {}
  
  protected void onEditTroopLocationRet(long paramLong, int paramInt1, boolean paramBoolean, String paramString, int paramInt2, int paramInt3) {}
  
  protected void onGetGolbalTroopLevel(boolean paramBoolean, long paramLong, int paramInt) {}
  
  protected void onGetInviteNoAuthLimitNum(boolean paramBoolean, long paramLong1, long paramLong2) {}
  
  protected void onGetInvitedUinList(boolean paramBoolean, Long paramLong, List<Long> paramList) {}
  
  protected void onGetMaxTroopAdminNum(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void onGetPayToJoinTroopStatus(boolean paramBoolean1, String paramString1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString2) {}
  
  protected void onGetTroopInfoForSetJoinTypeRet(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo, Object[] paramArrayOfObject) {}
  
  protected void onGetTroopMemberMaxNum(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void onModifyTroopNickRule(boolean paramBoolean, long paramLong1, long paramLong2, String paramString) {}
  
  protected void onNotifyTroopUpgradeSuccess(String paramString, int paramInt) {}
  
  protected void onSetAnonymousChatResult(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onTroopInfoModifyExamine(long paramLong1, long paramLong2, long paramLong3, String paramString) {}
  
  public void onTroopShareLink(boolean paramBoolean, TroopShareResp paramTroopShareResp) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    onUpdate_getMaxTroopAdminNum(paramInt, paramBoolean, paramObject);
    onUpdate_getPayToJoinTroopStatus(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopInfoForSetJoinType(paramInt, paramBoolean, paramObject);
    onUpdate_notifyModifyTroopNickRule(paramInt, paramBoolean, paramObject);
    onUpdate_editTroopLocation(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopMemberMaxNum(paramInt, paramBoolean, paramObject);
    onUpdate_confessTalkSwitchChange(paramInt, paramBoolean, paramObject);
    onUpdate_writeTogetherSwitchChange(paramInt, paramBoolean, paramObject);
    onUpdate_setAnonymousChatResult(paramInt, paramBoolean, paramObject);
    onUpdate_troopInfoModifyExamine(paramInt, paramBoolean, paramObject);
    onUpdate_notifyActiveExtTroopSuccess(paramInt, paramBoolean, paramObject);
    onUpdate_getInviteNoAuthLimitNum(paramInt, paramBoolean, paramObject);
    onUpdate_oidb_0x903_2(paramInt, paramBoolean, paramObject);
    onUpdate_troopLink(paramInt, paramBoolean, paramObject);
    onUpdate_getGlobalTroopLevel(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopUpgradeSuccess(paramInt, paramBoolean, paramObject);
  }
  
  protected void onWriteTogetherSwitchChange(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver
 * JD-Core Version:    0.7.0.1
 */