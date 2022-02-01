package com.tencent.mobileqq.kandian.biz.viola.contract;

import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/contract/ViolaFragmentCommonLogicContract;", "Lcom/tencent/mobileqq/kandian/biz/viola/contract/IViolaFragmentCommonContract;", "()V", "scene", "", "onScrollStateChange", "", "state", "", "openFrameDropUpload", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ViolaFragmentCommonLogicContract
  implements IViolaFragmentCommonContract
{
  private String a;
  
  public final void a(int paramInt)
  {
    String str = this.a;
    if (str != null)
    {
      if (paramInt == 0)
      {
        DropFrameMonitor.a().a(str, false);
        return;
      }
      DropFrameMonitor.a().a(str);
    }
  }
  
  public void openFrameDropUpload(@Nullable String paramString)
  {
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.contract.ViolaFragmentCommonLogicContract
 * JD-Core Version:    0.7.0.1
 */