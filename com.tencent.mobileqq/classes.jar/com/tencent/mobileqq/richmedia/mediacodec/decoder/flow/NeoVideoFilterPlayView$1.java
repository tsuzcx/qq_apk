package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.concurrent.atomic.AtomicBoolean;

class NeoVideoFilterPlayView$1
  implements Handler.Callback
{
  NeoVideoFilterPlayView$1(NeoVideoFilterPlayView paramNeoVideoFilterPlayView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if (!NeoVideoFilterPlayView.a(this.a))
    {
      this.a.requestRender();
      return true;
    }
    NeoVideoFilterPlayView.a(this.a).set(true);
    SLog.b("FlowEdit_NeoVideoFilterPlayView", "skip request render because of pause play");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.NeoVideoFilterPlayView.1
 * JD-Core Version:    0.7.0.1
 */