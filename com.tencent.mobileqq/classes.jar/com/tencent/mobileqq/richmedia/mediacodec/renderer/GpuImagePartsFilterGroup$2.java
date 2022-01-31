package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import avab;
import avad;
import avak;

public class GpuImagePartsFilterGroup$2
  implements Runnable
{
  public GpuImagePartsFilterGroup$2(avak paramavak, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat) {}
  
  public void run()
  {
    avad localavad2 = null;
    avad localavad1;
    if ((avak.a(this.this$0) == null) || (avak.a(this.this$0).getFilterType() != this.jdField_a_of_type_Int))
    {
      localavad1 = avak.a(this.this$0);
      avak.a(this.this$0, (avad)avab.a(this.jdField_a_of_type_Int));
      avak.a(this.this$0).init();
      avak.a(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    for (;;)
    {
      if ((avak.b(this.this$0) == null) || (avak.b(this.this$0).getFilterType() != this.d))
      {
        localavad2 = avak.b(this.this$0);
        avak.b(this.this$0, (avad)avab.a(this.d));
        avak.b(this.this$0).init();
        avak.b(this.this$0).onOutputSizeChanged(this.b, this.c);
      }
      if ((this.e == 90) || (this.e == 270))
      {
        avak.a(this.this$0).a(false);
        avak.b(this.this$0).a(false);
      }
      for (;;)
      {
        avak.a(this.this$0, this.jdField_a_of_type_Float);
        avak.a(this.this$0).a(true, 0.1F * 2.0F + this.jdField_a_of_type_Float);
        avak.b(this.this$0).a(false, this.jdField_a_of_type_Float);
        if (localavad1 != null) {
          localavad1.destroy();
        }
        if (localavad2 != null) {
          localavad2.destroy();
        }
        return;
        avak.a(this.this$0).a(true);
        avak.b(this.this$0).a(true);
      }
      localavad1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.2
 * JD-Core Version:    0.7.0.1
 */