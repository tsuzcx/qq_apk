package com.tencent.mobileqq.troop.onlinepush.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectData;

public class TroopOnlinePushObserver
  implements BusinessObserver
{
  public static final int TYPE_NOTIFY_TROOP_ENTER_EFFECT_PUSH;
  public static final int TYPE_NOTIFY_TROOP_MEMBER_CHANGED;
  public static final int TYPE_NOTIFY_TROOP_REWARD_CHANGE;
  public static final int TYPE_NOTIFY_UPDATE_TITLE_BTN_CALL;
  public static final int TYPE_TROOP_BLOCK_STATUS_CHANGED;
  public static final int TYPE_TROOP_NEW_FEED_NEED_AUTO_PULL_DOWN;
  public static final int TYPE_TROOP_RANK_SWITCH_CHANGE;
  private static int sNotificationTypeStart;
  
  static
  {
    int i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_TROOP_ENTER_EFFECT_PUSH = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_TROOP_MEMBER_CHANGED = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_TROOP_REWARD_CHANGE = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_TROOP_NEW_FEED_NEED_AUTO_PULL_DOWN = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_UPDATE_TITLE_BTN_CALL = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_TROOP_RANK_SWITCH_CHANGE = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_TROOP_BLOCK_STATUS_CHANGED = i;
  }
  
  private void onUpdate_notifyTroopEnterEffectPush(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_TROOP_ENTER_EFFECT_PUSH) {
      return;
    }
    onPushTroopEnterEffect((TroopEnterEffectData)paramObject);
  }
  
  private void onUpdate_notifyTroopMemberChanged(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_TROOP_MEMBER_CHANGED) {
      return;
    }
    onTroopMemberUpdate();
  }
  
  private void onUpdate_notifyTroopRankSwitchUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_TROOP_RANK_SWITCH_CHANGE) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 2) {
        onTroopRankSwitchUpdate((String)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
      }
    }
  }
  
  private void onUpdate_notifyTroopRewardChange(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_TROOP_REWARD_CHANGE) {
      return;
    }
    paramObject = (Object[])paramObject;
    onTroopRewardChangeNotify((String)paramObject[0], (String)paramObject[1]);
  }
  
  private void onUpdate_notifyUpdateTitleBtnCall(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_UPDATE_TITLE_BTN_CALL) {
      return;
    }
    onNotifyUpdateTitleBtnCall(paramBoolean, paramObject);
  }
  
  private void onUpdate_notify_TroopBlocked(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_TROOP_BLOCK_STATUS_CHANGED) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 1) {
        onTroopBlockStatusChanged((String)paramObject[0]);
      }
    }
  }
  
  private void onUpdate_troopNewFeedNeedAutoPullDown(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_TROOP_NEW_FEED_NEED_AUTO_PULL_DOWN) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 3) {
        onTroopNewFeedsAutoPullDown(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue());
      }
    }
  }
  
  protected void onNotifyUpdateTitleBtnCall(boolean paramBoolean, Object paramObject) {}
  
  protected void onPushTroopEnterEffect(TroopEnterEffectData paramTroopEnterEffectData) {}
  
  protected void onTroopBlockStatusChanged(String paramString) {}
  
  protected void onTroopMemberUpdate() {}
  
  protected void onTroopNewFeedsAutoPullDown(boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  protected void onTroopRankSwitchUpdate(String paramString, boolean paramBoolean) {}
  
  protected void onTroopRewardChangeNotify(String paramString1, String paramString2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    onUpdate_notifyTroopEnterEffectPush(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopMemberChanged(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopRewardChange(paramInt, paramBoolean, paramObject);
    onUpdate_troopNewFeedNeedAutoPullDown(paramInt, paramBoolean, paramObject);
    onUpdate_notifyUpdateTitleBtnCall(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopRankSwitchUpdate(paramInt, paramBoolean, paramObject);
    onUpdate_notify_TroopBlocked(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.onlinepush.api.TroopOnlinePushObserver
 * JD-Core Version:    0.7.0.1
 */