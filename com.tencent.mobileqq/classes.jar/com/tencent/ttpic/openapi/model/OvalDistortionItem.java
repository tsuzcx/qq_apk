package com.tencent.ttpic.openapi.model;

import java.util.Arrays;

public class OvalDistortionItem
  extends DistortionItem
{
  public int[] angleEnd = new int[4];
  public int[] angleStart = new int[4];
  public int[] center = new int[4];
  public int[] centerOffsetEnd = new int[4];
  public float centerOffsetMultiplier = 1.0F;
  public int[] centerOffsetStart = new int[4];
  public int distortionType = 0;
  public float innerCircle = 1.2F;
  public int[] lengthEnd = new int[4];
  public float lengthMultiplier = 1.0F;
  public int[] lengthStart = new int[4];
  public float outerCircle = 0.5F;
  public int[] pushEnd = new int[4];
  public int[] pushStart = new int[4];
  public int scaleArea = 0;
  public int[] widthEnd = new int[4];
  public float widthMultiplier = 1.0F;
  public int[] widthStart = new int[4];
  
  public OvalDistortionItem()
  {
    Arrays.fill(this.center, -1);
    Arrays.fill(this.centerOffsetStart, -1);
    Arrays.fill(this.centerOffsetEnd, -1);
    Arrays.fill(this.widthStart, -1);
    Arrays.fill(this.widthEnd, -1);
    Arrays.fill(this.lengthStart, -1);
    Arrays.fill(this.lengthEnd, -1);
    Arrays.fill(this.angleStart, -1);
    Arrays.fill(this.angleEnd, -1);
    Arrays.fill(this.pushStart, -1);
    Arrays.fill(this.pushEnd, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.OvalDistortionItem
 * JD-Core Version:    0.7.0.1
 */