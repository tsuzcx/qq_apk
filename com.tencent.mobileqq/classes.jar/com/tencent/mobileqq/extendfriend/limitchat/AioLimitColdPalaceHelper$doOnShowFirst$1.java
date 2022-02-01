package com.tencent.mobileqq.extendfriend.limitchat;

import ataa;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class AioLimitColdPalaceHelper$doOnShowFirst$1
  implements Runnable
{
  public AioLimitColdPalaceHelper$doOnShowFirst$1(ataa paramataa) {}
  
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
        ataa.a(this.this$0);
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
        ataa.a((ataa)localObject1, (String)localObject2, localSessionInfo.jdField_a_of_type_Int);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.AioLimitColdPalaceHelper.doOnShowFirst.1
 * JD-Core Version:    0.7.0.1
 */