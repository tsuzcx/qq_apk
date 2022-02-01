package com.tencent.mobileqq.friend.servlet;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.friend.servlet.coder.BaseJCECoder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.NewIntent;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class FriendService$sendRequest$requestTask$1
  implements Runnable
{
  FriendService$sendRequest$requestTask$1(FriendService paramFriendService, ToServiceMsg paramToServiceMsg) {}
  
  public final void run()
  {
    Object localObject1 = this.a.getServiceCmd();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sendToService: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("IMCore.friend.FriendServlet", 2, ((StringBuilder)localObject2).toString());
    }
    int j = 0;
    Object localObject2 = this.this$0;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "cmd");
    localObject2 = FriendService.a((FriendService)localObject2, (String)localObject1);
    int i = j;
    if (localObject2 != null)
    {
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setEncodeName("utf-8");
      FriendService localFriendService = this.this$0;
      i = FriendService.a(localFriendService);
      FriendService.a(localFriendService, i + 1);
      localUniPacket.setRequestId(i);
      i = j;
      if (((BaseJCECoder)localObject2).a(this.a, localUniPacket))
      {
        this.a.putWupBuffer(localUniPacket.encode());
        i = 1;
      }
    }
    if (i != 0)
    {
      this.a.extraData.putLong("KEY_REQUEST_TIME", System.currentTimeMillis());
      localObject1 = new NewIntent((Context)FriendService.b(this.this$0).getApplication(), FriendServlet.class);
      ((NewIntent)localObject1).putExtra(ToServiceMsg.class.getSimpleName(), (Parcelable)this.a);
      FriendService.b(this.this$0).startServlet((NewIntent)localObject1);
      return;
    }
    localObject1 = new FromServiceMsg(this.a.getUin(), (String)localObject1);
    FriendService.a(this.this$0, this.a, (FromServiceMsg)localObject1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friend.servlet.FriendService.sendRequest.requestTask.1
 * JD-Core Version:    0.7.0.1
 */