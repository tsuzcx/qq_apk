package com.tencent.ttpic.openapi.util;

import android.content.Context;
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
  private static String GRAY_FILE_ALL = "assets://camera/camera_video/faceOff/grayImages/allgray.png";
  private static String GRAY_FILE_HAS_EYE = "assets://camera/camera_video/faceOff/grayImages/noeyegray.png";
  private static String GRAY_FILE_NO_EYE = "assets://camera/camera_video/faceOff/grayImages/nomouthgray.png";
  public static final int SWITCH_FACE_NO_HOLE_TRIANGLE_COUNT = 46;
  public static final int[] SwitchFaceFaceMeshTriangles = { 32, 2, 1, 31, 2, 32, 3, 2, 31, 30, 3, 31, 4, 3, 30, 29, 4, 30, 5, 4, 29, 28, 5, 29, 5, 6, 27, 27, 5, 28, 7, 6, 27, 26, 7, 27, 8, 7, 26, 8, 26, 9, 9, 26, 10, 10, 26, 11, 27, 11, 26, 12, 11, 27, 28, 27, 13, 27, 13, 12, 29, 13, 28, 29, 14, 13, 15, 14, 29, 29, 30, 15, 15, 30, 31, 16, 15, 31, 31, 32, 16, 16, 32, 17, 32, 18, 17, 32, 0, 33, 1, 0, 32, 33, 0, 34, 18, 33, 34, 32, 33, 18, 20, 18, 34, 22, 34, 35, 35, 21, 22, 20, 34, 22, 35, 36, 21, 35, 24, 36, 35, 25, 24, 34, 25, 35, 19, 25, 34, 34, 0, 19, 24, 23, 36, 36, 23, 21 };
  private static final String TAG = "SwitchFaceUtil";
  
  public static List<PointF> genPoints(List<Integer> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (CollectionUtils.isEmpty(paramList)) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramList.size() / 2)
    {
      int j = i * 2;
      localArrayList.add(new PointF(((Integer)paramList.get(j)).intValue(), ((Integer)paramList.get(j + 1)).intValue()));
      i += 1;
    }
    return localArrayList;
  }
  
  public static Bitmap getFaceBitmap(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("assets://"))) {
      paramString = BitmapUtils.decodeSampledBitmapFromAssets(AEModule.getContext(), FileUtils.getRealPath(paramString), 2147483647, 2147483647);
    } else {
      paramString = BitmapUtils.decodeSampledBitmapFromFile(paramString, 2147483647, 2147483647);
    }
    String str = paramString;
    if (!BitmapUtils.isLegal(paramString)) {
      str = null;
    }
    return str;
  }
  
  public static Bitmap getFaceBitmap(String paramString, FaceItem paramFaceItem)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("assets://")))
    {
      localObject = AEModule.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(FileUtils.getRealPath(paramString));
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramFaceItem.faceExchangeImage);
      paramString = BitmapUtils.decodeSampledBitmapFromAssets((Context)localObject, localStringBuilder.toString(), 2147483647, 2147483647);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(paramFaceItem.faceExchangeImage);
      paramString = BitmapUtils.decodeSampledBitmapFromFile(((StringBuilder)localObject).toString(), 2147483647, 2147483647);
    }
    paramFaceItem = paramString;
    if (!BitmapUtils.isLegal(paramString)) {
      paramFaceItem = null;
    }
    return paramFaceItem;
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
    if ((!CollectionUtils.isEmpty(paramList)) && (paramList.size() >= 90))
    {
      while (paramList.size() > 90) {
        paramList.remove(paramList.size() - 1);
      }
      PointF localPointF1 = AlgoUtils.middlePoint((PointF)paramList.get(41), (PointF)paramList.get(51));
      float f1 = ((PointF)paramList.get(9)).x;
      float f2 = ((PointF)paramList.get(84)).x;
      float f3 = -((PointF)paramList.get(9)).y;
      float f4 = ((PointF)paramList.get(84)).y;
      double d1 = Math.atan2(f1 - f2, f3 + f4) + 3.141592653589793D;
      Matrix localMatrix = new Matrix();
      localMatrix.reset();
      localMatrix.postTranslate(-localPointF1.x, -localPointF1.y);
      localMatrix.postRotate((float)Math.toDegrees(-d1));
      localMatrix.postTranslate(localPointF1.x, localPointF1.y);
      paramList = AlgoUtils.mapPoints(paramList, localMatrix);
      f1 = AlgoUtils.getDistance((PointF)paramList.get(0), (PointF)paramList.get(1));
      double d3 = ((PointF)paramList.get(1)).x;
      double d2 = f1 * 2.0F;
      double d4 = Math.sin(0.0D);
      Double.isNaN(d2);
      Double.isNaN(d3);
      f1 = (float)(d3 + d4 * d2);
      d3 = ((PointF)paramList.get(1)).y;
      d4 = Math.cos(0.0D);
      Double.isNaN(d2);
      Double.isNaN(d3);
      PointF localPointF2 = new PointF(f1, (float)(d3 - d2 * d4));
      paramList.add(localPointF2);
      f1 = AlgoUtils.getDistance((PointF)paramList.get(17), (PointF)paramList.get(18));
      d3 = ((PointF)paramList.get(17)).x;
      d2 = f1 * 2.0F;
      d4 = Math.sin(0.0D);
      Double.isNaN(d2);
      Double.isNaN(d3);
      f1 = (float)(d3 + d4 * d2);
      d3 = ((PointF)paramList.get(17)).y;
      d4 = Math.cos(0.0D);
      Double.isNaN(d2);
      Double.isNaN(d3);
      PointF localPointF4 = new PointF(f1, (float)(d3 - d2 * d4));
      paramList.add(localPointF4);
      f1 = AlgoUtils.getDistance((PointF)paramList.get(59), localPointF1);
      d3 = ((PointF)paramList.get(59)).x;
      d2 = f1 * 2.0F;
      d4 = Math.sin(0.0D);
      Double.isNaN(d2);
      Double.isNaN(d3);
      f1 = (float)(d3 + d4 * d2);
      d3 = ((PointF)paramList.get(59)).y;
      d4 = Math.cos(0.0D);
      Double.isNaN(d2);
      Double.isNaN(d3);
      PointF localPointF3 = new PointF(f1, (float)(d3 - d2 * d4));
      int i = 2;
      double d5;
      while (i >= 1)
      {
        d2 = i;
        d3 = 0.1666667F;
        Double.isNaN(d3);
        Double.isNaN(d2);
        d2 *= d3 * 3.14D;
        PointF localPointF5 = new PointF();
        d3 = localPointF3.x;
        d4 = localPointF3.x - localPointF4.x;
        d5 = Math.cos(d2);
        Double.isNaN(d4);
        Double.isNaN(d3);
        localPointF5.x = ((float)(d3 - d4 * d5));
        d3 = localPointF4.y;
        d4 = localPointF4.y - localPointF3.y;
        d2 = Math.sin(d2);
        Double.isNaN(d4);
        Double.isNaN(d3);
        localPointF5.y = ((float)(d3 - d4 * d2));
        paramList.add(localPointF5);
        i -= 1;
      }
      i = 3;
      while (i >= 1)
      {
        f1 = i;
        localPointF4 = new PointF();
        d3 = localPointF3.x;
        d4 = localPointF3.x - localPointF2.x;
        d2 = f1 * 0.5233334F;
        d5 = Math.cos(d2);
        Double.isNaN(d4);
        Double.isNaN(d3);
        localPointF4.x = ((float)(d3 - d4 * d5));
        d3 = localPointF2.y;
        d4 = localPointF2.y - localPointF3.y;
        d2 = Math.sin(d2);
        Double.isNaN(d4);
        Double.isNaN(d3);
        localPointF4.y = ((float)(d3 - d4 * d2));
        paramList.add(localPointF4);
        i -= 1;
      }
      localMatrix.reset();
      localMatrix.postTranslate(-localPointF1.x, -localPointF1.y);
      localMatrix.postRotate((float)Math.toDegrees(d1));
      localMatrix.postTranslate(localPointF1.x, localPointF1.y);
      return AlgoUtils.mapPoints(paramList, localMatrix);
    }
    return new ArrayList();
  }
  
  public static Bitmap getGrayBitmap(SwitchFaceUtil.FEATURE_TYPE paramFEATURE_TYPE)
  {
    if (paramFEATURE_TYPE.equals(SwitchFaceUtil.FEATURE_TYPE.NO_EYE)) {
      return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_NO_EYE, 2147483647, 2147483647);
    }
    if (paramFEATURE_TYPE.equals(SwitchFaceUtil.FEATURE_TYPE.HAS_EYE)) {
      return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_HAS_EYE, 2147483647, 2147483647);
    }
    if (paramFEATURE_TYPE.equals(SwitchFaceUtil.FEATURE_TYPE.ALL_GRAY)) {
      return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_ALL, 2147483647, 2147483647);
    }
    return null;
  }
  
  public static List<PointF> getGrayCoords(SwitchFaceUtil.FEATURE_TYPE paramFEATURE_TYPE)
  {
    int i = SwitchFaceUtil.1.$SwitchMap$com$tencent$ttpic$openapi$util$SwitchFaceUtil$FEATURE_TYPE[paramFEATURE_TYPE.ordinal()];
    return loadTexCoords("assets://camera/camera_video/faceOff/coords/nomouthgray.tsv");
  }
  
  public static float[] initFacePositions(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (paramArrayOfFloat != null) && (paramInt1 > 0) && (paramInt2 > 0) && (paramArrayOfFloat.length == 276))
    {
      PointF[] arrayOfPointF = new PointF[3];
      int i = 0;
      int j = 0;
      while (i < 138)
      {
        arrayOfPointF[0] = ((PointF)paramList.get(SwitchFaceFaceMeshTriangles[i]));
        arrayOfPointF[1] = ((PointF)paramList.get(SwitchFaceFaceMeshTriangles[(i + 1)]));
        arrayOfPointF[2] = ((PointF)paramList.get(SwitchFaceFaceMeshTriangles[(i + 2)]));
        int k = 0;
        while (k < 3)
        {
          int m = k * 2 + j;
          paramArrayOfFloat[m] = (arrayOfPointF[k].x / paramInt1 * 2.0F - 1.0F);
          paramArrayOfFloat[(m + 1)] = (arrayOfPointF[k].y / paramInt2 * 2.0F - 1.0F);
          k += 1;
        }
        j += 6;
        i += 3;
      }
      return paramArrayOfFloat;
    }
    return new float[0];
  }
  
  public static float[] initMaterialFaceTexCoords(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (paramArrayOfFloat != null) && (paramInt1 > 0) && (paramInt2 > 0) && (paramArrayOfFloat.length == 276))
    {
      PointF[] arrayOfPointF = new PointF[3];
      int i = 0;
      int j = 0;
      while (i < 138)
      {
        arrayOfPointF[0] = ((PointF)paramList.get(SwitchFaceFaceMeshTriangles[i]));
        arrayOfPointF[1] = ((PointF)paramList.get(SwitchFaceFaceMeshTriangles[(i + 1)]));
        arrayOfPointF[2] = ((PointF)paramList.get(SwitchFaceFaceMeshTriangles[(i + 2)]));
        int k = 0;
        while (k < 3)
        {
          int m = k * 2 + j;
          paramArrayOfFloat[m] = (arrayOfPointF[k].x / paramInt1);
          paramArrayOfFloat[(m + 1)] = (arrayOfPointF[k].y / paramInt2);
          k += 1;
        }
        j += 6;
        i += 3;
      }
      return paramArrayOfFloat;
    }
    return new float[0];
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
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return localArrayList;
      }
      paramString1 = FileUtils.load(AEModule.getContext(), paramString1, paramString2);
      if (paramString1 == null) {
        return localArrayList;
      }
      paramString1 = paramString1.trim().split("\\s+");
      int i = 0;
      try
      {
        while (i < paramString1.length / 2)
        {
          int j = i * 2;
          localArrayList.add(new PointF(Integer.parseInt(paramString1[j]), Integer.parseInt(paramString1[(j + 1)])));
          i += 1;
        }
        return localArrayList;
      }
      catch (NumberFormatException paramString1)
      {
        LogUtils.e(TAG, paramString1.toString());
        return new ArrayList();
      }
    }
    return localArrayList;
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