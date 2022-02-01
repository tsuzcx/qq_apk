package com.tencent.mobileqq.data.utils;

import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IMessageForPttUtilsApi
  extends QRouteApi
{
  public abstract byte[] c2cConstructPTTExtraInfo(MessageForPtt paramMessageForPtt);
  
  public abstract byte[] c2cConstructPttReserveInfo(MessageForPtt paramMessageForPtt);
  
  public abstract byte[] changeWaveformToPb(int[] paramArrayOfInt);
  
  public abstract byte[] groupConstructPTTExtraInfo(MessageForPtt paramMessageForPtt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.utils.IMessageForPttUtilsApi
 * JD-Core Version:    0.7.0.1
 */