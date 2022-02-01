package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import bppt;
import bppv;
import bppy;

public class GpuImagePartsFilterGroup$2
  implements Runnable
{
  public GpuImagePartsFilterGroup$2(bppy parambppy, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat) {}
  
  public void run()
  {
    bppv localbppv2 = null;
    bppv localbppv1;
    if ((bppy.a(this.this$0) == null) || (bppy.a(this.this$0).getFilterType() != this.jdField_a_of_type_Int))
    {
      localbppv1 = bppy.a(this.this$0);
      bppy.a(this.this$0, (bppv)bppt.a(this.jdField_a_of_type_Int));
      bppy.a(this.this$0).init();
      bppy.a(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    for (;;)
    {
      if ((bppy.b(this.this$0) == null) || (bppy.b(this.this$0).getFilterType() != this.d))
      {
        localbppv2 = bppy.b(this.this$0);
        bppy.b(this.this$0, (bppv)bppt.a(this.d));
        bppy.b(this.this$0).init();
        bppy.b(this.this$0).onOutputSizeChanged(this.b, this.c);
      }
      if ((this.e == 90) || (this.e == 270))
      {
        bppy.a(this.this$0).a(false);
        bppy.b(this.this$0).a(false);
      }
      for (;;)
      {
        bppy.a(this.this$0, this.jdField_a_of_type_Float);
        bppy.a(this.this$0).a(true, this.jdField_a_of_type_Float + 0.1F);
        bppy.b(this.this$0).a(false, this.jdField_a_of_type_Float - 0.1F);
        if (localbppv1 != null) {
          localbppv1.destroy();
        }
        if (localbppv2 != null) {
          localbppv2.destroy();
        }
        return;
        bppy.a(this.this$0).a(true);
        bppy.b(this.this$0).a(true);
      }
      localbppv1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.2
 * JD-Core Version:    0.7.0.1
 */