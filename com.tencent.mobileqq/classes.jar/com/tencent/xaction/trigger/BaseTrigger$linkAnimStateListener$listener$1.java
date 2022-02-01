package com.tencent.xaction.trigger;

import android.view.View;
import com.tencent.xaction.api.data.LinkView;
import com.tencent.xaction.impl.AnimStateListener;
import com.tencent.xaction.impl.FloatViewUtil;
import com.tencent.xaction.impl.FloatViewUtil.Companion;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/xaction/trigger/BaseTrigger$linkAnimStateListener$listener$1", "Lcom/tencent/xaction/impl/AnimStateListener;", "cancel", "", "end", "start", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class BaseTrigger$linkAnimStateListener$listener$1
  implements AnimStateListener
{
  BaseTrigger$linkAnimStateListener$listener$1(LinkView paramLinkView, View paramView, int paramInt) {}
  
  public void a()
  {
    FloatViewUtil.a.b(this.jdField_a_of_type_ComTencentXactionApiDataLinkView.getFloatData(), this.jdField_a_of_type_AndroidViewView);
  }
  
  public void b() {}
  
  public void c()
  {
    FloatViewUtil.a.a(this.jdField_a_of_type_ComTencentXactionApiDataLinkView.getFloatData(), this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentXactionTriggerBaseTrigger.getAnimStateListenerMap().remove(Integer.valueOf(this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.trigger.BaseTrigger.linkAnimStateListener.listener.1
 * JD-Core Version:    0.7.0.1
 */