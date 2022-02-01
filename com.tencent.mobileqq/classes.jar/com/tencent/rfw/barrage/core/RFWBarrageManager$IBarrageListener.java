package com.tencent.rfw.barrage.core;

import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.tool.RFWClickResult;
import com.tencent.rfw.barrage.tool.RFWTouchPoint;
import java.util.List;

public abstract interface RFWBarrageManager$IBarrageListener
{
  public abstract void a();
  
  public abstract void a(RFWBaseBarrage paramRFWBaseBarrage, RFWTouchPoint paramRFWTouchPoint, RFWClickResult paramRFWClickResult);
  
  public abstract void a(List<RFWBaseBarrage> paramList);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.core.RFWBarrageManager.IBarrageListener
 * JD-Core Version:    0.7.0.1
 */