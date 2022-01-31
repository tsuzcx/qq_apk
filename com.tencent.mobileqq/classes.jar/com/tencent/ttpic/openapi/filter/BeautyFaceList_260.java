package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.filter.BeautyEffectCombineFilter_260;
import com.tencent.ttpic.filter.EyeBagBlurFilter;
import com.tencent.ttpic.filter.FaceFeatureAndTeethWhitenFilter;
import com.tencent.ttpic.filter.FaceFeatureFilter_280;
import com.tencent.ttpic.filter.SkinColorAndContrastFilter;
import com.tencent.ttpic.filter.WrinklesRemoveFilter_280;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.factory.TTPicFilterFactoryLocal;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceOffUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.List<Landroid.graphics.PointF;>;

public class BeautyFaceList_260
{
  public static final String TAG = BeautyFaceList.class.getName();
  private List<BeautyFaceList_260.ColorParam> colorParams = new ArrayList();
  private ByteBuffer dstByteBuffer = ByteBuffer.allocateDirect(1048).order(ByteOrder.nativeOrder());
  private float[] faceVertices = new float[1380];
  private int height;
  private boolean isLUT1LoadSuccess = false;
  private boolean isLUT2LoadSuccess = false;
  private float mAlphaWrinkles = 0.0F;
  private float mAlphaWrinklesFlw = 0.0F;
  private BeautyEffectCombineFilter_260 mBeautyEffectCombineFilter = new BeautyEffectCombineFilter_260();
  private EyeBagBlurFilter mBlurFilter1 = new EyeBagBlurFilter();
  private Frame mBlurFrame1 = new Frame();
  private Frame mBlurFrame2 = new Frame();
  private SkinColorAndContrastFilter mContrastFilter = new SkinColorAndContrastFilter();
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  byte[] mData = null;
  private double mFaceDetScale;
  private FaceFeatureAndTeethWhitenFilter mFaceFeatureAndTeethWhitenFilter = new FaceFeatureAndTeethWhitenFilter();
  private FaceFeatureFilter_280 mFaceFeatureFilter = new FaceFeatureFilter_280();
  private int mRenderIndex = 0;
  private boolean mRenderLipsLut = false;
  private int[] mTextures = new int[4];
  private float mToothWhiten = 0.0F;
  private WrinklesRemoveFilter_280 mWrinklesRemoveFilter2 = new WrinklesRemoveFilter_280();
  private boolean openFaceFeture = true;
  private float[] pointVisVertices = new float[1380];
  private FloatBuffer srcByteBuffer = ByteBuffer.allocateDirect(1440).order(ByteOrder.nativeOrder()).asFloatBuffer();
  private int width;
  
  private List<PointF> getFullCoords(List<PointF> paramList)
  {
    int j = 0;
    if (paramList.size() < 90) {
      return paramList;
    }
    Object localObject = paramList;
    if (paramList.size() > 90) {
      localObject = paramList.subList(0, 90);
    }
    float[] arrayOfFloat = new float[262];
    paramList = new float[((List)localObject).size() * 2];
    int i = 0;
    while (i < ((List)localObject).size())
    {
      paramList[(i * 2)] = ((PointF)((List)localObject).get(i)).x;
      paramList[(i * 2 + 1)] = ((PointF)((List)localObject).get(i)).y;
      i += 1;
    }
    this.srcByteBuffer.rewind();
    this.srcByteBuffer.put(paramList).position(0);
    FaceOffUtil.getFullCoords(this.srcByteBuffer, ((List)localObject).size(), 5.0F, this.dstByteBuffer);
    this.dstByteBuffer.asFloatBuffer().get(arrayOfFloat);
    localObject = new ArrayList();
    i = j;
    for (;;)
    {
      paramList = (List<PointF>)localObject;
      if (i >= arrayOfFloat.length) {
        break;
      }
      ((List)localObject).add(new PointF(arrayOfFloat[i], arrayOfFloat[(i + 1)]));
      i += 2;
    }
  }
  
