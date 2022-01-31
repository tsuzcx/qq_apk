package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import avzw;
import avzy;
import awaf;

public class GpuImagePartsFilterGroup$2
  implements Runnable
{
  public GpuImagePartsFilterGroup$2(awaf paramawaf, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat) {}
  
  public void run()
  {
    avzy localavzy2 = null;
    avzy localavzy1;
    if ((awaf.a(this.this$0) == null) || (awaf.a(this.this$0).getFilterType() != this.jdField_a_of_type_Int))
    {
      localavzy1 = awaf.a(this.this$0);
      awaf.a(this.this$0, (avzy)avzw.a(this.jdField_a_of_type_Int));
      awaf.a(this.this$0).init();
      awaf.a(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    for (;;)
    {
      if ((awaf.b(this.this$0) == null) || (awaf.b(this.this$0).getFilterType() != this.d))
      {
        localavzy2 = awaf.b(this.this$0);
        awaf.b(this.this$0, (avzy)avzw.a(this.d));
        awaf.b(this.this$0).init();
        awaf.b(this.this$0).onOutputSizeChanged(this.b, this.c);
      }
      if ((this.e == 90) || (this.e == 270))
      {
        awaf.a(this.this$0).a(false);
        awaf.b(this.this$0).a(false);
      }
      for (;;)
      {
        awaf.a(this.this$0, this.jdField_a_of_type_Float);
        awaf.a(this.this$0).a(true, 0.1F * 2.0F + this.jdField_a_of_type_Float);
        awaf.b(this.this$0).a(false, this.jdField_a_of_type_Float);
        if (localavzy1 != null) {
          localavzy1.destroy();
        }
        if (localavzy2 != null) {
          localavzy2.destroy();
        }
        return;
        awaf.a(this.this$0).a(true);
        awaf.b(this.this$0).a(true);
      }
      localavzy1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.2
 * JD-Core Version:    0.7.0.1
 */