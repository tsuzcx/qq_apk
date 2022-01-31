package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import bnnw;
import bnny;
import bnoh;

public class GpuImagePartsFilterGroup$2
  implements Runnable
{
  public GpuImagePartsFilterGroup$2(bnoh parambnoh, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat) {}
  
  public void run()
  {
    bnny localbnny2 = null;
    bnny localbnny1;
    if ((bnoh.a(this.this$0) == null) || (bnoh.a(this.this$0).getFilterType() != this.jdField_a_of_type_Int))
    {
      localbnny1 = bnoh.a(this.this$0);
      bnoh.a(this.this$0, (bnny)bnnw.a(this.jdField_a_of_type_Int));
      bnoh.a(this.this$0).init();
      bnoh.a(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    for (;;)
    {
      if ((bnoh.b(this.this$0) == null) || (bnoh.b(this.this$0).getFilterType() != this.d))
      {
        localbnny2 = bnoh.b(this.this$0);
        bnoh.b(this.this$0, (bnny)bnnw.a(this.d));
        bnoh.b(this.this$0).init();
        bnoh.b(this.this$0).onOutputSizeChanged(this.b, this.c);
      }
      if ((this.e == 90) || (this.e == 270))
      {
        bnoh.a(this.this$0).a(false);
        bnoh.b(this.this$0).a(false);
      }
      for (;;)
      {
        bnoh.a(this.this$0, this.jdField_a_of_type_Float);
        bnoh.a(this.this$0).a(true, this.jdField_a_of_type_Float + 0.1F);
        bnoh.b(this.this$0).a(false, this.jdField_a_of_type_Float - 0.1F);
        if (localbnny1 != null) {
          localbnny1.destroy();
        }
        if (localbnny2 != null) {
          localbnny2.destroy();
        }
        return;
        bnoh.a(this.this$0).a(true);
        bnoh.b(this.this$0).a(true);
      }
      localbnny1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.2
 * JD-Core Version:    0.7.0.1
 */