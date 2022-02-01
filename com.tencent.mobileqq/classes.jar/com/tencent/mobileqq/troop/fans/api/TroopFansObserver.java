package com.tencent.mobileqq.troop.fans.api;

import com.tencent.mobileqq.app.BusinessObserver;

public class TroopFansObserver
  implements BusinessObserver
{
  public static final int TYPE_GET_MEMBER_IDOLINFO;
  public static final int TYPE_NOTIFY_GET_FANS_TROOP_IDOL_INFO;
  private static int sNotificationTypeStart;
  
  static
  {
    int i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_GET_FANS_TROOP_IDOL_INFO = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_GET_MEMBER_IDOLINFO = i;
  }
  
  private void onUpdate_getIdolInfoOfCard(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_GET_MEMBER_IDOLINFO) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 3)
      {
        onGetIdolInfoOfCard(paramBoolean, ((Long)paramObject[0]).longValue(), paramObject[1], ((Integer)paramObject[2]).intValue());
        return;
      }
      onGetIdolInfoOfCard(false, 0L, null, -1);
      return;
    }
    onGetIdolInfoOfCard(false, 0L, null, -1);
  }
  
  private void onUpdate_notifyGetFansTroopIdolInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_GET_FANS_TROOP_IDOL_INFO) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length == 3) && ((paramObject[0] instanceof String)) && ((paramObject[1] instanceof String)) && ((paramObject[2] instanceof Long))) {
        onGetFansTroopIdolInfo(paramBoolean, (String)paramObject[0], (String)paramObject[1], (Long)paramObject[2]);
      }
    }
  }
  
  protected void onGetFansTroopIdolInfo(boolean paramBoolean, String paramString1, String paramString2, Long paramLong) {}
  
  protected void onGetIdolInfoOfCard(boolean paramBoolean, long paramLong, Object paramObject, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    onUpdate_notifyGetFansTroopIdolInfo(paramInt, paramBoolean, paramObject);
    onUpdate_getIdolInfoOfCard(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.fans.api.TroopFansObserver
 * JD-Core Version:    0.7.0.1
 */