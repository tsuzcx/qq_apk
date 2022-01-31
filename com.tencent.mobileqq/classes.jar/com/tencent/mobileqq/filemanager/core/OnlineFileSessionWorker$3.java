package com.tencent.mobileqq.filemanager.core;

import aoii;
import aokk;
import aoko;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class OnlineFileSessionWorker$3
  implements Runnable
{
  public OnlineFileSessionWorker$3(aokk paramaokk, float paramFloat) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return;
      localFileManagerEntity = this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if ((localFileManagerEntity.fProgress < this.a) && (this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null))
      {
        float f = localFileManagerEntity.fProgress + 0.05F;
        if (f > this.a) {}
        for (localFileManagerEntity.fProgress = this.a;; localFileManagerEntity.fProgress = f)
        {
          for (;;)
          {
            this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 16, null, 0, null);
            try
            {
              Thread.sleep(100L);
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
          }
          break;
        }
      }
    } while ((localFileManagerEntity.fProgress < 1.0F) || (this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null));
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + localFileManagerEntity.nSessionId + "] state:" + aokk.a(this.this$0).a() + " make progress. direct pass to 1.0 and notify make done");
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 41, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.3
 * JD-Core Version:    0.7.0.1
 */