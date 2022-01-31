package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import bnjk;
import bnjm;
import bnjv;

public class GpuImagePartsFilterGroup$1
  implements Runnable
{
  public GpuImagePartsFilterGroup$1(bnjv parambnjv, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    bnjm localbnjm1 = null;
    bnjm localbnjm2 = bnjv.a(this.this$0);
    bnjv.a(this.this$0, null);
    if ((bnjv.b(this.this$0) == null) || (bnjv.b(this.this$0).getFilterType() != this.a))
    {
      localbnjm1 = bnjv.b(this.this$0);
      bnjv.b(this.this$0, (bnjm)bnjk.a(this.a));
      bnjv.b(this.this$0).init();
      bnjv.b(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    bnjv.b(this.this$0).a(false, 0.0F);
    bnjv.a(this.this$0, 0.0F);
    if (localbnjm2 != null) {
      localbnjm2.destroy();
    }
    if (localbnjm1 != null) {
      localbnjm1.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.1
 * JD-Core Version:    0.7.0.1
 */