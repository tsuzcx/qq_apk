package com.tencent.ttpic.model;

import java.util.List;

public class FaceCropItem
{
  public int frameDuration;
  public List<CropFrame> frameList;
  public int frames;
  
  public static class CropFrame
  {
    public double faceAngle;
    public double faceWidth;
    public double height;
    public int index;
    public double noseX;
    public double noseY;
    public double width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.model.FaceCropItem
 * JD-Core Version:    0.7.0.1
 */