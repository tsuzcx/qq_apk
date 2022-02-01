package com.tencent.superplayer.bandwidth;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.superplayer.api.ISPBandwidthPredictor;
import com.tencent.superplayer.api.ISPBufferRangeController;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.ThreadUtil;
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
    int i;
    if ((paramLong2 > 0L) && (paramLong1 > 0L)) {
      i = (int)(paramLong2 / 1024L * 8L / paramLong1);
    } else {
      i = 0;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getBufferRange: fileSize=");
    ((StringBuilder)localObject1).append(paramLong2);
    ((StringBuilder)localObject1).append(", duration=");
    ((StringBuilder)localObject1).append(paramLong1);
    LogUtil.d("VideoBufferRangeController", ((StringBuilder)localObject1).toString());
    if (!isPeakPeriod(getEffectiveTimeConfigs()))
    {
      localObject1 = getConfigsForUnPeekPeriod();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("computeBufferange: no peak period，use defaultConfig, range=");
      ((StringBuilder)localObject2).append(localObject1[0]);
      ((StringBuilder)localObject2).append(", ");
      ((StringBuilder)localObject2).append(localObject1[1]);
      LogUtil.d("VideoBufferRangeController", ((StringBuilder)localObject2).toString());
      return localObject1;
    }
    localObject1 = getEmergencyTimeConfigs();
    Object localObject2 = getSafePlayTimeConfigs();
    int j = judgeStrategy((List)localObject1, l, i);
    int k = judgeStrategy((List)localObject2, l, i);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getBufferRange: bandwidth=");
    ((StringBuilder)localObject1).append(l);
    ((StringBuilder)localObject1).append(", bitrate=");
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append(", range=");
    ((StringBuilder)localObject1).append(j);
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append(k);
    LogUtil.d("VideoBufferRangeController", ((StringBuilder)localObject1).toString());
    return new int[] { j, k };
  }
  
  private List<Integer[]> decodeConfigs(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (String)this.configMap.get(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("decodeConfigs: key=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", configStr=");
    localStringBuilder.append((String)localObject);
    LogUtil.d("VideoBufferRangeController", localStringBuilder.toString());
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return localArrayList;
    }
    paramString = ((String)localObject).split("\\|");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      localObject = paramString[i].split(",");
      if (localObject.length == 2) {
        try
        {
          localArrayList.add(new Integer[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]) });
        }
        catch (Exception localException)
        {
          LogUtil.e("VideoBufferRangeController", "getConfigs: ", localException);
        }
      }
      i += 1;
    }
    Collections.sort(localArrayList, this);
    return localArrayList;
  }
  
  private int[] getConfigsForUnPeekPeriod()
  {
    Object localObject = decodeConfigs("uneffective_time_config");
    int i = ((List)localObject).size();
    Integer localInteger = Integer.valueOf(0);
    if (i > 0)
    {
      localObject = (Integer[])((List)localObject).get(0);
    }
    else
    {
      localObject = new Integer[2];
      localObject[0] = localInteger;
      localObject[1] = localInteger;
    }
    return new int[] { localObject[0].intValue(), localObject[1].intValue() };
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
    boolean bool1;
    Integer[] arrayOfInteger;
    do
    {
      do
      {
        boolean bool2 = paramList.hasNext();
        bool1 = false;
        if (!bool2) {
          break;
        }
        arrayOfInteger = (Integer[])paramList.next();
      } while (i < arrayOfInteger[0].intValue());
      bool1 = true;
    } while (i >= arrayOfInteger[1].intValue());
    return bool1;
  }
  
  private int judgeStrategy(List<Integer[]> paramList, long paramLong, int paramInt)
  {
    int i = 0;
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
    paramInt = i;
    if (!paramList.isEmpty())
    {
      paramList = (Integer[])paramList.get(paramList.size() - 1);
      paramInt = i;
      if (paramList[0].intValue() <= 0) {
        paramInt = paramList[1].intValue();
      }
    }
    return paramInt;
  }
  
  public int compare(Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2)
  {
    return paramArrayOfInteger2[0].intValue() - paramArrayOfInteger1[0].intValue();
  }
  
  public void setupBufferRange(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong)
  {
    ThreadUtil.runOnUiThread(new SPBufferRangeController.1(this, paramISuperPlayer, computeBufferange(paramInt, paramLong), CommonUtil.a((String)this.configMap.get("emergency_time_for_preplay"), 3)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.bandwidth.SPBufferRangeController
 * JD-Core Version:    0.7.0.1
 */