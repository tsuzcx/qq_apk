package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import bbni;
import bbnk;
import bbnr;

public class GpuImagePartsFilterGroup$1
  implements Runnable
{
  public GpuImagePartsFilterGroup$1(bbnr parambbnr, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    bbnk localbbnk1 = null;
    bbnk localbbnk2 = bbnr.a(this.this$0);
    bbnr.a(this.this$0, null);
    if ((bbnr.b(this.this$0) == null) || (bbnr.b(this.this$0).getFilterType() != this.a))
    {
      localbbnk1 = bbnr.b(this.this$0);
      bbnr.b(this.this$0, (bbnk)bbni.a(this.a));
      bbnr.b(this.this$0).init();
      bbnr.b(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    bbnr.b(this.this$0).a(false, 0.0F);
    bbnr.a(this.this$0, 0.0F);
    if (localbbnk2 != null) {
      localbbnk2.destroy();
    }
    if (localbbnk1 != null) {
      localbbnk1.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.1
 * JD-Core Version:    0.7.0.1
 */