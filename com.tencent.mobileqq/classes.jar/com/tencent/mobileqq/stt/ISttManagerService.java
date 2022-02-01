package com.tencent.mobileqq.stt;

import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={"all"})
public abstract interface ISttManagerService
  extends IRuntimeService
{
  public abstract boolean isTranslating(MessageForPtt paramMessageForPtt);
  
  public abstract boolean needAuotoChange(MessageForPtt paramMessageForPtt);
  
  public abstract void onSttResultPush(byte[] paramArrayOfByte);
  
  public abstract void setListener(ISttListener paramISttListener);
  
  public abstract Long translate(MessageForPtt paramMessageForPtt, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.stt.ISttManagerService
 * JD-Core Version:    0.7.0.1
 */