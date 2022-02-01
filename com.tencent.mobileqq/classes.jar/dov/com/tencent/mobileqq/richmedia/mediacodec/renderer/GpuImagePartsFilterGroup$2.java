package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import brgb;
import brgd;
import brgm;

public class GpuImagePartsFilterGroup$2
  implements Runnable
{
  public GpuImagePartsFilterGroup$2(brgm parambrgm, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat) {}
  
  public void run()
  {
    brgd localbrgd2 = null;
    brgd localbrgd1;
    if ((brgm.a(this.this$0) == null) || (brgm.a(this.this$0).getFilterType() != this.jdField_a_of_type_Int))
    {
      localbrgd1 = brgm.a(this.this$0);
      brgm.a(this.this$0, (brgd)brgb.a(this.jdField_a_of_type_Int));
      brgm.a(this.this$0).init();
      brgm.a(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    for (;;)
    {
      if ((brgm.b(this.this$0) == null) || (brgm.b(this.this$0).getFilterType() != this.d))
      {
        localbrgd2 = brgm.b(this.this$0);
        brgm.b(this.this$0, (brgd)brgb.a(this.d));
        brgm.b(this.this$0).init();
        brgm.b(this.this$0).onOutputSizeChanged(this.b, this.c);
      }
      if ((this.e == 90) || (this.e == 270))
      {
        brgm.a(this.this$0).a(false);
        brgm.b(this.this$0).a(false);
      }
      for (;;)
      {
        brgm.a(this.this$0, this.jdField_a_of_type_Float);
        brgm.a(this.this$0).a(true, this.jdField_a_of_type_Float + 0.1F);
        brgm.b(this.this$0).a(false, this.jdField_a_of_type_Float - 0.1F);
        if (localbrgd1 != null) {
          localbrgd1.destroy();
        }
        if (localbrgd2 != null) {
          localbrgd2.destroy();
        }
        return;
        brgm.a(this.this$0).a(true);
        brgm.b(this.this$0).a(true);
      }
      localbrgd1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.2
 * JD-Core Version:    0.7.0.1
 */