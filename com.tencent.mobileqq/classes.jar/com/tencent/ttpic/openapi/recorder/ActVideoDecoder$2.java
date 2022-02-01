package com.tencent.ttpic.openapi.recorder;

import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.log.LogUtils;

class ActVideoDecoder$2
  implements Runnable
{
  ActVideoDecoder$2(ActVideoDecoder paramActVideoDecoder) {}
  
  public void run()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ActVideoDecoder.access$600());
      localStringBuilder.append("[decodeNext]");
      BenchUtil.benchStart(localStringBuilder.toString());
      ActVideoDecoder.access$700(this.this$0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(ActVideoDecoder.access$600());
      localStringBuilder.append("[decodeNext]");
      BenchUtil.benchEnd(localStringBuilder.toString());
    }
    catch (Exception localException)
    {
      LogUtils.e(ActVideoDecoder.access$600(), "decodeNext error: ", localException, new Object[0]);
      if (AEOpenRenderConfig.DEBUG) {
        break label102;
      }
    }
    ActVideoDecoder.access$802(this.this$0, false);
    return;
    label102:
    throw localException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.recorder.ActVideoDecoder.2
 * JD-Core Version:    0.7.0.1
 */