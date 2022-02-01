package com.tencent.mobileqq.onlinestatus.view;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo.UpdateUIListener;
import com.tencent.mobileqq.onlinestatus.constellation.StatusExtInfoObserver;

class OnlineStatusConstellationDisplayInfo$1
  extends StatusExtInfoObserver
{
  OnlineStatusConstellationDisplayInfo$1(OnlineStatusConstellationDisplayInfo paramOnlineStatusConstellationDisplayInfo) {}
  
  public void a(boolean paramBoolean, @Nullable Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    if (paramBundle != null) {
      OnlineStatusConstellationDisplayInfo.a(this.a, paramBundle.getString("key_today_constellation_trend"));
    }
    this.a.a();
    if ((OnlineStatusConstellationDisplayInfo.a(this.a)) && (OnlineStatusConstellationDisplayInfo.a(this.a) != null)) {
      OnlineStatusConstellationDisplayInfo.b(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.OnlineStatusConstellationDisplayInfo.1
 * JD-Core Version:    0.7.0.1
 */