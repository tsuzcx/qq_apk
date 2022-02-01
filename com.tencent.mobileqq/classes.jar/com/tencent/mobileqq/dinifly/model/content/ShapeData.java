package com.tencent.mobileqq.dinifly.model.content;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import com.tencent.mobileqq.dinifly.L;
import com.tencent.mobileqq.dinifly.model.CubicCurveData;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import java.util.ArrayList;
import java.util.List;

public class ShapeData
{
  private boolean closed;
  private final List<CubicCurveData> curves;
  private PointF initialPoint;
  
  public ShapeData()
  {
    this.curves = new ArrayList();
  }
  
  public ShapeData(PointF paramPointF, boolean paramBoolean, List<CubicCurveData> paramList)
  {
    this.initialPoint = paramPointF;
    this.closed = paramBoolean;
    this.curves = new ArrayList(paramList);
  }
  
  private void setInitialPoint(float paramFloat1, float paramFloat2)
  {
    if (this.initialPoint == null) {
      this.initialPoint = new PointF();
    }
    this.initialPoint.set(paramFloat1, paramFloat2);
  }
  
  public List<CubicCurveData> getCurves()
  {
    return this.curves;
  }
  
  public PointF getInitialPoint()
  {
    return this.initialPoint;
  }
  
  public void interpolateBetween(ShapeData paramShapeData1, ShapeData paramShapeData2, @FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    if (this.initialPoint == null) {
      this.initialPoint = new PointF();
    }
    if ((paramShapeData1.isClosed()) || (paramShapeData2.isClosed())) {}
    int j;
    for (boolean bool = true;; bool = false)
    {
      this.closed = bool;
      if (paramShapeData1.getCurves().size() != paramShapeData2.getCurves().size()) {
        L.warn("Curves must have the same number of control points. Shape 1: " + paramShapeData1.getCurves().size() + "\tShape 2: " + paramShapeData2.getCurves().size());
      }
      j = Math.min(paramShapeData1.getCurves().size(), paramShapeData2.getCurves().size());
      if (this.curves.size() >= j) {
        break;
      }
      i = this.curves.size();
      while (i < j)
      {
        this.curves.add(new CubicCurveData());
        i += 1;
      }
    }
    if (this.curves.size() > j)
    {
      i = this.curves.size() - 1;
      while (i >= j)
      {
        this.curves.remove(this.curves.size() - 1);
        i -= 1;
      }
    }
    PointF localPointF1 = paramShapeData1.getInitialPoint();
    PointF localPointF2 = paramShapeData2.getInitialPoint();
    setInitialPoint(MiscUtils.lerp(localPointF1.x, localPointF2.x, paramFloat), MiscUtils.lerp(localPointF1.y, localPointF2.y, paramFloat));
    int i = this.curves.size() - 1;
    while (i >= 0)
    {
      Object localObject2 = (CubicCurveData)paramShapeData1.getCurves().get(i);
      Object localObject1 = (CubicCurveData)paramShapeData2.getCurves().get(i);
      localPointF1 = ((CubicCurveData)localObject2).getControlPoint1();
      localPointF2 = ((CubicCurveData)localObject2).getControlPoint2();
      localObject2 = ((CubicCurveData)localObject2).getVertex();
      PointF localPointF3 = ((CubicCurveData)localObject1).getControlPoint1();
      PointF localPointF4 = ((CubicCurveData)localObject1).getControlPoint2();
      localObject1 = ((CubicCurveData)localObject1).getVertex();
      ((CubicCurveData)this.curves.get(i)).setControlPoint1(MiscUtils.lerp(localPointF1.x, localPointF3.x, paramFloat), MiscUtils.lerp(localPointF1.y, localPointF3.y, paramFloat));
      ((CubicCurveData)this.curves.get(i)).setControlPoint2(MiscUtils.lerp(localPointF2.x, localPointF4.x, paramFloat), MiscUtils.lerp(localPointF2.y, localPointF4.y, paramFloat));
      ((CubicCurveData)this.curves.get(i)).setVertex(MiscUtils.lerp(((PointF)localObject2).x, ((PointF)localObject1).x, paramFloat), MiscUtils.lerp(((PointF)localObject2).y, ((PointF)localObject1).y, paramFloat));
      i -= 1;
    }
  }
  
  public boolean isClosed()
  {
    return this.closed;
  }
  
  public String toString()
  {
    return "ShapeData{numCurves=" + this.curves.size() + "closed=" + this.closed + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.ShapeData
 * JD-Core Version:    0.7.0.1
 */