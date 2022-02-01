package com.tencent.mobileqq.kandian.biz.viola.barrage;

import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.style.FlexNode.MeasureFunction;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageDomObject;", "Lcom/tencent/viola/ui/dom/DomObject;", "()V", "forceHeight", "", "getForceHeight", "()F", "setForceHeight", "(F)V", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BarrageDomObject
  extends DomObject
{
  public static final BarrageDomObject.Companion a = new BarrageDomObject.Companion(null);
  private float b = -1.0F;
  
  public BarrageDomObject()
  {
    setMeasureFunction((FlexNode.MeasureFunction)new BarrageDomObject.measureFunction.1(this));
  }
  
  public final void a(float paramFloat)
  {
    this.b = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageDomObject
 * JD-Core Version:    0.7.0.1
 */