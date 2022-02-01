package com.tencent.mobileqq.selectmember;

import android.text.TextUtils;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingObserver;
import java.util.Map;

public class TroopDiscussionTroop$MyRoamSettingObserver
  extends RoamSettingObserver
{
  protected TroopDiscussionTroop$MyRoamSettingObserver(TroopDiscussionTroop paramTroopDiscussionTroop) {}
  
  protected void a(boolean paramBoolean, String paramString, Map<String, Integer> paramMap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("message.group.policy.")) {
        return;
      }
      this.a.c();
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopDiscussionTroop.MyRoamSettingObserver
 * JD-Core Version:    0.7.0.1
 */