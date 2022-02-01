package com.tencent.mobileqq.service.message;

import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public abstract interface MessageCache$Callback
{
  public abstract int a(String paramString, MessageCache paramMessageCache);
  
  public abstract BaseMsgProxy a(int paramInt, MessageCache paramMessageCache);
  
  public abstract String a(byte[] paramArrayOfByte);
  
  public abstract StringBuilder a();
  
  public abstract List<MessageRecord> a(String paramString, int paramInt, MessageCache paramMessageCache);
  
  public abstract byte[] a(String paramString);
  
  public abstract String b(byte[] paramArrayOfByte);
  
  public abstract byte[] b(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageCache.Callback
 * JD-Core Version:    0.7.0.1
 */