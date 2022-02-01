package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import bagt;
import bagv;
import bahc;

public class GpuImagePartsFilterGroup$2
  implements Runnable
{
  public GpuImagePartsFilterGroup$2(bahc parambahc, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat) {}
  
  public void run()
  {
    bagv localbagv2 = null;
    bagv localbagv1;
    if ((bahc.a(this.this$0) == null) || (bahc.a(this.this$0).getFilterType() != this.jdField_a_of_type_Int))
    {
      localbagv1 = bahc.a(this.this$0);
      bahc.a(this.this$0, (bagv)bagt.a(this.jdField_a_of_type_Int));
      bahc.a(this.this$0).init();
      bahc.a(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    for (;;)
    {
      if ((bahc.b(this.this$0) == null) || (bahc.b(this.this$0).getFilterType() != this.d))
      {
        localbagv2 = bahc.b(this.this$0);
        bahc.b(this.this$0, (bagv)bagt.a(this.d));
        bahc.b(this.this$0).init();
        bahc.b(this.this$0).onOutputSizeChanged(this.b, this.c);
      }
      if ((this.e == 90) || (this.e == 270))
      {
        bahc.a(this.this$0).a(false);
        bahc.b(this.this$0).a(false);
      }
      for (;;)
      {
        bahc.a(this.this$0, this.jdField_a_of_type_Float);
        bahc.a(this.this$0).a(true, 0.1F * 2.0F + this.jdField_a_of_type_Float);
        bahc.b(this.this$0).a(false, this.jdField_a_of_type_Float);
        if (localbagv1 != null) {
          localbagv1.destroy();
        }
        if (localbagv2 != null) {
          localbagv2.destroy();
        }
        return;
        bahc.a(this.this$0).a(true);
        bahc.b(this.this$0).a(true);
      }
      localbagv1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.2
 * JD-Core Version:    0.7.0.1
 */