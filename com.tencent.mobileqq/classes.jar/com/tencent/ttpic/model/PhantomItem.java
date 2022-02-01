package com.tencent.ttpic.model;

import java.util.Arrays;

public class PhantomItem
{
  private int blendMode = 0;
  private String dataPath;
  private String id = "";
  private String maskImage = "";
  private double opacity = 1.0D;
  private double scale = 1.0D;
  private double xAsin = 0.0D;
  private double xBcos = 0.0D;
  private double xK = 0.0D;
  private double xOffset = 0.0D;
  private double xPhase = 0.0D;
  private double[] xRange = { 0.0D, 360.0D };
  private double xStep = 0.0D;
  private double xtime = 0.0D;
  private double yAsin = 0.0D;
  private double yBcos = 0.0D;
  private double yK = 0.0D;
  private double yOffset = 0.0D;
  private double yPhase = 0.0D;
  private double[] yRange = { 0.0D, 360.0D };
  private double yStep = 0.0D;
  private double ytime = 0.0D;
  
  public int getBlendMode()
  {
    return this.blendMode;
  }
  
  public String getDataPath()
  {
    return this.dataPath;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getMaskImage()
  {
    return this.maskImage;
  }
  
  public double getOpacity()
  {
    return this.opacity;
  }
  
  public double getScale()
  {
    return this.scale;
  }
  
  public double getXtime()
  {
    return this.xtime;
  }
  
  public double getYtime()
  {
    return this.ytime;
  }
  
  public double getxAsin()
  {
    return this.xAsin / this.scale;
  }
  
  public double getxBcos()
  {
    return this.xBcos / this.scale;
  }
  
  public double getxK()
  {
    return this.xK;
  }
  
  public double getxOffset()
  {
    double d1 = this.xOffset;
    double d2 = this.scale;
    return (d1 - (1.0D - d2) * 0.5D) / d2;
  }
  
  public double getxPhase()
  {
    return this.xPhase;
  }
  
  public double[] getxRange()
  {
    return this.xRange;
  }
  
  public double getxStep()
  {
    return this.xStep;
  }
  
  public double getyAsin()
  {
    return this.yAsin / this.scale;
  }
  
  public double getyBcos()
  {
    return this.yBcos / this.scale;
  }
  
  public double getyK()
  {
    return this.yK;
  }
  
  public double getyOffset()
  {
    double d1 = this.yOffset;
    double d2 = this.scale;
    return (d1 - (1.0D - d2) * 0.5D) / d2;
  }
  
  public double getyPhase()
  {
    return this.yPhase;
  }
  
  public double[] getyRange()
  {
    return this.yRange;
  }
  
  public double getyStep()
  {
    return this.yStep;
  }
  
  public void makeXStep(long paramLong)
  {
    double d1 = this.xtime;
    double d2 = this.xStep;
    double d3 = paramLong;
    Double.isNaN(d3);
    this.xtime = (d1 + d2 * d3 * 0.03D);
    d1 = this.xtime;
    double[] arrayOfDouble = this.xRange;
    if (d1 > arrayOfDouble[1]) {
      this.xtime = arrayOfDouble[0];
    }
  }
  
  public void makeYStep(long paramLong)
  {
    double d1 = this.ytime;
    double d2 = this.yStep;
    double d3 = paramLong;
    Double.isNaN(d3);
    this.ytime = (d1 + d2 * d3 * 0.03D);
    d1 = this.ytime;
    double[] arrayOfDouble = this.yRange;
    if (d1 > arrayOfDouble[1]) {
      this.ytime = arrayOfDouble[0];
    }
  }
  
  public void setBlendMode(int paramInt)
  {
    this.blendMode = paramInt;
  }
  
  public void setDataPath(String paramString)
  {
    this.dataPath = paramString;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setMaskImage(String paramString)
  {
    this.maskImage = paramString;
  }
  
  public void setOpacity(double paramDouble)
  {
    if (paramDouble > 1.0D)
    {
      this.opacity = 1.0D;
      return;
    }
    if (paramDouble < 0.0D)
    {
      this.opacity = 0.0D;
      return;
    }
    this.opacity = paramDouble;
  }
  
  public void setScale(double paramDouble)
  {
    if (paramDouble <= 0.0D)
    {
      this.scale = 1.0D;
      return;
    }
    this.scale = paramDouble;
  }
  
  public void setXtime(double paramDouble)
  {
    this.xtime = paramDouble;
  }
  
  public void setYtime(double paramDouble)
  {
    this.ytime = paramDouble;
  }
  
  public void setxAsin(double paramDouble)
  {
    this.xAsin = paramDouble;
  }
  
  public void setxBcos(double paramDouble)
  {
    this.xBcos = paramDouble;
  }
  
  public void setxK(double paramDouble)
  {
    this.xK = paramDouble;
  }
  
  public void setxOffset(double paramDouble)
  {
    this.xOffset = paramDouble;
  }
  
  public void setxPhase(double paramDouble)
  {
    this.xPhase = paramDouble;
  }
  
  public void setxRange(double[] paramArrayOfDouble)
  {
    this.xRange = paramArrayOfDouble;
  }
  
  public void setxStep(double paramDouble)
  {
    this.xStep = paramDouble;
  }
  
  public void setyAsin(double paramDouble)
  {
    this.yAsin = paramDouble;
  }
  
  public void setyBcos(double paramDouble)
  {
    this.yBcos = paramDouble;
  }
  
  public void setyK(double paramDouble)
  {
    this.yK = paramDouble;
  }
  
  public void setyOffset(double paramDouble)
  {
    this.yOffset = paramDouble;
  }
  
  public void setyPhase(double paramDouble)
  {
    this.yPhase = paramDouble;
  }
  
  public void setyRange(double[] paramArrayOfDouble)
  {
    this.yRange = paramArrayOfDouble;
  }
  
  public void setyStep(double paramDouble)
  {
    this.yStep = paramDouble;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PhantomItem{dataPath='");
    localStringBuilder.append(this.dataPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", id='");
    localStringBuilder.append(this.id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", maskImage='");
    localStringBuilder.append(this.maskImage);
    localStringBuilder.append('\'');
    localStringBuilder.append(", blendMode=");
    localStringBuilder.append(this.blendMode);
    localStringBuilder.append(", scale=");
    localStringBuilder.append(this.scale);
    localStringBuilder.append(", opacity=");
    localStringBuilder.append(this.opacity);
    localStringBuilder.append(", xK=");
    localStringBuilder.append(this.xK);
    localStringBuilder.append(", xAsin=");
    localStringBuilder.append(this.xAsin);
    localStringBuilder.append(", xBcos=");
    localStringBuilder.append(this.xBcos);
    localStringBuilder.append(", xPhase=");
    localStringBuilder.append(this.xPhase);
    localStringBuilder.append(", xOffset=");
    localStringBuilder.append(this.xOffset);
    localStringBuilder.append(", xStep=");
    localStringBuilder.append(this.xStep);
    localStringBuilder.append(", xRange=");
    localStringBuilder.append(Arrays.toString(this.xRange));
    localStringBuilder.append(", yK=");
    localStringBuilder.append(this.yK);
    localStringBuilder.append(", yAsin=");
    localStringBuilder.append(this.yAsin);
    localStringBuilder.append(", yBcos=");
    localStringBuilder.append(this.yBcos);
    localStringBuilder.append(", yPhase=");
    localStringBuilder.append(this.yPhase);
    localStringBuilder.append(", yOffset=");
    localStringBuilder.append(this.yOffset);
    localStringBuilder.append(", yStep=");
    localStringBuilder.append(this.yStep);
    localStringBuilder.append(", yRange=");
    localStringBuilder.append(Arrays.toString(this.yRange));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.model.PhantomItem
 * JD-Core Version:    0.7.0.1
 */