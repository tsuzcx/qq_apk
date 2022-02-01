package com.tencent.mobileqq.shortvideo.panoramicvideo.utils;

public class PlaneTextureRotationUtil
{
  public static final float[] TEXTURE_NO_ROTATION = { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F };
  public static final float[] TEXTURE_ROTATED_180 = { 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  public static final float[] TEXTURE_ROTATED_270 = { 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F };
  public static final float[] TEXTURE_ROTATED_90 = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  
  private static float flip(float paramFloat)
  {
    return 1.0F - paramFloat;
  }
  
  public static float[] getRotation(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          localObject1 = TEXTURE_NO_ROTATION;
        } else {
          localObject1 = TEXTURE_ROTATED_270;
        }
      }
      else {
        localObject1 = TEXTURE_ROTATED_180;
      }
    }
    else {
      localObject1 = TEXTURE_ROTATED_90;
    }
    Object localObject2 = localObject1;
    if (paramBoolean1) {
      localObject2 = new float[] { flip(localObject1[0]), localObject1[1], flip(localObject1[2]), localObject1[3], flip(localObject1[4]), localObject1[5], flip(localObject1[6]), localObject1[7] };
    }
    Object localObject1 = localObject2;
    if (paramBoolean2) {
      localObject1 = new float[] { localObject2[0], flip(localObject2[1]), localObject2[2], flip(localObject2[3]), localObject2[4], flip(localObject2[5]), localObject2[6], flip(localObject2[7]) };
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.utils.PlaneTextureRotationUtil
 * JD-Core Version:    0.7.0.1
 */