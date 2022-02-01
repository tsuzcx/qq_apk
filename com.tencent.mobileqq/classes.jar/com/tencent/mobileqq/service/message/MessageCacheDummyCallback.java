package com.tencent.mobileqq.service.message;

import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public class MessageCacheDummyCallback
  implements MessageCache.Callback
{
  public int a(String paramString, MessageCache paramMessageCache)
  {
    return 0;
  }
  
  public BaseMsgProxy a(int paramInt, MessageCache paramMessageCache)
  {
    return null;
  }
  
  public String a(byte[] paramArrayOfByte)
  {
    return null;
  }
  
  public StringBuilder a()
  {
    return new StringBuilder();
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, MessageCache paramMessageCache)
  {
    return null;
  }
  
  public byte[] a(String paramString)
  {
    return new byte[0];
  }
  
  public String b(byte[] paramArrayOfByte)
  {
    return null;
  }
  
  public byte[] b(String paramString)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageCacheDummyCallback
 * JD-Core Version:    0.7.0.1
 */