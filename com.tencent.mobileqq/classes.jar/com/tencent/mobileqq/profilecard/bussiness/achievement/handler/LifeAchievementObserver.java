package com.tencent.mobileqq.profilecard.bussiness.achievement.handler;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;

public class LifeAchievementObserver
  implements BusinessObserver
{
  private void onUpdate_onPraiseLifeAchievement(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 10) {
      return;
    }
    boolean bool = paramObject instanceof Bundle;
    paramInt = -1;
    int i;
    if (bool)
    {
      paramObject = (Bundle)paramObject;
      i = paramObject.getInt("life_achievement_praise_action_type_key", -1);
      paramInt = paramObject.getInt("life_achievement_praise_id_key", -1);
    }
    else
    {
      i = -1;
    }
    onPraiseLifeAchievement(paramBoolean, i, paramInt);
  }
  
  protected void onPraiseLifeAchievement(boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    onUpdate_onPraiseLifeAchievement(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.achievement.handler.LifeAchievementObserver
 * JD-Core Version:    0.7.0.1
 */