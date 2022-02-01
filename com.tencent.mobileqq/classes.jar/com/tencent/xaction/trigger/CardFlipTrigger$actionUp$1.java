package com.tencent.xaction.trigger;

import com.tencent.xaction.trigger.touch.VelocityTrackerHelper;
import com.tencent.xaction.trigger.touch.VelocityTrackerHelper.ScrollCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/xaction/trigger/CardFlipTrigger$actionUp$1", "Lcom/tencent/xaction/trigger/touch/VelocityTrackerHelper$ScrollCallback;", "computeScroll", "", "isEnd", "", "x", "", "y", "onVelocity", "xVelocity", "", "yVelocity", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class CardFlipTrigger$actionUp$1
  implements VelocityTrackerHelper.ScrollCallback
{
  public void a(float paramFloat1, float paramFloat2)
  {
    if (Intrinsics.areEqual(this.a.a(), "x")) {
      paramFloat1 = paramFloat2;
    }
    CardFlipTrigger localCardFlipTrigger = this.a;
    boolean bool;
    if (Math.abs(paramFloat1) >= CardFlipTrigger.a(this.a).a()) {
      bool = true;
    } else {
      bool = false;
    }
    CardFlipTrigger.a(localCardFlipTrigger, bool);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if ((CardFlipTrigger.a(this.a)) && (!paramBoolean))
    {
      if (Intrinsics.areEqual(this.a.a(), "x"))
      {
        f1 = paramInt1;
        f2 = CardFlipTrigger.a(this.a);
        CardFlipTrigger.a(this.a, true, f1 - f2);
        CardFlipTrigger.a(this.a, f1);
        return;
      }
      float f1 = paramInt2;
      float f2 = CardFlipTrigger.b(this.a);
      CardFlipTrigger.a(this.a, false, f1 - f2);
      CardFlipTrigger.b(this.a, f1);
      return;
    }
    CardFlipTrigger.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.trigger.CardFlipTrigger.actionUp.1
 * JD-Core Version:    0.7.0.1
 */