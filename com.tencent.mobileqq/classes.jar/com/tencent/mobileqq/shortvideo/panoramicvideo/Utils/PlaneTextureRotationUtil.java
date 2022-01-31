package com.tencent.mobileqq.shortvideo.panoramicvideo.Utils;

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
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = TEXTURE_NO_ROTATION;
      if (paramBoolean1)
      {
        float[] arrayOfFloat = new float[8];
        arrayOfFloat[0] = flip(localObject[0]);
        arrayOfFloat[1] = localObject[1];
        arrayOfFloat[2] = flip(localObject[2]);
        arrayOfFloat[3] = localObject[3];
        arrayOfFloat[4] = flip(localObject[4]);
        arrayOfFloat[5] = localObject[5];
        arrayOfFloat[6] = flip(localObject[6]);
        arrayOfFloat[7] = localObject[7];
        localObject = arrayOfFloat;
      }
      break;
    }
    for (;;)
    {
      if (paramBoolean2)
      {
        return new float[] { localObject[0], flip(localObject[1]), localObject[2], flip(localObject[3]), localObject[4], flip(localObject[5]), localObject[6], flip(localObject[7]) };
        localObject = TEXTURE_ROTATED_90;
        break;
        localObject = TEXTURE_ROTATED_180;
        break;
        localObject = TEXTURE_ROTATED_270;
        break;
      }
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.Utils.PlaneTextureRotationUtil
 * JD-Core Version:    0.7.0.1
 */