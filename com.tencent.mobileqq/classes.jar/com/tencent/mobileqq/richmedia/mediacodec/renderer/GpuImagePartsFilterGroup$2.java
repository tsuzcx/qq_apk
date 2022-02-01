package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import bauf;
import bauh;
import bauo;

public class GpuImagePartsFilterGroup$2
  implements Runnable
{
  public GpuImagePartsFilterGroup$2(bauo parambauo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat) {}
  
  public void run()
  {
    bauh localbauh2 = null;
    bauh localbauh1;
    if ((bauo.a(this.this$0) == null) || (bauo.a(this.this$0).getFilterType() != this.jdField_a_of_type_Int))
    {
      localbauh1 = bauo.a(this.this$0);
      bauo.a(this.this$0, (bauh)bauf.a(this.jdField_a_of_type_Int));
      bauo.a(this.this$0).init();
      bauo.a(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    for (;;)
    {
      if ((bauo.b(this.this$0) == null) || (bauo.b(this.this$0).getFilterType() != this.d))
      {
        localbauh2 = bauo.b(this.this$0);
        bauo.b(this.this$0, (bauh)bauf.a(this.d));
        bauo.b(this.this$0).init();
        bauo.b(this.this$0).onOutputSizeChanged(this.b, this.c);
      }
      if ((this.e == 90) || (this.e == 270))
      {
        bauo.a(this.this$0).a(false);
        bauo.b(this.this$0).a(false);
      }
      for (;;)
      {
        bauo.a(this.this$0, this.jdField_a_of_type_Float);
        bauo.a(this.this$0).a(true, 0.1F * 2.0F + this.jdField_a_of_type_Float);
        bauo.b(this.this$0).a(false, this.jdField_a_of_type_Float);
        if (localbauh1 != null) {
          localbauh1.destroy();
        }
        if (localbauh2 != null) {
          localbauh2.destroy();
        }
        return;
        bauo.a(this.this$0).a(true);
        bauo.b(this.this$0).a(true);
      }
      localbauh1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.2
 * JD-Core Version:    0.7.0.1
 */