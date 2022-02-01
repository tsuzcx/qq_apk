package com.tencent.mobileqq.kandian.biz.hippy.module;

import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.common.TKDNative2HippyEventSimpleReceiver;
import com.tencent.mtt.hippy.common.HippyMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/hippy/module/TKDCommentBizModule$hippyCommentEvent$1", "Lcom/tencent/mobileqq/kandian/biz/hippy/interfaces/receiver/common/TKDNative2HippyEventSimpleReceiver;", "jsCloseComment", "", "onFontScaleChange", "scaleFactor", "", "refreshNewAndHotData", "hippyMap", "Lcom/tencent/mtt/hippy/common/HippyMap;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class TKDCommentBizModule$hippyCommentEvent$1
  extends TKDNative2HippyEventSimpleReceiver
{
  public void jsCloseComment()
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("direction", "right");
    this.this$0.sendEventToJs("@comment:swipe", localHippyMap);
  }
  
  public void onFontScaleChange(double paramDouble)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushDouble("scaleFactor", paramDouble);
    this.this$0.sendEventToJs("@comment:onFontScaleChange", localHippyMap);
  }
  
  public void refreshNewAndHotData(@NotNull HippyMap paramHippyMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "hippyMap");
    this.this$0.sendEventToJs("@comment:refreshNewAndHot", paramHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDCommentBizModule.hippyCommentEvent.1
 * JD-Core Version:    0.7.0.1
 */