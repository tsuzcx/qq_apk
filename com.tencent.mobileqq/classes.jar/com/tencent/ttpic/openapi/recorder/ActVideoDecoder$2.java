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
      BenchUtil.benchStart(ActVideoDecoder.access$600() + "[decodeNext]");
      ActVideoDecoder.access$700(this.this$0);
      BenchUtil.benchEnd(ActVideoDecoder.access$600() + "[decodeNext]");
      ActVideoDecoder.access$802(this.this$0, false);
      return;
    }
    catch (Exception localException)
    {
      do
      {
        LogUtils.e(ActVideoDecoder.access$600(), "decodeNext error: ", localException, new Object[0]);
      } while (!AEOpenRenderConfig.DEBUG);
      throw localException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.recorder.ActVideoDecoder.2
 * JD-Core Version:    0.7.0.1
 */