package com.tencent.xaction.trigger;

import android.os.Build.VERSION;
import android.view.View;
import com.tencent.xaction.impl.AnimStateListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/xaction/trigger/TextTrigger$keyAnim$1", "Lcom/tencent/xaction/impl/AnimStateListener;", "cancel", "", "end", "start", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class TextTrigger$keyAnim$1
  implements AnimStateListener
{
  TextTrigger$keyAnim$1(View paramView) {}
  
  public void a() {}
  
  public void b() {}
  
  public void c()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      this.a.getForeground();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.trigger.TextTrigger.keyAnim.1
 * JD-Core Version:    0.7.0.1
 */