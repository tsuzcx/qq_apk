package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import bbmy;
import bbna;
import bbnh;

public class GpuImagePartsFilterGroup$2
  implements Runnable
{
  public GpuImagePartsFilterGroup$2(bbnh parambbnh, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat) {}
  
  public void run()
  {
    bbna localbbna2 = null;
    bbna localbbna1;
    if ((bbnh.a(this.this$0) == null) || (bbnh.a(this.this$0).getFilterType() != this.jdField_a_of_type_Int))
    {
      localbbna1 = bbnh.a(this.this$0);
      bbnh.a(this.this$0, (bbna)bbmy.a(this.jdField_a_of_type_Int));
      bbnh.a(this.this$0).init();
      bbnh.a(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    for (;;)
    {
      if ((bbnh.b(this.this$0) == null) || (bbnh.b(this.this$0).getFilterType() != this.d))
      {
        localbbna2 = bbnh.b(this.this$0);
        bbnh.b(this.this$0, (bbna)bbmy.a(this.d));
        bbnh.b(this.this$0).init();
        bbnh.b(this.this$0).onOutputSizeChanged(this.b, this.c);
      }
      if ((this.e == 90) || (this.e == 270))
      {
        bbnh.a(this.this$0).a(false);
        bbnh.b(this.this$0).a(false);
      }
      for (;;)
      {
        bbnh.a(this.this$0, this.jdField_a_of_type_Float);
        bbnh.a(this.this$0).a(true, 0.1F * 2.0F + this.jdField_a_of_type_Float);
        bbnh.b(this.this$0).a(false, this.jdField_a_of_type_Float);
        if (localbbna1 != null) {
          localbbna1.destroy();
        }
        if (localbbna2 != null) {
          localbbna2.destroy();
        }
        return;
        bbnh.a(this.this$0).a(true);
        bbnh.b(this.this$0).a(true);
      }
      localbbna1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.2
 * JD-Core Version:    0.7.0.1
 */