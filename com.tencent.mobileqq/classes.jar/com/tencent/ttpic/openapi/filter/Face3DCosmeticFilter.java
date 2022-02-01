package com.tencent.ttpic.openapi.filter;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.Mat4Param;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.initializer.Face3DLibInitializer;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.util.AlgoUtils;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class Face3DCosmeticFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision highp float;\n varying vec3 v_normalVector;\n varying vec2 v_uvTexCoords;\n uniform sampler2D inputImageTexture;\n uniform float ambientStrength;\n uniform float diffuseStrength;\n  \n  const vec3 u_directionalLightColor = vec3(1.0);\n  const vec3 u_directionalLightDirection = vec3(0.0, 0.0, -1.0);\n  \n  vec3 computeLighting(vec3 normalVector, vec3 lightDirection, vec3 lightColor, float attenuation)\n  {\n     float diffuse = max(dot(normalVector, lightDirection), 0.0);\n //    diffuse = max((diffuse - 0.65) / 0.35, 0.0);\n     vec3 diffuseColor = lightColor * diffuse * attenuation;\n     return diffuseColor;\n  }\n  \n  vec3 getLitPixel()\n  {\n     vec3 normalVector = normalize(v_normalVector);\n     vec3 lightDirection = normalize(u_directionalLightDirection);\n     vec3 lightColor = computeLighting(normalVector, -lightDirection, u_directionalLightColor, 1.0);\n     vec3 combinedColor = vec3(0.3) + lightColor * 0.7;\n //    float gray = dot(combinedColor, vec3(0.299, 0.587, 0.114));\n //    combinedColor = vec3(1.0) - (vec3(1.0) - combinedColor) * (vec3(1.0) - lightColor * gray);\n     return combinedColor;\n  }\n \n void main() {\n     vec4 srcColor = texture2D(inputImageTexture, v_uvTexCoords);\n     vec3 light_color = getLitPixel();\n     float alpha_scale = ambientStrength + (1.0 - ambientStrength) * min(1.0, light_color.r * diffuseStrength);\n     srcColor = vec4(srcColor.rgb * alpha_scale, srcColor.a * alpha_scale);\n     gl_FragColor = srcColor;\n }";
  private static final int PER_FLOAT_BYTE = 4;
  private static final int PER_INT_BYTE = 4;
  private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 normal;\nattribute vec2 uvTexCoords;\n\nvarying vec2 v_uvTexCoords;\nvarying vec3 v_normalVector;\n\nuniform vec2 faceDetSize; \nuniform mat4 matrix; \nuniform mat4 rotateMatrix; \nuniform float phoneRotation;\n\nvec4 RevertPhoneRotation(vec4 pos) {\n  vec4 res_pos = pos;\n  if (phoneRotation > 269.0) {\n    res_pos.x = faceDetSize.x - pos.y;\n    res_pos.y = pos.x;\n  } else if (phoneRotation > 179.0) {\n    res_pos.x = faceDetSize.x - pos.x;\n    res_pos.y = faceDetSize.y - pos.y;\n  } else if (phoneRotation > 89.0) {\n    res_pos.x = pos.y;\n    res_pos.y = faceDetSize.y - pos.x;\n  }\n  \n  return res_pos;\n}\n\nvoid main()\n{\n  vec4 pos = matrix * position; \n  vec4 pointNormal = rotateMatrix * normal;\n  v_normalVector = pointNormal.xyz / pointNormal.w;\n  \n  vec4 correct_pos = RevertPhoneRotation(pos);\n  gl_Position = vec4(correct_pos.x / faceDetSize.x * 2.0 - 1.0, (1.0 - correct_pos.y / faceDetSize.y) * 2.0 - 1.0, -correct_pos.z / 2.0 / max(faceDetSize.x, faceDetSize.y), 1.0);\n  v_uvTexCoords = vec2(uvTexCoords.x, 1.0 - uvTexCoords.y);\n\n}\n";
  private int cos3Dtype;
  private int[] mBuffer = new int[2];
  private BaseFilter mCopyFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
  private int[] mDepthBuffer = new int[1];
  private int[] mFrameBuffer = new int[1];
  private int[] mTexture = new int[1];
  private FloatBuffer mVertexBuffer;
  private int updateVideoHeight;
  private int updateVideoWidth;
  
  public Face3DCosmeticFilter()
  {
    super("attribute vec4 position;\nattribute vec4 normal;\nattribute vec2 uvTexCoords;\n\nvarying vec2 v_uvTexCoords;\nvarying vec3 v_normalVector;\n\nuniform vec2 faceDetSize; \nuniform mat4 matrix; \nuniform mat4 rotateMatrix; \nuniform float phoneRotation;\n\nvec4 RevertPhoneRotation(vec4 pos) {\n  vec4 res_pos = pos;\n  if (phoneRotation > 269.0) {\n    res_pos.x = faceDetSize.x - pos.y;\n    res_pos.y = pos.x;\n  } else if (phoneRotation > 179.0) {\n    res_pos.x = faceDetSize.x - pos.x;\n    res_pos.y = faceDetSize.y - pos.y;\n  } else if (phoneRotation > 89.0) {\n    res_pos.x = pos.y;\n    res_pos.y = faceDetSize.y - pos.x;\n  }\n  \n  return res_pos;\n}\n\nvoid main()\n{\n  vec4 pos = matrix * position; \n  vec4 pointNormal = rotateMatrix * normal;\n  v_normalVector = pointNormal.xyz / pointNormal.w;\n  \n  vec4 correct_pos = RevertPhoneRotation(pos);\n  gl_Position = vec4(correct_pos.x / faceDetSize.x * 2.0 - 1.0, (1.0 - correct_pos.y / faceDetSize.y) * 2.0 - 1.0, -correct_pos.z / 2.0 / max(faceDetSize.x, faceDetSize.y), 1.0);\n  v_uvTexCoords = vec2(uvTexCoords.x, 1.0 - uvTexCoords.y);\n\n}\n", "precision highp float;\n varying vec3 v_normalVector;\n varying vec2 v_uvTexCoords;\n uniform sampler2D inputImageTexture;\n uniform float ambientStrength;\n uniform float diffuseStrength;\n  \n  const vec3 u_directionalLightColor = vec3(1.0);\n  const vec3 u_directionalLightDirection = vec3(0.0, 0.0, -1.0);\n  \n  vec3 computeLighting(vec3 normalVector, vec3 lightDirection, vec3 lightColor, float attenuation)\n  {\n     float diffuse = max(dot(normalVector, lightDirection), 0.0);\n //    diffuse = max((diffuse - 0.65) / 0.35, 0.0);\n     vec3 diffuseColor = lightColor * diffuse * attenuation;\n     return diffuseColor;\n  }\n  \n  vec3 getLitPixel()\n  {\n     vec3 normalVector = normalize(v_normalVector);\n     vec3 lightDirection = normalize(u_directionalLightDirection);\n     vec3 lightColor = computeLighting(normalVector, -lightDirection, u_directionalLightColor, 1.0);\n     vec3 combinedColor = vec3(0.3) + lightColor * 0.7;\n //    float gray = dot(combinedColor, vec3(0.299, 0.587, 0.114));\n //    combinedColor = vec3(1.0) - (vec3(1.0) - combinedColor) * (vec3(1.0) - lightColor * gray);\n     return combinedColor;\n  }\n \n void main() {\n     vec4 srcColor = texture2D(inputImageTexture, v_uvTexCoords);\n     vec3 light_color = getLitPixel();\n     float alpha_scale = ambientStrength + (1.0 - ambientStrength) * min(1.0, light_color.r * diffuseStrength);\n     srcColor = vec4(srcColor.rgb * alpha_scale, srcColor.a * alpha_scale);\n     gl_FragColor = srcColor;\n }");
    initParams();
  }
  
  private void clearGLResources()
  {
    int[] arrayOfInt = this.mTexture;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    arrayOfInt = this.mFrameBuffer;
    GLES20.glDeleteFramebuffers(arrayOfInt.length, arrayOfInt, 0);
    arrayOfInt = this.mDepthBuffer;
    GLES20.glDeleteRenderbuffers(arrayOfInt.length, arrayOfInt, 0);
    arrayOfInt = this.mBuffer;
    GLES20.glDeleteBuffers(arrayOfInt.length, arrayOfInt, 0);
    this.mCopyFilter.clearGLSL();
  }
  
  private void initGLResources()
  {
    int[] arrayOfInt = this.mTexture;
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    arrayOfInt = this.mFrameBuffer;
    GLES20.glGenFramebuffers(arrayOfInt.length, arrayOfInt, 0);
    arrayOfInt = this.mDepthBuffer;
    GLES20.glGenRenderbuffers(arrayOfInt.length, arrayOfInt, 0);
    arrayOfInt = this.mBuffer;
    GLES20.glGenBuffers(arrayOfInt.length, arrayOfInt, 0);
    this.mCopyFilter.apply();
  }
  
  private void updateGLResources()
  {
    if ((this.width != 0) && (this.height != 0) && (this.mTexture[0] > 0))
    {
      if (!isValid()) {
        return;
      }
      if ((this.updateVideoWidth == this.width) && (this.updateVideoHeight == this.height)) {
        return;
      }
      this.updateVideoWidth = this.width;
      this.updateVideoHeight = this.height;
      GLES20.glActiveTexture(33989);
      GLES20.glBindTexture(3553, this.mTexture[0]);
      GLES20.glTexImage2D(3553, 0, 6408, this.width, this.height, 0, 6408, 5121, null);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glBindFramebuffer(36160, this.mFrameBuffer[0]);
      GLES20.glBindRenderbuffer(36161, this.mDepthBuffer[0]);
      GLES20.glRenderbufferStorage(36161, 33189, this.width, this.height);
      GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.mDepthBuffer[0]);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mTexture[0], 0);
      GLES20.glCheckFramebufferStatus(36160);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glBindTexture(3553, 0);
    }
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    initGLResources();
    updateVideoSize(this.width, this.height, this.mFaceDetScale);
    this.mVertexBuffer = FloatBuffer.wrap(Face3DLibInitializer.face3DUV);
    GLES20.glBindBuffer(34962, this.mBuffer[0]);
    GLES20.glBufferData(34962, this.mVertexBuffer.capacity() * 4, this.mVertexBuffer, 35048);
    GLES20.glBindBuffer(34962, 0);
    IntBuffer localIntBuffer = IntBuffer.wrap(Face3DLibInitializer.face3DIndices);
    GLES20.glBindBuffer(34963, this.mBuffer[1]);
    GLES20.glBufferData(34963, localIntBuffer.capacity() * 4, localIntBuffer, 35044);
    GLES20.glBindBuffer(34963, 0);
  }
  
  public void OnDrawFrameGLSL()
  {
    OnDrawFrameGLSLSuper();
    GLES20.glBindBuffer(34962, this.mBuffer[0]);
    GLES20.glBufferSubData(34962, 0, 41376, this.mVertexBuffer);
    if (getAttribParam("position").handle != -1)
    {
      GLES20.glEnableVertexAttribArray(getAttribParam("position").handle);
      GLES20.glVertexAttribPointer(getAttribParam("position").handle, 3, 5126, false, 12, 0);
    }
    if (getAttribParam("uvTexCoords").handle != -1)
    {
      GLES20.glEnableVertexAttribArray(getAttribParam("uvTexCoords").handle);
      GLES20.glVertexAttribPointer(getAttribParam("uvTexCoords").handle, 2, 5126, false, 8, (this.cos3Dtype * 2 + 1) * 3448 * 4);
    }
    if (getAttribParam("normal").handle != -1)
    {
      GLES20.glEnableVertexAttribArray(getAttribParam("normal").handle);
      GLES20.glVertexAttribPointer(getAttribParam("normal").handle, 3, 5126, false, 12, 96544);
    }
    GLES20.glBindBuffer(34963, this.mBuffer[1]);
  }
  
  public Frame RenderProcess(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glBindFramebuffer(36160, this.mFrameBuffer[0]);
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    OnDrawFrameGLSL();
    renderTexture(paramInt1, paramInt2, paramInt3);
    return this.mCopyFilter.RenderProcess(this.mTexture[0], paramInt2, paramInt3);
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, Frame paramFrame)
  {
    GLES20.glBindFramebuffer(36160, this.mFrameBuffer[0]);
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    OnDrawFrameGLSL();
    renderTexture(paramInt1, paramInt2, paramInt3);
    this.mCopyFilter.RenderProcess(this.mTexture[0], paramInt2, paramInt3, paramInt4, paramDouble, paramFrame);
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    clearGLResources();
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    addAttribParam(new AttributeParam("uvTexCoords", GlUtil.EMPTY_POSITIONS));
    addAttribParam(new AttributeParam("normal", GlUtil.EMPTY_POSITIONS, 4));
  }
  
  public void initParams()
  {
    addParam(new UniformParam.Float2fParam("faceDetSize", 180.0F, 240.0F));
    addParam(new UniformParam.Mat4Param("matrix", new float[16]));
    addParam(new UniformParam.Mat4Param("rotateMatrix", new float[16]));
    addParam(new UniformParam.FloatParam("ambientStrength", 1.0F));
    addParam(new UniformParam.FloatParam("diffuseStrength", 1.0F));
    addParam(new UniformParam.FloatParam("phoneRotation", 0.0F));
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16384);
    GLES20.glEnable(2884);
    GLES20.glFrontFace(2305);
    GLES20.glCullFace(1028);
    GLES20.glEnable(2929);
    GLES20.glDepthFunc(513);
    GLES20.glDepthMask(true);
    GLES20.glClear(256);
    GLES20.glDisable(3042);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.mSTextureHandle, 0);
    GLES20.glDrawElements(4, 20208, 5125, 0);
    GLES20.glBindBuffer(34962, 0);
    GLES20.glBindBuffer(34963, 0);
    GLES20.glDisable(2929);
    GLES20.glDisable(2884);
    return true;
  }
  
  public void setCosParam(FaceItem paramFaceItem)
  {
    this.cos3Dtype = paramFaceItem.is3DCos;
    addParam(new UniformParam.FloatParam("ambientStrength", paramFaceItem.cos3DAmbientStrength));
    addParam(new UniformParam.FloatParam("diffuseStrength", paramFaceItem.cos3DDiffuseStrength));
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      super.updatePreview(paramObject);
      float[] arrayOfFloat = paramObject.face3DVerticesArray;
      if (arrayOfFloat != null)
      {
        if (arrayOfFloat.length < 10344) {
          return;
        }
        if (!AlgoUtils.isFace3DPointsValid(arrayOfFloat)) {
          return;
        }
        if ((this.width != 0) && (this.height != 0) && (this.mTexture[0] > 0))
        {
          if (!isValid()) {
            return;
          }
          this.mVertexBuffer.put(paramObject.face3DVerticesArray, 0, paramObject.face3DVerticesArray.length).position(0);
          addParam(new UniformParam.Mat4Param("matrix", paramObject.face3DRotationArray));
          addParam(new UniformParam.Mat4Param("rotateMatrix", paramObject.face3DNormalRotationArray));
          addParam(new UniformParam.FloatParam("phoneRotation", (paramObject.phoneAngle + 360.0F) % 360.0F));
        }
      }
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    double d = paramInt1;
    Double.isNaN(d);
    float f = (int)(d * paramDouble);
    d = paramInt2;
    Double.isNaN(d);
    addParam(new UniformParam.Float2fParam("faceDetSize", f, (int)(d * paramDouble)));
    updateGLResources();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.Face3DCosmeticFilter
 * JD-Core Version:    0.7.0.1
 */