package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

class FileManagerNotifyCenter$2
  implements Runnable
{
  FileManagerNotifyCenter$2(FileManagerNotifyCenter paramFileManagerNotifyCenter, FileManagerEntity paramFileManagerEntity, int paramInt) {}
  
  public void run()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mContext;
    Object localObject1 = Boolean.valueOf(true);
    if ((localObject2 != null) && ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mContext instanceof String)) && ("DeceptiveProgressed".equalsIgnoreCase((String)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mContext)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("id:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      ((StringBuilder)localObject1).append(" DeceptiveProgressed return");
      QLog.i("FileManagerNotifyCenter<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("id:");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    ((StringBuilder)localObject2).append(" do DeceptiveProgress");
    QLog.i("Bug", 1, ((StringBuilder)localObject2).toString());
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    ((FileManagerEntity)localObject2).status = 2;
    ((FileManagerEntity)localObject2).fProgress = 0.0F;
    this.this$0.a(((FileManagerEntity)localObject2).uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 14, null);
    do
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress >= 0.95F)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 1.0F;
      }
      else
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
        double d = ((FileManagerEntity)localObject2).fProgress;
        Double.isNaN(d);
        ((FileManagerEntity)localObject2).fProgress = ((float)(d + 0.05D));
      }
      this.this$0.a.getFileManagerNotifyCenter().a(true, 3, null);
      try
      {
        Thread.sleep(50L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress < 1.0F);
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    ((FileManagerEntity)localObject3).fProgress = 1.0F;
    ((FileManagerEntity)localObject3).fProgress = 0.0F;
    ((FileManagerEntity)localObject3).status = 1;
    ((FileManagerEntity)localObject3).mContext = new String("DeceptiveProgressed");
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("id:");
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    ((StringBuilder)localObject3).append(" set DeceptiveProgressed");
    QLog.i("FileManagerNotifyCenter<FileAssistant>", 1, ((StringBuilder)localObject3).toString());
    int i = this.jdField_a_of_type_Int;
    if (i != 5)
    {
      if (i != 6) {
        if (i != 7)
        {
          if (i != 8)
          {
            if (i != 10)
            {
              if ((i != 63) && (i != 64)) {
                break label897;
              }
            }
            else
            {
              this.this$0.a.getFileManagerNotifyCenter().a(true, 53, new Object[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid });
              this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 14, new Object[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize), localObject1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath }, 0, null);
              break label897;
            }
          }
          else
          {
            this.this$0.a.getFileManagerNotifyCenter().a(true, 33, new Object[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid });
            this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 14, new Object[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize), localObject1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath }, 0, null);
            break label897;
          }
        }
        else
        {
          this.this$0.a.getFileManagerNotifyCenter().a(true, 34, new Object[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) });
          break label897;
        }
      }
      this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 14, new Object[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize), localObject1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath }, 0, null);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      ((FileManagerEntity)localObject3).status = 1;
      this.this$0.a(((FileManagerEntity)localObject3).uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 14, new Object[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize), localObject1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath }, 0, null);
    }
    label897:
    this.this$0.a.getFileManagerNotifyCenter().a(true, 3, null);
    FileManagerUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime = MessageCache.a();
    this.this$0.a.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter.2
 * JD-Core Version:    0.7.0.1
 */