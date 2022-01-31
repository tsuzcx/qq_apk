package com.tencent.mobileqq.richmedia.mediacodec.computeShader;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLES31;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

@SuppressLint({"NewApi"})
public class GPUImgFilterPixelsFilter
  extends GPUComputeShaderFilter
{
  private final int[] a = new int[1];
  
  public GPUImgFilterPixelsFilter()
  {
    super("    #version 310 es                                                                             \n                                                                                                \n    layout (local_size_x = 8, local_size_y = 8, local_size_z = 1) in;                           \n    layout (rgba8, binding = 0) readonly  uniform  highp image2D inputImage;                    \n    layout (std430,binding = 1) buffer outputData{                                              \n        int ouputdata[];                                                                        \n    };                                                                                          \n    uniform int r;                                                                    \n    uniform int imageHeight;                                                                    \n    uniform int imageWidth;                                                                     \n                                                                                                \n    void main(){                                                                                \n       int outputRowIndex = int(gl_GlobalInvocationID.y);                                        \n       int outputColumnIndex = int(gl_GlobalInvocationID.x);                                  \n       if(outputRowIndex >= imageHeight || outputColumnIndex >= imageWidth){                   \n            return;                                                                           \n       }                                                                                            \n       vec4 inputValue = imageLoad(inputImage, ivec2(gl_GlobalInvocationID.xy));                   \n       barrier();                                                                                          \n       int startX =  outputColumnIndex - r;                                                         \n       int startY =  outputRowIndex - r;                                                            \n       int endX =  outputColumnIndex + r;                                                              \n       int endY =  outputRowIndex + r;                                                          \n       float maxChanel = max(inputValue.r, max(inputValue.b, inputValue.g));                       \n       float minChanel = min(inputValue.r, min(inputValue.b, inputValue.g));                           \n       for(int i= startX; i<=endX; i++){                                                            \n           for(int j= startY; j<=endY; j++){                                                           \n               if(i >=0 && i<imageWidth && j >= 0 && j<imageHeight){                 \n                   vec4 arroundValue = imageLoad(inputImage, ivec2(i,j));                                  \n                   maxChanel = max(maxChanel,max(arroundValue.r, max(arroundValue.b, arroundValue.g))); \n                   minChanel = min(minChanel,min(arroundValue.r, min(arroundValue.b, arroundValue.g))); \n               }                                                                                        \n           }                                                                                            \n       }                                                                                                \n       int index = outputRowIndex*imageWidth+outputColumnIndex;                  \n                                                                                                        \n       ouputdata[index] = int(maxChanel * 255.0);                                                           \n                                                                                                           \n       int minoffset = imageHeight * imageWidth;                                                        \n       ouputdata[minoffset + index] = int(minChanel * 255.0);                                                           \n                                                                                                            \n       float avgValue =  float(inputValue.r*0.299 + inputValue.g*0.587 + inputValue.b*0.114);              \n       int avgoffset = imageHeight * imageWidth * 2;                                                       \n       ouputdata[avgoffset + index] = int(avgValue * 255.0);                                                            \n   }                                                        ", 3553);
    a();
  }
  
  private int[][] a(int paramInt1, int paramInt2, Buffer paramBuffer)
  {
    paramInt1 *= paramInt2;
    int[] arrayOfInt1 = new int[paramInt1 * 3];
    int[] arrayOfInt2 = new int[paramInt1];
    int[] arrayOfInt3 = new int[paramInt1];
    int[] arrayOfInt4 = new int[paramInt1];
    if (paramBuffer != null)
    {
      paramBuffer = (ByteBuffer)paramBuffer;
      paramBuffer.order(ByteOrder.nativeOrder());
      paramBuffer.asIntBuffer().get(arrayOfInt1);
    }
    System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, paramInt1);
    System.arraycopy(arrayOfInt1, paramInt1, arrayOfInt3, 0, paramInt1);
    System.arraycopy(arrayOfInt1, paramInt1 * 2, arrayOfInt4, 0, paramInt1);
    return new int[][] { arrayOfInt2, arrayOfInt3, arrayOfInt4 };
  }
  
  public int[][] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = a();
    GLES20.glGenBuffers(1, this.a, 0);
    a("glGenBuffers");
    GLES31.glBindImageTexture(0, paramInt1, 0, true, 0, 35000, 32856);
    a("fill inputImage texture");
    GLES20.glBindBuffer(37074, this.a[0]);
    GLES20.glBufferData(37074, paramInt2 * paramInt3 * 3 * 4, null, 35049);
    GLES30.glBindBufferBase(37074, 1, this.a[0]);
    GLES20.glBindBuffer(37074, 0);
    a("fill aValueData buffer");
    paramInt1 = GLES20.glGetUniformLocation(i, "r");
    a(paramInt1, "r");
    GLES20.glUniform1i(paramInt1, (paramInt4 - 1) / 2);
    a("fill uniform  r");
    paramInt1 = GLES20.glGetUniformLocation(i, "imageHeight");
    a(paramInt1, "imageHeight");
    GLES20.glUniform1i(paramInt1, paramInt3);
    a("fill uniform  imageHeight");
    paramInt1 = GLES20.glGetUniformLocation(i, "imageWidth");
    a(paramInt1, "imageWidth");
    GLES20.glUniform1i(paramInt1, paramInt2);
    a("fill uniform  imageWidth");
    paramInt1 = a(paramInt2);
    paramInt4 = a(paramInt3);
    if (paramInt1 % 8 == 0)
    {
      paramInt1 /= 8;
      if (paramInt4 % 8 != 0) {
        break label313;
      }
      paramInt4 /= 8;
    }
    for (;;)
    {
      GLES31.glDispatchCompute(paramInt1, paramInt4, 1);
      a("glDispatchCompute");
      GLES31.glMemoryBarrier(32);
      a("glMemoryBarrier");
      GLES20.glBindBuffer(37074, this.a[0]);
      Object localObject = GLES30.glMapBufferRange(37074, 0, paramInt2 * paramInt3 * 3 * 4, 1);
      a("glMapBufferRange");
      localObject = a(paramInt3, paramInt2, (Buffer)localObject);
      GLES30.glUnmapBuffer(37074);
      GLES20.glBindBuffer(37074, 0);
      GLES20.glDeleteBuffers(1, this.a, 0);
      return localObject;
      paramInt1 = paramInt1 / 8 + 1;
      break;
      label313:
      paramInt4 = paramInt4 / 8 + 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.computeShader.GPUImgFilterPixelsFilter
 * JD-Core Version:    0.7.0.1
 */