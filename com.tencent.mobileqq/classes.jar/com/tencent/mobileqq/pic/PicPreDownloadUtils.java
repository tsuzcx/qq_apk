package com.tencent.mobileqq.pic;

import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.api.IMsgMixed;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pic.api.IDep;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.api.IMsgStructing;
import com.tencent.mobileqq.transfile.TransferRequest;
import mqq.manager.ServerConfigManager.ConfigType;

public class PicPreDownloadUtils
  extends BasePicPreDownloadUtils
{
  static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 * 8 + paramInt2 * 2 + paramInt3;
  }
  
  public static int a(AppInterface paramAppInterface, int paramInt, String paramString)
  {
    int i;
    if (paramInt == 1) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((i != 0) && (paramAppInterface != null) && (((IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "")).getTroopMask(paramString) == 2)) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if (paramInt == 3000) {
      k = 1;
    } else {
      k = 0;
    }
    int m;
    if (paramInt == 0) {
      m = 1;
    } else {
      m = 0;
    }
    if (paramInt == 10014) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (j != 0) {}
    do
    {
      return 1;
      if (i != 0) {
        return 0;
      }
      if (k != 0) {
        return 2;
      }
      if (m != 0) {
        return 3;
      }
    } while (paramInt == 0);
    return 4;
  }
  
  public static long a(AppInterface paramAppInterface, String paramString, long paramLong)
  {
    if (paramString == null) {
      return paramLong;
    }
    try
    {
      paramAppInterface = ((IDep)QRoute.api(IDep.class)).getServerConfigValue(paramAppInterface, ServerConfigManager.ConfigType.common, paramString);
      if (paramAppInterface != null)
      {
        paramAppInterface = Long.valueOf(paramAppInterface);
        l = paramAppInterface.longValue();
      }
    }
    catch (Exception paramAppInterface)
    {
      long l;
      label56:
      label59:
      break label56;
    }
    try
    {
      a(paramString, paramAppInterface.longValue());
    }
    catch (Exception paramAppInterface)
    {
      break label59;
    }
    a(paramString, paramLong);
    l = paramLong;
    paramAppInterface = new StringBuilder();
    paramAppInterface.append("key:");
    paramAppInterface.append(paramString);
    paramAppInterface.append(",value:");
    paramAppInterface.append(l);
    paramAppInterface.append(",defValue:");
    paramAppInterface.append(paramLong);
    Logger.a("PIC_TAG_PRELOAD", "getLongConfig", paramAppInterface.toString());
    return l;
  }
  
  public static void a(AppInterface paramAppInterface, MessageForPic paramMessageForPic)
  {
    if (paramAppInterface != null)
    {
      if (paramMessageForPic == null) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uniseq:");
      ((StringBuilder)localObject).append(paramMessageForPic.uniseq);
      ((StringBuilder)localObject).append(",network:");
      ((StringBuilder)localObject).append(paramMessageForPic.preDownNetworkType);
      ((StringBuilder)localObject).append("state:");
      ((StringBuilder)localObject).append(paramMessageForPic.preDownState);
      Logger.a("PIC_TAG_PRELOAD", "updateMsg", ((StringBuilder)localObject).toString());
      paramMessageForPic.serial();
      localObject = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
      if (paramMessageForPic.subMsgId == MessageForPic.defaultSuMsgId)
      {
        if (((IMsgStructing)QRoute.api(IMsgStructing.class)).isMessageForStructing((MessageRecord)localObject))
        {
          ((IMsgStructing)QRoute.api(IMsgStructing.class)).updateMsgAfterDownload(paramAppInterface, (MessageRecord)localObject, paramMessageForPic);
          return;
        }
        ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq, paramMessageForPic.msgData);
        return;
      }
      if (((IMsgMixed)QRoute.api(IMsgMixed.class)).isMessageForMixedMsg((MessageRecord)localObject)) {
        ((IMsgMixed)QRoute.api(IMsgMixed.class)).updateMsgAfterDownload(paramAppInterface, (MessageRecord)localObject, paramMessageForPic);
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, TransferRequest paramTransferRequest)
  {
    if (paramTransferRequest == null) {
      return;
    }
    if ((paramTransferRequest.mRec instanceof MessageForPic))
    {
      if (paramTransferRequest.mFileType == 65537) {
        return;
      }
      MessageForPic localMessageForPic = (MessageForPic)paramTransferRequest.mRec;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Before update, networkType:");
      localStringBuilder.append(localMessageForPic.preDownNetworkType);
      localStringBuilder.append(",state:");
      localStringBuilder.append(localMessageForPic.preDownState);
      localStringBuilder.append(",uniseq:");
      localStringBuilder.append(localMessageForPic.uniseq);
      Logger.a("PIC_TAG_PRELOAD", "updateDownState", localStringBuilder.toString());
      if (paramTransferRequest.mDownMode == 1) {
        localMessageForPic.preDownState = 1;
      } else if (paramTransferRequest.mDownMode == 3) {
        localMessageForPic.preDownState = 4;
      } else if ((localMessageForPic.preDownState != 1) && (localMessageForPic.preDownState != 4)) {
        localMessageForPic.preDownState = 0;
      }
      paramTransferRequest = new StringBuilder();
      paramTransferRequest.append("After update, networkType:");
      paramTransferRequest.append(localMessageForPic.preDownNetworkType);
      paramTransferRequest.append(",state:");
      paramTransferRequest.append(localMessageForPic.preDownState);
      paramTransferRequest.append(",uniseq:");
      paramTransferRequest.append(localMessageForPic.uniseq);
      Logger.a("PIC_TAG_PRELOAD", "updateDownState", paramTransferRequest.toString());
      a(paramAppInterface, localMessageForPic);
    }
  }
  
  public static void b(AppInterface paramAppInterface, MessageForPic paramMessageForPic)
  {
    if (paramAppInterface != null)
    {
      if (paramMessageForPic == null) {
        return;
      }
      if (paramMessageForPic.preDownState == 0)
      {
        paramMessageForPic.preDownState = 1;
        paramMessageForPic.preDownNetworkType = a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("networkType:");
        localStringBuilder.append(paramMessageForPic.preDownNetworkType);
        localStringBuilder.append(",state:");
        localStringBuilder.append(paramMessageForPic.preDownState);
        localStringBuilder.append(",uniseq:");
        localStringBuilder.append(paramMessageForPic.uniseq);
        Logger.a("PIC_TAG_PRELOAD", "updateDownState4SD", localStringBuilder.toString());
        a(paramAppInterface, paramMessageForPic);
      }
    }
  }
  
  public static long[] b()
  {
    Object localObject = a.getString("PeakFlowTimePeriod", "");
    if ((localObject != null) && (localObject != ""))
    {
      localObject = ((String)localObject).split(";");
      if (localObject == null) {
        return new long[0];
      }
      long[] arrayOfLong = new long[localObject.length * 2];
      int k = localObject.length;
      int i = 0;
      int j = 0;
      while (i < k)
      {
        String[] arrayOfString = localObject[i].split("-");
        if ((arrayOfString != null) && (arrayOfString.length == 2))
        {
          arrayOfLong[j] = Long.valueOf(arrayOfString[0]).longValue();
          arrayOfLong[(j + 1)] = Long.valueOf(arrayOfString[1]).longValue();
          j += 2;
          i += 1;
        }
        else
        {
          return new long[0];
        }
      }
      return arrayOfLong;
    }
    return new long[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloadUtils
 * JD-Core Version:    0.7.0.1
 */