package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import axwe;
import axwg;
import axwn;

public class GpuImagePartsFilterGroup$2
  implements Runnable
{
  public GpuImagePartsFilterGroup$2(axwn paramaxwn, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat) {}
  
  public void run()
  {
    axwg localaxwg2 = null;
    axwg localaxwg1;
    if ((axwn.a(this.this$0) == null) || (axwn.a(this.this$0).getFilterType() != this.jdField_a_of_type_Int))
    {
      localaxwg1 = axwn.a(this.this$0);
      axwn.a(this.this$0, (axwg)axwe.a(this.jdField_a_of_type_Int));
      axwn.a(this.this$0).init();
      axwn.a(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    for (;;)
    {
      if ((axwn.b(this.this$0) == null) || (axwn.b(this.this$0).getFilterType() != this.d))
      {
        localaxwg2 = axwn.b(this.this$0);
        axwn.b(this.this$0, (axwg)axwe.a(this.d));
        axwn.b(this.this$0).init();
        axwn.b(this.this$0).onOutputSizeChanged(this.b, this.c);
      }
      if ((this.e == 90) || (this.e == 270))
      {
        axwn.a(this.this$0).a(false);
        axwn.b(this.this$0).a(false);
      }
      for (;;)
      {
        axwn.a(this.this$0, this.jdField_a_of_type_Float);
        axwn.a(this.this$0).a(true, 0.1F * 2.0F + this.jdField_a_of_type_Float);
        axwn.b(this.this$0).a(false, this.jdField_a_of_type_Float);
        if (localaxwg1 != null) {
          localaxwg1.destroy();
        }
        if (localaxwg2 != null) {
          localaxwg2.destroy();
        }
        return;
        axwn.a(this.this$0).a(true);
        axwn.b(this.this$0).a(true);
      }
      localaxwg1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.2
 * JD-Core Version:    0.7.0.1
 */