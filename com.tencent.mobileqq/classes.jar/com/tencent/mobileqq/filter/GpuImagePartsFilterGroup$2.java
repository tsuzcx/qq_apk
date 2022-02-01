package com.tencent.mobileqq.filter;

class GpuImagePartsFilterGroup$2
  implements Runnable
{
  GpuImagePartsFilterGroup$2(GpuImagePartsFilterGroup paramGpuImagePartsFilterGroup, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat) {}
  
  public void run()
  {
    GPUDrawPartFilter localGPUDrawPartFilter1 = GpuImagePartsFilterGroup.a(this.this$0);
    GPUDrawPartFilter localGPUDrawPartFilter2 = null;
    if ((localGPUDrawPartFilter1 != null) && (GpuImagePartsFilterGroup.a(this.this$0).getFilterType() == this.a))
    {
      localGPUDrawPartFilter1 = null;
    }
    else
    {
      localGPUDrawPartFilter1 = GpuImagePartsFilterGroup.a(this.this$0);
      GpuImagePartsFilterGroup.a(this.this$0, (GPUDrawPartFilter)FilterFactory.a(this.a));
      GpuImagePartsFilterGroup.a(this.this$0).init();
      GpuImagePartsFilterGroup.a(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    if ((GpuImagePartsFilterGroup.b(this.this$0) == null) || (GpuImagePartsFilterGroup.b(this.this$0).getFilterType() != this.d))
    {
      localGPUDrawPartFilter2 = GpuImagePartsFilterGroup.b(this.this$0);
      GpuImagePartsFilterGroup.b(this.this$0, (GPUDrawPartFilter)FilterFactory.a(this.d));
      GpuImagePartsFilterGroup.b(this.this$0).init();
      GpuImagePartsFilterGroup.b(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    int i = this.e;
    if ((i != 90) && (i != 270))
    {
      GpuImagePartsFilterGroup.a(this.this$0).a(true);
      GpuImagePartsFilterGroup.b(this.this$0).a(true);
    }
    else
    {
      GpuImagePartsFilterGroup.a(this.this$0).a(false);
      GpuImagePartsFilterGroup.b(this.this$0).a(false);
    }
    GpuImagePartsFilterGroup.a(this.this$0).a(true, this.f + 0.1F);
    GpuImagePartsFilterGroup.b(this.this$0).a(false, this.f - 0.1F);
    if (localGPUDrawPartFilter1 != null) {
      localGPUDrawPartFilter1.destroy();
    }
    if (localGPUDrawPartFilter2 != null) {
      localGPUDrawPartFilter2.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filter.GpuImagePartsFilterGroup.2
 * JD-Core Version:    0.7.0.1
 */