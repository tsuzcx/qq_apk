package com.tencent.mobileqq.richmedia.mediacodec.recorder;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class HWVideoRecorder$RecodeHandler
  extends Handler
{
  protected WeakReference<HWVideoRecorder> a;
  
  public HWVideoRecorder$RecodeHandler(HWVideoRecorder paramHWVideoRecorder1, Looper paramLooper, HWVideoRecorder paramHWVideoRecorder2)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHWVideoRecorder2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    HWVideoRecorder localHWVideoRecorder = (HWVideoRecorder)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localHWVideoRecorder == null) {
      if (QLog.isColorLevel()) {
        QLog.w("HWVideoRecorder", 2, "RecodeHandler.handleMessage: encoder is null");
      }
    }
    label187:
    do
    {
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
          if ((HWVideoRecorder.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder)) || (HWVideoRecorder.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder) == null) || (!HWVideoRecorder.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder).a)) {
            break label187;
          }
          sendEmptyMessageDelayed(1, 100L);
        }
      } while ((!QLog.isColorLevel()) || (!QLog.isColorLevel()));
      QLog.d("HWVideoRecorder", 2, "Thumbnail is not ready. Wait 100ms and retry.");
      return;
      HWVideoRecorder.a(localHWVideoRecorder);
      return;
      if (paramMessage.obj != null)
      {
        paramMessage = (Object[])paramMessage.obj;
        if ((paramMessage == null) || (paramMessage.length != 5)) {
          throw new IllegalArgumentException("args == null || args.length != 6");
        }
        localHWVideoRecorder.b(((Integer)paramMessage[0]).intValue(), ((Integer)paramMessage[1]).intValue(), (float[])paramMessage[2], (float[])paramMessage[3], ((Long)paramMessage[4]).longValue());
        return;
      }
      throw new RuntimeException("bundle == null");
    } while (HWVideoRecorder.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder) == null);
    HWVideoRecorder.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.recorder.HWVideoRecorder.RecodeHandler
 * JD-Core Version:    0.7.0.1
 */