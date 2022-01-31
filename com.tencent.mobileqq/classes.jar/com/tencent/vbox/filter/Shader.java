package com.tencent.vbox.filter;

import com.tencent.vbox.R.raw;
import com.tencent.vbox.util.FileUtils;

public class Shader
{
  public static final String aVertexShader = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  textureCoordinate = (uSTMatrix * aTextureCoord).xy;\n}";
  public static final String oesToRgba = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 textureCoordinate;\nuniform samplerExternalOES inputImageTexture;\nvoid main() {\n  gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}\n";
  public static final String yuv24ToRgba = "precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n\n const mat4 conversion = mat4(1.0, 0.0, 1.402, -0.701, 1.0, -0.344, -0.714, 0.529, 1.0, 1.772, 0.0, -0.886, 0.0, 0.0, 0.0, 0.0);\n void main()\n {\n     vec4 yuv = texture2D(inputImageTexture, textureCoordinate);\n     vec3 rgba = (yuv * conversion).xyz;\n     gl_FragColor = vec4(rgba, 1.0);\n }\n";
  public static final String yuvToRgba = FileUtils.readTextFileFromRaw(R.raw.yuv_to_rgba);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.vbox.filter.Shader
 * JD-Core Version:    0.7.0.1
 */