package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import bauf;
import bauh;
import bauo;

public class GpuImagePartsFilterGroup$1
  implements Runnable
{
  public GpuImagePartsFilterGroup$1(bauo parambauo, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    bauh localbauh1 = null;
    bauh localbauh2 = bauo.a(this.this$0);
    bauo.a(this.this$0, null);
    if ((bauo.b(this.this$0) == null) || (bauo.b(this.this$0).getFilterType() != this.a))
    {
      localbauh1 = bauo.b(this.this$0);
      bauo.b(this.this$0, (bauh)bauf.a(this.a));
      bauo.b(this.this$0).init();
      bauo.b(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    bauo.b(this.this$0).a(false, 0.0F);
    bauo.a(this.this$0, 0.0F);
    if (localbauh2 != null) {
      localbauh2.destroy();
    }
    if (localbauh1 != null) {
      localbauh1.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.1
 * JD-Core Version:    0.7.0.1
 */