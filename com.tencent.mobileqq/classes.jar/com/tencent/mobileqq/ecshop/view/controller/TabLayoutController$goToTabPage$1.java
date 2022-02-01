package com.tencent.mobileqq.ecshop.view.controller;

import android.os.Bundle;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuc", "", "<anonymous parameter 1>", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onLaunchResult"}, k=3, mv={1, 1, 16})
final class TabLayoutController$goToTabPage$1
  implements MiniAppLaunchListener
{
  TabLayoutController$goToTabPage$1(TabLayoutController paramTabLayoutController) {}
  
  public final void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = TabLayoutController.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLaunchResult");
    localStringBuilder.append(paramBoolean);
    QLog.i(paramBundle, 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.TabLayoutController.goToTabPage.1
 * JD-Core Version:    0.7.0.1
 */