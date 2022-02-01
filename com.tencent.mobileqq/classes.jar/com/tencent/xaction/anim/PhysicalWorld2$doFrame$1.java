package com.tencent.xaction.anim;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class PhysicalWorld2$doFrame$1
  implements Runnable
{
  PhysicalWorld2$doFrame$1(PhysicalWorld2 paramPhysicalWorld2, float paramFloat) {}
  
  public final void run()
  {
    Object localObject1 = PhysicalWorld2.a(this.this$0);
    if (localObject1 != null)
    {
      if (this.a <= PhysicalWorld2.b(this.this$0)) {
        return;
      }
      PhysicalWorld2.a(this.this$0, this.a);
    }
    try
    {
      ((World)localObject1).step(0.01666667F, this.this$0.a(), this.this$0.c());
      label59:
      localObject1 = ((Map)PhysicalWorld2.c(this.this$0)).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        XARect localXARect = (XARect)((Map.Entry)localObject2).getKey();
        localObject2 = (Body)((Map.Entry)localObject2).getValue();
        if (localXARect.i() != 0.0F)
        {
          localXARect.a(PhysicalWorld2.b(this.this$0, ((Body)localObject2).getPosition().x) - localXARect.f() / 2);
          localXARect.b(PhysicalWorld2.b(this.this$0, ((Body)localObject2).getPosition().y) - localXARect.g() / 2.0F);
          localXARect.c(PhysicalWorld2.c(this.this$0, ((Body)localObject2).getAngle()) % 360.0F);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      break label59;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.anim.PhysicalWorld2.doFrame.1
 * JD-Core Version:    0.7.0.1
 */