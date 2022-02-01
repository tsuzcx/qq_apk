package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.HWDecodeListener;

class VideoFlowDecodeWrapper$1
  implements HWDecodeListener
{
  VideoFlowDecodeWrapper$1(VideoFlowDecodeWrapper paramVideoFlowDecodeWrapper) {}
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    SLog.d("FlowEdit_VideoFlowDecodeWrapper", paramThrowable, "onDecodeError: %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void a(long paramLong) {}
  
  public void b(long paramLong)
  {
    SLog.a("FlowEdit_VideoFlowDecodeWrapper", "onDecodeSeekTo: %d", Long.valueOf(paramLong));
  }
  
  public void g()
  {
    SLog.b("FlowEdit_VideoFlowDecodeWrapper", "onDecodeStart: ");
  }
  
  public void j()
  {
    SLog.b("FlowEdit_VideoFlowDecodeWrapper", "onDecodeFinish: ");
  }
  
  public void k()
  {
    SLog.b("FlowEdit_VideoFlowDecodeWrapper", "onDecodeCancel: ");
  }
  
  public void l()
  {
    SLog.b("FlowEdit_VideoFlowDecodeWrapper", "onDecodeRepeat: ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.VideoFlowDecodeWrapper.1
 * JD-Core Version:    0.7.0.1
 */