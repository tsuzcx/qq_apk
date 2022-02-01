package com.tencent.mobileqq.qqexpand.chat;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AioLimitColdPalaceHelper$doOnShowFirst$1
  implements Runnable
{
  AioLimitColdPalaceHelper$doOnShowFirst$1(AioLimitColdPalaceHelper paramAioLimitColdPalaceHelper) {}
  
  public final void run()
  {
    this.this$0.q();
    if (this.this$0.a().ah != null)
    {
      Object localObject1 = this.this$0.a().ah;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      if (((SessionInfo)localObject1).b != null)
      {
        AioLimitColdPalaceHelper.a(this.this$0);
        localObject1 = this.this$0;
        Object localObject2 = ((AioLimitColdPalaceHelper)localObject1).a().ah;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        localObject2 = ((SessionInfo)localObject2).b;
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "mChatPie.sessionInfo!!.curFriendUin");
        SessionInfo localSessionInfo = this.this$0.a().ah;
        if (localSessionInfo == null) {
          Intrinsics.throwNpe();
        }
        AioLimitColdPalaceHelper.a((AioLimitColdPalaceHelper)localObject1, (String)localObject2, localSessionInfo.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.AioLimitColdPalaceHelper.doOnShowFirst.1
 * JD-Core Version:    0.7.0.1
 */