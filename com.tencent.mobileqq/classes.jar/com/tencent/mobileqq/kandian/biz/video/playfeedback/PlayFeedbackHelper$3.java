package com.tencent.mobileqq.kandian.biz.video.playfeedback;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.tplayer.plugins.report.BeaconAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class PlayFeedbackHelper$3
  implements Runnable
{
  PlayFeedbackHelper$3(HashMap paramHashMap) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      Object localObject2 = this.a.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append((String)localEntry.getKey());
        ((StringBuilder)localObject1).append(":");
        ((StringBuilder)localObject1).append((String)localEntry.getValue());
        ((StringBuilder)localObject1).append(" ");
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("report actVideoPlayFeedback, data=");
      ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
      QLog.d("PlayFeedbackHelper", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin();
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance((String)localObject1, "actVideoPlayFeedback", true, -1L, 0L, this.a, null);
    BeaconAdapter.onUserActionToTunnel("00000U7O8S3BLETM", "actVideoPlayFeedback", true, -1L, -1L, this.a, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeedback.PlayFeedbackHelper.3
 * JD-Core Version:    0.7.0.1
 */