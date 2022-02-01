package com.tencent.ttpic.thread;

import android.annotation.TargetApi;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.AsyncTask;
import android.util.Pair;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.AEProfiler;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.filter.StarEffectFilter;
import com.tencent.ttpic.openapi.facedetect.FaceDetector;
import com.tencent.ttpic.openapi.gles.GLSegSharedData;
import com.tencent.ttpic.openapi.gles.SegmentDataPipe;
import com.tencent.ttpic.openapi.model.StarParam;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.RetrieveDataManager;
import com.tencent.ttpic.openapi.util.RetrieveDataManager.DATA_TYPE;
import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FrameUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@TargetApi(18)
public class FaceGestureDetGLThread
{
  private static final long BRIGHTNESS_DURATION = 2000L;
  private static final String TAG = "FaceGestureDetGLThread";
  private int[] autoContrastCurve = new int[256];
  private double averageFaceL = 60.0D;
  private int[] brightnessAdjustmentCurve = new int[256];
  private byte[] brightnessAdjustmentData;
  private int curLevel;
  private int[] his;
  private int[] hisAutoContrast = new int[256];
  private Pair<Integer, int[]> histogram = null;
  private int inputHeight;
  private int inputWidth;
  private int[] lastAutoContrastCurve = new int[256];
  private final Object mBodyDetLock = new Object();
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame mCopyFrame;
  private VideoPreviewFaceOutlineDetector mFaceDetector = new VideoPreviewFaceOutlineDetector();
  private boolean mInitReady;
  private long mLastBrightnessTime = -1L;
  private FaceGestureDetGLThread.OnFaceDetListener mListener;
  private BaseFilter mRotateFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
  private Frame mRotateFrame;
  private StarEffectFilter mStarEffectFilter = new StarEffectFilter();
  private int[][][][] matrixCbs;
  private int[][][][] matrixCrs;
  private int[][] matrixRL;
  private GLSegSharedData sharedData;
  private ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
  private float[] whitenBalanceRGBGain = { 1.0F, 1.0F, 1.0F };
  
  public FaceGestureDetGLThread(EGLContext paramEGLContext)
  {
    this(paramEGLContext, false);
  }
  
  public FaceGestureDetGLThread(EGLContext paramEGLContext, boolean paramBoolean)
  {
    this.mCopyFilter.apply();
    this.mStarEffectFilter.initial();
    this.sharedData = new GLSegSharedData();
    this.mCopyFrame = new Frame();
    this.mRotateFilter.apply();
    this.mRotateFrame = new Frame();
    AlgoUtils.resetBrightnessAdjustmentCurve(this.brightnessAdjustmentCurve);
    if (this.mFaceDetector.init() != 0)
    {
      this.mInitReady = false;
      return;
    }
    this.mInitReady = true;
  }
  
