package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.StickerItem;
import java.io.File;

public class LutFilter
  extends VideoFilterBase
{
  private static final String fragment = "precision highp float;\nvarying vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D lutTexture;\nuniform sampler2D maskTexture;\n\nvec4 lut(sampler2D inputImageTexture, sampler2D inputImageTextureLUT) {\n\n    vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    highp float blueColor = textureColor.b * 63.0;\n    highp vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n    highp vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 8.0);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n    highp vec2 texPos1;\n    texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n    texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n    highp vec2 texPos2;\n    texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n    texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n    lowp vec4 newColor1 = texture2D(inputImageTextureLUT, texPos1);\n    lowp vec4 newColor2 = texture2D(inputImageTextureLUT, texPos2);\n    vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    return newColor;\n}\n\n\nvoid main()\n{\n    vec4 lutColor = lut(inputImageTexture, lutTexture);\n    vec4 maskColor = texture2D(maskTexture, textureCoordinate);\n    gl_FragColor = mix(texture2D(inputImageTexture, textureCoordinate), lutColor, maskColor.r);\n}\n";
  private static final String vertex = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nuniform mat4 Projection;\nuniform mat4 Modelview;\nuniform mat4 tMat;\nvoid main(void)\n{\n   gl_Position = Projection * Modelview *position;\n   vec4 tmp = tMat*vec4(inputTextureCoordinate.x,inputTextureCoordinate.y,0.0,1.0);\n   textureCoordinate = tmp.xy;\n}\n";
  private String lutPath;
  private int[] tex = new int[1];
  
  public LutFilter(String paramString, StickerItem paramStickerItem)
  {
    super("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nuniform mat4 Projection;\nuniform mat4 Modelview;\nuniform mat4 tMat;\nvoid main(void)\n{\n   gl_Position = Projection * Modelview *position;\n   vec4 tmp = tMat*vec4(inputTextureCoordinate.x,inputTextureCoordinate.y,0.0,1.0);\n   textureCoordinate = tmp.xy;\n}\n", "precision highp float;\nvarying vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D lutTexture;\nuniform sampler2D maskTexture;\n\nvec4 lut(sampler2D inputImageTexture, sampler2D inputImageTextureLUT) {\n\n    vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    highp float blueColor = textureColor.b * 63.0;\n    highp vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n    highp vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 8.0);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n    highp vec2 texPos1;\n    texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n    texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n    highp vec2 texPos2;\n    texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n    texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n    lowp vec4 newColor1 = texture2D(inputImageTextureLUT, texPos1);\n    lowp vec4 newColor2 = texture2D(inputImageTextureLUT, texPos2);\n    vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    return newColor;\n}\n\n\nvoid main()\n{\n    vec4 lutColor = lut(inputImageTexture, lutTexture);\n    vec4 maskColor = texture2D(maskTexture, textureCoordinate);\n    gl_FragColor = mix(texture2D(inputImageTexture, textureCoordinate), lutColor, maskColor.r);\n}\n");
    this.lutPath = (paramString + File.separator + paramStickerItem.maskLut);
  }
  
  private void initLut()
  {
    addParam(new UniformParam.TextureBitmapParam("lutTexture", BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.lutPath, 1), 33986, true));
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    GLES20.glGenTextures(this.tex.length, this.tex, 0);
    initLut();
  }
  
  public void clearGLSLSelf()
  {
    GLES20.glDeleteTextures(this.tex.length, this.tex, 0);
    super.clearGLSLSelf();
  }
  
  public Frame render(Frame paramFrame, PTDetectInfo paramPTDetectInfo, Bitmap paramBitmap)
  {
    GlUtil.loadTexture(this.tex[0], paramBitmap);
    addParam(new UniformParam.TextureParam("maskTexture", this.tex[0], 33987));
    return super.render(paramFrame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.LutFilter
 * JD-Core Version:    0.7.0.1
 */