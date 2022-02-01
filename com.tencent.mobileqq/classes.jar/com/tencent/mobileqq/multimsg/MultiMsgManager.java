package com.tencent.mobileqq.multimsg;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.activity.aio.stickerrecommended.ad.AdEmoReportUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.jubao.JubaoIPCServer;
import com.tencent.mobileqq.msgbackup.util.MsgBackupRichTextParse;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.receipt.ReceiptMsgManager.ReceiptMsgUploadCallback;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoForwardInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.SharedPreUtils;
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
  implements IUpLoadMsgPackBusinessType, Comparator<ChatMessage>
{
  private static long jdField_a_of_type_Long;
  private static MultiMsgManager jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager;
  public static final String a;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public int a;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private LongSparseArray<Integer> jdField_a_of_type_ComTencentUtilLongSparseArray;
  public ArrayList<ChatMessage> a;
  public HashMap<ChatMessage, Boolean> a;
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  public HashMap<String, String> b;
  private int jdField_c_of_type_Int = 100;
  private HashMap<Long, List<MultiMsgNick>> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  private int d = 20;
  private int e = 10;
  private int f = 100;
  private int g = 10;
  private int h = 0;
  private int i = 0;
  private int j;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("fight/pic_expire.png");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public MultiMsgManager()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Int = 0;
  }
  
  private int a(int paramInt)
  {
    int k = 3;
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 3)
      {
        if (paramInt == 4) {
          return k;
        }
        if (paramInt != 6) {
          return 0;
        }
      }
      return 2;
    }
    else
    {
      k = 1;
    }
    return k;
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
    if (jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager == null) {
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if (jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager == null) {
          jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager = new MultiMsgManager();
        }
      }
    }
    return jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager;
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    if (!new File(jdField_a_of_type_JavaLangString).exists())
    {
      FileUtils.copyResToFile(paramQQAppInterface.getApp(), 2130841561, jdField_a_of_type_JavaLangString);
      paramQQAppInterface = FileUtils.calcMd5(jdField_a_of_type_JavaLangString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("chatthumb:");
      localStringBuilder.append(paramQQAppInterface);
      paramQQAppInterface = AbsDownloader.getFilePath(localStringBuilder.toString());
      FileUtils.copyFile(jdField_a_of_type_JavaLangString, paramQQAppInterface);
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  private void a(long paramLong, int paramInt)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateFinishMaskForReceiptMessage uniseq: ");
        localStringBuilder.append(paramLong);
        localStringBuilder.append(" mask:");
        localStringBuilder.append(paramInt);
        QLog.d("MultiMsg_TAG", 2, localStringBuilder.toString());
      }
      if (this.jdField_a_of_type_ComTencentUtilLongSparseArray != null)
      {
        paramInt ^= ((Integer)this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(paramLong, Integer.valueOf(0))).intValue();
        if (paramInt != 0) {
          this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(paramLong, Integer.valueOf(paramInt));
        } else {
          this.jdField_a_of_type_ComTencentUtilLongSparseArray.b(paramLong);
        }
      }
      return;
    }
    finally {}
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, int paramInt2, @Nullable Bundle paramBundle)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)paramArrayList.get(0);
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mSelfUin = paramQQAppInterface.getAccount();
    localTransferRequest.mPeerUin = paramString;
    localTransferRequest.mUinType = paramInt1;
    localTransferRequest.mFileType = 2;
    localTransferRequest.mUniseq = ((MessageRecord)paramArrayList.get(0)).uniseq;
    boolean bool2 = true;
    localTransferRequest.mIsUp = true;
    String str;
    if (paramBundle != null) {
      str = paramBundle.getString("ReceiptMsgManager.EXTRA_KEY_PTT_PATH");
    } else {
      str = localMessageForPtt.fullLocalPath;
    }
    localTransferRequest.mLocalPath = str;
    localTransferRequest.mBusiType = 1002;
    boolean bool1 = bool2;
    if (paramBundle != null) {
      if (paramBundle.getBoolean("ReceiptMsgManager.EXTRA_KEY_PTT_COMPRESS_FINISHED")) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    localTransferRequest.mPttCompressFinish = bool1;
    int k;
    if (paramBundle != null) {
      k = a(paramBundle.getInt("ReceiptMsgManager.EXTRA_KEY_PTT_SEND_SOURCE"));
    } else {
      k = 0;
    }
    localTransferRequest.mPttUploadPanel = k;
    localTransferRequest.mRec = ((MessageRecord)paramArrayList.get(0));
    localMessageForPtt.mInputContent = "";
    localTransferRequest.mUpCallBack = new MultiMsgManager.PttUploadCallback(paramMessageRecord, paramArrayList, paramQQAppInterface, paramString, paramInt1, paramInt2, this, null);
    localTransferRequest.needSendMsg = false;
    ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, ArrayList<MessageRecord> paramArrayList, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isDevelopLevel())
    {
      QLog.d("MultiMsg_TAG", 4, "pack multi msg start.............................");
      QLog.d("MultiMsg_TAG", 4, paramArrayList.toString());
    }
    paramMessageObserver = paramQQAppInterface.getProxyManager().a().a(paramArrayList, paramHashMap, paramBoolean);
    if (paramMessageObserver == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "pack multi msg failed.............................");
      }
      if (paramInt2 == 2)
      {
        ((MessageHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(8031, false, Integer.valueOf(4));
        return;
      }
      paramMessageRecord.extraflag = 32768;
      paramQQAppInterface.getMsgCache().a(paramString, paramInt1, paramMessageRecord.uniseq);
      long l = paramMessageRecord.uniseq;
      ((MessageHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.a(paramInt1), false, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "pack multi msg done.............................");
    }
    if (paramInt2 == 0) {}
    for (paramHashMap = new MultiMsgManager.MultiMsgUploadCallback(paramQQAppInterface, paramMessageRecord, paramString, paramInt1);; paramHashMap = new ReceiptMsgManager.ReceiptMsgUploadCallback(paramQQAppInterface, paramMessageRecord, paramString, paramInt1))
    {
      break;
      if (paramInt2 == 2)
      {
        paramHashMap = new MultiMsgManager.MsgForwardWXUploadCallback(paramQQAppInterface, paramMessageRecord, paramString, paramInt1, paramArrayList, paramHashMap);
        break;
      }
      if (paramInt2 != 5) {
        break label329;
      }
    }
    if (a(paramQQAppInterface, paramMessageObserver, paramQQAppInterface.getCurrentAccountUin(), paramString, paramString, paramInt1, paramMessageRecord.uniseq, 1035, paramHashMap))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "sendMultiMsg successful, upload multi msg pack start.......................");
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "sendMultiMsg failed.......................");
    }
    return;
    label329:
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("not support forwardMode:");
    paramQQAppInterface.append(paramInt2);
    QLog.e("MultiMsg_TAG", 1, paramQQAppInterface.toString());
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, ArrayList<PicFowardInfo> paramArrayList1, int paramInt2)
  {
    PicReq localPicReq = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(8, 7);
    localPicReq.a(paramArrayList1);
    localPicReq.a(new MultiMsgManager.3(this, paramInt2, paramMessageRecord, paramArrayList, paramQQAppInterface, paramString, paramInt1, paramHashMap));
    ((IPicBus)QRoute.api(IPicBus.class)).launch(localPicReq);
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, ArrayList<ShortVideoForwardInfo> paramArrayList1, ShortVideoReq paramShortVideoReq, int paramInt2)
  {
    if (paramShortVideoReq == null) {
      paramShortVideoReq = SVBusiUtil.a(5, 5);
    }
    paramShortVideoReq.a(paramArrayList1);
    paramShortVideoReq.a(new MultiMsgManager.4(this, paramArrayList, paramMessageRecord, paramQQAppInterface, paramString, paramInt1, paramHashMap, paramInt2));
    ShortVideoBusiManager.a(paramShortVideoReq, paramQQAppInterface);
  }
  
  private void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramMessageRecord.extraflag = 32768;
    paramQQAppInterface.getMsgCache().a(paramString, paramInt, paramMessageRecord.uniseq);
    paramQQAppInterface.getMessageFacade().a(paramString, paramInt, paramMessageRecord.uniseq, 32768, -1);
    long l = paramMessageRecord.uniseq;
    ((MessageHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.a(paramInt), false, new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  private boolean a(long paramLong)
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentUtilLongSparseArray;
      boolean bool = false;
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "isReceiptMessageFinished map null and res: false");
        }
        return false;
      }
      if (((Integer)this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(paramLong, Integer.valueOf(0))).intValue() == 0) {
        bool = true;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("isReceiptMessageFinished res: ");
        ((StringBuilder)localObject1).append(bool);
        QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject1).toString());
      }
      return bool;
    }
    finally {}
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, UpCallBack paramUpCallBack)
  {
    return a(paramQQAppInterface, paramArrayOfByte, paramString1, paramString2, paramString3, paramInt1, paramLong, paramInt2, false, paramUpCallBack);
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, UpCallBack paramUpCallBack)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[sendMultiMsg]data.length = ");
      ((StringBuilder)localObject).append(paramArrayOfByte.length);
      QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new TransferRequest();
    ((TransferRequest)localObject).mIsUp = true;
    ((TransferRequest)localObject).mFileType = 131078;
    ((TransferRequest)localObject).multiMsgType = 0;
    ((TransferRequest)localObject).toSendData = paramArrayOfByte;
    ((TransferRequest)localObject).mSelfUin = paramString1;
    ((TransferRequest)localObject).mPeerUin = paramString2;
    ((TransferRequest)localObject).mSecondId = paramString3;
    ((TransferRequest)localObject).mUinType = paramInt1;
    ((TransferRequest)localObject).mUniseq = paramLong;
    ((TransferRequest)localObject).mBusiType = paramInt2;
    ((TransferRequest)localObject).upMsgBusiType = d();
    ((TransferRequest)localObject).mUpCallBack = paramUpCallBack;
    if (paramBoolean) {
      ((TransferRequest)localObject).isJubaoMsgType = true;
    }
    ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync((TransferRequest)localObject);
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateFinishMask mask: ");
      localStringBuilder.append(paramInt);
      QLog.d("MultiMsg_TAG", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_Int = (paramInt ^ this.jdField_b_of_type_Int);
  }
  
  private boolean b(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, UpCallBack paramUpCallBack)
  {
    return a(paramQQAppInterface, paramArrayOfByte, paramString1, paramString2, paramString3, paramInt1, paramLong, paramInt2, true, paramUpCallBack);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int != 7) {
      return this.jdField_c_of_type_Int;
    }
    return 50;
  }
  
  public int a(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    if ((paramChatMessage1.istroop != 1) && (paramChatMessage1.istroop != 3000))
    {
      if (paramChatMessage1.time == paramChatMessage2.time)
      {
        if (paramChatMessage1.getId() > paramChatMessage2.getId()) {
          return 1;
        }
        if (paramChatMessage1.getId() < paramChatMessage2.getId()) {
          return -1;
        }
        return 0;
      }
      if (paramChatMessage1.time > paramChatMessage2.time) {
        return 1;
      }
      return -1;
    }
    if (paramChatMessage1.shmsgseq == paramChatMessage2.shmsgseq)
    {
      if (paramChatMessage1.getId() > paramChatMessage2.getId()) {
        return 1;
      }
      if (paramChatMessage1.getId() < paramChatMessage2.getId()) {
        return -1;
      }
      return 0;
    }
    if (paramChatMessage1.shmsgseq > paramChatMessage2.shmsgseq) {
      return 1;
    }
    return -1;
  }
  
  public int a(Collection<ChatMessage> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    int k = 0;
    while (paramCollection.hasNext())
    {
      Object localObject1 = (ChatMessage)paramCollection.next();
      if ((localObject1 instanceof MessageForPic))
      {
        k += 1;
      }
      else
      {
        int m;
        if ((localObject1 instanceof MessageForMixedMsg))
        {
          localObject1 = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
          m = k;
          for (;;)
          {
            k = m;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            if (((MessageRecord)((Iterator)localObject1).next() instanceof MessageForPic)) {
              m += 1;
            }
          }
        }
        if (((ChatMessage)localObject1).msgtype == -1036)
        {
          localObject1 = ((MessageForLongMsg)localObject1).longMsgFragmentList.iterator();
          m = k;
          do
          {
            k = m;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
          } while (!(localObject2 instanceof MessageForMixedMsg));
          Object localObject2 = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
          k = m;
          for (;;)
          {
            m = k;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            if (((MessageRecord)((Iterator)localObject2).next() instanceof MessageForPic)) {
              k += 1;
            }
          }
        }
      }
    }
    return k;
  }
  
  public SessionInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public MessageForStructing a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, AbsStructMsg paramAbsStructMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, " favorMultiMsg start: ");
    }
    paramString2 = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = MessageRecordFactory.a(paramQQAppInterface, paramString2, paramString1, paramString2, paramInt, 0L, paramAbsStructMsg);
    paramQQAppInterface.isReMultiMsg = true;
    return (MessageForStructing)paramQQAppInterface;
  }
  
  public String a(String paramString, long paramLong, QQAppInterface paramQQAppInterface)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramLong == 0L) {
        return null;
      }
      Object localObject;
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
      paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager().query(MultiMsgNick.class, new MultiMsgNick().getTableName(), false, "uniseq = ?", new String[] { String.valueOf(paramLong) }, null, null, null, null);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
      {
        this.jdField_c_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), paramQQAppInterface);
        paramQQAppInterface = paramQQAppInterface.iterator();
        while (paramQQAppInterface.hasNext())
        {
          localObject = (MultiMsgNick)paramQQAppInterface.next();
          if ((localObject != null) && (paramString.equals(((MultiMsgNick)localObject).uin)) && (paramLong == ((MultiMsgNick)localObject).uniseq)) {
            return ((MultiMsgNick)localObject).nick;
          }
        }
      }
    }
    return null;
  }
  
  public List<ChatMessage> a()
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
  
  public List<ChatMessage> a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return a(paramQQAppInterface, paramLong, null, 0);
  }
  
  public List<ChatMessage> a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt)
  {
    Object localObject1 = paramQQAppInterface.getProxyManager().a().a(paramLong);
    if (paramString != null) {
      MsgProxyUtils.a(paramString, paramInt, (List)localObject1, paramQQAppInterface.getMsgCache());
    }
    paramQQAppInterface = new ArrayList();
    paramString = ((List)localObject1).iterator();
    while (paramString.hasNext())
    {
      localObject1 = (MessageRecord)paramString.next();
      Object localObject2;
      if ((localObject1 instanceof MessageForStructing))
      {
        localObject2 = (MessageForStructing)localObject1;
        if (((MessageForStructing)localObject2).structingMsg == null) {
          ((MessageForStructing)localObject2).structingMsg = StructMsgFactory.a(((MessageRecord)localObject1).msgData);
        }
      }
      if ((localObject1 instanceof MessageForQQStoryComment)) {
        ((MessageForQQStoryComment)localObject1).displayType = 1;
      }
      paramQQAppInterface.add((ChatMessage)localObject1);
      if ((QLog.isColorLevel()) && ((localObject1 instanceof MessageForPic)))
      {
        localObject1 = (MessageForPic)localObject1;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[chatPie.getMultiMsgList] = ");
        ((StringBuilder)localObject2).append(((MessageForPic)localObject1).toLogString());
        ((StringBuilder)localObject2).append(" mr = ");
        ((StringBuilder)localObject2).append(((MessageForPic)localObject1).toString());
        QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject2).toString());
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
    int k;
    if (paramQQAppInterface != null)
    {
      String str1 = paramQQAppInterface.getServerConfigValue(ServerConfigManager.ConfigType.user, "MMF_enable");
      paramQQAppInterface.getServerConfigValue(ServerConfigManager.ConfigType.user, "MMF_maxMsgNum");
      str2 = paramQQAppInterface.getServerConfigValue(ServerConfigManager.ConfigType.user, "MMF_maxPicNum");
      localObject = paramQQAppInterface.getServerConfigValue(ServerConfigManager.ConfigType.user, "MMF_maxVideoNum");
      k = SharedPreUtils.a(paramQQAppInterface.getCurrentUin(), "multimsg_config");
      if (k > 0) {
        this.jdField_c_of_type_Int = k;
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("initLimitCount enable = ");
        paramQQAppInterface.append(str1);
        paramQQAppInterface.append(" maxMsgNum = ");
        paramQQAppInterface.append(k);
        paramQQAppInterface.append(" maxPicNum ");
        paramQQAppInterface.append(str2);
        QLog.d("MultiMsg_TAG", 2, paramQQAppInterface.toString());
      }
      if (TextUtils.isEmpty(str2)) {}
    }
    try
    {
      this.d = Integer.parseInt(str2);
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      label158:
      break label158;
    }
    this.d = 20;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      this.e = Integer.parseInt((String)localObject);
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      label182:
      break label182;
    }
    this.e = 10;
    paramQQAppInterface = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.MultiMsgConfig.name(), "100|10|0|0");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initLimitCount delayConfi = ");
      ((StringBuilder)localObject).append(paramQQAppInterface);
      QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(paramQQAppInterface))
    {
      localObject = new Integer[4];
      Arrays.fill((Object[])localObject, Integer.valueOf(0));
      if (((IDPCApi)QRoute.api(IDPCApi.class)).parseComplexParamsByStringToIntParser(paramQQAppInterface, (Integer[])localObject) >= localObject.length)
      {
        if (localObject[0].intValue() >= 0)
        {
          this.f = localObject[0].intValue();
          if (localObject[1].intValue() > 0) {
            k = localObject[1].intValue();
          } else {
            k = this.g;
          }
          this.g = k;
        }
        if (localObject[2].intValue() >= 0) {
          k = localObject[2].intValue();
        } else {
          k = this.h;
        }
        this.h = k;
        if (localObject[3].intValue() >= 0) {
          k = localObject[3].intValue();
        } else {
          k = this.i;
        }
        this.i = k;
      }
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArrayList<ChatMessage> paramArrayList)
  {
    a(paramQQAppInterface, paramSessionInfo, paramArrayList, 0);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArrayList<ChatMessage> paramArrayList, int paramInt)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList(paramArrayList);
      ((IOrderMediaMsgService)paramQQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).enqueueMediaMsgByMsgList(paramSessionInfo.jdField_a_of_type_JavaLangString, paramArrayList);
      paramQQAppInterface.execute(new MultiMsgManager.1(this, paramSessionInfo, localArrayList, paramQQAppInterface, paramInt));
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    paramQQAppInterface.execute(new MultiMsgManager.5(this, paramQQAppInterface, paramString, paramInt, paramLong, paramBoolean));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, UpCallBack paramUpCallBack)
  {
    paramString2 = new ArrayList(JubaoIPCServer.a().a());
    Iterator localIterator = paramString2.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (((localMessageRecord instanceof MsgBackupRichTextParse)) && ((localMessageRecord instanceof MessageForRichText))) {
        ((MessageForRichText)localMessageRecord).richText = ((MsgBackupRichTextParse)localMessageRecord).getRichText();
      }
    }
    b(paramQQAppInterface, paramQQAppInterface.getProxyManager().a().a(paramString2, null, true), paramQQAppInterface.getCurrentAccountUin(), paramString1, paramString1, paramInt, 0L, 1035, paramUpCallBack);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, AbsStructMsg paramAbsStructMsg, long paramLong, boolean paramBoolean, int paramInt2)
  {
    a(paramQQAppInterface, paramString1, paramInt1, paramString2, paramAbsStructMsg, paramLong, paramBoolean, paramInt2, -1, new Bundle());
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, AbsStructMsg paramAbsStructMsg, long paramLong, boolean paramBoolean, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" sendMultiMsg start uniseq =  ");
      ((StringBuilder)localObject1).append(paramLong);
      QLog.d("MultiMsg_TAG", 4, ((StringBuilder)localObject1).toString());
    }
    HashMap localHashMap1 = null;
    Object localObject1 = null;
    Object localObject2;
    label68:
    Object localObject3;
    Object localObject4;
    if (paramLong == 0L)
    {
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (k = 1; ((Iterator)localObject2).hasNext(); k = 0)
      {
        localObject3 = (ChatMessage)((Iterator)localObject2).next();
        if (((localObject3 instanceof MessageForText)) || ((localObject3 instanceof MessageForLongMsg))) {
          break label68;
        }
      }
      if (k != 0) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800662C", "0X800662C", 0, 1, 0, "", "", "", "");
      }
      localObject4 = new ArrayList();
      ((ArrayList)localObject4).addAll(this.jdField_a_of_type_JavaUtilArrayList);
      localHashMap1 = new HashMap();
      localHashMap1.putAll(this.jdField_b_of_type_JavaUtilHashMap);
      if (paramInt2 == 0) {
        k = 3;
      } else if (paramInt2 == 1) {
        k = 2;
      } else {
        k = 0;
      }
      new AdEmoReportUtil().a(paramQQAppInterface, paramString1, (ArrayList)localObject4, k);
      if (paramInt2 == 1)
      {
        paramAbsStructMsg = new SessionInfo();
        paramAbsStructMsg.jdField_a_of_type_Int = paramInt1;
        paramAbsStructMsg.jdField_a_of_type_JavaLangString = paramString1;
        paramAbsStructMsg.b = paramString2;
        paramAbsStructMsg.a(paramBundle);
        a(paramQQAppInterface, paramAbsStructMsg, (ArrayList)localObject4, paramInt3);
        return;
      }
      if (paramInt2 == 2)
      {
        paramBundle = paramQQAppInterface.getCurrentAccountUin();
        k = MobileQQService.seq;
        MobileQQService.seq = k + 1;
        paramBundle = MessageRecordFactory.a(paramQQAppInterface, paramBundle, paramString1, paramBundle, 1040, k, paramAbsStructMsg);
        paramBundle.msg = ChatActivityFacade.a((List)localObject4, localHashMap1);
      }
      else
      {
        paramBundle = (Bundle)localObject1;
      }
      localObject3 = paramString1;
      localObject2 = paramQQAppInterface;
      localObject1 = paramString2;
      paramString2 = (String)localObject4;
      localObject4 = localHashMap1;
    }
    else
    {
      localObject4 = new ArrayList();
      paramBundle = paramQQAppInterface.getProxyManager().a().a(paramLong).iterator();
      for (k = 1; paramBundle.hasNext(); k = 0)
      {
        label398:
        localObject1 = (MessageRecord)paramBundle.next();
        if ((localObject1 instanceof ChatMessage)) {
          ((ArrayList)localObject4).add((ChatMessage)localObject1);
        }
        if (((localObject1 instanceof MessageForText)) || ((localObject1 instanceof MessageForLongMsg))) {
          break label398;
        }
      }
      if (k != 0) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800662C", "0X800662C", 0, 1, 0, "", "", "", "");
      }
      localObject3 = paramString1;
      localObject2 = paramQQAppInterface;
      localObject1 = paramString2;
      HashMap localHashMap2 = new HashMap();
      Iterator localIterator = ((ArrayList)localObject4).iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if (!localHashMap2.containsKey(localMessageRecord.senderuin))
        {
          paramBundle = localMessageRecord.getExtInfoFromExtStr("self_nickname");
          paramString2 = paramBundle;
          if (TextUtils.isEmpty(paramBundle)) {
            paramString2 = a(localMessageRecord.senderuin, localMessageRecord.msgseq, (QQAppInterface)localObject2);
          }
          if (paramString2 != null)
          {
            paramBundle = paramString2;
            if (paramString2.trim().length() != 0) {}
          }
          else
          {
            paramBundle = MultiMsgUtil.a(localMessageRecord.senderuin);
          }
          localHashMap2.put(localMessageRecord.senderuin, paramBundle);
        }
      }
      paramString2 = (String)localObject4;
      localObject4 = localHashMap2;
      paramBundle = localHashMap1;
    }
    if (paramBundle == null)
    {
      paramBundle = paramAbsStructMsg;
      paramBundle.forwardID = paramInt3;
      paramBundle = ShareMsgHelper.a((QQAppInterface)localObject2, (String)localObject3, paramInt1, paramBundle);
    }
    int k = paramInt1;
    if (paramBundle != null)
    {
      paramBundle.isReMultiMsg = true;
      ForwardOrderManager.a().a(paramBundle.uniseq, 0L, paramInt3);
      if (paramBoolean) {
        paramQQAppInterface.getMessageFacade().b(paramString1, k, paramLong);
      }
      if ((paramInt2 != 0) && (paramInt2 != 2))
      {
        a(paramQQAppInterface, paramString1, paramInt1, paramString2, (HashMap)localObject4, paramBundle, paramInt2);
        return;
      }
      localObject2 = new MultiMsgRequest();
      localObject3 = new SessionInfo();
      ((SessionInfo)localObject3).jdField_a_of_type_JavaLangString = paramString1;
      ((SessionInfo)localObject3).jdField_a_of_type_Int = k;
      if (paramInt2 == 2)
      {
        ((SessionInfo)localObject3).jdField_a_of_type_Int = 1040;
        ((SessionInfo)localObject3).g = k;
      }
      ((SessionInfo)localObject3).b = ((String)localObject1);
      ((MultiMsgRequest)localObject2).jdField_a_of_type_Int = 0;
      ((MultiMsgRequest)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)localObject3);
      ((MultiMsgRequest)localObject2).jdField_a_of_type_JavaUtilList = paramString2;
      ((MultiMsgRequest)localObject2).jdField_a_of_type_JavaUtilMap = ((Map)localObject4);
      ((MultiMsgRequest)localObject2).jdField_b_of_type_Int = paramInt2;
      ((MultiMsgRequest)localObject2).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = paramAbsStructMsg;
      ((MultiMsgRequest)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = ((MessageForStructing)paramBundle);
      paramQQAppInterface.getMultiMsgController().e((MultiMsgRequest)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, String.format("step.sendRequest:msglistSize = %d", new Object[] { Integer.valueOf(paramString2.size()) }));
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, ArrayList<ChatMessage> paramArrayList, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, int paramInt2)
  {
    a(paramQQAppInterface, paramString, paramInt1, paramArrayList, paramHashMap, paramMessageRecord, paramInt2, null);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, ArrayList<ChatMessage> paramArrayList, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, int paramInt2, @Nullable Bundle paramBundle)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      paramQQAppInterface.execute(new MultiMsgManager.2(this, paramArrayList, paramInt2, paramHashMap, paramMessageRecord, paramQQAppInterface, paramString, paramInt1, paramBundle));
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramBoolean ^ true);
    localStringBuilder.append("");
    localHashMap.put("result", localStringBuilder.toString());
    if (paramList != null)
    {
      int k = paramList.size();
      int m = a().a(paramList);
      paramList = new StringBuilder();
      paramList.append(k);
      paramList.append("");
      localHashMap.put("msgCount", paramList.toString());
      paramList = new StringBuilder();
      paramList.append(m);
      paramList.append("");
      localHashMap.put("picCount", paramList.toString());
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "multiMsgReceive", paramBoolean, 0L, 0L, localHashMap, "");
      return;
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "multiMsgReceive", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  protected void a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, int paramInt, SessionInfo paramSessionInfo)
  {
    Intent localIntent = FileManagerUtil.a(paramQQAppInterface, paramChatMessage);
    if ((localIntent != null) && (localIntent.getExtras() != null))
    {
      ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)localIntent.getExtras().getParcelable("fileinfo");
      String str = localIntent.getStringExtra("forward_filepath");
      if (localForwardFileInfo != null)
      {
        localForwardFileInfo.c(paramChatMessage.uniseq);
        localForwardFileInfo.jdField_a_of_type_Int = paramInt;
        ChatActivityFacade.a(paramQQAppInterface, BaseActivity.sTopActivity, paramSessionInfo, localIntent, str, localForwardFileInfo, false);
      }
    }
  }
  
  public void a(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramChatMessage == null) {
      return;
    }
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
    if (this.i != 0) {
      return;
    }
    if ((this.h != 0) && (((IPicPreDownload)paramQQAppInterface.getRuntimeService(IPicPreDownload.class, "")).calcUinType(paramQQAppInterface, paramMessageForStructing.istroop, paramMessageForStructing.frienduin) == 1)) {
      return;
    }
    String str1 = ((StructMsgForGeneralShare)paramMessageForStructing.structingMsg).mResid;
    if (TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "preDownloadRes failed by empty resid!");
      }
      return;
    }
    String str2 = paramMessageForStructing.frienduin;
    int k = paramMessageForStructing.istroop;
    long l = paramMessageForStructing.uniseq;
    if (QLog.isColorLevel())
    {
      paramMessageForStructing = new StringBuilder();
      paramMessageForStructing.append("preDownloadRes begin! touin:");
      paramMessageForStructing.append(str2);
      paramMessageForStructing.append(",touinType:");
      paramMessageForStructing.append(k);
      paramMessageForStructing.append(",uniseq:");
      paramMessageForStructing.append(l);
      paramMessageForStructing.append(",fileKey:");
      paramMessageForStructing.append(str1);
      QLog.d("MultiMsg_TAG", 2, paramMessageForStructing.toString());
    }
    a().a(paramQQAppInterface, str1, paramQQAppInterface.getCurrentAccountUin(), str2, str2, k, l, 1035, null);
  }
  
  /* Error */
  public void a(HashMap<String, String> paramHashMap, long paramLong, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +204 -> 205
    //   4: aload_1
    //   5: invokevirtual 589	java/util/HashMap:size	()I
    //   8: ifle +197 -> 205
    //   11: new 89	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 90	java/util/ArrayList:<init>	()V
    //   18: astore 5
    //   20: aload_1
    //   21: invokevirtual 645	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   24: invokeinterface 648 1 0
    //   29: astore_1
    //   30: aload_1
    //   31: invokeinterface 539 1 0
    //   36: ifeq +78 -> 114
    //   39: aload_1
    //   40: invokeinterface 543 1 0
    //   45: checkcast 650	java/util/Map$Entry
    //   48: astore 7
    //   50: aload 7
    //   52: invokeinterface 661 1 0
    //   57: checkcast 600	java/lang/String
    //   60: astore 6
    //   62: aload 7
    //   64: invokeinterface 653 1 0
    //   69: checkcast 600	java/lang/String
    //   72: astore 7
    //   74: new 595	com/tencent/mobileqq/multimsg/MultiMsgNick
    //   77: dup
    //   78: invokespecial 622	com/tencent/mobileqq/multimsg/MultiMsgNick:<init>	()V
    //   81: astore 8
    //   83: aload 8
    //   85: aload 6
    //   87: putfield 598	com/tencent/mobileqq/multimsg/MultiMsgNick:uin	Ljava/lang/String;
    //   90: aload 8
    //   92: lload_2
    //   93: putfield 605	com/tencent/mobileqq/multimsg/MultiMsgNick:uniseq	J
    //   96: aload 8
    //   98: aload 7
    //   100: putfield 608	com/tencent/mobileqq/multimsg/MultiMsgNick:nick	Ljava/lang/String;
    //   103: aload 5
    //   105: aload 8
    //   107: invokevirtual 892	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   110: pop
    //   111: goto -81 -> 30
    //   114: aload 4
    //   116: invokevirtual 615	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   119: invokevirtual 621	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   122: astore 4
    //   124: aload 4
    //   126: invokevirtual 1097	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 1102	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   134: aload 5
    //   136: invokevirtual 825	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   139: astore 5
    //   141: aload 5
    //   143: invokeinterface 539 1 0
    //   148: ifeq +21 -> 169
    //   151: aload 4
    //   153: aload 5
    //   155: invokeinterface 543 1 0
    //   160: checkcast 595	com/tencent/mobileqq/multimsg/MultiMsgNick
    //   163: invokevirtual 1106	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   166: goto -25 -> 141
    //   169: aload_1
    //   170: invokevirtual 1109	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   173: goto +15 -> 188
    //   176: astore 4
    //   178: goto +20 -> 198
    //   181: astore 5
    //   183: aload 5
    //   185: invokevirtual 1112	java/lang/Exception:printStackTrace	()V
    //   188: aload_1
    //   189: invokevirtual 1115	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   192: aload 4
    //   194: invokevirtual 1118	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   197: return
    //   198: aload_1
    //   199: invokevirtual 1115	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   202: aload 4
    //   204: athrow
    //   205: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	MultiMsgManager
    //   0	206	1	paramHashMap	HashMap<String, String>
    //   0	206	2	paramLong	long
    //   0	206	4	paramQQAppInterface	QQAppInterface
    //   18	136	5	localObject1	Object
    //   181	3	5	localException	java.lang.Exception
    //   60	26	6	str	String
    //   48	51	7	localObject2	Object
    //   81	25	8	localMultiMsgNick	MultiMsgNick
    // Exception table:
    //   from	to	target	type
    //   130	141	176	finally
    //   141	166	176	finally
    //   169	173	176	finally
    //   183	188	176	finally
    //   130	141	181	java/lang/Exception
    //   141	166	181	java/lang/Exception
    //   169	173	181	java/lang/Exception
  }
  
  public void a(List<ChatMessage> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      if (!((ChatMessage)paramList.get(0)).isLongMsg())
      {
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
      QLog.isColorLevel();
      return false;
    }
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = false;
    localTransferRequest.mFileType = 131078;
    localTransferRequest.resIdStr = paramString1;
    localTransferRequest.mSelfUin = paramString2;
    localTransferRequest.mPeerUin = paramString3;
    localTransferRequest.mSecondId = paramString4;
    localTransferRequest.mUinType = paramInt1;
    localTransferRequest.mUniseq = paramLong;
    localTransferRequest.mBusiType = paramInt2;
    localTransferRequest.mDownCallBack = paramDownCallBack;
    ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
    return true;
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    Object localObject;
    ChatMessage localChatMessage;
    if ((paramChatMessage instanceof MessageForLongMsg))
    {
      localObject = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        localChatMessage = (ChatMessage)((Iterator)localObject).next();
        if ((localChatMessage != null) && (paramChatMessage.uniseq == localChatMessage.uniseq) && (this.jdField_a_of_type_JavaUtilHashMap.get(localChatMessage) != null)) {
          return ((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localChatMessage)).booleanValue();
        }
      }
      return false;
    }
    if (paramChatMessage != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilHashMap.keySet();
      if (((Set)localObject).contains(paramChatMessage)) {
        return ((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(paramChatMessage)).booleanValue();
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localChatMessage = (ChatMessage)((Iterator)localObject).next();
        if (paramChatMessage.uniseq == localChatMessage.uniseq)
        {
          boolean bool = ((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localChatMessage)).booleanValue();
          this.jdField_a_of_type_JavaUtilHashMap.remove(localChatMessage);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramChatMessage, Boolean.valueOf(bool));
          return bool;
        }
      }
    }
    return false;
  }
  
  public boolean a(ChatMessage paramChatMessage, int paramInt)
  {
    int m = c();
    int k;
    if (this.jdField_a_of_type_Int == 7) {
      k = 1;
    } else {
      k = MultiMsgUtil.a(paramChatMessage);
    }
    int n = m + k;
    boolean bool;
    if (n > paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, String.format("isWillBeyondTotalLimit: hasCount = %d,willCheckCount = %d,willTotalCount = %d", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(n) }));
    }
    return bool;
  }
  
  public int b()
  {
    return this.j;
  }
  
  public void b(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramChatMessage == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap.keySet();
    if (((Set)localObject).contains(paramChatMessage))
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramChatMessage, Boolean.valueOf(paramBoolean));
      return;
    }
    int m = 0;
    localObject = ((Set)localObject).iterator();
    ChatMessage localChatMessage;
    do
    {
      k = m;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localChatMessage = (ChatMessage)((Iterator)localObject).next();
    } while (paramChatMessage.uniseq != localChatMessage.uniseq);
    int k = 1;
    this.jdField_a_of_type_JavaUtilHashMap.put(localChatMessage, Boolean.valueOf(paramBoolean));
    if (k == 0) {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramChatMessage, Boolean.valueOf(paramBoolean));
    }
  }
  
  public void b(List<ChatMessage> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      Collections.sort(paramList, jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager);
    }
  }
  
  public boolean b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = a(paramQQAppInterface, paramLong);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      Iterator localIterator1 = paramQQAppInterface.iterator();
      while (localIterator1.hasNext())
      {
        paramQQAppInterface = (ChatMessage)localIterator1.next();
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" isContainedNotExistPic ChatMessage = ");
          ((StringBuilder)localObject).append(paramQQAppInterface.getClass().getName());
          QLog.d("MultiMsg_TAG", 4, ((StringBuilder)localObject).toString());
        }
        if ((paramQQAppInterface instanceof MessageForPic))
        {
          paramQQAppInterface = (MessageForPic)paramQQAppInterface;
        }
        else
        {
          Iterator localIterator2;
          if ((paramQQAppInterface instanceof MessageForMixedMsg))
          {
            localIterator2 = ((MessageForMixedMsg)paramQQAppInterface).msgElemList.iterator();
            paramQQAppInterface = null;
            for (;;)
            {
              localObject = paramQQAppInterface;
              if (!localIterator2.hasNext()) {
                break;
              }
              localObject = (MessageRecord)localIterator2.next();
              if ((localObject instanceof MessageForPic)) {
                paramQQAppInterface = (MessageForPic)localObject;
              }
            }
            paramQQAppInterface = (QQAppInterface)localObject;
          }
          else
          {
            if (paramQQAppInterface.msgtype == -1036)
            {
              localIterator2 = ((MessageForLongMsg)paramQQAppInterface).longMsgFragmentList.iterator();
              paramQQAppInterface = null;
              do
              {
                localObject = paramQQAppInterface;
                if (!localIterator2.hasNext()) {
                  break;
                }
                localObject = (MessageRecord)localIterator2.next();
              } while (!(localObject instanceof MessageForMixedMsg));
              Iterator localIterator3 = ((MessageForMixedMsg)localObject).msgElemList.iterator();
              localObject = paramQQAppInterface;
              for (;;)
              {
                paramQQAppInterface = (QQAppInterface)localObject;
                if (!localIterator3.hasNext()) {
                  break;
                }
                paramQQAppInterface = (MessageRecord)localIterator3.next();
                if ((paramQQAppInterface instanceof MessageForPic)) {
                  localObject = (MessageForPic)paramQQAppInterface;
                }
              }
            }
            if (!(paramQQAppInterface instanceof MessageForStructing)) {
              continue;
            }
            paramQQAppInterface = ((MessageForStructing)paramQQAppInterface).structingMsg;
            if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof StructMsgForImageShare)))
            {
              paramQQAppInterface = (StructMsgForImageShare)paramQQAppInterface;
              localObject = paramQQAppInterface.getFirstImageElement();
              if ((localObject != null) && (((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null))
              {
                if (((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
                  ((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = paramQQAppInterface;
                }
                ((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((StructMsgItemImage)localObject).a();
                paramQQAppInterface = ((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
                break label385;
              }
            }
            paramQQAppInterface = null;
          }
        }
        label385:
        if ((paramQQAppInterface != null) && (!URLDrawableHelper.hasDiskCache(null, paramQQAppInterface, 65537)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 4, " isContainedNotExistPic is = true ");
          }
          return true;
        }
      }
    }
    return false;
  }
  
  public int c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    int k = 0;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      int m = 1;
      if (!bool) {
        break;
      }
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localChatMessage)).booleanValue())
      {
        if (this.jdField_a_of_type_Int != 7) {
          m = MultiMsgUtil.a(localChatMessage);
        }
        k += m;
      }
    }
    MultiMsgUtil.b("checkMap.size = %d,count= %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilHashMap.size()), Integer.valueOf(k) });
    return k;
  }
  
  public int d()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgManager
 * JD-Core Version:    0.7.0.1
 */