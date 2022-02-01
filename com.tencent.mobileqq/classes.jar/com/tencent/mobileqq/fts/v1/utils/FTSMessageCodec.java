package com.tencent.mobileqq.fts.v1.utils;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fts.data.msg.FTSMessage;
import com.tencent.mobileqq.fts.data.msg.FTSMessageDelete;
import com.tencent.mobileqq.fts.data.msg.FTSMessageForDel;
import com.tencent.mobileqq.fts.data.msg.FTSMessageSync;
import com.tencent.qphone.base.util.QLog;

public class FTSMessageCodec
{
  public static FTSMessage a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.utils", 2, "encodeMessageRecord message is null");
      }
      return null;
    }
    FTSMessage localFTSMessage = b(paramMessageRecord);
    if (localFTSMessage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.utils", 2, "encodeMessageRecord message is null");
      }
      return null;
    }
    int i = paramMessageRecord.msgtype;
    if ((i != -2011) && (i != -1051) && (i != -1049) && (i != -1035) && (i != -1000)) {
      return localFTSMessage;
    }
    TextMsgExts localTextMsgExts = new TextMsgExts();
    localTextMsgExts.time = paramMessageRecord.time;
    localTextMsgExts.shmsgseq = paramMessageRecord.shmsgseq;
    localFTSMessage.msgExts = localTextMsgExts;
    return localFTSMessage;
  }
  
  public static FTSMessage a(FTSMessageSync paramFTSMessageSync)
  {
    if (paramFTSMessageSync == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.utils", 2, "decodecFTSMessage ftsMessageSync is null");
      }
      return null;
    }
    FTSMessage localFTSMessage = new FTSMessage();
    localFTSMessage.mOpt = paramFTSMessageSync.mOpt;
    localFTSMessage.mType = paramFTSMessageSync.mType;
    localFTSMessage.mContent = paramFTSMessageSync.mContent;
    localFTSMessage.mOId = paramFTSMessageSync.mOId;
    localFTSMessage.uin = paramFTSMessageSync.uin;
    localFTSMessage.istroop = paramFTSMessageSync.istroop;
    localFTSMessage.senderuin = paramFTSMessageSync.senderuin;
    localFTSMessage.msgtype = paramFTSMessageSync.msgtype;
    try
    {
      if (paramFTSMessageSync.msgExts != null)
      {
        localFTSMessage.msgExts = ((MsgExts)paramFTSMessageSync.msgExts.clone());
        return localFTSMessage;
      }
      localFTSMessage.msgExts = null;
      return localFTSMessage;
    }
    catch (Exception paramFTSMessageSync)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.fts.utils", 2, "decodecFTSMessage, ", paramFTSMessageSync);
      }
      localFTSMessage.msgExts = null;
    }
    return localFTSMessage;
  }
  
  public static FTSMessageDelete a(FTSMessage paramFTSMessage)
  {
    if (paramFTSMessage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.utils", 2, "codecFTSMessage ftsMessage is null");
      }
      return null;
    }
    FTSMessageDelete localFTSMessageDelete = new FTSMessageDelete();
    localFTSMessageDelete.mOpt = paramFTSMessage.mOpt;
    localFTSMessageDelete.mType = paramFTSMessage.mType;
    localFTSMessageDelete.mContent = paramFTSMessage.mContent;
    localFTSMessageDelete.mOId = paramFTSMessage.mOId;
    localFTSMessageDelete.uin = paramFTSMessage.uin;
    localFTSMessageDelete.istroop = paramFTSMessage.istroop;
    localFTSMessageDelete.senderuin = paramFTSMessage.senderuin;
    localFTSMessageDelete.msgtype = paramFTSMessage.msgtype;
    try
    {
      if (paramFTSMessage.msgExts != null)
      {
        localFTSMessageDelete.msgExts = ((MsgExts)paramFTSMessage.msgExts.clone());
        return localFTSMessageDelete;
      }
      localFTSMessageDelete.msgExts = null;
      return localFTSMessageDelete;
    }
    catch (Exception paramFTSMessage)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.fts.utils", 2, "codecFTSMessage, ", paramFTSMessage);
      }
      localFTSMessageDelete.msgExts = null;
    }
    return localFTSMessageDelete;
  }
  
  public static FTSMessageForDel a(FTSMessageSync paramFTSMessageSync)
  {
    if (paramFTSMessageSync == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.utils", 2, "decodecFTSMessage ftsMessageSync is null");
      }
      return null;
    }
    FTSMessageForDel localFTSMessageForDel = new FTSMessageForDel();
    localFTSMessageForDel.mOpt = paramFTSMessageSync.mOpt;
    localFTSMessageForDel.mType = paramFTSMessageSync.mType;
    localFTSMessageForDel.mContent = paramFTSMessageSync.mContent;
    localFTSMessageForDel.mOId = paramFTSMessageSync.mOId;
    localFTSMessageForDel.uin = paramFTSMessageSync.uin;
    localFTSMessageForDel.istroop = paramFTSMessageSync.istroop;
    localFTSMessageForDel.senderuin = paramFTSMessageSync.senderuin;
    localFTSMessageForDel.msgtype = paramFTSMessageSync.msgtype;
    try
    {
      if (paramFTSMessageSync.msgExts != null)
      {
        localFTSMessageForDel.msgExts = ((MsgExts)paramFTSMessageSync.msgExts.clone());
        return localFTSMessageForDel;
      }
      localFTSMessageForDel.msgExts = null;
      return localFTSMessageForDel;
    }
    catch (Exception paramFTSMessageSync)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.fts.utils", 2, "decodecFTSMessage, ", paramFTSMessageSync);
      }
      localFTSMessageForDel.msgExts = null;
    }
    return localFTSMessageForDel;
  }
  
  public static FTSMessageSync a(FTSMessage paramFTSMessage)
  {
    if (paramFTSMessage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.utils", 2, "codecFTSMessage ftsMessage is null");
      }
      return null;
    }
    FTSMessageSync localFTSMessageSync = new FTSMessageSync();
    localFTSMessageSync.mOpt = paramFTSMessage.mOpt;
    localFTSMessageSync.mType = paramFTSMessage.mType;
    localFTSMessageSync.mContent = paramFTSMessage.mContent;
    localFTSMessageSync.mOId = paramFTSMessage.mOId;
    localFTSMessageSync.uin = paramFTSMessage.uin;
    localFTSMessageSync.istroop = paramFTSMessage.istroop;
    localFTSMessageSync.senderuin = paramFTSMessage.senderuin;
    localFTSMessageSync.msgtype = paramFTSMessage.msgtype;
    try
    {
      if (paramFTSMessage.msgExts != null)
      {
        localFTSMessageSync.msgExts = ((MsgExts)paramFTSMessage.msgExts.clone());
        return localFTSMessageSync;
      }
      localFTSMessageSync.msgExts = null;
      return localFTSMessageSync;
    }
    catch (Exception paramFTSMessage)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.fts.utils", 2, "codecFTSMessage, ", paramFTSMessage);
      }
      localFTSMessageSync.msgExts = null;
    }
    return localFTSMessageSync;
  }
  
  private static FTSMessage b(MessageRecord paramMessageRecord)
  {
    FTSMessage localFTSMessage = new FTSMessage();
    localFTSMessage.mType = 1;
    localFTSMessage.mContent = paramMessageRecord.getContentForSearch();
    localFTSMessage.mOId = paramMessageRecord.getId();
    localFTSMessage.uin = Long.parseLong(paramMessageRecord.frienduin);
    localFTSMessage.istroop = paramMessageRecord.istroop;
    localFTSMessage.senderuin = paramMessageRecord.senderuin;
    localFTSMessage.msgtype = paramMessageRecord.msgtype;
    return localFTSMessage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.v1.utils.FTSMessageCodec
 * JD-Core Version:    0.7.0.1
 */