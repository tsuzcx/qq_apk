package com.tencent.mobileqq.extendfriend.limitchat;

import asqn;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class AioLimitColdPalaceHelper$doOnShowFirst$1
  implements Runnable
{
  public AioLimitColdPalaceHelper$doOnShowFirst$1(asqn paramasqn) {}
  
  public final void run()
  {
    this.this$0.g();
    if (this.this$0.a().sessionInfo != null)
    {
      Object localObject1 = this.this$0.a().sessionInfo;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      if (((SessionInfo)localObject1).curFriendUin != null)
      {
        asqn.a(this.this$0);
        localObject1 = this.this$0;
        Object localObject2 = this.this$0.a().sessionInfo;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        localObject2 = ((SessionInfo)localObject2).curFriendUin;
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "mChatPie.sessionInfo!!.curFriendUin");
        SessionInfo localSessionInfo = this.this$0.a().sessionInfo;
        if (localSessionInfo == null) {
          Intrinsics.throwNpe();
        }
        asqn.a((asqn)localObject1, (String)localObject2, localSessionInfo.curType);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.AioLimitColdPalaceHelper.doOnShowFirst.1
 * JD-Core Version:    0.7.0.1
 */