package com.tencent.mobileqq.ecshop.view.controller;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qwallet.utils.FlymeOSStatusBarFontUtils;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TitleLayoutController$updateTitlelayout$1
  implements Runnable
{
  TitleLayoutController$updateTitlelayout$1(TitleLayoutController paramTitleLayoutController, HippyMap paramHippyMap) {}
  
  public final void run()
  {
    try
    {
      String str = this.a.getString("navTintColor");
      if (!TextUtils.isEmpty((CharSequence)str))
      {
        int i = Color.parseColor(str);
        this.this$0.a(i);
        this.this$0.b(i);
        this.this$0.c(i);
      }
      str = this.a.getString("navBgColor");
      if (!TextUtils.isEmpty((CharSequence)str)) {
        this.this$0.b().setBackgroundColor(Color.parseColor(str));
      }
      if (this.a.getInt("isStatusDark") == 1)
      {
        FlymeOSStatusBarFontUtils.a(this.this$0.c(), true);
        return;
      }
      FlymeOSStatusBarFontUtils.a(this.this$0.c(), false);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TitleLayoutController", 1, (Throwable)localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.TitleLayoutController.updateTitlelayout.1
 * JD-Core Version:    0.7.0.1
 */