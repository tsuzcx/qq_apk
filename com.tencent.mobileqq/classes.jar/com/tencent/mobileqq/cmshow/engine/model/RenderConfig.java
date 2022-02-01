package com.tencent.mobileqq.cmshow.engine.model;

import android.util.Pair;
import com.tencent.mobileqq.cmshow.engine.render.RenderMode;

public class RenderConfig
{
  public int a;
  public Pair<Integer, Integer> a;
  public RenderMode a;
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e = true;
  
  public RenderConfig()
  {
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderRenderMode = RenderMode.ON_SCREEN;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RenderConfig{needTextureView=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", initHeight=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", destroyOnAsync=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", disableDuplicateCreateRender=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", fastTouchCheck=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", renderMode=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderRenderMode);
    localStringBuilder.append(", zOrderOnTop=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.model.RenderConfig
 * JD-Core Version:    0.7.0.1
 */