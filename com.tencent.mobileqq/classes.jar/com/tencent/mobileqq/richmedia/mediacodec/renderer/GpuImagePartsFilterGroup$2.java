package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import axrv;
import axrx;
import axse;

public class GpuImagePartsFilterGroup$2
  implements Runnable
{
  public GpuImagePartsFilterGroup$2(axse paramaxse, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat) {}
  
  public void run()
  {
    axrx localaxrx2 = null;
    axrx localaxrx1;
    if ((axse.a(this.this$0) == null) || (axse.a(this.this$0).getFilterType() != this.jdField_a_of_type_Int))
    {
      localaxrx1 = axse.a(this.this$0);
      axse.a(this.this$0, (axrx)axrv.a(this.jdField_a_of_type_Int));
      axse.a(this.this$0).init();
      axse.a(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    for (;;)
    {
      if ((axse.b(this.this$0) == null) || (axse.b(this.this$0).getFilterType() != this.d))
      {
        localaxrx2 = axse.b(this.this$0);
        axse.b(this.this$0, (axrx)axrv.a(this.d));
        axse.b(this.this$0).init();
        axse.b(this.this$0).onOutputSizeChanged(this.b, this.c);
      }
      if ((this.e == 90) || (this.e == 270))
      {
        axse.a(this.this$0).a(false);
        axse.b(this.this$0).a(false);
      }
      for (;;)
      {
        axse.a(this.this$0, this.jdField_a_of_type_Float);
        axse.a(this.this$0).a(true, 0.1F * 2.0F + this.jdField_a_of_type_Float);
        axse.b(this.this$0).a(false, this.jdField_a_of_type_Float);
        if (localaxrx1 != null) {
          localaxrx1.destroy();
        }
        if (localaxrx2 != null) {
          localaxrx2.destroy();
        }
        return;
        axse.a(this.this$0).a(true);
        axse.b(this.this$0).a(true);
      }
      localaxrx1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.2
 * JD-Core Version:    0.7.0.1
 */