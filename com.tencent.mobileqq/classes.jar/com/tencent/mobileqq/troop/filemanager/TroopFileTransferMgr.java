package com.tencent.mobileqq.troop.filemanager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.FileDownloadMgrObserver;
import com.tencent.mobileqq.troop.filemanager.forward.TroopFileMultiForwarder;
import com.tencent.mobileqq.troop.filemanager.forward.TroopFileToTroopForwarder;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.FileUploadMgrObserver;
import com.tencent.mobileqq.troop.utils.TroopFileError.SimpleErrorInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TroopFileTransferMgr
  extends TroopFileTransferManager
{
  private static Handler jdField_a_of_type_AndroidOsHandler;
  protected int a;
  protected TroopFileDownloadMgr.FileDownloadMgrObserver a;
  protected TroopFileUploadMgr.FileUploadMgrObserver a;
  protected int b;
  
  static
  {
    if (!TroopFileTransferMgr.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public TroopFileTransferMgr(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.e = paramLong;
  }
  
  public static void a(Runnable paramRunnable, boolean paramBoolean)
  {
    if (jdField_a_of_type_AndroidOsHandler == null) {}
    try
    {
      jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
      if ((paramBoolean) || (Thread.currentThread() != jdField_a_of_type_AndroidOsHandler.getLooper().getThread()))
      {
        jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
        return;
      }
    }
    finally {}
    paramRunnable.run();
  }
  
  public int a(FileManagerEntity paramFileManagerEntity)
  {
    for (;;)
    {
      TroopFileInfo localTroopFileInfo;
      TroopFileTransferManager.Item localItem;
      synchronized (a()) {}
      int i = 0;
    }
  }
  
  public TroopFileStatusInfo a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, int paramInt1, int paramInt2, long paramLong3)
  {
    synchronized (a()) {}
    try
    {
      paramString2 = ???.a(paramString2, paramLong2, 102);
      if (paramString2 == null) {
        return null;
      }
      c();
      paramString2 = new TroopFileTransferManager.Item(paramString2);
      paramString2.RandomNum = paramInt2;
      paramString2.ForwardPath = paramString1;
      paramString2.ForwardTroopuin = paramLong1;
      paramString2.ForwardBusId = paramInt1;
      paramString2.Status = 4;
      paramString2.LocalFile = paramString3;
      paramString2.entrySessionID = paramLong3;
      paramString1 = (MessageForTroopFile)FileOperaterUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade(), String.valueOf(paramLong1), 1, paramString1);
      if (paramString1 != null)
      {
        paramString2.width = paramString1.width;
        paramString2.height = paramString1.height;
        paramString2.yybApkPackageName = paramString1.yybApkPackageName;
        paramString2.yybApkName = paramString1.yybApkName;
        paramString2.yybApkIconUrl = paramString1.yybApkIconUrl;
      }
      paramString3 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong1);
      if ((paramString3 != null) && (paramString1 != null) && (!TextUtils.isEmpty(paramString1.uuid)))
      {
        paramString1 = paramString3.a(UUID.fromString(paramString1.uuid));
        if (paramString1 != null)
        {
          paramString2.largeThumbnailFile = paramString1.largeThumbnailFile;
          paramString2.middleThumbnailFile = paramString1.middleThumbnailFile;
        }
      }
      a(paramString2);
      paramString1 = TroopFileToTroopForwarder.a(this.e, paramString2);
      if (paramString1 == null)
      {
        return null;
        paramString1 = finally;
        throw paramString1;
      }
      paramString1.a();
      paramString1 = paramString2.getInfo(this.e);
      return paramString1;
    }
    finally {}
  }
  
  /* Error */
  public TroopFileStatusInfo a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 83	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:a	()Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   4: astore 8
    //   6: aload 8
    //   8: monitorenter
    //   9: aload_0
    //   10: monitorenter
    //   11: aload 8
    //   13: aload_1
    //   14: aload_2
    //   15: lload_3
    //   16: iload 5
    //   18: invokevirtual 103	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/lang/String;Ljava/lang/String;JI)Lcom/tencent/mobileqq/troop/data/TroopFileInfo;
    //   21: astore 9
    //   23: aload 9
    //   25: ifnonnull +10 -> 35
    //   28: aload_0
    //   29: monitorexit
    //   30: aload 8
    //   32: monitorexit
    //   33: aconst_null
    //   34: areturn
    //   35: aload_0
    //   36: invokevirtual 119	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:c	()V
    //   39: iconst_0
    //   40: istore 6
    //   42: aload_0
    //   43: getfield 122	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   46: aload 9
    //   48: getfield 117	com/tencent/mobileqq/troop/data/TroopFileInfo:a	Ljava/util/UUID;
    //   51: invokeinterface 128 2 0
    //   56: checkcast 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   59: astore 7
    //   61: aload 7
    //   63: ifnonnull +175 -> 238
    //   66: new 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   69: dup
    //   70: aload 9
    //   72: invokespecial 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lcom/tencent/mobileqq/troop/data/TroopFileInfo;)V
    //   75: astore_1
    //   76: iconst_1
    //   77: istore 5
    //   79: aload_1
    //   80: aload_2
    //   81: putfield 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   84: aload_1
    //   85: lload_3
    //   86: putfield 139	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   89: aload_1
    //   90: lconst_0
    //   91: putfield 142	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   94: iload 5
    //   96: ifeq +8 -> 104
    //   99: aload_0
    //   100: aload_1
    //   101: invokevirtual 163	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   104: aload_1
    //   105: getfield 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   108: invokestatic 315	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)I
    //   111: iconst_2
    //   112: if_icmpne +206 -> 318
    //   115: aload_0
    //   116: getfield 33	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   119: invokestatic 320	com/tencent/mobileqq/filemanager/util/QFileUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   122: ifeq +196 -> 318
    //   125: aload_1
    //   126: aload_0
    //   127: getfield 37	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:e	J
    //   130: invokevirtual 309	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;
    //   133: astore 7
    //   135: new 322	com/tencent/mobileqq/filemanager/fileviewer/data/VideoForTroop
    //   138: dup
    //   139: aload_0
    //   140: getfield 33	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   143: aload 7
    //   145: invokespecial 325	com/tencent/mobileqq/filemanager/fileviewer/data/VideoForTroop:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;)V
    //   148: invokestatic 330	com/tencent/mobileqq/filemanager/core/FileVideoDownloadManager:a	(Lcom/tencent/mobileqq/filemanager/fileviewer/data/BaseVideoBiz;)Lcom/tencent/mobileqq/filemanager/core/IFileVideoDownloader;
    //   151: invokeinterface 334 1 0
    //   156: pop
    //   157: aload_2
    //   158: invokestatic 339	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   161: astore_2
    //   162: aload_0
    //   163: getfield 33	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   166: ldc_w 341
    //   169: ldc_w 343
    //   172: ldc_w 343
    //   175: ldc_w 345
    //   178: ldc_w 347
    //   181: iconst_0
    //   182: iconst_0
    //   183: ldc_w 343
    //   186: new 167	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   193: aload_0
    //   194: getfield 37	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:e	J
    //   197: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   200: ldc_w 343
    //   203: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: aload_2
    //   210: ldc_w 343
    //   213: invokestatic 355	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   216: aload_1
    //   217: aload_0
    //   218: getfield 37	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:e	J
    //   221: invokevirtual 309	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;
    //   224: astore_1
    //   225: aload_0
    //   226: monitorexit
    //   227: aload 8
    //   229: monitorexit
    //   230: aload_1
    //   231: areturn
    //   232: astore_1
    //   233: aload 8
    //   235: monitorexit
    //   236: aload_1
    //   237: athrow
    //   238: aload 7
    //   240: astore_1
    //   241: iload 6
    //   243: istore 5
    //   245: aload 7
    //   247: getfield 215	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   250: bipush 7
    //   252: if_icmpeq -173 -> 79
    //   255: aload 7
    //   257: getfield 215	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   260: bipush 11
    //   262: if_icmpne +21 -> 283
    //   265: aload 7
    //   267: astore_1
    //   268: iload 6
    //   270: istore 5
    //   272: aload 9
    //   274: getfield 357	com/tencent/mobileqq/troop/data/TroopFileInfo:i	Ljava/lang/String;
    //   277: invokestatic 362	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   280: ifeq -201 -> 79
    //   283: aload 7
    //   285: getfield 215	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   288: bipush 6
    //   290: if_icmpne +21 -> 311
    //   293: aload 7
    //   295: astore_1
    //   296: iload 6
    //   298: istore 5
    //   300: aload 9
    //   302: getfield 357	com/tencent/mobileqq/troop/data/TroopFileInfo:i	Ljava/lang/String;
    //   305: invokestatic 362	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   308: ifeq -229 -> 79
    //   311: aload_0
    //   312: monitorexit
    //   313: aload 8
    //   315: monitorexit
    //   316: aconst_null
    //   317: areturn
    //   318: invokestatic 209	com/tencent/mobileqq/troop/filemanager/download/TroopFileDownloadMgr:a	()Lcom/tencent/mobileqq/troop/filemanager/download/TroopFileDownloadMgr;
    //   321: aload_0
    //   322: getfield 37	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:e	J
    //   325: aload_1
    //   326: aconst_null
    //   327: invokevirtual 364	com/tencent/mobileqq/troop/filemanager/download/TroopFileDownloadMgr:a	(JLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;Landroid/os/Bundle;)I
    //   330: pop
    //   331: goto -174 -> 157
    //   334: astore_1
    //   335: aload_0
    //   336: monitorexit
    //   337: aload_1
    //   338: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	this	TroopFileTransferMgr
    //   0	339	1	paramString1	String
    //   0	339	2	paramString2	String
    //   0	339	3	paramLong	long
    //   0	339	5	paramInt	int
    //   40	257	6	i	int
    //   59	235	7	localObject	Object
    //   4	310	8	localTroopFileManager	TroopFileManager
    //   21	280	9	localTroopFileInfo	TroopFileInfo
    // Exception table:
    //   from	to	target	type
    //   9	11	232	finally
    //   30	33	232	finally
    //   227	230	232	finally
    //   233	236	232	finally
    //   313	316	232	finally
    //   337	339	232	finally
    //   11	23	334	finally
    //   28	30	334	finally
    //   35	39	334	finally
    //   42	61	334	finally
    //   66	76	334	finally
    //   79	94	334	finally
    //   99	104	334	finally
    //   104	157	334	finally
    //   157	227	334	finally
    //   245	265	334	finally
    //   272	283	334	finally
    //   283	293	334	finally
    //   300	311	334	finally
    //   311	313	334	finally
    //   318	331	334	finally
    //   335	337	334	finally
  }
  
  /* Error */
  public TroopFileStatusInfo a(String paramString, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 83	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:a	()Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   4: astore 4
    //   6: aload 4
    //   8: monitorenter
    //   9: aload_0
    //   10: monitorenter
    //   11: aload 4
    //   13: aload_1
    //   14: invokevirtual 368	com/tencent/mobileqq/troop/utils/TroopFileManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/troop/data/TroopFileInfo;
    //   17: astore 5
    //   19: aload 5
    //   21: ifnonnull +10 -> 31
    //   24: aload_0
    //   25: monitorexit
    //   26: aload 4
    //   28: monitorexit
    //   29: aconst_null
    //   30: areturn
    //   31: aload_0
    //   32: invokevirtual 119	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:c	()V
    //   35: new 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   38: dup
    //   39: aload 5
    //   41: invokespecial 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lcom/tencent/mobileqq/troop/data/TroopFileInfo;)V
    //   44: astore 5
    //   46: aload 5
    //   48: bipush 102
    //   50: putfield 371	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   53: aload 5
    //   55: iload_2
    //   56: putfield 374	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:isFromAIO	Z
    //   59: aload 5
    //   61: iload_3
    //   62: putfield 222	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:RandomNum	I
    //   65: new 376	com/tencent/mm/vfs/VFSFile
    //   68: dup
    //   69: aload_1
    //   70: invokespecial 379	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   73: astore 6
    //   75: aload 6
    //   77: invokevirtual 382	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   80: ifeq +13 -> 93
    //   83: aload 5
    //   85: aload 6
    //   87: invokevirtual 386	com/tencent/mm/vfs/VFSFile:lastModified	()J
    //   90: putfield 389	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:origLastModifyTime	J
    //   93: aload_0
    //   94: aload 5
    //   96: invokevirtual 163	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   99: aload_1
    //   100: invokestatic 315	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)I
    //   103: iconst_5
    //   104: if_icmpne +41 -> 145
    //   107: aload_1
    //   108: new 391	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr$4
    //   111: dup
    //   112: aload_0
    //   113: aload 5
    //   115: invokespecial 394	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr$4:<init>	(Lcom/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr;Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   118: invokestatic 399	com/tencent/mobileqq/filemanager/util/FileCategoryUtil:a	(Ljava/lang/String;Lcom/tencent/mobileqq/filemanager/util/FileCategoryUtil$GetApkPackageInfoCallback;)Z
    //   121: pop
    //   122: aload 5
    //   124: aload_0
    //   125: getfield 37	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:e	J
    //   128: invokevirtual 309	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;
    //   131: astore_1
    //   132: aload_0
    //   133: monitorexit
    //   134: aload 4
    //   136: monitorexit
    //   137: aload_1
    //   138: areturn
    //   139: astore_1
    //   140: aload 4
    //   142: monitorexit
    //   143: aload_1
    //   144: athrow
    //   145: invokestatic 405	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   148: invokestatic 410	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)I
    //   151: ifne +12 -> 163
    //   154: aload_0
    //   155: aload 5
    //   157: iconst_3
    //   158: bipush 106
    //   160: invokevirtual 413	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   163: invokestatic 418	com/tencent/mobileqq/troop/filemanager/upload/TroopFileUploadMgr:a	()Lcom/tencent/mobileqq/troop/filemanager/upload/TroopFileUploadMgr;
    //   166: aload_0
    //   167: getfield 37	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:e	J
    //   170: aload 5
    //   172: aconst_null
    //   173: invokevirtual 419	com/tencent/mobileqq/troop/filemanager/upload/TroopFileUploadMgr:a	(JLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;Landroid/os/Bundle;)I
    //   176: pop
    //   177: goto -55 -> 122
    //   180: astore_1
    //   181: aload_0
    //   182: monitorexit
    //   183: aload_1
    //   184: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	TroopFileTransferMgr
    //   0	185	1	paramString	String
    //   0	185	2	paramBoolean	boolean
    //   0	185	3	paramInt	int
    //   4	137	4	localTroopFileManager	TroopFileManager
    //   17	154	5	localObject	Object
    //   73	13	6	localVFSFile	VFSFile
    // Exception table:
    //   from	to	target	type
    //   9	11	139	finally
    //   26	29	139	finally
    //   134	137	139	finally
    //   140	143	139	finally
    //   183	185	139	finally
    //   11	19	180	finally
    //   24	26	180	finally
    //   31	93	180	finally
    //   93	122	180	finally
    //   122	134	180	finally
    //   145	163	180	finally
    //   163	177	180	finally
    //   181	183	180	finally
  }
  
  public TroopFileTransferManager.Item a(UUID paramUUID, boolean paramBoolean)
  {
    try
    {
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.remove(paramUUID);
      if ((paramBoolean) && (localItem != null)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(this.e, paramUUID);
      }
      return localItem;
    }
    finally {}
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$FileUploadMgrObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$FileUploadMgrObserver = new TroopFileTransferMgr.1(this);
      TroopFileUploadMgr.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$FileUploadMgrObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadMgr$FileDownloadMgrObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadMgr$FileDownloadMgrObserver = new TroopFileTransferMgr.2(this);
      TroopFileDownloadMgr.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadMgr$FileDownloadMgrObserver);
    }
    TroopFileTransferUtil.Log.c("TroopFileTransferMgr", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "init");
  }
  
  /* Error */
  public void a(TroopFileInfo paramTroopFileInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 83	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:a	()Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   4: astore 4
    //   6: aload 4
    //   8: monitorenter
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_1
    //   12: ifnonnull +9 -> 21
    //   15: aload_0
    //   16: monitorexit
    //   17: aload 4
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: invokevirtual 119	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:c	()V
    //   25: aload_0
    //   26: getfield 122	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   29: aload_1
    //   30: getfield 117	com/tencent/mobileqq/troop/data/TroopFileInfo:a	Ljava/util/UUID;
    //   33: invokeinterface 128 2 0
    //   38: checkcast 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   41: astore_3
    //   42: aload_3
    //   43: astore_2
    //   44: aload_3
    //   45: ifnonnull +17 -> 62
    //   48: new 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lcom/tencent/mobileqq/troop/data/TroopFileInfo;)V
    //   56: astore_2
    //   57: aload_0
    //   58: aload_2
    //   59: invokevirtual 163	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   62: aload_2
    //   63: aload_1
    //   64: getfield 466	com/tencent/mobileqq/troop/data/TroopFileInfo:k	Ljava/lang/String;
    //   67: putfield 294	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:largeThumbnailFile	Ljava/lang/String;
    //   70: aload_2
    //   71: aload_1
    //   72: getfield 469	com/tencent/mobileqq/troop/data/TroopFileInfo:l	Ljava/lang/String;
    //   75: putfield 297	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:middleThumbnailFile	Ljava/lang/String;
    //   78: aload_2
    //   79: aload_1
    //   80: getfield 472	com/tencent/mobileqq/troop/data/TroopFileInfo:j	Ljava/lang/String;
    //   83: putfield 475	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:smallThumbFile	Ljava/lang/String;
    //   86: aload_0
    //   87: aload_2
    //   88: invokevirtual 477	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   91: aload_0
    //   92: monitorexit
    //   93: aload 4
    //   95: monitorexit
    //   96: return
    //   97: astore_1
    //   98: aload 4
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	TroopFileTransferMgr
    //   0	108	1	paramTroopFileInfo	TroopFileInfo
    //   43	45	2	localItem1	TroopFileTransferManager.Item
    //   41	4	3	localItem2	TroopFileTransferManager.Item
    //   4	95	4	localTroopFileManager	TroopFileManager
    // Exception table:
    //   from	to	target	type
    //   9	11	97	finally
    //   17	20	97	finally
    //   93	96	97	finally
    //   98	101	97	finally
    //   106	108	97	finally
    //   15	17	103	finally
    //   21	42	103	finally
    //   48	62	103	finally
    //   62	93	103	finally
    //   104	106	103	finally
  }
  
  public void a(TroopFileTransferManager.Item paramItem)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramItem.Id, paramItem);
      if (paramItem.troopuin == 0L) {
        paramItem.troopuin = this.e;
      }
      if (paramItem.troopuin != this.e)
      {
        TroopFileTransferUtil.Log.b("TroopFileTransferMgr", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "newItem troop confit. item.troopuin:" + paramItem.troopuin + " mTroopUin" + this.e);
        paramItem.troopuin = this.e;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(paramItem, null);
      return;
    }
    finally {}
  }
  
  public void a(TroopFileTransferManager.Item paramItem, int paramInt1, int paramInt2)
  {
    try
    {
      TroopFileDataCenter.a(this.e, paramItem, paramInt1, paramInt2);
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  public void a(TroopFileTransferManager.Item paramItem, int paramInt, TroopFileError.SimpleErrorInfo paramSimpleErrorInfo)
  {
    try
    {
      TroopFileDataCenter.a(this.e, paramItem, paramInt, paramSimpleErrorInfo);
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  @Deprecated
  public void a(TroopFileTransferManager.Item paramItem, int paramInt, boolean paramBoolean)
  {
    try
    {
      TroopFileTransferUtil.Log.b("TroopFileTransferMgr", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "!!!warning: oldver fun: doReqDownload be called");
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  /* Error */
  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 83	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:a	()Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   4: astore 6
    //   6: aload 6
    //   8: monitorenter
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_1
    //   12: invokestatic 288	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifeq +9 -> 24
    //   18: aload_0
    //   19: monitorexit
    //   20: aload 6
    //   22: monitorexit
    //   23: return
    //   24: aload 6
    //   26: aload_2
    //   27: lload_3
    //   28: bipush 25
    //   30: invokevirtual 219	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/lang/String;JI)Lcom/tencent/mobileqq/troop/data/TroopFileInfo;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnonnull +15 -> 50
    //   38: aload_0
    //   39: monitorexit
    //   40: aload 6
    //   42: monitorexit
    //   43: return
    //   44: astore_1
    //   45: aload 6
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    //   50: aload_0
    //   51: invokevirtual 119	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:c	()V
    //   54: new 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   57: dup
    //   58: aload_2
    //   59: invokespecial 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lcom/tencent/mobileqq/troop/data/TroopFileInfo;)V
    //   62: astore_2
    //   63: aload_2
    //   64: aload_1
    //   65: putfield 225	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardPath	Ljava/lang/String;
    //   68: aload_2
    //   69: aload_0
    //   70: getfield 33	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   73: invokevirtual 511	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   76: invokestatic 516	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   79: invokevirtual 519	java/lang/Long:longValue	()J
    //   82: putfield 228	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardTroopuin	J
    //   85: aload_2
    //   86: iload 5
    //   88: putfield 231	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardBusId	I
    //   91: aload_2
    //   92: iconst_4
    //   93: putfield 215	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   96: aload_2
    //   97: bipush 25
    //   99: putfield 371	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   102: aload_0
    //   103: aload_2
    //   104: invokevirtual 163	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   107: aload_0
    //   108: getfield 37	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:e	J
    //   111: aload_2
    //   112: invokestatic 524	com/tencent/mobileqq/troop/filemanager/forward/TroopFileFromTroopForwarder:a	(JLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Lcom/tencent/mobileqq/troop/filemanager/forward/TroopFileFromTroopForwarder;
    //   115: astore_1
    //   116: aload_1
    //   117: ifnull +14 -> 131
    //   120: aload_1
    //   121: invokevirtual 525	com/tencent/mobileqq/troop/filemanager/forward/TroopFileFromTroopForwarder:a	()I
    //   124: pop
    //   125: aload_0
    //   126: monitorexit
    //   127: aload 6
    //   129: monitorexit
    //   130: return
    //   131: ldc 165
    //   133: getstatic 459	com/tencent/mobileqq/troop/filemanager/TroopFileTransferUtil$Log:jdField_a_of_type_Int	I
    //   136: ldc_w 527
    //   139: invokestatic 529	com/tencent/mobileqq/troop/filemanager/TroopFileTransferUtil$Log:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: goto -17 -> 125
    //   145: astore_1
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_1
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	TroopFileTransferMgr
    //   0	150	1	paramString1	String
    //   0	150	2	paramString2	String
    //   0	150	3	paramLong	long
    //   0	150	5	paramInt	int
    //   4	124	6	localTroopFileManager	TroopFileManager
    // Exception table:
    //   from	to	target	type
    //   9	11	44	finally
    //   20	23	44	finally
    //   40	43	44	finally
    //   45	48	44	finally
    //   127	130	44	finally
    //   148	150	44	finally
    //   11	20	145	finally
    //   24	34	145	finally
    //   38	40	145	finally
    //   50	116	145	finally
    //   120	125	145	finally
    //   125	127	145	finally
    //   131	142	145	finally
    //   146	148	145	finally
  }
  
  public void a(Collection<String> paramCollection, boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject2;
      synchronized (a())
      {
        try
        {
          if (NetworkUtil.a(BaseApplication.getContext()) == 0)
          {
            i = 1;
            paramCollection = paramCollection.iterator();
            if (!paramCollection.hasNext()) {
              break;
            }
            Object localObject1 = (String)paramCollection.next();
            localObject2 = ???.b((String)localObject1);
            if (localObject2 == null) {
              continue;
            }
            c();
            localObject2 = new TroopFileTransferManager.Item((TroopFileInfo)localObject2);
            ((TroopFileTransferManager.Item)localObject2).BusId = 102;
            ((TroopFileTransferManager.Item)localObject2).isFromAIO = paramBoolean;
            localObject1 = new VFSFile((String)localObject1);
            if (((VFSFile)localObject1).exists()) {
              ((TroopFileTransferManager.Item)localObject2).origLastModifyTime = ((VFSFile)localObject1).lastModified();
            }
            a((TroopFileTransferManager.Item)localObject2);
            if (i == 0) {
              break label158;
            }
            a((TroopFileTransferManager.Item)localObject2, 3, 106);
            continue;
            paramCollection = finally;
          }
        }
        finally {}
      }
      int i = 0;
      continue;
      label158:
      TroopFileUploadMgr.a().a(this.e, (TroopFileTransferManager.Item)localObject2, null);
    }
  }
  
  public void a(List<TroopFileStatusInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ArrayList localArrayList;
    synchronized (a())
    {
      try
      {
        c();
        localArrayList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          TroopFileStatusInfo localTroopFileStatusInfo = (TroopFileStatusInfo)paramList.next();
          if (!TextUtils.isEmpty(localTroopFileStatusInfo.e))
          {
            Object localObject = ???.a(localTroopFileStatusInfo.g, localTroopFileStatusInfo.c, 25);
            if (localObject != null)
            {
              localObject = new TroopFileTransferManager.Item((TroopFileInfo)localObject);
              a((TroopFileTransferManager.Item)localObject);
              ((TroopFileTransferManager.Item)localObject).ForwardPath = localTroopFileStatusInfo.e;
              ((TroopFileTransferManager.Item)localObject).ForwardTroopuin = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue();
              ((TroopFileTransferManager.Item)localObject).ForwardBusId = localTroopFileStatusInfo.h;
              ((TroopFileTransferManager.Item)localObject).Status = 4;
              ((TroopFileTransferManager.Item)localObject).BusId = 25;
              localArrayList.add(localObject);
              continue;
              paramList = finally;
            }
          }
        }
      }
      finally {}
    }
    if (localArrayList.size() == 0) {
      return;
    }
    paramList = TroopFileMultiForwarder.a(this.e, localArrayList);
    if (paramList != null) {
      paramList.a();
    }
    for (;;)
    {
      return;
      TroopFileTransferUtil.Log.a("TroopFileTransferMgr", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "startMultiCopyToWeiyun forwarder=null");
    }
  }
  
  /* Error */
  public void a(UUID paramUUID)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 119	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:c	()V
    //   6: aload_0
    //   7: getfield 122	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   10: aload_1
    //   11: invokeinterface 128 2 0
    //   16: checkcast 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   19: astore_2
    //   20: aload_2
    //   21: ifnonnull +6 -> 27
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: ldc 165
    //   29: getstatic 459	com/tencent/mobileqq/troop/filemanager/TroopFileTransferUtil$Log:jdField_a_of_type_Int	I
    //   32: new 167	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 585
    //   42: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_1
    //   46: invokevirtual 181	java/util/UUID:toString	()Ljava/lang/String;
    //   49: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc_w 587
    //   55: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 463	com/tencent/mobileqq/troop/filemanager/TroopFileTransferUtil$Log:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: new 589	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr$3
    //   67: dup
    //   68: aload_0
    //   69: aload_2
    //   70: aload_1
    //   71: invokespecial 592	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr$3:<init>	(Lcom/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr;Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;Ljava/util/UUID;)V
    //   74: iconst_5
    //   75: aconst_null
    //   76: iconst_0
    //   77: invokestatic 597	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   80: goto -56 -> 24
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	TroopFileTransferMgr
    //   0	88	1	paramUUID	UUID
    //   19	51	2	localItem	TroopFileTransferManager.Item
    // Exception table:
    //   from	to	target	type
    //   2	20	83	finally
    //   27	80	83	finally
  }
  
  @Deprecated
  public boolean a()
  {
    try
    {
      TroopFileTransferUtil.Log.b("TroopFileTransferMgr", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "!!!warning: oldver fun: saveStatus be called");
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    return TroopFileThumbnailMgr.a(this.e, paramItem, paramInt);
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt)
  {
    TroopFileInfo localTroopFileInfo;
    synchronized (a()) {}
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    synchronized (a()) {}
    try
    {
      int i = FileManagerUtil.a(FileUtil.a(paramString2));
      if ((i != 0) && (i != 2)) {
        return false;
      }
      TroopFileInfo localTroopFileInfo = ???.a(paramString1, paramString2, 0L, paramInt1);
      if (localTroopFileInfo == null)
      {
        return false;
        paramString1 = finally;
        throw paramString1;
      }
      c();
      paramString2 = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(localTroopFileInfo.a);
      paramString1 = paramString2;
      if (paramString2 == null)
      {
        paramString1 = new TroopFileTransferManager.Item(localTroopFileInfo);
        a(paramString1);
      }
      TroopFileThumbnailMgr.a().a(this.e, paramString1, paramInt2);
      return true;
    }
    finally {}
  }
  
  /* Error */
  public boolean a(UUID paramUUID)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 119	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:c	()V
    //   8: aload_0
    //   9: getfield 122	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   12: aload_1
    //   13: invokeinterface 128 2 0
    //   18: checkcast 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   21: astore 4
    //   23: aload 4
    //   25: ifnonnull +7 -> 32
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_3
    //   31: ireturn
    //   32: invokestatic 418	com/tencent/mobileqq/troop/filemanager/upload/TroopFileUploadMgr:a	()Lcom/tencent/mobileqq/troop/filemanager/upload/TroopFileUploadMgr;
    //   35: aload_1
    //   36: aconst_null
    //   37: invokevirtual 620	com/tencent/mobileqq/troop/filemanager/upload/TroopFileUploadMgr:a	(Ljava/util/UUID;Landroid/os/Bundle;)I
    //   40: istore_2
    //   41: iload_2
    //   42: ifne +8 -> 50
    //   45: iconst_1
    //   46: istore_3
    //   47: goto -19 -> 28
    //   50: iconst_0
    //   51: istore_3
    //   52: goto -5 -> 47
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	TroopFileTransferMgr
    //   0	60	1	paramUUID	UUID
    //   40	2	2	i	int
    //   1	51	3	bool	boolean
    //   21	3	4	localItem	TroopFileTransferManager.Item
    // Exception table:
    //   from	to	target	type
    //   4	23	55	finally
    //   32	41	55	finally
  }
  
  public boolean a(UUID paramUUID, int paramInt)
  {
    synchronized (a()) {}
    try
    {
      TroopFileInfo localTroopFileInfo = ???.a(paramUUID);
      if (localTroopFileInfo == null) {
        return false;
      }
      int i = FileManagerUtil.a(FileUtil.a(localTroopFileInfo.c));
      if ((i != 0) && (i != 2))
      {
        return false;
        paramUUID = finally;
        throw paramUUID;
      }
      c();
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(paramUUID);
      paramUUID = localItem;
      if (localItem == null)
      {
        paramUUID = new TroopFileTransferManager.Item(localTroopFileInfo);
        a(paramUUID);
      }
      TroopFileThumbnailMgr.a().a(this.e, paramUUID, paramInt);
      return true;
    }
    finally {}
  }
  
  public void b()
  {
    TroopFileTransferUtil.Log.c("TroopFileTransferMgr", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "release");
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$FileUploadMgrObserver != null)
    {
      TroopFileUploadMgr.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$FileUploadMgrObserver);
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$FileUploadMgrObserver = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadMgr$FileDownloadMgrObserver != null)
    {
      TroopFileDownloadMgr.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadMgr$FileDownloadMgrObserver);
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadMgr$FileDownloadMgrObserver = null;
    }
  }
  
  public void b(TroopFileTransferManager.Item paramItem)
  {
    TroopFileDataCenter.a(this.e, paramItem);
  }
  
  /* Error */
  public boolean b(UUID paramUUID)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 119	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:c	()V
    //   8: aload_0
    //   9: getfield 122	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   12: aload_1
    //   13: invokeinterface 128 2 0
    //   18: checkcast 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   21: astore_1
    //   22: aload_1
    //   23: ifnonnull +7 -> 30
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_3
    //   29: ireturn
    //   30: invokestatic 418	com/tencent/mobileqq/troop/filemanager/upload/TroopFileUploadMgr:a	()Lcom/tencent/mobileqq/troop/filemanager/upload/TroopFileUploadMgr;
    //   33: aload_0
    //   34: getfield 37	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:e	J
    //   37: aload_1
    //   38: aconst_null
    //   39: invokevirtual 419	com/tencent/mobileqq/troop/filemanager/upload/TroopFileUploadMgr:a	(JLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;Landroid/os/Bundle;)I
    //   42: istore_2
    //   43: iload_2
    //   44: ifne +8 -> 52
    //   47: iconst_1
    //   48: istore_3
    //   49: goto -23 -> 26
    //   52: iconst_0
    //   53: istore_3
    //   54: goto -5 -> 49
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	TroopFileTransferMgr
    //   0	62	1	paramUUID	UUID
    //   42	2	2	i	int
    //   1	53	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	22	57	finally
    //   30	43	57	finally
  }
  
  public void c()
  {
    try
    {
      boolean bool = this.jdField_b_of_type_Boolean;
      if (bool) {
        label11:
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(this.e);
      this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
      if ((!jdField_a_of_type_Boolean) && (localList == null)) {
        throw new AssertionError();
      }
    }
    finally {}
    Object localObject2;
    if (localObject1 != null)
    {
      localIterator = localObject1.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (TroopFileTansferItemEntity)localIterator.next();
        if (((TroopFileTansferItemEntity)localObject2).Id != null)
        {
          if (!((TroopFileTansferItemEntity)localObject2).isCheckPrivateDir)
          {
            ((TroopFileTansferItemEntity)localObject2).isCheckPrivateDir = true;
            if (!TextUtils.isEmpty(((TroopFileTansferItemEntity)localObject2).smallThumbFile)) {
              ((TroopFileTansferItemEntity)localObject2).smallThumbFile = VFSAssistantUtils.getSDKPrivatePath(((TroopFileTansferItemEntity)localObject2).smallThumbFile);
            }
            if (!TextUtils.isEmpty(((TroopFileTansferItemEntity)localObject2).largeThumbnailFile)) {
              ((TroopFileTansferItemEntity)localObject2).largeThumbnailFile = VFSAssistantUtils.getSDKPrivatePath(((TroopFileTansferItemEntity)localObject2).largeThumbnailFile);
            }
            if (!TextUtils.isEmpty(((TroopFileTansferItemEntity)localObject2).middleThumbnailFile)) {
              ((TroopFileTansferItemEntity)localObject2).middleThumbnailFile = VFSAssistantUtils.getSDKPrivatePath(((TroopFileTansferItemEntity)localObject2).middleThumbnailFile);
            }
          }
          this.jdField_a_of_type_JavaUtilMap.put(((TroopFileTansferItemEntity)localObject2).Id, new TroopFileTransferManager.Item((TroopFileTansferItemEntity)localObject2));
        }
        else
        {
          TroopFileTransferUtil.Log.a("TroopFileTransferMgr", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "entity.Id is null");
        }
      }
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    for (;;)
    {
      if (localIterator.hasNext()) {
        localObject2 = (TroopFileTransferManager.Item)localIterator.next();
      }
      switch (((TroopFileTransferManager.Item)localObject2).Status)
      {
      case 0: 
      case 1: 
        ((TroopFileTransferManager.Item)localObject2).Status = 3;
        break;
      case 8: 
        ((TroopFileTransferManager.Item)localObject2).Status = 10;
        continue;
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          ThreadManager.post(new TroopFileTransferMgr.5(this), 8, null, true);
          break label11;
        }
        c();
        break label11;
      }
    }
  }
  
  public void c(TroopFileTransferManager.Item paramItem)
  {
    paramItem = TroopFileUploadFeedsSender.a(this.e, paramItem);
    if (paramItem != null) {
      paramItem.j();
    }
  }
  
  /* Error */
  public boolean c(UUID paramUUID)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 119	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:c	()V
    //   8: aload_0
    //   9: getfield 122	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   12: aload_1
    //   13: invokeinterface 128 2 0
    //   18: checkcast 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   21: astore_1
    //   22: aload_1
    //   23: ifnonnull +7 -> 30
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_3
    //   29: ireturn
    //   30: aload_1
    //   31: getfield 145	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:isZipInnerFile	Z
    //   34: ifeq +21 -> 55
    //   37: invokestatic 209	com/tencent/mobileqq/troop/filemanager/download/TroopFileDownloadMgr:a	()Lcom/tencent/mobileqq/troop/filemanager/download/TroopFileDownloadMgr;
    //   40: aload_0
    //   41: getfield 37	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:e	J
    //   44: aload_1
    //   45: aconst_null
    //   46: invokevirtual 212	com/tencent/mobileqq/troop/filemanager/download/TroopFileDownloadMgr:b	(JLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;Landroid/os/Bundle;)I
    //   49: pop
    //   50: iconst_1
    //   51: istore_3
    //   52: goto -26 -> 26
    //   55: invokestatic 209	com/tencent/mobileqq/troop/filemanager/download/TroopFileDownloadMgr:a	()Lcom/tencent/mobileqq/troop/filemanager/download/TroopFileDownloadMgr;
    //   58: aload_0
    //   59: getfield 37	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:e	J
    //   62: aload_1
    //   63: aconst_null
    //   64: invokevirtual 364	com/tencent/mobileqq/troop/filemanager/download/TroopFileDownloadMgr:a	(JLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;Landroid/os/Bundle;)I
    //   67: istore_2
    //   68: iload_2
    //   69: ifne +8 -> 77
    //   72: iconst_1
    //   73: istore_3
    //   74: goto -48 -> 26
    //   77: iconst_0
    //   78: istore_3
    //   79: goto -5 -> 74
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	TroopFileTransferMgr
    //   0	87	1	paramUUID	UUID
    //   67	2	2	i	int
    //   1	78	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	22	82	finally
    //   30	50	82	finally
    //   55	68	82	finally
  }
  
  public void d()
  {
    for (;;)
    {
      TroopFileTransferManager.Item localItem;
      Bundle localBundle;
      try
      {
        c();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
        if (!localIterator.hasNext()) {
          break label204;
        }
        localItem = (TroopFileTransferManager.Item)localIterator.next();
        if (localItem.W2MPause != 2) {
          continue;
        }
        localItem.W2MPause = 0;
        localBundle = new Bundle();
        switch (localItem.Status)
        {
        case 0: 
        case 1: 
        case 8: 
          localItem.Pausing = 0;
          break;
        case 2: 
          localBundle.putBoolean("_wifi2mobile_resume_", true);
        }
      }
      finally {}
      TroopFileUploadMgr.a().a(this.e, localItem, localBundle);
      continue;
      localBundle.putBoolean("_wifi2mobile_resume_", true);
      if (localItem.isZipInnerFile)
      {
        TroopFileDownloadMgr.a().b(this.e, localItem, localBundle);
      }
      else
      {
        TroopFileDownloadMgr.a().a(this.e, localItem, localBundle);
        continue;
        label204:
        return;
      }
    }
  }
  
  public void d(TroopFileTransferManager.Item paramItem)
  {
    try
    {
      TroopFileDataCenter.b(this.e, paramItem);
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  /* Error */
  public boolean d(UUID paramUUID)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 119	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:c	()V
    //   8: aload_0
    //   9: getfield 122	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   12: aload_1
    //   13: invokeinterface 128 2 0
    //   18: checkcast 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   21: astore 4
    //   23: aload 4
    //   25: ifnonnull +7 -> 32
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_3
    //   31: ireturn
    //   32: invokestatic 209	com/tencent/mobileqq/troop/filemanager/download/TroopFileDownloadMgr:a	()Lcom/tencent/mobileqq/troop/filemanager/download/TroopFileDownloadMgr;
    //   35: aload_1
    //   36: aconst_null
    //   37: invokevirtual 700	com/tencent/mobileqq/troop/filemanager/download/TroopFileDownloadMgr:a	(Ljava/util/UUID;Landroid/os/Bundle;)I
    //   40: istore_2
    //   41: aload 4
    //   43: getfield 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   46: invokestatic 315	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)I
    //   49: iconst_2
    //   50: if_icmpne +29 -> 79
    //   53: aload_0
    //   54: getfield 33	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   57: invokestatic 320	com/tencent/mobileqq/filemanager/util/QFileUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   60: ifeq +19 -> 79
    //   63: aload 4
    //   65: getfield 703	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   68: invokestatic 705	com/tencent/mobileqq/filemanager/core/FileVideoDownloadManager:a	(Ljava/lang/String;)V
    //   71: aload_0
    //   72: aload 4
    //   74: bipush 9
    //   76: invokevirtual 708	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   79: iload_2
    //   80: ifne +8 -> 88
    //   83: iconst_1
    //   84: istore_3
    //   85: goto -57 -> 28
    //   88: iconst_0
    //   89: istore_3
    //   90: goto -5 -> 85
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	TroopFileTransferMgr
    //   0	98	1	paramUUID	UUID
    //   40	40	2	i	int
    //   1	89	3	bool	boolean
    //   21	52	4	localItem	TroopFileTransferManager.Item
    // Exception table:
    //   from	to	target	type
    //   4	23	93	finally
    //   32	79	93	finally
  }
  
  @Deprecated
  public void e()
  {
    try
    {
      TroopFileTransferUtil.Log.b("TroopFileTransferMgr", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "!!!warning: oldver fun: Interrupt be called");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  public void e(TroopFileTransferManager.Item paramItem)
  {
    TroopFileTransferUtil.Log.b("TroopFileTransferMgr", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "!!!warning: oldver fun: doReqUpload be called");
  }
  
  public boolean e(UUID paramUUID)
  {
    TroopFileInfo localTroopFileInfo;
    TroopFileTransferManager.Item localItem;
    synchronized (a()) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr
 * JD-Core Version:    0.7.0.1
 */