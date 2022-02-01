package com.tencent.ttpic.logic.watermark;

import android.media.AudioRecord;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.util.AudioUtil;
import java.util.TimerTask;

class DecibelDetector$1
  extends TimerTask
{
  DecibelDetector$1(DecibelDetector paramDecibelDetector) {}
  
  public void run()
  {
    synchronized (DecibelDetector.access$000(this.this$0))
    {
      if (DecibelDetector.access$100(this.this$0) == null) {
        return;
      }
      int i = DecibelDetector.access$100(this.this$0).read(DecibelDetector.access$200(this.this$0), 0, DecibelDetector.access$300(this.this$0));
      if (i <= 1) {
        return;
      }
      DecibelDetector.access$402(this.this$0, AudioUtil.getPcmDBFromShortBuffer(DecibelDetector.access$200(this.this$0), i));
      String str = DecibelDetector.access$500();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[decibel] = ");
      localStringBuilder.append(DecibelDetector.access$400(this.this$0));
      localStringBuilder.append(", capture size = ");
      localStringBuilder.append(i);
      LogUtils.d(str, localStringBuilder.toString());
      AudioUtil.getPcmFFTFromShortBuffer(DecibelDetector.access$200(this.this$0), i, DecibelDetector.access$600(this.this$0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.logic.watermark.DecibelDetector.1
 * JD-Core Version:    0.7.0.1
 */