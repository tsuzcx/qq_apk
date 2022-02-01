package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import bagt;
import bagv;
import bahc;

public class GpuImagePartsFilterGroup$1
  implements Runnable
{
  public GpuImagePartsFilterGroup$1(bahc parambahc, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    bagv localbagv1 = null;
    bagv localbagv2 = bahc.a(this.this$0);
    bahc.a(this.this$0, null);
    if ((bahc.b(this.this$0) == null) || (bahc.b(this.this$0).getFilterType() != this.a))
    {
      localbagv1 = bahc.b(this.this$0);
      bahc.b(this.this$0, (bagv)bagt.a(this.a));
      bahc.b(this.this$0).init();
      bahc.b(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    bahc.b(this.this$0).a(false, 0.0F);
    bahc.a(this.this$0, 0.0F);
    if (localbagv2 != null) {
      localbagv2.destroy();
    }
    if (localbagv1 != null) {
      localbagv1.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.1
 * JD-Core Version:    0.7.0.1
 */