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
    if ((paramRectF == null) || (paramInt3 == 0) || (paramInt4 == 0) || (paramInt1 == 0) || (paramInt2 == 0)) {
      return null;
    }
    for (;;)
    {
      try
      {
        localObject = ByteBuffer.allocateDirect(paramInt1 * paramInt2 * 2 * 4);
        ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
        localObject = ((ByteBuffer)localObject).asFloatBuffer();
        f1 = paramRectF.left;
        f2 = paramRectF.bottom;
        f3 = 1.0F / paramInt3;
        f4 = 1.0F / paramInt4;
        paramInt3 = 0;
      }
      catch (OutOfMemoryError paramRectF)
      {
        Object localObject;
        float f1;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        return null;
      }
      if (paramInt4 >= paramInt1) {
        break label169;
      }
      f5 = paramInt4;
      f6 = paramInt3;
      ((FloatBuffer)localObject).put((f5 * f3 + f1) * 2.0F - 1.0F);
      ((FloatBuffer)localObject).put(2.0F * (f6 * f4 + f2) - 1.0F);
      paramInt4 += 1;
    }
    label169:
    label176:
    for (;;)
    {
      ((FloatBuffer)localObject).rewind();
      return localObject;
      for (;;)
      {
        if (paramInt3 >= paramInt2) {
          break label176;
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
    if (this.mListenerRef == null) {}
    VertexDataJobListener localVertexDataJobListener;
    do
    {
      return;
      localVertexDataJobListener = (VertexDataJobListener)this.mListenerRef.get();
    } while (localVertexDataJobListener == null);
    localVertexDataJobListener.onResult(localFloatBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.VertexDataJob
 * JD-Core Version:    0.7.0.1
 */