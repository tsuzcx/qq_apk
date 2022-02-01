package com.tencent.mobileqq.ptt.temp.api.impl;

import android.content.Context;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.temp.api.IQQRecorderTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class QQRecorderTempApiImpl
  implements IQQRecorderTempApi
{
  public static final String TAG = "QQRecorderTempImpl";
  
  public long AudioHelper_enlargeVolumWrapper(Context paramContext, byte[] paramArrayOfByte, int paramInt, float paramFloat)
  {
    return AudioHelper.a(paramContext, paramArrayOfByte, paramInt, paramFloat);
  }
  
  public int getFilePlayTime(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPtt))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("voiceLength getFilePlayTime ");
        localStringBuilder.append(((MessageForPtt)paramMessageRecord).voiceLength);
        QLog.d("QQRecorderTempImpl", 2, localStringBuilder.toString());
      }
      paramMessageRecord = (MessageForPtt)paramMessageRecord;
      if (paramMessageRecord.voiceLength > 1) {
        return paramMessageRecord.voiceLength;
      }
      paramMessageRecord = paramMessageRecord.getLocalFilePath();
    }
    else if ((paramMessageRecord instanceof Message))
    {
      paramMessageRecord = ((Message)paramMessageRecord).pttUrl;
    }
    else
    {
      paramMessageRecord = null;
    }
    if (paramMessageRecord != null) {
      return ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).getFilePlayTime(paramMessageRecord);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.temp.api.impl.QQRecorderTempApiImpl
 * JD-Core Version:    0.7.0.1
 */