package com.tencent.mobileqq.msgbackup.controller;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessCommon;
import com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessImport;
import com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessMixed;
import com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessPic;
import com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessPicImport;
import com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessPtt;
import com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessPttImport;
import com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessRichMedia;
import com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessVideo;
import com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessVideoImport;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class RichMediaProcessor
  implements IMsgBackupRichProcessor
{
  public RichMediaProcessor() {}
  
  public RichMediaProcessor(QQAppInterface paramQQAppInterface)
  {
    this();
  }
  
  public static MsgProcessImport a(MsgBackupResEntity paramMsgBackupResEntity)
  {
    switch (paramMsgBackupResEntity.msgType)
    {
    default: 
      return null;
    case 1: 
      return new MsgProcessPicImport(paramMsgBackupResEntity);
    case 2: 
      return new MsgProcessVideoImport(paramMsgBackupResEntity);
    }
    return new MsgProcessPttImport(paramMsgBackupResEntity);
  }
  
  public static MsgProcessRichMedia a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPic)) {
      return new MsgProcessPic((MessageForPic)paramMessageRecord);
    }
    if ((paramMessageRecord instanceof MessageForShortVideo)) {
      return new MsgProcessVideo((MessageForShortVideo)paramMessageRecord);
    }
    if ((paramMessageRecord instanceof MessageForPtt)) {
      return new MsgProcessPtt((MessageForPtt)paramMessageRecord);
    }
    if ((paramMessageRecord instanceof MessageForMarketFace)) {
      return new MsgProcessCommon(paramMessageRecord);
    }
    if ((paramMessageRecord instanceof MessageForMixedMsg)) {
      return new MsgProcessMixed((MessageForMixedMsg)paramMessageRecord);
    }
    return null;
  }
  
  public ResDownloadObject a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    paramMessageRecord = a(paramMsgBackupResEntity);
    if (paramMessageRecord != null) {
      return paramMessageRecord.a();
    }
    return new ResDownloadObject();
  }
  
  public String a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    return null;
  }
  
  public void a(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    paramMessageRecord = a(paramMessageRecord);
    if (paramMessageRecord != null)
    {
      paramMessageRecord.a();
      Object localObject = paramMessageRecord.a();
      if (QLog.isColorLevel()) {
        paramMessageRecord.a("onExport");
      }
      if (localObject != null)
      {
        paramList.addAll((Collection)localObject);
        if (QLog.isColorLevel())
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            localObject = (MsgBackupResEntity)paramList.next();
            if (QLog.isColorLevel()) {
              paramMessageRecord.a("export resEntity:" + ((MsgBackupResEntity)localObject).toLogString());
            }
          }
        }
      }
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      paramMessageRecord = a(paramMessageRecord);
      if (paramMessageRecord != null) {
        return paramMessageRecord.a();
      }
    }
    return false;
  }
  
  public boolean a(MsgBackupResEntity paramMsgBackupResEntity)
  {
    return (paramMsgBackupResEntity.msgType == 1) || (paramMsgBackupResEntity.msgType == 2) || (paramMsgBackupResEntity.msgType == 3);
  }
  
  public void b(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    MsgProcessRichMedia localMsgProcessRichMedia = a(paramMessageRecord);
    if (localMsgProcessRichMedia != null)
    {
      if (QLog.isColorLevel()) {
        localMsgProcessRichMedia.a("onImport,uniseq:" + paramMessageRecord.uniseq + " msg:" + paramMessageRecord);
      }
      localMsgProcessRichMedia.b();
      if (paramList != null)
      {
        paramMessageRecord = paramList.iterator();
        while (paramMessageRecord.hasNext())
        {
          paramList = a((MsgBackupResEntity)paramMessageRecord.next());
          if (paramList != null) {
            paramList.a();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.RichMediaProcessor
 * JD-Core Version:    0.7.0.1
 */