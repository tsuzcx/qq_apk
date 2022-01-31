package com.tencent.mobileqq.shortvideo.bighead;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.Iterator;
import java.util.List;

public class BigHeadInitFilter
{
  public static final String BGRA_NO_FILTER_FRAGMENT_SHADER = "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\n\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord).bgra;\n}\n";
  public static final String NO_FILTER_VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n";
  public List<PointF> fullFaceCoords;
  public float[] inClipMatrix = new float[16];
  private float[] inMvpMatrix = new float[16];
  private Rect mClipRegion = new Rect();
  private float mCurrentScaleRatio = 1.3F;
  public Rect mEnlargeSubRegion = new Rect();
  private Rect mExtendRegion = new Rect();
  private GPUBaseFilter mGPU2DFilter;
  private GPUBaseFilter mGPU2DFilterClip;
  private boolean mInited = false;
  public int mMaxConstLength = 0;
  private float mMaxScaleRatio;
  public int mMaxTextureLength = 0;
  private Rect mOutputExtendRegion = new Rect();
  private RenderBuffer mRenderClip;
  private RenderBuffer mRenderInitFBO;
  private double mScreenScale;
  private int mTextureHeight;
  private RectF mTextureRegion = new RectF();
  private int mTextureWidth;
  private boolean mUpdateFaceData;
  public float[] mUserTextureCoord = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  private Rect mWindows = new Rect();
  private int netInputHeight = 256;
  private int netInputWidth = 256;
  public Point zhongxin = new Point();
  
  public BigHeadInitFilter()
  {
    Matrix.setIdentityM(this.inMvpMatrix, 0);
    Matrix.setRotateM(this.inMvpMatrix, 0, 270.0F, 0.0F, 0.0F, 1.0F);
  }
  
