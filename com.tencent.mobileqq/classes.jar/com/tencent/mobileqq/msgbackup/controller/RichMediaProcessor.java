package com.tencent.mobileqq.msgbackup.controller;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.api.IMsgMixed;
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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class RichMediaProcessor
  implements IMsgBackupRichProcessor
{
  public RichMediaProcessor() {}
  
  public RichMediaProcessor(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this();
  }
  
  public static MsgProcessImport b(MsgBackupResEntity paramMsgBackupResEntity)
  {
    int i = paramMsgBackupResEntity.msgType;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return null;
        }
        return new MsgProcessPttImport(paramMsgBackupResEntity);
      }
      return new MsgProcessVideoImport(paramMsgBackupResEntity);
    }
    return new MsgProcessPicImport(paramMsgBackupResEntity);
  }
  
  public static MsgProcessRichMedia b(MessageRecord paramMessageRecord)
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
    if (((IMsgMixed)QRoute.api(IMsgMixed.class)).isMessageForMixedMsg(paramMessageRecord)) {
      return new MsgProcessMixed(paramMessageRecord);
    }
    if ((paramMessageRecord instanceof MessageForAniSticker)) {
      return new MsgProcessCommon(paramMessageRecord);
    }
    return null;
  }
  
  public ResDownloadObject a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    paramMessageRecord = b(paramMsgBackupResEntity);
    if (paramMessageRecord != null) {
      return paramMessageRecord.b();
    }
    return new ResDownloadObject();
  }
  
  public void a(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    paramMessageRecord = b(paramMessageRecord);
    if (paramMessageRecord != null)
    {
      paramMessageRecord.a();
      Object localObject = paramMessageRecord.b();
      if (QLog.isColorLevel()) {
        paramMessageRecord.b("onExport");
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
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("export resEntity:");
              localStringBuilder.append(((MsgBackupResEntity)localObject).toLogString());
              paramMessageRecord.b(localStringBuilder.toString());
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
      paramMessageRecord = b(paramMessageRecord);
      if (paramMessageRecord != null) {
        return paramMessageRecord.e();
      }
    }
    return false;
  }
  
  public boolean a(MsgBackupResEntity paramMsgBackupResEntity)
  {
    if ((paramMsgBackupResEntity.msgType != 1) && (paramMsgBackupResEntity.msgType != 2)) {
      return paramMsgBackupResEntity.msgType == 3;
    }
    return true;
  }
  
  public String b(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    return null;
  }
  
  public void b(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    MsgProcessRichMedia localMsgProcessRichMedia = b(paramMessageRecord);
    if (localMsgProcessRichMedia != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onImport,uniseq:");
        localStringBuilder.append(paramMessageRecord.uniseq);
        localStringBuilder.append(" msg:");
        localStringBuilder.append(paramMessageRecord);
        localMsgProcessRichMedia.b(localStringBuilder.toString());
      }
      localMsgProcessRichMedia.d();
      if (paramList != null)
      {
        paramMessageRecord = paramList.iterator();
        while (paramMessageRecord.hasNext())
        {
          paramList = b((MsgBackupResEntity)paramMessageRecord.next());
          if (paramList != null) {
            paramList.e();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.RichMediaProcessor
 * JD-Core Version:    0.7.0.1
 */