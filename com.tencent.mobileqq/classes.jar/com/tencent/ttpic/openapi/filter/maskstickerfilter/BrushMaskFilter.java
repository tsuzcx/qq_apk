package com.tencent.ttpic.openapi.filter.maskstickerfilter;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.filter.FaceLineFilter;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FrameUtil;
import java.util.ArrayList;
import java.util.List;

public class BrushMaskFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision mediump float;\n varying vec2 grayTextureCoordinate;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture2;\nuniform int drawTypeFragment;\nuniform int maskType;\nvoid main(void) {\n    if (drawTypeFragment == 1) {// 纯色笔触画到画布\n        gl_FragColor = vec4(1.0, 1.0, 1.0, 1.0);\n    } else if (drawTypeFragment == 2) {// 纯色笔触把画布融合到画面\n        vec4 texColor = texture2D(inputImageTexture2, grayTextureCoordinate);\n        gl_FragColor = vec4(texColor.rgb, texColor.a);\n    }\n}\n";
  private static final int LINE_POINT_GAP = 200;
  private static final String TAG = FaceLineFilter.class.getSimpleName();
  private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputGrayTextureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvoid main() {\n    gl_Position = position;\n    grayTextureCoordinate = inputGrayTextureCoordinate.xy;\n}\n";
  private boolean mIsDrawLines;
  private PointF mLastPoint;
  private long mLastUpdateTime;
  private Frame mMaskFrame = new Frame();
  private int mMaskType;
  private boolean mNeedMaksFrameClear;
  private String mPaintImagePath;
  private float[] mPaintPointList;
  private int mPaintSize;
  private float[] mTextruePointList;
  
  public BrushMaskFilter(int paramInt1, int paramInt2, String paramString)
  {
    super("attribute vec4 position;\nattribute vec4 inputGrayTextureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvoid main() {\n    gl_Position = position;\n    grayTextureCoordinate = inputGrayTextureCoordinate.xy;\n}\n", "precision mediump float;\n varying vec2 grayTextureCoordinate;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture2;\nuniform int drawTypeFragment;\nuniform int maskType;\nvoid main(void) {\n    if (drawTypeFragment == 1) {// 纯色笔触画到画布\n        gl_FragColor = vec4(1.0, 1.0, 1.0, 1.0);\n    } else if (drawTypeFragment == 2) {// 纯色笔触把画布融合到画面\n        vec4 texColor = texture2D(inputImageTexture2, grayTextureCoordinate);\n        gl_FragColor = vec4(texColor.rgb, texColor.a);\n    }\n}\n");
    boolean bool = true;
    this.mNeedMaksFrameClear = true;
    this.mPaintSize = 10;
    this.mPaintPointList = new float[0];
    this.mTextruePointList = new float[0];
    this.mIsDrawLines = true;
    this.mMaskType = 1;
    String str = paramString;
    if (paramString == null) {
      str = FaceOffUtil.getMaskBrushPointPath();
    }
    this.mPaintImagePath = str;
    if (this.mPaintImagePath != null) {
      bool = false;
    }
    this.mIsDrawLines = bool;
    initParams();
    this.mPaintSize = paramInt2;
    this.mMaskType = paramInt1;
  }
  
