package com.tencent.mobileqq.filemanager.core;

import addi;
import addj;
import addk;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.DiscFileOperator;
import com.tencent.mobileqq.filemanager.discoperation.IFileHttpBase;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.Utils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class FileManagerRSCenter
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new addi(this);
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  
  public FileManagerRSCenter(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  /* Error */
  public int a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   6: lload 5
    //   8: invokestatic 46	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   11: invokevirtual 50	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: checkcast 52	com/tencent/mobileqq/filemanager/discoperation/IFileHttpBase
    //   17: astore 7
    //   19: aload 7
    //   21: ifnull +17 -> 38
    //   24: aload 7
    //   26: invokeinterface 56 1 0
    //   31: istore 4
    //   33: aload_0
    //   34: monitorexit
    //   35: iload 4
    //   37: ireturn
    //   38: aload_0
    //   39: getfield 27	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   42: invokevirtual 59	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   45: lload_1
    //   46: aload_3
    //   47: iload 4
    //   49: lload 5
    //   51: invokevirtual 64	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:a	(JLjava/lang/String;IJ)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   54: astore_3
    //   55: aload_3
    //   56: ifnonnull +9 -> 65
    //   59: iconst_m1
    //   60: istore 4
    //   62: goto -29 -> 33
    //   65: aload_0
    //   66: getfield 25	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   69: aload_3
    //   70: getfield 70	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   73: invokestatic 46	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   76: invokevirtual 50	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   79: checkcast 52	com/tencent/mobileqq/filemanager/discoperation/IFileHttpBase
    //   82: ifnull +12 -> 94
    //   85: aload_3
    //   86: getfield 74	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   89: istore 4
    //   91: goto -58 -> 33
    //   94: iconst_m1
    //   95: istore 4
    //   97: goto -64 -> 33
    //   100: astore_3
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_3
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	FileManagerRSCenter
    //   0	105	1	paramLong1	long
    //   0	105	3	paramString	String
    //   0	105	4	paramInt	int
    //   0	105	5	paramLong2	long
    //   17	8	7	localIFileHttpBase	IFileHttpBase
    // Exception table:
    //   from	to	target	type
    //   2	19	100	finally
    //   24	33	100	finally
    //   38	55	100	finally
    //   65	91	100	finally
  }
  
  /* Error */
  public long a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 59	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   9: lload 4
    //   11: aload_1
    //   12: iload 6
    //   14: invokevirtual 78	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:a	(JLjava/lang/String;I)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   17: astore 7
    //   19: aload 7
    //   21: ifnull +45 -> 66
    //   24: aload_0
    //   25: getfield 25	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   28: aload 7
    //   30: getfield 70	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   33: invokestatic 46	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   36: invokevirtual 50	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 52	com/tencent/mobileqq/filemanager/discoperation/IFileHttpBase
    //   42: astore 7
    //   44: aload 7
    //   46: ifnull +20 -> 66
    //   49: aload 7
    //   51: invokeinterface 81 1 0
    //   56: istore 6
    //   58: iload 6
    //   60: i2l
    //   61: lstore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: lload_2
    //   65: lreturn
    //   66: aload_0
    //   67: getfield 27	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   70: invokevirtual 59	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   73: aload_1
    //   74: lload_2
    //   75: lload 4
    //   77: iload 6
    //   79: invokevirtual 83	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:a	(Ljava/lang/String;JJI)J
    //   82: lstore_2
    //   83: goto -21 -> 62
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	FileManagerRSCenter
    //   0	91	1	paramString	String
    //   0	91	2	paramLong1	long
    //   0	91	4	paramLong2	long
    //   0	91	6	paramInt	int
    //   17	33	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	86	finally
    //   24	44	86	finally
    //   49	58	86	finally
    //   66	83	86	finally
  }
  
  /* Error */
  public FileManagerEntity a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   6: invokevirtual 87	java/util/LinkedHashMap:size	()I
    //   9: istore_2
    //   10: iload_2
    //   11: iconst_1
    //   12: if_icmpge +9 -> 21
    //   15: aconst_null
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: aload_0
    //   22: getfield 25	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   25: invokevirtual 91	java/util/LinkedHashMap:keySet	()Ljava/util/Set;
    //   28: invokeinterface 97 1 0
    //   33: astore_3
    //   34: aload_3
    //   35: invokeinterface 103 1 0
    //   40: ifeq +53 -> 93
    //   43: aload_3
    //   44: invokeinterface 107 1 0
    //   49: checkcast 42	java/lang/Long
    //   52: astore 4
    //   54: aload_0
    //   55: getfield 25	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   58: aload 4
    //   60: invokevirtual 50	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 52	com/tencent/mobileqq/filemanager/discoperation/IFileHttpBase
    //   66: astore 4
    //   68: aload_1
    //   69: aload 4
    //   71: invokeinterface 110 1 0
    //   76: invokevirtual 116	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   79: ifeq -45 -> 34
    //   82: aload 4
    //   84: invokeinterface 119 1 0
    //   89: astore_1
    //   90: goto -73 -> 17
    //   93: aconst_null
    //   94: astore_1
    //   95: goto -78 -> 17
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	FileManagerRSCenter
    //   0	103	1	paramString	String
    //   9	4	2	i	int
    //   33	11	3	localIterator	Iterator
    //   52	31	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	98	finally
    //   21	34	98	finally
    //   34	90	98	finally
  }
  
  public FileManagerEntity a(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        int i = this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
        if (i < 1)
        {
          paramString1 = null;
          return paramString1;
        }
        if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
          if (localIterator.hasNext())
          {
            Object localObject = (Long)localIterator.next();
            localObject = (IFileHttpBase)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
            FileManagerEntity localFileManagerEntity = ((IFileHttpBase)localObject).a();
            if ((paramString1.equalsIgnoreCase((String)localFileManagerEntity.mContext)) && (paramString2.equals(localFileManagerEntity.zipInnerPath))) {
              paramString1 = ((IFileHttpBase)localObject).a();
            }
          }
          else
          {
            paramString1 = null;
          }
        }
        else
        {
          paramString1 = null;
        }
      }
      finally {}
    }
  }
  
  public void a()
  {
    int i;
    try
    {
      i = Utils.a(BaseApplication.getContext());
      if (i == 1) {
        break label447;
      }
      if (i != 2) {
        break label442;
      }
    }
    finally {}
    int[] arrayOfInt = new int[2];
    long[] arrayOfLong = new long[2];
    String str1 = "";
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    String str4 = "";
    IFileHttpBase localIFileHttpBase;
    label155:
    int j;
    int k;
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      localIFileHttpBase = (IFileHttpBase)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localLong);
      if (localIFileHttpBase == null)
      {
        str4 = str4 + "!!!!runRSWorker error, get worker null!!! sessionID[" + localLong + "]\n";
      }
      else
      {
        if (localIFileHttpBase.a() == 0) {
          break label452;
        }
        if (localIFileHttpBase.a() != 6) {
          break label253;
        }
        break label452;
        if (!localIFileHttpBase.a()) {
          break label357;
        }
        if (arrayOfInt[j] >= i) {
          break label439;
        }
        if (j != 1) {
          break label340;
        }
        k = 0;
      }
    }
    for (;;)
    {
      if ((k >= arrayOfInt[j]) || (arrayOfLong[k] == localIFileHttpBase.a()))
      {
        if (k != arrayOfInt[j]) {
          break label469;
        }
        localIFileHttpBase.g();
        for (;;)
        {
          if (!TextUtils.isEmpty(str4)) {
            QLog.e("FileManagerRSCenter<FileAssistant>", 1, str4);
          }
          if (!TextUtils.isEmpty(str1)) {
            QLog.i("FileManagerRSCenter<FileAssistant>", 1, str1);
          }
          return;
          label253:
          if ((localIFileHttpBase.a() == 1) || (localIFileHttpBase.a() == 8) || (localIFileHttpBase.a() == 5)) {
            break label457;
          }
          str1 = str1 + "type[" + localIFileHttpBase.a() + "] is not processed, maxtype is " + 8 + "\n";
          break;
          label340:
          localIFileHttpBase.g();
        }
        label357:
        if (j == 1) {
          if (arrayOfInt[j] >= 2) {
            String str3 = str2 + "type[" + localIFileHttpBase.a() + "] count is " + arrayOfInt[j] + "\n";
          } else {
            arrayOfLong[arrayOfInt[j]] = localIFileHttpBase.a();
          }
        }
        break label472;
        label439:
        break label469;
        label442:
        i = 2;
        break;
        label447:
        i = 1;
        break;
        label452:
        j = 1;
        break label155;
        label457:
        j = 0;
        break label155;
      }
      k += 1;
    }
    for (;;)
    {
      label469:
      break;
      label472:
      arrayOfInt[j] += 1;
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      IFileHttpBase localIFileHttpBase = (IFileHttpBase)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramLong));
      if (localIFileHttpBase != null) {
        localIFileHttpBase.c();
      }
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerRSCenter<FileAssistant>", 2, "remove worker, sessionId[" + String.valueOf(paramLong) + "]");
      }
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(Long.valueOf(paramLong));
      a();
      return;
    }
    finally {}
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2)
  {
    FileManagerEntity localFileManagerEntity2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong1);
    FileManagerEntity localFileManagerEntity1 = localFileManagerEntity2;
    if (localFileManagerEntity2 == null) {
      localFileManagerEntity1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong2, paramString, paramInt1);
    }
    if (localFileManagerEntity1 == null)
    {
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= v! entity is null ,why you can choose!!!");
      return;
    }
    if ((localFileManagerEntity1.cloudType != 2) && (localFileManagerEntity1.cloudType != 0))
    {
      if (FileUtil.b(localFileManagerEntity1.getFilePath()))
      {
        localFileManagerEntity1.status = 1;
        localFileManagerEntity1.cloudType = 3;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
        QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= v! entity[" + localFileManagerEntity1.nSessionId + "] local existed so notify Success");
        return;
      }
      if ((TextUtils.isEmpty(localFileManagerEntity1.Uuid)) && (!localFileManagerEntity1.isZipInnerFile))
      {
        FileManagerUtil.a(BaseApplicationImpl.getContext().getString(2131428188));
        localFileManagerEntity1.status = 16;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
        QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= v! entity[" + localFileManagerEntity1.nSessionId + "] uuid null, but not Zipfile, set invalid!");
        return;
      }
    }
    if ((localFileManagerEntity1.nFileType == 2) && (!localFileManagerEntity1.isZipInnerFile) && (localFileManagerEntity1.cloudType != 2) && ((localFileManagerEntity1.peerType == 3000) || (localFileManagerEntity1.peerType == 0)))
    {
      localFileManagerEntity1.nOpType = 8;
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= v> entity[" + localFileManagerEntity1.nSessionId + "] is video, start init video sdk");
      FileVideoManager.a(BaseActivity.sTopActivity, new addk(this, localFileManagerEntity1));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
      return;
    }
    localFileManagerEntity1.nOpType = paramInt2;
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(Long.valueOf(paramLong1)) == true)
    {
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= v! entity[" + paramLong1 + "] is processing");
      return;
    }
    b(localFileManagerEntity1);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.bDelInFM == true)
    {
      paramFileManagerEntity.bDelInFM = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
    }
    int i;
    Object localObject;
    if (!FileUtils.b(paramFileManagerEntity.getFilePath()))
    {
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, "nSessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "]file is not exist or empty,path[" + paramFileManagerEntity.getFilePath() + "], please check file!");
      i = 0;
      String str = FileManagerUtil.a();
      if ((paramFileManagerEntity.getFilePath() == null) || (paramFileManagerEntity.getFilePath().length() == 0))
      {
        i = 9005;
        localObject = "filePathNull:" + str;
        switch (paramFileManagerEntity.nOpType)
        {
        }
      }
      for (;;)
      {
        paramFileManagerEntity.status = 16;
        paramFileManagerEntity.fProgress = 1.0F;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
        return;
        if (!FileManagerUtil.b(paramFileManagerEntity.getFilePath()))
        {
          i = 9042;
          localObject = "fileNotExists:" + str;
          break;
        }
        localObject = str;
        if (FileManagerUtil.a(paramFileManagerEntity.getFilePath()) != 0L) {
          break;
        }
        i = 9071;
        localObject = "fileExistsEmpty:" + str;
        break;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.uniseq, paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 15, null, 1, null);
        paramFileManagerEntity.status = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileUp", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, i, "", 0L, 0L, paramFileManagerEntity.fileSize, "", "", 0, (String)localObject, null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileUpDetail", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, i, "", 0L, 0L, paramFileManagerEntity.fileSize, "", "", 0, (String)localObject, null);
        continue;
        paramFileManagerEntity.status = 0;
        paramFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.uniseq, paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 38, null, 1, null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileWyUp", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, i, "", 0L, 0L, paramFileManagerEntity.fileSize, "", "", 0, (String)localObject, null);
      }
    }
    if (paramFileManagerEntity.peerType == 3000) {
      localObject = new DiscFileOperator(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramFileManagerEntity.nSessionId), localObject);
        if (QLog.isColorLevel()) {
          QLog.d("FileManagerRSCenter<FileAssistant>", 2, "Add a New Send Work!, sessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "]");
        }
        a();
        return;
      }
      finally {}
      localObject = (ShieldMsgManger)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15);
      if ((localObject != null) && (((ShieldMsgManger)localObject).a(paramFileManagerEntity.peerUin)))
      {
        paramFileManagerEntity.isReaded = false;
        if (paramFileManagerEntity.status != 16) {}
        for (i = 0;; i = 16)
        {
          paramFileManagerEntity.status = i;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
          QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= ! Id[" + paramFileManagerEntity.nSessionId + "] frend in blacklist!");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.uniseq, paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 15, null, -1, "该好友已被屏蔽！请先解除屏蔽！");
          return;
        }
      }
      if (paramFileManagerEntity.nOpType == 0) {
        localObject = new OfflineSendWorker(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);
      } else {
        localObject = new FileManagerRSWorker(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 0;
    Object localObject2;
    try
    {
      int j = this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
      if (j < 1) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localObject2 = this.jdField_a_of_type_JavaUtilLinkedHashMap.values().iterator();
      while (((Iterator)localObject2).hasNext()) {
        localArrayList.add(0, (IFileHttpBase)((Iterator)localObject2).next());
      }
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    }
    finally {}
    Iterator localIterator = localObject1.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject2 = (IFileHttpBase)localIterator.next();
        ((IFileHttpBase)localObject2).d();
        if (!paramBoolean)
        {
          ((IFileHttpBase)localObject2).e();
        }
        else
        {
          ((IFileHttpBase)localObject2).a(null, 0);
          i = 1;
        }
      }
      else
      {
        if ((paramBoolean) && (i == 0)) {
          FileManagerUtil.a(BaseApplicationImpl.getContext().getString(2131428193));
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
        break;
      }
    }
  }
  
  /* Error */
  public boolean a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   6: lload_1
    //   7: invokestatic 46	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   10: invokevirtual 50	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast 52	com/tencent/mobileqq/filemanager/discoperation/IFileHttpBase
    //   16: astore 4
    //   18: aload 4
    //   20: ifnull +26 -> 46
    //   23: aload 4
    //   25: invokeinterface 432 1 0
    //   30: aload_0
    //   31: getfield 25	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   34: lload_1
    //   35: invokestatic 46	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   38: invokevirtual 219	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   41: pop
    //   42: aload_0
    //   43: invokevirtual 221	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:a	()V
    //   46: aload_0
    //   47: getfield 27	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   50: invokevirtual 59	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   53: lload_1
    //   54: invokevirtual 225	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:a	(J)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   57: astore 4
    //   59: aload 4
    //   61: ifnull +60 -> 121
    //   64: aload 4
    //   66: getfield 275	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nFileType	I
    //   69: iconst_2
    //   70: if_icmpne +51 -> 121
    //   73: aload 4
    //   75: getfield 70	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   78: invokestatic 434	com/tencent/mobileqq/filemanager/core/FileVideoManager:a	(J)V
    //   81: aload 4
    //   83: getfield 74	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   86: iconst_2
    //   87: if_icmpne +9 -> 96
    //   90: aload 4
    //   92: iconst_3
    //   93: putfield 74	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   96: aload_0
    //   97: getfield 27	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   100: invokevirtual 59	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   103: aload 4
    //   105: invokevirtual 240	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:c	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)V
    //   108: aload_0
    //   109: getfield 27	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   112: invokevirtual 32	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter;
    //   115: iconst_1
    //   116: iconst_0
    //   117: aconst_null
    //   118: invokevirtual 243	com/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter:a	(ZILjava/lang/Object;)V
    //   121: aload 4
    //   123: ifnull +36 -> 159
    //   126: aload 4
    //   128: getfield 74	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   131: iconst_2
    //   132: if_icmpne +27 -> 159
    //   135: aload 4
    //   137: iconst_3
    //   138: putfield 74	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   141: aload_0
    //   142: getfield 27	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   145: invokevirtual 59	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   148: aload 4
    //   150: invokevirtual 240	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:c	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)V
    //   153: iconst_1
    //   154: istore_3
    //   155: aload_0
    //   156: monitorexit
    //   157: iload_3
    //   158: ireturn
    //   159: iconst_0
    //   160: istore_3
    //   161: goto -6 -> 155
    //   164: astore 4
    //   166: aload_0
    //   167: monitorexit
    //   168: aload 4
    //   170: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	FileManagerRSCenter
    //   0	171	1	paramLong	long
    //   154	7	3	bool	boolean
    //   16	133	4	localObject1	Object
    //   164	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	164	finally
    //   23	46	164	finally
    //   46	59	164	finally
    //   64	96	164	finally
    //   96	121	164	finally
    //   126	153	164	finally
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   6: invokevirtual 87	java/util/LinkedHashMap:size	()I
    //   9: istore_2
    //   10: iload_2
    //   11: iconst_1
    //   12: if_icmpge +9 -> 21
    //   15: iconst_0
    //   16: istore_3
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_3
    //   20: ireturn
    //   21: aload_0
    //   22: getfield 25	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   25: invokevirtual 91	java/util/LinkedHashMap:keySet	()Ljava/util/Set;
    //   28: invokeinterface 97 1 0
    //   33: astore 4
    //   35: aload 4
    //   37: invokeinterface 103 1 0
    //   42: ifeq +61 -> 103
    //   45: aload 4
    //   47: invokeinterface 107 1 0
    //   52: checkcast 42	java/lang/Long
    //   55: astore 5
    //   57: aload_0
    //   58: getfield 25	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   61: aload 5
    //   63: invokevirtual 50	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   66: checkcast 52	com/tencent/mobileqq/filemanager/discoperation/IFileHttpBase
    //   69: invokeinterface 119 1 0
    //   74: astore 5
    //   76: aload 5
    //   78: getfield 437	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFilePath	Ljava/lang/String;
    //   81: ifnull -46 -> 35
    //   84: aload 5
    //   86: getfield 437	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFilePath	Ljava/lang/String;
    //   89: aload_1
    //   90: invokevirtual 116	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   93: istore_3
    //   94: iload_3
    //   95: ifeq -60 -> 35
    //   98: iconst_1
    //   99: istore_3
    //   100: goto -83 -> 17
    //   103: iconst_0
    //   104: istore_3
    //   105: goto -88 -> 17
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	FileManagerRSCenter
    //   0	113	1	paramString	String
    //   9	4	2	i	int
    //   16	89	3	bool	boolean
    //   33	13	4	localIterator	Iterator
    //   55	30	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	108	finally
    //   21	35	108	finally
    //   35	94	108	finally
  }
  
  /* Error */
  public boolean a(String paramString, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 59	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   9: lload_2
    //   10: aload_1
    //   11: iload 4
    //   13: ldc2_w 439
    //   16: invokevirtual 64	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:a	(JLjava/lang/String;IJ)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   19: astore_1
    //   20: aload_1
    //   21: ifnonnull +11 -> 32
    //   24: iconst_0
    //   25: istore 5
    //   27: aload_0
    //   28: monitorexit
    //   29: iload 5
    //   31: ireturn
    //   32: aload_0
    //   33: aload_1
    //   34: getfield 70	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   37: invokevirtual 442	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:a	(J)Z
    //   40: istore 5
    //   42: goto -15 -> 27
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	FileManagerRSCenter
    //   0	50	1	paramString	String
    //   0	50	2	paramLong	long
    //   0	50	4	paramInt	int
    //   25	16	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	20	45	finally
    //   32	42	45	finally
  }
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.bDelInFM == true)
    {
      paramFileManagerEntity.bDelInFM = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
    }
    if ((paramFileManagerEntity.nFileType == 2) && (!paramFileManagerEntity.isZipInnerFile) && (paramFileManagerEntity.cloudType != 2))
    {
      FileVideoManager.a(BaseActivity.sTopActivity, new addj(this, paramFileManagerEntity));
      return;
    }
    FileManagerRSWorker localFileManagerRSWorker = new FileManagerRSWorker(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);
    try
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramFileManagerEntity.nSessionId), localFileManagerRSWorker);
      QLog.i("FileManagerRSCenter<FileAssistant>", 1, "=_= v> entity[" + paramFileManagerEntity.nSessionId + "] is add to download list");
      a();
      return;
    }
    finally {}
  }
  
  public void c(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    for (;;)
    {
      try
      {
        QLog.e("FileManagerRSCenter<FileAssistant>", 1, "entry is null, retry ge mao!");
        return;
      }
      finally {}
      IFileHttpBase localIFileHttpBase = (IFileHttpBase)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramFileManagerEntity.nSessionId));
      if ((localIFileHttpBase == null) || (localIFileHttpBase.a())) {
        break;
      }
      QLog.i("FileManagerRSCenter<FileAssistant>", 1, "uniseq[ " + String.valueOf(paramFileManagerEntity.uniseq) + " ],sessionid[ " + String.valueOf(paramFileManagerEntity.nSessionId) + " ] work,is procressing!");
    }
    switch (paramFileManagerEntity.nOpType)
    {
    }
    for (;;)
    {
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, "Unknow actionType!");
      break;
      a(paramFileManagerEntity);
      break;
      b(paramFileManagerEntity);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSCenter
 * JD-Core Version:    0.7.0.1
 */