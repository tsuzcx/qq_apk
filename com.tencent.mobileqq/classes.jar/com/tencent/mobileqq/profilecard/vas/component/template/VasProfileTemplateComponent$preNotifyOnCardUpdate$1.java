package com.tencent.mobileqq.profilecard.vas.component.template;

import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class VasProfileTemplateComponent$preNotifyOnCardUpdate$1
  extends Lambda
  implements Function0<Unit>
{
  VasProfileTemplateComponent$preNotifyOnCardUpdate$1(VasProfileTemplateComponent paramVasProfileTemplateComponent)
  {
    super(0);
  }
  
  public final void invoke()
  {
    if (VasProfileTemplateComponent.access$getMDelegate$p(this.this$0) != null) {
      VasProfileTemplateComponent.access$getMDelegate$p(this.this$0).notifyCardUpdate(VasProfileTemplateComponent.access$getMData$p(this.this$0).card);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.template.VasProfileTemplateComponent.preNotifyOnCardUpdate.1
 * JD-Core Version:    0.7.0.1
 */