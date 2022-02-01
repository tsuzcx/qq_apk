package com.tencent.ttpic.filter.aifilter;

import android.graphics.PointF;
import android.graphics.Rect;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.facebeauty.FaceDetect;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.view.RendererUtils;
import java.util.List;

public class AlphaFaceMaskFilter
  extends BaseFilter
{
  private static final String ALPHA_FACE_MASK_SHADER = "precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform highp vec2 faceCenter;\nuniform highp float radius;\nuniform highp int maskInterior;\nuniform highp float width;\nuniform highp float height;\nvoid main()\n{\n    highp float a = 1.0;\n    highp float x = textureCoordinate.x * width;\n    highp float y = textureCoordinate.y * height;\n    highp float dist = length(vec2(x-faceCenter.x, y-faceCenter.y));\n    if(dist < radius *2.0 / 3.0) {\n        a = 0.0;\n    } else if(dist < radius) {\n        a = (dist-radius *2.0 / 3.0)/(radius / 3.0);\n    }\n    if(maskInterior == 0) {\n        a = 1.0 - a;\n    }\n    vec4 c1 = texture2D(inputImageTexture, textureCoordinate.xy);\n    vec4 c2 = texture2D(inputImageTexture2, textureCoordinate.xy);\n    gl_FragColor = mix(c2,c1,a);\n}\n";
  float[] faceCenter = { 0.0F, 0.0F };
  FaceDetect faceDetector = null;
  boolean internalFaceDetect = true;
  int maskInterior = 1;
  float radius = 0.0F;
  private byte[] rgbaBuffer;
  
  public AlphaFaceMaskFilter()
  {
    super("precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform highp vec2 faceCenter;\nuniform highp float radius;\nuniform highp int maskInterior;\nuniform highp float width;\nuniform highp float height;\nvoid main()\n{\n    highp float a = 1.0;\n    highp float x = textureCoordinate.x * width;\n    highp float y = textureCoordinate.y * height;\n    highp float dist = length(vec2(x-faceCenter.x, y-faceCenter.y));\n    if(dist < radius *2.0 / 3.0) {\n        a = 0.0;\n    } else if(dist < radius) {\n        a = (dist-radius *2.0 / 3.0)/(radius / 3.0);\n    }\n    if(maskInterior == 0) {\n        a = 1.0 - a;\n    }\n    vec4 c1 = texture2D(inputImageTexture, textureCoordinate.xy);\n    vec4 c2 = texture2D(inputImageTexture2, textureCoordinate.xy);\n    gl_FragColor = mix(c2,c1,a);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.FloatsParam("faceCenter", this.faceCenter));
    addParam(new UniformParam.FloatParam("radius", this.radius));
    addParam(new UniformParam.IntParam("maskInterior", this.maskInterior));
    addParam(new UniformParam.FloatParam("width", paramFloat1));
    addParam(new UniformParam.FloatParam("height", paramFloat2));
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.rgbaBuffer == null) || (this.rgbaBuffer.length != paramInt2 * paramInt3 * 4)) {
      this.rgbaBuffer = new byte[paramInt2 * paramInt3 * 4];
    }
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    RendererUtils.saveTextureToRgbBuffer(paramInt1, paramInt2, paramInt3, this.rgbaBuffer, arrayOfInt[0]);
    Object localObject = new VideoPreviewFaceOutlineDetector();
    ((VideoPreviewFaceOutlineDetector)localObject).init();
    ((VideoPreviewFaceOutlineDetector)localObject).doFaceDetect(this.rgbaBuffer, paramInt2, paramInt3);
    ((VideoPreviewFaceOutlineDetector)localObject).doTrack(this.rgbaBuffer, paramInt2, paramInt3);
    List localList = ((VideoPreviewFaceOutlineDetector)localObject).getAllPoints(0);
    ((VideoPreviewFaceOutlineDetector)localObject).destroy();
    if ((localList == null) || (localList.size() == 0)) {
      return;
    }
    localObject = new Rect();
    if (localList.size() > 88)
    {
      ((Rect)localObject).left = ((int)((PointF)localList.get(86)).x);
      ((Rect)localObject).top = ((int)Math.min(((PointF)localList.get(86)).y, ((PointF)localList.get(88)).y));
      ((Rect)localObject).right = ((int)((PointF)localList.get(88)).x);
    }
    if (localList.size() > 9) {
      ((Rect)localObject).bottom = ((int)((PointF)localList.get(9)).y);
    }
    if (((Rect)localObject).left < 0) {
      ((Rect)localObject).left = 0;
    }
    if (((Rect)localObject).top < 0) {
      ((Rect)localObject).top = 0;
    }
    if (((Rect)localObject).right > paramInt2) {
      ((Rect)localObject).right = paramInt2;
    }
    if (((Rect)localObject).bottom > paramInt3) {
      ((Rect)localObject).bottom = paramInt3;
    }
    this.radius = ((float)Math.sqrt(((Rect)localObject).width() * ((Rect)localObject).width() + ((Rect)localObject).height() * ((Rect)localObject).height()) / 2.0F);
    this.radius *= 1.3F;
    this.faceCenter[0] = ((Rect)localObject).centerX();
    this.faceCenter[1] = ((Rect)localObject).centerY();
    addParam(new UniformParam.FloatsParam("faceCenter", this.faceCenter));
    addParam(new UniformParam.FloatParam("radius", this.radius));
    GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
  }
  
  public void setInternalFaceDetect(boolean paramBoolean, FaceDetect paramFaceDetect)
  {
    this.internalFaceDetect = paramBoolean;
    this.faceDetector = paramFaceDetect;
  }
  
  public void setMaskInterior(int paramInt)
  {
    this.maskInterior = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.AlphaFaceMaskFilter
 * JD-Core Version:    0.7.0.1
 */