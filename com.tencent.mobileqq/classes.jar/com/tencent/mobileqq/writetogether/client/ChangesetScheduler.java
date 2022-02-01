package com.tencent.mobileqq.writetogether.client;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.util.MqqWeakReferenceHandler;
import mqq.os.MqqHandler;

public class ChangesetScheduler
  implements Handler.Callback, IScheduler
{
  private ISchedulerCallback jdField_a_of_type_ComTencentMobileqqWritetogetherClientISchedulerCallback;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(paramInt1)) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(paramInt1, paramInt2);
    }
  }
  
  public void a(ISchedulerCallback paramISchedulerCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientISchedulerCallback = paramISchedulerCallback;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    ISchedulerCallback localISchedulerCallback = this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientISchedulerCallback;
    if (localISchedulerCallback != null) {
      return localISchedulerCallback.a(paramMessage.what);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.client.ChangesetScheduler
 * JD-Core Version:    0.7.0.1
 */