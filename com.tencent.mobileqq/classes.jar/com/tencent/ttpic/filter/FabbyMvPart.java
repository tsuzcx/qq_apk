package com.tencent.ttpic.filter;

import com.tencent.ttpic.model.StickerItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class FabbyMvPart
{
  public String audio;
  public StickerItem bgItem;
  public StickerItem coverItem;
  public HashMap<Float, Double> degreeMap = new HashMap();
  public long duration;
  public int easeCurve = 0;
  public StickerItem fgItem;
  public int fid;
  public int filterType;
  public HashMap<Float, Integer> gridModeMap = new HashMap();
  public HashMap<Float, Integer> gridTypeMap = new HashMap();
  public String lutFile;
  public long partIndex;
  public HashMap<Float, Double> scaleMap = new HashMap();
  public boolean singlePart;
  public long transitionDuration;
  public int transitionEase;
  public int transitionFunction;
  public StickerItem transitionItem;
  public int transitionMaskType = 1;
  
  private double getValue(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5)
  {
    paramDouble2 = (paramDouble5 - paramDouble2) / (paramDouble4 - paramDouble2);
    switch (this.easeCurve)
    {
    default: 
      return (paramDouble3 - paramDouble1) * paramDouble2 + paramDouble1;
    case 1: 
      return -(paramDouble3 - paramDouble1) * Math.cos(1.570796326794897D * paramDouble2) + paramDouble3;
    case 2: 
      return (paramDouble3 - paramDouble1) * Math.sin(1.570796326794897D * paramDouble2) + paramDouble1;
    }
    return -(paramDouble3 - paramDouble1) / 2.0D * (Math.cos(3.141592653589793D * paramDouble2) - 1.0D) + paramDouble1;
  }
  
  public double getDegree(float paramFloat)
  {
    if (this.degreeMap.size() <= 0) {
      return 0.0D;
    }
    float f1 = 0.0F;
    float f3 = 1.0F;
    Iterator localIterator = this.degreeMap.keySet().iterator();
    float f2;
    for (;;)
    {
      f2 = f3;
      if (!localIterator.hasNext()) {
        break;
      }
      f2 = ((Float)localIterator.next()).floatValue();
      if (f2 > paramFloat) {
        break;
      }
      f1 = f2;
    }
    if (paramFloat == f1) {
      return ((Double)this.degreeMap.get(Float.valueOf(f1))).doubleValue();
    }
    if (paramFloat == f2) {
      return ((Double)this.degreeMap.get(Float.valueOf(f2))).doubleValue();
    }
    return getValue(((Double)this.degreeMap.get(Float.valueOf(f1))).doubleValue(), f1, ((Double)this.degreeMap.get(Float.valueOf(f2))).doubleValue(), f2, paramFloat);
  }
  
  public int getGridMode(float paramFloat)
  {
    if (this.gridModeMap.size() <= 0) {
      return 0;
    }
    float f1 = 0.0F;
    Iterator localIterator = this.gridModeMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      float f2 = ((Float)localIterator.next()).floatValue();
      if (f2 > paramFloat) {
        break;
      }
      f1 = f2;
    }
    return ((Integer)this.gridModeMap.get(Float.valueOf(f1))).intValue();
  }
  
  public int getGridType(float paramFloat)
  {
    if (this.gridTypeMap.size() <= 0) {
      return 0;
    }
    float f1 = 0.0F;
    Iterator localIterator = this.gridTypeMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      float f2 = ((Float)localIterator.next()).floatValue();
      if (f2 > paramFloat) {
        break;
      }
      f1 = f2;
    }
    return ((Integer)this.gridTypeMap.get(Float.valueOf(f1))).intValue();
  }
  
  public double getScale(float paramFloat)
  {
    if (this.scaleMap.size() <= 0) {
      return 1.0D;
    }
    float f1 = 0.0F;
    float f3 = 1.0F;
    Iterator localIterator = this.scaleMap.keySet().iterator();
    float f2;
    for (;;)
    {
      f2 = f3;
      if (!localIterator.hasNext()) {
        break;
      }
      f2 = ((Float)localIterator.next()).floatValue();
      if (f2 > paramFloat) {
        break;
      }
      f1 = f2;
    }
    if (paramFloat == f1) {
      return ((Double)this.scaleMap.get(Float.valueOf(f1))).doubleValue();
    }
    if (paramFloat == f2) {
      return ((Double)this.scaleMap.get(Float.valueOf(f2))).doubleValue();
    }
    return getValue(((Double)this.scaleMap.get(Float.valueOf(f1))).doubleValue(), f1, ((Double)this.scaleMap.get(Float.valueOf(f2))).doubleValue(), f2, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.FabbyMvPart
 * JD-Core Version:    0.7.0.1
 */