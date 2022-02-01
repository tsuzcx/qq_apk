package com.tencent.mobileqq.dinifly.model.content;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.tencent.mobileqq.dinifly.model.CubicCurveData;
import com.tencent.mobileqq.dinifly.utils.Logger;
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
    boolean bool;
    if ((!paramShapeData1.isClosed()) && (!paramShapeData2.isClosed())) {
      bool = false;
    } else {
      bool = true;
    }
    this.closed = bool;
    if (paramShapeData1.getCurves().size() != paramShapeData2.getCurves().size())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Curves must have the same number of control points. Shape 1: ");
      ((StringBuilder)localObject1).append(paramShapeData1.getCurves().size());
      ((StringBuilder)localObject1).append("\tShape 2: ");
      ((StringBuilder)localObject1).append(paramShapeData2.getCurves().size());
      Logger.warning(((StringBuilder)localObject1).toString());
    }
    int j = Math.min(paramShapeData1.getCurves().size(), paramShapeData2.getCurves().size());
    if (this.curves.size() < j)
    {
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
        localObject1 = this.curves;
        ((List)localObject1).remove(((List)localObject1).size() - 1);
        i -= 1;
      }
    }
    Object localObject1 = paramShapeData1.getInitialPoint();
    PointF localPointF1 = paramShapeData2.getInitialPoint();
    setInitialPoint(MiscUtils.lerp(((PointF)localObject1).x, localPointF1.x, paramFloat), MiscUtils.lerp(((PointF)localObject1).y, localPointF1.y, paramFloat));
    int i = this.curves.size() - 1;
    while (i >= 0)
    {
      Object localObject3 = (CubicCurveData)paramShapeData1.getCurves().get(i);
      Object localObject2 = (CubicCurveData)paramShapeData2.getCurves().get(i);
      localObject1 = ((CubicCurveData)localObject3).getControlPoint1();
      localPointF1 = ((CubicCurveData)localObject3).getControlPoint2();
      localObject3 = ((CubicCurveData)localObject3).getVertex();
      PointF localPointF2 = ((CubicCurveData)localObject2).getControlPoint1();
      PointF localPointF3 = ((CubicCurveData)localObject2).getControlPoint2();
      localObject2 = ((CubicCurveData)localObject2).getVertex();
      ((CubicCurveData)this.curves.get(i)).setControlPoint1(MiscUtils.lerp(((PointF)localObject1).x, localPointF2.x, paramFloat), MiscUtils.lerp(((PointF)localObject1).y, localPointF2.y, paramFloat));
      ((CubicCurveData)this.curves.get(i)).setControlPoint2(MiscUtils.lerp(localPointF1.x, localPointF3.x, paramFloat), MiscUtils.lerp(localPointF1.y, localPointF3.y, paramFloat));
      ((CubicCurveData)this.curves.get(i)).setVertex(MiscUtils.lerp(((PointF)localObject3).x, ((PointF)localObject2).x, paramFloat), MiscUtils.lerp(((PointF)localObject3).y, ((PointF)localObject2).y, paramFloat));
      i -= 1;
    }
  }
  
  public boolean isClosed()
  {
    return this.closed;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShapeData{numCurves=");
    localStringBuilder.append(this.curves.size());
    localStringBuilder.append("closed=");
    localStringBuilder.append(this.closed);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.ShapeData
 * JD-Core Version:    0.7.0.1
 */