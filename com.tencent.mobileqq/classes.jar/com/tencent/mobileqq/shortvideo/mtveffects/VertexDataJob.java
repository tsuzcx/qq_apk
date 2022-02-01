package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

class VertexDataJob
  implements Runnable
{
  private static final String TAG = "VertexDataJob";
  private int mHeight;
  private WeakReference<VertexDataJobListener> mListenerRef;
  private int mMaxHeight;
  private int mMaxWidth;
  private RectF mRcSrc;
  private int mWidth;
  
  public VertexDataJob(RectF paramRectF, int paramInt1, int paramInt2, int paramInt3, int paramInt4, VertexDataJobListener paramVertexDataJobListener)
  {
    this.mRcSrc = paramRectF;
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.mMaxWidth = paramInt3;
    this.mMaxHeight = paramInt4;
    this.mListenerRef = new WeakReference(paramVertexDataJobListener);
  }
  
  private FloatBuffer getFloatBuffer(RectF paramRectF, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramRectF != null)
    {
      localObject1 = localObject2;
      if (paramInt3 != 0)
      {
        localObject1 = localObject2;
        if (paramInt4 != 0)
        {
          localObject1 = localObject2;
          if (paramInt1 != 0)
          {
            if (paramInt2 == 0) {
              return null;
            }
            for (;;)
            {
              try
              {
                localObject1 = ByteBuffer.allocateDirect(paramInt1 * paramInt2 * 2 * 4);
                ((ByteBuffer)localObject1).order(ByteOrder.nativeOrder());
                localObject1 = ((ByteBuffer)localObject1).asFloatBuffer();
                f1 = paramRectF.left;
                f2 = paramRectF.bottom;
                f3 = 1.0F / paramInt3;
                f4 = 1.0F / paramInt4;
                paramInt3 = 0;
              }
              catch (OutOfMemoryError paramRectF)
              {
                float f1;
                float f2;
                float f3;
                float f4;
                float f5;
                float f6;
                return null;
              }
              if (paramInt4 >= paramInt1) {
                break label188;
              }
              f5 = paramInt4;
              f6 = paramInt3;
              ((FloatBuffer)localObject1).put((f5 * f3 + f1) * 2.0F - 1.0F);
              ((FloatBuffer)localObject1).put((f6 * f4 + f2) * 2.0F - 1.0F);
              paramInt4 += 1;
            }
          }
        }
      }
    }
    label188:
    label195:
    for (;;)
    {
      ((FloatBuffer)localObject1).rewind();
      return localObject1;
      for (;;)
      {
        if (paramInt3 >= paramInt2) {
          break label195;
        }
        paramInt4 = 0;
        break;
        paramInt3 += 1;
      }
    }
  }
  
  public void run()
  {
    FloatBuffer localFloatBuffer = getFloatBuffer(this.mRcSrc, this.mWidth, this.mHeight, this.mMaxWidth, this.mMaxHeight);
    Object localObject = this.mListenerRef;
    if (localObject == null) {
      return;
    }
    localObject = (VertexDataJobListener)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ((VertexDataJobListener)localObject).onResult(localFloatBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.VertexDataJob
 * JD-Core Version:    0.7.0.1
 */