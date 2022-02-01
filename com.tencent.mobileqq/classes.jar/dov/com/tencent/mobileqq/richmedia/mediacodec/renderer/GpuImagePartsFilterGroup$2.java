package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import bqeq;
import bqes;
import bqfb;

public class GpuImagePartsFilterGroup$2
  implements Runnable
{
  public GpuImagePartsFilterGroup$2(bqfb parambqfb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat) {}
  
  public void run()
  {
    bqes localbqes2 = null;
    bqes localbqes1;
    if ((bqfb.a(this.this$0) == null) || (bqfb.a(this.this$0).getFilterType() != this.jdField_a_of_type_Int))
    {
      localbqes1 = bqfb.a(this.this$0);
      bqfb.a(this.this$0, (bqes)bqeq.a(this.jdField_a_of_type_Int));
      bqfb.a(this.this$0).init();
      bqfb.a(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    for (;;)
    {
      if ((bqfb.b(this.this$0) == null) || (bqfb.b(this.this$0).getFilterType() != this.d))
      {
        localbqes2 = bqfb.b(this.this$0);
        bqfb.b(this.this$0, (bqes)bqeq.a(this.d));
        bqfb.b(this.this$0).init();
        bqfb.b(this.this$0).onOutputSizeChanged(this.b, this.c);
      }
      if ((this.e == 90) || (this.e == 270))
      {
        bqfb.a(this.this$0).a(false);
        bqfb.b(this.this$0).a(false);
      }
      for (;;)
      {
        bqfb.a(this.this$0, this.jdField_a_of_type_Float);
        bqfb.a(this.this$0).a(true, this.jdField_a_of_type_Float + 0.1F);
        bqfb.b(this.this$0).a(false, this.jdField_a_of_type_Float - 0.1F);
        if (localbqes1 != null) {
          localbqes1.destroy();
        }
        if (localbqes2 != null) {
          localbqes2.destroy();
        }
        return;
        bqfb.a(this.this$0).a(true);
        bqfb.b(this.this$0).a(true);
      }
      localbqes1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.2
 * JD-Core Version:    0.7.0.1
 */