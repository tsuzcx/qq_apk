package com.tencent.mobileqq.richmedia.mediacodec.computeShader;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLES31;

@SuppressLint({"NewApi"})
public class GPUGuideFilterRecoverFilter
  extends GPUComputeShaderFilter
{
  private static final String TAG = "GPUVideoStablizationFilter";
  public static final String VIDEO_GUIDE_FILTER_RECOVER_SHADER = "    #version 310 es                                                                             \n                                                                                                \n    layout (local_size_x = 8, local_size_y = 8, local_size_z = 1) in;                           \n    layout (std430,binding = 0) buffer abData{                                              \n        float ab[];                                                                        \n    };                                                                                          \n    layout (std430,binding = 1) buffer meanabData{                                              \n        float mean_ab[];                                                                        \n    };                                                                                          \n    layout (std430,binding = 2) buffer guidenceImgData{                                              \n        int guidenceImg[];                                                                        \n    };                                                                                          \n    layout (rgba8, binding = 3) writeonly uniform  highp image2D transmisionImage;                    \n    uniform int r;                                                                    \n    uniform int imageHeight;                                                                    \n    uniform int imageWidth;                                                                     \n                                                                                                \n    void main(){                                                                                \n       int outputRowIndex = int(gl_GlobalInvocationID.y);                                        \n       int outputColumnIndex = int(gl_GlobalInvocationID.x);                                  \n       if(outputRowIndex >= imageHeight || outputColumnIndex >= imageWidth){                   \n            return;                                                                           \n       }                                                                                            \n       int startX =  outputColumnIndex - r;                                                         \n       int startY =  outputRowIndex - r;                                                            \n       int endX =  outputColumnIndex + r;                                                              \n       int endY =  outputRowIndex + r;                                                          \n       int k=0;                                                                                          \n       int wndsize = 2 * r + 1;                                                               \n       int pixcount = wndsize * wndsize;                                                            \n       float sumA = 0.0;                                                                               \n       float sumB = 0.0;                                                                                \n       int index = imageWidth*imageHeight;                                                                     \n       for(int m= startY; m<=endY; m++){                                                            \n           for(int n= startX; n<=endX; n++){                                                           \n               if(m < 0 || m >= imageHeight){                                                              \n                  k++;                                                                                            \n                  continue;                                                                                 \n               }                                                                                                \n               if(n < 0 || n >= imageWidth){                                                              \n                  k++;                                                                                            \n                  continue;                                                                                  \n               }                                                                                                \n               sumA += ab[m*imageWidth+n];                                                                               \n               sumB += ab[m*imageWidth+n + index];                                                            \n           }                                                                                            \n       }                                                                                                \n       mean_ab[outputRowIndex * imageWidth + outputColumnIndex] = sumA / float(pixcount - k);                                                                                                 \n       mean_ab[outputRowIndex * imageWidth + outputColumnIndex + index] = sumB / float(pixcount - k);                                                                                                              \n       float tmp = mean_ab[outputRowIndex * imageWidth + outputColumnIndex] * float(guidenceImg[outputRowIndex*imageWidth+outputColumnIndex])/255.0 + mean_ab[outputRowIndex*imageWidth+outputColumnIndex + index];          \n       tmp = tmp > 1.0 ? 1.0f : tmp;                                                                                                                                                                        \n       tmp = tmp > 0.1 ? tmp : 0.1;                                                                                                                                                                       \n       vec4 ouputRGBA = vec4(tmp,tmp,tmp,1.0);                                                              \n       imageStore(transmisionImage,ivec2(gl_GlobalInvocationID.xy),ouputRGBA);                                         \n       barrier();                                                                                                                                                                                                \n   }                                                                                                             ";
  
  public GPUGuideFilterRecoverFilter()
  {
    super("    #version 310 es                                                                             \n                                                                                                \n    layout (local_size_x = 8, local_size_y = 8, local_size_z = 1) in;                           \n    layout (std430,binding = 0) buffer abData{                                              \n        float ab[];                                                                        \n    };                                                                                          \n    layout (std430,binding = 1) buffer meanabData{                                              \n        float mean_ab[];                                                                        \n    };                                                                                          \n    layout (std430,binding = 2) buffer guidenceImgData{                                              \n        int guidenceImg[];                                                                        \n    };                                                                                          \n    layout (rgba8, binding = 3) writeonly uniform  highp image2D transmisionImage;                    \n    uniform int r;                                                                    \n    uniform int imageHeight;                                                                    \n    uniform int imageWidth;                                                                     \n                                                                                                \n    void main(){                                                                                \n       int outputRowIndex = int(gl_GlobalInvocationID.y);                                        \n       int outputColumnIndex = int(gl_GlobalInvocationID.x);                                  \n       if(outputRowIndex >= imageHeight || outputColumnIndex >= imageWidth){                   \n            return;                                                                           \n       }                                                                                            \n       int startX =  outputColumnIndex - r;                                                         \n       int startY =  outputRowIndex - r;                                                            \n       int endX =  outputColumnIndex + r;                                                              \n       int endY =  outputRowIndex + r;                                                          \n       int k=0;                                                                                          \n       int wndsize = 2 * r + 1;                                                               \n       int pixcount = wndsize * wndsize;                                                            \n       float sumA = 0.0;                                                                               \n       float sumB = 0.0;                                                                                \n       int index = imageWidth*imageHeight;                                                                     \n       for(int m= startY; m<=endY; m++){                                                            \n           for(int n= startX; n<=endX; n++){                                                           \n               if(m < 0 || m >= imageHeight){                                                              \n                  k++;                                                                                            \n                  continue;                                                                                 \n               }                                                                                                \n               if(n < 0 || n >= imageWidth){                                                              \n                  k++;                                                                                            \n                  continue;                                                                                  \n               }                                                                                                \n               sumA += ab[m*imageWidth+n];                                                                               \n               sumB += ab[m*imageWidth+n + index];                                                            \n           }                                                                                            \n       }                                                                                                \n       mean_ab[outputRowIndex * imageWidth + outputColumnIndex] = sumA / float(pixcount - k);                                                                                                 \n       mean_ab[outputRowIndex * imageWidth + outputColumnIndex + index] = sumB / float(pixcount - k);                                                                                                              \n       float tmp = mean_ab[outputRowIndex * imageWidth + outputColumnIndex] * float(guidenceImg[outputRowIndex*imageWidth+outputColumnIndex])/255.0 + mean_ab[outputRowIndex*imageWidth+outputColumnIndex + index];          \n       tmp = tmp > 1.0 ? 1.0f : tmp;                                                                                                                                                                        \n       tmp = tmp > 0.1 ? tmp : 0.1;                                                                                                                                                                       \n       vec4 ouputRGBA = vec4(tmp,tmp,tmp,1.0);                                                              \n       imageStore(transmisionImage,ivec2(gl_GlobalInvocationID.xy),ouputRGBA);                                         \n       barrier();                                                                                                                                                                                                \n   }                                                                                                             ", 3553);
    init();
  }
  
  public void glDisPatchGuideFilterRecoverFilterCompute(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = useComputeProgram();
    GLES20.glBindBuffer(37074, paramArrayOfInt[2]);
    GLES30.glBindBufferBase(37074, 0, paramArrayOfInt[2]);
    GLES20.glBindBuffer(37074, 0);
    checkGlError("fill ab buffer");
    GLES20.glBindBuffer(37074, paramArrayOfInt[3]);
    GLES20.glBufferData(37074, paramInt2 * paramInt3 * 2 * 4, null, 35049);
    GLES30.glBindBufferBase(37074, 1, paramArrayOfInt[3]);
    GLES20.glBindBuffer(37074, 0);
    checkGlError("fill aValueData buffer");
    GLES20.glBindBuffer(37074, paramArrayOfInt[0]);
    GLES30.glBindBufferBase(37074, 2, paramArrayOfInt[0]);
    GLES20.glBindBuffer(37074, 0);
    checkGlError("fill aValueData buffer");
    GLES31.glBindImageTexture(3, paramInt1, 0, true, 0, 35001, 32856);
    checkGlError("fill tImage texture");
    paramInt1 = GLES20.glGetUniformLocation(i, "r");
    checkLocation(paramInt1, "r");
    GLES20.glUniform1i(paramInt1, (paramInt4 - 1) / 2);
    checkGlError("fill uniform  r");
    paramInt1 = GLES20.glGetUniformLocation(i, "imageHeight");
    checkLocation(paramInt1, "imageHeight");
    GLES20.glUniform1i(paramInt1, paramInt3);
    checkGlError("fill uniform  imageHeight");
    paramInt1 = GLES20.glGetUniformLocation(i, "imageWidth");
    checkLocation(paramInt1, "imageWidth");
    GLES20.glUniform1i(paramInt1, paramInt2);
    checkGlError("fill uniform  imageWidth");
    paramInt1 = getAlignment16(paramInt2);
    paramInt2 = getAlignment16(paramInt3);
    if (paramInt1 % 8 == 0)
    {
      paramInt1 /= 8;
      if (paramInt2 % 8 != 0) {
        break label282;
      }
      paramInt2 /= 8;
    }
    for (;;)
    {
      GLES31.glDispatchCompute(paramInt1, paramInt2, 1);
      checkGlError("glDispatchCompute");
      GLES31.glMemoryBarrier(32);
      checkGlError("glMemoryBarrier");
      return;
      paramInt1 = paramInt1 / 8 + 1;
      break;
      label282:
      paramInt2 = paramInt2 / 8 + 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.computeShader.GPUGuideFilterRecoverFilter
 * JD-Core Version:    0.7.0.1
 */