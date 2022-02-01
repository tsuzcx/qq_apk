package com.tencent.mobileqq.vas.adv.base.support;

import com.tencent.mobileqq.vas.adv.base.support.gdt.VasAdvGdtInterface;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VasAdvSupport$initDeviceInfo$1
  implements Runnable
{
  VasAdvSupport$initDeviceInfo$1(VasAdvSupport paramVasAdvSupport, String paramString) {}
  
  public final void run()
  {
    VasAdvGdtInterface localVasAdvGdtInterface = VasAdvSupport.a(this.this$0);
    String str = this.a;
    if (str == null) {
      str = this.this$0.a();
    }
    localVasAdvGdtInterface.a(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport.initDeviceInfo.1
 * JD-Core Version:    0.7.0.1
 */