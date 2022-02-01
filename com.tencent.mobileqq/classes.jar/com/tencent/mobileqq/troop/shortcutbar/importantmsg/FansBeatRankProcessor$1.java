package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.text.TextUtils;
import com.tencent.mobileqq.app.TroopBusinessObserver;

class FansBeatRankProcessor$1
  extends TroopBusinessObserver
{
  FansBeatRankProcessor$1(FansBeatRankProcessor paramFansBeatRankProcessor) {}
  
  public void onTroopClassExtChanged(boolean paramBoolean, String paramString, long paramLong)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    while (!TextUtils.equals(paramString, FansBeatRankProcessor.a(this.a))) {
      return;
    }
    FansBeatRankProcessor.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.FansBeatRankProcessor.1
 * JD-Core Version:    0.7.0.1
 */