  private void initData(int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.mData == null) || (this.mData.length < paramInt1 * paramInt2 * 4)) {
        this.mData = new byte[paramInt1 * paramInt2 * 4];
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
  
  private boolean isFirstFewFrames()
  {
    return this.mRenderIndex < 20;
  }
  
  private boolean loadLut(Bitmap paramBitmap, int paramInt)
  {
    if (BitmapUtils.isLegal(paramBitmap))
    {
      GlUtil.loadTexture(paramInt, paramBitmap);
      if (BitmapUtils.isLegal(paramBitmap)) {}
      return true;
    }
    return false;
  }
  
  private void updateWrinklesAlpha()
  {
    if ((this.mAlphaWrinkles > 0.01F) && (this.mAlphaWrinklesFlw > 0.01F))
    {
      this.mWrinklesRemoveFilter2.setWrinklesAlpha(this.mAlphaWrinklesFlw);
      this.mBeautyEffectCombineFilter.setWrinkles_flw(0.0F);
      this.mBeautyEffectCombineFilter.setWrinkles(this.mAlphaWrinkles);
      return;
    }
    if (this.mAlphaWrinkles > 0.01F)
    {
      this.mWrinklesRemoveFilter2.setWrinklesAlpha(0.0F);
      this.mBeautyEffectCombineFilter.setWrinkles_flw(0.0F);
      this.mBeautyEffectCombineFilter.setWrinkles(this.mAlphaWrinkles);
      return;
    }
    if (this.mAlphaWrinklesFlw > 0.01F)
    {
      this.mWrinklesRemoveFilter2.setWrinklesAlpha(0.0F);
      this.mBeautyEffectCombineFilter.setWrinkles_flw(this.mAlphaWrinklesFlw);
      this.mBeautyEffectCombineFilter.setWrinkles(0.0F);
      return;
    }
    this.mWrinklesRemoveFilter2.setWrinklesAlpha(0.0F);
    this.mBeautyEffectCombineFilter.setWrinkles_flw(0.0F);
    this.mBeautyEffectCombineFilter.setWrinkles(0.0F);
  }
  
  public void clear()
  {
    this.mBeautyEffectCombineFilter.clearGLSLSelf();
    this.mFaceFeatureAndTeethWhitenFilter.clearGLSLSelf();
    this.mFaceFeatureFilter.clearGLSLSelf();
    this.mWrinklesRemoveFilter2.clearGLSLSelf();
    this.mBlurFilter1.clearGLSLSelf();
    this.mCopyFilter.ClearGLSL();
    this.mContrastFilter.ClearGLSL();
    this.mBlurFrame1.clear();
    this.mBlurFrame2.clear();
    GLES20.glDeleteTextures(this.mTextures.length, this.mTextures, 0);
    this.isLUT1LoadSuccess = false;
    this.isLUT2LoadSuccess = false;
  }
  
  public void forceAvgEyeBag()
  {
    this.colorParams.clear();
  }
  
  void getAvgColor(Frame paramFrame, float paramFloat1, List<PointF> paramList, float paramFloat2, BeautyFaceList_260.ColorParam paramColorParam)
  {
    float f1 = ((PointF)paramList.get(35)).x;
    f1 = (((PointF)paramList.get(39)).x + f1) / 2.0F;
    float f2 = ((PointF)paramList.get(35)).y;
    Object localObject = new PointF(f1, (((PointF)paramList.get(39)).y + f2) / 2.0F);
    f1 = ((PointF)paramList.get(45)).x;
    f1 = (((PointF)paramList.get(49)).x + f1) / 2.0F;
    f2 = ((PointF)paramList.get(45)).y;
    PointF localPointF = new PointF(f1, (((PointF)paramList.get(49)).y + f2) / 2.0F);
    f1 = ((PointF)localObject).x / paramFloat2 * paramFloat1;
    float f4 = ((PointF)localObject).y / paramFloat2 * paramFloat1;
    float f5 = localPointF.x / paramFloat2 * paramFloat1;
    f2 = localPointF.y / paramFloat2 * paramFloat1;
    float f3 = (float)Math.sqrt((f1 - f5) * (f1 - f5) + (f4 - f2) * (f4 - f2));
    double d = Math.atan2(f2 - f4, f5 - f1);
    f1 = (float)(f1 - f3 * Math.sin(0.157D + d) / 2.0D);
    f4 = (float)(f4 + f3 * Math.cos(0.157D + d) / 2.0D);
    float f7 = (float)(f5 - f3 * Math.sin(d - 0.157D) / 2.0D);
    float f8 = (float)(f2 + f3 * Math.cos(d - 0.157D) / 2.0D);
    int m = paramFrame.width;
    int k = paramFrame.height;
    f2 = AlgoUtils.getDistance((PointF)paramList.get(35), (PointF)paramList.get(39)) / paramFloat2 * paramFloat1 / 2.0F;
    int i = (int)Math.min(m - 1, Math.max(0.0F, f1 - 0.5F * f2));
    int j = (int)Math.min(m - 1, Math.max(0.0F, 0.9F * f2 + f1));
    int n = (int)Math.min(k - 1, Math.max(0.0F, f4 - 1.2F * f2));
    int i1 = (int)Math.min(k - 1, Math.max(0.0F, f2 * 1.2F + f4));
    initData(j - i, i1 - n);
    GlUtil.saveTextureToRgbaBuffer(paramFrame.getTextureId(), i, n, j - i, i1 - n, this.mData, paramFrame.getFBO());
    paramColorParam.mCgCrLeft[0] = 114.0F;
    paramColorParam.mCgCrLeft[1] = 112.0F;
    localObject = new int[3];
    n = (j - i) * (i1 - n);
    f1 = 0.0F;
    f2 = 0.0F;
    i = 0;
    f4 = 0.0F;
    j = 0;
    float f6 = 0.0F;
    f3 = 0.0F;
    f5 = 0.0F;
    if (i < n)
    {
      localObject[0] = (this.mData[i] & 0xFF);
      localObject[1] = (this.mData[(i + 1)] & 0xFF);
      localObject[2] = (this.mData[(i + 2)] & 0xFF);
      f6 += localObject[0];
      f5 += localObject[1];
      f4 += localObject[2];
      if (AlgoUtils.is_skin(localObject[0], localObject[1], localObject[2]) != 1) {}
      for (;;)
      {
        i += 4;
        break;
        f3 += localObject[0];
        f2 += localObject[1];
        f1 += localObject[2];
        j += 1;
      }
    }
    if (j > 0) {
      if ((paramColorParam.mLastRGBLeft[0] <= 0.0001D) || (isFirstFewFrames()))
      {
        paramColorParam.mRGBLeft[0] = (f3 / j);
        if ((paramColorParam.mLastRGBLeft[1] > 0.0001D) && (!isFirstFewFrames())) {
          break label1442;
        }
        paramColorParam.mRGBLeft[1] = (f2 / j);
        label832:
        if ((paramColorParam.mLastRGBLeft[2] > 0.0001D) && (!isFirstFewFrames())) {
          break label1474;
        }
        paramColorParam.mRGBLeft[2] = (f1 / j);
        label867:
        paramColorParam.mLastRGBLeft[0] = (f3 / j / 255.0F);
        paramColorParam.mLastRGBLeft[1] = (f2 / j / 255.0F);
        paramColorParam.mLastRGBLeft[2] = (f1 / j / 255.0F);
        label918:
        paramColorParam.mCgCrLeft[0] = ((-81085.0F * paramColorParam.mRGBLeft[0] + 112000.0F * paramColorParam.mRGBLeft[1] - 30915.0F * paramColorParam.mRGBLeft[2]) / 256000.0F + 128.0F);
        paramColorParam.mCgCrLeft[1] = ((-37797.0F * paramColorParam.mRGBLeft[0] - 74203.0F * paramColorParam.mRGBLeft[1] + 112000.0F * paramColorParam.mRGBLeft[2]) / 256000.0F + 128.0F);
        paramColorParam.mRGBLeft[0] /= 255.0F;
        paramColorParam.mRGBLeft[1] /= 255.0F;
        paramColorParam.mRGBLeft[2] /= 255.0F;
        paramFloat1 = AlgoUtils.getDistance((PointF)paramList.get(45), (PointF)paramList.get(49)) / paramFloat2 * paramFloat1 / 2.0F;
        i = (int)Math.min(m - 1, Math.max(0.0F, f7 - 0.9F * paramFloat1));
        j = (int)Math.min(m - 1, Math.max(0.0F, 0.5F * paramFloat1 + f7));
        m = (int)Math.min(k - 1, Math.max(0.0F, f8 - 1.2F * paramFloat1));
        k = (int)Math.min(k - 1, Math.max(0.0F, paramFloat1 * 1.2F + f8));
        initData(j - i, k - m);
        GlUtil.saveTextureToRgbaBuffer(paramFrame.getTextureId(), i, m, j - i, k - m, this.mData, paramFrame.getFBO());
        paramColorParam.mCgCrRight[0] = 114.0F;
        paramColorParam.mCgCrRight[1] = 112.0F;
        f2 = 0.0F;
        k = (j - i) * (k - m);
        paramFloat1 = 0.0F;
        paramFloat2 = 0.0F;
        f3 = 0.0F;
        f4 = 0.0F;
        i = 0;
        j = 0;
        f1 = 0.0F;
        label1296:
        if (i >= k) {
          break label1854;
        }
        localObject[0] = (this.mData[i] & 0xFF);
        localObject[1] = (this.mData[(i + 1)] & 0xFF);
        localObject[2] = (this.mData[(i + 2)] & 0xFF);
        f4 += localObject[0];
        f3 += localObject[1];
        f2 += localObject[2];
        if (AlgoUtils.is_skin(localObject[0], localObject[1], localObject[2]) == 1) {
          break label1817;
        }
      }
    }
    for (;;)
    {
      i += 4;
      break label1296;
      paramColorParam.mRGBLeft[0] = ((paramColorParam.mLastRGBLeft[0] * 255.0F + f3 / j) * 0.5F);
      break;
      label1442:
      paramColorParam.mRGBLeft[1] = ((paramColorParam.mLastRGBLeft[1] * 255.0F + f2 / j) * 0.5F);
      break label832;
      label1474:
      paramColorParam.mRGBLeft[2] = ((paramColorParam.mLastRGBLeft[2] * 255.0F + f1 / j) * 0.5F);
      break label867;
      if (n > 0)
      {
        if ((paramColorParam.mLastRGBLeft[0] <= 0.0001D) || (isFirstFewFrames()))
        {
          paramColorParam.mRGBLeft[0] = (f6 / n);
          label1546:
          if ((paramColorParam.mLastRGBLeft[1] > 0.0001D) && (!isFirstFewFrames())) {
            break label1702;
          }
          paramColorParam.mRGBLeft[1] = (f5 / n);
          label1581:
          if ((paramColorParam.mLastRGBLeft[2] > 0.0001D) && (!isFirstFewFrames())) {
            break label1734;
          }
          paramColorParam.mRGBLeft[2] = (f4 / n);
        }
        for (;;)
        {
          paramColorParam.mLastRGBLeft[0] = (f6 / n / 255.0F);
          paramColorParam.mLastRGBLeft[1] = (f5 / n / 255.0F);
          paramColorParam.mLastRGBLeft[2] = (f4 / n / 255.0F);
          break;
          paramColorParam.mRGBLeft[0] = ((paramColorParam.mLastRGBLeft[0] * 255.0F + f6 / n) * 0.5F);
          break label1546;
          label1702:
          paramColorParam.mRGBLeft[1] = ((paramColorParam.mLastRGBLeft[1] * 255.0F + f5 / n) * 0.5F);
          break label1581;
          label1734:
          paramColorParam.mRGBLeft[2] = ((paramColorParam.mLastRGBLeft[2] * 255.0F + f4 / n) * 0.5F);
        }
      }
      paramColorParam.mRGBLeft[0] = 0.0F;
      paramColorParam.mRGBLeft[1] = 0.0F;
      paramColorParam.mRGBLeft[2] = 0.0F;
      paramColorParam.mLastRGBLeft[0] = 0.0F;
      paramColorParam.mLastRGBLeft[1] = 0.0F;
      paramColorParam.mLastRGBLeft[2] = 0.0F;
      break label918;
      label1817:
      f1 += localObject[0];
      paramFloat2 += localObject[1];
      paramFloat1 += localObject[2];
      j += 1;
    }
    label1854:
    if (j > 0) {
      if ((paramColorParam.mLastRGBRight[0] <= 0.0001D) || (isFirstFewFrames()))
      {
        paramColorParam.mRGBRight[0] = (f1 / j);
        if ((paramColorParam.mLastRGBRight[1] > 0.0001D) && (!isFirstFewFrames())) {
          break label2200;
        }
        paramColorParam.mRGBRight[1] = (paramFloat2 / j);
        if ((paramColorParam.mLastRGBRight[2] > 0.0001D) && (!isFirstFewFrames())) {
          break label2232;
        }
        paramColorParam.mRGBRight[2] = (paramFloat1 / j);
        paramColorParam.mLastRGBRight[0] = (f1 / j / 255.0F);
        paramColorParam.mLastRGBRight[1] = (paramFloat2 / j / 255.0F);
        paramColorParam.mLastRGBRight[2] = (paramFloat1 / j / 255.0F);
      }
    }
    for (;;)
    {
      label1929:
      label1963:
      paramColorParam.mCgCrRight[0] = ((-81085.0F * paramColorParam.mRGBRight[0] + 112000.0F * paramColorParam.mRGBRight[1] - 30915.0F * paramColorParam.mRGBRight[2]) / 256000.0F + 128.0F);
      paramColorParam.mCgCrRight[1] = ((-37797.0F * paramColorParam.mRGBRight[0] - 74203.0F * paramColorParam.mRGBRight[1] + 112000.0F * paramColorParam.mRGBRight[2]) / 256000.0F + 128.0F);
      paramColorParam.mRGBRight[0] /= 255.0F;
      paramColorParam.mRGBRight[1] /= 255.0F;
      paramColorParam.mRGBRight[2] /= 255.0F;
      return;
      paramColorParam.mRGBRight[0] = ((paramColorParam.mLastRGBRight[0] * 255.0F + f1 / j) * 0.5F);
      break;
      label2200:
      paramColorParam.mRGBRight[1] = ((paramColorParam.mLastRGBRight[1] * 255.0F + paramFloat2 / j) * 0.5F);
      break label1929;
      label2232:
      paramColorParam.mRGBRight[2] = ((paramColorParam.mLastRGBRight[2] * 255.0F + paramFloat1 / j) * 0.5F);
      break label1963;
      if (k > 0)
      {
        if ((paramColorParam.mLastRGBRight[0] <= 0.0001D) || (isFirstFewFrames()))
        {
          paramColorParam.mRGBRight[0] = (f4 / k);
          label2303:
          if ((paramColorParam.mLastRGBRight[1] > 0.0001D) && (!isFirstFewFrames())) {
            break label2459;
          }
          paramColorParam.mRGBRight[1] = (f3 / k);
          label2338:
          if ((paramColorParam.mLastRGBRight[2] > 0.0001D) && (!isFirstFewFrames())) {
            break label2491;
          }
          paramColorParam.mRGBRight[2] = (f2 / k);
        }
        for (;;)
        {
          paramColorParam.mLastRGBRight[0] = (f4 / k / 255.0F);
          paramColorParam.mLastRGBRight[1] = (f3 / k / 255.0F);
          paramColorParam.mLastRGBRight[2] = (f2 / k / 255.0F);
          break;
          paramColorParam.mRGBRight[0] = ((paramColorParam.mLastRGBRight[0] * 255.0F + f4 / k) * 0.5F);
          break label2303;
          label2459:
          paramColorParam.mRGBRight[1] = ((paramColorParam.mLastRGBRight[1] * 255.0F + f3 / k) * 0.5F);
          break label2338;
          label2491:
          paramColorParam.mRGBRight[2] = ((paramColorParam.mLastRGBRight[2] * 255.0F + f2 / k) * 0.5F);
        }
      }
      paramColorParam.mRGBRight[0] = 0.0F;
      paramColorParam.mRGBRight[1] = 0.0F;
      paramColorParam.mRGBRight[2] = 0.0F;
      paramColorParam.mLastRGBRight[0] = 0.0F;
      paramColorParam.mLastRGBRight[1] = 0.0F;
      paramColorParam.mLastRGBRight[2] = 0.0F;
    }
  }
  
  public void initial()
  {
    this.mBeautyEffectCombineFilter.ApplyGLSLFilter();
    this.mFaceFeatureAndTeethWhitenFilter.ApplyGLSLFilter();
    this.mFaceFeatureFilter.ApplyGLSLFilter();
    this.mWrinklesRemoveFilter2.ApplyGLSLFilter();
    this.mBlurFilter1.ApplyGLSLFilter();
    this.mContrastFilter.apply();
    this.mCopyFilter.apply();
    Bitmap localBitmap1 = VideoMemoryManager.getInstance().getBeautyCacheBitmap("color_tone_hongrun.png");
    Bitmap localBitmap2 = VideoMemoryManager.getInstance().getBeautyCacheBitmap("color_tone_baixi.png");
    GLES20.glGenTextures(this.mTextures.length, this.mTextures, 0);
    if (loadLut(localBitmap1, this.mTextures[0])) {
      this.isLUT1LoadSuccess = true;
    }
    if (loadLut(localBitmap2, this.mTextures[1])) {
      this.isLUT2LoadSuccess = true;
    }
  }
  
  public float[] pointsVis(Float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0)) {
      return null;
    }
    float[] arrayOfFloat = new float[paramArrayOfFloat.length];
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      arrayOfFloat[i] = Float.parseFloat(paramArrayOfFloat[i].toString());
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public Frame render(Frame paramFrame, List<List<PointF>> paramList, List<Float[]> paramList1, List<FaceStatus> paramList2, boolean paramBoolean)
  {
    if (this.colorParams.size() != paramList.size())
    {
      this.colorParams.clear();
      i = 0;
      while (i < paramList.size())
      {
        this.colorParams.add(new BeautyFaceList_260.ColorParam(this));
        i += 1;
      }
    }
    for (int i = 1;; i = 0)
    {
      int j = 0;
      Frame localFrame = paramFrame;
      List localList;
      if (j < paramList.size())
      {
        localList = VideoMaterialUtil.copyList((List)paramList.get(j));
        FaceOffUtil.initFacePositions(getFullCoords(localList), (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices);
        if (paramList1.size() <= j) {
          break label1118;
        }
      }
      label1118:
      for (Object localObject = FaceOffUtil.initPointVis(FaceOffUtil.getFullPointsVisForFaceOffFilter(pointsVis((Float[])paramList1.get(j))), this.pointVisVertices);; localObject = new float[0])
      {
        if ((((FaceStatus)paramList2.get(j)).gender != 2) && (this.openFaceFeture == true)) {
          if ((this.mToothWhiten > 0.01F) || (this.mRenderLipsLut))
          {
            paramFrame = localFrame;
            if (this.mFaceFeatureAndTeethWhitenFilter.needRender())
            {
              paramFrame = this.mCopyFilter.RenderProcess(localFrame.getTextureId(), localFrame.width, localFrame.height);
              this.mFaceFeatureAndTeethWhitenFilter.updateParam(localList, this.faceVertices, (float[])localObject);
              this.mFaceFeatureAndTeethWhitenFilter.resetCosDefaultEffect();
              this.mFaceFeatureAndTeethWhitenFilter.OnDrawFrameGLSL();
              this.mFaceFeatureAndTeethWhitenFilter.renderTexture(localFrame.getTextureId(), localFrame.width, localFrame.height);
              localFrame.unlock();
            }
          }
        }
        for (;;)
        {
          localFrame = paramFrame;
          if (this.mWrinklesRemoveFilter2.needRender())
          {
            localFrame = this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
            this.mWrinklesRemoveFilter2.updateParam(localList, this.faceVertices);
            this.mWrinklesRemoveFilter2.OnDrawFrameGLSL();
            this.mWrinklesRemoveFilter2.renderTexture(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
            paramFrame.unlock();
          }
          paramFrame = localFrame;
          if (this.mBeautyEffectCombineFilter.needRender())
          {
            paramFrame = (BeautyFaceList_260.ColorParam)this.colorParams.get(j);
            if (this.mBeautyEffectCombineFilter.getSmoothOpacity() > 0.0F)
            {
              localObject = this.mCopyFilter.RenderProcess(localFrame.getTextureId(), localFrame.width / 2, localFrame.height / 2);
              this.mBlurFilter1.updateParam(localList, this.faceVertices);
              this.mBlurFilter1.updateSize(1.0F / ((Frame)localObject).width, 0.0F);
              this.mBlurFilter1.RenderProcess(((Frame)localObject).getTextureId(), ((Frame)localObject).width, ((Frame)localObject).height, -1, 0.0D, this.mBlurFrame1);
              this.mBlurFilter1.updateSize(0.0F, 1.0F / ((Frame)localObject).height);
              this.mBlurFilter1.RenderProcess(this.mBlurFrame1.getTextureId(), this.mBlurFrame1.width, this.mBlurFrame1.height, -1, 0.0D, this.mBlurFrame2);
              if ((isFirstFewFrames()) || (i != 0) || (this.mRenderIndex % 2 == 0)) {
                getAvgColor((Frame)localObject, 0.5F, localList, (float)this.mFaceDetScale, paramFrame);
              }
              ((Frame)localObject).unlock();
            }
            this.mBeautyEffectCombineFilter.setEyePouchSmoothImage(this.mBlurFrame2.getLastRenderTextureId(), paramFrame.mRGBLeft, paramFrame.mRGBRight, paramFrame.mCgCrLeft, paramFrame.mCgCrRight);
            paramFrame = this.mCopyFilter.RenderProcess(localFrame.getTextureId(), localFrame.width, localFrame.height);
            this.mBeautyEffectCombineFilter.updateParam(localList, this.faceVertices);
            this.mBeautyEffectCombineFilter.OnDrawFrameGLSL();
            this.mBeautyEffectCombineFilter.renderTexture(localFrame.getTextureId(), localFrame.width, localFrame.height);
            localFrame.unlock();
          }
          j += 1;
          localFrame = paramFrame;
          break;
          paramFrame = localFrame;
          if (!paramBoolean)
          {
            paramFrame = localFrame;
            if (this.mFaceFeatureFilter.needRender())
            {
              paramFrame = this.mCopyFilter.RenderProcess(localFrame.getTextureId(), localFrame.width, localFrame.height);
              this.mFaceFeatureFilter.updateParam(this.faceVertices);
              this.mFaceFeatureFilter.resetCosDefaultEffect();
              this.mFaceFeatureFilter.OnDrawFrameGLSL();
              this.mFaceFeatureFilter.renderTexture(localFrame.getTextureId(), localFrame.width, localFrame.height);
              localFrame.unlock();
              continue;
              if ((this.mToothWhiten > 0.01F) || (this.mRenderLipsLut))
              {
                paramFrame = localFrame;
                if (this.mFaceFeatureAndTeethWhitenFilter.needRender())
                {
                  paramFrame = this.mCopyFilter.RenderProcess(localFrame.getTextureId(), localFrame.width, localFrame.height);
                  this.mFaceFeatureAndTeethWhitenFilter.updateParam(localList, this.faceVertices, (float[])localObject);
                  this.mFaceFeatureAndTeethWhitenFilter.setNormalAlphaValue(0.0F);
                  this.mFaceFeatureAndTeethWhitenFilter.OnDrawFrameGLSL();
                  this.mFaceFeatureAndTeethWhitenFilter.renderTexture(localFrame.getTextureId(), localFrame.width, localFrame.height);
                  localFrame.unlock();
                }
              }
              else
              {
                paramFrame = localFrame;
                if (!paramBoolean)
                {
                  paramFrame = localFrame;
                  if (this.mFaceFeatureFilter.needRender())
                  {
                    paramFrame = this.mCopyFilter.RenderProcess(localFrame.getTextureId(), localFrame.width, localFrame.height);
                    this.mFaceFeatureFilter.updateParam(this.faceVertices);
                    this.mFaceFeatureFilter.setNormalAlphaValue(0.0F);
                    this.mFaceFeatureFilter.OnDrawFrameGLSL();
                    this.mFaceFeatureFilter.renderTexture(localFrame.getTextureId(), localFrame.width, localFrame.height);
                    localFrame.unlock();
                  }
                }
              }
            }
          }
        }
        paramFrame = localFrame;
        if (this.mContrastFilter.needRender())
        {
          paramFrame = this.mContrastFilter.RenderProcess(localFrame.getTextureId(), localFrame.width, localFrame.height);
          localFrame.unlock();
        }
        this.mRenderIndex += 1;
        if (paramList.isEmpty()) {
          this.colorParams.clear();
        }
        return paramFrame;
      }
    }
  }
  
  public void resetCosDefaultEffect()
  {
    this.mFaceFeatureFilter.resetCosDefaultEffect();
    this.mFaceFeatureAndTeethWhitenFilter.resetCosDefaultEffect();
  }
  
  public void resetEyeBagColors()
  {
    this.colorParams.clear();
    this.mRenderIndex = 0;
  }
  
  public void setContrastLevel(int paramInt)
  {
    this.mContrastFilter.setContrastLevel(paramInt);
  }
  
  public void setEyeLightenAlpha(float paramFloat)
  {
    this.mBeautyEffectCombineFilter.setAlphaValue(paramFloat);
  }
  
  public void setFaceFeatureMultiplyAlpha(float paramFloat)
  {
    this.mFaceFeatureAndTeethWhitenFilter.setMultiplyAlphaValue(paramFloat);
    this.mFaceFeatureFilter.setMultiplyAlphaValue(paramFloat);
  }
  
  public void setFaceFeatureNormalAlpha(float paramFloat)
  {
    this.mFaceFeatureAndTeethWhitenFilter.setNormalAlphaValue(paramFloat);
    this.mFaceFeatureFilter.setNormalAlphaValue(paramFloat);
  }
  
  public void setFaceFeatureParam(FaceFeatureParam paramFaceFeatureParam)
  {
    this.mFaceFeatureAndTeethWhitenFilter.setFaceFeatureParam(paramFaceFeatureParam);
    this.mFaceFeatureFilter.setFaceFeatureParam(paramFaceFeatureParam);
  }
  
  public void setFaceFeatureSoftlightAlpha(float paramFloat)
  {
    this.mFaceFeatureAndTeethWhitenFilter.setSoftlightAlphaValue(paramFloat);
    this.mFaceFeatureFilter.setSoftlightAlphaValue(paramFloat);
  }
  
  public void setLipsLut(String paramString)
  {
    Bitmap localBitmap = null;
    if (!TextUtils.isEmpty(paramString)) {
      if (paramString.startsWith("assets://")) {
        break label61;
      }
    }
    label61:
    for (localBitmap = BitmapUtils.decodeSampledBitmapFromFile(paramString, 1); BitmapUtils.isLegal(localBitmap); localBitmap = BitmapUtils.decodeSampleBitmapFromAssets(AEModule.getContext(), FileUtils.getRealPath(paramString), 1))
    {
      this.mRenderLipsLut = true;
      GlUtil.loadTexture(this.mTextures[3], localBitmap);
      this.mFaceFeatureAndTeethWhitenFilter.setLipsLutTexture(this.mTextures[3]);
      return;
    }
    this.mRenderLipsLut = false;
    this.mFaceFeatureAndTeethWhitenFilter.setLipsLutTexture(0);
  }
  
  public void setLipsLutAlpha(int paramInt)
  {
    if (this.mRenderLipsLut)
    {
      this.mFaceFeatureAndTeethWhitenFilter.setLipsLutAlpha(paramInt);
      return;
    }
    this.mFaceFeatureAndTeethWhitenFilter.setLipsLutAlpha(0);
  }
  
  public void setNormalAlphaFactor(float paramFloat)
  {
    this.mFaceFeatureAndTeethWhitenFilter.setNormalAlphaFactor(paramFloat);
    this.mFaceFeatureFilter.setNormalAlphaFactor(paramFloat);
  }
  
  public void setRemovePounchAlpha(float paramFloat)
  {
    this.mBeautyEffectCombineFilter.setSmoothOpacity(1.2F * paramFloat);
  }
  
  public void setRemoveWrinklesAlpha(float paramFloat)
  {
    this.mAlphaWrinkles = paramFloat;
    updateWrinklesAlpha();
  }
  
  public void setRemoveWrinklesAlpha2(float paramFloat)
  {
    this.mAlphaWrinklesFlw = paramFloat;
    updateWrinklesAlpha();
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mBeautyEffectCombineFilter.setRenderMode(paramInt);
    this.mFaceFeatureAndTeethWhitenFilter.setRenderMode(paramInt);
    this.mFaceFeatureFilter.setRenderMode(paramInt);
    this.mWrinklesRemoveFilter2.setRenderMode(paramInt);
    this.mContrastFilter.setRenderMode(paramInt);
    this.mCopyFilter.setRenderMode(paramInt);
  }
  
  public void setShowFaceFeatureFilter(boolean paramBoolean)
  {
    this.openFaceFeture = paramBoolean;
  }
  
  public void setSkinColorAlpha(float paramFloat)
  {
    Bitmap localBitmap;
    if (!this.isLUT1LoadSuccess)
    {
      localBitmap = VideoMemoryManager.getInstance().getBeautyCacheBitmap("color_tone_hongrun.png");
      if (localBitmap == null) {
        break label122;
      }
      bool = true;
      AEOpenRenderConfig.checkStrictMode(bool, "color_tone_hongrun.png is null");
      if (loadLut(localBitmap, this.mTextures[0])) {
        this.isLUT1LoadSuccess = true;
      }
    }
    if (!this.isLUT2LoadSuccess)
    {
      localBitmap = VideoMemoryManager.getInstance().getBeautyCacheBitmap("color_tone_baixi.png");
      if (localBitmap == null) {
        break label127;
      }
    }
    label122:
    label127:
    for (boolean bool = true;; bool = false)
    {
      AEOpenRenderConfig.checkStrictMode(bool, "color_tone_baixi.png is null");
      if (loadLut(localBitmap, this.mTextures[1])) {
        this.isLUT2LoadSuccess = true;
      }
      if (paramFloat >= 0.0F) {
        break label132;
      }
      this.mContrastFilter.updateSkinColorValue(Math.abs(paramFloat), this.mTextures[0]);
      return;
      bool = false;
      break;
    }
    label132:
    this.mContrastFilter.updateSkinColorValue(Math.abs(paramFloat), this.mTextures[1]);
  }
  
  public void setToothWhitenAlpha(float paramFloat)
  {
    this.mToothWhiten = paramFloat;
    this.mFaceFeatureAndTeethWhitenFilter.setToothWhitenAlphaValue(paramFloat);
  }
  
  public void updateFilterBlendImage(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramInt >= 0))
    {
      paramString = TTPicFilterFactoryLocal.getBitmapFromEncryptedFile(paramString);
      GlUtil.loadTexture(this.mTextures[2], paramString);
      if (BitmapUtils.isLegal(paramString)) {
        paramString.recycle();
      }
      this.mContrastFilter.setBlendImage(this.mTextures[2], paramInt);
      return;
    }
    this.mContrastFilter.clearBlendImage();
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.mBeautyEffectCombineFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.mWrinklesRemoveFilter2.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.mFaceFeatureAndTeethWhitenFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.mFaceFeatureFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.width = paramInt1;
    this.height = paramInt2;
    this.mFaceDetScale = paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.BeautyFaceList_260
 * JD-Core Version:    0.7.0.1
 */