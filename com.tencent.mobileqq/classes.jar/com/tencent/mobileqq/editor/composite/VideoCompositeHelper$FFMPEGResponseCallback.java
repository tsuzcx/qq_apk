package com.tencent.mobileqq.editor.composite;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback;
import java.util.concurrent.atomic.AtomicInteger;

class VideoCompositeHelper$FFMPEGResponseCallback
  implements FFmpegExecuteResponseCallback
{
  private final Object a;
  private final AtomicInteger b;
  private final int c;
  
  public VideoCompositeHelper$FFMPEGResponseCallback(Object paramObject, AtomicInteger paramAtomicInteger, int paramInt)
  {
    this.a = paramObject;
    this.b = paramAtomicInteger;
    this.c = paramInt;
  }
  
  public void onFailure(String paramString)
  {
    String str = VideoCompositeHelper.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FFMPEGResponseCallback onFailure() mTaskType = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" message = ");
    localStringBuilder.append(paramString);
    SLog.d(str, localStringBuilder.toString());
  }
  
  public void onFinish(boolean paramBoolean)
  {
    ??? = VideoCompositeHelper.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("FFMPEGResponseCallback onFinish() mTaskType = ");
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append(" isSuccess = ");
    ((StringBuilder)localObject2).append(paramBoolean);
    SLog.d((String)???, ((StringBuilder)localObject2).toString());
    for (;;)
    {
      synchronized (this.a)
      {
        this.a.notify();
        int n = this.c;
        int j = 0;
        int k = 0;
        int m = 0;
        i = 0;
        if (n != 1)
        {
          if (n != 2)
          {
            if (n != 3)
            {
              if (n == 4)
              {
                localObject2 = this.b;
                if (!paramBoolean) {
                  break label270;
                }
                ((AtomicInteger)localObject2).set(i);
              }
              else
              {
                localObject2 = VideoCompositeHelper.a;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("Undefined task type mTaskType = ");
                localStringBuilder.append(this.c);
                SLog.e((String)localObject2, localStringBuilder.toString());
                throw new RuntimeException("Undefined task in FFMPEGResponseCallback");
              }
            }
            else
            {
              localObject2 = this.b;
              if (!paramBoolean) {
                break label276;
              }
              i = j;
              ((AtomicInteger)localObject2).set(i);
            }
          }
          else
          {
            localObject2 = this.b;
            if (!paramBoolean) {
              break label282;
            }
            i = k;
            ((AtomicInteger)localObject2).set(i);
          }
        }
        else
        {
          localObject2 = this.b;
          if (!paramBoolean) {
            break label288;
          }
          i = m;
          ((AtomicInteger)localObject2).set(i);
        }
        return;
      }
      label270:
      int i = 944004;
      continue;
      label276:
      i = 945001;
      continue;
      label282:
      i = 942004;
      continue;
      label288:
      i = 943004;
    }
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    String str = VideoCompositeHelper.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStart() mTaskType = ");
    localStringBuilder.append(this.c);
    SLog.c(str, localStringBuilder.toString());
  }
  
  public void onSuccess(String paramString)
  {
    String str = VideoCompositeHelper.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FFMPEGResponseCallback onSuccess() mTaskType = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" message = ");
    localStringBuilder.append(paramString);
    SLog.c(str, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.VideoCompositeHelper.FFMPEGResponseCallback
 * JD-Core Version:    0.7.0.1
 */