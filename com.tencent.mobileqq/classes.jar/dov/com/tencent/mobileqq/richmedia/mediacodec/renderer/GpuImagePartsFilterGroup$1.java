package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import bkxj;
import bkxl;
import bkxu;

public class GpuImagePartsFilterGroup$1
  implements Runnable
{
  public GpuImagePartsFilterGroup$1(bkxu parambkxu, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    bkxl localbkxl1 = null;
    bkxl localbkxl2 = bkxu.a(this.this$0);
    bkxu.a(this.this$0, null);
    if ((bkxu.b(this.this$0) == null) || (bkxu.b(this.this$0).getFilterType() != this.a))
    {
      localbkxl1 = bkxu.b(this.this$0);
      bkxu.b(this.this$0, (bkxl)bkxj.a(this.a));
      bkxu.b(this.this$0).init();
      bkxu.b(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    bkxu.b(this.this$0).a(false, 0.0F);
    bkxu.a(this.this$0, 0.0F);
    if (localbkxl2 != null) {
      localbkxl2.destroy();
    }
    if (localbkxl1 != null) {
      localbkxl1.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.1
 * JD-Core Version:    0.7.0.1
 */