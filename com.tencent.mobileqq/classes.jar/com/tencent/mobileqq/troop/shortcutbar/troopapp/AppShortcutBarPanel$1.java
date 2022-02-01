package com.tencent.mobileqq.troop.shortcutbar.troopapp;

import android.view.View;
import android.widget.LinearLayout;
import bglw;
import bgly;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;

public class AppShortcutBarPanel$1
  implements Runnable
{
  public AppShortcutBarPanel$1(bglw parambglw) {}
  
  public void run()
  {
    this.this$0.d();
    if ((bglw.a(this.this$0) != null) && (bglw.a(this.this$0) != null) && (bglw.a(this.this$0) != null) && (bglw.b(this.this$0) != null) && (bglw.a(this.this$0) != null) && (bglw.a(this.this$0).jdField_a_of_type_Boolean) && (bglw.a(this.this$0).jdField_a_of_type_Int > 4) && (bglw.b(this.this$0).getChildCount() == 0))
    {
      View localView1 = bglw.a(this.this$0).findViewById((int)bglw.a(this.this$0).jdField_a_of_type_Long);
      View localView2 = bglw.a(this.this$0).findViewById((int)bglw.a(this.this$0).b);
      int i = localView1.getLeft();
      int j = localView2.getLeft();
      bglw.a(this.this$0).scrollBy(i - j, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarPanel.1
 * JD-Core Version:    0.7.0.1
 */