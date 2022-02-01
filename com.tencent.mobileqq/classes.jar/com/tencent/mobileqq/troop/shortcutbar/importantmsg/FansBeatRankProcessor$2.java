package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopInfoExt;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.utils.FansTroopUtils;
import com.tencent.qphone.base.util.QLog;

class FansBeatRankProcessor$2
  extends TroopObserver
{
  FansBeatRankProcessor$2(FansBeatRankProcessor paramFansBeatRankProcessor) {}
  
  protected void onGetTroopInfoExtComplete(boolean paramBoolean, String paramString, TroopInfoExt paramTroopInfoExt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FansBeatRankProcessor", 2, new Object[] { "onGetTroopInfoExtComplete,", Boolean.valueOf(paramBoolean), " troopUin=", paramString });
    }
    if (paramBoolean)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if ((TextUtils.equals(FansBeatRankProcessor.a(this.a), paramString)) && (FansTroopUtils.a(FansBeatRankProcessor.a(this.a), paramString, paramTroopInfoExt))) {
        FansBeatRankProcessor.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.FansBeatRankProcessor.2
 * JD-Core Version:    0.7.0.1
 */