package com.tencent.mobileqq.unifiedebug;

import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class SnapshotService$2
  implements Runnable
{
  SnapshotService$2(SnapshotService paramSnapshotService, Bitmap paramBitmap, SnapshotService.DebugCommand paramDebugCommand, SnapshotService.Snapshot paramSnapshot) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(SnapshotService.a(), 2, "ScreenShot Finish Callback");
    }
    SnapshotService.a(this.this$0, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$DebugCommand, this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot);
    this.this$0.a.post(new SnapshotService.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.SnapshotService.2
 * JD-Core Version:    0.7.0.1
 */