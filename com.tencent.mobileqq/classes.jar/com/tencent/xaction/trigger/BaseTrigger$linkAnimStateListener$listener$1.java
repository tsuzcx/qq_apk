package com.tencent.xaction.trigger;

import android.view.View;
import com.tencent.xaction.api.data.FloatViewData;
import com.tencent.xaction.impl.AnimStateListener;
import com.tencent.xaction.impl.FloatViewUtil;
import com.tencent.xaction.impl.FloatViewUtil.Companion;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/xaction/trigger/BaseTrigger$linkAnimStateListener$listener$1", "Lcom/tencent/xaction/impl/AnimStateListener;", "cancel", "", "end", "start", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class BaseTrigger$linkAnimStateListener$listener$1
  implements AnimStateListener
{
  BaseTrigger$linkAnimStateListener$listener$1(FloatViewData paramFloatViewData, View paramView, int paramInt) {}
  
  public void a()
  {
    FloatViewUtil.a.b(this.b, this.c);
  }
  
  public void b() {}
  
  public void c()
  {
    FloatViewUtil.a.a(this.b, this.c);
    this.a.getAnimStateListenerMap().remove(Integer.valueOf(this.d));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.trigger.BaseTrigger.linkAnimStateListener.listener.1
 * JD-Core Version:    0.7.0.1
 */