package com.tencent.mobileqq.location;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForLocationShare;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.location.qq_lbs_share.C2CRelationInfo;

public class LocationMessageUtil
{
  public static List<MessageRecord> a(AppInterface paramAppInterface, int paramInt, String paramString)
  {
    return a(((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getMessagesFromDB(paramString, paramInt, 9223372036854775807L, 3, 9223372036854775807L, new int[] { -2076 }, 2147483647));
  }
  
  private static List<MessageRecord> a(List<Entity> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Entity localEntity = (Entity)paramList.next();
      if ((localEntity instanceof MessageRecord)) {
        localArrayList.add((MessageRecord)localEntity);
      }
    }
    return localArrayList;
  }
  
  public static List<MessageRecord> a(AppRuntime paramAppRuntime, int paramInt, String paramString)
  {
    return a(((IMessageFacade)paramAppRuntime.getRuntimeService(IMessageFacade.class, "")).getAllMessages(paramString, paramInt, new int[] { -2076 }, 5));
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt, String paramString, boolean paramBoolean)
  {
    paramString = a(paramAppInterface, paramInt, paramString);
    if (paramString != null)
    {
      paramInt = 0;
      if (paramInt < paramString.size())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramString.get(paramInt);
        if ((localMessageRecord instanceof MessageForLocationShare))
        {
          if (paramInt != paramString.size() - 1) {
            break label69;
          }
          a(paramAppInterface, localMessageRecord, paramBoolean);
        }
        for (;;)
        {
          paramInt += 1;
          break;
          label69:
          a(paramAppInterface, localMessageRecord, false);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationMessageUtil", 2, new Object[] { "updateAllLbsMsgState: invoked. ", " lbsMsgs: ", paramString, " lbsMsgs.size(): ", Integer.valueOf(paramString.size()) });
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationMessageUtil", 2, new Object[] { "onDecodeC2cLbsCloseRoomMessage: invoked. ", " friendUin: ", paramString });
    }
    a(paramAppInterface, 0, paramString, false);
  }
  
  public static void a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    MessageForLocationShare localMessageForLocationShare;
    if ((paramMessageRecord instanceof MessageForLocationShare))
    {
      localMessageForLocationShare = (MessageForLocationShare)paramMessageRecord;
      if (localMessageForLocationShare.isSharingLocation == paramBoolean) {
        break label88;
      }
      localMessageForLocationShare.isSharingLocation = paramBoolean;
      ((IMessageFacade)paramAppRuntime.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, localMessageForLocationShare.convertToMsgData());
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationMessageUtil", 2, new Object[] { "updateMsgSharingState: invoked. updateMsgContentByUniseq to false ", " locationShare: ", localMessageForLocationShare });
      }
      return;
      label88:
      if (QLog.isColorLevel()) {
        QLog.d("LocationMessageUtil", 2, "updateMsgSharingState: invoked. state ok, no need update. ");
      }
    }
  }
  
  public static boolean a(PBBytesField paramPBBytesField)
  {
    boolean bool = true;
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    paramPBBytesField = paramPBBytesField.get().toByteArray();
    qq_lbs_share.C2CRelationInfo localC2CRelationInfo = new qq_lbs_share.C2CRelationInfo();
    try
    {
      localC2CRelationInfo.mergeFrom(paramPBBytesField);
      long l1 = localC2CRelationInfo.id1.get();
      long l2 = localC2CRelationInfo.id2.get();
      if (QLog.isColorLevel()) {
        QLog.d("LocationMessageUtil", 2, new Object[] { "isC2cSharingLocation: invoked. C2C profile flag [uin不为0即可说明正在分享]", " id1: ", Long.valueOf(l1), " id2: ", Long.valueOf(l2) });
      }
      if (localAppRuntime.getLongAccountUin() == l1)
      {
        if (l2 <= 0L) {
          break label158;
        }
        return true;
      }
      long l3 = localAppRuntime.getLongAccountUin();
      if (l3 == l2)
      {
        if (l1 <= 0L) {
          return false;
        }
      }
      else {
        return false;
      }
    }
    catch (Exception paramPBBytesField)
    {
      QLog.e("LocationMessageUtil", 1, "isC2cSharingLocation: failed. ", paramPBBytesField);
      bool = false;
    }
    return bool;
    label158:
    return false;
  }
  
  public static void b(AppInterface paramAppInterface, String paramString)
  {
    a(paramAppInterface, 1, paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.LocationMessageUtil
 * JD-Core Version:    0.7.0.1
 */