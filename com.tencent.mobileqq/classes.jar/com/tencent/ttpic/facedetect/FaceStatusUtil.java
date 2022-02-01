package com.tencent.ttpic.facedetect;

import android.graphics.Matrix;
import java.util.List;

public class FaceStatusUtil
{
  public static List<FaceStatus> rotateFaceStatusFor3D(List<FaceStatus> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramList != null)
    {
      int i = paramInt3;
      paramInt3 = 0;
      while (paramInt3 < paramList.size())
      {
        FaceStatus localFaceStatus = (FaceStatus)paramList.get(paramInt3);
        i = (i + 360) % 360;
        float f;
        if (i == 90)
        {
          f = localFaceStatus.pitch;
          localFaceStatus.pitch = (-localFaceStatus.yaw);
          localFaceStatus.yaw = f;
          localFaceStatus.roll += i;
        }
        else if (i == 180)
        {
          localFaceStatus.pitch = (-localFaceStatus.pitch);
          localFaceStatus.yaw = (-localFaceStatus.yaw);
          localFaceStatus.roll += i;
        }
        else if (i == 270)
        {
          f = localFaceStatus.pitch;
          localFaceStatus.pitch = localFaceStatus.yaw;
          localFaceStatus.yaw = (-f);
          localFaceStatus.roll += i;
        }
        Matrix localMatrix = new Matrix();
        localMatrix.reset();
        localMatrix.postTranslate(-paramInt1 / 2.0F, -paramInt2 / 2.0F);
        localMatrix.postRotate(i, 0.0F, 0.0F);
        if ((i != 90) && (i != 270)) {
          localMatrix.postTranslate(paramInt1 / 2.0F, paramInt2 / 2.0F);
        } else {
          localMatrix.postTranslate(paramInt2 / 2.0F, paramInt1 / 2.0F);
        }
        float[] arrayOfFloat = new float[2];
        localMatrix.mapPoints(arrayOfFloat, new float[] { localFaceStatus.tx, localFaceStatus.ty });
        localFaceStatus.tx = arrayOfFloat[0];
        localFaceStatus.ty = arrayOfFloat[1];
        paramInt3 += 1;
      }
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.facedetect.FaceStatusUtil
 * JD-Core Version:    0.7.0.1
 */