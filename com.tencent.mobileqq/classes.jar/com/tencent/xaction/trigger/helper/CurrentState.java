package com.tencent.xaction.trigger.helper;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/trigger/helper/CurrentState;", "", "lastDownX", "", "lastDownY", "lastX", "lastY", "cx", "cy", "dx", "dy", "movedX", "movedY", "dsx", "dsy", "(FFFFFFFFFFFF)V", "getCx", "()F", "setCx", "(F)V", "getCy", "setCy", "getDsx", "setDsx", "getDsy", "setDsy", "getDx", "setDx", "getDy", "setDy", "getLastDownX", "setLastDownX", "getLastDownY", "setLastDownY", "getLastX", "setLastX", "getLastY", "setLastY", "getMovedX", "setMovedX", "getMovedY", "setMovedY", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class CurrentState
{
  private float cx;
  private float cy;
  private float dsx;
  private float dsy;
  private float dx;
  private float dy;
  private float lastDownX;
  private float lastDownY;
  private float lastX;
  private float lastY;
  private float movedX;
  private float movedY;
  
  public CurrentState()
  {
    this(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 4095, null);
  }
  
  public CurrentState(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12)
  {
    this.lastDownX = paramFloat1;
    this.lastDownY = paramFloat2;
    this.lastX = paramFloat3;
    this.lastY = paramFloat4;
    this.cx = paramFloat5;
    this.cy = paramFloat6;
    this.dx = paramFloat7;
    this.dy = paramFloat8;
    this.movedX = paramFloat9;
    this.movedY = paramFloat10;
    this.dsx = paramFloat11;
    this.dsy = paramFloat12;
  }
  
  public final float component1()
  {
    return this.lastDownX;
  }
  
  public final float component10()
  {
    return this.movedY;
  }
  
  public final float component11()
  {
    return this.dsx;
  }
  
  public final float component12()
  {
    return this.dsy;
  }
  
  public final float component2()
  {
    return this.lastDownY;
  }
  
  public final float component3()
  {
    return this.lastX;
  }
  
  public final float component4()
  {
    return this.lastY;
  }
  
  public final float component5()
  {
    return this.cx;
  }
  
  public final float component6()
  {
    return this.cy;
  }
  
  public final float component7()
  {
    return this.dx;
  }
  
  public final float component8()
  {
    return this.dy;
  }
  
  public final float component9()
  {
    return this.movedX;
  }
  
  @NotNull
  public final CurrentState copy(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12)
  {
    return new CurrentState(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof CurrentState))
      {
        paramObject = (CurrentState)paramObject;
        if ((Float.compare(this.lastDownX, paramObject.lastDownX) == 0) && (Float.compare(this.lastDownY, paramObject.lastDownY) == 0) && (Float.compare(this.lastX, paramObject.lastX) == 0) && (Float.compare(this.lastY, paramObject.lastY) == 0) && (Float.compare(this.cx, paramObject.cx) == 0) && (Float.compare(this.cy, paramObject.cy) == 0) && (Float.compare(this.dx, paramObject.dx) == 0) && (Float.compare(this.dy, paramObject.dy) == 0) && (Float.compare(this.movedX, paramObject.movedX) == 0) && (Float.compare(this.movedY, paramObject.movedY) == 0) && (Float.compare(this.dsx, paramObject.dsx) == 0) && (Float.compare(this.dsy, paramObject.dsy) == 0)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final float getCx()
  {
    return this.cx;
  }
  
  public final float getCy()
  {
    return this.cy;
  }
  
  public final float getDsx()
  {
    return this.dsx;
  }
  
  public final float getDsy()
  {
    return this.dsy;
  }
  
  public final float getDx()
  {
    return this.dx;
  }
  
  public final float getDy()
  {
    return this.dy;
  }
  
  public final float getLastDownX()
  {
    return this.lastDownX;
  }
  
  public final float getLastDownY()
  {
    return this.lastDownY;
  }
  
  public final float getLastX()
  {
    return this.lastX;
  }
  
  public final float getLastY()
  {
    return this.lastY;
  }
  
  public final float getMovedX()
  {
    return this.movedX;
  }
  
  public final float getMovedY()
  {
    return this.movedY;
  }
  
  public int hashCode()
  {
    return ((((((((((Float.floatToIntBits(this.lastDownX) * 31 + Float.floatToIntBits(this.lastDownY)) * 31 + Float.floatToIntBits(this.lastX)) * 31 + Float.floatToIntBits(this.lastY)) * 31 + Float.floatToIntBits(this.cx)) * 31 + Float.floatToIntBits(this.cy)) * 31 + Float.floatToIntBits(this.dx)) * 31 + Float.floatToIntBits(this.dy)) * 31 + Float.floatToIntBits(this.movedX)) * 31 + Float.floatToIntBits(this.movedY)) * 31 + Float.floatToIntBits(this.dsx)) * 31 + Float.floatToIntBits(this.dsy);
  }
  
  public final void setCx(float paramFloat)
  {
    this.cx = paramFloat;
  }
  
  public final void setCy(float paramFloat)
  {
    this.cy = paramFloat;
  }
  
  public final void setDsx(float paramFloat)
  {
    this.dsx = paramFloat;
  }
  
  public final void setDsy(float paramFloat)
  {
    this.dsy = paramFloat;
  }
  
  public final void setDx(float paramFloat)
  {
    this.dx = paramFloat;
  }
  
  public final void setDy(float paramFloat)
  {
    this.dy = paramFloat;
  }
  
  public final void setLastDownX(float paramFloat)
  {
    this.lastDownX = paramFloat;
  }
  
  public final void setLastDownY(float paramFloat)
  {
    this.lastDownY = paramFloat;
  }
  
  public final void setLastX(float paramFloat)
  {
    this.lastX = paramFloat;
  }
  
  public final void setLastY(float paramFloat)
  {
    this.lastY = paramFloat;
  }
  
  public final void setMovedX(float paramFloat)
  {
    this.movedX = paramFloat;
  }
  
  public final void setMovedY(float paramFloat)
  {
    this.movedY = paramFloat;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CurrentState(lastDownX=");
    localStringBuilder.append(this.lastDownX);
    localStringBuilder.append(", lastDownY=");
    localStringBuilder.append(this.lastDownY);
    localStringBuilder.append(", lastX=");
    localStringBuilder.append(this.lastX);
    localStringBuilder.append(", lastY=");
    localStringBuilder.append(this.lastY);
    localStringBuilder.append(", cx=");
    localStringBuilder.append(this.cx);
    localStringBuilder.append(", cy=");
    localStringBuilder.append(this.cy);
    localStringBuilder.append(", dx=");
    localStringBuilder.append(this.dx);
    localStringBuilder.append(", dy=");
    localStringBuilder.append(this.dy);
    localStringBuilder.append(", movedX=");
    localStringBuilder.append(this.movedX);
    localStringBuilder.append(", movedY=");
    localStringBuilder.append(this.movedY);
    localStringBuilder.append(", dsx=");
    localStringBuilder.append(this.dsx);
    localStringBuilder.append(", dsy=");
    localStringBuilder.append(this.dsy);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.trigger.helper.CurrentState
 * JD-Core Version:    0.7.0.1
 */