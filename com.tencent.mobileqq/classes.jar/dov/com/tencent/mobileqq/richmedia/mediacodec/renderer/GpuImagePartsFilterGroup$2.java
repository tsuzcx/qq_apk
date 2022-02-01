package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import boab;
import boad;
import boag;

public class GpuImagePartsFilterGroup$2
  implements Runnable
{
  public GpuImagePartsFilterGroup$2(boag paramboag, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat) {}
  
  public void run()
  {
    boad localboad2 = null;
    boad localboad1;
    if ((boag.a(this.this$0) == null) || (boag.a(this.this$0).getFilterType() != this.jdField_a_of_type_Int))
    {
      localboad1 = boag.a(this.this$0);
      boag.a(this.this$0, (boad)boab.a(this.jdField_a_of_type_Int));
      boag.a(this.this$0).init();
      boag.a(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    for (;;)
    {
      if ((boag.b(this.this$0) == null) || (boag.b(this.this$0).getFilterType() != this.d))
      {
        localboad2 = boag.b(this.this$0);
        boag.b(this.this$0, (boad)boab.a(this.d));
        boag.b(this.this$0).init();
        boag.b(this.this$0).onOutputSizeChanged(this.b, this.c);
      }
      if ((this.e == 90) || (this.e == 270))
      {
        boag.a(this.this$0).a(false);
        boag.b(this.this$0).a(false);
      }
      for (;;)
      {
        boag.a(this.this$0, this.jdField_a_of_type_Float);
        boag.a(this.this$0).a(true, this.jdField_a_of_type_Float + 0.1F);
        boag.b(this.this$0).a(false, this.jdField_a_of_type_Float - 0.1F);
        if (localboad1 != null) {
          localboad1.destroy();
        }
        if (localboad2 != null) {
          localboad2.destroy();
        }
        return;
        boag.a(this.this$0).a(true);
        boag.b(this.this$0).a(true);
      }
      localboad1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.2
 * JD-Core Version:    0.7.0.1
 */