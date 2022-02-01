package org.jbox2d.common;

public abstract interface IViewportTransform
{
  public abstract Vec2 getCenter();
  
  public abstract Vec2 getExtents();
  
  public abstract void getScreenToWorld(Vec2 paramVec21, Vec2 paramVec22);
  
  public abstract void getScreenVectorToWorld(Vec2 paramVec21, Vec2 paramVec22);
  
  public abstract void getWorldToScreen(Vec2 paramVec21, Vec2 paramVec22);
  
  public abstract void getWorldVectorToScreen(Vec2 paramVec21, Vec2 paramVec22);
  
  public abstract boolean isYFlip();
  
  public abstract void setCamera(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void setCenter(float paramFloat1, float paramFloat2);
  
  public abstract void setCenter(Vec2 paramVec2);
  
  public abstract void setExtents(float paramFloat1, float paramFloat2);
  
  public abstract void setExtents(Vec2 paramVec2);
  
  public abstract void setYFlip(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.common.IViewportTransform
 * JD-Core Version:    0.7.0.1
 */