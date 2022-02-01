package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import bqeq;
import bqes;
import bqfb;

public class GpuImagePartsFilterGroup$1
  implements Runnable
{
  public GpuImagePartsFilterGroup$1(bqfb parambqfb, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    bqes localbqes1 = null;
    bqes localbqes2 = bqfb.a(this.this$0);
    bqfb.a(this.this$0, null);
    if ((bqfb.b(this.this$0) == null) || (bqfb.b(this.this$0).getFilterType() != this.a))
    {
      localbqes1 = bqfb.b(this.this$0);
      bqfb.b(this.this$0, (bqes)bqeq.a(this.a));
      bqfb.b(this.this$0).init();
      bqfb.b(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    bqfb.b(this.this$0).a(false, 0.0F);
    bqfb.a(this.this$0, 0.0F);
    if (localbqes2 != null) {
      localbqes2.destroy();
    }
    if (localbqes1 != null) {
      localbqes1.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.1
 * JD-Core Version:    0.7.0.1
 */