  private static float DISTANCE_OF(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF2.x - paramPointF1.x;
    float f2 = paramPointF2.y - paramPointF1.y;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private int getEvenInt(int paramInt)
  {
    return paramInt - paramInt % 2;
  }
  
  public static void releaseRenderFBOTexture(RenderBuffer paramRenderBuffer)
  {
    if (paramRenderBuffer != null) {
      GLES20.glDeleteTextures(1, new int[] { paramRenderBuffer.getTexId() }, 0);
    }
  }
  
  public void clipAllocateConstTexture(RenderBuffer paramRenderBuffer, float paramFloat)
  {
    if (paramRenderBuffer.getTexId() == 0)
    {
      this.mMaxTextureLength = getEvenInt((int)(this.mMaxConstLength * paramFloat));
      paramRenderBuffer.setUserTextureId(GlUtil.createTextureAllocate(this.mMaxTextureLength, this.mMaxTextureLength, false));
      paramRenderBuffer.setSize(this.mMaxTextureLength, this.mMaxTextureLength);
    }
  }
  
  public void drawTexture(int paramInt)
  {
    int j = 0;
    if (!this.mInited)
    {
      if (SLog.isEnable()) {
        SLog.d("BigHeadFilter", "BigHeadInitFilter:drawTexture mInited=false");
      }
      return;
    }
    int i = this.mExtendRegion.width();
    if (i != this.mRenderClip.getWidth())
    {
      GLES20.glDeleteTextures(1, new int[] { this.mRenderClip.getTexId() }, 0);
      int k = GlUtil.createTextureAllocate(i, i, false);
      this.mRenderClip.setUserTextureId(k);
      this.mRenderClip.setSize(i, i);
    }
    this.mRenderClip.bind();
    GLES20.glClear(16384);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    if (this.mExtendRegion.left < 0) {}
    for (i = -this.mExtendRegion.left;; i = 0)
    {
      if (this.mExtendRegion.top < 0) {
        j = -this.mExtendRegion.top;
      }
      GLES20.glViewport(i, j, this.mClipRegion.width(), this.mClipRegion.height());
      this.mGPU2DFilterClip.drawTexture(paramInt, this.inClipMatrix, null);
      this.mRenderClip.unbind();
      paramInt = this.mRenderClip.getTexId();
      this.mRenderInitFBO.bind();
      this.mGPU2DFilter.drawTexture(paramInt, null, this.inMvpMatrix);
      this.mRenderInitFBO.unbind();
      return;
    }
  }
  
  public void drawTextureOptimize(int paramInt)
  {
    if (!this.mInited)
    {
      if (SLog.isEnable()) {
        SLog.d("BigHeadFilter", "BigHeadInitFilter:drawTexture mInited=false");
      }
      return;
    }
    clipAllocateConstTexture(this.mRenderClip, this.mMaxScaleRatio);
    this.mRenderClip.bind();
    GLES20.glClear(16384);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    int i = this.mOutputExtendRegion.width();
    int j = (this.mMaxTextureLength - i) / 2;
    this.mEnlargeSubRegion.set(j, j, j + i, i + j);
    if (this.mExtendRegion.left < 0)
    {
      i = -this.mExtendRegion.left;
      if (this.mExtendRegion.top >= 0) {
        break label382;
      }
    }
    label382:
    for (j = -this.mExtendRegion.top;; j = 0)
    {
      i = (int)(i * this.mCurrentScaleRatio);
      j = (int)(j * this.mCurrentScaleRatio);
      int k = (int)(this.mClipRegion.width() * this.mCurrentScaleRatio);
      int m = (int)(this.mClipRegion.height() * this.mCurrentScaleRatio);
      GLES20.glViewport(i + this.mEnlargeSubRegion.left, j + this.mEnlargeSubRegion.top, k, m);
      this.mGPU2DFilterClip.drawTexture(paramInt, this.inClipMatrix, null);
      this.mRenderClip.unbind();
      paramInt = this.mRenderClip.getTexId();
      float f1 = this.mEnlargeSubRegion.left * 1.0F / this.mMaxTextureLength;
      float f2 = this.mEnlargeSubRegion.top * 1.0F / this.mMaxTextureLength;
      float f3 = this.mEnlargeSubRegion.width() * 1.0F / this.mMaxTextureLength;
      float f4 = this.mEnlargeSubRegion.height() * 1.0F / this.mMaxTextureLength;
      Matrix.setIdentityM(this.inClipMatrix, 0);
      Matrix.translateM(this.inClipMatrix, 0, f1, f2, 0.0F);
      Matrix.scaleM(this.inClipMatrix, 0, f3, f4, 1.0F);
      this.mRenderInitFBO.bind();
      this.mGPU2DFilter.drawTexture(paramInt, this.inClipMatrix, this.inMvpMatrix);
      this.mRenderInitFBO.unbind();
      return;
      i = 0;
      break;
    }
  }
  
  public int getClippedTextureId()
  {
    return this.mRenderClip.getTexId();
  }
  
  public Rect getExtendEnlargeRegion()
  {
    return this.mOutputExtendRegion;
  }
  
  public Rect getExtendRegion()
  {
    return this.mExtendRegion;
  }
  
  public int getOutputTexture()
  {
    return this.mRenderInitFBO.getTexId();
  }
  
  public boolean getUpdateDataFlag()
  {
    return this.mUpdateFaceData;
  }
  
  public void init()
  {
    if (!this.mInited)
    {
      this.mRenderInitFBO = new RenderBuffer(this.netInputWidth, this.netInputHeight, 33987, true);
      this.mGPU2DFilter = new GPUBaseFilter("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\n\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord).bgra;\n}\n");
      this.mGPU2DFilter.init();
      this.mGPU2DFilterClip = new GPUBaseFilter();
      this.mGPU2DFilterClip.init();
      this.mRenderClip = new RenderBuffer(false, 0, 0);
      this.mRenderClip.setUserTextureId(0);
      this.mInited = true;
    }
    this.mUpdateFaceData = false;
  }
  
  public void regionScaleCenterInteger(Rect paramRect1, Rect paramRect2, float paramFloat)
  {
    int i = getEvenInt((int)(paramRect1.width() * paramFloat) / 2);
    int j = this.zhongxin.x;
    int k = this.zhongxin.y;
    paramRect2.set(j - i, k - i, j + i, i + k);
  }
  
  public void release()
  {
    if (this.mInited)
    {
      this.mInited = false;
      this.mGPU2DFilter.destroy();
      this.mRenderInitFBO.destroy();
      releaseRenderFBOTexture(this.mRenderInitFBO);
      this.mRenderClip.destroy();
      this.mGPU2DFilterClip.destroy();
      releaseRenderFBOTexture(this.mRenderClip);
    }
  }
  
  public void setCurrentScaleRatio(float paramFloat)
  {
    this.mCurrentScaleRatio = paramFloat;
  }
  
  public void setMaxScaleRatio(float paramFloat)
  {
    this.mMaxScaleRatio = paramFloat;
  }
  
  public void updateNetWorkSize(int paramInt1, int paramInt2)
  {
    this.netInputWidth = paramInt1;
    this.netInputHeight = paramInt2;
  }
  
  public void updateParams(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    this.mUpdateFaceData = true;
    this.fullFaceCoords = paramList;
    if ((this.fullFaceCoords == null) || (this.fullFaceCoords.size() <= 0))
    {
      this.mUpdateFaceData = false;
      return;
    }
    paramList = this.fullFaceCoords.iterator();
    while (paramList.hasNext())
    {
      paramArrayOfFloat = (PointF)paramList.next();
      paramArrayOfFloat.x = ((float)(paramArrayOfFloat.x / this.mScreenScale));
      paramArrayOfFloat.y = ((float)(paramArrayOfFloat.y / this.mScreenScale));
    }
    paramList = (PointF)this.fullFaceCoords.get(9);
    paramArrayOfFloat = (PointF)this.fullFaceCoords.get(86);
    PointF localPointF = (PointF)this.fullFaceCoords.get(88);
    if (!this.mTextureRegion.contains(paramList.x, paramList.y))
    {
      this.mUpdateFaceData = false;
      return;
    }
    if (!this.mTextureRegion.contains(paramArrayOfFloat.x, paramArrayOfFloat.y))
    {
      this.mUpdateFaceData = false;
      return;
    }
    if (!this.mTextureRegion.contains(localPointF.x, localPointF.y))
    {
      this.mUpdateFaceData = false;
      return;
    }
    float f1 = DISTANCE_OF(paramArrayOfFloat, localPointF);
    float f2 = DISTANCE_OF(paramList, paramArrayOfFloat);
    float f3 = DISTANCE_OF(paramList, localPointF);
    f2 = Math.max(Math.max(f2, f1), f3) * 1.46F;
    f1 = f2;
    if (f2 > this.mMaxConstLength) {
      f1 = this.mMaxConstLength;
    }
    int k = getEvenInt((int)(f1 * 0.5F));
    f1 = k * 2;
    this.zhongxin.set((int)((paramList.x + paramArrayOfFloat.x + localPointF.x) / 3.0F), (int)((paramList.y + paramArrayOfFloat.y + localPointF.y) / 3.0F));
    this.zhongxin.x = getEvenInt(this.zhongxin.x);
    this.zhongxin.y = getEvenInt(this.zhongxin.y);
    int i = this.zhongxin.x - k;
    int j = (int)f1;
    k = this.zhongxin.y - k;
    int m = (int)f1;
    this.mExtendRegion.set(i, k, j + i, m + k);
    this.mClipRegion.setIntersect(this.mWindows, this.mExtendRegion);
    f1 = this.mClipRegion.left * 1.0F / this.mTextureWidth;
    f2 = this.mClipRegion.top * 1.0F / this.mTextureHeight;
    f3 = this.mClipRegion.width() * 1.0F / this.mTextureWidth;
    float f4 = this.mClipRegion.height() * 1.0F / this.mTextureHeight;
    Matrix.setIdentityM(this.inClipMatrix, 0);
    Matrix.translateM(this.inClipMatrix, 0, f1, f2, 0.0F);
    Matrix.scaleM(this.inClipMatrix, 0, f3, f4, 1.0F);
    regionScaleCenterInteger(this.mExtendRegion, this.mOutputExtendRegion, this.mCurrentScaleRatio);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.mTextureWidth = paramInt1;
    this.mTextureHeight = paramInt2;
    this.mScreenScale = paramDouble;
    this.mTextureRegion.set(0.0F, 0.0F, this.mTextureWidth, this.mTextureHeight);
    this.mWindows.set(0, 0, this.mTextureWidth, this.mTextureHeight);
    this.mMaxConstLength = Math.max(this.mTextureWidth, this.mTextureHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.bighead.BigHeadInitFilter
 * JD-Core Version:    0.7.0.1
 */