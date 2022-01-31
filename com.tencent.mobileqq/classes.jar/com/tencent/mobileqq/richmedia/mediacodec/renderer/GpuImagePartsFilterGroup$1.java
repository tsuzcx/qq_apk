package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import avzw;
import avzy;
import awaf;

public class GpuImagePartsFilterGroup$1
  implements Runnable
{
  public GpuImagePartsFilterGroup$1(awaf paramawaf, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    avzy localavzy1 = null;
    avzy localavzy2 = awaf.a(this.this$0);
    awaf.a(this.this$0, null);
    if ((awaf.b(this.this$0) == null) || (awaf.b(this.this$0).getFilterType() != this.a))
    {
      localavzy1 = awaf.b(this.this$0);
      awaf.b(this.this$0, (avzy)avzw.a(this.a));
      awaf.b(this.this$0).init();
      awaf.b(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    awaf.b(this.this$0).a(false, 0.0F);
    awaf.a(this.this$0, 0.0F);
    if (localavzy2 != null) {
      localavzy2.destroy();
    }
    if (localavzy1 != null) {
      localavzy1.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.1
 * JD-Core Version:    0.7.0.1
 */