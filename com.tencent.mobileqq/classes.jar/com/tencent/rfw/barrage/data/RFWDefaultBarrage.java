package com.tencent.rfw.barrage.data;

import com.tencent.rfw.barrage.inject.RFWBarrageContext;

public class RFWDefaultBarrage
  extends RFWR2LBarrage
{
  public RFWDefaultBarrage(RFWBarrageContext paramRFWBarrageContext)
  {
    super(paramRFWBarrageContext);
  }
  
  public int q()
  {
    return -2147483648;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.data.RFWDefaultBarrage
 * JD-Core Version:    0.7.0.1
 */