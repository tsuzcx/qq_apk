package com.tencent.mobileqq.shortvideo.common;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.shortvideo.mediadevice.Lock;
import com.tencent.qphone.base.util.QLog;

public class TCTimer
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public HandlerThread a;
  private TCTimer.TCTimerCallback jdField_a_of_type_ComTencentMobileqqShortvideoCommonTCTimer$TCTimerCallback;
  private int b;
  private int c;
  
  public TCTimer(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = (1000 / paramInt1);
    this.b = ((int)(paramInt2 / 1000.0F * paramInt1) + 1);
    this.c = 0;
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("shortvideo_Timer");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
  }
  
  private boolean a(Message paramMessage)
  {
    if (Lock.a)
    {
      paramMessage = RMVideoStateMgr.a();
      boolean bool3 = paramMessage.b;
      boolean bool2 = false;
      boolean bool1 = false;
      if (bool3)
      {
        paramMessage.jdField_a_of_type_Double = (System.currentTimeMillis() - paramMessage.jdField_a_of_type_Long);
        if (paramMessage.jdField_a_of_type_Double >= CodecParam.RECORD_MAX_TIME) {
          bool1 = true;
        }
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          if (bool1)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("handleLooperEvent startTime=");
            localStringBuilder.append(paramMessage.jdField_a_of_type_Long);
            localStringBuilder.append(" total=");
            localStringBuilder.append(paramMessage.jdField_a_of_type_Double);
            QLog.d("TCTimer", 2, localStringBuilder.toString());
            bool2 = bool1;
          }
        }
      }
      else if (this.c >= this.b)
      {
        bool2 = true;
      }
      if (bool2) {
        this.c = this.b;
      }
      int i = this.c;
      int j = this.jdField_a_of_type_Int;
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonTCTimer$TCTimerCallback;
      if (paramMessage != null) {
        paramMessage.a(paramMessage, bool2, j * i, i);
      }
      this.c += 1;
    }
    return true;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1398036036);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, this.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(TCTimer.TCTimerCallback paramTCTimerCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonTCTimer$TCTimerCallback = paramTCTimerCallback;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
  }
  
  public void c()
  {
    this.c = 0;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1398036036) {
      return false;
    }
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage(1398036036);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, this.jdField_a_of_type_Int);
    }
    return a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.common.TCTimer
 * JD-Core Version:    0.7.0.1
 */