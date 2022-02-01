package com.tencent.ttpic.openapi.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.util.AlgoUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SwitchFaceUtil
{
  private static final String COORDS_FILE_HAS_EYE = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
  private static final String COORDS_FILE_NO_EYE = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
  private static PointF EMPTY_POINT = new PointF();
  private static String GRAY_FILE_ALL;
  private static String GRAY_FILE_HAS_EYE;
  private static String GRAY_FILE_NO_EYE;
  public static final int SWITCH_FACE_NO_HOLE_TRIANGLE_COUNT = 46;
  public static final int[] SwitchFaceFaceMeshTriangles = { 32, 2, 1, 31, 2, 32, 3, 2, 31, 30, 3, 31, 4, 3, 30, 29, 4, 30, 5, 4, 29, 28, 5, 29, 5, 6, 27, 27, 5, 28, 7, 6, 27, 26, 7, 27, 8, 7, 26, 8, 26, 9, 9, 26, 10, 10, 26, 11, 27, 11, 26, 12, 11, 27, 28, 27, 13, 27, 13, 12, 29, 13, 28, 29, 14, 13, 15, 14, 29, 29, 30, 15, 15, 30, 31, 16, 15, 31, 31, 32, 16, 16, 32, 17, 32, 18, 17, 32, 0, 33, 1, 0, 32, 33, 0, 34, 18, 33, 34, 32, 33, 18, 20, 18, 34, 22, 34, 35, 35, 21, 22, 20, 34, 22, 35, 36, 21, 35, 24, 36, 35, 25, 24, 34, 25, 35, 19, 25, 34, 34, 0, 19, 24, 23, 36, 36, 23, 21 };
  private static final String TAG = SwitchFaceUtil.class.getSimpleName();
  
  static
  {
    GRAY_FILE_NO_EYE = "assets://camera/camera_video/faceOff/grayImages/nomouthgray.png";
    GRAY_FILE_HAS_EYE = "assets://camera/camera_video/faceOff/grayImages/noeyegray.png";
    GRAY_FILE_ALL = "assets://camera/camera_video/faceOff/grayImages/allgray.png";
  }
  
  public static List<PointF> genPoints(List<Integer> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (CollectionUtils.isEmpty(paramList)) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramList.size() / 2)
    {
      localArrayList.add(new PointF(((Integer)paramList.get(i * 2)).intValue(), ((Integer)paramList.get(i * 2 + 1)).intValue()));
      i += 1;
    }
    return localArrayList;
  }
  
  public static Bitmap getFaceBitmap(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("assets://"))) {}
    for (paramString = BitmapUtils.decodeSampledBitmapFromAssets(AEModule.getContext(), FileUtils.getRealPath(paramString), 2147483647, 2147483647);; paramString = BitmapUtils.decodeSampledBitmapFromFile(paramString, 2147483647, 2147483647))
    {
      String str = paramString;
      if (!BitmapUtils.isLegal(paramString)) {
        str = null;
      }
      return str;
    }
  }
  
  public static Bitmap getFaceBitmap(String paramString, FaceItem paramFaceItem)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("assets://"))) {}
    for (paramString = BitmapUtils.decodeSampledBitmapFromAssets(AEModule.getContext(), FileUtils.getRealPath(paramString) + File.separator + paramFaceItem.faceExchangeImage, 2147483647, 2147483647);; paramString = BitmapUtils.decodeSampledBitmapFromFile(paramString + File.separator + paramFaceItem.faceExchangeImage, 2147483647, 2147483647))
    {
      paramFaceItem = paramString;
      if (!BitmapUtils.isLegal(paramString)) {
        paramFaceItem = null;
      }
      return paramFaceItem;
    }
  }
  
  public static SwitchFaceUtil.FEATURE_TYPE getFeatureType(int paramInt)
  {
    SwitchFaceUtil.FEATURE_TYPE[] arrayOfFEATURE_TYPE = SwitchFaceUtil.FEATURE_TYPE.values();
    int j = arrayOfFEATURE_TYPE.length;
    int i = 0;
    while (i < j)
    {
      SwitchFaceUtil.FEATURE_TYPE localFEATURE_TYPE = arrayOfFEATURE_TYPE[i];
      if (localFEATURE_TYPE.value == paramInt) {
        return localFEATURE_TYPE;
      }
      i += 1;
    }
    return SwitchFaceUtil.FEATURE_TYPE.NO_EYE;
  }
  
  public static List<PointF> getFullCoords(List<PointF> paramList)
  {
    if ((CollectionUtils.isEmpty(paramList)) || (paramList.size() < 90)) {
      return new ArrayList();
    }
    while (paramList.size() > 90) {
      paramList.remove(paramList.size() - 1);
    }
    PointF localPointF1 = AlgoUtils.middlePoint((PointF)paramList.get(41), (PointF)paramList.get(51));
    float f1 = ((PointF)paramList.get(9)).x;
    float f2 = ((PointF)paramList.get(84)).x;
    float f3 = -((PointF)paramList.get(9)).y;
    float f4 = ((PointF)paramList.get(84)).y;
    double d1 = 3.141592653589793D + Math.atan2(f1 - f2, f4 + f3);
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    localMatrix.postTranslate(-localPointF1.x, -localPointF1.y);
    localMatrix.postRotate((float)Math.toDegrees(-d1));
    localMatrix.postTranslate(localPointF1.x, localPointF1.y);
    paramList = AlgoUtils.mapPoints(paramList, localMatrix);
    f1 = AlgoUtils.getDistance((PointF)paramList.get(0), (PointF)paramList.get(1));
    PointF localPointF2 = new PointF((float)(((PointF)paramList.get(1)).x + 2.0F * f1 * Math.sin(0.0D)), (float)(((PointF)paramList.get(1)).y - 2.0F * f1 * Math.cos(0.0D)));
    paramList.add(localPointF2);
    f1 = AlgoUtils.getDistance((PointF)paramList.get(17), (PointF)paramList.get(18));
    PointF localPointF4 = new PointF((float)(((PointF)paramList.get(17)).x + 2.0F * f1 * Math.sin(0.0D)), (float)(((PointF)paramList.get(17)).y - 2.0F * f1 * Math.cos(0.0D)));
    paramList.add(localPointF4);
    f1 = AlgoUtils.getDistance((PointF)paramList.get(59), localPointF1);
    PointF localPointF3 = new PointF((float)(((PointF)paramList.get(59)).x + 2.0F * f1 * Math.sin(0.0D)), (float)(((PointF)paramList.get(59)).y - 2.0F * f1 * Math.cos(0.0D)));
    int i = 2;
    while (i >= 1)
    {
      double d2 = i * (30.0F / 180.0F * 3.14D);
      PointF localPointF5 = new PointF();
      localPointF5.x = ((float)(localPointF3.x - (localPointF3.x - localPointF4.x) * Math.cos(d2)));
      double d3 = localPointF4.y;
      double d4 = localPointF4.y - localPointF3.y;
      localPointF5.y = ((float)(d3 - Math.sin(d2) * d4));
      paramList.add(localPointF5);
      i -= 1;
    }
    i = 3;
    while (i >= 1)
    {
      f1 = i * (30.0F / 180.0F * 3.14F);
      localPointF4 = new PointF();
      localPointF4.x = ((float)(localPointF3.x - (localPointF3.x - localPointF2.x) * Math.cos(f1)));
      localPointF4.y = ((float)(localPointF2.y - (localPointF2.y - localPointF3.y) * Math.sin(f1)));
      paramList.add(localPointF4);
      i -= 1;
    }
    localMatrix.reset();
    localMatrix.postTranslate(-localPointF1.x, -localPointF1.y);
    localMatrix.postRotate((float)Math.toDegrees(d1));
    localMatrix.postTranslate(localPointF1.x, localPointF1.y);
    return AlgoUtils.mapPoints(paramList, localMatrix);
  }
  
  public static Bitmap getGrayBitmap(SwitchFaceUtil.FEATURE_TYPE paramFEATURE_TYPE)
  {
    Bitmap localBitmap = null;
    if (paramFEATURE_TYPE.equals(SwitchFaceUtil.FEATURE_TYPE.NO_EYE)) {
      localBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_NO_EYE, 2147483647, 2147483647);
    }
    do
    {
      return localBitmap;
      if (paramFEATURE_TYPE.equals(SwitchFaceUtil.FEATURE_TYPE.HAS_EYE)) {
        return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_HAS_EYE, 2147483647, 2147483647);
      }
    } while (!paramFEATURE_TYPE.equals(SwitchFaceUtil.FEATURE_TYPE.ALL_GRAY));
    return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_ALL, 2147483647, 2147483647);
  }
  
  public static List<PointF> getGrayCoords(SwitchFaceUtil.FEATURE_TYPE paramFEATURE_TYPE)
  {
    switch (SwitchFaceUtil.1.$SwitchMap$com$tencent$ttpic$openapi$util$SwitchFaceUtil$FEATURE_TYPE[paramFEATURE_TYPE.ordinal()])
    {
    }
    for (;;)
    {
      return loadTexCoords("assets://camera/camera_video/faceOff/coords/nomouthgray.tsv");
    }
  }
  
  public static float[] initFacePositions(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat;
    if ((CollectionUtils.isEmpty(paramList)) || (paramArrayOfFloat == null) || (paramInt1 <= 0) || (paramInt2 <= 0) || (paramArrayOfFloat.length != 276))
    {
      arrayOfFloat = new float[0];
      return arrayOfFloat;
    }
    PointF[] arrayOfPointF = new PointF[3];
    int i = 0;
    int j = 0;
    for (;;)
    {
      arrayOfFloat = paramArrayOfFloat;
      if (i >= 138) {
        break;
      }
      arrayOfPointF[0] = ((PointF)paramList.get(SwitchFaceFaceMeshTriangles[i]));
      arrayOfPointF[1] = ((PointF)paramList.get(SwitchFaceFaceMeshTriangles[(i + 1)]));
      arrayOfPointF[2] = ((PointF)paramList.get(SwitchFaceFaceMeshTriangles[(i + 2)]));
      int k = 0;
      while (k < 3)
      {
        paramArrayOfFloat[(k * 2 + j)] = (arrayOfPointF[k].x / paramInt1 * 2.0F - 1.0F);
        paramArrayOfFloat[(k * 2 + j + 1)] = (arrayOfPointF[k].y / paramInt2 * 2.0F - 1.0F);
        k += 1;
      }
      j += 6;
      i += 3;
    }
  }
  
  public static float[] initMaterialFaceTexCoords(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat;
    if ((CollectionUtils.isEmpty(paramList)) || (paramArrayOfFloat == null) || (paramInt1 <= 0) || (paramInt2 <= 0) || (paramArrayOfFloat.length != 276))
    {
      arrayOfFloat = new float[0];
      return arrayOfFloat;
    }
    PointF[] arrayOfPointF = new PointF[3];
    int i = 0;
    int j = 0;
    for (;;)
    {
      arrayOfFloat = paramArrayOfFloat;
      if (i >= 138) {
        break;
      }
      arrayOfPointF[0] = ((PointF)paramList.get(SwitchFaceFaceMeshTriangles[i]));
      arrayOfPointF[1] = ((PointF)paramList.get(SwitchFaceFaceMeshTriangles[(i + 1)]));
      arrayOfPointF[2] = ((PointF)paramList.get(SwitchFaceFaceMeshTriangles[(i + 2)]));
      int k = 0;
      while (k < 3)
      {
        paramArrayOfFloat[(k * 2 + j)] = (arrayOfPointF[k].x / paramInt1);
        paramArrayOfFloat[(k * 2 + j + 1)] = (arrayOfPointF[k].y / paramInt2);
        k += 1;
      }
      j += 6;
      i += 3;
    }
  }
  
  private static List<PointF> loadTexCoords(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new ArrayList();
    }
    return loadTexCoords(paramString.substring(0, paramString.lastIndexOf(File.separator)), paramString.substring(paramString.lastIndexOf(File.separator) + 1));
  }
  
  private static List<PointF> loadTexCoords(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return localArrayList;
      paramString1 = FileUtils.load(AEModule.getContext(), paramString1, paramString2);
      if (paramString1 == null) {
        continue;
      }
      paramString1 = paramString1.trim().split("\\s+");
      int i = 0;
      try
      {
        while (i < paramString1.length / 2)
        {
          localArrayList.add(new PointF(Integer.parseInt(paramString1[(i * 2)]), Integer.parseInt(paramString1[(i * 2 + 1)])));
          i += 1;
        }
        return new ArrayList();
      }
      catch (NumberFormatException paramString1)
      {
        LogUtils.e(TAG, paramString1.toString());
      }
    }
  }
  
  public static void setAllGrayImagePath(String paramString)
  {
    GRAY_FILE_ALL = paramString;
  }
  
  public static void setNoEyeGrayImagePath(String paramString)
  {
    GRAY_FILE_HAS_EYE = paramString;
  }
  
  public static void setNoMouthGrayImagePath(String paramString)
  {
    GRAY_FILE_NO_EYE = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.SwitchFaceUtil
 * JD-Core Version:    0.7.0.1
 */