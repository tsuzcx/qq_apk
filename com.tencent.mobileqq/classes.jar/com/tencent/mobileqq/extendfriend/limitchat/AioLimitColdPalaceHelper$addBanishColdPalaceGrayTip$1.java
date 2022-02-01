package com.tencent.mobileqq.extendfriend.limitchat;

import android.content.res.Resources;
import asqn;
import aweo;
import bdla;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class AioLimitColdPalaceHelper$addBanishColdPalaceGrayTip$1
  implements Runnable
{
  public AioLimitColdPalaceHelper$addBanishColdPalaceGrayTip$1(asqn paramasqn) {}
  
  public final void run()
  {
    QQAppInterface localQQAppInterface;
    if ((this.this$0.a().sessionInfo != null) && (this.this$0.a() != null))
    {
      localQQAppInterface = this.this$0.a();
      localObject1 = this.this$0.a().sessionInfo;
      if (localObject1 == null) {
        break label178;
      }
    }
    label178:
    for (Object localObject1 = ((SessionInfo)localObject1).curFriendUin;; localObject1 = null)
    {
      int i = this.this$0.a().sessionInfo.curType;
      String str = this.this$0.a().sessionInfo.curFriendNick;
      Object localObject2 = this.this$0.a();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      localObject2 = ((BaseActivity)localObject2).getResources().getString(2131698414);
      BaseActivity localBaseActivity = this.this$0.a();
      if (localBaseActivity == null) {
        Intrinsics.throwNpe();
      }
      aweo.a(localQQAppInterface, (String)localObject1, i, str, (String)localObject2, 459802, localBaseActivity.getResources().getString(2131698415), 57, false, null, -1);
      bdla.b(null, "dc00898", "", "", "0X800B2C2", "0X800B2C2", 0, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.AioLimitColdPalaceHelper.addBanishColdPalaceGrayTip.1
 * JD-Core Version:    0.7.0.1
 */