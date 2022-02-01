package com.tencent.mobileqq.kandian.base.bandwidth;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.bandwidth.api.IBandwidthPredictor;
import com.tencent.superplayer.api.ISPBandwidthPredictor;
import com.tencent.superplayer.api.SuperPlayerFactory;
import java.util.HashMap;
import java.util.Map;

public class BandwidthPredictor
  implements IBandwidthPredictor, ISPBandwidthPredictor
{
  public static final int DEFAULT_RESET_TIME_THRESHOLD_WIFI = 3600;
  public static final int DEFAULT_RESET_TIME_THRESHOLD_XG = 600;
  private static BandwidthPredictor INSTANCE;
  private final ISPBandwidthPredictor predictor;
  
  public BandwidthPredictor()
  {
    HashMap localHashMap = new HashMap();
    int i = BandWidthConfig.a.a();
    int j = BandWidthConfig.a.b();
    localHashMap.put("reset_time_threshold_wifi", String.valueOf(i));
    localHashMap.put("reset_time_threshold_xg", String.valueOf(j));
    this.predictor = SuperPlayerFactory.createBandwidthPredictor(BaseApplicationImpl.context, null, null, localHashMap);
  }
  
  public static BandwidthPredictor from()
  {
    if (INSTANCE == null) {
      try
      {
        if (INSTANCE == null) {
          INSTANCE = new BandwidthPredictor();
        }
      }
      finally {}
    }
    return INSTANCE;
  }
  
  public long getCurrentPrediction()
  {
    return this.predictor.getCurrentPrediction();
  }
  
  public long getLastBandwidth()
  {
    return this.predictor.getLastBandwidth();
  }
  
  public void start(Context paramContext)
  {
    this.predictor.start(paramContext);
  }
  
  public void stop(Context paramContext)
  {
    this.predictor.stop(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.bandwidth.BandwidthPredictor
 * JD-Core Version:    0.7.0.1
 */