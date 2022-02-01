package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.FaceDetectUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FeatureType;
import java.util.List;

public class CFSkinCropFilterV2
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = " precision highp float;\n varying vec2 textureCoordinate;\n varying vec2 textureCoordinate2;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n void main()\n {\n     vec4 maskColor = texture2D(inputImageTexture2 , textureCoordinate2);\n     vec4 userColor = texture2D(inputImageTexture , textureCoordinate);\n     gl_FragColor = vec4(userColor.rgb, 1.0 - maskColor.b);\n }";
  private static final String VERTEX_SHADER = " attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n attribute vec4 inputTextureCoordinate2;\n varying vec2 textureCoordinate;\n varying vec2 textureCoordinate2;\n \n void main()\n {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n     textureCoordinate2 = inputTextureCoordinate2.xy;\n }";
  private Bitmap mMaskBitmap;
  private float[] maskVertices = new float[1104];
  private float[] positions = new float[1104];
  private float[] texVertices = new float[1104];
  
  public CFSkinCropFilterV2(String paramString)
  {
    super(" attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n attribute vec4 inputTextureCoordinate2;\n varying vec2 textureCoordinate;\n varying vec2 textureCoordinate2;\n \n void main()\n {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n     textureCoordinate2 = inputTextureCoordinate2.xy;\n }", " precision highp float;\n varying vec2 textureCoordinate;\n varying vec2 textureCoordinate2;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n void main()\n {\n     vec4 maskColor = texture2D(inputImageTexture2 , textureCoordinate2);\n     vec4 userColor = texture2D(inputImageTexture , textureCoordinate);\n     gl_FragColor = vec4(userColor.rgb, 1.0 - maskColor.b);\n }");
    this.mMaskBitmap = FaceOffUtil.getCrazySkinMergeMask(paramString);
    if (!BitmapUtils.isLegal(this.mMaskBitmap)) {
      this.mMaskBitmap = FaceOffUtil.getGrayBitmap(FaceOffUtil.FeatureType.FACE_SKIN);
    }
    initParams();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    setCoordNum(552);
  }
  
  public void initAttribParams()
  {
    setPositions(this.positions);
    setTexCords(this.texVertices);
    List localList = FaceOffUtil.getGrayCoords(FaceOffUtil.FeatureType.FACE_SKIN);
    FaceDetectUtil.facePointf83to90(localList);
    addAttribParam("inputTextureCoordinate2", FaceOffUtil.initMaterialFaceTexCoordsFaceAverage(FaceOffUtil.getFullCoords(localList, 2.0F), this.mMaskBitmap.getWidth(), this.mMaskBitmap.getHeight(), this.maskVertices, 0));
  }
  
  public void initParams()
  {
    addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", this.mMaskBitmap, 33986, true));
  }
  
  public void setFacePointsInfo(List<PointF> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    paramList = VideoMaterial.copyList(paramList);
    setPositions(FaceOffUtil.initFacePositionsFaceAverage(paramList, paramInt1, paramInt2, this.positions, paramInt3));
    setTexCords(FaceOffUtil.initMaterialFaceTexCoordsFaceAverage(paramList, paramInt1, paramInt2, this.texVertices, paramInt3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.CFSkinCropFilterV2
 * JD-Core Version:    0.7.0.1
 */