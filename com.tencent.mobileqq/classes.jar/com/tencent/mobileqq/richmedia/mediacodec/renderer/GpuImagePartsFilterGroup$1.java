package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import avzu;
import avzw;
import awad;

public class GpuImagePartsFilterGroup$1
  implements Runnable
{
  public GpuImagePartsFilterGroup$1(awad paramawad, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    avzw localavzw1 = null;
    avzw localavzw2 = awad.a(this.this$0);
    awad.a(this.this$0, null);
    if ((awad.b(this.this$0) == null) || (awad.b(this.this$0).getFilterType() != this.a))
    {
      localavzw1 = awad.b(this.this$0);
      awad.b(this.this$0, (avzw)avzu.a(this.a));
      awad.b(this.this$0).init();
      awad.b(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    awad.b(this.this$0).a(false, 0.0F);
    awad.a(this.this$0, 0.0F);
    if (localavzw2 != null) {
      localavzw2.destroy();
    }
    if (localavzw1 != null) {
      localavzw1.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.1
 * JD-Core Version:    0.7.0.1
 */