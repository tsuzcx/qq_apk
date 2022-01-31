package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.filter.ReshapeType;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import java.util.Map;

public class ReshapeCombineFilter_new
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER_NORMAL = "#ifdef GL_FRAGMENT_PRECISION_HIGH\n    precision highp float; //支持高精度，限定浮点型为高精度\n#else\n    precision mediump float; //不支持高精度，限定浮点型为中精度\n#endif\n\nvarying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n\n void main()\n {\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n }";
  public static final String FRAGMENT_SHADER_VTF = "#ifdef GL_FRAGMENT_PRECISION_HIGH\n    precision highp float; //支持高精度，限定浮点型为高精度\n#else\n    precision mediump float; //不支持高精度，限定浮点型为中精度\n#endif\n\nvarying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n\n void main()\n {\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n }";
  public static final String VERTEX_SHADER_NORMAL = "precision highp float;\n attribute vec4 position;\n attribute vec2 inputTextureCoordinate;\n attribute vec2 mesh_image1;\n attribute vec2 mesh_image2;\n\n varying vec2 textureCoordinate;\n uniform int vType; //0: draw base image, 1: draw with frag, 2: draw with frag and vertex, 3: draw with frag and vertex\n uniform vec2 srcSize;\n uniform vec2 cropSize;\n uniform vec2 texMapSize;   //形变纹理图大小\n uniform float boundFix;    //边缘修复比例\n\n void main()\n {\n     if (vType == 0){\n         gl_Position = position;\n         textureCoordinate = inputTextureCoordinate.xy;\n         return;\n     }\n     //this is base setting\n     textureCoordinate = position.xy;\n     vec2 rawPos = 2.0 * position.xy - 1.0;\n     if (vType == 1 || vType == 3){ //need fix fragment\n         //otherwise, load texture for diff\n         vec2 trueDiff = mesh_image1.xy;\n         if ((trueDiff.x < -0.9 && trueDiff.y < -0.9) || (trueDiff.x > 0.9 && trueDiff.y > 0.9)){\n             trueDiff = vec2(0.0, 0.0);\n         }\n         float px = 1.0;\n         float py = 1.0;\n         if (boundFix > 0.1){\n             if (textureCoordinate.x < 0.2){\n                 px = textureCoordinate.x / 0.2;\n             } else if (position.x > 0.8){\n                 px = (1.0 - textureCoordinate.x) / 0.2;\n             }\n             if (textureCoordinate.y < 0.2){\n                 py = textureCoordinate.y / 0.2;\n             } else if (position.y > 0.8){\n                 py = (1.0 - textureCoordinate.y) / 0.2;\n             }\n             px = 1.0 - (1.0 - clamp(px, 0.0, 1.0)) * boundFix;\n             py = 1.0 - (1.0 - clamp(py, 0.0, 1.0)) * boundFix;\n         }\n         textureCoordinate = textureCoordinate + vec2(px, py) * trueDiff * cropSize / srcSize;\n     }\n     if (vType == 2 || vType == 3){ //need fix vertex\n         vec2 trueDiff = mesh_image2.xy;\n         if ((trueDiff.x < -0.9 && trueDiff.y < -0.9) || (trueDiff.x > 0.9 && trueDiff.y > 0.9)){\n             trueDiff = vec2(0.0, 0.0);\n         }\n         rawPos = rawPos + 2.0 * trueDiff * cropSize / srcSize;\n     }\n     gl_Position = vec4(rawPos, position.zw);\n }";
  public static final String VERTEX_SHADER_VTF = "precision highp float;\n attribute vec4 position;\n attribute vec2 inputTextureCoordinate;\n uniform sampler2D inputImageTexture2;\n uniform sampler2D inputImageTexture3;\n\n varying vec2 textureCoordinate;\n uniform int vType; //0: draw base image, 1: draw with frag, 2: draw with frag and vertex, 3: draw with frag and vertex\n uniform vec2 srcSize;\n uniform vec2 cropSize;\n uniform vec2 texMapSize;   //形变纹理图大小\n uniform float boundFix;    //边缘修复比例\n\n void main()\n {\n     if (vType == 0){\n         gl_Position = position;\n         textureCoordinate = inputTextureCoordinate.xy;\n         return;\n     }\n     //this is base setting\n     textureCoordinate = position.xy;\n     vec2 rawPos = 2.0 * position.xy - 1.0;\n     if (vType == 1 || vType == 3){ //need fix fragment\n         //otherwise, load texture for diff\n         vec2 inputTex = inputTextureCoordinate.xy;\n         inputTex = (inputTex * (texMapSize - 1.0) + 0.5) / texMapSize;\n         vec4 texDiff = texture2D(inputImageTexture2, inputTex);\n         vec2 trueDiff = (texDiff.xy * 255.0 + texDiff.zw) / 127.5 - 1.0;\n         if ((trueDiff.x < -0.9 && trueDiff.y < -0.9) || (trueDiff.x > 0.9 && trueDiff.y > 0.9)){\n             trueDiff = vec2(0.0, 0.0);\n         }\n         float px = 1.0;\n         float py = 1.0;\n         if (boundFix > 0.1){\n             if (textureCoordinate.x < 0.2){\n                 px = textureCoordinate.x / 0.2;\n             } else if (position.x > 0.8){\n                 px = (1.0 - textureCoordinate.x) / 0.2;\n             }\n             if (textureCoordinate.y < 0.2){\n                 py = textureCoordinate.y / 0.2;\n             } else if (position.y > 0.8){\n                 py = (1.0 - textureCoordinate.y) / 0.2;\n             }\n             px = 1.0 - (1.0 - clamp(px, 0.0, 1.0)) * boundFix;\n             py = 1.0 - (1.0 - clamp(py, 0.0, 1.0)) * boundFix;\n         }\n         textureCoordinate = textureCoordinate + vec2(px, py) * trueDiff * cropSize / srcSize;\n     }\n     if (vType == 2 || vType == 3){ //need fix vertex\n         vec2 inputTex = inputTextureCoordinate.xy;\n         inputTex = (inputTex * (texMapSize - 1.0) + 0.5) / texMapSize;\n         vec4 texDiff = texture2D(inputImageTexture3, inputTex);\n         vec2 trueDiff = (texDiff.xy * 255.0 + texDiff.zw) / 127.5 - 1.0;\n         if ((trueDiff.x < -0.9 && trueDiff.y < -0.9) || (trueDiff.x > 0.9 && trueDiff.y > 0.9)){\n             trueDiff = vec2(0.0, 0.0);\n         }\n         rawPos = rawPos + 2.0 * trueDiff * cropSize / srcSize;\n     }\n     gl_Position = vec4(rawPos, position.zw);\n }";
  public static final int XCOORD_NUM = 64;
  public static final int YCOORD_NUM = 64;
  private static float[] mFullscreenVerticesPortrait;
  private static float[] mInitTextureCoordinatesPortrait;
  private static float[] positionArray = null;
  private float[] cropSize = { 1.0F, 1.0F };
  private int eyeMaskTex = 0;
  private int eyeMaskTex2 = 0;
  private float optimizeBoundaryStrength = 0.25F;
  private float[] srcSize = { 1.0F, 1.0F };
  private float[] texMapSize = { 67.0F, 67.0F };
  private ReshapeType useMeshType;
  private int vType = 1;
  
  public ReshapeCombineFilter_new(ReshapeType paramReshapeType)
  {
    super(BaseFilter.nativeDecrypt("precision highp float;\n attribute vec4 position;\n attribute vec2 inputTextureCoordinate;\n uniform sampler2D inputImageTexture2;\n uniform sampler2D inputImageTexture3;\n\n varying vec2 textureCoordinate;\n uniform int vType; //0: draw base image, 1: draw with frag, 2: draw with frag and vertex, 3: draw with frag and vertex\n uniform vec2 srcSize;\n uniform vec2 cropSize;\n uniform vec2 texMapSize;   //形变纹理图大小\n uniform float boundFix;    //边缘修复比例\n\n void main()\n {\n     if (vType == 0){\n         gl_Position = position;\n         textureCoordinate = inputTextureCoordinate.xy;\n         return;\n     }\n     //this is base setting\n     textureCoordinate = position.xy;\n     vec2 rawPos = 2.0 * position.xy - 1.0;\n     if (vType == 1 || vType == 3){ //need fix fragment\n         //otherwise, load texture for diff\n         vec2 inputTex = inputTextureCoordinate.xy;\n         inputTex = (inputTex * (texMapSize - 1.0) + 0.5) / texMapSize;\n         vec4 texDiff = texture2D(inputImageTexture2, inputTex);\n         vec2 trueDiff = (texDiff.xy * 255.0 + texDiff.zw) / 127.5 - 1.0;\n         if ((trueDiff.x < -0.9 && trueDiff.y < -0.9) || (trueDiff.x > 0.9 && trueDiff.y > 0.9)){\n             trueDiff = vec2(0.0, 0.0);\n         }\n         float px = 1.0;\n         float py = 1.0;\n         if (boundFix > 0.1){\n             if (textureCoordinate.x < 0.2){\n                 px = textureCoordinate.x / 0.2;\n             } else if (position.x > 0.8){\n                 px = (1.0 - textureCoordinate.x) / 0.2;\n             }\n             if (textureCoordinate.y < 0.2){\n                 py = textureCoordinate.y / 0.2;\n             } else if (position.y > 0.8){\n                 py = (1.0 - textureCoordinate.y) / 0.2;\n             }\n             px = 1.0 - (1.0 - clamp(px, 0.0, 1.0)) * boundFix;\n             py = 1.0 - (1.0 - clamp(py, 0.0, 1.0)) * boundFix;\n         }\n         textureCoordinate = textureCoordinate + vec2(px, py) * trueDiff * cropSize / srcSize;\n     }\n     if (vType == 2 || vType == 3){ //need fix vertex\n         vec2 inputTex = inputTextureCoordinate.xy;\n         inputTex = (inputTex * (texMapSize - 1.0) + 0.5) / texMapSize;\n         vec4 texDiff = texture2D(inputImageTexture3, inputTex);\n         vec2 trueDiff = (texDiff.xy * 255.0 + texDiff.zw) / 127.5 - 1.0;\n         if ((trueDiff.x < -0.9 && trueDiff.y < -0.9) || (trueDiff.x > 0.9 && trueDiff.y > 0.9)){\n             trueDiff = vec2(0.0, 0.0);\n         }\n         rawPos = rawPos + 2.0 * trueDiff * cropSize / srcSize;\n     }\n     gl_Position = vec4(rawPos, position.zw);\n }"), BaseFilter.nativeDecrypt("#ifdef GL_FRAGMENT_PRECISION_HIGH\n    precision highp float; //支持高精度，限定浮点型为高精度\n#else\n    precision mediump float; //不支持高精度，限定浮点型为中精度\n#endif\n\nvarying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n\n void main()\n {\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n }"));
    if (paramReshapeType == ReshapeType.NORMAL) {
      updateFilterShader(BaseFilter.nativeDecrypt("precision highp float;\n attribute vec4 position;\n attribute vec2 inputTextureCoordinate;\n attribute vec2 mesh_image1;\n attribute vec2 mesh_image2;\n\n varying vec2 textureCoordinate;\n uniform int vType; //0: draw base image, 1: draw with frag, 2: draw with frag and vertex, 3: draw with frag and vertex\n uniform vec2 srcSize;\n uniform vec2 cropSize;\n uniform vec2 texMapSize;   //形变纹理图大小\n uniform float boundFix;    //边缘修复比例\n\n void main()\n {\n     if (vType == 0){\n         gl_Position = position;\n         textureCoordinate = inputTextureCoordinate.xy;\n         return;\n     }\n     //this is base setting\n     textureCoordinate = position.xy;\n     vec2 rawPos = 2.0 * position.xy - 1.0;\n     if (vType == 1 || vType == 3){ //need fix fragment\n         //otherwise, load texture for diff\n         vec2 trueDiff = mesh_image1.xy;\n         if ((trueDiff.x < -0.9 && trueDiff.y < -0.9) || (trueDiff.x > 0.9 && trueDiff.y > 0.9)){\n             trueDiff = vec2(0.0, 0.0);\n         }\n         float px = 1.0;\n         float py = 1.0;\n         if (boundFix > 0.1){\n             if (textureCoordinate.x < 0.2){\n                 px = textureCoordinate.x / 0.2;\n             } else if (position.x > 0.8){\n                 px = (1.0 - textureCoordinate.x) / 0.2;\n             }\n             if (textureCoordinate.y < 0.2){\n                 py = textureCoordinate.y / 0.2;\n             } else if (position.y > 0.8){\n                 py = (1.0 - textureCoordinate.y) / 0.2;\n             }\n             px = 1.0 - (1.0 - clamp(px, 0.0, 1.0)) * boundFix;\n             py = 1.0 - (1.0 - clamp(py, 0.0, 1.0)) * boundFix;\n         }\n         textureCoordinate = textureCoordinate + vec2(px, py) * trueDiff * cropSize / srcSize;\n     }\n     if (vType == 2 || vType == 3){ //need fix vertex\n         vec2 trueDiff = mesh_image2.xy;\n         if ((trueDiff.x < -0.9 && trueDiff.y < -0.9) || (trueDiff.x > 0.9 && trueDiff.y > 0.9)){\n             trueDiff = vec2(0.0, 0.0);\n         }\n         rawPos = rawPos + 2.0 * trueDiff * cropSize / srcSize;\n     }\n     gl_Position = vec4(rawPos, position.zw);\n }"), BaseFilter.nativeDecrypt("#ifdef GL_FRAGMENT_PRECISION_HIGH\n    precision highp float; //支持高精度，限定浮点型为高精度\n#else\n    precision mediump float; //不支持高精度，限定浮点型为中精度\n#endif\n\nvarying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n\n void main()\n {\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n }"));
    }
    this.useMeshType = paramReshapeType;
    initParams();
  }
  
  public void ApplyGLSLFilter()
  {
    initParams();
    super.ApplyGLSLFilter();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLE_STRIP);
  }
  
  public void initAttribParams()
  {
    setPositions(mFullscreenVerticesPortrait, false);
    setTexCords(mInitTextureCoordinatesPortrait, false);
    setCoordNum(8257);
    if (this.useMeshType == ReshapeType.NORMAL) {
      updateImage(mFullscreenVerticesPortrait, mFullscreenVerticesPortrait);
    }
  }
  
  public void initParams()
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", this.eyeMaskTex, 33986));
    addParam(new UniformParam.TextureParam("inputImageTexture3", this.eyeMaskTex2, 33987));
    addParam(new UniformParam.FloatsParam("srcSize", this.srcSize));
    addParam(new UniformParam.FloatsParam("cropSize", this.cropSize));
    addParam(new UniformParam.FloatsParam("texMapSize", this.texMapSize));
    addParam(new UniformParam.IntParam("vType", this.vType));
    addParam(new UniformParam.FloatParam("boundFix", this.optimizeBoundaryStrength));
  }
  
  public void setInitMesh(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    mFullscreenVerticesPortrait = VideoMaterialUtil.toFlatArray(VideoMaterialUtil.genFullScreenVertices(66, 66, 0.0F, 1.0F, 0.0F, 1.0F));
    mInitTextureCoordinatesPortrait = mFullscreenVerticesPortrait;
  }
  
  public void setParam(Map<String, Object> paramMap)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return;
    }
    if (paramMap.containsKey("inputImageTexture2")) {
      this.eyeMaskTex = ((Integer)paramMap.get("inputImageTexture2")).intValue();
    }
    if (paramMap.containsKey("inputImageTexture3")) {
      this.eyeMaskTex2 = ((Integer)paramMap.get("inputImageTexture3")).intValue();
    }
    if (paramMap.containsKey("srcSize")) {
      this.srcSize = ((float[])paramMap.get("srcSize"));
    }
    if (paramMap.containsKey("cropSize")) {
      this.cropSize = ((float[])paramMap.get("cropSize"));
    }
    if (paramMap.containsKey("texMapSize")) {
      this.texMapSize = ((float[])paramMap.get("texMapSize"));
    }
    if (paramMap.containsKey("vType")) {
      this.vType = ((Integer)paramMap.get("vType")).intValue();
    }
    initParams();
  }
  
  public void updateImage(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    addAttribParam("mesh_image1", paramArrayOfFloat1, false);
    addAttribParam("mesh_image2", paramArrayOfFloat2, false);
  }
  
  public void updateSize(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (positionArray == null) {
      positionArray = new float[mFullscreenVerticesPortrait.length];
    }
    VideoMaterialUtil.genFullScreenVertices(positionArray, 66, 66, paramFloat1 - (paramFloat2 - paramFloat1) / 64.0F, paramFloat2 + (paramFloat2 - paramFloat1) / 64.0F, paramFloat3 - (paramFloat4 - paramFloat3) / 64.0F, paramFloat4 + (paramFloat4 - paramFloat3) / 64.0F);
    setPositions(positionArray, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.ReshapeCombineFilter_new
 * JD-Core Version:    0.7.0.1
 */