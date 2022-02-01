package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import brgb;
import brgd;
import brgm;

public class GpuImagePartsFilterGroup$1
  implements Runnable
{
  public GpuImagePartsFilterGroup$1(brgm parambrgm, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    brgd localbrgd1 = null;
    brgd localbrgd2 = brgm.a(this.this$0);
    brgm.a(this.this$0, null);
    if ((brgm.b(this.this$0) == null) || (brgm.b(this.this$0).getFilterType() != this.a))
    {
      localbrgd1 = brgm.b(this.this$0);
      brgm.b(this.this$0, (brgd)brgb.a(this.a));
      brgm.b(this.this$0).init();
      brgm.b(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    brgm.b(this.this$0).a(false, 0.0F);
    brgm.a(this.this$0, 0.0F);
    if (localbrgd2 != null) {
      localbrgd2.destroy();
    }
    if (localbrgd1 != null) {
      localbrgd1.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.1
 * JD-Core Version:    0.7.0.1
 */