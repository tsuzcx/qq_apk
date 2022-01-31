package com.tencent.mobileqq.multimsg;

import aejh;
import aeji;
import aejj;
import aejk;
import aejl;
import aejm;
import aejn;
import aejo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.StringToIntParser;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.lovelanguage.LoveLanguageManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.receipt.ReceiptMsgManager.ReceiptMsgUploadCallback;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LongSparseArray;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.manager.ServerConfigManager.ConfigType;

public class MultiMsgManager
  implements Comparator
{
  private static long jdField_a_of_type_Long;
  private static MultiMsgManager jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager;
  public static final String a;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public int a;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private LongSparseArray jdField_a_of_type_ComTencentUtilLongSparseArray;
  public ArrayList a;
  public HashMap a;
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  public HashMap b;
  private int jdField_c_of_type_Int = 100;
  private HashMap jdField_c_of_type_JavaUtilHashMap = new HashMap();
  private int d = 20;
  private int e;
  private int f = 100;
  private int g = 10;
  private int h;
  private int i;
  private int j;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.aJ + "fight/pic_expire.png";
  }
  
  public MultiMsgManager()
  {
    this.jdField_e_of_type_Int = 10;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
    case 2: 
      return 1;
    case 3: 
      return 2;
    }
    return 3;
  }
  
  public static long a()
  {
    File localFile = new File(jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      return localFile.length();
    }
    return 0L;
  }
  
  public static MultiMsgManager a()
  {
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager == null) {
        jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager = new MultiMsgManager();
      }
      return jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    if (!new File(jdField_a_of_type_JavaLangString).exists())
    {
      FileUtils.a(paramQQAppInterface.getApp(), 2130839562, jdField_a_of_type_JavaLangString);
      paramQQAppInterface = FileUtils.b(jdField_a_of_type_JavaLangString);
      paramQQAppInterface = "chatthumb:" + paramQQAppInterface;
      paramQQAppInterface = URLDrawableHelper.a + "/" + AbsDownloader.c(paramQQAppInterface) + "_hd";
      FileUtils.d(jdField_a_of_type_JavaLangString, paramQQAppInterface);
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  /* Error */
  private void a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +37 -> 42
    //   8: ldc 150
    //   10: iconst_2
    //   11: new 30	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   18: ldc 152
    //   20: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_1
    //   24: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: ldc 157
    //   29: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: iload_3
    //   33: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_0
    //   43: getfield 165	com/tencent/mobileqq/multimsg/MultiMsgManager:jdField_a_of_type_ComTencentUtilLongSparseArray	Lcom/tencent/util/LongSparseArray;
    //   46: ifnull +40 -> 86
    //   49: aload_0
    //   50: getfield 165	com/tencent/mobileqq/multimsg/MultiMsgManager:jdField_a_of_type_ComTencentUtilLongSparseArray	Lcom/tencent/util/LongSparseArray;
    //   53: lload_1
    //   54: iconst_0
    //   55: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   58: invokevirtual 176	com/tencent/util/LongSparseArray:a	(JLjava/lang/Object;)Ljava/lang/Object;
    //   61: checkcast 167	java/lang/Integer
    //   64: invokevirtual 180	java/lang/Integer:intValue	()I
    //   67: iload_3
    //   68: ixor
    //   69: istore_3
    //   70: iload_3
    //   71: ifeq +18 -> 89
    //   74: aload_0
    //   75: getfield 165	com/tencent/mobileqq/multimsg/MultiMsgManager:jdField_a_of_type_ComTencentUtilLongSparseArray	Lcom/tencent/util/LongSparseArray;
    //   78: lload_1
    //   79: iload_3
    //   80: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   83: invokevirtual 183	com/tencent/util/LongSparseArray:a	(JLjava/lang/Object;)V
    //   86: aload_0
    //   87: monitorexit
    //   88: return
    //   89: aload_0
    //   90: getfield 165	com/tencent/mobileqq/multimsg/MultiMsgManager:jdField_a_of_type_ComTencentUtilLongSparseArray	Lcom/tencent/util/LongSparseArray;
    //   93: lload_1
    //   94: invokevirtual 186	com/tencent/util/LongSparseArray:b	(J)V
    //   97: goto -11 -> 86
    //   100: astore 4
    //   102: aload_0
    //   103: monitorexit
    //   104: aload 4
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	MultiMsgManager
    //   0	107	1	paramLong	long
    //   0	107	3	paramInt	int
    //   100	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	42	100	finally
    //   42	70	100	finally
    //   74	86	100	finally
    //   89	97	100	finally
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, MessageRecord paramMessageRecord, ArrayList paramArrayList, int paramInt2, @Nullable Bundle paramBundle)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)paramArrayList.get(0);
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_b_of_type_JavaLangString = paramQQAppInterface.getAccount();
    localTransferRequest.c = paramString;
    localTransferRequest.jdField_a_of_type_Int = paramInt1;
    localTransferRequest.jdField_b_of_type_Int = 2;
    localTransferRequest.jdField_a_of_type_Long = ((MessageRecord)paramArrayList.get(0)).uniseq;
    localTransferRequest.jdField_a_of_type_Boolean = true;
    String str;
    boolean bool;
    if (paramBundle != null)
    {
      str = paramBundle.getString("ReceiptMsgManager.EXTRA_KEY_PTT_PATH");
      localTransferRequest.i = str;
      localTransferRequest.jdField_e_of_type_Int = 1002;
      if ((paramBundle != null) && (!paramBundle.getBoolean("ReceiptMsgManager.EXTRA_KEY_PTT_COMPRESS_FINISHED"))) {
        break label220;
      }
      bool = true;
      label117:
      localTransferRequest.jdField_l_of_type_Boolean = bool;
      if (paramBundle == null) {
        break label226;
      }
    }
    label220:
    label226:
    for (int k = a(paramBundle.getInt("ReceiptMsgManager.EXTRA_KEY_PTT_SEND_SOURCE"));; k = 0)
    {
      localTransferRequest.n = k;
      localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)paramArrayList.get(0));
      localMessageForPtt.mInputContent = "";
      localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = new aejo(paramMessageRecord, paramArrayList, paramQQAppInterface, paramString, paramInt1, paramInt2, this, null);
      localTransferRequest.jdField_e_of_type_Boolean = false;
      paramQQAppInterface.a().a(localTransferRequest);
      return;
      str = localMessageForPtt.fullLocalPath;
      break;
      bool = false;
      break label117;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, HashMap paramHashMap, MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, ArrayList paramArrayList, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isDevelopLevel())
    {
      QLog.d("MultiMsg", 4, "pack multi msg start.............................");
      QLog.d("MultiMsg", 4, paramArrayList.toString());
    }
    paramMessageObserver = paramQQAppInterface.a().a().a(paramArrayList, paramHashMap, paramBoolean);
    if (paramMessageObserver == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "pack multi msg failed.............................");
      }
      if (paramInt2 == 2) {
        ((MessageHandler)paramQQAppInterface.a(0)).a(8031, false, Integer.valueOf(4));
      }
    }
    do
    {
      return;
      paramMessageRecord.extraflag = 32768;
      paramQQAppInterface.a().a(paramString, paramInt1, paramMessageRecord.uniseq);
      long l = paramMessageRecord.uniseq;
      ((MessageHandler)paramQQAppInterface.a(0)).a(MessageHandler.c(paramInt1), false, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "pack multi msg done.............................");
      }
      if (paramInt2 == 0) {
        paramHashMap = new aejn(paramQQAppInterface, paramMessageRecord, paramString, paramInt1);
      }
      for (;;)
      {
        if (a(paramQQAppInterface, paramMessageObserver, paramQQAppInterface.getCurrentAccountUin(), paramString, paramString, paramInt1, paramMessageRecord.uniseq, 1035, paramHashMap))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MultiMsg", 2, "sendMultiMsg successful, upload multi msg pack start.......................");
          return;
          if (paramInt2 == 2)
          {
            paramHashMap = new aejm(paramQQAppInterface, paramMessageRecord, paramString, paramInt1, paramArrayList, paramHashMap);
          }
          else if (paramInt2 == 5)
          {
            paramHashMap = new ReceiptMsgManager.ReceiptMsgUploadCallback(paramQQAppInterface, paramMessageRecord, paramString, paramInt1);
          }
          else
          {
            QLog.e("MultiMsg", 1, "not support forwardMode:" + paramInt2);
            return;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MultiMsg", 2, "sendMultiMsg failed.......................");
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, HashMap paramHashMap, MessageRecord paramMessageRecord, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt2)
  {
    PicReq localPicReq = PicBusiManager.a(8, 7);
    localPicReq.a(paramArrayList2);
    localPicReq.a(new aejj(this, paramInt2, paramMessageRecord, paramArrayList1, paramQQAppInterface, paramString, paramInt1, paramHashMap));
    PicBusiManager.a(localPicReq, paramQQAppInterface);
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, HashMap paramHashMap, MessageRecord paramMessageRecord, ArrayList paramArrayList1, ArrayList paramArrayList2, ShortVideoReq paramShortVideoReq, int paramInt2)
  {
    ShortVideoReq localShortVideoReq = paramShortVideoReq;
    if (paramShortVideoReq == null) {
      localShortVideoReq = ShortVideoBusiManager.a(5, 5);
    }
    localShortVideoReq.a(paramArrayList2);
    localShortVideoReq.a(new aejk(this, paramArrayList1, paramMessageRecord, paramQQAppInterface, paramString, paramInt1, paramHashMap, paramInt2));
    ShortVideoBusiManager.a(localShortVideoReq, paramQQAppInterface);
  }
  
  private void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramMessageRecord.extraflag = 32768;
    paramQQAppInterface.a().a(paramString, paramInt, paramMessageRecord.uniseq);
    paramQQAppInterface.a().a(paramString, paramInt, paramMessageRecord.uniseq, 32768, -1);
    long l = paramMessageRecord.uniseq;
    ((MessageHandler)paramQQAppInterface.a(0)).a(MessageHandler.c(paramInt), false, new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  private boolean a(long paramLong)
  {
    for (;;)
    {
      try
      {
        boolean bool2;
        if (this.jdField_a_of_type_ComTencentUtilLongSparseArray == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg", 2, "isReceiptMessageFinished map null and res: false");
          }
          bool2 = false;
          return bool2;
        }
        boolean bool1;
        if (((Integer)this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(paramLong, Integer.valueOf(0))).intValue() == 0)
        {
          bool1 = true;
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("MultiMsg", 2, "isReceiptMessageFinished res: " + bool1);
            bool2 = bool1;
          }
        }
        else
        {
          bool1 = false;
        }
      }
      finally {}
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, UpCallBack paramUpCallBack)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "[sendMultiMsg]data.length = " + paramArrayOfByte.length);
    }
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.jdField_b_of_type_Int = 131078;
    localTransferRequest.h = 0;
    localTransferRequest.jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
    localTransferRequest.jdField_b_of_type_JavaLangString = paramString1;
    localTransferRequest.c = paramString2;
    localTransferRequest.d = paramString3;
    localTransferRequest.jdField_a_of_type_Int = paramInt1;
    localTransferRequest.jdField_a_of_type_Long = paramLong;
    localTransferRequest.jdField_e_of_type_Int = paramInt2;
    localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = paramUpCallBack;
    paramQQAppInterface.a().a(localTransferRequest);
    return true;
  }
  
  private void b()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentUtilLongSparseArray == null) {
        this.jdField_a_of_type_ComTencentUtilLongSparseArray = new LongSparseArray();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "updateFinishMask mask: " + paramInt);
    }
    this.jdField_b_of_type_Int ^= paramInt;
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int a(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    if ((paramChatMessage1.istroop == 1) || (paramChatMessage1.istroop == 3000)) {
      if (paramChatMessage1.shmsgseq == paramChatMessage2.shmsgseq) {
        if (paramChatMessage1.getId() <= paramChatMessage2.getId()) {}
      }
    }
    do
    {
      do
      {
        do
        {
          return 1;
          if (paramChatMessage1.getId() < paramChatMessage2.getId()) {
            return -1;
          }
          return 0;
        } while (paramChatMessage1.shmsgseq > paramChatMessage2.shmsgseq);
        return -1;
        if (paramChatMessage1.time != paramChatMessage2.time) {
          break;
        }
      } while (paramChatMessage1.getId() > paramChatMessage2.getId());
      if (paramChatMessage1.getId() < paramChatMessage2.getId()) {
        return -1;
      }
      return 0;
    } while (paramChatMessage1.time > paramChatMessage2.time);
    return -1;
  }
  
  public int a(Collection paramCollection)
  {
    paramCollection = paramCollection.iterator();
    int k = 0;
    Object localObject1;
    if (paramCollection.hasNext())
    {
      localObject1 = (ChatMessage)paramCollection.next();
      if ((localObject1 instanceof MessageForPic)) {
        k += 1;
      }
    }
    for (;;)
    {
      break;
      if ((localObject1 instanceof MessageForMixedMsg))
      {
        localObject1 = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          if (((MessageRecord)((Iterator)localObject1).next() instanceof MessageForPic)) {
            k += 1;
          }
        }
      }
      else
      {
        int m = k;
        if (((ChatMessage)localObject1).msgtype == -1036)
        {
          localObject1 = ((MessageForLongMsg)localObject1).longMsgFragmentList.iterator();
          do
          {
            m = k;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
          } while (!(localObject2 instanceof MessageForMixedMsg));
          Object localObject2 = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
          m = k;
          for (;;)
          {
            k = m;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            if (((MessageRecord)((Iterator)localObject2).next() instanceof MessageForPic)) {
              m += 1;
            }
          }
          return k;
        }
        k = m;
      }
    }
  }
  
  public SessionInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public String a(String paramString, long paramLong, QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong == 0L)) {}
    Object localObject;
    do
    {
      while (!paramQQAppInterface.hasNext())
      {
        do
        {
          return null;
          if (this.jdField_c_of_type_JavaUtilHashMap.size() > 0)
          {
            localObject = (List)this.jdField_c_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
            if ((localObject != null) && (((List)localObject).size() > 0))
            {
              localObject = ((List)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                MultiMsgNick localMultiMsgNick = (MultiMsgNick)((Iterator)localObject).next();
                if ((localMultiMsgNick != null) && (paramString.equals(localMultiMsgNick.uin)) && (paramLong == localMultiMsgNick.uniseq)) {
                  return localMultiMsgNick.nick;
                }
              }
            }
          }
          this.jdField_c_of_type_JavaUtilHashMap.clear();
          paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager().a(MultiMsgNick.class, new MultiMsgNick().getTableName(), false, "uniseq = ?", new String[] { String.valueOf(paramLong) }, null, null, null, null);
        } while ((paramQQAppInterface == null) || (paramQQAppInterface.size() <= 0));
        this.jdField_c_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), paramQQAppInterface);
        paramQQAppInterface = paramQQAppInterface.iterator();
      }
      localObject = (MultiMsgNick)paramQQAppInterface.next();
    } while ((localObject == null) || (!paramString.equals(((MultiMsgNick)localObject).uin)) || (paramLong != ((MultiMsgNick)localObject).uniseq));
    return ((MultiMsgNick)localObject).nick;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Boolean)localEntry.getValue()).booleanValue()) {
        localArrayList.add(localEntry.getKey());
      }
    }
    return localArrayList;
  }
  
  public List a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    Object localObject1 = paramQQAppInterface.a().a().a(paramLong);
    paramQQAppInterface = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
      if ((localObject2 instanceof MessageForStructing))
      {
        MessageForStructing localMessageForStructing = (MessageForStructing)localObject2;
        if (localMessageForStructing.structingMsg == null) {
          localMessageForStructing.structingMsg = StructMsgFactory.a(((MessageRecord)localObject2).msgData);
        }
      }
      if ((localObject2 instanceof MessageForQQStoryComment)) {
        ((MessageForQQStoryComment)localObject2).displayType = 1;
      }
      paramQQAppInterface.add((ChatMessage)localObject2);
      if ((QLog.isColorLevel()) && ((localObject2 instanceof MessageForPic)))
      {
        localObject2 = (MessageForPic)localObject2;
        QLog.d("MultiMsg", 2, "[chatPie.getMultiMsgList] = " + ((MessageForPic)localObject2).toLogString() + " mr = " + ((MessageForPic)localObject2).toString());
      }
    }
    return paramQQAppInterface;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)paramSessionInfo.clone());
      return;
    }
    catch (CloneNotSupportedException paramSessionInfo) {}
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
    return;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    String str2;
    Object localObject;
    if (paramQQAppInterface != null)
    {
      String str1 = paramQQAppInterface.a(ServerConfigManager.ConfigType.user, "MMF_enable");
      str2 = paramQQAppInterface.a(ServerConfigManager.ConfigType.user, "MMF_maxMsgNum");
      localObject = paramQQAppInterface.a(ServerConfigManager.ConfigType.user, "MMF_maxPicNum");
      paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.user, "MMF_maxVideoNum");
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "initLimitCount enable = " + str1 + " maxMsgNum = " + str2 + " maxPicNum " + (String)localObject);
      }
      if (TextUtils.isEmpty(str2)) {}
    }
    try
    {
      this.jdField_c_of_type_Int = Integer.parseInt(str2);
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        this.d = Integer.parseInt((String)localObject);
        if (TextUtils.isEmpty(paramQQAppInterface)) {}
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          for (;;)
          {
            this.jdField_e_of_type_Int = Integer.parseInt(paramQQAppInterface);
            paramQQAppInterface = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.MultiMsgConfig.name(), "100|10|0|0");
            if (QLog.isColorLevel()) {
              QLog.d("MultiMsg", 2, "initLimitCount delayConfi = " + paramQQAppInterface);
            }
            if (!TextUtils.isEmpty(paramQQAppInterface))
            {
              localObject = new Integer[4];
              Arrays.fill((Object[])localObject, Integer.valueOf(0));
              if (DeviceProfileManager.a(paramQQAppInterface, (Object[])localObject, new DeviceProfileManager.StringToIntParser()) >= localObject.length)
              {
                if (localObject[0].intValue() >= 0)
                {
                  this.f = localObject[0].intValue();
                  if (localObject[1].intValue() <= 0) {
                    break;
                  }
                  k = localObject[1].intValue();
                  this.g = k;
                }
                if (localObject[2].intValue() < 0) {
                  break label363;
                }
                k = localObject[2].intValue();
                this.h = k;
                if (localObject[3].intValue() < 0) {
                  break label371;
                }
                k = localObject[3].intValue();
                this.i = k;
              }
            }
            this.jdField_a_of_type_Boolean = true;
            return;
            localNumberFormatException2 = localNumberFormatException2;
            this.jdField_c_of_type_Int = 100;
          }
          localNumberFormatException1 = localNumberFormatException1;
          this.d = 20;
        }
        catch (NumberFormatException paramQQAppInterface)
        {
          for (;;)
          {
            this.jdField_e_of_type_Int = 10;
            continue;
            int k = this.g;
            continue;
            label363:
            k = this.h;
            continue;
            label371:
            k = this.i;
          }
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    paramQQAppInterface.a(new aejh(this, new ArrayList(paramArrayList), paramQQAppInterface, paramSessionInfo));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    paramQQAppInterface.a(new aejl(this, paramQQAppInterface, paramString, paramInt, paramLong, paramBoolean));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, AbsStructMsg paramAbsStructMsg, long paramLong, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 4, " sendMultiMsg start uniseq =  " + paramLong);
    }
    Object localObject2;
    Object localObject1;
    Object localObject3;
    int k;
    Object localObject4;
    if (paramLong == 0L)
    {
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
      localObject1 = this.jdField_b_of_type_JavaUtilHashMap;
      localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      k = 1;
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (ChatMessage)((Iterator)localObject3).next();
        if (((localObject4 instanceof MessageForText)) || ((localObject4 instanceof MessageForLongMsg))) {
          break label534;
        }
        k = 0;
      }
    }
    label531:
    label534:
    for (;;)
    {
      break;
      if (k != 0) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800662C", "0X800662C", 0, 1, 0, "", "", "", "");
      }
      if (paramInt2 == 1)
      {
        paramAbsStructMsg = new SessionInfo();
        paramAbsStructMsg.jdField_a_of_type_Int = paramInt1;
        paramAbsStructMsg.jdField_a_of_type_JavaLangString = paramString1;
        paramAbsStructMsg.jdField_b_of_type_JavaLangString = paramString2;
        a(paramQQAppInterface, paramAbsStructMsg, this.jdField_a_of_type_JavaUtilArrayList);
      }
      do
      {
        return;
        if (paramInt2 == 2)
        {
          paramString2 = paramQQAppInterface.getCurrentAccountUin();
          k = MobileQQService.jdField_a_of_type_Int;
          MobileQQService.jdField_a_of_type_Int = k + 1;
          paramString2 = MessageRecordFactory.a(paramQQAppInterface, paramString2, paramString1, paramString2, paramInt1, k, paramAbsStructMsg);
          paramString2.msg = ChatActivityFacade.a((List)localObject2, (Map)localObject1);
          a().a(paramQQAppInterface, paramString1, paramInt1, (ArrayList)localObject2, (HashMap)localObject1, paramString2, paramInt2);
          return;
        }
        paramString2 = (String)localObject2;
        paramAbsStructMsg = ShareMsgHelper.a(paramQQAppInterface, paramString1, paramInt1, paramAbsStructMsg);
      } while (paramAbsStructMsg == null);
      paramAbsStructMsg.isReMultiMsg = true;
      if (paramBoolean) {
        paramQQAppInterface.a().b(paramString1, paramInt1, paramLong);
      }
      a().a(paramQQAppInterface, paramString1, paramInt1, paramString2, (HashMap)localObject1, paramAbsStructMsg, paramInt2);
      return;
      paramString2 = new ArrayList();
      localObject1 = paramQQAppInterface.a().a().a(paramLong).iterator();
      k = 1;
      label346:
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((localObject2 instanceof ChatMessage)) {
          paramString2.add((ChatMessage)localObject2);
        }
        if (((localObject2 instanceof MessageForText)) || ((localObject2 instanceof MessageForLongMsg))) {
          break label531;
        }
        k = 0;
      }
      for (;;)
      {
        break label346;
        if (k != 0) {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800662C", "0X800662C", 0, 1, 0, "", "", "", "");
        }
        localObject1 = new HashMap();
        localObject2 = paramString2.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (MessageRecord)((Iterator)localObject2).next();
          if (!((HashMap)localObject1).containsKey(((MessageRecord)localObject3).senderuin))
          {
            localObject4 = a().a(((MessageRecord)localObject3).senderuin, ((MessageRecord)localObject3).msgseq, paramQQAppInterface);
            ((HashMap)localObject1).put(((MessageRecord)localObject3).senderuin, localObject4);
          }
        }
        break;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, ArrayList paramArrayList, HashMap paramHashMap, MessageRecord paramMessageRecord, int paramInt2)
  {
    a(paramQQAppInterface, paramString, paramInt1, paramArrayList, paramHashMap, paramMessageRecord, paramInt2, null);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, ArrayList paramArrayList, HashMap paramHashMap, MessageRecord paramMessageRecord, int paramInt2, @Nullable Bundle paramBundle)
  {
    if (paramMessageRecord == null) {}
    while ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    paramQQAppInterface.a(new aeji(this, paramArrayList, paramInt2, paramHashMap, paramMessageRecord, paramQQAppInterface, paramString, paramInt1, paramBundle));
  }
  
  public void a(QQAppInterface paramQQAppInterface, List paramList, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean) {}
    for (int k = 0;; k = 1)
    {
      localHashMap.put("result", k + "");
      if (paramList == null) {
        break;
      }
      k = paramList.size();
      int m = a().a(paramList);
      localHashMap.put("msgCount", k + "");
      localHashMap.put("picCount", m + "");
      StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.getCurrentAccountUin(), "multiMsgReceive", paramBoolean, 0L, 0L, localHashMap, "");
      return;
    }
    StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.getCurrentAccountUin(), "multiMsgReceive", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public void a(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramChatMessage == null) {
      return;
    }
    LoveLanguageManager.a(paramChatMessage);
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForLongMsg)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        if (paramChatMessage.uniseq == localChatMessage.uniseq)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(localChatMessage, Boolean.valueOf(paramBoolean));
          return;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramChatMessage, Boolean.valueOf(paramBoolean));
  }
  
  public void a(MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface)
  {
    if (this.i != 0) {}
    String str1;
    do
    {
      do
      {
        return;
      } while ((this.h != 0) && (PicPreDownloadUtils.a(paramQQAppInterface, paramMessageForStructing.istroop, paramMessageForStructing.frienduin) == 1));
      str1 = ((StructMsgForGeneralShare)paramMessageForStructing.structingMsg).mResid;
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MultiMsg", 2, "preDownloadRes failed by empty resid!");
    return;
    String str2 = paramMessageForStructing.frienduin;
    int k = paramMessageForStructing.istroop;
    long l = paramMessageForStructing.uniseq;
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "preDownloadRes begin! touin:" + str2 + ",touinType:" + k + ",uniseq:" + l + ",fileKey:" + str1);
    }
    a().a(paramQQAppInterface, str1, paramQQAppInterface.getCurrentAccountUin(), str2, str2, k, l, 1035, null);
  }
  
  /* Error */
  public void a(HashMap paramHashMap, long paramLong, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +184 -> 185
    //   4: aload_1
    //   5: invokevirtual 514	java/util/HashMap:size	()I
    //   8: ifle +177 -> 185
    //   11: new 75	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 76	java/util/ArrayList:<init>	()V
    //   18: astore 5
    //   20: aload_1
    //   21: invokevirtual 569	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   24: invokeinterface 572 1 0
    //   29: astore_1
    //   30: aload_1
    //   31: invokeinterface 478 1 0
    //   36: ifeq +78 -> 114
    //   39: aload_1
    //   40: invokeinterface 482 1 0
    //   45: checkcast 574	java/util/Map$Entry
    //   48: astore 7
    //   50: aload 7
    //   52: invokeinterface 585 1 0
    //   57: checkcast 525	java/lang/String
    //   60: astore 6
    //   62: aload 7
    //   64: invokeinterface 577 1 0
    //   69: checkcast 525	java/lang/String
    //   72: astore 7
    //   74: new 520	com/tencent/mobileqq/multimsg/MultiMsgNick
    //   77: dup
    //   78: invokespecial 547	com/tencent/mobileqq/multimsg/MultiMsgNick:<init>	()V
    //   81: astore 8
    //   83: aload 8
    //   85: aload 6
    //   87: putfield 523	com/tencent/mobileqq/multimsg/MultiMsgNick:uin	Ljava/lang/String;
    //   90: aload 8
    //   92: lload_2
    //   93: putfield 530	com/tencent/mobileqq/multimsg/MultiMsgNick:uniseq	J
    //   96: aload 8
    //   98: aload 7
    //   100: putfield 533	com/tencent/mobileqq/multimsg/MultiMsgNick:nick	Ljava/lang/String;
    //   103: aload 5
    //   105: aload 8
    //   107: invokevirtual 767	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   110: pop
    //   111: goto -81 -> 30
    //   114: aload 4
    //   116: invokevirtual 540	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   119: invokevirtual 546	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   122: astore 4
    //   124: aload 4
    //   126: invokevirtual 858	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 862	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   134: aload 5
    //   136: invokevirtual 717	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   139: astore 5
    //   141: aload 5
    //   143: invokeinterface 478 1 0
    //   148: ifeq +38 -> 186
    //   151: aload 4
    //   153: aload 5
    //   155: invokeinterface 482 1 0
    //   160: checkcast 520	com/tencent/mobileqq/multimsg/MultiMsgNick
    //   163: invokevirtual 865	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   166: goto -25 -> 141
    //   169: astore 5
    //   171: aload 5
    //   173: invokevirtual 868	java/lang/Exception:printStackTrace	()V
    //   176: aload_1
    //   177: invokevirtual 869	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   180: aload 4
    //   182: invokevirtual 870	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   185: return
    //   186: aload_1
    //   187: invokevirtual 872	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   190: aload_1
    //   191: invokevirtual 869	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   194: goto -14 -> 180
    //   197: astore 4
    //   199: aload_1
    //   200: invokevirtual 869	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   203: aload 4
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	MultiMsgManager
    //   0	206	1	paramHashMap	HashMap
    //   0	206	2	paramLong	long
    //   0	206	4	paramQQAppInterface	QQAppInterface
    //   18	136	5	localObject1	Object
    //   169	3	5	localException	java.lang.Exception
    //   60	26	6	str	String
    //   48	51	7	localObject2	Object
    //   81	25	8	localMultiMsgNick	MultiMsgNick
    // Exception table:
    //   from	to	target	type
    //   130	141	169	java/lang/Exception
    //   141	166	169	java/lang/Exception
    //   186	190	169	java/lang/Exception
    //   130	141	197	finally
    //   141	166	197	finally
    //   171	176	197	finally
    //   186	190	197	finally
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      if (((ChatMessage)paramList.get(0)).isLongMsg()) {
        break;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (ChatMessage)paramList.next();
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) {
          this.jdField_a_of_type_JavaUtilHashMap.remove(localObject);
        }
      }
    }
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      ChatMessage localChatMessage1 = (ChatMessage)((Map.Entry)((Iterator)localObject).next()).getKey();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage2 = (ChatMessage)localIterator.next();
        if ((localChatMessage2.shmsgseq == localChatMessage1.shmsgseq) && (localChatMessage2.msgUid == localChatMessage1.msgUid)) {
          ((Iterator)localObject).remove();
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006628", "0X8006628", 0, 1, 0, "", "", "", "");
    return a(paramQQAppInterface, paramLong).size() > 0;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, long paramLong, int paramInt2, DownCallBack paramDownCallBack)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {}
      return false;
    }
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_a_of_type_Boolean = false;
    localTransferRequest.jdField_b_of_type_Int = 131078;
    localTransferRequest.jdField_l_of_type_JavaLangString = paramString1;
    localTransferRequest.jdField_b_of_type_JavaLangString = paramString2;
    localTransferRequest.c = paramString3;
    localTransferRequest.d = paramString4;
    localTransferRequest.jdField_a_of_type_Int = paramInt1;
    localTransferRequest.jdField_a_of_type_Long = paramLong;
    localTransferRequest.jdField_e_of_type_Int = paramInt2;
    localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack = paramDownCallBack;
    paramQQAppInterface.a().a(localTransferRequest);
    return true;
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForLongMsg)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        if ((localChatMessage != null) && (paramChatMessage.uniseq == localChatMessage.uniseq) && (this.jdField_a_of_type_JavaUtilHashMap.get(localChatMessage) != null)) {
          return ((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localChatMessage)).booleanValue();
        }
      }
      return false;
    }
    if ((paramChatMessage != null) && (this.jdField_a_of_type_JavaUtilHashMap.get(paramChatMessage) != null)) {
      return ((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(paramChatMessage)).booleanValue();
    }
    return false;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void b(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      Collections.sort(paramList, jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager);
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (a().e() >= a().a()) {
      bool = true;
    }
    return bool;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = a(paramQQAppInterface, paramLong);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      Iterator localIterator1 = paramQQAppInterface.iterator();
      if (localIterator1.hasNext())
      {
        paramQQAppInterface = (ChatMessage)localIterator1.next();
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 4, " isContainedNotExistPic ChatMessage = " + paramQQAppInterface.getClass().getName());
        }
        if ((paramQQAppInterface instanceof MessageForPic)) {
          paramQQAppInterface = (MessageForPic)paramQQAppInterface;
        }
        label99:
        Iterator localIterator2;
        Object localObject;
        for (;;)
        {
          if ((paramQQAppInterface != null) && (!URLDrawableHelper.a(null, paramQQAppInterface, 65537)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("MultiMsg", 4, " isContainedNotExistPic is = true ");
            }
            return true;
            if ((paramQQAppInterface instanceof MessageForMixedMsg))
            {
              localIterator2 = ((MessageForMixedMsg)paramQQAppInterface).msgElemList.iterator();
              localObject = null;
              label155:
              paramQQAppInterface = (QQAppInterface)localObject;
              if (!localIterator2.hasNext()) {
                continue;
              }
              paramQQAppInterface = (MessageRecord)localIterator2.next();
              if (!(paramQQAppInterface instanceof MessageForPic)) {
                break label406;
              }
            }
          }
        }
        label272:
        label403:
        label404:
        label406:
        for (paramQQAppInterface = (MessageForPic)paramQQAppInterface;; paramQQAppInterface = (QQAppInterface)localObject)
        {
          localObject = paramQQAppInterface;
          break label155;
          if (paramQQAppInterface.msgtype == -1036)
          {
            localIterator2 = ((MessageForLongMsg)paramQQAppInterface).longMsgFragmentList.iterator();
            localObject = null;
            Iterator localIterator3;
            do
            {
              do
              {
                paramQQAppInterface = (QQAppInterface)localObject;
                if (!localIterator2.hasNext()) {
                  break;
                }
                paramQQAppInterface = (MessageRecord)localIterator2.next();
              } while (!(paramQQAppInterface instanceof MessageForMixedMsg));
              localIterator3 = ((MessageForMixedMsg)paramQQAppInterface).msgElemList.iterator();
              paramQQAppInterface = (QQAppInterface)localObject;
              localObject = paramQQAppInterface;
            } while (!localIterator3.hasNext());
            localObject = (MessageRecord)localIterator3.next();
            if (!(localObject instanceof MessageForPic)) {
              break label403;
            }
            paramQQAppInterface = (MessageForPic)localObject;
          }
          for (;;)
          {
            break label272;
            if (!(paramQQAppInterface instanceof MessageForStructing)) {
              break label404;
            }
            paramQQAppInterface = ((MessageForStructing)paramQQAppInterface).structingMsg;
            if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof StructMsgForImageShare)))
            {
              localObject = ((StructMsgForImageShare)paramQQAppInterface).getFirstImageElement();
              if ((localObject != null) && (((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null))
              {
                if (((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
                  ((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)paramQQAppInterface);
                }
                ((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((StructMsgItemImage)localObject).a();
                paramQQAppInterface = ((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
                break label99;
              }
            }
            paramQQAppInterface = null;
            break label99;
            break;
          }
          break;
        }
      }
    }
    return false;
  }
  
  public int c()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public boolean c()
  {
    boolean bool = false;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    int k = 0;
    Object localObject1;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject1 = (ChatMessage)localIterator.next();
        if (((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1)).booleanValue()) {
          if ((localObject1 instanceof MessageForPic)) {
            k += 1;
          }
        }
      }
    }
    for (;;)
    {
      break;
      if ((localObject1 instanceof MessageForMixedMsg))
      {
        localObject1 = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          if (((MessageRecord)((Iterator)localObject1).next() instanceof MessageForPic)) {
            k += 1;
          }
        }
      }
      else
      {
        int m = k;
        if (((ChatMessage)localObject1).msgtype == -1036)
        {
          localObject1 = ((MessageForLongMsg)localObject1).longMsgFragmentList.iterator();
          do
          {
            m = k;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
          } while (!(localObject2 instanceof MessageForMixedMsg));
          Object localObject2 = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
          m = k;
          for (;;)
          {
            k = m;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            if (((MessageRecord)((Iterator)localObject2).next() instanceof MessageForPic)) {
              m += 1;
            }
          }
          if (k >= a().b()) {
            bool = true;
          }
          return bool;
        }
        k = m;
      }
    }
  }
  
  public int d()
  {
    return this.j;
  }
  
  public boolean d()
  {
    boolean bool = false;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    int k = 0;
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localChatMessage)).booleanValue())
      {
        if (!(localChatMessage instanceof MessageForShortVideo)) {
          break label84;
        }
        k += 1;
      }
    }
    label84:
    for (;;)
    {
      break;
      if (k >= a().c()) {
        bool = true;
      }
      return bool;
    }
  }
  
  public int e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    int k = 0;
    if (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (!((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localChatMessage)).booleanValue()) {
        break label60;
      }
      k += 1;
    }
    label60:
    for (;;)
    {
      break;
      return k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgManager
 * JD-Core Version:    0.7.0.1
 */