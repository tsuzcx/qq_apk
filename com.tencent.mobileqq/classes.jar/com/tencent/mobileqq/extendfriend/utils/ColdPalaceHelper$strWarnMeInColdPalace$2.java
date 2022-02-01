package com.tencent.mobileqq.extendfriend.utils;

import android.content.res.Resources;
import arom;
import com.tencent.mobileqq.app.QQAppInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.app.MobileQQ;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
public final class ColdPalaceHelper$strWarnMeInColdPalace$2
  extends Lambda
  implements Function0<String>
{
  public ColdPalaceHelper$strWarnMeInColdPalace$2(arom paramarom)
  {
    super(0);
  }
  
  public final String invoke()
  {
    MobileQQ localMobileQQ = this.this$0.a().getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localMobileQQ, "app.application");
    return localMobileQQ.getResources().getString(2131698158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ColdPalaceHelper.strWarnMeInColdPalace.2
 * JD-Core Version:    0.7.0.1
 */