package com.tencent.mobileqq.mediafocus;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;

class MediaFocusController$1
  implements Runnable
{
  MediaFocusController$1(MediaFocusController paramMediaFocusController, MediaFocusStackItem paramMediaFocusStackItem, int paramInt) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    localBundle.putString("processName", this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusStackItem.b());
    localBundle.putParcelable("focusItem", this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusStackItem);
    QIPCClientHelper.getInstance().callServer("MediaFocusModuleServer", "actionCheckItemExist", localBundle, new MediaFocusController.1.1(this, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mediafocus.MediaFocusController.1
 * JD-Core Version:    0.7.0.1
 */