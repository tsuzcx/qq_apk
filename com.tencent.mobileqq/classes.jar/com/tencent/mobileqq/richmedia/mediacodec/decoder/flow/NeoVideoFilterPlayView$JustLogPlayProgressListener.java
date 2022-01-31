package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import com.tencent.biz.qqstory.support.logging.SLog;

public class NeoVideoFilterPlayView$JustLogPlayProgressListener
  implements NeoVideoFilterPlayView.PlayProgressListener
{
  public void a()
  {
    SLog.b("FlowEdit_NeoVideoFilterPlayView", "onResetAndStart");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    SLog.a("FlowEdit_NeoVideoFilterPlayView", "onSpeedChange, old=%d, new=%d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void a(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.NeoVideoFilterPlayView.JustLogPlayProgressListener
 * JD-Core Version:    0.7.0.1
 */