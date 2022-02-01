package com.tencent.mobileqq.filemanager.core;

import com.tencent.qphone.base.util.QLog;
import java.util.Timer;

class OnlineFileSessionCenter$UploadProgressMakeEvtPump
{
  private Timer jdField_a_of_type_JavaUtilTimer = null;
  
  private OnlineFileSessionCenter$UploadProgressMakeEvtPump(OnlineFileSessionCenter paramOnlineFileSessionCenter) {}
  
  void a()
  {
    try
    {
      Timer localTimer = this.jdField_a_of_type_JavaUtilTimer;
      if (localTimer != null) {
        return;
      }
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(new OnlineFileSessionCenter.UploadProgressMakeEvtPump.1(this), 1000L, 1000L);
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[]  progress make  start. . .");
      return;
    }
    finally {}
  }
  
  void b()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[]  progress make  exit. . .");
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter.UploadProgressMakeEvtPump
 * JD-Core Version:    0.7.0.1
 */