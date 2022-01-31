package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import bkya;
import bkyc;
import bkyl;

public class GpuImagePartsFilterGroup$2
  implements Runnable
{
  public GpuImagePartsFilterGroup$2(bkyl parambkyl, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat) {}
  
  public void run()
  {
    bkyc localbkyc2 = null;
    bkyc localbkyc1;
    if ((bkyl.a(this.this$0) == null) || (bkyl.a(this.this$0).getFilterType() != this.jdField_a_of_type_Int))
    {
      localbkyc1 = bkyl.a(this.this$0);
      bkyl.a(this.this$0, (bkyc)bkya.a(this.jdField_a_of_type_Int));
      bkyl.a(this.this$0).init();
      bkyl.a(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    for (;;)
    {
      if ((bkyl.b(this.this$0) == null) || (bkyl.b(this.this$0).getFilterType() != this.d))
      {
        localbkyc2 = bkyl.b(this.this$0);
        bkyl.b(this.this$0, (bkyc)bkya.a(this.d));
        bkyl.b(this.this$0).init();
        bkyl.b(this.this$0).onOutputSizeChanged(this.b, this.c);
      }
      if ((this.e == 90) || (this.e == 270))
      {
        bkyl.a(this.this$0).a(false);
        bkyl.b(this.this$0).a(false);
      }
      for (;;)
      {
        bkyl.a(this.this$0, this.jdField_a_of_type_Float);
        bkyl.a(this.this$0).a(true, this.jdField_a_of_type_Float + 0.1F);
        bkyl.b(this.this$0).a(false, this.jdField_a_of_type_Float - 0.1F);
        if (localbkyc1 != null) {
          localbkyc1.destroy();
        }
        if (localbkyc2 != null) {
          localbkyc2.destroy();
        }
        return;
        bkyl.a(this.this$0).a(true);
        bkyl.b(this.this$0).a(true);
      }
      localbkyc1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.2
 * JD-Core Version:    0.7.0.1
 */