package com.tencent.mobileqq.dinifly.model.content;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import com.tencent.mobileqq.dinifly.model.CubicCurveData;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue.Factory;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ShapeData
{
  private boolean closed;
  private final List<CubicCurveData> curves = new ArrayList();
  private PointF initialPoint;
  
  public ShapeData() {}
  
  private ShapeData(PointF paramPointF, boolean paramBoolean, List<CubicCurveData> paramList)
  {
    this.initialPoint = paramPointF;
    this.closed = paramBoolean;
    this.curves.addAll(paramList);
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
    for (boolean bool = true;; bool = false)
    {
      this.closed = bool;
      if ((this.curves.isEmpty()) || (this.curves.size() == paramShapeData1.getCurves().size()) || (this.curves.size() == paramShapeData2.getCurves().size())) {
        break;
      }
      throw new IllegalStateException("Curves must have the same number of control points. This: " + getCurves().size() + "\tShape 1: " + paramShapeData1.getCurves().size() + "\tShape 2: " + paramShapeData2.getCurves().size());
    }
    if (this.curves.isEmpty())
    {
      i = paramShapeData1.getCurves().size() - 1;
      while (i >= 0)
      {
        this.curves.add(new CubicCurveData());
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
  
  public static class Factory
    implements AnimatableValue.Factory<ShapeData>
  {
    public static final Factory INSTANCE = new Factory();
    
    private static PointF vertexAtIndex(int paramInt, JSONArray paramJSONArray)
    {
      if (paramInt >= paramJSONArray.length()) {
        throw new IllegalArgumentException("Invalid index " + paramInt + ". There are only " + paramJSONArray.length() + " points.");
      }
      Object localObject = paramJSONArray.optJSONArray(paramInt);
      paramJSONArray = ((JSONArray)localObject).opt(0);
      localObject = ((JSONArray)localObject).opt(1);
      float f1;
      if ((paramJSONArray instanceof Double))
      {
        f1 = ((Double)paramJSONArray).floatValue();
        if (!(localObject instanceof Double)) {
          break label128;
        }
      }
      label128:
      for (float f2 = ((Double)localObject).floatValue();; f2 = ((Integer)localObject).intValue())
      {
        return new PointF(f1, f2);
        f1 = ((Integer)paramJSONArray).intValue();
        break;
      }
    }
    
    public ShapeData valueFromObject(Object paramObject, float paramFloat)
    {
      Object localObject2 = null;
      if ((paramObject instanceof JSONArray))
      {
        paramObject = ((JSONArray)paramObject).opt(0);
        localObject1 = localObject2;
        if ((paramObject instanceof JSONObject))
        {
          localObject1 = localObject2;
          if (((JSONObject)paramObject).has("v")) {
            localObject1 = (JSONObject)paramObject;
          }
        }
      }
      while (localObject1 == null)
      {
        return null;
        localObject1 = localObject2;
        if ((paramObject instanceof JSONObject))
        {
          localObject1 = localObject2;
          if (((JSONObject)paramObject).has("v")) {
            localObject1 = (JSONObject)paramObject;
          }
        }
      }
      Object localObject4 = ((JSONObject)localObject1).optJSONArray("v");
      localObject2 = ((JSONObject)localObject1).optJSONArray("i");
      Object localObject3 = ((JSONObject)localObject1).optJSONArray("o");
      boolean bool = ((JSONObject)localObject1).optBoolean("c", false);
      if ((localObject4 == null) || (localObject2 == null) || (localObject3 == null) || (((JSONArray)localObject4).length() != ((JSONArray)localObject2).length()) || (((JSONArray)localObject4).length() != ((JSONArray)localObject3).length())) {
        throw new IllegalStateException("Unable to process points array or tangents. " + localObject1);
      }
      if (((JSONArray)localObject4).length() == 0) {
        return new ShapeData(new PointF(), false, Collections.emptyList(), null);
      }
      int j = ((JSONArray)localObject4).length();
      paramObject = vertexAtIndex(0, (JSONArray)localObject4);
      paramObject.x *= paramFloat;
      paramObject.y *= paramFloat;
      Object localObject1 = new ArrayList(j);
      int i = 1;
      PointF localPointF1;
      while (i < j)
      {
        localPointF1 = vertexAtIndex(i, (JSONArray)localObject4);
        PointF localPointF3 = vertexAtIndex(i - 1, (JSONArray)localObject4);
        PointF localPointF4 = vertexAtIndex(i - 1, (JSONArray)localObject3);
        PointF localPointF2 = vertexAtIndex(i, (JSONArray)localObject2);
        localPointF3 = MiscUtils.addPoints(localPointF3, localPointF4);
        localPointF2 = MiscUtils.addPoints(localPointF1, localPointF2);
        localPointF3.x *= paramFloat;
        localPointF3.y *= paramFloat;
        localPointF2.x *= paramFloat;
        localPointF2.y *= paramFloat;
        localPointF1.x *= paramFloat;
        localPointF1.y *= paramFloat;
        ((List)localObject1).add(new CubicCurveData(localPointF3, localPointF2, localPointF1));
        i += 1;
      }
      if (bool)
      {
        localPointF1 = vertexAtIndex(0, (JSONArray)localObject4);
        localObject4 = vertexAtIndex(j - 1, (JSONArray)localObject4);
        localObject3 = vertexAtIndex(j - 1, (JSONArray)localObject3);
        localObject2 = vertexAtIndex(0, (JSONArray)localObject2);
        localObject3 = MiscUtils.addPoints((PointF)localObject4, (PointF)localObject3);
        localObject2 = MiscUtils.addPoints(localPointF1, (PointF)localObject2);
        if (paramFloat != 1.0F)
        {
          ((PointF)localObject3).x *= paramFloat;
          ((PointF)localObject3).y *= paramFloat;
          ((PointF)localObject2).x *= paramFloat;
          ((PointF)localObject2).y *= paramFloat;
          localPointF1.x *= paramFloat;
          localPointF1.y *= paramFloat;
        }
        ((List)localObject1).add(new CubicCurveData((PointF)localObject3, (PointF)localObject2, localPointF1));
      }
      return new ShapeData(paramObject, bool, (List)localObject1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.ShapeData
 * JD-Core Version:    0.7.0.1
 */