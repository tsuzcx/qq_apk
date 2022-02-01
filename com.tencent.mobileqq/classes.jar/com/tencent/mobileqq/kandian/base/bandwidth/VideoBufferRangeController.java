package com.tencent.mobileqq.kandian.base.bandwidth;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.ThreadUtil;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class VideoBufferRangeController
  implements Comparator<Integer[]>
{
  private static VideoBufferRangeController a;
  
  private int a(List<Integer[]> paramList, long paramLong, int paramInt)
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
  
  public static VideoBufferRangeController a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new VideoBufferRangeController();
        }
      }
      finally {}
    }
    return a;
  }
  
  private List<Integer[]> a()
  {
    return a("effective_time");
  }
  
  private List<Integer[]> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = BandWidthConfig.a.a(paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("decodeConfigs: key=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", configStr=");
      localStringBuilder.append((String)localObject);
      QLog.d("VideoBufferRangeController", 2, localStringBuilder.toString());
    }
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
          if (QLog.isColorLevel()) {
            QLog.e("VideoBufferRangeController", 2, "getConfigs: ", localException);
          }
        }
      }
      i += 1;
    }
    Collections.sort(localArrayList, this);
    return localArrayList;
  }
  
  private boolean a(List<Integer[]> paramList)
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
  
  private int[] a()
  {
    Object localObject = a("uneffective_time_config");
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
  
  private List<Integer[]> b()
  {
    return a("emergency_time_config");
  }
  
  private List<Integer[]> c()
  {
    return a("safe_play_time_config");
  }
  
  public int a(int paramInt, long paramLong)
  {
    if ((paramLong > 0L) && (paramInt > 0)) {
      long l = paramLong / 1024L * 8L / paramInt;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBufferRange: fileSize=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", duration=");
      localStringBuilder.append(paramInt);
      QLog.d("VideoBufferRangeController", 2, localStringBuilder.toString());
    }
    if (paramInt > 60) {
      return BandWidthConfig.a.c() + paramInt / 60;
    }
    return BandWidthConfig.a.c();
  }
  
  public int a(Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2)
  {
    return paramArrayOfInteger2[0].intValue() - paramArrayOfInteger1[0].intValue();
  }
  
  public String a()
  {
    return BandWidthConfig.a.a();
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt, long paramLong)
  {
    int[] arrayOfInt = a().a(paramInt, paramLong);
    paramInt = a().a(paramInt, paramLong);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setupBufferRange: bufferRange=");
      localStringBuilder.append(arrayOfInt[0]);
      localStringBuilder.append(" ");
      localStringBuilder.append(arrayOfInt[1]);
      localStringBuilder.append(", preplayTime=");
      localStringBuilder.append(paramInt);
      QLog.d("VideoBufferRangeController", 2, localStringBuilder.toString());
    }
    ThreadUtil.a(new VideoBufferRangeController.1(this, paramVideoPlayerWrapper, arrayOfInt, paramInt));
  }
  
  public int[] a(long paramLong1, long paramLong2)
  {
    long l = BandwidthPredictor.from().getCurrentPrediction();
    int i;
    if ((paramLong2 > 0L) && (paramLong1 > 0L)) {
      i = (int)(paramLong2 / 1024L * 8L / paramLong1);
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getBufferRange: fileSize=");
      ((StringBuilder)localObject1).append(paramLong2);
      ((StringBuilder)localObject1).append(", duration=");
      ((StringBuilder)localObject1).append(paramLong1);
      QLog.d("VideoBufferRangeController", 2, ((StringBuilder)localObject1).toString());
    }
    if (!a(a()))
    {
      localObject1 = a();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("computeBufferange: no peak period，use defaultConfig, range=");
        ((StringBuilder)localObject2).append(localObject1[0]);
        ((StringBuilder)localObject2).append(", ");
        ((StringBuilder)localObject2).append(localObject1[1]);
        QLog.d("VideoBufferRangeController", 2, ((StringBuilder)localObject2).toString());
      }
      return localObject1;
    }
    Object localObject1 = b();
    Object localObject2 = c();
    int j = a((List)localObject1, l, i);
    int k = a((List)localObject2, l, i);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getBufferRange: bandwidth=");
      ((StringBuilder)localObject1).append(l);
      ((StringBuilder)localObject1).append(", bitrate=");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(", range=");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(k);
      QLog.d("VideoBufferRangeController", 2, ((StringBuilder)localObject1).toString());
    }
    return new int[] { j, k };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.bandwidth.VideoBufferRangeController
 * JD-Core Version:    0.7.0.1
 */