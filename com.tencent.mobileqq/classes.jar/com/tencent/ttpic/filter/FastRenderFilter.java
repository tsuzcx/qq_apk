package com.tencent.ttpic.filter;

import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.Mat4Param;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.Shader;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.model.RenderParam;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FastRenderFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying float stickerIndex;\n\nuniform sampler2D canvas;\nuniform sampler2D inputImageTexture0;\nuniform sampler2D inputImageTexture1;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform sampler2D inputImageTexture4;\nuniform sampler2D inputImageTexture5;\nuniform sampler2D inputImageTexture6;\nuniform sampler2D inputImageTexture7;\nuniform int blendMode;\n\nvec4 blendColor(vec4 texColor, vec4 canvasColor)\n {\n     vec3 vOne = vec3(1.0, 1.0, 1.0);\n     vec3 vZero = vec3(0.0, 0.0, 0.0);\n     //revert pre multiply\n     if(texColor.a > 0.0){\n        texColor.rgb = texColor.rgb / texColor.a;\n     }\n     vec3 resultFore = texColor.rgb;\n     if (blendMode <= 1 || blendMode > 12){ //default, since used most, put on top\n\n     } else if (blendMode == 2) {  //multiply\n         resultFore = canvasColor.rgb * texColor.rgb;\n     } else if (blendMode == 3){    //screen\n         resultFore = vOne - (vOne - canvasColor.rgb) * (vOne - texColor.rgb);\n     } else if (blendMode == 4){    //overlay\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n         if (canvasColor.r >= 0.5) {\n             resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n         }\n         if (canvasColor.g >= 0.5) {\n             resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n         }\n         if (canvasColor.b >= 0.5) {\n             resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n         }\n     } else if (blendMode == 5){    //hardlight\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n         if (texColor.r >= 0.5) {\n             resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n         }\n         if (texColor.g >= 0.5) {\n             resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n         }\n         if (texColor.b >= 0.5) {\n             resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n         }\n     } else if (blendMode == 6){    //softlight\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb + canvasColor.rgb * canvasColor.rgb * (vOne - 2.0 * texColor.rgb);\n         if (texColor.r >= 0.5) {\n             resultFore.r = 2.0 * canvasColor.r * (1.0 - texColor.r) + (2.0 * texColor.r - 1.0) * sqrt(canvasColor.r);\n         }\n         if (texColor.g >= 0.5) {\n             resultFore.g = 2.0 * canvasColor.g * (1.0 - texColor.g) + (2.0 * texColor.g - 1.0) * sqrt(canvasColor.g);\n         }\n         if (texColor.b >= 0.5) {\n             resultFore.b = 2.0 * canvasColor.b * (1.0 - texColor.b) + (2.0 * texColor.b - 1.0) * sqrt(canvasColor.b);\n         }\n     } else if (blendMode == 7){    //divide\n         resultFore = vOne;\n         if (texColor.r > 0.0) {\n             resultFore.r = canvasColor.r / texColor.r;\n         }\n         if (texColor.g > 0.0) {\n             resultFore.g = canvasColor.g / texColor.g;\n         }\n         if (texColor.b > 0.0) {\n             resultFore.b = canvasColor.b / texColor.b;\n         }\n         resultFore = min(vOne, resultFore);\n     } else if (blendMode == 8){    //add\n         resultFore = canvasColor.rgb + texColor.rgb;\n         resultFore = min(vOne, resultFore);\n     } else if (blendMode == 9){    //substract\n         resultFore = canvasColor.rgb - texColor.rgb;\n         resultFore = max(vZero, resultFore);\n     } else if (blendMode == 10){   //diff\n         resultFore = abs(canvasColor.rgb - texColor.rgb);\n     } else if (blendMode == 11){   //darken\n         resultFore = min(canvasColor.rgb, texColor.rgb);\n     } else if (blendMode == 12){   //lighten\n         resultFore = max(canvasColor.rgb, texColor.rgb);\n     }\n     //pre multiply for glBlendFunc\n     vec4 resultColor = vec4(resultFore * texColor.a, texColor.a);\n     return resultColor;\n }\n\nvoid main(void)\n{\n    vec4 canvasColor = texture2D(canvas, canvasCoordinate);\n\n    vec4 texColor = vec4(0.0, 0.0, 0.0, 0.0);\n\n    if (0.0 <= stickerIndex && stickerIndex <= 1.0 ) {\n        texColor = texture2D(inputImageTexture0, textureCoordinate);\n    } else if (1.0 <= stickerIndex && stickerIndex <= 2.0) {\n        texColor = texture2D(inputImageTexture1, textureCoordinate);\n    } else if (2.0 <= stickerIndex && stickerIndex <= 3.0) {\n        texColor = texture2D(inputImageTexture2, textureCoordinate);\n    } else if (3.0 <= stickerIndex && stickerIndex <= 4.0) {\n        texColor = texture2D(inputImageTexture3, textureCoordinate);\n    } else if (4.0 <= stickerIndex && stickerIndex <= 5.0) {\n        texColor = texture2D(inputImageTexture4, textureCoordinate);\n    } else if (5.0 <= stickerIndex && stickerIndex <= 6.0) {\n        texColor = texture2D(inputImageTexture5, textureCoordinate);\n    } else if (6.0 <= stickerIndex && stickerIndex <= 7.0) {\n        texColor = texture2D(inputImageTexture6, textureCoordinate);\n    } else {\n        texColor = texture2D(inputImageTexture7, textureCoordinate);\n    }\n    gl_FragColor = blendColor(texColor, canvasColor);\n}\n";
  private static final int MAX_DRAW_PER_RENDER = 8;
  private static final String VERTEX_SHADER = "attribute float a_stickerIndex;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nattribute vec2 texAnchor;\nattribute float texScale;\nattribute vec3 texRotate;\n\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying float stickerIndex;\n\nuniform vec2 canvasSize;\nuniform mat4 u_MVPMatrix;\nuniform int texNeedTransform;\n\nmat4 texMatTranslateBefore = mat4(1.0, 0.0, 0.0, 0.0,\n                                  0.0, 1.0, 0.0, 0.0,\n                                  0.0, 0.0, 1.0, 0.0,\n                                  0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatScale = mat4(1.0, 0.0, 0.0, 0.0,\n                        0.0, 1.0, 0.0, 0.0,\n                        0.0, 0.0, 1.0, 0.0,\n                        0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatRotate = mat4(1.0, 0.0, 0.0, 0.0,\n                         0.0, 1.0, 0.0, 0.0,\n                         0.0, 0.0, 1.0, 0.0,\n                         0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatRotateXY = mat4(1.0, 0.0, 0.0, 0.0,\n                         0.0, 1.0, 0.0, 0.0,\n                         0.0, 0.0, 1.0, 0.0,\n                         0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatTranslateAfter = mat4(1.0, 0.0, 0.0, 0.0,\n                                 0.0, 1.0, 0.0, 0.0,\n                                 0.0, 0.0, 1.0, 0.0,\n                                 0.0, 0.0, 0.0, 1.0);\n\nmat4 mat4RotationYXZ(mat4 m, float xRadians, float yRadians, float zRadians) {\n    /*\n     |  cycz + sxsysz   czsxsy - cysz   cxsy  0 |\n M = |  cxsz            cxcz           -sx    0 |\n     |  cysxsz - czsy   cyczsx + sysz   cxcy  0 |\n     |  0               0               0     1 |\n\n     where cA = cos(A), sA = sin(A) for A = x,y,z\n     */\n\n    float cx = cos(xRadians);\n    float sx = sin(xRadians);\n    float cy = cos(yRadians);\n    float sy = sin(yRadians);\n    float cz = cos(zRadians);\n    float sz = sin(zRadians);\n\n    m[0][0] = (cy * cz) + (sx * sy * sz);\n    m[0][1] = cx * sz;\n    m[0][2] = (cy * sx * sz) - (cz * sy);\n    m[0][3] = 0.0;\n\n    m[1][0] = (cz * sx * sy) - (cy * sz);\n    m[1][1] = cx * cz;\n    m[1][2] = (cy * cz * sx) + (sy * sz);\n    m[1][3] = 0.0;\n\n    m[2][0] = cx * sy;\n    m[2][1] = -sx;\n    m[2][2] = cx * cy;\n    m[2][3] = 0.0;\n\n    m[3][0] = 0.0;\n    m[3][1] = 0.0;\n    m[3][2] = 0.0;\n    m[3][3] = 1.0;\n\n    return m;\n}\n\nvoid main(){\n    vec4 framePos = position;\n    if (texNeedTransform > 0) {\n        framePos.x = framePos.x * canvasSize.x * 0.5;\n        framePos.y = framePos.y * canvasSize.y * 0.5;\n\n        texMatTranslateBefore[3][0] = -texAnchor.x;\n        texMatTranslateBefore[3][1] = -texAnchor.y;\n\n        texMatScale[0][0] = texScale;\n        texMatScale[1][1] = texScale;\n\n        texMatRotate = mat4RotationYXZ(texMatRotate, 0.0, 0.0, texRotate.z);\n        texMatRotateXY = mat4RotationYXZ(texMatRotateXY, texRotate.x, texRotate.y, 0.0);\n\n        texMatTranslateAfter[3][0] = texAnchor.x;\n        texMatTranslateAfter[3][1] = texAnchor.y;\n\n        framePos = texMatRotate * texMatScale * texMatTranslateBefore * framePos;\n\n        framePos.x = framePos.x * 2.0 / canvasSize.x;\n        framePos.y = framePos.y * 2.0 / canvasSize.y;\n\n        framePos = texMatRotateXY * framePos;\n\n        framePos.x = framePos.x * canvasSize.x * 0.5;\n        framePos.y = framePos.y * canvasSize.y * 0.5;\n\n        framePos = texMatTranslateAfter * framePos;\n\n        framePos.x = framePos.x * 2.0 / canvasSize.x;\n        framePos.y = framePos.y * 2.0 / canvasSize.y;\n\n        framePos.x = framePos.x * 1.5 ;\n        framePos.y = framePos.y * 1.5 ;\n\n        framePos = u_MVPMatrix * framePos;\n\n    }\n    gl_Position = framePos;\n    canvasCoordinate = vec2(framePos.x / framePos.w * 0.5 + 0.5, framePos.y / framePos.w * 0.5 + 0.5);\n    textureCoordinate = inputTextureCoordinate;\n    stickerIndex = a_stickerIndex;\n}\n";
  private boolean hasBlendMode = false;
  protected int height;
  private Map<String, AttributeParam> mAttrParams;
  private int mCoordNum;
  private Map<String, UniformParam> mParamList;
  protected double mScreenScale;
  private Shader shader;
  protected int width;
  
  public FastRenderFilter()
  {
    this(new Shader(BaseFilter.nativeDecrypt("attribute float a_stickerIndex;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nattribute vec2 texAnchor;\nattribute float texScale;\nattribute vec3 texRotate;\n\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying float stickerIndex;\n\nuniform vec2 canvasSize;\nuniform mat4 u_MVPMatrix;\nuniform int texNeedTransform;\n\nmat4 texMatTranslateBefore = mat4(1.0, 0.0, 0.0, 0.0,\n                                  0.0, 1.0, 0.0, 0.0,\n                                  0.0, 0.0, 1.0, 0.0,\n                                  0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatScale = mat4(1.0, 0.0, 0.0, 0.0,\n                        0.0, 1.0, 0.0, 0.0,\n                        0.0, 0.0, 1.0, 0.0,\n                        0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatRotate = mat4(1.0, 0.0, 0.0, 0.0,\n                         0.0, 1.0, 0.0, 0.0,\n                         0.0, 0.0, 1.0, 0.0,\n                         0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatRotateXY = mat4(1.0, 0.0, 0.0, 0.0,\n                         0.0, 1.0, 0.0, 0.0,\n                         0.0, 0.0, 1.0, 0.0,\n                         0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatTranslateAfter = mat4(1.0, 0.0, 0.0, 0.0,\n                                 0.0, 1.0, 0.0, 0.0,\n                                 0.0, 0.0, 1.0, 0.0,\n                                 0.0, 0.0, 0.0, 1.0);\n\nmat4 mat4RotationYXZ(mat4 m, float xRadians, float yRadians, float zRadians) {\n    /*\n     |  cycz + sxsysz   czsxsy - cysz   cxsy  0 |\n M = |  cxsz            cxcz           -sx    0 |\n     |  cysxsz - czsy   cyczsx + sysz   cxcy  0 |\n     |  0               0               0     1 |\n\n     where cA = cos(A), sA = sin(A) for A = x,y,z\n     */\n\n    float cx = cos(xRadians);\n    float sx = sin(xRadians);\n    float cy = cos(yRadians);\n    float sy = sin(yRadians);\n    float cz = cos(zRadians);\n    float sz = sin(zRadians);\n\n    m[0][0] = (cy * cz) + (sx * sy * sz);\n    m[0][1] = cx * sz;\n    m[0][2] = (cy * sx * sz) - (cz * sy);\n    m[0][3] = 0.0;\n\n    m[1][0] = (cz * sx * sy) - (cy * sz);\n    m[1][1] = cx * cz;\n    m[1][2] = (cy * cz * sx) + (sy * sz);\n    m[1][3] = 0.0;\n\n    m[2][0] = cx * sy;\n    m[2][1] = -sx;\n    m[2][2] = cx * cy;\n    m[2][3] = 0.0;\n\n    m[3][0] = 0.0;\n    m[3][1] = 0.0;\n    m[3][2] = 0.0;\n    m[3][3] = 1.0;\n\n    return m;\n}\n\nvoid main(){\n    vec4 framePos = position;\n    if (texNeedTransform > 0) {\n        framePos.x = framePos.x * canvasSize.x * 0.5;\n        framePos.y = framePos.y * canvasSize.y * 0.5;\n\n        texMatTranslateBefore[3][0] = -texAnchor.x;\n        texMatTranslateBefore[3][1] = -texAnchor.y;\n\n        texMatScale[0][0] = texScale;\n        texMatScale[1][1] = texScale;\n\n        texMatRotate = mat4RotationYXZ(texMatRotate, 0.0, 0.0, texRotate.z);\n        texMatRotateXY = mat4RotationYXZ(texMatRotateXY, texRotate.x, texRotate.y, 0.0);\n\n        texMatTranslateAfter[3][0] = texAnchor.x;\n        texMatTranslateAfter[3][1] = texAnchor.y;\n\n        framePos = texMatRotate * texMatScale * texMatTranslateBefore * framePos;\n\n        framePos.x = framePos.x * 2.0 / canvasSize.x;\n        framePos.y = framePos.y * 2.0 / canvasSize.y;\n\n        framePos = texMatRotateXY * framePos;\n\n        framePos.x = framePos.x * canvasSize.x * 0.5;\n        framePos.y = framePos.y * canvasSize.y * 0.5;\n\n        framePos = texMatTranslateAfter * framePos;\n\n        framePos.x = framePos.x * 2.0 / canvasSize.x;\n        framePos.y = framePos.y * 2.0 / canvasSize.y;\n\n        framePos.x = framePos.x * 1.5 ;\n        framePos.y = framePos.y * 1.5 ;\n\n        framePos = u_MVPMatrix * framePos;\n\n    }\n    gl_Position = framePos;\n    canvasCoordinate = vec2(framePos.x / framePos.w * 0.5 + 0.5, framePos.y / framePos.w * 0.5 + 0.5);\n    textureCoordinate = inputTextureCoordinate;\n    stickerIndex = a_stickerIndex;\n}\n"), BaseFilter.nativeDecrypt("precision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying float stickerIndex;\n\nuniform sampler2D canvas;\nuniform sampler2D inputImageTexture0;\nuniform sampler2D inputImageTexture1;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform sampler2D inputImageTexture4;\nuniform sampler2D inputImageTexture5;\nuniform sampler2D inputImageTexture6;\nuniform sampler2D inputImageTexture7;\nuniform int blendMode;\n\nvec4 blendColor(vec4 texColor, vec4 canvasColor)\n {\n     vec3 vOne = vec3(1.0, 1.0, 1.0);\n     vec3 vZero = vec3(0.0, 0.0, 0.0);\n     //revert pre multiply\n     if(texColor.a > 0.0){\n        texColor.rgb = texColor.rgb / texColor.a;\n     }\n     vec3 resultFore = texColor.rgb;\n     if (blendMode <= 1 || blendMode > 12){ //default, since used most, put on top\n\n     } else if (blendMode == 2) {  //multiply\n         resultFore = canvasColor.rgb * texColor.rgb;\n     } else if (blendMode == 3){    //screen\n         resultFore = vOne - (vOne - canvasColor.rgb) * (vOne - texColor.rgb);\n     } else if (blendMode == 4){    //overlay\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n         if (canvasColor.r >= 0.5) {\n             resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n         }\n         if (canvasColor.g >= 0.5) {\n             resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n         }\n         if (canvasColor.b >= 0.5) {\n             resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n         }\n     } else if (blendMode == 5){    //hardlight\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n         if (texColor.r >= 0.5) {\n             resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n         }\n         if (texColor.g >= 0.5) {\n             resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n         }\n         if (texColor.b >= 0.5) {\n             resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n         }\n     } else if (blendMode == 6){    //softlight\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb + canvasColor.rgb * canvasColor.rgb * (vOne - 2.0 * texColor.rgb);\n         if (texColor.r >= 0.5) {\n             resultFore.r = 2.0 * canvasColor.r * (1.0 - texColor.r) + (2.0 * texColor.r - 1.0) * sqrt(canvasColor.r);\n         }\n         if (texColor.g >= 0.5) {\n             resultFore.g = 2.0 * canvasColor.g * (1.0 - texColor.g) + (2.0 * texColor.g - 1.0) * sqrt(canvasColor.g);\n         }\n         if (texColor.b >= 0.5) {\n             resultFore.b = 2.0 * canvasColor.b * (1.0 - texColor.b) + (2.0 * texColor.b - 1.0) * sqrt(canvasColor.b);\n         }\n     } else if (blendMode == 7){    //divide\n         resultFore = vOne;\n         if (texColor.r > 0.0) {\n             resultFore.r = canvasColor.r / texColor.r;\n         }\n         if (texColor.g > 0.0) {\n             resultFore.g = canvasColor.g / texColor.g;\n         }\n         if (texColor.b > 0.0) {\n             resultFore.b = canvasColor.b / texColor.b;\n         }\n         resultFore = min(vOne, resultFore);\n     } else if (blendMode == 8){    //add\n         resultFore = canvasColor.rgb + texColor.rgb;\n         resultFore = min(vOne, resultFore);\n     } else if (blendMode == 9){    //substract\n         resultFore = canvasColor.rgb - texColor.rgb;\n         resultFore = max(vZero, resultFore);\n     } else if (blendMode == 10){   //diff\n         resultFore = abs(canvasColor.rgb - texColor.rgb);\n     } else if (blendMode == 11){   //darken\n         resultFore = min(canvasColor.rgb, texColor.rgb);\n     } else if (blendMode == 12){   //lighten\n         resultFore = max(canvasColor.rgb, texColor.rgb);\n     }\n     //pre multiply for glBlendFunc\n     vec4 resultColor = vec4(resultFore * texColor.a, texColor.a);\n     return resultColor;\n }\n\nvoid main(void)\n{\n    vec4 canvasColor = texture2D(canvas, canvasCoordinate);\n\n    vec4 texColor = vec4(0.0, 0.0, 0.0, 0.0);\n\n    if (0.0 <= stickerIndex && stickerIndex <= 1.0 ) {\n        texColor = texture2D(inputImageTexture0, textureCoordinate);\n    } else if (1.0 <= stickerIndex && stickerIndex <= 2.0) {\n        texColor = texture2D(inputImageTexture1, textureCoordinate);\n    } else if (2.0 <= stickerIndex && stickerIndex <= 3.0) {\n        texColor = texture2D(inputImageTexture2, textureCoordinate);\n    } else if (3.0 <= stickerIndex && stickerIndex <= 4.0) {\n        texColor = texture2D(inputImageTexture3, textureCoordinate);\n    } else if (4.0 <= stickerIndex && stickerIndex <= 5.0) {\n        texColor = texture2D(inputImageTexture4, textureCoordinate);\n    } else if (5.0 <= stickerIndex && stickerIndex <= 6.0) {\n        texColor = texture2D(inputImageTexture5, textureCoordinate);\n    } else if (6.0 <= stickerIndex && stickerIndex <= 7.0) {\n        texColor = texture2D(inputImageTexture6, textureCoordinate);\n    } else {\n        texColor = texture2D(inputImageTexture7, textureCoordinate);\n    }\n    gl_FragColor = blendColor(texColor, canvasColor);\n}\n")));
  }
  
  private FastRenderFilter(Shader paramShader)
  {
    this.shader = paramShader;
    this.mAttrParams = new HashMap();
    this.mParamList = new HashMap();
  }
  
  private boolean mergeRenderParams(List<RenderParam> paramList)
  {
    return mergeRenderParams(paramList, false);
  }
  
  private boolean mergeRenderParams(List<RenderParam> paramList, boolean paramBoolean)
  {
    int i;
    Object localObject;
    int j;
    int k;
    int m;
    if (!paramList.isEmpty())
    {
      i = paramList.size();
      localObject = new float[((RenderParam)paramList.get(0)).position.length * i];
      i = 0;
      while (i < paramList.size())
      {
        j = 0;
        while (j < ((RenderParam)paramList.get(i)).position.length)
        {
          localObject[(((RenderParam)paramList.get(i)).position.length * i + j)] = ((RenderParam)paramList.get(i)).position[j];
          j += 1;
        }
        i += 1;
      }
      setPositions((float[])localObject);
      localObject = new float[paramList.size() * GlUtil.ORIGIN_TEX_COORDS_TRIANGLES.length];
      i = 0;
      while (i < paramList.size())
      {
        j = 0;
        while (j < ((RenderParam)paramList.get(i)).texCords.length)
        {
          localObject[(((RenderParam)paramList.get(i)).texCords.length * i + j)] = ((RenderParam)paramList.get(i)).texCords[j];
          j += 1;
        }
        i += 1;
      }
      setTexCords((float[])localObject);
      localObject = new float[paramList.size() * 6];
      if (paramBoolean)
      {
        k = ((RenderParam)paramList.get(0)).texture;
        i = 0;
        j = 0;
        if (j >= localObject.length) {
          break label379;
        }
        m = j / 6;
        if (((RenderParam)paramList.get(m)).texture == k) {
          break label968;
        }
        k = ((RenderParam)paramList.get(m)).texture;
        i += 1;
      }
    }
    label968:
    for (;;)
    {
      localObject[j] = (i + 0.5F);
      j += 1;
      break;
      i = 0;
      while (i < localObject.length)
      {
        localObject[i] = (i / 6 + 0.5F);
        i += 1;
      }
      label379:
      addAttribParam(new AttributeParam("a_stickerIndex", (float[])localObject, 1));
      localObject = new float[paramList.size() * 6 * 2];
      i = 0;
      while (i < paramList.size())
      {
        j = 0;
        while (j < 12)
        {
          localObject[(i * 6 * 2 + j)] = ((RenderParam)paramList.get(i)).texAnchor[(j % 2)];
          j += 1;
        }
        i += 1;
      }
      addAttribParam(new AttributeParam("texAnchor", (float[])localObject, 2));
      localObject = new float[paramList.size() * 6 * 1];
      i = 0;
      while (i < paramList.size())
      {
        j = 0;
        while (j < 6)
        {
          localObject[(i * 6 + j)] = ((RenderParam)paramList.get(i)).texScale;
          j += 1;
        }
        i += 1;
      }
      addAttribParam(new AttributeParam("texScale", (float[])localObject, 1));
      localObject = new float[paramList.size() * 6 * 3];
      i = 0;
      while (i < paramList.size())
      {
        j = 0;
        while (j < 18)
        {
          localObject[(i * 6 * 3 + j)] = ((RenderParam)paramList.get(i)).texRotate[(j % 3)];
          j += 1;
        }
        i += 1;
      }
      addAttribParam(new AttributeParam("texRotate", (float[])localObject, 3));
      if (paramBoolean)
      {
        m = ((RenderParam)paramList.get(0)).texture;
        int n = 0;
        i = 0;
        if (i < paramList.size())
        {
          k = n;
          j = m;
          if (((RenderParam)paramList.get(i)).texture != m)
          {
            k = n + 1;
            j = ((RenderParam)paramList.get(i)).texture;
          }
          localObject = "inputImageTexture" + k;
          n = ((RenderParam)paramList.get(i)).texture;
          if (this.hasBlendMode) {}
          for (m = 1;; m = 0)
          {
            addParam(new UniformParam.TextureParam((String)localObject, n, m + (33984 + k)));
            i += 1;
            n = k;
            m = j;
            break;
          }
        }
      }
      else
      {
        i = 0;
        if (i < paramList.size())
        {
          localObject = "inputImageTexture" + i;
          k = ((RenderParam)paramList.get(i)).texture;
          if (this.hasBlendMode) {}
          for (j = 1;; j = 0)
          {
            addParam(new UniformParam.TextureParam((String)localObject, k, j + (33984 + i)));
            i += 1;
            break;
          }
        }
      }
      setCoordNum(paramList.size() * 6);
      return true;
      return false;
    }
  }
  
  private List<List<RenderParam>> splitRenderParams(List<RenderParam> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size() / 8 + 1)
    {
      int m = i * 8;
      int k = m + 8;
      int j = k;
      if (k > paramList.size()) {
        j = paramList.size();
      }
      localArrayList.add(paramList.subList(m, j));
      i += 1;
    }
    return localArrayList;
  }
  
  private List<List<RenderParam>> splitRenderParams(List<RenderParam> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    int k;
    if (paramBoolean)
    {
      ArrayList localArrayList = new ArrayList();
      k = ((RenderParam)paramList.get(0)).texture;
      localObject1 = new ArrayList();
      i = 1;
      if (j < paramList.size())
      {
        RenderParam localRenderParam = (RenderParam)paramList.get(j);
        if (localRenderParam.texture == k) {
          ((List)localObject1).add(localRenderParam);
        }
        for (;;)
        {
          j += 1;
          break;
          k = i + 1;
          i = k;
          Object localObject2 = localObject1;
          if (k > 8)
          {
            localArrayList.add(localObject1);
            localObject2 = new ArrayList();
            i = 1;
          }
          ((List)localObject2).add(localRenderParam);
          k = localRenderParam.texture;
          localObject1 = localObject2;
        }
      }
      localArrayList.add(localObject1);
      return localArrayList;
    }
    Object localObject1 = new ArrayList();
    while (i < paramList.size() / 8 + 1)
    {
      int m = i * 8;
      k = m + 8;
      j = k;
      if (k > paramList.size()) {
        j = paramList.size();
      }
      ((List)localObject1).add(paramList.subList(m, j));
      i += 1;
    }
    return localObject1;
  }
  
  public void OnDrawFrameGLSL()
  {
    this.shader.bind();
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((UniformParam)localIterator.next()).setParams(this.shader.getShaderProgram());
    }
    localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext())
    {
      AttributeParam localAttributeParam = (AttributeParam)localIterator.next();
      if (localAttributeParam.handle >= 0) {
        localAttributeParam.setParams(this.shader.getShaderProgram());
      }
    }
  }
  
  public void addAttribParam(AttributeParam paramAttributeParam)
  {
    if (paramAttributeParam == null) {
      return;
    }
    AttributeParam localAttributeParam2 = (AttributeParam)this.mAttrParams.get(paramAttributeParam.name);
    AttributeParam localAttributeParam1 = localAttributeParam2;
    if (localAttributeParam2 == null)
    {
      localAttributeParam1 = new AttributeParam(paramAttributeParam.name, paramAttributeParam.vertices, paramAttributeParam.perVertexFloat, false);
      this.mAttrParams.put(paramAttributeParam.name, localAttributeParam1);
    }
    localAttributeParam1.setVertices(paramAttributeParam.vertices);
    localAttributeParam1.perVertexFloat = paramAttributeParam.perVertexFloat;
  }
  
  public void addAttribParam(String paramString, float[] paramArrayOfFloat)
  {
    addAttribParam(paramString, paramArrayOfFloat, false);
  }
  
  public void addAttribParam(String paramString, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    AttributeParam localAttributeParam2 = (AttributeParam)this.mAttrParams.get(paramString);
    AttributeParam localAttributeParam1 = localAttributeParam2;
    if (localAttributeParam2 == null)
    {
      localAttributeParam1 = new AttributeParam(paramString, paramArrayOfFloat, paramBoolean);
      this.mAttrParams.put(paramString, localAttributeParam1);
    }
    localAttributeParam1.setVertices(paramArrayOfFloat);
  }
  
  public void addParam(UniformParam paramUniformParam)
  {
    if (paramUniformParam == null) {
      return;
    }
    UniformParam localUniformParam = (UniformParam)this.mParamList.get(paramUniformParam.name);
    if (localUniformParam == null)
    {
      this.mParamList.put(paramUniformParam.name, paramUniformParam);
      return;
    }
    paramUniformParam.handle = localUniformParam.handle;
    this.mParamList.put(paramUniformParam.name, paramUniformParam);
  }
  
  public void applyGLSLFilter()
  {
    initAttribParams();
    this.shader.compile();
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((UniformParam)localIterator.next()).initialParams(this.shader.getShaderProgram());
    }
    localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext()) {
      ((AttributeParam)localIterator.next()).initialParams(this.shader.getShaderProgram());
    }
  }
  
  public void clearGLSLSelf()
  {
    this.shader.clear();
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((UniformParam)localIterator.next()).clear();
    }
    localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext()) {
      ((AttributeParam)localIterator.next()).clear();
    }
  }
  
  public AttributeParam getAttribParam(String paramString)
  {
    return (AttributeParam)this.mAttrParams.get(paramString);
  }
  
  public void initAttribParams()
  {
    setPositions(GlUtil.ORIGIN_TEX_COORDS_TRIANGLES);
    setTexCords(new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F });
    setCoordNum(4);
    addAttribParam(new AttributeParam("a_stickerIndex", new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 1));
    addAttribParam(new AttributeParam("texAnchor", new float[] { 0.0F, 0.0F }, 2));
    addAttribParam(new AttributeParam("texScale", new float[] { 0.0F }, 1));
    addAttribParam(new AttributeParam("texRotate", new float[] { 0.0F, 0.0F, 0.0F }, 3));
    initParams();
  }
  
  public void initParams()
  {
    addParam(new UniformParam.IntParam("texNeedTransform", 1));
    addParam(new UniformParam.IntParam("blendMode", 0));
    addParam(new UniformParam.Float2fParam("canvasSize", 0.0F, 0.0F));
    addParam(new UniformParam.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
    addParam(new UniformParam.TextureParam("canvas", 0, 33986));
    int i = 0;
    while (i <= 7)
    {
      addParam(new UniformParam.TextureParam("inputImageTexture" + i, 0, 33986));
      i += 1;
    }
  }
  
  public void render(int paramInt, List<RenderParam> paramList, Frame paramFrame, boolean paramBoolean)
  {
    if (paramInt > 0) {
      addParam(new UniformParam.TextureParam("canvas", paramInt, 33984));
    }
    render(paramList, paramFrame, paramBoolean);
  }
  
  public void render(List<RenderParam> paramList, Frame paramFrame)
  {
    render(paramList, paramFrame, false);
  }
  
  public void render(List<RenderParam> paramList, Frame paramFrame, boolean paramBoolean)
  {
    if (paramList.size() > 0)
    {
      if (paramFrame != null)
      {
        addParam(new UniformParam.Float2fParam("canvasSize", paramFrame.width, paramFrame.height));
        paramFrame.bindFrame(-1, paramFrame.width, paramFrame.height, 0.0D);
      }
      while (paramBoolean)
      {
        Collections.sort(paramList, new FastRenderFilter.1(this));
        paramList = splitRenderParams(paramList, true).iterator();
        while (paramList.hasNext()) {
          if (mergeRenderParams((List)paramList.next(), true))
          {
            OnDrawFrameGLSL();
            renderTexture();
          }
        }
        addParam(new UniformParam.Float2fParam("canvasSize", this.width, this.height));
      }
      paramList = splitRenderParams(paramList).iterator();
      while (paramList.hasNext()) {
        if (mergeRenderParams((List)paramList.next()))
        {
          OnDrawFrameGLSL();
          renderTexture();
        }
      }
    }
  }
  
  public void renderTexture()
  {
    GLES20.glDrawArrays(4, 0, this.mCoordNum);
    GLES20.glFlush();
  }
  
  public void setBlendMode(int paramInt)
  {
    addParam(new UniformParam.IntParam("blendMode", paramInt));
    this.hasBlendMode = true;
  }
  
  public boolean setCoordNum(int paramInt)
  {
    this.mCoordNum = paramInt;
    return true;
  }
  
  public boolean setPositions(float[] paramArrayOfFloat)
  {
    addAttribParam("position", paramArrayOfFloat);
    return true;
  }
  
  public boolean setPositions(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    addAttribParam("position", paramArrayOfFloat, paramBoolean);
    return true;
  }
  
  public boolean setTexCords(float[] paramArrayOfFloat)
  {
    addAttribParam("inputTextureCoordinate", paramArrayOfFloat);
    return true;
  }
  
  public boolean setTexCords(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    addAttribParam("inputTextureCoordinate", paramArrayOfFloat, paramBoolean);
    return true;
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.FastRenderFilter
 * JD-Core Version:    0.7.0.1
 */