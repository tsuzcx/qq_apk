package com.tencent.rfw.barrage.render;

import android.graphics.Canvas;
import android.util.SparseArray;
import android.view.View.MeasureSpec;
import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.data.RFWViewBarrage;
import com.tencent.rfw.barrage.inject.RFWBarrageContext;
import com.tencent.rfw.barrage.util.RFWBarrageContentSize;
import com.tencent.rfw.barrage.util.RFWBarrageLogger;
import java.util.ArrayList;
import java.util.List;

public abstract class RFWViewBarrageRender
  extends RFWBaseBarrageRender<RFWViewBarrage>
{
  private final SparseArray<List<RFWViewBarrageRender.ViewHolder>> a = new SparseArray();
  
  public int a(Object paramObject)
  {
    return 0;
  }
  
  public abstract RFWViewBarrageRender.ViewHolder a(int paramInt);
  
  public RFWBarrageContentSize a(RFWViewBarrage paramRFWViewBarrage)
  {
    if (paramRFWViewBarrage == null) {
      return new RFWBarrageContentSize(0.0F, 0.0F);
    }
    int i = a(paramRFWViewBarrage.r());
    Object localObject2 = (List)this.a.get(i);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ArrayList();
      this.a.put(i, localObject1);
    }
    if (((List)localObject1).isEmpty()) {
      ((List)localObject1).add(a(i));
    }
    localObject2 = null;
    if (!((List)localObject1).isEmpty()) {
      localObject2 = (RFWViewBarrageRender.ViewHolder)((List)localObject1).remove(0);
    }
    if (localObject2 == null)
    {
      RFWBarrageLogger.b("RFWViewBarrageRender", "[measure] current view holder should not be null.");
      return new RFWBarrageContentSize(0.0F, 0.0F);
    }
    a(i, (RFWViewBarrageRender.ViewHolder)localObject2, paramRFWViewBarrage);
    i = View.MeasureSpec.makeMeasureSpec(paramRFWViewBarrage.H(), -2147483648);
    int j = View.MeasureSpec.makeMeasureSpec(paramRFWViewBarrage.I(), -2147483648);
    ((RFWViewBarrageRender.ViewHolder)localObject2).a(i, j);
    int k = ((RFWViewBarrageRender.ViewHolder)localObject2).a();
    int m = ((RFWViewBarrageRender.ViewHolder)localObject2).b();
    ((RFWViewBarrageRender.ViewHolder)localObject2).a(0, 0, k, m);
    RFWBarrageLogger.a("RFWViewBarrageRender", new Object[] { "[measure] widthMeasureSpec: ", Integer.valueOf(i), " | heightMeasureSpec: ", Integer.valueOf(j), " | measureWidth: ", Integer.valueOf(k), " | measureHeight: ", Integer.valueOf(m) });
    paramRFWViewBarrage.a((RFWViewBarrageRender.ViewHolder)localObject2);
    paramRFWViewBarrage.b(((RFWViewBarrageRender.ViewHolder)localObject2).a());
    paramRFWViewBarrage.a(((RFWViewBarrageRender.ViewHolder)localObject2).b());
    return new RFWBarrageContentSize(((RFWViewBarrageRender.ViewHolder)localObject2).a(), ((RFWViewBarrageRender.ViewHolder)localObject2).b());
  }
  
  public abstract void a(int paramInt, RFWViewBarrageRender.ViewHolder paramViewHolder, RFWViewBarrage paramRFWViewBarrage);
  
  public void a(Canvas paramCanvas, RFWViewBarrage paramRFWViewBarrage, RFWBarrageContext paramRFWBarrageContext, float paramFloat1, float paramFloat2)
  {
    if (paramRFWViewBarrage == null) {
      return;
    }
    if (paramCanvas == null) {
      return;
    }
    paramRFWBarrageContext = paramRFWViewBarrage.S();
    if (paramRFWBarrageContext == null) {
      return;
    }
    if (!paramRFWViewBarrage.T())
    {
      paramRFWBarrageContext.a(View.MeasureSpec.makeMeasureSpec(paramRFWBarrageContext.a(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramRFWBarrageContext.b(), 1073741824));
      paramRFWBarrageContext.a(0, 0, paramRFWBarrageContext.a(), paramRFWBarrageContext.b());
      paramRFWViewBarrage.f(true);
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramRFWBarrageContext.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean a(RFWBaseBarrage paramRFWBaseBarrage)
  {
    return paramRFWBaseBarrage instanceof RFWViewBarrage;
  }
  
  public void b(RFWViewBarrage paramRFWViewBarrage)
  {
    if (paramRFWViewBarrage == null) {
      return;
    }
    RFWViewBarrageRender.ViewHolder localViewHolder = paramRFWViewBarrage.S();
    if (localViewHolder != null)
    {
      int i = a(paramRFWViewBarrage.r());
      List localList = (List)this.a.get(i);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.a.put(i, localObject);
      }
      ((List)localObject).add(localViewHolder);
      paramRFWViewBarrage.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.render.RFWViewBarrageRender
 * JD-Core Version:    0.7.0.1
 */