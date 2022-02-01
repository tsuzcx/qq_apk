package com.tencent.mobileqq.c2cshortcutbar.store;

import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class C2CShortcutBarStoreView$3
  extends C2CShortcutBarObserver
{
  C2CShortcutBarStoreView$3(C2CShortcutBarStoreView paramC2CShortcutBarStoreView) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if ((C2CShortcutBarStoreView.a(this.a) != null) && (paramBoolean2 != C2CShortcutBarStoreView.a(this.a).a()))
      {
        C2CShortcutBarStoreView.a(this.a).setOnCheckedChangeListener(null);
        C2CShortcutBarStoreView.a(this.a).setChecked(paramBoolean2);
        C2CShortcutBarStoreView.a(this.a).setOnCheckedChangeListener(this.a);
      }
      return;
    }
    paramString = QQToast.a(BaseApplication.getContext(), 1, 2131690784, 0);
    paramString.b(paramString.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.store.C2CShortcutBarStoreView.3
 * JD-Core Version:    0.7.0.1
 */