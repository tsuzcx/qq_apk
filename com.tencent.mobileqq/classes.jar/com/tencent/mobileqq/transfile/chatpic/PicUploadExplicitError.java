package com.tencent.mobileqq.transfile.chatpic;

import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.GIFPreDownloadLimit;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class PicUploadExplicitError
{
  private static final int ERROR_OVER_BACK_LIMIT = 2;
  private static final int ERROR_OVER_CLIENT_LIMIT = 1;
  private static final int ERROR_OVER_COUNT = 3;
  private static final String SEND_PHOTO_DAY_KEY = "SEND_PHOTO_DAY_KEY";
  public static final String TAG = "PicUploadExplicitError";
  public static final String TAG_REASON = "PicUploadExplicitErrorReason";
  
  private static int getError(int paramInt, MessageRecord paramMessageRecord, String paramString)
  {
    if (paramInt != 9063)
    {
      if (paramInt == 90632) {
        return 1;
      }
      if ((paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 3000))
      {
        if (paramInt == -9527)
        {
          paramInt = getReasonServerErrCode(paramString);
          if (paramInt == 199) {
            return 2;
          }
          if ((paramInt == 206) || (paramInt == 207)) {
            return 3;
          }
        }
      }
      else if (paramInt == -9527)
      {
        paramInt = getReasonServerErrCode(paramString);
        if (paramInt == 197) {
          return 2;
        }
        if ((paramInt == 202) || (paramInt == 201)) {
          return 3;
        }
      }
      return -1;
    }
    return 1;
  }
  
  private static String getFailedTip(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 3) {
        return null;
      }
      return BaseApplication.getContext().getResources().getString(2131886565);
    }
    return BaseApplication.getContext().getResources().getString(2131886566);
  }
  
  public static String getFailedTip(MessageForPic paramMessageForPic)
  {
    try
    {
      String str = paramMessageForPic.getExtInfoFromExtStr("PicUploadExplicitError");
      if (!TextUtils.isEmpty(str))
      {
        int i = getError(Integer.parseInt(str), paramMessageForPic, paramMessageForPic.getExtInfoFromExtStr("PicUploadExplicitErrorReason"));
        if (i == 3)
        {
          str = paramMessageForPic.getExtInfoFromExtStr("SEND_PHOTO_DAY_KEY");
          if (!TextUtils.isEmpty(str))
          {
            long l1 = Long.parseLong(str);
            long l2 = SystemClock.uptimeMillis();
            if (GIFPreDownloadLimit.a(l1, l2))
            {
              if (QLog.isColorLevel())
              {
                paramMessageForPic = new StringBuilder();
                paramMessageForPic.append("getFailedTip,lastSendPicTime:");
                paramMessageForPic.append(l1);
                paramMessageForPic.append(" timeCurrent:");
                paramMessageForPic.append(l2);
                QLog.d("PicUploadExplicitError", 2, paramMessageForPic.toString());
              }
              return getFailedTip(i);
            }
            paramMessageForPic.removeExtInfoToExtStr("SEND_PHOTO_DAY_KEY");
            paramMessageForPic.updateMsgExtFiled();
            return null;
          }
        }
        else
        {
          paramMessageForPic = getFailedTip(i);
          return paramMessageForPic;
        }
      }
    }
    catch (Exception paramMessageForPic)
    {
      paramMessageForPic.printStackTrace();
    }
    return null;
  }
  
  private static int getReasonServerErrCode(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.split("_");
      if ((paramString != null) && (paramString.length == 2)) {
        try
        {
          int i = Integer.parseInt(paramString[1]);
          return i;
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
    return 0;
  }
  
  public static void uploadFailUpdateMsg(MessageRecord paramMessageRecord, int paramInt, String paramString1, String paramString2)
  {
    if ((paramMessageRecord instanceof MessageForPic))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("uploadFailUpdateMsg,errCode:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" errStr:");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" uinType:");
        localStringBuilder.append(paramMessageRecord.istroop);
        localStringBuilder.append(" msg:");
        localStringBuilder.append(paramMessageRecord);
        QLog.d("PicUploadExplicitError", 2, localStringBuilder.toString());
      }
      int i = getError(paramInt, paramMessageRecord, paramString2);
      if (i > 0)
      {
        if (i == 3)
        {
          paramMessageRecord.saveExtInfoToExtStr("PicUploadExplicitError", String.valueOf(paramInt));
          paramMessageRecord.saveExtInfoToExtStr("PicUploadExplicitErrorReason", paramString2);
          paramMessageRecord.saveExtInfoToExtStr("SEND_PHOTO_DAY_KEY", String.valueOf(SystemClock.uptimeMillis()));
        }
        else
        {
          paramMessageRecord.saveExtInfoToExtStr("PicUploadExplicitError", String.valueOf(paramInt));
          paramMessageRecord.saveExtInfoToExtStr("PicUploadExplicitErrorReason", paramString2);
        }
        ((MessageForPic)paramMessageRecord).updateMsgExtFiled();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.chatpic.PicUploadExplicitError
 * JD-Core Version:    0.7.0.1
 */