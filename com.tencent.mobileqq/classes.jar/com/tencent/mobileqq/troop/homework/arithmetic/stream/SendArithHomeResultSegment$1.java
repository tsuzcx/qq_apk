package com.tencent.mobileqq.troop.homework.arithmetic.stream;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.support.logging.SLog;

class SendArithHomeResultSegment$1
  implements CmdTaskManger.CommandCallback<SendArithHomeResultSegment.Request, BaseResponse>
{
  SendArithHomeResultSegment$1(SendArithHomeResultSegment paramSendArithHomeResultSegment) {}
  
  public void a(@NonNull SendArithHomeResultSegment.Request paramRequest, @Nullable BaseResponse paramBaseResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail())
    {
      SLog.e("QQ.Troop.homework.SendArithHomeResultSegment", "onCmdRespond failed :" + paramErrorMessage);
      SendArithHomeResultSegment.a(this.a, paramErrorMessage);
      return;
    }
    if (paramBaseResponse.a == 0)
    {
      paramRequest = new SendArithHomeResultSegment.RspInfo();
      paramRequest.a = SendArithHomeResultSegment.a(this.a);
      paramRequest.b = SendArithHomeResultSegment.a(this.a).b;
      SendArithHomeResultSegment.a(this.a, paramRequest);
      return;
    }
    SLog.e("QQ.Troop.homework.SendArithHomeResultSegment", "baseResponse failed :" + paramBaseResponse.b);
    SendArithHomeResultSegment.b(this.a, new ErrorMessage(paramBaseResponse.a, paramBaseResponse.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.stream.SendArithHomeResultSegment.1
 * JD-Core Version:    0.7.0.1
 */