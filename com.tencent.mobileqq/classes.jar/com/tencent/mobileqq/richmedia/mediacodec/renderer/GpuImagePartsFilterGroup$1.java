package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import avab;
import avad;
import avak;

public class GpuImagePartsFilterGroup$1
  implements Runnable
{
  public GpuImagePartsFilterGroup$1(avak paramavak, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    avad localavad1 = null;
    avad localavad2 = avak.a(this.this$0);
    avak.a(this.this$0, null);
    if ((avak.b(this.this$0) == null) || (avak.b(this.this$0).getFilterType() != this.a))
    {
      localavad1 = avak.b(this.this$0);
      avak.b(this.this$0, (avad)avab.a(this.a));
      avak.b(this.this$0).init();
      avak.b(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    avak.b(this.this$0).a(false, 0.0F);
    avak.a(this.this$0, 0.0F);
    if (localavad2 != null) {
      localavad2.destroy();
    }
    if (localavad1 != null) {
      localavad1.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.1
 * JD-Core Version:    0.7.0.1
 */