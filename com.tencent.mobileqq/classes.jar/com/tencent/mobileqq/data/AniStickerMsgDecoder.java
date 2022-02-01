package com.tencent.mobileqq.data;

import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.decoder.IMessageDecoder;
import com.tencent.mobileqq.app.message.IMessageManager;
import mqq.app.AppRuntime;

public class AniStickerMsgDecoder
  implements IMessageDecoder
{
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    int i = paramMessage.msgtype;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.AniStickerMsgDecoder
 * JD-Core Version:    0.7.0.1
 */