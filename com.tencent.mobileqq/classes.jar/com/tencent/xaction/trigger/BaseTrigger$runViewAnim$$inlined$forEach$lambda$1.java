package com.tencent.xaction.trigger;

import android.view.View;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.data.LinkView;
import com.tencent.xaction.impl.AnimStateListener;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/xaction/trigger/BaseTrigger$runViewAnim$1$1$listener$1", "Lcom/tencent/xaction/impl/AnimStateListener;", "cancel", "", "end", "start", "XActionCore_release", "com/tencent/xaction/trigger/BaseTrigger$$special$$inlined$forEach$lambda$1"}, k=1, mv={1, 1, 16})
public final class BaseTrigger$runViewAnim$$inlined$forEach$lambda$1
  implements AnimStateListener
{
  BaseTrigger$runViewAnim$$inlined$forEach$lambda$1(IView paramIView, int paramInt, Ref.ObjectRef paramObjectRef, LinkView paramLinkView, BaseTrigger paramBaseTrigger) {}
  
  public void a() {}
  
  public void b() {}
  
  public void c()
  {
    View localView = this.a.getDecor().b();
    if (localView != null) {
      BaseTrigger.access$removeParView(this.e, this.d, localView);
    }
    this.e.getAnimStateListenerMap().remove(Integer.valueOf(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.trigger.BaseTrigger.runViewAnim..inlined.forEach.lambda.1
 * JD-Core Version:    0.7.0.1
 */