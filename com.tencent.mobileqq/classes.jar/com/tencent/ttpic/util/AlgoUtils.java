package com.tencent.ttpic.util;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.model.FILL_STYLE;
import com.tencent.ttpic.model.SizeI;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class AlgoUtils
{
  private static final String TAG = "AlgoUtils";
  private static int mAverageHistogram = -1;
  private static final Random mRandom = new Random(System.currentTimeMillis());
  
  private static float[] GLKVector4Subtract(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float[] arrayOfFloat = new float[paramArrayOfFloat1.length];
    int i = 0;
    while (i < paramArrayOfFloat1.length)
    {
      paramArrayOfFloat1[i] -= paramArrayOfFloat2[i];
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public static native void RGBA2YUV420SP(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static native void RGBA2YUV420SP2(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static native void RGBA2YUV420SP3(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static void XYZ2Lab(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    double d3 = paramArrayOfDouble1[0];
    double d2 = paramArrayOfDouble1[1];
    double d1 = paramArrayOfDouble1[2];
    double d4 = d3 / 95.040000000000006D;
    d2 /= 100.0D;
    d3 = d1 / 108.89D;
    if (d4 > 0.008855999999999999D)
    {
      d1 = Math.pow(d4, 0.333333D);
      if (d2 <= 0.008855999999999999D) {
        break label144;
      }
      d2 = Math.pow(d2, 0.333333D);
      label74:
      if (d3 <= 0.008855999999999999D) {
        break label159;
      }
    }
    label144:
    label159:
    for (d3 = Math.pow(d3, 0.333333D);; d3 = 7.787D * d3 + 0.137931D)
    {
      paramArrayOfDouble2[0] = (116.0D * d2 - 16.0D);
      paramArrayOfDouble2[1] = ((d1 - d2) * 500.0D);
      paramArrayOfDouble2[2] = ((d2 - d3) * 200.0D);
      return;
      d1 = d4 * 7.787D + 0.137931D;
      break;
      d2 = 7.787D * d2 + 0.137931D;
      break label74;
    }
  }
  
  public static native void YUVNV21TORGBA(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2);
  
  public static native void YUVX2YUV(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static float[] adjustPosition(float[] paramArrayOfFloat, float paramFloat)
  {
    int i = 0;
    float f1 = (paramArrayOfFloat[0] + paramArrayOfFloat[4]) / 2.0F;
    float f2 = (paramArrayOfFloat[1] + paramArrayOfFloat[3]) / 2.0F;
    while (i < paramArrayOfFloat.length / 2)
    {
      paramArrayOfFloat[(i * 2)] = ((paramArrayOfFloat[(i * 2)] - f1) * paramFloat + f1);
      paramArrayOfFloat[(i * 2 + 1)] = ((paramArrayOfFloat[(i * 2 + 1)] - f2) * paramFloat + f2);
      i += 1;
    }
    return paramArrayOfFloat;
  }
  
  public static float[] adjustPosition(float[] paramArrayOfFloat, float paramFloat, double[] paramArrayOfDouble, int paramInt)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    float f1 = paramArrayOfFloat[0] + (paramArrayOfFloat[4] - paramArrayOfFloat[0]) * (float)paramArrayOfDouble[0];
    float f2 = paramArrayOfFloat[3] + (paramArrayOfFloat[1] - paramArrayOfFloat[3]) * (float)paramArrayOfDouble[1];
    if (paramInt == 0)
    {
      paramInt = i;
      while (paramInt < paramArrayOfFloat.length / 2)
      {
        paramArrayOfFloat[(paramInt * 2)] = ((paramArrayOfFloat[(paramInt * 2)] - f1) * paramFloat + f1);
        paramArrayOfFloat[(paramInt * 2 + 1)] = ((paramArrayOfFloat[(paramInt * 2 + 1)] - f2) * paramFloat + f2);
        paramInt += 1;
      }
    }
    if (paramInt == 1)
    {
      paramInt = j;
      while (paramInt < paramArrayOfFloat.length / 2)
      {
        paramArrayOfFloat[(paramInt * 2 + 1)] = ((paramArrayOfFloat[(paramInt * 2 + 1)] - f2) * paramFloat + f2);
        paramInt += 1;
      }
    }
    if (paramInt == 2)
    {
      paramInt = k;
      while (paramInt < paramArrayOfFloat.length / 2)
      {
        paramArrayOfFloat[(paramInt * 2)] = ((paramArrayOfFloat[(paramInt * 2)] - f1) * paramFloat + f1);
        paramInt += 1;
      }
    }
    return paramArrayOfFloat;
  }
  
  public static float[] adjustPositionTriangles(float[] paramArrayOfFloat, float paramFloat, double[] paramArrayOfDouble, int paramInt)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    float f1 = paramArrayOfFloat[0] + (paramArrayOfFloat[10] - paramArrayOfFloat[0]) * (float)paramArrayOfDouble[0];
    float f2 = paramArrayOfFloat[1] + (paramArrayOfFloat[3] - paramArrayOfFloat[1]) * (float)paramArrayOfDouble[1];
    if (paramInt == 0)
    {
      paramInt = i;
      while (paramInt < paramArrayOfFloat.length / 2)
      {
        paramArrayOfFloat[(paramInt * 2)] = ((paramArrayOfFloat[(paramInt * 2)] - f1) * paramFloat + f1);
        paramArrayOfFloat[(paramInt * 2 + 1)] = ((paramArrayOfFloat[(paramInt * 2 + 1)] - f2) * paramFloat + f2);
        paramInt += 1;
      }
    }
    if (paramInt == 1)
    {
      paramInt = j;
      while (paramInt < paramArrayOfFloat.length / 2)
      {
        paramArrayOfFloat[(paramInt * 2 + 1)] = ((paramArrayOfFloat[(paramInt * 2 + 1)] - f2) * paramFloat + f2);
        paramInt += 1;
      }
    }
    if (paramInt == 2)
    {
      paramInt = k;
      while (paramInt < paramArrayOfFloat.length / 2)
      {
        paramArrayOfFloat[(paramInt * 2)] = ((paramArrayOfFloat[(paramInt * 2)] - f1) * paramFloat + f1);
        paramInt += 1;
      }
    }
    return paramArrayOfFloat;
  }
  
  public static boolean between(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 >= Math.min(paramFloat1, paramFloat2)) && (paramFloat3 <= Math.max(paramFloat1, paramFloat2));
  }
  
  public static double calBrightnessAdjustment(byte[] paramArrayOfByte, int paramInt1, int paramInt2, List<List<PointF>> paramList, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramList == null) || (paramList.size() <= 0) || (((List)paramList.get(0)).size() <= 0))
    {
      resetBrightnessAdjustmentCurve(paramArrayOfInt2);
      return 60.0D;
    }
    paramList = new ArrayList((Collection)paramList.get(0));
    return createBrightnessCurve((int)((PointF)paramList.get(4)).x, (int)((PointF)paramList.get(14)).x, (int)((PointF)paramList.get(0)).y, (int)((PointF)paramList.get(3)).y, paramInt1, paramInt2, paramArrayOfByte, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public static int[] calBrightnessCurve(byte[] paramArrayOfByte, int paramInt1, int paramInt2, List<List<PointF>> paramList)
  {
    int[] arrayOfInt1 = new int[256];
    int[] arrayOfInt2 = new int[256];
    int[] arrayOfInt3 = new int[256];
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 256) || (paramInt1 <= 0) || (paramInt2 <= 0) || (CollectionUtils.isEmpty(paramList)))
    {
      resetBrightnessAdjustmentCurve(arrayOfInt3);
      return arrayOfInt3;
    }
    getHistogram(paramArrayOfByte, paramInt1, paramInt2, paramList, arrayOfInt1, arrayOfInt2);
    calBrightnessAdjustment(paramArrayOfByte, paramInt1, paramInt2, paramList, arrayOfInt2, arrayOfInt3);
    return mergeCurve(arrayOfInt2, arrayOfInt3);
  }
  
  private static SizeI calCutAspectSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d4 = paramInt1 / paramInt2;
    double d2 = paramInt4;
    double d3 = (int)(d2 * d4);
    double d1 = d3;
    if (d3 < paramInt3)
    {
      d1 = paramInt3;
      d2 = d1 / d4;
    }
    return new SizeI((int)d1, (int)d2);
  }
  
  public static SizeI calCutSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if (paramInt1 / paramInt2 >= paramDouble) {
      return new SizeI((int)Math.round(paramInt2 * paramDouble), paramInt2);
    }
    return new SizeI(paramInt1, (int)Math.round(paramInt1 / paramDouble));
  }
  
  public static List<Integer> calFaceAvgColor(byte[] paramArrayOfByte, int paramInt1, int paramInt2, List<List<PointF>> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0) || (((List)paramList.get(0)).size() <= 0)) {
      return Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    }
    paramList = new ArrayList((Collection)paramList.get(0));
    return createFaceAvgColor(paramArrayOfByte, (int)((PointF)paramList.get(4)).x, (int)((PointF)paramList.get(14)).x, (int)((PointF)paramList.get(0)).y, (int)((PointF)paramList.get(3)).y, paramInt1, paramInt2);
  }
  
  private float[] calPlaneLineIntersectPoint(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4)
  {
    float f7 = paramArrayOfFloat1[0];
    float f8 = paramArrayOfFloat1[1];
    float f9 = paramArrayOfFloat1[2];
    float f10 = paramArrayOfFloat2[0];
    float f11 = paramArrayOfFloat2[1];
    float f12 = paramArrayOfFloat2[2];
    float f1 = paramArrayOfFloat3[0];
    float f2 = paramArrayOfFloat3[1];
    float f3 = paramArrayOfFloat3[2];
    float f4 = paramArrayOfFloat4[0];
    float f5 = paramArrayOfFloat4[1];
    float f6 = paramArrayOfFloat4[2];
    float f13 = f1 * f7 + f2 * f8 + f3 * f9;
    if (f13 == 0.0F) {
      return null;
    }
    f7 = (f7 * (f10 - f4) + f8 * (f11 - f5) + (f12 - f6) * f9) / f13;
    return new float[] { f1 * f7 + f4, f2 * f7 + f5, f7 * f3 + f6 };
  }
  
  public static float[] calPositions(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2)
  {
    paramFloat1 = paramFloat1 / paramInt1 * 2.0F - 1.0F;
    paramFloat2 = paramFloat2 / paramInt2 * 2.0F - 1.0F;
    paramFloat3 = paramFloat3 / paramInt1 * 2.0F - 1.0F;
    paramFloat4 = paramFloat4 / paramInt2 * 2.0F - 1.0F;
    return new float[] { paramFloat1, paramFloat4, paramFloat1, paramFloat2, paramFloat3, paramFloat2, paramFloat3, paramFloat4 };
  }
  
  public static float[] calPositions(com.tencent.ttpic.openapi.model.Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 == FILL_STYLE.SPACE.value)
    {
      SizeI localSizeI = calSpaceAspectSize(paramInt1, paramInt2, paramRect.width, paramRect.height);
      paramInt1 = paramRect.x + (paramRect.width - localSizeI.width) / 2;
      paramInt2 = paramRect.y;
      paramInt2 = (paramRect.height - localSizeI.height) / 2 + paramInt2;
      paramInt5 = localSizeI.width;
      i = localSizeI.height;
      return calPositions(paramInt1, paramInt2 + i, paramInt5 + paramInt1, paramInt2, paramInt3, paramInt4);
    }
    paramInt1 = paramRect.x;
    paramInt2 = paramRect.y;
    paramInt5 = paramRect.width;
    int i = paramRect.height;
    return calPositions(paramInt1, i + paramInt2, paramInt1 + paramInt5, paramInt2, paramInt3, paramInt4);
  }
  
  public static float[] calPositionsTriangles(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2)
  {
    paramFloat1 = paramFloat1 / paramInt1 * 2.0F - 1.0F;
    paramFloat2 = paramFloat2 / paramInt2 * 2.0F - 1.0F;
    paramFloat3 = paramFloat3 / paramInt1 * 2.0F - 1.0F;
    paramFloat4 = paramFloat4 / paramInt2 * 2.0F - 1.0F;
    return new float[] { paramFloat1, paramFloat2, paramFloat1, paramFloat4, paramFloat3, paramFloat4, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat3, paramFloat2 };
  }
  
  private static SizeI calSpaceAspectSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d4 = paramInt1 / paramInt2;
    double d2 = paramInt4;
    double d3 = (int)(d2 * d4);
    double d1 = d3;
    if (d3 > paramInt3)
    {
      d1 = paramInt3;
      d2 = d1 / d4;
    }
    return new SizeI((int)d1, (int)d2);
  }
  
  public static float[] calTexCoords(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat = calPositions(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt1, paramInt2);
    paramInt1 = 0;
    while (paramInt1 < arrayOfFloat.length)
    {
      arrayOfFloat[paramInt1] = (arrayOfFloat[paramInt1] * 0.5F + 0.5F);
      paramInt1 += 1;
    }
    return arrayOfFloat;
  }
  
  public static float[] calTexCoords(int paramInt1, int paramInt2, double paramDouble)
  {
    int i;
    int m;
    int k;
    int j;
    if (paramInt1 / paramInt2 >= paramDouble)
    {
      i = (int)(paramInt2 * paramDouble);
      m = (paramInt1 - i) / 2;
      k = i + m;
      i = 0;
      j = paramInt2;
    }
    for (;;)
    {
      float f1 = m / paramInt1;
      float f2 = k / paramInt1;
      float f3 = j / paramInt2;
      float f4 = i / paramInt2;
      return new float[] { f1, f4, f1, f3, f2, f3, f2, f4 };
      j = (int)(paramInt1 / paramDouble);
      i = (paramInt2 - j) / 2;
      j += i;
      k = paramInt1;
      m = 0;
    }
  }
  
  public static float[] calTexCoords(int paramInt1, int paramInt2, int paramInt3, double paramDouble)
  {
    if ((paramInt3 == 90) || (paramInt3 == 270)) {}
    for (;;)
    {
      int k;
      int j;
      int i;
      if (paramInt2 / paramInt1 >= paramDouble)
      {
        paramInt3 = (int)(paramInt1 * paramDouble);
        k = (paramInt2 - paramInt3) / 2;
        j = paramInt3 + k;
        paramInt3 = 0;
        i = paramInt1;
      }
      for (;;)
      {
        float f1 = k / paramInt2;
        float f2 = j / paramInt2;
        float f3 = i / paramInt1;
        float f4 = paramInt3 / paramInt1;
        return new float[] { f1, f4, f1, f3, f2, f3, f2, f4 };
        i = (int)(paramInt2 / paramDouble);
        paramInt3 = (paramInt1 - i) / 2;
        i += paramInt3;
        j = paramInt2;
        k = 0;
      }
      paramInt3 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = paramInt3;
    }
  }
  
  public static float[] calTexCoordsFill(android.graphics.Rect paramRect, int paramInt1, int paramInt2)
  {
    float f1 = -paramRect.left;
    float f2 = paramInt1 - paramRect.left;
    return calTexCoords(f1, paramInt2 - paramRect.top, f2, -paramRect.top, paramRect.width(), paramRect.height());
  }
  
  public static float[] calTexCords(com.tencent.ttpic.openapi.model.Rect paramRect, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 == FILL_STYLE.CUT.value) || (paramInt3 == FILL_STYLE.FRAME_STYLE_CUT.value)) {
      return calTexCoords(paramInt1, paramInt2, paramRect.width / paramRect.height);
    }
    return GlUtil.ORIGIN_TEX_COORDS;
  }
  
  public static float[] calcPerspectiveProjTransformMatrix(float[] paramArrayOfFloat, int paramInt1, int paramInt2, float paramFloat)
  {
    float[] arrayOfFloat1 = new float[3];
    arrayOfFloat1[0] = paramArrayOfFloat[0];
    arrayOfFloat1[1] = paramArrayOfFloat[1];
    arrayOfFloat1[2] = paramArrayOfFloat[2];
    paramFloat = paramArrayOfFloat[3];
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = (paramArrayOfFloat[4] * paramArrayOfFloat[3]);
    arrayOfFloat2[1] = (paramArrayOfFloat[5] * paramArrayOfFloat[3]);
    paramFloat *= 110.0F;
    float f = (float)(paramInt2 / 2.0D / Math.tan(0.5235987755982988D));
    paramArrayOfFloat = new float[16];
    android.opengl.Matrix.setIdentityM(paramArrayOfFloat, 0);
    android.opengl.Matrix.translateM(paramArrayOfFloat, 0, arrayOfFloat2[0] - paramInt1 * 0.5F, -(arrayOfFloat2[1] - paramInt2 * 0.5F), f);
    android.opengl.Matrix.rotateM(paramArrayOfFloat, 0, -arrayOfFloat1[2], 0.0F, 0.0F, 1.0F);
    android.opengl.Matrix.rotateM(paramArrayOfFloat, 0, -arrayOfFloat1[1], 0.0F, 1.0F, 0.0F);
    android.opengl.Matrix.rotateM(paramArrayOfFloat, 0, arrayOfFloat1[0], 1.0F, 0.0F, 0.0F);
    android.opengl.Matrix.scaleM(paramArrayOfFloat, 0, paramFloat, paramFloat, paramFloat);
    arrayOfFloat1 = new float[4];
    arrayOfFloat2 = new float[4];
    float[] arrayOfFloat3 = new float[4];
    arrayOfFloat3 = new float[16];
    float[] arrayOfFloat4 = new float[16];
    android.opengl.Matrix.multiplyMV(arrayOfFloat1, 0, paramArrayOfFloat, 0, new float[] { 0.0F, 11.8F / 110.0F, 113.2F / 110.0F, 1.0F }, 0);
    android.opengl.Matrix.multiplyMV(arrayOfFloat2, 0, paramArrayOfFloat, 0, new float[] { 0.0F, 0.0F, 0.0F, 1.0F }, 0);
    arrayOfFloat1 = GLKVector4Subtract(arrayOfFloat1, arrayOfFloat2);
    android.opengl.Matrix.setIdentityM(arrayOfFloat3, 0);
    android.opengl.Matrix.translateM(arrayOfFloat3, 0, arrayOfFloat1[0], arrayOfFloat1[1], arrayOfFloat1[2]);
    android.opengl.Matrix.multiplyMM(arrayOfFloat4, 0, arrayOfFloat3, 0, paramArrayOfFloat, 0);
    return arrayOfFloat4;
  }
  
  public static void calcRotateMatrix(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f1 = (float)Math.cos(paramArrayOfFloat1[0]);
    float f2 = (float)Math.sin(paramArrayOfFloat1[0]);
    float f3 = (float)Math.cos(paramArrayOfFloat1[1]);
    float f4 = (float)Math.sin(paramArrayOfFloat1[1]);
    float f5 = (float)Math.cos(paramArrayOfFloat1[2]);
    float f6 = (float)Math.sin(paramArrayOfFloat1[2]);
    paramArrayOfFloat2[0] = (f3 * f5);
    paramArrayOfFloat2[1] = (f3 * f6);
    paramArrayOfFloat2[2] = (-f4);
    paramArrayOfFloat2[3] = 0.0F;
    paramArrayOfFloat2[4] = (f5 * f4 * f2 - f1 * f6);
    paramArrayOfFloat2[5] = (f5 * f1 + f2 * f4 * f6);
    paramArrayOfFloat2[6] = (f3 * f2);
    paramArrayOfFloat2[7] = 0.0F;
    paramArrayOfFloat2[8] = (f6 * f2 + f5 * f1 * f4);
    paramArrayOfFloat2[9] = (f4 * f1 * f6 - f2 * f5);
    paramArrayOfFloat2[10] = (f1 * f3);
    paramArrayOfFloat2[11] = 0.0F;
    paramArrayOfFloat2[12] = 0.0F;
    paramArrayOfFloat2[13] = 0.0F;
    paramArrayOfFloat2[14] = 0.0F;
    paramArrayOfFloat2[15] = 1.0F;
  }
  
  public static void calcTransformMatrix(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float paramFloat)
  {
    float f1 = (float)Math.cos(paramArrayOfFloat1[0]);
    float f2 = (float)Math.sin(paramArrayOfFloat1[0]);
    float f3 = (float)Math.cos(paramArrayOfFloat1[1]);
    float f4 = (float)Math.sin(paramArrayOfFloat1[1]);
    float f5 = (float)Math.cos(paramArrayOfFloat1[2]);
    float f6 = (float)Math.sin(paramArrayOfFloat1[2]);
    paramArrayOfFloat2[0] = (f3 * f5);
    paramArrayOfFloat2[1] = (f3 * f6);
    paramArrayOfFloat2[2] = (-f4);
    paramArrayOfFloat2[3] = 0.0F;
    paramArrayOfFloat2[4] = (f5 * f4 * f2 - f1 * f6);
    paramArrayOfFloat2[5] = (f5 * f1 + f2 * f4 * f6);
    paramArrayOfFloat2[6] = (f3 * f2);
    paramArrayOfFloat2[7] = 0.0F;
    paramArrayOfFloat2[8] = (f6 * f2 + f5 * f1 * f4);
    paramArrayOfFloat2[9] = (f4 * f1 * f6 - f2 * f5);
    paramArrayOfFloat2[10] = (f1 * f3);
    paramArrayOfFloat2[11] = 0.0F;
    paramArrayOfFloat2[12] = paramArrayOfFloat1[4];
    paramArrayOfFloat2[13] = paramArrayOfFloat1[5];
    paramArrayOfFloat2[14] = 0.0F;
    paramArrayOfFloat2[15] = 1.0F;
    int i = 0;
    while (i < 15)
    {
      paramArrayOfFloat2[i] *= paramArrayOfFloat1[3];
      i += 1;
    }
    paramArrayOfFloat2[0] /= paramFloat;
    paramArrayOfFloat2[4] /= paramFloat;
    paramArrayOfFloat2[8] /= paramFloat;
    paramArrayOfFloat2[12] /= paramFloat;
    paramArrayOfFloat2[1] /= paramFloat;
    paramArrayOfFloat2[5] /= paramFloat;
    paramArrayOfFloat2[9] /= paramFloat;
    paramArrayOfFloat2[13] /= paramFloat;
  }
  
  private static double createBrightnessCurve(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    double d1 = 0.0D;
    double d2 = 0.0D;
    double[] arrayOfDouble1 = new double[3];
    double[] arrayOfDouble2 = new double[3];
    double[] arrayOfDouble3 = new double[3];
    while (paramInt1 <= paramInt2)
    {
      d3 = d2;
      paramInt6 = paramInt3;
      d2 = d1;
      d1 = d3;
      while (paramInt6 <= paramInt4)
      {
        int j = (paramInt6 * paramInt5 + paramInt1) * 4;
        double d4 = d1;
        d3 = d2;
        if (j >= 0)
        {
          d4 = d1;
          d3 = d2;
          if (j + 2 < paramArrayOfByte.length)
          {
            int k = paramArrayOfByte[j];
            int i = paramArrayOfByte[(j + 1)];
            j = paramArrayOfByte[(j + 2)];
            k = paramArrayOfInt1[(k & 0xFF)];
            i = paramArrayOfInt1[(i & 0xFF)];
            j = paramArrayOfInt1[(j & 0xFF)];
            arrayOfDouble1[0] = k;
            arrayOfDouble1[1] = i;
            arrayOfDouble1[2] = j;
            sRGB2XYZ(arrayOfDouble1, arrayOfDouble2);
            XYZ2Lab(arrayOfDouble2, arrayOfDouble3);
            d3 = d2 + arrayOfDouble3[0];
            d4 = d1 + 1.0D;
          }
        }
        paramInt6 += 1;
        d1 = d4;
        d2 = d3;
      }
      paramInt1 += 1;
      d3 = d2;
      d2 = d1;
      d1 = d3;
    }
    double d3 = 60.0D;
    if (d2 != 0.0D)
    {
      d3 = d1 / d2;
      if ((d3 >= 60.0D) && (d3 <= 75.0D)) {
        resetBrightnessAdjustmentCurve(paramArrayOfInt2);
      }
    }
    else
    {
      return d3;
    }
    if (d3 < 60.0D) {}
    for (paramInt1 = (int)(1.0D * (60.0D - d3) + 128.0D);; paramInt1 = (int)(0.8D * (75.0D - d3) + 128.0D))
    {
      getPreparedSpline(new int[] { 0, 128, 255 }, new int[] { 0, paramInt1, 255 }, paramArrayOfInt2);
      return d3;
    }
  }
  
  private static List<Integer> createFaceAvgColor(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    double d3 = 0.0D;
    double d2 = 0.0D;
    double d1 = 0.0D;
    paramInt6 = 0;
    while (paramInt1 <= paramInt2)
    {
      int i = paramInt3;
      while (i <= paramInt4)
      {
        int k = (i * paramInt5 + paramInt1) * 4;
        int j = paramInt6;
        double d6 = d1;
        double d5 = d2;
        double d4 = d3;
        if (k >= 0)
        {
          j = paramInt6;
          d6 = d1;
          d5 = d2;
          d4 = d3;
          if (k + 2 < paramArrayOfByte.length)
          {
            j = paramArrayOfByte[k];
            int m = paramArrayOfByte[(k + 1)];
            k = paramArrayOfByte[(k + 2)];
            d4 = d3 + (j & 0xFF);
            d5 = d2 + (m & 0xFF);
            d6 = d1 + (k & 0xFF);
            j = paramInt6 + 1;
          }
        }
        i += 1;
        paramInt6 = j;
        d1 = d6;
        d2 = d5;
        d3 = d4;
      }
      paramInt1 += 1;
    }
    return Arrays.asList(new Integer[] { Integer.valueOf((int)(d3 / paramInt6)), Integer.valueOf((int)(d2 / paramInt6)), Integer.valueOf((int)(d1 / paramInt6)) });
  }
  
  public static float distanceOfPoint2Line(PointF paramPointF1, PointF paramPointF2, float paramFloat, PointF paramPointF3)
  {
    float f1 = getDistance(paramPointF1, paramPointF3);
    float f2 = getDistance(paramPointF2, paramPointF3);
    float f3 = (paramFloat + f1 + f2) / 2.0F;
    if ((f3 - paramFloat) * f3 * (f3 - f1) * (f3 - f2) < 1.0E-006D) {
      return 0.0F;
    }
    return (float)Math.sqrt((f3 - f1) * ((f3 - paramFloat) * f3) * (f3 - f2)) * 2.0F / paramFloat;
  }
  
  public static float[] double2FloatArray(double[] paramArrayOfDouble)
  {
    float[] arrayOfFloat = new float[paramArrayOfDouble.length];
    int i = 0;
    while (i < paramArrayOfDouble.length)
    {
      arrayOfFloat[i] = ((float)paramArrayOfDouble[i]);
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public static PointF genVector(PointF paramPointF1, PointF paramPointF2)
  {
    return new PointF(paramPointF2.x - paramPointF1.x, paramPointF2.y - paramPointF1.y);
  }
  
  public static int getAverageHistogram(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 0;
    int m;
    for (int k = 0; k < paramInt1; k = m)
    {
      int n = j;
      m = 0;
      j = i;
      i = n;
      while (m < paramInt2)
      {
        int i2 = (m * paramInt1 + k) * 4;
        int i1 = i;
        n = j;
        if (i2 >= 0)
        {
          i1 = i;
          n = j;
          if (i2 + 2 < paramArrayOfByte.length)
          {
            n = paramArrayOfByte[i2];
            i1 = paramArrayOfByte[(i2 + 1)];
            i2 = paramArrayOfByte[(i2 + 2)];
            double d = n & 0xFF;
            n = j + (int)((i1 & 0xFF) * 0.587D + d * 0.299D + (i2 & 0xFF) * 0.114D);
            i1 = i + 1;
          }
        }
        m += 20;
        i = i1;
        j = n;
      }
      m = k + 20;
      k = j;
      j = i;
      i = k;
    }
    paramInt1 = i / j;
    Log.d("AlgoUtils", "getAverageHistogram:result:" + paramInt1);
    mAverageHistogram = paramInt1;
    return paramInt1;
  }
  
  public static PointF getBetweenPoint(PointF paramPointF1, PointF paramPointF2, float paramFloat)
  {
    if ((paramPointF1 == null) || (paramPointF2 == null)) {
      return new PointF();
    }
    return new PointF(paramPointF1.x * (1.0F - paramFloat) + paramPointF2.x * paramFloat, paramPointF1.y * (1.0F - paramFloat) + paramPointF2.y * paramFloat);
  }
  
  public static int getBitmapHistogram(String paramString)
  {
    paramString = BitmapUtils.decodeBitmap(paramString, true);
    int n = paramString.getWidth();
    int i1 = paramString.getHeight();
    int j = 0;
    int k = 0;
    int i = 0;
    while (i < i1)
    {
      int m = 0;
      while (m < n)
      {
        int i4 = paramString.getPixel(m, i);
        int i2 = Color.red(i4);
        int i3 = Color.green(i4);
        i4 = Color.blue(i4);
        double d1 = i2;
        double d2 = i3;
        k += (int)(i4 * 0.114D + (d2 * 0.587D + d1 * 0.299D));
        j += 1;
        m += 20;
      }
      i += 20;
    }
    i = k / j;
    mAverageHistogram = i;
    return i;
  }
  
  public static PointF getCrossPoint(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4)
  {
    float f3 = paramPointF1.x;
    float f4 = paramPointF1.y;
    float f7 = paramPointF2.x;
    float f8 = paramPointF2.y;
    float f5 = paramPointF3.x;
    float f6 = paramPointF3.y;
    float f9 = paramPointF4.x;
    float f10 = paramPointF4.y;
    float f1 = 3.4028235E+38F;
    float f2 = 3.4028235E+38F;
    int i = 0;
    int j = 0;
    if (Math.abs(f3 - f7) < 1.0E-008D) {
      i = 1;
    }
    if (Math.abs(f5 - f9) < 1.0E-008D) {
      j = 1;
    }
    if (i == 0) {
      f1 = (f4 - f8) / (f3 - f7);
    }
    if (j == 0) {
      f2 = (f6 - f10) / (f5 - f9);
    }
    if (Math.abs(f1 - f2) < 1.0E-008D) {
      return null;
    }
    if (i != 0)
    {
      if (j != 0) {
        return null;
      }
      if (Math.abs(f2) < 1.0E-008D)
      {
        f1 = f6;
        f2 = f3;
      }
    }
    while ((between(f3, f7, f2)) && (between(f4, f8, f1)) && (between(f5, f9, f2)) && (between(f6, f10, f1)))
    {
      return new PointF(f2, f1);
      f1 = (f3 - f9) * f2 + f10;
      f2 = f3;
      continue;
      if (j != 0)
      {
        if (Math.abs(f1) < 1.0E-008D)
        {
          f1 = f4;
          f2 = f5;
        }
        else
        {
          f1 = (f5 - f7) * f1 + f8;
          f2 = f5;
        }
      }
      else if (Math.abs(f1) < 1.0E-008D)
      {
        f2 = (f4 - f10) / f2 + f9;
        f1 = f4;
      }
      else if (Math.abs(f2) < 1.0E-008D)
      {
        f2 = (f6 - f8) / f1 + f7;
        f1 = f6;
      }
      else
      {
        f2 = (f1 * f7 - f2 * f9 + f10 - f8) / (f1 - f2);
        f1 = (f2 - f7) * f1 + f8;
      }
    }
    return null;
  }
  
  public static float getDistance(PointF paramPointF1, PointF paramPointF2)
  {
    if ((paramPointF1 == null) || (paramPointF2 == null)) {
      return 0.0F;
    }
    double d1 = paramPointF1.x - paramPointF2.x;
    double d2 = paramPointF1.y - paramPointF2.y;
    return (float)Math.sqrt(d1 * d1 + d2 * d2);
  }
  
  public static float getDistance(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if ((paramArrayOfFloat1 == null) || (paramArrayOfFloat2 == null)) {
      return 0.0F;
    }
    double d1 = paramArrayOfFloat1[0] - paramArrayOfFloat2[0];
    double d2 = paramArrayOfFloat1[1] - paramArrayOfFloat2[1];
    return (float)Math.sqrt(d1 * d1 + d2 * d2);
  }
  
  public static RectF getFaceRectF(List<PointF> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      float f2 = 3.4028235E+38F;
      float f3 = 1.4E-45F;
      float f4 = 3.4028235E+38F;
      PointF localPointF;
      for (float f1 = 1.4E-45F; paramList.hasNext(); f1 = Math.max(f1, localPointF.y))
      {
        localPointF = (PointF)paramList.next();
        f4 = Math.min(f4, localPointF.x);
        f3 = Math.max(f3, localPointF.x);
        f2 = Math.min(f2, localPointF.y);
      }
      return new RectF(f4, f2, f3, f1);
    }
    return null;
  }
  
  public static Pair<Integer, int[]> getHistogram(byte[] paramArrayOfByte, int paramInt1, int paramInt2, List<List<PointF>> paramList, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    Arrays.fill(paramArrayOfInt1, 0);
    int i = 0;
    int[] arrayOfInt1 = new int[256];
    int[] arrayOfInt2 = new int[256];
    android.graphics.Rect localRect = new android.graphics.Rect();
    int j;
    if ((paramList == null) || (paramList.size() <= 0) || (((List)paramList.get(0)).size() <= 0))
    {
      localRect.left = 0;
      localRect.right = paramInt1;
      localRect.top = 0;
      localRect.bottom = paramInt2;
      j = 0;
    }
    int k;
    int m;
    int n;
    for (;;)
    {
      if (j < paramInt1)
      {
        if (paramInt2 > 2560) {
          LogUtils.d("GetHistogram", "illegal imageHeight = " + paramInt2);
        }
      }
      else
      {
        j = 0;
        paramInt2 = 0;
        paramInt1 = 0;
        while (paramInt1 < arrayOfInt1.length)
        {
          j += arrayOfInt1[paramInt1];
          paramInt2 += arrayOfInt1[paramInt1] * paramInt1;
          paramInt1 += 1;
        }
        paramList = new ArrayList((Collection)paramList.get(0));
        j = (int)((PointF)paramList.get(25)).x;
        k = (int)((PointF)paramList.get(33)).x;
        m = (int)((PointF)paramList.get(87)).y;
        n = (int)((PointF)paramList.get(4)).y;
        localRect.left = j;
        localRect.right = k;
        localRect.top = m;
        localRect.bottom = n;
        break;
      }
      k = 0;
      if (k < paramInt2)
      {
        n = (k * paramInt1 + j) * 4;
        m = i;
        if (n >= 0)
        {
          m = i;
          if (n + 2 < paramArrayOfByte.length)
          {
            m = paramArrayOfByte[n] & 0xFF;
            int i1 = paramArrayOfByte[(n + 1)] & 0xFF;
            n = paramArrayOfByte[(n + 2)] & 0xFF;
            paramArrayOfInt1[m] += 1;
            paramArrayOfInt1[i1] += 1;
            paramArrayOfInt1[n] += 1;
            double d1 = m;
            double d2 = i1;
            m = (int)(n * 0.11D + (d2 * 0.59D + d1 * 0.3D));
            if (m < 256) {
              break label518;
            }
          }
        }
        label518:
        for (n = 255;; n = m)
        {
          arrayOfInt2[n] += 1;
          if (localRect.contains(j, k))
          {
            n = m;
            if (m >= 256) {
              n = 255;
            }
            arrayOfInt1[n] += 1;
          }
          m = i + 3;
          k += 2;
          i = m;
          break;
        }
      }
      j += 2;
    }
    if (j > 0) {
      paramInt2 /= j;
    }
    for (;;)
    {
      paramInt1 = 0;
      j = 255;
      k = 0;
      for (m = 0; paramInt1 < 256; m = n)
      {
        n = m + paramArrayOfInt1[paramInt1];
        m = k;
        if (n >= i * 0.00105D)
        {
          m = k;
          if (k == 0) {
            m = paramInt1;
          }
        }
        k = j;
        if (n >= i * (1.0D - 0.00105D))
        {
          k = j;
          if (j == 255) {
            k = paramInt1;
          }
        }
        paramInt1 += 1;
        j = k;
        k = m;
      }
      i = Math.max(Math.min(k, 32), 0);
      m = Math.max(Math.min(j, 255), 224);
      paramInt1 = (k - i) * 255 / (m - i);
      n = (j - i) * 255 / (m - i);
      if ((paramInt1 <= k) && (n >= j))
      {
        paramInt1 = 0;
        if (paramInt1 < 256)
        {
          if (paramInt1 < i) {
            paramArrayOfInt2[paramInt1] = 0;
          }
          for (;;)
          {
            paramInt1 += 1;
            break;
            if (paramInt1 > m) {
              paramArrayOfInt2[paramInt1] = 255;
            } else {
              paramArrayOfInt2[paramInt1] = ((paramInt1 - i) * 255 / (m - i));
            }
          }
        }
      }
      else
      {
        paramInt1 = 0;
        while (paramInt1 < 256)
        {
          paramArrayOfInt2[paramInt1] = paramInt1;
          paramInt1 += 1;
        }
      }
      return Pair.create(Integer.valueOf(paramInt2), arrayOfInt2);
      paramInt2 = 255;
    }
  }
  
  public static RectF getLeftEyeRectF(List<PointF> paramList)
  {
    float f2 = 3.4028235E+38F;
    float f1 = 1.4E-45F;
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 19;
      float f3 = 1.4E-45F;
      float f4 = 3.4028235E+38F;
      PointF localPointF;
      while (i <= 26)
      {
        localPointF = (PointF)paramList.get(i);
        f4 = Math.min(f4, localPointF.x);
        f3 = Math.max(f3, localPointF.x);
        f2 = Math.min(f2, localPointF.y);
        f1 = Math.max(f1, localPointF.y);
        i += 1;
      }
      i = 35;
      while (i <= 44)
      {
        localPointF = (PointF)paramList.get(i);
        f4 = Math.min(f4, localPointF.x);
        f3 = Math.max(f3, localPointF.x);
        f2 = Math.min(f2, localPointF.y);
        f1 = Math.max(f1, localPointF.y);
        i += 1;
      }
      return new RectF(f4, f2, f3, f1);
    }
    return null;
  }
  
  public static void getPreparedSpline(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((paramArrayOfInt3 == null) || (paramArrayOfInt3.length < 256)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < 256)
      {
        paramArrayOfInt3[i] = i;
        i += 1;
      }
      double[] arrayOfDouble = secondDerivative(paramArrayOfInt1, paramArrayOfInt2);
      i = 0;
      while (i < paramArrayOfInt1.length - 1)
      {
        int k = paramArrayOfInt1[i];
        int m = paramArrayOfInt2[i];
        int n = paramArrayOfInt1[(i + 1)];
        int i1 = paramArrayOfInt2[(i + 1)];
        int j = k;
        while (j < n)
        {
          double d1 = (j - k) / (n - k);
          double d2 = 1.0D - d1;
          double d5 = n - k;
          double d3 = m;
          double d4 = i1;
          d5 = d5 * d5 / 6.0D;
          double d6 = arrayOfDouble[i];
          double d7 = arrayOfDouble[(i + 1)];
          if ((j >= 0) && (j < 256)) {
            paramArrayOfInt3[j] = Math.max(0, Math.min(255, (int)(((d1 * d1 * d1 - d1) * d7 + (d2 * d2 * d2 - d2) * d6) * d5 + (d3 * d2 + d4 * d1))));
          }
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  public static RectF getRightEyeRectF(List<PointF> paramList)
  {
    float f2 = 3.4028235E+38F;
    float f1 = 1.4E-45F;
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 27;
      float f3 = 1.4E-45F;
      float f4 = 3.4028235E+38F;
      PointF localPointF;
      while (i <= 34)
      {
        localPointF = (PointF)paramList.get(i);
        f4 = Math.min(f4, localPointF.x);
        f3 = Math.max(f3, localPointF.x);
        f2 = Math.min(f2, localPointF.y);
        f1 = Math.max(f1, localPointF.y);
        i += 1;
      }
      i = 45;
      while (i <= 54)
      {
        localPointF = (PointF)paramList.get(i);
        f4 = Math.min(f4, localPointF.x);
        f3 = Math.max(f3, localPointF.x);
        f2 = Math.min(f2, localPointF.y);
        f1 = Math.max(f1, localPointF.y);
        i += 1;
      }
      return new RectF(f4, f2, f3, f1);
    }
    return null;
  }
  
  public static int getmAverageHistogram()
  {
    return mAverageHistogram;
  }
  
  public static boolean isFace3DPointsValid(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length < 9)) {}
    for (;;)
    {
      return false;
      if (!Float.isNaN(paramArrayOfFloat[0]))
      {
        PointF localPointF = new PointF(paramArrayOfFloat[0], paramArrayOfFloat[1]);
        int i = 0;
        while (i < paramArrayOfFloat.length / 3)
        {
          if (getDistance(new PointF(paramArrayOfFloat[(i * 3)], paramArrayOfFloat[(i * 3 + 1)]), localPointF) > 0.001F) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public static boolean isFacePointsValid(List<PointF> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return false;
    }
    PointF localPointF = (PointF)paramList.get(0);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (getDistance((PointF)paramList.next(), localPointF) > 0.001F) {
        return true;
      }
    }
    return false;
  }
  
  public static int is_skin(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 <= 45) || (paramInt2 <= 40) || (paramInt3 <= 20)) {}
    while ((paramInt1 <= paramInt2) || (paramInt1 <= paramInt3) || (Math.max(Math.max(paramInt1, paramInt2), paramInt3) - Math.min(Math.min(paramInt1, paramInt2), paramInt3) <= 3) || (paramInt1 < paramInt2 + 3)) {
      return 0;
    }
    return 1;
  }
  
  public static float[] linearRegression(List<PointF> paramList)
  {
    float f3 = 0.0F;
    int i = 0;
    float f1 = 0.0F;
    float f2 = 0.0F;
    while (i < paramList.size())
    {
      f2 += ((PointF)paramList.get(i)).x;
      f1 += ((PointF)paramList.get(i)).y;
      i += 1;
    }
    float f4 = f2 / paramList.size();
    float f5 = f1 / paramList.size();
    i = 0;
    f2 = 0.0F;
    f1 = f3;
    while (i < paramList.size())
    {
      f3 = ((PointF)paramList.get(i)).x;
      f2 += (((PointF)paramList.get(i)).y - f5) * (f3 - f4);
      f1 += (f3 - f4) * (f3 - f4);
      i += 1;
    }
    f1 = f2 / f1;
    return new float[] { f1, f5 - f1 * f4 };
  }
  
  public static PointF mapPoint(PointF paramPointF, android.graphics.Matrix paramMatrix)
  {
    float[] arrayOfFloat = new float[2];
    paramMatrix.mapPoints(arrayOfFloat, new float[] { paramPointF.x, paramPointF.y });
    paramPointF.x = arrayOfFloat[0];
    paramPointF.y = arrayOfFloat[1];
    return paramPointF;
  }
  
  public static List<PointF> mapPoints(List<PointF> paramList, android.graphics.Matrix paramMatrix)
  {
    float[] arrayOfFloat1 = new float[2];
    float[] arrayOfFloat2 = new float[2];
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      PointF localPointF = (PointF)localIterator.next();
      arrayOfFloat1[0] = localPointF.x;
      arrayOfFloat1[1] = localPointF.y;
      paramMatrix.mapPoints(arrayOfFloat2, arrayOfFloat1);
      localPointF.x = arrayOfFloat2[0];
      localPointF.y = arrayOfFloat2[1];
    }
    return paramList;
  }
  
  public static int[] mergeCurve(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    Object localObject;
    if ((paramArrayOfInt1 == null) || (paramArrayOfInt2 == null))
    {
      localObject = null;
      return localObject;
    }
    int j = Math.min(paramArrayOfInt1.length, paramArrayOfInt2.length);
    int[] arrayOfInt = new int[j];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfInt;
      if (i >= j) {
        break;
      }
      arrayOfInt[i] = paramArrayOfInt2[paramArrayOfInt1[i]];
      i += 1;
    }
  }
  
  public static int[] mergeCurve(int[] paramArrayOfInt1, int[] paramArrayOfInt2, float paramFloat1, float paramFloat2)
  {
    if ((paramArrayOfInt1 == null) || (paramArrayOfInt2 == null)) {
      return null;
    }
    int k = Math.min(paramArrayOfInt1.length, paramArrayOfInt2.length);
    int[] arrayOfInt = new int[k];
    int i = 0;
    if (i < k)
    {
      int j = (int)(paramArrayOfInt1[i] * paramFloat1 + i * (1.0F - paramFloat1));
      if (j >= 0) {}
      for (;;)
      {
        float f = paramArrayOfInt2[j];
        arrayOfInt[i] = ((int)(j * (1.0F - paramFloat2) + f * paramFloat2));
        i += 1;
        break;
        j = 0;
      }
    }
    return arrayOfInt;
  }
  
  public static PointF middlePoint(PointF paramPointF1, PointF paramPointF2)
  {
    if ((paramPointF1 == null) || (paramPointF2 == null)) {
      return new PointF();
    }
    return new PointF((paramPointF1.x + paramPointF2.x) / 2.0F, (paramPointF1.y + paramPointF2.y) / 2.0F);
  }
  
  public static native void nativeRotatePlane(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeScalePlane(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2);
  
  public static int randValueDiff(int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 1) {
      return 1;
    }
    int i;
    do
    {
      i = mRandom.nextInt(paramInt2) + 1;
    } while (paramInt1 == i);
    return i;
  }
  
  public static void resetBrightnessAdjustmentCurve(int[] paramArrayOfInt)
  {
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      paramArrayOfInt[i] = i;
      i += 1;
    }
  }
  
  public static float[] rgb2HSV(int paramInt1, int paramInt2, int paramInt3)
  {
    float[] arrayOfFloat = new float[3];
    int i = Math.max(Math.max(paramInt1, paramInt2), paramInt3);
    int j = Math.min(Math.min(paramInt1, paramInt2), paramInt3);
    if (i == j) {
      arrayOfFloat[0] = 0.0F;
    }
    for (;;)
    {
      arrayOfFloat[2] = ((i + j) * 0.5F / 255.0F);
      if (i != j) {
        break;
      }
      arrayOfFloat[1] = 0.0F;
      return arrayOfFloat;
      if ((i == paramInt1) && (paramInt2 >= paramInt3)) {
        arrayOfFloat[0] = ((paramInt2 - paramInt3) * 60.0F / (i - j) / 360.0F);
      } else if (i == paramInt1) {
        arrayOfFloat[0] = (((paramInt2 - paramInt3) * 60.0F / (i - j) + 360.0F) / 360.0F);
      } else if (i == paramInt2) {
        arrayOfFloat[0] = (((paramInt3 - paramInt1) * 60.0F / (i - j) + 120.0F) / 360.0F);
      } else {
        arrayOfFloat[0] = (((paramInt1 - paramInt2) * 60.0F / (i - j) + 240.0F) / 360.0F);
      }
    }
    if (arrayOfFloat[2] <= 0.5D)
    {
      arrayOfFloat[1] = ((i - j) / (arrayOfFloat[2] * 2.0F) / 255.0F);
      return arrayOfFloat;
    }
    arrayOfFloat[1] = ((i - j) / (2.0F - arrayOfFloat[2] * 2.0F) / 255.0F);
    return arrayOfFloat;
  }
  
  public static Point rotate(int paramInt1, int paramInt2, int paramInt3)
  {
    int j;
    int i;
    if (paramInt3 != 90)
    {
      j = paramInt1;
      i = paramInt2;
      if (paramInt3 != 270) {}
    }
    else
    {
      paramInt1 += paramInt2;
      i = paramInt1 - paramInt2;
      j = paramInt1 - i;
    }
    return new Point(j, i);
  }
  
  public static List<float[]> rotateAngles(List<float[]> paramList, int paramInt)
  {
    if (paramList == null) {
      return null;
    }
    paramInt = (paramInt + 360) % 360;
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      float[] arrayOfFloat = (float[])paramList.next();
      if ((paramInt == 90) || (paramInt == 270)) {
        localArrayList.add(new float[] { -arrayOfFloat[1], -arrayOfFloat[0], (float)(arrayOfFloat[2] + paramInt * 3.141592653589793D / 180.0D) });
      } else {
        localArrayList.add(new float[] { arrayOfFloat[0], arrayOfFloat[1], (float)(arrayOfFloat[2] + paramInt * 3.141592653589793D / 180.0D) });
      }
    }
    return localArrayList;
  }
  
  public static float[] rotateAngles(float[] paramArrayOfFloat, int paramInt)
  {
    float[] arrayOfFloat = new float[3];
    if (paramArrayOfFloat == null) {
      return arrayOfFloat;
    }
    paramInt = (paramInt + 360) % 360;
    if ((paramInt == 90) || (paramInt == 270)) {
      return new float[] { -paramArrayOfFloat[1], -paramArrayOfFloat[0], (float)(paramArrayOfFloat[2] + paramInt * 3.141592653589793D / 180.0D) };
    }
    return new float[] { paramArrayOfFloat[0], paramArrayOfFloat[1], (float)(paramArrayOfFloat[2] + paramInt * 3.141592653589793D / 180.0D) };
  }
  
  public static List<FaceStatus> rotateFaceStatusFor3D(List<FaceStatus> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramList != null)
    {
      int j = 0;
      int i = paramInt3;
      paramInt3 = j;
      if (paramInt3 < paramList.size())
      {
        FaceStatus localFaceStatus = (FaceStatus)paramList.get(paramInt3);
        i = (i + 360) % 360;
        float f;
        label93:
        android.graphics.Matrix localMatrix;
        if (i == 90)
        {
          f = localFaceStatus.pitch;
          localFaceStatus.pitch = (-localFaceStatus.yaw);
          localFaceStatus.yaw = f;
          localFaceStatus.roll += i;
          localMatrix = new android.graphics.Matrix();
          localMatrix.reset();
          localMatrix.postTranslate(-paramInt1 / 2.0F, -paramInt2 / 2.0F);
          localMatrix.postRotate(i, 0.0F, 0.0F);
          if ((i != 90) && (i != 270)) {
            break label316;
          }
          localMatrix.postTranslate(paramInt2 / 2.0F, paramInt1 / 2.0F);
        }
        for (;;)
        {
          float[] arrayOfFloat = new float[2];
          localMatrix.mapPoints(arrayOfFloat, new float[] { localFaceStatus.tx, localFaceStatus.ty });
          localFaceStatus.tx = arrayOfFloat[0];
          localFaceStatus.ty = arrayOfFloat[1];
          paramInt3 += 1;
          break;
          if (i == 180)
          {
            localFaceStatus.pitch = (-localFaceStatus.pitch);
            localFaceStatus.yaw = (-localFaceStatus.yaw);
            localFaceStatus.roll += i;
            break label93;
          }
          if (i != 270) {
            break label93;
          }
          f = localFaceStatus.pitch;
          localFaceStatus.pitch = localFaceStatus.yaw;
          localFaceStatus.yaw = (-f);
          localFaceStatus.roll += i;
          break label93;
          label316:
          localMatrix.postTranslate(paramInt1 / 2.0F, paramInt2 / 2.0F);
        }
      }
    }
    return paramList;
  }
  
  public static PointF rotatePoint(PointF paramPointF, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramPointF == null) {
      return null;
    }
    paramInt3 = (paramInt3 + 360) % 360;
    android.graphics.Matrix localMatrix = new android.graphics.Matrix();
    localMatrix.reset();
    localMatrix.postTranslate(-paramInt1 / 2.0F, -paramInt2 / 2.0F);
    localMatrix.postRotate(paramInt3, 0.0F, 0.0F);
    if ((paramInt3 == 90) || (paramInt3 == 270)) {
      localMatrix.postTranslate(paramInt2 / 2.0F, paramInt1 / 2.0F);
    }
    for (;;)
    {
      float[] arrayOfFloat = new float[2];
      localMatrix.mapPoints(arrayOfFloat, new float[] { paramPointF.x, paramPointF.y });
      paramPointF.x = arrayOfFloat[0];
      paramPointF.y = arrayOfFloat[1];
      return paramPointF;
      localMatrix.postTranslate(paramInt1 / 2.0F, paramInt2 / 2.0F);
    }
  }
  
  public static List<PointF> rotatePoints(List<PointF> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if (paramList == null)
    {
      localObject = null;
      return localObject;
    }
    paramInt3 = (paramInt3 + 360) % 360;
    android.graphics.Matrix localMatrix = new android.graphics.Matrix();
    localMatrix.reset();
    localMatrix.postTranslate(-paramInt1 / 2.0F, -paramInt2 / 2.0F);
    localMatrix.postRotate(paramInt3, 0.0F, 0.0F);
    if ((paramInt3 == 90) || (paramInt3 == 270)) {
      localMatrix.postTranslate(paramInt2 / 2.0F, paramInt1 / 2.0F);
    }
    for (;;)
    {
      float[] arrayOfFloat1 = new float[2];
      float[] arrayOfFloat2 = new float[2];
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        localObject = paramList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (PointF)localIterator.next();
        arrayOfFloat1[0] = ((PointF)localObject).x;
        arrayOfFloat1[1] = ((PointF)localObject).y;
        localMatrix.mapPoints(arrayOfFloat2, arrayOfFloat1);
        ((PointF)localObject).x = arrayOfFloat2[0];
        ((PointF)localObject).y = arrayOfFloat2[1];
      }
      localMatrix.postTranslate(paramInt1 / 2.0F, paramInt2 / 2.0F);
    }
  }
  
  public static List<float[]> rotatePointsForFloat3DList(List<float[]> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt4 == 0) {}
    for (;;)
    {
      return paramList;
      if ((paramList != null) && (paramInt1 > 0))
      {
        int i = 0;
        int j = paramInt4;
        paramInt4 = i;
        while (paramInt4 < paramList.size())
        {
          float[] arrayOfFloat = (float[])paramList.get(paramInt4);
          i = j;
          if (arrayOfFloat != null)
          {
            i = j;
            if (arrayOfFloat.length >= paramInt1 * 3)
            {
              int k = (j + 360) % 360;
              j = 0;
              i = k;
              if (j < arrayOfFloat.length)
              {
                float f1;
                float f2;
                float f3;
                if (k == 90)
                {
                  f1 = arrayOfFloat[(j + 1)];
                  f2 = paramInt2 - 1;
                  f3 = arrayOfFloat[j];
                  arrayOfFloat[j] = f1;
                  arrayOfFloat[(j + 1)] = (f2 - f3);
                }
                for (;;)
                {
                  j += 3;
                  break;
                  if (k == 180)
                  {
                    f1 = paramInt2 - 1;
                    f2 = arrayOfFloat[j];
                    f3 = paramInt3 - 1;
                    float f4 = arrayOfFloat[(j + 1)];
                    arrayOfFloat[j] = (f1 - f2);
                    arrayOfFloat[(j + 1)] = (f3 - f4);
                  }
                  else if (k == 270)
                  {
                    f1 = paramInt3 - 1;
                    f2 = arrayOfFloat[(j + 1)];
                    f3 = arrayOfFloat[j];
                    arrayOfFloat[j] = (f1 - f2);
                    arrayOfFloat[(j + 1)] = f3;
                  }
                }
              }
            }
          }
          paramInt4 += 1;
          j = i;
        }
      }
    }
  }
  
  public static List<List<PointF>> rotatePointsForList(List<List<PointF>> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramList == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(rotatePoints((List)paramList.next(), paramInt1, paramInt2, paramInt3));
    }
    return localArrayList;
  }
  
  public static void sRGB2XYZ(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    double d3 = paramArrayOfDouble1[0];
    double d2 = paramArrayOfDouble1[1];
    double d1 = paramArrayOfDouble1[2];
    double d4 = d3 / 255.0D;
    d2 /= 255.0D;
    d3 = d1 / 255.0D;
    if (d4 <= 0.04045D)
    {
      d1 = d4 / 12.92D;
      if (d2 > 0.04045D) {
        break label174;
      }
      d2 /= 12.92D;
      label70:
      if (d3 > 0.04045D) {
        break label195;
      }
    }
    label174:
    label195:
    for (d3 /= 12.92D;; d3 = Math.pow((0.055D + d3) / 1.055D, 2.4D))
    {
      paramArrayOfDouble2[0] = (41.240000000000002D * d1 + 35.759999999999998D * d2 + 18.050000000000001D * d3);
      paramArrayOfDouble2[1] = (21.260000000000002D * d1 + 71.519999999999996D * d2 + 7.2D * d3);
      paramArrayOfDouble2[2] = (d3 * 95.049999999999997D + (d2 * 11.92D + d1 * 1.93D));
      return;
      d1 = Math.pow((d4 + 0.055D) / 1.055D, 2.4D);
      break;
      d2 = Math.pow((0.055D + d2) / 1.055D, 2.4D);
      break label70;
    }
  }
  
  public static boolean samePeople(List<PointF> paramList1, List<PointF> paramList2)
  {
    if ((paramList1.size() < 83) || (paramList2.size() < 83)) {
      return false;
    }
    float f1 = ((PointF)paramList1.get(0)).x;
    f1 = (((PointF)paramList1.get(18)).x + f1) / 2.0F;
    float f2 = ((PointF)paramList1.get(0)).y;
    PointF localPointF1 = new PointF(f1, (((PointF)paramList1.get(18)).y + f2) / 2.0F);
    f1 = ((PointF)paramList2.get(0)).x;
    f1 = (((PointF)paramList2.get(18)).x + f1) / 2.0F;
    f2 = ((PointF)paramList2.get(0)).y;
    PointF localPointF2 = new PointF(f1, (((PointF)paramList2.get(18)).y + f2) / 2.0F);
    f1 = Math.min(getDistance((PointF)paramList1.get(0), (PointF)paramList1.get(18)), getDistance((PointF)paramList2.get(0), (PointF)paramList2.get(18)));
    return getDistance(localPointF1, localPointF2) < f1 * 0.5F;
  }
  
  private static double[] secondDerivative(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int j = paramArrayOfInt1.length;
    double[][] arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { j, 3 });
    double[] arrayOfDouble1 = new double[j];
    arrayOfDouble[0][1] = 4607182418800017408L;
    int i = 1;
    while (i < j - 1)
    {
      arrayOfDouble[i][0] = ((paramArrayOfInt1[i] - paramArrayOfInt1[(i - 1)]) / 6.0D);
      arrayOfDouble[i][1] = ((paramArrayOfInt1[(i + 1)] - paramArrayOfInt1[(i - 1)]) / 3.0D);
      arrayOfDouble[i][2] = ((paramArrayOfInt1[(i + 1)] - paramArrayOfInt1[i]) / 6.0D);
      arrayOfDouble1[i] = ((paramArrayOfInt2[(i + 1)] - paramArrayOfInt2[i]) / (paramArrayOfInt1[(i + 1)] - paramArrayOfInt1[i]) - (paramArrayOfInt2[i] - paramArrayOfInt2[(i - 1)]) / (paramArrayOfInt1[i] - paramArrayOfInt1[(i - 1)]));
      i += 1;
    }
    arrayOfDouble[(j - 1)][1] = 4607182418800017408L;
    i = 1;
    double d;
    while (i < j)
    {
      d = arrayOfDouble[i][0] / arrayOfDouble[(i - 1)][1];
      paramArrayOfInt1 = arrayOfDouble[i];
      paramArrayOfInt1[1] -= arrayOfDouble[(i - 1)][2] * d;
      arrayOfDouble[i][0] = 0L;
      arrayOfDouble1[i] -= d * arrayOfDouble1[(i - 1)];
      i += 1;
    }
    i = j - 2;
    while (i >= 0)
    {
      d = arrayOfDouble[i][2] / arrayOfDouble[(i + 1)][1];
      paramArrayOfInt1 = arrayOfDouble[i];
      paramArrayOfInt1[1] -= arrayOfDouble[(i + 1)][0] * d;
      arrayOfDouble[i][2] = 0L;
      arrayOfDouble1[i] -= d * arrayOfDouble1[(i + 1)];
      i -= 1;
    }
    paramArrayOfInt1 = new double[j];
    i = 0;
    while (i < j)
    {
      arrayOfDouble1[i] /= arrayOfDouble[i][1];
      i += 1;
    }
    return paramArrayOfInt1;
  }
  
  public static double spacing(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() == 2)
    {
      float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
      float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
      return Math.sqrt(f1 * f1 + f2 * f2);
    }
    return 0.0D;
  }
  
  public static List<Float> substract(List<Float> paramList, float[] paramArrayOfFloat)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramArrayOfFloat == null)) {
      return localArrayList;
    }
    int i = 0;
    while (i < Math.min(paramList.size(), paramArrayOfFloat.length))
    {
      localArrayList.add(Float.valueOf(((Float)paramList.get(i)).floatValue() - paramArrayOfFloat[i]));
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.util.AlgoUtils
 * JD-Core Version:    0.7.0.1
 */