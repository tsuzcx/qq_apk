package com.tencent.rfw.barrage.render;

import android.graphics.Canvas;
import android.text.TextPaint;
import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.inject.RFWBarrageContext;
import com.tencent.rfw.barrage.inject.RFWWindowConfig;
import com.tencent.rfw.barrage.util.RFWBarrageContentSize;
import com.tencent.rfw.barrage.util.RFWDrawUtils;

public class RFWDefaultBarrageRender
  extends RFWBaseBarrageRender
{
  private TextPaint a = new TextPaint();
  
  private String d(RFWBaseBarrage paramRFWBaseBarrage)
  {
    if (paramRFWBaseBarrage == null) {
      return "";
    }
    return String.valueOf(paramRFWBaseBarrage.r());
  }
  
  public boolean a(RFWBaseBarrage paramRFWBaseBarrage)
  {
    return true;
  }
  
  public RFWBarrageContentSize b(RFWBaseBarrage paramRFWBaseBarrage)
  {
    if (paramRFWBaseBarrage == null) {
      return new RFWBarrageContentSize(0.0F, 0.0F);
    }
    RFWWindowConfig localRFWWindowConfig = RFWBarrageContext.a();
    float f1 = RFWDrawUtils.a(localRFWWindowConfig.m(), d(paramRFWBaseBarrage)) + localRFWWindowConfig.p() + localRFWWindowConfig.p();
    float f2 = RFWDrawUtils.a(localRFWWindowConfig.m()) + localRFWWindowConfig.o() * 2.0F;
    paramRFWBaseBarrage.a(f2);
    paramRFWBaseBarrage.b(f1);
    return new RFWBarrageContentSize(f1, f2);
  }
  
  public void b(Canvas paramCanvas, RFWBaseBarrage paramRFWBaseBarrage, RFWBarrageContext paramRFWBarrageContext, float paramFloat1, float paramFloat2)
  {
    paramRFWBarrageContext = RFWBarrageContext.a();
    this.a.setTextSize(paramRFWBarrageContext.m());
    this.a.setColor(-1);
    paramCanvas.drawText(d(paramRFWBaseBarrage), paramFloat1 + paramRFWBarrageContext.p(), paramFloat2 + paramRFWBarrageContext.o() - this.a.ascent(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.render.RFWDefaultBarrageRender
 * JD-Core Version:    0.7.0.1
 */