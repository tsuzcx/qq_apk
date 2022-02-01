package com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.tkd.topicsdk.framework.TLog;
import java.lang.ref.WeakReference;

public class HWVideoRecorder$RecodeHandler
  extends Handler
{
  WeakReference<HWVideoRecorder> jdField_a_of_type_JavaLangRefWeakReference;
  
  HWVideoRecorder$RecodeHandler(HWVideoRecorder paramHWVideoRecorder1, Looper paramLooper, HWVideoRecorder paramHWVideoRecorder2)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHWVideoRecorder2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    HWVideoRecorder localHWVideoRecorder = (HWVideoRecorder)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localHWVideoRecorder == null) {
      TLog.c("HWVideoRecorder", "RecodeHandler.handleMessage: encoder is null");
    }
    do
    {
      return;
      switch (i)
      {
      default: 
        throw new RuntimeException("Unhandled msg what=" + i);
      case 0: 
        if (paramMessage.obj != null)
        {
          HWVideoRecorder.a(localHWVideoRecorder, (HWVideoRecorder.RecordingObj)paramMessage.obj);
          return;
        }
        throw new RuntimeException("bundle == null");
      case 1: 
        HWVideoRecorder.a(localHWVideoRecorder);
        return;
      case 2: 
        if (paramMessage.obj != null)
        {
          paramMessage = (Object[])paramMessage.obj;
          if (paramMessage.length != 5) {
            throw new IllegalArgumentException("args == null || args.length != 6");
          }
          HWVideoRecorder.a(localHWVideoRecorder, ((Integer)paramMessage[0]).intValue(), ((Integer)paramMessage[1]).intValue(), (float[])paramMessage[2], (float[])paramMessage[3], ((Long)paramMessage[4]).longValue());
          return;
        }
        throw new RuntimeException("bundle == null");
      }
    } while (HWVideoRecorder.a(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorder) == null);
    HWVideoRecorder.a(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorder).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder.HWVideoRecorder.RecodeHandler
 * JD-Core Version:    0.7.0.1
 */