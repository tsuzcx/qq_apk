package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import avzu;
import avzw;
import awad;

public class GpuImagePartsFilterGroup$2
  implements Runnable
{
  public GpuImagePartsFilterGroup$2(awad paramawad, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat) {}
  
  public void run()
  {
    avzw localavzw2 = null;
    avzw localavzw1;
    if ((awad.a(this.this$0) == null) || (awad.a(this.this$0).getFilterType() != this.jdField_a_of_type_Int))
    {
      localavzw1 = awad.a(this.this$0);
      awad.a(this.this$0, (avzw)avzu.a(this.jdField_a_of_type_Int));
      awad.a(this.this$0).init();
      awad.a(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    for (;;)
    {
      if ((awad.b(this.this$0) == null) || (awad.b(this.this$0).getFilterType() != this.d))
      {
        localavzw2 = awad.b(this.this$0);
        awad.b(this.this$0, (avzw)avzu.a(this.d));
        awad.b(this.this$0).init();
        awad.b(this.this$0).onOutputSizeChanged(this.b, this.c);
      }
      if ((this.e == 90) || (this.e == 270))
      {
        awad.a(this.this$0).a(false);
        awad.b(this.this$0).a(false);
      }
      for (;;)
      {
        awad.a(this.this$0, this.jdField_a_of_type_Float);
        awad.a(this.this$0).a(true, 0.1F * 2.0F + this.jdField_a_of_type_Float);
        awad.b(this.this$0).a(false, this.jdField_a_of_type_Float);
        if (localavzw1 != null) {
          localavzw1.destroy();
        }
        if (localavzw2 != null) {
          localavzw2.destroy();
        }
        return;
        awad.a(this.this$0).a(true);
        awad.b(this.this$0).a(true);
      }
      localavzw1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.2
 * JD-Core Version:    0.7.0.1
 */