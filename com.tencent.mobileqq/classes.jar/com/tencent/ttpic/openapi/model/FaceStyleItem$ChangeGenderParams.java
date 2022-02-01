package com.tencent.ttpic.openapi.model;

public class FaceStyleItem$ChangeGenderParams
{
  public static final ChangeGenderParams defaultParams = new ChangeGenderParams();
  public FaceStyleItem.ChangeGenderCropParams face = new FaceStyleItem.ChangeGenderCropParams(107, 60, 245, 330, 0.64F, 448);
  public FaceStyleItem.ChangeGenderCropParams hair = new FaceStyleItem.ChangeGenderCropParams(0, 0, 256, 256, 0.64F, 448);
  public int offsetY = 50;
  public int outputTextureCount = 1;
  
  public float[] toFloatArray()
  {
    return new float[] { this.face.preSize, this.face.x, this.face.y, this.face.w, this.face.h, this.face.margin, this.hair.preSize, this.hair.x, this.hair.y, this.hair.w, this.hair.h, this.hair.margin, this.offsetY };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.FaceStyleItem.ChangeGenderParams
 * JD-Core Version:    0.7.0.1
 */