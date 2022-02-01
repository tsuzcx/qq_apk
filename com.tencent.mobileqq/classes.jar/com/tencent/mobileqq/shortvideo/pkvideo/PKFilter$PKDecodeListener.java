package com.tencent.mobileqq.shortvideo.pkvideo;

import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.sveffects.SLog;

class PKFilter$PKDecodeListener
  implements HWDecodeListener
{
  private PKFilter$PKDecodeListener(PKFilter paramPKFilter) {}
  
  public void onDecodeCancel() {}
  
  public void onDecodeError(int paramInt, Throwable paramThrowable) {}
  
  public void onDecodeFinish() {}
  
  public void onDecodeFrame(long paramLong1, long paramLong2)
  {
    String str = PKFilter.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PK decoder onDecodeFrame=");
    localStringBuilder.append(paramLong1 / 1000000L);
    SLog.d(str, localStringBuilder.toString());
    PKFilter.access$102(this.this$0, paramLong1);
  }
  
  public void onDecodeRepeat()
  {
    PKFilter.access$102(this.this$0, 0L);
    SLog.e(PKFilter.TAG, "pk decoder onDecodeRepeat");
  }
  
  public void onDecodeSeekTo(long paramLong) {}
  
  public void onDecodeStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.pkvideo.PKFilter.PKDecodeListener
 * JD-Core Version:    0.7.0.1
 */