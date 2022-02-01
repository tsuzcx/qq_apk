package com.tencent.mobileqq.gamecenter.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.qphone.base.util.QLog;

final class GameMsgUtil$2
  implements Runnable
{
  GameMsgUtil$2(AppInterface paramAppInterface, int paramInt, Message paramMessage) {}
  
  public void run()
  {
    try
    {
      if (-1 == GameMsgUtil.b()) {
        GameMsgUtil.b(GameMsgUtil.b(this.a));
      }
      if (-1 == GameMsgUtil.b())
      {
        GameMsgUtil.b(this.a, this.b);
        return;
      }
      if (((GameMsgUtil.b() == 0) && (this.b > 0)) || ((GameMsgUtil.b() > 0) && (this.b == 0)))
      {
        String str = GameMsgUtil.a;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[reportGameMsgBoxExplosure883], lastUnread:");
        ((StringBuilder)localObject).append(GameMsgUtil.b());
        ((StringBuilder)localObject).append(",curCount:");
        ((StringBuilder)localObject).append(this.b);
        QLog.i(str, 1, ((StringBuilder)localObject).toString());
        str = "0";
        if (this.b == 0) {
          str = "1";
        }
        localObject = new TinyInfo();
        ((TinyInfo)localObject).parseFromMessageRecord(this.c);
        GameMsgUtil.a(String.valueOf(((TinyInfo)localObject).gameAppId), "1", "145", "920", "92003", "209055", "", "", "8", str);
        GameMsgUtil.b(this.a, this.b);
      }
      GameMsgUtil.b(this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i(GameMsgUtil.a, 1, localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.utils.GameMsgUtil.2
 * JD-Core Version:    0.7.0.1
 */