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
    Object localObject2;
    try
    {
      QLog.i("FileAssistantMgrNDL", 1, "----setAllFailed START----");
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator1.hasNext())
        {
          localObject2 = (FileAssistantSender)localIterator1.next();
          QLog.i("FileAssistantMgrNDL", 1, "remove sender:" + ((FileAssistantSender)localObject2).a());
          ((FileAssistantSender)localObject2).b();
        }
        this.jdField_a_of_type_JavaUtilList.clear();
      }
    }
    finally {}
    if (this.b != null)
    {
      Iterator localIterator2 = this.b.iterator();
      while (localIterator2.hasNext())
      {
        localObject2 = (FileAssistantRecver)localIterator2.next();
        QLog.i("FileAssistantMgrNDL", 1, "remove recver:" + ((FileAssistantRecver)localObject2).a());
        ((FileAssistantRecver)localObject2).a();
      }
      this.b.clear();
    }
    QLog.i("FileAssistantMgrNDL", 1, "----setAllFailed END----");
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
        QLog.i("FileAssistantMgrNDL", 1, "add new sender :" + paramBundle.nSessionId);
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
      QLog.i("FileAssistantMgrNDL", 1, "retrySend:" + paramFileManagerEntity.nSessionId);
      paramFileManagerEntity = new FileAssistantSender(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramFileManagerEntity);
      this.jdField_a_of_type_JavaUtilList.add(paramFileManagerEntity);
      paramFileManagerEntity.a(true);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(FileAssistantRecver paramFileAssistantRecver)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 74	com/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantMgr:b	Ljava/util/List;
    //   6: invokeinterface 131 1 0
    //   11: ifne +14 -> 25
    //   14: ldc 20
    //   16: iconst_1
    //   17: ldc 133
    //   19: invokestatic 28	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield 120	com/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantMgr:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   29: new 135	com/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantMgr$2
    //   32: dup
    //   33: aload_0
    //   34: aload_1
    //   35: invokespecial 138	com/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantMgr$2:<init>	(Lcom/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantMgr;Lcom/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantRecver;)V
    //   38: invokevirtual 144	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   41: pop
    //   42: goto -20 -> 22
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	FileAssistantMgr
    //   0	50	1	paramFileAssistantRecver	FileAssistantRecver
    // Exception table:
    //   from	to	target	type
    //   2	22	45	finally
    //   25	42	45	finally
  }
  
  /* Error */
  public void a(FileAssistantSender paramFileAssistantSender)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	com/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantMgr:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: invokeinterface 131 1 0
    //   11: ifne +14 -> 25
    //   14: ldc 20
    //   16: iconst_1
    //   17: ldc 147
    //   19: invokestatic 28	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield 120	com/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantMgr:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   29: new 149	com/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantMgr$1
    //   32: dup
    //   33: aload_0
    //   34: aload_1
    //   35: invokespecial 152	com/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantMgr$1:<init>	(Lcom/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantMgr;Lcom/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantSender;)V
    //   38: invokevirtual 144	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   41: pop
    //   42: goto -20 -> 22
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	FileAssistantMgr
    //   0	50	1	paramFileAssistantSender	FileAssistantSender
    // Exception table:
    //   from	to	target	type
    //   2	22	45	finally
    //   25	42	45	finally
  }
  
  /* Error */
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 20
    //   4: iconst_1
    //   5: new 50	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   12: ldc 155
    //   14: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_1
    //   18: getfield 107	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   21: invokevirtual 63	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   24: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 28	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: aload_0
    //   31: getfield 30	com/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantMgr:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   34: ifnull +15 -> 49
    //   37: aload_0
    //   38: getfield 30	com/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantMgr:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   41: invokeinterface 131 1 0
    //   46: ifne +17 -> 63
    //   49: ldc 20
    //   51: iconst_1
    //   52: ldc 157
    //   54: invokestatic 28	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iconst_0
    //   58: istore_2
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_2
    //   62: ireturn
    //   63: aload_0
    //   64: getfield 30	com/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantMgr:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   67: invokeinterface 36 1 0
    //   72: astore_3
    //   73: aload_3
    //   74: invokeinterface 42 1 0
    //   79: ifeq +36 -> 115
    //   82: aload_3
    //   83: invokeinterface 46 1 0
    //   88: checkcast 48	com/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantSender
    //   91: astore 4
    //   93: aload 4
    //   95: aload_1
    //   96: getfield 107	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   99: invokevirtual 160	com/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantSender:a	(J)Z
    //   102: ifeq -29 -> 73
    //   105: aload 4
    //   107: invokevirtual 161	com/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantSender:a	()V
    //   110: iconst_1
    //   111: istore_2
    //   112: goto -53 -> 59
    //   115: iconst_0
    //   116: istore_2
    //   117: goto -58 -> 59
    //   120: astore_1
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_1
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	FileAssistantMgr
    //   0	125	1	paramFileManagerEntity	FileManagerEntity
    //   58	59	2	bool	boolean
    //   72	11	3	localIterator	Iterator
    //   91	15	4	localFileAssistantSender	FileAssistantSender
    // Exception table:
    //   from	to	target	type
    //   2	49	120	finally
    //   49	57	120	finally
    //   63	73	120	finally
    //   73	110	120	finally
  }
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    try
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      QLog.i("FileAssistantMgrNDL", 1, "retryRecv:" + paramFileManagerEntity.nSessionId);
      paramFileManagerEntity = new FileAssistantRecver(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramFileManagerEntity);
      this.b.add(paramFileManagerEntity);
      paramFileManagerEntity.e();
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean b(FileManagerEntity paramFileManagerEntity)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 20
    //   4: iconst_1
    //   5: new 50	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   12: ldc 169
    //   14: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_1
    //   18: getfield 107	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   21: invokevirtual 63	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   24: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 28	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: aload_0
    //   31: getfield 74	com/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantMgr:b	Ljava/util/List;
    //   34: ifnull +15 -> 49
    //   37: aload_0
    //   38: getfield 74	com/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantMgr:b	Ljava/util/List;
    //   41: invokeinterface 131 1 0
    //   46: ifne +17 -> 63
    //   49: ldc 20
    //   51: iconst_1
    //   52: ldc 171
    //   54: invokestatic 28	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iconst_0
    //   58: istore_2
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_2
    //   62: ireturn
    //   63: aload_0
    //   64: getfield 74	com/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantMgr:b	Ljava/util/List;
    //   67: invokeinterface 36 1 0
    //   72: astore_3
    //   73: aload_3
    //   74: invokeinterface 42 1 0
    //   79: ifeq +36 -> 115
    //   82: aload_3
    //   83: invokeinterface 46 1 0
    //   88: checkcast 76	com/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantRecver
    //   91: astore 4
    //   93: aload 4
    //   95: aload_1
    //   96: getfield 107	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   99: invokevirtual 172	com/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantRecver:a	(J)Z
    //   102: ifeq -29 -> 73
    //   105: aload 4
    //   107: invokevirtual 175	com/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantRecver:d	()V
    //   110: iconst_1
    //   111: istore_2
    //   112: goto -53 -> 59
    //   115: iconst_0
    //   116: istore_2
    //   117: goto -58 -> 59
    //   120: astore_1
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_1
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	FileAssistantMgr
    //   0	125	1	paramFileManagerEntity	FileManagerEntity
    //   58	59	2	bool	boolean
    //   72	11	3	localIterator	Iterator
    //   91	15	4	localFileAssistantRecver	FileAssistantRecver
    // Exception table:
    //   from	to	target	type
    //   2	49	120	finally
    //   49	57	120	finally
    //   63	73	120	finally
    //   73	110	120	finally
  }
  
  public void c(FileManagerEntity paramFileManagerEntity)
  {
    for (;;)
    {
      try
      {
        if (this.b == null) {
          this.b = new ArrayList();
        }
        Object localObject = this.b.iterator();
        if (((Iterator)localObject).hasNext())
        {
          localFileAssistantRecver = (FileAssistantRecver)((Iterator)localObject).next();
          if (!localFileAssistantRecver.a(paramFileManagerEntity.nSessionId)) {
            continue;
          }
          localObject = localFileAssistantRecver;
          if (localFileAssistantRecver == null) {
            localObject = new FileAssistantRecver(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramFileManagerEntity);
          }
          QLog.i("FileAssistantMgrNDL", 1, "add new recver :" + paramFileManagerEntity.nSessionId);
          this.b.add(localObject);
          ((FileAssistantRecver)localObject).c();
          return;
        }
      }
      finally {}
      FileAssistantRecver localFileAssistantRecver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantMgr
 * JD-Core Version:    0.7.0.1
 */