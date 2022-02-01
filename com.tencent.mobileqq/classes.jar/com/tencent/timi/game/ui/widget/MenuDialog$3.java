package com.tencent.timi.game.ui.widget;

import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.timi.game.ui.utils.CommonAnimationUtil;
import com.tencent.timi.game.utils.ScreenUtils;

class MenuDialog$3
  implements Runnable
{
  MenuDialog$3(MenuDialog paramMenuDialog, float paramFloat1, float paramFloat2) {}
  
  public void run()
  {
    int i = MenuDialog.b(this.this$0).getMeasuredWidth();
    int j = MenuDialog.b(this.this$0).getMeasuredHeight();
    int k = ScreenUtils.a();
    int m = ScreenUtils.b();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)MenuDialog.b(this.this$0).getLayoutParams();
    float f1 = i;
    float f2 = this.a;
    float f3 = 32;
    if (f2 + f1 - f3 < k - 60)
    {
      localLayoutParams.addRule(9, 1);
      localLayoutParams.leftMargin = ((int)Math.max(this.a - f3, 0.0F));
      MenuDialog.b(this.this$0).setPivotX(0.0F);
    }
    else
    {
      localLayoutParams.addRule(11, 1);
      localLayoutParams.rightMargin = ((int)Math.max(k - this.a - f3, 0.0F));
      MenuDialog.b(this.this$0).setPivotX(f1);
    }
    f1 = j;
    f2 = this.b;
    f3 = 25;
    if (f2 + f1 - f3 < m - 100)
    {
      localLayoutParams.addRule(10, 1);
      localLayoutParams.topMargin = ((int)Math.max(this.b - f3, 0.0F));
      MenuDialog.b(this.this$0).setPivotY(0.0F);
    }
    else
    {
      localLayoutParams.addRule(12, 1);
      localLayoutParams.bottomMargin = ((int)Math.max(m - this.b - 45, 0.0F));
      MenuDialog.b(this.this$0).setPivotY(f1);
    }
    MenuDialog.b(this.this$0).setLayoutParams(localLayoutParams);
    MenuDialog.b(this.this$0).setVisibility(0);
    CommonAnimationUtil.a(MenuDialog.b(this.this$0), 0.0F, 1.0F, 120L, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.MenuDialog.3
 * JD-Core Version:    0.7.0.1
 */