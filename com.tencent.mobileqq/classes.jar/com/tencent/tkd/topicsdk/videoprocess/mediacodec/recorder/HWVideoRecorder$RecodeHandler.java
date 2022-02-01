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
    if (localHWVideoRecorder == null)
    {
      TLog.c("HWVideoRecorder", "RecodeHandler.handleMessage: encoder is null");
      return;
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            if (HWVideoRecorder.a(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorder) != null) {
              HWVideoRecorder.a(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorder).a();
            }
          }
          else
          {
            paramMessage = new StringBuilder();
            paramMessage.append("Unhandled msg what=");
            paramMessage.append(i);
            throw new RuntimeException(paramMessage.toString());
          }
        }
        else
        {
          if (paramMessage.obj != null)
          {
            paramMessage = (Object[])paramMessage.obj;
            if (paramMessage.length == 5)
            {
              HWVideoRecorder.a(localHWVideoRecorder, ((Integer)paramMessage[0]).intValue(), ((Integer)paramMessage[1]).intValue(), (float[])paramMessage[2], (float[])paramMessage[3], ((Long)paramMessage[4]).longValue());
              return;
            }
            throw new IllegalArgumentException("args == null || args.length != 6");
          }
          throw new RuntimeException("bundle == null");
        }
      }
      else {
        HWVideoRecorder.a(localHWVideoRecorder);
      }
    }
    else
    {
      if (paramMessage.obj == null) {
        break label221;
      }
      HWVideoRecorder.a(localHWVideoRecorder, (HWVideoRecorder.RecordingObj)paramMessage.obj);
    }
    return;
    label221:
    throw new RuntimeException("bundle == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder.HWVideoRecorder.RecodeHandler
 * JD-Core Version:    0.7.0.1
 */