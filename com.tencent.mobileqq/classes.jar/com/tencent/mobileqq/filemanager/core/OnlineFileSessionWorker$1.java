package com.tencent.mobileqq.filemanager.core;

import aoii;
import aokk;
import aoko;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

public class OnlineFileSessionWorker$1
  extends TimerTask
{
  public OnlineFileSessionWorker$1(aokk paramaokk) {}
  
  public void run()
  {
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] state:" + aokk.a(this.this$0).a() + " WaitSenderReplayOnRecvTimer time out!!!!!!!");
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 42, new Object[] { Long.valueOf(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) });
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.1
 * JD-Core Version:    0.7.0.1
 */