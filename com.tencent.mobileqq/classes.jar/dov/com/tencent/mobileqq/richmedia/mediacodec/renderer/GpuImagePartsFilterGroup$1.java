package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import bppt;
import bppv;
import bppy;

public class GpuImagePartsFilterGroup$1
  implements Runnable
{
  public GpuImagePartsFilterGroup$1(bppy parambppy, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    bppv localbppv1 = null;
    bppv localbppv2 = bppy.a(this.this$0);
    bppy.a(this.this$0, null);
    if ((bppy.b(this.this$0) == null) || (bppy.b(this.this$0).getFilterType() != this.a))
    {
      localbppv1 = bppy.b(this.this$0);
      bppy.b(this.this$0, (bppv)bppt.a(this.a));
      bppy.b(this.this$0).init();
      bppy.b(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    bppy.b(this.this$0).a(false, 0.0F);
    bppy.a(this.this$0, 0.0F);
    if (localbppv2 != null) {
      localbppv2.destroy();
    }
    if (localbppv1 != null) {
      localbppv1.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.1
 * JD-Core Version:    0.7.0.1
 */