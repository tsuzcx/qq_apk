package com.tencent.rfw.barrage.util;

import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.data.RFWR2LBarrage;
import com.tencent.rfw.barrage.inject.RFWBarrageContext;
import com.tencent.rfw.barrage.inject.RFWWindowConfig;
import com.tencent.rfw.barrage.tool.RFWDuration;

public class RFWBarrageTimeUtils
{
  private static int a(RFWBaseBarrage paramRFWBaseBarrage)
  {
    return (int)(b(paramRFWBaseBarrage) / 64.0F * 1000.0F);
  }
  
  private static void a(RFWBaseBarrage paramRFWBaseBarrage, int paramInt, float paramFloat)
  {
    if (paramRFWBaseBarrage == null)
    {
      RFWBarrageLogger.b("RFWBarrageTimeUtils", "[updateBarrageDistribute] barrage should not be null.");
      return;
    }
    float f = paramFloat;
    if (paramFloat < 1250.0F) {
      f = 1250.0F;
    }
    int i = c(paramRFWBaseBarrage);
    long l = a(paramRFWBaseBarrage);
    paramInt = (int)(paramInt * f);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[updateBarrageDistribute] barrage play start time: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" | barrageDrawWidth: ");
    localStringBuilder.append(i);
    localStringBuilder.append(" | drawScreenDuration: ");
    localStringBuilder.append(l);
    localStringBuilder.append(" | barrage hash code: ");
    localStringBuilder.append(paramRFWBaseBarrage.hashCode());
    RFWBarrageLogger.b("RFWBarrageTimeUtils", localStringBuilder.toString());
    paramRFWBaseBarrage.g(paramInt);
    paramRFWBaseBarrage.a(new RFWDuration(l));
    if ((paramRFWBaseBarrage instanceof RFWR2LBarrage)) {
      ((RFWR2LBarrage)paramRFWBaseBarrage).g(i / (float)l);
    }
  }
  
  public static void a(RFWBarrageTimeUtils.RFWUpdateBarrageTimeParam paramRFWUpdateBarrageTimeParam)
  {
    if (paramRFWUpdateBarrageTimeParam == null)
    {
      RFWBarrageLogger.d("RFWBarrageTimeUtils", "[updateBarrageTime] barrage time param should not be null.");
      return;
    }
    long l = paramRFWUpdateBarrageTimeParam.c();
    int i = paramRFWUpdateBarrageTimeParam.b();
    int j = paramRFWUpdateBarrageTimeParam.d();
    a(paramRFWUpdateBarrageTimeParam.a(), j, (float)l / i);
  }
  
  private static int b(RFWBaseBarrage paramRFWBaseBarrage)
  {
    return RFWBarrageViewUtils.b(c(paramRFWBaseBarrage));
  }
  
  private static int c(RFWBaseBarrage paramRFWBaseBarrage)
  {
    if (paramRFWBaseBarrage == null)
    {
      RFWBarrageLogger.b("RFWBarrageTimeUtils", "[getBarrageDrawWidth] barrage should not be null.");
      return 0;
    }
    int i = (int)paramRFWBaseBarrage.c();
    return RFWBarrageContext.a().j() + i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.util.RFWBarrageTimeUtils
 * JD-Core Version:    0.7.0.1
 */