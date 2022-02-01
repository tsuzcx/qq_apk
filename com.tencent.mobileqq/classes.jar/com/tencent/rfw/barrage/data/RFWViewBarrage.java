package com.tencent.rfw.barrage.data;

import android.view.View;
import com.tencent.rfw.barrage.inject.RFWBarrageContext;
import com.tencent.rfw.barrage.render.RFWViewBarrageRender.ViewHolder;
import com.tencent.rfw.barrage.tool.RFWClickResult;
import com.tencent.rfw.barrage.tool.RFWTouchPoint;
import com.tencent.rfw.barrage.util.RFWBarrageLogger;
import com.tencent.rfw.barrage.util.RFWBarrageThreadUtils;

public class RFWViewBarrage
  extends RFWR2LBarrage
{
  private RFWViewBarrageRender.ViewHolder y;
  private boolean z = false;
  
  public RFWViewBarrage(RFWBarrageContext paramRFWBarrageContext)
  {
    super(paramRFWBarrageContext);
  }
  
  private void a(View paramView)
  {
    if (paramView == null)
    {
      RFWBarrageLogger.b("RFWBaseBarrage", "[performClick] target view should not be null.");
      return;
    }
    paramView.performClick();
  }
  
  public RFWViewBarrageRender.ViewHolder S()
  {
    return this.y;
  }
  
  public boolean T()
  {
    return this.z;
  }
  
  public RFWClickResult a(RFWTouchPoint paramRFWTouchPoint)
  {
    Object localObject = this.y;
    if (localObject == null)
    {
      RFWBarrageLogger.b("RFWBaseBarrage", "[onClick] view holder should not be null.");
      return super.a(paramRFWTouchPoint);
    }
    localObject = ((RFWViewBarrageRender.ViewHolder)localObject).a(paramRFWTouchPoint);
    if (localObject == null)
    {
      RFWBarrageLogger.b("RFWBaseBarrage", "[onClick] target view should not be null.");
      return super.a(paramRFWTouchPoint);
    }
    RFWBarrageThreadUtils.a().a(new RFWViewBarrage.1(this, (View)localObject));
    return new RFWClickResult(((View)localObject).getId());
  }
  
  public void a(RFWViewBarrageRender.ViewHolder paramViewHolder)
  {
    this.y = paramViewHolder;
  }
  
  public void f(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public void h()
  {
    super.h();
    this.z = false;
  }
  
  public int q()
  {
    return -2147483647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.data.RFWViewBarrage
 * JD-Core Version:    0.7.0.1
 */