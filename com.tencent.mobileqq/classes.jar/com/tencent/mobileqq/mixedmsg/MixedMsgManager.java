package com.tencent.mobileqq.mixedmsg;

import aehf;
import aehg;
import aehh;
import aehi;
import aehj;
import aehk;
import aehl;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import tencent.im.msg.im_msg_body.RichText;

public class MixedMsgManager
  implements Manager
{
  private static final String jdField_a_of_type_JavaLangString = AppConstants.aJ + "fight/pic_expire.png";
  private long jdField_a_of_type_Long;
  public QQAppInterface a;
  public ConcurrentHashMap a;
  
  public MixedMsgManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  protected static final MessageForMixedMsg a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, ArrayList paramArrayList1, String paramString2, ArrayList paramArrayList2, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    if ((paramArrayList1 == null) || (paramArrayList1.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (paramSourceMsgInfo != null)
    {
      paramString2 = MessageRecordFactory.a(paramQQAppInterface, paramString1, paramInt, paramSourceMsgInfo, paramString2);
      paramString2.atInfoList = paramArrayList2;
      localArrayList.add(paramString2);
    }
    while (TextUtils.isEmpty(paramString2))
    {
      int k = paramArrayList1.size();
      int j = 0;
      while (j < k)
      {
        paramString2 = (String)paramArrayList1.get(j);
        if (FileUtil.a(paramString2))
        {
          paramString2 = a(paramQQAppInterface, paramString2, null, paramString1, paramInt);
          if (paramString2 != null)
          {
            ThreadManager.post(new aehk(paramString2), 8, null, true);
            paramString2.subMsgId = localArrayList.size();
            localArrayList.add(paramString2);
          }
        }
        j += 1;
      }
    }
    paramString2 = MessageRecordFactory.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), paramString1, paramString1, paramInt, (byte)1, (byte)0, (short)0, paramString2);
    paramString2.atInfoList = paramArrayList2;
    if ((paramString2.atInfoList != null) && (!paramString2.atInfoList.isEmpty()))
    {
      paramArrayList2 = (TroopRobotManager)paramQQAppInterface.getManager(202);
      paramSourceMsgInfo = paramString2.atInfoList.iterator();
      do
      {
        if (!paramSourceMsgInfo.hasNext()) {
          break;
        }
      } while (!paramArrayList2.a(((MessageForText.AtTroopMemberInfo)paramSourceMsgInfo.next()).uin));
    }
    for (i = 1;; i = 0)
    {
      localArrayList.add(paramString2);
      break;
      if (localArrayList.isEmpty()) {
        return null;
      }
      paramQQAppInterface = (MessageRecord)localArrayList.get(0);
      paramQQAppInterface.longMsgId = 0;
      paramString1 = (MessageForMixedMsg)MessageRecordFactory.a(-1035);
      MessageRecord.copyMessageRecordBaseField(paramString1, paramQQAppInterface);
      if (paramString1.istroop == 1) {
        AnonymousChatHelper.a().a(paramString1);
      }
      paramString1.msgtype = -1035;
      paramString1.issend = 1;
      paramString1.extraflag = 32772;
      paramString1.uniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      paramString1.msgElemList = localArrayList;
      if (i != 0) {}
      for (paramInt = 1;; paramInt = -1)
      {
        paramString1.mRobotFlag = paramInt;
        paramString1.prewrite();
        return paramString1;
      }
    }
  }
  
  protected static final MessageForPic a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (paramString1 != null)
    {
      paramQQAppInterface = MessageRecordFactory.a(paramQQAppInterface, paramString3, paramString2, paramInt);
      paramQQAppInterface.path = paramString1;
      paramQQAppInterface.size = 0L;
      paramQQAppInterface.uniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      paramQQAppInterface.type = 1;
      paramQQAppInterface.isRead = true;
      paramQQAppInterface.localUUID = PicReq.a();
      paramQQAppInterface.md5 = HexUtil.a(MD5.getFileMd5(paramQQAppInterface.path));
      paramQQAppInterface.serial();
      return paramQQAppInterface;
    }
    return null;
  }
  
  protected static final void a(QQAppInterface paramQQAppInterface, MessageForPic paramMessageForPic, boolean paramBoolean, UpCallBack paramUpCallBack)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_b_of_type_JavaLangString = paramMessageForPic.selfuin;
    localTransferRequest.c = paramMessageForPic.frienduin;
    localTransferRequest.jdField_a_of_type_Int = paramMessageForPic.istroop;
    localTransferRequest.jdField_b_of_type_Int = 1;
    localTransferRequest.jdField_a_of_type_Long = (paramMessageForPic.uniseq + paramMessageForPic.subMsgId);
    for (Object localObject = localTransferRequest.c + localTransferRequest.jdField_a_of_type_Long; paramQQAppInterface.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject); localObject = localTransferRequest.c + localTransferRequest.jdField_a_of_type_Long) {
      localTransferRequest.jdField_a_of_type_Long += 100L;
    }
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.jdField_e_of_type_Boolean = false;
    localObject = new TransferRequest.PicUpExtraInfo();
    ((TransferRequest.PicUpExtraInfo)localObject).jdField_a_of_type_Boolean = paramBoolean;
    localTransferRequest.jdField_a_of_type_JavaLangObject = localObject;
    localTransferRequest.i = paramMessageForPic.path;
    localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = paramUpCallBack;
    paramQQAppInterface.a().a(localTransferRequest);
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean)
  {
    Object localObject1 = new im_msg_body.RichText();
    int k = paramMessageForMixedMsg.msgElemList.size();
    int i = 0;
    if (i < k)
    {
      Object localObject2 = (MessageRecord)paramMessageForMixedMsg.msgElemList.get(i);
      if ((localObject2 instanceof MessageForText))
      {
        localObject2 = MessageProtoCodec.a((MessageForText)localObject2);
        if (localObject2 != null) {}
      }
      for (;;)
      {
        i += 1;
        break;
        j = 0;
        while (j < ((im_msg_body.RichText)localObject2).elems.size())
        {
          ((im_msg_body.RichText)localObject1).elems.add(((im_msg_body.RichText)localObject2).elems.get(j));
          j += 1;
        }
        continue;
        if ((localObject2 instanceof MessageForRichText))
        {
          localObject2 = ((MessageForPic)localObject2).richText;
          if (localObject2 != null) {
            ((im_msg_body.RichText)localObject1).elems.add(((im_msg_body.RichText)localObject2).elems.get(0));
          }
        }
        else if ((localObject2 instanceof MessageForReplyText))
        {
          localObject2 = MessageProtoCodec.a((MessageForReplyText)localObject2);
          if (localObject2 != null)
          {
            j = 0;
            while (j < ((im_msg_body.RichText)localObject2).elems.size())
            {
              ((im_msg_body.RichText)localObject1).elems.add(((im_msg_body.RichText)localObject2).elems.get(j));
              j += 1;
            }
          }
        }
      }
    }
    k = ((im_msg_body.RichText)localObject1).toByteArray().length;
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgManager", 2, "packAndSendMsg, richTextLength : " + k);
    }
    paramMessageForMixedMsg.mRichTextLength = k;
    int j = 460;
    localObject1 = SharedPreUtils.g(paramQQAppInterface.getApp().getApplicationContext());
    i = j;
    if (localObject1 != null)
    {
      i = j;
      if (((String)localObject1).length() > 0)
      {
        localObject1 = ((String)localObject1).split("\\|");
        i = j;
        if (localObject1 != null)
        {
          i = j;
          if (localObject1.length <= 1) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        i = Integer.parseInt(localObject1[1]);
        if (i <= 0) {
          break label572;
        }
        j = i;
        i = j;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("MixedMsgManager", 2, "get maxSize From config : maxSize = " + i);
            j = i;
          }
          if (k >= j) {
            break label512;
          }
          paramString = new aehh(this, paramQQAppInterface, paramString, paramInt, paramMessageForMixedMsg);
          paramQQAppInterface.a().b(paramMessageForMixedMsg, paramString);
          if (QLog.isColorLevel()) {
            QLog.d("MixedMsgManager", 2, "packAndSendMsg, richTextLength < " + j + ", send by normal message");
          }
          return;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          for (;;)
          {
            j = i;
          }
        }
        localNumberFormatException1 = localNumberFormatException1;
      }
      if (QLog.isColorLevel())
      {
        QLog.e("MixedMsgManager", 2, "get maxSize from config error", localNumberFormatException1);
        i = j;
      }
      j = i;
      continue;
      label512:
      a(paramString, paramInt, paramMessageForMixedMsg, paramQQAppInterface, false);
      if (QLog.isColorLevel())
      {
        QLog.d("MixedMsgManager", 2, "packAndSendMsg, richTextLength >= " + j + ", send by longStruct message");
        return;
        label572:
        j = 460;
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, ArrayList paramArrayList, MessageForMixedMsg paramMessageForMixedMsg)
  {
    PicReq localPicReq = PicBusiManager.a(8, 7);
    localPicReq.a(paramArrayList);
    localPicReq.a(new aehg(this, paramMessageForMixedMsg, paramQQAppInterface, paramString, paramInt));
    PicBusiManager.a(localPicReq, paramQQAppInterface);
  }
  
  private void a(MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean)
  {
    if ((paramMessageForMixedMsg.istroop != 3000) && (paramMessageForMixedMsg.istroop != 1)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.istroop, paramMessageForMixedMsg.uniseq, 32770, paramMessageForMixedMsg.sendFailCode);
    }
    b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForMixedMsg);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramMessageForMixedMsg);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForMixedMsg.mForwardFromUniSeq));
    a(true, paramBoolean, paramMessageForMixedMsg, null);
  }
  
  private void a(MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.istroop, paramMessageForMixedMsg.uniseq, 32768, paramMessageForMixedMsg.sendFailCode);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForMixedMsg);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForMixedMsg.mForwardFromUniSeq));
    a(false, paramBoolean, paramMessageForMixedMsg, paramString);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, MessageForMixedMsg paramMessageForMixedMsg, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_isresend", String.valueOf(paramMessageForMixedMsg.mIsResend));
    if (!paramMessageForMixedMsg.mIsResend)
    {
      localHashMap.put("param_forwardFromUin", paramMessageForMixedMsg.mForwardFromUin);
      localHashMap.put("param_forwardFromUinType", String.valueOf(paramMessageForMixedMsg.mForwardFromIsTroop));
    }
    localHashMap.put("param_senderUin", paramMessageForMixedMsg.senderuin);
    localHashMap.put("param_toUin", paramMessageForMixedMsg.frienduin);
    localHashMap.put("param_toUinType", String.valueOf(paramMessageForMixedMsg.istroop));
    localHashMap.put("param_sendByLongStruct", String.valueOf(paramBoolean2));
    localHashMap.put("param_richTextLength", String.valueOf(paramMessageForMixedMsg.mRichTextLength));
    if (paramString != null) {
      localHashMap.put("param_errDesc", paramString);
    }
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "MixedMsgForward", paramBoolean1, 0L, 0L, localHashMap, "");
  }
  
  public static final boolean a(Intent paramIntent)
  {
    boolean bool2 = true;
    int i = paramIntent.getIntExtra("camera_type", -1);
    int j = paramIntent.getIntExtra("pic_entrance_type", -1);
    boolean bool1;
    if (i != -1) {
      bool1 = bool2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "fromCamera: " + bool1 + ", cameraType = " + i + ", picEntanceType = " + j);
      }
      return bool1;
      bool1 = bool2;
      if (j != 1)
      {
        bool1 = bool2;
        if (j != 2)
        {
          bool1 = bool2;
          if (j != 3)
          {
            bool1 = bool2;
            if (j != 10) {
              bool1 = false;
            }
          }
        }
      }
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, UpCallBack paramUpCallBack)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgManager", 2, "[sendLongTextMsg]data.length = " + paramArrayOfByte.length);
    }
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.jdField_b_of_type_Int = 131078;
    localTransferRequest.h = 1;
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
  
  public void a(SessionInfo paramSessionInfo, long paramLong)
  {
    Object localObject = (ChatMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localObject != null) {
      if (((ChatMessage)localObject).msgtype == -1036)
      {
        localObject = (MessageForMixedMsg)((MessageForLongMsg)localObject).rebuildLongMsg();
        ((MessageForMixedMsg)localObject).mForwardFromUniSeq = paramLong;
        a(paramSessionInfo, (MessageForMixedMsg)localObject, false);
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        localObject = (MessageForMixedMsg)localObject;
      }
    }
    QLog.e("MixedMsgManager", 2, "forwardMixedMsg, not find in cache !");
  }
  
  public void a(SessionInfo paramSessionInfo, MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean)
  {
    paramSessionInfo = new aehf(this, paramSessionInfo, paramMessageForMixedMsg, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramSessionInfo);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramMessageRecord.extraflag = 32768;
    paramQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    String str = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.uniseq;
    paramQQAppInterface.a().a(1000, false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, ArrayList paramArrayList1, boolean paramBoolean, String paramString2, ArrayList paramArrayList2, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    if (paramQQAppInterface == null) {}
    for (;;)
    {
      return;
      paramArrayList1 = a(paramQQAppInterface, paramString1, paramInt, paramArrayList1, paramString2, paramArrayList2, paramSourceMsgInfo);
      if (paramArrayList1 != null)
      {
        paramString2 = new ArrayList(paramArrayList1.msgElemList);
        paramQQAppInterface.a().a(paramArrayList1, paramQQAppInterface.getCurrentAccountUin());
        paramQQAppInterface.a().d(paramArrayList1);
        paramQQAppInterface.a().f(paramString1, paramInt);
        paramString1 = Collections.synchronizedMap(new HashMap());
        int i = paramString2.size();
        paramInt = 0;
        while (paramInt < i)
        {
          paramSourceMsgInfo = (MessageRecord)paramString2.get(paramInt);
          if ((paramSourceMsgInfo instanceof MessageForPic))
          {
            paramSourceMsgInfo = (MessageForPic)paramSourceMsgInfo;
            String str = paramSourceMsgInfo.path;
            if (FileUtil.a(str))
            {
              paramString1.put(str, Integer.valueOf(paramSourceMsgInfo.subMsgId));
              a(paramQQAppInterface, paramSourceMsgInfo, paramBoolean, new aehl(this, paramArrayList1, paramString1, str, paramArrayList2));
            }
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_istroop", String.valueOf(paramMessageRecord.istroop));
    localHashMap.put("param_issend", String.valueOf(paramMessageRecord.issend));
    localHashMap.put("param_msgtype", String.valueOf(paramMessageRecord.msgtype));
    localHashMap.put("param_isAnonymous", String.valueOf(AnonymousChatHelper.a(paramMessageRecord)));
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "MixedMsgReceived", true, 0L, 0L, localHashMap, "");
  }
  
  public void a(String paramString, int paramInt, MessageForMixedMsg paramMessageForMixedMsg, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgManager", 2, " sendStructLongMsg start");
    }
    if ((paramMessageForMixedMsg instanceof ChatMessage)) {
      paramMessageForMixedMsg.mPendantAnimatable = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgManager", 2, "step2: sendStructLongMsg saveMessage end and pack StructLongMsg start currenttime:" + System.currentTimeMillis());
    }
    byte[] arrayOfByte = paramQQAppInterface.a().a().a(paramMessageForMixedMsg);
    if (arrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "step2: sendStructLongMsg pack failed! packData is null.............................");
      }
      a(paramMessageForMixedMsg, true, "sendStructLongMsg pack fail : packData is null");
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        paramString = new aehi(this, paramQQAppInterface, paramMessageForMixedMsg, paramString, paramInt);
        paramBoolean = a(paramQQAppInterface, arrayOfByte, paramQQAppInterface.getCurrentAccountUin(), paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.istroop, paramMessageForMixedMsg.uniseq, 1035, new aehj(this, paramQQAppInterface, paramMessageForMixedMsg, paramString, paramBoolean));
        if (!paramBoolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MixedMsgManager", 2, "sendLongTextMsg successful, uploadLongTextMsgPkg start!");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("MixedMsgManager", 2, "sendLongTextMsg failed! isSuccess:" + paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localHashMap.put("param_isTroop", String.valueOf(paramInt));
    if (paramBoolean)
    {
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "MixedMsgClientAutoPull", true, 0L, 0L, localHashMap, "");
      return;
    }
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "MixedMsgClientManualPull", true, 0L, 0L, localHashMap, "");
  }
  
  protected void b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop != 3000) && (paramMessageRecord.istroop != 1)) {
      paramMessageRecord.extraflag = 32770;
    }
    String str = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.uniseq;
    paramQQAppInterface.a().a(1000, true, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.mixedmsg.MixedMsgManager
 * JD-Core Version:    0.7.0.1
 */