package com.tencent.weiyun.cmd;

import com.tencent.weiyun.WeiyunLiteGlobal.IResponseHandler;

class CommandManager$1$1
  implements WeiyunLiteGlobal.IResponseHandler
{
  CommandManager$1$1(CommandManager.1 param1, long paramLong, int paramInt) {}
  
  public void receiveResponse(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    this.this$1.recvResponse(paramInt, paramArrayOfByte, this.val$nativeReceiver, this.val$nativeCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weiyun.cmd.CommandManager.1.1
 * JD-Core Version:    0.7.0.1
 */