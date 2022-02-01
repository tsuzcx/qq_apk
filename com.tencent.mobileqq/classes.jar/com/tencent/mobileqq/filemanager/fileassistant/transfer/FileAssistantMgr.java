package com.tencent.mobileqq.filemanager.fileassistant.transfer;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.data.FileAssistantResultCallbak;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileAssistantMgr
  implements FileAssistantResultCallbak
{
  Handler jdField_a_of_type_AndroidOsHandler;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  List<FileAssistantSender> jdField_a_of_type_JavaUtilList;
  List<FileAssistantRecver> b;
  
  private void b()
  {
    try
    {
      QLog.i("FileAssistantMgrNDL", 1, "----setAllFailed START----");
      Iterator localIterator;
      Object localObject2;
      StringBuilder localStringBuilder;
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (FileAssistantSender)localIterator.next();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("remove sender:");
          localStringBuilder.append(((FileAssistantSender)localObject2).a());
          QLog.i("FileAssistantMgrNDL", 1, localStringBuilder.toString());
          ((FileAssistantSender)localObject2).b();
        }
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      if (this.b != null)
      {
        localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (FileAssistantRecver)localIterator.next();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("remove recver:");
          localStringBuilder.append(((FileAssistantRecver)localObject2).a());
          QLog.i("FileAssistantMgrNDL", 1, localStringBuilder.toString());
          ((FileAssistantRecver)localObject2).a();
        }
        this.b.clear();
      }
      QLog.i("FileAssistantMgrNDL", 1, "----setAllFailed END----");
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public FileManagerEntity a(String paramString, Bundle paramBundle)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      paramString = new FileAssistantSender(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramString);
      paramBundle = paramString.a(paramBundle);
      if (paramBundle != null)
      {
        this.jdField_a_of_type_JavaUtilList.add(paramString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("add new sender :");
        localStringBuilder.append(paramBundle.nSessionId);
        QLog.i("FileAssistantMgrNDL", 1, localStringBuilder.toString());
        paramString.a(false);
      }
      return paramBundle;
    }
    finally {}
  }
  
  public void a()
  {
    b();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = ThreadManagerV2.getUIHandlerV2();
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("retrySend:");
      localStringBuilder.append(paramFileManagerEntity.nSessionId);
      QLog.i("FileAssistantMgrNDL", 1, localStringBuilder.toString());
      paramFileManagerEntity = new FileAssistantSender(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramFileManagerEntity);
      this.jdField_a_of_type_JavaUtilList.add(paramFileManagerEntity);
      paramFileManagerEntity.a(true);
      return;
    }
    finally {}
  }
  
  public void a(FileAssistantRecver paramFileAssistantRecver)
  {
    try
    {
      if (this.b.size() == 0)
      {
        QLog.i("FileAssistantMgrNDL", 1, "mRecvQueue is empty!");
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new FileAssistantMgr.2(this, paramFileAssistantRecver));
      return;
    }
    finally {}
  }
  
  public void a(FileAssistantSender paramFileAssistantSender)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        QLog.i("FileAssistantMgrNDL", 1, "mSendQueue is empty!");
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new FileAssistantMgr.1(this, paramFileAssistantSender));
      return;
    }
    finally {}
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cancelSend : ");
      ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
      QLog.i("FileAssistantMgrNDL", 1, ((StringBuilder)localObject).toString());
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0))
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          FileAssistantSender localFileAssistantSender = (FileAssistantSender)((Iterator)localObject).next();
          if (localFileAssistantSender.a(paramFileManagerEntity.nSessionId))
          {
            localFileAssistantSender.a();
            return true;
          }
        }
        return false;
      }
      QLog.i("FileAssistantMgrNDL", 1, "mSendQueue is null or size is 0");
      return false;
    }
    finally {}
    for (;;)
    {
      throw paramFileManagerEntity;
    }
  }
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    try
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("retryRecv:");
      localStringBuilder.append(paramFileManagerEntity.nSessionId);
      QLog.i("FileAssistantMgrNDL", 1, localStringBuilder.toString());
      paramFileManagerEntity = new FileAssistantRecver(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramFileManagerEntity);
      this.b.add(paramFileManagerEntity);
      paramFileManagerEntity.e();
      return;
    }
    finally {}
  }
  
  public boolean b(FileManagerEntity paramFileManagerEntity)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cancelRecv : ");
      ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
      QLog.i("FileAssistantMgrNDL", 1, ((StringBuilder)localObject).toString());
      if ((this.b != null) && (this.b.size() != 0))
      {
        localObject = this.b.iterator();
        while (((Iterator)localObject).hasNext())
        {
          FileAssistantRecver localFileAssistantRecver = (FileAssistantRecver)((Iterator)localObject).next();
          if (localFileAssistantRecver.a(paramFileManagerEntity.nSessionId))
          {
            localFileAssistantRecver.d();
            return true;
          }
        }
        return false;
      }
      QLog.i("FileAssistantMgrNDL", 1, "mRecvQueue is null or size is 0");
      return false;
    }
    finally {}
    for (;;)
    {
      throw paramFileManagerEntity;
    }
  }
  
  public void c(FileManagerEntity paramFileManagerEntity)
  {
    try
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      Object localObject2 = null;
      Iterator localIterator = this.b.iterator();
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (FileAssistantRecver)localIterator.next();
      } while (!((FileAssistantRecver)localObject1).a(paramFileManagerEntity.nSessionId));
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new FileAssistantRecver(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramFileManagerEntity);
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("add new recver :");
      ((StringBuilder)localObject1).append(paramFileManagerEntity.nSessionId);
      QLog.i("FileAssistantMgrNDL", 1, ((StringBuilder)localObject1).toString());
      this.b.add(localObject2);
      ((FileAssistantRecver)localObject2).c();
      return;
    }
    finally {}
    for (;;)
    {
      throw paramFileManagerEntity;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantMgr
 * JD-Core Version:    0.7.0.1
 */