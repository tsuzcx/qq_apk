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
      if ((C2CShortcutBarStoreView.e(this.a) != null) && (paramBoolean2 != C2CShortcutBarStoreView.e(this.a).a()))
      {
        C2CShortcutBarStoreView.e(this.a).setOnCheckedChangeListener(null);
        C2CShortcutBarStoreView.e(this.a).setChecked(paramBoolean2);
        C2CShortcutBarStoreView.e(this.a).setOnCheckedChangeListener(this.a);
      }
    }
    else
    {
      paramString = QQToast.makeText(BaseApplication.getContext(), 1, 2131887632, 0);
      paramString.show(paramString.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.store.C2CShortcutBarStoreView.3
 * JD-Core Version:    0.7.0.1
 */