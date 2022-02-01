package com.tencent.mobileqq.extendfriend.utils;

import android.content.res.Resources;
import asss;
import aweo;
import com.tencent.mobileqq.app.QQAppInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class ColdPalaceHelper$addMeBlockedGrayTip$1
  implements Runnable
{
  public ColdPalaceHelper$addMeBlockedGrayTip$1(asss paramasss, String paramString, int paramInt) {}
  
  public final void run()
  {
    QQAppInterface localQQAppInterface = this.this$0.a();
    String str = this.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_Int;
    MobileQQ localMobileQQ = this.this$0.a().getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localMobileQQ, "app.application");
    aweo.a(localQQAppInterface, str, i, "", localMobileQQ.getResources().getString(2131698416), 459803, "", -1, false, null, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ColdPalaceHelper.addMeBlockedGrayTip.1
 * JD-Core Version:    0.7.0.1
 */