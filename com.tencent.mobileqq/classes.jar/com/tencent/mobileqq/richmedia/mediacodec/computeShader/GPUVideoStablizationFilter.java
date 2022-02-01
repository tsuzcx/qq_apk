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
public class GPUVideoStablizationFilter
  extends GPUComputeShaderFilter
{
  private static final String TAG = "GPUVideoStablizationFilter";
  public static final String VIDEO_STABILAZATION_COMPUTE_SHADER = "    #version 310 es                                                                             \n                                                                                                \n    layout (local_size_x = 8, local_size_y = 8, local_size_z = 1) in;                           \n    layout (rgba8, binding = 0) readonly uniform  highp image2D inputImage;                     \n    layout (std430,binding = 1) writeonly buffer outputVec{                                     \n        int VecData[];                                                                          \n    };                                                                                          \n    layout (std430,binding = 2)  buffer outputAvgImage{                                         \n        float avgImageData[];                                                                   \n    };                                                                                          \n    uniform int imageHeight;                                                                    \n    uniform int imageWidth;                                                                     \n                                                                                                \n    void main(){                                                                                \n        int outputRowIndex = int(gl_GlobalInvocationID.y);                                      \n        int outputColumnIndex = int(gl_GlobalInvocationID.x);                                   \n                                                                                                \n        if(outputRowIndex >= imageHeight || outputColumnIndex >= imageWidth){                   \n            return;                                                                             \n                                                                                                \n        }                                                                                       \n                                                                                                \n        vec4 inputValue = imageLoad(inputImage, ivec2(gl_GlobalInvocationID.xy));               \n        float avgValue =  float(inputValue.r*0.299 + inputValue.g*0.587 + inputValue.b*0.114);  \n        int index = outputRowIndex * imageWidth + outputColumnIndex;                            \n        avgImageData[index] = avgValue;                                                         \n        barrier();                                                                              \n                                                                                                \n        if(outputColumnIndex == imageWidth - 1){                                                \n             float rowSum = 0.0;                                                                \n             for(int i = 0; i < imageWidth; i++){                                               \n                int idx = outputRowIndex * imageWidth + i;                                      \n                rowSum += avgImageData[idx];                                                    \n             }                                                                                  \n             VecData[imageHeight-1-outputRowIndex] = int(rowSum / float(imageWidth) * 255.0);   \n        }                                                                                       \n                                                                                                \n        if(outputRowIndex == imageHeight - 1){                                                  \n            float colSum = 0.0;                                                                 \n            for(int i = 0; i < imageHeight; i++){                                               \n                int idx = i * imageWidth + outputColumnIndex;                                   \n                colSum += avgImageData[idx];                                                    \n            }                                                                                   \n            VecData[imageHeight+outputColumnIndex] = int(colSum / float(imageHeight) * 255.0);  \n        }                                                                                       \n    }                                                                                     ";
  private final int[] mGLBuffers = new int[2];
  
  public GPUVideoStablizationFilter()
  {
    super("    #version 310 es                                                                             \n                                                                                                \n    layout (local_size_x = 8, local_size_y = 8, local_size_z = 1) in;                           \n    layout (rgba8, binding = 0) readonly uniform  highp image2D inputImage;                     \n    layout (std430,binding = 1) writeonly buffer outputVec{                                     \n        int VecData[];                                                                          \n    };                                                                                          \n    layout (std430,binding = 2)  buffer outputAvgImage{                                         \n        float avgImageData[];                                                                   \n    };                                                                                          \n    uniform int imageHeight;                                                                    \n    uniform int imageWidth;                                                                     \n                                                                                                \n    void main(){                                                                                \n        int outputRowIndex = int(gl_GlobalInvocationID.y);                                      \n        int outputColumnIndex = int(gl_GlobalInvocationID.x);                                   \n                                                                                                \n        if(outputRowIndex >= imageHeight || outputColumnIndex >= imageWidth){                   \n            return;                                                                             \n                                                                                                \n        }                                                                                       \n                                                                                                \n        vec4 inputValue = imageLoad(inputImage, ivec2(gl_GlobalInvocationID.xy));               \n        float avgValue =  float(inputValue.r*0.299 + inputValue.g*0.587 + inputValue.b*0.114);  \n        int index = outputRowIndex * imageWidth + outputColumnIndex;                            \n        avgImageData[index] = avgValue;                                                         \n        barrier();                                                                              \n                                                                                                \n        if(outputColumnIndex == imageWidth - 1){                                                \n             float rowSum = 0.0;                                                                \n             for(int i = 0; i < imageWidth; i++){                                               \n                int idx = outputRowIndex * imageWidth + i;                                      \n                rowSum += avgImageData[idx];                                                    \n             }                                                                                  \n             VecData[imageHeight-1-outputRowIndex] = int(rowSum / float(imageWidth) * 255.0);   \n        }                                                                                       \n                                                                                                \n        if(outputRowIndex == imageHeight - 1){                                                  \n            float colSum = 0.0;                                                                 \n            for(int i = 0; i < imageHeight; i++){                                               \n                int idx = i * imageWidth + outputColumnIndex;                                   \n                colSum += avgImageData[idx];                                                    \n            }                                                                                   \n            VecData[imageHeight+outputColumnIndex] = int(colSum / float(imageHeight) * 255.0);  \n        }                                                                                       \n    }                                                                                     ", 3553);
    init();
  }
  
  private int[][] copyDataGpuToCpu(int paramInt1, int paramInt2, Buffer paramBuffer)
  {
    int[] arrayOfInt1 = new int[paramInt1 + paramInt2];
    int[] arrayOfInt2 = new int[paramInt1];
    int[] arrayOfInt3 = new int[paramInt2];
    if (paramBuffer != null)
    {
      paramBuffer = (ByteBuffer)paramBuffer;
      paramBuffer.order(ByteOrder.nativeOrder());
      paramBuffer.asIntBuffer().get(arrayOfInt1);
    }
    System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, paramInt1);
    System.arraycopy(arrayOfInt1, paramInt1, arrayOfInt3, 0, paramInt2);
    return new int[][] { arrayOfInt2, arrayOfInt3 };
  }
  
  public int[][] glDisPatchVideoStavizationCompute(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = useComputeProgram();
    GLES20.glGenBuffers(2, this.mGLBuffers, 0);
    checkGlError("glGenBuffers");
    int j = paramInt3 * 4 + paramInt2 * 4;
    GLES31.glBindImageTexture(0, paramInt1, 0, true, 0, 35000, 32856);
    checkGlError("fill texture");
    GLES20.glBindBuffer(37074, this.mGLBuffers[0]);
    GLES20.glBufferData(37074, j, null, 35049);
    GLES30.glBindBufferBase(37074, 1, this.mGLBuffers[0]);
    GLES20.glBindBuffer(37074, 0);
    checkGlError("fill heightVecData buffer");
    GLES20.glBindBuffer(37074, this.mGLBuffers[1]);
    GLES20.glBufferData(37074, paramInt2 * paramInt3 * 4, null, 35049);
    GLES30.glBindBufferBase(37074, 2, this.mGLBuffers[1]);
    GLES20.glBindBuffer(37074, 0);
    checkGlError("fill outputAvgImage buffer");
    paramInt1 = GLES20.glGetUniformLocation(i, "imageHeight");
    checkLocation(paramInt1, "imageHeight");
    GLES20.glUniform1i(paramInt1, paramInt3);
    checkGlError("fill uniform  imageHeight");
    paramInt1 = GLES20.glGetUniformLocation(i, "imageWidth");
    checkLocation(paramInt1, "imageWidth");
    GLES20.glUniform1i(paramInt1, paramInt2);
    checkGlError("fill uniform  imageWidth");
    if (paramInt2 % 8 == 0) {
      paramInt1 = paramInt2 / 8;
    } else {
      paramInt1 = paramInt2 / 8 + 1;
    }
    if (paramInt3 % 8 == 0) {
      i = paramInt3 / 8;
    } else {
      i = paramInt3 / 8 + 1;
    }
    GLES31.glDispatchCompute(paramInt1, i, 1);
    checkGlError("glDispatchCompute");
    GLES31.glMemoryBarrier(32);
    checkGlError("glMemoryBarrier");
    GLES20.glBindBuffer(37074, this.mGLBuffers[0]);
    Object localObject = GLES30.glMapBufferRange(37074, 0, j, 1);
    checkGlError("glMapBufferRange");
    localObject = copyDataGpuToCpu(paramInt3, paramInt2, (Buffer)localObject);
    GLES30.glUnmapBuffer(37074);
    GLES20.glBindBuffer(37074, 0);
    GLES20.glDeleteBuffers(2, this.mGLBuffers, 0);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.computeShader.GPUVideoStablizationFilter
 * JD-Core Version:    0.7.0.1
 */