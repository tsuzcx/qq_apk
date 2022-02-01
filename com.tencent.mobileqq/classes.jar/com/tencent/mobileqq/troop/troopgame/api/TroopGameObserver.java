package com.tencent.mobileqq.troop.troopgame.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.troop.troopgame.data.ProfileGameInfo;
import com.tencent.mobileqq.troop.troopgame.data.TroopGameActivityInfo;
import com.tencent.mobileqq.troop.troopgame.data.TroopGameInfo;

public class TroopGameObserver
  implements BusinessObserver
{
  public static final int TYPE_GET_TROOP_GAME_ACTIVITY_INFO;
  public static final int TYPE_NOTIFY_GET_MEMBER_GAME_CARD;
  public static final int TYPE_NOTIFY_GET_MEMBER_GAME_CARD_SWITCH;
  public static final int TYPE_NOTIFY_GET_TROOP_GAME_CARD;
  public static final int TYPE_NOTIFY_MODIFY_MEMBER_GAME_CARD_SWITCH;
  public static final int TYPE_NOTIFY_MODIFY_TROOP_GAME_CARD_SWITCH;
  private static int sNotificationTypeStart;
  
  static
  {
    int i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_MODIFY_TROOP_GAME_CARD_SWITCH = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_GET_MEMBER_GAME_CARD = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_MODIFY_MEMBER_GAME_CARD_SWITCH = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_GET_MEMBER_GAME_CARD_SWITCH = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_GET_TROOP_GAME_CARD = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_GET_TROOP_GAME_ACTIVITY_INFO = i;
  }
  
  private void onUpdate_notifyGetMemberGameCard(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_GET_MEMBER_GAME_CARD) {
      return;
    }
    ProfileGameInfo localProfileGameInfo = null;
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      Object[] arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length == 3)
      {
        if ((arrayOfObject[0] instanceof String)) {
          paramObject = (String)arrayOfObject[0];
        } else {
          paramObject = null;
        }
        String str;
        if ((arrayOfObject[1] instanceof String)) {
          str = (String)arrayOfObject[1];
        } else {
          str = null;
        }
        if ((arrayOfObject[2] instanceof ProfileGameInfo)) {
          localProfileGameInfo = (ProfileGameInfo)arrayOfObject[2];
        }
        onGetTroopMemberGameCard(paramBoolean, paramObject, str, localProfileGameInfo);
        return;
      }
      onGetTroopMemberGameCard(paramBoolean, null, null, null);
      return;
    }
    onGetTroopMemberGameCard(paramBoolean, null, null, null);
  }
  
  private void onUpdate_notifyGetMemberGameCardSwitch(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_GET_MEMBER_GAME_CARD_SWITCH) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      Object[] arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length == 3)
      {
        paramObject = Long.valueOf(0L);
        if ((arrayOfObject[0] instanceof Long)) {
          paramObject = (Long)arrayOfObject[0];
        }
        Long localLong1 = Long.valueOf(0L);
        if ((arrayOfObject[1] instanceof Long)) {
          localLong1 = (Long)arrayOfObject[1];
        }
        Long localLong2 = Long.valueOf(0L);
        if ((arrayOfObject[2] instanceof Long)) {
          localLong2 = (Long)arrayOfObject[2];
        }
        onGetMemberGameCardSwitch(paramBoolean, paramObject.longValue(), localLong1.longValue(), localLong2.longValue());
        return;
      }
      onGetMemberGameCardSwitch(false, 0L, 0L, 0L);
      return;
    }
    onGetMemberGameCardSwitch(false, 0L, 0L, 0L);
  }
  
  private void onUpdate_notifyGetTroopGameActivityInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_GET_TROOP_GAME_ACTIVITY_INFO) {
      return;
    }
    paramInt = 0;
    TroopGameActivityInfo localTroopGameActivityInfo = null;
    if (paramObject != null)
    {
      Object[] arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length == 3)
      {
        if ((arrayOfObject[0] instanceof String)) {
          paramObject = (String)arrayOfObject[0];
        } else {
          paramObject = null;
        }
        if ((arrayOfObject[1] instanceof Integer)) {
          paramInt = ((Integer)arrayOfObject[1]).intValue();
        }
        if ((arrayOfObject[2] instanceof TroopGameActivityInfo)) {
          localTroopGameActivityInfo = (TroopGameActivityInfo)arrayOfObject[2];
        }
        onGetTroopGameActivityInfo(paramObject, paramInt, localTroopGameActivityInfo);
        return;
      }
      onGetTroopGameActivityInfo(null, 0, null);
      return;
    }
    onGetTroopGameActivityInfo(null, 0, null);
  }
  
  private void onUpdate_notifyGetTroopGameCard(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_GET_TROOP_GAME_CARD) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length == 2) && ((paramObject[0] instanceof String)))
      {
        if ((paramObject[1] instanceof TroopGameInfo))
        {
          onGetTroopGameGameCard(paramBoolean, (String)paramObject[0], (TroopGameInfo)paramObject[1]);
          return;
        }
        onGetTroopGameGameCard(paramBoolean, (String)paramObject[0], null);
        return;
      }
      onGetTroopGameGameCard(paramBoolean, null, null);
      return;
    }
    onGetTroopGameGameCard(paramBoolean, null, null);
  }
  
  private void onUpdate_notifyModifyMemberGameCardSwitch(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_MODIFY_MEMBER_GAME_CARD_SWITCH) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      Object localObject = (Object[])paramObject;
      if (localObject.length == 3)
      {
        paramObject = Long.valueOf(0L);
        if ((localObject[0] instanceof Long)) {
          paramObject = (Long)localObject[0];
        }
        Long localLong = Long.valueOf(0L);
        if ((localObject[1] instanceof Long)) {
          localLong = (Long)localObject[1];
        }
        if ((localObject[2] instanceof String)) {
          localObject = (String)localObject[2];
        } else {
          localObject = "";
        }
        onModifyMemberGameCardSwitch(paramBoolean, paramObject.longValue(), localLong.longValue(), (String)localObject);
        return;
      }
      onModifyMemberGameCardSwitch(false, 0L, 0L, "");
      return;
    }
    onModifyMemberGameCardSwitch(false, 0L, 0L, "");
  }
  
  private void onUpdate_notifyModifyTroopGameCardSwitch(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_MODIFY_TROOP_GAME_CARD_SWITCH) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
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
          l2 = ((Integer)paramObject[1]).longValue();
        }
        if ((paramObject[2] instanceof String)) {
          paramObject = (String)paramObject[2];
        } else {
          paramObject = "";
        }
        onModifyTroopGameCardSwitch(paramBoolean, l1, l2, paramObject);
        return;
      }
      onModifyTroopGameCardSwitch(false, 0L, 0L, "");
      return;
    }
    onModifyTroopGameCardSwitch(false, 0L, 0L, "");
  }
  
  protected void onGetMemberGameCardSwitch(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void onGetTroopGameActivityInfo(String paramString, int paramInt, TroopGameActivityInfo paramTroopGameActivityInfo) {}
  
  protected void onGetTroopGameGameCard(boolean paramBoolean, String paramString, TroopGameInfo paramTroopGameInfo) {}
  
  protected void onGetTroopMemberGameCard(boolean paramBoolean, String paramString1, String paramString2, ProfileGameInfo paramProfileGameInfo) {}
  
  protected void onModifyMemberGameCardSwitch(boolean paramBoolean, long paramLong1, long paramLong2, String paramString) {}
  
  protected void onModifyTroopGameCardSwitch(boolean paramBoolean, long paramLong1, long paramLong2, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    onUpdate_notifyGetTroopGameCard(paramInt, paramBoolean, paramObject);
    onUpdate_notifyGetMemberGameCard(paramInt, paramBoolean, paramObject);
    onUpdate_notifyModifyMemberGameCardSwitch(paramInt, paramBoolean, paramObject);
    onUpdate_notifyGetMemberGameCardSwitch(paramInt, paramBoolean, paramObject);
    onUpdate_notifyModifyTroopGameCardSwitch(paramInt, paramBoolean, paramObject);
    onUpdate_notifyGetTroopGameActivityInfo(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.api.TroopGameObserver
 * JD-Core Version:    0.7.0.1
 */