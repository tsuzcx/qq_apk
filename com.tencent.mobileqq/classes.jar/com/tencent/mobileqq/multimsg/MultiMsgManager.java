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
import com.tencent.mobileqq.data.MessageForAniSticker;
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
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.AniStickerSendMessageCallBack;
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
  public static final String a;
  private static byte[] f = new byte[0];
  private static MultiMsgManager g;
  private static long t;
  public HashMap<ChatMessage, Boolean> b = new HashMap();
  public ArrayList<ChatMessage> c = new ArrayList();
  public HashMap<String, String> d = new HashMap();
  public int e = 0;
  private int h = 0;
  private LongSparseArray<Integer> i;
  private int j = 100;
  private int k = 20;
  private int l = 10;
  private boolean m = true;
  private int n = 100;
  private int o = 10;
  private int p = 0;
  private int q = 0;
  private SessionInfo r;
  private int s;
  private HashMap<Long, List<MultiMsgNick>> u = new HashMap();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("fight/pic_expire.png");
    a = localStringBuilder.toString();
  }
  
  public static MultiMsgManager a()
  {
    if (g == null) {
      synchronized (f)
      {
        if (g == null) {
          g = new MultiMsgManager();
        }
      }
    }
    return g;
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
      if (this.i != null)
      {
        paramInt ^= ((Integer)this.i.a(paramLong, Integer.valueOf(0))).intValue();
        if (paramInt != 0) {
          this.i.b(paramLong, Integer.valueOf(paramInt));
        } else {
          this.i.c(paramLong);
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
    int i1;
    if (paramBundle != null) {
      i1 = b(paramBundle.getInt("ReceiptMsgManager.EXTRA_KEY_PTT_SEND_SOURCE"));
    } else {
      i1 = 0;
    }
    localTransferRequest.mPttUploadPanel = i1;
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
    paramMessageObserver = paramQQAppInterface.getProxyManager().b().a(paramArrayList, paramHashMap, paramBoolean);
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
      paramQQAppInterface.getMsgCache().b(paramString, paramInt1, paramMessageRecord.uniseq);
      long l1 = paramMessageRecord.uniseq;
      ((MessageHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.b(paramInt1), false, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l1) });
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
    paramQQAppInterface.getMsgCache().b(paramString, paramInt, paramMessageRecord.uniseq);
    paramQQAppInterface.getMessageFacade().a(paramString, paramInt, paramMessageRecord.uniseq, 32768, -1);
    long l1 = paramMessageRecord.uniseq;
    ((MessageHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.b(paramInt), false, new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l1) });
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
    ((TransferRequest)localObject).upMsgBusiType = j();
    ((TransferRequest)localObject).mUpCallBack = paramUpCallBack;
    if (paramBoolean) {
      ((TransferRequest)localObject).isJubaoMsgType = true;
    }
    ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync((TransferRequest)localObject);
    return true;
  }
  
  private int b(int paramInt)
  {
    int i1 = 3;
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 3)
      {
        if (paramInt == 4) {
          return i1;
        }
        if (paramInt != 6) {
          return 0;
        }
      }
      return 2;
    }
    else
    {
      i1 = 1;
    }
    return i1;
  }
  
  public static String b(QQAppInterface paramQQAppInterface)
  {
    if (!new File(a).exists())
    {
      FileUtils.copyResToFile(paramQQAppInterface.getApp(), 2130842458, a);
      paramQQAppInterface = FileUtils.calcMd5(a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("chatthumb:");
      localStringBuilder.append(paramQQAppInterface);
      paramQQAppInterface = AbsDownloader.getFilePath(localStringBuilder.toString());
      FileUtils.copyFile(a, paramQQAppInterface);
    }
    return a;
  }
  
  private boolean b(long paramLong)
  {
    try
    {
      Object localObject1 = this.i;
      boolean bool = false;
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "isReceiptMessageFinished map null and res: false");
        }
        return false;
      }
      if (((Integer)this.i.a(paramLong, Integer.valueOf(0))).intValue() == 0) {
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
  
  private boolean b(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, UpCallBack paramUpCallBack)
  {
    return a(paramQQAppInterface, paramArrayOfByte, paramString1, paramString2, paramString3, paramInt1, paramLong, paramInt2, true, paramUpCallBack);
  }
  
  private void c(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateFinishMask mask: ");
      localStringBuilder.append(paramInt);
      QLog.d("MultiMsg_TAG", 2, localStringBuilder.toString());
    }
    this.h = (paramInt ^ this.h);
  }
  
  public static long h()
  {
    File localFile = new File(a);
    if (localFile.exists()) {
      return localFile.length();
    }
    return 0L;
  }
  
  private void l()
  {
    try
    {
      if (this.i == null) {
        this.i = new LongSparseArray();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
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
    int i1 = 0;
    while (paramCollection.hasNext())
    {
      Object localObject1 = (ChatMessage)paramCollection.next();
      if ((localObject1 instanceof MessageForPic))
      {
        i1 += 1;
      }
      else
      {
        int i2;
        if ((localObject1 instanceof MessageForMixedMsg))
        {
          localObject1 = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
          i2 = i1;
          for (;;)
          {
            i1 = i2;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            if (((MessageRecord)((Iterator)localObject1).next() instanceof MessageForPic)) {
              i2 += 1;
            }
          }
        }
        if (((ChatMessage)localObject1).msgtype == -1036)
        {
          localObject1 = ((MessageForLongMsg)localObject1).longMsgFragmentList.iterator();
          i2 = i1;
          do
          {
            i1 = i2;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
          } while (!(localObject2 instanceof MessageForMixedMsg));
          Object localObject2 = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
          i1 = i2;
          for (;;)
          {
            i2 = i1;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            if (((MessageRecord)((Iterator)localObject2).next() instanceof MessageForPic)) {
              i1 += 1;
            }
          }
        }
      }
    }
    return i1;
  }
  
  public MessageForStructing a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, AbsStructMsg paramAbsStructMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, " favorMultiMsg start: ");
    }
    paramString2 = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = MessageRecordFactory.c(paramQQAppInterface, paramString2, paramString1, paramString2, paramInt, 0L, paramAbsStructMsg);
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
      if (this.u.size() > 0)
      {
        localObject = (List)this.u.get(Long.valueOf(paramLong));
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
      this.u.clear();
      paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager().query(MultiMsgNick.class, new MultiMsgNick().getTableName(), false, "uniseq = ?", new String[] { String.valueOf(paramLong) }, null, null, null, null);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
      {
        this.u.put(Long.valueOf(paramLong), paramQQAppInterface);
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
  
  public List<ChatMessage> a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return a(paramQQAppInterface, paramLong, null, 0);
  }
  
  public List<ChatMessage> a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt)
  {
    Object localObject1 = paramQQAppInterface.getProxyManager().b().a(paramLong);
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
  
  public void a(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo != null) {}
    try
    {
      this.r = ((SessionInfo)paramSessionInfo.clone());
      return;
    }
    catch (CloneNotSupportedException paramSessionInfo) {}
    this.r = null;
    return;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    String str2;
    Object localObject;
    int i1;
    if (paramQQAppInterface != null)
    {
      String str1 = paramQQAppInterface.getServerConfigValue(ServerConfigManager.ConfigType.user, "MMF_enable");
      paramQQAppInterface.getServerConfigValue(ServerConfigManager.ConfigType.user, "MMF_maxMsgNum");
      str2 = paramQQAppInterface.getServerConfigValue(ServerConfigManager.ConfigType.user, "MMF_maxPicNum");
      localObject = paramQQAppInterface.getServerConfigValue(ServerConfigManager.ConfigType.user, "MMF_maxVideoNum");
      i1 = SharedPreUtils.b(paramQQAppInterface.getCurrentUin(), "multimsg_config");
      if (i1 > 0) {
        this.j = i1;
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("initLimitCount enable = ");
        paramQQAppInterface.append(str1);
        paramQQAppInterface.append(" maxMsgNum = ");
        paramQQAppInterface.append(i1);
        paramQQAppInterface.append(" maxPicNum ");
        paramQQAppInterface.append(str2);
        QLog.d("MultiMsg_TAG", 2, paramQQAppInterface.toString());
      }
      if (TextUtils.isEmpty(str2)) {}
    }
    try
    {
      this.k = Integer.parseInt(str2);
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      label158:
      break label158;
    }
    this.k = 20;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      this.l = Integer.parseInt((String)localObject);
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      label182:
      break label182;
    }
    this.l = 10;
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
          this.n = localObject[0].intValue();
          if (localObject[1].intValue() > 0) {
            i1 = localObject[1].intValue();
          } else {
            i1 = this.o;
          }
          this.o = i1;
        }
        if (localObject[2].intValue() >= 0) {
          i1 = localObject[2].intValue();
        } else {
          i1 = this.p;
        }
        this.p = i1;
        if (localObject[3].intValue() >= 0) {
          i1 = localObject[3].intValue();
        } else {
          i1 = this.q;
        }
        this.q = i1;
      }
    }
    this.m = true;
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
      ((IOrderMediaMsgService)paramQQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).enqueueMediaMsgByMsgList(paramSessionInfo.b, paramArrayList);
      paramQQAppInterface.execute(new MultiMsgManager.1(this, paramSessionInfo, localArrayList, paramQQAppInterface, paramInt));
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    paramQQAppInterface.execute(new MultiMsgManager.5(this, paramQQAppInterface, paramString, paramInt, paramLong, paramBoolean));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, UpCallBack paramUpCallBack)
  {
    paramString2 = new ArrayList(JubaoIPCServer.a().c());
    Iterator localIterator = paramString2.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (((localMessageRecord instanceof MsgBackupRichTextParse)) && ((localMessageRecord instanceof MessageForRichText))) {
        ((MessageForRichText)localMessageRecord).richText = ((MsgBackupRichTextParse)localMessageRecord).getRichText();
      }
    }
    b(paramQQAppInterface, paramQQAppInterface.getProxyManager().b().a(paramString2, null, true), paramQQAppInterface.getCurrentAccountUin(), paramString1, paramString1, paramInt, 0L, 1035, paramUpCallBack);
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
      localObject2 = this.c.iterator();
      for (i1 = 1; ((Iterator)localObject2).hasNext(); i1 = 0)
      {
        localObject3 = (ChatMessage)((Iterator)localObject2).next();
        if (((localObject3 instanceof MessageForText)) || ((localObject3 instanceof MessageForLongMsg))) {
          break label68;
        }
      }
      if (i1 != 0) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800662C", "0X800662C", 0, 1, 0, "", "", "", "");
      }
      localObject4 = new ArrayList();
      ((ArrayList)localObject4).addAll(this.c);
      localHashMap1 = new HashMap();
      localHashMap1.putAll(this.d);
      if (paramInt2 == 0) {
        i1 = 3;
      } else if (paramInt2 == 1) {
        i1 = 2;
      } else {
        i1 = 0;
      }
      new AdEmoReportUtil().a(paramQQAppInterface, paramString1, (ArrayList)localObject4, i1);
      if (paramInt2 == 1)
      {
        paramAbsStructMsg = new SessionInfo();
        paramAbsStructMsg.a = paramInt1;
        paramAbsStructMsg.b = paramString1;
        paramAbsStructMsg.c = paramString2;
        paramAbsStructMsg.a(paramBundle);
        a(paramQQAppInterface, paramAbsStructMsg, (ArrayList)localObject4, paramInt3);
        return;
      }
      if (paramInt2 == 2)
      {
        paramBundle = paramQQAppInterface.getCurrentAccountUin();
        i1 = MobileQQService.seq;
        MobileQQService.seq = i1 + 1;
        paramBundle = MessageRecordFactory.c(paramQQAppInterface, paramBundle, paramString1, paramBundle, 1040, i1, paramAbsStructMsg);
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
      paramBundle = paramQQAppInterface.getProxyManager().b().a(paramLong).iterator();
      for (i1 = 1; paramBundle.hasNext(); i1 = 0)
      {
        label392:
        localObject1 = (MessageRecord)paramBundle.next();
        if ((localObject1 instanceof ChatMessage)) {
          ((ArrayList)localObject4).add((ChatMessage)localObject1);
        }
        if (((localObject1 instanceof MessageForText)) || ((localObject1 instanceof MessageForLongMsg))) {
          break label392;
        }
      }
      if (i1 != 0) {
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
            paramBundle = MultiMsgUtil.b(localMessageRecord.senderuin);
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
    int i1 = paramInt1;
    if (paramBundle != null)
    {
      paramBundle.isReMultiMsg = true;
      ForwardOrderManager.a().a(paramBundle.uniseq, 0L, paramInt3);
      if (paramBoolean) {
        paramQQAppInterface.getMessageFacade().h(paramString1, i1, paramLong);
      }
      if ((paramInt2 != 0) && (paramInt2 != 2))
      {
        a(paramQQAppInterface, paramString1, paramInt1, paramString2, (HashMap)localObject4, paramBundle, paramInt2);
        return;
      }
      localObject2 = new MultiMsgRequest();
      localObject3 = new SessionInfo();
      ((SessionInfo)localObject3).b = paramString1;
      ((SessionInfo)localObject3).a = i1;
      if (paramInt2 == 2)
      {
        ((SessionInfo)localObject3).a = 1040;
        ((SessionInfo)localObject3).C = i1;
      }
      ((SessionInfo)localObject3).c = ((String)localObject1);
      ((MultiMsgRequest)localObject2).h = 0;
      ((MultiMsgRequest)localObject2).a = ((SessionInfo)localObject3);
      ((MultiMsgRequest)localObject2).b = paramString2;
      ((MultiMsgRequest)localObject2).c = ((Map)localObject4);
      ((MultiMsgRequest)localObject2).i = paramInt2;
      ((MultiMsgRequest)localObject2).d = paramAbsStructMsg;
      ((MultiMsgRequest)localObject2).e = ((MessageForStructing)paramBundle);
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
      int i1 = paramList.size();
      int i2 = a().a(paramList);
      paramList = new StringBuilder();
      paramList.append(i1);
      paramList.append("");
      localHashMap.put("msgCount", paramList.toString());
      paramList = new StringBuilder();
      paramList.append(i2);
      paramList.append("");
      localHashMap.put("picCount", paramList.toString());
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "multiMsgReceive", paramBoolean, 0L, 0L, localHashMap, "");
      return;
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "multiMsgReceive", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  protected void a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, int paramInt, SessionInfo paramSessionInfo)
  {
    Intent localIntent = FileManagerUtil.b(paramQQAppInterface, paramChatMessage);
    if ((localIntent != null) && (localIntent.getExtras() != null))
    {
      ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)localIntent.getExtras().getParcelable("fileinfo");
      String str = localIntent.getStringExtra("forward_filepath");
      if (localForwardFileInfo != null)
      {
        localForwardFileInfo.c(paramChatMessage.uniseq);
        localForwardFileInfo.a = paramInt;
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
      Iterator localIterator = this.b.keySet().iterator();
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        if (paramChatMessage.uniseq == localChatMessage.uniseq)
        {
          this.b.put(localChatMessage, Boolean.valueOf(paramBoolean));
          return;
        }
      }
    }
    this.b.put(paramChatMessage, Boolean.valueOf(paramBoolean));
  }
  
  public void a(MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface)
  {
    if (this.q != 0) {
      return;
    }
    if ((this.p != 0) && (((IPicPreDownload)paramQQAppInterface.getRuntimeService(IPicPreDownload.class, "")).calcUinType(paramQQAppInterface, paramMessageForStructing.istroop, paramMessageForStructing.frienduin) == 1)) {
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
    int i1 = paramMessageForStructing.istroop;
    long l1 = paramMessageForStructing.uniseq;
    if (QLog.isColorLevel())
    {
      paramMessageForStructing = new StringBuilder();
      paramMessageForStructing.append("preDownloadRes begin! touin:");
      paramMessageForStructing.append(str2);
      paramMessageForStructing.append(",touinType:");
      paramMessageForStructing.append(i1);
      paramMessageForStructing.append(",uniseq:");
      paramMessageForStructing.append(l1);
      paramMessageForStructing.append(",fileKey:");
      paramMessageForStructing.append(str1);
      QLog.d("MultiMsg_TAG", 2, paramMessageForStructing.toString());
    }
    a().a(paramQQAppInterface, str1, paramQQAppInterface.getCurrentAccountUin(), str2, str2, i1, l1, 1035, null);
  }
  
  /* Error */
  public void a(HashMap<String, String> paramHashMap, long paramLong, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +204 -> 205
    //   4: aload_1
    //   5: invokevirtual 597	java/util/HashMap:size	()I
    //   8: ifle +197 -> 205
    //   11: new 100	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 101	java/util/ArrayList:<init>	()V
    //   18: astore 5
    //   20: aload_1
    //   21: invokevirtual 1095	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   24: invokeinterface 1051 1 0
    //   29: astore_1
    //   30: aload_1
    //   31: invokeinterface 550 1 0
    //   36: ifeq +78 -> 114
    //   39: aload_1
    //   40: invokeinterface 554 1 0
    //   45: checkcast 1097	java/util/Map$Entry
    //   48: astore 7
    //   50: aload 7
    //   52: invokeinterface 1100 1 0
    //   57: checkcast 608	java/lang/String
    //   60: astore 6
    //   62: aload 7
    //   64: invokeinterface 1103 1 0
    //   69: checkcast 608	java/lang/String
    //   72: astore 7
    //   74: new 603	com/tencent/mobileqq/multimsg/MultiMsgNick
    //   77: dup
    //   78: invokespecial 630	com/tencent/mobileqq/multimsg/MultiMsgNick:<init>	()V
    //   81: astore 8
    //   83: aload 8
    //   85: aload 6
    //   87: putfield 606	com/tencent/mobileqq/multimsg/MultiMsgNick:uin	Ljava/lang/String;
    //   90: aload 8
    //   92: lload_2
    //   93: putfield 613	com/tencent/mobileqq/multimsg/MultiMsgNick:uniseq	J
    //   96: aload 8
    //   98: aload 7
    //   100: putfield 616	com/tencent/mobileqq/multimsg/MultiMsgNick:nick	Ljava/lang/String;
    //   103: aload 5
    //   105: aload 8
    //   107: invokevirtual 882	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   110: pop
    //   111: goto -81 -> 30
    //   114: aload 4
    //   116: invokevirtual 623	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   119: invokevirtual 629	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   122: astore 4
    //   124: aload 4
    //   126: invokevirtual 1107	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 1112	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   134: aload 5
    //   136: invokevirtual 814	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   139: astore 5
    //   141: aload 5
    //   143: invokeinterface 550 1 0
    //   148: ifeq +21 -> 169
    //   151: aload 4
    //   153: aload 5
    //   155: invokeinterface 554 1 0
    //   160: checkcast 603	com/tencent/mobileqq/multimsg/MultiMsgNick
    //   163: invokevirtual 1116	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   166: goto -25 -> 141
    //   169: aload_1
    //   170: invokevirtual 1119	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   173: goto +15 -> 188
    //   176: astore 4
    //   178: goto +20 -> 198
    //   181: astore 5
    //   183: aload 5
    //   185: invokevirtual 1122	java/lang/Exception:printStackTrace	()V
    //   188: aload_1
    //   189: invokevirtual 1125	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   192: aload 4
    //   194: invokevirtual 1128	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   197: return
    //   198: aload_1
    //   199: invokevirtual 1125	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
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
          if (this.b.containsKey(localObject)) {
            this.b.remove(localObject);
          }
        }
      }
      Object localObject = this.b.entrySet().iterator();
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
      localObject = this.b.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        localChatMessage = (ChatMessage)((Iterator)localObject).next();
        if ((localChatMessage != null) && (paramChatMessage.uniseq == localChatMessage.uniseq) && (this.b.get(localChatMessage) != null)) {
          return ((Boolean)this.b.get(localChatMessage)).booleanValue();
        }
      }
      return false;
    }
    if (paramChatMessage != null)
    {
      localObject = this.b.keySet();
      if (((Set)localObject).contains(paramChatMessage)) {
        return ((Boolean)this.b.get(paramChatMessage)).booleanValue();
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localChatMessage = (ChatMessage)((Iterator)localObject).next();
        if (paramChatMessage.uniseq == localChatMessage.uniseq)
        {
          boolean bool = ((Boolean)this.b.get(localChatMessage)).booleanValue();
          this.b.remove(localChatMessage);
          this.b.put(paramChatMessage, Boolean.valueOf(bool));
          return bool;
        }
      }
    }
    return false;
  }
  
  public boolean a(ChatMessage paramChatMessage, int paramInt)
  {
    int i2 = f();
    int i1;
    if (this.e == 7) {
      i1 = 1;
    } else {
      i1 = MultiMsgUtil.b(paramChatMessage);
    }
    int i3 = i2 + i1;
    boolean bool;
    if (i3 > paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, String.format("isWillBeyondTotalLimit: hasCount = %d,willCheckCount = %d,willTotalCount = %d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(i3) }));
    }
    return bool;
  }
  
  protected boolean a(ChatMessage paramChatMessage, boolean paramBoolean, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, int paramInt)
  {
    boolean bool;
    if (paramSessionInfo.a != 0)
    {
      bool = paramBoolean;
      if (paramSessionInfo.a != 1) {}
    }
    else
    {
      paramChatMessage = paramQQAppInterface.getMessageFacade().a(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
      bool = paramBoolean;
      if ((paramChatMessage instanceof MessageForAniSticker)) {
        bool = AniStickerSendMessageCallBack.sendAniSticker(QQSysFaceUtil.convertToLocal(((MessageForAniSticker)paramChatMessage).sevrId), paramSessionInfo);
      }
    }
    return bool;
  }
  
  public void b(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramChatMessage == null) {
      return;
    }
    Object localObject = this.b.keySet();
    if (((Set)localObject).contains(paramChatMessage))
    {
      this.b.put(paramChatMessage, Boolean.valueOf(paramBoolean));
      return;
    }
    int i2 = 0;
    localObject = ((Set)localObject).iterator();
    ChatMessage localChatMessage;
    do
    {
      i1 = i2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localChatMessage = (ChatMessage)((Iterator)localObject).next();
    } while (paramChatMessage.uniseq != localChatMessage.uniseq);
    int i1 = 1;
    this.b.put(localChatMessage, Boolean.valueOf(paramBoolean));
    if (i1 == 0) {
      this.b.put(paramChatMessage, Boolean.valueOf(paramBoolean));
    }
  }
  
  public void b(List<ChatMessage> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      Collections.sort(paramList, g);
    }
  }
  
  public boolean b()
  {
    return this.m;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006628", "0X8006628", 0, 1, 0, "", "", "", "");
    return a(paramQQAppInterface, paramLong).size() > 0;
  }
  
  public int c()
  {
    if (this.e != 7) {
      return this.j;
    }
    return 50;
  }
  
  public boolean c(QQAppInterface paramQQAppInterface, long paramLong)
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
              if ((localObject != null) && (((StructMsgItemImage)localObject).aF == null))
              {
                if (((StructMsgItemImage)localObject).aE == null) {
                  ((StructMsgItemImage)localObject).aE = paramQQAppInterface;
                }
                ((StructMsgItemImage)localObject).aF = ((StructMsgItemImage)localObject).d();
                paramQQAppInterface = ((StructMsgItemImage)localObject).aF;
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
  
  public SessionInfo d()
  {
    return this.r;
  }
  
  public int e()
  {
    return this.s;
  }
  
  public int f()
  {
    Iterator localIterator = this.b.keySet().iterator();
    int i1 = 0;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      int i2 = 1;
      if (!bool) {
        break;
      }
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (((Boolean)this.b.get(localChatMessage)).booleanValue())
      {
        if (this.e != 7) {
          i2 = MultiMsgUtil.b(localChatMessage);
        }
        i1 += i2;
      }
    }
    MultiMsgUtil.b("checkMap.size = %d,count= %d", new Object[] { Integer.valueOf(this.b.size()), Integer.valueOf(i1) });
    return i1;
  }
  
  public void g()
  {
    this.b.clear();
  }
  
  public List<ChatMessage> i()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Boolean)localEntry.getValue()).booleanValue()) {
        localArrayList.add(localEntry.getKey());
      }
    }
    return localArrayList;
  }
  
  public int j()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgManager
 * JD-Core Version:    0.7.0.1
 */