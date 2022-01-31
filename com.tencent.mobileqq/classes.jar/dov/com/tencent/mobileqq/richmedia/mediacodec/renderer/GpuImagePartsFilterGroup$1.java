package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import bkya;
import bkyc;
import bkyl;

public class GpuImagePartsFilterGroup$1
  implements Runnable
{
  public GpuImagePartsFilterGroup$1(bkyl parambkyl, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    bkyc localbkyc1 = null;
    bkyc localbkyc2 = bkyl.a(this.this$0);
    bkyl.a(this.this$0, null);
    if ((bkyl.b(this.this$0) == null) || (bkyl.b(this.this$0).getFilterType() != this.a))
    {
      localbkyc1 = bkyl.b(this.this$0);
      bkyl.b(this.this$0, (bkyc)bkya.a(this.a));
      bkyl.b(this.this$0).init();
      bkyl.b(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    bkyl.b(this.this$0).a(false, 0.0F);
    bkyl.a(this.this$0, 0.0F);
    if (localbkyc2 != null) {
      localbkyc2.destroy();
    }
    if (localbkyc1 != null) {
      localbkyc1.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.1
 * JD-Core Version:    0.7.0.1
 */