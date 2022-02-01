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
    if (paramEIPCResult.data != null)
    {
      boolean bool1 = paramEIPCResult.data.getBoolean("isProcessRunning");
      boolean bool2 = paramEIPCResult.data.getBoolean("isItemExist");
      long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      if ((bool1) && (bool2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MediaFocusController", 2, new Object[] { "notifyFocusChanged not the same process but existed, cost:", Long.valueOf(l) });
        }
      }
      else
      {
        MediaFocusController.a(this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController$1.this$0).pop();
        if (QLog.isColorLevel()) {
          QLog.d("MediaFocusController", 2, new Object[] { "notifyFocusChanged isProcessRun:", Boolean.valueOf(bool1), " ,isItmeExist:", Boolean.valueOf(bool2), " ,stack:", Integer.valueOf(MediaFocusController.a(this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController$1.this$0).size()), " ,cost:", Long.valueOf(l) });
        }
        MediaFocusController.a(this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController$1.this$0, this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController$1.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mediafocus.MediaFocusController.1.1
 * JD-Core Version:    0.7.0.1
 */