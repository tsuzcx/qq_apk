package org.light;

public class PerformanceData
{
  public float aeBasicBeautySystemTime;
  public float aeLiquifyRenderChainTime;
  public float aeLutRendererTime;
  public float aePagRendererTime;
  public float aePostEffectRendererTime;
  public float aeScene3dRendererTime;
  public float aiSystemTime;
  public float frameTime;
  public float ganRendererTime;
  public float scriptSystemTime;
  public float stickerRendererTime;
  
  public PerformanceData(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11)
  {
    this.frameTime = paramFloat1;
    this.aiSystemTime = paramFloat2;
    this.scriptSystemTime = paramFloat3;
    this.stickerRendererTime = paramFloat4;
    this.aePagRendererTime = paramFloat5;
    this.aeBasicBeautySystemTime = paramFloat6;
    this.aeLiquifyRenderChainTime = paramFloat7;
    this.aeLutRendererTime = paramFloat8;
    this.aePostEffectRendererTime = paramFloat9;
    this.aeScene3dRendererTime = paramFloat10;
    this.ganRendererTime = paramFloat11;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.PerformanceData
 * JD-Core Version:    0.7.0.1
 */