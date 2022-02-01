package com.tencent.mobileqq.troop.shortcutbar.troopapp;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;

class AppShortcutBarPanel$1
  implements Runnable
{
  AppShortcutBarPanel$1(AppShortcutBarPanel paramAppShortcutBarPanel) {}
  
  public void run()
  {
    this.this$0.e();
    if ((AppShortcutBarPanel.a(this.this$0) != null) && (AppShortcutBarPanel.a(this.this$0) != null) && (AppShortcutBarPanel.b(this.this$0) != null) && (AppShortcutBarPanel.a(this.this$0) != null) && (AppShortcutBarPanel.a(this.this$0).jdField_a_of_type_Boolean) && (AppShortcutBarPanel.a(this.this$0).jdField_a_of_type_Int > 4) && (AppShortcutBarPanel.b(this.this$0).getChildCount() == 0))
    {
      View localView1 = AppShortcutBarPanel.a(this.this$0).findViewById((int)AppShortcutBarPanel.a(this.this$0).jdField_a_of_type_Long);
      View localView2 = AppShortcutBarPanel.a(this.this$0).findViewById((int)AppShortcutBarPanel.a(this.this$0).b);
      int i = localView1.getLeft();
      int j = localView2.getLeft();
      AppShortcutBarPanel.a(this.this$0).scrollBy(i - j, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarPanel.1
 * JD-Core Version:    0.7.0.1
 */