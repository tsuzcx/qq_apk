package com.tencent.mobileqq.ptt.temp.api;

import android.content.Context;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQRecorderTempApi
  extends QRouteApi
{
  public abstract long AudioHelper_enlargeVolumWrapper(Context paramContext, byte[] paramArrayOfByte, int paramInt, float paramFloat);
  
  public abstract int getFilePlayTime(MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.temp.api.IQQRecorderTempApi
 * JD-Core Version:    0.7.0.1
 */