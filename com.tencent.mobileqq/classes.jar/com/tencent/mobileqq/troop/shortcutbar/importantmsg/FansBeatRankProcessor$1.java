package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.text.TextUtils;
import com.tencent.mobileqq.troop.api.observer.TroopPushObserver;

class FansBeatRankProcessor$1
  extends TroopPushObserver
{
  FansBeatRankProcessor$1(FansBeatRankProcessor paramFansBeatRankProcessor) {}
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    if (paramBoolean)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (TextUtils.equals(paramString, FansBeatRankProcessor.a(this.a))) {
        FansBeatRankProcessor.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.FansBeatRankProcessor.1
 * JD-Core Version:    0.7.0.1
 */