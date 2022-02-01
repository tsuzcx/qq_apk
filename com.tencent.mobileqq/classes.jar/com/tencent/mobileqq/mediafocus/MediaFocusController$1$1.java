package com.tencent.mobileqq.mediafocus;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Stack;

class MediaFocusController$1$1
  implements EIPCResultCallback
{
  MediaFocusController$1$1(MediaFocusController.1 param1, long paramLong) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool1;
    boolean bool2;
    long l;
    if (paramEIPCResult.data != null)
    {
      bool1 = paramEIPCResult.data.getBoolean("isProcessRunning");
      bool2 = paramEIPCResult.data.getBoolean("isItemExist");
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      if ((!bool1) || (!bool2)) {
        break label75;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MediaFocusController", 2, new Object[] { "notifyFocusChanged not the same process but existed, cost:", Long.valueOf(l) });
      }
    }
    return;
    label75:
    MediaFocusController.a(this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController$1.this$0).pop();
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusController", 2, new Object[] { "notifyFocusChanged isProcessRun:", Boolean.valueOf(bool1), " ,isItmeExist:", Boolean.valueOf(bool2), " ,stack:", Integer.valueOf(MediaFocusController.a(this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController$1.this$0).size()), " ,cost:", Long.valueOf(l) });
    }
    MediaFocusController.a(this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController$1.this$0, this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController$1.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mediafocus.MediaFocusController.1.1
 * JD-Core Version:    0.7.0.1
 */