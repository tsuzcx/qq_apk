package com.tencent.youtu.ytagreflectlivecheck.jni.model;

import java.util.ArrayList;

public class PersonLive
{
  private String app_id = "";
  private String color_data;
  private ArrayList<FaceFrame> frames;
  private int platform;
  private ReflectColorData reflect_data;
  
  public String getColor_data()
  {
    return this.color_data;
  }
  
  public ArrayList<FaceFrame> getFrames()
  {
    return this.frames;
  }
  
  public int getPlatform()
  {
    return this.platform;
  }
  
  public ReflectColorData getReflect_data()
  {
    return this.reflect_data;
  }
  
  public void setColor_data(String paramString)
  {
    this.color_data = paramString;
  }
  
  public void setFrames(ArrayList<FaceFrame> paramArrayList)
  {
    this.frames = paramArrayList;
  }
  
  public void setPlatform(int paramInt)
  {
    this.platform = paramInt;
  }
  
  public void setReflect_data(ReflectColorData paramReflectColorData)
  {
    this.reflect_data = paramReflectColorData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.jni.model.PersonLive
 * JD-Core Version:    0.7.0.1
 */