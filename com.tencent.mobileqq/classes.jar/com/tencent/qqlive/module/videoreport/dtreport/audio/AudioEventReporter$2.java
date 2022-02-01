package com.tencent.qqlive.module.videoreport.dtreport.audio;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.time.audio.AudioHeartBeatSpUtils;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.JsonUtils;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class AudioEventReporter$2
  implements Runnable
{
  public void run()
  {
    Object localObject1 = AudioHeartBeatSpUtils.getLastHeartBeatMap();
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = String.valueOf(((Map.Entry)((Iterator)localObject1).next()).getValue());
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        Object localObject3 = JsonUtils.getMapForJson((String)localObject2);
        if (localObject3 != null)
        {
          localObject2 = (FinalData)ReusablePool.obtain(6);
          ((FinalData)localObject2).setEventKey("dt_audio_heartbeat");
          ((FinalData)localObject2).putAll((Map)localObject3);
          localObject3 = VideoReportInner.getInstance().getEventDynamicParams();
          if (localObject3 != null) {
            ((IEventDynamicParams)localObject3).setEventDynamicParams("dt_audio_heartbeat", ((FinalData)localObject2).getEventParams());
          }
          FinalDataTarget.handle(null, (FinalData)localObject2);
        }
      }
    }
    AudioHeartBeatSpUtils.clearLastHeartBeatMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.AudioEventReporter.2
 * JD-Core Version:    0.7.0.1
 */