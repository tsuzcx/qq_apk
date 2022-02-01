package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import bbni;
import bbnk;
import bbnr;

public class GpuImagePartsFilterGroup$2
  implements Runnable
{
  public GpuImagePartsFilterGroup$2(bbnr parambbnr, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat) {}
  
  public void run()
  {
    bbnk localbbnk2 = null;
    bbnk localbbnk1;
    if ((bbnr.a(this.this$0) == null) || (bbnr.a(this.this$0).getFilterType() != this.jdField_a_of_type_Int))
    {
      localbbnk1 = bbnr.a(this.this$0);
      bbnr.a(this.this$0, (bbnk)bbni.a(this.jdField_a_of_type_Int));
      bbnr.a(this.this$0).init();
      bbnr.a(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    for (;;)
    {
      if ((bbnr.b(this.this$0) == null) || (bbnr.b(this.this$0).getFilterType() != this.d))
      {
        localbbnk2 = bbnr.b(this.this$0);
        bbnr.b(this.this$0, (bbnk)bbni.a(this.d));
        bbnr.b(this.this$0).init();
        bbnr.b(this.this$0).onOutputSizeChanged(this.b, this.c);
      }
      if ((this.e == 90) || (this.e == 270))
      {
        bbnr.a(this.this$0).a(false);
        bbnr.b(this.this$0).a(false);
      }
      for (;;)
      {
        bbnr.a(this.this$0, this.jdField_a_of_type_Float);
        bbnr.a(this.this$0).a(true, 0.1F * 2.0F + this.jdField_a_of_type_Float);
        bbnr.b(this.this$0).a(false, this.jdField_a_of_type_Float);
        if (localbbnk1 != null) {
          localbbnk1.destroy();
        }
        if (localbbnk2 != null) {
          localbbnk2.destroy();
        }
        return;
        bbnr.a(this.this$0).a(true);
        bbnr.b(this.this$0).a(true);
      }
      localbbnk1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.2
 * JD-Core Version:    0.7.0.1
 */