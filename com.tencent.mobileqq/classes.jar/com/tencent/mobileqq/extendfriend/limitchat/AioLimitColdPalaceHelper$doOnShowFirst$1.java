package com.tencent.mobileqq.extendfriend.limitchat;

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
    this.this$0.g();
    if (this.this$0.a().a != null)
    {
      Object localObject1 = this.this$0.a().a;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      if (((SessionInfo)localObject1).jdField_a_of_type_JavaLangString != null)
      {
        AioLimitColdPalaceHelper.a(this.this$0);
        localObject1 = this.this$0;
        Object localObject2 = this.this$0.a().a;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        localObject2 = ((SessionInfo)localObject2).jdField_a_of_type_JavaLangString;
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "mChatPie.sessionInfo!!.curFriendUin");
        SessionInfo localSessionInfo = this.this$0.a().a;
        if (localSessionInfo == null) {
          Intrinsics.throwNpe();
        }
        AioLimitColdPalaceHelper.a((AioLimitColdPalaceHelper)localObject1, (String)localObject2, localSessionInfo.jdField_a_of_type_Int);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.AioLimitColdPalaceHelper.doOnShowFirst.1
 * JD-Core Version:    0.7.0.1
 */