package com.tencent.mobileqq.ecshop.view.controller;

import android.os.Bundle;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuc", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onLaunchResult"}, k=3, mv={1, 1, 16})
final class TitleLayoutController$goToMenuPage$1
  implements MiniAppLaunchListener
{
  public static final 1 a = new 1();
  
  public final void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("onLaunchResult");
    paramBundle.append(paramBoolean);
    QLog.i("TitleLayoutController", 2, paramBundle.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.TitleLayoutController.goToMenuPage.1
 * JD-Core Version:    0.7.0.1
 */