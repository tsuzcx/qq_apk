package com.tencent.mobileqq.minigame.manager;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

final class BannerAdViolationManager$2
  implements View.OnClickListener
{
  BannerAdViolationManager$2(View.OnClickListener paramOnClickListener, long paramLong, View paramView, float[] paramArrayOfFloat, String paramString, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo) {}
  
  public void onClick(View paramView)
  {
    if (this.val$oldOnClickListener != null) {
      this.val$oldOnClickListener.onClick(paramView);
    }
    Long localLong = (Long)BannerAdViolationManager.access$000().get(Long.valueOf(this.val$aid));
    if (localLong != null) {}
    for (long l = System.currentTimeMillis() - localLong.longValue();; l = 0L)
    {
      int j = this.val$view.getWidth() / 5;
      int k = this.val$view.getHeight() / 2;
      if (this.val$lastTouchDownXY[1] > k) {}
      for (int i = (int)this.val$lastTouchDownXY[0] / j + 6;; i = (int)this.val$lastTouchDownXY[0] / j + 1)
      {
        QLog.d("BannerAdViolationManage", 1, "box = " + j + "," + k + " size = " + this.val$view.getWidth() + "," + this.val$view.getHeight() + " x,y = " + this.val$lastTouchDownXY[0] + "," + this.val$lastTouchDownXY[1] + " area = " + i);
        BannerAdViolationManager.access$100(this.val$miniAppId, this.val$adInfo, i, l);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.BannerAdViolationManager.2
 * JD-Core Version:    0.7.0.1
 */