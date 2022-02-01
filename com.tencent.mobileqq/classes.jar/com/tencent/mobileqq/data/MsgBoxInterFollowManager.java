package com.tencent.mobileqq.data;

import android.text.TextUtils;
import appoint.define.appoint_define.RichText;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dating.MsgBoxProtocol;
import com.tencent.mobileqq.dating.MsgBoxUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import tencent.im.s2c.msgtype0x210.submsgtype0xd7.SubMsgType0xd7.Content;
import tencent.im.s2c.msgtype0x210.submsgtype0xd7.SubMsgType0xd7.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xfe.submsgtype0xfe.MsgBody;

public class MsgBoxInterFollowManager
  implements Manager
{
  public QQAppInterface app;
  public int msgboxUnreadCount;
  
  public MsgBoxInterFollowManager(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.msgboxUnreadCount = SharedPreUtils.W(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
  }
  
  private void addMessage(MessageForInteractAndFollow paramMessageForInteractAndFollow)
  {
    MessageRecord localMessageRecord = this.app.getMessageFacade().b(paramMessageForInteractAndFollow.senderuin, paramMessageForInteractAndFollow.istroop);
    if (localMessageRecord != null)
    {
      this.app.getMessageFacade().b(localMessageRecord.senderuin, localMessageRecord.istroop, localMessageRecord.uniseq);
      this.app.getMessageFacade().a(paramMessageForInteractAndFollow, this.app.getCurrentAccountUin());
      return;
    }
    this.app.getMessageFacade().a(paramMessageForInteractAndFollow, this.app.getCurrentAccountUin());
  }
  
  public void addMessage(String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    if ((paramInt3 != 1) && (paramInt3 != 2))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("type=");
        paramString.append(paramInt3);
        QLog.i("Q.msg_box.MsgBoxInterFollowManager", 2, paramString.toString());
      }
      return;
    }
    MessageForInteractAndFollow localMessageForInteractAndFollow = (MessageForInteractAndFollow)MessageRecordFactory.a(-2055);
    localMessageForInteractAndFollow.rawContext = paramString;
    localMessageForInteractAndFollow.context = MsgBoxUtil.a(paramString, 14);
    localMessageForInteractAndFollow.unReadCount = paramInt2;
    localMessageForInteractAndFollow.msgBoxUnreadCount = paramInt1;
    localMessageForInteractAndFollow.timeStamp = paramLong;
    localMessageForInteractAndFollow.msgseq = paramLong;
    localMessageForInteractAndFollow.type = paramInt3;
    localMessageForInteractAndFollow.time = paramLong;
    localMessageForInteractAndFollow.shmsgseq = paramLong;
    localMessageForInteractAndFollow.msgUid = paramLong;
    localMessageForInteractAndFollow.selfuin = this.app.getCurrentAccountUin();
    localMessageForInteractAndFollow.istroop = 10002;
    if (localMessageForInteractAndFollow.type == 1) {
      paramString = AppConstants.MSG_BOX_INTERACT_UIN;
    } else {
      paramString = AppConstants.MSG_BOX_FOLLOW_UIN;
    }
    localMessageForInteractAndFollow.senderuin = paramString;
    localMessageForInteractAndFollow.frienduin = AppConstants.LBS_HELLO_UIN;
    localMessageForInteractAndFollow.getBytes();
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder(20);
      paramString.append("msgBoxUnreadCount=");
      paramString.append(localMessageForInteractAndFollow.msgBoxUnreadCount);
      paramString.append(",unReadCount=");
      paramString.append(localMessageForInteractAndFollow.unReadCount);
      paramString.append(",context=");
      paramString.append(localMessageForInteractAndFollow.context);
      paramString.append("timeStamp=");
      paramString.append(localMessageForInteractAndFollow.timeStamp);
      paramString.append(",msgseq=");
      paramString.append(localMessageForInteractAndFollow.msgseq);
      paramString.append(",shmsgseq=");
      paramString.append(localMessageForInteractAndFollow.shmsgseq);
      paramString.append(",msgUid=");
      paramString.append(localMessageForInteractAndFollow.msgUid);
      paramString.append(",senderuin=");
      paramString.append(localMessageForInteractAndFollow.senderuin);
      QLog.i("Q.msg_box.MsgBoxInterFollowManager", 2, paramString.toString());
    }
    paramInt2 = localMessageForInteractAndFollow.unReadCount;
    paramInt1 = 0;
    if (paramInt2 > 0) {
      if (SharedPreUtils.b(this.app.getApp(), this.app.getCurrentAccountUin(), localMessageForInteractAndFollow.senderuin) == 1) {
        SharedPreUtils.b(this.app.getApp(), this.app.getCurrentAccountUin(), localMessageForInteractAndFollow.senderuin, 0);
      }
    }
    while (SharedPreUtils.b(this.app.getApp(), this.app.getCurrentAccountUin(), localMessageForInteractAndFollow.senderuin) == 0)
    {
      paramInt1 = 1;
      break;
    }
    if (paramInt1 != 0) {
      ThreadManager.post(new MsgBoxInterFollowManager.2(this, localMessageForInteractAndFollow), 8, null, true);
    }
  }
  
  public void addMomentMessage(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    MessageForInteractAndFollow localMessageForInteractAndFollow = (MessageForInteractAndFollow)MessageRecordFactory.a(-2055);
    localMessageForInteractAndFollow.rawContext = paramString;
    localMessageForInteractAndFollow.context = MsgBoxUtil.a(paramString, 14);
    localMessageForInteractAndFollow.unReadCount = paramInt2;
    localMessageForInteractAndFollow.msgBoxUnreadCount = paramInt1;
    localMessageForInteractAndFollow.timeStamp = paramLong;
    localMessageForInteractAndFollow.msgseq = paramLong;
    localMessageForInteractAndFollow.type = 3;
    localMessageForInteractAndFollow.time = paramLong;
    localMessageForInteractAndFollow.shmsgseq = paramLong;
    localMessageForInteractAndFollow.msgUid = paramLong;
    localMessageForInteractAndFollow.selfuin = this.app.getCurrentAccountUin();
    localMessageForInteractAndFollow.istroop = 1001;
    localMessageForInteractAndFollow.senderuin = AppConstants.MSG_BOX_MYMOMMENT_UIN;
    localMessageForInteractAndFollow.frienduin = AppConstants.LBS_HELLO_UIN;
    localMessageForInteractAndFollow.getBytes();
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder(20);
      paramString.append("msgBoxUnreadCount=");
      paramString.append(localMessageForInteractAndFollow.msgBoxUnreadCount);
      paramString.append(",unReadCount=");
      paramString.append(localMessageForInteractAndFollow.unReadCount);
      paramString.append(",context=");
      paramString.append(localMessageForInteractAndFollow.context);
      paramString.append("timeStamp=");
      paramString.append(localMessageForInteractAndFollow.timeStamp);
      paramString.append(",msgseq=");
      paramString.append(localMessageForInteractAndFollow.msgseq);
      paramString.append(",shmsgseq=");
      paramString.append(localMessageForInteractAndFollow.shmsgseq);
      paramString.append(",msgUid=");
      paramString.append(localMessageForInteractAndFollow.msgUid);
      paramString.append(",senderuin=");
      paramString.append(localMessageForInteractAndFollow.senderuin);
      QLog.i("Q.msg_box.MsgBoxInterFollowManager", 2, paramString.toString());
    }
    paramInt2 = localMessageForInteractAndFollow.unReadCount;
    paramInt1 = 0;
    if (paramInt2 > 0) {
      if (SharedPreUtils.b(this.app.getApp(), this.app.getCurrentAccountUin(), localMessageForInteractAndFollow.senderuin) == 1) {
        SharedPreUtils.b(this.app.getApp(), this.app.getCurrentAccountUin(), localMessageForInteractAndFollow.senderuin, 0);
      }
    }
    while (SharedPreUtils.b(this.app.getApp(), this.app.getCurrentAccountUin(), localMessageForInteractAndFollow.senderuin) == 0)
    {
      paramInt1 = 1;
      break;
    }
    if (paramInt1 != 0) {
      ThreadManager.post(new MsgBoxInterFollowManager.1(this, localMessageForInteractAndFollow), 8, null, true);
    }
  }
  
  public void clearMsgBoxUnreadCount()
  {
    if (this.msgboxUnreadCount > 0)
    {
      this.msgboxUnreadCount = 0;
      MsgBoxProtocol.a(this.app, 0, null);
      SharedPreUtils.v(this.app.getApp(), this.app.getCurrentAccountUin(), 0);
    }
  }
  
  public void decode0xd7InteractAndFollowMsg(byte[] paramArrayOfByte)
  {
    SubMsgType0xd7.MsgBody localMsgBody = new SubMsgType0xd7.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decode0xd7InteractAndFollowMsg decode failed:");
        localStringBuilder.append(paramArrayOfByte.toString());
        QLog.e("Q.msg_box.MsgBoxInterFollowManager", 2, localStringBuilder.toString(), paramArrayOfByte);
      }
    }
    paramArrayOfByte = new StringBuilder();
    if (localMsgBody.msg_content.bytes_from_user.has()) {
      paramArrayOfByte.append(localMsgBody.msg_content.bytes_from_user.get().toStringUtf8());
    }
    if (localMsgBody.msg_content.bytes_buluo_word.has()) {
      paramArrayOfByte.append(MsgBoxUtil.b(MsgBoxUtil.a(localMsgBody.msg_content.bytes_buluo_word.get().toStringUtf8())));
    } else if (localMsgBody.msg_content.rich_fresh_word.has()) {
      paramArrayOfByte.append(MsgBoxUtil.a((appoint_define.RichText)localMsgBody.msg_content.rich_fresh_word.get()));
    } else {
      paramArrayOfByte.append(localMsgBody.msg_content.bytes_plain_text.get().toStringUtf8());
    }
    if (localMsgBody.uint32_msgbox_unread_count.has())
    {
      this.msgboxUnreadCount = localMsgBody.uint32_msgbox_unread_count.get();
      SharedPreUtils.v(this.app.getApp(), this.app.getCurrentAccountUin(), localMsgBody.uint32_msgbox_unread_count.get());
    }
    addMessage(paramArrayOfByte.toString(), localMsgBody.uint32_msgbox_unread_count.get(), localMsgBody.uint32_unread_count.get(), localMsgBody.uint64_timestamp.get(), localMsgBody.uint32_type.get());
  }
  
  public void decode0xfeInteractAndFollowMsg(byte[] paramArrayOfByte)
  {
    submsgtype0xfe.MsgBody localMsgBody = new submsgtype0xfe.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decode0xd7InteractAndFollowMsg decode failed:");
        localStringBuilder.append(paramArrayOfByte.toString());
        QLog.e("Q.msg_box.MsgBoxInterFollowManager", 2, localStringBuilder.toString(), paramArrayOfByte);
      }
    }
    if (localMsgBody.uint32_box_unread_num.has())
    {
      this.msgboxUnreadCount = localMsgBody.uint32_box_unread_num.get();
      SharedPreUtils.v(this.app.getApp(), this.app.getCurrentAccountUin(), localMsgBody.uint32_box_unread_num.get());
    }
    addMomentMessage(localMsgBody.bytes_wording.get().toStringUtf8(), localMsgBody.uint32_box_unread_num.get(), localMsgBody.uint32_inner_unread_num.get(), localMsgBody.uint32_update_time.get());
  }
  
  public int getInterFollowMsgBoxUnreadCount()
  {
    return this.msgboxUnreadCount;
  }
  
  public boolean isInMsgBoxRecentList(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isInMsgBoxRecentList, uin=");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("Q.msg_box.MsgBoxInterFollowManager", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    Object localObject = this.app.getMessageProxy(paramInt).b(paramString, paramInt);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramString.equals(((MessageRecord)((Iterator)localObject).next()).senderuin)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void onDestroy()
  {
    this.msgboxUnreadCount = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MsgBoxInterFollowManager
 * JD-Core Version:    0.7.0.1
 */