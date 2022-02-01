package com.tencent.mobileqq.c2cshortcutbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class C2CAppShortcutBarHelper$3
  implements AdapterView.OnItemClickListener
{
  C2CAppShortcutBarHelper$3(C2CAppShortcutBarHelper paramC2CAppShortcutBarHelper) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = C2CShortcutBarManager.a((QQAppInterface)C2CAppShortcutBarHelper.h(this.a)).a(paramInt, C2CAppShortcutBarHelper.c(this.a).getCount());
    if (C2CAppShortcutBarHelper.i(this.a) == null) {
      C2CAppShortcutBarHelper.a(this.a, new C2CShortcutBarJumpController());
    }
    C2CAppShortcutBarHelper.i(this.a).a(C2CAppShortcutBarHelper.j(this.a), C2CAppShortcutBarHelper.k(this.a), (QQAppInterface)C2CAppShortcutBarHelper.l(this.a), C2CAppShortcutBarHelper.m(this.a), C2CAppShortcutBarHelper.c(this.a).a(paramInt), bool);
    AppRuntime localAppRuntime = C2CAppShortcutBarHelper.n(this.a);
    int i = C2CShortcutBarManager.a((QQAppInterface)C2CAppShortcutBarHelper.o(this.a)).a(String.valueOf(C2CAppShortcutBarHelper.a(this.a)));
    String str;
    if (bool) {
      str = "1";
    } else {
      str = C2CAppShortcutBarHelper.c(this.a).a(paramInt).a;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    ReportController.b(localAppRuntime, "dc00898", "", "", "0X800B32A", "0X800B32A", i, 0, str, localStringBuilder.toString(), "", "");
    if (C2CAppShortcutBarHelper.p(this.a).a() == 5) {
      C2CAppShortcutBarHelper.q(this.a).a("5");
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.C2CAppShortcutBarHelper.3
 * JD-Core Version:    0.7.0.1
 */