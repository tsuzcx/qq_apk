package com.tencent.xaction.anim;

import kotlin.Metadata;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class PhysicalWorld2$addBody$1
  implements Runnable
{
  PhysicalWorld2$addBody$1(PhysicalWorld2 paramPhysicalWorld2, XARect paramXARect, float paramFloat1, float paramFloat2) {}
  
  public final void run()
  {
    Body localBody = this.this$0.a(this.a);
    if (localBody != null)
    {
      localBody.setAwake(true);
      localBody.applyLinearImpulse(new Vec2(this.b, this.c), localBody.getPosition());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.anim.PhysicalWorld2.addBody.1
 * JD-Core Version:    0.7.0.1
 */