package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import axwe;
import axwg;
import axwn;

public class GpuImagePartsFilterGroup$1
  implements Runnable
{
  public GpuImagePartsFilterGroup$1(axwn paramaxwn, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    axwg localaxwg1 = null;
    axwg localaxwg2 = axwn.a(this.this$0);
    axwn.a(this.this$0, null);
    if ((axwn.b(this.this$0) == null) || (axwn.b(this.this$0).getFilterType() != this.a))
    {
      localaxwg1 = axwn.b(this.this$0);
      axwn.b(this.this$0, (axwg)axwe.a(this.a));
      axwn.b(this.this$0).init();
      axwn.b(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    axwn.b(this.this$0).a(false, 0.0F);
    axwn.a(this.this$0, 0.0F);
    if (localaxwg2 != null) {
      localaxwg2.destroy();
    }
    if (localaxwg1 != null) {
      localaxwg1.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.1
 * JD-Core Version:    0.7.0.1
 */