package com.tencent.mobileqq.c2cshortcutbar.store;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutAppInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class C2CShortcutBarStoreView$C2CShortcutBarStoreAdapter$1
  implements View.OnClickListener
{
  C2CShortcutBarStoreView$C2CShortcutBarStoreAdapter$1(C2CShortcutBarStoreView.C2CShortcutBarStoreAdapter paramC2CShortcutBarStoreAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (C2CShortcutBarStoreView.c(this.b.a) != null) {
      C2CShortcutBarStoreView.c(this.b.a).a(this.a, (C2CShortcutAppInfo)C2CShortcutBarStoreView.f(this.b.a).get(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.store.C2CShortcutBarStoreView.C2CShortcutBarStoreAdapter.1
 * JD-Core Version:    0.7.0.1
 */