  private double caculateDistance(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF1.x - paramPointF2.x;
    float f2 = paramPointF1.y - paramPointF2.y;
    return Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private ArrayList<PointF> check2Points(PointF paramPointF1, PointF paramPointF2)
  {
    if ((paramPointF1 != null) && (paramPointF2 != null))
    {
      if (this.mPaintSize == 0) {
        return null;
      }
      double d1 = caculateDistance(paramPointF1, paramPointF2);
      int i = this.mPaintSize;
      if (d1 > i * 0.5F)
      {
        double d2 = i;
        Double.isNaN(d2);
        int j = (int)Math.ceil(d1 * 2.0D / d2);
        ArrayList localArrayList = new ArrayList();
        float f1 = paramPointF2.x;
        float f3 = paramPointF1.x;
        float f2 = j;
        f1 = (f1 - f3) / f2;
        f2 = (paramPointF2.y - paramPointF1.y) / f2;
        i = 1;
        while (i < j)
        {
          f3 = paramPointF1.x;
          float f4 = i;
          localArrayList.add(new PointF(f3 + f1 * f4, paramPointF1.y + f4 * f2));
          i += 1;
        }
        return localArrayList;
      }
    }
    return null;
  }
  
  private List<PointF> insertPoints(List<PointF> paramList)
  {
    Object localObject1 = paramList;
    if (paramList != null)
    {
      if (paramList.size() < 2) {
        return paramList;
      }
      localObject1 = null;
      Object localObject2 = (PointF)paramList.get(0);
      int i = 1;
      while (i < paramList.size())
      {
        PointF localPointF = (PointF)paramList.get(i);
        ArrayList localArrayList = check2Points((PointF)localObject2, localPointF);
        localObject2 = localObject1;
        if (localArrayList != null)
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList(paramList.subList(0, i - 1));
          }
          ((ArrayList)localObject2).addAll(localArrayList);
        }
        if (localObject2 != null) {
          ((ArrayList)localObject2).add(localPointF);
        }
        i += 1;
        localObject1 = localObject2;
        localObject2 = localPointF;
      }
      if (localObject1 == null) {
        return paramList;
      }
    }
    return localObject1;
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    if (this.mIsDrawLines) {
      setDrawMode(AEOpenRenderConfig.DRAW_MODE.LINES_STRIP);
    } else {
      setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    }
    this.mNeedMaksFrameClear = true;
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    Frame localFrame = this.mMaskFrame;
    if (localFrame != null) {
      localFrame.clear();
    }
  }
  
  public int getMaskType()
  {
    return this.mMaskType;
  }
  
  public void initAttribParams()
  {
    setPositions(GlUtil.ORIGIN_POSITION_COORDS);
    setGrayCords(GlUtil.ORIGIN_TEX_COORDS);
  }
  
