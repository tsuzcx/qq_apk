package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import boab;
import boad;
import boag;

public class GpuImagePartsFilterGroup$1
  implements Runnable
{
  public GpuImagePartsFilterGroup$1(boag paramboag, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    boad localboad1 = null;
    boad localboad2 = boag.a(this.this$0);
    boag.a(this.this$0, null);
    if ((boag.b(this.this$0) == null) || (boag.b(this.this$0).getFilterType() != this.a))
    {
      localboad1 = boag.b(this.this$0);
      boag.b(this.this$0, (boad)boab.a(this.a));
      boag.b(this.this$0).init();
      boag.b(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    boag.b(this.this$0).a(false, 0.0F);
    boag.a(this.this$0, 0.0F);
    if (localboad2 != null) {
      localboad2.destroy();
    }
    if (localboad1 != null) {
      localboad1.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.1
 * JD-Core Version:    0.7.0.1
 */