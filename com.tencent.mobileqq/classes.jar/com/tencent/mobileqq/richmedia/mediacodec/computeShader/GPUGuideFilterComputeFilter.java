package com.tencent.mobileqq.richmedia.mediacodec.computeShader;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLES31;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@SuppressLint({"NewApi"})
public class GPUGuideFilterComputeFilter
  extends GPUComputeShaderFilter
{
  private final int[] a = new int[3];
  
  public GPUGuideFilterComputeFilter()
  {
    super("    #version 310 es                                                                             \n                                                                                                \n    layout (local_size_x = 8, local_size_y = 8, local_size_z = 1) in;                           \n    layout (std430,binding = 0) buffer transmissionData{                                              \n        float transmission[];                                                                        \n    };                                                                                          \n    layout (std430,binding = 1) buffer guidenceImgData{                                              \n        float guidenceImg[];                                                                        \n    };                                                                                          \n    layout (std430,binding = 2) buffer outputData{                                              \n        float ab[];                                                                        \n    };                                                                                          \n    uniform int r;                                                                    \n    uniform float eps;                                                                    \n    uniform int imageHeight;                                                                    \n    uniform int imageWidth;                                                                     \n                                                                                                \n    void main(){                                                                                \n       int outputRowIndex = int(gl_GlobalInvocationID.y);                                        \n       int outputColumnIndex = int(gl_GlobalInvocationID.x);                                  \n       if(outputRowIndex >= imageHeight || outputColumnIndex >= imageWidth){                   \n            return;                                                                           \n       }                                                                                            \n       int startX =  outputColumnIndex - r;                                                         \n       int startY =  outputRowIndex - r;                                                            \n       int endX =  outputColumnIndex + r;                                                              \n       int endY =  outputRowIndex + r;                                                          \n       int k=0;                                                                                          \n       int wndsize = 2 * r + 1;                                                               \n       int pixcount = wndsize * wndsize;                                                            \n       float sum_I = 0.0;                                                                               \n       float sum_p = 0.0;                                                                                \n       for(int m= startY; m<=endY; m++){                                                            \n           for(int n= startX; n<=endX; n++){                                                           \n               if(m < 0 || m >= imageHeight){                                                              \n                  k++;                                                                                            \n                  continue;                                                                                 \n               }                                                                                                \n               if(n < 0 || n >= imageWidth){                                                              \n                  k++;                                                                                            \n                  continue;                                                                                  \n               }                                                                                                \n               sum_I += guidenceImg[m*imageWidth+n];                                                     \n               sum_p += transmission[m*imageWidth+n];                                                            \n           }                                                                                            \n       }                                                                                                \n       float mean_I = sum_I / float(pixcount - k);                                                      \n       float mean_p = sum_p / float(pixcount - k);                                                          \n       k = 0;                                                                                              \n       float sum_Ip = 0.0f;                                                                                \n       float sum_var_I = 0.0f;                                                                                   \n       for(int m= startY; m<=endY; m++){                                                                        \n           for(int n= startX; n<=endX; n++){                                                           \n               if(m < 0 || m >= imageHeight){                                                              \n                  k++;                                                                                            \n                  continue;                                                                                \n               }                                                                                                \n               if(n < 0 || n >= imageWidth){                                                              \n                  k++;                                                                                         \n                  continue;                                                                                      \n               }                                                                                                                     \n               sum_Ip += transmission[m * imageWidth + n] * guidenceImg[m * imageWidth + n];                               \n               sum_var_I += (guidenceImg[m * imageWidth + n] - mean_I) * (guidenceImg[m * imageWidth + n] - mean_I);       \n           }                                                                                                                                        \n       }                                                                                                                                             \n       int index = imageWidth*imageHeight;                                                                                                                           \n       ab[outputRowIndex*imageWidth + outputColumnIndex] = (sum_Ip / float(pixcount - k) - mean_I * mean_p) / (sum_var_I / float(pixcount - k) + eps);                           \n       ab[outputRowIndex*imageWidth + outputColumnIndex + index] = mean_p - ab[outputRowIndex*imageWidth+outputColumnIndex] * mean_I;                                                        \n       barrier();                                                                                                                                                \n   }                                                                                                             ", 3553);
    a();
  }
  
  public float[] a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    int i = a();
    GLES20.glGenBuffers(3, this.a, 0);
    a("glGenBuffers");
    paramArrayOfFloat1 = GlUtil.a(paramArrayOfFloat1);
    GLES20.glBindBuffer(37074, this.a[0]);
    GLES20.glBufferData(37074, paramInt1 * paramInt2 * 4, paramArrayOfFloat1, 35049);
    GLES30.glBindBufferBase(37074, 0, this.a[0]);
    GLES20.glBindBuffer(37074, 0);
    a("fill aValueData buffer");
    paramArrayOfFloat1 = GlUtil.a(paramArrayOfFloat2);
    GLES20.glBindBuffer(37074, this.a[1]);
    GLES20.glBufferData(37074, paramInt1 * paramInt2 * 4, paramArrayOfFloat1, 35049);
    GLES30.glBindBufferBase(37074, 1, this.a[1]);
    GLES20.glBindBuffer(37074, 0);
    a("fill aValueData buffer");
    GLES20.glBindBuffer(37074, this.a[2]);
    GLES20.glBufferData(37074, paramInt1 * paramInt2 * 2 * 4, null, 35049);
    GLES30.glBindBufferBase(37074, 2, this.a[2]);
    GLES20.glBindBuffer(37074, 0);
    a("fill aValueData buffer");
    int j = GLES20.glGetUniformLocation(i, "r");
    a(j, "r");
    GLES20.glUniform1i(j, (paramInt3 - 1) / 2);
    a("fill uniform  r");
    paramInt3 = GLES20.glGetUniformLocation(i, "eps");
    a(paramInt3, "eps");
    GLES20.glUniform1f(paramInt3, paramFloat);
    a("fill uniform  eps");
    paramInt3 = GLES20.glGetUniformLocation(i, "imageHeight");
    a(paramInt3, "imageHeight");
    GLES20.glUniform1i(paramInt3, paramInt2);
    a("fill uniform  imageHeight");
    paramInt3 = GLES20.glGetUniformLocation(i, "imageWidth");
    a(paramInt3, "imageWidth");
    GLES20.glUniform1i(paramInt3, paramInt1);
    a("fill uniform  imageWidth");
    paramInt3 = a(paramInt1);
    i = a(paramInt2);
    if (paramInt3 % 8 == 0)
    {
      paramInt3 /= 8;
      if (i % 8 != 0) {
        break label476;
      }
      i /= 8;
    }
    for (;;)
    {
      GLES31.glDispatchCompute(paramInt3, i, 1);
      a("glDispatchCompute");
      GLES31.glMemoryBarrier(32);
      a("glMemoryBarrier");
      GLES20.glBindBuffer(37074, this.a[2]);
      paramArrayOfFloat2 = GLES30.glMapBufferRange(37074, 0, paramInt1 * paramInt2 * 2 * 4, 1);
      a("glMapBufferRange");
      paramArrayOfFloat1 = new float[paramInt1 * paramInt2 * 2];
      if (paramArrayOfFloat2 != null)
      {
        paramArrayOfFloat2 = (ByteBuffer)paramArrayOfFloat2;
        paramArrayOfFloat2.order(ByteOrder.nativeOrder());
        paramArrayOfFloat2.asFloatBuffer().get(paramArrayOfFloat1);
      }
      GLES30.glUnmapBuffer(37074);
      GLES20.glBindBuffer(37074, 0);
      GLES20.glDeleteBuffers(3, this.a, 0);
      return paramArrayOfFloat1;
      paramInt3 = paramInt3 / 8 + 1;
      break;
      label476:
      i = i / 8 + 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.computeShader.GPUGuideFilterComputeFilter
 * JD-Core Version:    0.7.0.1
 */