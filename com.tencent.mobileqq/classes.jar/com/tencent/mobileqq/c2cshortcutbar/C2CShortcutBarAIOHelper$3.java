package com.tencent.mobileqq.c2cshortcutbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class C2CShortcutBarAIOHelper$3
  implements AdapterView.OnItemClickListener
{
  C2CShortcutBarAIOHelper$3(C2CShortcutBarAIOHelper paramC2CShortcutBarAIOHelper) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = C2CShortcutBarManager.a(C2CShortcutBarAIOHelper.f(this.a).a).a(paramInt, C2CShortcutBarAIOHelper.a(this.a).getCount());
    if (C2CShortcutBarAIOHelper.a(this.a) == null) {
      C2CShortcutBarAIOHelper.a(this.a, new C2CShortcutBarJumpController());
    }
    C2CShortcutBarAIOHelper.a(this.a).a(C2CShortcutBarAIOHelper.g(this.a), C2CShortcutBarAIOHelper.a(this.a).a(paramInt), bool);
    QQAppInterface localQQAppInterface = C2CShortcutBarAIOHelper.h(this.a).a;
    int i = C2CShortcutBarManager.a(C2CShortcutBarAIOHelper.i(this.a).a).a(String.valueOf(C2CShortcutBarAIOHelper.a(this.a)));
    if (bool) {}
    for (String str = "1";; str = C2CShortcutBarAIOHelper.a(this.a).a(paramInt).a)
    {
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800B32A", "0X800B32A", i, 0, str, paramInt + "", "", "");
      if ((C2CShortcutBarAIOHelper.j(this.a) instanceof LimitChatPie)) {
        ((LimitChatPie)C2CShortcutBarAIOHelper.k(this.a)).i("5");
      }
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarAIOHelper.3
 * JD-Core Version:    0.7.0.1
 */