  private void createBrightnessCurve(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte)
  {
    double[] arrayOfDouble1 = new double[3];
    double[] arrayOfDouble2 = new double[3];
    double[] arrayOfDouble3 = new double[3];
    double d1 = 0.0D;
    double d2 = 0.0D;
    while (paramInt1 <= paramInt2)
    {
      paramInt6 = paramInt3;
      while (paramInt6 <= paramInt4)
      {
        int j = (paramInt6 * paramInt5 + paramInt1) * 4;
        double d4 = d2;
        double d3 = d1;
        if (j >= 0)
        {
          int k = j + 2;
          d4 = d2;
          d3 = d1;
          if (k < paramArrayOfByte.length)
          {
            int i = paramArrayOfByte[j];
            j = paramArrayOfByte[(j + 1)];
            k = paramArrayOfByte[k];
            int[] arrayOfInt = this.lastAutoContrastCurve;
            i = arrayOfInt[(i & 0xFF)];
            j = arrayOfInt[(j & 0xFF)];
            k = arrayOfInt[(k & 0xFF)];
            arrayOfDouble1[0] = i;
            arrayOfDouble1[1] = j;
            arrayOfDouble1[2] = k;
            AlgoUtils.sRGB2XYZ(arrayOfDouble1, arrayOfDouble2);
            AlgoUtils.XYZ2Lab(arrayOfDouble2, arrayOfDouble3);
            d4 = d2 + arrayOfDouble3[0];
            d3 = d1 + 1.0D;
          }
        }
        paramInt6 += 1;
        d2 = d4;
        d1 = d3;
      }
      paramInt1 += 1;
    }
    if (d1 != 0.0D)
    {
      this.averageFaceL = (d2 / d1);
      d1 = this.averageFaceL;
      if ((d1 >= 60.0D) && (d1 <= 75.0D))
      {
        resetBrightnessAdjustmentCurve();
        return;
      }
      d1 = this.averageFaceL;
      if (d1 < 60.0D) {
        paramInt1 = (int)((60.0D - d1) * 1.0D + 128.0D);
      } else {
        paramInt1 = (int)((75.0D - d1) * 0.8D + 128.0D);
      }
      paramArrayOfByte = this.brightnessAdjustmentCurve;
      AlgoUtils.getPreparedSpline(new int[] { 0, 128, 255 }, new int[] { 0, paramInt1, 255 }, paramArrayOfByte);
    }
  }
  
  private double getInterpolateValue(double paramDouble, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, List<Double> paramList1, List<Double> paramList2, List<Double> paramList3)
  {
    int i = paramArrayOfDouble1.length - 1;
    if (paramDouble == paramArrayOfDouble1[i]) {
      return paramArrayOfDouble2[i];
    }
    i = paramList3.size() - 1;
    int j = 0;
    while (j <= i)
    {
      d = j + i;
      Double.isNaN(d);
      int k = (int)Math.floor(d * 0.5D);
      d = paramArrayOfDouble1[k];
      if (d < paramDouble) {
        j = k + 1;
      } else if (d > paramDouble) {
        i = k - 1;
      } else {
        return paramArrayOfDouble2[k];
      }
    }
    i = Math.max(0, i);
    paramDouble -= paramArrayOfDouble1[i];
    double d = paramDouble * paramDouble;
    return paramArrayOfDouble2[i] + ((Double)paramList1.get(i)).doubleValue() * paramDouble + ((Double)paramList2.get(i)).doubleValue() * d + ((Double)paramList3.get(i)).doubleValue() * paramDouble * d;
  }
  
