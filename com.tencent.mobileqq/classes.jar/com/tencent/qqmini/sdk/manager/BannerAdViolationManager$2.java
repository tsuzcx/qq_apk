package com.tencent.qqmini.sdk.manager;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Map;

final class BannerAdViolationManager$2
  implements View.OnClickListener
{
  BannerAdViolationManager$2(View.OnClickListener paramOnClickListener, long paramLong, View paramView, float[] paramArrayOfFloat, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.val$oldOnClickListener;
    if (localObject != null) {
      ((View.OnClickListener)localObject).onClick(paramView);
    }
    long l = 0L;
    localObject = (Long)BannerAdViolationManager.access$000().get(Long.valueOf(this.val$aid));
    if (localObject != null) {
      l = System.currentTimeMillis() - ((Long)localObject).longValue();
    }
    int j = this.val$view.getWidth() / 5;
    int k = this.val$view.getHeight() / 2;
    localObject = this.val$lastTouchDownXY;
    int i;
    if (localObject[1] > k) {
      i = (int)localObject[0] / j + 6;
    } else {
      i = (int)localObject[0] / j + 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("box = ");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(k);
    ((StringBuilder)localObject).append(" size = ");
    ((StringBuilder)localObject).append(this.val$view.getWidth());
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(this.val$view.getHeight());
    ((StringBuilder)localObject).append(" x,y = ");
    ((StringBuilder)localObject).append(this.val$lastTouchDownXY[0]);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(this.val$lastTouchDownXY[1]);
    ((StringBuilder)localObject).append(" area = ");
    ((StringBuilder)localObject).append(i);
    QMLog.d("BannerAdViolationManage", ((StringBuilder)localObject).toString());
    BannerAdViolationManager.access$100(this.val$miniAppId, this.val$aid, i, l);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BannerAdViolationManager.2
 * JD-Core Version:    0.7.0.1
 */