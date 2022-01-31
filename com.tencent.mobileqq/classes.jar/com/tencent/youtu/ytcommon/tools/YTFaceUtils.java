package com.tencent.youtu.ytcommon.tools;

import android.graphics.Rect;
import com.tencent.youtu.ytfacetrack.YTFaceTrack.FaceStatus;

public class YTFaceUtils
{
  private static final String TAG = "FaceUtils";
  
  public static Rect getFaceScreen(YTFaceTrack.FaceStatus paramFaceStatus)
  {
    float f3 = paramFaceStatus.xys[0];
    float f4 = paramFaceStatus.xys[0];
    float f2 = paramFaceStatus.xys[1];
    float f1 = paramFaceStatus.xys[1];
    int i = 0;
    if (i < 180)
    {
      if (f3 < paramFaceStatus.xys[i])
      {
        label52:
        if (f4 <= paramFaceStatus.xys[i]) {
          break label115;
        }
        label65:
        i += 1;
        if (f2 >= paramFaceStatus.xys[i]) {
          break label127;
        }
        label83:
        if (f1 <= paramFaceStatus.xys[i]) {
          break label138;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        f3 = paramFaceStatus.xys[i];
        break label52;
        label115:
        f4 = paramFaceStatus.xys[i];
        break label65;
        label127:
        f2 = paramFaceStatus.xys[i];
        break label83;
        label138:
        f1 = paramFaceStatus.xys[i];
      }
    }
    return new Rect((int)f3, (int)f2, (int)f4, (int)f1);
  }
  
  public static int shelterJudge(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
    {
      YTLogger.i("FaceUtils", "[YTFaceTraceInterface.blockJudge] input pointsVis is null.");
      return -1;
    }
    if (paramArrayOfFloat.length != 90)
    {
      YTLogger.i("FaceUtils", "[YTFaceTraceInterface.blockJudge] input pointsVis.length != 90. current pointsVis.length: " + paramArrayOfFloat.length);
      return -2;
    }
    int i = 33;
    int k;
    for (int j = 0; i <= 45; j = k)
    {
      k = j;
      if (paramArrayOfFloat[(i - 1)] < 0.7F) {
        k = j + 1;
      }
      i += 1;
    }
    if (j >= 4) {
      return 5;
    }
    i = 46;
    for (j = 0; i <= 67; j = k)
    {
      k = j;
      if (paramArrayOfFloat[(i - 1)] < 0.7F) {
        k = j + 1;
      }
      i += 1;
    }
    if (j >= 4) {
      return 3;
    }
    j = 9;
    for (i = 0; j <= 16; i = k)
    {
      k = i;
      if (paramArrayOfFloat[(j - 1)] < 0.7F) {
        k = i + 1;
      }
      j += 1;
    }
    j = 25;
    while (j <= 32)
    {
      k = i;
      if (paramArrayOfFloat[(j - 1)] < 0.7F) {
        k = i + 1;
      }
      j += 1;
      i = k;
    }
    j = i;
    if (paramArrayOfFloat[89] < 0.7F) {
      j = i + 1;
    }
    if (j >= 4) {
      return 6;
    }
    j = 1;
    for (i = 0; j <= 8; i = k)
    {
      k = i;
      if (paramArrayOfFloat[(j - 1)] < 0.7F) {
        k = i + 1;
      }
      j += 1;
    }
    j = 17;
    while (j <= 24)
    {
      k = i;
      if (paramArrayOfFloat[(j - 1)] < 0.7F) {
        k = i + 1;
      }
      j += 1;
      i = k;
    }
    j = i;
    if (paramArrayOfFloat[88] < 0.7F) {
      j = i + 1;
    }
    if (j >= 4) {
      return 7;
    }
    i = 68;
    for (j = 0; i < 74; j = k)
    {
      k = j;
      if (paramArrayOfFloat[(i - 1)] < 0.7F) {
        k = j + 1;
      }
      i += 1;
    }
    if (j >= 3) {
      return 1;
    }
    i = 82;
    for (j = 0; i <= 88; j = k)
    {
      k = j;
      if (paramArrayOfFloat[(i - 1)] < 0.7F) {
        k = j + 1;
      }
      i += 1;
    }
    if (j >= 3) {
      return 4;
    }
    i = 75;
    for (j = 0; i <= 81; j = k)
    {
      k = j;
      if (paramArrayOfFloat[(i - 1)] < 0.7F) {
        k = j + 1;
      }
      i += 1;
    }
    if (j >= 3) {
      return 2;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.tools.YTFaceUtils
 * JD-Core Version:    0.7.0.1
 */