  private float[] getRGBGain(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int m = (int)(FaceDetector.FACE_DETECT_WIDTH / 90.0F);
    int n = paramInt1 / m / 5 * 5;
    int i = paramInt2 / m / 5 * 5;
    Object localObject1 = this.matrixRL;
    if ((localObject1 == null) || (localObject1.length != n) || (localObject1[0].length != i)) {
      this.matrixRL = ((int[][])Array.newInstance(Integer.TYPE, new int[] { n, i }));
    }
    localObject1 = this.matrixCrs;
    if ((localObject1 == null) || (localObject1[0][0].length != n / 5) || (localObject1[0][0][0].length != i / 5)) {
      this.matrixCrs = ((int[][][][])Array.newInstance(Integer.TYPE, new int[] { 5, 5, n / 5, i / 5 }));
    }
    localObject1 = this.matrixCbs;
    if ((localObject1 == null) || (localObject1[0][0].length != n / 5) || (localObject1[0][0][0].length != i / 5)) {
      this.matrixCbs = ((int[][][][])Array.newInstance(Integer.TYPE, new int[] { 5, 5, n / 5, i / 5 }));
    }
    int j = 0;
    int i4;
    int i3;
    while (j < n)
    {
      paramInt2 = 0;
      while (paramInt2 < i)
      {
        i2 = (paramInt2 * m * paramInt1 + j * m) * 4;
        if (i2 >= 0)
        {
          i1 = i2 + 2;
          if (i1 < paramArrayOfByte.length)
          {
            k = paramArrayOfByte[i2];
            i2 = paramArrayOfByte[(i2 + 1)];
            i1 = paramArrayOfByte[i1];
            d1 = k & 0xFF;
            Double.isNaN(d1);
            f1 = i2 & 0xFF;
            k = paramInt2;
            d2 = f1;
            Double.isNaN(d2);
            d3 = i1 & 0xFF;
            Double.isNaN(d3);
            i4 = (int)(0.299D * d1 + 0.587D * d2 + 0.114D * d3);
            Double.isNaN(d1);
            Double.isNaN(d2);
            Double.isNaN(d3);
            i1 = (int)(-0.169D * d1 + -0.331D * d2 + d3 * 0.5D + 128.0D);
            Double.isNaN(d1);
            Double.isNaN(d2);
            Double.isNaN(d3);
            i2 = (int)(d1 * 0.5D + d2 * -0.419D + d3 * -0.081D + 128.0D);
            int i6 = n / 5;
            i3 = i / 5;
            this.matrixRL[j][k] = i4;
            localObject1 = this.matrixCrs;
            i4 = j / i6;
            localObject1 = localObject1[i4];
            int i5 = k / i3;
            localObject1 = localObject1[i5];
            i6 = j % i6;
            localObject1 = localObject1[i6];
            k %= i3;
            localObject1[k] = i1;
            this.matrixCbs[i4][i5][i6][k] = i2;
          }
        }
        paramInt2 += 1;
      }
      j += 1;
    }
    j = i;
    double d2 = 0.0D;
    double d3 = d2;
    double d4 = d3;
    double d1 = d4;
    int k = 0;
    paramInt2 = n;
    double d5;
    while (k < 5)
    {
      n = 0;
      i = m;
      while (n < 5)
      {
        m = 0;
        l1 = 0L;
        l2 = 0L;
        for (;;)
        {
          i1 = paramInt2 / 5;
          if (m >= i1) {
            break;
          }
          i1 = 0;
          while (i1 < j / 5)
          {
            l1 += this.matrixCrs[k][n][m][i1];
            l2 += this.matrixCbs[k][n][m][i1];
            i1 += 1;
          }
          m += 1;
        }
        long l3 = i1 * j / 5;
        d5 = l1 / l3;
        double d6 = l2 / l3;
        i2 = 0;
        l2 = 0L;
        l1 = 0L;
        m = i1;
        i1 = i2;
        while (i1 < m)
        {
          long l4 = l1;
          i2 = 0;
          l1 = l2;
          l2 = l4;
          while (i2 < j / 5)
          {
            d7 = l1;
            d8 = this.matrixCrs[k][n][i1][i2];
            Double.isNaN(d8);
            Double.isNaN(d5);
            d8 = Math.abs(d8 - d5);
            Double.isNaN(d7);
            l1 = (d7 + d8);
            d7 = l2;
            d8 = this.matrixCbs[k][n][i1][i2];
            Double.isNaN(d8);
            Double.isNaN(d6);
            d8 = Math.abs(d8 - d6);
            Double.isNaN(d7);
            l2 = (d7 + d8);
            i2 += 1;
          }
          i1 += 1;
          l4 = l2;
          l2 = l1;
          l1 = l4;
        }
        double d8 = l2 / l3;
        double d9 = l1 / l3;
        double d7 = 5;
        Double.isNaN(d6);
        Double.isNaN(d7);
        d6 /= d7;
        Double.isNaN(d7);
        d6 /= d7;
        Double.isNaN(d5);
        Double.isNaN(d7);
        d5 /= d7;
        Double.isNaN(d7);
        d5 /= d7;
        Double.isNaN(d9);
        Double.isNaN(d7);
        d9 /= d7;
        Double.isNaN(d7);
        d9 /= d7;
        Double.isNaN(d8);
        Double.isNaN(d7);
        d8 /= d7;
        Double.isNaN(d7);
        d4 += d8 / d7;
        n += 1;
        d2 += d5;
        d1 += d6;
        d3 += d9;
      }
      k += 1;
      m = i;
    }
    i = 0;
    while (i < 5)
    {
      k = 0;
      while (k < 5)
      {
        n = 0;
        for (;;)
        {
          i2 = paramInt2 / 5;
          if (n >= i2) {
            break;
          }
          i1 = 0;
          for (;;)
          {
            i4 = j / 5;
            if (i1 >= i4) {
              break;
            }
            i3 = i * i2 + n;
            i4 = i4 * k + i1;
            d5 = this.matrixCbs[i][k][n][i1];
            Double.isNaN(d5);
            if (d5 - (d1 + d3) < d3 * 1.5D)
            {
              d5 = this.matrixCrs[i][k][n][i1];
              Double.isNaN(d5);
              if (d5 - (d2 * 1.5D + d4) < 1.5D * d4) {
                break label1338;
              }
            }
            this.matrixRL[i3][i4] = 0;
            label1338:
            localObject1 = this.matrixRL;
            if (localObject1[i3][i4] >= 250) {
              localObject1[i3][i4] = 0;
            }
            i1 += 1;
          }
          n += 1;
        }
        k += 1;
      }
      i += 1;
    }
    int i2 = 250;
    localObject1 = new int[256];
    k = 0;
    i = 0;
    n = j;
    j = k;
    while (j < paramInt2)
    {
      k = 0;
      while (k < n)
      {
        localObject2 = this.matrixRL;
        i1 = i;
        if (localObject2[j][k] != 0)
        {
          i1 = localObject2[j][k];
          localObject1[i1] += 1;
          i1 = i + 1;
        }
        k += 1;
        i = i1;
      }
      j += 1;
    }
    int i1 = 0;
    k = 0;
    j = i2;
    while (j != 0)
    {
      i1 += localObject1[j] * j;
      k += localObject1[j];
      if (k > i / 10)
      {
        i = i1 / k;
        break label1589;
      }
      j -= 1;
    }
    i = 0;
    j = 0;
    label1589:
    if (j == 0) {
      return new float[] { 1.0F, 1.0F, 1.0F };
    }
    localObject1 = new float[3];
    Object localObject2 = new long[3];
    i1 = 0;
    while (i1 < paramInt2)
    {
      i2 = 0;
      while (i2 < n)
      {
        if (this.matrixRL[i1][i2] >= j)
        {
          i3 = (i2 * m * paramInt1 + i1 * m) * 4;
          localObject2[0] += (paramArrayOfByte[i3] & 0xFF);
          localObject2[1] += (paramArrayOfByte[(i3 + 1)] & 0xFF);
          localObject2[2] += (paramArrayOfByte[(i3 + 2)] & 0xFF);
        }
        i2 += 1;
      }
      i1 += 1;
    }
    float f1 = i;
    long l1 = localObject2[0];
    long l2 = k;
    localObject1[0] = (f1 / (float)(l1 / l2));
    localObject1[1] = (f1 / (float)(localObject2[1] / l2));
    localObject1[2] = (f1 / (float)(localObject2[2] / l2));
    float f6 = localObject1[0] - 1.0F;
    float f5 = localObject1[1] - 1.0F;
    float f4 = localObject1[2] - 1.0F;
    float f3;
    float f2;
    if ((Math.abs(f6) <= 0.05D) && (Math.abs(f5) <= 0.05D))
    {
      f3 = f6;
      f2 = f5;
      f1 = f4;
      if (Math.abs(f4) <= 0.05D) {}
    }
    else
    {
      f1 = Math.max(Math.max(Math.abs(f6), Math.abs(f5)), Math.abs(f4));
      f3 = f6 / f1 * 0.05F;
      f2 = f5 / f1 * 0.05F;
      f1 = f4 / f1 * 0.05F;
    }
    localObject1[0] = (f3 + 1.0F);
    localObject1[1] = (f2 + 1.0F);
    localObject1[2] = (f1 + 1.0F);
    return localObject1;
  }
  
