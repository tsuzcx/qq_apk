package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import bnjk;
import bnjm;
import bnjv;

public class GpuImagePartsFilterGroup$2
  implements Runnable
{
  public GpuImagePartsFilterGroup$2(bnjv parambnjv, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat) {}
  
  public void run()
  {
    bnjm localbnjm2 = null;
    bnjm localbnjm1;
    if ((bnjv.a(this.this$0) == null) || (bnjv.a(this.this$0).getFilterType() != this.jdField_a_of_type_Int))
    {
      localbnjm1 = bnjv.a(this.this$0);
      bnjv.a(this.this$0, (bnjm)bnjk.a(this.jdField_a_of_type_Int));
      bnjv.a(this.this$0).init();
      bnjv.a(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    for (;;)
    {
      if ((bnjv.b(this.this$0) == null) || (bnjv.b(this.this$0).getFilterType() != this.d))
      {
        localbnjm2 = bnjv.b(this.this$0);
        bnjv.b(this.this$0, (bnjm)bnjk.a(this.d));
        bnjv.b(this.this$0).init();
        bnjv.b(this.this$0).onOutputSizeChanged(this.b, this.c);
      }
      if ((this.e == 90) || (this.e == 270))
      {
        bnjv.a(this.this$0).a(false);
        bnjv.b(this.this$0).a(false);
      }
      for (;;)
      {
        bnjv.a(this.this$0, this.jdField_a_of_type_Float);
        bnjv.a(this.this$0).a(true, this.jdField_a_of_type_Float + 0.1F);
        bnjv.b(this.this$0).a(false, this.jdField_a_of_type_Float - 0.1F);
        if (localbnjm1 != null) {
          localbnjm1.destroy();
        }
        if (localbnjm2 != null) {
          localbnjm2.destroy();
        }
        return;
        bnjv.a(this.this$0).a(true);
        bnjv.b(this.this$0).a(true);
      }
      localbnjm1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.2
 * JD-Core Version:    0.7.0.1
 */