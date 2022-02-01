package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import bbmy;
import bbna;
import bbnh;

public class GpuImagePartsFilterGroup$1
  implements Runnable
{
  public GpuImagePartsFilterGroup$1(bbnh parambbnh, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    bbna localbbna1 = null;
    bbna localbbna2 = bbnh.a(this.this$0);
    bbnh.a(this.this$0, null);
    if ((bbnh.b(this.this$0) == null) || (bbnh.b(this.this$0).getFilterType() != this.a))
    {
      localbbna1 = bbnh.b(this.this$0);
      bbnh.b(this.this$0, (bbna)bbmy.a(this.a));
      bbnh.b(this.this$0).init();
      bbnh.b(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    bbnh.b(this.this$0).a(false, 0.0F);
    bbnh.a(this.this$0, 0.0F);
    if (localbbna2 != null) {
      localbbna2.destroy();
    }
    if (localbbna1 != null) {
      localbbna1.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.1
 * JD-Core Version:    0.7.0.1
 */