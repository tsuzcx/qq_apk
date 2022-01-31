package com.tencent.mobileqq.richmedia.mediacodec.computeShader;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLES31;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;

@SuppressLint({"NewApi"})
public class GPUImgFilterRecoverFilter
  extends GPUComputeShaderFilter
{
  private final int[] a = new int[1];
  
  public GPUImgFilterRecoverFilter()
  {
    super("    #version 310 es                                                                             \n                                                                                                \n    layout (local_size_x = 8, local_size_y = 8, local_size_z = 1) in;                           \n    layout (rgba8, binding = 0) readonly  uniform  highp image2D inputImage;                    \n    layout (rgba8, binding = 1) writeonly uniform  highp image2D outputImage;                   \n    layout (rgba8, binding = 2) readonly  uniform  highp image2D TImage;                        \n    layout (std430,binding = 3) buffer Avalue{                                                  \n        float aValueData[3];                                                                    \n    };                                                                                          \n    uniform int imageHeight;                                                                    \n    uniform int imageWidth;                                                                     \n                                                                                                \n    void main(){                                                                                \n        int outputRowIndex = int(gl_GlobalInvocationID.y);                                      \n        int outputColumnIndex = int(gl_GlobalInvocationID.x);                                   \n        if(outputRowIndex >= imageHeight || outputColumnIndex >= imageWidth){                   \n            return;                                                                             \n        }                                                                                       \n        vec4 inputValue = imageLoad(inputImage, ivec2(gl_GlobalInvocationID.xy));               \n        vec4 TValue = imageLoad(TImage, ivec2(gl_GlobalInvocationID.xy));                       \n        barrier();                                                                              \n        int index = (imageHeight - 1 - outputRowIndex) * imageWidth + outputColumnIndex;        \n        float Tx = TValue.r;                                         \n        Tx = TValue.r >= 1.0 ? 1.0 :  TValue.r;                                   \n        Tx = Tx >= 0.1 ? Tx :  0.1;                                   \n        float outputR = (inputValue.r - aValueData[0])/Tx +  aValueData[0];              \n        float outputG = (inputValue.g - aValueData[1])/Tx +  aValueData[1];              \n        float outputB = (inputValue.b - aValueData[2])/Tx +  aValueData[2];              \n        outputR = outputR < 0.0 ? 0.0 : outputR;              \n        outputR = outputR > 1.0 ? 1.0 : outputR;              \n        outputG = outputG < 0.0 ? 0.0 : outputG;              \n        outputG = outputG > 1.0 ? 1.0 : outputG;              \n        outputB = outputB < 0.0 ? 0.0 : outputB;              \n        outputB = outputB > 1.0 ? 1.0 : outputB;              \n        vec4 ouputRGBA = vec4(outputR,outputG,outputB,inputValue.a);                            \n        imageStore(outputImage,ivec2(gl_GlobalInvocationID.xy),ouputRGBA);                      \n    }                                                                                     ", 3553);
    a();
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt, int paramInt4, int paramInt5, float[] paramArrayOfFloat)
  {
    int i = a();
    GLES20.glGenBuffers(1, this.a, 0);
    a("glGenBuffers");
    GLES31.glBindImageTexture(0, paramInt1, 0, true, 0, 35000, 32856);
    a("fill inputImage texture");
    GLES31.glBindImageTexture(1, paramInt2, 0, true, 0, 35001, 32856);
    a("fill outputImage texture");
    GLES31.glBindImageTexture(2, paramInt3, 0, true, 0, 35000, 32856);
    a("fill tImage texture");
    paramArrayOfFloat = new float[3];
    paramInt1 = 0;
    while (paramInt1 < paramArrayOfInt.length)
    {
      paramArrayOfFloat[paramInt1] = (paramArrayOfInt[paramInt1] / 255.0F);
      paramInt1 += 1;
    }
    paramArrayOfFloat = GlUtil.a(paramArrayOfFloat);
    GLES20.glBindBuffer(37074, this.a[0]);
    GLES20.glBufferData(37074, paramArrayOfInt.length * 4, paramArrayOfFloat, 35049);
    GLES30.glBindBufferBase(37074, 3, this.a[0]);
    GLES20.glBindBuffer(37074, 0);
    a("fill aValueData buffer");
    paramInt1 = GLES20.glGetUniformLocation(i, "imageHeight");
    a(paramInt1, "imageHeight");
    GLES20.glUniform1i(paramInt1, paramInt5);
    a("fill uniform  imageHeight");
    paramInt1 = GLES20.glGetUniformLocation(i, "imageWidth");
    a(paramInt1, "imageWidth");
    GLES20.glUniform1i(paramInt1, paramInt4);
    a("fill uniform  imageWidth");
    paramInt1 = a(paramInt4);
    paramInt3 = a(paramInt5);
    if (paramInt1 % 8 == 0)
    {
      paramInt1 /= 8;
      if (paramInt3 % 8 != 0) {
        break label312;
      }
      paramInt3 /= 8;
    }
    for (;;)
    {
      GLES31.glDispatchCompute(paramInt1, paramInt3, 1);
      a("glDispatchCompute");
      GLES31.glMemoryBarrier(32);
      a("glMemoryBarrier");
      GLES30.glUnmapBuffer(37074);
      GLES20.glBindBuffer(37074, 0);
      GLES20.glDeleteBuffers(1, this.a, 0);
      return paramInt2;
      paramInt1 = paramInt1 / 8 + 1;
      break;
      label312:
      paramInt3 = paramInt3 / 8 + 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.computeShader.GPUImgFilterRecoverFilter
 * JD-Core Version:    0.7.0.1
 */