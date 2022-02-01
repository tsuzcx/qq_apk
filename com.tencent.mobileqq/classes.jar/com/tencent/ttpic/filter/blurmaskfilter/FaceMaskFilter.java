package com.tencent.ttpic.filter.blurmaskfilter;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.model.FaceMaskItem;
import com.tencent.ttpic.model.FaceMaskItem.FaceMaskType;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.filter.FaceLineFilter;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FeatureType;
import com.tencent.view.RendererUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class FaceMaskFilter
  extends VideoFilterBase
  implements BlurMaskFilter.IBlurMaskFactory
{
  public static final String FRAGMENT_SHADER = "precision highp float;\n varying vec2 grayTextureCoordinate;\n uniform sampler2D inputImageTexture2;\n void main() {\n    vec4 graycolor= texture2D(inputImageTexture2, grayTextureCoordinate);\n    float grayColorR=1.0-graycolor.r;\n    if(graycolor.r<0.981){\n        gl_FragColor = vec4(grayColorR,grayColorR,grayColorR,1.0);\n    }\n }";
  private static final String TAG = FaceLineFilter.class.getSimpleName();
  public static final String VERTEX_SHADER = "attribute vec4 position;\n\nattribute vec4 inputGrayTextureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvoid main() {\n    gl_Position = position;\n    grayTextureCoordinate  = inputGrayTextureCoordinate.xy;\n}\n";
  private static final int WIDTH_MASK = 360;
  private float[] faceVertices = new float[1380];
  private int grayImageHeight;
  private int grayImageWidth;
  private float[] grayVertices = new float[1380];
  private BaseFilter mCopyFilter;
  private Bitmap mGrayBitmap;
  private boolean mIsNeedWhiteBg = false;
  private float mMaskBlurStrength = 0.0F;
  private Frame mMaskFrame;
  private String mMaskPath;
  private float mMaskSizeValue = 1.0F;
  private int mOutHeight;
  private int mOutWidth;
  private float[] mVertexs;
  private float[] sumXy = new float[2];
  
  public FaceMaskFilter()
  {
    super("attribute vec4 position;\n\nattribute vec4 inputGrayTextureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvoid main() {\n    gl_Position = position;\n    grayTextureCoordinate  = inputGrayTextureCoordinate.xy;\n}\n", "precision highp float;\n varying vec2 grayTextureCoordinate;\n uniform sampler2D inputImageTexture2;\n void main() {\n    vec4 graycolor= texture2D(inputImageTexture2, grayTextureCoordinate);\n    float grayColorR=1.0-graycolor.r;\n    if(graycolor.r<0.981){\n        gl_FragColor = vec4(grayColorR,grayColorR,grayColorR,1.0);\n    }\n }");
    initParams();
  }
  
  public FaceMaskFilter(FaceMaskItem paramFaceMaskItem)
  {
    super("attribute vec4 position;\n\nattribute vec4 inputGrayTextureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvoid main() {\n    gl_Position = position;\n    grayTextureCoordinate  = inputGrayTextureCoordinate.xy;\n}\n", "precision highp float;\n varying vec2 grayTextureCoordinate;\n uniform sampler2D inputImageTexture2;\n void main() {\n    vec4 graycolor= texture2D(inputImageTexture2, grayTextureCoordinate);\n    float grayColorR=1.0-graycolor.r;\n    if(graycolor.r<0.981){\n        gl_FragColor = vec4(grayColorR,grayColorR,grayColorR,1.0);\n    }\n }");
    if ((paramFaceMaskItem != null) && (paramFaceMaskItem.isValid))
    {
      if ((paramFaceMaskItem.faceMaskType == FaceMaskItem.FaceMaskType.SINGLE_MASK.value) && (paramFaceMaskItem.faceMaskImgPath != null)) {
        this.mMaskPath = (paramFaceMaskItem.faceMaskImgPath + "0.png");
      }
      this.mMaskBlurStrength = ((float)paramFaceMaskItem.featherStrength);
      this.mMaskSizeValue = ((float)paramFaceMaskItem.faceMaskSize);
    }
    initParams();
  }
  
  public FaceMaskFilter(String paramString)
  {
    super("attribute vec4 position;\n\nattribute vec4 inputGrayTextureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvoid main() {\n    gl_Position = position;\n    grayTextureCoordinate  = inputGrayTextureCoordinate.xy;\n}\n", "precision highp float;\n varying vec2 grayTextureCoordinate;\n uniform sampler2D inputImageTexture2;\n void main() {\n    vec4 graycolor= texture2D(inputImageTexture2, grayTextureCoordinate);\n    float grayColorR=1.0-graycolor.r;\n    if(graycolor.r<0.981){\n        gl_FragColor = vec4(grayColorR,grayColorR,grayColorR,1.0);\n    }\n }");
    this.mMaskPath = paramString;
    initParams();
  }
  
  private float[] facePointInit(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    int n = 88;
    if ((CollectionUtils.isEmpty(paramList)) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      localObject = new float[0];
      return localObject;
    }
    Object localObject = (PointF)paramList.get(88);
    paramArrayOfFloat[0] = (((PointF)localObject).x / paramInt1 * 2.0F - 1.0F);
    paramArrayOfFloat[1] = (((PointF)localObject).y / paramInt2 * 2.0F - 1.0F);
    localObject = (PointF)paramList.get(86);
    paramArrayOfFloat[2] = (((PointF)localObject).x / paramInt1 * 2.0F - 1.0F);
    paramArrayOfFloat[3] = (((PointF)localObject).y / paramInt2 * 2.0F - 1.0F);
    int j = 0;
    int i = 4;
    int k;
    int m;
    for (;;)
    {
      k = n;
      m = i;
      if (j >= 19) {
        break;
      }
      localObject = (PointF)paramList.get(j);
      k = i + 1;
      paramArrayOfFloat[i] = (((PointF)localObject).x / paramInt1 * 2.0F - 1.0F);
      i = k + 1;
      paramArrayOfFloat[k] = (((PointF)localObject).y / paramInt2 * 2.0F - 1.0F);
      j += 1;
    }
    for (;;)
    {
      localObject = paramArrayOfFloat;
      if (k <= 86) {
        break;
      }
      localObject = (PointF)paramList.get(k);
      i = m + 1;
      paramArrayOfFloat[m] = (((PointF)localObject).x / paramInt1 * 2.0F - 1.0F);
      m = i + 1;
      paramArrayOfFloat[i] = (((PointF)localObject).y / paramInt2 * 2.0F - 1.0F);
      k -= 1;
    }
  }
  
  private Bitmap featherBitmap(Bitmap paramBitmap, float paramFloat)
  {
    if (paramBitmap == null) {
      return null;
    }
    Frame localFrame1 = new Frame(0, RendererUtils.createTexture(paramBitmap), paramBitmap.getWidth(), paramBitmap.getHeight());
    localFrame1.width = paramBitmap.getWidth();
    localFrame1.height = paramBitmap.getHeight();
    Object localObject = new GaussinNoMaskFilter(paramFloat);
    ((GaussinNoMaskFilter)localObject).applyFilterChain(false, localFrame1.width, localFrame1.height);
    ((GaussinNoMaskFilter)localObject).updateVideoSize(localFrame1.width, localFrame1.height);
    Frame localFrame2 = new Frame();
    Frame localFrame3 = ((GaussinNoMaskFilter)localObject).RenderProcess(localFrame1, localFrame2);
    ((GaussinNoMaskFilter)localObject).clear();
    localObject = RendererUtils.saveTexture(localFrame3.getTextureId(), paramBitmap.getWidth(), paramBitmap.getHeight());
    if (!paramBitmap.isRecycled()) {
      paramBitmap.recycle();
    }
    localFrame1.clear();
    RendererUtils.clearTexture(localFrame1.getTextureId());
    localFrame2.clear();
    localFrame3.clear();
    return localObject;
  }
  
  private float[] resizePoints(float[] paramArrayOfFloat, float paramFloat)
  {
    float f2 = 0.0F;
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length < 2)) {}
    for (;;)
    {
      return paramArrayOfFloat;
      int j = paramArrayOfFloat.length / 2;
      int k;
      if ((this.sumXy == null) || (this.sumXy[0] < 1.E-005D) || (this.sumXy[1] < 1.E-005D))
      {
        i = 0;
        for (f1 = 0.0F;; f1 = f3 + f1)
        {
          f3 = f2;
          f4 = f1;
          if (i >= j) {
            break;
          }
          k = i * 2;
          f3 = paramArrayOfFloat[k];
          f4 = paramArrayOfFloat[(k + 1)];
          i += 1;
          f2 = f4 + f2;
        }
      }
      float f4 = this.sumXy[0];
      float f3 = this.sumXy[1];
      float f1 = f4 / j;
      f2 = f3 / j;
      int i = 0;
      while (i < j)
      {
        k = i * 2;
        paramArrayOfFloat[k] = ((paramArrayOfFloat[k] - f1) * paramFloat + f1);
        paramArrayOfFloat[(k + 1)] = ((paramArrayOfFloat[(k + 1)] - f2) * paramFloat + f2);
        i += 1;
      }
    }
  }
  
  public void apply()
  {
    super.ApplyGLSLFilter();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    setCoordNum(690);
    this.mMaskFrame = new Frame();
    this.mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    this.mCopyFilter.apply();
  }
  
  public void clear()
  {
    clearGLSLSelf();
    if (this.mMaskFrame != null) {
      this.mMaskFrame.clear();
    }
    if (this.mCopyFilter != null) {
      this.mCopyFilter.clearGLSL();
    }
    if ((this.mGrayBitmap != null) && (!this.mGrayBitmap.isRecycled())) {
      this.mGrayBitmap.recycle();
    }
  }
  
  public void initAttribParams()
  {
    setPositions(GlUtil.ORIGIN_POSITION_COORDS);
    this.mVertexs = FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoords(FaceOffUtil.getGrayCoords(FaceOffUtil.FeatureType.FACE_HEAD_CROP), 3.0F), this.grayImageWidth, this.grayImageHeight, this.grayVertices);
    addAttribParam("inputGrayTextureCoordinate", this.mVertexs);
  }
  
  public void initParams()
  {
    this.mGrayBitmap = FaceOffUtil.getGrayBitmap(FaceOffUtil.FeatureType.FACE_HEAD_CROP);
    if (this.mGrayBitmap != null)
    {
      this.grayImageWidth = this.mGrayBitmap.getWidth();
      this.grayImageHeight = this.mGrayBitmap.getHeight();
      if (this.mMaskPath != null)
      {
        Bitmap localBitmap = loadImg(this.mMaskPath);
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          this.mGrayBitmap.recycle();
          this.mGrayBitmap = localBitmap;
        }
      }
      if (this.mMaskBlurStrength > 1.0F) {
        this.mGrayBitmap = featherBitmap(this.mGrayBitmap, this.mMaskBlurStrength);
      }
      addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", this.mGrayBitmap, 33986, true));
    }
  }
  
  public Bitmap loadImg(String paramString)
  {
    return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), paramString, 2147483647, 2147483647);
  }
  
  public void pause() {}
  
  public void render(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = paramInt3 * 360 / paramInt2;
    if (this.mIsNeedWhiteBg)
    {
      GLES20.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
      GLES20.glClear(16384);
    }
    GLES20.glLineWidth(3.0F);
    GlUtil.setBlendMode(true);
    OnDrawFrameGLSL();
    renderTexture(paramInt1, 360, paramInt2);
    GlUtil.setBlendMode(false);
  }
  
  public Frame renderMask(PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr)
  {
    this.mCopyFilter.RenderProcess(-1, this.width, this.height, -1, 0.0D, this.mMaskFrame);
    if (paramPTFaceAttr == null) {
      return this.mMaskFrame;
    }
    paramPTSegAttr = paramPTFaceAttr.getAllFacePoints().iterator();
    while (paramPTSegAttr.hasNext())
    {
      updateFacePoints((List)paramPTSegAttr.next());
      updateVideoSize(this.mOutWidth, this.mOutHeight, paramPTFaceAttr.getFaceDetectScale());
      render(this.mMaskFrame.getTextureId(), this.mOutWidth, this.mOutHeight);
    }
    return this.mMaskFrame;
  }
  
  public void resume() {}
  
  public void saveBitmap(Bitmap paramBitmap, String paramString)
  {
    LogUtils.e(TAG, "保存图片");
    paramString = new File("/sdcard/", paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
    try
    {
      paramString = new FileOutputStream(paramString);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 90, paramString);
      paramString.flush();
      paramString.close();
      LogUtils.i(TAG, "已经保存");
      return;
    }
    catch (FileNotFoundException paramBitmap)
    {
      paramBitmap.printStackTrace();
      return;
    }
    catch (IOException paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
  }
  
  public void setMaskSize(float paramFloat)
  {
    this.mMaskSizeValue = paramFloat;
  }
  
  public void setWhiteBg(boolean paramBoolean)
  {
    this.mIsNeedWhiteBg = paramBoolean;
  }
  
  public void updateAndResizeFacePoints(List<PointF> paramList, float paramFloat)
  {
    setPositions(FaceOffUtil.initFacePositions(FaceOffUtil.getFullCoords(VideoMaterialUtil.copyList(paramList), 3.0F), (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices));
    setCoordNum(690);
  }
  
  public void updateFacePoints(List<PointF> paramList)
  {
    paramList = FaceOffUtil.getFullCoords(VideoMaterialUtil.copyList(paramList), 3.0F);
    if ((this.mMaskSizeValue > 0.9D) && (this.mMaskSizeValue < 1.1D)) {
      setPositions(FaceOffUtil.initFacePositions(paramList, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices));
    }
    for (;;)
    {
      setCoordNum(690);
      return;
      setPositions(resizePoints(FaceOffUtil.initFacePositions(paramList, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices, this.sumXy), this.mMaskSizeValue));
    }
  }
  
  public void updatePoints(List<List<PointF>> paramList)
  {
    if (paramList.size() == 0)
    {
      setPositions(GlUtil.EMPTY_POSITIONS);
      setCoordNum(4);
      return;
    }
    updateFacePoints((List)paramList.get(0));
  }
  
  public void updatePointsAngles(List<List<PointF>> paramList)
  {
    if (paramList.size() == 0)
    {
      setPositions(GlUtil.EMPTY_POSITIONS);
      setCoordNum(4);
      return;
    }
    paramList = VideoMaterialUtil.copyList((List)paramList.get(0));
    FaceOffUtil.getFullCoords(paramList, 2.0F);
    setPositions(facePointInit(paramList, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices));
    setCoordNum(23);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.mOutHeight = paramInt2;
    this.mOutWidth = paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.blurmaskfilter.FaceMaskFilter
 * JD-Core Version:    0.7.0.1
 */