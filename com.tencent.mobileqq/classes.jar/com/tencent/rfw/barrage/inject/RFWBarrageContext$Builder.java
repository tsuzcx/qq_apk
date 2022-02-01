package com.tencent.rfw.barrage.inject;

import com.tencent.rfw.barrage.render.RFWBaseBarrageRender;
import java.util.ArrayList;
import java.util.List;

public final class RFWBarrageContext$Builder
{
  public IRFWBarrageLineHeightDecider a;
  public IRFWBarrageBarrageCreator b;
  private boolean c;
  private IRFWBarragePlayTimeSupplier d;
  private IRFWBarrageExposureCallback e;
  private IRFWWindowConfigCreator f;
  private IRFWBarrageUIConfigCreator g;
  private List<RFWBaseBarrageRender> h = new ArrayList();
  private IRFWBarrageClearScreenCallback i;
  private IRFWBarrageWindowCreator j;
  private int k;
  private boolean l = false;
  
  public Builder a(int paramInt)
  {
    this.k = paramInt;
    return this;
  }
  
  public Builder a(IRFWBarrageExposureCallback paramIRFWBarrageExposureCallback)
  {
    this.e = paramIRFWBarrageExposureCallback;
    return this;
  }
  
  public Builder a(IRFWBarragePlayTimeSupplier paramIRFWBarragePlayTimeSupplier)
  {
    this.d = paramIRFWBarragePlayTimeSupplier;
    return this;
  }
  
  public Builder a(RFWBaseBarrageRender paramRFWBaseBarrageRender)
  {
    this.h.add(paramRFWBaseBarrageRender);
    return this;
  }
  
  public RFWBarrageContext a()
  {
    return new RFWBarrageContext(this, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.inject.RFWBarrageContext.Builder
 * JD-Core Version:    0.7.0.1
 */