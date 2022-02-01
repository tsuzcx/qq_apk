package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.size;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/size/SizeParam;", "", "unitValue", "", "(F)V", "getUnitValue", "()F", "getPosition", "timeUs", "getShowStr", "", "", "getTime", "scrollX", "perPx", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public abstract class SizeParam
{
  private final float a;
  
  public SizeParam(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public final float a()
  {
    return this.a;
  }
  
  public abstract float a(float paramFloat);
  
  public abstract float a(float paramFloat1, float paramFloat2);
  
  @NotNull
  public abstract String a(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.size.SizeParam
 * JD-Core Version:    0.7.0.1
 */