  public void initParams()
  {
    int i;
    if (this.mIsDrawLines) {
      i = 1;
    } else {
      i = 2;
    }
    addParam(new UniformParam.IntParam("drawTypeFragment", i));
    addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.mPaintImagePath, 1), 33986, true));
  }
  
  public Frame render(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mNeedMaksFrameClear)
    {
      this.mNeedMaksFrameClear = false;
      FrameUtil.clearFrame(this.mMaskFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramInt2, paramInt3);
    }
    Frame localFrame = this.mMaskFrame;
    localFrame.bindFrame(-1, localFrame.width, this.mMaskFrame.height, 0.0D);
    GlUtil.setBlendMode(true);
    OnDrawFrameGLSL();
    renderTexture(this.mMaskFrame.getTextureId(), paramInt2, paramInt3);
    GlUtil.setBlendMode(false);
    return this.mMaskFrame;
  }
  
  public void reset()
  {
    this.mNeedMaksFrameClear = true;
  }
  
  public void setTouchPoints(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    if (this.mIsDrawLines)
    {
      setTouchPointsByLines(paramList, paramInt1, paramInt2);
      return;
    }
    setTouchPointsByTriangles(paramList, paramInt1, paramInt2);
  }
  
  public void setTouchPointsByLines(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      PointF localPointF = this.mLastPoint;
      int i = 0;
      if ((localPointF != null) && (System.currentTimeMillis() - this.mLastUpdateTime < 200L)) {
        paramList.add(0, this.mLastPoint);
      }
      if (paramList.size() * 2 > this.mPaintPointList.length) {
        this.mPaintPointList = new float[paramList.size() * 2];
      }
      int k = 0;
      int j = 0;
      while (i < paramList.size())
      {
        localPointF = (PointF)paramList.get(i);
        this.mPaintPointList[k] = ((localPointF.x - this.mPaintSize * 0.5F) * 2.0F / paramInt1 - 1.0F);
        this.mPaintPointList[(k + 1)] = ((localPointF.y - this.mPaintSize * 0.5F) * 2.0F / paramInt2 - 1.0F);
        k += 2;
        j += 1;
        i += 1;
      }
      if (this.mLastPoint == null) {
        this.mLastPoint = new PointF();
      }
      this.mLastUpdateTime = System.currentTimeMillis();
      localPointF = this.mLastPoint;
      paramInt1 = j - 1;
      localPointF.x = ((PointF)paramList.get(paramInt1)).x;
      this.mLastPoint.y = ((PointF)paramList.get(paramInt1)).y;
      setPositions(this.mPaintPointList);
      setCoordNum(paramList.size());
      GLES20.glLineWidth(this.mPaintSize);
    }
  }
  
  public void setTouchPointsByTriangles(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      Object localObject = this.mLastPoint;
      int i = 0;
      float f1;
      float f2;
      if ((localObject != null) && (System.currentTimeMillis() - this.mLastUpdateTime < 200L))
      {
        localObject = (PointF)paramList.get(0);
        f1 = ((PointF)localObject).x - this.mLastPoint.x;
        f2 = ((PointF)localObject).y - this.mLastPoint.y;
        if (Math.abs(f1 * f1 + f2 * f2) > 9.0F) {
          paramList.add(0, this.mLastPoint);
        }
      }
      paramList = insertPoints(paramList);
      if (paramList.size() * 12 > this.mPaintPointList.length)
      {
        this.mPaintPointList = new float[paramList.size() * 12];
        this.mTextruePointList = new float[paramList.size() * 12];
      }
      int k = 0;
      int j = 0;
      while (i < paramList.size())
      {
        localObject = (PointF)paramList.get(i);
        float[] arrayOfFloat = this.mPaintPointList;
        f2 = ((PointF)localObject).x;
        float f3 = this.mPaintSize;
        f1 = paramInt1;
        arrayOfFloat[k] = ((f2 + f3 * 0.5F) * 2.0F / f1 - 1.0F);
        arrayOfFloat = this.mPaintPointList;
        int m = k + 1;
        f2 = ((PointF)localObject).y;
        f3 = this.mPaintSize;
        float f4 = paramInt2;
        arrayOfFloat[m] = ((f2 + f3 * 0.5F) * 2.0F / f4 - 1.0F);
        arrayOfFloat = this.mPaintPointList;
        int n = k + 2;
        arrayOfFloat[n] = ((((PointF)localObject).x + this.mPaintSize * 0.5F) * 2.0F / f1 - 1.0F);
        arrayOfFloat = this.mPaintPointList;
        int i1 = k + 3;
        arrayOfFloat[i1] = ((((PointF)localObject).y - this.mPaintSize * 0.5F) * 2.0F / f4 - 1.0F);
        arrayOfFloat = this.mPaintPointList;
        int i2 = k + 4;
        arrayOfFloat[i2] = ((((PointF)localObject).x - this.mPaintSize * 0.5F) * 2.0F / f1 - 1.0F);
        arrayOfFloat = this.mPaintPointList;
        int i3 = k + 5;
        arrayOfFloat[i3] = ((((PointF)localObject).y - this.mPaintSize * 0.5F) * 2.0F / f4 - 1.0F);
        arrayOfFloat = this.mPaintPointList;
        int i4 = k + 6;
        arrayOfFloat[i4] = arrayOfFloat[k];
        int i5 = k + 7;
        arrayOfFloat[i5] = arrayOfFloat[m];
        int i6 = k + 8;
        arrayOfFloat[i6] = arrayOfFloat[i2];
        int i7 = k + 9;
        arrayOfFloat[i7] = arrayOfFloat[i3];
        int i8 = k + 10;
        arrayOfFloat[i8] = ((((PointF)localObject).x - this.mPaintSize * 0.5F) * 2.0F / f1 - 1.0F);
        arrayOfFloat = this.mPaintPointList;
        int i9 = k + 11;
        arrayOfFloat[i9] = ((((PointF)localObject).y + this.mPaintSize * 0.5F) * 2.0F / f4 - 1.0F);
        localObject = this.mTextruePointList;
        localObject[k] = 1.0F;
        localObject[m] = 1.0F;
        localObject[n] = 1.0F;
        localObject[i1] = 0.0F;
        localObject[i2] = 0.0F;
        localObject[i3] = 0.0F;
        localObject[i4] = 1.0F;
        localObject[i5] = 1.0F;
        localObject[i6] = 0.0F;
        localObject[i7] = 0.0F;
        localObject[i8] = 0.0F;
        localObject[i9] = 1.0F;
        k += 12;
        j += 1;
        i += 1;
      }
      if (this.mLastPoint == null) {
        this.mLastPoint = new PointF();
      }
      this.mLastUpdateTime = System.currentTimeMillis();
      localObject = this.mLastPoint;
      paramInt1 = j - 1;
      ((PointF)localObject).x = ((PointF)paramList.get(paramInt1)).x;
      this.mLastPoint.y = ((PointF)paramList.get(paramInt1)).y;
      setPositions(this.mPaintPointList);
      setGrayCords(this.mTextruePointList);
      setCoordNum(paramList.size() * 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.maskstickerfilter.BrushMaskFilter
 * JD-Core Version:    0.7.0.1
 */