  private void resetBrightnessAdjustmentCurve()
  {
    try
    {
      this.brightnessAdjustmentCurve = new int[256];
      int i = 0;
      while (i < 256)
      {
        this.brightnessAdjustmentCurve[i] = i;
        i += 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void switchBrightnessAdjustment(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    byte[] arrayOfByte = this.brightnessAdjustmentData;
    if ((arrayOfByte == null) || (arrayOfByte.length != paramArrayOfByte.length)) {
      this.brightnessAdjustmentData = new byte[paramArrayOfByte.length];
    }
    System.arraycopy(paramArrayOfByte, 0, this.brightnessAdjustmentData, 0, paramArrayOfByte.length);
    paramArrayOfByte = this.autoContrastCurve;
    System.arraycopy(paramArrayOfByte, 0, this.lastAutoContrastCurve, 0, paramArrayOfByte.length);
    if (!this.singleThreadExecutor.isShutdown())
    {
      if (this.singleThreadExecutor.isTerminated()) {
        return;
      }
      this.singleThreadExecutor.execute(new FaceGestureDetGLThread.3(this, paramInt1, paramInt2));
    }
  }
  
  public void destroy()
  {
    Object localObject = this.sharedData;
    if (localObject != null) {
      ((GLSegSharedData)localObject).clear();
    }
    localObject = this.mCopyFrame;
    if (localObject != null) {
      ((Frame)localObject).clear();
    }
    localObject = this.mCopyFilter;
    if (localObject != null) {
      ((BaseFilter)localObject).clearGLSL();
    }
    localObject = this.mRotateFilter;
    if (localObject != null) {
      ((BaseFilter)localObject).clearGLSL();
    }
    localObject = this.mRotateFrame;
    if (localObject != null) {
      ((Frame)localObject).clear();
    }
    localObject = this.mStarEffectFilter;
    if (localObject != null) {
      ((StarEffectFilter)localObject).clear();
    }
    localObject = this.singleThreadExecutor;
    if (localObject != null) {
      ((ExecutorService)localObject).shutdownNow();
    }
  }
  
  public VideoPreviewFaceOutlineDetector getDetector()
  {
    return this.mFaceDetector;
  }
  
  public String getHistogramInfo()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("averageL: ");
    localStringBuilder.append((int)this.averageFaceL);
    localStringBuilder.append("\n");
    localStringBuffer.append(localStringBuilder.toString());
    return localStringBuffer.toString();
  }
  
  public int getLastFaceDetectedPhoneRotation()
  {
    VideoPreviewFaceOutlineDetector localVideoPreviewFaceOutlineDetector = this.mFaceDetector;
    if (localVideoPreviewFaceOutlineDetector != null) {
      return localVideoPreviewFaceOutlineDetector.getLastFaceDetectedPhoneRotation();
    }
    return 0;
  }
  
  public boolean isInitReady()
  {
    return this.mInitReady;
  }
  
  public void onPreviewStartPreImmediately()
  {
    this.mLastBrightnessTime = -1L;
    resetBrightnessAdjustmentCurve();
  }
  
  public void postFaceDetectorDestroy()
  {
    this.mFaceDetector.destroy();
    RetrieveDataManager.getInstance().clear();
  }
  
  public SegmentDataPipe postFaceGestureDet(Frame paramFrame, double paramDouble, boolean paramBoolean1, boolean paramBoolean2, int paramInt, StarParam paramStarParam, boolean paramBoolean3)
  {
    AEProfiler.getInstance().start("PTFaceDetect-detect", true);
    if (this.mListener == null) {
      return null;
    }
    Frame localFrame = FrameUtil.rotateCorrect(paramFrame, paramFrame.width, paramFrame.height, paramInt, this.mRotateFilter, this.mRotateFrame);
    GLES20.glFinish();
    paramFrame = this.sharedData.getFreeTexturePileMakeBusy();
    if (paramFrame == null) {
      return null;
    }
    paramFrame.mTimestamp = System.currentTimeMillis();
    if ((this.inputWidth != localFrame.width) || (this.inputHeight != localFrame.height)) {
      RetrieveDataManager.getInstance().clear();
    }
    this.inputWidth = localFrame.width;
    this.inputHeight = localFrame.height;
    double d = localFrame.width;
    Double.isNaN(d);
    int i = (int)(d * paramDouble);
    d = localFrame.height;
    Double.isNaN(d);
    int j = (int)(d * paramDouble);
    if (localFrame.height > 2560)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("faceDetectFrame [");
      ((StringBuilder)localObject).append(localFrame.width);
      ((StringBuilder)localObject).append("x");
      ((StringBuilder)localObject).append(localFrame.height);
      ((StringBuilder)localObject).append("] faceDetectScale = ");
      ((StringBuilder)localObject).append(paramDouble);
      LogUtils.d("GetHistogram", ((StringBuilder)localObject).toString());
    }
    paramFrame.mTexFrame = localFrame;
    Object localObject = RetrieveDataManager.getInstance().retrieveData(RetrieveDataManager.DATA_TYPE.RGBA.value, localFrame.getTextureId(), i, j);
    try
    {
      if ((paramFrame.mData == null) || (paramFrame.mData.length != localObject.length)) {
        paramFrame.mData = new byte[localObject.length];
      }
      System.arraycopy(localObject, 0, paramFrame.mData, 0, localObject.length);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
    CountDownLatch localCountDownLatch1 = new CountDownLatch(1);
    AsyncTask.THREAD_POOL_EXECUTOR.execute(new FaceGestureDetGLThread.1(this, (byte[])localObject, i, j, localCountDownLatch1));
    this.mFaceDetector.init();
    this.mFaceDetector.autoChangeFaceRefine(i, j, paramInt);
    this.mFaceDetector.setFaceKitVerticesArray(paramFrame.faceKitVerticesArray);
    this.mFaceDetector.setFace3DVerticesArray(paramFrame.face3DVerticesArray);
    this.mFaceDetector.setFace3DRotationArray(paramFrame.face3DRotationArray);
    this.mFaceDetector.setFeatureIndicesArray(paramFrame.featureIndicesArray);
    this.mFaceDetector.setFacePiont2DCenter(paramFrame.facePiont2DCenter);
    if (paramBoolean2) {
      this.mFaceDetector.reset();
    }
    if (paramBoolean1) {
      this.mFaceDetector.doDectectTrackByRGBA(paramFrame.mData, i, j);
    } else {
      this.mFaceDetector.doTrackByRGBA(paramFrame.mData, i, j, paramInt);
    }
    long l1 = this.mFaceDetector.getFaceTrackTime();
    this.mFaceDetector.updateAllFaceExpression(paramBoolean3);
    long l2 = System.currentTimeMillis();
    CountDownLatch localCountDownLatch2 = new CountDownLatch(1);
    long l3 = this.mLastBrightnessTime;
    if (l3 <= 0L)
    {
      this.mLastBrightnessTime = (l2 - 2000L + 2000L);
    }
    else if (l2 - l3 >= 2000L)
    {
      AsyncTask.THREAD_POOL_EXECUTOR.execute(new FaceGestureDetGLThread.2(this, (byte[])localObject, i, j, localCountDownLatch2));
      this.mLastBrightnessTime = l2;
      i = 1;
      break label600;
    }
    i = 0;
    label600:
    if (i == 0) {
      localCountDownLatch2.countDown();
    }
    paramFrame.faceInfos = this.mFaceDetector.getAllFaceInfos();
    paramFrame.allFacePoints = this.mFaceDetector.getAllFaces();
    paramFrame.allIrisPoints = this.mFaceDetector.getAllIris();
    paramFrame.allFaceAngles = this.mFaceDetector.getAllFaceAngles();
    paramFrame.allPointsVis = this.mFaceDetector.getAllPointsVis();
    paramFrame.mTriggeredExpressionType = this.mFaceDetector.getTriggeredExpression();
    paramFrame.expressions = this.mFaceDetector.getExpressions();
    paramFrame.faceStatus = this.mFaceDetector.getFaceStatus3Ds();
    paramFrame.recordFaceInfo = this.mFaceDetector.getRecordFaceInfo();
    paramFrame.faceActionCounter = this.mFaceDetector.getFaceActionCounter();
    paramFrame.rgbGain = this.whitenBalanceRGBGain;
    paramFrame.detectTimes = new HashMap();
    paramFrame.detectTimes.put("sdk_face_detect_time", Long.valueOf(l1));
    processStar(paramFrame, localFrame, paramStarParam, paramInt);
    try
    {
      localCountDownLatch1.await();
      localCountDownLatch2.await();
      paramFrame.histogram = this.histogram;
    }
    catch (InterruptedException paramStarParam)
    {
      paramStarParam.printStackTrace();
    }
    try
    {
      paramStarParam = this.brightnessAdjustmentCurve;
      paramFrame.curve = AlgoUtils.mergeCurve(this.autoContrastCurve, paramStarParam);
      if ((paramFrame.autoContrastCurve == null) || (paramFrame.autoContrastCurve.length < 256)) {
        paramFrame.autoContrastCurve = new int[256];
      }
      System.arraycopy(this.autoContrastCurve, 0, paramFrame.autoContrastCurve, 0, this.autoContrastCurve.length);
      if ((paramFrame.autoBrightnessCurve == null) || (paramFrame.autoBrightnessCurve.length < 256)) {
        paramFrame.autoBrightnessCurve = new int[256];
      }
      System.arraycopy(paramStarParam, 0, paramFrame.autoBrightnessCurve, 0, paramStarParam.length);
      paramFrame.faceAverageL = this.averageFaceL;
      paramFrame.makeDataReady();
      this.sharedData.makeBrotherTextureFree(paramFrame);
      l1 = AEProfiler.getInstance().end("PTFaceDetect-detect", true);
      AEProfiler.getInstance().add(1, "PTFaceDetect-detect", l1);
      return paramFrame;
    }
    finally {}
  }
  
  public void processStar(SegmentDataPipe paramSegmentDataPipe, Frame paramFrame, StarParam paramStarParam, int paramInt)
  {
    if ((paramFrame.width != 0) && (VideoMaterial.needRenderStar(paramStarParam)))
    {
      if (paramStarParam.starType == 0)
      {
        paramSegmentDataPipe.starMaskFrame = this.mStarEffectFilter.getMaskFrame(paramFrame, paramStarParam, paramInt);
        paramSegmentDataPipe.starPoints = new ArrayList();
        return;
      }
      paramSegmentDataPipe.starPoints = this.mStarEffectFilter.getStarPoints(paramFrame, paramStarParam, paramInt);
      paramSegmentDataPipe.starMaskFrame = null;
      return;
    }
    paramSegmentDataPipe.starPoints = new ArrayList();
    paramSegmentDataPipe.starMaskFrame = null;
  }
  
  public void setAgeDetectable(boolean paramBoolean)
  {
    VideoPreviewFaceOutlineDetector localVideoPreviewFaceOutlineDetector = this.mFaceDetector;
    if (localVideoPreviewFaceOutlineDetector != null) {
      localVideoPreviewFaceOutlineDetector.setDetectAge(paramBoolean);
    }
  }
  
  public void setMaxFaceCount(int paramInt)
  {
    VideoPreviewFaceOutlineDetector localVideoPreviewFaceOutlineDetector = this.mFaceDetector;
    if (localVideoPreviewFaceOutlineDetector != null) {
      localVideoPreviewFaceOutlineDetector.setMaxFaceCount(paramInt);
    }
  }
  
  public void setOnFaceDetListener(FaceGestureDetGLThread.OnFaceDetListener paramOnFaceDetListener)
  {
    this.mListener = paramOnFaceDetListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.thread.FaceGestureDetGLThread
 * JD-Core Version:    0.7.0.1
 */