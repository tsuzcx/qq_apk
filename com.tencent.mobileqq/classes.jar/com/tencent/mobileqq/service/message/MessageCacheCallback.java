package com.tencent.mobileqq.service.message;

import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import java.util.List;

public class MessageCacheCallback
  implements MessageCache.Callback
{
  public int a(String paramString, MessageCache paramMessageCache)
  {
    return ((QQAppInterface)paramMessageCache.a()).getTroopMask(paramString);
  }
  
  public BaseMsgProxy a(int paramInt, MessageCache paramMessageCache)
  {
    return ((QQAppInterface)paramMessageCache.a()).getMessageProxy(0);
  }
  
  public String a(byte[] paramArrayOfByte)
  {
    return HexUtil.bytes2HexStr(paramArrayOfByte);
  }
  
  public StringBuilder a()
  {
    return AIOUtils.a();
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, MessageCache paramMessageCache)
  {
    return ((QQAppInterface)paramMessageCache.a()).getMessageFacade().h(paramString, paramInt);
  }
  
  public byte[] a(String paramString)
  {
    return HexUtil.hexStr2Bytes(paramString);
  }
  
  public String b(byte[] paramArrayOfByte)
  {
    return PkgTools.toHexStr(paramArrayOfByte);
  }
  
  public byte[] b(String paramString)
  {
    return PkgTools.hexToBytes(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageCacheCallback
 * JD-Core Version:    0.7.0.1
 */