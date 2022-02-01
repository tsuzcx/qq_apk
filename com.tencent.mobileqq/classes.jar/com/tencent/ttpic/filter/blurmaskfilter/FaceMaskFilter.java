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
import com.tencent.ttpic.openapi.model.VideoMaterial;
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
      if ((paramFaceMaskItem.faceMaskType == FaceMaskItem.FaceMaskType.SINGLE_MASK.value) && (paramFaceMaskItem.faceMaskImgPath != null))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramFaceMaskItem.faceMaskImgPath);
        localStringBuilder.append("0.png");
        this.mMaskPath = localStringBuilder.toString();
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
    boolean bool = CollectionUtils.isEmpty(paramList);
    int i = 0;
    if ((!bool) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      int k = 88;
      PointF localPointF = (PointF)paramList.get(88);
      float f2 = localPointF.x;
      float f1 = paramInt1;
      paramArrayOfFloat[0] = (f2 / f1 * 2.0F - 1.0F);
      f2 = localPointF.y;
      float f3 = paramInt2;
      paramArrayOfFloat[1] = (f2 / f3 * 2.0F - 1.0F);
      localPointF = (PointF)paramList.get(86);
      paramArrayOfFloat[2] = (localPointF.x / f1 * 2.0F - 1.0F);
      paramArrayOfFloat[3] = (localPointF.y / f3 * 2.0F - 1.0F);
      paramInt1 = 4;
      paramInt2 = i;
      int j;
      for (;;)
      {
        i = k;
        j = paramInt1;
        if (paramInt2 >= 19) {
          break;
        }
        localPointF = (PointF)paramList.get(paramInt2);
        i = paramInt1 + 1;
        paramArrayOfFloat[paramInt1] = (localPointF.x / f1 * 2.0F - 1.0F);
        paramInt1 = i + 1;
        paramArrayOfFloat[i] = (localPointF.y / f3 * 2.0F - 1.0F);
        paramInt2 += 1;
      }
      while (i > 86)
      {
        localPointF = (PointF)paramList.get(i);
        paramInt1 = j + 1;
        paramArrayOfFloat[j] = (localPointF.x / f1 * 2.0F - 1.0F);
        j = paramInt1 + 1;
        paramArrayOfFloat[paramInt1] = (localPointF.y / f3 * 2.0F - 1.0F);
        i -= 1;
      }
      return paramArrayOfFloat;
    }
    return new float[0];
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
    if (paramArrayOfFloat != null)
    {
      if (paramArrayOfFloat.length < 2) {
        return paramArrayOfFloat;
      }
      int k = paramArrayOfFloat.length / 2;
      float[] arrayOfFloat = this.sumXy;
      int j = 0;
      float f2;
      float f1;
      if ((arrayOfFloat != null) && (arrayOfFloat[0] >= 1.E-005D) && (arrayOfFloat[1] >= 1.E-005D))
      {
        f2 = arrayOfFloat[0];
        f1 = arrayOfFloat[1];
      }
      else
      {
        i = 0;
        f1 = 0.0F;
        f2 = 0.0F;
        while (i < k)
        {
          int m = i * 2;
          f1 += paramArrayOfFloat[m];
          f2 += paramArrayOfFloat[(m + 1)];
          i += 1;
        }
        f3 = f2;
        f2 = f1;
        f1 = f3;
      }
      float f3 = k;
      f2 /= f3;
      f1 /= f3;
      int i = j;
      while (i < k)
      {
        j = i * 2;
        paramArrayOfFloat[j] = ((paramArrayOfFloat[j] - f2) * paramFloat + f2);
        j += 1;
        paramArrayOfFloat[j] = ((paramArrayOfFloat[j] - f1) * paramFloat + f1);
        i += 1;
      }
    }
    return paramArrayOfFloat;
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
    Object localObject = this.mMaskFrame;
    if (localObject != null) {
      ((Frame)localObject).clear();
    }
    localObject = this.mCopyFilter;
    if (localObject != null) {
      ((BaseFilter)localObject).clearGLSL();
    }
    localObject = this.mGrayBitmap;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
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
    Object localObject = this.mGrayBitmap;
    if (localObject != null)
    {
      this.grayImageWidth = ((Bitmap)localObject).getWidth();
      this.grayImageHeight = this.mGrayBitmap.getHeight();
      localObject = this.mMaskPath;
      if (localObject != null)
      {
        localObject = loadImg((String)localObject);
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
        {
          this.mGrayBitmap.recycle();
          this.mGrayBitmap = ((Bitmap)localObject);
        }
      }
      float f = this.mMaskBlurStrength;
      if (f > 1.0F) {
        this.mGrayBitmap = featherBitmap(this.mGrayBitmap, f);
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
    catch (IOException paramBitmap)
    {
      paramBitmap.printStackTrace();
      return;
    }
    catch (FileNotFoundException paramBitmap)
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
    paramList = FaceOffUtil.getFullCoords(VideoMaterial.copyList(paramList), 3.0F);
    double d1 = this.width;
    double d2 = this.mFaceDetScale;
    Double.isNaN(d1);
    int i = (int)(d1 * d2);
    d1 = this.height;
    d2 = this.mFaceDetScale;
    Double.isNaN(d1);
    setPositions(FaceOffUtil.initFacePositions(paramList, i, (int)(d1 * d2), this.faceVertices));
    setCoordNum(690);
  }
  
  public void updateFacePoints(List<PointF> paramList)
  {
    paramList = FaceOffUtil.getFullCoords(VideoMaterial.copyList(paramList), 3.0F);
    float f = this.mMaskSizeValue;
    double d1;
    double d2;
    int i;
    if ((f > 0.9D) && (f < 1.1D))
    {
      d1 = this.width;
      d2 = this.mFaceDetScale;
      Double.isNaN(d1);
      i = (int)(d1 * d2);
      d1 = this.height;
      d2 = this.mFaceDetScale;
      Double.isNaN(d1);
      setPositions(FaceOffUtil.initFacePositions(paramList, i, (int)(d1 * d2), this.faceVertices));
    }
    else
    {
      d1 = this.width;
      d2 = this.mFaceDetScale;
      Double.isNaN(d1);
      i = (int)(d1 * d2);
      d1 = this.height;
      d2 = this.mFaceDetScale;
      Double.isNaN(d1);
      setPositions(resizePoints(FaceOffUtil.initFacePositions(paramList, i, (int)(d1 * d2), this.faceVertices, this.sumXy), this.mMaskSizeValue));
    }
    setCoordNum(690);
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
    paramList = VideoMaterial.copyList((List)paramList.get(0));
    FaceOffUtil.getFullCoords(paramList, 2.0F);
    double d1 = this.width;
    double d2 = this.mFaceDetScale;
    Double.isNaN(d1);
    int i = (int)(d1 * d2);
    d1 = this.height;
    d2 = this.mFaceDetScale;
    Double.isNaN(d1);
    setPositions(facePointInit(paramList, i, (int)(d1 * d2), this.faceVertices));
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