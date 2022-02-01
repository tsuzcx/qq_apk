package com.tencent.mobileqq.filter;

class GpuImagePartsFilterGroup$1
  implements Runnable
{
  GpuImagePartsFilterGroup$1(GpuImagePartsFilterGroup paramGpuImagePartsFilterGroup, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    GPUDrawPartFilter localGPUDrawPartFilter2 = GpuImagePartsFilterGroup.a(this.this$0);
    GpuImagePartsFilterGroup localGpuImagePartsFilterGroup = this.this$0;
    GPUDrawPartFilter localGPUDrawPartFilter1 = null;
    GpuImagePartsFilterGroup.a(localGpuImagePartsFilterGroup, null);
    if ((GpuImagePartsFilterGroup.b(this.this$0) == null) || (GpuImagePartsFilterGroup.b(this.this$0).getFilterType() != this.a))
    {
      localGPUDrawPartFilter1 = GpuImagePartsFilterGroup.b(this.this$0);
      GpuImagePartsFilterGroup.b(this.this$0, (GPUDrawPartFilter)FilterFactory.a(this.a));
      GpuImagePartsFilterGroup.b(this.this$0).init();
      GpuImagePartsFilterGroup.b(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    GpuImagePartsFilterGroup.b(this.this$0).a(false, 0.0F);
    if (localGPUDrawPartFilter2 != null) {
      localGPUDrawPartFilter2.destroy();
    }
    if (localGPUDrawPartFilter1 != null) {
      localGPUDrawPartFilter1.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filter.GpuImagePartsFilterGroup.1
 * JD-Core Version:    0.7.0.1
 */