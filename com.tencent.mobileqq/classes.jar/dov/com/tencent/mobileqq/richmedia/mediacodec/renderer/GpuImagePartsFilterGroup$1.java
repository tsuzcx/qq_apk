package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

class GpuImagePartsFilterGroup$1
  implements Runnable
{
  GpuImagePartsFilterGroup$1(GpuImagePartsFilterGroup paramGpuImagePartsFilterGroup, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    GPUDrawPartFilter localGPUDrawPartFilter1 = null;
    GPUDrawPartFilter localGPUDrawPartFilter2 = GpuImagePartsFilterGroup.a(this.this$0);
    GpuImagePartsFilterGroup.a(this.this$0, null);
    if ((GpuImagePartsFilterGroup.b(this.this$0) == null) || (GpuImagePartsFilterGroup.b(this.this$0).getFilterType() != this.a))
    {
      localGPUDrawPartFilter1 = GpuImagePartsFilterGroup.b(this.this$0);
      GpuImagePartsFilterGroup.b(this.this$0, (GPUDrawPartFilter)FilterFactory.a(this.a));
      GpuImagePartsFilterGroup.b(this.this$0).init();
      GpuImagePartsFilterGroup.b(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    GpuImagePartsFilterGroup.b(this.this$0).a(false, 0.0F);
    GpuImagePartsFilterGroup.a(this.this$0, 0.0F);
    if (localGPUDrawPartFilter2 != null) {
      localGPUDrawPartFilter2.destroy();
    }
    if (localGPUDrawPartFilter1 != null) {
      localGPUDrawPartFilter1.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.1
 * JD-Core Version:    0.7.0.1
 */