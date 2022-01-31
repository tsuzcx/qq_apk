package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import axrv;
import axrx;
import axse;

public class GpuImagePartsFilterGroup$1
  implements Runnable
{
  public GpuImagePartsFilterGroup$1(axse paramaxse, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    axrx localaxrx1 = null;
    axrx localaxrx2 = axse.a(this.this$0);
    axse.a(this.this$0, null);
    if ((axse.b(this.this$0) == null) || (axse.b(this.this$0).getFilterType() != this.a))
    {
      localaxrx1 = axse.b(this.this$0);
      axse.b(this.this$0, (axrx)axrv.a(this.a));
      axse.b(this.this$0).init();
      axse.b(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    axse.b(this.this$0).a(false, 0.0F);
    axse.a(this.this$0, 0.0F);
    if (localaxrx2 != null) {
      localaxrx2.destroy();
    }
    if (localaxrx1 != null) {
      localaxrx1.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.1
 * JD-Core Version:    0.7.0.1
 */