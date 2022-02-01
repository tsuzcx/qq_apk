package com.tencent.mobileqq.cmshow.engine.model;

import android.util.Pair;
import com.tencent.mobileqq.cmshow.engine.render.RenderMode;

public class RenderConfig
{
  public boolean a;
  public int b;
  public boolean c;
  public boolean d;
  public boolean e;
  public RenderMode f = RenderMode.ON_SCREEN;
  public Pair<Integer, Integer> g;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RenderConfig{needTextureView=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", initHeight=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", destroyOnAsync=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", disableDuplicateCreateRender=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", fastTouchCheck=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", renderMode=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.model.RenderConfig
 * JD-Core Version:    0.7.0.1
 */