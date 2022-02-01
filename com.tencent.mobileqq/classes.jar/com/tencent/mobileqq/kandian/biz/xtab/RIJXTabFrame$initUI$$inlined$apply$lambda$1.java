package com.tencent.mobileqq.kandian.biz.xtab;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke", "com/tencent/mobileqq/kandian/biz/xtab/RIJXTabFrame$initUI$entryViewBridge$1$1"}, k=3, mv={1, 1, 16})
final class RIJXTabFrame$initUI$$inlined$apply$lambda$1
  extends Lambda
  implements Function0<Unit>
{
  RIJXTabFrame$initUI$$inlined$apply$lambda$1(RIJXTabFrame paramRIJXTabFrame)
  {
    super(0);
  }
  
  public final void invoke()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RIJXTabFrame", 2, "onClick for removeGuidePopView");
    }
    UgcPublishUserGuideController localUgcPublishUserGuideController = RIJXTabFrame.a(this.this$0);
    if (localUgcPublishUserGuideController != null) {
      localUgcPublishUserGuideController.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabFrame.initUI..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */