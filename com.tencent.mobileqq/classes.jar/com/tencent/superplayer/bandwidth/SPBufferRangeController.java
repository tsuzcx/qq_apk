package com.tencent.superplayer.bandwidth;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.superplayer.api.ISPBandwidthPredictor;
import com.tencent.superplayer.api.ISPBufferRangeController;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.ThreadUtil;
import com.tencent.superplayer.utils.Utils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SPBufferRangeController
  implements ISPBufferRangeController, Comparator<Integer[]>
{
  public static final String CONFIG_EFFECTIVE_TIME = "effective_time";
  public static final String CONFIG_EMERGENCY_TIME = "emergency_time_config";
  public static final String CONFIG_EMERGENCY_TIME_FOR_PREPLAY = "emergency_time_for_preplay";
  public static final String CONFIG_PARAMS_FOR_UNEFFECTIVE_TIME = "uneffective_time_config";
  public static final String CONFIG_SAFE_PLAY_TIME = "safe_play_time_config";
  private static final int DEFAULT_EMERGENCY_TIME_FOR_PREPLAY = 3;
  private static final String TAG = "VideoBufferRangeController";
  private Map<String, String> configMap;
  private ISPBandwidthPredictor predictor;
  
  public SPBufferRangeController(@NonNull ISPBandwidthPredictor paramISPBandwidthPredictor, @NonNull Map<String, String> paramMap)
  {
    this.predictor = paramISPBandwidthPredictor;
    this.configMap = paramMap;
  }
  
  private int[] computeBufferange(long paramLong1, long paramLong2)
  {
    long l = this.predictor.getCurrentPrediction();
    if ((paramLong2 > 0L) && (paramLong1 > 0L)) {}
    for (int i = (int)(paramLong2 / 1024L * 8L / paramLong1);; i = 0)
    {
      LogUtil.d("VideoBufferRangeController", "getBufferRange: fileSize=" + paramLong2 + ", duration=" + paramLong1);
      if (!isPeakPeriod(getEffectiveTimeConfigs()))
      {
        localObject = getConfigsForUnPeekPeriod();
        LogUtil.d("VideoBufferRangeController", "computeBufferange: no peak period，use defaultConfig, range=" + localObject[0] + ", " + localObject[1]);
        return localObject;
      }
      Object localObject = getEmergencyTimeConfigs();
      List localList = getSafePlayTimeConfigs();
      int j = judgeStrategy((List)localObject, l, i);
      int k = judgeStrategy(localList, l, i);
      LogUtil.d("VideoBufferRangeController", "getBufferRange: bandwidth=" + l + ", bitrate=" + i + ", range=" + j + ", " + k);
      return new int[] { j, k };
    }
  }
  
  private List<Integer[]> decodeConfigs(String paramString)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    Object localObject = (String)this.configMap.get(paramString);
    LogUtil.d("VideoBufferRangeController", "decodeConfigs: key=" + paramString + ", configStr=" + (String)localObject);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return localArrayList;
    }
    paramString = ((String)localObject).split("\\|");
    int j = paramString.length;
    for (;;)
    {
      if (i < j)
      {
        localObject = paramString[i].split(",");
        if (localObject.length == 2) {}
        try
        {
          localArrayList.add(new Integer[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]) });
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            LogUtil.e("VideoBufferRangeController", "getConfigs: ", localException);
          }
        }
      }
    }
    Collections.sort(localArrayList, this);
    return localArrayList;
  }
  
  private int[] getConfigsForUnPeekPeriod()
  {
    Object localObject = decodeConfigs("uneffective_time_config");
    if (((List)localObject).size() > 0) {
      localObject = (Integer[])((List)localObject).get(0);
    }
    for (;;)
    {
      return new int[] { localObject[0].intValue(), localObject[1].intValue() };
      localObject = new Integer[2];
      localObject[0] = Integer.valueOf(0);
      localObject[1] = Integer.valueOf(0);
    }
  }
  
  private List<Integer[]> getEffectiveTimeConfigs()
  {
    return decodeConfigs("effective_time");
  }
  
  private List<Integer[]> getEmergencyTimeConfigs()
  {
    return decodeConfigs("emergency_time_config");
  }
  
  private List<Integer[]> getSafePlayTimeConfigs()
  {
    return decodeConfigs("safe_play_time_config");
  }
  
  private boolean isPeakPeriod(List<Integer[]> paramList)
  {
    int i = Calendar.getInstance().get(11);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Integer[] arrayOfInteger = (Integer[])paramList.next();
      if ((i >= arrayOfInteger[0].intValue()) && (i < arrayOfInteger[1].intValue())) {
        return true;
      }
    }
    return false;
  }
  
  private int judgeStrategy(List<Integer[]> paramList, long paramLong, int paramInt)
  {
    if ((paramLong > 0L) && (paramInt > 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Integer[] arrayOfInteger = (Integer[])localIterator.next();
        if (paramLong > arrayOfInteger[0].intValue() * paramInt / 8) {
          return arrayOfInteger[1].intValue();
        }
      }
    }
    if (!paramList.isEmpty())
    {
      paramList = (Integer[])paramList.get(paramList.size() - 1);
      if (paramList[0].intValue() <= 0) {
        return paramList[1].intValue();
      }
    }
    return 0;
  }
  
  public int compare(Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2)
  {
    return paramArrayOfInteger2[0].intValue() - paramArrayOfInteger1[0].intValue();
  }
  
  public void setupBufferRange(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong)
  {
    ThreadUtil.runOnUiThread(new SPBufferRangeController.1(this, paramISuperPlayer, computeBufferange(paramInt, paramLong), Utils.parseStr2Int((String)this.configMap.get("emergency_time_for_preplay"), 3)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.bandwidth.SPBufferRangeController
 * JD-Core Version:    0.7.0.1
 */