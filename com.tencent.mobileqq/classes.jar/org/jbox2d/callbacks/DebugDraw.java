package org.jbox2d.callbacks;

import org.jbox2d.common.Color3f;
import org.jbox2d.common.IViewportTransform;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;

public abstract class DebugDraw
{
  public static final int e_aabbBit = 4;
  public static final int e_centerOfMassBit = 16;
  public static final int e_dynamicTreeBit = 32;
  public static final int e_jointBit = 2;
  public static final int e_pairBit = 8;
  public static final int e_shapeBit = 1;
  protected int m_drawFlags = 0;
  protected final IViewportTransform viewportTransform;
  
  public DebugDraw(IViewportTransform paramIViewportTransform)
  {
    this.viewportTransform = paramIViewportTransform;
  }
  
  public void appendFlags(int paramInt)
  {
    this.m_drawFlags = (paramInt | this.m_drawFlags);
  }
  
  public void clearFlags(int paramInt)
  {
    this.m_drawFlags = ((paramInt ^ 0xFFFFFFFF) & this.m_drawFlags);
  }
  
  public abstract void drawCircle(Vec2 paramVec2, float paramFloat, Color3f paramColor3f);
  
  public abstract void drawPoint(Vec2 paramVec2, float paramFloat, Color3f paramColor3f);
  
  public void drawPolygon(Vec2[] paramArrayOfVec2, int paramInt, Color3f paramColor3f)
  {
    if (paramInt == 1)
    {
      drawSegment(paramArrayOfVec2[0], paramArrayOfVec2[0], paramColor3f);
      return;
    }
    int i = 0;
    int j;
    for (;;)
    {
      j = paramInt - 1;
      if (i >= j) {
        break;
      }
      Vec2 localVec2 = paramArrayOfVec2[i];
      i += 1;
      drawSegment(localVec2, paramArrayOfVec2[i], paramColor3f);
    }
    if (paramInt > 2) {
      drawSegment(paramArrayOfVec2[j], paramArrayOfVec2[0], paramColor3f);
    }
  }
  
  public abstract void drawSegment(Vec2 paramVec21, Vec2 paramVec22, Color3f paramColor3f);
  
  public abstract void drawSolidCircle(Vec2 paramVec21, float paramFloat, Vec2 paramVec22, Color3f paramColor3f);
  
  public abstract void drawSolidPolygon(Vec2[] paramArrayOfVec2, int paramInt, Color3f paramColor3f);
  
  public abstract void drawString(float paramFloat1, float paramFloat2, String paramString, Color3f paramColor3f);
  
  public void drawString(Vec2 paramVec2, String paramString, Color3f paramColor3f)
  {
    drawString(paramVec2.x, paramVec2.y, paramString, paramColor3f);
  }
  
  public abstract void drawTransform(Transform paramTransform);
  
  public int getFlags()
  {
    return this.m_drawFlags;
  }
  
  public Vec2 getScreenToWorld(float paramFloat1, float paramFloat2)
  {
    Vec2 localVec2 = new Vec2(paramFloat1, paramFloat2);
    this.viewportTransform.getScreenToWorld(localVec2, localVec2);
    return localVec2;
  }
  
  public Vec2 getScreenToWorld(Vec2 paramVec2)
  {
    Vec2 localVec2 = new Vec2();
    this.viewportTransform.getScreenToWorld(paramVec2, localVec2);
    return localVec2;
  }
  
  public void getScreenToWorldToOut(float paramFloat1, float paramFloat2, Vec2 paramVec2)
  {
    paramVec2.set(paramFloat1, paramFloat2);
    this.viewportTransform.getScreenToWorld(paramVec2, paramVec2);
  }
  
  public void getScreenToWorldToOut(Vec2 paramVec21, Vec2 paramVec22)
  {
    this.viewportTransform.getScreenToWorld(paramVec21, paramVec22);
  }
  
  public IViewportTransform getViewportTranform()
  {
    return this.viewportTransform;
  }
  
  public Vec2 getWorldToScreen(float paramFloat1, float paramFloat2)
  {
    Vec2 localVec2 = new Vec2(paramFloat1, paramFloat2);
    this.viewportTransform.getWorldToScreen(localVec2, localVec2);
    return localVec2;
  }
  
  public Vec2 getWorldToScreen(Vec2 paramVec2)
  {
    Vec2 localVec2 = new Vec2();
    this.viewportTransform.getWorldToScreen(paramVec2, localVec2);
    return localVec2;
  }
  
  public void getWorldToScreenToOut(float paramFloat1, float paramFloat2, Vec2 paramVec2)
  {
    paramVec2.set(paramFloat1, paramFloat2);
    this.viewportTransform.getWorldToScreen(paramVec2, paramVec2);
  }
  
  public void getWorldToScreenToOut(Vec2 paramVec21, Vec2 paramVec22)
  {
    this.viewportTransform.getWorldToScreen(paramVec21, paramVec22);
  }
  
  public void setCamera(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.viewportTransform.setCamera(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setFlags(int paramInt)
  {
    this.m_drawFlags = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.callbacks.DebugDraw
 * JD-Core Version:    0.7.0.1
 */