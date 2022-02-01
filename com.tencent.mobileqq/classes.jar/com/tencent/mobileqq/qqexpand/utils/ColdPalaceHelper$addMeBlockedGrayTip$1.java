package com.tencent.mobileqq.qqexpand.utils;

import android.content.res.Resources;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ColdPalaceHelper$addMeBlockedGrayTip$1
  implements Runnable
{
  ColdPalaceHelper$addMeBlockedGrayTip$1(ColdPalaceHelper paramColdPalaceHelper, String paramString, int paramInt) {}
  
  public final void run()
  {
    ILimitChatUtils localILimitChatUtils = (ILimitChatUtils)QRoute.api(ILimitChatUtils.class);
    BaseQQAppInterface localBaseQQAppInterface = (BaseQQAppInterface)this.this$0.i();
    String str = this.a;
    int i = this.b;
    MobileQQ localMobileQQ = this.this$0.i().getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localMobileQQ, "app.application");
    localILimitChatUtils.addGrayTipsMessage(localBaseQQAppInterface, str, i, "", localMobileQQ.getResources().getString(2131896737), 459803, "", -1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper.addMeBlockedGrayTip.1
 * JD-Core Version:    0.7.0.1
 */