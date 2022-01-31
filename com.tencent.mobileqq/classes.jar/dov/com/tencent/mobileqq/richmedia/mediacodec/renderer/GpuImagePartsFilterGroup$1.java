package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import bnnw;
import bnny;
import bnoh;

public class GpuImagePartsFilterGroup$1
  implements Runnable
{
  public GpuImagePartsFilterGroup$1(bnoh parambnoh, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    bnny localbnny1 = null;
    bnny localbnny2 = bnoh.a(this.this$0);
    bnoh.a(this.this$0, null);
    if ((bnoh.b(this.this$0) == null) || (bnoh.b(this.this$0).getFilterType() != this.a))
    {
      localbnny1 = bnoh.b(this.this$0);
      bnoh.b(this.this$0, (bnny)bnnw.a(this.a));
      bnoh.b(this.this$0).init();
      bnoh.b(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    bnoh.b(this.this$0).a(false, 0.0F);
    bnoh.a(this.this$0, 0.0F);
    if (localbnny2 != null) {
      localbnny2.destroy();
    }
    if (localbnny1 != null) {
      localbnny1.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.1
 * JD-Core Version:    0.7.0.1
 */