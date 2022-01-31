import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.ttpic.facedetect.TTFaceOriginDataModel;
import java.lang.reflect.Array;

public class lrb
{
  private static int[] a = { 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 30, 31, 32, 33, 34, 35, 36, 37, 22, 23, 24, 25, 26, 27, 28, 29, 46, 47, 48, 49, 50, 51, 52, 53, 38, 39, 40, 41, 42, 43, 44, 45, 54, 55, 66, 65, 64, 63, 62, 61, 60, 59, 58, 57, 56, 73, 72, 71, 70, 69, 68, 67, 78, 77, 76, 75, 74, 83, 82, 81, 80, 79, 88, 87, 86, 85, 84, 90, 89, 93, 94, 91, 92 };
  
  public static TTFaceOriginDataModel a(TTFaceOriginDataModel paramTTFaceOriginDataModel, RectF paramRectF1, RectF paramRectF2, Matrix paramMatrix, float paramFloat, boolean paramBoolean)
  {
    TTFaceOriginDataModel localTTFaceOriginDataModel = new TTFaceOriginDataModel();
    float f = Math.max(paramRectF2.width() / paramRectF1.width(), paramRectF2.height() / paramRectF1.height());
    int i = (int)(paramRectF1.width() * f);
    int j = (int)(paramRectF1.height() * f);
    if (i > paramRectF2.width()) {
      paramMatrix.preTranslate((paramRectF2.width() - i) / 2.0F, 0.0F);
    }
    for (;;)
    {
      paramMatrix.preScale(f, f);
      paramMatrix.postScale(paramFloat, paramFloat);
      i = 0;
      while (i < paramTTFaceOriginDataModel.facePoint.length)
      {
        if (paramBoolean) {
          paramTTFaceOriginDataModel.facePoint[i][0] = (paramRectF1.width() - paramTTFaceOriginDataModel.facePoint[i][0]);
        }
        paramMatrix.mapPoints(localTTFaceOriginDataModel.facePoint[i], paramTTFaceOriginDataModel.facePoint[i]);
        i += 1;
      }
      if (j > paramRectF2.height()) {
        paramMatrix.preTranslate(0.0F, (paramRectF2.height() - j) / 2.0F);
      }
    }
    localTTFaceOriginDataModel.facePointVisible = paramTTFaceOriginDataModel.facePointVisible;
    localTTFaceOriginDataModel.pitch = paramTTFaceOriginDataModel.pitch;
    if (paramBoolean)
    {
      paramFloat = -paramTTFaceOriginDataModel.yaw;
      localTTFaceOriginDataModel.yaw = paramFloat;
      if (!paramBoolean) {
        break label273;
      }
    }
    label273:
    for (paramFloat = -paramTTFaceOriginDataModel.roll;; paramFloat = paramTTFaceOriginDataModel.roll)
    {
      localTTFaceOriginDataModel.roll = paramFloat;
      localTTFaceOriginDataModel.cls = paramTTFaceOriginDataModel.cls;
      return localTTFaceOriginDataModel;
      paramFloat = paramTTFaceOriginDataModel.yaw;
      break;
    }
  }
  
  public static void a(TTFaceOriginDataModel paramTTFaceOriginDataModel)
  {
    float[][] arrayOfFloat = (float[][])Array.newInstance(Float.TYPE, new int[] { 94, 2 });
    int i = 0;
    while (i < a.length)
    {
      arrayOfFloat[i][0] = paramTTFaceOriginDataModel.facePoint[(a[i] - 1)][0];
      arrayOfFloat[i][1] = paramTTFaceOriginDataModel.facePoint[(a[i] - 1)][1];
      i += 1;
    }
    paramTTFaceOriginDataModel.facePoint = arrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lrb
 * JD-Core Version:    0.7.0.1
 */