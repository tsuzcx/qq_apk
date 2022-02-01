package com.tencent.rfw.barrage.inject;

import com.tencent.rfw.barrage.core.RFWAbsWindow;
import com.tencent.rfw.barrage.core.RFWCacheDrawManager;
import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.tool.RFWBarrageDrawTimer;
import com.tencent.rfw.barrage.tool.RFWBasePlayerTimer;
import java.util.Comparator;

public abstract interface IRFWBarrageWindowCreator
{
  public abstract RFWAbsWindow a(RFWBarrageContext paramRFWBarrageContext, RFWCacheDrawManager paramRFWCacheDrawManager, Comparator<RFWBaseBarrage> paramComparator, RFWBasePlayerTimer paramRFWBasePlayerTimer, RFWBarrageDrawTimer paramRFWBarrageDrawTimer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.inject.IRFWBarrageWindowCreator
 * JD-Core Version:    0.7.0.1
 */