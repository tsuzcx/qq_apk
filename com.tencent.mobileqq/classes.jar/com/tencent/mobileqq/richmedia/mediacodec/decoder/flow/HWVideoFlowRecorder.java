package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import android.annotation.TargetApi;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWVideoRecorder;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWVideoRecorder.RecodeHandler;

@TargetApi(18)
public class HWVideoFlowRecorder
  extends HWVideoRecorder
{
  @NonNull
  public HWVideoRecorder.RecodeHandler a(Looper paramLooper)
  {
    return new HWVideoRecorder.RecodeHandler(this, paramLooper, this);
  }
  
  public void a(Runnable paramRunnable)
  {
    this.a.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.HWVideoFlowRecorder
 * JD-Core Version:    0.7.0.1
 */