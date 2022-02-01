package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

class GpuImagePartsFilterGroup$2
  implements Runnable
{
  GpuImagePartsFilterGroup$2(GpuImagePartsFilterGroup paramGpuImagePartsFilterGroup, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat) {}
  
  public void run()
  {
    GPUDrawPartFilter localGPUDrawPartFilter2 = null;
    GPUDrawPartFilter localGPUDrawPartFilter1;
    if ((GpuImagePartsFilterGroup.a(this.this$0) == null) || (GpuImagePartsFilterGroup.a(this.this$0).getFilterType() != this.jdField_a_of_type_Int))
    {
      localGPUDrawPartFilter1 = GpuImagePartsFilterGroup.a(this.this$0);
      GpuImagePartsFilterGroup.a(this.this$0, (GPUDrawPartFilter)FilterFactory.a(this.jdField_a_of_type_Int));
      GpuImagePartsFilterGroup.a(this.this$0).init();
      GpuImagePartsFilterGroup.a(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    for (;;)
    {
      if ((GpuImagePartsFilterGroup.b(this.this$0) == null) || (GpuImagePartsFilterGroup.b(this.this$0).getFilterType() != this.d))
      {
        localGPUDrawPartFilter2 = GpuImagePartsFilterGroup.b(this.this$0);
        GpuImagePartsFilterGroup.b(this.this$0, (GPUDrawPartFilter)FilterFactory.a(this.d));
        GpuImagePartsFilterGroup.b(this.this$0).init();
        GpuImagePartsFilterGroup.b(this.this$0).onOutputSizeChanged(this.b, this.c);
      }
      if ((this.e == 90) || (this.e == 270))
      {
        GpuImagePartsFilterGroup.a(this.this$0).a(false);
        GpuImagePartsFilterGroup.b(this.this$0).a(false);
      }
      for (;;)
      {
        GpuImagePartsFilterGroup.a(this.this$0, this.jdField_a_of_type_Float);
        GpuImagePartsFilterGroup.a(this.this$0).a(true, this.jdField_a_of_type_Float + 0.1F);
        GpuImagePartsFilterGroup.b(this.this$0).a(false, this.jdField_a_of_type_Float - 0.1F);
        if (localGPUDrawPartFilter1 != null) {
          localGPUDrawPartFilter1.destroy();
        }
        if (localGPUDrawPartFilter2 != null) {
          localGPUDrawPartFilter2.destroy();
        }
        return;
        GpuImagePartsFilterGroup.a(this.this$0).a(true);
        GpuImagePartsFilterGroup.b(this.this$0).a(true);
      }
      localGPUDrawPartFilter1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.2
 * JD-Core Version:    0.7.0.1
 */