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
public class GPUAvgPixelsFilter
  extends GPUComputeShaderFilter
{
  private static final String TAG = "GPUVideoStablizationFilter";
  public static final String VIDEO_IMG_FILTER_COMPUTE_SHADER = "    #version 310 es                                                                             \n                                                                                                \n    layout (local_size_x = 8, local_size_y = 8, local_size_z = 1) in;                           \n    layout (rgba8, binding = 0) readonly  uniform  highp image2D inputImage;                    \n    layout (std430,binding = 1) buffer AvgPixlesData{                                              \n        int avgPixels[];                                                                        \n    };                                                                                          \n    uniform int imageHeight;                                                                    \n    uniform int imageWidth;                                                                     \n                                                                                                \n    void main(){                                                                                \n       int outputRowIndex = int(gl_GlobalInvocationID.y);                                        \n       int outputColumnIndex = int(gl_GlobalInvocationID.x);                                  \n       if(outputRowIndex >= imageHeight || outputColumnIndex >= imageWidth){                   \n            return;                                                                           \n       }                                                                                            \n       vec4 inputValue = imageLoad(inputImage, ivec2(gl_GlobalInvocationID.xy));                   \n       barrier();                                                                                          \n       int index = outputRowIndex*imageWidth+outputColumnIndex;                  \n       float avgValue =  float(inputValue.r*0.299 + inputValue.g*0.587 + inputValue.b*0.114);              \n       avgPixels[index] = int(avgValue * 255.0);                                                            \n   }                                                        ";
  ByteOrder byteOrder = ByteOrder.nativeOrder();
  
  public GPUAvgPixelsFilter()
  {
    super("    #version 310 es                                                                             \n                                                                                                \n    layout (local_size_x = 8, local_size_y = 8, local_size_z = 1) in;                           \n    layout (rgba8, binding = 0) readonly  uniform  highp image2D inputImage;                    \n    layout (std430,binding = 1) buffer AvgPixlesData{                                              \n        int avgPixels[];                                                                        \n    };                                                                                          \n    uniform int imageHeight;                                                                    \n    uniform int imageWidth;                                                                     \n                                                                                                \n    void main(){                                                                                \n       int outputRowIndex = int(gl_GlobalInvocationID.y);                                        \n       int outputColumnIndex = int(gl_GlobalInvocationID.x);                                  \n       if(outputRowIndex >= imageHeight || outputColumnIndex >= imageWidth){                   \n            return;                                                                           \n       }                                                                                            \n       vec4 inputValue = imageLoad(inputImage, ivec2(gl_GlobalInvocationID.xy));                   \n       barrier();                                                                                          \n       int index = outputRowIndex*imageWidth+outputColumnIndex;                  \n       float avgValue =  float(inputValue.r*0.299 + inputValue.g*0.587 + inputValue.b*0.114);              \n       avgPixels[index] = int(avgValue * 255.0);                                                            \n   }                                                        ", 3553);
    init();
  }
  
  private int[] copyDataGpuToCpu(int paramInt1, int paramInt2, Buffer paramBuffer)
  {
    int[] arrayOfInt = new int[paramInt1 * paramInt2];
    if (paramBuffer != null)
    {
      paramBuffer = (ByteBuffer)paramBuffer;
      paramBuffer.order(this.byteOrder);
      paramBuffer.asIntBuffer().get(arrayOfInt);
    }
    return arrayOfInt;
  }
  
  public int[] glDisPatchGPUAvgPixelsFilterCompute(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt, int paramInt4)
  {
    paramInt4 = useComputeProgram();
    GLES31.glBindImageTexture(0, paramInt1, 0, true, 0, 35000, 32856);
    checkGlError("fill inputImage texture");
    GLES20.glBindBuffer(37074, paramArrayOfInt[0]);
    GLES20.glBufferData(37074, paramInt2 * paramInt3 * 4, null, 35049);
    GLES30.glBindBufferBase(37074, 1, paramArrayOfInt[0]);
    GLES20.glBindBuffer(37074, 0);
    checkGlError("fill avgData buffer");
    paramInt1 = GLES20.glGetUniformLocation(paramInt4, "imageHeight");
    checkLocation(paramInt1, "imageHeight");
    GLES20.glUniform1i(paramInt1, paramInt3);
    checkGlError("fill uniform  imageHeight");
    paramInt1 = GLES20.glGetUniformLocation(paramInt4, "imageWidth");
    checkLocation(paramInt1, "imageWidth");
    GLES20.glUniform1i(paramInt1, paramInt2);
    checkGlError("fill uniform  imageWidth");
    paramInt1 = getAlignment16(paramInt2);
    paramInt4 = getAlignment16(paramInt3);
    if (paramInt1 % 8 == 0)
    {
      paramInt1 /= 8;
      if (paramInt4 % 8 != 0) {
        break label248;
      }
      paramInt4 /= 8;
    }
    for (;;)
    {
      GLES31.glDispatchCompute(paramInt1, paramInt4, 1);
      checkGlError("glDispatchCompute");
      GLES31.glMemoryBarrier(32);
      checkGlError("glMemoryBarrier");
      GLES20.glBindBuffer(37074, paramArrayOfInt[0]);
      paramArrayOfInt = GLES30.glMapBufferRange(37074, 0, paramInt2 * paramInt3 * 4, 1);
      checkGlError("glMapBufferRange");
      paramArrayOfInt = copyDataGpuToCpu(paramInt3, paramInt2, paramArrayOfInt);
      GLES30.glUnmapBuffer(37074);
      GLES20.glBindBuffer(37074, 0);
      return paramArrayOfInt;
      paramInt1 = paramInt1 / 8 + 1;
      break;
      label248:
      paramInt4 = paramInt4 / 8 + 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.computeShader.GPUAvgPixelsFilter
 * JD-Core Version:    0.7.0.1
 */