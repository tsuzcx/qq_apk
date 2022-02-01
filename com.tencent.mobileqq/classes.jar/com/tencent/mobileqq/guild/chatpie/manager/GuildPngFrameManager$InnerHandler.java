package com.tencent.mobileqq.guild.chatpie.manager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.magicface.drawable.IMessageHandler;

final class GuildPngFrameManager$InnerHandler
  extends Handler
{
  java.lang.ref.WeakReference<IMessageHandler> a;
  
  public GuildPngFrameManager$InnerHandler(IMessageHandler paramIMessageHandler)
  {
    super(Looper.getMainLooper());
    this.a = new mqq.util.WeakReference(paramIMessageHandler);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = (IMessageHandler)((java.lang.ref.WeakReference)localObject).get();
    if (localObject != null) {
      ((IMessageHandler)localObject).handleMsg(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.manager.GuildPngFrameManager.InnerHandler
 * JD-Core Version:    0.7.0.1
 */