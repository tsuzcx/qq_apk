package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import bkxj;
import bkxl;
import bkxu;

public class GpuImagePartsFilterGroup$2
  implements Runnable
{
  public GpuImagePartsFilterGroup$2(bkxu parambkxu, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat) {}
  
  public void run()
  {
    bkxl localbkxl2 = null;
    bkxl localbkxl1;
    if ((bkxu.a(this.this$0) == null) || (bkxu.a(this.this$0).getFilterType() != this.jdField_a_of_type_Int))
    {
      localbkxl1 = bkxu.a(this.this$0);
      bkxu.a(this.this$0, (bkxl)bkxj.a(this.jdField_a_of_type_Int));
      bkxu.a(this.this$0).init();
      bkxu.a(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    for (;;)
    {
      if ((bkxu.b(this.this$0) == null) || (bkxu.b(this.this$0).getFilterType() != this.d))
      {
        localbkxl2 = bkxu.b(this.this$0);
        bkxu.b(this.this$0, (bkxl)bkxj.a(this.d));
        bkxu.b(this.this$0).init();
        bkxu.b(this.this$0).onOutputSizeChanged(this.b, this.c);
      }
      if ((this.e == 90) || (this.e == 270))
      {
        bkxu.a(this.this$0).a(false);
        bkxu.b(this.this$0).a(false);
      }
      for (;;)
      {
        bkxu.a(this.this$0, this.jdField_a_of_type_Float);
        bkxu.a(this.this$0).a(true, this.jdField_a_of_type_Float + 0.1F);
        bkxu.b(this.this$0).a(false, this.jdField_a_of_type_Float - 0.1F);
        if (localbkxl1 != null) {
          localbkxl1.destroy();
        }
        if (localbkxl2 != null) {
          localbkxl2.destroy();
        }
        return;
        bkxu.a(this.this$0).a(true);
        bkxu.b(this.this$0).a(true);
      }
      localbkxl1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.2
 * JD-Core Version:    0.7.0.1
 */